$(document).ready(function(){
            //1. hide error section
            $("#codeError").hide();
            $("#specNameError").hide();
            $("#specNoteError").hide();

            //2. define error variable
            var codeError = false;
            var specNameError = false;
            var specNoteError = false;

            //3. validate function
            function validate_code() {
                var val = $("#code").val();
                var exp = /^[A-Z]{4}$/;
                if(val=='') {
                    $("#codeError").show();
                    $("#codeError").html("*<b>Code</b> Can not be empty")
                    $("#codeError").css('color','red');
                    codeError = false;
                } else if(!exp.test(val)) {
                    $("#codeError").show();
                    $("#codeError").html("*<b>Code</b> must be 4 chars only")
                    $("#codeError").css('color','red');
                    codeError = false;
                } else {
                    $.ajax({
						url:'checkCode',
						data: {"code": val},
						success:function(resTxt) {
							if(resTxt!='') {
								$("#codeError").show();
                   				$("#codeError").html(resTxt);
                    			$("#codeError").css('color','red');
                    			codeError = false;
							} else {
								$("#codeError").hide();
								codeError = true;
							}
						}
						
					});
                }
                return codeError;
            }

            function validate_specName() {
                var val = $("#specName").val();
                var exp = /^[A-Za-z0-9\s\.]{4,60}$/;
                if(val=='') {
                    $("#specNameError").show();
                    $("#specNameError").html("*<b>Name</b> Can not be empty")
                    $("#specNameError").css('color','red');
                    specNameError = false;
                } else if(!exp.test(val)) {
                    $("#specNameError").show();
                    $("#specNameError").html("*<b>Name</b> must be 4-25 chars")
                    $("#specNameError").css('color','red');
                    specNameError = false;
                } else {
                    $("#specNameError").hide();
                    specNameError = true;
                }
                
                return specNameError;
            }

            function validate_specNote() {
                var val = $("#specNote").val();
                var exp = /^[A-Za-z0-9\s\.\-\,\']{10,250}$/;
                if(val=='') {
                    $("#specNoteError").show();
                    $("#specNoteError").html("*<b>Note</b> Can not be empty")
                    $("#specNoteError").css('color','red');
                    specNoteError = false;
                } else if(!exp.test(val)) {
                    $("#specNoteError").show();
                    $("#specNoteError").html("*<b>Note</b> can have 10 to 150 chars[A-Za-z0-9.,-(space)]")
                    $("#specNoteError").css('color','red');
                    specNoteError = false;
                } else {
                    $("#specNoteError").hide();
                    specNoteError = true;
                }
                 return specNoteError;
            }

            //4. action-event
            $("#code").keyup(function(){
                //$(this).val($(this).val().toUpperCase());
                validate_code();
            });

            $("#specName").keyup(function(){
                validate_specName();
            });

            $("#specNote").keyup(function(){
                validate_specNote();
            });

            //5. on submit
            $("#specForm").submit(function(){
                validate_code();
                validate_specName();
                validate_specNote();

                if(codeError 
                && specNameError 
                && specNoteError)
                    return true;
                else return false;
            });
        });