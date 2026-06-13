SELECT
    e1.name AS first_employee,
    e2.name AS second_employee
FROM employee e1
JOIN employee e2
    ON e1.salary < e2.salary
ORDER BY
    e1.id ASC,
    e2.salary ASC;