def solution(s):
    answer = 0
    
    for i in range(len(s)):
        stack = []
        for j in range(len(s)):
            c = s[(i+j) % len(s)]
            if len(stack) > 0:
                if c ==')' and stack[-1] =='(':
                    stack.pop()
                elif c ==']' and stack[-1] =='[':
                    stack.pop()
                elif c =='}' and stack[-1] == '{':
                    stack.pop()
                else:
                    stack.append(c)
            else:
                stack.append(c)
        
        if len(stack) == 0:
            answer += 1
    
    return answer