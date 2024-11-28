const mongoose = require("mongoose");

const showSchema = new mongoose.Schema({
    nome: {
        type:String,
        required: true,
    },
    data: {
        type: Date,
        required: true,
    },
    cidade: {
        type: String,
        required: true,
    },
    estadio: {
        type: String,
    },
    ingressosDisponiveis: {
        type : Number,
        default: 0,
    }

});
const show = mongoose.model("show", showSchema);
module.exports = show;