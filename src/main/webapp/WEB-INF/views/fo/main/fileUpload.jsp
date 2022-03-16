<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>Aws S3 File Upload</title>
</head>
<body>
  <div style="height: 50px;">
      <input type="file" id="file" style="display: none;">
      <label for="file" style="color: blue;cursor: pointer">업로드</label>
      <input type="button" id="remove" style="display: none;">
      <label for="remove" style="color: red;cursor: pointer">삭제</label>
  </div>
  <div>
      <img id="img"/>
  </div>
  <script type="text/javascript">
    document.getElementById("file").addEventListener("change", uploadResource);
    document.getElementById("remove").addEventListener("click", removeResource);

    function uploadResource() {
        const file = document.getElementById("file");
        const formData = new FormData();
        formData.append("file", file.files[0]);

        fetch("/file/upload", {
            method : "POST"
            , body : formData
        })
        .then(result => result.json())
        .then(data => {
            document.getElementById("img").setAttribute("src", data.fileUrl);
            document.getElementById("remove").setAttribute("fileNm", data.fileNm)
        })
        .catch(error => console.log(`error => ${error}`));
    }
    function removeResource() {
        const fileNm = document.getElementById("remove").getAttribute("fileNm");
        if (!fileNm) {
            return;
        }
        const formData = new FormData();
        formData.append("fileNm", fileNm);

        fetch("/file/delete", {
            method : "DELETE"
            , body : formData
        })
        .then(result => {
            if (result.ok && result.status === 200) {
                alert("해당 이미지가 삭제되었습니다.");
                document.getElementById("img").removeAttribute("src");
            }
        })
        .catch(error => console.log(`error => ${error}`));
    }
  </script>
</body>
</html>