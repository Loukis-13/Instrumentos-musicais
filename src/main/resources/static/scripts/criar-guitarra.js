trocaCorpo=(x)=>document.getElementById('corpo').src=`/images/partes/corpos/${x}.svg`
trocaBraco=(x)=>document.getElementById('braco').src=`/images/partes/bracos/${x}.svg`
trocaCabeca=(x)=>document.getElementById('cabeca').src=`/images/partes/cabecas/${x}.svg`
trocaCapitador1=(x)=>document.getElementById('capitador1').src=`/images/partes/capitadores/${x}.svg`
trocaCapitador2=(x)=>document.getElementById('capitador2').src=`/images/partes/capitadores/${x}.svg`

function generateImage() {
    let corpo = document.getElementById('corpo');
    let braco = document.getElementById('braco');
    let cabeca = document.getElementById('cabeca');
    let capitador1 = document.getElementById('capitador1');
    let capitador2 = document.getElementById('capitador2');

    let canvas = document.createElement('canvas');
    let context = canvas.getContext('2d');

    canvas.setAttribute('width', 584/2);
    canvas.setAttribute('height', 1036/2);
    context.scale(.5, .5);
    context.drawImage(corpo, 0, 0);
    context.drawImage(braco, 0, 0);
    context.drawImage(cabeca, 0, 0);
    context.drawImage(capitador1, 0, 0);
    context.drawImage(capitador2, 0, 0);

    document.getElementById('imagem').value = canvas.toDataURL();

     document.guitarraForm.submit();
}