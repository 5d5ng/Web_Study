function printName(firstName) {
    var myName = "Dave";
    return "name is "+firstName;
}

function printName2(firstName){
    var inner = function(){
        return "inner value";
    }
    var result = inner();
    console.log("name is "+result);
}
function exArgument(){
    var res = 0 ;
    for (let i = 0; i < arguments.length; i++) {
        res+=arguments[i];
    }
    return res;
}

//printName2();
console.log(exArgument(1,2,3,4,5,6,7,8,10));

//arrow Function
var getNum = (num) => "Your number is " +num;
console.log(getNum(12345));


