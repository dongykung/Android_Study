package com.dkproject.compose_codelab.Chapter3.grammer


//fold함수는 컬렉션에서 단일 값을 생성하는 데 사용됩니다.
// 주로 총가격을 계산하거나 목록의 모든 요소를 합산하여 평균을 구하는 등의 작업에 가장 많이 사용됩니다.

val totalPrice = cookies.fold(0.0) { total, cookie ->
    total + cookie.price
}