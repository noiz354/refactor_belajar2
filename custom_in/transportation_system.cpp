#include <iostream>
#include <utility>
#include <vector>
#include <cmath>
#include <algorithm>
#include <cstdio>
#define sqr(x) ((x)*(x))
#define max 500000
#define maxnode 1005

using namespace std;
typedef pair<float,float>ii;
vector<ii>co;

float round(float d)
{
    return floor(d+0.5);
}

struct edges
{
    int s,e;
    float w;
};
edges ed[max];
int par[maxnode];

bool comp(edges e1,edges e2)
{
    return (e1.w-e2.w)<1e-9;
}

int findpar(int x)
{
    if(par[x]==x)
    return x;
    else
    return par[x]=findpar(par[x]);
}

int main()
{
    //freopen("input.txt","r",stdin);
    int t,counter=0;cin>>t;
    while(t!=0)
    {
        int n,r;
        co.clear();
        t--;counter++;
        cin>>n>>r;
        for(int i=1;i<=n;i++)par[i]=i;
        for(int i=0;i<n;i++)
        {
            double x,y;
            cin>>x>>y;
            co.push_back(ii(x,y));
        }
        int c=-1;
        for(int i=0;i<co.size();i++)
        for(int j=i+1;j<co.size();j++)

                {
                    c++;
                    ed[c].s=i+1;
                    ed[c].e=j+1;
                    ed[c].w=sqrt(sqr((double)co[i].first-co[j].first)+sqr((double)co[i].second-co[j].second));

                }

        sort(ed,ed+c+1,comp);
        int s=n;
        double road=0,rail=0;
        for(int i=0;i<=c;i++)
        {
            int u=findpar(ed[i].s);
            int v=findpar(ed[i].e);
            if((ed[i].w-r)>1e-9 && u!=v)
            {
                rail+=ed[i].w;
                par[v]=par[u];
            }


                else if(u!=v)
                {

                    road+=ed[i].w;
                    par[v]=par[u];
                    s--;
                }


        }
        road=round(road);
        rail=round(rail);
        cout<<"Case #"<<counter<<": "<<s<<" "<<road<<" "<<rail<<endl;

    }

    return 0;
}