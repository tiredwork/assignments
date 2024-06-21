'use strict';

import express from 'express';
import routes from './routes.js';
import logger from "./utils/logger.js";
import { create } from 'express-handlebars';
import bodyParser from "body-parser";
import cookieParser from "cookie-parser";
import fileUpload from "express-fileupload";

const app = express();
const port = 3000;

app.use(express.static("public"));
app.use(bodyParser.urlencoded({ extended: false, }));
app.use(cookieParser());
app.use(fileUpload({useTempFiles: true}));

const handlebars = create({
    extname: '.hbs', 
        helpers: {
            //helpers here
        }
    }
);
app.engine(".hbs", handlebars.engine);
app.set("view engine", ".hbs");

app.use("/", routes);

app.listen(port, () => logger.info("Your app is listening on port " + port));