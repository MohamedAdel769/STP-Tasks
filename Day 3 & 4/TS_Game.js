"use strict";
class SmileyGame {
    constructor(Nfaces, difficulty, img) {
        this.curr_faces = Nfaces;
        this.lvl_diff = difficulty;
        this.face_img = img;
        this.curr_lvl = 1;
        this.curr_lives = 2;
    }
    checkResult(currID) {
        if (currID === "target") {
            alert("GG EZZZZZZ!");
            this.levelUp();
            return true;
        }
        else {
            alert("NOPE");
            this.gameOver();
            fillPanel(this);
            return false;
        }
    }
    levelUp() {
        // if(this.curr_lvl % 10 === 0){
        //     // TODO: change smile img
        // }
        this.curr_faces += this.lvl_diff;
        this.curr_lvl++;
        fillPanel(this);
    }
    gameOver() {
        if (this.curr_lvl === 1)
            return;
        this.curr_lives--;
        if (this.curr_lives === 0) {
            this.curr_lvl--;
            this.curr_faces -= this.lvl_diff;
            this.curr_lives = 2;
        }
    }
    genSmile() {
        var new_smile = document.createElement("IMG");
        var min = 10;
        // get panel width and height, then subtract from it (padding + img size) to prevent overflow outside panel.
        var max_width = document.getElementById("left-panel").clientWidth - 80;
        var max_height = document.getElementById("left-panel").clientHeight - 80;
        // generate random position for the img between 10 and maxWidth/Height.
        new_smile.setAttribute("src", this.face_img);
        new_smile.style.top = Math.floor(Math.random() * (max_height - min + 1) + min) + "px";
        new_smile.style.left = Math.floor(Math.random() * (max_width - min + 1) + min) + "px";
        new_smile.addEventListener("click", () => { this.checkResult(new_smile.id); });
        //new_smile.setAttribute("onClick", "checkResult(this.id)");
        return new_smile;
    }
}
function removeAllChildNodes(parent) {
    while (parent.lastElementChild) {
        parent.removeChild(parent.lastElementChild);
    }
}
function fillPanel(new_game) {
    // TODO: Handle duplicates
    document.getElementById("curr-lvl").innerText = new_game.curr_lvl.toString();
    document.getElementById("curr-lives").innerText = new_game.curr_lives.toString();
    let right_panel = document.getElementById("right-panel");
    let left_panel = document.getElementById("left-panel");
    const cloned_faces = [];
    //clear prev faces on the panels.
    removeAllChildNodes(right_panel);
    removeAllChildNodes(left_panel);
    const unique_faces = new Set();
    while (unique_faces.size !== new_game.curr_faces) {
        unique_faces.add(new_game.genSmile());
    }
    for (let face of unique_faces) {
        let clone_smile = face.cloneNode();
        clone_smile.addEventListener("click", () => { new_game.checkResult(clone_smile.id); });
        cloned_faces.push(clone_smile);
        right_panel.appendChild(face);
    }
    for (let i = 0; i < new_game.curr_faces; i++) {
        left_panel.appendChild(cloned_faces[i]);
    }
    let target_smile = new_game.genSmile();
    target_smile.id = "target";
    addTarget(target_smile);
}
function addTarget(target_smile) {
    let chosen_panel = Math.floor(Math.random() * 2);
    if (chosen_panel === 0)
        document.getElementById("left-panel").appendChild(target_smile);
    else
        document.getElementById("right-panel").appendChild(target_smile);
}
window.addEventListener("load", function () {
    // TODO: window resize --> reGenerate faces in curr lvl
    var new_game = new SmileyGame(3, 2, "smile.png");
    fillPanel(new_game);
});
