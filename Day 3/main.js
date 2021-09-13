var game_mod = {
    curr_faces: 4,
    lvl_diff: 2,
    curr_lvl: 1
};

function getResult(){
    //console.log(this);
    let lvl_up = false;
    if(this.id === "target"){
        alert("GG EZZZZZZ!");
       lvl_up = true;
    }
    else{
        alert("NOPE -_-");
    }
    mainLoop(game_mod, lvl_up);
}

function genSmile(){
    var new_smile = document.createElement("IMG");
    var min = 10;

    // get panel width and height, then subtract from it (padding + img size) to prevent overflow outside panel.
    var max_width = document.getElementById("left-panel").clientWidth - 80;
    var max_height = document.getElementById("left-panel").clientHeight - 80;

    // generate random position for the img between 10 and maxWidth/Height.
    new_smile.src = "smile.png";
    new_smile.style.top = Math.floor(Math.random() * (max_height - min + 1) + min) + "px";
    new_smile.style.left = Math.floor(Math.random() * (max_width - min + 1) + min) + "px";
    new_smile.addEventListener("click", getResult);

    return new_smile;
}

function removeAllChildNodes(parent) {
    while (parent.lastElementChild) {
        parent.removeChild(parent.lastElementChild);
    }
}

function fillPanel(faces_number){
    // TODO: Handle duplicates

    let right_panel = document.getElementById("right-panel");
    let left_panel = document.getElementById("left-panel");
    const cloned_faces = [];

    //clear prev faces on the panels.
    removeAllChildNodes(right_panel);
    removeAllChildNodes(left_panel);

    for(let i=0;i<faces_number;i++){
        let new_smile = genSmile();
        let clone_smile = new_smile.cloneNode();
        clone_smile.addEventListener("click", getResult);

        cloned_faces.push(clone_smile);
        right_panel.appendChild(new_smile);
    }

    for(let i=0;i<faces_number;i++){
        left_panel.appendChild(cloned_faces[i]);
    }
}

function addTarget(){
    let chosen_panel = Math.floor(Math.random() * 2);

    let target_smile = genSmile();
    target_smile.id = "target";

    if(chosen_panel === 0)
        document.getElementById("left-panel").appendChild(target_smile);
    else
        document.getElementById("right-panel").appendChild(target_smile);
}

function mainLoop(game_mod, lvl_up){
    if(lvl_up){
        if(game_mod.curr_lvl % 5 === 0){
            game_mod.lvl_diff += 2;
        }
        game_mod.curr_faces += game_mod.lvl_diff;
        game_mod.curr_lvl++;

        document.getElementById("curr-lvl").innerText = game_mod.curr_lvl;
    }

    fillPanel(game_mod.curr_faces);
    addTarget();
}

window.addEventListener("load", function(){
    // TODO: window resize --> reGenerate faces in curr lvl
    mainLoop(game_mod, false);
});

