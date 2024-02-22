-- 코드를 입력하세요
SELECT a.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY, sum(c.SALES*a.PRICE) as TOTAL_SALES
FROM BOOK a JOIN AUTHOR b ON a.AUTHOR_ID = b.AUTHOR_ID JOIN BOOK_SALES c ON a.BOOK_ID = c.BOOK_ID
WHERE YEAR(c.SALES_DATE) = '2022' AND MONTH(c.SALES_DATE) = '1'
GROUP BY a.AUTHOR_ID, a.CATEGORY
ORDER BY AUTHOR_ID ASC, CATEGORY desc