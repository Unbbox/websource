// submit 발생 시
document.querySelector("form").addEventListener("submit", (e) => {
  // submit 기능 중지
  e.preventDefault();

  const code = document.querySelector("#code");
  const title = document.querySelector("#title");
  const writer = document.querySelector("#writer");
  const price = document.querySelector("#price");

  // code, title, writer, price 비어있는지 확인
  // code : 4자리인지 확인
  if (!code.value || code.value.length != 4 || isNaN(code.value)) {
    alert("코드값이 비어있거나 숫자 4자리가 아닙니다");
    code.focus();
    return;
  } else if (!title.value) {
    alert("제목을 입력해주세요");
    title.focus();
    return;
  } else if (!writer.value) {
    alert("저자를 입력해주세요");
    writer.focus();
    return;
  } else if (!price.value || isNaN(price.value)) {
    alert("가격 값이 비어있거나 숫자가 아닙니다");
    price.focus();
    return;
  }

  // 값이 존재한다면 submit
  e.target.submit();
});
