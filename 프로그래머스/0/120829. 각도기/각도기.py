def solution(angle):
    answer = 1
    if angle == 90:
        answer = 2
    if angle > 90 and angle < 180:
        answer = 3
    if angle == 180:
        answer = 4
    return answer