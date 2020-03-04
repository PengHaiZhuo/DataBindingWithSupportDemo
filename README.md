# DataBindingWithSupportDemo
 databinding实践，使用support包

### 第一步，在build.gradle的android标签下添加
```
//打开DataBinding
dataBinding {
  enabled = true
}
```

### 第二步
在布局中将最外层布局替换成<layout>标签，然后编译一下，会自动生成文件，比如activity_main.xml布局，会生成ActivityMainBinding文件

 
### 第三步使用
- Activity中使用，以MainActivity为例

```
/**
 * @author haizhuo
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //使用DataBinding,绑定后可以直接拿到控件，不需要使用findView去找，也不需要使用ButterKnife了
        //举个例子，设置id为id_content的控件透明度为80%
        binding.idContent.setAlpha(0.8f);
    }
}

```

- fragment中使用，以fragment_balance.xml为例
```
private FragmentBalanceBinding binding;

@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_balance,container,false);
        return binding.getRoot();
    }

```

### 后话
双向绑定需要使用到ViewModel，具体实现请查看demo


