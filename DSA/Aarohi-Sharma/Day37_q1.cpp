 unordered_set<char> alphabet;
    for (char c = 'a'; c <= 'z'; ++c) {
        alphabet.insert(c);
    }
    unordered_set<char> present_chars;
    for (char c : s) {
        if (isalpha(c)) {
            present_chars.insert(tolower(c));
        }
    }
    for (char c : present_chars) {
        alphabet.erase(c);
    }
    return alphabet.size() <= k;
