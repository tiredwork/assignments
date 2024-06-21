"use strict";

import logger from "../utils/logger.js";
import JsonStore from "./json-store.js";
import cloudinary from "cloudinary";

import { createRequire } from "module";
const require = createRequire(import.meta.url);

try {
  const env = require("../.data/.env.json");
  cloudinary.config(env.cloudinary);
} catch (e) {
  logger.info("You must provide a Cloudinary credentials file - see README.md");
  process.exit(1);
}

const collectionStore = {
  store: new JsonStore("./models/collection-store.json", {
    consoleCollection: [],
  }),
  collection: "consoleCollection",
  array: "consoles",

  getAllCollections() {
    return this.store.findAll(this.collection);
  },

  getCollection(id) {
    return this.store.findOneBy(
      this.collection,
      (collection) => collection.id === id
    );
  },

  //addConsole(id, console) {
  //  this.store.addItem(this.collection, id, this.array, console);
  //},
  
async addConsole(collectionId, consoleData, response) {
  function uploader() {
    return new Promise(function(resolve, reject) {
      cloudinary.uploader.upload(consoleData.picture.tempFilePath, function(result, err) {
        if (err) { console.log(err); }
        resolve(result);
      });
    });
  }

  let result = await uploader();
  logger.info("cloudinary result", result);
  consoleData.picture = result.url;

  this.store.addItem(this.collection, collectionId, this.array, consoleData);
  response();
},

  async addCollection(collection, response) {
    function uploader() {
      return new Promise(function(resolve, reject) {
        cloudinary.uploader.upload(collection.picture.tempFilePath,function(result, err) {
            if (err) {console.log(err);}
            resolve(result);
          });
        });
      }
    let result = await uploader();
    logger.info("cloudinary result", result);
    collection.picture = result.url;

    this.store.addCollection(this.collection, collection);
    response();
  },

  removeConsole(id, consoleId) {
    this.store.removeItem(this.collection, id, this.array, consoleId);
  },

  removeCollection(id) {
    const collection = this.getCollection(id);
    this.store.removeCollection(this.collection, collection);
  },

  editConsole(id, consoleId, updatedConsole) {
    this.store.editItem(
      this.collection,
      id,
      consoleId,
      this.array,
      updatedConsole
    );
  },

  getUserCollection(userid) {
    return this.store.findBy(
      this.collection,
      (collection) => collection.userid === userid
    );
  },
};

export default collectionStore;
