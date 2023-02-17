// 以下一整段是 CKEditor 啟動的程式碼，不要改直接複製貼上
const watchdog = new CKSource.EditorWatchdog();
window.watchdog = watchdog;
watchdog.setCreator((element, config) => {
    return CKSource.Editor
        .create(element, config)
        .then(editor => {
            return editor;
        })
});
watchdog.setDestructor(editor => {
    return editor.destroy();
});
watchdog.on('error', handleError);
watchdog
    .create(document.getElementById('ckeditor'), {
        licenseKey: '',
    })
    .catch(handleError);
function handleError(error) {
    console.error('Oops, something went wrong!');
    console.error('Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:');
    console.warn('Build id: 2k3rlvkrt2sl-cxacd0sf2d33');
    console.error(error);
}

// 以下是表單送出後去抓 CKEditor 裡寫的東西的程式碼
// 內容會轉成 markdown 語法的程式碼字串（就是純 string 而已不用懷疑～）
// 這個部分可以自訂成想要的功能
//const whatiwrite = document.getElementById('whatiwrite');
//document.querySelector('form').addEventListener('submit', function (e) {
//    e.preventDefault();
//    console.log(watchdog.editor.getData());
//});