var faker = require('faker');

var database = { products: [] };

for (var i=1; i<=500; i++) {
  database.products.push({
    id: i,
    name: faker.random.word(),
    cost: faker.random.number({min:0, max:1000000}),
    quantity: faker.random.number({min:0, max:1000})
  });
}

console.log(JSON.stringify(database));