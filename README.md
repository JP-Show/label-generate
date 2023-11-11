# label-generate
Programa que gera etiquetas em .odt (documento de texto do libreoffice)

## Como usar
Bem de um readme.txt dentro da pasta
para usar esse programa você vai precisar do AIDA64 em conjunto (claro que ele funciona sem o AIDA porém ao pegar o socket é possível dar "unknown"), enfim vamos falar sobre a estrutura

### No diretório atual existe o script.bat, o start.exe

1. start.exe - vai iniciar o aida e fazer o relatório e salvar nesse diretório mesmo depois iniciar o start.bat (PS* ele vai buscar um aida no diretório atual (aida64extreme\aida64.exe))

2. script.bat - o programa vai inicia o generate-label.jar

3. Model.odt - modelo exemplo de etiqueta

### Dentro da pasta geradorEtiquetas

1. tem o win-x86 nele existe um programa feito em c# compilado, ele simplesmente pega o socket (porém se a máquina for muito antiga é possivel ele não pegar o socket)

2. config.properties - CRUCIAL PRESTAR ATENÇÃO NELA E EDITAR, tem duas linhas
   - fileSaveLabel= - precisa ter endereço de onde vai ser pego o Model.odt (sim precisa está com o nome Model.odt) e esse endereço vai ser utilizado para salvar o etiquetas também. Exemplo: C:/Users/Administrador/Desktop/Remoto-ponto-a-ponto
     - odt é o tipo do arquivo do libreoffice writer. o Model.odt precisa ter uma tabela 1x1 (uma tabela de uma celula apenas) para funcionar corretamente, vai ter um Model.odt de exemplo dentro dessa pasta
  - dirFile= é o nome onde o generate-label.jar está, por padrão é geradorEtiquetas.

3. generate-label.jar - o programa que gera a etiqueta.

EM CASO DE ERROR

vai ser gerador um log dentro da pasta onde está o generate-label.jar, vai ser um log, pode tentar corrigir apartir desse error ou mandar constatar o error no repositório do programa

https://github.com/Ponto-a-Ponto-LTDA/label-generate/issues   :)
