class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        s = s.replace('()','+1')
        while '(' in s or '+' in s[1:]:
            s = re.sub(r'\(\+(\d+)\)',lambda m:f'+{int(m[1])*2}',s)
            s = re.sub(r'([^()]+)',lambda m:f'+{eval(m[1])}',s)

        return int(s)