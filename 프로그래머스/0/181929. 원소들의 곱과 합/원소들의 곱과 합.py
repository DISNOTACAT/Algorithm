def solution(num_list):
    total_sum = sum(num_list)
    total_product = 1
    for num in num_list:
        total_product *= num
    return 1 if total_product < total_sum ** 2 else 0
