'use strict';

import logger from "../utils/logger.js";
import collectionStore from "../models/collection-store.js";
import { v4 as uuidv4 } from 'uuid';
import accounts from './accounts.js';

const database = {
    createView(request, response) {
    logger.info('Database rendering...');
    const loggedInUser = accounts.getCurrentUser(request);
    if (loggedInUser) {
    const viewData = {
      title: 'Rare console database',
      collections: collectionStore.getUserCollection(loggedInUser.id),
      fullname: loggedInUser.firstName + ' ' + loggedInUser.lastName,
      picture: loggedInUser.picture,
    };
    logger.info('about to render' + viewData.collections);
    response.render('database', viewData);
    }
    else response.redirect('/');
  },

  addCollection(request, response) {
    const loggedInUser = accounts.getCurrentUser(request);
    logger.debug(loggedInUser.id);
    
    const newCollection = {
      id: uuidv4(),
      userid: loggedInUser.id,
      title: request.body.title,
      consoles: [],
      picture: request.files.picture,
    };
    
    collectionStore.addCollection(newCollection, function() {
    response.redirect('/database');
    });
  },
  
  deleteCollection(request, response) {
    const collectionId = request.params.id;
    logger.debug(`Deleting Collection ${collectionId}`);
    collectionStore.removeCollection(collectionId);
    response.redirect("/database");
},
  
};

export default database;