import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import caigoujinhuo from '@/views/modules/caigoujinhuo/list'
    import caigoutuihuo from '@/views/modules/caigoutuihuo/list'
    import caigouyuangong from '@/views/modules/caigouyuangong/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gongyingshang from '@/views/modules/gongyingshang/list'
    import shangpin from '@/views/modules/shangpin/list'
    import xiaoshou from '@/views/modules/xiaoshou/list'
    import xiaoshouyuangong from '@/views/modules/xiaoshouyuangong/list'
    import dictionaryGongyingshang from '@/views/modules/dictionaryGongyingshang/list'
    import dictionaryGongyingshangXinyongdengji from '@/views/modules/dictionaryGongyingshangXinyongdengji/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangpin from '@/views/modules/dictionaryShangpin/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryGongyingshang',
        name: '供应商类型',
        component: dictionaryGongyingshang
    }
    ,{
        path: '/dictionaryGongyingshangXinyongdengji',
        name: '供应商信用等级类型',
        component: dictionaryGongyingshangXinyongdengji
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpin',
        name: '商品类型',
        component: dictionaryShangpin
    }


    ,{
        path: '/caigoujinhuo',
        name: '采购进货',
        component: caigoujinhuo
      }
    ,{
        path: '/caigoutuihuo',
        name: '采购退货',
        component: caigoutuihuo
      }
    ,{
        path: '/caigouyuangong',
        name: '采购员工',
        component: caigouyuangong
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gongyingshang',
        name: '供应商信息',
        component: gongyingshang
      }
    ,{
        path: '/shangpin',
        name: '商品',
        component: shangpin
      }
    ,{
        path: '/xiaoshou',
        name: '商品销售',
        component: xiaoshou
      }
    ,{
        path: '/xiaoshouyuangong',
        name: '销售员工',
        component: xiaoshouyuangong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
