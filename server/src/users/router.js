const UserRepository = require('./services/UserRepository');
const express = require('express');

module.exports = () => {
    const router = express.Router();

    router.get('/', (req, res) => {
        res.send(UserRepository.retrieveUsers());
    });
    router.get('/:id', (req, res) => {
        res.send(UserRepository.findOneById(req.params.id));
    });
    router.delete('/:id', (req, res) => {
        res.send(UserRepository.deleteUser(req.params.id));
    });
    router.post('/', (req, res) => {
        res.send(UserRepository.persistUser(req.body));
    });

    return router;
};