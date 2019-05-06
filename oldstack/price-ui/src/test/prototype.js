function Cat(name) {
  this.name = name;
}
Cat.prototype.meow = function meow() {
  console.log(this.name + " meow !");
};

let cat = new Cat("Hector");
cat.meow();
