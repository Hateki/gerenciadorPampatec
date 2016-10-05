-- CADASTRO DE ENDERECO
INSERT INTO endereco(idendereco, bairro, logradouro, numero, rua, complemento, cidade, estado) VALUES
(1, 'CENTRO', 'RUA', 15, 'GASPAR MARTINS', 'CASA', 'ALEGRETE', 'RS');
 
INSERT INTO endereco(idendereco, bairro, logradouro, numero, rua, complemento, cidade, estado) VALUES
(2, 'CENTRO', 'AV', 255, 'ASSIS BRASIL', 'AP 202', 'ALEGRETE', 'RS');
 
INSERT INTO endereco(idendereco, bairro, logradouro, numero, rua, complemento, cidade, estado) VALUES
(3, 'CIDADE ALTA', 'RUA', 1981, 'BARAO DO RIO BRANCO', 'CASA', 'ALEGRETE', 'RS');

-- CADASTRO DE FUNCIONARIOS

INSERT INTO funcionario(idfuncionario, nome, matricula, telefone, email, cpf, rg, estagio_obrigatorio, ativo
, curso, instituicao, endereco_idendereco, codigo_acesso) VALUES
(1, 'ROBERTO', '131150222', '3422-5522', 'email@email.com', '00000000000', '1002585900', true, true,
'ENGENHARIA', 'UNIPAMPA', 1, 'meucodigo20');
INSERT INTO funcionario(idfuncionario, nome, matricula, telefone, email, cpf, rg, estagio_obrigatorio, ativo
, curso, instituicao, endereco_idendereco, codigo_acesso) VALUES
(2, 'BESSIAS', '1000000', '3422-5522', 'email20@email.com', '0010000100', '899635552', false, true,
 'ES', 'UNIPAMPA', 2, 'codigomeu10');

INSERT INTO funcionario(idfuncionario, nome, matricula, telefone, email, cpf, rg, estagio_obrigatorio, ativo
, curso, instituicao, endereco_idendereco, codigo_acesso) VALUES
(3, 'TTTTTTT', '100855200', '3422-5522', 'novo20@email.com', '10000125100', '98522552', false, true,
 'ES', 'UNIPAMPA', 3, '200000');