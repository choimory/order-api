# DB

## store

- 가게

## item

- 상품
- store와 1:N

## item_image

- 상품의 이미지
- type: RAW(원본), RESIZE(리사이즈)
- item과 1:N

## order

- 특정 상품에 대한 주문
- status: WAIT(대기), 접수(ACCEPT), 완료(COMPLETE)
- item과 N:1

# API

## 상세 조회 

- /api/orders/{id}
- 성공시 200, 해당 주문애 대한 정보를 반환
- 잘못된 요청시 400, 잘못된 요청에 대한 값과 사유를 반환
- 값이 없을시 404를 반환

## 목록 조회

- /api/orders/{id}
- 성공시 200, 페이지네이션 정보와 주문 목록을 반환
    - 주문명, 주문자명, 상태를 요청해 해당 값에 해당하는 목록 조회 가능 
- 잘못된 요청시 400, 잘못된 요청에 대한 값과 사유를 반환
- 값이 없을시 404를 반환

## 주문 접수

- /api/orders/{id}/accept
- 성공시 200, 주문 접수 처리된 주문정보를 반환
- 잘못된 요청시 400, 잘못된 요청에 대한 값과 사유를 반환
- 값이 없을시 404를 반환

## 주문 완료

- /api/orders/{id}/complete
- 성공시 200, 주문 완료 처리된 주문정보를 반환
- 잘못된 요청시 400, 잘못된 요청에 대한 값과 사유를 반환
- 값이 없을시 404를 반환