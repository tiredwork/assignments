"use strict";

import logger from "../utils/logger.js";
import collectionStore from "../models/collection-store.js";
import { v4 as uuidv4 } from "uuid";
import accounts from './accounts.js';

const collection = {
  createView(request, response) {
    const collectionId = request.params.id;
    const loggedInUser = accounts.getCurrentUser(request);
    logger.debug("Collection id = " + collectionId);

    const viewData = {
      title: "Collection",
      singleCollection: collectionStore.getCollection(collectionId),
      fullname: loggedInUser.firstName + ' ' + loggedInUser.lastName,
      picture: loggedInUser.picture,
    };

    response.render("collection", viewData);
  },

addConsole(request, response) {
  console.log("Request Body:", request.body);
  const collectionId = request.params.id;
  const collection = collectionStore.getCollection(collectionId);

  const newConsole = {
    id: uuidv4(),
    name: request.body.name,
    type: request.body.type,
    color: request.body.color,
    release_date: request.body.release_date,
    is_bundle: request.body.is_bundle === "true",
    details: request.body.details,
    picture: request.files.picture,
  };

  collectionStore.addConsole(collectionId, newConsole, function() {
    response.redirect("/collection/" + collectionId);
  });
},

  deleteConsole(request, response) {
    const collectionId = request.params.id;
    const consoleId = request.params.consoleid;
    logger.debug(`Deleting Console  ${consoleId} from Collection ${collectionId}`);
    collectionStore.removeConsole(collectionId, consoleId);
    response.redirect("/collection/" + collectionId);
  },

  updateConsole(request, response) {
  const collectionId = request.params.id; 
  const consoleId = parseInt(request.params.consoleid); // Parse ID as integer
  logger.debug("updating console " + consoleId);
  const updatedConsole = {
    id: consoleId,
    name: request.body.name,
    type: request.body.type,
    color: request.body.color,
    release_date: request.body.release_date,
    is_bundle: request.body.is_bundle === "true",
    details: request.body.details,
    picture: request.files.picture,
  };
  collectionStore.editConsole(collectionId, consoleId, updatedConsole);
  response.redirect("/collection/" + collectionId);
},

};

export default collection;
