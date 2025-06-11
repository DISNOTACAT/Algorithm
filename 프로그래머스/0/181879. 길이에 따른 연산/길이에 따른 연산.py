from functools import reduce

def solution(num_list):
    if len(num_list) > 10:
        return sum(num_list)
    else:
        return reduce(lambda x, y: x*y , num_list)