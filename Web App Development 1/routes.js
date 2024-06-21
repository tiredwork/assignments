'use strict';

import express from 'express';
import logger from "./utils/logger.js";
const router = express.Router();

import start from './controllers/start.js';
import database from './controllers/database.js';
import about from './controllers/about.js';
import collection from './controllers/collection.js';
import accounts from './controllers/accounts.js';

router.get('/start', start.createView);
router.get('/database', database.createView);
router.get('/about', about.createView);
router.get('/collection/:id', collection.createView);
router.post('/collection/:id/addconsole', collection.addConsole);
router.post('/database/addcollection', database.addCollection);
router.get('/collection/:id/deleteconsole/:consoleid', collection.deleteConsole);
router.get('/database/deletecollection/:id', database.deleteCollection);
router.post('/collection/:id/updateconsole/:consoleid', collection.updateConsole);

router.get('/', accounts.index);
router.get('/login', accounts.login);
router.get('/signup', accounts.signup);
router.get('/logout', accounts.logout);
router.post('/register', accounts.register);
router.post('/authenticate', accounts.authenticate);

router.get('/error', (request, response, error) => response.status(404).end('Page not found.'));

export default router;