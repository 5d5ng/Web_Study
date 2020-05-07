
function run(){
    console.log("start");
    setTimeout(function () { // 시간 조절 해주는 함수
        var msg ="Hello run"
        console.log(msg);
    },100);
    console.log("end");
}

function run2() {
    console.log("start");
    setInterval(function(){
        //do something every 500ms
        var msg ="Hello";
        console.log(msg);
    },500);
    console.log("end");
}

console.log("이게 먼저나올까?");

run();
console.log("run보다 먼저일까?");
run2();