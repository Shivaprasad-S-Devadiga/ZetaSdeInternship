var a = 10;
console.log(a);

function add() {
    var sum = 0;

    for (let i = 0; i < arguments.length; i++) {
        sum += arguments[i];
    }

    return sum;
}

var result = add(10, 20, 30);
console.log(result);
