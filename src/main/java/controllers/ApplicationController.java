/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.amGame;
import models.spGame;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result acesUp() {
        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }
    
    public Result gameGet(@PathParam("choice") int choose){
        amGame g = new amGame();
        spGame g2 = new spGame();

        // build american deck
        if(choose == 1) {
            g.buildDeck();
            g.shuffle();
            return Results.json().render(g);
        }

        // build spanish deck
        else {
            g2.buildDeck();
            g2.shuffle();
            return Results.json().render(g2);
        }
    }

    public Result dealamPost(Context context, amGame g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        return Results.json().render(g);
    }

    public Result dealspPost(Context context, spGame g2) {
        if(context.getRequestPath().contains("deal")){
            g2.dealFour();
        }
        return Results.json().render(g2);
    }

    public Result removeamCard(Context context, @PathParam("column") int colNumber, amGame g){
        g.remove(colNumber);
        return  Results.json().render(g);
    }

    public Result removespCard(Context context, @PathParam("column") int colNumber, spGame g){
        g.remove(colNumber);
        return  Results.json().render(g);
    }

    public Result moveAmCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, amGame g){
        g.move(colFrom,colTo);
        return  Results.json().render(g);
    }

    public Result moveSpCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, spGame g){
        g.move(colFrom,colTo);
        return  Results.json().render(g);
    }
}
