string removeDups(string str) {
        // Your code goes here
        map<char,bool>mp2;
        for(int i=0;i<str.length();i++)
        {
            mp2[str[i]] ;
        }
        string str2;
        for(int i=0;i<str.length();i++)
        {
            if(mp2[str[i]]==false)
            {
                str2 = str2 + str[i];
                mp2[str[i]] = true;
            }
        }
        return str2;
    }
