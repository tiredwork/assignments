'use strict';

import logger from "../utils/logger.js";
import appStore from "../models/app-store.js";
import accounts from './accounts.js';

const start = {
  createView(request, response) {
    const loggedInUser = accounts.getCurrentUser(request);
    logger.info("Start page loading!");
    
    if (loggedInUser) {
    const viewData = {
      title: "Welcome to the Rare Console Database!",
      info: appStore.getAppInfo(),
      fullname: loggedInUser.firstName + ' ' + loggedInUser.lastName,
      picture: loggedInUser.picture,

    };
    
    //logger.debug(viewData);
    response.render('start', viewData);   
  }
    else response.redirect('/');
  },
};

export default start;