def solution(my_strings, parts):
    return ''.join(s[start:end+1] for s, (start, end) in zip(my_strings, parts))