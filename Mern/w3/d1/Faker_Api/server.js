import { faker } from '@faker-js/faker';
//defines require so that import and require can be used in the same file
import { createRequire } from "module";
const require = createRequire(import.meta.url);
//
const express = require("express");
const app = express();

const User = () => {
    const newUser = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        lastName: faker.name.lastName(),
        firstName: faker.name.firstName(),
        _id: faker.datatype.uuid()
    };
    return newUser;
};

const Company = () => {
    const newCompany = {
        _id: faker.datatype.uuid(),
        name: faker.company.name(),
        address: {
            street: faker.address.streetAddress(),
            city: faker.address.city(),
            state: faker.address.state(),
            zipCode: faker.address.zipCode(),
            country: faker.address.country()
        }
    };
    return newCompany;
};



app.get("/api/users/new", (req, res) => {
    const newUser = User();
    res.send(newUser);
});

app.get("/api/companies/new", (req, res) => {
    const newCompany = Company();
    res.send(newCompany);
});

const server = app.listen(8000, () =>
    console.log(`Server is locked and loaded on port ${server.address().port}!`)
);