"use strict";

import logger from "../utils/logger.js";
import collectionStore from "../models/collection-store.js";
import accounts from "./accounts.js";

const about = {
  createView(request, response) {
    const loggedInUser = accounts.getCurrentUser(request);
    logger.info("About page loading");

    // app statistics calculations
    const collections = collectionStore.getAllCollections();
    let numCollections = collections.length;
    let numConsoles = 0;
    for (let item of collections) {
      numConsoles += item.consoles.length;
    }

    //Largest collection by elements

    let max = 0;
    for (let i = 0; i < collections.length; i++) {
      if (collections[i].consoles.length > max) {
        max = collections[i].consoles.length;
      }
    }

    for (let collection of collections) {
      if (collection.consoles.length === max) {
        max = collection.title;
      }
    }

    //Smallest collection by elements
    let min = Infinity;
    for (let i = 0; i < collections.length; i++) {
      if (collections[i].consoles.length < min) {
        min = collections[i].consoles.length;
      }
    }

    for (let collection of collections) {
      if (collection.consoles.length === min) {
        min = collection.title;
      }
    }
    if (loggedInUser) {
      const viewData = {
        title: "About the Rare Console Database website",
        fullname: loggedInUser.firstName + " " + loggedInUser.lastName,
        picture: loggedInUser.picture,
        displayNumCollections: numCollections,
        displayNumConsoles: numConsoles,
        displayLargestCollection: max,
        displaySmallestCollection: min,
      };
      response.render("about", viewData);
    } else response.redirect("/");
  },
};

export default about;
