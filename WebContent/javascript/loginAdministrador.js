$(
	function(){
		$('.botao').click(function(){
						
			var sEmail = $('.email').val();
			
			var emailFilter=/^.+@.+\..{2,}$/;
			var illegalChars= /[\(\)\<\>\,\;\:\\\/\"\[\]]/
			

			if(!(emailFilter.test(sEmail)) || sEmail.match(illegalChars)){
				$('.caixa-aviso').html("O email informado é inválido").slideDown(100);
			}
			else if($('.senha').val() == "" || $('.senha').val().length < 6){
				$('.caixa-aviso').html('A senha possui menos de seis dígitos').slideDown(100);
			}else{
				
			$.post('servletVerificarAdministrador.jsp',{ 
					email:$('.email').val(), senha:$('.senha').val()
			}
			, 
			function(dados){								
				if(dados == 'true'){
					window.location.replace("servletCadastroProdutos.jsp")
				}else{
					alert("Usuário inválido, tente novamente");				
				}					
			});				
			}
				
		});
		
	$('.caixa-aviso').click(function(){
		$(this).slideUp(100);		
	});	
	
	}
		
  );
