const express = require('express');
const Show = require('../models/Show');
const router = express.Router();

router.get('/',async (req,res)=> {
    try{
      const shows = await Show.find();
      res.json(shows);   

    }catch (err) {
        res.status(500).json({message:err.message});
    }

});


router.post('/', async (req,res)=> {
    const { nome, data, cidade, estadio, ingressosDisponiveis }
    =req.body;

    const novoShow = new Show({
        nome,
        data,
        cidade,
        estadio,
        ingressosDisponiveis,
    });

    try {
        const show = await novoShow.save();
        res.status(201).json(show);
    } catch (err) {
        res.status(400).json({message:err.message});
    }
});

router.put('/:id', async (req,res)=>{
try{
    const show = await Show.findByIdAndDelete
    (req.params.id,req.body,{new:true});
    res.json(show);
}catch (err) {
    res.status(400).json({message:err.message});
}
});

router.delete('/:id',async (req,res)=> {
 try{
    await Show.findByIdAndDelete(req.params.id);
    res.json({message:'Show deletado com sucesso'});
 }catch (err) {
    res.status(500).json({message:err.message});
 }    
});

module.exports = router;