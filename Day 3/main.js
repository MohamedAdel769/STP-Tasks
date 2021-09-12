function genSmile(){
    var newSmile = document.createElement("IMG");
    var min = 10;

    // get panel width and height, then subtract from it (padding + img size) to prevent overflow outside panel.
    var maxWidth = document.getElementById("left-panel").clientWidth - 80;
    var maxHeight = document.getElementById("left-panel").clientHeight - 80;

    // generate random position for the img between 10 and maxWidth/Height.
    newSmile.src = 'smile.png';
    newSmile.style.top = Math.floor(Math.random() * (maxHeight - min + 1) + min) + "px";
    newSmile.style.left = Math.floor(Math.random() * (maxWidth - min + 1) + min) + "px";

    return newSmile;
}

function fillPanel(facesNumber){
    // TODO: Handle duplicates

    var newFaces = [];
    //var frag = document.createDocumentFragment();

    for(let i=0;i<facesNumber;i++){
        newFaces.push(genSmile());
        //frag.appendChild(newFaces[i]);
    }

    var leftPanel = document.getElementById("left-panel");
    var rightPanel = document.getElementById("right-panel");

    //console.log(document.getElementById("right-panel").childElementCount);

    for(let i=0;i<newFaces.length;i++){
        rightPanel.appendChild(newFaces[i]);
    }

    //console.log(document.getElementById("right-panel").childElementCount);

    // for(let i=0;i<newFaces.length;i++){
    //     console.log(newFaces[i]);
    // }

    for(let i=0;i<newFaces.length;i++){
        leftPanel.appendChild(newFaces[i]);
    }

    //console.log(document.getElementById("right-panel").childElementCount);
}

window.addEventListener("load", function(){
    fillPanel(4);
});

