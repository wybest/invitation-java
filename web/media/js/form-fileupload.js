var FormFileUpload = function () {


    return {
        //main function to initiate the module
        init: function () {

            // Initialize the jQuery File Upload widget:
            $('#fileupload').fileupload({
                // Uncomment the following to send cross-domain cookies:
                //xhrFields: {withCredentials: true},
                url: '/upload',
                previewMaxWidth : 200,
                previewMaxHeight : 200
            });

            var uploader = $("#singlefileupload");
            uploader.fileupload({
                url : '/uploadBackground',
                dataType: 'json',
                autoUpload: true,
                acceptFileTypes:  /(\.|\/)(gif|jpe?g|png)$/i,
                maxNumberOfFiles : 1,
                fileInput : uploader.find("input:file"),
                maxFileSize: 5000000,
                previewMaxWidth : 200,
                previewMaxHeight : 200
            });

            // Load existing files:
            // Demo settings:
            $.ajax({
                // Uncomment the following to send cross-domain cookies:
                //xhrFields: {withCredentials: true},
                url: "/images",
                dataType: 'json',
                context: $('#fileupload')[0],
                maxFileSize: 5000000,
                acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                process: [{
                        action: 'load',
                        fileTypes: /^image\/(gif|jpeg|png)$/,
                        maxFileSize: 20000000 // 20MB
                    }, {
                        action: 'resize',
                        maxWidth: 200,
                        maxHeight: 200
                    }, {
                        action: 'save'
                    }
                ]
            }).done(function (result) {
                $(this).fileupload('option', 'done')
                    .call(this, null, {
                    result: result
                });
            });

            // Upload server status check for browsers with CORS support:
            if ($.support.cors) {
                $.ajax({
                    url: '/check',
                    type: 'HEAD'
                }).fail(function () {
                    $('<span class="alert alert-error"/>')
                        .text('Upload server currently unavailable - ' +
                        new Date())
                        .appendTo('#fileupload');
                });
            }

            // initialize uniform checkboxes  
            App.initUniform('.fileupload-toggle-checkbox');
        }

    };

}();