def solution(answers):
    answer = []
    
    player1 = [1,2,3,4,5]
    player2 = [2,1,2,3,2,4,2,5]
    player3 = [3,3,1,1,2,2,4,4,5,5]
    
    scores = [0] * 3
    
    for i in range(len(answers)):
        if answers[i] == player1[i%len(player1)]:
            scores[0] += 1
        if answers[i] == player2[i%len(player2)]:
            scores[1] += 1
        if answers[i] == player3[i%len(player3)]:
            scores[2] += 1
    
    for i, s in enumerate(scores):
        if s == max(scores):
            answer.append(i+1)
    
    
    return answer