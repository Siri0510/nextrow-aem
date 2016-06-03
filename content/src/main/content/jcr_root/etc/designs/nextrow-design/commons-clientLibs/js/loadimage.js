//News.dialogs.image = News.dialogs.image || {
//    loadImage: function(comp) {
//        try {
//            var dlg = comp.findParentByType('dialog');
//            console.log(dlg);
//            var file = dlg.getField('./file');
//            var fileInfo = file.fileInfo ; 
//            if(fileInfo != null){
//            	
//                var imageDataPath = fileInfo.dataPath;
//                var imageFileName = fileInfo.fileName;
//                var assetCreateURL = '/services/scaffolding/imageupload.page.json?imageDataPath=' + imageDataPath + '&imageFileName=' + imageFileName;
//
//                $.ajax(assetCreateURL)
//                    .done(function(data) {
//                        if (typeof data != 'undefined' && data.length > 0) {
//                            CQ.Ext.getCmp('newsSmartImage').setValue(data);
//                        }
//                    })
//                    .fail(function() {
//                        alert("Faild to uplaod image, please re-upload the image");
//                    })
//            }else{
//                CQ.Ext.getCmp('newsSmartImage').setValue('');
//            }
//        } catch (err) {
//            console.error(err)
//        }
//    }
//};