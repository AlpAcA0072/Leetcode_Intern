f = lambda a, b=2, *args, c=3, **kwargs: a + b + c + sum(args) + sum(kwargs.values())
print(f(1, 4, 5, 6, d=7, e=8))

# #include <iostream>
# #include <vector>
# #include <algorithm>
# int main()
# {
#     std::cout<<"Hello World";
#     std::vector<int> v = {3,1,4,1,5,9,2,6,5,3,5};
#     auto it = std::remove_if(v.begin(), v.end(), [](int x){
#         return x % 2 == 0;
#     });
#     v.erase(it, v.end());
#     for (int num: v){
#         std::cout << num << " ";

#     }
#     std::cout << std::endl;
#     return 0;
# }
