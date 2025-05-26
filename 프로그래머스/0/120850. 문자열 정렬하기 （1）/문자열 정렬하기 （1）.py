def solution(my_string):
    digit_list = []
    for ch in my_string:
        if ch.isdigit():
            digit_list.append(int(ch))
    return sorted(digit_list)