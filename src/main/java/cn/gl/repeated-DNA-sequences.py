class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        target_set = set()
        temp_set = set()

        for i,v in enumerate(s):
            if i > len(s) - 10:
                break
            origin_len = len(temp_set)
            temp_set.add(s[i:i + 10])
            new_len = len(temp_set)
            if origin_len == new_len:
                target_set.add(s[i:i+10])
        return list(target_set)


s = Solution()
r = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
print(r)

