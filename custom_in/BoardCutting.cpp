#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
int t;
cin>>t;
while(t--){
    int64_t m;
    int64_t n;
    cin>>m;
    cin>>n;
    int64_t a[m-1];
    int64_t b[n-1];
    vector<int64_t> v1;
    vector<int64_t> v2;
    for(int64_t i=0;i<m-1;i++){
        cin>>a[i];
        v1.push_back(a[i]);
    }
    for(int64_t i=0;i<n-1;i++){
        cin>>b[i];
        v2.push_back(b[i]);
    }
    sort(v1.begin(),v1.end());
    sort(v2.begin(),v2.end());
    int64_t h=m+n;
    int64_t k=1;
    int64_t p=1;
    int64_t cost=0;
    while(h--){
        if(v1.size()==0){
            int64_t sum=0;
            for(int64_t i=0;i<v2.size();i++){
                sum+=v2[i];
            }
            cost=(cost+(sum*p))%1000000007;
            break;
        }
        else if(v2.size()==0){
            int64_t sum=0;
            for(int64_t i=0;i<v1.size();i++){
                sum+=v1[i];
            }
            cost=(cost+(sum*k))%1000000007;
            break;
        }
        else if(v1[v1.size()-1]>v2[v2.size()-1]){
            cost=(cost+(v1[v1.size()-1]*k))%1000000007;
            p++;
            v1.erase(v1.begin()+v1.size()-1);
        }
        else if(v1[v1.size()-1]<v2[v2.size()-1]){
            cost=(cost+(v2[v2.size()-1]*p))%1000000007;
            k++;
            v2.erase(v2.begin()+v2.size()-1);
        }
        else if(v1[v1.size()-1]==v2[v2.size()-1]){
            if(v1[v1.size()-1]*k>=v2[v2.size()-1]*p){
            cost=(cost+(v2[v2.size()-1]*p))%1000000007;
            k++;
            v2.erase(v2.begin()+v2.size()-1);
            }
            else{
                cost=(cost+(v1[v1.size()-1]*k))%1000000007;
                p++;
                v1.erase(v1.begin()+v1.size()-1);
            }

        }
    }

    cout<<cost%1000000007<<endl;
}
return 0;
}