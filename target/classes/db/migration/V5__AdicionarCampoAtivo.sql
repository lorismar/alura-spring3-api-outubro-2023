ALTER TABLE vollmed_api.medicos ADD ativo tinyint ;
update vollmed_api.medicos set ativo = 1;