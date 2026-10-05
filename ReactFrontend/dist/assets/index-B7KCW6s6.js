var TC=Object.defineProperty;var IC=(t,e,n)=>e in t?TC(t,e,{enumerable:!0,configurable:!0,writable:!0,value:n}):t[e]=n;var Oe=(t,e,n)=>IC(t,typeof e!="symbol"?e+"":e,n);(function(){const e=document.createElement("link").relList;if(e&&e.supports&&e.supports("modulepreload"))return;for(const i of document.querySelectorAll('link[rel="modulepreload"]'))r(i);new MutationObserver(i=>{for(const s of i)if(s.type==="childList")for(const o of s.addedNodes)o.tagName==="LINK"&&o.rel==="modulepreload"&&r(o)}).observe(document,{childList:!0,subtree:!0});function n(i){const s={};return i.integrity&&(s.integrity=i.integrity),i.referrerPolicy&&(s.referrerPolicy=i.referrerPolicy),i.crossOrigin==="use-credentials"?s.credentials="include":i.crossOrigin==="anonymous"?s.credentials="omit":s.credentials="same-origin",s}function r(i){if(i.ep)return;i.ep=!0;const s=n(i);fetch(i.href,s)}})();function SC(t){return t&&t.__esModule&&Object.prototype.hasOwnProperty.call(t,"default")?t.default:t}var bw={exports:{}},Zc={},Pw={exports:{}},ce={};/**
 * @license React
 * react.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var ml=Symbol.for("react.element"),kC=Symbol.for("react.portal"),CC=Symbol.for("react.fragment"),RC=Symbol.for("react.strict_mode"),xC=Symbol.for("react.profiler"),AC=Symbol.for("react.provider"),bC=Symbol.for("react.context"),PC=Symbol.for("react.forward_ref"),NC=Symbol.for("react.suspense"),DC=Symbol.for("react.memo"),OC=Symbol.for("react.lazy"),ay=Symbol.iterator;function MC(t){return t===null||typeof t!="object"?null:(t=ay&&t[ay]||t["@@iterator"],typeof t=="function"?t:null)}var Nw={isMounted:function(){return!1},enqueueForceUpdate:function(){},enqueueReplaceState:function(){},enqueueSetState:function(){}},Dw=Object.assign,Ow={};function po(t,e,n){this.props=t,this.context=e,this.refs=Ow,this.updater=n||Nw}po.prototype.isReactComponent={};po.prototype.setState=function(t,e){if(typeof t!="object"&&typeof t!="function"&&t!=null)throw Error("setState(...): takes an object of state variables to update or a function which returns an object of state variables.");this.updater.enqueueSetState(this,t,e,"setState")};po.prototype.forceUpdate=function(t){this.updater.enqueueForceUpdate(this,t,"forceUpdate")};function Mw(){}Mw.prototype=po.prototype;function Up(t,e,n){this.props=t,this.context=e,this.refs=Ow,this.updater=n||Nw}var jp=Up.prototype=new Mw;jp.constructor=Up;Dw(jp,po.prototype);jp.isPureReactComponent=!0;var ly=Array.isArray,Lw=Object.prototype.hasOwnProperty,zp={current:null},Fw={key:!0,ref:!0,__self:!0,__source:!0};function Vw(t,e,n){var r,i={},s=null,o=null;if(e!=null)for(r in e.ref!==void 0&&(o=e.ref),e.key!==void 0&&(s=""+e.key),e)Lw.call(e,r)&&!Fw.hasOwnProperty(r)&&(i[r]=e[r]);var a=arguments.length-2;if(a===1)i.children=n;else if(1<a){for(var u=Array(a),c=0;c<a;c++)u[c]=arguments[c+2];i.children=u}if(t&&t.defaultProps)for(r in a=t.defaultProps,a)i[r]===void 0&&(i[r]=a[r]);return{$$typeof:ml,type:t,key:s,ref:o,props:i,_owner:zp.current}}function LC(t,e){return{$$typeof:ml,type:t.type,key:e,ref:t.ref,props:t.props,_owner:t._owner}}function Bp(t){return typeof t=="object"&&t!==null&&t.$$typeof===ml}function FC(t){var e={"=":"=0",":":"=2"};return"$"+t.replace(/[=:]/g,function(n){return e[n]})}var uy=/\/+/g;function ld(t,e){return typeof t=="object"&&t!==null&&t.key!=null?FC(""+t.key):e.toString(36)}function bu(t,e,n,r,i){var s=typeof t;(s==="undefined"||s==="boolean")&&(t=null);var o=!1;if(t===null)o=!0;else switch(s){case"string":case"number":o=!0;break;case"object":switch(t.$$typeof){case ml:case kC:o=!0}}if(o)return o=t,i=i(o),t=r===""?"."+ld(o,0):r,ly(i)?(n="",t!=null&&(n=t.replace(uy,"$&/")+"/"),bu(i,e,n,"",function(c){return c})):i!=null&&(Bp(i)&&(i=LC(i,n+(!i.key||o&&o.key===i.key?"":(""+i.key).replace(uy,"$&/")+"/")+t)),e.push(i)),1;if(o=0,r=r===""?".":r+":",ly(t))for(var a=0;a<t.length;a++){s=t[a];var u=r+ld(s,a);o+=bu(s,e,n,u,i)}else if(u=MC(t),typeof u=="function")for(t=u.call(t),a=0;!(s=t.next()).done;)s=s.value,u=r+ld(s,a++),o+=bu(s,e,n,u,i);else if(s==="object")throw e=String(t),Error("Objects are not valid as a React child (found: "+(e==="[object Object]"?"object with keys {"+Object.keys(t).join(", ")+"}":e)+"). If you meant to render a collection of children, use an array instead.");return o}function tu(t,e,n){if(t==null)return t;var r=[],i=0;return bu(t,r,"","",function(s){return e.call(n,s,i++)}),r}function VC(t){if(t._status===-1){var e=t._result;e=e(),e.then(function(n){(t._status===0||t._status===-1)&&(t._status=1,t._result=n)},function(n){(t._status===0||t._status===-1)&&(t._status=2,t._result=n)}),t._status===-1&&(t._status=0,t._result=e)}if(t._status===1)return t._result.default;throw t._result}var Ht={current:null},Pu={transition:null},UC={ReactCurrentDispatcher:Ht,ReactCurrentBatchConfig:Pu,ReactCurrentOwner:zp};function Uw(){throw Error("act(...) is not supported in production builds of React.")}ce.Children={map:tu,forEach:function(t,e,n){tu(t,function(){e.apply(this,arguments)},n)},count:function(t){var e=0;return tu(t,function(){e++}),e},toArray:function(t){return tu(t,function(e){return e})||[]},only:function(t){if(!Bp(t))throw Error("React.Children.only expected to receive a single React element child.");return t}};ce.Component=po;ce.Fragment=CC;ce.Profiler=xC;ce.PureComponent=Up;ce.StrictMode=RC;ce.Suspense=NC;ce.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=UC;ce.act=Uw;ce.cloneElement=function(t,e,n){if(t==null)throw Error("React.cloneElement(...): The argument must be a React element, but you passed "+t+".");var r=Dw({},t.props),i=t.key,s=t.ref,o=t._owner;if(e!=null){if(e.ref!==void 0&&(s=e.ref,o=zp.current),e.key!==void 0&&(i=""+e.key),t.type&&t.type.defaultProps)var a=t.type.defaultProps;for(u in e)Lw.call(e,u)&&!Fw.hasOwnProperty(u)&&(r[u]=e[u]===void 0&&a!==void 0?a[u]:e[u])}var u=arguments.length-2;if(u===1)r.children=n;else if(1<u){a=Array(u);for(var c=0;c<u;c++)a[c]=arguments[c+2];r.children=a}return{$$typeof:ml,type:t.type,key:i,ref:s,props:r,_owner:o}};ce.createContext=function(t){return t={$$typeof:bC,_currentValue:t,_currentValue2:t,_threadCount:0,Provider:null,Consumer:null,_defaultValue:null,_globalName:null},t.Provider={$$typeof:AC,_context:t},t.Consumer=t};ce.createElement=Vw;ce.createFactory=function(t){var e=Vw.bind(null,t);return e.type=t,e};ce.createRef=function(){return{current:null}};ce.forwardRef=function(t){return{$$typeof:PC,render:t}};ce.isValidElement=Bp;ce.lazy=function(t){return{$$typeof:OC,_payload:{_status:-1,_result:t},_init:VC}};ce.memo=function(t,e){return{$$typeof:DC,type:t,compare:e===void 0?null:e}};ce.startTransition=function(t){var e=Pu.transition;Pu.transition={};try{t()}finally{Pu.transition=e}};ce.unstable_act=Uw;ce.useCallback=function(t,e){return Ht.current.useCallback(t,e)};ce.useContext=function(t){return Ht.current.useContext(t)};ce.useDebugValue=function(){};ce.useDeferredValue=function(t){return Ht.current.useDeferredValue(t)};ce.useEffect=function(t,e){return Ht.current.useEffect(t,e)};ce.useId=function(){return Ht.current.useId()};ce.useImperativeHandle=function(t,e,n){return Ht.current.useImperativeHandle(t,e,n)};ce.useInsertionEffect=function(t,e){return Ht.current.useInsertionEffect(t,e)};ce.useLayoutEffect=function(t,e){return Ht.current.useLayoutEffect(t,e)};ce.useMemo=function(t,e){return Ht.current.useMemo(t,e)};ce.useReducer=function(t,e,n){return Ht.current.useReducer(t,e,n)};ce.useRef=function(t){return Ht.current.useRef(t)};ce.useState=function(t){return Ht.current.useState(t)};ce.useSyncExternalStore=function(t,e,n){return Ht.current.useSyncExternalStore(t,e,n)};ce.useTransition=function(){return Ht.current.useTransition()};ce.version="18.3.1";Pw.exports=ce;var ne=Pw.exports;const jC=SC(ne);/**
 * @license React
 * react-jsx-runtime.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var zC=ne,BC=Symbol.for("react.element"),$C=Symbol.for("react.fragment"),WC=Object.prototype.hasOwnProperty,qC=zC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED.ReactCurrentOwner,HC={key:!0,ref:!0,__self:!0,__source:!0};function jw(t,e,n){var r,i={},s=null,o=null;n!==void 0&&(s=""+n),e.key!==void 0&&(s=""+e.key),e.ref!==void 0&&(o=e.ref);for(r in e)WC.call(e,r)&&!HC.hasOwnProperty(r)&&(i[r]=e[r]);if(t&&t.defaultProps)for(r in e=t.defaultProps,e)i[r]===void 0&&(i[r]=e[r]);return{$$typeof:BC,type:t,key:s,ref:o,props:i,_owner:qC.current}}Zc.Fragment=$C;Zc.jsx=jw;Zc.jsxs=jw;bw.exports=Zc;var m=bw.exports,sf={},zw={exports:{}},hn={},Bw={exports:{}},$w={};/**
 * @license React
 * scheduler.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */(function(t){function e(H,re){var P=H.length;H.push(re);e:for(;0<P;){var A=P-1>>>1,$=H[A];if(0<i($,re))H[A]=re,H[P]=$,P=A;else break e}}function n(H){return H.length===0?null:H[0]}function r(H){if(H.length===0)return null;var re=H[0],P=H.pop();if(P!==re){H[0]=P;e:for(var A=0,$=H.length,F=$>>>1;A<F;){var W=2*(A+1)-1,K=H[W],Z=W+1,Y=H[Z];if(0>i(K,P))Z<$&&0>i(Y,K)?(H[A]=Y,H[Z]=P,A=Z):(H[A]=K,H[W]=P,A=W);else if(Z<$&&0>i(Y,P))H[A]=Y,H[Z]=P,A=Z;else break e}}return re}function i(H,re){var P=H.sortIndex-re.sortIndex;return P!==0?P:H.id-re.id}if(typeof performance=="object"&&typeof performance.now=="function"){var s=performance;t.unstable_now=function(){return s.now()}}else{var o=Date,a=o.now();t.unstable_now=function(){return o.now()-a}}var u=[],c=[],h=1,f=null,g=3,v=!1,I=!1,N=!1,D=typeof setTimeout=="function"?setTimeout:null,C=typeof clearTimeout=="function"?clearTimeout:null,w=typeof setImmediate<"u"?setImmediate:null;typeof navigator<"u"&&navigator.scheduling!==void 0&&navigator.scheduling.isInputPending!==void 0&&navigator.scheduling.isInputPending.bind(navigator.scheduling);function R(H){for(var re=n(c);re!==null;){if(re.callback===null)r(c);else if(re.startTime<=H)r(c),re.sortIndex=re.expirationTime,e(u,re);else break;re=n(c)}}function M(H){if(N=!1,R(H),!I)if(n(u)!==null)I=!0,Je(z);else{var re=n(c);re!==null&&Rt(M,re.startTime-H)}}function z(H,re){I=!1,N&&(N=!1,C(y),y=-1),v=!0;var P=g;try{for(R(re),f=n(u);f!==null&&(!(f.expirationTime>re)||H&&!b());){var A=f.callback;if(typeof A=="function"){f.callback=null,g=f.priorityLevel;var $=A(f.expirationTime<=re);re=t.unstable_now(),typeof $=="function"?f.callback=$:f===n(u)&&r(u),R(re)}else r(u);f=n(u)}if(f!==null)var F=!0;else{var W=n(c);W!==null&&Rt(M,W.startTime-re),F=!1}return F}finally{f=null,g=P,v=!1}}var U=!1,E=null,y=-1,T=5,x=-1;function b(){return!(t.unstable_now()-x<T)}function k(){if(E!==null){var H=t.unstable_now();x=H;var re=!0;try{re=E(!0,H)}finally{re?S():(U=!1,E=null)}}else U=!1}var S;if(typeof w=="function")S=function(){w(k)};else if(typeof MessageChannel<"u"){var ue=new MessageChannel,Se=ue.port2;ue.port1.onmessage=k,S=function(){Se.postMessage(null)}}else S=function(){D(k,0)};function Je(H){E=H,U||(U=!0,S())}function Rt(H,re){y=D(function(){H(t.unstable_now())},re)}t.unstable_IdlePriority=5,t.unstable_ImmediatePriority=1,t.unstable_LowPriority=4,t.unstable_NormalPriority=3,t.unstable_Profiling=null,t.unstable_UserBlockingPriority=2,t.unstable_cancelCallback=function(H){H.callback=null},t.unstable_continueExecution=function(){I||v||(I=!0,Je(z))},t.unstable_forceFrameRate=function(H){0>H||125<H?console.error("forceFrameRate takes a positive int between 0 and 125, forcing frame rates higher than 125 fps is not supported"):T=0<H?Math.floor(1e3/H):5},t.unstable_getCurrentPriorityLevel=function(){return g},t.unstable_getFirstCallbackNode=function(){return n(u)},t.unstable_next=function(H){switch(g){case 1:case 2:case 3:var re=3;break;default:re=g}var P=g;g=re;try{return H()}finally{g=P}},t.unstable_pauseExecution=function(){},t.unstable_requestPaint=function(){},t.unstable_runWithPriority=function(H,re){switch(H){case 1:case 2:case 3:case 4:case 5:break;default:H=3}var P=g;g=H;try{return re()}finally{g=P}},t.unstable_scheduleCallback=function(H,re,P){var A=t.unstable_now();switch(typeof P=="object"&&P!==null?(P=P.delay,P=typeof P=="number"&&0<P?A+P:A):P=A,H){case 1:var $=-1;break;case 2:$=250;break;case 5:$=1073741823;break;case 4:$=1e4;break;default:$=5e3}return $=P+$,H={id:h++,callback:re,priorityLevel:H,startTime:P,expirationTime:$,sortIndex:-1},P>A?(H.sortIndex=P,e(c,H),n(u)===null&&H===n(c)&&(N?(C(y),y=-1):N=!0,Rt(M,P-A))):(H.sortIndex=$,e(u,H),I||v||(I=!0,Je(z))),H},t.unstable_shouldYield=b,t.unstable_wrapCallback=function(H){var re=g;return function(){var P=g;g=re;try{return H.apply(this,arguments)}finally{g=P}}}})($w);Bw.exports=$w;var GC=Bw.exports;/**
 * @license React
 * react-dom.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var KC=ne,cn=GC;function B(t){for(var e="https://reactjs.org/docs/error-decoder.html?invariant="+t,n=1;n<arguments.length;n++)e+="&args[]="+encodeURIComponent(arguments[n]);return"Minified React error #"+t+"; visit "+e+" for the full message or use the non-minified dev environment for full errors and additional helpful warnings."}var Ww=new Set,Fa={};function es(t,e){Qs(t,e),Qs(t+"Capture",e)}function Qs(t,e){for(Fa[t]=e,t=0;t<e.length;t++)Ww.add(e[t])}var mr=!(typeof window>"u"||typeof window.document>"u"||typeof window.document.createElement>"u"),of=Object.prototype.hasOwnProperty,QC=/^[:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD][:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD\-.0-9\u00B7\u0300-\u036F\u203F-\u2040]*$/,cy={},hy={};function YC(t){return of.call(hy,t)?!0:of.call(cy,t)?!1:QC.test(t)?hy[t]=!0:(cy[t]=!0,!1)}function XC(t,e,n,r){if(n!==null&&n.type===0)return!1;switch(typeof e){case"function":case"symbol":return!0;case"boolean":return r?!1:n!==null?!n.acceptsBooleans:(t=t.toLowerCase().slice(0,5),t!=="data-"&&t!=="aria-");default:return!1}}function JC(t,e,n,r){if(e===null||typeof e>"u"||XC(t,e,n,r))return!0;if(r)return!1;if(n!==null)switch(n.type){case 3:return!e;case 4:return e===!1;case 5:return isNaN(e);case 6:return isNaN(e)||1>e}return!1}function Gt(t,e,n,r,i,s,o){this.acceptsBooleans=e===2||e===3||e===4,this.attributeName=r,this.attributeNamespace=i,this.mustUseProperty=n,this.propertyName=t,this.type=e,this.sanitizeURL=s,this.removeEmptyString=o}var kt={};"children dangerouslySetInnerHTML defaultValue defaultChecked innerHTML suppressContentEditableWarning suppressHydrationWarning style".split(" ").forEach(function(t){kt[t]=new Gt(t,0,!1,t,null,!1,!1)});[["acceptCharset","accept-charset"],["className","class"],["htmlFor","for"],["httpEquiv","http-equiv"]].forEach(function(t){var e=t[0];kt[e]=new Gt(e,1,!1,t[1],null,!1,!1)});["contentEditable","draggable","spellCheck","value"].forEach(function(t){kt[t]=new Gt(t,2,!1,t.toLowerCase(),null,!1,!1)});["autoReverse","externalResourcesRequired","focusable","preserveAlpha"].forEach(function(t){kt[t]=new Gt(t,2,!1,t,null,!1,!1)});"allowFullScreen async autoFocus autoPlay controls default defer disabled disablePictureInPicture disableRemotePlayback formNoValidate hidden loop noModule noValidate open playsInline readOnly required reversed scoped seamless itemScope".split(" ").forEach(function(t){kt[t]=new Gt(t,3,!1,t.toLowerCase(),null,!1,!1)});["checked","multiple","muted","selected"].forEach(function(t){kt[t]=new Gt(t,3,!0,t,null,!1,!1)});["capture","download"].forEach(function(t){kt[t]=new Gt(t,4,!1,t,null,!1,!1)});["cols","rows","size","span"].forEach(function(t){kt[t]=new Gt(t,6,!1,t,null,!1,!1)});["rowSpan","start"].forEach(function(t){kt[t]=new Gt(t,5,!1,t.toLowerCase(),null,!1,!1)});var $p=/[\-:]([a-z])/g;function Wp(t){return t[1].toUpperCase()}"accent-height alignment-baseline arabic-form baseline-shift cap-height clip-path clip-rule color-interpolation color-interpolation-filters color-profile color-rendering dominant-baseline enable-background fill-opacity fill-rule flood-color flood-opacity font-family font-size font-size-adjust font-stretch font-style font-variant font-weight glyph-name glyph-orientation-horizontal glyph-orientation-vertical horiz-adv-x horiz-origin-x image-rendering letter-spacing lighting-color marker-end marker-mid marker-start overline-position overline-thickness paint-order panose-1 pointer-events rendering-intent shape-rendering stop-color stop-opacity strikethrough-position strikethrough-thickness stroke-dasharray stroke-dashoffset stroke-linecap stroke-linejoin stroke-miterlimit stroke-opacity stroke-width text-anchor text-decoration text-rendering underline-position underline-thickness unicode-bidi unicode-range units-per-em v-alphabetic v-hanging v-ideographic v-mathematical vector-effect vert-adv-y vert-origin-x vert-origin-y word-spacing writing-mode xmlns:xlink x-height".split(" ").forEach(function(t){var e=t.replace($p,Wp);kt[e]=new Gt(e,1,!1,t,null,!1,!1)});"xlink:actuate xlink:arcrole xlink:role xlink:show xlink:title xlink:type".split(" ").forEach(function(t){var e=t.replace($p,Wp);kt[e]=new Gt(e,1,!1,t,"http://www.w3.org/1999/xlink",!1,!1)});["xml:base","xml:lang","xml:space"].forEach(function(t){var e=t.replace($p,Wp);kt[e]=new Gt(e,1,!1,t,"http://www.w3.org/XML/1998/namespace",!1,!1)});["tabIndex","crossOrigin"].forEach(function(t){kt[t]=new Gt(t,1,!1,t.toLowerCase(),null,!1,!1)});kt.xlinkHref=new Gt("xlinkHref",1,!1,"xlink:href","http://www.w3.org/1999/xlink",!0,!1);["src","href","action","formAction"].forEach(function(t){kt[t]=new Gt(t,1,!1,t.toLowerCase(),null,!0,!0)});function qp(t,e,n,r){var i=kt.hasOwnProperty(e)?kt[e]:null;(i!==null?i.type!==0:r||!(2<e.length)||e[0]!=="o"&&e[0]!=="O"||e[1]!=="n"&&e[1]!=="N")&&(JC(e,n,i,r)&&(n=null),r||i===null?YC(e)&&(n===null?t.removeAttribute(e):t.setAttribute(e,""+n)):i.mustUseProperty?t[i.propertyName]=n===null?i.type===3?!1:"":n:(e=i.attributeName,r=i.attributeNamespace,n===null?t.removeAttribute(e):(i=i.type,n=i===3||i===4&&n===!0?"":""+n,r?t.setAttributeNS(r,e,n):t.setAttribute(e,n))))}var Rr=KC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED,nu=Symbol.for("react.element"),Es=Symbol.for("react.portal"),Ts=Symbol.for("react.fragment"),Hp=Symbol.for("react.strict_mode"),af=Symbol.for("react.profiler"),qw=Symbol.for("react.provider"),Hw=Symbol.for("react.context"),Gp=Symbol.for("react.forward_ref"),lf=Symbol.for("react.suspense"),uf=Symbol.for("react.suspense_list"),Kp=Symbol.for("react.memo"),Mr=Symbol.for("react.lazy"),Gw=Symbol.for("react.offscreen"),dy=Symbol.iterator;function qo(t){return t===null||typeof t!="object"?null:(t=dy&&t[dy]||t["@@iterator"],typeof t=="function"?t:null)}var Ge=Object.assign,ud;function aa(t){if(ud===void 0)try{throw Error()}catch(n){var e=n.stack.trim().match(/\n( *(at )?)/);ud=e&&e[1]||""}return`
`+ud+t}var cd=!1;function hd(t,e){if(!t||cd)return"";cd=!0;var n=Error.prepareStackTrace;Error.prepareStackTrace=void 0;try{if(e)if(e=function(){throw Error()},Object.defineProperty(e.prototype,"props",{set:function(){throw Error()}}),typeof Reflect=="object"&&Reflect.construct){try{Reflect.construct(e,[])}catch(c){var r=c}Reflect.construct(t,[],e)}else{try{e.call()}catch(c){r=c}t.call(e.prototype)}else{try{throw Error()}catch(c){r=c}t()}}catch(c){if(c&&r&&typeof c.stack=="string"){for(var i=c.stack.split(`
`),s=r.stack.split(`
`),o=i.length-1,a=s.length-1;1<=o&&0<=a&&i[o]!==s[a];)a--;for(;1<=o&&0<=a;o--,a--)if(i[o]!==s[a]){if(o!==1||a!==1)do if(o--,a--,0>a||i[o]!==s[a]){var u=`
`+i[o].replace(" at new "," at ");return t.displayName&&u.includes("<anonymous>")&&(u=u.replace("<anonymous>",t.displayName)),u}while(1<=o&&0<=a);break}}}finally{cd=!1,Error.prepareStackTrace=n}return(t=t?t.displayName||t.name:"")?aa(t):""}function ZC(t){switch(t.tag){case 5:return aa(t.type);case 16:return aa("Lazy");case 13:return aa("Suspense");case 19:return aa("SuspenseList");case 0:case 2:case 15:return t=hd(t.type,!1),t;case 11:return t=hd(t.type.render,!1),t;case 1:return t=hd(t.type,!0),t;default:return""}}function cf(t){if(t==null)return null;if(typeof t=="function")return t.displayName||t.name||null;if(typeof t=="string")return t;switch(t){case Ts:return"Fragment";case Es:return"Portal";case af:return"Profiler";case Hp:return"StrictMode";case lf:return"Suspense";case uf:return"SuspenseList"}if(typeof t=="object")switch(t.$$typeof){case Hw:return(t.displayName||"Context")+".Consumer";case qw:return(t._context.displayName||"Context")+".Provider";case Gp:var e=t.render;return t=t.displayName,t||(t=e.displayName||e.name||"",t=t!==""?"ForwardRef("+t+")":"ForwardRef"),t;case Kp:return e=t.displayName||null,e!==null?e:cf(t.type)||"Memo";case Mr:e=t._payload,t=t._init;try{return cf(t(e))}catch{}}return null}function eR(t){var e=t.type;switch(t.tag){case 24:return"Cache";case 9:return(e.displayName||"Context")+".Consumer";case 10:return(e._context.displayName||"Context")+".Provider";case 18:return"DehydratedFragment";case 11:return t=e.render,t=t.displayName||t.name||"",e.displayName||(t!==""?"ForwardRef("+t+")":"ForwardRef");case 7:return"Fragment";case 5:return e;case 4:return"Portal";case 3:return"Root";case 6:return"Text";case 16:return cf(e);case 8:return e===Hp?"StrictMode":"Mode";case 22:return"Offscreen";case 12:return"Profiler";case 21:return"Scope";case 13:return"Suspense";case 19:return"SuspenseList";case 25:return"TracingMarker";case 1:case 0:case 17:case 2:case 14:case 15:if(typeof e=="function")return e.displayName||e.name||null;if(typeof e=="string")return e}return null}function li(t){switch(typeof t){case"boolean":case"number":case"string":case"undefined":return t;case"object":return t;default:return""}}function Kw(t){var e=t.type;return(t=t.nodeName)&&t.toLowerCase()==="input"&&(e==="checkbox"||e==="radio")}function tR(t){var e=Kw(t)?"checked":"value",n=Object.getOwnPropertyDescriptor(t.constructor.prototype,e),r=""+t[e];if(!t.hasOwnProperty(e)&&typeof n<"u"&&typeof n.get=="function"&&typeof n.set=="function"){var i=n.get,s=n.set;return Object.defineProperty(t,e,{configurable:!0,get:function(){return i.call(this)},set:function(o){r=""+o,s.call(this,o)}}),Object.defineProperty(t,e,{enumerable:n.enumerable}),{getValue:function(){return r},setValue:function(o){r=""+o},stopTracking:function(){t._valueTracker=null,delete t[e]}}}}function ru(t){t._valueTracker||(t._valueTracker=tR(t))}function Qw(t){if(!t)return!1;var e=t._valueTracker;if(!e)return!0;var n=e.getValue(),r="";return t&&(r=Kw(t)?t.checked?"true":"false":t.value),t=r,t!==n?(e.setValue(t),!0):!1}function Zu(t){if(t=t||(typeof document<"u"?document:void 0),typeof t>"u")return null;try{return t.activeElement||t.body}catch{return t.body}}function hf(t,e){var n=e.checked;return Ge({},e,{defaultChecked:void 0,defaultValue:void 0,value:void 0,checked:n??t._wrapperState.initialChecked})}function fy(t,e){var n=e.defaultValue==null?"":e.defaultValue,r=e.checked!=null?e.checked:e.defaultChecked;n=li(e.value!=null?e.value:n),t._wrapperState={initialChecked:r,initialValue:n,controlled:e.type==="checkbox"||e.type==="radio"?e.checked!=null:e.value!=null}}function Yw(t,e){e=e.checked,e!=null&&qp(t,"checked",e,!1)}function df(t,e){Yw(t,e);var n=li(e.value),r=e.type;if(n!=null)r==="number"?(n===0&&t.value===""||t.value!=n)&&(t.value=""+n):t.value!==""+n&&(t.value=""+n);else if(r==="submit"||r==="reset"){t.removeAttribute("value");return}e.hasOwnProperty("value")?ff(t,e.type,n):e.hasOwnProperty("defaultValue")&&ff(t,e.type,li(e.defaultValue)),e.checked==null&&e.defaultChecked!=null&&(t.defaultChecked=!!e.defaultChecked)}function py(t,e,n){if(e.hasOwnProperty("value")||e.hasOwnProperty("defaultValue")){var r=e.type;if(!(r!=="submit"&&r!=="reset"||e.value!==void 0&&e.value!==null))return;e=""+t._wrapperState.initialValue,n||e===t.value||(t.value=e),t.defaultValue=e}n=t.name,n!==""&&(t.name=""),t.defaultChecked=!!t._wrapperState.initialChecked,n!==""&&(t.name=n)}function ff(t,e,n){(e!=="number"||Zu(t.ownerDocument)!==t)&&(n==null?t.defaultValue=""+t._wrapperState.initialValue:t.defaultValue!==""+n&&(t.defaultValue=""+n))}var la=Array.isArray;function Ls(t,e,n,r){if(t=t.options,e){e={};for(var i=0;i<n.length;i++)e["$"+n[i]]=!0;for(n=0;n<t.length;n++)i=e.hasOwnProperty("$"+t[n].value),t[n].selected!==i&&(t[n].selected=i),i&&r&&(t[n].defaultSelected=!0)}else{for(n=""+li(n),e=null,i=0;i<t.length;i++){if(t[i].value===n){t[i].selected=!0,r&&(t[i].defaultSelected=!0);return}e!==null||t[i].disabled||(e=t[i])}e!==null&&(e.selected=!0)}}function pf(t,e){if(e.dangerouslySetInnerHTML!=null)throw Error(B(91));return Ge({},e,{value:void 0,defaultValue:void 0,children:""+t._wrapperState.initialValue})}function my(t,e){var n=e.value;if(n==null){if(n=e.children,e=e.defaultValue,n!=null){if(e!=null)throw Error(B(92));if(la(n)){if(1<n.length)throw Error(B(93));n=n[0]}e=n}e==null&&(e=""),n=e}t._wrapperState={initialValue:li(n)}}function Xw(t,e){var n=li(e.value),r=li(e.defaultValue);n!=null&&(n=""+n,n!==t.value&&(t.value=n),e.defaultValue==null&&t.defaultValue!==n&&(t.defaultValue=n)),r!=null&&(t.defaultValue=""+r)}function gy(t){var e=t.textContent;e===t._wrapperState.initialValue&&e!==""&&e!==null&&(t.value=e)}function Jw(t){switch(t){case"svg":return"http://www.w3.org/2000/svg";case"math":return"http://www.w3.org/1998/Math/MathML";default:return"http://www.w3.org/1999/xhtml"}}function mf(t,e){return t==null||t==="http://www.w3.org/1999/xhtml"?Jw(e):t==="http://www.w3.org/2000/svg"&&e==="foreignObject"?"http://www.w3.org/1999/xhtml":t}var iu,Zw=function(t){return typeof MSApp<"u"&&MSApp.execUnsafeLocalFunction?function(e,n,r,i){MSApp.execUnsafeLocalFunction(function(){return t(e,n,r,i)})}:t}(function(t,e){if(t.namespaceURI!=="http://www.w3.org/2000/svg"||"innerHTML"in t)t.innerHTML=e;else{for(iu=iu||document.createElement("div"),iu.innerHTML="<svg>"+e.valueOf().toString()+"</svg>",e=iu.firstChild;t.firstChild;)t.removeChild(t.firstChild);for(;e.firstChild;)t.appendChild(e.firstChild)}});function Va(t,e){if(e){var n=t.firstChild;if(n&&n===t.lastChild&&n.nodeType===3){n.nodeValue=e;return}}t.textContent=e}var ma={animationIterationCount:!0,aspectRatio:!0,borderImageOutset:!0,borderImageSlice:!0,borderImageWidth:!0,boxFlex:!0,boxFlexGroup:!0,boxOrdinalGroup:!0,columnCount:!0,columns:!0,flex:!0,flexGrow:!0,flexPositive:!0,flexShrink:!0,flexNegative:!0,flexOrder:!0,gridArea:!0,gridRow:!0,gridRowEnd:!0,gridRowSpan:!0,gridRowStart:!0,gridColumn:!0,gridColumnEnd:!0,gridColumnSpan:!0,gridColumnStart:!0,fontWeight:!0,lineClamp:!0,lineHeight:!0,opacity:!0,order:!0,orphans:!0,tabSize:!0,widows:!0,zIndex:!0,zoom:!0,fillOpacity:!0,floodOpacity:!0,stopOpacity:!0,strokeDasharray:!0,strokeDashoffset:!0,strokeMiterlimit:!0,strokeOpacity:!0,strokeWidth:!0},nR=["Webkit","ms","Moz","O"];Object.keys(ma).forEach(function(t){nR.forEach(function(e){e=e+t.charAt(0).toUpperCase()+t.substring(1),ma[e]=ma[t]})});function eE(t,e,n){return e==null||typeof e=="boolean"||e===""?"":n||typeof e!="number"||e===0||ma.hasOwnProperty(t)&&ma[t]?(""+e).trim():e+"px"}function tE(t,e){t=t.style;for(var n in e)if(e.hasOwnProperty(n)){var r=n.indexOf("--")===0,i=eE(n,e[n],r);n==="float"&&(n="cssFloat"),r?t.setProperty(n,i):t[n]=i}}var rR=Ge({menuitem:!0},{area:!0,base:!0,br:!0,col:!0,embed:!0,hr:!0,img:!0,input:!0,keygen:!0,link:!0,meta:!0,param:!0,source:!0,track:!0,wbr:!0});function gf(t,e){if(e){if(rR[t]&&(e.children!=null||e.dangerouslySetInnerHTML!=null))throw Error(B(137,t));if(e.dangerouslySetInnerHTML!=null){if(e.children!=null)throw Error(B(60));if(typeof e.dangerouslySetInnerHTML!="object"||!("__html"in e.dangerouslySetInnerHTML))throw Error(B(61))}if(e.style!=null&&typeof e.style!="object")throw Error(B(62))}}function _f(t,e){if(t.indexOf("-")===-1)return typeof e.is=="string";switch(t){case"annotation-xml":case"color-profile":case"font-face":case"font-face-src":case"font-face-uri":case"font-face-format":case"font-face-name":case"missing-glyph":return!1;default:return!0}}var yf=null;function Qp(t){return t=t.target||t.srcElement||window,t.correspondingUseElement&&(t=t.correspondingUseElement),t.nodeType===3?t.parentNode:t}var vf=null,Fs=null,Vs=null;function _y(t){if(t=yl(t)){if(typeof vf!="function")throw Error(B(280));var e=t.stateNode;e&&(e=ih(e),vf(t.stateNode,t.type,e))}}function nE(t){Fs?Vs?Vs.push(t):Vs=[t]:Fs=t}function rE(){if(Fs){var t=Fs,e=Vs;if(Vs=Fs=null,_y(t),e)for(t=0;t<e.length;t++)_y(e[t])}}function iE(t,e){return t(e)}function sE(){}var dd=!1;function oE(t,e,n){if(dd)return t(e,n);dd=!0;try{return iE(t,e,n)}finally{dd=!1,(Fs!==null||Vs!==null)&&(sE(),rE())}}function Ua(t,e){var n=t.stateNode;if(n===null)return null;var r=ih(n);if(r===null)return null;n=r[e];e:switch(e){case"onClick":case"onClickCapture":case"onDoubleClick":case"onDoubleClickCapture":case"onMouseDown":case"onMouseDownCapture":case"onMouseMove":case"onMouseMoveCapture":case"onMouseUp":case"onMouseUpCapture":case"onMouseEnter":(r=!r.disabled)||(t=t.type,r=!(t==="button"||t==="input"||t==="select"||t==="textarea")),t=!r;break e;default:t=!1}if(t)return null;if(n&&typeof n!="function")throw Error(B(231,e,typeof n));return n}var wf=!1;if(mr)try{var Ho={};Object.defineProperty(Ho,"passive",{get:function(){wf=!0}}),window.addEventListener("test",Ho,Ho),window.removeEventListener("test",Ho,Ho)}catch{wf=!1}function iR(t,e,n,r,i,s,o,a,u){var c=Array.prototype.slice.call(arguments,3);try{e.apply(n,c)}catch(h){this.onError(h)}}var ga=!1,ec=null,tc=!1,Ef=null,sR={onError:function(t){ga=!0,ec=t}};function oR(t,e,n,r,i,s,o,a,u){ga=!1,ec=null,iR.apply(sR,arguments)}function aR(t,e,n,r,i,s,o,a,u){if(oR.apply(this,arguments),ga){if(ga){var c=ec;ga=!1,ec=null}else throw Error(B(198));tc||(tc=!0,Ef=c)}}function ts(t){var e=t,n=t;if(t.alternate)for(;e.return;)e=e.return;else{t=e;do e=t,e.flags&4098&&(n=e.return),t=e.return;while(t)}return e.tag===3?n:null}function aE(t){if(t.tag===13){var e=t.memoizedState;if(e===null&&(t=t.alternate,t!==null&&(e=t.memoizedState)),e!==null)return e.dehydrated}return null}function yy(t){if(ts(t)!==t)throw Error(B(188))}function lR(t){var e=t.alternate;if(!e){if(e=ts(t),e===null)throw Error(B(188));return e!==t?null:t}for(var n=t,r=e;;){var i=n.return;if(i===null)break;var s=i.alternate;if(s===null){if(r=i.return,r!==null){n=r;continue}break}if(i.child===s.child){for(s=i.child;s;){if(s===n)return yy(i),t;if(s===r)return yy(i),e;s=s.sibling}throw Error(B(188))}if(n.return!==r.return)n=i,r=s;else{for(var o=!1,a=i.child;a;){if(a===n){o=!0,n=i,r=s;break}if(a===r){o=!0,r=i,n=s;break}a=a.sibling}if(!o){for(a=s.child;a;){if(a===n){o=!0,n=s,r=i;break}if(a===r){o=!0,r=s,n=i;break}a=a.sibling}if(!o)throw Error(B(189))}}if(n.alternate!==r)throw Error(B(190))}if(n.tag!==3)throw Error(B(188));return n.stateNode.current===n?t:e}function lE(t){return t=lR(t),t!==null?uE(t):null}function uE(t){if(t.tag===5||t.tag===6)return t;for(t=t.child;t!==null;){var e=uE(t);if(e!==null)return e;t=t.sibling}return null}var cE=cn.unstable_scheduleCallback,vy=cn.unstable_cancelCallback,uR=cn.unstable_shouldYield,cR=cn.unstable_requestPaint,tt=cn.unstable_now,hR=cn.unstable_getCurrentPriorityLevel,Yp=cn.unstable_ImmediatePriority,hE=cn.unstable_UserBlockingPriority,nc=cn.unstable_NormalPriority,dR=cn.unstable_LowPriority,dE=cn.unstable_IdlePriority,eh=null,qn=null;function fR(t){if(qn&&typeof qn.onCommitFiberRoot=="function")try{qn.onCommitFiberRoot(eh,t,void 0,(t.current.flags&128)===128)}catch{}}var Mn=Math.clz32?Math.clz32:gR,pR=Math.log,mR=Math.LN2;function gR(t){return t>>>=0,t===0?32:31-(pR(t)/mR|0)|0}var su=64,ou=4194304;function ua(t){switch(t&-t){case 1:return 1;case 2:return 2;case 4:return 4;case 8:return 8;case 16:return 16;case 32:return 32;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return t&4194240;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return t&130023424;case 134217728:return 134217728;case 268435456:return 268435456;case 536870912:return 536870912;case 1073741824:return 1073741824;default:return t}}function rc(t,e){var n=t.pendingLanes;if(n===0)return 0;var r=0,i=t.suspendedLanes,s=t.pingedLanes,o=n&268435455;if(o!==0){var a=o&~i;a!==0?r=ua(a):(s&=o,s!==0&&(r=ua(s)))}else o=n&~i,o!==0?r=ua(o):s!==0&&(r=ua(s));if(r===0)return 0;if(e!==0&&e!==r&&!(e&i)&&(i=r&-r,s=e&-e,i>=s||i===16&&(s&4194240)!==0))return e;if(r&4&&(r|=n&16),e=t.entangledLanes,e!==0)for(t=t.entanglements,e&=r;0<e;)n=31-Mn(e),i=1<<n,r|=t[n],e&=~i;return r}function _R(t,e){switch(t){case 1:case 2:case 4:return e+250;case 8:case 16:case 32:case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return e+5e3;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return-1;case 134217728:case 268435456:case 536870912:case 1073741824:return-1;default:return-1}}function yR(t,e){for(var n=t.suspendedLanes,r=t.pingedLanes,i=t.expirationTimes,s=t.pendingLanes;0<s;){var o=31-Mn(s),a=1<<o,u=i[o];u===-1?(!(a&n)||a&r)&&(i[o]=_R(a,e)):u<=e&&(t.expiredLanes|=a),s&=~a}}function Tf(t){return t=t.pendingLanes&-1073741825,t!==0?t:t&1073741824?1073741824:0}function fE(){var t=su;return su<<=1,!(su&4194240)&&(su=64),t}function fd(t){for(var e=[],n=0;31>n;n++)e.push(t);return e}function gl(t,e,n){t.pendingLanes|=e,e!==536870912&&(t.suspendedLanes=0,t.pingedLanes=0),t=t.eventTimes,e=31-Mn(e),t[e]=n}function vR(t,e){var n=t.pendingLanes&~e;t.pendingLanes=e,t.suspendedLanes=0,t.pingedLanes=0,t.expiredLanes&=e,t.mutableReadLanes&=e,t.entangledLanes&=e,e=t.entanglements;var r=t.eventTimes;for(t=t.expirationTimes;0<n;){var i=31-Mn(n),s=1<<i;e[i]=0,r[i]=-1,t[i]=-1,n&=~s}}function Xp(t,e){var n=t.entangledLanes|=e;for(t=t.entanglements;n;){var r=31-Mn(n),i=1<<r;i&e|t[r]&e&&(t[r]|=e),n&=~i}}var xe=0;function pE(t){return t&=-t,1<t?4<t?t&268435455?16:536870912:4:1}var mE,Jp,gE,_E,yE,If=!1,au=[],Gr=null,Kr=null,Qr=null,ja=new Map,za=new Map,Fr=[],wR="mousedown mouseup touchcancel touchend touchstart auxclick dblclick pointercancel pointerdown pointerup dragend dragstart drop compositionend compositionstart keydown keypress keyup input textInput copy cut paste click change contextmenu reset submit".split(" ");function wy(t,e){switch(t){case"focusin":case"focusout":Gr=null;break;case"dragenter":case"dragleave":Kr=null;break;case"mouseover":case"mouseout":Qr=null;break;case"pointerover":case"pointerout":ja.delete(e.pointerId);break;case"gotpointercapture":case"lostpointercapture":za.delete(e.pointerId)}}function Go(t,e,n,r,i,s){return t===null||t.nativeEvent!==s?(t={blockedOn:e,domEventName:n,eventSystemFlags:r,nativeEvent:s,targetContainers:[i]},e!==null&&(e=yl(e),e!==null&&Jp(e)),t):(t.eventSystemFlags|=r,e=t.targetContainers,i!==null&&e.indexOf(i)===-1&&e.push(i),t)}function ER(t,e,n,r,i){switch(e){case"focusin":return Gr=Go(Gr,t,e,n,r,i),!0;case"dragenter":return Kr=Go(Kr,t,e,n,r,i),!0;case"mouseover":return Qr=Go(Qr,t,e,n,r,i),!0;case"pointerover":var s=i.pointerId;return ja.set(s,Go(ja.get(s)||null,t,e,n,r,i)),!0;case"gotpointercapture":return s=i.pointerId,za.set(s,Go(za.get(s)||null,t,e,n,r,i)),!0}return!1}function vE(t){var e=bi(t.target);if(e!==null){var n=ts(e);if(n!==null){if(e=n.tag,e===13){if(e=aE(n),e!==null){t.blockedOn=e,yE(t.priority,function(){gE(n)});return}}else if(e===3&&n.stateNode.current.memoizedState.isDehydrated){t.blockedOn=n.tag===3?n.stateNode.containerInfo:null;return}}}t.blockedOn=null}function Nu(t){if(t.blockedOn!==null)return!1;for(var e=t.targetContainers;0<e.length;){var n=Sf(t.domEventName,t.eventSystemFlags,e[0],t.nativeEvent);if(n===null){n=t.nativeEvent;var r=new n.constructor(n.type,n);yf=r,n.target.dispatchEvent(r),yf=null}else return e=yl(n),e!==null&&Jp(e),t.blockedOn=n,!1;e.shift()}return!0}function Ey(t,e,n){Nu(t)&&n.delete(e)}function TR(){If=!1,Gr!==null&&Nu(Gr)&&(Gr=null),Kr!==null&&Nu(Kr)&&(Kr=null),Qr!==null&&Nu(Qr)&&(Qr=null),ja.forEach(Ey),za.forEach(Ey)}function Ko(t,e){t.blockedOn===e&&(t.blockedOn=null,If||(If=!0,cn.unstable_scheduleCallback(cn.unstable_NormalPriority,TR)))}function Ba(t){function e(i){return Ko(i,t)}if(0<au.length){Ko(au[0],t);for(var n=1;n<au.length;n++){var r=au[n];r.blockedOn===t&&(r.blockedOn=null)}}for(Gr!==null&&Ko(Gr,t),Kr!==null&&Ko(Kr,t),Qr!==null&&Ko(Qr,t),ja.forEach(e),za.forEach(e),n=0;n<Fr.length;n++)r=Fr[n],r.blockedOn===t&&(r.blockedOn=null);for(;0<Fr.length&&(n=Fr[0],n.blockedOn===null);)vE(n),n.blockedOn===null&&Fr.shift()}var Us=Rr.ReactCurrentBatchConfig,ic=!0;function IR(t,e,n,r){var i=xe,s=Us.transition;Us.transition=null;try{xe=1,Zp(t,e,n,r)}finally{xe=i,Us.transition=s}}function SR(t,e,n,r){var i=xe,s=Us.transition;Us.transition=null;try{xe=4,Zp(t,e,n,r)}finally{xe=i,Us.transition=s}}function Zp(t,e,n,r){if(ic){var i=Sf(t,e,n,r);if(i===null)Id(t,e,r,sc,n),wy(t,r);else if(ER(i,t,e,n,r))r.stopPropagation();else if(wy(t,r),e&4&&-1<wR.indexOf(t)){for(;i!==null;){var s=yl(i);if(s!==null&&mE(s),s=Sf(t,e,n,r),s===null&&Id(t,e,r,sc,n),s===i)break;i=s}i!==null&&r.stopPropagation()}else Id(t,e,r,null,n)}}var sc=null;function Sf(t,e,n,r){if(sc=null,t=Qp(r),t=bi(t),t!==null)if(e=ts(t),e===null)t=null;else if(n=e.tag,n===13){if(t=aE(e),t!==null)return t;t=null}else if(n===3){if(e.stateNode.current.memoizedState.isDehydrated)return e.tag===3?e.stateNode.containerInfo:null;t=null}else e!==t&&(t=null);return sc=t,null}function wE(t){switch(t){case"cancel":case"click":case"close":case"contextmenu":case"copy":case"cut":case"auxclick":case"dblclick":case"dragend":case"dragstart":case"drop":case"focusin":case"focusout":case"input":case"invalid":case"keydown":case"keypress":case"keyup":case"mousedown":case"mouseup":case"paste":case"pause":case"play":case"pointercancel":case"pointerdown":case"pointerup":case"ratechange":case"reset":case"resize":case"seeked":case"submit":case"touchcancel":case"touchend":case"touchstart":case"volumechange":case"change":case"selectionchange":case"textInput":case"compositionstart":case"compositionend":case"compositionupdate":case"beforeblur":case"afterblur":case"beforeinput":case"blur":case"fullscreenchange":case"focus":case"hashchange":case"popstate":case"select":case"selectstart":return 1;case"drag":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"mousemove":case"mouseout":case"mouseover":case"pointermove":case"pointerout":case"pointerover":case"scroll":case"toggle":case"touchmove":case"wheel":case"mouseenter":case"mouseleave":case"pointerenter":case"pointerleave":return 4;case"message":switch(hR()){case Yp:return 1;case hE:return 4;case nc:case dR:return 16;case dE:return 536870912;default:return 16}default:return 16}}var Wr=null,em=null,Du=null;function EE(){if(Du)return Du;var t,e=em,n=e.length,r,i="value"in Wr?Wr.value:Wr.textContent,s=i.length;for(t=0;t<n&&e[t]===i[t];t++);var o=n-t;for(r=1;r<=o&&e[n-r]===i[s-r];r++);return Du=i.slice(t,1<r?1-r:void 0)}function Ou(t){var e=t.keyCode;return"charCode"in t?(t=t.charCode,t===0&&e===13&&(t=13)):t=e,t===10&&(t=13),32<=t||t===13?t:0}function lu(){return!0}function Ty(){return!1}function dn(t){function e(n,r,i,s,o){this._reactName=n,this._targetInst=i,this.type=r,this.nativeEvent=s,this.target=o,this.currentTarget=null;for(var a in t)t.hasOwnProperty(a)&&(n=t[a],this[a]=n?n(s):s[a]);return this.isDefaultPrevented=(s.defaultPrevented!=null?s.defaultPrevented:s.returnValue===!1)?lu:Ty,this.isPropagationStopped=Ty,this}return Ge(e.prototype,{preventDefault:function(){this.defaultPrevented=!0;var n=this.nativeEvent;n&&(n.preventDefault?n.preventDefault():typeof n.returnValue!="unknown"&&(n.returnValue=!1),this.isDefaultPrevented=lu)},stopPropagation:function(){var n=this.nativeEvent;n&&(n.stopPropagation?n.stopPropagation():typeof n.cancelBubble!="unknown"&&(n.cancelBubble=!0),this.isPropagationStopped=lu)},persist:function(){},isPersistent:lu}),e}var mo={eventPhase:0,bubbles:0,cancelable:0,timeStamp:function(t){return t.timeStamp||Date.now()},defaultPrevented:0,isTrusted:0},tm=dn(mo),_l=Ge({},mo,{view:0,detail:0}),kR=dn(_l),pd,md,Qo,th=Ge({},_l,{screenX:0,screenY:0,clientX:0,clientY:0,pageX:0,pageY:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,getModifierState:nm,button:0,buttons:0,relatedTarget:function(t){return t.relatedTarget===void 0?t.fromElement===t.srcElement?t.toElement:t.fromElement:t.relatedTarget},movementX:function(t){return"movementX"in t?t.movementX:(t!==Qo&&(Qo&&t.type==="mousemove"?(pd=t.screenX-Qo.screenX,md=t.screenY-Qo.screenY):md=pd=0,Qo=t),pd)},movementY:function(t){return"movementY"in t?t.movementY:md}}),Iy=dn(th),CR=Ge({},th,{dataTransfer:0}),RR=dn(CR),xR=Ge({},_l,{relatedTarget:0}),gd=dn(xR),AR=Ge({},mo,{animationName:0,elapsedTime:0,pseudoElement:0}),bR=dn(AR),PR=Ge({},mo,{clipboardData:function(t){return"clipboardData"in t?t.clipboardData:window.clipboardData}}),NR=dn(PR),DR=Ge({},mo,{data:0}),Sy=dn(DR),OR={Esc:"Escape",Spacebar:" ",Left:"ArrowLeft",Up:"ArrowUp",Right:"ArrowRight",Down:"ArrowDown",Del:"Delete",Win:"OS",Menu:"ContextMenu",Apps:"ContextMenu",Scroll:"ScrollLock",MozPrintableKey:"Unidentified"},MR={8:"Backspace",9:"Tab",12:"Clear",13:"Enter",16:"Shift",17:"Control",18:"Alt",19:"Pause",20:"CapsLock",27:"Escape",32:" ",33:"PageUp",34:"PageDown",35:"End",36:"Home",37:"ArrowLeft",38:"ArrowUp",39:"ArrowRight",40:"ArrowDown",45:"Insert",46:"Delete",112:"F1",113:"F2",114:"F3",115:"F4",116:"F5",117:"F6",118:"F7",119:"F8",120:"F9",121:"F10",122:"F11",123:"F12",144:"NumLock",145:"ScrollLock",224:"Meta"},LR={Alt:"altKey",Control:"ctrlKey",Meta:"metaKey",Shift:"shiftKey"};function FR(t){var e=this.nativeEvent;return e.getModifierState?e.getModifierState(t):(t=LR[t])?!!e[t]:!1}function nm(){return FR}var VR=Ge({},_l,{key:function(t){if(t.key){var e=OR[t.key]||t.key;if(e!=="Unidentified")return e}return t.type==="keypress"?(t=Ou(t),t===13?"Enter":String.fromCharCode(t)):t.type==="keydown"||t.type==="keyup"?MR[t.keyCode]||"Unidentified":""},code:0,location:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,repeat:0,locale:0,getModifierState:nm,charCode:function(t){return t.type==="keypress"?Ou(t):0},keyCode:function(t){return t.type==="keydown"||t.type==="keyup"?t.keyCode:0},which:function(t){return t.type==="keypress"?Ou(t):t.type==="keydown"||t.type==="keyup"?t.keyCode:0}}),UR=dn(VR),jR=Ge({},th,{pointerId:0,width:0,height:0,pressure:0,tangentialPressure:0,tiltX:0,tiltY:0,twist:0,pointerType:0,isPrimary:0}),ky=dn(jR),zR=Ge({},_l,{touches:0,targetTouches:0,changedTouches:0,altKey:0,metaKey:0,ctrlKey:0,shiftKey:0,getModifierState:nm}),BR=dn(zR),$R=Ge({},mo,{propertyName:0,elapsedTime:0,pseudoElement:0}),WR=dn($R),qR=Ge({},th,{deltaX:function(t){return"deltaX"in t?t.deltaX:"wheelDeltaX"in t?-t.wheelDeltaX:0},deltaY:function(t){return"deltaY"in t?t.deltaY:"wheelDeltaY"in t?-t.wheelDeltaY:"wheelDelta"in t?-t.wheelDelta:0},deltaZ:0,deltaMode:0}),HR=dn(qR),GR=[9,13,27,32],rm=mr&&"CompositionEvent"in window,_a=null;mr&&"documentMode"in document&&(_a=document.documentMode);var KR=mr&&"TextEvent"in window&&!_a,TE=mr&&(!rm||_a&&8<_a&&11>=_a),Cy=" ",Ry=!1;function IE(t,e){switch(t){case"keyup":return GR.indexOf(e.keyCode)!==-1;case"keydown":return e.keyCode!==229;case"keypress":case"mousedown":case"focusout":return!0;default:return!1}}function SE(t){return t=t.detail,typeof t=="object"&&"data"in t?t.data:null}var Is=!1;function QR(t,e){switch(t){case"compositionend":return SE(e);case"keypress":return e.which!==32?null:(Ry=!0,Cy);case"textInput":return t=e.data,t===Cy&&Ry?null:t;default:return null}}function YR(t,e){if(Is)return t==="compositionend"||!rm&&IE(t,e)?(t=EE(),Du=em=Wr=null,Is=!1,t):null;switch(t){case"paste":return null;case"keypress":if(!(e.ctrlKey||e.altKey||e.metaKey)||e.ctrlKey&&e.altKey){if(e.char&&1<e.char.length)return e.char;if(e.which)return String.fromCharCode(e.which)}return null;case"compositionend":return TE&&e.locale!=="ko"?null:e.data;default:return null}}var XR={color:!0,date:!0,datetime:!0,"datetime-local":!0,email:!0,month:!0,number:!0,password:!0,range:!0,search:!0,tel:!0,text:!0,time:!0,url:!0,week:!0};function xy(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e==="input"?!!XR[t.type]:e==="textarea"}function kE(t,e,n,r){nE(r),e=oc(e,"onChange"),0<e.length&&(n=new tm("onChange","change",null,n,r),t.push({event:n,listeners:e}))}var ya=null,$a=null;function JR(t){LE(t,0)}function nh(t){var e=Cs(t);if(Qw(e))return t}function ZR(t,e){if(t==="change")return e}var CE=!1;if(mr){var _d;if(mr){var yd="oninput"in document;if(!yd){var Ay=document.createElement("div");Ay.setAttribute("oninput","return;"),yd=typeof Ay.oninput=="function"}_d=yd}else _d=!1;CE=_d&&(!document.documentMode||9<document.documentMode)}function by(){ya&&(ya.detachEvent("onpropertychange",RE),$a=ya=null)}function RE(t){if(t.propertyName==="value"&&nh($a)){var e=[];kE(e,$a,t,Qp(t)),oE(JR,e)}}function ex(t,e,n){t==="focusin"?(by(),ya=e,$a=n,ya.attachEvent("onpropertychange",RE)):t==="focusout"&&by()}function tx(t){if(t==="selectionchange"||t==="keyup"||t==="keydown")return nh($a)}function nx(t,e){if(t==="click")return nh(e)}function rx(t,e){if(t==="input"||t==="change")return nh(e)}function ix(t,e){return t===e&&(t!==0||1/t===1/e)||t!==t&&e!==e}var Vn=typeof Object.is=="function"?Object.is:ix;function Wa(t,e){if(Vn(t,e))return!0;if(typeof t!="object"||t===null||typeof e!="object"||e===null)return!1;var n=Object.keys(t),r=Object.keys(e);if(n.length!==r.length)return!1;for(r=0;r<n.length;r++){var i=n[r];if(!of.call(e,i)||!Vn(t[i],e[i]))return!1}return!0}function Py(t){for(;t&&t.firstChild;)t=t.firstChild;return t}function Ny(t,e){var n=Py(t);t=0;for(var r;n;){if(n.nodeType===3){if(r=t+n.textContent.length,t<=e&&r>=e)return{node:n,offset:e-t};t=r}e:{for(;n;){if(n.nextSibling){n=n.nextSibling;break e}n=n.parentNode}n=void 0}n=Py(n)}}function xE(t,e){return t&&e?t===e?!0:t&&t.nodeType===3?!1:e&&e.nodeType===3?xE(t,e.parentNode):"contains"in t?t.contains(e):t.compareDocumentPosition?!!(t.compareDocumentPosition(e)&16):!1:!1}function AE(){for(var t=window,e=Zu();e instanceof t.HTMLIFrameElement;){try{var n=typeof e.contentWindow.location.href=="string"}catch{n=!1}if(n)t=e.contentWindow;else break;e=Zu(t.document)}return e}function im(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e&&(e==="input"&&(t.type==="text"||t.type==="search"||t.type==="tel"||t.type==="url"||t.type==="password")||e==="textarea"||t.contentEditable==="true")}function sx(t){var e=AE(),n=t.focusedElem,r=t.selectionRange;if(e!==n&&n&&n.ownerDocument&&xE(n.ownerDocument.documentElement,n)){if(r!==null&&im(n)){if(e=r.start,t=r.end,t===void 0&&(t=e),"selectionStart"in n)n.selectionStart=e,n.selectionEnd=Math.min(t,n.value.length);else if(t=(e=n.ownerDocument||document)&&e.defaultView||window,t.getSelection){t=t.getSelection();var i=n.textContent.length,s=Math.min(r.start,i);r=r.end===void 0?s:Math.min(r.end,i),!t.extend&&s>r&&(i=r,r=s,s=i),i=Ny(n,s);var o=Ny(n,r);i&&o&&(t.rangeCount!==1||t.anchorNode!==i.node||t.anchorOffset!==i.offset||t.focusNode!==o.node||t.focusOffset!==o.offset)&&(e=e.createRange(),e.setStart(i.node,i.offset),t.removeAllRanges(),s>r?(t.addRange(e),t.extend(o.node,o.offset)):(e.setEnd(o.node,o.offset),t.addRange(e)))}}for(e=[],t=n;t=t.parentNode;)t.nodeType===1&&e.push({element:t,left:t.scrollLeft,top:t.scrollTop});for(typeof n.focus=="function"&&n.focus(),n=0;n<e.length;n++)t=e[n],t.element.scrollLeft=t.left,t.element.scrollTop=t.top}}var ox=mr&&"documentMode"in document&&11>=document.documentMode,Ss=null,kf=null,va=null,Cf=!1;function Dy(t,e,n){var r=n.window===n?n.document:n.nodeType===9?n:n.ownerDocument;Cf||Ss==null||Ss!==Zu(r)||(r=Ss,"selectionStart"in r&&im(r)?r={start:r.selectionStart,end:r.selectionEnd}:(r=(r.ownerDocument&&r.ownerDocument.defaultView||window).getSelection(),r={anchorNode:r.anchorNode,anchorOffset:r.anchorOffset,focusNode:r.focusNode,focusOffset:r.focusOffset}),va&&Wa(va,r)||(va=r,r=oc(kf,"onSelect"),0<r.length&&(e=new tm("onSelect","select",null,e,n),t.push({event:e,listeners:r}),e.target=Ss)))}function uu(t,e){var n={};return n[t.toLowerCase()]=e.toLowerCase(),n["Webkit"+t]="webkit"+e,n["Moz"+t]="moz"+e,n}var ks={animationend:uu("Animation","AnimationEnd"),animationiteration:uu("Animation","AnimationIteration"),animationstart:uu("Animation","AnimationStart"),transitionend:uu("Transition","TransitionEnd")},vd={},bE={};mr&&(bE=document.createElement("div").style,"AnimationEvent"in window||(delete ks.animationend.animation,delete ks.animationiteration.animation,delete ks.animationstart.animation),"TransitionEvent"in window||delete ks.transitionend.transition);function rh(t){if(vd[t])return vd[t];if(!ks[t])return t;var e=ks[t],n;for(n in e)if(e.hasOwnProperty(n)&&n in bE)return vd[t]=e[n];return t}var PE=rh("animationend"),NE=rh("animationiteration"),DE=rh("animationstart"),OE=rh("transitionend"),ME=new Map,Oy="abort auxClick cancel canPlay canPlayThrough click close contextMenu copy cut drag dragEnd dragEnter dragExit dragLeave dragOver dragStart drop durationChange emptied encrypted ended error gotPointerCapture input invalid keyDown keyPress keyUp load loadedData loadedMetadata loadStart lostPointerCapture mouseDown mouseMove mouseOut mouseOver mouseUp paste pause play playing pointerCancel pointerDown pointerMove pointerOut pointerOver pointerUp progress rateChange reset resize seeked seeking stalled submit suspend timeUpdate touchCancel touchEnd touchStart volumeChange scroll toggle touchMove waiting wheel".split(" ");function gi(t,e){ME.set(t,e),es(e,[t])}for(var wd=0;wd<Oy.length;wd++){var Ed=Oy[wd],ax=Ed.toLowerCase(),lx=Ed[0].toUpperCase()+Ed.slice(1);gi(ax,"on"+lx)}gi(PE,"onAnimationEnd");gi(NE,"onAnimationIteration");gi(DE,"onAnimationStart");gi("dblclick","onDoubleClick");gi("focusin","onFocus");gi("focusout","onBlur");gi(OE,"onTransitionEnd");Qs("onMouseEnter",["mouseout","mouseover"]);Qs("onMouseLeave",["mouseout","mouseover"]);Qs("onPointerEnter",["pointerout","pointerover"]);Qs("onPointerLeave",["pointerout","pointerover"]);es("onChange","change click focusin focusout input keydown keyup selectionchange".split(" "));es("onSelect","focusout contextmenu dragend focusin keydown keyup mousedown mouseup selectionchange".split(" "));es("onBeforeInput",["compositionend","keypress","textInput","paste"]);es("onCompositionEnd","compositionend focusout keydown keypress keyup mousedown".split(" "));es("onCompositionStart","compositionstart focusout keydown keypress keyup mousedown".split(" "));es("onCompositionUpdate","compositionupdate focusout keydown keypress keyup mousedown".split(" "));var ca="abort canplay canplaythrough durationchange emptied encrypted ended error loadeddata loadedmetadata loadstart pause play playing progress ratechange resize seeked seeking stalled suspend timeupdate volumechange waiting".split(" "),ux=new Set("cancel close invalid load scroll toggle".split(" ").concat(ca));function My(t,e,n){var r=t.type||"unknown-event";t.currentTarget=n,aR(r,e,void 0,t),t.currentTarget=null}function LE(t,e){e=(e&4)!==0;for(var n=0;n<t.length;n++){var r=t[n],i=r.event;r=r.listeners;e:{var s=void 0;if(e)for(var o=r.length-1;0<=o;o--){var a=r[o],u=a.instance,c=a.currentTarget;if(a=a.listener,u!==s&&i.isPropagationStopped())break e;My(i,a,c),s=u}else for(o=0;o<r.length;o++){if(a=r[o],u=a.instance,c=a.currentTarget,a=a.listener,u!==s&&i.isPropagationStopped())break e;My(i,a,c),s=u}}}if(tc)throw t=Ef,tc=!1,Ef=null,t}function Fe(t,e){var n=e[Pf];n===void 0&&(n=e[Pf]=new Set);var r=t+"__bubble";n.has(r)||(FE(e,t,2,!1),n.add(r))}function Td(t,e,n){var r=0;e&&(r|=4),FE(n,t,r,e)}var cu="_reactListening"+Math.random().toString(36).slice(2);function qa(t){if(!t[cu]){t[cu]=!0,Ww.forEach(function(n){n!=="selectionchange"&&(ux.has(n)||Td(n,!1,t),Td(n,!0,t))});var e=t.nodeType===9?t:t.ownerDocument;e===null||e[cu]||(e[cu]=!0,Td("selectionchange",!1,e))}}function FE(t,e,n,r){switch(wE(e)){case 1:var i=IR;break;case 4:i=SR;break;default:i=Zp}n=i.bind(null,e,n,t),i=void 0,!wf||e!=="touchstart"&&e!=="touchmove"&&e!=="wheel"||(i=!0),r?i!==void 0?t.addEventListener(e,n,{capture:!0,passive:i}):t.addEventListener(e,n,!0):i!==void 0?t.addEventListener(e,n,{passive:i}):t.addEventListener(e,n,!1)}function Id(t,e,n,r,i){var s=r;if(!(e&1)&&!(e&2)&&r!==null)e:for(;;){if(r===null)return;var o=r.tag;if(o===3||o===4){var a=r.stateNode.containerInfo;if(a===i||a.nodeType===8&&a.parentNode===i)break;if(o===4)for(o=r.return;o!==null;){var u=o.tag;if((u===3||u===4)&&(u=o.stateNode.containerInfo,u===i||u.nodeType===8&&u.parentNode===i))return;o=o.return}for(;a!==null;){if(o=bi(a),o===null)return;if(u=o.tag,u===5||u===6){r=s=o;continue e}a=a.parentNode}}r=r.return}oE(function(){var c=s,h=Qp(n),f=[];e:{var g=ME.get(t);if(g!==void 0){var v=tm,I=t;switch(t){case"keypress":if(Ou(n)===0)break e;case"keydown":case"keyup":v=UR;break;case"focusin":I="focus",v=gd;break;case"focusout":I="blur",v=gd;break;case"beforeblur":case"afterblur":v=gd;break;case"click":if(n.button===2)break e;case"auxclick":case"dblclick":case"mousedown":case"mousemove":case"mouseup":case"mouseout":case"mouseover":case"contextmenu":v=Iy;break;case"drag":case"dragend":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"dragstart":case"drop":v=RR;break;case"touchcancel":case"touchend":case"touchmove":case"touchstart":v=BR;break;case PE:case NE:case DE:v=bR;break;case OE:v=WR;break;case"scroll":v=kR;break;case"wheel":v=HR;break;case"copy":case"cut":case"paste":v=NR;break;case"gotpointercapture":case"lostpointercapture":case"pointercancel":case"pointerdown":case"pointermove":case"pointerout":case"pointerover":case"pointerup":v=ky}var N=(e&4)!==0,D=!N&&t==="scroll",C=N?g!==null?g+"Capture":null:g;N=[];for(var w=c,R;w!==null;){R=w;var M=R.stateNode;if(R.tag===5&&M!==null&&(R=M,C!==null&&(M=Ua(w,C),M!=null&&N.push(Ha(w,M,R)))),D)break;w=w.return}0<N.length&&(g=new v(g,I,null,n,h),f.push({event:g,listeners:N}))}}if(!(e&7)){e:{if(g=t==="mouseover"||t==="pointerover",v=t==="mouseout"||t==="pointerout",g&&n!==yf&&(I=n.relatedTarget||n.fromElement)&&(bi(I)||I[gr]))break e;if((v||g)&&(g=h.window===h?h:(g=h.ownerDocument)?g.defaultView||g.parentWindow:window,v?(I=n.relatedTarget||n.toElement,v=c,I=I?bi(I):null,I!==null&&(D=ts(I),I!==D||I.tag!==5&&I.tag!==6)&&(I=null)):(v=null,I=c),v!==I)){if(N=Iy,M="onMouseLeave",C="onMouseEnter",w="mouse",(t==="pointerout"||t==="pointerover")&&(N=ky,M="onPointerLeave",C="onPointerEnter",w="pointer"),D=v==null?g:Cs(v),R=I==null?g:Cs(I),g=new N(M,w+"leave",v,n,h),g.target=D,g.relatedTarget=R,M=null,bi(h)===c&&(N=new N(C,w+"enter",I,n,h),N.target=R,N.relatedTarget=D,M=N),D=M,v&&I)t:{for(N=v,C=I,w=0,R=N;R;R=ms(R))w++;for(R=0,M=C;M;M=ms(M))R++;for(;0<w-R;)N=ms(N),w--;for(;0<R-w;)C=ms(C),R--;for(;w--;){if(N===C||C!==null&&N===C.alternate)break t;N=ms(N),C=ms(C)}N=null}else N=null;v!==null&&Ly(f,g,v,N,!1),I!==null&&D!==null&&Ly(f,D,I,N,!0)}}e:{if(g=c?Cs(c):window,v=g.nodeName&&g.nodeName.toLowerCase(),v==="select"||v==="input"&&g.type==="file")var z=ZR;else if(xy(g))if(CE)z=rx;else{z=tx;var U=ex}else(v=g.nodeName)&&v.toLowerCase()==="input"&&(g.type==="checkbox"||g.type==="radio")&&(z=nx);if(z&&(z=z(t,c))){kE(f,z,n,h);break e}U&&U(t,g,c),t==="focusout"&&(U=g._wrapperState)&&U.controlled&&g.type==="number"&&ff(g,"number",g.value)}switch(U=c?Cs(c):window,t){case"focusin":(xy(U)||U.contentEditable==="true")&&(Ss=U,kf=c,va=null);break;case"focusout":va=kf=Ss=null;break;case"mousedown":Cf=!0;break;case"contextmenu":case"mouseup":case"dragend":Cf=!1,Dy(f,n,h);break;case"selectionchange":if(ox)break;case"keydown":case"keyup":Dy(f,n,h)}var E;if(rm)e:{switch(t){case"compositionstart":var y="onCompositionStart";break e;case"compositionend":y="onCompositionEnd";break e;case"compositionupdate":y="onCompositionUpdate";break e}y=void 0}else Is?IE(t,n)&&(y="onCompositionEnd"):t==="keydown"&&n.keyCode===229&&(y="onCompositionStart");y&&(TE&&n.locale!=="ko"&&(Is||y!=="onCompositionStart"?y==="onCompositionEnd"&&Is&&(E=EE()):(Wr=h,em="value"in Wr?Wr.value:Wr.textContent,Is=!0)),U=oc(c,y),0<U.length&&(y=new Sy(y,t,null,n,h),f.push({event:y,listeners:U}),E?y.data=E:(E=SE(n),E!==null&&(y.data=E)))),(E=KR?QR(t,n):YR(t,n))&&(c=oc(c,"onBeforeInput"),0<c.length&&(h=new Sy("onBeforeInput","beforeinput",null,n,h),f.push({event:h,listeners:c}),h.data=E))}LE(f,e)})}function Ha(t,e,n){return{instance:t,listener:e,currentTarget:n}}function oc(t,e){for(var n=e+"Capture",r=[];t!==null;){var i=t,s=i.stateNode;i.tag===5&&s!==null&&(i=s,s=Ua(t,n),s!=null&&r.unshift(Ha(t,s,i)),s=Ua(t,e),s!=null&&r.push(Ha(t,s,i))),t=t.return}return r}function ms(t){if(t===null)return null;do t=t.return;while(t&&t.tag!==5);return t||null}function Ly(t,e,n,r,i){for(var s=e._reactName,o=[];n!==null&&n!==r;){var a=n,u=a.alternate,c=a.stateNode;if(u!==null&&u===r)break;a.tag===5&&c!==null&&(a=c,i?(u=Ua(n,s),u!=null&&o.unshift(Ha(n,u,a))):i||(u=Ua(n,s),u!=null&&o.push(Ha(n,u,a)))),n=n.return}o.length!==0&&t.push({event:e,listeners:o})}var cx=/\r\n?/g,hx=/\u0000|\uFFFD/g;function Fy(t){return(typeof t=="string"?t:""+t).replace(cx,`
`).replace(hx,"")}function hu(t,e,n){if(e=Fy(e),Fy(t)!==e&&n)throw Error(B(425))}function ac(){}var Rf=null,xf=null;function Af(t,e){return t==="textarea"||t==="noscript"||typeof e.children=="string"||typeof e.children=="number"||typeof e.dangerouslySetInnerHTML=="object"&&e.dangerouslySetInnerHTML!==null&&e.dangerouslySetInnerHTML.__html!=null}var bf=typeof setTimeout=="function"?setTimeout:void 0,dx=typeof clearTimeout=="function"?clearTimeout:void 0,Vy=typeof Promise=="function"?Promise:void 0,fx=typeof queueMicrotask=="function"?queueMicrotask:typeof Vy<"u"?function(t){return Vy.resolve(null).then(t).catch(px)}:bf;function px(t){setTimeout(function(){throw t})}function Sd(t,e){var n=e,r=0;do{var i=n.nextSibling;if(t.removeChild(n),i&&i.nodeType===8)if(n=i.data,n==="/$"){if(r===0){t.removeChild(i),Ba(e);return}r--}else n!=="$"&&n!=="$?"&&n!=="$!"||r++;n=i}while(n);Ba(e)}function Yr(t){for(;t!=null;t=t.nextSibling){var e=t.nodeType;if(e===1||e===3)break;if(e===8){if(e=t.data,e==="$"||e==="$!"||e==="$?")break;if(e==="/$")return null}}return t}function Uy(t){t=t.previousSibling;for(var e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="$"||n==="$!"||n==="$?"){if(e===0)return t;e--}else n==="/$"&&e++}t=t.previousSibling}return null}var go=Math.random().toString(36).slice(2),Bn="__reactFiber$"+go,Ga="__reactProps$"+go,gr="__reactContainer$"+go,Pf="__reactEvents$"+go,mx="__reactListeners$"+go,gx="__reactHandles$"+go;function bi(t){var e=t[Bn];if(e)return e;for(var n=t.parentNode;n;){if(e=n[gr]||n[Bn]){if(n=e.alternate,e.child!==null||n!==null&&n.child!==null)for(t=Uy(t);t!==null;){if(n=t[Bn])return n;t=Uy(t)}return e}t=n,n=t.parentNode}return null}function yl(t){return t=t[Bn]||t[gr],!t||t.tag!==5&&t.tag!==6&&t.tag!==13&&t.tag!==3?null:t}function Cs(t){if(t.tag===5||t.tag===6)return t.stateNode;throw Error(B(33))}function ih(t){return t[Ga]||null}var Nf=[],Rs=-1;function _i(t){return{current:t}}function ze(t){0>Rs||(t.current=Nf[Rs],Nf[Rs]=null,Rs--)}function Me(t,e){Rs++,Nf[Rs]=t.current,t.current=e}var ui={},Ut=_i(ui),Zt=_i(!1),ji=ui;function Ys(t,e){var n=t.type.contextTypes;if(!n)return ui;var r=t.stateNode;if(r&&r.__reactInternalMemoizedUnmaskedChildContext===e)return r.__reactInternalMemoizedMaskedChildContext;var i={},s;for(s in n)i[s]=e[s];return r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=e,t.__reactInternalMemoizedMaskedChildContext=i),i}function en(t){return t=t.childContextTypes,t!=null}function lc(){ze(Zt),ze(Ut)}function jy(t,e,n){if(Ut.current!==ui)throw Error(B(168));Me(Ut,e),Me(Zt,n)}function VE(t,e,n){var r=t.stateNode;if(e=e.childContextTypes,typeof r.getChildContext!="function")return n;r=r.getChildContext();for(var i in r)if(!(i in e))throw Error(B(108,eR(t)||"Unknown",i));return Ge({},n,r)}function uc(t){return t=(t=t.stateNode)&&t.__reactInternalMemoizedMergedChildContext||ui,ji=Ut.current,Me(Ut,t),Me(Zt,Zt.current),!0}function zy(t,e,n){var r=t.stateNode;if(!r)throw Error(B(169));n?(t=VE(t,e,ji),r.__reactInternalMemoizedMergedChildContext=t,ze(Zt),ze(Ut),Me(Ut,t)):ze(Zt),Me(Zt,n)}var ir=null,sh=!1,kd=!1;function UE(t){ir===null?ir=[t]:ir.push(t)}function _x(t){sh=!0,UE(t)}function yi(){if(!kd&&ir!==null){kd=!0;var t=0,e=xe;try{var n=ir;for(xe=1;t<n.length;t++){var r=n[t];do r=r(!0);while(r!==null)}ir=null,sh=!1}catch(i){throw ir!==null&&(ir=ir.slice(t+1)),cE(Yp,yi),i}finally{xe=e,kd=!1}}return null}var xs=[],As=0,cc=null,hc=0,pn=[],mn=0,zi=null,sr=1,or="";function ki(t,e){xs[As++]=hc,xs[As++]=cc,cc=t,hc=e}function jE(t,e,n){pn[mn++]=sr,pn[mn++]=or,pn[mn++]=zi,zi=t;var r=sr;t=or;var i=32-Mn(r)-1;r&=~(1<<i),n+=1;var s=32-Mn(e)+i;if(30<s){var o=i-i%5;s=(r&(1<<o)-1).toString(32),r>>=o,i-=o,sr=1<<32-Mn(e)+i|n<<i|r,or=s+t}else sr=1<<s|n<<i|r,or=t}function sm(t){t.return!==null&&(ki(t,1),jE(t,1,0))}function om(t){for(;t===cc;)cc=xs[--As],xs[As]=null,hc=xs[--As],xs[As]=null;for(;t===zi;)zi=pn[--mn],pn[mn]=null,or=pn[--mn],pn[mn]=null,sr=pn[--mn],pn[mn]=null}var un=null,an=null,We=!1,Pn=null;function zE(t,e){var n=_n(5,null,null,0);n.elementType="DELETED",n.stateNode=e,n.return=t,e=t.deletions,e===null?(t.deletions=[n],t.flags|=16):e.push(n)}function By(t,e){switch(t.tag){case 5:var n=t.type;return e=e.nodeType!==1||n.toLowerCase()!==e.nodeName.toLowerCase()?null:e,e!==null?(t.stateNode=e,un=t,an=Yr(e.firstChild),!0):!1;case 6:return e=t.pendingProps===""||e.nodeType!==3?null:e,e!==null?(t.stateNode=e,un=t,an=null,!0):!1;case 13:return e=e.nodeType!==8?null:e,e!==null?(n=zi!==null?{id:sr,overflow:or}:null,t.memoizedState={dehydrated:e,treeContext:n,retryLane:1073741824},n=_n(18,null,null,0),n.stateNode=e,n.return=t,t.child=n,un=t,an=null,!0):!1;default:return!1}}function Df(t){return(t.mode&1)!==0&&(t.flags&128)===0}function Of(t){if(We){var e=an;if(e){var n=e;if(!By(t,e)){if(Df(t))throw Error(B(418));e=Yr(n.nextSibling);var r=un;e&&By(t,e)?zE(r,n):(t.flags=t.flags&-4097|2,We=!1,un=t)}}else{if(Df(t))throw Error(B(418));t.flags=t.flags&-4097|2,We=!1,un=t}}}function $y(t){for(t=t.return;t!==null&&t.tag!==5&&t.tag!==3&&t.tag!==13;)t=t.return;un=t}function du(t){if(t!==un)return!1;if(!We)return $y(t),We=!0,!1;var e;if((e=t.tag!==3)&&!(e=t.tag!==5)&&(e=t.type,e=e!=="head"&&e!=="body"&&!Af(t.type,t.memoizedProps)),e&&(e=an)){if(Df(t))throw BE(),Error(B(418));for(;e;)zE(t,e),e=Yr(e.nextSibling)}if($y(t),t.tag===13){if(t=t.memoizedState,t=t!==null?t.dehydrated:null,!t)throw Error(B(317));e:{for(t=t.nextSibling,e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="/$"){if(e===0){an=Yr(t.nextSibling);break e}e--}else n!=="$"&&n!=="$!"&&n!=="$?"||e++}t=t.nextSibling}an=null}}else an=un?Yr(t.stateNode.nextSibling):null;return!0}function BE(){for(var t=an;t;)t=Yr(t.nextSibling)}function Xs(){an=un=null,We=!1}function am(t){Pn===null?Pn=[t]:Pn.push(t)}var yx=Rr.ReactCurrentBatchConfig;function Yo(t,e,n){if(t=n.ref,t!==null&&typeof t!="function"&&typeof t!="object"){if(n._owner){if(n=n._owner,n){if(n.tag!==1)throw Error(B(309));var r=n.stateNode}if(!r)throw Error(B(147,t));var i=r,s=""+t;return e!==null&&e.ref!==null&&typeof e.ref=="function"&&e.ref._stringRef===s?e.ref:(e=function(o){var a=i.refs;o===null?delete a[s]:a[s]=o},e._stringRef=s,e)}if(typeof t!="string")throw Error(B(284));if(!n._owner)throw Error(B(290,t))}return t}function fu(t,e){throw t=Object.prototype.toString.call(e),Error(B(31,t==="[object Object]"?"object with keys {"+Object.keys(e).join(", ")+"}":t))}function Wy(t){var e=t._init;return e(t._payload)}function $E(t){function e(C,w){if(t){var R=C.deletions;R===null?(C.deletions=[w],C.flags|=16):R.push(w)}}function n(C,w){if(!t)return null;for(;w!==null;)e(C,w),w=w.sibling;return null}function r(C,w){for(C=new Map;w!==null;)w.key!==null?C.set(w.key,w):C.set(w.index,w),w=w.sibling;return C}function i(C,w){return C=ei(C,w),C.index=0,C.sibling=null,C}function s(C,w,R){return C.index=R,t?(R=C.alternate,R!==null?(R=R.index,R<w?(C.flags|=2,w):R):(C.flags|=2,w)):(C.flags|=1048576,w)}function o(C){return t&&C.alternate===null&&(C.flags|=2),C}function a(C,w,R,M){return w===null||w.tag!==6?(w=Nd(R,C.mode,M),w.return=C,w):(w=i(w,R),w.return=C,w)}function u(C,w,R,M){var z=R.type;return z===Ts?h(C,w,R.props.children,M,R.key):w!==null&&(w.elementType===z||typeof z=="object"&&z!==null&&z.$$typeof===Mr&&Wy(z)===w.type)?(M=i(w,R.props),M.ref=Yo(C,w,R),M.return=C,M):(M=zu(R.type,R.key,R.props,null,C.mode,M),M.ref=Yo(C,w,R),M.return=C,M)}function c(C,w,R,M){return w===null||w.tag!==4||w.stateNode.containerInfo!==R.containerInfo||w.stateNode.implementation!==R.implementation?(w=Dd(R,C.mode,M),w.return=C,w):(w=i(w,R.children||[]),w.return=C,w)}function h(C,w,R,M,z){return w===null||w.tag!==7?(w=Fi(R,C.mode,M,z),w.return=C,w):(w=i(w,R),w.return=C,w)}function f(C,w,R){if(typeof w=="string"&&w!==""||typeof w=="number")return w=Nd(""+w,C.mode,R),w.return=C,w;if(typeof w=="object"&&w!==null){switch(w.$$typeof){case nu:return R=zu(w.type,w.key,w.props,null,C.mode,R),R.ref=Yo(C,null,w),R.return=C,R;case Es:return w=Dd(w,C.mode,R),w.return=C,w;case Mr:var M=w._init;return f(C,M(w._payload),R)}if(la(w)||qo(w))return w=Fi(w,C.mode,R,null),w.return=C,w;fu(C,w)}return null}function g(C,w,R,M){var z=w!==null?w.key:null;if(typeof R=="string"&&R!==""||typeof R=="number")return z!==null?null:a(C,w,""+R,M);if(typeof R=="object"&&R!==null){switch(R.$$typeof){case nu:return R.key===z?u(C,w,R,M):null;case Es:return R.key===z?c(C,w,R,M):null;case Mr:return z=R._init,g(C,w,z(R._payload),M)}if(la(R)||qo(R))return z!==null?null:h(C,w,R,M,null);fu(C,R)}return null}function v(C,w,R,M,z){if(typeof M=="string"&&M!==""||typeof M=="number")return C=C.get(R)||null,a(w,C,""+M,z);if(typeof M=="object"&&M!==null){switch(M.$$typeof){case nu:return C=C.get(M.key===null?R:M.key)||null,u(w,C,M,z);case Es:return C=C.get(M.key===null?R:M.key)||null,c(w,C,M,z);case Mr:var U=M._init;return v(C,w,R,U(M._payload),z)}if(la(M)||qo(M))return C=C.get(R)||null,h(w,C,M,z,null);fu(w,M)}return null}function I(C,w,R,M){for(var z=null,U=null,E=w,y=w=0,T=null;E!==null&&y<R.length;y++){E.index>y?(T=E,E=null):T=E.sibling;var x=g(C,E,R[y],M);if(x===null){E===null&&(E=T);break}t&&E&&x.alternate===null&&e(C,E),w=s(x,w,y),U===null?z=x:U.sibling=x,U=x,E=T}if(y===R.length)return n(C,E),We&&ki(C,y),z;if(E===null){for(;y<R.length;y++)E=f(C,R[y],M),E!==null&&(w=s(E,w,y),U===null?z=E:U.sibling=E,U=E);return We&&ki(C,y),z}for(E=r(C,E);y<R.length;y++)T=v(E,C,y,R[y],M),T!==null&&(t&&T.alternate!==null&&E.delete(T.key===null?y:T.key),w=s(T,w,y),U===null?z=T:U.sibling=T,U=T);return t&&E.forEach(function(b){return e(C,b)}),We&&ki(C,y),z}function N(C,w,R,M){var z=qo(R);if(typeof z!="function")throw Error(B(150));if(R=z.call(R),R==null)throw Error(B(151));for(var U=z=null,E=w,y=w=0,T=null,x=R.next();E!==null&&!x.done;y++,x=R.next()){E.index>y?(T=E,E=null):T=E.sibling;var b=g(C,E,x.value,M);if(b===null){E===null&&(E=T);break}t&&E&&b.alternate===null&&e(C,E),w=s(b,w,y),U===null?z=b:U.sibling=b,U=b,E=T}if(x.done)return n(C,E),We&&ki(C,y),z;if(E===null){for(;!x.done;y++,x=R.next())x=f(C,x.value,M),x!==null&&(w=s(x,w,y),U===null?z=x:U.sibling=x,U=x);return We&&ki(C,y),z}for(E=r(C,E);!x.done;y++,x=R.next())x=v(E,C,y,x.value,M),x!==null&&(t&&x.alternate!==null&&E.delete(x.key===null?y:x.key),w=s(x,w,y),U===null?z=x:U.sibling=x,U=x);return t&&E.forEach(function(k){return e(C,k)}),We&&ki(C,y),z}function D(C,w,R,M){if(typeof R=="object"&&R!==null&&R.type===Ts&&R.key===null&&(R=R.props.children),typeof R=="object"&&R!==null){switch(R.$$typeof){case nu:e:{for(var z=R.key,U=w;U!==null;){if(U.key===z){if(z=R.type,z===Ts){if(U.tag===7){n(C,U.sibling),w=i(U,R.props.children),w.return=C,C=w;break e}}else if(U.elementType===z||typeof z=="object"&&z!==null&&z.$$typeof===Mr&&Wy(z)===U.type){n(C,U.sibling),w=i(U,R.props),w.ref=Yo(C,U,R),w.return=C,C=w;break e}n(C,U);break}else e(C,U);U=U.sibling}R.type===Ts?(w=Fi(R.props.children,C.mode,M,R.key),w.return=C,C=w):(M=zu(R.type,R.key,R.props,null,C.mode,M),M.ref=Yo(C,w,R),M.return=C,C=M)}return o(C);case Es:e:{for(U=R.key;w!==null;){if(w.key===U)if(w.tag===4&&w.stateNode.containerInfo===R.containerInfo&&w.stateNode.implementation===R.implementation){n(C,w.sibling),w=i(w,R.children||[]),w.return=C,C=w;break e}else{n(C,w);break}else e(C,w);w=w.sibling}w=Dd(R,C.mode,M),w.return=C,C=w}return o(C);case Mr:return U=R._init,D(C,w,U(R._payload),M)}if(la(R))return I(C,w,R,M);if(qo(R))return N(C,w,R,M);fu(C,R)}return typeof R=="string"&&R!==""||typeof R=="number"?(R=""+R,w!==null&&w.tag===6?(n(C,w.sibling),w=i(w,R),w.return=C,C=w):(n(C,w),w=Nd(R,C.mode,M),w.return=C,C=w),o(C)):n(C,w)}return D}var Js=$E(!0),WE=$E(!1),dc=_i(null),fc=null,bs=null,lm=null;function um(){lm=bs=fc=null}function cm(t){var e=dc.current;ze(dc),t._currentValue=e}function Mf(t,e,n){for(;t!==null;){var r=t.alternate;if((t.childLanes&e)!==e?(t.childLanes|=e,r!==null&&(r.childLanes|=e)):r!==null&&(r.childLanes&e)!==e&&(r.childLanes|=e),t===n)break;t=t.return}}function js(t,e){fc=t,lm=bs=null,t=t.dependencies,t!==null&&t.firstContext!==null&&(t.lanes&e&&(Xt=!0),t.firstContext=null)}function Sn(t){var e=t._currentValue;if(lm!==t)if(t={context:t,memoizedValue:e,next:null},bs===null){if(fc===null)throw Error(B(308));bs=t,fc.dependencies={lanes:0,firstContext:t}}else bs=bs.next=t;return e}var Pi=null;function hm(t){Pi===null?Pi=[t]:Pi.push(t)}function qE(t,e,n,r){var i=e.interleaved;return i===null?(n.next=n,hm(e)):(n.next=i.next,i.next=n),e.interleaved=n,_r(t,r)}function _r(t,e){t.lanes|=e;var n=t.alternate;for(n!==null&&(n.lanes|=e),n=t,t=t.return;t!==null;)t.childLanes|=e,n=t.alternate,n!==null&&(n.childLanes|=e),n=t,t=t.return;return n.tag===3?n.stateNode:null}var Lr=!1;function dm(t){t.updateQueue={baseState:t.memoizedState,firstBaseUpdate:null,lastBaseUpdate:null,shared:{pending:null,interleaved:null,lanes:0},effects:null}}function HE(t,e){t=t.updateQueue,e.updateQueue===t&&(e.updateQueue={baseState:t.baseState,firstBaseUpdate:t.firstBaseUpdate,lastBaseUpdate:t.lastBaseUpdate,shared:t.shared,effects:t.effects})}function dr(t,e){return{eventTime:t,lane:e,tag:0,payload:null,callback:null,next:null}}function Xr(t,e,n){var r=t.updateQueue;if(r===null)return null;if(r=r.shared,ve&2){var i=r.pending;return i===null?e.next=e:(e.next=i.next,i.next=e),r.pending=e,_r(t,n)}return i=r.interleaved,i===null?(e.next=e,hm(r)):(e.next=i.next,i.next=e),r.interleaved=e,_r(t,n)}function Mu(t,e,n){if(e=e.updateQueue,e!==null&&(e=e.shared,(n&4194240)!==0)){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Xp(t,n)}}function qy(t,e){var n=t.updateQueue,r=t.alternate;if(r!==null&&(r=r.updateQueue,n===r)){var i=null,s=null;if(n=n.firstBaseUpdate,n!==null){do{var o={eventTime:n.eventTime,lane:n.lane,tag:n.tag,payload:n.payload,callback:n.callback,next:null};s===null?i=s=o:s=s.next=o,n=n.next}while(n!==null);s===null?i=s=e:s=s.next=e}else i=s=e;n={baseState:r.baseState,firstBaseUpdate:i,lastBaseUpdate:s,shared:r.shared,effects:r.effects},t.updateQueue=n;return}t=n.lastBaseUpdate,t===null?n.firstBaseUpdate=e:t.next=e,n.lastBaseUpdate=e}function pc(t,e,n,r){var i=t.updateQueue;Lr=!1;var s=i.firstBaseUpdate,o=i.lastBaseUpdate,a=i.shared.pending;if(a!==null){i.shared.pending=null;var u=a,c=u.next;u.next=null,o===null?s=c:o.next=c,o=u;var h=t.alternate;h!==null&&(h=h.updateQueue,a=h.lastBaseUpdate,a!==o&&(a===null?h.firstBaseUpdate=c:a.next=c,h.lastBaseUpdate=u))}if(s!==null){var f=i.baseState;o=0,h=c=u=null,a=s;do{var g=a.lane,v=a.eventTime;if((r&g)===g){h!==null&&(h=h.next={eventTime:v,lane:0,tag:a.tag,payload:a.payload,callback:a.callback,next:null});e:{var I=t,N=a;switch(g=e,v=n,N.tag){case 1:if(I=N.payload,typeof I=="function"){f=I.call(v,f,g);break e}f=I;break e;case 3:I.flags=I.flags&-65537|128;case 0:if(I=N.payload,g=typeof I=="function"?I.call(v,f,g):I,g==null)break e;f=Ge({},f,g);break e;case 2:Lr=!0}}a.callback!==null&&a.lane!==0&&(t.flags|=64,g=i.effects,g===null?i.effects=[a]:g.push(a))}else v={eventTime:v,lane:g,tag:a.tag,payload:a.payload,callback:a.callback,next:null},h===null?(c=h=v,u=f):h=h.next=v,o|=g;if(a=a.next,a===null){if(a=i.shared.pending,a===null)break;g=a,a=g.next,g.next=null,i.lastBaseUpdate=g,i.shared.pending=null}}while(!0);if(h===null&&(u=f),i.baseState=u,i.firstBaseUpdate=c,i.lastBaseUpdate=h,e=i.shared.interleaved,e!==null){i=e;do o|=i.lane,i=i.next;while(i!==e)}else s===null&&(i.shared.lanes=0);$i|=o,t.lanes=o,t.memoizedState=f}}function Hy(t,e,n){if(t=e.effects,e.effects=null,t!==null)for(e=0;e<t.length;e++){var r=t[e],i=r.callback;if(i!==null){if(r.callback=null,r=n,typeof i!="function")throw Error(B(191,i));i.call(r)}}}var vl={},Hn=_i(vl),Ka=_i(vl),Qa=_i(vl);function Ni(t){if(t===vl)throw Error(B(174));return t}function fm(t,e){switch(Me(Qa,e),Me(Ka,t),Me(Hn,vl),t=e.nodeType,t){case 9:case 11:e=(e=e.documentElement)?e.namespaceURI:mf(null,"");break;default:t=t===8?e.parentNode:e,e=t.namespaceURI||null,t=t.tagName,e=mf(e,t)}ze(Hn),Me(Hn,e)}function Zs(){ze(Hn),ze(Ka),ze(Qa)}function GE(t){Ni(Qa.current);var e=Ni(Hn.current),n=mf(e,t.type);e!==n&&(Me(Ka,t),Me(Hn,n))}function pm(t){Ka.current===t&&(ze(Hn),ze(Ka))}var qe=_i(0);function mc(t){for(var e=t;e!==null;){if(e.tag===13){var n=e.memoizedState;if(n!==null&&(n=n.dehydrated,n===null||n.data==="$?"||n.data==="$!"))return e}else if(e.tag===19&&e.memoizedProps.revealOrder!==void 0){if(e.flags&128)return e}else if(e.child!==null){e.child.return=e,e=e.child;continue}if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return null;e=e.return}e.sibling.return=e.return,e=e.sibling}return null}var Cd=[];function mm(){for(var t=0;t<Cd.length;t++)Cd[t]._workInProgressVersionPrimary=null;Cd.length=0}var Lu=Rr.ReactCurrentDispatcher,Rd=Rr.ReactCurrentBatchConfig,Bi=0,He=null,lt=null,pt=null,gc=!1,wa=!1,Ya=0,vx=0;function Pt(){throw Error(B(321))}function gm(t,e){if(e===null)return!1;for(var n=0;n<e.length&&n<t.length;n++)if(!Vn(t[n],e[n]))return!1;return!0}function _m(t,e,n,r,i,s){if(Bi=s,He=e,e.memoizedState=null,e.updateQueue=null,e.lanes=0,Lu.current=t===null||t.memoizedState===null?Ix:Sx,t=n(r,i),wa){s=0;do{if(wa=!1,Ya=0,25<=s)throw Error(B(301));s+=1,pt=lt=null,e.updateQueue=null,Lu.current=kx,t=n(r,i)}while(wa)}if(Lu.current=_c,e=lt!==null&&lt.next!==null,Bi=0,pt=lt=He=null,gc=!1,e)throw Error(B(300));return t}function ym(){var t=Ya!==0;return Ya=0,t}function zn(){var t={memoizedState:null,baseState:null,baseQueue:null,queue:null,next:null};return pt===null?He.memoizedState=pt=t:pt=pt.next=t,pt}function kn(){if(lt===null){var t=He.alternate;t=t!==null?t.memoizedState:null}else t=lt.next;var e=pt===null?He.memoizedState:pt.next;if(e!==null)pt=e,lt=t;else{if(t===null)throw Error(B(310));lt=t,t={memoizedState:lt.memoizedState,baseState:lt.baseState,baseQueue:lt.baseQueue,queue:lt.queue,next:null},pt===null?He.memoizedState=pt=t:pt=pt.next=t}return pt}function Xa(t,e){return typeof e=="function"?e(t):e}function xd(t){var e=kn(),n=e.queue;if(n===null)throw Error(B(311));n.lastRenderedReducer=t;var r=lt,i=r.baseQueue,s=n.pending;if(s!==null){if(i!==null){var o=i.next;i.next=s.next,s.next=o}r.baseQueue=i=s,n.pending=null}if(i!==null){s=i.next,r=r.baseState;var a=o=null,u=null,c=s;do{var h=c.lane;if((Bi&h)===h)u!==null&&(u=u.next={lane:0,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null}),r=c.hasEagerState?c.eagerState:t(r,c.action);else{var f={lane:h,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null};u===null?(a=u=f,o=r):u=u.next=f,He.lanes|=h,$i|=h}c=c.next}while(c!==null&&c!==s);u===null?o=r:u.next=a,Vn(r,e.memoizedState)||(Xt=!0),e.memoizedState=r,e.baseState=o,e.baseQueue=u,n.lastRenderedState=r}if(t=n.interleaved,t!==null){i=t;do s=i.lane,He.lanes|=s,$i|=s,i=i.next;while(i!==t)}else i===null&&(n.lanes=0);return[e.memoizedState,n.dispatch]}function Ad(t){var e=kn(),n=e.queue;if(n===null)throw Error(B(311));n.lastRenderedReducer=t;var r=n.dispatch,i=n.pending,s=e.memoizedState;if(i!==null){n.pending=null;var o=i=i.next;do s=t(s,o.action),o=o.next;while(o!==i);Vn(s,e.memoizedState)||(Xt=!0),e.memoizedState=s,e.baseQueue===null&&(e.baseState=s),n.lastRenderedState=s}return[s,r]}function KE(){}function QE(t,e){var n=He,r=kn(),i=e(),s=!Vn(r.memoizedState,i);if(s&&(r.memoizedState=i,Xt=!0),r=r.queue,vm(JE.bind(null,n,r,t),[t]),r.getSnapshot!==e||s||pt!==null&&pt.memoizedState.tag&1){if(n.flags|=2048,Ja(9,XE.bind(null,n,r,i,e),void 0,null),gt===null)throw Error(B(349));Bi&30||YE(n,e,i)}return i}function YE(t,e,n){t.flags|=16384,t={getSnapshot:e,value:n},e=He.updateQueue,e===null?(e={lastEffect:null,stores:null},He.updateQueue=e,e.stores=[t]):(n=e.stores,n===null?e.stores=[t]:n.push(t))}function XE(t,e,n,r){e.value=n,e.getSnapshot=r,ZE(e)&&eT(t)}function JE(t,e,n){return n(function(){ZE(e)&&eT(t)})}function ZE(t){var e=t.getSnapshot;t=t.value;try{var n=e();return!Vn(t,n)}catch{return!0}}function eT(t){var e=_r(t,1);e!==null&&Ln(e,t,1,-1)}function Gy(t){var e=zn();return typeof t=="function"&&(t=t()),e.memoizedState=e.baseState=t,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:Xa,lastRenderedState:t},e.queue=t,t=t.dispatch=Tx.bind(null,He,t),[e.memoizedState,t]}function Ja(t,e,n,r){return t={tag:t,create:e,destroy:n,deps:r,next:null},e=He.updateQueue,e===null?(e={lastEffect:null,stores:null},He.updateQueue=e,e.lastEffect=t.next=t):(n=e.lastEffect,n===null?e.lastEffect=t.next=t:(r=n.next,n.next=t,t.next=r,e.lastEffect=t)),t}function tT(){return kn().memoizedState}function Fu(t,e,n,r){var i=zn();He.flags|=t,i.memoizedState=Ja(1|e,n,void 0,r===void 0?null:r)}function oh(t,e,n,r){var i=kn();r=r===void 0?null:r;var s=void 0;if(lt!==null){var o=lt.memoizedState;if(s=o.destroy,r!==null&&gm(r,o.deps)){i.memoizedState=Ja(e,n,s,r);return}}He.flags|=t,i.memoizedState=Ja(1|e,n,s,r)}function Ky(t,e){return Fu(8390656,8,t,e)}function vm(t,e){return oh(2048,8,t,e)}function nT(t,e){return oh(4,2,t,e)}function rT(t,e){return oh(4,4,t,e)}function iT(t,e){if(typeof e=="function")return t=t(),e(t),function(){e(null)};if(e!=null)return t=t(),e.current=t,function(){e.current=null}}function sT(t,e,n){return n=n!=null?n.concat([t]):null,oh(4,4,iT.bind(null,e,t),n)}function wm(){}function oT(t,e){var n=kn();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&gm(e,r[1])?r[0]:(n.memoizedState=[t,e],t)}function aT(t,e){var n=kn();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&gm(e,r[1])?r[0]:(t=t(),n.memoizedState=[t,e],t)}function lT(t,e,n){return Bi&21?(Vn(n,e)||(n=fE(),He.lanes|=n,$i|=n,t.baseState=!0),e):(t.baseState&&(t.baseState=!1,Xt=!0),t.memoizedState=n)}function wx(t,e){var n=xe;xe=n!==0&&4>n?n:4,t(!0);var r=Rd.transition;Rd.transition={};try{t(!1),e()}finally{xe=n,Rd.transition=r}}function uT(){return kn().memoizedState}function Ex(t,e,n){var r=Zr(t);if(n={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null},cT(t))hT(e,n);else if(n=qE(t,e,n,r),n!==null){var i=qt();Ln(n,t,r,i),dT(n,e,r)}}function Tx(t,e,n){var r=Zr(t),i={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null};if(cT(t))hT(e,i);else{var s=t.alternate;if(t.lanes===0&&(s===null||s.lanes===0)&&(s=e.lastRenderedReducer,s!==null))try{var o=e.lastRenderedState,a=s(o,n);if(i.hasEagerState=!0,i.eagerState=a,Vn(a,o)){var u=e.interleaved;u===null?(i.next=i,hm(e)):(i.next=u.next,u.next=i),e.interleaved=i;return}}catch{}finally{}n=qE(t,e,i,r),n!==null&&(i=qt(),Ln(n,t,r,i),dT(n,e,r))}}function cT(t){var e=t.alternate;return t===He||e!==null&&e===He}function hT(t,e){wa=gc=!0;var n=t.pending;n===null?e.next=e:(e.next=n.next,n.next=e),t.pending=e}function dT(t,e,n){if(n&4194240){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Xp(t,n)}}var _c={readContext:Sn,useCallback:Pt,useContext:Pt,useEffect:Pt,useImperativeHandle:Pt,useInsertionEffect:Pt,useLayoutEffect:Pt,useMemo:Pt,useReducer:Pt,useRef:Pt,useState:Pt,useDebugValue:Pt,useDeferredValue:Pt,useTransition:Pt,useMutableSource:Pt,useSyncExternalStore:Pt,useId:Pt,unstable_isNewReconciler:!1},Ix={readContext:Sn,useCallback:function(t,e){return zn().memoizedState=[t,e===void 0?null:e],t},useContext:Sn,useEffect:Ky,useImperativeHandle:function(t,e,n){return n=n!=null?n.concat([t]):null,Fu(4194308,4,iT.bind(null,e,t),n)},useLayoutEffect:function(t,e){return Fu(4194308,4,t,e)},useInsertionEffect:function(t,e){return Fu(4,2,t,e)},useMemo:function(t,e){var n=zn();return e=e===void 0?null:e,t=t(),n.memoizedState=[t,e],t},useReducer:function(t,e,n){var r=zn();return e=n!==void 0?n(e):e,r.memoizedState=r.baseState=e,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:t,lastRenderedState:e},r.queue=t,t=t.dispatch=Ex.bind(null,He,t),[r.memoizedState,t]},useRef:function(t){var e=zn();return t={current:t},e.memoizedState=t},useState:Gy,useDebugValue:wm,useDeferredValue:function(t){return zn().memoizedState=t},useTransition:function(){var t=Gy(!1),e=t[0];return t=wx.bind(null,t[1]),zn().memoizedState=t,[e,t]},useMutableSource:function(){},useSyncExternalStore:function(t,e,n){var r=He,i=zn();if(We){if(n===void 0)throw Error(B(407));n=n()}else{if(n=e(),gt===null)throw Error(B(349));Bi&30||YE(r,e,n)}i.memoizedState=n;var s={value:n,getSnapshot:e};return i.queue=s,Ky(JE.bind(null,r,s,t),[t]),r.flags|=2048,Ja(9,XE.bind(null,r,s,n,e),void 0,null),n},useId:function(){var t=zn(),e=gt.identifierPrefix;if(We){var n=or,r=sr;n=(r&~(1<<32-Mn(r)-1)).toString(32)+n,e=":"+e+"R"+n,n=Ya++,0<n&&(e+="H"+n.toString(32)),e+=":"}else n=vx++,e=":"+e+"r"+n.toString(32)+":";return t.memoizedState=e},unstable_isNewReconciler:!1},Sx={readContext:Sn,useCallback:oT,useContext:Sn,useEffect:vm,useImperativeHandle:sT,useInsertionEffect:nT,useLayoutEffect:rT,useMemo:aT,useReducer:xd,useRef:tT,useState:function(){return xd(Xa)},useDebugValue:wm,useDeferredValue:function(t){var e=kn();return lT(e,lt.memoizedState,t)},useTransition:function(){var t=xd(Xa)[0],e=kn().memoizedState;return[t,e]},useMutableSource:KE,useSyncExternalStore:QE,useId:uT,unstable_isNewReconciler:!1},kx={readContext:Sn,useCallback:oT,useContext:Sn,useEffect:vm,useImperativeHandle:sT,useInsertionEffect:nT,useLayoutEffect:rT,useMemo:aT,useReducer:Ad,useRef:tT,useState:function(){return Ad(Xa)},useDebugValue:wm,useDeferredValue:function(t){var e=kn();return lt===null?e.memoizedState=t:lT(e,lt.memoizedState,t)},useTransition:function(){var t=Ad(Xa)[0],e=kn().memoizedState;return[t,e]},useMutableSource:KE,useSyncExternalStore:QE,useId:uT,unstable_isNewReconciler:!1};function An(t,e){if(t&&t.defaultProps){e=Ge({},e),t=t.defaultProps;for(var n in t)e[n]===void 0&&(e[n]=t[n]);return e}return e}function Lf(t,e,n,r){e=t.memoizedState,n=n(r,e),n=n==null?e:Ge({},e,n),t.memoizedState=n,t.lanes===0&&(t.updateQueue.baseState=n)}var ah={isMounted:function(t){return(t=t._reactInternals)?ts(t)===t:!1},enqueueSetState:function(t,e,n){t=t._reactInternals;var r=qt(),i=Zr(t),s=dr(r,i);s.payload=e,n!=null&&(s.callback=n),e=Xr(t,s,i),e!==null&&(Ln(e,t,i,r),Mu(e,t,i))},enqueueReplaceState:function(t,e,n){t=t._reactInternals;var r=qt(),i=Zr(t),s=dr(r,i);s.tag=1,s.payload=e,n!=null&&(s.callback=n),e=Xr(t,s,i),e!==null&&(Ln(e,t,i,r),Mu(e,t,i))},enqueueForceUpdate:function(t,e){t=t._reactInternals;var n=qt(),r=Zr(t),i=dr(n,r);i.tag=2,e!=null&&(i.callback=e),e=Xr(t,i,r),e!==null&&(Ln(e,t,r,n),Mu(e,t,r))}};function Qy(t,e,n,r,i,s,o){return t=t.stateNode,typeof t.shouldComponentUpdate=="function"?t.shouldComponentUpdate(r,s,o):e.prototype&&e.prototype.isPureReactComponent?!Wa(n,r)||!Wa(i,s):!0}function fT(t,e,n){var r=!1,i=ui,s=e.contextType;return typeof s=="object"&&s!==null?s=Sn(s):(i=en(e)?ji:Ut.current,r=e.contextTypes,s=(r=r!=null)?Ys(t,i):ui),e=new e(n,s),t.memoizedState=e.state!==null&&e.state!==void 0?e.state:null,e.updater=ah,t.stateNode=e,e._reactInternals=t,r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=i,t.__reactInternalMemoizedMaskedChildContext=s),e}function Yy(t,e,n,r){t=e.state,typeof e.componentWillReceiveProps=="function"&&e.componentWillReceiveProps(n,r),typeof e.UNSAFE_componentWillReceiveProps=="function"&&e.UNSAFE_componentWillReceiveProps(n,r),e.state!==t&&ah.enqueueReplaceState(e,e.state,null)}function Ff(t,e,n,r){var i=t.stateNode;i.props=n,i.state=t.memoizedState,i.refs={},dm(t);var s=e.contextType;typeof s=="object"&&s!==null?i.context=Sn(s):(s=en(e)?ji:Ut.current,i.context=Ys(t,s)),i.state=t.memoizedState,s=e.getDerivedStateFromProps,typeof s=="function"&&(Lf(t,e,s,n),i.state=t.memoizedState),typeof e.getDerivedStateFromProps=="function"||typeof i.getSnapshotBeforeUpdate=="function"||typeof i.UNSAFE_componentWillMount!="function"&&typeof i.componentWillMount!="function"||(e=i.state,typeof i.componentWillMount=="function"&&i.componentWillMount(),typeof i.UNSAFE_componentWillMount=="function"&&i.UNSAFE_componentWillMount(),e!==i.state&&ah.enqueueReplaceState(i,i.state,null),pc(t,n,i,r),i.state=t.memoizedState),typeof i.componentDidMount=="function"&&(t.flags|=4194308)}function eo(t,e){try{var n="",r=e;do n+=ZC(r),r=r.return;while(r);var i=n}catch(s){i=`
Error generating stack: `+s.message+`
`+s.stack}return{value:t,source:e,stack:i,digest:null}}function bd(t,e,n){return{value:t,source:null,stack:n??null,digest:e??null}}function Vf(t,e){try{console.error(e.value)}catch(n){setTimeout(function(){throw n})}}var Cx=typeof WeakMap=="function"?WeakMap:Map;function pT(t,e,n){n=dr(-1,n),n.tag=3,n.payload={element:null};var r=e.value;return n.callback=function(){vc||(vc=!0,Kf=r),Vf(t,e)},n}function mT(t,e,n){n=dr(-1,n),n.tag=3;var r=t.type.getDerivedStateFromError;if(typeof r=="function"){var i=e.value;n.payload=function(){return r(i)},n.callback=function(){Vf(t,e)}}var s=t.stateNode;return s!==null&&typeof s.componentDidCatch=="function"&&(n.callback=function(){Vf(t,e),typeof r!="function"&&(Jr===null?Jr=new Set([this]):Jr.add(this));var o=e.stack;this.componentDidCatch(e.value,{componentStack:o!==null?o:""})}),n}function Xy(t,e,n){var r=t.pingCache;if(r===null){r=t.pingCache=new Cx;var i=new Set;r.set(e,i)}else i=r.get(e),i===void 0&&(i=new Set,r.set(e,i));i.has(n)||(i.add(n),t=jx.bind(null,t,e,n),e.then(t,t))}function Jy(t){do{var e;if((e=t.tag===13)&&(e=t.memoizedState,e=e!==null?e.dehydrated!==null:!0),e)return t;t=t.return}while(t!==null);return null}function Zy(t,e,n,r,i){return t.mode&1?(t.flags|=65536,t.lanes=i,t):(t===e?t.flags|=65536:(t.flags|=128,n.flags|=131072,n.flags&=-52805,n.tag===1&&(n.alternate===null?n.tag=17:(e=dr(-1,1),e.tag=2,Xr(n,e,1))),n.lanes|=1),t)}var Rx=Rr.ReactCurrentOwner,Xt=!1;function Wt(t,e,n,r){e.child=t===null?WE(e,null,n,r):Js(e,t.child,n,r)}function ev(t,e,n,r,i){n=n.render;var s=e.ref;return js(e,i),r=_m(t,e,n,r,s,i),n=ym(),t!==null&&!Xt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):(We&&n&&sm(e),e.flags|=1,Wt(t,e,r,i),e.child)}function tv(t,e,n,r,i){if(t===null){var s=n.type;return typeof s=="function"&&!xm(s)&&s.defaultProps===void 0&&n.compare===null&&n.defaultProps===void 0?(e.tag=15,e.type=s,gT(t,e,s,r,i)):(t=zu(n.type,null,r,e,e.mode,i),t.ref=e.ref,t.return=e,e.child=t)}if(s=t.child,!(t.lanes&i)){var o=s.memoizedProps;if(n=n.compare,n=n!==null?n:Wa,n(o,r)&&t.ref===e.ref)return yr(t,e,i)}return e.flags|=1,t=ei(s,r),t.ref=e.ref,t.return=e,e.child=t}function gT(t,e,n,r,i){if(t!==null){var s=t.memoizedProps;if(Wa(s,r)&&t.ref===e.ref)if(Xt=!1,e.pendingProps=r=s,(t.lanes&i)!==0)t.flags&131072&&(Xt=!0);else return e.lanes=t.lanes,yr(t,e,i)}return Uf(t,e,n,r,i)}function _T(t,e,n){var r=e.pendingProps,i=r.children,s=t!==null?t.memoizedState:null;if(r.mode==="hidden")if(!(e.mode&1))e.memoizedState={baseLanes:0,cachePool:null,transitions:null},Me(Ns,sn),sn|=n;else{if(!(n&1073741824))return t=s!==null?s.baseLanes|n:n,e.lanes=e.childLanes=1073741824,e.memoizedState={baseLanes:t,cachePool:null,transitions:null},e.updateQueue=null,Me(Ns,sn),sn|=t,null;e.memoizedState={baseLanes:0,cachePool:null,transitions:null},r=s!==null?s.baseLanes:n,Me(Ns,sn),sn|=r}else s!==null?(r=s.baseLanes|n,e.memoizedState=null):r=n,Me(Ns,sn),sn|=r;return Wt(t,e,i,n),e.child}function yT(t,e){var n=e.ref;(t===null&&n!==null||t!==null&&t.ref!==n)&&(e.flags|=512,e.flags|=2097152)}function Uf(t,e,n,r,i){var s=en(n)?ji:Ut.current;return s=Ys(e,s),js(e,i),n=_m(t,e,n,r,s,i),r=ym(),t!==null&&!Xt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):(We&&r&&sm(e),e.flags|=1,Wt(t,e,n,i),e.child)}function nv(t,e,n,r,i){if(en(n)){var s=!0;uc(e)}else s=!1;if(js(e,i),e.stateNode===null)Vu(t,e),fT(e,n,r),Ff(e,n,r,i),r=!0;else if(t===null){var o=e.stateNode,a=e.memoizedProps;o.props=a;var u=o.context,c=n.contextType;typeof c=="object"&&c!==null?c=Sn(c):(c=en(n)?ji:Ut.current,c=Ys(e,c));var h=n.getDerivedStateFromProps,f=typeof h=="function"||typeof o.getSnapshotBeforeUpdate=="function";f||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==r||u!==c)&&Yy(e,o,r,c),Lr=!1;var g=e.memoizedState;o.state=g,pc(e,r,o,i),u=e.memoizedState,a!==r||g!==u||Zt.current||Lr?(typeof h=="function"&&(Lf(e,n,h,r),u=e.memoizedState),(a=Lr||Qy(e,n,a,r,g,u,c))?(f||typeof o.UNSAFE_componentWillMount!="function"&&typeof o.componentWillMount!="function"||(typeof o.componentWillMount=="function"&&o.componentWillMount(),typeof o.UNSAFE_componentWillMount=="function"&&o.UNSAFE_componentWillMount()),typeof o.componentDidMount=="function"&&(e.flags|=4194308)):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),e.memoizedProps=r,e.memoizedState=u),o.props=r,o.state=u,o.context=c,r=a):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),r=!1)}else{o=e.stateNode,HE(t,e),a=e.memoizedProps,c=e.type===e.elementType?a:An(e.type,a),o.props=c,f=e.pendingProps,g=o.context,u=n.contextType,typeof u=="object"&&u!==null?u=Sn(u):(u=en(n)?ji:Ut.current,u=Ys(e,u));var v=n.getDerivedStateFromProps;(h=typeof v=="function"||typeof o.getSnapshotBeforeUpdate=="function")||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==f||g!==u)&&Yy(e,o,r,u),Lr=!1,g=e.memoizedState,o.state=g,pc(e,r,o,i);var I=e.memoizedState;a!==f||g!==I||Zt.current||Lr?(typeof v=="function"&&(Lf(e,n,v,r),I=e.memoizedState),(c=Lr||Qy(e,n,c,r,g,I,u)||!1)?(h||typeof o.UNSAFE_componentWillUpdate!="function"&&typeof o.componentWillUpdate!="function"||(typeof o.componentWillUpdate=="function"&&o.componentWillUpdate(r,I,u),typeof o.UNSAFE_componentWillUpdate=="function"&&o.UNSAFE_componentWillUpdate(r,I,u)),typeof o.componentDidUpdate=="function"&&(e.flags|=4),typeof o.getSnapshotBeforeUpdate=="function"&&(e.flags|=1024)):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&g===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&g===t.memoizedState||(e.flags|=1024),e.memoizedProps=r,e.memoizedState=I),o.props=r,o.state=I,o.context=u,r=c):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&g===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&g===t.memoizedState||(e.flags|=1024),r=!1)}return jf(t,e,n,r,s,i)}function jf(t,e,n,r,i,s){yT(t,e);var o=(e.flags&128)!==0;if(!r&&!o)return i&&zy(e,n,!1),yr(t,e,s);r=e.stateNode,Rx.current=e;var a=o&&typeof n.getDerivedStateFromError!="function"?null:r.render();return e.flags|=1,t!==null&&o?(e.child=Js(e,t.child,null,s),e.child=Js(e,null,a,s)):Wt(t,e,a,s),e.memoizedState=r.state,i&&zy(e,n,!0),e.child}function vT(t){var e=t.stateNode;e.pendingContext?jy(t,e.pendingContext,e.pendingContext!==e.context):e.context&&jy(t,e.context,!1),fm(t,e.containerInfo)}function rv(t,e,n,r,i){return Xs(),am(i),e.flags|=256,Wt(t,e,n,r),e.child}var zf={dehydrated:null,treeContext:null,retryLane:0};function Bf(t){return{baseLanes:t,cachePool:null,transitions:null}}function wT(t,e,n){var r=e.pendingProps,i=qe.current,s=!1,o=(e.flags&128)!==0,a;if((a=o)||(a=t!==null&&t.memoizedState===null?!1:(i&2)!==0),a?(s=!0,e.flags&=-129):(t===null||t.memoizedState!==null)&&(i|=1),Me(qe,i&1),t===null)return Of(e),t=e.memoizedState,t!==null&&(t=t.dehydrated,t!==null)?(e.mode&1?t.data==="$!"?e.lanes=8:e.lanes=1073741824:e.lanes=1,null):(o=r.children,t=r.fallback,s?(r=e.mode,s=e.child,o={mode:"hidden",children:o},!(r&1)&&s!==null?(s.childLanes=0,s.pendingProps=o):s=ch(o,r,0,null),t=Fi(t,r,n,null),s.return=e,t.return=e,s.sibling=t,e.child=s,e.child.memoizedState=Bf(n),e.memoizedState=zf,t):Em(e,o));if(i=t.memoizedState,i!==null&&(a=i.dehydrated,a!==null))return xx(t,e,o,r,a,i,n);if(s){s=r.fallback,o=e.mode,i=t.child,a=i.sibling;var u={mode:"hidden",children:r.children};return!(o&1)&&e.child!==i?(r=e.child,r.childLanes=0,r.pendingProps=u,e.deletions=null):(r=ei(i,u),r.subtreeFlags=i.subtreeFlags&14680064),a!==null?s=ei(a,s):(s=Fi(s,o,n,null),s.flags|=2),s.return=e,r.return=e,r.sibling=s,e.child=r,r=s,s=e.child,o=t.child.memoizedState,o=o===null?Bf(n):{baseLanes:o.baseLanes|n,cachePool:null,transitions:o.transitions},s.memoizedState=o,s.childLanes=t.childLanes&~n,e.memoizedState=zf,r}return s=t.child,t=s.sibling,r=ei(s,{mode:"visible",children:r.children}),!(e.mode&1)&&(r.lanes=n),r.return=e,r.sibling=null,t!==null&&(n=e.deletions,n===null?(e.deletions=[t],e.flags|=16):n.push(t)),e.child=r,e.memoizedState=null,r}function Em(t,e){return e=ch({mode:"visible",children:e},t.mode,0,null),e.return=t,t.child=e}function pu(t,e,n,r){return r!==null&&am(r),Js(e,t.child,null,n),t=Em(e,e.pendingProps.children),t.flags|=2,e.memoizedState=null,t}function xx(t,e,n,r,i,s,o){if(n)return e.flags&256?(e.flags&=-257,r=bd(Error(B(422))),pu(t,e,o,r)):e.memoizedState!==null?(e.child=t.child,e.flags|=128,null):(s=r.fallback,i=e.mode,r=ch({mode:"visible",children:r.children},i,0,null),s=Fi(s,i,o,null),s.flags|=2,r.return=e,s.return=e,r.sibling=s,e.child=r,e.mode&1&&Js(e,t.child,null,o),e.child.memoizedState=Bf(o),e.memoizedState=zf,s);if(!(e.mode&1))return pu(t,e,o,null);if(i.data==="$!"){if(r=i.nextSibling&&i.nextSibling.dataset,r)var a=r.dgst;return r=a,s=Error(B(419)),r=bd(s,r,void 0),pu(t,e,o,r)}if(a=(o&t.childLanes)!==0,Xt||a){if(r=gt,r!==null){switch(o&-o){case 4:i=2;break;case 16:i=8;break;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:i=32;break;case 536870912:i=268435456;break;default:i=0}i=i&(r.suspendedLanes|o)?0:i,i!==0&&i!==s.retryLane&&(s.retryLane=i,_r(t,i),Ln(r,t,i,-1))}return Rm(),r=bd(Error(B(421))),pu(t,e,o,r)}return i.data==="$?"?(e.flags|=128,e.child=t.child,e=zx.bind(null,t),i._reactRetry=e,null):(t=s.treeContext,an=Yr(i.nextSibling),un=e,We=!0,Pn=null,t!==null&&(pn[mn++]=sr,pn[mn++]=or,pn[mn++]=zi,sr=t.id,or=t.overflow,zi=e),e=Em(e,r.children),e.flags|=4096,e)}function iv(t,e,n){t.lanes|=e;var r=t.alternate;r!==null&&(r.lanes|=e),Mf(t.return,e,n)}function Pd(t,e,n,r,i){var s=t.memoizedState;s===null?t.memoizedState={isBackwards:e,rendering:null,renderingStartTime:0,last:r,tail:n,tailMode:i}:(s.isBackwards=e,s.rendering=null,s.renderingStartTime=0,s.last=r,s.tail=n,s.tailMode=i)}function ET(t,e,n){var r=e.pendingProps,i=r.revealOrder,s=r.tail;if(Wt(t,e,r.children,n),r=qe.current,r&2)r=r&1|2,e.flags|=128;else{if(t!==null&&t.flags&128)e:for(t=e.child;t!==null;){if(t.tag===13)t.memoizedState!==null&&iv(t,n,e);else if(t.tag===19)iv(t,n,e);else if(t.child!==null){t.child.return=t,t=t.child;continue}if(t===e)break e;for(;t.sibling===null;){if(t.return===null||t.return===e)break e;t=t.return}t.sibling.return=t.return,t=t.sibling}r&=1}if(Me(qe,r),!(e.mode&1))e.memoizedState=null;else switch(i){case"forwards":for(n=e.child,i=null;n!==null;)t=n.alternate,t!==null&&mc(t)===null&&(i=n),n=n.sibling;n=i,n===null?(i=e.child,e.child=null):(i=n.sibling,n.sibling=null),Pd(e,!1,i,n,s);break;case"backwards":for(n=null,i=e.child,e.child=null;i!==null;){if(t=i.alternate,t!==null&&mc(t)===null){e.child=i;break}t=i.sibling,i.sibling=n,n=i,i=t}Pd(e,!0,n,null,s);break;case"together":Pd(e,!1,null,null,void 0);break;default:e.memoizedState=null}return e.child}function Vu(t,e){!(e.mode&1)&&t!==null&&(t.alternate=null,e.alternate=null,e.flags|=2)}function yr(t,e,n){if(t!==null&&(e.dependencies=t.dependencies),$i|=e.lanes,!(n&e.childLanes))return null;if(t!==null&&e.child!==t.child)throw Error(B(153));if(e.child!==null){for(t=e.child,n=ei(t,t.pendingProps),e.child=n,n.return=e;t.sibling!==null;)t=t.sibling,n=n.sibling=ei(t,t.pendingProps),n.return=e;n.sibling=null}return e.child}function Ax(t,e,n){switch(e.tag){case 3:vT(e),Xs();break;case 5:GE(e);break;case 1:en(e.type)&&uc(e);break;case 4:fm(e,e.stateNode.containerInfo);break;case 10:var r=e.type._context,i=e.memoizedProps.value;Me(dc,r._currentValue),r._currentValue=i;break;case 13:if(r=e.memoizedState,r!==null)return r.dehydrated!==null?(Me(qe,qe.current&1),e.flags|=128,null):n&e.child.childLanes?wT(t,e,n):(Me(qe,qe.current&1),t=yr(t,e,n),t!==null?t.sibling:null);Me(qe,qe.current&1);break;case 19:if(r=(n&e.childLanes)!==0,t.flags&128){if(r)return ET(t,e,n);e.flags|=128}if(i=e.memoizedState,i!==null&&(i.rendering=null,i.tail=null,i.lastEffect=null),Me(qe,qe.current),r)break;return null;case 22:case 23:return e.lanes=0,_T(t,e,n)}return yr(t,e,n)}var TT,$f,IT,ST;TT=function(t,e){for(var n=e.child;n!==null;){if(n.tag===5||n.tag===6)t.appendChild(n.stateNode);else if(n.tag!==4&&n.child!==null){n.child.return=n,n=n.child;continue}if(n===e)break;for(;n.sibling===null;){if(n.return===null||n.return===e)return;n=n.return}n.sibling.return=n.return,n=n.sibling}};$f=function(){};IT=function(t,e,n,r){var i=t.memoizedProps;if(i!==r){t=e.stateNode,Ni(Hn.current);var s=null;switch(n){case"input":i=hf(t,i),r=hf(t,r),s=[];break;case"select":i=Ge({},i,{value:void 0}),r=Ge({},r,{value:void 0}),s=[];break;case"textarea":i=pf(t,i),r=pf(t,r),s=[];break;default:typeof i.onClick!="function"&&typeof r.onClick=="function"&&(t.onclick=ac)}gf(n,r);var o;n=null;for(c in i)if(!r.hasOwnProperty(c)&&i.hasOwnProperty(c)&&i[c]!=null)if(c==="style"){var a=i[c];for(o in a)a.hasOwnProperty(o)&&(n||(n={}),n[o]="")}else c!=="dangerouslySetInnerHTML"&&c!=="children"&&c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&c!=="autoFocus"&&(Fa.hasOwnProperty(c)?s||(s=[]):(s=s||[]).push(c,null));for(c in r){var u=r[c];if(a=i!=null?i[c]:void 0,r.hasOwnProperty(c)&&u!==a&&(u!=null||a!=null))if(c==="style")if(a){for(o in a)!a.hasOwnProperty(o)||u&&u.hasOwnProperty(o)||(n||(n={}),n[o]="");for(o in u)u.hasOwnProperty(o)&&a[o]!==u[o]&&(n||(n={}),n[o]=u[o])}else n||(s||(s=[]),s.push(c,n)),n=u;else c==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,a=a?a.__html:void 0,u!=null&&a!==u&&(s=s||[]).push(c,u)):c==="children"?typeof u!="string"&&typeof u!="number"||(s=s||[]).push(c,""+u):c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&(Fa.hasOwnProperty(c)?(u!=null&&c==="onScroll"&&Fe("scroll",t),s||a===u||(s=[])):(s=s||[]).push(c,u))}n&&(s=s||[]).push("style",n);var c=s;(e.updateQueue=c)&&(e.flags|=4)}};ST=function(t,e,n,r){n!==r&&(e.flags|=4)};function Xo(t,e){if(!We)switch(t.tailMode){case"hidden":e=t.tail;for(var n=null;e!==null;)e.alternate!==null&&(n=e),e=e.sibling;n===null?t.tail=null:n.sibling=null;break;case"collapsed":n=t.tail;for(var r=null;n!==null;)n.alternate!==null&&(r=n),n=n.sibling;r===null?e||t.tail===null?t.tail=null:t.tail.sibling=null:r.sibling=null}}function Nt(t){var e=t.alternate!==null&&t.alternate.child===t.child,n=0,r=0;if(e)for(var i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags&14680064,r|=i.flags&14680064,i.return=t,i=i.sibling;else for(i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags,r|=i.flags,i.return=t,i=i.sibling;return t.subtreeFlags|=r,t.childLanes=n,e}function bx(t,e,n){var r=e.pendingProps;switch(om(e),e.tag){case 2:case 16:case 15:case 0:case 11:case 7:case 8:case 12:case 9:case 14:return Nt(e),null;case 1:return en(e.type)&&lc(),Nt(e),null;case 3:return r=e.stateNode,Zs(),ze(Zt),ze(Ut),mm(),r.pendingContext&&(r.context=r.pendingContext,r.pendingContext=null),(t===null||t.child===null)&&(du(e)?e.flags|=4:t===null||t.memoizedState.isDehydrated&&!(e.flags&256)||(e.flags|=1024,Pn!==null&&(Xf(Pn),Pn=null))),$f(t,e),Nt(e),null;case 5:pm(e);var i=Ni(Qa.current);if(n=e.type,t!==null&&e.stateNode!=null)IT(t,e,n,r,i),t.ref!==e.ref&&(e.flags|=512,e.flags|=2097152);else{if(!r){if(e.stateNode===null)throw Error(B(166));return Nt(e),null}if(t=Ni(Hn.current),du(e)){r=e.stateNode,n=e.type;var s=e.memoizedProps;switch(r[Bn]=e,r[Ga]=s,t=(e.mode&1)!==0,n){case"dialog":Fe("cancel",r),Fe("close",r);break;case"iframe":case"object":case"embed":Fe("load",r);break;case"video":case"audio":for(i=0;i<ca.length;i++)Fe(ca[i],r);break;case"source":Fe("error",r);break;case"img":case"image":case"link":Fe("error",r),Fe("load",r);break;case"details":Fe("toggle",r);break;case"input":fy(r,s),Fe("invalid",r);break;case"select":r._wrapperState={wasMultiple:!!s.multiple},Fe("invalid",r);break;case"textarea":my(r,s),Fe("invalid",r)}gf(n,s),i=null;for(var o in s)if(s.hasOwnProperty(o)){var a=s[o];o==="children"?typeof a=="string"?r.textContent!==a&&(s.suppressHydrationWarning!==!0&&hu(r.textContent,a,t),i=["children",a]):typeof a=="number"&&r.textContent!==""+a&&(s.suppressHydrationWarning!==!0&&hu(r.textContent,a,t),i=["children",""+a]):Fa.hasOwnProperty(o)&&a!=null&&o==="onScroll"&&Fe("scroll",r)}switch(n){case"input":ru(r),py(r,s,!0);break;case"textarea":ru(r),gy(r);break;case"select":case"option":break;default:typeof s.onClick=="function"&&(r.onclick=ac)}r=i,e.updateQueue=r,r!==null&&(e.flags|=4)}else{o=i.nodeType===9?i:i.ownerDocument,t==="http://www.w3.org/1999/xhtml"&&(t=Jw(n)),t==="http://www.w3.org/1999/xhtml"?n==="script"?(t=o.createElement("div"),t.innerHTML="<script><\/script>",t=t.removeChild(t.firstChild)):typeof r.is=="string"?t=o.createElement(n,{is:r.is}):(t=o.createElement(n),n==="select"&&(o=t,r.multiple?o.multiple=!0:r.size&&(o.size=r.size))):t=o.createElementNS(t,n),t[Bn]=e,t[Ga]=r,TT(t,e,!1,!1),e.stateNode=t;e:{switch(o=_f(n,r),n){case"dialog":Fe("cancel",t),Fe("close",t),i=r;break;case"iframe":case"object":case"embed":Fe("load",t),i=r;break;case"video":case"audio":for(i=0;i<ca.length;i++)Fe(ca[i],t);i=r;break;case"source":Fe("error",t),i=r;break;case"img":case"image":case"link":Fe("error",t),Fe("load",t),i=r;break;case"details":Fe("toggle",t),i=r;break;case"input":fy(t,r),i=hf(t,r),Fe("invalid",t);break;case"option":i=r;break;case"select":t._wrapperState={wasMultiple:!!r.multiple},i=Ge({},r,{value:void 0}),Fe("invalid",t);break;case"textarea":my(t,r),i=pf(t,r),Fe("invalid",t);break;default:i=r}gf(n,i),a=i;for(s in a)if(a.hasOwnProperty(s)){var u=a[s];s==="style"?tE(t,u):s==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,u!=null&&Zw(t,u)):s==="children"?typeof u=="string"?(n!=="textarea"||u!=="")&&Va(t,u):typeof u=="number"&&Va(t,""+u):s!=="suppressContentEditableWarning"&&s!=="suppressHydrationWarning"&&s!=="autoFocus"&&(Fa.hasOwnProperty(s)?u!=null&&s==="onScroll"&&Fe("scroll",t):u!=null&&qp(t,s,u,o))}switch(n){case"input":ru(t),py(t,r,!1);break;case"textarea":ru(t),gy(t);break;case"option":r.value!=null&&t.setAttribute("value",""+li(r.value));break;case"select":t.multiple=!!r.multiple,s=r.value,s!=null?Ls(t,!!r.multiple,s,!1):r.defaultValue!=null&&Ls(t,!!r.multiple,r.defaultValue,!0);break;default:typeof i.onClick=="function"&&(t.onclick=ac)}switch(n){case"button":case"input":case"select":case"textarea":r=!!r.autoFocus;break e;case"img":r=!0;break e;default:r=!1}}r&&(e.flags|=4)}e.ref!==null&&(e.flags|=512,e.flags|=2097152)}return Nt(e),null;case 6:if(t&&e.stateNode!=null)ST(t,e,t.memoizedProps,r);else{if(typeof r!="string"&&e.stateNode===null)throw Error(B(166));if(n=Ni(Qa.current),Ni(Hn.current),du(e)){if(r=e.stateNode,n=e.memoizedProps,r[Bn]=e,(s=r.nodeValue!==n)&&(t=un,t!==null))switch(t.tag){case 3:hu(r.nodeValue,n,(t.mode&1)!==0);break;case 5:t.memoizedProps.suppressHydrationWarning!==!0&&hu(r.nodeValue,n,(t.mode&1)!==0)}s&&(e.flags|=4)}else r=(n.nodeType===9?n:n.ownerDocument).createTextNode(r),r[Bn]=e,e.stateNode=r}return Nt(e),null;case 13:if(ze(qe),r=e.memoizedState,t===null||t.memoizedState!==null&&t.memoizedState.dehydrated!==null){if(We&&an!==null&&e.mode&1&&!(e.flags&128))BE(),Xs(),e.flags|=98560,s=!1;else if(s=du(e),r!==null&&r.dehydrated!==null){if(t===null){if(!s)throw Error(B(318));if(s=e.memoizedState,s=s!==null?s.dehydrated:null,!s)throw Error(B(317));s[Bn]=e}else Xs(),!(e.flags&128)&&(e.memoizedState=null),e.flags|=4;Nt(e),s=!1}else Pn!==null&&(Xf(Pn),Pn=null),s=!0;if(!s)return e.flags&65536?e:null}return e.flags&128?(e.lanes=n,e):(r=r!==null,r!==(t!==null&&t.memoizedState!==null)&&r&&(e.child.flags|=8192,e.mode&1&&(t===null||qe.current&1?ct===0&&(ct=3):Rm())),e.updateQueue!==null&&(e.flags|=4),Nt(e),null);case 4:return Zs(),$f(t,e),t===null&&qa(e.stateNode.containerInfo),Nt(e),null;case 10:return cm(e.type._context),Nt(e),null;case 17:return en(e.type)&&lc(),Nt(e),null;case 19:if(ze(qe),s=e.memoizedState,s===null)return Nt(e),null;if(r=(e.flags&128)!==0,o=s.rendering,o===null)if(r)Xo(s,!1);else{if(ct!==0||t!==null&&t.flags&128)for(t=e.child;t!==null;){if(o=mc(t),o!==null){for(e.flags|=128,Xo(s,!1),r=o.updateQueue,r!==null&&(e.updateQueue=r,e.flags|=4),e.subtreeFlags=0,r=n,n=e.child;n!==null;)s=n,t=r,s.flags&=14680066,o=s.alternate,o===null?(s.childLanes=0,s.lanes=t,s.child=null,s.subtreeFlags=0,s.memoizedProps=null,s.memoizedState=null,s.updateQueue=null,s.dependencies=null,s.stateNode=null):(s.childLanes=o.childLanes,s.lanes=o.lanes,s.child=o.child,s.subtreeFlags=0,s.deletions=null,s.memoizedProps=o.memoizedProps,s.memoizedState=o.memoizedState,s.updateQueue=o.updateQueue,s.type=o.type,t=o.dependencies,s.dependencies=t===null?null:{lanes:t.lanes,firstContext:t.firstContext}),n=n.sibling;return Me(qe,qe.current&1|2),e.child}t=t.sibling}s.tail!==null&&tt()>to&&(e.flags|=128,r=!0,Xo(s,!1),e.lanes=4194304)}else{if(!r)if(t=mc(o),t!==null){if(e.flags|=128,r=!0,n=t.updateQueue,n!==null&&(e.updateQueue=n,e.flags|=4),Xo(s,!0),s.tail===null&&s.tailMode==="hidden"&&!o.alternate&&!We)return Nt(e),null}else 2*tt()-s.renderingStartTime>to&&n!==1073741824&&(e.flags|=128,r=!0,Xo(s,!1),e.lanes=4194304);s.isBackwards?(o.sibling=e.child,e.child=o):(n=s.last,n!==null?n.sibling=o:e.child=o,s.last=o)}return s.tail!==null?(e=s.tail,s.rendering=e,s.tail=e.sibling,s.renderingStartTime=tt(),e.sibling=null,n=qe.current,Me(qe,r?n&1|2:n&1),e):(Nt(e),null);case 22:case 23:return Cm(),r=e.memoizedState!==null,t!==null&&t.memoizedState!==null!==r&&(e.flags|=8192),r&&e.mode&1?sn&1073741824&&(Nt(e),e.subtreeFlags&6&&(e.flags|=8192)):Nt(e),null;case 24:return null;case 25:return null}throw Error(B(156,e.tag))}function Px(t,e){switch(om(e),e.tag){case 1:return en(e.type)&&lc(),t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 3:return Zs(),ze(Zt),ze(Ut),mm(),t=e.flags,t&65536&&!(t&128)?(e.flags=t&-65537|128,e):null;case 5:return pm(e),null;case 13:if(ze(qe),t=e.memoizedState,t!==null&&t.dehydrated!==null){if(e.alternate===null)throw Error(B(340));Xs()}return t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 19:return ze(qe),null;case 4:return Zs(),null;case 10:return cm(e.type._context),null;case 22:case 23:return Cm(),null;case 24:return null;default:return null}}var mu=!1,Mt=!1,Nx=typeof WeakSet=="function"?WeakSet:Set,Q=null;function Ps(t,e){var n=t.ref;if(n!==null)if(typeof n=="function")try{n(null)}catch(r){Ye(t,e,r)}else n.current=null}function Wf(t,e,n){try{n()}catch(r){Ye(t,e,r)}}var sv=!1;function Dx(t,e){if(Rf=ic,t=AE(),im(t)){if("selectionStart"in t)var n={start:t.selectionStart,end:t.selectionEnd};else e:{n=(n=t.ownerDocument)&&n.defaultView||window;var r=n.getSelection&&n.getSelection();if(r&&r.rangeCount!==0){n=r.anchorNode;var i=r.anchorOffset,s=r.focusNode;r=r.focusOffset;try{n.nodeType,s.nodeType}catch{n=null;break e}var o=0,a=-1,u=-1,c=0,h=0,f=t,g=null;t:for(;;){for(var v;f!==n||i!==0&&f.nodeType!==3||(a=o+i),f!==s||r!==0&&f.nodeType!==3||(u=o+r),f.nodeType===3&&(o+=f.nodeValue.length),(v=f.firstChild)!==null;)g=f,f=v;for(;;){if(f===t)break t;if(g===n&&++c===i&&(a=o),g===s&&++h===r&&(u=o),(v=f.nextSibling)!==null)break;f=g,g=f.parentNode}f=v}n=a===-1||u===-1?null:{start:a,end:u}}else n=null}n=n||{start:0,end:0}}else n=null;for(xf={focusedElem:t,selectionRange:n},ic=!1,Q=e;Q!==null;)if(e=Q,t=e.child,(e.subtreeFlags&1028)!==0&&t!==null)t.return=e,Q=t;else for(;Q!==null;){e=Q;try{var I=e.alternate;if(e.flags&1024)switch(e.tag){case 0:case 11:case 15:break;case 1:if(I!==null){var N=I.memoizedProps,D=I.memoizedState,C=e.stateNode,w=C.getSnapshotBeforeUpdate(e.elementType===e.type?N:An(e.type,N),D);C.__reactInternalSnapshotBeforeUpdate=w}break;case 3:var R=e.stateNode.containerInfo;R.nodeType===1?R.textContent="":R.nodeType===9&&R.documentElement&&R.removeChild(R.documentElement);break;case 5:case 6:case 4:case 17:break;default:throw Error(B(163))}}catch(M){Ye(e,e.return,M)}if(t=e.sibling,t!==null){t.return=e.return,Q=t;break}Q=e.return}return I=sv,sv=!1,I}function Ea(t,e,n){var r=e.updateQueue;if(r=r!==null?r.lastEffect:null,r!==null){var i=r=r.next;do{if((i.tag&t)===t){var s=i.destroy;i.destroy=void 0,s!==void 0&&Wf(e,n,s)}i=i.next}while(i!==r)}}function lh(t,e){if(e=e.updateQueue,e=e!==null?e.lastEffect:null,e!==null){var n=e=e.next;do{if((n.tag&t)===t){var r=n.create;n.destroy=r()}n=n.next}while(n!==e)}}function qf(t){var e=t.ref;if(e!==null){var n=t.stateNode;switch(t.tag){case 5:t=n;break;default:t=n}typeof e=="function"?e(t):e.current=t}}function kT(t){var e=t.alternate;e!==null&&(t.alternate=null,kT(e)),t.child=null,t.deletions=null,t.sibling=null,t.tag===5&&(e=t.stateNode,e!==null&&(delete e[Bn],delete e[Ga],delete e[Pf],delete e[mx],delete e[gx])),t.stateNode=null,t.return=null,t.dependencies=null,t.memoizedProps=null,t.memoizedState=null,t.pendingProps=null,t.stateNode=null,t.updateQueue=null}function CT(t){return t.tag===5||t.tag===3||t.tag===4}function ov(t){e:for(;;){for(;t.sibling===null;){if(t.return===null||CT(t.return))return null;t=t.return}for(t.sibling.return=t.return,t=t.sibling;t.tag!==5&&t.tag!==6&&t.tag!==18;){if(t.flags&2||t.child===null||t.tag===4)continue e;t.child.return=t,t=t.child}if(!(t.flags&2))return t.stateNode}}function Hf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.nodeType===8?n.parentNode.insertBefore(t,e):n.insertBefore(t,e):(n.nodeType===8?(e=n.parentNode,e.insertBefore(t,n)):(e=n,e.appendChild(t)),n=n._reactRootContainer,n!=null||e.onclick!==null||(e.onclick=ac));else if(r!==4&&(t=t.child,t!==null))for(Hf(t,e,n),t=t.sibling;t!==null;)Hf(t,e,n),t=t.sibling}function Gf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.insertBefore(t,e):n.appendChild(t);else if(r!==4&&(t=t.child,t!==null))for(Gf(t,e,n),t=t.sibling;t!==null;)Gf(t,e,n),t=t.sibling}var vt=null,bn=!1;function Dr(t,e,n){for(n=n.child;n!==null;)RT(t,e,n),n=n.sibling}function RT(t,e,n){if(qn&&typeof qn.onCommitFiberUnmount=="function")try{qn.onCommitFiberUnmount(eh,n)}catch{}switch(n.tag){case 5:Mt||Ps(n,e);case 6:var r=vt,i=bn;vt=null,Dr(t,e,n),vt=r,bn=i,vt!==null&&(bn?(t=vt,n=n.stateNode,t.nodeType===8?t.parentNode.removeChild(n):t.removeChild(n)):vt.removeChild(n.stateNode));break;case 18:vt!==null&&(bn?(t=vt,n=n.stateNode,t.nodeType===8?Sd(t.parentNode,n):t.nodeType===1&&Sd(t,n),Ba(t)):Sd(vt,n.stateNode));break;case 4:r=vt,i=bn,vt=n.stateNode.containerInfo,bn=!0,Dr(t,e,n),vt=r,bn=i;break;case 0:case 11:case 14:case 15:if(!Mt&&(r=n.updateQueue,r!==null&&(r=r.lastEffect,r!==null))){i=r=r.next;do{var s=i,o=s.destroy;s=s.tag,o!==void 0&&(s&2||s&4)&&Wf(n,e,o),i=i.next}while(i!==r)}Dr(t,e,n);break;case 1:if(!Mt&&(Ps(n,e),r=n.stateNode,typeof r.componentWillUnmount=="function"))try{r.props=n.memoizedProps,r.state=n.memoizedState,r.componentWillUnmount()}catch(a){Ye(n,e,a)}Dr(t,e,n);break;case 21:Dr(t,e,n);break;case 22:n.mode&1?(Mt=(r=Mt)||n.memoizedState!==null,Dr(t,e,n),Mt=r):Dr(t,e,n);break;default:Dr(t,e,n)}}function av(t){var e=t.updateQueue;if(e!==null){t.updateQueue=null;var n=t.stateNode;n===null&&(n=t.stateNode=new Nx),e.forEach(function(r){var i=Bx.bind(null,t,r);n.has(r)||(n.add(r),r.then(i,i))})}}function xn(t,e){var n=e.deletions;if(n!==null)for(var r=0;r<n.length;r++){var i=n[r];try{var s=t,o=e,a=o;e:for(;a!==null;){switch(a.tag){case 5:vt=a.stateNode,bn=!1;break e;case 3:vt=a.stateNode.containerInfo,bn=!0;break e;case 4:vt=a.stateNode.containerInfo,bn=!0;break e}a=a.return}if(vt===null)throw Error(B(160));RT(s,o,i),vt=null,bn=!1;var u=i.alternate;u!==null&&(u.return=null),i.return=null}catch(c){Ye(i,e,c)}}if(e.subtreeFlags&12854)for(e=e.child;e!==null;)xT(e,t),e=e.sibling}function xT(t,e){var n=t.alternate,r=t.flags;switch(t.tag){case 0:case 11:case 14:case 15:if(xn(e,t),jn(t),r&4){try{Ea(3,t,t.return),lh(3,t)}catch(N){Ye(t,t.return,N)}try{Ea(5,t,t.return)}catch(N){Ye(t,t.return,N)}}break;case 1:xn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return);break;case 5:if(xn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return),t.flags&32){var i=t.stateNode;try{Va(i,"")}catch(N){Ye(t,t.return,N)}}if(r&4&&(i=t.stateNode,i!=null)){var s=t.memoizedProps,o=n!==null?n.memoizedProps:s,a=t.type,u=t.updateQueue;if(t.updateQueue=null,u!==null)try{a==="input"&&s.type==="radio"&&s.name!=null&&Yw(i,s),_f(a,o);var c=_f(a,s);for(o=0;o<u.length;o+=2){var h=u[o],f=u[o+1];h==="style"?tE(i,f):h==="dangerouslySetInnerHTML"?Zw(i,f):h==="children"?Va(i,f):qp(i,h,f,c)}switch(a){case"input":df(i,s);break;case"textarea":Xw(i,s);break;case"select":var g=i._wrapperState.wasMultiple;i._wrapperState.wasMultiple=!!s.multiple;var v=s.value;v!=null?Ls(i,!!s.multiple,v,!1):g!==!!s.multiple&&(s.defaultValue!=null?Ls(i,!!s.multiple,s.defaultValue,!0):Ls(i,!!s.multiple,s.multiple?[]:"",!1))}i[Ga]=s}catch(N){Ye(t,t.return,N)}}break;case 6:if(xn(e,t),jn(t),r&4){if(t.stateNode===null)throw Error(B(162));i=t.stateNode,s=t.memoizedProps;try{i.nodeValue=s}catch(N){Ye(t,t.return,N)}}break;case 3:if(xn(e,t),jn(t),r&4&&n!==null&&n.memoizedState.isDehydrated)try{Ba(e.containerInfo)}catch(N){Ye(t,t.return,N)}break;case 4:xn(e,t),jn(t);break;case 13:xn(e,t),jn(t),i=t.child,i.flags&8192&&(s=i.memoizedState!==null,i.stateNode.isHidden=s,!s||i.alternate!==null&&i.alternate.memoizedState!==null||(Sm=tt())),r&4&&av(t);break;case 22:if(h=n!==null&&n.memoizedState!==null,t.mode&1?(Mt=(c=Mt)||h,xn(e,t),Mt=c):xn(e,t),jn(t),r&8192){if(c=t.memoizedState!==null,(t.stateNode.isHidden=c)&&!h&&t.mode&1)for(Q=t,h=t.child;h!==null;){for(f=Q=h;Q!==null;){switch(g=Q,v=g.child,g.tag){case 0:case 11:case 14:case 15:Ea(4,g,g.return);break;case 1:Ps(g,g.return);var I=g.stateNode;if(typeof I.componentWillUnmount=="function"){r=g,n=g.return;try{e=r,I.props=e.memoizedProps,I.state=e.memoizedState,I.componentWillUnmount()}catch(N){Ye(r,n,N)}}break;case 5:Ps(g,g.return);break;case 22:if(g.memoizedState!==null){uv(f);continue}}v!==null?(v.return=g,Q=v):uv(f)}h=h.sibling}e:for(h=null,f=t;;){if(f.tag===5){if(h===null){h=f;try{i=f.stateNode,c?(s=i.style,typeof s.setProperty=="function"?s.setProperty("display","none","important"):s.display="none"):(a=f.stateNode,u=f.memoizedProps.style,o=u!=null&&u.hasOwnProperty("display")?u.display:null,a.style.display=eE("display",o))}catch(N){Ye(t,t.return,N)}}}else if(f.tag===6){if(h===null)try{f.stateNode.nodeValue=c?"":f.memoizedProps}catch(N){Ye(t,t.return,N)}}else if((f.tag!==22&&f.tag!==23||f.memoizedState===null||f===t)&&f.child!==null){f.child.return=f,f=f.child;continue}if(f===t)break e;for(;f.sibling===null;){if(f.return===null||f.return===t)break e;h===f&&(h=null),f=f.return}h===f&&(h=null),f.sibling.return=f.return,f=f.sibling}}break;case 19:xn(e,t),jn(t),r&4&&av(t);break;case 21:break;default:xn(e,t),jn(t)}}function jn(t){var e=t.flags;if(e&2){try{e:{for(var n=t.return;n!==null;){if(CT(n)){var r=n;break e}n=n.return}throw Error(B(160))}switch(r.tag){case 5:var i=r.stateNode;r.flags&32&&(Va(i,""),r.flags&=-33);var s=ov(t);Gf(t,s,i);break;case 3:case 4:var o=r.stateNode.containerInfo,a=ov(t);Hf(t,a,o);break;default:throw Error(B(161))}}catch(u){Ye(t,t.return,u)}t.flags&=-3}e&4096&&(t.flags&=-4097)}function Ox(t,e,n){Q=t,AT(t)}function AT(t,e,n){for(var r=(t.mode&1)!==0;Q!==null;){var i=Q,s=i.child;if(i.tag===22&&r){var o=i.memoizedState!==null||mu;if(!o){var a=i.alternate,u=a!==null&&a.memoizedState!==null||Mt;a=mu;var c=Mt;if(mu=o,(Mt=u)&&!c)for(Q=i;Q!==null;)o=Q,u=o.child,o.tag===22&&o.memoizedState!==null?cv(i):u!==null?(u.return=o,Q=u):cv(i);for(;s!==null;)Q=s,AT(s),s=s.sibling;Q=i,mu=a,Mt=c}lv(t)}else i.subtreeFlags&8772&&s!==null?(s.return=i,Q=s):lv(t)}}function lv(t){for(;Q!==null;){var e=Q;if(e.flags&8772){var n=e.alternate;try{if(e.flags&8772)switch(e.tag){case 0:case 11:case 15:Mt||lh(5,e);break;case 1:var r=e.stateNode;if(e.flags&4&&!Mt)if(n===null)r.componentDidMount();else{var i=e.elementType===e.type?n.memoizedProps:An(e.type,n.memoizedProps);r.componentDidUpdate(i,n.memoizedState,r.__reactInternalSnapshotBeforeUpdate)}var s=e.updateQueue;s!==null&&Hy(e,s,r);break;case 3:var o=e.updateQueue;if(o!==null){if(n=null,e.child!==null)switch(e.child.tag){case 5:n=e.child.stateNode;break;case 1:n=e.child.stateNode}Hy(e,o,n)}break;case 5:var a=e.stateNode;if(n===null&&e.flags&4){n=a;var u=e.memoizedProps;switch(e.type){case"button":case"input":case"select":case"textarea":u.autoFocus&&n.focus();break;case"img":u.src&&(n.src=u.src)}}break;case 6:break;case 4:break;case 12:break;case 13:if(e.memoizedState===null){var c=e.alternate;if(c!==null){var h=c.memoizedState;if(h!==null){var f=h.dehydrated;f!==null&&Ba(f)}}}break;case 19:case 17:case 21:case 22:case 23:case 25:break;default:throw Error(B(163))}Mt||e.flags&512&&qf(e)}catch(g){Ye(e,e.return,g)}}if(e===t){Q=null;break}if(n=e.sibling,n!==null){n.return=e.return,Q=n;break}Q=e.return}}function uv(t){for(;Q!==null;){var e=Q;if(e===t){Q=null;break}var n=e.sibling;if(n!==null){n.return=e.return,Q=n;break}Q=e.return}}function cv(t){for(;Q!==null;){var e=Q;try{switch(e.tag){case 0:case 11:case 15:var n=e.return;try{lh(4,e)}catch(u){Ye(e,n,u)}break;case 1:var r=e.stateNode;if(typeof r.componentDidMount=="function"){var i=e.return;try{r.componentDidMount()}catch(u){Ye(e,i,u)}}var s=e.return;try{qf(e)}catch(u){Ye(e,s,u)}break;case 5:var o=e.return;try{qf(e)}catch(u){Ye(e,o,u)}}}catch(u){Ye(e,e.return,u)}if(e===t){Q=null;break}var a=e.sibling;if(a!==null){a.return=e.return,Q=a;break}Q=e.return}}var Mx=Math.ceil,yc=Rr.ReactCurrentDispatcher,Tm=Rr.ReactCurrentOwner,En=Rr.ReactCurrentBatchConfig,ve=0,gt=null,it=null,It=0,sn=0,Ns=_i(0),ct=0,Za=null,$i=0,uh=0,Im=0,Ta=null,Yt=null,Sm=0,to=1/0,rr=null,vc=!1,Kf=null,Jr=null,gu=!1,qr=null,wc=0,Ia=0,Qf=null,Uu=-1,ju=0;function qt(){return ve&6?tt():Uu!==-1?Uu:Uu=tt()}function Zr(t){return t.mode&1?ve&2&&It!==0?It&-It:yx.transition!==null?(ju===0&&(ju=fE()),ju):(t=xe,t!==0||(t=window.event,t=t===void 0?16:wE(t.type)),t):1}function Ln(t,e,n,r){if(50<Ia)throw Ia=0,Qf=null,Error(B(185));gl(t,n,r),(!(ve&2)||t!==gt)&&(t===gt&&(!(ve&2)&&(uh|=n),ct===4&&Vr(t,It)),tn(t,r),n===1&&ve===0&&!(e.mode&1)&&(to=tt()+500,sh&&yi()))}function tn(t,e){var n=t.callbackNode;yR(t,e);var r=rc(t,t===gt?It:0);if(r===0)n!==null&&vy(n),t.callbackNode=null,t.callbackPriority=0;else if(e=r&-r,t.callbackPriority!==e){if(n!=null&&vy(n),e===1)t.tag===0?_x(hv.bind(null,t)):UE(hv.bind(null,t)),fx(function(){!(ve&6)&&yi()}),n=null;else{switch(pE(r)){case 1:n=Yp;break;case 4:n=hE;break;case 16:n=nc;break;case 536870912:n=dE;break;default:n=nc}n=FT(n,bT.bind(null,t))}t.callbackPriority=e,t.callbackNode=n}}function bT(t,e){if(Uu=-1,ju=0,ve&6)throw Error(B(327));var n=t.callbackNode;if(zs()&&t.callbackNode!==n)return null;var r=rc(t,t===gt?It:0);if(r===0)return null;if(r&30||r&t.expiredLanes||e)e=Ec(t,r);else{e=r;var i=ve;ve|=2;var s=NT();(gt!==t||It!==e)&&(rr=null,to=tt()+500,Li(t,e));do try{Vx();break}catch(a){PT(t,a)}while(!0);um(),yc.current=s,ve=i,it!==null?e=0:(gt=null,It=0,e=ct)}if(e!==0){if(e===2&&(i=Tf(t),i!==0&&(r=i,e=Yf(t,i))),e===1)throw n=Za,Li(t,0),Vr(t,r),tn(t,tt()),n;if(e===6)Vr(t,r);else{if(i=t.current.alternate,!(r&30)&&!Lx(i)&&(e=Ec(t,r),e===2&&(s=Tf(t),s!==0&&(r=s,e=Yf(t,s))),e===1))throw n=Za,Li(t,0),Vr(t,r),tn(t,tt()),n;switch(t.finishedWork=i,t.finishedLanes=r,e){case 0:case 1:throw Error(B(345));case 2:Ci(t,Yt,rr);break;case 3:if(Vr(t,r),(r&130023424)===r&&(e=Sm+500-tt(),10<e)){if(rc(t,0)!==0)break;if(i=t.suspendedLanes,(i&r)!==r){qt(),t.pingedLanes|=t.suspendedLanes&i;break}t.timeoutHandle=bf(Ci.bind(null,t,Yt,rr),e);break}Ci(t,Yt,rr);break;case 4:if(Vr(t,r),(r&4194240)===r)break;for(e=t.eventTimes,i=-1;0<r;){var o=31-Mn(r);s=1<<o,o=e[o],o>i&&(i=o),r&=~s}if(r=i,r=tt()-r,r=(120>r?120:480>r?480:1080>r?1080:1920>r?1920:3e3>r?3e3:4320>r?4320:1960*Mx(r/1960))-r,10<r){t.timeoutHandle=bf(Ci.bind(null,t,Yt,rr),r);break}Ci(t,Yt,rr);break;case 5:Ci(t,Yt,rr);break;default:throw Error(B(329))}}}return tn(t,tt()),t.callbackNode===n?bT.bind(null,t):null}function Yf(t,e){var n=Ta;return t.current.memoizedState.isDehydrated&&(Li(t,e).flags|=256),t=Ec(t,e),t!==2&&(e=Yt,Yt=n,e!==null&&Xf(e)),t}function Xf(t){Yt===null?Yt=t:Yt.push.apply(Yt,t)}function Lx(t){for(var e=t;;){if(e.flags&16384){var n=e.updateQueue;if(n!==null&&(n=n.stores,n!==null))for(var r=0;r<n.length;r++){var i=n[r],s=i.getSnapshot;i=i.value;try{if(!Vn(s(),i))return!1}catch{return!1}}}if(n=e.child,e.subtreeFlags&16384&&n!==null)n.return=e,e=n;else{if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return!0;e=e.return}e.sibling.return=e.return,e=e.sibling}}return!0}function Vr(t,e){for(e&=~Im,e&=~uh,t.suspendedLanes|=e,t.pingedLanes&=~e,t=t.expirationTimes;0<e;){var n=31-Mn(e),r=1<<n;t[n]=-1,e&=~r}}function hv(t){if(ve&6)throw Error(B(327));zs();var e=rc(t,0);if(!(e&1))return tn(t,tt()),null;var n=Ec(t,e);if(t.tag!==0&&n===2){var r=Tf(t);r!==0&&(e=r,n=Yf(t,r))}if(n===1)throw n=Za,Li(t,0),Vr(t,e),tn(t,tt()),n;if(n===6)throw Error(B(345));return t.finishedWork=t.current.alternate,t.finishedLanes=e,Ci(t,Yt,rr),tn(t,tt()),null}function km(t,e){var n=ve;ve|=1;try{return t(e)}finally{ve=n,ve===0&&(to=tt()+500,sh&&yi())}}function Wi(t){qr!==null&&qr.tag===0&&!(ve&6)&&zs();var e=ve;ve|=1;var n=En.transition,r=xe;try{if(En.transition=null,xe=1,t)return t()}finally{xe=r,En.transition=n,ve=e,!(ve&6)&&yi()}}function Cm(){sn=Ns.current,ze(Ns)}function Li(t,e){t.finishedWork=null,t.finishedLanes=0;var n=t.timeoutHandle;if(n!==-1&&(t.timeoutHandle=-1,dx(n)),it!==null)for(n=it.return;n!==null;){var r=n;switch(om(r),r.tag){case 1:r=r.type.childContextTypes,r!=null&&lc();break;case 3:Zs(),ze(Zt),ze(Ut),mm();break;case 5:pm(r);break;case 4:Zs();break;case 13:ze(qe);break;case 19:ze(qe);break;case 10:cm(r.type._context);break;case 22:case 23:Cm()}n=n.return}if(gt=t,it=t=ei(t.current,null),It=sn=e,ct=0,Za=null,Im=uh=$i=0,Yt=Ta=null,Pi!==null){for(e=0;e<Pi.length;e++)if(n=Pi[e],r=n.interleaved,r!==null){n.interleaved=null;var i=r.next,s=n.pending;if(s!==null){var o=s.next;s.next=i,r.next=o}n.pending=r}Pi=null}return t}function PT(t,e){do{var n=it;try{if(um(),Lu.current=_c,gc){for(var r=He.memoizedState;r!==null;){var i=r.queue;i!==null&&(i.pending=null),r=r.next}gc=!1}if(Bi=0,pt=lt=He=null,wa=!1,Ya=0,Tm.current=null,n===null||n.return===null){ct=1,Za=e,it=null;break}e:{var s=t,o=n.return,a=n,u=e;if(e=It,a.flags|=32768,u!==null&&typeof u=="object"&&typeof u.then=="function"){var c=u,h=a,f=h.tag;if(!(h.mode&1)&&(f===0||f===11||f===15)){var g=h.alternate;g?(h.updateQueue=g.updateQueue,h.memoizedState=g.memoizedState,h.lanes=g.lanes):(h.updateQueue=null,h.memoizedState=null)}var v=Jy(o);if(v!==null){v.flags&=-257,Zy(v,o,a,s,e),v.mode&1&&Xy(s,c,e),e=v,u=c;var I=e.updateQueue;if(I===null){var N=new Set;N.add(u),e.updateQueue=N}else I.add(u);break e}else{if(!(e&1)){Xy(s,c,e),Rm();break e}u=Error(B(426))}}else if(We&&a.mode&1){var D=Jy(o);if(D!==null){!(D.flags&65536)&&(D.flags|=256),Zy(D,o,a,s,e),am(eo(u,a));break e}}s=u=eo(u,a),ct!==4&&(ct=2),Ta===null?Ta=[s]:Ta.push(s),s=o;do{switch(s.tag){case 3:s.flags|=65536,e&=-e,s.lanes|=e;var C=pT(s,u,e);qy(s,C);break e;case 1:a=u;var w=s.type,R=s.stateNode;if(!(s.flags&128)&&(typeof w.getDerivedStateFromError=="function"||R!==null&&typeof R.componentDidCatch=="function"&&(Jr===null||!Jr.has(R)))){s.flags|=65536,e&=-e,s.lanes|=e;var M=mT(s,a,e);qy(s,M);break e}}s=s.return}while(s!==null)}OT(n)}catch(z){e=z,it===n&&n!==null&&(it=n=n.return);continue}break}while(!0)}function NT(){var t=yc.current;return yc.current=_c,t===null?_c:t}function Rm(){(ct===0||ct===3||ct===2)&&(ct=4),gt===null||!($i&268435455)&&!(uh&268435455)||Vr(gt,It)}function Ec(t,e){var n=ve;ve|=2;var r=NT();(gt!==t||It!==e)&&(rr=null,Li(t,e));do try{Fx();break}catch(i){PT(t,i)}while(!0);if(um(),ve=n,yc.current=r,it!==null)throw Error(B(261));return gt=null,It=0,ct}function Fx(){for(;it!==null;)DT(it)}function Vx(){for(;it!==null&&!uR();)DT(it)}function DT(t){var e=LT(t.alternate,t,sn);t.memoizedProps=t.pendingProps,e===null?OT(t):it=e,Tm.current=null}function OT(t){var e=t;do{var n=e.alternate;if(t=e.return,e.flags&32768){if(n=Px(n,e),n!==null){n.flags&=32767,it=n;return}if(t!==null)t.flags|=32768,t.subtreeFlags=0,t.deletions=null;else{ct=6,it=null;return}}else if(n=bx(n,e,sn),n!==null){it=n;return}if(e=e.sibling,e!==null){it=e;return}it=e=t}while(e!==null);ct===0&&(ct=5)}function Ci(t,e,n){var r=xe,i=En.transition;try{En.transition=null,xe=1,Ux(t,e,n,r)}finally{En.transition=i,xe=r}return null}function Ux(t,e,n,r){do zs();while(qr!==null);if(ve&6)throw Error(B(327));n=t.finishedWork;var i=t.finishedLanes;if(n===null)return null;if(t.finishedWork=null,t.finishedLanes=0,n===t.current)throw Error(B(177));t.callbackNode=null,t.callbackPriority=0;var s=n.lanes|n.childLanes;if(vR(t,s),t===gt&&(it=gt=null,It=0),!(n.subtreeFlags&2064)&&!(n.flags&2064)||gu||(gu=!0,FT(nc,function(){return zs(),null})),s=(n.flags&15990)!==0,n.subtreeFlags&15990||s){s=En.transition,En.transition=null;var o=xe;xe=1;var a=ve;ve|=4,Tm.current=null,Dx(t,n),xT(n,t),sx(xf),ic=!!Rf,xf=Rf=null,t.current=n,Ox(n),cR(),ve=a,xe=o,En.transition=s}else t.current=n;if(gu&&(gu=!1,qr=t,wc=i),s=t.pendingLanes,s===0&&(Jr=null),fR(n.stateNode),tn(t,tt()),e!==null)for(r=t.onRecoverableError,n=0;n<e.length;n++)i=e[n],r(i.value,{componentStack:i.stack,digest:i.digest});if(vc)throw vc=!1,t=Kf,Kf=null,t;return wc&1&&t.tag!==0&&zs(),s=t.pendingLanes,s&1?t===Qf?Ia++:(Ia=0,Qf=t):Ia=0,yi(),null}function zs(){if(qr!==null){var t=pE(wc),e=En.transition,n=xe;try{if(En.transition=null,xe=16>t?16:t,qr===null)var r=!1;else{if(t=qr,qr=null,wc=0,ve&6)throw Error(B(331));var i=ve;for(ve|=4,Q=t.current;Q!==null;){var s=Q,o=s.child;if(Q.flags&16){var a=s.deletions;if(a!==null){for(var u=0;u<a.length;u++){var c=a[u];for(Q=c;Q!==null;){var h=Q;switch(h.tag){case 0:case 11:case 15:Ea(8,h,s)}var f=h.child;if(f!==null)f.return=h,Q=f;else for(;Q!==null;){h=Q;var g=h.sibling,v=h.return;if(kT(h),h===c){Q=null;break}if(g!==null){g.return=v,Q=g;break}Q=v}}}var I=s.alternate;if(I!==null){var N=I.child;if(N!==null){I.child=null;do{var D=N.sibling;N.sibling=null,N=D}while(N!==null)}}Q=s}}if(s.subtreeFlags&2064&&o!==null)o.return=s,Q=o;else e:for(;Q!==null;){if(s=Q,s.flags&2048)switch(s.tag){case 0:case 11:case 15:Ea(9,s,s.return)}var C=s.sibling;if(C!==null){C.return=s.return,Q=C;break e}Q=s.return}}var w=t.current;for(Q=w;Q!==null;){o=Q;var R=o.child;if(o.subtreeFlags&2064&&R!==null)R.return=o,Q=R;else e:for(o=w;Q!==null;){if(a=Q,a.flags&2048)try{switch(a.tag){case 0:case 11:case 15:lh(9,a)}}catch(z){Ye(a,a.return,z)}if(a===o){Q=null;break e}var M=a.sibling;if(M!==null){M.return=a.return,Q=M;break e}Q=a.return}}if(ve=i,yi(),qn&&typeof qn.onPostCommitFiberRoot=="function")try{qn.onPostCommitFiberRoot(eh,t)}catch{}r=!0}return r}finally{xe=n,En.transition=e}}return!1}function dv(t,e,n){e=eo(n,e),e=pT(t,e,1),t=Xr(t,e,1),e=qt(),t!==null&&(gl(t,1,e),tn(t,e))}function Ye(t,e,n){if(t.tag===3)dv(t,t,n);else for(;e!==null;){if(e.tag===3){dv(e,t,n);break}else if(e.tag===1){var r=e.stateNode;if(typeof e.type.getDerivedStateFromError=="function"||typeof r.componentDidCatch=="function"&&(Jr===null||!Jr.has(r))){t=eo(n,t),t=mT(e,t,1),e=Xr(e,t,1),t=qt(),e!==null&&(gl(e,1,t),tn(e,t));break}}e=e.return}}function jx(t,e,n){var r=t.pingCache;r!==null&&r.delete(e),e=qt(),t.pingedLanes|=t.suspendedLanes&n,gt===t&&(It&n)===n&&(ct===4||ct===3&&(It&130023424)===It&&500>tt()-Sm?Li(t,0):Im|=n),tn(t,e)}function MT(t,e){e===0&&(t.mode&1?(e=ou,ou<<=1,!(ou&130023424)&&(ou=4194304)):e=1);var n=qt();t=_r(t,e),t!==null&&(gl(t,e,n),tn(t,n))}function zx(t){var e=t.memoizedState,n=0;e!==null&&(n=e.retryLane),MT(t,n)}function Bx(t,e){var n=0;switch(t.tag){case 13:var r=t.stateNode,i=t.memoizedState;i!==null&&(n=i.retryLane);break;case 19:r=t.stateNode;break;default:throw Error(B(314))}r!==null&&r.delete(e),MT(t,n)}var LT;LT=function(t,e,n){if(t!==null)if(t.memoizedProps!==e.pendingProps||Zt.current)Xt=!0;else{if(!(t.lanes&n)&&!(e.flags&128))return Xt=!1,Ax(t,e,n);Xt=!!(t.flags&131072)}else Xt=!1,We&&e.flags&1048576&&jE(e,hc,e.index);switch(e.lanes=0,e.tag){case 2:var r=e.type;Vu(t,e),t=e.pendingProps;var i=Ys(e,Ut.current);js(e,n),i=_m(null,e,r,t,i,n);var s=ym();return e.flags|=1,typeof i=="object"&&i!==null&&typeof i.render=="function"&&i.$$typeof===void 0?(e.tag=1,e.memoizedState=null,e.updateQueue=null,en(r)?(s=!0,uc(e)):s=!1,e.memoizedState=i.state!==null&&i.state!==void 0?i.state:null,dm(e),i.updater=ah,e.stateNode=i,i._reactInternals=e,Ff(e,r,t,n),e=jf(null,e,r,!0,s,n)):(e.tag=0,We&&s&&sm(e),Wt(null,e,i,n),e=e.child),e;case 16:r=e.elementType;e:{switch(Vu(t,e),t=e.pendingProps,i=r._init,r=i(r._payload),e.type=r,i=e.tag=Wx(r),t=An(r,t),i){case 0:e=Uf(null,e,r,t,n);break e;case 1:e=nv(null,e,r,t,n);break e;case 11:e=ev(null,e,r,t,n);break e;case 14:e=tv(null,e,r,An(r.type,t),n);break e}throw Error(B(306,r,""))}return e;case 0:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Uf(t,e,r,i,n);case 1:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),nv(t,e,r,i,n);case 3:e:{if(vT(e),t===null)throw Error(B(387));r=e.pendingProps,s=e.memoizedState,i=s.element,HE(t,e),pc(e,r,null,n);var o=e.memoizedState;if(r=o.element,s.isDehydrated)if(s={element:r,isDehydrated:!1,cache:o.cache,pendingSuspenseBoundaries:o.pendingSuspenseBoundaries,transitions:o.transitions},e.updateQueue.baseState=s,e.memoizedState=s,e.flags&256){i=eo(Error(B(423)),e),e=rv(t,e,r,n,i);break e}else if(r!==i){i=eo(Error(B(424)),e),e=rv(t,e,r,n,i);break e}else for(an=Yr(e.stateNode.containerInfo.firstChild),un=e,We=!0,Pn=null,n=WE(e,null,r,n),e.child=n;n;)n.flags=n.flags&-3|4096,n=n.sibling;else{if(Xs(),r===i){e=yr(t,e,n);break e}Wt(t,e,r,n)}e=e.child}return e;case 5:return GE(e),t===null&&Of(e),r=e.type,i=e.pendingProps,s=t!==null?t.memoizedProps:null,o=i.children,Af(r,i)?o=null:s!==null&&Af(r,s)&&(e.flags|=32),yT(t,e),Wt(t,e,o,n),e.child;case 6:return t===null&&Of(e),null;case 13:return wT(t,e,n);case 4:return fm(e,e.stateNode.containerInfo),r=e.pendingProps,t===null?e.child=Js(e,null,r,n):Wt(t,e,r,n),e.child;case 11:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),ev(t,e,r,i,n);case 7:return Wt(t,e,e.pendingProps,n),e.child;case 8:return Wt(t,e,e.pendingProps.children,n),e.child;case 12:return Wt(t,e,e.pendingProps.children,n),e.child;case 10:e:{if(r=e.type._context,i=e.pendingProps,s=e.memoizedProps,o=i.value,Me(dc,r._currentValue),r._currentValue=o,s!==null)if(Vn(s.value,o)){if(s.children===i.children&&!Zt.current){e=yr(t,e,n);break e}}else for(s=e.child,s!==null&&(s.return=e);s!==null;){var a=s.dependencies;if(a!==null){o=s.child;for(var u=a.firstContext;u!==null;){if(u.context===r){if(s.tag===1){u=dr(-1,n&-n),u.tag=2;var c=s.updateQueue;if(c!==null){c=c.shared;var h=c.pending;h===null?u.next=u:(u.next=h.next,h.next=u),c.pending=u}}s.lanes|=n,u=s.alternate,u!==null&&(u.lanes|=n),Mf(s.return,n,e),a.lanes|=n;break}u=u.next}}else if(s.tag===10)o=s.type===e.type?null:s.child;else if(s.tag===18){if(o=s.return,o===null)throw Error(B(341));o.lanes|=n,a=o.alternate,a!==null&&(a.lanes|=n),Mf(o,n,e),o=s.sibling}else o=s.child;if(o!==null)o.return=s;else for(o=s;o!==null;){if(o===e){o=null;break}if(s=o.sibling,s!==null){s.return=o.return,o=s;break}o=o.return}s=o}Wt(t,e,i.children,n),e=e.child}return e;case 9:return i=e.type,r=e.pendingProps.children,js(e,n),i=Sn(i),r=r(i),e.flags|=1,Wt(t,e,r,n),e.child;case 14:return r=e.type,i=An(r,e.pendingProps),i=An(r.type,i),tv(t,e,r,i,n);case 15:return gT(t,e,e.type,e.pendingProps,n);case 17:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:An(r,i),Vu(t,e),e.tag=1,en(r)?(t=!0,uc(e)):t=!1,js(e,n),fT(e,r,i),Ff(e,r,i,n),jf(null,e,r,!0,t,n);case 19:return ET(t,e,n);case 22:return _T(t,e,n)}throw Error(B(156,e.tag))};function FT(t,e){return cE(t,e)}function $x(t,e,n,r){this.tag=t,this.key=n,this.sibling=this.child=this.return=this.stateNode=this.type=this.elementType=null,this.index=0,this.ref=null,this.pendingProps=e,this.dependencies=this.memoizedState=this.updateQueue=this.memoizedProps=null,this.mode=r,this.subtreeFlags=this.flags=0,this.deletions=null,this.childLanes=this.lanes=0,this.alternate=null}function _n(t,e,n,r){return new $x(t,e,n,r)}function xm(t){return t=t.prototype,!(!t||!t.isReactComponent)}function Wx(t){if(typeof t=="function")return xm(t)?1:0;if(t!=null){if(t=t.$$typeof,t===Gp)return 11;if(t===Kp)return 14}return 2}function ei(t,e){var n=t.alternate;return n===null?(n=_n(t.tag,e,t.key,t.mode),n.elementType=t.elementType,n.type=t.type,n.stateNode=t.stateNode,n.alternate=t,t.alternate=n):(n.pendingProps=e,n.type=t.type,n.flags=0,n.subtreeFlags=0,n.deletions=null),n.flags=t.flags&14680064,n.childLanes=t.childLanes,n.lanes=t.lanes,n.child=t.child,n.memoizedProps=t.memoizedProps,n.memoizedState=t.memoizedState,n.updateQueue=t.updateQueue,e=t.dependencies,n.dependencies=e===null?null:{lanes:e.lanes,firstContext:e.firstContext},n.sibling=t.sibling,n.index=t.index,n.ref=t.ref,n}function zu(t,e,n,r,i,s){var o=2;if(r=t,typeof t=="function")xm(t)&&(o=1);else if(typeof t=="string")o=5;else e:switch(t){case Ts:return Fi(n.children,i,s,e);case Hp:o=8,i|=8;break;case af:return t=_n(12,n,e,i|2),t.elementType=af,t.lanes=s,t;case lf:return t=_n(13,n,e,i),t.elementType=lf,t.lanes=s,t;case uf:return t=_n(19,n,e,i),t.elementType=uf,t.lanes=s,t;case Gw:return ch(n,i,s,e);default:if(typeof t=="object"&&t!==null)switch(t.$$typeof){case qw:o=10;break e;case Hw:o=9;break e;case Gp:o=11;break e;case Kp:o=14;break e;case Mr:o=16,r=null;break e}throw Error(B(130,t==null?t:typeof t,""))}return e=_n(o,n,e,i),e.elementType=t,e.type=r,e.lanes=s,e}function Fi(t,e,n,r){return t=_n(7,t,r,e),t.lanes=n,t}function ch(t,e,n,r){return t=_n(22,t,r,e),t.elementType=Gw,t.lanes=n,t.stateNode={isHidden:!1},t}function Nd(t,e,n){return t=_n(6,t,null,e),t.lanes=n,t}function Dd(t,e,n){return e=_n(4,t.children!==null?t.children:[],t.key,e),e.lanes=n,e.stateNode={containerInfo:t.containerInfo,pendingChildren:null,implementation:t.implementation},e}function qx(t,e,n,r,i){this.tag=e,this.containerInfo=t,this.finishedWork=this.pingCache=this.current=this.pendingChildren=null,this.timeoutHandle=-1,this.callbackNode=this.pendingContext=this.context=null,this.callbackPriority=0,this.eventTimes=fd(0),this.expirationTimes=fd(-1),this.entangledLanes=this.finishedLanes=this.mutableReadLanes=this.expiredLanes=this.pingedLanes=this.suspendedLanes=this.pendingLanes=0,this.entanglements=fd(0),this.identifierPrefix=r,this.onRecoverableError=i,this.mutableSourceEagerHydrationData=null}function Am(t,e,n,r,i,s,o,a,u){return t=new qx(t,e,n,a,u),e===1?(e=1,s===!0&&(e|=8)):e=0,s=_n(3,null,null,e),t.current=s,s.stateNode=t,s.memoizedState={element:r,isDehydrated:n,cache:null,transitions:null,pendingSuspenseBoundaries:null},dm(s),t}function Hx(t,e,n){var r=3<arguments.length&&arguments[3]!==void 0?arguments[3]:null;return{$$typeof:Es,key:r==null?null:""+r,children:t,containerInfo:e,implementation:n}}function VT(t){if(!t)return ui;t=t._reactInternals;e:{if(ts(t)!==t||t.tag!==1)throw Error(B(170));var e=t;do{switch(e.tag){case 3:e=e.stateNode.context;break e;case 1:if(en(e.type)){e=e.stateNode.__reactInternalMemoizedMergedChildContext;break e}}e=e.return}while(e!==null);throw Error(B(171))}if(t.tag===1){var n=t.type;if(en(n))return VE(t,n,e)}return e}function UT(t,e,n,r,i,s,o,a,u){return t=Am(n,r,!0,t,i,s,o,a,u),t.context=VT(null),n=t.current,r=qt(),i=Zr(n),s=dr(r,i),s.callback=e??null,Xr(n,s,i),t.current.lanes=i,gl(t,i,r),tn(t,r),t}function hh(t,e,n,r){var i=e.current,s=qt(),o=Zr(i);return n=VT(n),e.context===null?e.context=n:e.pendingContext=n,e=dr(s,o),e.payload={element:t},r=r===void 0?null:r,r!==null&&(e.callback=r),t=Xr(i,e,o),t!==null&&(Ln(t,i,o,s),Mu(t,i,o)),o}function Tc(t){if(t=t.current,!t.child)return null;switch(t.child.tag){case 5:return t.child.stateNode;default:return t.child.stateNode}}function fv(t,e){if(t=t.memoizedState,t!==null&&t.dehydrated!==null){var n=t.retryLane;t.retryLane=n!==0&&n<e?n:e}}function bm(t,e){fv(t,e),(t=t.alternate)&&fv(t,e)}function Gx(){return null}var jT=typeof reportError=="function"?reportError:function(t){console.error(t)};function Pm(t){this._internalRoot=t}dh.prototype.render=Pm.prototype.render=function(t){var e=this._internalRoot;if(e===null)throw Error(B(409));hh(t,e,null,null)};dh.prototype.unmount=Pm.prototype.unmount=function(){var t=this._internalRoot;if(t!==null){this._internalRoot=null;var e=t.containerInfo;Wi(function(){hh(null,t,null,null)}),e[gr]=null}};function dh(t){this._internalRoot=t}dh.prototype.unstable_scheduleHydration=function(t){if(t){var e=_E();t={blockedOn:null,target:t,priority:e};for(var n=0;n<Fr.length&&e!==0&&e<Fr[n].priority;n++);Fr.splice(n,0,t),n===0&&vE(t)}};function Nm(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11)}function fh(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11&&(t.nodeType!==8||t.nodeValue!==" react-mount-point-unstable "))}function pv(){}function Kx(t,e,n,r,i){if(i){if(typeof r=="function"){var s=r;r=function(){var c=Tc(o);s.call(c)}}var o=UT(e,r,t,0,null,!1,!1,"",pv);return t._reactRootContainer=o,t[gr]=o.current,qa(t.nodeType===8?t.parentNode:t),Wi(),o}for(;i=t.lastChild;)t.removeChild(i);if(typeof r=="function"){var a=r;r=function(){var c=Tc(u);a.call(c)}}var u=Am(t,0,!1,null,null,!1,!1,"",pv);return t._reactRootContainer=u,t[gr]=u.current,qa(t.nodeType===8?t.parentNode:t),Wi(function(){hh(e,u,n,r)}),u}function ph(t,e,n,r,i){var s=n._reactRootContainer;if(s){var o=s;if(typeof i=="function"){var a=i;i=function(){var u=Tc(o);a.call(u)}}hh(e,o,t,i)}else o=Kx(n,e,t,i,r);return Tc(o)}mE=function(t){switch(t.tag){case 3:var e=t.stateNode;if(e.current.memoizedState.isDehydrated){var n=ua(e.pendingLanes);n!==0&&(Xp(e,n|1),tn(e,tt()),!(ve&6)&&(to=tt()+500,yi()))}break;case 13:Wi(function(){var r=_r(t,1);if(r!==null){var i=qt();Ln(r,t,1,i)}}),bm(t,1)}};Jp=function(t){if(t.tag===13){var e=_r(t,134217728);if(e!==null){var n=qt();Ln(e,t,134217728,n)}bm(t,134217728)}};gE=function(t){if(t.tag===13){var e=Zr(t),n=_r(t,e);if(n!==null){var r=qt();Ln(n,t,e,r)}bm(t,e)}};_E=function(){return xe};yE=function(t,e){var n=xe;try{return xe=t,e()}finally{xe=n}};vf=function(t,e,n){switch(e){case"input":if(df(t,n),e=n.name,n.type==="radio"&&e!=null){for(n=t;n.parentNode;)n=n.parentNode;for(n=n.querySelectorAll("input[name="+JSON.stringify(""+e)+'][type="radio"]'),e=0;e<n.length;e++){var r=n[e];if(r!==t&&r.form===t.form){var i=ih(r);if(!i)throw Error(B(90));Qw(r),df(r,i)}}}break;case"textarea":Xw(t,n);break;case"select":e=n.value,e!=null&&Ls(t,!!n.multiple,e,!1)}};iE=km;sE=Wi;var Qx={usingClientEntryPoint:!1,Events:[yl,Cs,ih,nE,rE,km]},Jo={findFiberByHostInstance:bi,bundleType:0,version:"18.3.1",rendererPackageName:"react-dom"},Yx={bundleType:Jo.bundleType,version:Jo.version,rendererPackageName:Jo.rendererPackageName,rendererConfig:Jo.rendererConfig,overrideHookState:null,overrideHookStateDeletePath:null,overrideHookStateRenamePath:null,overrideProps:null,overridePropsDeletePath:null,overridePropsRenamePath:null,setErrorHandler:null,setSuspenseHandler:null,scheduleUpdate:null,currentDispatcherRef:Rr.ReactCurrentDispatcher,findHostInstanceByFiber:function(t){return t=lE(t),t===null?null:t.stateNode},findFiberByHostInstance:Jo.findFiberByHostInstance||Gx,findHostInstancesForRefresh:null,scheduleRefresh:null,scheduleRoot:null,setRefreshHandler:null,getCurrentFiber:null,reconcilerVersion:"18.3.1-next-f1338f8080-20240426"};if(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__<"u"){var _u=__REACT_DEVTOOLS_GLOBAL_HOOK__;if(!_u.isDisabled&&_u.supportsFiber)try{eh=_u.inject(Yx),qn=_u}catch{}}hn.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=Qx;hn.createPortal=function(t,e){var n=2<arguments.length&&arguments[2]!==void 0?arguments[2]:null;if(!Nm(e))throw Error(B(200));return Hx(t,e,null,n)};hn.createRoot=function(t,e){if(!Nm(t))throw Error(B(299));var n=!1,r="",i=jT;return e!=null&&(e.unstable_strictMode===!0&&(n=!0),e.identifierPrefix!==void 0&&(r=e.identifierPrefix),e.onRecoverableError!==void 0&&(i=e.onRecoverableError)),e=Am(t,1,!1,null,null,n,!1,r,i),t[gr]=e.current,qa(t.nodeType===8?t.parentNode:t),new Pm(e)};hn.findDOMNode=function(t){if(t==null)return null;if(t.nodeType===1)return t;var e=t._reactInternals;if(e===void 0)throw typeof t.render=="function"?Error(B(188)):(t=Object.keys(t).join(","),Error(B(268,t)));return t=lE(e),t=t===null?null:t.stateNode,t};hn.flushSync=function(t){return Wi(t)};hn.hydrate=function(t,e,n){if(!fh(e))throw Error(B(200));return ph(null,t,e,!0,n)};hn.hydrateRoot=function(t,e,n){if(!Nm(t))throw Error(B(405));var r=n!=null&&n.hydratedSources||null,i=!1,s="",o=jT;if(n!=null&&(n.unstable_strictMode===!0&&(i=!0),n.identifierPrefix!==void 0&&(s=n.identifierPrefix),n.onRecoverableError!==void 0&&(o=n.onRecoverableError)),e=UT(e,null,t,1,n??null,i,!1,s,o),t[gr]=e.current,qa(t),r)for(t=0;t<r.length;t++)n=r[t],i=n._getVersion,i=i(n._source),e.mutableSourceEagerHydrationData==null?e.mutableSourceEagerHydrationData=[n,i]:e.mutableSourceEagerHydrationData.push(n,i);return new dh(e)};hn.render=function(t,e,n){if(!fh(e))throw Error(B(200));return ph(null,t,e,!1,n)};hn.unmountComponentAtNode=function(t){if(!fh(t))throw Error(B(40));return t._reactRootContainer?(Wi(function(){ph(null,null,t,!1,function(){t._reactRootContainer=null,t[gr]=null})}),!0):!1};hn.unstable_batchedUpdates=km;hn.unstable_renderSubtreeIntoContainer=function(t,e,n,r){if(!fh(n))throw Error(B(200));if(t==null||t._reactInternals===void 0)throw Error(B(38));return ph(t,e,n,!1,r)};hn.version="18.3.1-next-f1338f8080-20240426";function zT(){if(!(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__>"u"||typeof __REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE!="function"))try{__REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE(zT)}catch(t){console.error(t)}}zT(),zw.exports=hn;var Xx=zw.exports,mv=Xx;sf.createRoot=mv.createRoot,sf.hydrateRoot=mv.hydrateRoot;/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Jx=t=>t.replace(/([a-z0-9])([A-Z])/g,"$1-$2").toLowerCase(),BT=(...t)=>t.filter((e,n,r)=>!!e&&r.indexOf(e)===n).join(" ");/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */var Zx={xmlns:"http://www.w3.org/2000/svg",width:24,height:24,viewBox:"0 0 24 24",fill:"none",stroke:"currentColor",strokeWidth:2,strokeLinecap:"round",strokeLinejoin:"round"};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const eA=ne.forwardRef(({color:t="currentColor",size:e=24,strokeWidth:n=2,absoluteStrokeWidth:r,className:i="",children:s,iconNode:o,...a},u)=>ne.createElement("svg",{ref:u,...Zx,width:e,height:e,stroke:t,strokeWidth:r?Number(n)*24/Number(e):n,className:BT("lucide",i),...a},[...o.map(([c,h])=>ne.createElement(c,h)),...Array.isArray(s)?s:[s]]));/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ge=(t,e)=>{const n=ne.forwardRef(({className:r,...i},s)=>ne.createElement(eA,{ref:s,iconNode:e,className:BT(`lucide-${Jx(t)}`,r),...i}));return n.displayName=`${t}`,n};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const tA=ge("ArrowLeft",[["path",{d:"m12 19-7-7 7-7",key:"1l729n"}],["path",{d:"M19 12H5",key:"x3x0zl"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const nA=ge("ArrowRight",[["path",{d:"M5 12h14",key:"1ays0h"}],["path",{d:"m12 5 7 7-7 7",key:"xquz4c"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const no=ge("BookOpen",[["path",{d:"M12 7v14",key:"1akyts"}],["path",{d:"M3 18a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h5a4 4 0 0 1 4 4 4 4 0 0 1 4-4h5a1 1 0 0 1 1 1v13a1 1 0 0 1-1 1h-6a3 3 0 0 0-3 3 3 3 0 0 0-3-3z",key:"ruj8y"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Ds=ge("Check",[["path",{d:"M20 6 9 17l-5-5",key:"1gmf2c"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const rA=ge("ChevronDown",[["path",{d:"m6 9 6 6 6-6",key:"qrunsl"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const iA=ge("ChevronUp",[["path",{d:"m18 15-6-6-6 6",key:"153udz"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const sA=ge("CircleAlert",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["line",{x1:"12",x2:"12",y1:"8",y2:"12",key:"1pkeuh"}],["line",{x1:"12",x2:"12.01",y1:"16",y2:"16",key:"4dfq90"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const oA=ge("CircleCheck",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"m9 12 2 2 4-4",key:"dzmm74"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const gv=ge("CirclePlay",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["polygon",{points:"10 8 16 12 10 16 10 8",key:"1cimsy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const aA=ge("Clock",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["polyline",{points:"12 6 12 12 16 14",key:"68esgv"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Dm=ge("CloudUpload",[["path",{d:"M12 13v8",key:"1l5pq0"}],["path",{d:"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242",key:"1pljnt"}],["path",{d:"m8 17 4-4 4 4",key:"1quai1"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const _v=ge("Copy",[["rect",{width:"14",height:"14",x:"8",y:"8",rx:"2",ry:"2",key:"17jyea"}],["path",{d:"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2",key:"zix9uf"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const lA=ge("Database",[["ellipse",{cx:"12",cy:"5",rx:"9",ry:"3",key:"msslwz"}],["path",{d:"M3 5V19A9 3 0 0 0 21 19V5",key:"1wlel7"}],["path",{d:"M3 12A9 3 0 0 0 21 12",key:"mv7ke4"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const yv=ge("ExternalLink",[["path",{d:"M15 3h6v6",key:"1q9fwt"}],["path",{d:"M10 14 21 3",key:"gplh6r"}],["path",{d:"M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6",key:"a6xqqp"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Om=ge("FileCode",[["path",{d:"M10 12.5 8 15l2 2.5",key:"1tg20x"}],["path",{d:"m14 12.5 2 2.5-2 2.5",key:"yinavb"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7z",key:"1mlx9k"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const el=ge("FileText",[["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z",key:"1rqfz7"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M10 9H8",key:"b1mrlr"}],["path",{d:"M16 13H8",key:"t4e002"}],["path",{d:"M16 17H8",key:"z1uh3a"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Jf=ge("GraduationCap",[["path",{d:"M21.42 10.922a1 1 0 0 0-.019-1.838L12.83 5.18a2 2 0 0 0-1.66 0L2.6 9.08a1 1 0 0 0 0 1.832l8.57 3.908a2 2 0 0 0 1.66 0z",key:"j76jl0"}],["path",{d:"M22 10v6",key:"1lu8f3"}],["path",{d:"M6 12.5V16a6 3 0 0 0 12 0v-3.5",key:"1r8lef"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const uA=ge("HardDrive",[["line",{x1:"22",x2:"2",y1:"12",y2:"12",key:"1y58io"}],["path",{d:"M5.45 5.11 2 12v6a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-6l-3.45-6.89A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z",key:"oot6mr"}],["line",{x1:"6",x2:"6.01",y1:"16",y2:"16",key:"sgf278"}],["line",{x1:"10",x2:"10.01",y1:"16",y2:"16",key:"1l4acy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const cA=ge("Headphones",[["path",{d:"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3",key:"1xhozi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const hA=ge("Image",[["rect",{width:"18",height:"18",x:"3",y:"3",rx:"2",ry:"2",key:"1m3agn"}],["circle",{cx:"9",cy:"9",r:"2",key:"af1f0g"}],["path",{d:"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21",key:"1xmnt7"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const $T=ge("Info",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"M12 16v-4",key:"1dtifu"}],["path",{d:"M12 8h.01",key:"e9boi3"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const dA=ge("Library",[["path",{d:"m16 6 4 14",key:"ji33uf"}],["path",{d:"M12 6v14",key:"1n7gus"}],["path",{d:"M8 8v12",key:"1gg7y9"}],["path",{d:"M4 4v16",key:"6qkkli"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Bu=ge("Link2",[["path",{d:"M9 17H7A5 5 0 0 1 7 7h2",key:"8i5ue5"}],["path",{d:"M15 7h2a5 5 0 1 1 0 10h-2",key:"1b9ql8"}],["line",{x1:"8",x2:"16",y1:"12",y2:"12",key:"1jonct"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const fA=ge("LoaderCircle",[["path",{d:"M21 12a9 9 0 1 1-6.219-8.56",key:"13zald"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const pA=ge("PenLine",[["path",{d:"M12 20h9",key:"t2du7b"}],["path",{d:"M16.376 3.622a1 1 0 0 1 3.002 3.002L7.368 18.635a2 2 0 0 1-.855.506l-2.872.838a.5.5 0 0 1-.62-.62l.838-2.872a2 2 0 0 1 .506-.854z",key:"1ykcvy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Ic=ge("RefreshCw",[["path",{d:"M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8",key:"v9h5vc"}],["path",{d:"M21 3v5h-5",key:"1q7to0"}],["path",{d:"M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16",key:"3uifl3"}],["path",{d:"M8 16H3v5",key:"1cv678"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const WT=ge("Search",[["circle",{cx:"11",cy:"11",r:"8",key:"4ej97u"}],["path",{d:"m21 21-4.3-4.3",key:"1qie3q"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const mA=ge("ShieldAlert",[["path",{d:"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z",key:"oel41y"}],["path",{d:"M12 8v4",key:"1got3b"}],["path",{d:"M12 16h.01",key:"1drbdi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const vv=ge("Sparkles",[["path",{d:"M9.937 15.5A2 2 0 0 0 8.5 14.063l-6.135-1.582a.5.5 0 0 1 0-.962L8.5 9.936A2 2 0 0 0 9.937 8.5l1.582-6.135a.5.5 0 0 1 .963 0L14.063 8.5A2 2 0 0 0 15.5 9.937l6.135 1.581a.5.5 0 0 1 0 .964L15.5 14.063a2 2 0 0 0-1.437 1.437l-1.582 6.135a.5.5 0 0 1-.963 0z",key:"4pj2yx"}],["path",{d:"M20 3v4",key:"1olli1"}],["path",{d:"M22 5h-4",key:"1gvqau"}],["path",{d:"M4 17v2",key:"vumght"}],["path",{d:"M5 18H3",key:"zchphs"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const gA=ge("Star",[["polygon",{points:"12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2",key:"8f66p6"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const _A=ge("Tag",[["path",{d:"M12.586 2.586A2 2 0 0 0 11.172 2H4a2 2 0 0 0-2 2v7.172a2 2 0 0 0 .586 1.414l8.704 8.704a2.426 2.426 0 0 0 3.42 0l6.58-6.58a2.426 2.426 0 0 0 0-3.42z",key:"vktsd0"}],["circle",{cx:"7.5",cy:"7.5",r:".5",fill:"currentColor",key:"kqv944"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ha=ge("Trash2",[["path",{d:"M3 6h18",key:"d0wm0j"}],["path",{d:"M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6",key:"4alrt4"}],["path",{d:"M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2",key:"v07s0e"}],["line",{x1:"10",x2:"10",y1:"11",y2:"17",key:"1uufr5"}],["line",{x1:"14",x2:"14",y1:"11",y2:"17",key:"xtxkd"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const yA=ge("TriangleAlert",[["path",{d:"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3",key:"wmoenq"}],["path",{d:"M12 9v4",key:"juzpu7"}],["path",{d:"M12 17h.01",key:"p32p05"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const vA=ge("Users",[["path",{d:"M16 21v-2a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v2",key:"1yyitq"}],["circle",{cx:"9",cy:"7",r:"4",key:"nufk8"}],["path",{d:"M22 21v-2a4 4 0 0 0-3-3.87",key:"kshegd"}],["path",{d:"M16 3.13a4 4 0 0 1 0 7.75",key:"1da9ce"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const qT=ge("X",[["path",{d:"M18 6 6 18",key:"1bl5f8"}],["path",{d:"m6 6 12 12",key:"d8bk6v"}]]);var wv={};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const HT={NODE_ADMIN:!1,SDK_VERSION:"${JSCORE_VERSION}"};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const G=function(t,e){if(!t)throw _o(e)},_o=function(t){return new Error("Firebase Database ("+HT.SDK_VERSION+") INTERNAL ASSERT FAILED: "+t)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const GT=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):(i&64512)===55296&&r+1<t.length&&(t.charCodeAt(r+1)&64512)===56320?(i=65536+((i&1023)<<10)+(t.charCodeAt(++r)&1023),e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},wA=function(t){const e=[];let n=0,r=0;for(;n<t.length;){const i=t[n++];if(i<128)e[r++]=String.fromCharCode(i);else if(i>191&&i<224){const s=t[n++];e[r++]=String.fromCharCode((i&31)<<6|s&63)}else if(i>239&&i<365){const s=t[n++],o=t[n++],a=t[n++],u=((i&7)<<18|(s&63)<<12|(o&63)<<6|a&63)-65536;e[r++]=String.fromCharCode(55296+(u>>10)),e[r++]=String.fromCharCode(56320+(u&1023))}else{const s=t[n++],o=t[n++];e[r++]=String.fromCharCode((i&15)<<12|(s&63)<<6|o&63)}}return e.join("")},Mm={byteToCharMap_:null,charToByteMap_:null,byteToCharMapWebSafe_:null,charToByteMapWebSafe_:null,ENCODED_VALS_BASE:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",get ENCODED_VALS(){return this.ENCODED_VALS_BASE+"+/="},get ENCODED_VALS_WEBSAFE(){return this.ENCODED_VALS_BASE+"-_."},HAS_NATIVE_SUPPORT:typeof atob=="function",encodeByteArray(t,e){if(!Array.isArray(t))throw Error("encodeByteArray takes an array as a parameter");this.init_();const n=e?this.byteToCharMapWebSafe_:this.byteToCharMap_,r=[];for(let i=0;i<t.length;i+=3){const s=t[i],o=i+1<t.length,a=o?t[i+1]:0,u=i+2<t.length,c=u?t[i+2]:0,h=s>>2,f=(s&3)<<4|a>>4;let g=(a&15)<<2|c>>6,v=c&63;u||(v=64,o||(g=64)),r.push(n[h],n[f],n[g],n[v])}return r.join("")},encodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?btoa(t):this.encodeByteArray(GT(t),e)},decodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?atob(t):wA(this.decodeStringToByteArray(t,e))},decodeStringToByteArray(t,e){this.init_();const n=e?this.charToByteMapWebSafe_:this.charToByteMap_,r=[];for(let i=0;i<t.length;){const s=n[t.charAt(i++)],a=i<t.length?n[t.charAt(i)]:0;++i;const c=i<t.length?n[t.charAt(i)]:64;++i;const f=i<t.length?n[t.charAt(i)]:64;if(++i,s==null||a==null||c==null||f==null)throw new EA;const g=s<<2|a>>4;if(r.push(g),c!==64){const v=a<<4&240|c>>2;if(r.push(v),f!==64){const I=c<<6&192|f;r.push(I)}}}return r},init_(){if(!this.byteToCharMap_){this.byteToCharMap_={},this.charToByteMap_={},this.byteToCharMapWebSafe_={},this.charToByteMapWebSafe_={};for(let t=0;t<this.ENCODED_VALS.length;t++)this.byteToCharMap_[t]=this.ENCODED_VALS.charAt(t),this.charToByteMap_[this.byteToCharMap_[t]]=t,this.byteToCharMapWebSafe_[t]=this.ENCODED_VALS_WEBSAFE.charAt(t),this.charToByteMapWebSafe_[this.byteToCharMapWebSafe_[t]]=t,t>=this.ENCODED_VALS_BASE.length&&(this.charToByteMap_[this.ENCODED_VALS_WEBSAFE.charAt(t)]=t,this.charToByteMapWebSafe_[this.ENCODED_VALS.charAt(t)]=t)}}};class EA extends Error{constructor(){super(...arguments),this.name="DecodeBase64StringError"}}const KT=function(t){const e=GT(t);return Mm.encodeByteArray(e,!0)},Sc=function(t){return KT(t).replace(/\./g,"")},kc=function(t){try{return Mm.decodeString(t,!0)}catch(e){console.error("base64Decode failed: ",e)}return null};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function TA(t){return QT(void 0,t)}function QT(t,e){if(!(e instanceof Object))return e;switch(e.constructor){case Date:const n=e;return new Date(n.getTime());case Object:t===void 0&&(t={});break;case Array:t=[];break;default:return e}for(const n in e)!e.hasOwnProperty(n)||!IA(n)||(t[n]=QT(t[n],e[n]));return t}function IA(t){return t!=="__proto__"}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function SA(){if(typeof self<"u")return self;if(typeof window<"u")return window;if(typeof global<"u")return global;throw new Error("Unable to locate global object.")}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const kA=()=>SA().__FIREBASE_DEFAULTS__,CA=()=>{if(typeof process>"u"||typeof wv>"u")return;const t=wv.__FIREBASE_DEFAULTS__;if(t)return JSON.parse(t)},RA=()=>{if(typeof document>"u")return;let t;try{t=document.cookie.match(/__FIREBASE_DEFAULTS__=([^;]+)/)}catch{return}const e=t&&kc(t[1]);return e&&JSON.parse(e)},mh=()=>{try{return kA()||CA()||RA()}catch(t){console.info(`Unable to get __FIREBASE_DEFAULTS__ due to: ${t}`);return}},YT=t=>{var e,n;return(n=(e=mh())===null||e===void 0?void 0:e.emulatorHosts)===null||n===void 0?void 0:n[t]},Lm=t=>{const e=YT(t);if(!e)return;const n=e.lastIndexOf(":");if(n<=0||n+1===e.length)throw new Error(`Invalid host ${e} with no separate hostname and port!`);const r=parseInt(e.substring(n+1),10);return e[0]==="["?[e.substring(1,n-1),r]:[e.substring(0,n),r]},XT=()=>{var t;return(t=mh())===null||t===void 0?void 0:t.config},JT=t=>{var e;return(e=mh())===null||e===void 0?void 0:e[`_${t}`]};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class gh{constructor(){this.reject=()=>{},this.resolve=()=>{},this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}wrapCallback(e){return(n,r)=>{n?this.reject(n):this.resolve(r),typeof e=="function"&&(this.promise.catch(()=>{}),e.length===1?e(n):e(n,r))}}}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Fm(t,e){if(t.uid)throw new Error('The "uid" field is no longer supported by mockUserToken. Please use "sub" instead for Firebase Auth User ID.');const n={alg:"none",type:"JWT"},r=e||"demo-project",i=t.iat||0,s=t.sub||t.user_id;if(!s)throw new Error("mockUserToken must contain 'sub' or 'user_id' field!");const o=Object.assign({iss:`https://securetoken.google.com/${r}`,aud:r,iat:i,exp:i+3600,auth_time:i,sub:s,user_id:s,firebase:{sign_in_provider:"custom",identities:{}}},t);return[Sc(JSON.stringify(n)),Sc(JSON.stringify(o)),""].join(".")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function jt(){return typeof navigator<"u"&&typeof navigator.userAgent=="string"?navigator.userAgent:""}function Vm(){return typeof window<"u"&&!!(window.cordova||window.phonegap||window.PhoneGap)&&/ios|iphone|ipod|ipad|android|blackberry|iemobile/i.test(jt())}function xA(){var t;const e=(t=mh())===null||t===void 0?void 0:t.forceEnvironment;if(e==="node")return!0;if(e==="browser")return!1;try{return Object.prototype.toString.call(global.process)==="[object process]"}catch{return!1}}function AA(){return typeof navigator<"u"&&navigator.userAgent==="Cloudflare-Workers"}function bA(){const t=typeof chrome=="object"?chrome.runtime:typeof browser=="object"?browser.runtime:void 0;return typeof t=="object"&&t.id!==void 0}function ZT(){return typeof navigator=="object"&&navigator.product==="ReactNative"}function PA(){const t=jt();return t.indexOf("MSIE ")>=0||t.indexOf("Trident/")>=0}function NA(){return HT.NODE_ADMIN===!0}function DA(){return!xA()&&!!navigator.userAgent&&navigator.userAgent.includes("Safari")&&!navigator.userAgent.includes("Chrome")}function OA(){try{return typeof indexedDB=="object"}catch{return!1}}function MA(){return new Promise((t,e)=>{try{let n=!0;const r="validate-browser-context-for-indexeddb-analytics-module",i=self.indexedDB.open(r);i.onsuccess=()=>{i.result.close(),n||self.indexedDB.deleteDatabase(r),t(!0)},i.onupgradeneeded=()=>{n=!1},i.onerror=()=>{var s;e(((s=i.error)===null||s===void 0?void 0:s.message)||"")}}catch(n){e(n)}})}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const LA="FirebaseError";class Zn extends Error{constructor(e,n,r){super(n),this.code=e,this.customData=r,this.name=LA,Object.setPrototypeOf(this,Zn.prototype),Error.captureStackTrace&&Error.captureStackTrace(this,wl.prototype.create)}}class wl{constructor(e,n,r){this.service=e,this.serviceName=n,this.errors=r}create(e,...n){const r=n[0]||{},i=`${this.service}/${e}`,s=this.errors[e],o=s?FA(s,r):"Error",a=`${this.serviceName}: ${o} (${i}).`;return new Zn(i,a,r)}}function FA(t,e){return t.replace(VA,(n,r)=>{const i=e[r];return i!=null?String(i):`<${r}?>`})}const VA=/\{\$([^}]+)}/g;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function tl(t){return JSON.parse(t)}function Et(t){return JSON.stringify(t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const eI=function(t){let e={},n={},r={},i="";try{const s=t.split(".");e=tl(kc(s[0])||""),n=tl(kc(s[1])||""),i=s[2],r=n.d||{},delete n.d}catch{}return{header:e,claims:n,data:r,signature:i}},UA=function(t){const e=eI(t),n=e.claims;return!!n&&typeof n=="object"&&n.hasOwnProperty("iat")},jA=function(t){const e=eI(t).claims;return typeof e=="object"&&e.admin===!0};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function xr(t,e){return Object.prototype.hasOwnProperty.call(t,e)}function ro(t,e){if(Object.prototype.hasOwnProperty.call(t,e))return t[e]}function Zf(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}function Cc(t,e,n){const r={};for(const i in t)Object.prototype.hasOwnProperty.call(t,i)&&(r[i]=e.call(n,t[i],i,t));return r}function Rc(t,e){if(t===e)return!0;const n=Object.keys(t),r=Object.keys(e);for(const i of n){if(!r.includes(i))return!1;const s=t[i],o=e[i];if(Ev(s)&&Ev(o)){if(!Rc(s,o))return!1}else if(s!==o)return!1}for(const i of r)if(!n.includes(i))return!1;return!0}function Ev(t){return t!==null&&typeof t=="object"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function yo(t){const e=[];for(const[n,r]of Object.entries(t))Array.isArray(r)?r.forEach(i=>{e.push(encodeURIComponent(n)+"="+encodeURIComponent(i))}):e.push(encodeURIComponent(n)+"="+encodeURIComponent(r));return e.length?"&"+e.join("&"):""}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zA{constructor(){this.chain_=[],this.buf_=[],this.W_=[],this.pad_=[],this.inbuf_=0,this.total_=0,this.blockSize=512/8,this.pad_[0]=128;for(let e=1;e<this.blockSize;++e)this.pad_[e]=0;this.reset()}reset(){this.chain_[0]=1732584193,this.chain_[1]=4023233417,this.chain_[2]=2562383102,this.chain_[3]=271733878,this.chain_[4]=3285377520,this.inbuf_=0,this.total_=0}compress_(e,n){n||(n=0);const r=this.W_;if(typeof e=="string")for(let f=0;f<16;f++)r[f]=e.charCodeAt(n)<<24|e.charCodeAt(n+1)<<16|e.charCodeAt(n+2)<<8|e.charCodeAt(n+3),n+=4;else for(let f=0;f<16;f++)r[f]=e[n]<<24|e[n+1]<<16|e[n+2]<<8|e[n+3],n+=4;for(let f=16;f<80;f++){const g=r[f-3]^r[f-8]^r[f-14]^r[f-16];r[f]=(g<<1|g>>>31)&4294967295}let i=this.chain_[0],s=this.chain_[1],o=this.chain_[2],a=this.chain_[3],u=this.chain_[4],c,h;for(let f=0;f<80;f++){f<40?f<20?(c=a^s&(o^a),h=1518500249):(c=s^o^a,h=1859775393):f<60?(c=s&o|a&(s|o),h=2400959708):(c=s^o^a,h=3395469782);const g=(i<<5|i>>>27)+c+u+h+r[f]&4294967295;u=a,a=o,o=(s<<30|s>>>2)&4294967295,s=i,i=g}this.chain_[0]=this.chain_[0]+i&4294967295,this.chain_[1]=this.chain_[1]+s&4294967295,this.chain_[2]=this.chain_[2]+o&4294967295,this.chain_[3]=this.chain_[3]+a&4294967295,this.chain_[4]=this.chain_[4]+u&4294967295}update(e,n){if(e==null)return;n===void 0&&(n=e.length);const r=n-this.blockSize;let i=0;const s=this.buf_;let o=this.inbuf_;for(;i<n;){if(o===0)for(;i<=r;)this.compress_(e,i),i+=this.blockSize;if(typeof e=="string"){for(;i<n;)if(s[o]=e.charCodeAt(i),++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}else for(;i<n;)if(s[o]=e[i],++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}this.inbuf_=o,this.total_+=n}digest(){const e=[];let n=this.total_*8;this.inbuf_<56?this.update(this.pad_,56-this.inbuf_):this.update(this.pad_,this.blockSize-(this.inbuf_-56));for(let i=this.blockSize-1;i>=56;i--)this.buf_[i]=n&255,n/=256;this.compress_(this.buf_);let r=0;for(let i=0;i<5;i++)for(let s=24;s>=0;s-=8)e[r]=this.chain_[i]>>s&255,++r;return e}}function BA(t,e){const n=new $A(t,e);return n.subscribe.bind(n)}class $A{constructor(e,n){this.observers=[],this.unsubscribes=[],this.observerCount=0,this.task=Promise.resolve(),this.finalized=!1,this.onNoObservers=n,this.task.then(()=>{e(this)}).catch(r=>{this.error(r)})}next(e){this.forEachObserver(n=>{n.next(e)})}error(e){this.forEachObserver(n=>{n.error(e)}),this.close(e)}complete(){this.forEachObserver(e=>{e.complete()}),this.close()}subscribe(e,n,r){let i;if(e===void 0&&n===void 0&&r===void 0)throw new Error("Missing Observer.");WA(e,["next","error","complete"])?i=e:i={next:e,error:n,complete:r},i.next===void 0&&(i.next=Od),i.error===void 0&&(i.error=Od),i.complete===void 0&&(i.complete=Od);const s=this.unsubscribeOne.bind(this,this.observers.length);return this.finalized&&this.task.then(()=>{try{this.finalError?i.error(this.finalError):i.complete()}catch{}}),this.observers.push(i),s}unsubscribeOne(e){this.observers===void 0||this.observers[e]===void 0||(delete this.observers[e],this.observerCount-=1,this.observerCount===0&&this.onNoObservers!==void 0&&this.onNoObservers(this))}forEachObserver(e){if(!this.finalized)for(let n=0;n<this.observers.length;n++)this.sendOne(n,e)}sendOne(e,n){this.task.then(()=>{if(this.observers!==void 0&&this.observers[e]!==void 0)try{n(this.observers[e])}catch(r){typeof console<"u"&&console.error&&console.error(r)}})}close(e){this.finalized||(this.finalized=!0,e!==void 0&&(this.finalError=e),this.task.then(()=>{this.observers=void 0,this.onNoObservers=void 0}))}}function WA(t,e){if(typeof t!="object"||t===null)return!1;for(const n of e)if(n in t&&typeof t[n]=="function")return!0;return!1}function Od(){}function Um(t,e){return`${t} failed: ${e} argument `}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qA=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);if(i>=55296&&i<=56319){const s=i-55296;r++,G(r<t.length,"Surrogate pair missing trail surrogate.");const o=t.charCodeAt(r)-56320;i=65536+(s<<10)+o}i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):i<65536?(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},_h=function(t){let e=0;for(let n=0;n<t.length;n++){const r=t.charCodeAt(n);r<128?e++:r<2048?e+=2:r>=55296&&r<=56319?(e+=4,n++):e+=3}return e};/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Xe(t){return t&&t._delegate?t._delegate:t}class vr{constructor(e,n,r){this.name=e,this.instanceFactory=n,this.type=r,this.multipleInstances=!1,this.serviceProps={},this.instantiationMode="LAZY",this.onInstanceCreated=null}setInstantiationMode(e){return this.instantiationMode=e,this}setMultipleInstances(e){return this.multipleInstances=e,this}setServiceProps(e){return this.serviceProps=e,this}setInstanceCreatedCallback(e){return this.onInstanceCreated=e,this}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Ri="[DEFAULT]";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class HA{constructor(e,n){this.name=e,this.container=n,this.component=null,this.instances=new Map,this.instancesDeferred=new Map,this.instancesOptions=new Map,this.onInitCallbacks=new Map}get(e){const n=this.normalizeInstanceIdentifier(e);if(!this.instancesDeferred.has(n)){const r=new gh;if(this.instancesDeferred.set(n,r),this.isInitialized(n)||this.shouldAutoInitialize())try{const i=this.getOrInitializeService({instanceIdentifier:n});i&&r.resolve(i)}catch{}}return this.instancesDeferred.get(n).promise}getImmediate(e){var n;const r=this.normalizeInstanceIdentifier(e==null?void 0:e.identifier),i=(n=e==null?void 0:e.optional)!==null&&n!==void 0?n:!1;if(this.isInitialized(r)||this.shouldAutoInitialize())try{return this.getOrInitializeService({instanceIdentifier:r})}catch(s){if(i)return null;throw s}else{if(i)return null;throw Error(`Service ${this.name} is not available`)}}getComponent(){return this.component}setComponent(e){if(e.name!==this.name)throw Error(`Mismatching Component ${e.name} for Provider ${this.name}.`);if(this.component)throw Error(`Component for ${this.name} has already been provided`);if(this.component=e,!!this.shouldAutoInitialize()){if(KA(e))try{this.getOrInitializeService({instanceIdentifier:Ri})}catch{}for(const[n,r]of this.instancesDeferred.entries()){const i=this.normalizeInstanceIdentifier(n);try{const s=this.getOrInitializeService({instanceIdentifier:i});r.resolve(s)}catch{}}}}clearInstance(e=Ri){this.instancesDeferred.delete(e),this.instancesOptions.delete(e),this.instances.delete(e)}async delete(){const e=Array.from(this.instances.values());await Promise.all([...e.filter(n=>"INTERNAL"in n).map(n=>n.INTERNAL.delete()),...e.filter(n=>"_delete"in n).map(n=>n._delete())])}isComponentSet(){return this.component!=null}isInitialized(e=Ri){return this.instances.has(e)}getOptions(e=Ri){return this.instancesOptions.get(e)||{}}initialize(e={}){const{options:n={}}=e,r=this.normalizeInstanceIdentifier(e.instanceIdentifier);if(this.isInitialized(r))throw Error(`${this.name}(${r}) has already been initialized`);if(!this.isComponentSet())throw Error(`Component ${this.name} has not been registered yet`);const i=this.getOrInitializeService({instanceIdentifier:r,options:n});for(const[s,o]of this.instancesDeferred.entries()){const a=this.normalizeInstanceIdentifier(s);r===a&&o.resolve(i)}return i}onInit(e,n){var r;const i=this.normalizeInstanceIdentifier(n),s=(r=this.onInitCallbacks.get(i))!==null&&r!==void 0?r:new Set;s.add(e),this.onInitCallbacks.set(i,s);const o=this.instances.get(i);return o&&e(o,i),()=>{s.delete(e)}}invokeOnInitCallbacks(e,n){const r=this.onInitCallbacks.get(n);if(r)for(const i of r)try{i(e,n)}catch{}}getOrInitializeService({instanceIdentifier:e,options:n={}}){let r=this.instances.get(e);if(!r&&this.component&&(r=this.component.instanceFactory(this.container,{instanceIdentifier:GA(e),options:n}),this.instances.set(e,r),this.instancesOptions.set(e,n),this.invokeOnInitCallbacks(r,e),this.component.onInstanceCreated))try{this.component.onInstanceCreated(this.container,e,r)}catch{}return r||null}normalizeInstanceIdentifier(e=Ri){return this.component?this.component.multipleInstances?e:Ri:e}shouldAutoInitialize(){return!!this.component&&this.component.instantiationMode!=="EXPLICIT"}}function GA(t){return t===Ri?void 0:t}function KA(t){return t.instantiationMode==="EAGER"}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class QA{constructor(e){this.name=e,this.providers=new Map}addComponent(e){const n=this.getProvider(e.name);if(n.isComponentSet())throw new Error(`Component ${e.name} has already been registered with ${this.name}`);n.setComponent(e)}addOrOverwriteComponent(e){this.getProvider(e.name).isComponentSet()&&this.providers.delete(e.name),this.addComponent(e)}getProvider(e){if(this.providers.has(e))return this.providers.get(e);const n=new HA(e,this);return this.providers.set(e,n),n}getProviders(){return Array.from(this.providers.values())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var he;(function(t){t[t.DEBUG=0]="DEBUG",t[t.VERBOSE=1]="VERBOSE",t[t.INFO=2]="INFO",t[t.WARN=3]="WARN",t[t.ERROR=4]="ERROR",t[t.SILENT=5]="SILENT"})(he||(he={}));const YA={debug:he.DEBUG,verbose:he.VERBOSE,info:he.INFO,warn:he.WARN,error:he.ERROR,silent:he.SILENT},XA=he.INFO,JA={[he.DEBUG]:"log",[he.VERBOSE]:"log",[he.INFO]:"info",[he.WARN]:"warn",[he.ERROR]:"error"},ZA=(t,e,...n)=>{if(e<t.logLevel)return;const r=new Date().toISOString(),i=JA[e];if(i)console[i](`[${r}]  ${t.name}:`,...n);else throw new Error(`Attempted to log a message with an invalid logType (value: ${e})`)};class yh{constructor(e){this.name=e,this._logLevel=XA,this._logHandler=ZA,this._userLogHandler=null}get logLevel(){return this._logLevel}set logLevel(e){if(!(e in he))throw new TypeError(`Invalid value "${e}" assigned to \`logLevel\``);this._logLevel=e}setLogLevel(e){this._logLevel=typeof e=="string"?YA[e]:e}get logHandler(){return this._logHandler}set logHandler(e){if(typeof e!="function")throw new TypeError("Value assigned to `logHandler` must be a function");this._logHandler=e}get userLogHandler(){return this._userLogHandler}set userLogHandler(e){this._userLogHandler=e}debug(...e){this._userLogHandler&&this._userLogHandler(this,he.DEBUG,...e),this._logHandler(this,he.DEBUG,...e)}log(...e){this._userLogHandler&&this._userLogHandler(this,he.VERBOSE,...e),this._logHandler(this,he.VERBOSE,...e)}info(...e){this._userLogHandler&&this._userLogHandler(this,he.INFO,...e),this._logHandler(this,he.INFO,...e)}warn(...e){this._userLogHandler&&this._userLogHandler(this,he.WARN,...e),this._logHandler(this,he.WARN,...e)}error(...e){this._userLogHandler&&this._userLogHandler(this,he.ERROR,...e),this._logHandler(this,he.ERROR,...e)}}const eb=(t,e)=>e.some(n=>t instanceof n);let Tv,Iv;function tb(){return Tv||(Tv=[IDBDatabase,IDBObjectStore,IDBIndex,IDBCursor,IDBTransaction])}function nb(){return Iv||(Iv=[IDBCursor.prototype.advance,IDBCursor.prototype.continue,IDBCursor.prototype.continuePrimaryKey])}const tI=new WeakMap,ep=new WeakMap,nI=new WeakMap,Md=new WeakMap,jm=new WeakMap;function rb(t){const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("success",s),t.removeEventListener("error",o)},s=()=>{n(ti(t.result)),i()},o=()=>{r(t.error),i()};t.addEventListener("success",s),t.addEventListener("error",o)});return e.then(n=>{n instanceof IDBCursor&&tI.set(n,t)}).catch(()=>{}),jm.set(e,t),e}function ib(t){if(ep.has(t))return;const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("complete",s),t.removeEventListener("error",o),t.removeEventListener("abort",o)},s=()=>{n(),i()},o=()=>{r(t.error||new DOMException("AbortError","AbortError")),i()};t.addEventListener("complete",s),t.addEventListener("error",o),t.addEventListener("abort",o)});ep.set(t,e)}let tp={get(t,e,n){if(t instanceof IDBTransaction){if(e==="done")return ep.get(t);if(e==="objectStoreNames")return t.objectStoreNames||nI.get(t);if(e==="store")return n.objectStoreNames[1]?void 0:n.objectStore(n.objectStoreNames[0])}return ti(t[e])},set(t,e,n){return t[e]=n,!0},has(t,e){return t instanceof IDBTransaction&&(e==="done"||e==="store")?!0:e in t}};function sb(t){tp=t(tp)}function ob(t){return t===IDBDatabase.prototype.transaction&&!("objectStoreNames"in IDBTransaction.prototype)?function(e,...n){const r=t.call(Ld(this),e,...n);return nI.set(r,e.sort?e.sort():[e]),ti(r)}:nb().includes(t)?function(...e){return t.apply(Ld(this),e),ti(tI.get(this))}:function(...e){return ti(t.apply(Ld(this),e))}}function ab(t){return typeof t=="function"?ob(t):(t instanceof IDBTransaction&&ib(t),eb(t,tb())?new Proxy(t,tp):t)}function ti(t){if(t instanceof IDBRequest)return rb(t);if(Md.has(t))return Md.get(t);const e=ab(t);return e!==t&&(Md.set(t,e),jm.set(e,t)),e}const Ld=t=>jm.get(t);function lb(t,e,{blocked:n,upgrade:r,blocking:i,terminated:s}={}){const o=indexedDB.open(t,e),a=ti(o);return r&&o.addEventListener("upgradeneeded",u=>{r(ti(o.result),u.oldVersion,u.newVersion,ti(o.transaction),u)}),n&&o.addEventListener("blocked",u=>n(u.oldVersion,u.newVersion,u)),a.then(u=>{s&&u.addEventListener("close",()=>s()),i&&u.addEventListener("versionchange",c=>i(c.oldVersion,c.newVersion,c))}).catch(()=>{}),a}const ub=["get","getKey","getAll","getAllKeys","count"],cb=["put","add","delete","clear"],Fd=new Map;function Sv(t,e){if(!(t instanceof IDBDatabase&&!(e in t)&&typeof e=="string"))return;if(Fd.get(e))return Fd.get(e);const n=e.replace(/FromIndex$/,""),r=e!==n,i=cb.includes(n);if(!(n in(r?IDBIndex:IDBObjectStore).prototype)||!(i||ub.includes(n)))return;const s=async function(o,...a){const u=this.transaction(o,i?"readwrite":"readonly");let c=u.store;return r&&(c=c.index(a.shift())),(await Promise.all([c[n](...a),i&&u.done]))[0]};return Fd.set(e,s),s}sb(t=>({...t,get:(e,n,r)=>Sv(e,n)||t.get(e,n,r),has:(e,n)=>!!Sv(e,n)||t.has(e,n)}));/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class hb{constructor(e){this.container=e}getPlatformInfoString(){return this.container.getProviders().map(n=>{if(db(n)){const r=n.getImmediate();return`${r.library}/${r.version}`}else return null}).filter(n=>n).join(" ")}}function db(t){const e=t.getComponent();return(e==null?void 0:e.type)==="VERSION"}const np="@firebase/app",kv="0.10.13";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const wr=new yh("@firebase/app"),fb="@firebase/app-compat",pb="@firebase/analytics-compat",mb="@firebase/analytics",gb="@firebase/app-check-compat",_b="@firebase/app-check",yb="@firebase/auth",vb="@firebase/auth-compat",wb="@firebase/database",Eb="@firebase/data-connect",Tb="@firebase/database-compat",Ib="@firebase/functions",Sb="@firebase/functions-compat",kb="@firebase/installations",Cb="@firebase/installations-compat",Rb="@firebase/messaging",xb="@firebase/messaging-compat",Ab="@firebase/performance",bb="@firebase/performance-compat",Pb="@firebase/remote-config",Nb="@firebase/remote-config-compat",Db="@firebase/storage",Ob="@firebase/storage-compat",Mb="@firebase/firestore",Lb="@firebase/vertexai-preview",Fb="@firebase/firestore-compat",Vb="firebase",Ub="10.14.1";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const rp="[DEFAULT]",jb={[np]:"fire-core",[fb]:"fire-core-compat",[mb]:"fire-analytics",[pb]:"fire-analytics-compat",[_b]:"fire-app-check",[gb]:"fire-app-check-compat",[yb]:"fire-auth",[vb]:"fire-auth-compat",[wb]:"fire-rtdb",[Eb]:"fire-data-connect",[Tb]:"fire-rtdb-compat",[Ib]:"fire-fn",[Sb]:"fire-fn-compat",[kb]:"fire-iid",[Cb]:"fire-iid-compat",[Rb]:"fire-fcm",[xb]:"fire-fcm-compat",[Ab]:"fire-perf",[bb]:"fire-perf-compat",[Pb]:"fire-rc",[Nb]:"fire-rc-compat",[Db]:"fire-gcs",[Ob]:"fire-gcs-compat",[Mb]:"fire-fst",[Fb]:"fire-fst-compat",[Lb]:"fire-vertex","fire-js":"fire-js",[Vb]:"fire-js-all"};/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const xc=new Map,zb=new Map,ip=new Map;function Cv(t,e){try{t.container.addComponent(e)}catch(n){wr.debug(`Component ${e.name} failed to register with FirebaseApp ${t.name}`,n)}}function ci(t){const e=t.name;if(ip.has(e))return wr.debug(`There were multiple attempts to register component ${e}.`),!1;ip.set(e,t);for(const n of xc.values())Cv(n,t);for(const n of zb.values())Cv(n,t);return!0}function El(t,e){const n=t.container.getProvider("heartbeat").getImmediate({optional:!0});return n&&n.triggerHeartbeat(),t.container.getProvider(e)}function ar(t){return t.settings!==void 0}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Bb={"no-app":"No Firebase App '{$appName}' has been created - call initializeApp() first","bad-app-name":"Illegal App name: '{$appName}'","duplicate-app":"Firebase App named '{$appName}' already exists with different options or config","app-deleted":"Firebase App named '{$appName}' already deleted","server-app-deleted":"Firebase Server App has been deleted","no-options":"Need to provide options, when not being deployed to hosting via source.","invalid-app-argument":"firebase.{$appName}() takes either no argument or a Firebase App instance.","invalid-log-argument":"First argument to `onLog` must be null or a function.","idb-open":"Error thrown when opening IndexedDB. Original error: {$originalErrorMessage}.","idb-get":"Error thrown when reading from IndexedDB. Original error: {$originalErrorMessage}.","idb-set":"Error thrown when writing to IndexedDB. Original error: {$originalErrorMessage}.","idb-delete":"Error thrown when deleting from IndexedDB. Original error: {$originalErrorMessage}.","finalization-registry-not-supported":"FirebaseServerApp deleteOnDeref field defined but the JS runtime does not support FinalizationRegistry.","invalid-server-app-environment":"FirebaseServerApp is not for use in browser environments."},ni=new wl("app","Firebase",Bb);/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $b{constructor(e,n,r){this._isDeleted=!1,this._options=Object.assign({},e),this._config=Object.assign({},n),this._name=n.name,this._automaticDataCollectionEnabled=n.automaticDataCollectionEnabled,this._container=r,this.container.addComponent(new vr("app",()=>this,"PUBLIC"))}get automaticDataCollectionEnabled(){return this.checkDestroyed(),this._automaticDataCollectionEnabled}set automaticDataCollectionEnabled(e){this.checkDestroyed(),this._automaticDataCollectionEnabled=e}get name(){return this.checkDestroyed(),this._name}get options(){return this.checkDestroyed(),this._options}get config(){return this.checkDestroyed(),this._config}get container(){return this._container}get isDeleted(){return this._isDeleted}set isDeleted(e){this._isDeleted=e}checkDestroyed(){if(this.isDeleted)throw ni.create("app-deleted",{appName:this._name})}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const vi=Ub;function rI(t,e={}){let n=t;typeof e!="object"&&(e={name:e});const r=Object.assign({name:rp,automaticDataCollectionEnabled:!1},e),i=r.name;if(typeof i!="string"||!i)throw ni.create("bad-app-name",{appName:String(i)});if(n||(n=XT()),!n)throw ni.create("no-options");const s=xc.get(i);if(s){if(Rc(n,s.options)&&Rc(r,s.config))return s;throw ni.create("duplicate-app",{appName:i})}const o=new QA(i);for(const u of ip.values())o.addComponent(u);const a=new $b(n,r,o);return xc.set(i,a),a}function vh(t=rp){const e=xc.get(t);if(!e&&t===rp&&XT())return rI();if(!e)throw ni.create("no-app",{appName:t});return e}function Tn(t,e,n){var r;let i=(r=jb[t])!==null&&r!==void 0?r:t;n&&(i+=`-${n}`);const s=i.match(/\s|\//),o=e.match(/\s|\//);if(s||o){const a=[`Unable to register library "${i}" with version "${e}":`];s&&a.push(`library name "${i}" contains illegal characters (whitespace or "/")`),s&&o&&a.push("and"),o&&a.push(`version name "${e}" contains illegal characters (whitespace or "/")`),wr.warn(a.join(" "));return}ci(new vr(`${i}-version`,()=>({library:i,version:e}),"VERSION"))}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Wb="firebase-heartbeat-database",qb=1,nl="firebase-heartbeat-store";let Vd=null;function iI(){return Vd||(Vd=lb(Wb,qb,{upgrade:(t,e)=>{switch(e){case 0:try{t.createObjectStore(nl)}catch(n){console.warn(n)}}}}).catch(t=>{throw ni.create("idb-open",{originalErrorMessage:t.message})})),Vd}async function Hb(t){try{const n=(await iI()).transaction(nl),r=await n.objectStore(nl).get(sI(t));return await n.done,r}catch(e){if(e instanceof Zn)wr.warn(e.message);else{const n=ni.create("idb-get",{originalErrorMessage:e==null?void 0:e.message});wr.warn(n.message)}}}async function Rv(t,e){try{const r=(await iI()).transaction(nl,"readwrite");await r.objectStore(nl).put(e,sI(t)),await r.done}catch(n){if(n instanceof Zn)wr.warn(n.message);else{const r=ni.create("idb-set",{originalErrorMessage:n==null?void 0:n.message});wr.warn(r.message)}}}function sI(t){return`${t.name}!${t.options.appId}`}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Gb=1024,Kb=30*24*60*60*1e3;class Qb{constructor(e){this.container=e,this._heartbeatsCache=null;const n=this.container.getProvider("app").getImmediate();this._storage=new Xb(n),this._heartbeatsCachePromise=this._storage.read().then(r=>(this._heartbeatsCache=r,r))}async triggerHeartbeat(){var e,n;try{const i=this.container.getProvider("platform-logger").getImmediate().getPlatformInfoString(),s=xv();return((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null&&(this._heartbeatsCache=await this._heartbeatsCachePromise,((n=this._heartbeatsCache)===null||n===void 0?void 0:n.heartbeats)==null)||this._heartbeatsCache.lastSentHeartbeatDate===s||this._heartbeatsCache.heartbeats.some(o=>o.date===s)?void 0:(this._heartbeatsCache.heartbeats.push({date:s,agent:i}),this._heartbeatsCache.heartbeats=this._heartbeatsCache.heartbeats.filter(o=>{const a=new Date(o.date).valueOf();return Date.now()-a<=Kb}),this._storage.overwrite(this._heartbeatsCache))}catch(r){wr.warn(r)}}async getHeartbeatsHeader(){var e;try{if(this._heartbeatsCache===null&&await this._heartbeatsCachePromise,((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null||this._heartbeatsCache.heartbeats.length===0)return"";const n=xv(),{heartbeatsToSend:r,unsentEntries:i}=Yb(this._heartbeatsCache.heartbeats),s=Sc(JSON.stringify({version:2,heartbeats:r}));return this._heartbeatsCache.lastSentHeartbeatDate=n,i.length>0?(this._heartbeatsCache.heartbeats=i,await this._storage.overwrite(this._heartbeatsCache)):(this._heartbeatsCache.heartbeats=[],this._storage.overwrite(this._heartbeatsCache)),s}catch(n){return wr.warn(n),""}}}function xv(){return new Date().toISOString().substring(0,10)}function Yb(t,e=Gb){const n=[];let r=t.slice();for(const i of t){const s=n.find(o=>o.agent===i.agent);if(s){if(s.dates.push(i.date),Av(n)>e){s.dates.pop();break}}else if(n.push({agent:i.agent,dates:[i.date]}),Av(n)>e){n.pop();break}r=r.slice(1)}return{heartbeatsToSend:n,unsentEntries:r}}class Xb{constructor(e){this.app=e,this._canUseIndexedDBPromise=this.runIndexedDBEnvironmentCheck()}async runIndexedDBEnvironmentCheck(){return OA()?MA().then(()=>!0).catch(()=>!1):!1}async read(){if(await this._canUseIndexedDBPromise){const n=await Hb(this.app);return n!=null&&n.heartbeats?n:{heartbeats:[]}}else return{heartbeats:[]}}async overwrite(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Rv(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:e.heartbeats})}else return}async add(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Rv(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:[...i.heartbeats,...e.heartbeats]})}else return}}function Av(t){return Sc(JSON.stringify({version:2,heartbeats:t})).length}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Jb(t){ci(new vr("platform-logger",e=>new hb(e),"PRIVATE")),ci(new vr("heartbeat",e=>new Qb(e),"PRIVATE")),Tn(np,kv,t),Tn(np,kv,"esm2017"),Tn("fire-js","")}Jb("");var Zb="firebase",eP="10.14.1";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */Tn(Zb,eP,"app");var bv=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var Vi,oI;(function(){var t;/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/function e(E,y){function T(){}T.prototype=y.prototype,E.D=y.prototype,E.prototype=new T,E.prototype.constructor=E,E.C=function(x,b,k){for(var S=Array(arguments.length-2),ue=2;ue<arguments.length;ue++)S[ue-2]=arguments[ue];return y.prototype[b].apply(x,S)}}function n(){this.blockSize=-1}function r(){this.blockSize=-1,this.blockSize=64,this.g=Array(4),this.B=Array(this.blockSize),this.o=this.h=0,this.s()}e(r,n),r.prototype.s=function(){this.g[0]=1732584193,this.g[1]=4023233417,this.g[2]=2562383102,this.g[3]=271733878,this.o=this.h=0};function i(E,y,T){T||(T=0);var x=Array(16);if(typeof y=="string")for(var b=0;16>b;++b)x[b]=y.charCodeAt(T++)|y.charCodeAt(T++)<<8|y.charCodeAt(T++)<<16|y.charCodeAt(T++)<<24;else for(b=0;16>b;++b)x[b]=y[T++]|y[T++]<<8|y[T++]<<16|y[T++]<<24;y=E.g[0],T=E.g[1],b=E.g[2];var k=E.g[3],S=y+(k^T&(b^k))+x[0]+3614090360&4294967295;y=T+(S<<7&4294967295|S>>>25),S=k+(b^y&(T^b))+x[1]+3905402710&4294967295,k=y+(S<<12&4294967295|S>>>20),S=b+(T^k&(y^T))+x[2]+606105819&4294967295,b=k+(S<<17&4294967295|S>>>15),S=T+(y^b&(k^y))+x[3]+3250441966&4294967295,T=b+(S<<22&4294967295|S>>>10),S=y+(k^T&(b^k))+x[4]+4118548399&4294967295,y=T+(S<<7&4294967295|S>>>25),S=k+(b^y&(T^b))+x[5]+1200080426&4294967295,k=y+(S<<12&4294967295|S>>>20),S=b+(T^k&(y^T))+x[6]+2821735955&4294967295,b=k+(S<<17&4294967295|S>>>15),S=T+(y^b&(k^y))+x[7]+4249261313&4294967295,T=b+(S<<22&4294967295|S>>>10),S=y+(k^T&(b^k))+x[8]+1770035416&4294967295,y=T+(S<<7&4294967295|S>>>25),S=k+(b^y&(T^b))+x[9]+2336552879&4294967295,k=y+(S<<12&4294967295|S>>>20),S=b+(T^k&(y^T))+x[10]+4294925233&4294967295,b=k+(S<<17&4294967295|S>>>15),S=T+(y^b&(k^y))+x[11]+2304563134&4294967295,T=b+(S<<22&4294967295|S>>>10),S=y+(k^T&(b^k))+x[12]+1804603682&4294967295,y=T+(S<<7&4294967295|S>>>25),S=k+(b^y&(T^b))+x[13]+4254626195&4294967295,k=y+(S<<12&4294967295|S>>>20),S=b+(T^k&(y^T))+x[14]+2792965006&4294967295,b=k+(S<<17&4294967295|S>>>15),S=T+(y^b&(k^y))+x[15]+1236535329&4294967295,T=b+(S<<22&4294967295|S>>>10),S=y+(b^k&(T^b))+x[1]+4129170786&4294967295,y=T+(S<<5&4294967295|S>>>27),S=k+(T^b&(y^T))+x[6]+3225465664&4294967295,k=y+(S<<9&4294967295|S>>>23),S=b+(y^T&(k^y))+x[11]+643717713&4294967295,b=k+(S<<14&4294967295|S>>>18),S=T+(k^y&(b^k))+x[0]+3921069994&4294967295,T=b+(S<<20&4294967295|S>>>12),S=y+(b^k&(T^b))+x[5]+3593408605&4294967295,y=T+(S<<5&4294967295|S>>>27),S=k+(T^b&(y^T))+x[10]+38016083&4294967295,k=y+(S<<9&4294967295|S>>>23),S=b+(y^T&(k^y))+x[15]+3634488961&4294967295,b=k+(S<<14&4294967295|S>>>18),S=T+(k^y&(b^k))+x[4]+3889429448&4294967295,T=b+(S<<20&4294967295|S>>>12),S=y+(b^k&(T^b))+x[9]+568446438&4294967295,y=T+(S<<5&4294967295|S>>>27),S=k+(T^b&(y^T))+x[14]+3275163606&4294967295,k=y+(S<<9&4294967295|S>>>23),S=b+(y^T&(k^y))+x[3]+4107603335&4294967295,b=k+(S<<14&4294967295|S>>>18),S=T+(k^y&(b^k))+x[8]+1163531501&4294967295,T=b+(S<<20&4294967295|S>>>12),S=y+(b^k&(T^b))+x[13]+2850285829&4294967295,y=T+(S<<5&4294967295|S>>>27),S=k+(T^b&(y^T))+x[2]+4243563512&4294967295,k=y+(S<<9&4294967295|S>>>23),S=b+(y^T&(k^y))+x[7]+1735328473&4294967295,b=k+(S<<14&4294967295|S>>>18),S=T+(k^y&(b^k))+x[12]+2368359562&4294967295,T=b+(S<<20&4294967295|S>>>12),S=y+(T^b^k)+x[5]+4294588738&4294967295,y=T+(S<<4&4294967295|S>>>28),S=k+(y^T^b)+x[8]+2272392833&4294967295,k=y+(S<<11&4294967295|S>>>21),S=b+(k^y^T)+x[11]+1839030562&4294967295,b=k+(S<<16&4294967295|S>>>16),S=T+(b^k^y)+x[14]+4259657740&4294967295,T=b+(S<<23&4294967295|S>>>9),S=y+(T^b^k)+x[1]+2763975236&4294967295,y=T+(S<<4&4294967295|S>>>28),S=k+(y^T^b)+x[4]+1272893353&4294967295,k=y+(S<<11&4294967295|S>>>21),S=b+(k^y^T)+x[7]+4139469664&4294967295,b=k+(S<<16&4294967295|S>>>16),S=T+(b^k^y)+x[10]+3200236656&4294967295,T=b+(S<<23&4294967295|S>>>9),S=y+(T^b^k)+x[13]+681279174&4294967295,y=T+(S<<4&4294967295|S>>>28),S=k+(y^T^b)+x[0]+3936430074&4294967295,k=y+(S<<11&4294967295|S>>>21),S=b+(k^y^T)+x[3]+3572445317&4294967295,b=k+(S<<16&4294967295|S>>>16),S=T+(b^k^y)+x[6]+76029189&4294967295,T=b+(S<<23&4294967295|S>>>9),S=y+(T^b^k)+x[9]+3654602809&4294967295,y=T+(S<<4&4294967295|S>>>28),S=k+(y^T^b)+x[12]+3873151461&4294967295,k=y+(S<<11&4294967295|S>>>21),S=b+(k^y^T)+x[15]+530742520&4294967295,b=k+(S<<16&4294967295|S>>>16),S=T+(b^k^y)+x[2]+3299628645&4294967295,T=b+(S<<23&4294967295|S>>>9),S=y+(b^(T|~k))+x[0]+4096336452&4294967295,y=T+(S<<6&4294967295|S>>>26),S=k+(T^(y|~b))+x[7]+1126891415&4294967295,k=y+(S<<10&4294967295|S>>>22),S=b+(y^(k|~T))+x[14]+2878612391&4294967295,b=k+(S<<15&4294967295|S>>>17),S=T+(k^(b|~y))+x[5]+4237533241&4294967295,T=b+(S<<21&4294967295|S>>>11),S=y+(b^(T|~k))+x[12]+1700485571&4294967295,y=T+(S<<6&4294967295|S>>>26),S=k+(T^(y|~b))+x[3]+2399980690&4294967295,k=y+(S<<10&4294967295|S>>>22),S=b+(y^(k|~T))+x[10]+4293915773&4294967295,b=k+(S<<15&4294967295|S>>>17),S=T+(k^(b|~y))+x[1]+2240044497&4294967295,T=b+(S<<21&4294967295|S>>>11),S=y+(b^(T|~k))+x[8]+1873313359&4294967295,y=T+(S<<6&4294967295|S>>>26),S=k+(T^(y|~b))+x[15]+4264355552&4294967295,k=y+(S<<10&4294967295|S>>>22),S=b+(y^(k|~T))+x[6]+2734768916&4294967295,b=k+(S<<15&4294967295|S>>>17),S=T+(k^(b|~y))+x[13]+1309151649&4294967295,T=b+(S<<21&4294967295|S>>>11),S=y+(b^(T|~k))+x[4]+4149444226&4294967295,y=T+(S<<6&4294967295|S>>>26),S=k+(T^(y|~b))+x[11]+3174756917&4294967295,k=y+(S<<10&4294967295|S>>>22),S=b+(y^(k|~T))+x[2]+718787259&4294967295,b=k+(S<<15&4294967295|S>>>17),S=T+(k^(b|~y))+x[9]+3951481745&4294967295,E.g[0]=E.g[0]+y&4294967295,E.g[1]=E.g[1]+(b+(S<<21&4294967295|S>>>11))&4294967295,E.g[2]=E.g[2]+b&4294967295,E.g[3]=E.g[3]+k&4294967295}r.prototype.u=function(E,y){y===void 0&&(y=E.length);for(var T=y-this.blockSize,x=this.B,b=this.h,k=0;k<y;){if(b==0)for(;k<=T;)i(this,E,k),k+=this.blockSize;if(typeof E=="string"){for(;k<y;)if(x[b++]=E.charCodeAt(k++),b==this.blockSize){i(this,x),b=0;break}}else for(;k<y;)if(x[b++]=E[k++],b==this.blockSize){i(this,x),b=0;break}}this.h=b,this.o+=y},r.prototype.v=function(){var E=Array((56>this.h?this.blockSize:2*this.blockSize)-this.h);E[0]=128;for(var y=1;y<E.length-8;++y)E[y]=0;var T=8*this.o;for(y=E.length-8;y<E.length;++y)E[y]=T&255,T/=256;for(this.u(E),E=Array(16),y=T=0;4>y;++y)for(var x=0;32>x;x+=8)E[T++]=this.g[y]>>>x&255;return E};function s(E,y){var T=a;return Object.prototype.hasOwnProperty.call(T,E)?T[E]:T[E]=y(E)}function o(E,y){this.h=y;for(var T=[],x=!0,b=E.length-1;0<=b;b--){var k=E[b]|0;x&&k==y||(T[b]=k,x=!1)}this.g=T}var a={};function u(E){return-128<=E&&128>E?s(E,function(y){return new o([y|0],0>y?-1:0)}):new o([E|0],0>E?-1:0)}function c(E){if(isNaN(E)||!isFinite(E))return f;if(0>E)return D(c(-E));for(var y=[],T=1,x=0;E>=T;x++)y[x]=E/T|0,T*=4294967296;return new o(y,0)}function h(E,y){if(E.length==0)throw Error("number format error: empty string");if(y=y||10,2>y||36<y)throw Error("radix out of range: "+y);if(E.charAt(0)=="-")return D(h(E.substring(1),y));if(0<=E.indexOf("-"))throw Error('number format error: interior "-" character');for(var T=c(Math.pow(y,8)),x=f,b=0;b<E.length;b+=8){var k=Math.min(8,E.length-b),S=parseInt(E.substring(b,b+k),y);8>k?(k=c(Math.pow(y,k)),x=x.j(k).add(c(S))):(x=x.j(T),x=x.add(c(S)))}return x}var f=u(0),g=u(1),v=u(16777216);t=o.prototype,t.m=function(){if(N(this))return-D(this).m();for(var E=0,y=1,T=0;T<this.g.length;T++){var x=this.i(T);E+=(0<=x?x:4294967296+x)*y,y*=4294967296}return E},t.toString=function(E){if(E=E||10,2>E||36<E)throw Error("radix out of range: "+E);if(I(this))return"0";if(N(this))return"-"+D(this).toString(E);for(var y=c(Math.pow(E,6)),T=this,x="";;){var b=M(T,y).g;T=C(T,b.j(y));var k=((0<T.g.length?T.g[0]:T.h)>>>0).toString(E);if(T=b,I(T))return k+x;for(;6>k.length;)k="0"+k;x=k+x}},t.i=function(E){return 0>E?0:E<this.g.length?this.g[E]:this.h};function I(E){if(E.h!=0)return!1;for(var y=0;y<E.g.length;y++)if(E.g[y]!=0)return!1;return!0}function N(E){return E.h==-1}t.l=function(E){return E=C(this,E),N(E)?-1:I(E)?0:1};function D(E){for(var y=E.g.length,T=[],x=0;x<y;x++)T[x]=~E.g[x];return new o(T,~E.h).add(g)}t.abs=function(){return N(this)?D(this):this},t.add=function(E){for(var y=Math.max(this.g.length,E.g.length),T=[],x=0,b=0;b<=y;b++){var k=x+(this.i(b)&65535)+(E.i(b)&65535),S=(k>>>16)+(this.i(b)>>>16)+(E.i(b)>>>16);x=S>>>16,k&=65535,S&=65535,T[b]=S<<16|k}return new o(T,T[T.length-1]&-2147483648?-1:0)};function C(E,y){return E.add(D(y))}t.j=function(E){if(I(this)||I(E))return f;if(N(this))return N(E)?D(this).j(D(E)):D(D(this).j(E));if(N(E))return D(this.j(D(E)));if(0>this.l(v)&&0>E.l(v))return c(this.m()*E.m());for(var y=this.g.length+E.g.length,T=[],x=0;x<2*y;x++)T[x]=0;for(x=0;x<this.g.length;x++)for(var b=0;b<E.g.length;b++){var k=this.i(x)>>>16,S=this.i(x)&65535,ue=E.i(b)>>>16,Se=E.i(b)&65535;T[2*x+2*b]+=S*Se,w(T,2*x+2*b),T[2*x+2*b+1]+=k*Se,w(T,2*x+2*b+1),T[2*x+2*b+1]+=S*ue,w(T,2*x+2*b+1),T[2*x+2*b+2]+=k*ue,w(T,2*x+2*b+2)}for(x=0;x<y;x++)T[x]=T[2*x+1]<<16|T[2*x];for(x=y;x<2*y;x++)T[x]=0;return new o(T,0)};function w(E,y){for(;(E[y]&65535)!=E[y];)E[y+1]+=E[y]>>>16,E[y]&=65535,y++}function R(E,y){this.g=E,this.h=y}function M(E,y){if(I(y))throw Error("division by zero");if(I(E))return new R(f,f);if(N(E))return y=M(D(E),y),new R(D(y.g),D(y.h));if(N(y))return y=M(E,D(y)),new R(D(y.g),y.h);if(30<E.g.length){if(N(E)||N(y))throw Error("slowDivide_ only works with positive integers.");for(var T=g,x=y;0>=x.l(E);)T=z(T),x=z(x);var b=U(T,1),k=U(x,1);for(x=U(x,2),T=U(T,2);!I(x);){var S=k.add(x);0>=S.l(E)&&(b=b.add(T),k=S),x=U(x,1),T=U(T,1)}return y=C(E,b.j(y)),new R(b,y)}for(b=f;0<=E.l(y);){for(T=Math.max(1,Math.floor(E.m()/y.m())),x=Math.ceil(Math.log(T)/Math.LN2),x=48>=x?1:Math.pow(2,x-48),k=c(T),S=k.j(y);N(S)||0<S.l(E);)T-=x,k=c(T),S=k.j(y);I(k)&&(k=g),b=b.add(k),E=C(E,S)}return new R(b,E)}t.A=function(E){return M(this,E).h},t.and=function(E){for(var y=Math.max(this.g.length,E.g.length),T=[],x=0;x<y;x++)T[x]=this.i(x)&E.i(x);return new o(T,this.h&E.h)},t.or=function(E){for(var y=Math.max(this.g.length,E.g.length),T=[],x=0;x<y;x++)T[x]=this.i(x)|E.i(x);return new o(T,this.h|E.h)},t.xor=function(E){for(var y=Math.max(this.g.length,E.g.length),T=[],x=0;x<y;x++)T[x]=this.i(x)^E.i(x);return new o(T,this.h^E.h)};function z(E){for(var y=E.g.length+1,T=[],x=0;x<y;x++)T[x]=E.i(x)<<1|E.i(x-1)>>>31;return new o(T,E.h)}function U(E,y){var T=y>>5;y%=32;for(var x=E.g.length-T,b=[],k=0;k<x;k++)b[k]=0<y?E.i(k+T)>>>y|E.i(k+T+1)<<32-y:E.i(k+T);return new o(b,E.h)}r.prototype.digest=r.prototype.v,r.prototype.reset=r.prototype.s,r.prototype.update=r.prototype.u,oI=r,o.prototype.add=o.prototype.add,o.prototype.multiply=o.prototype.j,o.prototype.modulo=o.prototype.A,o.prototype.compare=o.prototype.l,o.prototype.toNumber=o.prototype.m,o.prototype.toString=o.prototype.toString,o.prototype.getBits=o.prototype.i,o.fromNumber=c,o.fromString=h,Vi=o}).apply(typeof bv<"u"?bv:typeof self<"u"?self:typeof window<"u"?window:{});var yu=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var aI,da,lI,$u,sp,uI,cI,hI;(function(){var t,e=typeof Object.defineProperties=="function"?Object.defineProperty:function(l,d,p){return l==Array.prototype||l==Object.prototype||(l[d]=p.value),l};function n(l){l=[typeof globalThis=="object"&&globalThis,l,typeof window=="object"&&window,typeof self=="object"&&self,typeof yu=="object"&&yu];for(var d=0;d<l.length;++d){var p=l[d];if(p&&p.Math==Math)return p}throw Error("Cannot find global object")}var r=n(this);function i(l,d){if(d)e:{var p=r;l=l.split(".");for(var _=0;_<l.length-1;_++){var O=l[_];if(!(O in p))break e;p=p[O]}l=l[l.length-1],_=p[l],d=d(_),d!=_&&d!=null&&e(p,l,{configurable:!0,writable:!0,value:d})}}function s(l,d){l instanceof String&&(l+="");var p=0,_=!1,O={next:function(){if(!_&&p<l.length){var L=p++;return{value:d(L,l[L]),done:!1}}return _=!0,{done:!0,value:void 0}}};return O[Symbol.iterator]=function(){return O},O}i("Array.prototype.values",function(l){return l||function(){return s(this,function(d,p){return p})}});/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/var o=o||{},a=this||self;function u(l){var d=typeof l;return d=d!="object"?d:l?Array.isArray(l)?"array":d:"null",d=="array"||d=="object"&&typeof l.length=="number"}function c(l){var d=typeof l;return d=="object"&&l!=null||d=="function"}function h(l,d,p){return l.call.apply(l.bind,arguments)}function f(l,d,p){if(!l)throw Error();if(2<arguments.length){var _=Array.prototype.slice.call(arguments,2);return function(){var O=Array.prototype.slice.call(arguments);return Array.prototype.unshift.apply(O,_),l.apply(d,O)}}return function(){return l.apply(d,arguments)}}function g(l,d,p){return g=Function.prototype.bind&&Function.prototype.bind.toString().indexOf("native code")!=-1?h:f,g.apply(null,arguments)}function v(l,d){var p=Array.prototype.slice.call(arguments,1);return function(){var _=p.slice();return _.push.apply(_,arguments),l.apply(this,_)}}function I(l,d){function p(){}p.prototype=d.prototype,l.aa=d.prototype,l.prototype=new p,l.prototype.constructor=l,l.Qb=function(_,O,L){for(var q=Array(arguments.length-2),De=2;De<arguments.length;De++)q[De-2]=arguments[De];return d.prototype[O].apply(_,q)}}function N(l){const d=l.length;if(0<d){const p=Array(d);for(let _=0;_<d;_++)p[_]=l[_];return p}return[]}function D(l,d){for(let p=1;p<arguments.length;p++){const _=arguments[p];if(u(_)){const O=l.length||0,L=_.length||0;l.length=O+L;for(let q=0;q<L;q++)l[O+q]=_[q]}else l.push(_)}}class C{constructor(d,p){this.i=d,this.j=p,this.h=0,this.g=null}get(){let d;return 0<this.h?(this.h--,d=this.g,this.g=d.next,d.next=null):d=this.i(),d}}function w(l){return/^[\s\xa0]*$/.test(l)}function R(){var l=a.navigator;return l&&(l=l.userAgent)?l:""}function M(l){return M[" "](l),l}M[" "]=function(){};var z=R().indexOf("Gecko")!=-1&&!(R().toLowerCase().indexOf("webkit")!=-1&&R().indexOf("Edge")==-1)&&!(R().indexOf("Trident")!=-1||R().indexOf("MSIE")!=-1)&&R().indexOf("Edge")==-1;function U(l,d,p){for(const _ in l)d.call(p,l[_],_,l)}function E(l,d){for(const p in l)d.call(void 0,l[p],p,l)}function y(l){const d={};for(const p in l)d[p]=l[p];return d}const T="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function x(l,d){let p,_;for(let O=1;O<arguments.length;O++){_=arguments[O];for(p in _)l[p]=_[p];for(let L=0;L<T.length;L++)p=T[L],Object.prototype.hasOwnProperty.call(_,p)&&(l[p]=_[p])}}function b(l){var d=1;l=l.split(":");const p=[];for(;0<d&&l.length;)p.push(l.shift()),d--;return l.length&&p.push(l.join(":")),p}function k(l){a.setTimeout(()=>{throw l},0)}function S(){var l=re;let d=null;return l.g&&(d=l.g,l.g=l.g.next,l.g||(l.h=null),d.next=null),d}class ue{constructor(){this.h=this.g=null}add(d,p){const _=Se.get();_.set(d,p),this.h?this.h.next=_:this.g=_,this.h=_}}var Se=new C(()=>new Je,l=>l.reset());class Je{constructor(){this.next=this.g=this.h=null}set(d,p){this.h=d,this.g=p,this.next=null}reset(){this.next=this.g=this.h=null}}let Rt,H=!1,re=new ue,P=()=>{const l=a.Promise.resolve(void 0);Rt=()=>{l.then(A)}};var A=()=>{for(var l;l=S();){try{l.h.call(l.g)}catch(p){k(p)}var d=Se;d.j(l),100>d.h&&(d.h++,l.next=d.g,d.g=l)}H=!1};function $(){this.s=this.s,this.C=this.C}$.prototype.s=!1,$.prototype.ma=function(){this.s||(this.s=!0,this.N())},$.prototype.N=function(){if(this.C)for(;this.C.length;)this.C.shift()()};function F(l,d){this.type=l,this.g=this.target=d,this.defaultPrevented=!1}F.prototype.h=function(){this.defaultPrevented=!0};var W=function(){if(!a.addEventListener||!Object.defineProperty)return!1;var l=!1,d=Object.defineProperty({},"passive",{get:function(){l=!0}});try{const p=()=>{};a.addEventListener("test",p,d),a.removeEventListener("test",p,d)}catch{}return l}();function K(l,d){if(F.call(this,l?l.type:""),this.relatedTarget=this.g=this.target=null,this.button=this.screenY=this.screenX=this.clientY=this.clientX=0,this.key="",this.metaKey=this.shiftKey=this.altKey=this.ctrlKey=!1,this.state=null,this.pointerId=0,this.pointerType="",this.i=null,l){var p=this.type=l.type,_=l.changedTouches&&l.changedTouches.length?l.changedTouches[0]:null;if(this.target=l.target||l.srcElement,this.g=d,d=l.relatedTarget){if(z){e:{try{M(d.nodeName);var O=!0;break e}catch{}O=!1}O||(d=null)}}else p=="mouseover"?d=l.fromElement:p=="mouseout"&&(d=l.toElement);this.relatedTarget=d,_?(this.clientX=_.clientX!==void 0?_.clientX:_.pageX,this.clientY=_.clientY!==void 0?_.clientY:_.pageY,this.screenX=_.screenX||0,this.screenY=_.screenY||0):(this.clientX=l.clientX!==void 0?l.clientX:l.pageX,this.clientY=l.clientY!==void 0?l.clientY:l.pageY,this.screenX=l.screenX||0,this.screenY=l.screenY||0),this.button=l.button,this.key=l.key||"",this.ctrlKey=l.ctrlKey,this.altKey=l.altKey,this.shiftKey=l.shiftKey,this.metaKey=l.metaKey,this.pointerId=l.pointerId||0,this.pointerType=typeof l.pointerType=="string"?l.pointerType:Z[l.pointerType]||"",this.state=l.state,this.i=l,l.defaultPrevented&&K.aa.h.call(this)}}I(K,F);var Z={2:"touch",3:"pen",4:"mouse"};K.prototype.h=function(){K.aa.h.call(this);var l=this.i;l.preventDefault?l.preventDefault():l.returnValue=!1};var Y="closure_listenable_"+(1e6*Math.random()|0),oe=0;function we(l,d,p,_,O){this.listener=l,this.proxy=null,this.src=d,this.type=p,this.capture=!!_,this.ha=O,this.key=++oe,this.da=this.fa=!1}function Ee(l){l.da=!0,l.listener=null,l.proxy=null,l.src=null,l.ha=null}function pe(l){this.src=l,this.g={},this.h=0}pe.prototype.add=function(l,d,p,_,O){var L=l.toString();l=this.g[L],l||(l=this.g[L]=[],this.h++);var q=be(l,d,_,O);return-1<q?(d=l[q],p||(d.fa=!1)):(d=new we(d,this.src,L,!!_,O),d.fa=p,l.push(d)),d};function ke(l,d){var p=d.type;if(p in l.g){var _=l.g[p],O=Array.prototype.indexOf.call(_,d,void 0),L;(L=0<=O)&&Array.prototype.splice.call(_,O,1),L&&(Ee(d),l.g[p].length==0&&(delete l.g[p],l.h--))}}function be(l,d,p,_){for(var O=0;O<l.length;++O){var L=l[O];if(!L.da&&L.listener==d&&L.capture==!!p&&L.ha==_)return O}return-1}var ee="closure_lm_"+(1e6*Math.random()|0),Ze={};function nt(l,d,p,_,O){if(Array.isArray(d)){for(var L=0;L<d.length;L++)nt(l,d[L],p,_,O);return null}return p=Vl(p),l&&l[Y]?l.K(d,p,c(_)?!!_.capture:!1,O):zt(l,d,p,!1,_,O)}function zt(l,d,p,_,O,L){if(!d)throw Error("Invalid event type");var q=c(O)?!!O.capture:!!O,De=Ao(l);if(De||(l[ee]=De=new pe(l)),p=De.add(d,p,_,q,L),p.proxy)return p;if(_=Kt(),p.proxy=_,_.src=l,_.listener=p,l.addEventListener)W||(O=q),O===void 0&&(O=!1),l.addEventListener(d.toString(),_,O);else if(l.attachEvent)l.attachEvent(Ar(d.toString()),_);else if(l.addListener&&l.removeListener)l.addListener(_);else throw Error("addEventListener and attachEvent are unavailable.");return p}function Kt(){function l(p){return d.call(l.src,l.listener,p)}const d=qh;return l}function fn(l,d,p,_,O){if(Array.isArray(d))for(var L=0;L<d.length;L++)fn(l,d[L],p,_,O);else _=c(_)?!!_.capture:!!_,p=Vl(p),l&&l[Y]?(l=l.i,d=String(d).toString(),d in l.g&&(L=l.g[d],p=be(L,p,_,O),-1<p&&(Ee(L[p]),Array.prototype.splice.call(L,p,1),L.length==0&&(delete l.g[d],l.h--)))):l&&(l=Ao(l))&&(d=l.g[d.toString()],l=-1,d&&(l=be(d,p,_,O)),(p=-1<l?d[l]:null)&&xt(p))}function xt(l){if(typeof l!="number"&&l&&!l.da){var d=l.src;if(d&&d[Y])ke(d.i,l);else{var p=l.type,_=l.proxy;d.removeEventListener?d.removeEventListener(p,_,l.capture):d.detachEvent?d.detachEvent(Ar(p),_):d.addListener&&d.removeListener&&d.removeListener(_),(p=Ao(d))?(ke(p,l),p.h==0&&(p.src=null,d[ee]=null)):Ee(l)}}}function Ar(l){return l in Ze?Ze[l]:Ze[l]="on"+l}function qh(l,d){if(l.da)l=!0;else{d=new K(d,this);var p=l.listener,_=l.ha||l.src;l.fa&&xt(l),l=p.call(_,d)}return l}function Ao(l){return l=l[ee],l instanceof pe?l:null}var us="__closure_events_fn_"+(1e9*Math.random()>>>0);function Vl(l){return typeof l=="function"?l:(l[us]||(l[us]=function(d){return l.handleEvent(d)}),l[us])}function at(){$.call(this),this.i=new pe(this),this.M=this,this.F=null}I(at,$),at.prototype[Y]=!0,at.prototype.removeEventListener=function(l,d,p,_){fn(this,l,d,p,_)};function _t(l,d){var p,_=l.F;if(_)for(p=[];_;_=_.F)p.push(_);if(l=l.M,_=d.type||d,typeof d=="string")d=new F(d,l);else if(d instanceof F)d.target=d.target||l;else{var O=d;d=new F(_,l),x(d,O)}if(O=!0,p)for(var L=p.length-1;0<=L;L--){var q=d.g=p[L];O=cs(q,_,!0,d)&&O}if(q=d.g=l,O=cs(q,_,!0,d)&&O,O=cs(q,_,!1,d)&&O,p)for(L=0;L<p.length;L++)q=d.g=p[L],O=cs(q,_,!1,d)&&O}at.prototype.N=function(){if(at.aa.N.call(this),this.i){var l=this.i,d;for(d in l.g){for(var p=l.g[d],_=0;_<p.length;_++)Ee(p[_]);delete l.g[d],l.h--}}this.F=null},at.prototype.K=function(l,d,p,_){return this.i.add(String(l),d,!1,p,_)},at.prototype.L=function(l,d,p,_){return this.i.add(String(l),d,!0,p,_)};function cs(l,d,p,_){if(d=l.i.g[String(d)],!d)return!0;d=d.concat();for(var O=!0,L=0;L<d.length;++L){var q=d[L];if(q&&!q.da&&q.capture==p){var De=q.listener,yt=q.ha||q.src;q.fa&&ke(l.i,q),O=De.call(yt,_)!==!1&&O}}return O&&!_.defaultPrevented}function bo(l,d,p){if(typeof l=="function")p&&(l=g(l,p));else if(l&&typeof l.handleEvent=="function")l=g(l.handleEvent,l);else throw Error("Invalid listener argument");return 2147483647<Number(d)?-1:a.setTimeout(l,d||0)}function Po(l){l.g=bo(()=>{l.g=null,l.i&&(l.i=!1,Po(l))},l.l);const d=l.h;l.h=null,l.m.apply(null,d)}class No extends ${constructor(d,p){super(),this.m=d,this.l=p,this.h=null,this.i=!1,this.g=null}j(d){this.h=arguments,this.g?this.i=!0:Po(this)}N(){super.N(),this.g&&(a.clearTimeout(this.g),this.g=null,this.i=!1,this.h=null)}}function wi(l){$.call(this),this.h=l,this.g={}}I(wi,$);var Ul=[];function m_(l){U(l.g,function(d,p){this.g.hasOwnProperty(p)&&xt(d)},l),l.g={}}wi.prototype.N=function(){wi.aa.N.call(this),m_(this)},wi.prototype.handleEvent=function(){throw Error("EventHandler.handleEvent not implemented")};var Hh=a.JSON.stringify,Xk=a.JSON.parse,Jk=class{stringify(l){return a.JSON.stringify(l,void 0)}parse(l){return a.JSON.parse(l,void 0)}};function Gh(){}Gh.prototype.h=null;function g_(l){return l.h||(l.h=l.i())}function __(){}var Do={OPEN:"a",kb:"b",Ja:"c",wb:"d"};function Kh(){F.call(this,"d")}I(Kh,F);function Qh(){F.call(this,"c")}I(Qh,F);var Ei={},y_=null;function jl(){return y_=y_||new at}Ei.La="serverreachability";function v_(l){F.call(this,Ei.La,l)}I(v_,F);function Oo(l){const d=jl();_t(d,new v_(d))}Ei.STAT_EVENT="statevent";function w_(l,d){F.call(this,Ei.STAT_EVENT,l),this.stat=d}I(w_,F);function Bt(l){const d=jl();_t(d,new w_(d,l))}Ei.Ma="timingevent";function E_(l,d){F.call(this,Ei.Ma,l),this.size=d}I(E_,F);function Mo(l,d){if(typeof l!="function")throw Error("Fn must not be null and must be a function");return a.setTimeout(function(){l()},d)}function Lo(){this.g=!0}Lo.prototype.xa=function(){this.g=!1};function Zk(l,d,p,_,O,L){l.info(function(){if(l.g)if(L)for(var q="",De=L.split("&"),yt=0;yt<De.length;yt++){var Te=De[yt].split("=");if(1<Te.length){var At=Te[0];Te=Te[1];var bt=At.split("_");q=2<=bt.length&&bt[1]=="type"?q+(At+"="+Te+"&"):q+(At+"=redacted&")}}else q=null;else q=L;return"XMLHTTP REQ ("+_+") [attempt "+O+"]: "+d+`
`+p+`
`+q})}function eC(l,d,p,_,O,L,q){l.info(function(){return"XMLHTTP RESP ("+_+") [ attempt "+O+"]: "+d+`
`+p+`
`+L+" "+q})}function hs(l,d,p,_){l.info(function(){return"XMLHTTP TEXT ("+d+"): "+nC(l,p)+(_?" "+_:"")})}function tC(l,d){l.info(function(){return"TIMEOUT: "+d})}Lo.prototype.info=function(){};function nC(l,d){if(!l.g)return d;if(!d)return null;try{var p=JSON.parse(d);if(p){for(l=0;l<p.length;l++)if(Array.isArray(p[l])){var _=p[l];if(!(2>_.length)){var O=_[1];if(Array.isArray(O)&&!(1>O.length)){var L=O[0];if(L!="noop"&&L!="stop"&&L!="close")for(var q=1;q<O.length;q++)O[q]=""}}}}return Hh(p)}catch{return d}}var zl={NO_ERROR:0,gb:1,tb:2,sb:3,nb:4,rb:5,ub:6,Ia:7,TIMEOUT:8,xb:9},T_={lb:"complete",Hb:"success",Ja:"error",Ia:"abort",zb:"ready",Ab:"readystatechange",TIMEOUT:"timeout",vb:"incrementaldata",yb:"progress",ob:"downloadprogress",Pb:"uploadprogress"},Yh;function Bl(){}I(Bl,Gh),Bl.prototype.g=function(){return new XMLHttpRequest},Bl.prototype.i=function(){return{}},Yh=new Bl;function br(l,d,p,_){this.j=l,this.i=d,this.l=p,this.R=_||1,this.U=new wi(this),this.I=45e3,this.H=null,this.o=!1,this.m=this.A=this.v=this.L=this.F=this.S=this.B=null,this.D=[],this.g=null,this.C=0,this.s=this.u=null,this.X=-1,this.J=!1,this.O=0,this.M=null,this.W=this.K=this.T=this.P=!1,this.h=new I_}function I_(){this.i=null,this.g="",this.h=!1}var S_={},Xh={};function Jh(l,d,p){l.L=1,l.v=Hl(er(d)),l.m=p,l.P=!0,k_(l,null)}function k_(l,d){l.F=Date.now(),$l(l),l.A=er(l.v);var p=l.A,_=l.R;Array.isArray(_)||(_=[String(_)]),U_(p.i,"t",_),l.C=0,p=l.j.J,l.h=new I_,l.g=ry(l.j,p?d:null,!l.m),0<l.O&&(l.M=new No(g(l.Y,l,l.g),l.O)),d=l.U,p=l.g,_=l.ca;var O="readystatechange";Array.isArray(O)||(O&&(Ul[0]=O.toString()),O=Ul);for(var L=0;L<O.length;L++){var q=nt(p,O[L],_||d.handleEvent,!1,d.h||d);if(!q)break;d.g[q.key]=q}d=l.H?y(l.H):{},l.m?(l.u||(l.u="POST"),d["Content-Type"]="application/x-www-form-urlencoded",l.g.ea(l.A,l.u,l.m,d)):(l.u="GET",l.g.ea(l.A,l.u,null,d)),Oo(),Zk(l.i,l.u,l.A,l.l,l.R,l.m)}br.prototype.ca=function(l){l=l.target;const d=this.M;d&&tr(l)==3?d.j():this.Y(l)},br.prototype.Y=function(l){try{if(l==this.g)e:{const bt=tr(this.g);var d=this.g.Ba();const ps=this.g.Z();if(!(3>bt)&&(bt!=3||this.g&&(this.h.h||this.g.oa()||H_(this.g)))){this.J||bt!=4||d==7||(d==8||0>=ps?Oo(3):Oo(2)),Zh(this);var p=this.g.Z();this.X=p;t:if(C_(this)){var _=H_(this.g);l="";var O=_.length,L=tr(this.g)==4;if(!this.h.i){if(typeof TextDecoder>"u"){Ti(this),Fo(this);var q="";break t}this.h.i=new a.TextDecoder}for(d=0;d<O;d++)this.h.h=!0,l+=this.h.i.decode(_[d],{stream:!(L&&d==O-1)});_.length=0,this.h.g+=l,this.C=0,q=this.h.g}else q=this.g.oa();if(this.o=p==200,eC(this.i,this.u,this.A,this.l,this.R,bt,p),this.o){if(this.T&&!this.K){t:{if(this.g){var De,yt=this.g;if((De=yt.g?yt.g.getResponseHeader("X-HTTP-Initial-Response"):null)&&!w(De)){var Te=De;break t}}Te=null}if(p=Te)hs(this.i,this.l,p,"Initial handshake response via X-HTTP-Initial-Response"),this.K=!0,ed(this,p);else{this.o=!1,this.s=3,Bt(12),Ti(this),Fo(this);break e}}if(this.P){p=!0;let Rn;for(;!this.J&&this.C<q.length;)if(Rn=rC(this,q),Rn==Xh){bt==4&&(this.s=4,Bt(14),p=!1),hs(this.i,this.l,null,"[Incomplete Response]");break}else if(Rn==S_){this.s=4,Bt(15),hs(this.i,this.l,q,"[Invalid Chunk]"),p=!1;break}else hs(this.i,this.l,Rn,null),ed(this,Rn);if(C_(this)&&this.C!=0&&(this.h.g=this.h.g.slice(this.C),this.C=0),bt!=4||q.length!=0||this.h.h||(this.s=1,Bt(16),p=!1),this.o=this.o&&p,!p)hs(this.i,this.l,q,"[Invalid Chunked Response]"),Ti(this),Fo(this);else if(0<q.length&&!this.W){this.W=!0;var At=this.j;At.g==this&&At.ba&&!At.M&&(At.j.info("Great, no buffering proxy detected. Bytes received: "+q.length),od(At),At.M=!0,Bt(11))}}else hs(this.i,this.l,q,null),ed(this,q);bt==4&&Ti(this),this.o&&!this.J&&(bt==4?Z_(this.j,this):(this.o=!1,$l(this)))}else wC(this.g),p==400&&0<q.indexOf("Unknown SID")?(this.s=3,Bt(12)):(this.s=0,Bt(13)),Ti(this),Fo(this)}}}catch{}finally{}};function C_(l){return l.g?l.u=="GET"&&l.L!=2&&l.j.Ca:!1}function rC(l,d){var p=l.C,_=d.indexOf(`
`,p);return _==-1?Xh:(p=Number(d.substring(p,_)),isNaN(p)?S_:(_+=1,_+p>d.length?Xh:(d=d.slice(_,_+p),l.C=_+p,d)))}br.prototype.cancel=function(){this.J=!0,Ti(this)};function $l(l){l.S=Date.now()+l.I,R_(l,l.I)}function R_(l,d){if(l.B!=null)throw Error("WatchDog timer not null");l.B=Mo(g(l.ba,l),d)}function Zh(l){l.B&&(a.clearTimeout(l.B),l.B=null)}br.prototype.ba=function(){this.B=null;const l=Date.now();0<=l-this.S?(tC(this.i,this.A),this.L!=2&&(Oo(),Bt(17)),Ti(this),this.s=2,Fo(this)):R_(this,this.S-l)};function Fo(l){l.j.G==0||l.J||Z_(l.j,l)}function Ti(l){Zh(l);var d=l.M;d&&typeof d.ma=="function"&&d.ma(),l.M=null,m_(l.U),l.g&&(d=l.g,l.g=null,d.abort(),d.ma())}function ed(l,d){try{var p=l.j;if(p.G!=0&&(p.g==l||td(p.h,l))){if(!l.K&&td(p.h,l)&&p.G==3){try{var _=p.Da.g.parse(d)}catch{_=null}if(Array.isArray(_)&&_.length==3){var O=_;if(O[0]==0){e:if(!p.u){if(p.g)if(p.g.F+3e3<l.F)Jl(p),Yl(p);else break e;sd(p),Bt(18)}}else p.za=O[1],0<p.za-p.T&&37500>O[2]&&p.F&&p.v==0&&!p.C&&(p.C=Mo(g(p.Za,p),6e3));if(1>=b_(p.h)&&p.ca){try{p.ca()}catch{}p.ca=void 0}}else Si(p,11)}else if((l.K||p.g==l)&&Jl(p),!w(d))for(O=p.Da.g.parse(d),d=0;d<O.length;d++){let Te=O[d];if(p.T=Te[0],Te=Te[1],p.G==2)if(Te[0]=="c"){p.K=Te[1],p.ia=Te[2];const At=Te[3];At!=null&&(p.la=At,p.j.info("VER="+p.la));const bt=Te[4];bt!=null&&(p.Aa=bt,p.j.info("SVER="+p.Aa));const ps=Te[5];ps!=null&&typeof ps=="number"&&0<ps&&(_=1.5*ps,p.L=_,p.j.info("backChannelRequestTimeoutMs_="+_)),_=p;const Rn=l.g;if(Rn){const eu=Rn.g?Rn.g.getResponseHeader("X-Client-Wire-Protocol"):null;if(eu){var L=_.h;L.g||eu.indexOf("spdy")==-1&&eu.indexOf("quic")==-1&&eu.indexOf("h2")==-1||(L.j=L.l,L.g=new Set,L.h&&(nd(L,L.h),L.h=null))}if(_.D){const ad=Rn.g?Rn.g.getResponseHeader("X-HTTP-Session-Id"):null;ad&&(_.ya=ad,Le(_.I,_.D,ad))}}p.G=3,p.l&&p.l.ua(),p.ba&&(p.R=Date.now()-l.F,p.j.info("Handshake RTT: "+p.R+"ms")),_=p;var q=l;if(_.qa=ny(_,_.J?_.ia:null,_.W),q.K){P_(_.h,q);var De=q,yt=_.L;yt&&(De.I=yt),De.B&&(Zh(De),$l(De)),_.g=q}else X_(_);0<p.i.length&&Xl(p)}else Te[0]!="stop"&&Te[0]!="close"||Si(p,7);else p.G==3&&(Te[0]=="stop"||Te[0]=="close"?Te[0]=="stop"?Si(p,7):id(p):Te[0]!="noop"&&p.l&&p.l.ta(Te),p.v=0)}}Oo(4)}catch{}}var iC=class{constructor(l,d){this.g=l,this.map=d}};function x_(l){this.l=l||10,a.PerformanceNavigationTiming?(l=a.performance.getEntriesByType("navigation"),l=0<l.length&&(l[0].nextHopProtocol=="hq"||l[0].nextHopProtocol=="h2")):l=!!(a.chrome&&a.chrome.loadTimes&&a.chrome.loadTimes()&&a.chrome.loadTimes().wasFetchedViaSpdy),this.j=l?this.l:1,this.g=null,1<this.j&&(this.g=new Set),this.h=null,this.i=[]}function A_(l){return l.h?!0:l.g?l.g.size>=l.j:!1}function b_(l){return l.h?1:l.g?l.g.size:0}function td(l,d){return l.h?l.h==d:l.g?l.g.has(d):!1}function nd(l,d){l.g?l.g.add(d):l.h=d}function P_(l,d){l.h&&l.h==d?l.h=null:l.g&&l.g.has(d)&&l.g.delete(d)}x_.prototype.cancel=function(){if(this.i=N_(this),this.h)this.h.cancel(),this.h=null;else if(this.g&&this.g.size!==0){for(const l of this.g.values())l.cancel();this.g.clear()}};function N_(l){if(l.h!=null)return l.i.concat(l.h.D);if(l.g!=null&&l.g.size!==0){let d=l.i;for(const p of l.g.values())d=d.concat(p.D);return d}return N(l.i)}function sC(l){if(l.V&&typeof l.V=="function")return l.V();if(typeof Map<"u"&&l instanceof Map||typeof Set<"u"&&l instanceof Set)return Array.from(l.values());if(typeof l=="string")return l.split("");if(u(l)){for(var d=[],p=l.length,_=0;_<p;_++)d.push(l[_]);return d}d=[],p=0;for(_ in l)d[p++]=l[_];return d}function oC(l){if(l.na&&typeof l.na=="function")return l.na();if(!l.V||typeof l.V!="function"){if(typeof Map<"u"&&l instanceof Map)return Array.from(l.keys());if(!(typeof Set<"u"&&l instanceof Set)){if(u(l)||typeof l=="string"){var d=[];l=l.length;for(var p=0;p<l;p++)d.push(p);return d}d=[],p=0;for(const _ in l)d[p++]=_;return d}}}function D_(l,d){if(l.forEach&&typeof l.forEach=="function")l.forEach(d,void 0);else if(u(l)||typeof l=="string")Array.prototype.forEach.call(l,d,void 0);else for(var p=oC(l),_=sC(l),O=_.length,L=0;L<O;L++)d.call(void 0,_[L],p&&p[L],l)}var O_=RegExp("^(?:([^:/?#.]+):)?(?://(?:([^\\\\/?#]*)@)?([^\\\\/?#]*?)(?::([0-9]+))?(?=[\\\\/?#]|$))?([^?#]+)?(?:\\?([^#]*))?(?:#([\\s\\S]*))?$");function aC(l,d){if(l){l=l.split("&");for(var p=0;p<l.length;p++){var _=l[p].indexOf("="),O=null;if(0<=_){var L=l[p].substring(0,_);O=l[p].substring(_+1)}else L=l[p];d(L,O?decodeURIComponent(O.replace(/\+/g," ")):"")}}}function Ii(l){if(this.g=this.o=this.j="",this.s=null,this.m=this.l="",this.h=!1,l instanceof Ii){this.h=l.h,Wl(this,l.j),this.o=l.o,this.g=l.g,ql(this,l.s),this.l=l.l;var d=l.i,p=new jo;p.i=d.i,d.g&&(p.g=new Map(d.g),p.h=d.h),M_(this,p),this.m=l.m}else l&&(d=String(l).match(O_))?(this.h=!1,Wl(this,d[1]||"",!0),this.o=Vo(d[2]||""),this.g=Vo(d[3]||"",!0),ql(this,d[4]),this.l=Vo(d[5]||"",!0),M_(this,d[6]||"",!0),this.m=Vo(d[7]||"")):(this.h=!1,this.i=new jo(null,this.h))}Ii.prototype.toString=function(){var l=[],d=this.j;d&&l.push(Uo(d,L_,!0),":");var p=this.g;return(p||d=="file")&&(l.push("//"),(d=this.o)&&l.push(Uo(d,L_,!0),"@"),l.push(encodeURIComponent(String(p)).replace(/%25([0-9a-fA-F]{2})/g,"%$1")),p=this.s,p!=null&&l.push(":",String(p))),(p=this.l)&&(this.g&&p.charAt(0)!="/"&&l.push("/"),l.push(Uo(p,p.charAt(0)=="/"?cC:uC,!0))),(p=this.i.toString())&&l.push("?",p),(p=this.m)&&l.push("#",Uo(p,dC)),l.join("")};function er(l){return new Ii(l)}function Wl(l,d,p){l.j=p?Vo(d,!0):d,l.j&&(l.j=l.j.replace(/:$/,""))}function ql(l,d){if(d){if(d=Number(d),isNaN(d)||0>d)throw Error("Bad port number "+d);l.s=d}else l.s=null}function M_(l,d,p){d instanceof jo?(l.i=d,fC(l.i,l.h)):(p||(d=Uo(d,hC)),l.i=new jo(d,l.h))}function Le(l,d,p){l.i.set(d,p)}function Hl(l){return Le(l,"zx",Math.floor(2147483648*Math.random()).toString(36)+Math.abs(Math.floor(2147483648*Math.random())^Date.now()).toString(36)),l}function Vo(l,d){return l?d?decodeURI(l.replace(/%25/g,"%2525")):decodeURIComponent(l):""}function Uo(l,d,p){return typeof l=="string"?(l=encodeURI(l).replace(d,lC),p&&(l=l.replace(/%25([0-9a-fA-F]{2})/g,"%$1")),l):null}function lC(l){return l=l.charCodeAt(0),"%"+(l>>4&15).toString(16)+(l&15).toString(16)}var L_=/[#\/\?@]/g,uC=/[#\?:]/g,cC=/[#\?]/g,hC=/[#\?@]/g,dC=/#/g;function jo(l,d){this.h=this.g=null,this.i=l||null,this.j=!!d}function Pr(l){l.g||(l.g=new Map,l.h=0,l.i&&aC(l.i,function(d,p){l.add(decodeURIComponent(d.replace(/\+/g," ")),p)}))}t=jo.prototype,t.add=function(l,d){Pr(this),this.i=null,l=ds(this,l);var p=this.g.get(l);return p||this.g.set(l,p=[]),p.push(d),this.h+=1,this};function F_(l,d){Pr(l),d=ds(l,d),l.g.has(d)&&(l.i=null,l.h-=l.g.get(d).length,l.g.delete(d))}function V_(l,d){return Pr(l),d=ds(l,d),l.g.has(d)}t.forEach=function(l,d){Pr(this),this.g.forEach(function(p,_){p.forEach(function(O){l.call(d,O,_,this)},this)},this)},t.na=function(){Pr(this);const l=Array.from(this.g.values()),d=Array.from(this.g.keys()),p=[];for(let _=0;_<d.length;_++){const O=l[_];for(let L=0;L<O.length;L++)p.push(d[_])}return p},t.V=function(l){Pr(this);let d=[];if(typeof l=="string")V_(this,l)&&(d=d.concat(this.g.get(ds(this,l))));else{l=Array.from(this.g.values());for(let p=0;p<l.length;p++)d=d.concat(l[p])}return d},t.set=function(l,d){return Pr(this),this.i=null,l=ds(this,l),V_(this,l)&&(this.h-=this.g.get(l).length),this.g.set(l,[d]),this.h+=1,this},t.get=function(l,d){return l?(l=this.V(l),0<l.length?String(l[0]):d):d};function U_(l,d,p){F_(l,d),0<p.length&&(l.i=null,l.g.set(ds(l,d),N(p)),l.h+=p.length)}t.toString=function(){if(this.i)return this.i;if(!this.g)return"";const l=[],d=Array.from(this.g.keys());for(var p=0;p<d.length;p++){var _=d[p];const L=encodeURIComponent(String(_)),q=this.V(_);for(_=0;_<q.length;_++){var O=L;q[_]!==""&&(O+="="+encodeURIComponent(String(q[_]))),l.push(O)}}return this.i=l.join("&")};function ds(l,d){return d=String(d),l.j&&(d=d.toLowerCase()),d}function fC(l,d){d&&!l.j&&(Pr(l),l.i=null,l.g.forEach(function(p,_){var O=_.toLowerCase();_!=O&&(F_(this,_),U_(this,O,p))},l)),l.j=d}function pC(l,d){const p=new Lo;if(a.Image){const _=new Image;_.onload=v(Nr,p,"TestLoadImage: loaded",!0,d,_),_.onerror=v(Nr,p,"TestLoadImage: error",!1,d,_),_.onabort=v(Nr,p,"TestLoadImage: abort",!1,d,_),_.ontimeout=v(Nr,p,"TestLoadImage: timeout",!1,d,_),a.setTimeout(function(){_.ontimeout&&_.ontimeout()},1e4),_.src=l}else d(!1)}function mC(l,d){const p=new Lo,_=new AbortController,O=setTimeout(()=>{_.abort(),Nr(p,"TestPingServer: timeout",!1,d)},1e4);fetch(l,{signal:_.signal}).then(L=>{clearTimeout(O),L.ok?Nr(p,"TestPingServer: ok",!0,d):Nr(p,"TestPingServer: server error",!1,d)}).catch(()=>{clearTimeout(O),Nr(p,"TestPingServer: error",!1,d)})}function Nr(l,d,p,_,O){try{O&&(O.onload=null,O.onerror=null,O.onabort=null,O.ontimeout=null),_(p)}catch{}}function gC(){this.g=new Jk}function _C(l,d,p){const _=p||"";try{D_(l,function(O,L){let q=O;c(O)&&(q=Hh(O)),d.push(_+L+"="+encodeURIComponent(q))})}catch(O){throw d.push(_+"type="+encodeURIComponent("_badmap")),O}}function Gl(l){this.l=l.Ub||null,this.j=l.eb||!1}I(Gl,Gh),Gl.prototype.g=function(){return new Kl(this.l,this.j)},Gl.prototype.i=function(l){return function(){return l}}({});function Kl(l,d){at.call(this),this.D=l,this.o=d,this.m=void 0,this.status=this.readyState=0,this.responseType=this.responseText=this.response=this.statusText="",this.onreadystatechange=null,this.u=new Headers,this.h=null,this.B="GET",this.A="",this.g=!1,this.v=this.j=this.l=null}I(Kl,at),t=Kl.prototype,t.open=function(l,d){if(this.readyState!=0)throw this.abort(),Error("Error reopening a connection");this.B=l,this.A=d,this.readyState=1,Bo(this)},t.send=function(l){if(this.readyState!=1)throw this.abort(),Error("need to call open() first. ");this.g=!0;const d={headers:this.u,method:this.B,credentials:this.m,cache:void 0};l&&(d.body=l),(this.D||a).fetch(new Request(this.A,d)).then(this.Sa.bind(this),this.ga.bind(this))},t.abort=function(){this.response=this.responseText="",this.u=new Headers,this.status=0,this.j&&this.j.cancel("Request was aborted.").catch(()=>{}),1<=this.readyState&&this.g&&this.readyState!=4&&(this.g=!1,zo(this)),this.readyState=0},t.Sa=function(l){if(this.g&&(this.l=l,this.h||(this.status=this.l.status,this.statusText=this.l.statusText,this.h=l.headers,this.readyState=2,Bo(this)),this.g&&(this.readyState=3,Bo(this),this.g)))if(this.responseType==="arraybuffer")l.arrayBuffer().then(this.Qa.bind(this),this.ga.bind(this));else if(typeof a.ReadableStream<"u"&&"body"in l){if(this.j=l.body.getReader(),this.o){if(this.responseType)throw Error('responseType must be empty for "streamBinaryChunks" mode responses.');this.response=[]}else this.response=this.responseText="",this.v=new TextDecoder;j_(this)}else l.text().then(this.Ra.bind(this),this.ga.bind(this))};function j_(l){l.j.read().then(l.Pa.bind(l)).catch(l.ga.bind(l))}t.Pa=function(l){if(this.g){if(this.o&&l.value)this.response.push(l.value);else if(!this.o){var d=l.value?l.value:new Uint8Array(0);(d=this.v.decode(d,{stream:!l.done}))&&(this.response=this.responseText+=d)}l.done?zo(this):Bo(this),this.readyState==3&&j_(this)}},t.Ra=function(l){this.g&&(this.response=this.responseText=l,zo(this))},t.Qa=function(l){this.g&&(this.response=l,zo(this))},t.ga=function(){this.g&&zo(this)};function zo(l){l.readyState=4,l.l=null,l.j=null,l.v=null,Bo(l)}t.setRequestHeader=function(l,d){this.u.append(l,d)},t.getResponseHeader=function(l){return this.h&&this.h.get(l.toLowerCase())||""},t.getAllResponseHeaders=function(){if(!this.h)return"";const l=[],d=this.h.entries();for(var p=d.next();!p.done;)p=p.value,l.push(p[0]+": "+p[1]),p=d.next();return l.join(`\r
`)};function Bo(l){l.onreadystatechange&&l.onreadystatechange.call(l)}Object.defineProperty(Kl.prototype,"withCredentials",{get:function(){return this.m==="include"},set:function(l){this.m=l?"include":"same-origin"}});function z_(l){let d="";return U(l,function(p,_){d+=_,d+=":",d+=p,d+=`\r
`}),d}function rd(l,d,p){e:{for(_ in p){var _=!1;break e}_=!0}_||(p=z_(p),typeof l=="string"?p!=null&&encodeURIComponent(String(p)):Le(l,d,p))}function Qe(l){at.call(this),this.headers=new Map,this.o=l||null,this.h=!1,this.v=this.g=null,this.D="",this.m=0,this.l="",this.j=this.B=this.u=this.A=!1,this.I=null,this.H="",this.J=!1}I(Qe,at);var yC=/^https?$/i,vC=["POST","PUT"];t=Qe.prototype,t.Ha=function(l){this.J=l},t.ea=function(l,d,p,_){if(this.g)throw Error("[goog.net.XhrIo] Object is active with another request="+this.D+"; newUri="+l);d=d?d.toUpperCase():"GET",this.D=l,this.l="",this.m=0,this.A=!1,this.h=!0,this.g=this.o?this.o.g():Yh.g(),this.v=this.o?g_(this.o):g_(Yh),this.g.onreadystatechange=g(this.Ea,this);try{this.B=!0,this.g.open(d,String(l),!0),this.B=!1}catch(L){B_(this,L);return}if(l=p||"",p=new Map(this.headers),_)if(Object.getPrototypeOf(_)===Object.prototype)for(var O in _)p.set(O,_[O]);else if(typeof _.keys=="function"&&typeof _.get=="function")for(const L of _.keys())p.set(L,_.get(L));else throw Error("Unknown input type for opt_headers: "+String(_));_=Array.from(p.keys()).find(L=>L.toLowerCase()=="content-type"),O=a.FormData&&l instanceof a.FormData,!(0<=Array.prototype.indexOf.call(vC,d,void 0))||_||O||p.set("Content-Type","application/x-www-form-urlencoded;charset=utf-8");for(const[L,q]of p)this.g.setRequestHeader(L,q);this.H&&(this.g.responseType=this.H),"withCredentials"in this.g&&this.g.withCredentials!==this.J&&(this.g.withCredentials=this.J);try{q_(this),this.u=!0,this.g.send(l),this.u=!1}catch(L){B_(this,L)}};function B_(l,d){l.h=!1,l.g&&(l.j=!0,l.g.abort(),l.j=!1),l.l=d,l.m=5,$_(l),Ql(l)}function $_(l){l.A||(l.A=!0,_t(l,"complete"),_t(l,"error"))}t.abort=function(l){this.g&&this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1,this.m=l||7,_t(this,"complete"),_t(this,"abort"),Ql(this))},t.N=function(){this.g&&(this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1),Ql(this,!0)),Qe.aa.N.call(this)},t.Ea=function(){this.s||(this.B||this.u||this.j?W_(this):this.bb())},t.bb=function(){W_(this)};function W_(l){if(l.h&&typeof o<"u"&&(!l.v[1]||tr(l)!=4||l.Z()!=2)){if(l.u&&tr(l)==4)bo(l.Ea,0,l);else if(_t(l,"readystatechange"),tr(l)==4){l.h=!1;try{const q=l.Z();e:switch(q){case 200:case 201:case 202:case 204:case 206:case 304:case 1223:var d=!0;break e;default:d=!1}var p;if(!(p=d)){var _;if(_=q===0){var O=String(l.D).match(O_)[1]||null;!O&&a.self&&a.self.location&&(O=a.self.location.protocol.slice(0,-1)),_=!yC.test(O?O.toLowerCase():"")}p=_}if(p)_t(l,"complete"),_t(l,"success");else{l.m=6;try{var L=2<tr(l)?l.g.statusText:""}catch{L=""}l.l=L+" ["+l.Z()+"]",$_(l)}}finally{Ql(l)}}}}function Ql(l,d){if(l.g){q_(l);const p=l.g,_=l.v[0]?()=>{}:null;l.g=null,l.v=null,d||_t(l,"ready");try{p.onreadystatechange=_}catch{}}}function q_(l){l.I&&(a.clearTimeout(l.I),l.I=null)}t.isActive=function(){return!!this.g};function tr(l){return l.g?l.g.readyState:0}t.Z=function(){try{return 2<tr(this)?this.g.status:-1}catch{return-1}},t.oa=function(){try{return this.g?this.g.responseText:""}catch{return""}},t.Oa=function(l){if(this.g){var d=this.g.responseText;return l&&d.indexOf(l)==0&&(d=d.substring(l.length)),Xk(d)}};function H_(l){try{if(!l.g)return null;if("response"in l.g)return l.g.response;switch(l.H){case"":case"text":return l.g.responseText;case"arraybuffer":if("mozResponseArrayBuffer"in l.g)return l.g.mozResponseArrayBuffer}return null}catch{return null}}function wC(l){const d={};l=(l.g&&2<=tr(l)&&l.g.getAllResponseHeaders()||"").split(`\r
`);for(let _=0;_<l.length;_++){if(w(l[_]))continue;var p=b(l[_]);const O=p[0];if(p=p[1],typeof p!="string")continue;p=p.trim();const L=d[O]||[];d[O]=L,L.push(p)}E(d,function(_){return _.join(", ")})}t.Ba=function(){return this.m},t.Ka=function(){return typeof this.l=="string"?this.l:String(this.l)};function $o(l,d,p){return p&&p.internalChannelParams&&p.internalChannelParams[l]||d}function G_(l){this.Aa=0,this.i=[],this.j=new Lo,this.ia=this.qa=this.I=this.W=this.g=this.ya=this.D=this.H=this.m=this.S=this.o=null,this.Ya=this.U=0,this.Va=$o("failFast",!1,l),this.F=this.C=this.u=this.s=this.l=null,this.X=!0,this.za=this.T=-1,this.Y=this.v=this.B=0,this.Ta=$o("baseRetryDelayMs",5e3,l),this.cb=$o("retryDelaySeedMs",1e4,l),this.Wa=$o("forwardChannelMaxRetries",2,l),this.wa=$o("forwardChannelRequestTimeoutMs",2e4,l),this.pa=l&&l.xmlHttpFactory||void 0,this.Xa=l&&l.Tb||void 0,this.Ca=l&&l.useFetchStreams||!1,this.L=void 0,this.J=l&&l.supportsCrossDomainXhr||!1,this.K="",this.h=new x_(l&&l.concurrentRequestLimit),this.Da=new gC,this.P=l&&l.fastHandshake||!1,this.O=l&&l.encodeInitMessageHeaders||!1,this.P&&this.O&&(this.O=!1),this.Ua=l&&l.Rb||!1,l&&l.xa&&this.j.xa(),l&&l.forceLongPolling&&(this.X=!1),this.ba=!this.P&&this.X&&l&&l.detectBufferingProxy||!1,this.ja=void 0,l&&l.longPollingTimeout&&0<l.longPollingTimeout&&(this.ja=l.longPollingTimeout),this.ca=void 0,this.R=0,this.M=!1,this.ka=this.A=null}t=G_.prototype,t.la=8,t.G=1,t.connect=function(l,d,p,_){Bt(0),this.W=l,this.H=d||{},p&&_!==void 0&&(this.H.OSID=p,this.H.OAID=_),this.F=this.X,this.I=ny(this,null,this.W),Xl(this)};function id(l){if(K_(l),l.G==3){var d=l.U++,p=er(l.I);if(Le(p,"SID",l.K),Le(p,"RID",d),Le(p,"TYPE","terminate"),Wo(l,p),d=new br(l,l.j,d),d.L=2,d.v=Hl(er(p)),p=!1,a.navigator&&a.navigator.sendBeacon)try{p=a.navigator.sendBeacon(d.v.toString(),"")}catch{}!p&&a.Image&&(new Image().src=d.v,p=!0),p||(d.g=ry(d.j,null),d.g.ea(d.v)),d.F=Date.now(),$l(d)}ty(l)}function Yl(l){l.g&&(od(l),l.g.cancel(),l.g=null)}function K_(l){Yl(l),l.u&&(a.clearTimeout(l.u),l.u=null),Jl(l),l.h.cancel(),l.s&&(typeof l.s=="number"&&a.clearTimeout(l.s),l.s=null)}function Xl(l){if(!A_(l.h)&&!l.s){l.s=!0;var d=l.Ga;Rt||P(),H||(Rt(),H=!0),re.add(d,l),l.B=0}}function EC(l,d){return b_(l.h)>=l.h.j-(l.s?1:0)?!1:l.s?(l.i=d.D.concat(l.i),!0):l.G==1||l.G==2||l.B>=(l.Va?0:l.Wa)?!1:(l.s=Mo(g(l.Ga,l,d),ey(l,l.B)),l.B++,!0)}t.Ga=function(l){if(this.s)if(this.s=null,this.G==1){if(!l){this.U=Math.floor(1e5*Math.random()),l=this.U++;const O=new br(this,this.j,l);let L=this.o;if(this.S&&(L?(L=y(L),x(L,this.S)):L=this.S),this.m!==null||this.O||(O.H=L,L=null),this.P)e:{for(var d=0,p=0;p<this.i.length;p++){t:{var _=this.i[p];if("__data__"in _.map&&(_=_.map.__data__,typeof _=="string")){_=_.length;break t}_=void 0}if(_===void 0)break;if(d+=_,4096<d){d=p;break e}if(d===4096||p===this.i.length-1){d=p+1;break e}}d=1e3}else d=1e3;d=Y_(this,O,d),p=er(this.I),Le(p,"RID",l),Le(p,"CVER",22),this.D&&Le(p,"X-HTTP-Session-Id",this.D),Wo(this,p),L&&(this.O?d="headers="+encodeURIComponent(String(z_(L)))+"&"+d:this.m&&rd(p,this.m,L)),nd(this.h,O),this.Ua&&Le(p,"TYPE","init"),this.P?(Le(p,"$req",d),Le(p,"SID","null"),O.T=!0,Jh(O,p,null)):Jh(O,p,d),this.G=2}}else this.G==3&&(l?Q_(this,l):this.i.length==0||A_(this.h)||Q_(this))};function Q_(l,d){var p;d?p=d.l:p=l.U++;const _=er(l.I);Le(_,"SID",l.K),Le(_,"RID",p),Le(_,"AID",l.T),Wo(l,_),l.m&&l.o&&rd(_,l.m,l.o),p=new br(l,l.j,p,l.B+1),l.m===null&&(p.H=l.o),d&&(l.i=d.D.concat(l.i)),d=Y_(l,p,1e3),p.I=Math.round(.5*l.wa)+Math.round(.5*l.wa*Math.random()),nd(l.h,p),Jh(p,_,d)}function Wo(l,d){l.H&&U(l.H,function(p,_){Le(d,_,p)}),l.l&&D_({},function(p,_){Le(d,_,p)})}function Y_(l,d,p){p=Math.min(l.i.length,p);var _=l.l?g(l.l.Na,l.l,l):null;e:{var O=l.i;let L=-1;for(;;){const q=["count="+p];L==-1?0<p?(L=O[0].g,q.push("ofs="+L)):L=0:q.push("ofs="+L);let De=!0;for(let yt=0;yt<p;yt++){let Te=O[yt].g;const At=O[yt].map;if(Te-=L,0>Te)L=Math.max(0,O[yt].g-100),De=!1;else try{_C(At,q,"req"+Te+"_")}catch{_&&_(At)}}if(De){_=q.join("&");break e}}}return l=l.i.splice(0,p),d.D=l,_}function X_(l){if(!l.g&&!l.u){l.Y=1;var d=l.Fa;Rt||P(),H||(Rt(),H=!0),re.add(d,l),l.v=0}}function sd(l){return l.g||l.u||3<=l.v?!1:(l.Y++,l.u=Mo(g(l.Fa,l),ey(l,l.v)),l.v++,!0)}t.Fa=function(){if(this.u=null,J_(this),this.ba&&!(this.M||this.g==null||0>=this.R)){var l=2*this.R;this.j.info("BP detection timer enabled: "+l),this.A=Mo(g(this.ab,this),l)}},t.ab=function(){this.A&&(this.A=null,this.j.info("BP detection timeout reached."),this.j.info("Buffering proxy detected and switch to long-polling!"),this.F=!1,this.M=!0,Bt(10),Yl(this),J_(this))};function od(l){l.A!=null&&(a.clearTimeout(l.A),l.A=null)}function J_(l){l.g=new br(l,l.j,"rpc",l.Y),l.m===null&&(l.g.H=l.o),l.g.O=0;var d=er(l.qa);Le(d,"RID","rpc"),Le(d,"SID",l.K),Le(d,"AID",l.T),Le(d,"CI",l.F?"0":"1"),!l.F&&l.ja&&Le(d,"TO",l.ja),Le(d,"TYPE","xmlhttp"),Wo(l,d),l.m&&l.o&&rd(d,l.m,l.o),l.L&&(l.g.I=l.L);var p=l.g;l=l.ia,p.L=1,p.v=Hl(er(d)),p.m=null,p.P=!0,k_(p,l)}t.Za=function(){this.C!=null&&(this.C=null,Yl(this),sd(this),Bt(19))};function Jl(l){l.C!=null&&(a.clearTimeout(l.C),l.C=null)}function Z_(l,d){var p=null;if(l.g==d){Jl(l),od(l),l.g=null;var _=2}else if(td(l.h,d))p=d.D,P_(l.h,d),_=1;else return;if(l.G!=0){if(d.o)if(_==1){p=d.m?d.m.length:0,d=Date.now()-d.F;var O=l.B;_=jl(),_t(_,new E_(_,p)),Xl(l)}else X_(l);else if(O=d.s,O==3||O==0&&0<d.X||!(_==1&&EC(l,d)||_==2&&sd(l)))switch(p&&0<p.length&&(d=l.h,d.i=d.i.concat(p)),O){case 1:Si(l,5);break;case 4:Si(l,10);break;case 3:Si(l,6);break;default:Si(l,2)}}}function ey(l,d){let p=l.Ta+Math.floor(Math.random()*l.cb);return l.isActive()||(p*=2),p*d}function Si(l,d){if(l.j.info("Error code "+d),d==2){var p=g(l.fb,l),_=l.Xa;const O=!_;_=new Ii(_||"//www.google.com/images/cleardot.gif"),a.location&&a.location.protocol=="http"||Wl(_,"https"),Hl(_),O?pC(_.toString(),p):mC(_.toString(),p)}else Bt(2);l.G=0,l.l&&l.l.sa(d),ty(l),K_(l)}t.fb=function(l){l?(this.j.info("Successfully pinged google.com"),Bt(2)):(this.j.info("Failed to ping google.com"),Bt(1))};function ty(l){if(l.G=0,l.ka=[],l.l){const d=N_(l.h);(d.length!=0||l.i.length!=0)&&(D(l.ka,d),D(l.ka,l.i),l.h.i.length=0,N(l.i),l.i.length=0),l.l.ra()}}function ny(l,d,p){var _=p instanceof Ii?er(p):new Ii(p);if(_.g!="")d&&(_.g=d+"."+_.g),ql(_,_.s);else{var O=a.location;_=O.protocol,d=d?d+"."+O.hostname:O.hostname,O=+O.port;var L=new Ii(null);_&&Wl(L,_),d&&(L.g=d),O&&ql(L,O),p&&(L.l=p),_=L}return p=l.D,d=l.ya,p&&d&&Le(_,p,d),Le(_,"VER",l.la),Wo(l,_),_}function ry(l,d,p){if(d&&!l.J)throw Error("Can't create secondary domain capable XhrIo object.");return d=l.Ca&&!l.pa?new Qe(new Gl({eb:p})):new Qe(l.pa),d.Ha(l.J),d}t.isActive=function(){return!!this.l&&this.l.isActive(this)};function iy(){}t=iy.prototype,t.ua=function(){},t.ta=function(){},t.sa=function(){},t.ra=function(){},t.isActive=function(){return!0},t.Na=function(){};function Zl(){}Zl.prototype.g=function(l,d){return new rn(l,d)};function rn(l,d){at.call(this),this.g=new G_(d),this.l=l,this.h=d&&d.messageUrlParams||null,l=d&&d.messageHeaders||null,d&&d.clientProtocolHeaderRequired&&(l?l["X-Client-Protocol"]="webchannel":l={"X-Client-Protocol":"webchannel"}),this.g.o=l,l=d&&d.initMessageHeaders||null,d&&d.messageContentType&&(l?l["X-WebChannel-Content-Type"]=d.messageContentType:l={"X-WebChannel-Content-Type":d.messageContentType}),d&&d.va&&(l?l["X-WebChannel-Client-Profile"]=d.va:l={"X-WebChannel-Client-Profile":d.va}),this.g.S=l,(l=d&&d.Sb)&&!w(l)&&(this.g.m=l),this.v=d&&d.supportsCrossDomainXhr||!1,this.u=d&&d.sendRawJson||!1,(d=d&&d.httpSessionIdParam)&&!w(d)&&(this.g.D=d,l=this.h,l!==null&&d in l&&(l=this.h,d in l&&delete l[d])),this.j=new fs(this)}I(rn,at),rn.prototype.m=function(){this.g.l=this.j,this.v&&(this.g.J=!0),this.g.connect(this.l,this.h||void 0)},rn.prototype.close=function(){id(this.g)},rn.prototype.o=function(l){var d=this.g;if(typeof l=="string"){var p={};p.__data__=l,l=p}else this.u&&(p={},p.__data__=Hh(l),l=p);d.i.push(new iC(d.Ya++,l)),d.G==3&&Xl(d)},rn.prototype.N=function(){this.g.l=null,delete this.j,id(this.g),delete this.g,rn.aa.N.call(this)};function sy(l){Kh.call(this),l.__headers__&&(this.headers=l.__headers__,this.statusCode=l.__status__,delete l.__headers__,delete l.__status__);var d=l.__sm__;if(d){e:{for(const p in d){l=p;break e}l=void 0}(this.i=l)&&(l=this.i,d=d!==null&&l in d?d[l]:void 0),this.data=d}else this.data=l}I(sy,Kh);function oy(){Qh.call(this),this.status=1}I(oy,Qh);function fs(l){this.g=l}I(fs,iy),fs.prototype.ua=function(){_t(this.g,"a")},fs.prototype.ta=function(l){_t(this.g,new sy(l))},fs.prototype.sa=function(l){_t(this.g,new oy)},fs.prototype.ra=function(){_t(this.g,"b")},Zl.prototype.createWebChannel=Zl.prototype.g,rn.prototype.send=rn.prototype.o,rn.prototype.open=rn.prototype.m,rn.prototype.close=rn.prototype.close,hI=function(){return new Zl},cI=function(){return jl()},uI=Ei,sp={mb:0,pb:1,qb:2,Jb:3,Ob:4,Lb:5,Mb:6,Kb:7,Ib:8,Nb:9,PROXY:10,NOPROXY:11,Gb:12,Cb:13,Db:14,Bb:15,Eb:16,Fb:17,ib:18,hb:19,jb:20},zl.NO_ERROR=0,zl.TIMEOUT=8,zl.HTTP_ERROR=6,$u=zl,T_.COMPLETE="complete",lI=T_,__.EventType=Do,Do.OPEN="a",Do.CLOSE="b",Do.ERROR="c",Do.MESSAGE="d",at.prototype.listen=at.prototype.K,da=__,Qe.prototype.listenOnce=Qe.prototype.L,Qe.prototype.getLastError=Qe.prototype.Ka,Qe.prototype.getLastErrorCode=Qe.prototype.Ba,Qe.prototype.getStatus=Qe.prototype.Z,Qe.prototype.getResponseJson=Qe.prototype.Oa,Qe.prototype.getResponseText=Qe.prototype.oa,Qe.prototype.send=Qe.prototype.ea,Qe.prototype.setWithCredentials=Qe.prototype.Ha,aI=Qe}).apply(typeof yu<"u"?yu:typeof self<"u"?self:typeof window<"u"?window:{});const Pv="@firebase/firestore";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ot{constructor(e){this.uid=e}isAuthenticated(){return this.uid!=null}toKey(){return this.isAuthenticated()?"uid:"+this.uid:"anonymous-user"}isEqual(e){return e.uid===this.uid}}Ot.UNAUTHENTICATED=new Ot(null),Ot.GOOGLE_CREDENTIALS=new Ot("google-credentials-uid"),Ot.FIRST_PARTY=new Ot("first-party-uid"),Ot.MOCK_USER=new Ot("mock-user");/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let vo="10.14.0";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qi=new yh("@firebase/firestore");function Zo(){return qi.logLevel}function J(t,...e){if(qi.logLevel<=he.DEBUG){const n=e.map(zm);qi.debug(`Firestore (${vo}): ${t}`,...n)}}function Er(t,...e){if(qi.logLevel<=he.ERROR){const n=e.map(zm);qi.error(`Firestore (${vo}): ${t}`,...n)}}function io(t,...e){if(qi.logLevel<=he.WARN){const n=e.map(zm);qi.warn(`Firestore (${vo}): ${t}`,...n)}}function zm(t){if(typeof t=="string")return t;try{/**
* @license
* Copyright 2020 Google LLC
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/return function(n){return JSON.stringify(n)}(t)}catch{return t}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function se(t="Unexpected state"){const e=`FIRESTORE (${vo}) INTERNAL ASSERTION FAILED: `+t;throw Er(e),new Error(e)}function Ae(t,e){t||se()}function le(t,e){return t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const V={OK:"ok",CANCELLED:"cancelled",UNKNOWN:"unknown",INVALID_ARGUMENT:"invalid-argument",DEADLINE_EXCEEDED:"deadline-exceeded",NOT_FOUND:"not-found",ALREADY_EXISTS:"already-exists",PERMISSION_DENIED:"permission-denied",UNAUTHENTICATED:"unauthenticated",RESOURCE_EXHAUSTED:"resource-exhausted",FAILED_PRECONDITION:"failed-precondition",ABORTED:"aborted",OUT_OF_RANGE:"out-of-range",UNIMPLEMENTED:"unimplemented",INTERNAL:"internal",UNAVAILABLE:"unavailable",DATA_LOSS:"data-loss"};class X extends Zn{constructor(e,n){super(e,n),this.code=e,this.message=n,this.toString=()=>`${this.name}: [code=${this.code}]: ${this.message}`}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ri{constructor(){this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dI{constructor(e,n){this.user=n,this.type="OAuth",this.headers=new Map,this.headers.set("Authorization",`Bearer ${e}`)}}class tP{getToken(){return Promise.resolve(null)}invalidateToken(){}start(e,n){e.enqueueRetryable(()=>n(Ot.UNAUTHENTICATED))}shutdown(){}}class nP{constructor(e){this.token=e,this.changeListener=null}getToken(){return Promise.resolve(this.token)}invalidateToken(){}start(e,n){this.changeListener=n,e.enqueueRetryable(()=>n(this.token.user))}shutdown(){this.changeListener=null}}class rP{constructor(e){this.t=e,this.currentUser=Ot.UNAUTHENTICATED,this.i=0,this.forceRefresh=!1,this.auth=null}start(e,n){Ae(this.o===void 0);let r=this.i;const i=u=>this.i!==r?(r=this.i,n(u)):Promise.resolve();let s=new ri;this.o=()=>{this.i++,this.currentUser=this.u(),s.resolve(),s=new ri,e.enqueueRetryable(()=>i(this.currentUser))};const o=()=>{const u=s;e.enqueueRetryable(async()=>{await u.promise,await i(this.currentUser)})},a=u=>{J("FirebaseAuthCredentialsProvider","Auth detected"),this.auth=u,this.o&&(this.auth.addAuthTokenListener(this.o),o())};this.t.onInit(u=>a(u)),setTimeout(()=>{if(!this.auth){const u=this.t.getImmediate({optional:!0});u?a(u):(J("FirebaseAuthCredentialsProvider","Auth not yet detected"),s.resolve(),s=new ri)}},0),o()}getToken(){const e=this.i,n=this.forceRefresh;return this.forceRefresh=!1,this.auth?this.auth.getToken(n).then(r=>this.i!==e?(J("FirebaseAuthCredentialsProvider","getToken aborted due to token change."),this.getToken()):r?(Ae(typeof r.accessToken=="string"),new dI(r.accessToken,this.currentUser)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.auth&&this.o&&this.auth.removeAuthTokenListener(this.o),this.o=void 0}u(){const e=this.auth&&this.auth.getUid();return Ae(e===null||typeof e=="string"),new Ot(e)}}class iP{constructor(e,n,r){this.l=e,this.h=n,this.P=r,this.type="FirstParty",this.user=Ot.FIRST_PARTY,this.I=new Map}T(){return this.P?this.P():null}get headers(){this.I.set("X-Goog-AuthUser",this.l);const e=this.T();return e&&this.I.set("Authorization",e),this.h&&this.I.set("X-Goog-Iam-Authorization-Token",this.h),this.I}}class sP{constructor(e,n,r){this.l=e,this.h=n,this.P=r}getToken(){return Promise.resolve(new iP(this.l,this.h,this.P))}start(e,n){e.enqueueRetryable(()=>n(Ot.FIRST_PARTY))}shutdown(){}invalidateToken(){}}class oP{constructor(e){this.value=e,this.type="AppCheck",this.headers=new Map,e&&e.length>0&&this.headers.set("x-firebase-appcheck",this.value)}}class aP{constructor(e){this.A=e,this.forceRefresh=!1,this.appCheck=null,this.R=null}start(e,n){Ae(this.o===void 0);const r=s=>{s.error!=null&&J("FirebaseAppCheckTokenProvider",`Error getting App Check token; using placeholder token instead. Error: ${s.error.message}`);const o=s.token!==this.R;return this.R=s.token,J("FirebaseAppCheckTokenProvider",`Received ${o?"new":"existing"} token.`),o?n(s.token):Promise.resolve()};this.o=s=>{e.enqueueRetryable(()=>r(s))};const i=s=>{J("FirebaseAppCheckTokenProvider","AppCheck detected"),this.appCheck=s,this.o&&this.appCheck.addTokenListener(this.o)};this.A.onInit(s=>i(s)),setTimeout(()=>{if(!this.appCheck){const s=this.A.getImmediate({optional:!0});s?i(s):J("FirebaseAppCheckTokenProvider","AppCheck not yet detected")}},0)}getToken(){const e=this.forceRefresh;return this.forceRefresh=!1,this.appCheck?this.appCheck.getToken(e).then(n=>n?(Ae(typeof n.token=="string"),this.R=n.token,new oP(n.token)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.appCheck&&this.o&&this.appCheck.removeTokenListener(this.o),this.o=void 0}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function lP(t){const e=typeof self<"u"&&(self.crypto||self.msCrypto),n=new Uint8Array(t);if(e&&typeof e.getRandomValues=="function")e.getRandomValues(n);else for(let r=0;r<t;r++)n[r]=Math.floor(256*Math.random());return n}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fI{static newId(){const e="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",n=Math.floor(256/e.length)*e.length;let r="";for(;r.length<20;){const i=lP(40);for(let s=0;s<i.length;++s)r.length<20&&i[s]<n&&(r+=e.charAt(i[s]%e.length))}return r}}function Ie(t,e){return t<e?-1:t>e?1:0}function so(t,e,n){return t.length===e.length&&t.every((r,i)=>n(r,e[i]))}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ht{constructor(e,n){if(this.seconds=e,this.nanoseconds=n,n<0)throw new X(V.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(n>=1e9)throw new X(V.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(e<-62135596800)throw new X(V.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e);if(e>=253402300800)throw new X(V.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e)}static now(){return ht.fromMillis(Date.now())}static fromDate(e){return ht.fromMillis(e.getTime())}static fromMillis(e){const n=Math.floor(e/1e3),r=Math.floor(1e6*(e-1e3*n));return new ht(n,r)}toDate(){return new Date(this.toMillis())}toMillis(){return 1e3*this.seconds+this.nanoseconds/1e6}_compareTo(e){return this.seconds===e.seconds?Ie(this.nanoseconds,e.nanoseconds):Ie(this.seconds,e.seconds)}isEqual(e){return e.seconds===this.seconds&&e.nanoseconds===this.nanoseconds}toString(){return"Timestamp(seconds="+this.seconds+", nanoseconds="+this.nanoseconds+")"}toJSON(){return{seconds:this.seconds,nanoseconds:this.nanoseconds}}valueOf(){const e=this.seconds- -62135596800;return String(e).padStart(12,"0")+"."+String(this.nanoseconds).padStart(9,"0")}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ae{constructor(e){this.timestamp=e}static fromTimestamp(e){return new ae(e)}static min(){return new ae(new ht(0,0))}static max(){return new ae(new ht(253402300799,999999999))}compareTo(e){return this.timestamp._compareTo(e.timestamp)}isEqual(e){return this.timestamp.isEqual(e.timestamp)}toMicroseconds(){return 1e6*this.timestamp.seconds+this.timestamp.nanoseconds/1e3}toString(){return"SnapshotVersion("+this.timestamp.toString()+")"}toTimestamp(){return this.timestamp}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class rl{constructor(e,n,r){n===void 0?n=0:n>e.length&&se(),r===void 0?r=e.length-n:r>e.length-n&&se(),this.segments=e,this.offset=n,this.len=r}get length(){return this.len}isEqual(e){return rl.comparator(this,e)===0}child(e){const n=this.segments.slice(this.offset,this.limit());return e instanceof rl?e.forEach(r=>{n.push(r)}):n.push(e),this.construct(n)}limit(){return this.offset+this.length}popFirst(e){return e=e===void 0?1:e,this.construct(this.segments,this.offset+e,this.length-e)}popLast(){return this.construct(this.segments,this.offset,this.length-1)}firstSegment(){return this.segments[this.offset]}lastSegment(){return this.get(this.length-1)}get(e){return this.segments[this.offset+e]}isEmpty(){return this.length===0}isPrefixOf(e){if(e.length<this.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}isImmediateParentOf(e){if(this.length+1!==e.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}forEach(e){for(let n=this.offset,r=this.limit();n<r;n++)e(this.segments[n])}toArray(){return this.segments.slice(this.offset,this.limit())}static comparator(e,n){const r=Math.min(e.length,n.length);for(let i=0;i<r;i++){const s=e.get(i),o=n.get(i);if(s<o)return-1;if(s>o)return 1}return e.length<n.length?-1:e.length>n.length?1:0}}class je extends rl{construct(e,n,r){return new je(e,n,r)}canonicalString(){return this.toArray().join("/")}toString(){return this.canonicalString()}toUriEncodedString(){return this.toArray().map(encodeURIComponent).join("/")}static fromString(...e){const n=[];for(const r of e){if(r.indexOf("//")>=0)throw new X(V.INVALID_ARGUMENT,`Invalid segment (${r}). Paths must not contain // in them.`);n.push(...r.split("/").filter(i=>i.length>0))}return new je(n)}static emptyPath(){return new je([])}}const uP=/^[_a-zA-Z][_a-zA-Z0-9]*$/;class Tt extends rl{construct(e,n,r){return new Tt(e,n,r)}static isValidIdentifier(e){return uP.test(e)}canonicalString(){return this.toArray().map(e=>(e=e.replace(/\\/g,"\\\\").replace(/`/g,"\\`"),Tt.isValidIdentifier(e)||(e="`"+e+"`"),e)).join(".")}toString(){return this.canonicalString()}isKeyField(){return this.length===1&&this.get(0)==="__name__"}static keyField(){return new Tt(["__name__"])}static fromServerFormat(e){const n=[];let r="",i=0;const s=()=>{if(r.length===0)throw new X(V.INVALID_ARGUMENT,`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`);n.push(r),r=""};let o=!1;for(;i<e.length;){const a=e[i];if(a==="\\"){if(i+1===e.length)throw new X(V.INVALID_ARGUMENT,"Path has trailing escape character: "+e);const u=e[i+1];if(u!=="\\"&&u!=="."&&u!=="`")throw new X(V.INVALID_ARGUMENT,"Path has invalid escape sequence: "+e);r+=u,i+=2}else a==="`"?(o=!o,i++):a!=="."||o?(r+=a,i++):(s(),i++)}if(s(),o)throw new X(V.INVALID_ARGUMENT,"Unterminated ` in path: "+e);return new Tt(n)}static emptyPath(){return new Tt([])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class te{constructor(e){this.path=e}static fromPath(e){return new te(je.fromString(e))}static fromName(e){return new te(je.fromString(e).popFirst(5))}static empty(){return new te(je.emptyPath())}get collectionGroup(){return this.path.popLast().lastSegment()}hasCollectionId(e){return this.path.length>=2&&this.path.get(this.path.length-2)===e}getCollectionGroup(){return this.path.get(this.path.length-2)}getCollectionPath(){return this.path.popLast()}isEqual(e){return e!==null&&je.comparator(this.path,e.path)===0}toString(){return this.path.toString()}static comparator(e,n){return je.comparator(e.path,n.path)}static isDocumentKey(e){return e.length%2==0}static fromSegments(e){return new te(new je(e.slice()))}}function cP(t,e){const n=t.toTimestamp().seconds,r=t.toTimestamp().nanoseconds+1,i=ae.fromTimestamp(r===1e9?new ht(n+1,0):new ht(n,r));return new hi(i,te.empty(),e)}function hP(t){return new hi(t.readTime,t.key,-1)}class hi{constructor(e,n,r){this.readTime=e,this.documentKey=n,this.largestBatchId=r}static min(){return new hi(ae.min(),te.empty(),-1)}static max(){return new hi(ae.max(),te.empty(),-1)}}function dP(t,e){let n=t.readTime.compareTo(e.readTime);return n!==0?n:(n=te.comparator(t.documentKey,e.documentKey),n!==0?n:Ie(t.largestBatchId,e.largestBatchId))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const fP="The current tab is not in the required state to perform this operation. It might be necessary to refresh the browser tab.";class pP{constructor(){this.onCommittedListeners=[]}addOnCommittedListener(e){this.onCommittedListeners.push(e)}raiseOnCommittedEvent(){this.onCommittedListeners.forEach(e=>e())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Tl(t){if(t.code!==V.FAILED_PRECONDITION||t.message!==fP)throw t;J("LocalStore","Unexpectedly lost primary lease")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class j{constructor(e){this.nextCallback=null,this.catchCallback=null,this.result=void 0,this.error=void 0,this.isDone=!1,this.callbackAttached=!1,e(n=>{this.isDone=!0,this.result=n,this.nextCallback&&this.nextCallback(n)},n=>{this.isDone=!0,this.error=n,this.catchCallback&&this.catchCallback(n)})}catch(e){return this.next(void 0,e)}next(e,n){return this.callbackAttached&&se(),this.callbackAttached=!0,this.isDone?this.error?this.wrapFailure(n,this.error):this.wrapSuccess(e,this.result):new j((r,i)=>{this.nextCallback=s=>{this.wrapSuccess(e,s).next(r,i)},this.catchCallback=s=>{this.wrapFailure(n,s).next(r,i)}})}toPromise(){return new Promise((e,n)=>{this.next(e,n)})}wrapUserFunction(e){try{const n=e();return n instanceof j?n:j.resolve(n)}catch(n){return j.reject(n)}}wrapSuccess(e,n){return e?this.wrapUserFunction(()=>e(n)):j.resolve(n)}wrapFailure(e,n){return e?this.wrapUserFunction(()=>e(n)):j.reject(n)}static resolve(e){return new j((n,r)=>{n(e)})}static reject(e){return new j((n,r)=>{r(e)})}static waitFor(e){return new j((n,r)=>{let i=0,s=0,o=!1;e.forEach(a=>{++i,a.next(()=>{++s,o&&s===i&&n()},u=>r(u))}),o=!0,s===i&&n()})}static or(e){let n=j.resolve(!1);for(const r of e)n=n.next(i=>i?j.resolve(i):r());return n}static forEach(e,n){const r=[];return e.forEach((i,s)=>{r.push(n.call(this,i,s))}),this.waitFor(r)}static mapArray(e,n){return new j((r,i)=>{const s=e.length,o=new Array(s);let a=0;for(let u=0;u<s;u++){const c=u;n(e[c]).next(h=>{o[c]=h,++a,a===s&&r(o)},h=>i(h))}})}static doWhile(e,n){return new j((r,i)=>{const s=()=>{e()===!0?n().next(()=>{s()},i):r()};s()})}}function mP(t){const e=t.match(/Android ([\d.]+)/i),n=e?e[1].split(".").slice(0,2).join("."):"-1";return Number(n)}function Il(t){return t.name==="IndexedDbTransactionError"}/**
 * @license
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Bm{constructor(e,n){this.previousValue=e,n&&(n.sequenceNumberHandler=r=>this.ie(r),this.se=r=>n.writeSequenceNumber(r))}ie(e){return this.previousValue=Math.max(e,this.previousValue),this.previousValue}next(){const e=++this.previousValue;return this.se&&this.se(e),e}}Bm.oe=-1;function wh(t){return t==null}function Ac(t){return t===0&&1/t==-1/0}function gP(t){return typeof t=="number"&&Number.isInteger(t)&&!Ac(t)&&t<=Number.MAX_SAFE_INTEGER&&t>=Number.MIN_SAFE_INTEGER}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Nv(t){let e=0;for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e++;return e}function wo(t,e){for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e(n,t[n])}function pI(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let ot=class op{constructor(e,n){this.comparator=e,this.root=n||ii.EMPTY}insert(e,n){return new op(this.comparator,this.root.insert(e,n,this.comparator).copy(null,null,ii.BLACK,null,null))}remove(e){return new op(this.comparator,this.root.remove(e,this.comparator).copy(null,null,ii.BLACK,null,null))}get(e){let n=this.root;for(;!n.isEmpty();){const r=this.comparator(e,n.key);if(r===0)return n.value;r<0?n=n.left:r>0&&(n=n.right)}return null}indexOf(e){let n=0,r=this.root;for(;!r.isEmpty();){const i=this.comparator(e,r.key);if(i===0)return n+r.left.size;i<0?r=r.left:(n+=r.left.size+1,r=r.right)}return-1}isEmpty(){return this.root.isEmpty()}get size(){return this.root.size}minKey(){return this.root.minKey()}maxKey(){return this.root.maxKey()}inorderTraversal(e){return this.root.inorderTraversal(e)}forEach(e){this.inorderTraversal((n,r)=>(e(n,r),!1))}toString(){const e=[];return this.inorderTraversal((n,r)=>(e.push(`${n}:${r}`),!1)),`{${e.join(", ")}}`}reverseTraversal(e){return this.root.reverseTraversal(e)}getIterator(){return new vu(this.root,null,this.comparator,!1)}getIteratorFrom(e){return new vu(this.root,e,this.comparator,!1)}getReverseIterator(){return new vu(this.root,null,this.comparator,!0)}getReverseIteratorFrom(e){return new vu(this.root,e,this.comparator,!0)}},vu=class{constructor(e,n,r,i){this.isReverse=i,this.nodeStack=[];let s=1;for(;!e.isEmpty();)if(s=n?r(e.key,n):1,n&&i&&(s*=-1),s<0)e=this.isReverse?e.left:e.right;else{if(s===0){this.nodeStack.push(e);break}this.nodeStack.push(e),e=this.isReverse?e.right:e.left}}getNext(){let e=this.nodeStack.pop();const n={key:e.key,value:e.value};if(this.isReverse)for(e=e.left;!e.isEmpty();)this.nodeStack.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack.push(e),e=e.left;return n}hasNext(){return this.nodeStack.length>0}peek(){if(this.nodeStack.length===0)return null;const e=this.nodeStack[this.nodeStack.length-1];return{key:e.key,value:e.value}}},ii=class nr{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??nr.RED,this.left=i??nr.EMPTY,this.right=s??nr.EMPTY,this.size=this.left.size+1+this.right.size}copy(e,n,r,i,s){return new nr(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min(){return this.left.isEmpty()?this:this.left.min()}minKey(){return this.min().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return i=s<0?i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i.copy(null,n,null,null,null):i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp()}removeMin(){if(this.left.isEmpty())return nr.EMPTY;let e=this;return e.left.isRed()||e.left.left.isRed()||(e=e.moveRedLeft()),e=e.copy(null,null,null,e.left.removeMin(),null),e.fixUp()}remove(e,n){let r,i=this;if(n(e,i.key)<0)i.left.isEmpty()||i.left.isRed()||i.left.left.isRed()||(i=i.moveRedLeft()),i=i.copy(null,null,null,i.left.remove(e,n),null);else{if(i.left.isRed()&&(i=i.rotateRight()),i.right.isEmpty()||i.right.isRed()||i.right.left.isRed()||(i=i.moveRedRight()),n(e,i.key)===0){if(i.right.isEmpty())return nr.EMPTY;r=i.right.min(),i=i.copy(r.key,r.value,null,null,i.right.removeMin())}i=i.copy(null,null,null,null,i.right.remove(e,n))}return i.fixUp()}isRed(){return this.color}fixUp(){let e=this;return e.right.isRed()&&!e.left.isRed()&&(e=e.rotateLeft()),e.left.isRed()&&e.left.left.isRed()&&(e=e.rotateRight()),e.left.isRed()&&e.right.isRed()&&(e=e.colorFlip()),e}moveRedLeft(){let e=this.colorFlip();return e.right.left.isRed()&&(e=e.copy(null,null,null,null,e.right.rotateRight()),e=e.rotateLeft(),e=e.colorFlip()),e}moveRedRight(){let e=this.colorFlip();return e.left.left.isRed()&&(e=e.rotateRight(),e=e.colorFlip()),e}rotateLeft(){const e=this.copy(null,null,nr.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight(){const e=this.copy(null,null,nr.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth(){const e=this.check();return Math.pow(2,e)<=this.size+1}check(){if(this.isRed()&&this.left.isRed()||this.right.isRed())throw se();const e=this.left.check();if(e!==this.right.check())throw se();return e+(this.isRed()?0:1)}};ii.EMPTY=null,ii.RED=!0,ii.BLACK=!1;ii.EMPTY=new class{constructor(){this.size=0}get key(){throw se()}get value(){throw se()}get color(){throw se()}get left(){throw se()}get right(){throw se()}copy(e,n,r,i,s){return this}insert(e,n,r){return new ii(e,n)}remove(e,n){return this}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}isRed(){return!1}checkMaxDepth(){return!0}check(){return 0}};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class St{constructor(e){this.comparator=e,this.data=new ot(this.comparator)}has(e){return this.data.get(e)!==null}first(){return this.data.minKey()}last(){return this.data.maxKey()}get size(){return this.data.size}indexOf(e){return this.data.indexOf(e)}forEach(e){this.data.inorderTraversal((n,r)=>(e(n),!1))}forEachInRange(e,n){const r=this.data.getIteratorFrom(e[0]);for(;r.hasNext();){const i=r.getNext();if(this.comparator(i.key,e[1])>=0)return;n(i.key)}}forEachWhile(e,n){let r;for(r=n!==void 0?this.data.getIteratorFrom(n):this.data.getIterator();r.hasNext();)if(!e(r.getNext().key))return}firstAfterOrEqual(e){const n=this.data.getIteratorFrom(e);return n.hasNext()?n.getNext().key:null}getIterator(){return new Dv(this.data.getIterator())}getIteratorFrom(e){return new Dv(this.data.getIteratorFrom(e))}add(e){return this.copy(this.data.remove(e).insert(e,!0))}delete(e){return this.has(e)?this.copy(this.data.remove(e)):this}isEmpty(){return this.data.isEmpty()}unionWith(e){let n=this;return n.size<e.size&&(n=e,e=this),e.forEach(r=>{n=n.add(r)}),n}isEqual(e){if(!(e instanceof St)||this.size!==e.size)return!1;const n=this.data.getIterator(),r=e.data.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(this.comparator(i,s)!==0)return!1}return!0}toArray(){const e=[];return this.forEach(n=>{e.push(n)}),e}toString(){const e=[];return this.forEach(n=>e.push(n)),"SortedSet("+e.toString()+")"}copy(e){const n=new St(this.comparator);return n.data=e,n}}class Dv{constructor(e){this.iter=e}getNext(){return this.iter.getNext().key}hasNext(){return this.iter.hasNext()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Dn{constructor(e){this.fields=e,e.sort(Tt.comparator)}static empty(){return new Dn([])}unionWith(e){let n=new St(Tt.comparator);for(const r of this.fields)n=n.add(r);for(const r of e)n=n.add(r);return new Dn(n.toArray())}covers(e){for(const n of this.fields)if(n.isPrefixOf(e))return!0;return!1}isEqual(e){return so(this.fields,e.fields,(n,r)=>n.isEqual(r))}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class mI extends Error{constructor(){super(...arguments),this.name="Base64DecodeError"}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ct{constructor(e){this.binaryString=e}static fromBase64String(e){const n=function(i){try{return atob(i)}catch(s){throw typeof DOMException<"u"&&s instanceof DOMException?new mI("Invalid base64 string: "+s):s}}(e);return new Ct(n)}static fromUint8Array(e){const n=function(i){let s="";for(let o=0;o<i.length;++o)s+=String.fromCharCode(i[o]);return s}(e);return new Ct(n)}[Symbol.iterator](){let e=0;return{next:()=>e<this.binaryString.length?{value:this.binaryString.charCodeAt(e++),done:!1}:{value:void 0,done:!0}}}toBase64(){return function(n){return btoa(n)}(this.binaryString)}toUint8Array(){return function(n){const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}(this.binaryString)}approximateByteSize(){return 2*this.binaryString.length}compareTo(e){return Ie(this.binaryString,e.binaryString)}isEqual(e){return this.binaryString===e.binaryString}}Ct.EMPTY_BYTE_STRING=new Ct("");const _P=new RegExp(/^\d{4}-\d\d-\d\dT\d\d:\d\d:\d\d(?:\.(\d+))?Z$/);function di(t){if(Ae(!!t),typeof t=="string"){let e=0;const n=_P.exec(t);if(Ae(!!n),n[1]){let i=n[1];i=(i+"000000000").substr(0,9),e=Number(i)}const r=new Date(t);return{seconds:Math.floor(r.getTime()/1e3),nanos:e}}return{seconds:et(t.seconds),nanos:et(t.nanos)}}function et(t){return typeof t=="number"?t:typeof t=="string"?Number(t):0}function Hi(t){return typeof t=="string"?Ct.fromBase64String(t):Ct.fromUint8Array(t)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $m(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="server_timestamp"}function Wm(t){const e=t.mapValue.fields.__previous_value__;return $m(e)?Wm(e):e}function il(t){const e=di(t.mapValue.fields.__local_write_time__.timestampValue);return new ht(e.seconds,e.nanos)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class yP{constructor(e,n,r,i,s,o,a,u,c){this.databaseId=e,this.appId=n,this.persistenceKey=r,this.host=i,this.ssl=s,this.forceLongPolling=o,this.autoDetectLongPolling=a,this.longPollingOptions=u,this.useFetchStreams=c}}class sl{constructor(e,n){this.projectId=e,this.database=n||"(default)"}static empty(){return new sl("","")}get isDefaultDatabase(){return this.database==="(default)"}isEqual(e){return e instanceof sl&&e.projectId===this.projectId&&e.database===this.database}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const wu={mapValue:{}};function Gi(t){return"nullValue"in t?0:"booleanValue"in t?1:"integerValue"in t||"doubleValue"in t?2:"timestampValue"in t?3:"stringValue"in t?5:"bytesValue"in t?6:"referenceValue"in t?7:"geoPointValue"in t?8:"arrayValue"in t?9:"mapValue"in t?$m(t)?4:wP(t)?9007199254740991:vP(t)?10:11:se()}function Jn(t,e){if(t===e)return!0;const n=Gi(t);if(n!==Gi(e))return!1;switch(n){case 0:case 9007199254740991:return!0;case 1:return t.booleanValue===e.booleanValue;case 4:return il(t).isEqual(il(e));case 3:return function(i,s){if(typeof i.timestampValue=="string"&&typeof s.timestampValue=="string"&&i.timestampValue.length===s.timestampValue.length)return i.timestampValue===s.timestampValue;const o=di(i.timestampValue),a=di(s.timestampValue);return o.seconds===a.seconds&&o.nanos===a.nanos}(t,e);case 5:return t.stringValue===e.stringValue;case 6:return function(i,s){return Hi(i.bytesValue).isEqual(Hi(s.bytesValue))}(t,e);case 7:return t.referenceValue===e.referenceValue;case 8:return function(i,s){return et(i.geoPointValue.latitude)===et(s.geoPointValue.latitude)&&et(i.geoPointValue.longitude)===et(s.geoPointValue.longitude)}(t,e);case 2:return function(i,s){if("integerValue"in i&&"integerValue"in s)return et(i.integerValue)===et(s.integerValue);if("doubleValue"in i&&"doubleValue"in s){const o=et(i.doubleValue),a=et(s.doubleValue);return o===a?Ac(o)===Ac(a):isNaN(o)&&isNaN(a)}return!1}(t,e);case 9:return so(t.arrayValue.values||[],e.arrayValue.values||[],Jn);case 10:case 11:return function(i,s){const o=i.mapValue.fields||{},a=s.mapValue.fields||{};if(Nv(o)!==Nv(a))return!1;for(const u in o)if(o.hasOwnProperty(u)&&(a[u]===void 0||!Jn(o[u],a[u])))return!1;return!0}(t,e);default:return se()}}function ol(t,e){return(t.values||[]).find(n=>Jn(n,e))!==void 0}function oo(t,e){if(t===e)return 0;const n=Gi(t),r=Gi(e);if(n!==r)return Ie(n,r);switch(n){case 0:case 9007199254740991:return 0;case 1:return Ie(t.booleanValue,e.booleanValue);case 2:return function(s,o){const a=et(s.integerValue||s.doubleValue),u=et(o.integerValue||o.doubleValue);return a<u?-1:a>u?1:a===u?0:isNaN(a)?isNaN(u)?0:-1:1}(t,e);case 3:return Ov(t.timestampValue,e.timestampValue);case 4:return Ov(il(t),il(e));case 5:return Ie(t.stringValue,e.stringValue);case 6:return function(s,o){const a=Hi(s),u=Hi(o);return a.compareTo(u)}(t.bytesValue,e.bytesValue);case 7:return function(s,o){const a=s.split("/"),u=o.split("/");for(let c=0;c<a.length&&c<u.length;c++){const h=Ie(a[c],u[c]);if(h!==0)return h}return Ie(a.length,u.length)}(t.referenceValue,e.referenceValue);case 8:return function(s,o){const a=Ie(et(s.latitude),et(o.latitude));return a!==0?a:Ie(et(s.longitude),et(o.longitude))}(t.geoPointValue,e.geoPointValue);case 9:return Mv(t.arrayValue,e.arrayValue);case 10:return function(s,o){var a,u,c,h;const f=s.fields||{},g=o.fields||{},v=(a=f.value)===null||a===void 0?void 0:a.arrayValue,I=(u=g.value)===null||u===void 0?void 0:u.arrayValue,N=Ie(((c=v==null?void 0:v.values)===null||c===void 0?void 0:c.length)||0,((h=I==null?void 0:I.values)===null||h===void 0?void 0:h.length)||0);return N!==0?N:Mv(v,I)}(t.mapValue,e.mapValue);case 11:return function(s,o){if(s===wu.mapValue&&o===wu.mapValue)return 0;if(s===wu.mapValue)return 1;if(o===wu.mapValue)return-1;const a=s.fields||{},u=Object.keys(a),c=o.fields||{},h=Object.keys(c);u.sort(),h.sort();for(let f=0;f<u.length&&f<h.length;++f){const g=Ie(u[f],h[f]);if(g!==0)return g;const v=oo(a[u[f]],c[h[f]]);if(v!==0)return v}return Ie(u.length,h.length)}(t.mapValue,e.mapValue);default:throw se()}}function Ov(t,e){if(typeof t=="string"&&typeof e=="string"&&t.length===e.length)return Ie(t,e);const n=di(t),r=di(e),i=Ie(n.seconds,r.seconds);return i!==0?i:Ie(n.nanos,r.nanos)}function Mv(t,e){const n=t.values||[],r=e.values||[];for(let i=0;i<n.length&&i<r.length;++i){const s=oo(n[i],r[i]);if(s)return s}return Ie(n.length,r.length)}function ao(t){return ap(t)}function ap(t){return"nullValue"in t?"null":"booleanValue"in t?""+t.booleanValue:"integerValue"in t?""+t.integerValue:"doubleValue"in t?""+t.doubleValue:"timestampValue"in t?function(n){const r=di(n);return`time(${r.seconds},${r.nanos})`}(t.timestampValue):"stringValue"in t?t.stringValue:"bytesValue"in t?function(n){return Hi(n).toBase64()}(t.bytesValue):"referenceValue"in t?function(n){return te.fromName(n).toString()}(t.referenceValue):"geoPointValue"in t?function(n){return`geo(${n.latitude},${n.longitude})`}(t.geoPointValue):"arrayValue"in t?function(n){let r="[",i=!0;for(const s of n.values||[])i?i=!1:r+=",",r+=ap(s);return r+"]"}(t.arrayValue):"mapValue"in t?function(n){const r=Object.keys(n.fields||{}).sort();let i="{",s=!0;for(const o of r)s?s=!1:i+=",",i+=`${o}:${ap(n.fields[o])}`;return i+"}"}(t.mapValue):se()}function Lv(t,e){return{referenceValue:`projects/${t.projectId}/databases/${t.database}/documents/${e.path.canonicalString()}`}}function lp(t){return!!t&&"integerValue"in t}function qm(t){return!!t&&"arrayValue"in t}function Fv(t){return!!t&&"nullValue"in t}function Vv(t){return!!t&&"doubleValue"in t&&isNaN(Number(t.doubleValue))}function Wu(t){return!!t&&"mapValue"in t}function vP(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="__vector__"}function Sa(t){if(t.geoPointValue)return{geoPointValue:Object.assign({},t.geoPointValue)};if(t.timestampValue&&typeof t.timestampValue=="object")return{timestampValue:Object.assign({},t.timestampValue)};if(t.mapValue){const e={mapValue:{fields:{}}};return wo(t.mapValue.fields,(n,r)=>e.mapValue.fields[n]=Sa(r)),e}if(t.arrayValue){const e={arrayValue:{values:[]}};for(let n=0;n<(t.arrayValue.values||[]).length;++n)e.arrayValue.values[n]=Sa(t.arrayValue.values[n]);return e}return Object.assign({},t)}function wP(t){return(((t.mapValue||{}).fields||{}).__type__||{}).stringValue==="__max__"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class gn{constructor(e){this.value=e}static empty(){return new gn({mapValue:{}})}field(e){if(e.isEmpty())return this.value;{let n=this.value;for(let r=0;r<e.length-1;++r)if(n=(n.mapValue.fields||{})[e.get(r)],!Wu(n))return null;return n=(n.mapValue.fields||{})[e.lastSegment()],n||null}}set(e,n){this.getFieldsMap(e.popLast())[e.lastSegment()]=Sa(n)}setAll(e){let n=Tt.emptyPath(),r={},i=[];e.forEach((o,a)=>{if(!n.isImmediateParentOf(a)){const u=this.getFieldsMap(n);this.applyChanges(u,r,i),r={},i=[],n=a.popLast()}o?r[a.lastSegment()]=Sa(o):i.push(a.lastSegment())});const s=this.getFieldsMap(n);this.applyChanges(s,r,i)}delete(e){const n=this.field(e.popLast());Wu(n)&&n.mapValue.fields&&delete n.mapValue.fields[e.lastSegment()]}isEqual(e){return Jn(this.value,e.value)}getFieldsMap(e){let n=this.value;n.mapValue.fields||(n.mapValue={fields:{}});for(let r=0;r<e.length;++r){let i=n.mapValue.fields[e.get(r)];Wu(i)&&i.mapValue.fields||(i={mapValue:{fields:{}}},n.mapValue.fields[e.get(r)]=i),n=i}return n.mapValue.fields}applyChanges(e,n,r){wo(n,(i,s)=>e[i]=s);for(const i of r)delete e[i]}clone(){return new gn(Sa(this.value))}}function gI(t){const e=[];return wo(t.fields,(n,r)=>{const i=new Tt([n]);if(Wu(r)){const s=gI(r.mapValue).fields;if(s.length===0)e.push(i);else for(const o of s)e.push(i.child(o))}else e.push(i)}),new Dn(e)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Lt{constructor(e,n,r,i,s,o,a){this.key=e,this.documentType=n,this.version=r,this.readTime=i,this.createTime=s,this.data=o,this.documentState=a}static newInvalidDocument(e){return new Lt(e,0,ae.min(),ae.min(),ae.min(),gn.empty(),0)}static newFoundDocument(e,n,r,i){return new Lt(e,1,n,ae.min(),r,i,0)}static newNoDocument(e,n){return new Lt(e,2,n,ae.min(),ae.min(),gn.empty(),0)}static newUnknownDocument(e,n){return new Lt(e,3,n,ae.min(),ae.min(),gn.empty(),2)}convertToFoundDocument(e,n){return!this.createTime.isEqual(ae.min())||this.documentType!==2&&this.documentType!==0||(this.createTime=e),this.version=e,this.documentType=1,this.data=n,this.documentState=0,this}convertToNoDocument(e){return this.version=e,this.documentType=2,this.data=gn.empty(),this.documentState=0,this}convertToUnknownDocument(e){return this.version=e,this.documentType=3,this.data=gn.empty(),this.documentState=2,this}setHasCommittedMutations(){return this.documentState=2,this}setHasLocalMutations(){return this.documentState=1,this.version=ae.min(),this}setReadTime(e){return this.readTime=e,this}get hasLocalMutations(){return this.documentState===1}get hasCommittedMutations(){return this.documentState===2}get hasPendingWrites(){return this.hasLocalMutations||this.hasCommittedMutations}isValidDocument(){return this.documentType!==0}isFoundDocument(){return this.documentType===1}isNoDocument(){return this.documentType===2}isUnknownDocument(){return this.documentType===3}isEqual(e){return e instanceof Lt&&this.key.isEqual(e.key)&&this.version.isEqual(e.version)&&this.documentType===e.documentType&&this.documentState===e.documentState&&this.data.isEqual(e.data)}mutableCopy(){return new Lt(this.key,this.documentType,this.version,this.readTime,this.createTime,this.data.clone(),this.documentState)}toString(){return`Document(${this.key}, ${this.version}, ${JSON.stringify(this.data.value)}, {createTime: ${this.createTime}}), {documentType: ${this.documentType}}), {documentState: ${this.documentState}})`}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class bc{constructor(e,n){this.position=e,this.inclusive=n}}function Uv(t,e,n){let r=0;for(let i=0;i<t.position.length;i++){const s=e[i],o=t.position[i];if(s.field.isKeyField()?r=te.comparator(te.fromName(o.referenceValue),n.key):r=oo(o,n.data.field(s.field)),s.dir==="desc"&&(r*=-1),r!==0)break}return r}function jv(t,e){if(t===null)return e===null;if(e===null||t.inclusive!==e.inclusive||t.position.length!==e.position.length)return!1;for(let n=0;n<t.position.length;n++)if(!Jn(t.position[n],e.position[n]))return!1;return!0}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class al{constructor(e,n="asc"){this.field=e,this.dir=n}}function EP(t,e){return t.dir===e.dir&&t.field.isEqual(e.field)}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class _I{}class st extends _I{constructor(e,n,r){super(),this.field=e,this.op=n,this.value=r}static create(e,n,r){return e.isKeyField()?n==="in"||n==="not-in"?this.createKeyFieldInFilter(e,n,r):new IP(e,n,r):n==="array-contains"?new CP(e,r):n==="in"?new RP(e,r):n==="not-in"?new xP(e,r):n==="array-contains-any"?new AP(e,r):new st(e,n,r)}static createKeyFieldInFilter(e,n,r){return n==="in"?new SP(e,r):new kP(e,r)}matches(e){const n=e.data.field(this.field);return this.op==="!="?n!==null&&this.matchesComparison(oo(n,this.value)):n!==null&&Gi(this.value)===Gi(n)&&this.matchesComparison(oo(n,this.value))}matchesComparison(e){switch(this.op){case"<":return e<0;case"<=":return e<=0;case"==":return e===0;case"!=":return e!==0;case">":return e>0;case">=":return e>=0;default:return se()}}isInequality(){return["<","<=",">",">=","!=","not-in"].indexOf(this.op)>=0}getFlattenedFilters(){return[this]}getFilters(){return[this]}}class Un extends _I{constructor(e,n){super(),this.filters=e,this.op=n,this.ae=null}static create(e,n){return new Un(e,n)}matches(e){return yI(this)?this.filters.find(n=>!n.matches(e))===void 0:this.filters.find(n=>n.matches(e))!==void 0}getFlattenedFilters(){return this.ae!==null||(this.ae=this.filters.reduce((e,n)=>e.concat(n.getFlattenedFilters()),[])),this.ae}getFilters(){return Object.assign([],this.filters)}}function yI(t){return t.op==="and"}function vI(t){return TP(t)&&yI(t)}function TP(t){for(const e of t.filters)if(e instanceof Un)return!1;return!0}function up(t){if(t instanceof st)return t.field.canonicalString()+t.op.toString()+ao(t.value);if(vI(t))return t.filters.map(e=>up(e)).join(",");{const e=t.filters.map(n=>up(n)).join(",");return`${t.op}(${e})`}}function wI(t,e){return t instanceof st?function(r,i){return i instanceof st&&r.op===i.op&&r.field.isEqual(i.field)&&Jn(r.value,i.value)}(t,e):t instanceof Un?function(r,i){return i instanceof Un&&r.op===i.op&&r.filters.length===i.filters.length?r.filters.reduce((s,o,a)=>s&&wI(o,i.filters[a]),!0):!1}(t,e):void se()}function EI(t){return t instanceof st?function(n){return`${n.field.canonicalString()} ${n.op} ${ao(n.value)}`}(t):t instanceof Un?function(n){return n.op.toString()+" {"+n.getFilters().map(EI).join(" ,")+"}"}(t):"Filter"}class IP extends st{constructor(e,n,r){super(e,n,r),this.key=te.fromName(r.referenceValue)}matches(e){const n=te.comparator(e.key,this.key);return this.matchesComparison(n)}}class SP extends st{constructor(e,n){super(e,"in",n),this.keys=TI("in",n)}matches(e){return this.keys.some(n=>n.isEqual(e.key))}}class kP extends st{constructor(e,n){super(e,"not-in",n),this.keys=TI("not-in",n)}matches(e){return!this.keys.some(n=>n.isEqual(e.key))}}function TI(t,e){var n;return(((n=e.arrayValue)===null||n===void 0?void 0:n.values)||[]).map(r=>te.fromName(r.referenceValue))}class CP extends st{constructor(e,n){super(e,"array-contains",n)}matches(e){const n=e.data.field(this.field);return qm(n)&&ol(n.arrayValue,this.value)}}class RP extends st{constructor(e,n){super(e,"in",n)}matches(e){const n=e.data.field(this.field);return n!==null&&ol(this.value.arrayValue,n)}}class xP extends st{constructor(e,n){super(e,"not-in",n)}matches(e){if(ol(this.value.arrayValue,{nullValue:"NULL_VALUE"}))return!1;const n=e.data.field(this.field);return n!==null&&!ol(this.value.arrayValue,n)}}class AP extends st{constructor(e,n){super(e,"array-contains-any",n)}matches(e){const n=e.data.field(this.field);return!(!qm(n)||!n.arrayValue.values)&&n.arrayValue.values.some(r=>ol(this.value.arrayValue,r))}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class bP{constructor(e,n=null,r=[],i=[],s=null,o=null,a=null){this.path=e,this.collectionGroup=n,this.orderBy=r,this.filters=i,this.limit=s,this.startAt=o,this.endAt=a,this.ue=null}}function zv(t,e=null,n=[],r=[],i=null,s=null,o=null){return new bP(t,e,n,r,i,s,o)}function Hm(t){const e=le(t);if(e.ue===null){let n=e.path.canonicalString();e.collectionGroup!==null&&(n+="|cg:"+e.collectionGroup),n+="|f:",n+=e.filters.map(r=>up(r)).join(","),n+="|ob:",n+=e.orderBy.map(r=>function(s){return s.field.canonicalString()+s.dir}(r)).join(","),wh(e.limit)||(n+="|l:",n+=e.limit),e.startAt&&(n+="|lb:",n+=e.startAt.inclusive?"b:":"a:",n+=e.startAt.position.map(r=>ao(r)).join(",")),e.endAt&&(n+="|ub:",n+=e.endAt.inclusive?"a:":"b:",n+=e.endAt.position.map(r=>ao(r)).join(",")),e.ue=n}return e.ue}function Gm(t,e){if(t.limit!==e.limit||t.orderBy.length!==e.orderBy.length)return!1;for(let n=0;n<t.orderBy.length;n++)if(!EP(t.orderBy[n],e.orderBy[n]))return!1;if(t.filters.length!==e.filters.length)return!1;for(let n=0;n<t.filters.length;n++)if(!wI(t.filters[n],e.filters[n]))return!1;return t.collectionGroup===e.collectionGroup&&!!t.path.isEqual(e.path)&&!!jv(t.startAt,e.startAt)&&jv(t.endAt,e.endAt)}function cp(t){return te.isDocumentKey(t.path)&&t.collectionGroup===null&&t.filters.length===0}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Eo{constructor(e,n=null,r=[],i=[],s=null,o="F",a=null,u=null){this.path=e,this.collectionGroup=n,this.explicitOrderBy=r,this.filters=i,this.limit=s,this.limitType=o,this.startAt=a,this.endAt=u,this.ce=null,this.le=null,this.he=null,this.startAt,this.endAt}}function PP(t,e,n,r,i,s,o,a){return new Eo(t,e,n,r,i,s,o,a)}function II(t){return new Eo(t)}function Bv(t){return t.filters.length===0&&t.limit===null&&t.startAt==null&&t.endAt==null&&(t.explicitOrderBy.length===0||t.explicitOrderBy.length===1&&t.explicitOrderBy[0].field.isKeyField())}function SI(t){return t.collectionGroup!==null}function ka(t){const e=le(t);if(e.ce===null){e.ce=[];const n=new Set;for(const s of e.explicitOrderBy)e.ce.push(s),n.add(s.field.canonicalString());const r=e.explicitOrderBy.length>0?e.explicitOrderBy[e.explicitOrderBy.length-1].dir:"asc";(function(o){let a=new St(Tt.comparator);return o.filters.forEach(u=>{u.getFlattenedFilters().forEach(c=>{c.isInequality()&&(a=a.add(c.field))})}),a})(e).forEach(s=>{n.has(s.canonicalString())||s.isKeyField()||e.ce.push(new al(s,r))}),n.has(Tt.keyField().canonicalString())||e.ce.push(new al(Tt.keyField(),r))}return e.ce}function Gn(t){const e=le(t);return e.le||(e.le=NP(e,ka(t))),e.le}function NP(t,e){if(t.limitType==="F")return zv(t.path,t.collectionGroup,e,t.filters,t.limit,t.startAt,t.endAt);{e=e.map(i=>{const s=i.dir==="desc"?"asc":"desc";return new al(i.field,s)});const n=t.endAt?new bc(t.endAt.position,t.endAt.inclusive):null,r=t.startAt?new bc(t.startAt.position,t.startAt.inclusive):null;return zv(t.path,t.collectionGroup,e,t.filters,t.limit,n,r)}}function hp(t,e){const n=t.filters.concat([e]);return new Eo(t.path,t.collectionGroup,t.explicitOrderBy.slice(),n,t.limit,t.limitType,t.startAt,t.endAt)}function dp(t,e,n){return new Eo(t.path,t.collectionGroup,t.explicitOrderBy.slice(),t.filters.slice(),e,n,t.startAt,t.endAt)}function Eh(t,e){return Gm(Gn(t),Gn(e))&&t.limitType===e.limitType}function kI(t){return`${Hm(Gn(t))}|lt:${t.limitType}`}function ys(t){return`Query(target=${function(n){let r=n.path.canonicalString();return n.collectionGroup!==null&&(r+=" collectionGroup="+n.collectionGroup),n.filters.length>0&&(r+=`, filters: [${n.filters.map(i=>EI(i)).join(", ")}]`),wh(n.limit)||(r+=", limit: "+n.limit),n.orderBy.length>0&&(r+=`, orderBy: [${n.orderBy.map(i=>function(o){return`${o.field.canonicalString()} (${o.dir})`}(i)).join(", ")}]`),n.startAt&&(r+=", startAt: ",r+=n.startAt.inclusive?"b:":"a:",r+=n.startAt.position.map(i=>ao(i)).join(",")),n.endAt&&(r+=", endAt: ",r+=n.endAt.inclusive?"a:":"b:",r+=n.endAt.position.map(i=>ao(i)).join(",")),`Target(${r})`}(Gn(t))}; limitType=${t.limitType})`}function Th(t,e){return e.isFoundDocument()&&function(r,i){const s=i.key.path;return r.collectionGroup!==null?i.key.hasCollectionId(r.collectionGroup)&&r.path.isPrefixOf(s):te.isDocumentKey(r.path)?r.path.isEqual(s):r.path.isImmediateParentOf(s)}(t,e)&&function(r,i){for(const s of ka(r))if(!s.field.isKeyField()&&i.data.field(s.field)===null)return!1;return!0}(t,e)&&function(r,i){for(const s of r.filters)if(!s.matches(i))return!1;return!0}(t,e)&&function(r,i){return!(r.startAt&&!function(o,a,u){const c=Uv(o,a,u);return o.inclusive?c<=0:c<0}(r.startAt,ka(r),i)||r.endAt&&!function(o,a,u){const c=Uv(o,a,u);return o.inclusive?c>=0:c>0}(r.endAt,ka(r),i))}(t,e)}function DP(t){return t.collectionGroup||(t.path.length%2==1?t.path.lastSegment():t.path.get(t.path.length-2))}function CI(t){return(e,n)=>{let r=!1;for(const i of ka(t)){const s=OP(i,e,n);if(s!==0)return s;r=r||i.field.isKeyField()}return 0}}function OP(t,e,n){const r=t.field.isKeyField()?te.comparator(e.key,n.key):function(s,o,a){const u=o.data.field(s),c=a.data.field(s);return u!==null&&c!==null?oo(u,c):se()}(t.field,e,n);switch(t.dir){case"asc":return r;case"desc":return-1*r;default:return se()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class To{constructor(e,n){this.mapKeyFn=e,this.equalsFn=n,this.inner={},this.innerSize=0}get(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r!==void 0){for(const[i,s]of r)if(this.equalsFn(i,e))return s}}has(e){return this.get(e)!==void 0}set(e,n){const r=this.mapKeyFn(e),i=this.inner[r];if(i===void 0)return this.inner[r]=[[e,n]],void this.innerSize++;for(let s=0;s<i.length;s++)if(this.equalsFn(i[s][0],e))return void(i[s]=[e,n]);i.push([e,n]),this.innerSize++}delete(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r===void 0)return!1;for(let i=0;i<r.length;i++)if(this.equalsFn(r[i][0],e))return r.length===1?delete this.inner[n]:r.splice(i,1),this.innerSize--,!0;return!1}forEach(e){wo(this.inner,(n,r)=>{for(const[i,s]of r)e(i,s)})}isEmpty(){return pI(this.inner)}size(){return this.innerSize}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const MP=new ot(te.comparator);function Tr(){return MP}const RI=new ot(te.comparator);function fa(...t){let e=RI;for(const n of t)e=e.insert(n.key,n);return e}function xI(t){let e=RI;return t.forEach((n,r)=>e=e.insert(n,r.overlayedDocument)),e}function Di(){return Ca()}function AI(){return Ca()}function Ca(){return new To(t=>t.toString(),(t,e)=>t.isEqual(e))}const LP=new ot(te.comparator),FP=new St(te.comparator);function fe(...t){let e=FP;for(const n of t)e=e.add(n);return e}const VP=new St(Ie);function UP(){return VP}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Km(t,e){if(t.useProto3Json){if(isNaN(e))return{doubleValue:"NaN"};if(e===1/0)return{doubleValue:"Infinity"};if(e===-1/0)return{doubleValue:"-Infinity"}}return{doubleValue:Ac(e)?"-0":e}}function bI(t){return{integerValue:""+t}}function jP(t,e){return gP(e)?bI(e):Km(t,e)}/**
 * @license
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ih{constructor(){this._=void 0}}function zP(t,e,n){return t instanceof ll?function(i,s){const o={fields:{__type__:{stringValue:"server_timestamp"},__local_write_time__:{timestampValue:{seconds:i.seconds,nanos:i.nanoseconds}}}};return s&&$m(s)&&(s=Wm(s)),s&&(o.fields.__previous_value__=s),{mapValue:o}}(n,e):t instanceof ul?NI(t,e):t instanceof cl?DI(t,e):function(i,s){const o=PI(i,s),a=$v(o)+$v(i.Pe);return lp(o)&&lp(i.Pe)?bI(a):Km(i.serializer,a)}(t,e)}function BP(t,e,n){return t instanceof ul?NI(t,e):t instanceof cl?DI(t,e):n}function PI(t,e){return t instanceof Pc?function(r){return lp(r)||function(s){return!!s&&"doubleValue"in s}(r)}(e)?e:{integerValue:0}:null}class ll extends Ih{}class ul extends Ih{constructor(e){super(),this.elements=e}}function NI(t,e){const n=OI(e);for(const r of t.elements)n.some(i=>Jn(i,r))||n.push(r);return{arrayValue:{values:n}}}class cl extends Ih{constructor(e){super(),this.elements=e}}function DI(t,e){let n=OI(e);for(const r of t.elements)n=n.filter(i=>!Jn(i,r));return{arrayValue:{values:n}}}class Pc extends Ih{constructor(e,n){super(),this.serializer=e,this.Pe=n}}function $v(t){return et(t.integerValue||t.doubleValue)}function OI(t){return qm(t)&&t.arrayValue.values?t.arrayValue.values.slice():[]}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $P{constructor(e,n){this.field=e,this.transform=n}}function WP(t,e){return t.field.isEqual(e.field)&&function(r,i){return r instanceof ul&&i instanceof ul||r instanceof cl&&i instanceof cl?so(r.elements,i.elements,Jn):r instanceof Pc&&i instanceof Pc?Jn(r.Pe,i.Pe):r instanceof ll&&i instanceof ll}(t.transform,e.transform)}class qP{constructor(e,n){this.version=e,this.transformResults=n}}class Kn{constructor(e,n){this.updateTime=e,this.exists=n}static none(){return new Kn}static exists(e){return new Kn(void 0,e)}static updateTime(e){return new Kn(e)}get isNone(){return this.updateTime===void 0&&this.exists===void 0}isEqual(e){return this.exists===e.exists&&(this.updateTime?!!e.updateTime&&this.updateTime.isEqual(e.updateTime):!e.updateTime)}}function qu(t,e){return t.updateTime!==void 0?e.isFoundDocument()&&e.version.isEqual(t.updateTime):t.exists===void 0||t.exists===e.isFoundDocument()}class Sh{}function MI(t,e){if(!t.hasLocalMutations||e&&e.fields.length===0)return null;if(e===null)return t.isNoDocument()?new Qm(t.key,Kn.none()):new Sl(t.key,t.data,Kn.none());{const n=t.data,r=gn.empty();let i=new St(Tt.comparator);for(let s of e.fields)if(!i.has(s)){let o=n.field(s);o===null&&s.length>1&&(s=s.popLast(),o=n.field(s)),o===null?r.delete(s):r.set(s,o),i=i.add(s)}return new ns(t.key,r,new Dn(i.toArray()),Kn.none())}}function HP(t,e,n){t instanceof Sl?function(i,s,o){const a=i.value.clone(),u=qv(i.fieldTransforms,s,o.transformResults);a.setAll(u),s.convertToFoundDocument(o.version,a).setHasCommittedMutations()}(t,e,n):t instanceof ns?function(i,s,o){if(!qu(i.precondition,s))return void s.convertToUnknownDocument(o.version);const a=qv(i.fieldTransforms,s,o.transformResults),u=s.data;u.setAll(LI(i)),u.setAll(a),s.convertToFoundDocument(o.version,u).setHasCommittedMutations()}(t,e,n):function(i,s,o){s.convertToNoDocument(o.version).setHasCommittedMutations()}(0,e,n)}function Ra(t,e,n,r){return t instanceof Sl?function(s,o,a,u){if(!qu(s.precondition,o))return a;const c=s.value.clone(),h=Hv(s.fieldTransforms,u,o);return c.setAll(h),o.convertToFoundDocument(o.version,c).setHasLocalMutations(),null}(t,e,n,r):t instanceof ns?function(s,o,a,u){if(!qu(s.precondition,o))return a;const c=Hv(s.fieldTransforms,u,o),h=o.data;return h.setAll(LI(s)),h.setAll(c),o.convertToFoundDocument(o.version,h).setHasLocalMutations(),a===null?null:a.unionWith(s.fieldMask.fields).unionWith(s.fieldTransforms.map(f=>f.field))}(t,e,n,r):function(s,o,a){return qu(s.precondition,o)?(o.convertToNoDocument(o.version).setHasLocalMutations(),null):a}(t,e,n)}function GP(t,e){let n=null;for(const r of t.fieldTransforms){const i=e.data.field(r.field),s=PI(r.transform,i||null);s!=null&&(n===null&&(n=gn.empty()),n.set(r.field,s))}return n||null}function Wv(t,e){return t.type===e.type&&!!t.key.isEqual(e.key)&&!!t.precondition.isEqual(e.precondition)&&!!function(r,i){return r===void 0&&i===void 0||!(!r||!i)&&so(r,i,(s,o)=>WP(s,o))}(t.fieldTransforms,e.fieldTransforms)&&(t.type===0?t.value.isEqual(e.value):t.type!==1||t.data.isEqual(e.data)&&t.fieldMask.isEqual(e.fieldMask))}class Sl extends Sh{constructor(e,n,r,i=[]){super(),this.key=e,this.value=n,this.precondition=r,this.fieldTransforms=i,this.type=0}getFieldMask(){return null}}class ns extends Sh{constructor(e,n,r,i,s=[]){super(),this.key=e,this.data=n,this.fieldMask=r,this.precondition=i,this.fieldTransforms=s,this.type=1}getFieldMask(){return this.fieldMask}}function LI(t){const e=new Map;return t.fieldMask.fields.forEach(n=>{if(!n.isEmpty()){const r=t.data.field(n);e.set(n,r)}}),e}function qv(t,e,n){const r=new Map;Ae(t.length===n.length);for(let i=0;i<n.length;i++){const s=t[i],o=s.transform,a=e.data.field(s.field);r.set(s.field,BP(o,a,n[i]))}return r}function Hv(t,e,n){const r=new Map;for(const i of t){const s=i.transform,o=n.data.field(i.field);r.set(i.field,zP(s,o,e))}return r}class Qm extends Sh{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=2,this.fieldTransforms=[]}getFieldMask(){return null}}class KP extends Sh{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=3,this.fieldTransforms=[]}getFieldMask(){return null}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class QP{constructor(e,n,r,i){this.batchId=e,this.localWriteTime=n,this.baseMutations=r,this.mutations=i}applyToRemoteDocument(e,n){const r=n.mutationResults;for(let i=0;i<this.mutations.length;i++){const s=this.mutations[i];s.key.isEqual(e.key)&&HP(s,e,r[i])}}applyToLocalView(e,n){for(const r of this.baseMutations)r.key.isEqual(e.key)&&(n=Ra(r,e,n,this.localWriteTime));for(const r of this.mutations)r.key.isEqual(e.key)&&(n=Ra(r,e,n,this.localWriteTime));return n}applyToLocalDocumentSet(e,n){const r=AI();return this.mutations.forEach(i=>{const s=e.get(i.key),o=s.overlayedDocument;let a=this.applyToLocalView(o,s.mutatedFields);a=n.has(i.key)?null:a;const u=MI(o,a);u!==null&&r.set(i.key,u),o.isValidDocument()||o.convertToNoDocument(ae.min())}),r}keys(){return this.mutations.reduce((e,n)=>e.add(n.key),fe())}isEqual(e){return this.batchId===e.batchId&&so(this.mutations,e.mutations,(n,r)=>Wv(n,r))&&so(this.baseMutations,e.baseMutations,(n,r)=>Wv(n,r))}}class Ym{constructor(e,n,r,i){this.batch=e,this.commitVersion=n,this.mutationResults=r,this.docVersions=i}static from(e,n,r){Ae(e.mutations.length===r.length);let i=function(){return LP}();const s=e.mutations;for(let o=0;o<s.length;o++)i=i.insert(s[o].key,r[o].version);return new Ym(e,n,r,i)}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class YP{constructor(e,n){this.largestBatchId=e,this.mutation=n}getKey(){return this.mutation.key}isEqual(e){return e!==null&&this.mutation===e.mutation}toString(){return`Overlay{
      largestBatchId: ${this.largestBatchId},
      mutation: ${this.mutation.toString()}
    }`}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class XP{constructor(e,n){this.count=e,this.unchangedNames=n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var rt,_e;function JP(t){switch(t){default:return se();case V.CANCELLED:case V.UNKNOWN:case V.DEADLINE_EXCEEDED:case V.RESOURCE_EXHAUSTED:case V.INTERNAL:case V.UNAVAILABLE:case V.UNAUTHENTICATED:return!1;case V.INVALID_ARGUMENT:case V.NOT_FOUND:case V.ALREADY_EXISTS:case V.PERMISSION_DENIED:case V.FAILED_PRECONDITION:case V.ABORTED:case V.OUT_OF_RANGE:case V.UNIMPLEMENTED:case V.DATA_LOSS:return!0}}function FI(t){if(t===void 0)return Er("GRPC error has no .code"),V.UNKNOWN;switch(t){case rt.OK:return V.OK;case rt.CANCELLED:return V.CANCELLED;case rt.UNKNOWN:return V.UNKNOWN;case rt.DEADLINE_EXCEEDED:return V.DEADLINE_EXCEEDED;case rt.RESOURCE_EXHAUSTED:return V.RESOURCE_EXHAUSTED;case rt.INTERNAL:return V.INTERNAL;case rt.UNAVAILABLE:return V.UNAVAILABLE;case rt.UNAUTHENTICATED:return V.UNAUTHENTICATED;case rt.INVALID_ARGUMENT:return V.INVALID_ARGUMENT;case rt.NOT_FOUND:return V.NOT_FOUND;case rt.ALREADY_EXISTS:return V.ALREADY_EXISTS;case rt.PERMISSION_DENIED:return V.PERMISSION_DENIED;case rt.FAILED_PRECONDITION:return V.FAILED_PRECONDITION;case rt.ABORTED:return V.ABORTED;case rt.OUT_OF_RANGE:return V.OUT_OF_RANGE;case rt.UNIMPLEMENTED:return V.UNIMPLEMENTED;case rt.DATA_LOSS:return V.DATA_LOSS;default:return se()}}(_e=rt||(rt={}))[_e.OK=0]="OK",_e[_e.CANCELLED=1]="CANCELLED",_e[_e.UNKNOWN=2]="UNKNOWN",_e[_e.INVALID_ARGUMENT=3]="INVALID_ARGUMENT",_e[_e.DEADLINE_EXCEEDED=4]="DEADLINE_EXCEEDED",_e[_e.NOT_FOUND=5]="NOT_FOUND",_e[_e.ALREADY_EXISTS=6]="ALREADY_EXISTS",_e[_e.PERMISSION_DENIED=7]="PERMISSION_DENIED",_e[_e.UNAUTHENTICATED=16]="UNAUTHENTICATED",_e[_e.RESOURCE_EXHAUSTED=8]="RESOURCE_EXHAUSTED",_e[_e.FAILED_PRECONDITION=9]="FAILED_PRECONDITION",_e[_e.ABORTED=10]="ABORTED",_e[_e.OUT_OF_RANGE=11]="OUT_OF_RANGE",_e[_e.UNIMPLEMENTED=12]="UNIMPLEMENTED",_e[_e.INTERNAL=13]="INTERNAL",_e[_e.UNAVAILABLE=14]="UNAVAILABLE",_e[_e.DATA_LOSS=15]="DATA_LOSS";/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function ZP(){return new TextEncoder}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const e2=new Vi([4294967295,4294967295],0);function Gv(t){const e=ZP().encode(t),n=new oI;return n.update(e),new Uint8Array(n.digest())}function Kv(t){const e=new DataView(t.buffer),n=e.getUint32(0,!0),r=e.getUint32(4,!0),i=e.getUint32(8,!0),s=e.getUint32(12,!0);return[new Vi([n,r],0),new Vi([i,s],0)]}class Xm{constructor(e,n,r){if(this.bitmap=e,this.padding=n,this.hashCount=r,n<0||n>=8)throw new pa(`Invalid padding: ${n}`);if(r<0)throw new pa(`Invalid hash count: ${r}`);if(e.length>0&&this.hashCount===0)throw new pa(`Invalid hash count: ${r}`);if(e.length===0&&n!==0)throw new pa(`Invalid padding when bitmap length is 0: ${n}`);this.Ie=8*e.length-n,this.Te=Vi.fromNumber(this.Ie)}Ee(e,n,r){let i=e.add(n.multiply(Vi.fromNumber(r)));return i.compare(e2)===1&&(i=new Vi([i.getBits(0),i.getBits(1)],0)),i.modulo(this.Te).toNumber()}de(e){return(this.bitmap[Math.floor(e/8)]&1<<e%8)!=0}mightContain(e){if(this.Ie===0)return!1;const n=Gv(e),[r,i]=Kv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);if(!this.de(o))return!1}return!0}static create(e,n,r){const i=e%8==0?0:8-e%8,s=new Uint8Array(Math.ceil(e/8)),o=new Xm(s,i,n);return r.forEach(a=>o.insert(a)),o}insert(e){if(this.Ie===0)return;const n=Gv(e),[r,i]=Kv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);this.Ae(o)}}Ae(e){const n=Math.floor(e/8),r=e%8;this.bitmap[n]|=1<<r}}class pa extends Error{constructor(){super(...arguments),this.name="BloomFilterError"}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class kh{constructor(e,n,r,i,s){this.snapshotVersion=e,this.targetChanges=n,this.targetMismatches=r,this.documentUpdates=i,this.resolvedLimboDocuments=s}static createSynthesizedRemoteEventForCurrentChange(e,n,r){const i=new Map;return i.set(e,kl.createSynthesizedTargetChangeForCurrentChange(e,n,r)),new kh(ae.min(),i,new ot(Ie),Tr(),fe())}}class kl{constructor(e,n,r,i,s){this.resumeToken=e,this.current=n,this.addedDocuments=r,this.modifiedDocuments=i,this.removedDocuments=s}static createSynthesizedTargetChangeForCurrentChange(e,n,r){return new kl(r,n,fe(),fe(),fe())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Hu{constructor(e,n,r,i){this.Re=e,this.removedTargetIds=n,this.key=r,this.Ve=i}}class VI{constructor(e,n){this.targetId=e,this.me=n}}class UI{constructor(e,n,r=Ct.EMPTY_BYTE_STRING,i=null){this.state=e,this.targetIds=n,this.resumeToken=r,this.cause=i}}class Qv{constructor(){this.fe=0,this.ge=Xv(),this.pe=Ct.EMPTY_BYTE_STRING,this.ye=!1,this.we=!0}get current(){return this.ye}get resumeToken(){return this.pe}get Se(){return this.fe!==0}get be(){return this.we}De(e){e.approximateByteSize()>0&&(this.we=!0,this.pe=e)}ve(){let e=fe(),n=fe(),r=fe();return this.ge.forEach((i,s)=>{switch(s){case 0:e=e.add(i);break;case 2:n=n.add(i);break;case 1:r=r.add(i);break;default:se()}}),new kl(this.pe,this.ye,e,n,r)}Ce(){this.we=!1,this.ge=Xv()}Fe(e,n){this.we=!0,this.ge=this.ge.insert(e,n)}Me(e){this.we=!0,this.ge=this.ge.remove(e)}xe(){this.fe+=1}Oe(){this.fe-=1,Ae(this.fe>=0)}Ne(){this.we=!0,this.ye=!0}}class t2{constructor(e){this.Le=e,this.Be=new Map,this.ke=Tr(),this.qe=Yv(),this.Qe=new ot(Ie)}Ke(e){for(const n of e.Re)e.Ve&&e.Ve.isFoundDocument()?this.$e(n,e.Ve):this.Ue(n,e.key,e.Ve);for(const n of e.removedTargetIds)this.Ue(n,e.key,e.Ve)}We(e){this.forEachTarget(e,n=>{const r=this.Ge(n);switch(e.state){case 0:this.ze(n)&&r.De(e.resumeToken);break;case 1:r.Oe(),r.Se||r.Ce(),r.De(e.resumeToken);break;case 2:r.Oe(),r.Se||this.removeTarget(n);break;case 3:this.ze(n)&&(r.Ne(),r.De(e.resumeToken));break;case 4:this.ze(n)&&(this.je(n),r.De(e.resumeToken));break;default:se()}})}forEachTarget(e,n){e.targetIds.length>0?e.targetIds.forEach(n):this.Be.forEach((r,i)=>{this.ze(i)&&n(i)})}He(e){const n=e.targetId,r=e.me.count,i=this.Je(n);if(i){const s=i.target;if(cp(s))if(r===0){const o=new te(s.path);this.Ue(n,o,Lt.newNoDocument(o,ae.min()))}else Ae(r===1);else{const o=this.Ye(n);if(o!==r){const a=this.Ze(e),u=a?this.Xe(a,e,o):1;if(u!==0){this.je(n);const c=u===2?"TargetPurposeExistenceFilterMismatchBloom":"TargetPurposeExistenceFilterMismatch";this.Qe=this.Qe.insert(n,c)}}}}}Ze(e){const n=e.me.unchangedNames;if(!n||!n.bits)return null;const{bits:{bitmap:r="",padding:i=0},hashCount:s=0}=n;let o,a;try{o=Hi(r).toUint8Array()}catch(u){if(u instanceof mI)return io("Decoding the base64 bloom filter in existence filter failed ("+u.message+"); ignoring the bloom filter and falling back to full re-query."),null;throw u}try{a=new Xm(o,i,s)}catch(u){return io(u instanceof pa?"BloomFilter error: ":"Applying bloom filter failed: ",u),null}return a.Ie===0?null:a}Xe(e,n,r){return n.me.count===r-this.nt(e,n.targetId)?0:2}nt(e,n){const r=this.Le.getRemoteKeysForTarget(n);let i=0;return r.forEach(s=>{const o=this.Le.tt(),a=`projects/${o.projectId}/databases/${o.database}/documents/${s.path.canonicalString()}`;e.mightContain(a)||(this.Ue(n,s,null),i++)}),i}rt(e){const n=new Map;this.Be.forEach((s,o)=>{const a=this.Je(o);if(a){if(s.current&&cp(a.target)){const u=new te(a.target.path);this.ke.get(u)!==null||this.it(o,u)||this.Ue(o,u,Lt.newNoDocument(u,e))}s.be&&(n.set(o,s.ve()),s.Ce())}});let r=fe();this.qe.forEach((s,o)=>{let a=!0;o.forEachWhile(u=>{const c=this.Je(u);return!c||c.purpose==="TargetPurposeLimboResolution"||(a=!1,!1)}),a&&(r=r.add(s))}),this.ke.forEach((s,o)=>o.setReadTime(e));const i=new kh(e,n,this.Qe,this.ke,r);return this.ke=Tr(),this.qe=Yv(),this.Qe=new ot(Ie),i}$e(e,n){if(!this.ze(e))return;const r=this.it(e,n.key)?2:0;this.Ge(e).Fe(n.key,r),this.ke=this.ke.insert(n.key,n),this.qe=this.qe.insert(n.key,this.st(n.key).add(e))}Ue(e,n,r){if(!this.ze(e))return;const i=this.Ge(e);this.it(e,n)?i.Fe(n,1):i.Me(n),this.qe=this.qe.insert(n,this.st(n).delete(e)),r&&(this.ke=this.ke.insert(n,r))}removeTarget(e){this.Be.delete(e)}Ye(e){const n=this.Ge(e).ve();return this.Le.getRemoteKeysForTarget(e).size+n.addedDocuments.size-n.removedDocuments.size}xe(e){this.Ge(e).xe()}Ge(e){let n=this.Be.get(e);return n||(n=new Qv,this.Be.set(e,n)),n}st(e){let n=this.qe.get(e);return n||(n=new St(Ie),this.qe=this.qe.insert(e,n)),n}ze(e){const n=this.Je(e)!==null;return n||J("WatchChangeAggregator","Detected inactive target",e),n}Je(e){const n=this.Be.get(e);return n&&n.Se?null:this.Le.ot(e)}je(e){this.Be.set(e,new Qv),this.Le.getRemoteKeysForTarget(e).forEach(n=>{this.Ue(e,n,null)})}it(e,n){return this.Le.getRemoteKeysForTarget(e).has(n)}}function Yv(){return new ot(te.comparator)}function Xv(){return new ot(te.comparator)}const n2={asc:"ASCENDING",desc:"DESCENDING"},r2={"<":"LESS_THAN","<=":"LESS_THAN_OR_EQUAL",">":"GREATER_THAN",">=":"GREATER_THAN_OR_EQUAL","==":"EQUAL","!=":"NOT_EQUAL","array-contains":"ARRAY_CONTAINS",in:"IN","not-in":"NOT_IN","array-contains-any":"ARRAY_CONTAINS_ANY"},i2={and:"AND",or:"OR"};class s2{constructor(e,n){this.databaseId=e,this.useProto3Json=n}}function fp(t,e){return t.useProto3Json||wh(e)?e:{value:e}}function Nc(t,e){return t.useProto3Json?`${new Date(1e3*e.seconds).toISOString().replace(/\.\d*/,"").replace("Z","")}.${("000000000"+e.nanoseconds).slice(-9)}Z`:{seconds:""+e.seconds,nanos:e.nanoseconds}}function jI(t,e){return t.useProto3Json?e.toBase64():e.toUint8Array()}function o2(t,e){return Nc(t,e.toTimestamp())}function Qn(t){return Ae(!!t),ae.fromTimestamp(function(n){const r=di(n);return new ht(r.seconds,r.nanos)}(t))}function Jm(t,e){return pp(t,e).canonicalString()}function pp(t,e){const n=function(i){return new je(["projects",i.projectId,"databases",i.database])}(t).child("documents");return e===void 0?n:n.child(e)}function zI(t){const e=je.fromString(t);return Ae(HI(e)),e}function mp(t,e){return Jm(t.databaseId,e.path)}function Ud(t,e){const n=zI(e);if(n.get(1)!==t.databaseId.projectId)throw new X(V.INVALID_ARGUMENT,"Tried to deserialize key from different project: "+n.get(1)+" vs "+t.databaseId.projectId);if(n.get(3)!==t.databaseId.database)throw new X(V.INVALID_ARGUMENT,"Tried to deserialize key from different database: "+n.get(3)+" vs "+t.databaseId.database);return new te($I(n))}function BI(t,e){return Jm(t.databaseId,e)}function a2(t){const e=zI(t);return e.length===4?je.emptyPath():$I(e)}function gp(t){return new je(["projects",t.databaseId.projectId,"databases",t.databaseId.database]).canonicalString()}function $I(t){return Ae(t.length>4&&t.get(4)==="documents"),t.popFirst(5)}function Jv(t,e,n){return{name:mp(t,e),fields:n.value.mapValue.fields}}function l2(t,e){let n;if("targetChange"in e){e.targetChange;const r=function(c){return c==="NO_CHANGE"?0:c==="ADD"?1:c==="REMOVE"?2:c==="CURRENT"?3:c==="RESET"?4:se()}(e.targetChange.targetChangeType||"NO_CHANGE"),i=e.targetChange.targetIds||[],s=function(c,h){return c.useProto3Json?(Ae(h===void 0||typeof h=="string"),Ct.fromBase64String(h||"")):(Ae(h===void 0||h instanceof Buffer||h instanceof Uint8Array),Ct.fromUint8Array(h||new Uint8Array))}(t,e.targetChange.resumeToken),o=e.targetChange.cause,a=o&&function(c){const h=c.code===void 0?V.UNKNOWN:FI(c.code);return new X(h,c.message||"")}(o);n=new UI(r,i,s,a||null)}else if("documentChange"in e){e.documentChange;const r=e.documentChange;r.document,r.document.name,r.document.updateTime;const i=Ud(t,r.document.name),s=Qn(r.document.updateTime),o=r.document.createTime?Qn(r.document.createTime):ae.min(),a=new gn({mapValue:{fields:r.document.fields}}),u=Lt.newFoundDocument(i,s,o,a),c=r.targetIds||[],h=r.removedTargetIds||[];n=new Hu(c,h,u.key,u)}else if("documentDelete"in e){e.documentDelete;const r=e.documentDelete;r.document;const i=Ud(t,r.document),s=r.readTime?Qn(r.readTime):ae.min(),o=Lt.newNoDocument(i,s),a=r.removedTargetIds||[];n=new Hu([],a,o.key,o)}else if("documentRemove"in e){e.documentRemove;const r=e.documentRemove;r.document;const i=Ud(t,r.document),s=r.removedTargetIds||[];n=new Hu([],s,i,null)}else{if(!("filter"in e))return se();{e.filter;const r=e.filter;r.targetId;const{count:i=0,unchangedNames:s}=r,o=new XP(i,s),a=r.targetId;n=new VI(a,o)}}return n}function u2(t,e){let n;if(e instanceof Sl)n={update:Jv(t,e.key,e.value)};else if(e instanceof Qm)n={delete:mp(t,e.key)};else if(e instanceof ns)n={update:Jv(t,e.key,e.data),updateMask:y2(e.fieldMask)};else{if(!(e instanceof KP))return se();n={verify:mp(t,e.key)}}return e.fieldTransforms.length>0&&(n.updateTransforms=e.fieldTransforms.map(r=>function(s,o){const a=o.transform;if(a instanceof ll)return{fieldPath:o.field.canonicalString(),setToServerValue:"REQUEST_TIME"};if(a instanceof ul)return{fieldPath:o.field.canonicalString(),appendMissingElements:{values:a.elements}};if(a instanceof cl)return{fieldPath:o.field.canonicalString(),removeAllFromArray:{values:a.elements}};if(a instanceof Pc)return{fieldPath:o.field.canonicalString(),increment:a.Pe};throw se()}(0,r))),e.precondition.isNone||(n.currentDocument=function(i,s){return s.updateTime!==void 0?{updateTime:o2(i,s.updateTime)}:s.exists!==void 0?{exists:s.exists}:se()}(t,e.precondition)),n}function c2(t,e){return t&&t.length>0?(Ae(e!==void 0),t.map(n=>function(i,s){let o=i.updateTime?Qn(i.updateTime):Qn(s);return o.isEqual(ae.min())&&(o=Qn(s)),new qP(o,i.transformResults||[])}(n,e))):[]}function h2(t,e){return{documents:[BI(t,e.path)]}}function d2(t,e){const n={structuredQuery:{}},r=e.path;let i;e.collectionGroup!==null?(i=r,n.structuredQuery.from=[{collectionId:e.collectionGroup,allDescendants:!0}]):(i=r.popLast(),n.structuredQuery.from=[{collectionId:r.lastSegment()}]),n.parent=BI(t,i);const s=function(c){if(c.length!==0)return qI(Un.create(c,"and"))}(e.filters);s&&(n.structuredQuery.where=s);const o=function(c){if(c.length!==0)return c.map(h=>function(g){return{field:vs(g.field),direction:m2(g.dir)}}(h))}(e.orderBy);o&&(n.structuredQuery.orderBy=o);const a=fp(t,e.limit);return a!==null&&(n.structuredQuery.limit=a),e.startAt&&(n.structuredQuery.startAt=function(c){return{before:c.inclusive,values:c.position}}(e.startAt)),e.endAt&&(n.structuredQuery.endAt=function(c){return{before:!c.inclusive,values:c.position}}(e.endAt)),{_t:n,parent:i}}function f2(t){let e=a2(t.parent);const n=t.structuredQuery,r=n.from?n.from.length:0;let i=null;if(r>0){Ae(r===1);const h=n.from[0];h.allDescendants?i=h.collectionId:e=e.child(h.collectionId)}let s=[];n.where&&(s=function(f){const g=WI(f);return g instanceof Un&&vI(g)?g.getFilters():[g]}(n.where));let o=[];n.orderBy&&(o=function(f){return f.map(g=>function(I){return new al(ws(I.field),function(D){switch(D){case"ASCENDING":return"asc";case"DESCENDING":return"desc";default:return}}(I.direction))}(g))}(n.orderBy));let a=null;n.limit&&(a=function(f){let g;return g=typeof f=="object"?f.value:f,wh(g)?null:g}(n.limit));let u=null;n.startAt&&(u=function(f){const g=!!f.before,v=f.values||[];return new bc(v,g)}(n.startAt));let c=null;return n.endAt&&(c=function(f){const g=!f.before,v=f.values||[];return new bc(v,g)}(n.endAt)),PP(e,i,o,s,a,"F",u,c)}function p2(t,e){const n=function(i){switch(i){case"TargetPurposeListen":return null;case"TargetPurposeExistenceFilterMismatch":return"existence-filter-mismatch";case"TargetPurposeExistenceFilterMismatchBloom":return"existence-filter-mismatch-bloom";case"TargetPurposeLimboResolution":return"limbo-document";default:return se()}}(e.purpose);return n==null?null:{"goog-listen-tags":n}}function WI(t){return t.unaryFilter!==void 0?function(n){switch(n.unaryFilter.op){case"IS_NAN":const r=ws(n.unaryFilter.field);return st.create(r,"==",{doubleValue:NaN});case"IS_NULL":const i=ws(n.unaryFilter.field);return st.create(i,"==",{nullValue:"NULL_VALUE"});case"IS_NOT_NAN":const s=ws(n.unaryFilter.field);return st.create(s,"!=",{doubleValue:NaN});case"IS_NOT_NULL":const o=ws(n.unaryFilter.field);return st.create(o,"!=",{nullValue:"NULL_VALUE"});default:return se()}}(t):t.fieldFilter!==void 0?function(n){return st.create(ws(n.fieldFilter.field),function(i){switch(i){case"EQUAL":return"==";case"NOT_EQUAL":return"!=";case"GREATER_THAN":return">";case"GREATER_THAN_OR_EQUAL":return">=";case"LESS_THAN":return"<";case"LESS_THAN_OR_EQUAL":return"<=";case"ARRAY_CONTAINS":return"array-contains";case"IN":return"in";case"NOT_IN":return"not-in";case"ARRAY_CONTAINS_ANY":return"array-contains-any";default:return se()}}(n.fieldFilter.op),n.fieldFilter.value)}(t):t.compositeFilter!==void 0?function(n){return Un.create(n.compositeFilter.filters.map(r=>WI(r)),function(i){switch(i){case"AND":return"and";case"OR":return"or";default:return se()}}(n.compositeFilter.op))}(t):se()}function m2(t){return n2[t]}function g2(t){return r2[t]}function _2(t){return i2[t]}function vs(t){return{fieldPath:t.canonicalString()}}function ws(t){return Tt.fromServerFormat(t.fieldPath)}function qI(t){return t instanceof st?function(n){if(n.op==="=="){if(Vv(n.value))return{unaryFilter:{field:vs(n.field),op:"IS_NAN"}};if(Fv(n.value))return{unaryFilter:{field:vs(n.field),op:"IS_NULL"}}}else if(n.op==="!="){if(Vv(n.value))return{unaryFilter:{field:vs(n.field),op:"IS_NOT_NAN"}};if(Fv(n.value))return{unaryFilter:{field:vs(n.field),op:"IS_NOT_NULL"}}}return{fieldFilter:{field:vs(n.field),op:g2(n.op),value:n.value}}}(t):t instanceof Un?function(n){const r=n.getFilters().map(i=>qI(i));return r.length===1?r[0]:{compositeFilter:{op:_2(n.op),filters:r}}}(t):se()}function y2(t){const e=[];return t.fields.forEach(n=>e.push(n.canonicalString())),{fieldPaths:e}}function HI(t){return t.length>=4&&t.get(0)==="projects"&&t.get(2)==="databases"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Hr{constructor(e,n,r,i,s=ae.min(),o=ae.min(),a=Ct.EMPTY_BYTE_STRING,u=null){this.target=e,this.targetId=n,this.purpose=r,this.sequenceNumber=i,this.snapshotVersion=s,this.lastLimboFreeSnapshotVersion=o,this.resumeToken=a,this.expectedCount=u}withSequenceNumber(e){return new Hr(this.target,this.targetId,this.purpose,e,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,this.expectedCount)}withResumeToken(e,n){return new Hr(this.target,this.targetId,this.purpose,this.sequenceNumber,n,this.lastLimboFreeSnapshotVersion,e,null)}withExpectedCount(e){return new Hr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,e)}withLastLimboFreeSnapshotVersion(e){return new Hr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,e,this.resumeToken,this.expectedCount)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class v2{constructor(e){this.ct=e}}function w2(t){const e=f2({parent:t.parent,structuredQuery:t.structuredQuery});return t.limitType==="LAST"?dp(e,e.limit,"L"):e}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class E2{constructor(){this.un=new T2}addToCollectionParentIndex(e,n){return this.un.add(n),j.resolve()}getCollectionParents(e,n){return j.resolve(this.un.getEntries(n))}addFieldIndex(e,n){return j.resolve()}deleteFieldIndex(e,n){return j.resolve()}deleteAllFieldIndexes(e){return j.resolve()}createTargetIndexes(e,n){return j.resolve()}getDocumentsMatchingTarget(e,n){return j.resolve(null)}getIndexType(e,n){return j.resolve(0)}getFieldIndexes(e,n){return j.resolve([])}getNextCollectionGroupToUpdate(e){return j.resolve(null)}getMinOffset(e,n){return j.resolve(hi.min())}getMinOffsetFromCollectionGroup(e,n){return j.resolve(hi.min())}updateCollectionGroup(e,n,r){return j.resolve()}updateIndexEntries(e,n){return j.resolve()}}class T2{constructor(){this.index={}}add(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n]||new St(je.comparator),s=!i.has(r);return this.index[n]=i.add(r),s}has(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n];return i&&i.has(r)}getEntries(e){return(this.index[e]||new St(je.comparator)).toArray()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class lo{constructor(e){this.Ln=e}next(){return this.Ln+=2,this.Ln}static Bn(){return new lo(0)}static kn(){return new lo(-1)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class I2{constructor(){this.changes=new To(e=>e.toString(),(e,n)=>e.isEqual(n)),this.changesApplied=!1}addEntry(e){this.assertNotApplied(),this.changes.set(e.key,e)}removeEntry(e,n){this.assertNotApplied(),this.changes.set(e,Lt.newInvalidDocument(e).setReadTime(n))}getEntry(e,n){this.assertNotApplied();const r=this.changes.get(n);return r!==void 0?j.resolve(r):this.getFromCache(e,n)}getEntries(e,n){return this.getAllFromCache(e,n)}apply(e){return this.assertNotApplied(),this.changesApplied=!0,this.applyChanges(e)}assertNotApplied(){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *//**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class S2{constructor(e,n){this.overlayedDocument=e,this.mutatedFields=n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class k2{constructor(e,n,r,i){this.remoteDocumentCache=e,this.mutationQueue=n,this.documentOverlayCache=r,this.indexManager=i}getDocument(e,n){let r=null;return this.documentOverlayCache.getOverlay(e,n).next(i=>(r=i,this.remoteDocumentCache.getEntry(e,n))).next(i=>(r!==null&&Ra(r.mutation,i,Dn.empty(),ht.now()),i))}getDocuments(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.getLocalViewOfDocuments(e,r,fe()).next(()=>r))}getLocalViewOfDocuments(e,n,r=fe()){const i=Di();return this.populateOverlays(e,i,n).next(()=>this.computeViews(e,n,i,r).next(s=>{let o=fa();return s.forEach((a,u)=>{o=o.insert(a,u.overlayedDocument)}),o}))}getOverlayedDocuments(e,n){const r=Di();return this.populateOverlays(e,r,n).next(()=>this.computeViews(e,n,r,fe()))}populateOverlays(e,n,r){const i=[];return r.forEach(s=>{n.has(s)||i.push(s)}),this.documentOverlayCache.getOverlays(e,i).next(s=>{s.forEach((o,a)=>{n.set(o,a)})})}computeViews(e,n,r,i){let s=Tr();const o=Ca(),a=function(){return Ca()}();return n.forEach((u,c)=>{const h=r.get(c.key);i.has(c.key)&&(h===void 0||h.mutation instanceof ns)?s=s.insert(c.key,c):h!==void 0?(o.set(c.key,h.mutation.getFieldMask()),Ra(h.mutation,c,h.mutation.getFieldMask(),ht.now())):o.set(c.key,Dn.empty())}),this.recalculateAndSaveOverlays(e,s).next(u=>(u.forEach((c,h)=>o.set(c,h)),n.forEach((c,h)=>{var f;return a.set(c,new S2(h,(f=o.get(c))!==null&&f!==void 0?f:null))}),a))}recalculateAndSaveOverlays(e,n){const r=Ca();let i=new ot((o,a)=>o-a),s=fe();return this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(e,n).next(o=>{for(const a of o)a.keys().forEach(u=>{const c=n.get(u);if(c===null)return;let h=r.get(u)||Dn.empty();h=a.applyToLocalView(c,h),r.set(u,h);const f=(i.get(a.batchId)||fe()).add(u);i=i.insert(a.batchId,f)})}).next(()=>{const o=[],a=i.getReverseIterator();for(;a.hasNext();){const u=a.getNext(),c=u.key,h=u.value,f=AI();h.forEach(g=>{if(!s.has(g)){const v=MI(n.get(g),r.get(g));v!==null&&f.set(g,v),s=s.add(g)}}),o.push(this.documentOverlayCache.saveOverlays(e,c,f))}return j.waitFor(o)}).next(()=>r)}recalculateAndSaveOverlaysForDocumentKeys(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.recalculateAndSaveOverlays(e,r))}getDocumentsMatchingQuery(e,n,r,i){return function(o){return te.isDocumentKey(o.path)&&o.collectionGroup===null&&o.filters.length===0}(n)?this.getDocumentsMatchingDocumentQuery(e,n.path):SI(n)?this.getDocumentsMatchingCollectionGroupQuery(e,n,r,i):this.getDocumentsMatchingCollectionQuery(e,n,r,i)}getNextDocuments(e,n,r,i){return this.remoteDocumentCache.getAllFromCollectionGroup(e,n,r,i).next(s=>{const o=i-s.size>0?this.documentOverlayCache.getOverlaysForCollectionGroup(e,n,r.largestBatchId,i-s.size):j.resolve(Di());let a=-1,u=s;return o.next(c=>j.forEach(c,(h,f)=>(a<f.largestBatchId&&(a=f.largestBatchId),s.get(h)?j.resolve():this.remoteDocumentCache.getEntry(e,h).next(g=>{u=u.insert(h,g)}))).next(()=>this.populateOverlays(e,c,s)).next(()=>this.computeViews(e,u,c,fe())).next(h=>({batchId:a,changes:xI(h)})))})}getDocumentsMatchingDocumentQuery(e,n){return this.getDocument(e,new te(n)).next(r=>{let i=fa();return r.isFoundDocument()&&(i=i.insert(r.key,r)),i})}getDocumentsMatchingCollectionGroupQuery(e,n,r,i){const s=n.collectionGroup;let o=fa();return this.indexManager.getCollectionParents(e,s).next(a=>j.forEach(a,u=>{const c=function(f,g){return new Eo(g,null,f.explicitOrderBy.slice(),f.filters.slice(),f.limit,f.limitType,f.startAt,f.endAt)}(n,u.child(s));return this.getDocumentsMatchingCollectionQuery(e,c,r,i).next(h=>{h.forEach((f,g)=>{o=o.insert(f,g)})})}).next(()=>o))}getDocumentsMatchingCollectionQuery(e,n,r,i){let s;return this.documentOverlayCache.getOverlaysForCollection(e,n.path,r.largestBatchId).next(o=>(s=o,this.remoteDocumentCache.getDocumentsMatchingQuery(e,n,r,s,i))).next(o=>{s.forEach((u,c)=>{const h=c.getKey();o.get(h)===null&&(o=o.insert(h,Lt.newInvalidDocument(h)))});let a=fa();return o.forEach((u,c)=>{const h=s.get(u);h!==void 0&&Ra(h.mutation,c,Dn.empty(),ht.now()),Th(n,c)&&(a=a.insert(u,c))}),a})}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class C2{constructor(e){this.serializer=e,this.hr=new Map,this.Pr=new Map}getBundleMetadata(e,n){return j.resolve(this.hr.get(n))}saveBundleMetadata(e,n){return this.hr.set(n.id,function(i){return{id:i.id,version:i.version,createTime:Qn(i.createTime)}}(n)),j.resolve()}getNamedQuery(e,n){return j.resolve(this.Pr.get(n))}saveNamedQuery(e,n){return this.Pr.set(n.name,function(i){return{name:i.name,query:w2(i.bundledQuery),readTime:Qn(i.readTime)}}(n)),j.resolve()}}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class R2{constructor(){this.overlays=new ot(te.comparator),this.Ir=new Map}getOverlay(e,n){return j.resolve(this.overlays.get(n))}getOverlays(e,n){const r=Di();return j.forEach(n,i=>this.getOverlay(e,i).next(s=>{s!==null&&r.set(i,s)})).next(()=>r)}saveOverlays(e,n,r){return r.forEach((i,s)=>{this.ht(e,n,s)}),j.resolve()}removeOverlaysForBatchId(e,n,r){const i=this.Ir.get(r);return i!==void 0&&(i.forEach(s=>this.overlays=this.overlays.remove(s)),this.Ir.delete(r)),j.resolve()}getOverlaysForCollection(e,n,r){const i=Di(),s=n.length+1,o=new te(n.child("")),a=this.overlays.getIteratorFrom(o);for(;a.hasNext();){const u=a.getNext().value,c=u.getKey();if(!n.isPrefixOf(c.path))break;c.path.length===s&&u.largestBatchId>r&&i.set(u.getKey(),u)}return j.resolve(i)}getOverlaysForCollectionGroup(e,n,r,i){let s=new ot((c,h)=>c-h);const o=this.overlays.getIterator();for(;o.hasNext();){const c=o.getNext().value;if(c.getKey().getCollectionGroup()===n&&c.largestBatchId>r){let h=s.get(c.largestBatchId);h===null&&(h=Di(),s=s.insert(c.largestBatchId,h)),h.set(c.getKey(),c)}}const a=Di(),u=s.getIterator();for(;u.hasNext()&&(u.getNext().value.forEach((c,h)=>a.set(c,h)),!(a.size()>=i)););return j.resolve(a)}ht(e,n,r){const i=this.overlays.get(r.key);if(i!==null){const o=this.Ir.get(i.largestBatchId).delete(r.key);this.Ir.set(i.largestBatchId,o)}this.overlays=this.overlays.insert(r.key,new YP(n,r));let s=this.Ir.get(n);s===void 0&&(s=fe(),this.Ir.set(n,s)),this.Ir.set(n,s.add(r.key))}}/**
 * @license
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class x2{constructor(){this.sessionToken=Ct.EMPTY_BYTE_STRING}getSessionToken(e){return j.resolve(this.sessionToken)}setSessionToken(e,n){return this.sessionToken=n,j.resolve()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Zm{constructor(){this.Tr=new St(ft.Er),this.dr=new St(ft.Ar)}isEmpty(){return this.Tr.isEmpty()}addReference(e,n){const r=new ft(e,n);this.Tr=this.Tr.add(r),this.dr=this.dr.add(r)}Rr(e,n){e.forEach(r=>this.addReference(r,n))}removeReference(e,n){this.Vr(new ft(e,n))}mr(e,n){e.forEach(r=>this.removeReference(r,n))}gr(e){const n=new te(new je([])),r=new ft(n,e),i=new ft(n,e+1),s=[];return this.dr.forEachInRange([r,i],o=>{this.Vr(o),s.push(o.key)}),s}pr(){this.Tr.forEach(e=>this.Vr(e))}Vr(e){this.Tr=this.Tr.delete(e),this.dr=this.dr.delete(e)}yr(e){const n=new te(new je([])),r=new ft(n,e),i=new ft(n,e+1);let s=fe();return this.dr.forEachInRange([r,i],o=>{s=s.add(o.key)}),s}containsKey(e){const n=new ft(e,0),r=this.Tr.firstAfterOrEqual(n);return r!==null&&e.isEqual(r.key)}}class ft{constructor(e,n){this.key=e,this.wr=n}static Er(e,n){return te.comparator(e.key,n.key)||Ie(e.wr,n.wr)}static Ar(e,n){return Ie(e.wr,n.wr)||te.comparator(e.key,n.key)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class A2{constructor(e,n){this.indexManager=e,this.referenceDelegate=n,this.mutationQueue=[],this.Sr=1,this.br=new St(ft.Er)}checkEmpty(e){return j.resolve(this.mutationQueue.length===0)}addMutationBatch(e,n,r,i){const s=this.Sr;this.Sr++,this.mutationQueue.length>0&&this.mutationQueue[this.mutationQueue.length-1];const o=new QP(s,n,r,i);this.mutationQueue.push(o);for(const a of i)this.br=this.br.add(new ft(a.key,s)),this.indexManager.addToCollectionParentIndex(e,a.key.path.popLast());return j.resolve(o)}lookupMutationBatch(e,n){return j.resolve(this.Dr(n))}getNextMutationBatchAfterBatchId(e,n){const r=n+1,i=this.vr(r),s=i<0?0:i;return j.resolve(this.mutationQueue.length>s?this.mutationQueue[s]:null)}getHighestUnacknowledgedBatchId(){return j.resolve(this.mutationQueue.length===0?-1:this.Sr-1)}getAllMutationBatches(e){return j.resolve(this.mutationQueue.slice())}getAllMutationBatchesAffectingDocumentKey(e,n){const r=new ft(n,0),i=new ft(n,Number.POSITIVE_INFINITY),s=[];return this.br.forEachInRange([r,i],o=>{const a=this.Dr(o.wr);s.push(a)}),j.resolve(s)}getAllMutationBatchesAffectingDocumentKeys(e,n){let r=new St(Ie);return n.forEach(i=>{const s=new ft(i,0),o=new ft(i,Number.POSITIVE_INFINITY);this.br.forEachInRange([s,o],a=>{r=r.add(a.wr)})}),j.resolve(this.Cr(r))}getAllMutationBatchesAffectingQuery(e,n){const r=n.path,i=r.length+1;let s=r;te.isDocumentKey(s)||(s=s.child(""));const o=new ft(new te(s),0);let a=new St(Ie);return this.br.forEachWhile(u=>{const c=u.key.path;return!!r.isPrefixOf(c)&&(c.length===i&&(a=a.add(u.wr)),!0)},o),j.resolve(this.Cr(a))}Cr(e){const n=[];return e.forEach(r=>{const i=this.Dr(r);i!==null&&n.push(i)}),n}removeMutationBatch(e,n){Ae(this.Fr(n.batchId,"removed")===0),this.mutationQueue.shift();let r=this.br;return j.forEach(n.mutations,i=>{const s=new ft(i.key,n.batchId);return r=r.delete(s),this.referenceDelegate.markPotentiallyOrphaned(e,i.key)}).next(()=>{this.br=r})}On(e){}containsKey(e,n){const r=new ft(n,0),i=this.br.firstAfterOrEqual(r);return j.resolve(n.isEqual(i&&i.key))}performConsistencyCheck(e){return this.mutationQueue.length,j.resolve()}Fr(e,n){return this.vr(e)}vr(e){return this.mutationQueue.length===0?0:e-this.mutationQueue[0].batchId}Dr(e){const n=this.vr(e);return n<0||n>=this.mutationQueue.length?null:this.mutationQueue[n]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class b2{constructor(e){this.Mr=e,this.docs=function(){return new ot(te.comparator)}(),this.size=0}setIndexManager(e){this.indexManager=e}addEntry(e,n){const r=n.key,i=this.docs.get(r),s=i?i.size:0,o=this.Mr(n);return this.docs=this.docs.insert(r,{document:n.mutableCopy(),size:o}),this.size+=o-s,this.indexManager.addToCollectionParentIndex(e,r.path.popLast())}removeEntry(e){const n=this.docs.get(e);n&&(this.docs=this.docs.remove(e),this.size-=n.size)}getEntry(e,n){const r=this.docs.get(n);return j.resolve(r?r.document.mutableCopy():Lt.newInvalidDocument(n))}getEntries(e,n){let r=Tr();return n.forEach(i=>{const s=this.docs.get(i);r=r.insert(i,s?s.document.mutableCopy():Lt.newInvalidDocument(i))}),j.resolve(r)}getDocumentsMatchingQuery(e,n,r,i){let s=Tr();const o=n.path,a=new te(o.child("")),u=this.docs.getIteratorFrom(a);for(;u.hasNext();){const{key:c,value:{document:h}}=u.getNext();if(!o.isPrefixOf(c.path))break;c.path.length>o.length+1||dP(hP(h),r)<=0||(i.has(h.key)||Th(n,h))&&(s=s.insert(h.key,h.mutableCopy()))}return j.resolve(s)}getAllFromCollectionGroup(e,n,r,i){se()}Or(e,n){return j.forEach(this.docs,r=>n(r))}newChangeBuffer(e){return new P2(this)}getSize(e){return j.resolve(this.size)}}class P2 extends I2{constructor(e){super(),this.cr=e}applyChanges(e){const n=[];return this.changes.forEach((r,i)=>{i.isValidDocument()?n.push(this.cr.addEntry(e,i)):this.cr.removeEntry(r)}),j.waitFor(n)}getFromCache(e,n){return this.cr.getEntry(e,n)}getAllFromCache(e,n){return this.cr.getEntries(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class N2{constructor(e){this.persistence=e,this.Nr=new To(n=>Hm(n),Gm),this.lastRemoteSnapshotVersion=ae.min(),this.highestTargetId=0,this.Lr=0,this.Br=new Zm,this.targetCount=0,this.kr=lo.Bn()}forEachTarget(e,n){return this.Nr.forEach((r,i)=>n(i)),j.resolve()}getLastRemoteSnapshotVersion(e){return j.resolve(this.lastRemoteSnapshotVersion)}getHighestSequenceNumber(e){return j.resolve(this.Lr)}allocateTargetId(e){return this.highestTargetId=this.kr.next(),j.resolve(this.highestTargetId)}setTargetsMetadata(e,n,r){return r&&(this.lastRemoteSnapshotVersion=r),n>this.Lr&&(this.Lr=n),j.resolve()}Kn(e){this.Nr.set(e.target,e);const n=e.targetId;n>this.highestTargetId&&(this.kr=new lo(n),this.highestTargetId=n),e.sequenceNumber>this.Lr&&(this.Lr=e.sequenceNumber)}addTargetData(e,n){return this.Kn(n),this.targetCount+=1,j.resolve()}updateTargetData(e,n){return this.Kn(n),j.resolve()}removeTargetData(e,n){return this.Nr.delete(n.target),this.Br.gr(n.targetId),this.targetCount-=1,j.resolve()}removeTargets(e,n,r){let i=0;const s=[];return this.Nr.forEach((o,a)=>{a.sequenceNumber<=n&&r.get(a.targetId)===null&&(this.Nr.delete(o),s.push(this.removeMatchingKeysForTargetId(e,a.targetId)),i++)}),j.waitFor(s).next(()=>i)}getTargetCount(e){return j.resolve(this.targetCount)}getTargetData(e,n){const r=this.Nr.get(n)||null;return j.resolve(r)}addMatchingKeys(e,n,r){return this.Br.Rr(n,r),j.resolve()}removeMatchingKeys(e,n,r){this.Br.mr(n,r);const i=this.persistence.referenceDelegate,s=[];return i&&n.forEach(o=>{s.push(i.markPotentiallyOrphaned(e,o))}),j.waitFor(s)}removeMatchingKeysForTargetId(e,n){return this.Br.gr(n),j.resolve()}getMatchingKeysForTargetId(e,n){const r=this.Br.yr(n);return j.resolve(r)}containsKey(e,n){return j.resolve(this.Br.containsKey(n))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class D2{constructor(e,n){this.qr={},this.overlays={},this.Qr=new Bm(0),this.Kr=!1,this.Kr=!0,this.$r=new x2,this.referenceDelegate=e(this),this.Ur=new N2(this),this.indexManager=new E2,this.remoteDocumentCache=function(i){return new b2(i)}(r=>this.referenceDelegate.Wr(r)),this.serializer=new v2(n),this.Gr=new C2(this.serializer)}start(){return Promise.resolve()}shutdown(){return this.Kr=!1,Promise.resolve()}get started(){return this.Kr}setDatabaseDeletedListener(){}setNetworkEnabled(){}getIndexManager(e){return this.indexManager}getDocumentOverlayCache(e){let n=this.overlays[e.toKey()];return n||(n=new R2,this.overlays[e.toKey()]=n),n}getMutationQueue(e,n){let r=this.qr[e.toKey()];return r||(r=new A2(n,this.referenceDelegate),this.qr[e.toKey()]=r),r}getGlobalsCache(){return this.$r}getTargetCache(){return this.Ur}getRemoteDocumentCache(){return this.remoteDocumentCache}getBundleCache(){return this.Gr}runTransaction(e,n,r){J("MemoryPersistence","Starting transaction:",e);const i=new O2(this.Qr.next());return this.referenceDelegate.zr(),r(i).next(s=>this.referenceDelegate.jr(i).next(()=>s)).toPromise().then(s=>(i.raiseOnCommittedEvent(),s))}Hr(e,n){return j.or(Object.values(this.qr).map(r=>()=>r.containsKey(e,n)))}}class O2 extends pP{constructor(e){super(),this.currentSequenceNumber=e}}class eg{constructor(e){this.persistence=e,this.Jr=new Zm,this.Yr=null}static Zr(e){return new eg(e)}get Xr(){if(this.Yr)return this.Yr;throw se()}addReference(e,n,r){return this.Jr.addReference(r,n),this.Xr.delete(r.toString()),j.resolve()}removeReference(e,n,r){return this.Jr.removeReference(r,n),this.Xr.add(r.toString()),j.resolve()}markPotentiallyOrphaned(e,n){return this.Xr.add(n.toString()),j.resolve()}removeTarget(e,n){this.Jr.gr(n.targetId).forEach(i=>this.Xr.add(i.toString()));const r=this.persistence.getTargetCache();return r.getMatchingKeysForTargetId(e,n.targetId).next(i=>{i.forEach(s=>this.Xr.add(s.toString()))}).next(()=>r.removeTargetData(e,n))}zr(){this.Yr=new Set}jr(e){const n=this.persistence.getRemoteDocumentCache().newChangeBuffer();return j.forEach(this.Xr,r=>{const i=te.fromPath(r);return this.ei(e,i).next(s=>{s||n.removeEntry(i,ae.min())})}).next(()=>(this.Yr=null,n.apply(e)))}updateLimboDocument(e,n){return this.ei(e,n).next(r=>{r?this.Xr.delete(n.toString()):this.Xr.add(n.toString())})}Wr(e){return 0}ei(e,n){return j.or([()=>j.resolve(this.Jr.containsKey(n)),()=>this.persistence.getTargetCache().containsKey(e,n),()=>this.persistence.Hr(e,n)])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class tg{constructor(e,n,r,i){this.targetId=e,this.fromCache=n,this.$i=r,this.Ui=i}static Wi(e,n){let r=fe(),i=fe();for(const s of n.docChanges)switch(s.type){case 0:r=r.add(s.doc.key);break;case 1:i=i.add(s.doc.key)}return new tg(e,n.fromCache,r,i)}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class M2{constructor(){this._documentReadCount=0}get documentReadCount(){return this._documentReadCount}incrementDocumentReadCount(e){this._documentReadCount+=e}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class L2{constructor(){this.Gi=!1,this.zi=!1,this.ji=100,this.Hi=function(){return DA()?8:mP(jt())>0?6:4}()}initialize(e,n){this.Ji=e,this.indexManager=n,this.Gi=!0}getDocumentsMatchingQuery(e,n,r,i){const s={result:null};return this.Yi(e,n).next(o=>{s.result=o}).next(()=>{if(!s.result)return this.Zi(e,n,i,r).next(o=>{s.result=o})}).next(()=>{if(s.result)return;const o=new M2;return this.Xi(e,n,o).next(a=>{if(s.result=a,this.zi)return this.es(e,n,o,a.size)})}).next(()=>s.result)}es(e,n,r,i){return r.documentReadCount<this.ji?(Zo()<=he.DEBUG&&J("QueryEngine","SDK will not create cache indexes for query:",ys(n),"since it only creates cache indexes for collection contains","more than or equal to",this.ji,"documents"),j.resolve()):(Zo()<=he.DEBUG&&J("QueryEngine","Query:",ys(n),"scans",r.documentReadCount,"local documents and returns",i,"documents as results."),r.documentReadCount>this.Hi*i?(Zo()<=he.DEBUG&&J("QueryEngine","The SDK decides to create cache indexes for query:",ys(n),"as using cache indexes may help improve performance."),this.indexManager.createTargetIndexes(e,Gn(n))):j.resolve())}Yi(e,n){if(Bv(n))return j.resolve(null);let r=Gn(n);return this.indexManager.getIndexType(e,r).next(i=>i===0?null:(n.limit!==null&&i===1&&(n=dp(n,null,"F"),r=Gn(n)),this.indexManager.getDocumentsMatchingTarget(e,r).next(s=>{const o=fe(...s);return this.Ji.getDocuments(e,o).next(a=>this.indexManager.getMinOffset(e,r).next(u=>{const c=this.ts(n,a);return this.ns(n,c,o,u.readTime)?this.Yi(e,dp(n,null,"F")):this.rs(e,c,n,u)}))})))}Zi(e,n,r,i){return Bv(n)||i.isEqual(ae.min())?j.resolve(null):this.Ji.getDocuments(e,r).next(s=>{const o=this.ts(n,s);return this.ns(n,o,r,i)?j.resolve(null):(Zo()<=he.DEBUG&&J("QueryEngine","Re-using previous result from %s to execute query: %s",i.toString(),ys(n)),this.rs(e,o,n,cP(i,-1)).next(a=>a))})}ts(e,n){let r=new St(CI(e));return n.forEach((i,s)=>{Th(e,s)&&(r=r.add(s))}),r}ns(e,n,r,i){if(e.limit===null)return!1;if(r.size!==n.size)return!0;const s=e.limitType==="F"?n.last():n.first();return!!s&&(s.hasPendingWrites||s.version.compareTo(i)>0)}Xi(e,n,r){return Zo()<=he.DEBUG&&J("QueryEngine","Using full collection scan to execute query:",ys(n)),this.Ji.getDocumentsMatchingQuery(e,n,hi.min(),r)}rs(e,n,r,i){return this.Ji.getDocumentsMatchingQuery(e,r,i).next(s=>(n.forEach(o=>{s=s.insert(o.key,o)}),s))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class F2{constructor(e,n,r,i){this.persistence=e,this.ss=n,this.serializer=i,this.os=new ot(Ie),this._s=new To(s=>Hm(s),Gm),this.us=new Map,this.cs=e.getRemoteDocumentCache(),this.Ur=e.getTargetCache(),this.Gr=e.getBundleCache(),this.ls(r)}ls(e){this.documentOverlayCache=this.persistence.getDocumentOverlayCache(e),this.indexManager=this.persistence.getIndexManager(e),this.mutationQueue=this.persistence.getMutationQueue(e,this.indexManager),this.localDocuments=new k2(this.cs,this.mutationQueue,this.documentOverlayCache,this.indexManager),this.cs.setIndexManager(this.indexManager),this.ss.initialize(this.localDocuments,this.indexManager)}collectGarbage(e){return this.persistence.runTransaction("Collect garbage","readwrite-primary",n=>e.collect(n,this.os))}}function V2(t,e,n,r){return new F2(t,e,n,r)}async function GI(t,e){const n=le(t);return await n.persistence.runTransaction("Handle user change","readonly",r=>{let i;return n.mutationQueue.getAllMutationBatches(r).next(s=>(i=s,n.ls(e),n.mutationQueue.getAllMutationBatches(r))).next(s=>{const o=[],a=[];let u=fe();for(const c of i){o.push(c.batchId);for(const h of c.mutations)u=u.add(h.key)}for(const c of s){a.push(c.batchId);for(const h of c.mutations)u=u.add(h.key)}return n.localDocuments.getDocuments(r,u).next(c=>({hs:c,removedBatchIds:o,addedBatchIds:a}))})})}function U2(t,e){const n=le(t);return n.persistence.runTransaction("Acknowledge batch","readwrite-primary",r=>{const i=e.batch.keys(),s=n.cs.newChangeBuffer({trackRemovals:!0});return function(a,u,c,h){const f=c.batch,g=f.keys();let v=j.resolve();return g.forEach(I=>{v=v.next(()=>h.getEntry(u,I)).next(N=>{const D=c.docVersions.get(I);Ae(D!==null),N.version.compareTo(D)<0&&(f.applyToRemoteDocument(N,c),N.isValidDocument()&&(N.setReadTime(c.commitVersion),h.addEntry(N)))})}),v.next(()=>a.mutationQueue.removeMutationBatch(u,f))}(n,r,e,s).next(()=>s.apply(r)).next(()=>n.mutationQueue.performConsistencyCheck(r)).next(()=>n.documentOverlayCache.removeOverlaysForBatchId(r,i,e.batch.batchId)).next(()=>n.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(r,function(a){let u=fe();for(let c=0;c<a.mutationResults.length;++c)a.mutationResults[c].transformResults.length>0&&(u=u.add(a.batch.mutations[c].key));return u}(e))).next(()=>n.localDocuments.getDocuments(r,i))})}function KI(t){const e=le(t);return e.persistence.runTransaction("Get last remote snapshot version","readonly",n=>e.Ur.getLastRemoteSnapshotVersion(n))}function j2(t,e){const n=le(t),r=e.snapshotVersion;let i=n.os;return n.persistence.runTransaction("Apply remote event","readwrite-primary",s=>{const o=n.cs.newChangeBuffer({trackRemovals:!0});i=n.os;const a=[];e.targetChanges.forEach((h,f)=>{const g=i.get(f);if(!g)return;a.push(n.Ur.removeMatchingKeys(s,h.removedDocuments,f).next(()=>n.Ur.addMatchingKeys(s,h.addedDocuments,f)));let v=g.withSequenceNumber(s.currentSequenceNumber);e.targetMismatches.get(f)!==null?v=v.withResumeToken(Ct.EMPTY_BYTE_STRING,ae.min()).withLastLimboFreeSnapshotVersion(ae.min()):h.resumeToken.approximateByteSize()>0&&(v=v.withResumeToken(h.resumeToken,r)),i=i.insert(f,v),function(N,D,C){return N.resumeToken.approximateByteSize()===0||D.snapshotVersion.toMicroseconds()-N.snapshotVersion.toMicroseconds()>=3e8?!0:C.addedDocuments.size+C.modifiedDocuments.size+C.removedDocuments.size>0}(g,v,h)&&a.push(n.Ur.updateTargetData(s,v))});let u=Tr(),c=fe();if(e.documentUpdates.forEach(h=>{e.resolvedLimboDocuments.has(h)&&a.push(n.persistence.referenceDelegate.updateLimboDocument(s,h))}),a.push(z2(s,o,e.documentUpdates).next(h=>{u=h.Ps,c=h.Is})),!r.isEqual(ae.min())){const h=n.Ur.getLastRemoteSnapshotVersion(s).next(f=>n.Ur.setTargetsMetadata(s,s.currentSequenceNumber,r));a.push(h)}return j.waitFor(a).next(()=>o.apply(s)).next(()=>n.localDocuments.getLocalViewOfDocuments(s,u,c)).next(()=>u)}).then(s=>(n.os=i,s))}function z2(t,e,n){let r=fe(),i=fe();return n.forEach(s=>r=r.add(s)),e.getEntries(t,r).next(s=>{let o=Tr();return n.forEach((a,u)=>{const c=s.get(a);u.isFoundDocument()!==c.isFoundDocument()&&(i=i.add(a)),u.isNoDocument()&&u.version.isEqual(ae.min())?(e.removeEntry(a,u.readTime),o=o.insert(a,u)):!c.isValidDocument()||u.version.compareTo(c.version)>0||u.version.compareTo(c.version)===0&&c.hasPendingWrites?(e.addEntry(u),o=o.insert(a,u)):J("LocalStore","Ignoring outdated watch update for ",a,". Current version:",c.version," Watch version:",u.version)}),{Ps:o,Is:i}})}function B2(t,e){const n=le(t);return n.persistence.runTransaction("Get next mutation batch","readonly",r=>(e===void 0&&(e=-1),n.mutationQueue.getNextMutationBatchAfterBatchId(r,e)))}function $2(t,e){const n=le(t);return n.persistence.runTransaction("Allocate target","readwrite",r=>{let i;return n.Ur.getTargetData(r,e).next(s=>s?(i=s,j.resolve(i)):n.Ur.allocateTargetId(r).next(o=>(i=new Hr(e,o,"TargetPurposeListen",r.currentSequenceNumber),n.Ur.addTargetData(r,i).next(()=>i))))}).then(r=>{const i=n.os.get(r.targetId);return(i===null||r.snapshotVersion.compareTo(i.snapshotVersion)>0)&&(n.os=n.os.insert(r.targetId,r),n._s.set(e,r.targetId)),r})}async function _p(t,e,n){const r=le(t),i=r.os.get(e),s=n?"readwrite":"readwrite-primary";try{n||await r.persistence.runTransaction("Release target",s,o=>r.persistence.referenceDelegate.removeTarget(o,i))}catch(o){if(!Il(o))throw o;J("LocalStore",`Failed to update sequence numbers for target ${e}: ${o}`)}r.os=r.os.remove(e),r._s.delete(i.target)}function Zv(t,e,n){const r=le(t);let i=ae.min(),s=fe();return r.persistence.runTransaction("Execute query","readwrite",o=>function(u,c,h){const f=le(u),g=f._s.get(h);return g!==void 0?j.resolve(f.os.get(g)):f.Ur.getTargetData(c,h)}(r,o,Gn(e)).next(a=>{if(a)return i=a.lastLimboFreeSnapshotVersion,r.Ur.getMatchingKeysForTargetId(o,a.targetId).next(u=>{s=u})}).next(()=>r.ss.getDocumentsMatchingQuery(o,e,n?i:ae.min(),n?s:fe())).next(a=>(W2(r,DP(e),a),{documents:a,Ts:s})))}function W2(t,e,n){let r=t.us.get(e)||ae.min();n.forEach((i,s)=>{s.readTime.compareTo(r)>0&&(r=s.readTime)}),t.us.set(e,r)}class e0{constructor(){this.activeTargetIds=UP()}fs(e){this.activeTargetIds=this.activeTargetIds.add(e)}gs(e){this.activeTargetIds=this.activeTargetIds.delete(e)}Vs(){const e={activeTargetIds:this.activeTargetIds.toArray(),updateTimeMs:Date.now()};return JSON.stringify(e)}}class q2{constructor(){this.so=new e0,this.oo={},this.onlineStateHandler=null,this.sequenceNumberHandler=null}addPendingMutation(e){}updateMutationState(e,n,r){}addLocalQueryTarget(e,n=!0){return n&&this.so.fs(e),this.oo[e]||"not-current"}updateQueryState(e,n,r){this.oo[e]=n}removeLocalQueryTarget(e){this.so.gs(e)}isLocalQueryTarget(e){return this.so.activeTargetIds.has(e)}clearQueryState(e){delete this.oo[e]}getAllActiveQueryTargets(){return this.so.activeTargetIds}isActiveQueryTarget(e){return this.so.activeTargetIds.has(e)}start(){return this.so=new e0,Promise.resolve()}handleUserChange(e,n,r){}setOnlineState(e){}shutdown(){}writeSequenceNumber(e){}notifyBundleLoaded(e){}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class H2{_o(e){}shutdown(){}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class t0{constructor(){this.ao=()=>this.uo(),this.co=()=>this.lo(),this.ho=[],this.Po()}_o(e){this.ho.push(e)}shutdown(){window.removeEventListener("online",this.ao),window.removeEventListener("offline",this.co)}Po(){window.addEventListener("online",this.ao),window.addEventListener("offline",this.co)}uo(){J("ConnectivityMonitor","Network connectivity changed: AVAILABLE");for(const e of this.ho)e(0)}lo(){J("ConnectivityMonitor","Network connectivity changed: UNAVAILABLE");for(const e of this.ho)e(1)}static D(){return typeof window<"u"&&window.addEventListener!==void 0&&window.removeEventListener!==void 0}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Eu=null;function jd(){return Eu===null?Eu=function(){return 268435456+Math.round(2147483648*Math.random())}():Eu++,"0x"+Eu.toString(16)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const G2={BatchGetDocuments:"batchGet",Commit:"commit",RunQuery:"runQuery",RunAggregationQuery:"runAggregationQuery"};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class K2{constructor(e){this.Io=e.Io,this.To=e.To}Eo(e){this.Ao=e}Ro(e){this.Vo=e}mo(e){this.fo=e}onMessage(e){this.po=e}close(){this.To()}send(e){this.Io(e)}yo(){this.Ao()}wo(){this.Vo()}So(e){this.fo(e)}bo(e){this.po(e)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Dt="WebChannelConnection";class Q2 extends class{constructor(n){this.databaseInfo=n,this.databaseId=n.databaseId;const r=n.ssl?"https":"http",i=encodeURIComponent(this.databaseId.projectId),s=encodeURIComponent(this.databaseId.database);this.Do=r+"://"+n.host,this.vo=`projects/${i}/databases/${s}`,this.Co=this.databaseId.database==="(default)"?`project_id=${i}`:`project_id=${i}&database_id=${s}`}get Fo(){return!1}Mo(n,r,i,s,o){const a=jd(),u=this.xo(n,r.toUriEncodedString());J("RestConnection",`Sending RPC '${n}' ${a}:`,u,i);const c={"google-cloud-resource-prefix":this.vo,"x-goog-request-params":this.Co};return this.Oo(c,s,o),this.No(n,u,c,i).then(h=>(J("RestConnection",`Received RPC '${n}' ${a}: `,h),h),h=>{throw io("RestConnection",`RPC '${n}' ${a} failed with error: `,h,"url: ",u,"request:",i),h})}Lo(n,r,i,s,o,a){return this.Mo(n,r,i,s,o)}Oo(n,r,i){n["X-Goog-Api-Client"]=function(){return"gl-js/ fire/"+vo}(),n["Content-Type"]="text/plain",this.databaseInfo.appId&&(n["X-Firebase-GMPID"]=this.databaseInfo.appId),r&&r.headers.forEach((s,o)=>n[o]=s),i&&i.headers.forEach((s,o)=>n[o]=s)}xo(n,r){const i=G2[n];return`${this.Do}/v1/${r}:${i}`}terminate(){}}{constructor(e){super(e),this.forceLongPolling=e.forceLongPolling,this.autoDetectLongPolling=e.autoDetectLongPolling,this.useFetchStreams=e.useFetchStreams,this.longPollingOptions=e.longPollingOptions}No(e,n,r,i){const s=jd();return new Promise((o,a)=>{const u=new aI;u.setWithCredentials(!0),u.listenOnce(lI.COMPLETE,()=>{try{switch(u.getLastErrorCode()){case $u.NO_ERROR:const h=u.getResponseJson();J(Dt,`XHR for RPC '${e}' ${s} received:`,JSON.stringify(h)),o(h);break;case $u.TIMEOUT:J(Dt,`RPC '${e}' ${s} timed out`),a(new X(V.DEADLINE_EXCEEDED,"Request time out"));break;case $u.HTTP_ERROR:const f=u.getStatus();if(J(Dt,`RPC '${e}' ${s} failed with status:`,f,"response text:",u.getResponseText()),f>0){let g=u.getResponseJson();Array.isArray(g)&&(g=g[0]);const v=g==null?void 0:g.error;if(v&&v.status&&v.message){const I=function(D){const C=D.toLowerCase().replace(/_/g,"-");return Object.values(V).indexOf(C)>=0?C:V.UNKNOWN}(v.status);a(new X(I,v.message))}else a(new X(V.UNKNOWN,"Server responded with status "+u.getStatus()))}else a(new X(V.UNAVAILABLE,"Connection failed."));break;default:se()}}finally{J(Dt,`RPC '${e}' ${s} completed.`)}});const c=JSON.stringify(i);J(Dt,`RPC '${e}' ${s} sending request:`,i),u.send(n,"POST",c,r,15)})}Bo(e,n,r){const i=jd(),s=[this.Do,"/","google.firestore.v1.Firestore","/",e,"/channel"],o=hI(),a=cI(),u={httpSessionIdParam:"gsessionid",initMessageHeaders:{},messageUrlParams:{database:`projects/${this.databaseId.projectId}/databases/${this.databaseId.database}`},sendRawJson:!0,supportsCrossDomainXhr:!0,internalChannelParams:{forwardChannelRequestTimeoutMs:6e5},forceLongPolling:this.forceLongPolling,detectBufferingProxy:this.autoDetectLongPolling},c=this.longPollingOptions.timeoutSeconds;c!==void 0&&(u.longPollingTimeout=Math.round(1e3*c)),this.useFetchStreams&&(u.useFetchStreams=!0),this.Oo(u.initMessageHeaders,n,r),u.encodeInitMessageHeaders=!0;const h=s.join("");J(Dt,`Creating RPC '${e}' stream ${i}: ${h}`,u);const f=o.createWebChannel(h,u);let g=!1,v=!1;const I=new K2({Io:D=>{v?J(Dt,`Not sending because RPC '${e}' stream ${i} is closed:`,D):(g||(J(Dt,`Opening RPC '${e}' stream ${i} transport.`),f.open(),g=!0),J(Dt,`RPC '${e}' stream ${i} sending:`,D),f.send(D))},To:()=>f.close()}),N=(D,C,w)=>{D.listen(C,R=>{try{w(R)}catch(M){setTimeout(()=>{throw M},0)}})};return N(f,da.EventType.OPEN,()=>{v||(J(Dt,`RPC '${e}' stream ${i} transport opened.`),I.yo())}),N(f,da.EventType.CLOSE,()=>{v||(v=!0,J(Dt,`RPC '${e}' stream ${i} transport closed`),I.So())}),N(f,da.EventType.ERROR,D=>{v||(v=!0,io(Dt,`RPC '${e}' stream ${i} transport errored:`,D),I.So(new X(V.UNAVAILABLE,"The operation could not be completed")))}),N(f,da.EventType.MESSAGE,D=>{var C;if(!v){const w=D.data[0];Ae(!!w);const R=w,M=R.error||((C=R[0])===null||C===void 0?void 0:C.error);if(M){J(Dt,`RPC '${e}' stream ${i} received error:`,M);const z=M.status;let U=function(T){const x=rt[T];if(x!==void 0)return FI(x)}(z),E=M.message;U===void 0&&(U=V.INTERNAL,E="Unknown error status: "+z+" with message "+M.message),v=!0,I.So(new X(U,E)),f.close()}else J(Dt,`RPC '${e}' stream ${i} received:`,w),I.bo(w)}}),N(a,uI.STAT_EVENT,D=>{D.stat===sp.PROXY?J(Dt,`RPC '${e}' stream ${i} detected buffering proxy`):D.stat===sp.NOPROXY&&J(Dt,`RPC '${e}' stream ${i} detected no buffering proxy`)}),setTimeout(()=>{I.wo()},0),I}}function zd(){return typeof document<"u"?document:null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Ch(t){return new s2(t,!0)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class QI{constructor(e,n,r=1e3,i=1.5,s=6e4){this.ui=e,this.timerId=n,this.ko=r,this.qo=i,this.Qo=s,this.Ko=0,this.$o=null,this.Uo=Date.now(),this.reset()}reset(){this.Ko=0}Wo(){this.Ko=this.Qo}Go(e){this.cancel();const n=Math.floor(this.Ko+this.zo()),r=Math.max(0,Date.now()-this.Uo),i=Math.max(0,n-r);i>0&&J("ExponentialBackoff",`Backing off for ${i} ms (base delay: ${this.Ko} ms, delay with jitter: ${n} ms, last attempt: ${r} ms ago)`),this.$o=this.ui.enqueueAfterDelay(this.timerId,i,()=>(this.Uo=Date.now(),e())),this.Ko*=this.qo,this.Ko<this.ko&&(this.Ko=this.ko),this.Ko>this.Qo&&(this.Ko=this.Qo)}jo(){this.$o!==null&&(this.$o.skipDelay(),this.$o=null)}cancel(){this.$o!==null&&(this.$o.cancel(),this.$o=null)}zo(){return(Math.random()-.5)*this.Ko}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class YI{constructor(e,n,r,i,s,o,a,u){this.ui=e,this.Ho=r,this.Jo=i,this.connection=s,this.authCredentialsProvider=o,this.appCheckCredentialsProvider=a,this.listener=u,this.state=0,this.Yo=0,this.Zo=null,this.Xo=null,this.stream=null,this.e_=0,this.t_=new QI(e,n)}n_(){return this.state===1||this.state===5||this.r_()}r_(){return this.state===2||this.state===3}start(){this.e_=0,this.state!==4?this.auth():this.i_()}async stop(){this.n_()&&await this.close(0)}s_(){this.state=0,this.t_.reset()}o_(){this.r_()&&this.Zo===null&&(this.Zo=this.ui.enqueueAfterDelay(this.Ho,6e4,()=>this.__()))}a_(e){this.u_(),this.stream.send(e)}async __(){if(this.r_())return this.close(0)}u_(){this.Zo&&(this.Zo.cancel(),this.Zo=null)}c_(){this.Xo&&(this.Xo.cancel(),this.Xo=null)}async close(e,n){this.u_(),this.c_(),this.t_.cancel(),this.Yo++,e!==4?this.t_.reset():n&&n.code===V.RESOURCE_EXHAUSTED?(Er(n.toString()),Er("Using maximum backoff delay to prevent overloading the backend."),this.t_.Wo()):n&&n.code===V.UNAUTHENTICATED&&this.state!==3&&(this.authCredentialsProvider.invalidateToken(),this.appCheckCredentialsProvider.invalidateToken()),this.stream!==null&&(this.l_(),this.stream.close(),this.stream=null),this.state=e,await this.listener.mo(n)}l_(){}auth(){this.state=1;const e=this.h_(this.Yo),n=this.Yo;Promise.all([this.authCredentialsProvider.getToken(),this.appCheckCredentialsProvider.getToken()]).then(([r,i])=>{this.Yo===n&&this.P_(r,i)},r=>{e(()=>{const i=new X(V.UNKNOWN,"Fetching auth token failed: "+r.message);return this.I_(i)})})}P_(e,n){const r=this.h_(this.Yo);this.stream=this.T_(e,n),this.stream.Eo(()=>{r(()=>this.listener.Eo())}),this.stream.Ro(()=>{r(()=>(this.state=2,this.Xo=this.ui.enqueueAfterDelay(this.Jo,1e4,()=>(this.r_()&&(this.state=3),Promise.resolve())),this.listener.Ro()))}),this.stream.mo(i=>{r(()=>this.I_(i))}),this.stream.onMessage(i=>{r(()=>++this.e_==1?this.E_(i):this.onNext(i))})}i_(){this.state=5,this.t_.Go(async()=>{this.state=0,this.start()})}I_(e){return J("PersistentStream",`close with error: ${e}`),this.stream=null,this.close(4,e)}h_(e){return n=>{this.ui.enqueueAndForget(()=>this.Yo===e?n():(J("PersistentStream","stream callback skipped by getCloseGuardedDispatcher."),Promise.resolve()))}}}class Y2 extends YI{constructor(e,n,r,i,s,o){super(e,"listen_stream_connection_backoff","listen_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}T_(e,n){return this.connection.Bo("Listen",e,n)}E_(e){return this.onNext(e)}onNext(e){this.t_.reset();const n=l2(this.serializer,e),r=function(s){if(!("targetChange"in s))return ae.min();const o=s.targetChange;return o.targetIds&&o.targetIds.length?ae.min():o.readTime?Qn(o.readTime):ae.min()}(e);return this.listener.d_(n,r)}A_(e){const n={};n.database=gp(this.serializer),n.addTarget=function(s,o){let a;const u=o.target;if(a=cp(u)?{documents:h2(s,u)}:{query:d2(s,u)._t},a.targetId=o.targetId,o.resumeToken.approximateByteSize()>0){a.resumeToken=jI(s,o.resumeToken);const c=fp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}else if(o.snapshotVersion.compareTo(ae.min())>0){a.readTime=Nc(s,o.snapshotVersion.toTimestamp());const c=fp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}return a}(this.serializer,e);const r=p2(this.serializer,e);r&&(n.labels=r),this.a_(n)}R_(e){const n={};n.database=gp(this.serializer),n.removeTarget=e,this.a_(n)}}class X2 extends YI{constructor(e,n,r,i,s,o){super(e,"write_stream_connection_backoff","write_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}get V_(){return this.e_>0}start(){this.lastStreamToken=void 0,super.start()}l_(){this.V_&&this.m_([])}T_(e,n){return this.connection.Bo("Write",e,n)}E_(e){return Ae(!!e.streamToken),this.lastStreamToken=e.streamToken,Ae(!e.writeResults||e.writeResults.length===0),this.listener.f_()}onNext(e){Ae(!!e.streamToken),this.lastStreamToken=e.streamToken,this.t_.reset();const n=c2(e.writeResults,e.commitTime),r=Qn(e.commitTime);return this.listener.g_(r,n)}p_(){const e={};e.database=gp(this.serializer),this.a_(e)}m_(e){const n={streamToken:this.lastStreamToken,writes:e.map(r=>u2(this.serializer,r))};this.a_(n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class J2 extends class{}{constructor(e,n,r,i){super(),this.authCredentials=e,this.appCheckCredentials=n,this.connection=r,this.serializer=i,this.y_=!1}w_(){if(this.y_)throw new X(V.FAILED_PRECONDITION,"The client has already been terminated.")}Mo(e,n,r,i){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([s,o])=>this.connection.Mo(e,pp(n,r),i,s,o)).catch(s=>{throw s.name==="FirebaseError"?(s.code===V.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),s):new X(V.UNKNOWN,s.toString())})}Lo(e,n,r,i,s){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([o,a])=>this.connection.Lo(e,pp(n,r),i,o,a,s)).catch(o=>{throw o.name==="FirebaseError"?(o.code===V.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),o):new X(V.UNKNOWN,o.toString())})}terminate(){this.y_=!0,this.connection.terminate()}}class Z2{constructor(e,n){this.asyncQueue=e,this.onlineStateHandler=n,this.state="Unknown",this.S_=0,this.b_=null,this.D_=!0}v_(){this.S_===0&&(this.C_("Unknown"),this.b_=this.asyncQueue.enqueueAfterDelay("online_state_timeout",1e4,()=>(this.b_=null,this.F_("Backend didn't respond within 10 seconds."),this.C_("Offline"),Promise.resolve())))}M_(e){this.state==="Online"?this.C_("Unknown"):(this.S_++,this.S_>=1&&(this.x_(),this.F_(`Connection failed 1 times. Most recent error: ${e.toString()}`),this.C_("Offline")))}set(e){this.x_(),this.S_=0,e==="Online"&&(this.D_=!1),this.C_(e)}C_(e){e!==this.state&&(this.state=e,this.onlineStateHandler(e))}F_(e){const n=`Could not reach Cloud Firestore backend. ${e}
This typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.`;this.D_?(Er(n),this.D_=!1):J("OnlineStateTracker",n)}x_(){this.b_!==null&&(this.b_.cancel(),this.b_=null)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class eN{constructor(e,n,r,i,s){this.localStore=e,this.datastore=n,this.asyncQueue=r,this.remoteSyncer={},this.O_=[],this.N_=new Map,this.L_=new Set,this.B_=[],this.k_=s,this.k_._o(o=>{r.enqueueAndForget(async()=>{rs(this)&&(J("RemoteStore","Restarting streams for network reachability change."),await async function(u){const c=le(u);c.L_.add(4),await Cl(c),c.q_.set("Unknown"),c.L_.delete(4),await Rh(c)}(this))})}),this.q_=new Z2(r,i)}}async function Rh(t){if(rs(t))for(const e of t.B_)await e(!0)}async function Cl(t){for(const e of t.B_)await e(!1)}function XI(t,e){const n=le(t);n.N_.has(e.targetId)||(n.N_.set(e.targetId,e),sg(n)?ig(n):Io(n).r_()&&rg(n,e))}function ng(t,e){const n=le(t),r=Io(n);n.N_.delete(e),r.r_()&&JI(n,e),n.N_.size===0&&(r.r_()?r.o_():rs(n)&&n.q_.set("Unknown"))}function rg(t,e){if(t.Q_.xe(e.targetId),e.resumeToken.approximateByteSize()>0||e.snapshotVersion.compareTo(ae.min())>0){const n=t.remoteSyncer.getRemoteKeysForTarget(e.targetId).size;e=e.withExpectedCount(n)}Io(t).A_(e)}function JI(t,e){t.Q_.xe(e),Io(t).R_(e)}function ig(t){t.Q_=new t2({getRemoteKeysForTarget:e=>t.remoteSyncer.getRemoteKeysForTarget(e),ot:e=>t.N_.get(e)||null,tt:()=>t.datastore.serializer.databaseId}),Io(t).start(),t.q_.v_()}function sg(t){return rs(t)&&!Io(t).n_()&&t.N_.size>0}function rs(t){return le(t).L_.size===0}function ZI(t){t.Q_=void 0}async function tN(t){t.q_.set("Online")}async function nN(t){t.N_.forEach((e,n)=>{rg(t,e)})}async function rN(t,e){ZI(t),sg(t)?(t.q_.M_(e),ig(t)):t.q_.set("Unknown")}async function iN(t,e,n){if(t.q_.set("Online"),e instanceof UI&&e.state===2&&e.cause)try{await async function(i,s){const o=s.cause;for(const a of s.targetIds)i.N_.has(a)&&(await i.remoteSyncer.rejectListen(a,o),i.N_.delete(a),i.Q_.removeTarget(a))}(t,e)}catch(r){J("RemoteStore","Failed to remove targets %s: %s ",e.targetIds.join(","),r),await Dc(t,r)}else if(e instanceof Hu?t.Q_.Ke(e):e instanceof VI?t.Q_.He(e):t.Q_.We(e),!n.isEqual(ae.min()))try{const r=await KI(t.localStore);n.compareTo(r)>=0&&await function(s,o){const a=s.Q_.rt(o);return a.targetChanges.forEach((u,c)=>{if(u.resumeToken.approximateByteSize()>0){const h=s.N_.get(c);h&&s.N_.set(c,h.withResumeToken(u.resumeToken,o))}}),a.targetMismatches.forEach((u,c)=>{const h=s.N_.get(u);if(!h)return;s.N_.set(u,h.withResumeToken(Ct.EMPTY_BYTE_STRING,h.snapshotVersion)),JI(s,u);const f=new Hr(h.target,u,c,h.sequenceNumber);rg(s,f)}),s.remoteSyncer.applyRemoteEvent(a)}(t,n)}catch(r){J("RemoteStore","Failed to raise snapshot:",r),await Dc(t,r)}}async function Dc(t,e,n){if(!Il(e))throw e;t.L_.add(1),await Cl(t),t.q_.set("Offline"),n||(n=()=>KI(t.localStore)),t.asyncQueue.enqueueRetryable(async()=>{J("RemoteStore","Retrying IndexedDB access"),await n(),t.L_.delete(1),await Rh(t)})}function e1(t,e){return e().catch(n=>Dc(t,n,e))}async function xh(t){const e=le(t),n=fi(e);let r=e.O_.length>0?e.O_[e.O_.length-1].batchId:-1;for(;sN(e);)try{const i=await B2(e.localStore,r);if(i===null){e.O_.length===0&&n.o_();break}r=i.batchId,oN(e,i)}catch(i){await Dc(e,i)}t1(e)&&n1(e)}function sN(t){return rs(t)&&t.O_.length<10}function oN(t,e){t.O_.push(e);const n=fi(t);n.r_()&&n.V_&&n.m_(e.mutations)}function t1(t){return rs(t)&&!fi(t).n_()&&t.O_.length>0}function n1(t){fi(t).start()}async function aN(t){fi(t).p_()}async function lN(t){const e=fi(t);for(const n of t.O_)e.m_(n.mutations)}async function uN(t,e,n){const r=t.O_.shift(),i=Ym.from(r,e,n);await e1(t,()=>t.remoteSyncer.applySuccessfulWrite(i)),await xh(t)}async function cN(t,e){e&&fi(t).V_&&await async function(r,i){if(function(o){return JP(o)&&o!==V.ABORTED}(i.code)){const s=r.O_.shift();fi(r).s_(),await e1(r,()=>r.remoteSyncer.rejectFailedWrite(s.batchId,i)),await xh(r)}}(t,e),t1(t)&&n1(t)}async function n0(t,e){const n=le(t);n.asyncQueue.verifyOperationInProgress(),J("RemoteStore","RemoteStore received new credentials");const r=rs(n);n.L_.add(3),await Cl(n),r&&n.q_.set("Unknown"),await n.remoteSyncer.handleCredentialChange(e),n.L_.delete(3),await Rh(n)}async function hN(t,e){const n=le(t);e?(n.L_.delete(2),await Rh(n)):e||(n.L_.add(2),await Cl(n),n.q_.set("Unknown"))}function Io(t){return t.K_||(t.K_=function(n,r,i){const s=le(n);return s.w_(),new Y2(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:tN.bind(null,t),Ro:nN.bind(null,t),mo:rN.bind(null,t),d_:iN.bind(null,t)}),t.B_.push(async e=>{e?(t.K_.s_(),sg(t)?ig(t):t.q_.set("Unknown")):(await t.K_.stop(),ZI(t))})),t.K_}function fi(t){return t.U_||(t.U_=function(n,r,i){const s=le(n);return s.w_(),new X2(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:()=>Promise.resolve(),Ro:aN.bind(null,t),mo:cN.bind(null,t),f_:lN.bind(null,t),g_:uN.bind(null,t)}),t.B_.push(async e=>{e?(t.U_.s_(),await xh(t)):(await t.U_.stop(),t.O_.length>0&&(J("RemoteStore",`Stopping write stream with ${t.O_.length} pending writes`),t.O_=[]))})),t.U_}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class og{constructor(e,n,r,i,s){this.asyncQueue=e,this.timerId=n,this.targetTimeMs=r,this.op=i,this.removalCallback=s,this.deferred=new ri,this.then=this.deferred.promise.then.bind(this.deferred.promise),this.deferred.promise.catch(o=>{})}get promise(){return this.deferred.promise}static createAndSchedule(e,n,r,i,s){const o=Date.now()+r,a=new og(e,n,o,i,s);return a.start(r),a}start(e){this.timerHandle=setTimeout(()=>this.handleDelayElapsed(),e)}skipDelay(){return this.handleDelayElapsed()}cancel(e){this.timerHandle!==null&&(this.clearTimeout(),this.deferred.reject(new X(V.CANCELLED,"Operation cancelled"+(e?": "+e:""))))}handleDelayElapsed(){this.asyncQueue.enqueueAndForget(()=>this.timerHandle!==null?(this.clearTimeout(),this.op().then(e=>this.deferred.resolve(e))):Promise.resolve())}clearTimeout(){this.timerHandle!==null&&(this.removalCallback(this),clearTimeout(this.timerHandle),this.timerHandle=null)}}function ag(t,e){if(Er("AsyncQueue",`${e}: ${t}`),Il(t))return new X(V.UNAVAILABLE,`${e}: ${t}`);throw t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Bs{constructor(e){this.comparator=e?(n,r)=>e(n,r)||te.comparator(n.key,r.key):(n,r)=>te.comparator(n.key,r.key),this.keyedMap=fa(),this.sortedSet=new ot(this.comparator)}static emptySet(e){return new Bs(e.comparator)}has(e){return this.keyedMap.get(e)!=null}get(e){return this.keyedMap.get(e)}first(){return this.sortedSet.minKey()}last(){return this.sortedSet.maxKey()}isEmpty(){return this.sortedSet.isEmpty()}indexOf(e){const n=this.keyedMap.get(e);return n?this.sortedSet.indexOf(n):-1}get size(){return this.sortedSet.size}forEach(e){this.sortedSet.inorderTraversal((n,r)=>(e(n),!1))}add(e){const n=this.delete(e.key);return n.copy(n.keyedMap.insert(e.key,e),n.sortedSet.insert(e,null))}delete(e){const n=this.get(e);return n?this.copy(this.keyedMap.remove(e),this.sortedSet.remove(n)):this}isEqual(e){if(!(e instanceof Bs)||this.size!==e.size)return!1;const n=this.sortedSet.getIterator(),r=e.sortedSet.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(!i.isEqual(s))return!1}return!0}toString(){const e=[];return this.forEach(n=>{e.push(n.toString())}),e.length===0?"DocumentSet ()":`DocumentSet (
  `+e.join(`  
`)+`
)`}copy(e,n){const r=new Bs;return r.comparator=this.comparator,r.keyedMap=e,r.sortedSet=n,r}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class r0{constructor(){this.W_=new ot(te.comparator)}track(e){const n=e.doc.key,r=this.W_.get(n);r?e.type!==0&&r.type===3?this.W_=this.W_.insert(n,e):e.type===3&&r.type!==1?this.W_=this.W_.insert(n,{type:r.type,doc:e.doc}):e.type===2&&r.type===2?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):e.type===2&&r.type===0?this.W_=this.W_.insert(n,{type:0,doc:e.doc}):e.type===1&&r.type===0?this.W_=this.W_.remove(n):e.type===1&&r.type===2?this.W_=this.W_.insert(n,{type:1,doc:r.doc}):e.type===0&&r.type===1?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):se():this.W_=this.W_.insert(n,e)}G_(){const e=[];return this.W_.inorderTraversal((n,r)=>{e.push(r)}),e}}class uo{constructor(e,n,r,i,s,o,a,u,c){this.query=e,this.docs=n,this.oldDocs=r,this.docChanges=i,this.mutatedKeys=s,this.fromCache=o,this.syncStateChanged=a,this.excludesMetadataChanges=u,this.hasCachedResults=c}static fromInitialDocuments(e,n,r,i,s){const o=[];return n.forEach(a=>{o.push({type:0,doc:a})}),new uo(e,n,Bs.emptySet(n),o,r,i,!0,!1,s)}get hasPendingWrites(){return!this.mutatedKeys.isEmpty()}isEqual(e){if(!(this.fromCache===e.fromCache&&this.hasCachedResults===e.hasCachedResults&&this.syncStateChanged===e.syncStateChanged&&this.mutatedKeys.isEqual(e.mutatedKeys)&&Eh(this.query,e.query)&&this.docs.isEqual(e.docs)&&this.oldDocs.isEqual(e.oldDocs)))return!1;const n=this.docChanges,r=e.docChanges;if(n.length!==r.length)return!1;for(let i=0;i<n.length;i++)if(n[i].type!==r[i].type||!n[i].doc.isEqual(r[i].doc))return!1;return!0}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dN{constructor(){this.z_=void 0,this.j_=[]}H_(){return this.j_.some(e=>e.J_())}}class fN{constructor(){this.queries=i0(),this.onlineState="Unknown",this.Y_=new Set}terminate(){(function(n,r){const i=le(n),s=i.queries;i.queries=i0(),s.forEach((o,a)=>{for(const u of a.j_)u.onError(r)})})(this,new X(V.ABORTED,"Firestore shutting down"))}}function i0(){return new To(t=>kI(t),Eh)}async function pN(t,e){const n=le(t);let r=3;const i=e.query;let s=n.queries.get(i);s?!s.H_()&&e.J_()&&(r=2):(s=new dN,r=e.J_()?0:1);try{switch(r){case 0:s.z_=await n.onListen(i,!0);break;case 1:s.z_=await n.onListen(i,!1);break;case 2:await n.onFirstRemoteStoreListen(i)}}catch(o){const a=ag(o,`Initialization of query '${ys(e.query)}' failed`);return void e.onError(a)}n.queries.set(i,s),s.j_.push(e),e.Z_(n.onlineState),s.z_&&e.X_(s.z_)&&lg(n)}async function mN(t,e){const n=le(t),r=e.query;let i=3;const s=n.queries.get(r);if(s){const o=s.j_.indexOf(e);o>=0&&(s.j_.splice(o,1),s.j_.length===0?i=e.J_()?0:1:!s.H_()&&e.J_()&&(i=2))}switch(i){case 0:return n.queries.delete(r),n.onUnlisten(r,!0);case 1:return n.queries.delete(r),n.onUnlisten(r,!1);case 2:return n.onLastRemoteStoreUnlisten(r);default:return}}function gN(t,e){const n=le(t);let r=!1;for(const i of e){const s=i.query,o=n.queries.get(s);if(o){for(const a of o.j_)a.X_(i)&&(r=!0);o.z_=i}}r&&lg(n)}function _N(t,e,n){const r=le(t),i=r.queries.get(e);if(i)for(const s of i.j_)s.onError(n);r.queries.delete(e)}function lg(t){t.Y_.forEach(e=>{e.next()})}var yp,s0;(s0=yp||(yp={})).ea="default",s0.Cache="cache";class yN{constructor(e,n,r){this.query=e,this.ta=n,this.na=!1,this.ra=null,this.onlineState="Unknown",this.options=r||{}}X_(e){if(!this.options.includeMetadataChanges){const r=[];for(const i of e.docChanges)i.type!==3&&r.push(i);e=new uo(e.query,e.docs,e.oldDocs,r,e.mutatedKeys,e.fromCache,e.syncStateChanged,!0,e.hasCachedResults)}let n=!1;return this.na?this.ia(e)&&(this.ta.next(e),n=!0):this.sa(e,this.onlineState)&&(this.oa(e),n=!0),this.ra=e,n}onError(e){this.ta.error(e)}Z_(e){this.onlineState=e;let n=!1;return this.ra&&!this.na&&this.sa(this.ra,e)&&(this.oa(this.ra),n=!0),n}sa(e,n){if(!e.fromCache||!this.J_())return!0;const r=n!=="Offline";return(!this.options._a||!r)&&(!e.docs.isEmpty()||e.hasCachedResults||n==="Offline")}ia(e){if(e.docChanges.length>0)return!0;const n=this.ra&&this.ra.hasPendingWrites!==e.hasPendingWrites;return!(!e.syncStateChanged&&!n)&&this.options.includeMetadataChanges===!0}oa(e){e=uo.fromInitialDocuments(e.query,e.docs,e.mutatedKeys,e.fromCache,e.hasCachedResults),this.na=!0,this.ta.next(e)}J_(){return this.options.source!==yp.Cache}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class r1{constructor(e){this.key=e}}class i1{constructor(e){this.key=e}}class vN{constructor(e,n){this.query=e,this.Ta=n,this.Ea=null,this.hasCachedResults=!1,this.current=!1,this.da=fe(),this.mutatedKeys=fe(),this.Aa=CI(e),this.Ra=new Bs(this.Aa)}get Va(){return this.Ta}ma(e,n){const r=n?n.fa:new r0,i=n?n.Ra:this.Ra;let s=n?n.mutatedKeys:this.mutatedKeys,o=i,a=!1;const u=this.query.limitType==="F"&&i.size===this.query.limit?i.last():null,c=this.query.limitType==="L"&&i.size===this.query.limit?i.first():null;if(e.inorderTraversal((h,f)=>{const g=i.get(h),v=Th(this.query,f)?f:null,I=!!g&&this.mutatedKeys.has(g.key),N=!!v&&(v.hasLocalMutations||this.mutatedKeys.has(v.key)&&v.hasCommittedMutations);let D=!1;g&&v?g.data.isEqual(v.data)?I!==N&&(r.track({type:3,doc:v}),D=!0):this.ga(g,v)||(r.track({type:2,doc:v}),D=!0,(u&&this.Aa(v,u)>0||c&&this.Aa(v,c)<0)&&(a=!0)):!g&&v?(r.track({type:0,doc:v}),D=!0):g&&!v&&(r.track({type:1,doc:g}),D=!0,(u||c)&&(a=!0)),D&&(v?(o=o.add(v),s=N?s.add(h):s.delete(h)):(o=o.delete(h),s=s.delete(h)))}),this.query.limit!==null)for(;o.size>this.query.limit;){const h=this.query.limitType==="F"?o.last():o.first();o=o.delete(h.key),s=s.delete(h.key),r.track({type:1,doc:h})}return{Ra:o,fa:r,ns:a,mutatedKeys:s}}ga(e,n){return e.hasLocalMutations&&n.hasCommittedMutations&&!n.hasLocalMutations}applyChanges(e,n,r,i){const s=this.Ra;this.Ra=e.Ra,this.mutatedKeys=e.mutatedKeys;const o=e.fa.G_();o.sort((h,f)=>function(v,I){const N=D=>{switch(D){case 0:return 1;case 2:case 3:return 2;case 1:return 0;default:return se()}};return N(v)-N(I)}(h.type,f.type)||this.Aa(h.doc,f.doc)),this.pa(r),i=i!=null&&i;const a=n&&!i?this.ya():[],u=this.da.size===0&&this.current&&!i?1:0,c=u!==this.Ea;return this.Ea=u,o.length!==0||c?{snapshot:new uo(this.query,e.Ra,s,o,e.mutatedKeys,u===0,c,!1,!!r&&r.resumeToken.approximateByteSize()>0),wa:a}:{wa:a}}Z_(e){return this.current&&e==="Offline"?(this.current=!1,this.applyChanges({Ra:this.Ra,fa:new r0,mutatedKeys:this.mutatedKeys,ns:!1},!1)):{wa:[]}}Sa(e){return!this.Ta.has(e)&&!!this.Ra.has(e)&&!this.Ra.get(e).hasLocalMutations}pa(e){e&&(e.addedDocuments.forEach(n=>this.Ta=this.Ta.add(n)),e.modifiedDocuments.forEach(n=>{}),e.removedDocuments.forEach(n=>this.Ta=this.Ta.delete(n)),this.current=e.current)}ya(){if(!this.current)return[];const e=this.da;this.da=fe(),this.Ra.forEach(r=>{this.Sa(r.key)&&(this.da=this.da.add(r.key))});const n=[];return e.forEach(r=>{this.da.has(r)||n.push(new i1(r))}),this.da.forEach(r=>{e.has(r)||n.push(new r1(r))}),n}ba(e){this.Ta=e.Ts,this.da=fe();const n=this.ma(e.documents);return this.applyChanges(n,!0)}Da(){return uo.fromInitialDocuments(this.query,this.Ra,this.mutatedKeys,this.Ea===0,this.hasCachedResults)}}class wN{constructor(e,n,r){this.query=e,this.targetId=n,this.view=r}}class EN{constructor(e){this.key=e,this.va=!1}}class TN{constructor(e,n,r,i,s,o){this.localStore=e,this.remoteStore=n,this.eventManager=r,this.sharedClientState=i,this.currentUser=s,this.maxConcurrentLimboResolutions=o,this.Ca={},this.Fa=new To(a=>kI(a),Eh),this.Ma=new Map,this.xa=new Set,this.Oa=new ot(te.comparator),this.Na=new Map,this.La=new Zm,this.Ba={},this.ka=new Map,this.qa=lo.kn(),this.onlineState="Unknown",this.Qa=void 0}get isPrimaryClient(){return this.Qa===!0}}async function IN(t,e,n=!0){const r=c1(t);let i;const s=r.Fa.get(e);return s?(r.sharedClientState.addLocalQueryTarget(s.targetId),i=s.view.Da()):i=await s1(r,e,n,!0),i}async function SN(t,e){const n=c1(t);await s1(n,e,!0,!1)}async function s1(t,e,n,r){const i=await $2(t.localStore,Gn(e)),s=i.targetId,o=t.sharedClientState.addLocalQueryTarget(s,n);let a;return r&&(a=await kN(t,e,s,o==="current",i.resumeToken)),t.isPrimaryClient&&n&&XI(t.remoteStore,i),a}async function kN(t,e,n,r,i){t.Ka=(f,g,v)=>async function(N,D,C,w){let R=D.view.ma(C);R.ns&&(R=await Zv(N.localStore,D.query,!1).then(({documents:E})=>D.view.ma(E,R)));const M=w&&w.targetChanges.get(D.targetId),z=w&&w.targetMismatches.get(D.targetId)!=null,U=D.view.applyChanges(R,N.isPrimaryClient,M,z);return a0(N,D.targetId,U.wa),U.snapshot}(t,f,g,v);const s=await Zv(t.localStore,e,!0),o=new vN(e,s.Ts),a=o.ma(s.documents),u=kl.createSynthesizedTargetChangeForCurrentChange(n,r&&t.onlineState!=="Offline",i),c=o.applyChanges(a,t.isPrimaryClient,u);a0(t,n,c.wa);const h=new wN(e,n,o);return t.Fa.set(e,h),t.Ma.has(n)?t.Ma.get(n).push(e):t.Ma.set(n,[e]),c.snapshot}async function CN(t,e,n){const r=le(t),i=r.Fa.get(e),s=r.Ma.get(i.targetId);if(s.length>1)return r.Ma.set(i.targetId,s.filter(o=>!Eh(o,e))),void r.Fa.delete(e);r.isPrimaryClient?(r.sharedClientState.removeLocalQueryTarget(i.targetId),r.sharedClientState.isActiveQueryTarget(i.targetId)||await _p(r.localStore,i.targetId,!1).then(()=>{r.sharedClientState.clearQueryState(i.targetId),n&&ng(r.remoteStore,i.targetId),vp(r,i.targetId)}).catch(Tl)):(vp(r,i.targetId),await _p(r.localStore,i.targetId,!0))}async function RN(t,e){const n=le(t),r=n.Fa.get(e),i=n.Ma.get(r.targetId);n.isPrimaryClient&&i.length===1&&(n.sharedClientState.removeLocalQueryTarget(r.targetId),ng(n.remoteStore,r.targetId))}async function xN(t,e,n){const r=MN(t);try{const i=await function(o,a){const u=le(o),c=ht.now(),h=a.reduce((v,I)=>v.add(I.key),fe());let f,g;return u.persistence.runTransaction("Locally write mutations","readwrite",v=>{let I=Tr(),N=fe();return u.cs.getEntries(v,h).next(D=>{I=D,I.forEach((C,w)=>{w.isValidDocument()||(N=N.add(C))})}).next(()=>u.localDocuments.getOverlayedDocuments(v,I)).next(D=>{f=D;const C=[];for(const w of a){const R=GP(w,f.get(w.key).overlayedDocument);R!=null&&C.push(new ns(w.key,R,gI(R.value.mapValue),Kn.exists(!0)))}return u.mutationQueue.addMutationBatch(v,c,C,a)}).next(D=>{g=D;const C=D.applyToLocalDocumentSet(f,N);return u.documentOverlayCache.saveOverlays(v,D.batchId,C)})}).then(()=>({batchId:g.batchId,changes:xI(f)}))}(r.localStore,e);r.sharedClientState.addPendingMutation(i.batchId),function(o,a,u){let c=o.Ba[o.currentUser.toKey()];c||(c=new ot(Ie)),c=c.insert(a,u),o.Ba[o.currentUser.toKey()]=c}(r,i.batchId,n),await Rl(r,i.changes),await xh(r.remoteStore)}catch(i){const s=ag(i,"Failed to persist write");n.reject(s)}}async function o1(t,e){const n=le(t);try{const r=await j2(n.localStore,e);e.targetChanges.forEach((i,s)=>{const o=n.Na.get(s);o&&(Ae(i.addedDocuments.size+i.modifiedDocuments.size+i.removedDocuments.size<=1),i.addedDocuments.size>0?o.va=!0:i.modifiedDocuments.size>0?Ae(o.va):i.removedDocuments.size>0&&(Ae(o.va),o.va=!1))}),await Rl(n,r,e)}catch(r){await Tl(r)}}function o0(t,e,n){const r=le(t);if(r.isPrimaryClient&&n===0||!r.isPrimaryClient&&n===1){const i=[];r.Fa.forEach((s,o)=>{const a=o.view.Z_(e);a.snapshot&&i.push(a.snapshot)}),function(o,a){const u=le(o);u.onlineState=a;let c=!1;u.queries.forEach((h,f)=>{for(const g of f.j_)g.Z_(a)&&(c=!0)}),c&&lg(u)}(r.eventManager,e),i.length&&r.Ca.d_(i),r.onlineState=e,r.isPrimaryClient&&r.sharedClientState.setOnlineState(e)}}async function AN(t,e,n){const r=le(t);r.sharedClientState.updateQueryState(e,"rejected",n);const i=r.Na.get(e),s=i&&i.key;if(s){let o=new ot(te.comparator);o=o.insert(s,Lt.newNoDocument(s,ae.min()));const a=fe().add(s),u=new kh(ae.min(),new Map,new ot(Ie),o,a);await o1(r,u),r.Oa=r.Oa.remove(s),r.Na.delete(e),ug(r)}else await _p(r.localStore,e,!1).then(()=>vp(r,e,n)).catch(Tl)}async function bN(t,e){const n=le(t),r=e.batch.batchId;try{const i=await U2(n.localStore,e);l1(n,r,null),a1(n,r),n.sharedClientState.updateMutationState(r,"acknowledged"),await Rl(n,i)}catch(i){await Tl(i)}}async function PN(t,e,n){const r=le(t);try{const i=await function(o,a){const u=le(o);return u.persistence.runTransaction("Reject batch","readwrite-primary",c=>{let h;return u.mutationQueue.lookupMutationBatch(c,a).next(f=>(Ae(f!==null),h=f.keys(),u.mutationQueue.removeMutationBatch(c,f))).next(()=>u.mutationQueue.performConsistencyCheck(c)).next(()=>u.documentOverlayCache.removeOverlaysForBatchId(c,h,a)).next(()=>u.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(c,h)).next(()=>u.localDocuments.getDocuments(c,h))})}(r.localStore,e);l1(r,e,n),a1(r,e),r.sharedClientState.updateMutationState(e,"rejected",n),await Rl(r,i)}catch(i){await Tl(i)}}function a1(t,e){(t.ka.get(e)||[]).forEach(n=>{n.resolve()}),t.ka.delete(e)}function l1(t,e,n){const r=le(t);let i=r.Ba[r.currentUser.toKey()];if(i){const s=i.get(e);s&&(n?s.reject(n):s.resolve(),i=i.remove(e)),r.Ba[r.currentUser.toKey()]=i}}function vp(t,e,n=null){t.sharedClientState.removeLocalQueryTarget(e);for(const r of t.Ma.get(e))t.Fa.delete(r),n&&t.Ca.$a(r,n);t.Ma.delete(e),t.isPrimaryClient&&t.La.gr(e).forEach(r=>{t.La.containsKey(r)||u1(t,r)})}function u1(t,e){t.xa.delete(e.path.canonicalString());const n=t.Oa.get(e);n!==null&&(ng(t.remoteStore,n),t.Oa=t.Oa.remove(e),t.Na.delete(n),ug(t))}function a0(t,e,n){for(const r of n)r instanceof r1?(t.La.addReference(r.key,e),NN(t,r)):r instanceof i1?(J("SyncEngine","Document no longer in limbo: "+r.key),t.La.removeReference(r.key,e),t.La.containsKey(r.key)||u1(t,r.key)):se()}function NN(t,e){const n=e.key,r=n.path.canonicalString();t.Oa.get(n)||t.xa.has(r)||(J("SyncEngine","New document in limbo: "+n),t.xa.add(r),ug(t))}function ug(t){for(;t.xa.size>0&&t.Oa.size<t.maxConcurrentLimboResolutions;){const e=t.xa.values().next().value;t.xa.delete(e);const n=new te(je.fromString(e)),r=t.qa.next();t.Na.set(r,new EN(n)),t.Oa=t.Oa.insert(n,r),XI(t.remoteStore,new Hr(Gn(II(n.path)),r,"TargetPurposeLimboResolution",Bm.oe))}}async function Rl(t,e,n){const r=le(t),i=[],s=[],o=[];r.Fa.isEmpty()||(r.Fa.forEach((a,u)=>{o.push(r.Ka(u,e,n).then(c=>{var h;if((c||n)&&r.isPrimaryClient){const f=c?!c.fromCache:(h=n==null?void 0:n.targetChanges.get(u.targetId))===null||h===void 0?void 0:h.current;r.sharedClientState.updateQueryState(u.targetId,f?"current":"not-current")}if(c){i.push(c);const f=tg.Wi(u.targetId,c);s.push(f)}}))}),await Promise.all(o),r.Ca.d_(i),await async function(u,c){const h=le(u);try{await h.persistence.runTransaction("notifyLocalViewChanges","readwrite",f=>j.forEach(c,g=>j.forEach(g.$i,v=>h.persistence.referenceDelegate.addReference(f,g.targetId,v)).next(()=>j.forEach(g.Ui,v=>h.persistence.referenceDelegate.removeReference(f,g.targetId,v)))))}catch(f){if(!Il(f))throw f;J("LocalStore","Failed to update sequence numbers: "+f)}for(const f of c){const g=f.targetId;if(!f.fromCache){const v=h.os.get(g),I=v.snapshotVersion,N=v.withLastLimboFreeSnapshotVersion(I);h.os=h.os.insert(g,N)}}}(r.localStore,s))}async function DN(t,e){const n=le(t);if(!n.currentUser.isEqual(e)){J("SyncEngine","User change. New user:",e.toKey());const r=await GI(n.localStore,e);n.currentUser=e,function(s,o){s.ka.forEach(a=>{a.forEach(u=>{u.reject(new X(V.CANCELLED,o))})}),s.ka.clear()}(n,"'waitForPendingWrites' promise is rejected due to a user change."),n.sharedClientState.handleUserChange(e,r.removedBatchIds,r.addedBatchIds),await Rl(n,r.hs)}}function ON(t,e){const n=le(t),r=n.Na.get(e);if(r&&r.va)return fe().add(r.key);{let i=fe();const s=n.Ma.get(e);if(!s)return i;for(const o of s){const a=n.Fa.get(o);i=i.unionWith(a.view.Va)}return i}}function c1(t){const e=le(t);return e.remoteStore.remoteSyncer.applyRemoteEvent=o1.bind(null,e),e.remoteStore.remoteSyncer.getRemoteKeysForTarget=ON.bind(null,e),e.remoteStore.remoteSyncer.rejectListen=AN.bind(null,e),e.Ca.d_=gN.bind(null,e.eventManager),e.Ca.$a=_N.bind(null,e.eventManager),e}function MN(t){const e=le(t);return e.remoteStore.remoteSyncer.applySuccessfulWrite=bN.bind(null,e),e.remoteStore.remoteSyncer.rejectFailedWrite=PN.bind(null,e),e}class Oc{constructor(){this.kind="memory",this.synchronizeTabs=!1}async initialize(e){this.serializer=Ch(e.databaseInfo.databaseId),this.sharedClientState=this.Wa(e),this.persistence=this.Ga(e),await this.persistence.start(),this.localStore=this.za(e),this.gcScheduler=this.ja(e,this.localStore),this.indexBackfillerScheduler=this.Ha(e,this.localStore)}ja(e,n){return null}Ha(e,n){return null}za(e){return V2(this.persistence,new L2,e.initialUser,this.serializer)}Ga(e){return new D2(eg.Zr,this.serializer)}Wa(e){return new q2}async terminate(){var e,n;(e=this.gcScheduler)===null||e===void 0||e.stop(),(n=this.indexBackfillerScheduler)===null||n===void 0||n.stop(),this.sharedClientState.shutdown(),await this.persistence.shutdown()}}Oc.provider={build:()=>new Oc};class wp{async initialize(e,n){this.localStore||(this.localStore=e.localStore,this.sharedClientState=e.sharedClientState,this.datastore=this.createDatastore(n),this.remoteStore=this.createRemoteStore(n),this.eventManager=this.createEventManager(n),this.syncEngine=this.createSyncEngine(n,!e.synchronizeTabs),this.sharedClientState.onlineStateHandler=r=>o0(this.syncEngine,r,1),this.remoteStore.remoteSyncer.handleCredentialChange=DN.bind(null,this.syncEngine),await hN(this.remoteStore,this.syncEngine.isPrimaryClient))}createEventManager(e){return function(){return new fN}()}createDatastore(e){const n=Ch(e.databaseInfo.databaseId),r=function(s){return new Q2(s)}(e.databaseInfo);return function(s,o,a,u){return new J2(s,o,a,u)}(e.authCredentials,e.appCheckCredentials,r,n)}createRemoteStore(e){return function(r,i,s,o,a){return new eN(r,i,s,o,a)}(this.localStore,this.datastore,e.asyncQueue,n=>o0(this.syncEngine,n,0),function(){return t0.D()?new t0:new H2}())}createSyncEngine(e,n){return function(i,s,o,a,u,c,h){const f=new TN(i,s,o,a,u,c);return h&&(f.Qa=!0),f}(this.localStore,this.remoteStore,this.eventManager,this.sharedClientState,e.initialUser,e.maxConcurrentLimboResolutions,n)}async terminate(){var e,n;await async function(i){const s=le(i);J("RemoteStore","RemoteStore shutting down."),s.L_.add(5),await Cl(s),s.k_.shutdown(),s.q_.set("Unknown")}(this.remoteStore),(e=this.datastore)===null||e===void 0||e.terminate(),(n=this.eventManager)===null||n===void 0||n.terminate()}}wp.provider={build:()=>new wp};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *//**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class LN{constructor(e){this.observer=e,this.muted=!1}next(e){this.muted||this.observer.next&&this.Ya(this.observer.next,e)}error(e){this.muted||(this.observer.error?this.Ya(this.observer.error,e):Er("Uncaught Error in snapshot listener:",e.toString()))}Za(){this.muted=!0}Ya(e,n){setTimeout(()=>{this.muted||e(n)},0)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class FN{constructor(e,n,r,i,s){this.authCredentials=e,this.appCheckCredentials=n,this.asyncQueue=r,this.databaseInfo=i,this.user=Ot.UNAUTHENTICATED,this.clientId=fI.newId(),this.authCredentialListener=()=>Promise.resolve(),this.appCheckCredentialListener=()=>Promise.resolve(),this._uninitializedComponentsProvider=s,this.authCredentials.start(r,async o=>{J("FirestoreClient","Received user=",o.uid),await this.authCredentialListener(o),this.user=o}),this.appCheckCredentials.start(r,o=>(J("FirestoreClient","Received new app check token=",o),this.appCheckCredentialListener(o,this.user)))}get configuration(){return{asyncQueue:this.asyncQueue,databaseInfo:this.databaseInfo,clientId:this.clientId,authCredentials:this.authCredentials,appCheckCredentials:this.appCheckCredentials,initialUser:this.user,maxConcurrentLimboResolutions:100}}setCredentialChangeListener(e){this.authCredentialListener=e}setAppCheckTokenChangeListener(e){this.appCheckCredentialListener=e}terminate(){this.asyncQueue.enterRestrictedMode();const e=new ri;return this.asyncQueue.enqueueAndForgetEvenWhileRestricted(async()=>{try{this._onlineComponents&&await this._onlineComponents.terminate(),this._offlineComponents&&await this._offlineComponents.terminate(),this.authCredentials.shutdown(),this.appCheckCredentials.shutdown(),e.resolve()}catch(n){const r=ag(n,"Failed to shutdown persistence");e.reject(r)}}),e.promise}}async function Bd(t,e){t.asyncQueue.verifyOperationInProgress(),J("FirestoreClient","Initializing OfflineComponentProvider");const n=t.configuration;await e.initialize(n);let r=n.initialUser;t.setCredentialChangeListener(async i=>{r.isEqual(i)||(await GI(e.localStore,i),r=i)}),e.persistence.setDatabaseDeletedListener(()=>t.terminate()),t._offlineComponents=e}async function l0(t,e){t.asyncQueue.verifyOperationInProgress();const n=await VN(t);J("FirestoreClient","Initializing OnlineComponentProvider"),await e.initialize(n,t.configuration),t.setCredentialChangeListener(r=>n0(e.remoteStore,r)),t.setAppCheckTokenChangeListener((r,i)=>n0(e.remoteStore,i)),t._onlineComponents=e}async function VN(t){if(!t._offlineComponents)if(t._uninitializedComponentsProvider){J("FirestoreClient","Using user provided OfflineComponentProvider");try{await Bd(t,t._uninitializedComponentsProvider._offline)}catch(e){const n=e;if(!function(i){return i.name==="FirebaseError"?i.code===V.FAILED_PRECONDITION||i.code===V.UNIMPLEMENTED:!(typeof DOMException<"u"&&i instanceof DOMException)||i.code===22||i.code===20||i.code===11}(n))throw n;io("Error using user provided cache. Falling back to memory cache: "+n),await Bd(t,new Oc)}}else J("FirestoreClient","Using default OfflineComponentProvider"),await Bd(t,new Oc);return t._offlineComponents}async function h1(t){return t._onlineComponents||(t._uninitializedComponentsProvider?(J("FirestoreClient","Using user provided OnlineComponentProvider"),await l0(t,t._uninitializedComponentsProvider._online)):(J("FirestoreClient","Using default OnlineComponentProvider"),await l0(t,new wp))),t._onlineComponents}function UN(t){return h1(t).then(e=>e.syncEngine)}async function jN(t){const e=await h1(t),n=e.eventManager;return n.onListen=IN.bind(null,e.syncEngine),n.onUnlisten=CN.bind(null,e.syncEngine),n.onFirstRemoteStoreListen=SN.bind(null,e.syncEngine),n.onLastRemoteStoreUnlisten=RN.bind(null,e.syncEngine),n}function zN(t,e,n={}){const r=new ri;return t.asyncQueue.enqueueAndForget(async()=>function(s,o,a,u,c){const h=new LN({next:g=>{h.Za(),o.enqueueAndForget(()=>mN(s,f)),g.fromCache&&u.source==="server"?c.reject(new X(V.UNAVAILABLE,'Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to "server" to retrieve the cached documents.)')):c.resolve(g)},error:g=>c.reject(g)}),f=new yN(a,h,{includeMetadataChanges:!0,_a:!0});return pN(s,f)}(await jN(t),t.asyncQueue,e,n,r)),r.promise}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function d1(t){const e={};return t.timeoutSeconds!==void 0&&(e.timeoutSeconds=t.timeoutSeconds),e}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const u0=new Map;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function f1(t,e,n){if(!n)throw new X(V.INVALID_ARGUMENT,`Function ${t}() cannot be called with an empty ${e}.`)}function BN(t,e,n,r){if(e===!0&&r===!0)throw new X(V.INVALID_ARGUMENT,`${t} and ${n} cannot be used together.`)}function c0(t){if(!te.isDocumentKey(t))throw new X(V.INVALID_ARGUMENT,`Invalid document reference. Document references must have an even number of segments, but ${t} has ${t.length}.`)}function h0(t){if(te.isDocumentKey(t))throw new X(V.INVALID_ARGUMENT,`Invalid collection reference. Collection references must have an odd number of segments, but ${t} has ${t.length}.`)}function Ah(t){if(t===void 0)return"undefined";if(t===null)return"null";if(typeof t=="string")return t.length>20&&(t=`${t.substring(0,20)}...`),JSON.stringify(t);if(typeof t=="number"||typeof t=="boolean")return""+t;if(typeof t=="object"){if(t instanceof Array)return"an array";{const e=function(r){return r.constructor?r.constructor.name:null}(t);return e?`a custom ${e} object`:"an object"}}return typeof t=="function"?"a function":se()}function hl(t,e){if("_delegate"in t&&(t=t._delegate),!(t instanceof e)){if(e.name===t.constructor.name)throw new X(V.INVALID_ARGUMENT,"Type does not match the expected instance. Did you pass a reference from a different Firestore SDK?");{const n=Ah(t);throw new X(V.INVALID_ARGUMENT,`Expected type '${e.name}', but it was: ${n}`)}}return t}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class d0{constructor(e){var n,r;if(e.host===void 0){if(e.ssl!==void 0)throw new X(V.INVALID_ARGUMENT,"Can't provide ssl option if host option is not set");this.host="firestore.googleapis.com",this.ssl=!0}else this.host=e.host,this.ssl=(n=e.ssl)===null||n===void 0||n;if(this.credentials=e.credentials,this.ignoreUndefinedProperties=!!e.ignoreUndefinedProperties,this.localCache=e.localCache,e.cacheSizeBytes===void 0)this.cacheSizeBytes=41943040;else{if(e.cacheSizeBytes!==-1&&e.cacheSizeBytes<1048576)throw new X(V.INVALID_ARGUMENT,"cacheSizeBytes must be at least 1048576");this.cacheSizeBytes=e.cacheSizeBytes}BN("experimentalForceLongPolling",e.experimentalForceLongPolling,"experimentalAutoDetectLongPolling",e.experimentalAutoDetectLongPolling),this.experimentalForceLongPolling=!!e.experimentalForceLongPolling,this.experimentalForceLongPolling?this.experimentalAutoDetectLongPolling=!1:e.experimentalAutoDetectLongPolling===void 0?this.experimentalAutoDetectLongPolling=!0:this.experimentalAutoDetectLongPolling=!!e.experimentalAutoDetectLongPolling,this.experimentalLongPollingOptions=d1((r=e.experimentalLongPollingOptions)!==null&&r!==void 0?r:{}),function(s){if(s.timeoutSeconds!==void 0){if(isNaN(s.timeoutSeconds))throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (must not be NaN)`);if(s.timeoutSeconds<5)throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (minimum allowed value is 5)`);if(s.timeoutSeconds>30)throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (maximum allowed value is 30)`)}}(this.experimentalLongPollingOptions),this.useFetchStreams=!!e.useFetchStreams}isEqual(e){return this.host===e.host&&this.ssl===e.ssl&&this.credentials===e.credentials&&this.cacheSizeBytes===e.cacheSizeBytes&&this.experimentalForceLongPolling===e.experimentalForceLongPolling&&this.experimentalAutoDetectLongPolling===e.experimentalAutoDetectLongPolling&&function(r,i){return r.timeoutSeconds===i.timeoutSeconds}(this.experimentalLongPollingOptions,e.experimentalLongPollingOptions)&&this.ignoreUndefinedProperties===e.ignoreUndefinedProperties&&this.useFetchStreams===e.useFetchStreams}}class bh{constructor(e,n,r,i){this._authCredentials=e,this._appCheckCredentials=n,this._databaseId=r,this._app=i,this.type="firestore-lite",this._persistenceKey="(lite)",this._settings=new d0({}),this._settingsFrozen=!1,this._terminateTask="notTerminated"}get app(){if(!this._app)throw new X(V.FAILED_PRECONDITION,"Firestore was not initialized using the Firebase SDK. 'app' is not available");return this._app}get _initialized(){return this._settingsFrozen}get _terminated(){return this._terminateTask!=="notTerminated"}_setSettings(e){if(this._settingsFrozen)throw new X(V.FAILED_PRECONDITION,"Firestore has already been started and its settings can no longer be changed. You can only modify settings before calling any other methods on a Firestore object.");this._settings=new d0(e),e.credentials!==void 0&&(this._authCredentials=function(r){if(!r)return new tP;switch(r.type){case"firstParty":return new sP(r.sessionIndex||"0",r.iamToken||null,r.authTokenFactory||null);case"provider":return r.client;default:throw new X(V.INVALID_ARGUMENT,"makeAuthCredentialsProvider failed due to invalid credential type")}}(e.credentials))}_getSettings(){return this._settings}_freezeSettings(){return this._settingsFrozen=!0,this._settings}_delete(){return this._terminateTask==="notTerminated"&&(this._terminateTask=this._terminate()),this._terminateTask}async _restart(){this._terminateTask==="notTerminated"?await this._terminate():this._terminateTask="notTerminated"}toJSON(){return{app:this._app,databaseId:this._databaseId,settings:this._settings}}_terminate(){return function(n){const r=u0.get(n);r&&(J("ComponentProvider","Removing Datastore"),u0.delete(n),r.terminate())}(this),Promise.resolve()}}function $N(t,e,n,r={}){var i;const s=(t=hl(t,bh))._getSettings(),o=`${e}:${n}`;if(s.host!=="firestore.googleapis.com"&&s.host!==o&&io("Host has been set in both settings() and connectFirestoreEmulator(), emulator host will be used."),t._setSettings(Object.assign(Object.assign({},s),{host:o,ssl:!1})),r.mockUserToken){let a,u;if(typeof r.mockUserToken=="string")a=r.mockUserToken,u=Ot.MOCK_USER;else{a=Fm(r.mockUserToken,(i=t._app)===null||i===void 0?void 0:i.options.projectId);const c=r.mockUserToken.sub||r.mockUserToken.user_id;if(!c)throw new X(V.INVALID_ARGUMENT,"mockUserToken must contain 'sub' or 'user_id' field!");u=new Ot(c)}t._authCredentials=new nP(new dI(a,u))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class is{constructor(e,n,r){this.converter=n,this._query=r,this.type="query",this.firestore=e}withConverter(e){return new is(this.firestore,e,this._query)}}class In{constructor(e,n,r){this.converter=n,this._key=r,this.type="document",this.firestore=e}get _path(){return this._key.path}get id(){return this._key.path.lastSegment()}get path(){return this._key.path.canonicalString()}get parent(){return new si(this.firestore,this.converter,this._key.path.popLast())}withConverter(e){return new In(this.firestore,e,this._key)}}class si extends is{constructor(e,n,r){super(e,n,II(r)),this._path=r,this.type="collection"}get id(){return this._query.path.lastSegment()}get path(){return this._query.path.canonicalString()}get parent(){const e=this._path.popLast();return e.isEmpty()?null:new In(this.firestore,null,new te(e))}withConverter(e){return new si(this.firestore,e,this._path)}}function $d(t,e,...n){if(t=Xe(t),f1("collection","path",e),t instanceof bh){const r=je.fromString(e,...n);return h0(r),new si(t,null,r)}{if(!(t instanceof In||t instanceof si))throw new X(V.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(je.fromString(e,...n));return h0(r),new si(t.firestore,null,r)}}function p1(t,e,...n){if(t=Xe(t),arguments.length===1&&(e=fI.newId()),f1("doc","path",e),t instanceof bh){const r=je.fromString(e,...n);return c0(r),new In(t,null,new te(r))}{if(!(t instanceof In||t instanceof si))throw new X(V.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(je.fromString(e,...n));return c0(r),new In(t.firestore,t instanceof si?t.converter:null,new te(r))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class f0{constructor(e=Promise.resolve()){this.Pu=[],this.Iu=!1,this.Tu=[],this.Eu=null,this.du=!1,this.Au=!1,this.Ru=[],this.t_=new QI(this,"async_queue_retry"),this.Vu=()=>{const r=zd();r&&J("AsyncQueue","Visibility state changed to "+r.visibilityState),this.t_.jo()},this.mu=e;const n=zd();n&&typeof n.addEventListener=="function"&&n.addEventListener("visibilitychange",this.Vu)}get isShuttingDown(){return this.Iu}enqueueAndForget(e){this.enqueue(e)}enqueueAndForgetEvenWhileRestricted(e){this.fu(),this.gu(e)}enterRestrictedMode(e){if(!this.Iu){this.Iu=!0,this.Au=e||!1;const n=zd();n&&typeof n.removeEventListener=="function"&&n.removeEventListener("visibilitychange",this.Vu)}}enqueue(e){if(this.fu(),this.Iu)return new Promise(()=>{});const n=new ri;return this.gu(()=>this.Iu&&this.Au?Promise.resolve():(e().then(n.resolve,n.reject),n.promise)).then(()=>n.promise)}enqueueRetryable(e){this.enqueueAndForget(()=>(this.Pu.push(e),this.pu()))}async pu(){if(this.Pu.length!==0){try{await this.Pu[0](),this.Pu.shift(),this.t_.reset()}catch(e){if(!Il(e))throw e;J("AsyncQueue","Operation failed with retryable error: "+e)}this.Pu.length>0&&this.t_.Go(()=>this.pu())}}gu(e){const n=this.mu.then(()=>(this.du=!0,e().catch(r=>{this.Eu=r,this.du=!1;const i=function(o){let a=o.message||"";return o.stack&&(a=o.stack.includes(o.message)?o.stack:o.message+`
`+o.stack),a}(r);throw Er("INTERNAL UNHANDLED ERROR: ",i),r}).then(r=>(this.du=!1,r))));return this.mu=n,n}enqueueAfterDelay(e,n,r){this.fu(),this.Ru.indexOf(e)>-1&&(n=0);const i=og.createAndSchedule(this,e,n,r,s=>this.yu(s));return this.Tu.push(i),i}fu(){this.Eu&&se()}verifyOperationInProgress(){}async wu(){let e;do e=this.mu,await e;while(e!==this.mu)}Su(e){for(const n of this.Tu)if(n.timerId===e)return!0;return!1}bu(e){return this.wu().then(()=>{this.Tu.sort((n,r)=>n.targetTimeMs-r.targetTimeMs);for(const n of this.Tu)if(n.skipDelay(),e!=="all"&&n.timerId===e)break;return this.wu()})}Du(e){this.Ru.push(e)}yu(e){const n=this.Tu.indexOf(e);this.Tu.splice(n,1)}}class Ph extends bh{constructor(e,n,r,i){super(e,n,r,i),this.type="firestore",this._queue=new f0,this._persistenceKey=(i==null?void 0:i.name)||"[DEFAULT]"}async _terminate(){if(this._firestoreClient){const e=this._firestoreClient.terminate();this._queue=new f0(e),this._firestoreClient=void 0,await e}}}function WN(t,e){const n=typeof t=="object"?t:vh(),r=typeof t=="string"?t:"(default)",i=El(n,"firestore").getImmediate({identifier:r});if(!i._initialized){const s=Lm("firestore");s&&$N(i,...s)}return i}function m1(t){if(t._terminated)throw new X(V.FAILED_PRECONDITION,"The client has already been terminated.");return t._firestoreClient||qN(t),t._firestoreClient}function qN(t){var e,n,r;const i=t._freezeSettings(),s=function(a,u,c,h){return new yP(a,u,c,h.host,h.ssl,h.experimentalForceLongPolling,h.experimentalAutoDetectLongPolling,d1(h.experimentalLongPollingOptions),h.useFetchStreams)}(t._databaseId,((e=t._app)===null||e===void 0?void 0:e.options.appId)||"",t._persistenceKey,i);t._componentsProvider||!((n=i.localCache)===null||n===void 0)&&n._offlineComponentProvider&&(!((r=i.localCache)===null||r===void 0)&&r._onlineComponentProvider)&&(t._componentsProvider={_offline:i.localCache._offlineComponentProvider,_online:i.localCache._onlineComponentProvider}),t._firestoreClient=new FN(t._authCredentials,t._appCheckCredentials,t._queue,s,t._componentsProvider&&function(a){const u=a==null?void 0:a._online.build();return{_offline:a==null?void 0:a._offline.build(u),_online:u}}(t._componentsProvider))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class co{constructor(e){this._byteString=e}static fromBase64String(e){try{return new co(Ct.fromBase64String(e))}catch(n){throw new X(V.INVALID_ARGUMENT,"Failed to construct data from Base64 string: "+n)}}static fromUint8Array(e){return new co(Ct.fromUint8Array(e))}toBase64(){return this._byteString.toBase64()}toUint8Array(){return this._byteString.toUint8Array()}toString(){return"Bytes(base64: "+this.toBase64()+")"}isEqual(e){return this._byteString.isEqual(e._byteString)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class cg{constructor(...e){for(let n=0;n<e.length;++n)if(e[n].length===0)throw new X(V.INVALID_ARGUMENT,"Invalid field name at argument $(i + 1). Field names must not be empty.");this._internalPath=new Tt(e)}isEqual(e){return this._internalPath.isEqual(e._internalPath)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class hg{constructor(e){this._methodName=e}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dg{constructor(e,n){if(!isFinite(e)||e<-90||e>90)throw new X(V.INVALID_ARGUMENT,"Latitude must be a number between -90 and 90, but was: "+e);if(!isFinite(n)||n<-180||n>180)throw new X(V.INVALID_ARGUMENT,"Longitude must be a number between -180 and 180, but was: "+n);this._lat=e,this._long=n}get latitude(){return this._lat}get longitude(){return this._long}isEqual(e){return this._lat===e._lat&&this._long===e._long}toJSON(){return{latitude:this._lat,longitude:this._long}}_compareTo(e){return Ie(this._lat,e._lat)||Ie(this._long,e._long)}}/**
 * @license
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fg{constructor(e){this._values=(e||[]).map(n=>n)}toArray(){return this._values.map(e=>e)}isEqual(e){return function(r,i){if(r.length!==i.length)return!1;for(let s=0;s<r.length;++s)if(r[s]!==i[s])return!1;return!0}(this._values,e._values)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const HN=/^__.*__$/;class GN{constructor(e,n,r){this.data=e,this.fieldMask=n,this.fieldTransforms=r}toMutation(e,n){return this.fieldMask!==null?new ns(e,this.data,this.fieldMask,n,this.fieldTransforms):new Sl(e,this.data,n,this.fieldTransforms)}}function g1(t){switch(t){case 0:case 2:case 1:return!0;case 3:case 4:return!1;default:throw se()}}class pg{constructor(e,n,r,i,s,o){this.settings=e,this.databaseId=n,this.serializer=r,this.ignoreUndefinedProperties=i,s===void 0&&this.vu(),this.fieldTransforms=s||[],this.fieldMask=o||[]}get path(){return this.settings.path}get Cu(){return this.settings.Cu}Fu(e){return new pg(Object.assign(Object.assign({},this.settings),e),this.databaseId,this.serializer,this.ignoreUndefinedProperties,this.fieldTransforms,this.fieldMask)}Mu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.Ou(e),i}Nu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.vu(),i}Lu(e){return this.Fu({path:void 0,xu:!0})}Bu(e){return Mc(e,this.settings.methodName,this.settings.ku||!1,this.path,this.settings.qu)}contains(e){return this.fieldMask.find(n=>e.isPrefixOf(n))!==void 0||this.fieldTransforms.find(n=>e.isPrefixOf(n.field))!==void 0}vu(){if(this.path)for(let e=0;e<this.path.length;e++)this.Ou(this.path.get(e))}Ou(e){if(e.length===0)throw this.Bu("Document fields must not be empty");if(g1(this.Cu)&&HN.test(e))throw this.Bu('Document fields cannot begin and end with "__"')}}class KN{constructor(e,n,r){this.databaseId=e,this.ignoreUndefinedProperties=n,this.serializer=r||Ch(e)}Qu(e,n,r,i=!1){return new pg({Cu:e,methodName:n,qu:r,path:Tt.emptyPath(),xu:!1,ku:i},this.databaseId,this.serializer,this.ignoreUndefinedProperties)}}function _1(t){const e=t._freezeSettings(),n=Ch(t._databaseId);return new KN(t._databaseId,!!e.ignoreUndefinedProperties,n)}function QN(t,e,n,r,i,s={}){const o=t.Qu(s.merge||s.mergeFields?2:0,e,n,i);w1("Data must be an object, but it was:",o,r);const a=y1(r,o);let u,c;if(s.merge)u=new Dn(o.fieldMask),c=o.fieldTransforms;else if(s.mergeFields){const h=[];for(const f of s.mergeFields){const g=XN(e,f,n);if(!o.contains(g))throw new X(V.INVALID_ARGUMENT,`Field '${g}' is specified in your field mask but missing from your input data.`);ZN(h,g)||h.push(g)}u=new Dn(h),c=o.fieldTransforms.filter(f=>u.covers(f.field))}else u=null,c=o.fieldTransforms;return new GN(new gn(a),u,c)}class mg extends hg{_toFieldTransform(e){return new $P(e.path,new ll)}isEqual(e){return e instanceof mg}}function YN(t,e,n,r=!1){return gg(n,t.Qu(r?4:3,e))}function gg(t,e){if(v1(t=Xe(t)))return w1("Unsupported field value:",e,t),y1(t,e);if(t instanceof hg)return function(r,i){if(!g1(i.Cu))throw i.Bu(`${r._methodName}() can only be used with update() and set()`);if(!i.path)throw i.Bu(`${r._methodName}() is not currently supported inside arrays`);const s=r._toFieldTransform(i);s&&i.fieldTransforms.push(s)}(t,e),null;if(t===void 0&&e.ignoreUndefinedProperties)return null;if(e.path&&e.fieldMask.push(e.path),t instanceof Array){if(e.settings.xu&&e.Cu!==4)throw e.Bu("Nested arrays are not supported");return function(r,i){const s=[];let o=0;for(const a of r){let u=gg(a,i.Lu(o));u==null&&(u={nullValue:"NULL_VALUE"}),s.push(u),o++}return{arrayValue:{values:s}}}(t,e)}return function(r,i){if((r=Xe(r))===null)return{nullValue:"NULL_VALUE"};if(typeof r=="number")return jP(i.serializer,r);if(typeof r=="boolean")return{booleanValue:r};if(typeof r=="string")return{stringValue:r};if(r instanceof Date){const s=ht.fromDate(r);return{timestampValue:Nc(i.serializer,s)}}if(r instanceof ht){const s=new ht(r.seconds,1e3*Math.floor(r.nanoseconds/1e3));return{timestampValue:Nc(i.serializer,s)}}if(r instanceof dg)return{geoPointValue:{latitude:r.latitude,longitude:r.longitude}};if(r instanceof co)return{bytesValue:jI(i.serializer,r._byteString)};if(r instanceof In){const s=i.databaseId,o=r.firestore._databaseId;if(!o.isEqual(s))throw i.Bu(`Document reference is for database ${o.projectId}/${o.database} but should be for database ${s.projectId}/${s.database}`);return{referenceValue:Jm(r.firestore._databaseId||i.databaseId,r._key.path)}}if(r instanceof fg)return function(o,a){return{mapValue:{fields:{__type__:{stringValue:"__vector__"},value:{arrayValue:{values:o.toArray().map(u=>{if(typeof u!="number")throw a.Bu("VectorValues must only contain numeric values.");return Km(a.serializer,u)})}}}}}}(r,i);throw i.Bu(`Unsupported field value: ${Ah(r)}`)}(t,e)}function y1(t,e){const n={};return pI(t)?e.path&&e.path.length>0&&e.fieldMask.push(e.path):wo(t,(r,i)=>{const s=gg(i,e.Mu(r));s!=null&&(n[r]=s)}),{mapValue:{fields:n}}}function v1(t){return!(typeof t!="object"||t===null||t instanceof Array||t instanceof Date||t instanceof ht||t instanceof dg||t instanceof co||t instanceof In||t instanceof hg||t instanceof fg)}function w1(t,e,n){if(!v1(n)||!function(i){return typeof i=="object"&&i!==null&&(Object.getPrototypeOf(i)===Object.prototype||Object.getPrototypeOf(i)===null)}(n)){const r=Ah(n);throw r==="an object"?e.Bu(t+" a custom object"):e.Bu(t+" "+r)}}function XN(t,e,n){if((e=Xe(e))instanceof cg)return e._internalPath;if(typeof e=="string")return E1(t,e);throw Mc("Field path arguments must be of type string or ",t,!1,void 0,n)}const JN=new RegExp("[~\\*/\\[\\]]");function E1(t,e,n){if(e.search(JN)>=0)throw Mc(`Invalid field path (${e}). Paths must not contain '~', '*', '/', '[', or ']'`,t,!1,void 0,n);try{return new cg(...e.split("."))._internalPath}catch{throw Mc(`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`,t,!1,void 0,n)}}function Mc(t,e,n,r,i){const s=r&&!r.isEmpty(),o=i!==void 0;let a=`Function ${e}() called with invalid data`;n&&(a+=" (via `toFirestore()`)"),a+=". ";let u="";return(s||o)&&(u+=" (found",s&&(u+=` in field ${r}`),o&&(u+=` in document ${i}`),u+=")"),new X(V.INVALID_ARGUMENT,a+t+u)}function ZN(t,e){return t.some(n=>n.isEqual(e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class T1{constructor(e,n,r,i,s){this._firestore=e,this._userDataWriter=n,this._key=r,this._document=i,this._converter=s}get id(){return this._key.path.lastSegment()}get ref(){return new In(this._firestore,this._converter,this._key)}exists(){return this._document!==null}data(){if(this._document){if(this._converter){const e=new eD(this._firestore,this._userDataWriter,this._key,this._document,null);return this._converter.fromFirestore(e)}return this._userDataWriter.convertValue(this._document.data.value)}}get(e){if(this._document){const n=this._document.data.field(_g("DocumentSnapshot.get",e));if(n!==null)return this._userDataWriter.convertValue(n)}}}class eD extends T1{data(){return super.data()}}function _g(t,e){return typeof e=="string"?E1(t,e):e instanceof cg?e._internalPath:e._delegate._internalPath}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function tD(t){if(t.limitType==="L"&&t.explicitOrderBy.length===0)throw new X(V.UNIMPLEMENTED,"limitToLast() queries require specifying at least one orderBy() clause")}class yg{}class I1 extends yg{}function nD(t,e,...n){let r=[];e instanceof yg&&r.push(e),r=r.concat(n),function(s){const o=s.filter(u=>u instanceof wg).length,a=s.filter(u=>u instanceof vg).length;if(o>1||o>0&&a>0)throw new X(V.INVALID_ARGUMENT,"InvalidQuery. When using composite filters, you cannot use more than one filter at the top level. Consider nesting the multiple filters within an `and(...)` statement. For example: change `query(query, where(...), or(...))` to `query(query, and(where(...), or(...)))`.")}(r);for(const i of r)t=i._apply(t);return t}class vg extends I1{constructor(e,n,r){super(),this._field=e,this._op=n,this._value=r,this.type="where"}static _create(e,n,r){return new vg(e,n,r)}_apply(e){const n=this._parse(e);return S1(e._query,n),new is(e.firestore,e.converter,hp(e._query,n))}_parse(e){const n=_1(e.firestore);return function(s,o,a,u,c,h,f){let g;if(c.isKeyField()){if(h==="array-contains"||h==="array-contains-any")throw new X(V.INVALID_ARGUMENT,`Invalid Query. You can't perform '${h}' queries on documentId().`);if(h==="in"||h==="not-in"){m0(f,h);const v=[];for(const I of f)v.push(p0(u,s,I));g={arrayValue:{values:v}}}else g=p0(u,s,f)}else h!=="in"&&h!=="not-in"&&h!=="array-contains-any"||m0(f,h),g=YN(a,o,f,h==="in"||h==="not-in");return st.create(c,h,g)}(e._query,"where",n,e.firestore._databaseId,this._field,this._op,this._value)}}class wg extends yg{constructor(e,n){super(),this.type=e,this._queryConstraints=n}static _create(e,n){return new wg(e,n)}_parse(e){const n=this._queryConstraints.map(r=>r._parse(e)).filter(r=>r.getFilters().length>0);return n.length===1?n[0]:Un.create(n,this._getOperator())}_apply(e){const n=this._parse(e);return n.getFilters().length===0?e:(function(i,s){let o=i;const a=s.getFlattenedFilters();for(const u of a)S1(o,u),o=hp(o,u)}(e._query,n),new is(e.firestore,e.converter,hp(e._query,n)))}_getQueryConstraints(){return this._queryConstraints}_getOperator(){return this.type==="and"?"and":"or"}}class Eg extends I1{constructor(e,n){super(),this._field=e,this._direction=n,this.type="orderBy"}static _create(e,n){return new Eg(e,n)}_apply(e){const n=function(i,s,o){if(i.startAt!==null)throw new X(V.INVALID_ARGUMENT,"Invalid query. You must not call startAt() or startAfter() before calling orderBy().");if(i.endAt!==null)throw new X(V.INVALID_ARGUMENT,"Invalid query. You must not call endAt() or endBefore() before calling orderBy().");return new al(s,o)}(e._query,this._field,this._direction);return new is(e.firestore,e.converter,function(i,s){const o=i.explicitOrderBy.concat([s]);return new Eo(i.path,i.collectionGroup,o,i.filters.slice(),i.limit,i.limitType,i.startAt,i.endAt)}(e._query,n))}}function rD(t,e="asc"){const n=e,r=_g("orderBy",t);return Eg._create(r,n)}function p0(t,e,n){if(typeof(n=Xe(n))=="string"){if(n==="")throw new X(V.INVALID_ARGUMENT,"Invalid query. When querying with documentId(), you must provide a valid document ID, but it was an empty string.");if(!SI(e)&&n.indexOf("/")!==-1)throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying a collection by documentId(), you must provide a plain document ID, but '${n}' contains a '/' character.`);const r=e.path.child(je.fromString(n));if(!te.isDocumentKey(r))throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying a collection group by documentId(), the value provided must result in a valid document path, but '${r}' is not because it has an odd number of segments (${r.length}).`);return Lv(t,new te(r))}if(n instanceof In)return Lv(t,n._key);throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying with documentId(), you must provide a valid string or a DocumentReference, but it was: ${Ah(n)}.`)}function m0(t,e){if(!Array.isArray(t)||t.length===0)throw new X(V.INVALID_ARGUMENT,`Invalid Query. A non-empty array is required for '${e.toString()}' filters.`)}function S1(t,e){const n=function(i,s){for(const o of i)for(const a of o.getFlattenedFilters())if(s.indexOf(a.op)>=0)return a.op;return null}(t.filters,function(i){switch(i){case"!=":return["!=","not-in"];case"array-contains-any":case"in":return["not-in"];case"not-in":return["array-contains-any","in","not-in","!="];default:return[]}}(e.op));if(n!==null)throw n===e.op?new X(V.INVALID_ARGUMENT,`Invalid query. You cannot use more than one '${e.op.toString()}' filter.`):new X(V.INVALID_ARGUMENT,`Invalid query. You cannot use '${e.op.toString()}' filters with '${n.toString()}' filters.`)}class iD{convertValue(e,n="none"){switch(Gi(e)){case 0:return null;case 1:return e.booleanValue;case 2:return et(e.integerValue||e.doubleValue);case 3:return this.convertTimestamp(e.timestampValue);case 4:return this.convertServerTimestamp(e,n);case 5:return e.stringValue;case 6:return this.convertBytes(Hi(e.bytesValue));case 7:return this.convertReference(e.referenceValue);case 8:return this.convertGeoPoint(e.geoPointValue);case 9:return this.convertArray(e.arrayValue,n);case 11:return this.convertObject(e.mapValue,n);case 10:return this.convertVectorValue(e.mapValue);default:throw se()}}convertObject(e,n){return this.convertObjectMap(e.fields,n)}convertObjectMap(e,n="none"){const r={};return wo(e,(i,s)=>{r[i]=this.convertValue(s,n)}),r}convertVectorValue(e){var n,r,i;const s=(i=(r=(n=e.fields)===null||n===void 0?void 0:n.value.arrayValue)===null||r===void 0?void 0:r.values)===null||i===void 0?void 0:i.map(o=>et(o.doubleValue));return new fg(s)}convertGeoPoint(e){return new dg(et(e.latitude),et(e.longitude))}convertArray(e,n){return(e.values||[]).map(r=>this.convertValue(r,n))}convertServerTimestamp(e,n){switch(n){case"previous":const r=Wm(e);return r==null?null:this.convertValue(r,n);case"estimate":return this.convertTimestamp(il(e));default:return null}}convertTimestamp(e){const n=di(e);return new ht(n.seconds,n.nanos)}convertDocumentKey(e,n){const r=je.fromString(e);Ae(HI(r));const i=new sl(r.get(1),r.get(3)),s=new te(r.popFirst(5));return i.isEqual(n)||Er(`Document ${s} contains a document reference within a different database (${i.projectId}/${i.database}) which is not supported. It will be treated as a reference in the current database (${n.projectId}/${n.database}) instead.`),s}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function sD(t,e,n){let r;return r=t?t.toFirestore(e):e,r}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Tu{constructor(e,n){this.hasPendingWrites=e,this.fromCache=n}isEqual(e){return this.hasPendingWrites===e.hasPendingWrites&&this.fromCache===e.fromCache}}class oD extends T1{constructor(e,n,r,i,s,o){super(e,n,r,i,o),this._firestore=e,this._firestoreImpl=e,this.metadata=s}exists(){return super.exists()}data(e={}){if(this._document){if(this._converter){const n=new Gu(this._firestore,this._userDataWriter,this._key,this._document,this.metadata,null);return this._converter.fromFirestore(n,e)}return this._userDataWriter.convertValue(this._document.data.value,e.serverTimestamps)}}get(e,n={}){if(this._document){const r=this._document.data.field(_g("DocumentSnapshot.get",e));if(r!==null)return this._userDataWriter.convertValue(r,n.serverTimestamps)}}}class Gu extends oD{data(e={}){return super.data(e)}}class aD{constructor(e,n,r,i){this._firestore=e,this._userDataWriter=n,this._snapshot=i,this.metadata=new Tu(i.hasPendingWrites,i.fromCache),this.query=r}get docs(){const e=[];return this.forEach(n=>e.push(n)),e}get size(){return this._snapshot.docs.size}get empty(){return this.size===0}forEach(e,n){this._snapshot.docs.forEach(r=>{e.call(n,new Gu(this._firestore,this._userDataWriter,r.key,r,new Tu(this._snapshot.mutatedKeys.has(r.key),this._snapshot.fromCache),this.query.converter))})}docChanges(e={}){const n=!!e.includeMetadataChanges;if(n&&this._snapshot.excludesMetadataChanges)throw new X(V.INVALID_ARGUMENT,"To include metadata changes with your document changes, you must also pass { includeMetadataChanges:true } to onSnapshot().");return this._cachedChanges&&this._cachedChangesIncludeMetadataChanges===n||(this._cachedChanges=function(i,s){if(i._snapshot.oldDocs.isEmpty()){let o=0;return i._snapshot.docChanges.map(a=>{const u=new Gu(i._firestore,i._userDataWriter,a.doc.key,a.doc,new Tu(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);return a.doc,{type:"added",doc:u,oldIndex:-1,newIndex:o++}})}{let o=i._snapshot.oldDocs;return i._snapshot.docChanges.filter(a=>s||a.type!==3).map(a=>{const u=new Gu(i._firestore,i._userDataWriter,a.doc.key,a.doc,new Tu(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);let c=-1,h=-1;return a.type!==0&&(c=o.indexOf(a.doc.key),o=o.delete(a.doc.key)),a.type!==1&&(o=o.add(a.doc),h=o.indexOf(a.doc.key)),{type:lD(a.type),doc:u,oldIndex:c,newIndex:h}})}}(this,n),this._cachedChangesIncludeMetadataChanges=n),this._cachedChanges}}function lD(t){switch(t){case 0:return"added";case 2:case 3:return"modified";case 1:return"removed";default:return se()}}class uD extends iD{constructor(e){super(),this.firestore=e}convertBytes(e){return new co(e)}convertReference(e){const n=this.convertDocumentKey(e,this.firestore._databaseId);return new In(this.firestore,null,n)}}function g0(t){t=hl(t,is);const e=hl(t.firestore,Ph),n=m1(e),r=new uD(e);return tD(t._query),zN(n,t._query).then(i=>new aD(e,r,t,i))}function cD(t){return k1(hl(t.firestore,Ph),[new Qm(t._key,Kn.none())])}function hD(t,e){const n=hl(t.firestore,Ph),r=p1(t),i=sD(t.converter,e);return k1(n,[QN(_1(t.firestore),"addDoc",r._key,i,t.converter!==null,{}).toMutation(r._key,Kn.exists(!1))]).then(()=>r)}function k1(t,e){return function(r,i){const s=new ri;return r.asyncQueue.enqueueAndForget(async()=>xN(await UN(r),i,s)),s.promise}(m1(t),e)}function dD(){return new mg("serverTimestamp")}(function(e,n=!0){(function(i){vo=i})(vi),ci(new vr("firestore",(r,{instanceIdentifier:i,options:s})=>{const o=r.getProvider("app").getImmediate(),a=new Ph(new rP(r.getProvider("auth-internal")),new aP(r.getProvider("app-check-internal")),function(c,h){if(!Object.prototype.hasOwnProperty.apply(c.options,["projectId"]))throw new X(V.INVALID_ARGUMENT,'"projectId" not provided in firebase.initializeApp.');return new sl(c.options.projectId,h)}(o,i),o);return s=Object.assign({useFetchStreams:n},s),a._setSettings(s),a},"PUBLIC").setMultipleInstances(!0)),Tn(Pv,"4.7.3",e),Tn(Pv,"4.7.3","esm2017")})();/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const C1="firebasestorage.googleapis.com",R1="storageBucket",fD=2*60*1e3,pD=10*60*1e3,mD=1e3;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ke extends Zn{constructor(e,n,r=0){super(Wd(e),`Firebase Storage: ${n} (${Wd(e)})`),this.status_=r,this.customData={serverResponse:null},this._baseMessage=this.message,Object.setPrototypeOf(this,Ke.prototype)}get status(){return this.status_}set status(e){this.status_=e}_codeEquals(e){return Wd(e)===this.code}get serverResponse(){return this.customData.serverResponse}set serverResponse(e){this.customData.serverResponse=e,this.customData.serverResponse?this.message=`${this._baseMessage}
${this.customData.serverResponse}`:this.message=this._baseMessage}}var Be;(function(t){t.UNKNOWN="unknown",t.OBJECT_NOT_FOUND="object-not-found",t.BUCKET_NOT_FOUND="bucket-not-found",t.PROJECT_NOT_FOUND="project-not-found",t.QUOTA_EXCEEDED="quota-exceeded",t.UNAUTHENTICATED="unauthenticated",t.UNAUTHORIZED="unauthorized",t.UNAUTHORIZED_APP="unauthorized-app",t.RETRY_LIMIT_EXCEEDED="retry-limit-exceeded",t.INVALID_CHECKSUM="invalid-checksum",t.CANCELED="canceled",t.INVALID_EVENT_NAME="invalid-event-name",t.INVALID_URL="invalid-url",t.INVALID_DEFAULT_BUCKET="invalid-default-bucket",t.NO_DEFAULT_BUCKET="no-default-bucket",t.CANNOT_SLICE_BLOB="cannot-slice-blob",t.SERVER_FILE_WRONG_SIZE="server-file-wrong-size",t.NO_DOWNLOAD_URL="no-download-url",t.INVALID_ARGUMENT="invalid-argument",t.INVALID_ARGUMENT_COUNT="invalid-argument-count",t.APP_DELETED="app-deleted",t.INVALID_ROOT_OPERATION="invalid-root-operation",t.INVALID_FORMAT="invalid-format",t.INTERNAL_ERROR="internal-error",t.UNSUPPORTED_ENVIRONMENT="unsupported-environment"})(Be||(Be={}));function Wd(t){return"storage/"+t}function Tg(){const t="An unknown error occurred, please check the error payload for server response.";return new Ke(Be.UNKNOWN,t)}function gD(t){return new Ke(Be.OBJECT_NOT_FOUND,"Object '"+t+"' does not exist.")}function _D(t){return new Ke(Be.QUOTA_EXCEEDED,"Quota for bucket '"+t+"' exceeded, please view quota on https://firebase.google.com/pricing/.")}function yD(){const t="User is not authenticated, please authenticate using Firebase Authentication and try again.";return new Ke(Be.UNAUTHENTICATED,t)}function vD(){return new Ke(Be.UNAUTHORIZED_APP,"This app does not have permission to access Firebase Storage on this project.")}function wD(t){return new Ke(Be.UNAUTHORIZED,"User does not have permission to access '"+t+"'.")}function x1(){return new Ke(Be.RETRY_LIMIT_EXCEEDED,"Max retry time for operation exceeded, please try again.")}function A1(){return new Ke(Be.CANCELED,"User canceled the upload/download.")}function ED(t){return new Ke(Be.INVALID_URL,"Invalid URL '"+t+"'.")}function TD(t){return new Ke(Be.INVALID_DEFAULT_BUCKET,"Invalid default bucket '"+t+"'.")}function ID(){return new Ke(Be.NO_DEFAULT_BUCKET,"No default bucket found. Did you set the '"+R1+"' property when initializing the app?")}function b1(){return new Ke(Be.CANNOT_SLICE_BLOB,"Cannot slice blob for upload. Please retry the upload.")}function SD(){return new Ke(Be.SERVER_FILE_WRONG_SIZE,"Server recorded incorrect upload file size, please retry the upload.")}function kD(){return new Ke(Be.NO_DOWNLOAD_URL,"The given file does not have any download URLs.")}function CD(t){return new Ke(Be.UNSUPPORTED_ENVIRONMENT,`${t} is missing. Make sure to install the required polyfills. See https://firebase.google.com/docs/web/environments-js-sdk#polyfills for more information.`)}function Ep(t){return new Ke(Be.INVALID_ARGUMENT,t)}function P1(){return new Ke(Be.APP_DELETED,"The Firebase app was deleted.")}function RD(t){return new Ke(Be.INVALID_ROOT_OPERATION,"The operation '"+t+"' cannot be performed on a root reference, create a non-root reference using child, such as .child('file.png').")}function xa(t,e){return new Ke(Be.INVALID_FORMAT,"String does not match format '"+t+"': "+e)}function ea(t){throw new Ke(Be.INTERNAL_ERROR,"Internal error: "+t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ln{constructor(e,n){this.bucket=e,this.path_=n}get path(){return this.path_}get isRoot(){return this.path.length===0}fullServerUrl(){const e=encodeURIComponent;return"/b/"+e(this.bucket)+"/o/"+e(this.path)}bucketOnlyServerUrl(){return"/b/"+encodeURIComponent(this.bucket)+"/o"}static makeFromBucketSpec(e,n){let r;try{r=ln.makeFromUrl(e,n)}catch{return new ln(e,"")}if(r.path==="")return r;throw TD(e)}static makeFromUrl(e,n){let r=null;const i="([A-Za-z0-9.\\-_]+)";function s(M){M.path.charAt(M.path.length-1)==="/"&&(M.path_=M.path_.slice(0,-1))}const o="(/(.*))?$",a=new RegExp("^gs://"+i+o,"i"),u={bucket:1,path:3};function c(M){M.path_=decodeURIComponent(M.path)}const h="v[A-Za-z0-9_]+",f=n.replace(/[.]/g,"\\."),g="(/([^?#]*).*)?$",v=new RegExp(`^https?://${f}/${h}/b/${i}/o${g}`,"i"),I={bucket:1,path:3},N=n===C1?"(?:storage.googleapis.com|storage.cloud.google.com)":n,D="([^?#]*)",C=new RegExp(`^https?://${N}/${i}/${D}`,"i"),R=[{regex:a,indices:u,postModify:s},{regex:v,indices:I,postModify:c},{regex:C,indices:{bucket:1,path:2},postModify:c}];for(let M=0;M<R.length;M++){const z=R[M],U=z.regex.exec(e);if(U){const E=U[z.indices.bucket];let y=U[z.indices.path];y||(y=""),r=new ln(E,y),z.postModify(r);break}}if(r==null)throw ED(e);return r}}class xD{constructor(e){this.promise_=Promise.reject(e)}getPromise(){return this.promise_}cancel(e=!1){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function AD(t,e,n){let r=1,i=null,s=null,o=!1,a=0;function u(){return a===2}let c=!1;function h(...D){c||(c=!0,e.apply(null,D))}function f(D){i=setTimeout(()=>{i=null,t(v,u())},D)}function g(){s&&clearTimeout(s)}function v(D,...C){if(c){g();return}if(D){g(),h.call(null,D,...C);return}if(u()||o){g(),h.call(null,D,...C);return}r<64&&(r*=2);let R;a===1?(a=2,R=0):R=(r+Math.random())*1e3,f(R)}let I=!1;function N(D){I||(I=!0,g(),!c&&(i!==null?(D||(a=2),clearTimeout(i),f(0)):D||(a=1)))}return f(0),s=setTimeout(()=>{o=!0,N(!0)},n),N}function bD(t){t(!1)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function PD(t){return t!==void 0}function ND(t){return typeof t=="function"}function DD(t){return typeof t=="object"&&!Array.isArray(t)}function Nh(t){return typeof t=="string"||t instanceof String}function _0(t){return Ig()&&t instanceof Blob}function Ig(){return typeof Blob<"u"}function y0(t,e,n,r){if(r<e)throw Ep(`Invalid value for '${t}'. Expected ${e} or greater.`);if(r>n)throw Ep(`Invalid value for '${t}'. Expected ${n} or less.`)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function So(t,e,n){let r=e;return n==null&&(r=`https://${e}`),`${n}://${r}/v0${t}`}function N1(t){const e=encodeURIComponent;let n="?";for(const r in t)if(t.hasOwnProperty(r)){const i=e(r)+"="+e(t[r]);n=n+i+"&"}return n=n.slice(0,-1),n}var Ui;(function(t){t[t.NO_ERROR=0]="NO_ERROR",t[t.NETWORK_ERROR=1]="NETWORK_ERROR",t[t.ABORT=2]="ABORT"})(Ui||(Ui={}));/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function D1(t,e){const n=t>=500&&t<600,i=[408,429].indexOf(t)!==-1,s=e.indexOf(t)!==-1;return n||i||s}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class OD{constructor(e,n,r,i,s,o,a,u,c,h,f,g=!0){this.url_=e,this.method_=n,this.headers_=r,this.body_=i,this.successCodes_=s,this.additionalRetryCodes_=o,this.callback_=a,this.errorCallback_=u,this.timeout_=c,this.progressCallback_=h,this.connectionFactory_=f,this.retry=g,this.pendingConnection_=null,this.backoffId_=null,this.canceled_=!1,this.appDelete_=!1,this.promise_=new Promise((v,I)=>{this.resolve_=v,this.reject_=I,this.start_()})}start_(){const e=(r,i)=>{if(i){r(!1,new Iu(!1,null,!0));return}const s=this.connectionFactory_();this.pendingConnection_=s;const o=a=>{const u=a.loaded,c=a.lengthComputable?a.total:-1;this.progressCallback_!==null&&this.progressCallback_(u,c)};this.progressCallback_!==null&&s.addUploadProgressListener(o),s.send(this.url_,this.method_,this.body_,this.headers_).then(()=>{this.progressCallback_!==null&&s.removeUploadProgressListener(o),this.pendingConnection_=null;const a=s.getErrorCode()===Ui.NO_ERROR,u=s.getStatus();if(!a||D1(u,this.additionalRetryCodes_)&&this.retry){const h=s.getErrorCode()===Ui.ABORT;r(!1,new Iu(!1,null,h));return}const c=this.successCodes_.indexOf(u)!==-1;r(!0,new Iu(c,s))})},n=(r,i)=>{const s=this.resolve_,o=this.reject_,a=i.connection;if(i.wasSuccessCode)try{const u=this.callback_(a,a.getResponse());PD(u)?s(u):s()}catch(u){o(u)}else if(a!==null){const u=Tg();u.serverResponse=a.getErrorText(),this.errorCallback_?o(this.errorCallback_(a,u)):o(u)}else if(i.canceled){const u=this.appDelete_?P1():A1();o(u)}else{const u=x1();o(u)}};this.canceled_?n(!1,new Iu(!1,null,!0)):this.backoffId_=AD(e,n,this.timeout_)}getPromise(){return this.promise_}cancel(e){this.canceled_=!0,this.appDelete_=e||!1,this.backoffId_!==null&&bD(this.backoffId_),this.pendingConnection_!==null&&this.pendingConnection_.abort()}}class Iu{constructor(e,n,r){this.wasSuccessCode=e,this.connection=n,this.canceled=!!r}}function MD(t,e){e!==null&&e.length>0&&(t.Authorization="Firebase "+e)}function LD(t,e){t["X-Firebase-Storage-Version"]="webjs/"+(e??"AppManager")}function FD(t,e){e&&(t["X-Firebase-GMPID"]=e)}function VD(t,e){e!==null&&(t["X-Firebase-AppCheck"]=e)}function UD(t,e,n,r,i,s,o=!0){const a=N1(t.urlParams),u=t.url+a,c=Object.assign({},t.headers);return FD(c,e),MD(c,n),LD(c,s),VD(c,r),new OD(u,t.method,c,t.body,t.successCodes,t.additionalRetryCodes,t.handler,t.errorHandler,t.timeout,t.progressCallback,i,o)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function jD(){return typeof BlobBuilder<"u"?BlobBuilder:typeof WebKitBlobBuilder<"u"?WebKitBlobBuilder:void 0}function zD(...t){const e=jD();if(e!==void 0){const n=new e;for(let r=0;r<t.length;r++)n.append(t[r]);return n.getBlob()}else{if(Ig())return new Blob(t);throw new Ke(Be.UNSUPPORTED_ENVIRONMENT,"This browser doesn't seem to support creating Blobs")}}function BD(t,e,n){return t.webkitSlice?t.webkitSlice(e,n):t.mozSlice?t.mozSlice(e,n):t.slice?t.slice(e,n):null}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function $D(t){if(typeof atob>"u")throw CD("base-64");return atob(t)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const $n={RAW:"raw",BASE64:"base64",BASE64URL:"base64url",DATA_URL:"data_url"};class qd{constructor(e,n){this.data=e,this.contentType=n||null}}function WD(t,e){switch(t){case $n.RAW:return new qd(O1(e));case $n.BASE64:case $n.BASE64URL:return new qd(M1(t,e));case $n.DATA_URL:return new qd(HD(e),GD(e))}throw Tg()}function O1(t){const e=[];for(let n=0;n<t.length;n++){let r=t.charCodeAt(n);if(r<=127)e.push(r);else if(r<=2047)e.push(192|r>>6,128|r&63);else if((r&64512)===55296)if(!(n<t.length-1&&(t.charCodeAt(n+1)&64512)===56320))e.push(239,191,189);else{const s=r,o=t.charCodeAt(++n);r=65536|(s&1023)<<10|o&1023,e.push(240|r>>18,128|r>>12&63,128|r>>6&63,128|r&63)}else(r&64512)===56320?e.push(239,191,189):e.push(224|r>>12,128|r>>6&63,128|r&63)}return new Uint8Array(e)}function qD(t){let e;try{e=decodeURIComponent(t)}catch{throw xa($n.DATA_URL,"Malformed data URL.")}return O1(e)}function M1(t,e){switch(t){case $n.BASE64:{const i=e.indexOf("-")!==-1,s=e.indexOf("_")!==-1;if(i||s)throw xa(t,"Invalid character '"+(i?"-":"_")+"' found: is it base64url encoded?");break}case $n.BASE64URL:{const i=e.indexOf("+")!==-1,s=e.indexOf("/")!==-1;if(i||s)throw xa(t,"Invalid character '"+(i?"+":"/")+"' found: is it base64 encoded?");e=e.replace(/-/g,"+").replace(/_/g,"/");break}}let n;try{n=$D(e)}catch(i){throw i.message.includes("polyfill")?i:xa(t,"Invalid character found")}const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}class L1{constructor(e){this.base64=!1,this.contentType=null;const n=e.match(/^data:([^,]+)?,/);if(n===null)throw xa($n.DATA_URL,"Must be formatted 'data:[<mediatype>][;base64],<data>");const r=n[1]||null;r!=null&&(this.base64=KD(r,";base64"),this.contentType=this.base64?r.substring(0,r.length-7):r),this.rest=e.substring(e.indexOf(",")+1)}}function HD(t){const e=new L1(t);return e.base64?M1($n.BASE64,e.rest):qD(e.rest)}function GD(t){return new L1(t).contentType}function KD(t,e){return t.length>=e.length?t.substring(t.length-e.length)===e:!1}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ur{constructor(e,n){let r=0,i="";_0(e)?(this.data_=e,r=e.size,i=e.type):e instanceof ArrayBuffer?(n?this.data_=new Uint8Array(e):(this.data_=new Uint8Array(e.byteLength),this.data_.set(new Uint8Array(e))),r=this.data_.length):e instanceof Uint8Array&&(n?this.data_=e:(this.data_=new Uint8Array(e.length),this.data_.set(e)),r=e.length),this.size_=r,this.type_=i}size(){return this.size_}type(){return this.type_}slice(e,n){if(_0(this.data_)){const r=this.data_,i=BD(r,e,n);return i===null?null:new Ur(i)}else{const r=new Uint8Array(this.data_.buffer,e,n-e);return new Ur(r,!0)}}static getBlob(...e){if(Ig()){const n=e.map(r=>r instanceof Ur?r.data_:r);return new Ur(zD.apply(null,n))}else{const n=e.map(o=>Nh(o)?WD($n.RAW,o).data:o.data_);let r=0;n.forEach(o=>{r+=o.byteLength});const i=new Uint8Array(r);let s=0;return n.forEach(o=>{for(let a=0;a<o.length;a++)i[s++]=o[a]}),new Ur(i,!0)}}uploadData(){return this.data_}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function F1(t){let e;try{e=JSON.parse(t)}catch{return null}return DD(e)?e:null}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function QD(t){if(t.length===0)return null;const e=t.lastIndexOf("/");return e===-1?"":t.slice(0,e)}function YD(t,e){const n=e.split("/").filter(r=>r.length>0).join("/");return t.length===0?n:t+"/"+n}function V1(t){const e=t.lastIndexOf("/",t.length-2);return e===-1?t:t.slice(e+1)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function XD(t,e){return e}class $t{constructor(e,n,r,i){this.server=e,this.local=n||e,this.writable=!!r,this.xform=i||XD}}let Su=null;function JD(t){return!Nh(t)||t.length<2?t:V1(t)}function U1(){if(Su)return Su;const t=[];t.push(new $t("bucket")),t.push(new $t("generation")),t.push(new $t("metageneration")),t.push(new $t("name","fullPath",!0));function e(s,o){return JD(o)}const n=new $t("name");n.xform=e,t.push(n);function r(s,o){return o!==void 0?Number(o):o}const i=new $t("size");return i.xform=r,t.push(i),t.push(new $t("timeCreated")),t.push(new $t("updated")),t.push(new $t("md5Hash",null,!0)),t.push(new $t("cacheControl",null,!0)),t.push(new $t("contentDisposition",null,!0)),t.push(new $t("contentEncoding",null,!0)),t.push(new $t("contentLanguage",null,!0)),t.push(new $t("contentType",null,!0)),t.push(new $t("metadata","customMetadata",!0)),Su=t,Su}function ZD(t,e){function n(){const r=t.bucket,i=t.fullPath,s=new ln(r,i);return e._makeStorageReference(s)}Object.defineProperty(t,"ref",{get:n})}function eO(t,e,n){const r={};r.type="file";const i=n.length;for(let s=0;s<i;s++){const o=n[s];r[o.local]=o.xform(r,e[o.server])}return ZD(r,t),r}function j1(t,e,n){const r=F1(e);return r===null?null:eO(t,r,n)}function tO(t,e,n,r){const i=F1(e);if(i===null||!Nh(i.downloadTokens))return null;const s=i.downloadTokens;if(s.length===0)return null;const o=encodeURIComponent;return s.split(",").map(c=>{const h=t.bucket,f=t.fullPath,g="/b/"+o(h)+"/o/"+o(f),v=So(g,n,r),I=N1({alt:"media",token:c});return v+I})[0]}function z1(t,e){const n={},r=e.length;for(let i=0;i<r;i++){const s=e[i];s.writable&&(n[s.server]=t[s.local])}return JSON.stringify(n)}class ss{constructor(e,n,r,i){this.url=e,this.method=n,this.handler=r,this.timeout=i,this.urlParams={},this.headers={},this.body=null,this.errorHandler=null,this.progressCallback=null,this.successCodes=[200],this.additionalRetryCodes=[]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function fr(t){if(!t)throw Tg()}function Sg(t,e){function n(r,i){const s=j1(t,i,e);return fr(s!==null),s}return n}function nO(t,e){function n(r,i){const s=j1(t,i,e);return fr(s!==null),tO(s,i,t.host,t._protocol)}return n}function xl(t){function e(n,r){let i;return n.getStatus()===401?n.getErrorText().includes("Firebase App Check token is invalid")?i=vD():i=yD():n.getStatus()===402?i=_D(t.bucket):n.getStatus()===403?i=wD(t.path):i=r,i.status=n.getStatus(),i.serverResponse=r.serverResponse,i}return e}function kg(t){const e=xl(t);function n(r,i){let s=e(r,i);return r.getStatus()===404&&(s=gD(t.path)),s.serverResponse=i.serverResponse,s}return n}function rO(t,e,n){const r=e.fullServerUrl(),i=So(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new ss(i,s,Sg(t,n),o);return a.errorHandler=kg(e),a}function iO(t,e,n){const r=e.fullServerUrl(),i=So(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new ss(i,s,nO(t,n),o);return a.errorHandler=kg(e),a}function sO(t,e){const n=e.fullServerUrl(),r=So(n,t.host,t._protocol),i="DELETE",s=t.maxOperationRetryTime;function o(u,c){}const a=new ss(r,i,o,s);return a.successCodes=[200,204],a.errorHandler=kg(e),a}function oO(t,e){return t&&t.contentType||e&&e.type()||"application/octet-stream"}function B1(t,e,n){const r=Object.assign({},n);return r.fullPath=t.path,r.size=e.size(),r.contentType||(r.contentType=oO(null,e)),r}function aO(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o={"X-Goog-Upload-Protocol":"multipart"};function a(){let R="";for(let M=0;M<2;M++)R=R+Math.random().toString().slice(2);return R}const u=a();o["Content-Type"]="multipart/related; boundary="+u;const c=B1(e,r,i),h=z1(c,n),f="--"+u+`\r
Content-Type: application/json; charset=utf-8\r
\r
`+h+`\r
--`+u+`\r
Content-Type: `+c.contentType+`\r
\r
`,g=`\r
--`+u+"--",v=Ur.getBlob(f,r,g);if(v===null)throw b1();const I={name:c.fullPath},N=So(s,t.host,t._protocol),D="POST",C=t.maxUploadRetryTime,w=new ss(N,D,Sg(t,n),C);return w.urlParams=I,w.headers=o,w.body=v.uploadData(),w.errorHandler=xl(e),w}class Lc{constructor(e,n,r,i){this.current=e,this.total=n,this.finalized=!!r,this.metadata=i||null}}function Cg(t,e){let n=null;try{n=t.getResponseHeader("X-Goog-Upload-Status")}catch{fr(!1)}return fr(!!n&&(e||["active"]).indexOf(n)!==-1),n}function lO(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o=B1(e,r,i),a={name:o.fullPath},u=So(s,t.host,t._protocol),c="POST",h={"X-Goog-Upload-Protocol":"resumable","X-Goog-Upload-Command":"start","X-Goog-Upload-Header-Content-Length":`${r.size()}`,"X-Goog-Upload-Header-Content-Type":o.contentType,"Content-Type":"application/json; charset=utf-8"},f=z1(o,n),g=t.maxUploadRetryTime;function v(N){Cg(N);let D;try{D=N.getResponseHeader("X-Goog-Upload-URL")}catch{fr(!1)}return fr(Nh(D)),D}const I=new ss(u,c,v,g);return I.urlParams=a,I.headers=h,I.body=f,I.errorHandler=xl(e),I}function uO(t,e,n,r){const i={"X-Goog-Upload-Command":"query"};function s(c){const h=Cg(c,["active","final"]);let f=null;try{f=c.getResponseHeader("X-Goog-Upload-Size-Received")}catch{fr(!1)}f||fr(!1);const g=Number(f);return fr(!isNaN(g)),new Lc(g,r.size(),h==="final")}const o="POST",a=t.maxUploadRetryTime,u=new ss(n,o,s,a);return u.headers=i,u.errorHandler=xl(e),u}const v0=256*1024;function cO(t,e,n,r,i,s,o,a){const u=new Lc(0,0);if(o?(u.current=o.current,u.total=o.total):(u.current=0,u.total=r.size()),r.size()!==u.total)throw SD();const c=u.total-u.current;let h=c;i>0&&(h=Math.min(h,i));const f=u.current,g=f+h;let v="";h===0?v="finalize":c===h?v="upload, finalize":v="upload";const I={"X-Goog-Upload-Command":v,"X-Goog-Upload-Offset":`${u.current}`},N=r.slice(f,g);if(N===null)throw b1();function D(M,z){const U=Cg(M,["active","final"]),E=u.current+h,y=r.size();let T;return U==="final"?T=Sg(e,s)(M,z):T=null,new Lc(E,y,U==="final",T)}const C="POST",w=e.maxUploadRetryTime,R=new ss(n,C,D,w);return R.headers=I,R.body=N.uploadData(),R.progressCallback=a||null,R.errorHandler=xl(t),R}const Qt={RUNNING:"running",PAUSED:"paused",SUCCESS:"success",CANCELED:"canceled",ERROR:"error"};function Hd(t){switch(t){case"running":case"pausing":case"canceling":return Qt.RUNNING;case"paused":return Qt.PAUSED;case"success":return Qt.SUCCESS;case"canceled":return Qt.CANCELED;case"error":return Qt.ERROR;default:return Qt.ERROR}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class hO{constructor(e,n,r){if(ND(e)||n!=null||r!=null)this.next=e,this.error=n??void 0,this.complete=r??void 0;else{const s=e;this.next=s.next,this.error=s.error,this.complete=s.complete}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function gs(t){return(...e)=>{Promise.resolve().then(()=>t(...e))}}class dO{constructor(){this.sent_=!1,this.xhr_=new XMLHttpRequest,this.initXhr(),this.errorCode_=Ui.NO_ERROR,this.sendPromise_=new Promise(e=>{this.xhr_.addEventListener("abort",()=>{this.errorCode_=Ui.ABORT,e()}),this.xhr_.addEventListener("error",()=>{this.errorCode_=Ui.NETWORK_ERROR,e()}),this.xhr_.addEventListener("load",()=>{e()})})}send(e,n,r,i){if(this.sent_)throw ea("cannot .send() more than once");if(this.sent_=!0,this.xhr_.open(n,e,!0),i!==void 0)for(const s in i)i.hasOwnProperty(s)&&this.xhr_.setRequestHeader(s,i[s].toString());return r!==void 0?this.xhr_.send(r):this.xhr_.send(),this.sendPromise_}getErrorCode(){if(!this.sent_)throw ea("cannot .getErrorCode() before sending");return this.errorCode_}getStatus(){if(!this.sent_)throw ea("cannot .getStatus() before sending");try{return this.xhr_.status}catch{return-1}}getResponse(){if(!this.sent_)throw ea("cannot .getResponse() before sending");return this.xhr_.response}getErrorText(){if(!this.sent_)throw ea("cannot .getErrorText() before sending");return this.xhr_.statusText}abort(){this.xhr_.abort()}getResponseHeader(e){return this.xhr_.getResponseHeader(e)}addUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.addEventListener("progress",e)}removeUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.removeEventListener("progress",e)}}class fO extends dO{initXhr(){this.xhr_.responseType="text"}}function Ai(){return new fO}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class pO{constructor(e,n,r=null){this._transferred=0,this._needToFetchStatus=!1,this._needToFetchMetadata=!1,this._observers=[],this._error=void 0,this._uploadUrl=void 0,this._request=void 0,this._chunkMultiplier=1,this._resolve=void 0,this._reject=void 0,this._ref=e,this._blob=n,this._metadata=r,this._mappings=U1(),this._resumable=this._shouldDoResumable(this._blob),this._state="running",this._errorHandler=i=>{if(this._request=void 0,this._chunkMultiplier=1,i._codeEquals(Be.CANCELED))this._needToFetchStatus=!0,this.completeTransitions_();else{const s=this.isExponentialBackoffExpired();if(D1(i.status,[]))if(s)i=x1();else{this.sleepTime=Math.max(this.sleepTime*2,mD),this._needToFetchStatus=!0,this.completeTransitions_();return}this._error=i,this._transition("error")}},this._metadataErrorHandler=i=>{this._request=void 0,i._codeEquals(Be.CANCELED)?this.completeTransitions_():(this._error=i,this._transition("error"))},this.sleepTime=0,this.maxSleepTime=this._ref.storage.maxUploadRetryTime,this._promise=new Promise((i,s)=>{this._resolve=i,this._reject=s,this._start()}),this._promise.then(null,()=>{})}isExponentialBackoffExpired(){return this.sleepTime>this.maxSleepTime}_makeProgressCallback(){const e=this._transferred;return n=>this._updateProgress(e+n)}_shouldDoResumable(e){return e.size()>256*1024}_start(){this._state==="running"&&this._request===void 0&&(this._resumable?this._uploadUrl===void 0?this._createResumable():this._needToFetchStatus?this._fetchStatus():this._needToFetchMetadata?this._fetchMetadata():this.pendingTimeout=setTimeout(()=>{this.pendingTimeout=void 0,this._continueUpload()},this.sleepTime):this._oneShotUpload())}_resolveToken(e){Promise.all([this._ref.storage._getAuthToken(),this._ref.storage._getAppCheckToken()]).then(([n,r])=>{switch(this._state){case"running":e(n,r);break;case"canceling":this._transition("canceled");break;case"pausing":this._transition("paused");break}})}_createResumable(){this._resolveToken((e,n)=>{const r=lO(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._uploadUrl=s,this._needToFetchStatus=!1,this.completeTransitions_()},this._errorHandler)})}_fetchStatus(){const e=this._uploadUrl;this._resolveToken((n,r)=>{const i=uO(this._ref.storage,this._ref._location,e,this._blob),s=this._ref.storage._makeRequest(i,Ai,n,r);this._request=s,s.getPromise().then(o=>{o=o,this._request=void 0,this._updateProgress(o.current),this._needToFetchStatus=!1,o.finalized&&(this._needToFetchMetadata=!0),this.completeTransitions_()},this._errorHandler)})}_continueUpload(){const e=v0*this._chunkMultiplier,n=new Lc(this._transferred,this._blob.size()),r=this._uploadUrl;this._resolveToken((i,s)=>{let o;try{o=cO(this._ref._location,this._ref.storage,r,this._blob,e,this._mappings,n,this._makeProgressCallback())}catch(u){this._error=u,this._transition("error");return}const a=this._ref.storage._makeRequest(o,Ai,i,s,!1);this._request=a,a.getPromise().then(u=>{this._increaseMultiplier(),this._request=void 0,this._updateProgress(u.current),u.finalized?(this._metadata=u.metadata,this._transition("success")):this.completeTransitions_()},this._errorHandler)})}_increaseMultiplier(){v0*this._chunkMultiplier*2<32*1024*1024&&(this._chunkMultiplier*=2)}_fetchMetadata(){this._resolveToken((e,n)=>{const r=rO(this._ref.storage,this._ref._location,this._mappings),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._transition("success")},this._metadataErrorHandler)})}_oneShotUpload(){this._resolveToken((e,n)=>{const r=aO(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,Ai,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._updateProgress(this._blob.size()),this._transition("success")},this._errorHandler)})}_updateProgress(e){const n=this._transferred;this._transferred=e,this._transferred!==n&&this._notifyObservers()}_transition(e){if(this._state!==e)switch(e){case"canceling":case"pausing":this._state=e,this._request!==void 0?this._request.cancel():this.pendingTimeout&&(clearTimeout(this.pendingTimeout),this.pendingTimeout=void 0,this.completeTransitions_());break;case"running":const n=this._state==="paused";this._state=e,n&&(this._notifyObservers(),this._start());break;case"paused":this._state=e,this._notifyObservers();break;case"canceled":this._error=A1(),this._state=e,this._notifyObservers();break;case"error":this._state=e,this._notifyObservers();break;case"success":this._state=e,this._notifyObservers();break}}completeTransitions_(){switch(this._state){case"pausing":this._transition("paused");break;case"canceling":this._transition("canceled");break;case"running":this._start();break}}get snapshot(){const e=Hd(this._state);return{bytesTransferred:this._transferred,totalBytes:this._blob.size(),state:e,metadata:this._metadata,task:this,ref:this._ref}}on(e,n,r,i){const s=new hO(n||void 0,r||void 0,i||void 0);return this._addObserver(s),()=>{this._removeObserver(s)}}then(e,n){return this._promise.then(e,n)}catch(e){return this.then(null,e)}_addObserver(e){this._observers.push(e),this._notifyObserver(e)}_removeObserver(e){const n=this._observers.indexOf(e);n!==-1&&this._observers.splice(n,1)}_notifyObservers(){this._finishPromise(),this._observers.slice().forEach(n=>{this._notifyObserver(n)})}_finishPromise(){if(this._resolve!==void 0){let e=!0;switch(Hd(this._state)){case Qt.SUCCESS:gs(this._resolve.bind(null,this.snapshot))();break;case Qt.CANCELED:case Qt.ERROR:const n=this._reject;gs(n.bind(null,this._error))();break;default:e=!1;break}e&&(this._resolve=void 0,this._reject=void 0)}}_notifyObserver(e){switch(Hd(this._state)){case Qt.RUNNING:case Qt.PAUSED:e.next&&gs(e.next.bind(e,this.snapshot))();break;case Qt.SUCCESS:e.complete&&gs(e.complete.bind(e))();break;case Qt.CANCELED:case Qt.ERROR:e.error&&gs(e.error.bind(e,this._error))();break;default:e.error&&gs(e.error.bind(e,this._error))()}}resume(){const e=this._state==="paused"||this._state==="pausing";return e&&this._transition("running"),e}pause(){const e=this._state==="running";return e&&this._transition("pausing"),e}cancel(){const e=this._state==="running"||this._state==="pausing";return e&&this._transition("canceling"),e}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ki{constructor(e,n){this._service=e,n instanceof ln?this._location=n:this._location=ln.makeFromUrl(n,e.host)}toString(){return"gs://"+this._location.bucket+"/"+this._location.path}_newRef(e,n){return new Ki(e,n)}get root(){const e=new ln(this._location.bucket,"");return this._newRef(this._service,e)}get bucket(){return this._location.bucket}get fullPath(){return this._location.path}get name(){return V1(this._location.path)}get storage(){return this._service}get parent(){const e=QD(this._location.path);if(e===null)return null;const n=new ln(this._location.bucket,e);return new Ki(this._service,n)}_throwIfRoot(e){if(this._location.path==="")throw RD(e)}}function mO(t,e,n){return t._throwIfRoot("uploadBytesResumable"),new pO(t,new Ur(e),n)}function gO(t){t._throwIfRoot("getDownloadURL");const e=iO(t.storage,t._location,U1());return t.storage.makeRequestWithTokens(e,Ai).then(n=>{if(n===null)throw kD();return n})}function _O(t){t._throwIfRoot("deleteObject");const e=sO(t.storage,t._location);return t.storage.makeRequestWithTokens(e,Ai)}function yO(t,e){const n=YD(t._location.path,e),r=new ln(t._location.bucket,n);return new Ki(t.storage,r)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function vO(t){return/^[A-Za-z]+:\/\//.test(t)}function wO(t,e){return new Ki(t,e)}function $1(t,e){if(t instanceof Rg){const n=t;if(n._bucket==null)throw ID();const r=new Ki(n,n._bucket);return e!=null?$1(r,e):r}else return e!==void 0?yO(t,e):t}function EO(t,e){if(e&&vO(e)){if(t instanceof Rg)return wO(t,e);throw Ep("To use ref(service, url), the first argument must be a Storage instance.")}else return $1(t,e)}function w0(t,e){const n=e==null?void 0:e[R1];return n==null?null:ln.makeFromBucketSpec(n,t)}function TO(t,e,n,r={}){t.host=`${e}:${n}`,t._protocol="http";const{mockUserToken:i}=r;i&&(t._overrideAuthToken=typeof i=="string"?i:Fm(i,t.app.options.projectId))}class Rg{constructor(e,n,r,i,s){this.app=e,this._authProvider=n,this._appCheckProvider=r,this._url=i,this._firebaseVersion=s,this._bucket=null,this._host=C1,this._protocol="https",this._appId=null,this._deleted=!1,this._maxOperationRetryTime=fD,this._maxUploadRetryTime=pD,this._requests=new Set,i!=null?this._bucket=ln.makeFromBucketSpec(i,this._host):this._bucket=w0(this._host,this.app.options)}get host(){return this._host}set host(e){this._host=e,this._url!=null?this._bucket=ln.makeFromBucketSpec(this._url,e):this._bucket=w0(e,this.app.options)}get maxUploadRetryTime(){return this._maxUploadRetryTime}set maxUploadRetryTime(e){y0("time",0,Number.POSITIVE_INFINITY,e),this._maxUploadRetryTime=e}get maxOperationRetryTime(){return this._maxOperationRetryTime}set maxOperationRetryTime(e){y0("time",0,Number.POSITIVE_INFINITY,e),this._maxOperationRetryTime=e}async _getAuthToken(){if(this._overrideAuthToken)return this._overrideAuthToken;const e=this._authProvider.getImmediate({optional:!0});if(e){const n=await e.getToken();if(n!==null)return n.accessToken}return null}async _getAppCheckToken(){const e=this._appCheckProvider.getImmediate({optional:!0});return e?(await e.getToken()).token:null}_delete(){return this._deleted||(this._deleted=!0,this._requests.forEach(e=>e.cancel()),this._requests.clear()),Promise.resolve()}_makeStorageReference(e){return new Ki(this,e)}_makeRequest(e,n,r,i,s=!0){if(this._deleted)return new xD(P1());{const o=UD(e,this._appId,r,i,n,this._firebaseVersion,s);return this._requests.add(o),o.getPromise().then(()=>this._requests.delete(o),()=>this._requests.delete(o)),o}}async makeRequestWithTokens(e,n){const[r,i]=await Promise.all([this._getAuthToken(),this._getAppCheckToken()]);return this._makeRequest(e,n,r,i).getPromise()}}const E0="@firebase/storage",T0="0.13.2";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const W1="storage";function IO(t,e,n){return t=Xe(t),mO(t,e,n)}function SO(t){return t=Xe(t),gO(t)}function kO(t){return t=Xe(t),_O(t)}function I0(t,e){return t=Xe(t),EO(t,e)}function CO(t=vh(),e){t=Xe(t);const r=El(t,W1).getImmediate({identifier:e}),i=Lm("storage");return i&&RO(r,...i),r}function RO(t,e,n,r={}){TO(t,e,n,r)}function xO(t,{instanceIdentifier:e}){const n=t.getProvider("app").getImmediate(),r=t.getProvider("auth-internal"),i=t.getProvider("app-check-internal");return new Rg(n,r,i,e,vi)}function AO(){ci(new vr(W1,xO,"PUBLIC").setMultipleInstances(!0)),Tn(E0,T0,""),Tn(E0,T0,"esm2017")}AO();var S0={};const k0="@firebase/database",C0="1.0.8";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let q1="";function bO(t){q1=t}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class PO{constructor(e){this.domStorage_=e,this.prefix_="firebase:"}set(e,n){n==null?this.domStorage_.removeItem(this.prefixedName_(e)):this.domStorage_.setItem(this.prefixedName_(e),Et(n))}get(e){const n=this.domStorage_.getItem(this.prefixedName_(e));return n==null?null:tl(n)}remove(e){this.domStorage_.removeItem(this.prefixedName_(e))}prefixedName_(e){return this.prefix_+e}toString(){return this.domStorage_.toString()}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class NO{constructor(){this.cache_={},this.isInMemoryStorage=!0}set(e,n){n==null?delete this.cache_[e]:this.cache_[e]=n}get(e){return xr(this.cache_,e)?this.cache_[e]:null}remove(e){delete this.cache_[e]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const H1=function(t){try{if(typeof window<"u"&&typeof window[t]<"u"){const e=window[t];return e.setItem("firebase:sentinel","cache"),e.removeItem("firebase:sentinel"),new PO(e)}}catch{}return new NO},Oi=H1("localStorage"),DO=H1("sessionStorage");/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const $s=new yh("@firebase/database"),OO=function(){let t=1;return function(){return t++}}(),G1=function(t){const e=qA(t),n=new zA;n.update(e);const r=n.digest();return Mm.encodeByteArray(r)},Al=function(...t){let e="";for(let n=0;n<t.length;n++){const r=t[n];Array.isArray(r)||r&&typeof r=="object"&&typeof r.length=="number"?e+=Al.apply(null,r):typeof r=="object"?e+=Et(r):e+=r,e+=" "}return e};let Aa=null,R0=!0;const MO=function(t,e){G(!0,"Can't turn on custom loggers persistently."),$s.logLevel=he.VERBOSE,Aa=$s.log.bind($s)},Ft=function(...t){if(R0===!0&&(R0=!1,Aa===null&&DO.get("logging_enabled")===!0&&MO()),Aa){const e=Al.apply(null,t);Aa(e)}},bl=function(t){return function(...e){Ft(t,...e)}},Tp=function(...t){const e="FIREBASE INTERNAL ERROR: "+Al(...t);$s.error(e)},Ir=function(...t){const e=`FIREBASE FATAL ERROR: ${Al(...t)}`;throw $s.error(e),new Error(e)},nn=function(...t){const e="FIREBASE WARNING: "+Al(...t);$s.warn(e)},LO=function(){typeof window<"u"&&window.location&&window.location.protocol&&window.location.protocol.indexOf("https:")!==-1&&nn("Insecure Firebase access from a secure page. Please use https in calls to new Firebase().")},K1=function(t){return typeof t=="number"&&(t!==t||t===Number.POSITIVE_INFINITY||t===Number.NEGATIVE_INFINITY)},FO=function(t){if(document.readyState==="complete")t();else{let e=!1;const n=function(){if(!document.body){setTimeout(n,Math.floor(10));return}e||(e=!0,t())};document.addEventListener?(document.addEventListener("DOMContentLoaded",n,!1),window.addEventListener("load",n,!1)):document.attachEvent&&(document.attachEvent("onreadystatechange",()=>{document.readyState==="complete"&&n()}),window.attachEvent("onload",n))}},ho="[MIN_NAME]",Qi="[MAX_NAME]",ko=function(t,e){if(t===e)return 0;if(t===ho||e===Qi)return-1;if(e===ho||t===Qi)return 1;{const n=x0(t),r=x0(e);return n!==null?r!==null?n-r===0?t.length-e.length:n-r:-1:r!==null?1:t<e?-1:1}},VO=function(t,e){return t===e?0:t<e?-1:1},ta=function(t,e){if(e&&t in e)return e[t];throw new Error("Missing required key ("+t+") in object: "+Et(e))},xg=function(t){if(typeof t!="object"||t===null)return Et(t);const e=[];for(const r in t)e.push(r);e.sort();let n="{";for(let r=0;r<e.length;r++)r!==0&&(n+=","),n+=Et(e[r]),n+=":",n+=xg(t[e[r]]);return n+="}",n},Q1=function(t,e){const n=t.length;if(n<=e)return[t];const r=[];for(let i=0;i<n;i+=e)i+e>n?r.push(t.substring(i,n)):r.push(t.substring(i,i+e));return r};function Cn(t,e){for(const n in t)t.hasOwnProperty(n)&&e(n,t[n])}const Y1=function(t){G(!K1(t),"Invalid JSON number");const e=11,n=52,r=(1<<e-1)-1;let i,s,o,a,u;t===0?(s=0,o=0,i=1/t===-1/0?1:0):(i=t<0,t=Math.abs(t),t>=Math.pow(2,1-r)?(a=Math.min(Math.floor(Math.log(t)/Math.LN2),r),s=a+r,o=Math.round(t*Math.pow(2,n-a)-Math.pow(2,n))):(s=0,o=Math.round(t/Math.pow(2,1-r-n))));const c=[];for(u=n;u;u-=1)c.push(o%2?1:0),o=Math.floor(o/2);for(u=e;u;u-=1)c.push(s%2?1:0),s=Math.floor(s/2);c.push(i?1:0),c.reverse();const h=c.join("");let f="";for(u=0;u<64;u+=8){let g=parseInt(h.substr(u,8),2).toString(16);g.length===1&&(g="0"+g),f=f+g}return f.toLowerCase()},UO=function(){return!!(typeof window=="object"&&window.chrome&&window.chrome.extension&&!/^chrome/.test(window.location.href))},jO=function(){return typeof Windows=="object"&&typeof Windows.UI=="object"},zO=new RegExp("^-?(0*)\\d{1,10}$"),BO=-2147483648,$O=2147483647,x0=function(t){if(zO.test(t)){const e=Number(t);if(e>=BO&&e<=$O)return e}return null},Co=function(t){try{t()}catch(e){setTimeout(()=>{const n=e.stack||"";throw nn("Exception was thrown by user callback.",n),e},Math.floor(0))}},WO=function(){return(typeof window=="object"&&window.navigator&&window.navigator.userAgent||"").search(/googlebot|google webmaster tools|bingbot|yahoo! slurp|baiduspider|yandexbot|duckduckbot/i)>=0},ba=function(t,e){const n=setTimeout(t,e);return typeof n=="number"&&typeof Deno<"u"&&Deno.unrefTimer?Deno.unrefTimer(n):typeof n=="object"&&n.unref&&n.unref(),n};/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class qO{constructor(e,n){this.appName_=e,this.appCheckProvider=n,this.appCheck=n==null?void 0:n.getImmediate({optional:!0}),this.appCheck||n==null||n.get().then(r=>this.appCheck=r)}getToken(e){return this.appCheck?this.appCheck.getToken(e):new Promise((n,r)=>{setTimeout(()=>{this.appCheck?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){var n;(n=this.appCheckProvider)===null||n===void 0||n.get().then(r=>r.addTokenListener(e))}notifyForInvalidToken(){nn(`Provided AppCheck credentials for the app named "${this.appName_}" are invalid. This usually indicates your app was not initialized correctly.`)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class HO{constructor(e,n,r){this.appName_=e,this.firebaseOptions_=n,this.authProvider_=r,this.auth_=null,this.auth_=r.getImmediate({optional:!0}),this.auth_||r.onInit(i=>this.auth_=i)}getToken(e){return this.auth_?this.auth_.getToken(e).catch(n=>n&&n.code==="auth/token-not-initialized"?(Ft("Got auth/token-not-initialized error.  Treating as null token."),null):Promise.reject(n)):new Promise((n,r)=>{setTimeout(()=>{this.auth_?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){this.auth_?this.auth_.addAuthTokenListener(e):this.authProvider_.get().then(n=>n.addAuthTokenListener(e))}removeTokenChangeListener(e){this.authProvider_.get().then(n=>n.removeAuthTokenListener(e))}notifyForInvalidToken(){let e='Provided authentication credentials for the app named "'+this.appName_+'" are invalid. This usually indicates your app was not initialized correctly. ';"credential"in this.firebaseOptions_?e+='Make sure the "credential" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':"serviceAccount"in this.firebaseOptions_?e+='Make sure the "serviceAccount" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':e+='Make sure the "apiKey" and "databaseURL" properties provided to initializeApp() match the values provided for your app at https://console.firebase.google.com/.',nn(e)}}class Ku{constructor(e){this.accessToken=e}getToken(e){return Promise.resolve({accessToken:this.accessToken})}addTokenChangeListener(e){e(this.accessToken)}removeTokenChangeListener(e){}notifyForInvalidToken(){}}Ku.OWNER="owner";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Ag="5",X1="v",J1="s",Z1="r",eS="f",tS=/(console\.firebase|firebase-console-\w+\.corp|firebase\.corp)\.google\.com/,nS="ls",rS="p",Ip="ac",iS="websocket",sS="long_polling";/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class oS{constructor(e,n,r,i,s=!1,o="",a=!1,u=!1){this.secure=n,this.namespace=r,this.webSocketOnly=i,this.nodeAdmin=s,this.persistenceKey=o,this.includeNamespaceInQueryParams=a,this.isUsingEmulator=u,this._host=e.toLowerCase(),this._domain=this._host.substr(this._host.indexOf(".")+1),this.internalHost=Oi.get("host:"+e)||this._host}isCacheableHost(){return this.internalHost.substr(0,2)==="s-"}isCustomHost(){return this._domain!=="firebaseio.com"&&this._domain!=="firebaseio-demo.com"}get host(){return this._host}set host(e){e!==this.internalHost&&(this.internalHost=e,this.isCacheableHost()&&Oi.set("host:"+this._host,this.internalHost))}toString(){let e=this.toURLString();return this.persistenceKey&&(e+="<"+this.persistenceKey+">"),e}toURLString(){const e=this.secure?"https://":"http://",n=this.includeNamespaceInQueryParams?`?ns=${this.namespace}`:"";return`${e}${this.host}/${n}`}}function GO(t){return t.host!==t.internalHost||t.isCustomHost()||t.includeNamespaceInQueryParams}function aS(t,e,n){G(typeof e=="string","typeof type must == string"),G(typeof n=="object","typeof params must == object");let r;if(e===iS)r=(t.secure?"wss://":"ws://")+t.internalHost+"/.ws?";else if(e===sS)r=(t.secure?"https://":"http://")+t.internalHost+"/.lp?";else throw new Error("Unknown connection type: "+e);GO(t)&&(n.ns=t.namespace);const i=[];return Cn(n,(s,o)=>{i.push(s+"="+o)}),r+i.join("&")}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class KO{constructor(){this.counters_={}}incrementCounter(e,n=1){xr(this.counters_,e)||(this.counters_[e]=0),this.counters_[e]+=n}get(){return TA(this.counters_)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Gd={},Kd={};function bg(t){const e=t.toString();return Gd[e]||(Gd[e]=new KO),Gd[e]}function QO(t,e){const n=t.toString();return Kd[n]||(Kd[n]=e()),Kd[n]}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class YO{constructor(e){this.onMessage_=e,this.pendingResponses=[],this.currentResponseNum=0,this.closeAfterResponse=-1,this.onClose=null}closeAfter(e,n){this.closeAfterResponse=e,this.onClose=n,this.closeAfterResponse<this.currentResponseNum&&(this.onClose(),this.onClose=null)}handleResponse(e,n){for(this.pendingResponses[e]=n;this.pendingResponses[this.currentResponseNum];){const r=this.pendingResponses[this.currentResponseNum];delete this.pendingResponses[this.currentResponseNum];for(let i=0;i<r.length;++i)r[i]&&Co(()=>{this.onMessage_(r[i])});if(this.currentResponseNum===this.closeAfterResponse){this.onClose&&(this.onClose(),this.onClose=null);break}this.currentResponseNum++}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const A0="start",XO="close",JO="pLPCommand",ZO="pRTLPCB",lS="id",uS="pw",cS="ser",eM="cb",tM="seg",nM="ts",rM="d",iM="dframe",hS=1870,dS=30,sM=hS-dS,oM=25e3,aM=3e4;class Os{constructor(e,n,r,i,s,o,a){this.connId=e,this.repoInfo=n,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.transportSessionId=o,this.lastSessionId=a,this.bytesSent=0,this.bytesReceived=0,this.everConnected_=!1,this.log_=bl(e),this.stats_=bg(n),this.urlFn=u=>(this.appCheckToken&&(u[Ip]=this.appCheckToken),aS(n,sS,u))}open(e,n){this.curSegmentNum=0,this.onDisconnect_=n,this.myPacketOrderer=new YO(e),this.isClosed_=!1,this.connectTimeoutTimer_=setTimeout(()=>{this.log_("Timed out trying to connect."),this.onClosed_(),this.connectTimeoutTimer_=null},Math.floor(aM)),FO(()=>{if(this.isClosed_)return;this.scriptTagHolder=new Pg((...s)=>{const[o,a,u,c,h]=s;if(this.incrementIncomingBytes_(s),!!this.scriptTagHolder)if(this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null),this.everConnected_=!0,o===A0)this.id=a,this.password=u;else if(o===XO)a?(this.scriptTagHolder.sendNewPolls=!1,this.myPacketOrderer.closeAfter(a,()=>{this.onClosed_()})):this.onClosed_();else throw new Error("Unrecognized command received: "+o)},(...s)=>{const[o,a]=s;this.incrementIncomingBytes_(s),this.myPacketOrderer.handleResponse(o,a)},()=>{this.onClosed_()},this.urlFn);const r={};r[A0]="t",r[cS]=Math.floor(Math.random()*1e8),this.scriptTagHolder.uniqueCallbackIdentifier&&(r[eM]=this.scriptTagHolder.uniqueCallbackIdentifier),r[X1]=Ag,this.transportSessionId&&(r[J1]=this.transportSessionId),this.lastSessionId&&(r[nS]=this.lastSessionId),this.applicationId&&(r[rS]=this.applicationId),this.appCheckToken&&(r[Ip]=this.appCheckToken),typeof location<"u"&&location.hostname&&tS.test(location.hostname)&&(r[Z1]=eS);const i=this.urlFn(r);this.log_("Connecting via long-poll to "+i),this.scriptTagHolder.addTag(i,()=>{})})}start(){this.scriptTagHolder.startLongPoll(this.id,this.password),this.addDisconnectPingFrame(this.id,this.password)}static forceAllow(){Os.forceAllow_=!0}static forceDisallow(){Os.forceDisallow_=!0}static isAvailable(){return Os.forceAllow_?!0:!Os.forceDisallow_&&typeof document<"u"&&document.createElement!=null&&!UO()&&!jO()}markConnectionHealthy(){}shutdown_(){this.isClosed_=!0,this.scriptTagHolder&&(this.scriptTagHolder.close(),this.scriptTagHolder=null),this.myDisconnFrame&&(document.body.removeChild(this.myDisconnFrame),this.myDisconnFrame=null),this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null)}onClosed_(){this.isClosed_||(this.log_("Longpoll is closing itself"),this.shutdown_(),this.onDisconnect_&&(this.onDisconnect_(this.everConnected_),this.onDisconnect_=null))}close(){this.isClosed_||(this.log_("Longpoll is being closed."),this.shutdown_())}send(e){const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=KT(n),i=Q1(r,sM);for(let s=0;s<i.length;s++)this.scriptTagHolder.enqueueSegment(this.curSegmentNum,i.length,i[s]),this.curSegmentNum++}addDisconnectPingFrame(e,n){this.myDisconnFrame=document.createElement("iframe");const r={};r[iM]="t",r[lS]=e,r[uS]=n,this.myDisconnFrame.src=this.urlFn(r),this.myDisconnFrame.style.display="none",document.body.appendChild(this.myDisconnFrame)}incrementIncomingBytes_(e){const n=Et(e).length;this.bytesReceived+=n,this.stats_.incrementCounter("bytes_received",n)}}class Pg{constructor(e,n,r,i){this.onDisconnect=r,this.urlFn=i,this.outstandingRequests=new Set,this.pendingSegs=[],this.currentSerial=Math.floor(Math.random()*1e8),this.sendNewPolls=!0;{this.uniqueCallbackIdentifier=OO(),window[JO+this.uniqueCallbackIdentifier]=e,window[ZO+this.uniqueCallbackIdentifier]=n,this.myIFrame=Pg.createIFrame_();let s="";this.myIFrame.src&&this.myIFrame.src.substr(0,11)==="javascript:"&&(s='<script>document.domain="'+document.domain+'";<\/script>');const o="<html><body>"+s+"</body></html>";try{this.myIFrame.doc.open(),this.myIFrame.doc.write(o),this.myIFrame.doc.close()}catch(a){Ft("frame writing exception"),a.stack&&Ft(a.stack),Ft(a)}}}static createIFrame_(){const e=document.createElement("iframe");if(e.style.display="none",document.body){document.body.appendChild(e);try{e.contentWindow.document||Ft("No IE domain setting required")}catch{const r=document.domain;e.src="javascript:void((function(){document.open();document.domain='"+r+"';document.close();})())"}}else throw"Document body has not initialized. Wait to initialize Firebase until after the document is ready.";return e.contentDocument?e.doc=e.contentDocument:e.contentWindow?e.doc=e.contentWindow.document:e.document&&(e.doc=e.document),e}close(){this.alive=!1,this.myIFrame&&(this.myIFrame.doc.body.textContent="",setTimeout(()=>{this.myIFrame!==null&&(document.body.removeChild(this.myIFrame),this.myIFrame=null)},Math.floor(0)));const e=this.onDisconnect;e&&(this.onDisconnect=null,e())}startLongPoll(e,n){for(this.myID=e,this.myPW=n,this.alive=!0;this.newRequest_(););}newRequest_(){if(this.alive&&this.sendNewPolls&&this.outstandingRequests.size<(this.pendingSegs.length>0?2:1)){this.currentSerial++;const e={};e[lS]=this.myID,e[uS]=this.myPW,e[cS]=this.currentSerial;let n=this.urlFn(e),r="",i=0;for(;this.pendingSegs.length>0&&this.pendingSegs[0].d.length+dS+r.length<=hS;){const o=this.pendingSegs.shift();r=r+"&"+tM+i+"="+o.seg+"&"+nM+i+"="+o.ts+"&"+rM+i+"="+o.d,i++}return n=n+r,this.addLongPollTag_(n,this.currentSerial),!0}else return!1}enqueueSegment(e,n,r){this.pendingSegs.push({seg:e,ts:n,d:r}),this.alive&&this.newRequest_()}addLongPollTag_(e,n){this.outstandingRequests.add(n);const r=()=>{this.outstandingRequests.delete(n),this.newRequest_()},i=setTimeout(r,Math.floor(oM)),s=()=>{clearTimeout(i),r()};this.addTag(e,s)}addTag(e,n){setTimeout(()=>{try{if(!this.sendNewPolls)return;const r=this.myIFrame.doc.createElement("script");r.type="text/javascript",r.async=!0,r.src=e,r.onload=r.onreadystatechange=function(){const i=r.readyState;(!i||i==="loaded"||i==="complete")&&(r.onload=r.onreadystatechange=null,r.parentNode&&r.parentNode.removeChild(r),n())},r.onerror=()=>{Ft("Long-poll script failed to load: "+e),this.sendNewPolls=!1,this.close()},this.myIFrame.doc.body.appendChild(r)}catch{}},Math.floor(1))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const lM=16384,uM=45e3;let Fc=null;typeof MozWebSocket<"u"?Fc=MozWebSocket:typeof WebSocket<"u"&&(Fc=WebSocket);class Nn{constructor(e,n,r,i,s,o,a){this.connId=e,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.keepaliveTimer=null,this.frames=null,this.totalFrames=0,this.bytesSent=0,this.bytesReceived=0,this.log_=bl(this.connId),this.stats_=bg(n),this.connURL=Nn.connectionURL_(n,o,a,i,r),this.nodeAdmin=n.nodeAdmin}static connectionURL_(e,n,r,i,s){const o={};return o[X1]=Ag,typeof location<"u"&&location.hostname&&tS.test(location.hostname)&&(o[Z1]=eS),n&&(o[J1]=n),r&&(o[nS]=r),i&&(o[Ip]=i),s&&(o[rS]=s),aS(e,iS,o)}open(e,n){this.onDisconnect=n,this.onMessage=e,this.log_("Websocket connecting to "+this.connURL),this.everConnected_=!1,Oi.set("previous_websocket_failure",!0);try{let r;NA(),this.mySock=new Fc(this.connURL,[],r)}catch(r){this.log_("Error instantiating WebSocket.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_();return}this.mySock.onopen=()=>{this.log_("Websocket connected."),this.everConnected_=!0},this.mySock.onclose=()=>{this.log_("Websocket connection was disconnected."),this.mySock=null,this.onClosed_()},this.mySock.onmessage=r=>{this.handleIncomingFrame(r)},this.mySock.onerror=r=>{this.log_("WebSocket error.  Closing connection.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_()}}start(){}static forceDisallow(){Nn.forceDisallow_=!0}static isAvailable(){let e=!1;if(typeof navigator<"u"&&navigator.userAgent){const n=/Android ([0-9]{0,}\.[0-9]{0,})/,r=navigator.userAgent.match(n);r&&r.length>1&&parseFloat(r[1])<4.4&&(e=!0)}return!e&&Fc!==null&&!Nn.forceDisallow_}static previouslyFailed(){return Oi.isInMemoryStorage||Oi.get("previous_websocket_failure")===!0}markConnectionHealthy(){Oi.remove("previous_websocket_failure")}appendFrame_(e){if(this.frames.push(e),this.frames.length===this.totalFrames){const n=this.frames.join("");this.frames=null;const r=tl(n);this.onMessage(r)}}handleNewFrameCount_(e){this.totalFrames=e,this.frames=[]}extractFrameCount_(e){if(G(this.frames===null,"We already have a frame buffer"),e.length<=6){const n=Number(e);if(!isNaN(n))return this.handleNewFrameCount_(n),null}return this.handleNewFrameCount_(1),e}handleIncomingFrame(e){if(this.mySock===null)return;const n=e.data;if(this.bytesReceived+=n.length,this.stats_.incrementCounter("bytes_received",n.length),this.resetKeepAlive(),this.frames!==null)this.appendFrame_(n);else{const r=this.extractFrameCount_(n);r!==null&&this.appendFrame_(r)}}send(e){this.resetKeepAlive();const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=Q1(n,lM);r.length>1&&this.sendString_(String(r.length));for(let i=0;i<r.length;i++)this.sendString_(r[i])}shutdown_(){this.isClosed_=!0,this.keepaliveTimer&&(clearInterval(this.keepaliveTimer),this.keepaliveTimer=null),this.mySock&&(this.mySock.close(),this.mySock=null)}onClosed_(){this.isClosed_||(this.log_("WebSocket is closing itself"),this.shutdown_(),this.onDisconnect&&(this.onDisconnect(this.everConnected_),this.onDisconnect=null))}close(){this.isClosed_||(this.log_("WebSocket is being closed"),this.shutdown_())}resetKeepAlive(){clearInterval(this.keepaliveTimer),this.keepaliveTimer=setInterval(()=>{this.mySock&&this.sendString_("0"),this.resetKeepAlive()},Math.floor(uM))}sendString_(e){try{this.mySock.send(e)}catch(n){this.log_("Exception thrown from WebSocket.send():",n.message||n.data,"Closing connection."),setTimeout(this.onClosed_.bind(this),0)}}}Nn.responsesRequiredToBeHealthy=2;Nn.healthyTimeout=3e4;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dl{constructor(e){this.initTransports_(e)}static get ALL_TRANSPORTS(){return[Os,Nn]}static get IS_TRANSPORT_INITIALIZED(){return this.globalTransportInitialized_}initTransports_(e){const n=Nn&&Nn.isAvailable();let r=n&&!Nn.previouslyFailed();if(e.webSocketOnly&&(n||nn("wss:// URL used, but browser isn't known to support websockets.  Trying anyway."),r=!0),r)this.transports_=[Nn];else{const i=this.transports_=[];for(const s of dl.ALL_TRANSPORTS)s&&s.isAvailable()&&i.push(s);dl.globalTransportInitialized_=!0}}initialTransport(){if(this.transports_.length>0)return this.transports_[0];throw new Error("No transports available")}upgradeTransport(){return this.transports_.length>1?this.transports_[1]:null}}dl.globalTransportInitialized_=!1;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const cM=6e4,hM=5e3,dM=10*1024,fM=100*1024,Qd="t",b0="d",pM="s",P0="r",mM="e",N0="o",D0="a",O0="n",M0="p",gM="h";class _M{constructor(e,n,r,i,s,o,a,u,c,h){this.id=e,this.repoInfo_=n,this.applicationId_=r,this.appCheckToken_=i,this.authToken_=s,this.onMessage_=o,this.onReady_=a,this.onDisconnect_=u,this.onKill_=c,this.lastSessionId=h,this.connectionCount=0,this.pendingDataMessages=[],this.state_=0,this.log_=bl("c:"+this.id+":"),this.transportManager_=new dl(n),this.log_("Connection created"),this.start_()}start_(){const e=this.transportManager_.initialTransport();this.conn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,null,this.lastSessionId),this.primaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.conn_),r=this.disconnReceiver_(this.conn_);this.tx_=this.conn_,this.rx_=this.conn_,this.secondaryConn_=null,this.isHealthy_=!1,setTimeout(()=>{this.conn_&&this.conn_.open(n,r)},Math.floor(0));const i=e.healthyTimeout||0;i>0&&(this.healthyTimeout_=ba(()=>{this.healthyTimeout_=null,this.isHealthy_||(this.conn_&&this.conn_.bytesReceived>fM?(this.log_("Connection exceeded healthy timeout but has received "+this.conn_.bytesReceived+" bytes.  Marking connection healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()):this.conn_&&this.conn_.bytesSent>dM?this.log_("Connection exceeded healthy timeout but has sent "+this.conn_.bytesSent+" bytes.  Leaving connection alive."):(this.log_("Closing unhealthy connection after timeout."),this.close()))},Math.floor(i)))}nextTransportId_(){return"c:"+this.id+":"+this.connectionCount++}disconnReceiver_(e){return n=>{e===this.conn_?this.onConnectionLost_(n):e===this.secondaryConn_?(this.log_("Secondary connection lost."),this.onSecondaryConnectionLost_()):this.log_("closing an old connection")}}connReceiver_(e){return n=>{this.state_!==2&&(e===this.rx_?this.onPrimaryMessageReceived_(n):e===this.secondaryConn_?this.onSecondaryMessageReceived_(n):this.log_("message on old connection"))}}sendRequest(e){const n={t:"d",d:e};this.sendData_(n)}tryCleanupConnection(){this.tx_===this.secondaryConn_&&this.rx_===this.secondaryConn_&&(this.log_("cleaning up and promoting a connection: "+this.secondaryConn_.connId),this.conn_=this.secondaryConn_,this.secondaryConn_=null)}onSecondaryControl_(e){if(Qd in e){const n=e[Qd];n===D0?this.upgradeIfSecondaryHealthy_():n===P0?(this.log_("Got a reset on secondary, closing it"),this.secondaryConn_.close(),(this.tx_===this.secondaryConn_||this.rx_===this.secondaryConn_)&&this.close()):n===N0&&(this.log_("got pong on secondary."),this.secondaryResponsesRequired_--,this.upgradeIfSecondaryHealthy_())}}onSecondaryMessageReceived_(e){const n=ta("t",e),r=ta("d",e);if(n==="c")this.onSecondaryControl_(r);else if(n==="d")this.pendingDataMessages.push(r);else throw new Error("Unknown protocol layer: "+n)}upgradeIfSecondaryHealthy_(){this.secondaryResponsesRequired_<=0?(this.log_("Secondary connection is healthy."),this.isHealthy_=!0,this.secondaryConn_.markConnectionHealthy(),this.proceedWithUpgrade_()):(this.log_("sending ping on secondary."),this.secondaryConn_.send({t:"c",d:{t:M0,d:{}}}))}proceedWithUpgrade_(){this.secondaryConn_.start(),this.log_("sending client ack on secondary"),this.secondaryConn_.send({t:"c",d:{t:D0,d:{}}}),this.log_("Ending transmission on primary"),this.conn_.send({t:"c",d:{t:O0,d:{}}}),this.tx_=this.secondaryConn_,this.tryCleanupConnection()}onPrimaryMessageReceived_(e){const n=ta("t",e),r=ta("d",e);n==="c"?this.onControl_(r):n==="d"&&this.onDataMessage_(r)}onDataMessage_(e){this.onPrimaryResponse_(),this.onMessage_(e)}onPrimaryResponse_(){this.isHealthy_||(this.primaryResponsesRequired_--,this.primaryResponsesRequired_<=0&&(this.log_("Primary connection is healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()))}onControl_(e){const n=ta(Qd,e);if(b0 in e){const r=e[b0];if(n===gM){const i=Object.assign({},r);this.repoInfo_.isUsingEmulator&&(i.h=this.repoInfo_.host),this.onHandshake_(i)}else if(n===O0){this.log_("recvd end transmission on primary"),this.rx_=this.secondaryConn_;for(let i=0;i<this.pendingDataMessages.length;++i)this.onDataMessage_(this.pendingDataMessages[i]);this.pendingDataMessages=[],this.tryCleanupConnection()}else n===pM?this.onConnectionShutdown_(r):n===P0?this.onReset_(r):n===mM?Tp("Server Error: "+r):n===N0?(this.log_("got pong on primary."),this.onPrimaryResponse_(),this.sendPingOnPrimaryIfNecessary_()):Tp("Unknown control packet command: "+n)}}onHandshake_(e){const n=e.ts,r=e.v,i=e.h;this.sessionId=e.s,this.repoInfo_.host=i,this.state_===0&&(this.conn_.start(),this.onConnectionEstablished_(this.conn_,n),Ag!==r&&nn("Protocol version mismatch detected"),this.tryStartUpgrade_())}tryStartUpgrade_(){const e=this.transportManager_.upgradeTransport();e&&this.startUpgrade_(e)}startUpgrade_(e){this.secondaryConn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,this.sessionId),this.secondaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.secondaryConn_),r=this.disconnReceiver_(this.secondaryConn_);this.secondaryConn_.open(n,r),ba(()=>{this.secondaryConn_&&(this.log_("Timed out trying to upgrade."),this.secondaryConn_.close())},Math.floor(cM))}onReset_(e){this.log_("Reset packet received.  New host: "+e),this.repoInfo_.host=e,this.state_===1?this.close():(this.closeConnections_(),this.start_())}onConnectionEstablished_(e,n){this.log_("Realtime connection established."),this.conn_=e,this.state_=1,this.onReady_&&(this.onReady_(n,this.sessionId),this.onReady_=null),this.primaryResponsesRequired_===0?(this.log_("Primary connection is healthy."),this.isHealthy_=!0):ba(()=>{this.sendPingOnPrimaryIfNecessary_()},Math.floor(hM))}sendPingOnPrimaryIfNecessary_(){!this.isHealthy_&&this.state_===1&&(this.log_("sending ping on primary."),this.sendData_({t:"c",d:{t:M0,d:{}}}))}onSecondaryConnectionLost_(){const e=this.secondaryConn_;this.secondaryConn_=null,(this.tx_===e||this.rx_===e)&&this.close()}onConnectionLost_(e){this.conn_=null,!e&&this.state_===0?(this.log_("Realtime connection failed."),this.repoInfo_.isCacheableHost()&&(Oi.remove("host:"+this.repoInfo_.host),this.repoInfo_.internalHost=this.repoInfo_.host)):this.state_===1&&this.log_("Realtime connection lost."),this.close()}onConnectionShutdown_(e){this.log_("Connection shutdown command received. Shutting down..."),this.onKill_&&(this.onKill_(e),this.onKill_=null),this.onDisconnect_=null,this.close()}sendData_(e){if(this.state_!==1)throw"Connection is not connected";this.tx_.send(e)}close(){this.state_!==2&&(this.log_("Closing realtime connection."),this.state_=2,this.closeConnections_(),this.onDisconnect_&&(this.onDisconnect_(),this.onDisconnect_=null))}closeConnections_(){this.log_("Shutting down all connections"),this.conn_&&(this.conn_.close(),this.conn_=null),this.secondaryConn_&&(this.secondaryConn_.close(),this.secondaryConn_=null),this.healthyTimeout_&&(clearTimeout(this.healthyTimeout_),this.healthyTimeout_=null)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fS{put(e,n,r,i){}merge(e,n,r,i){}refreshAuthToken(e){}refreshAppCheckToken(e){}onDisconnectPut(e,n,r){}onDisconnectMerge(e,n,r){}onDisconnectCancel(e,n){}reportStats(e){}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class pS{constructor(e){this.allowedEvents_=e,this.listeners_={},G(Array.isArray(e)&&e.length>0,"Requires a non-empty array")}trigger(e,...n){if(Array.isArray(this.listeners_[e])){const r=[...this.listeners_[e]];for(let i=0;i<r.length;i++)r[i].callback.apply(r[i].context,n)}}on(e,n,r){this.validateEventType_(e),this.listeners_[e]=this.listeners_[e]||[],this.listeners_[e].push({callback:n,context:r});const i=this.getInitialEvent(e);i&&n.apply(r,i)}off(e,n,r){this.validateEventType_(e);const i=this.listeners_[e]||[];for(let s=0;s<i.length;s++)if(i[s].callback===n&&(!r||r===i[s].context)){i.splice(s,1);return}}validateEventType_(e){G(this.allowedEvents_.find(n=>n===e),"Unknown event: "+e)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Vc extends pS{constructor(){super(["online"]),this.online_=!0,typeof window<"u"&&typeof window.addEventListener<"u"&&!Vm()&&(window.addEventListener("online",()=>{this.online_||(this.online_=!0,this.trigger("online",!0))},!1),window.addEventListener("offline",()=>{this.online_&&(this.online_=!1,this.trigger("online",!1))},!1))}static getInstance(){return new Vc}getInitialEvent(e){return G(e==="online","Unknown event type: "+e),[this.online_]}currentlyOnline(){return this.online_}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const L0=32,F0=768;class $e{constructor(e,n){if(n===void 0){this.pieces_=e.split("/");let r=0;for(let i=0;i<this.pieces_.length;i++)this.pieces_[i].length>0&&(this.pieces_[r]=this.pieces_[i],r++);this.pieces_.length=r,this.pieceNum_=0}else this.pieces_=e,this.pieceNum_=n}toString(){let e="";for(let n=this.pieceNum_;n<this.pieces_.length;n++)this.pieces_[n]!==""&&(e+="/"+this.pieces_[n]);return e||"/"}}function Pe(){return new $e("")}function de(t){return t.pieceNum_>=t.pieces_.length?null:t.pieces_[t.pieceNum_]}function pi(t){return t.pieces_.length-t.pieceNum_}function Ue(t){let e=t.pieceNum_;return e<t.pieces_.length&&e++,new $e(t.pieces_,e)}function mS(t){return t.pieceNum_<t.pieces_.length?t.pieces_[t.pieces_.length-1]:null}function yM(t){let e="";for(let n=t.pieceNum_;n<t.pieces_.length;n++)t.pieces_[n]!==""&&(e+="/"+encodeURIComponent(String(t.pieces_[n])));return e||"/"}function gS(t,e=0){return t.pieces_.slice(t.pieceNum_+e)}function _S(t){if(t.pieceNum_>=t.pieces_.length)return null;const e=[];for(let n=t.pieceNum_;n<t.pieces_.length-1;n++)e.push(t.pieces_[n]);return new $e(e,0)}function ut(t,e){const n=[];for(let r=t.pieceNum_;r<t.pieces_.length;r++)n.push(t.pieces_[r]);if(e instanceof $e)for(let r=e.pieceNum_;r<e.pieces_.length;r++)n.push(e.pieces_[r]);else{const r=e.split("/");for(let i=0;i<r.length;i++)r[i].length>0&&n.push(r[i])}return new $e(n,0)}function me(t){return t.pieceNum_>=t.pieces_.length}function yn(t,e){const n=de(t),r=de(e);if(n===null)return e;if(n===r)return yn(Ue(t),Ue(e));throw new Error("INTERNAL ERROR: innerPath ("+e+") is not within outerPath ("+t+")")}function yS(t,e){if(pi(t)!==pi(e))return!1;for(let n=t.pieceNum_,r=e.pieceNum_;n<=t.pieces_.length;n++,r++)if(t.pieces_[n]!==e.pieces_[r])return!1;return!0}function On(t,e){let n=t.pieceNum_,r=e.pieceNum_;if(pi(t)>pi(e))return!1;for(;n<t.pieces_.length;){if(t.pieces_[n]!==e.pieces_[r])return!1;++n,++r}return!0}class vM{constructor(e,n){this.errorPrefix_=n,this.parts_=gS(e,0),this.byteLength_=Math.max(1,this.parts_.length);for(let r=0;r<this.parts_.length;r++)this.byteLength_+=_h(this.parts_[r]);vS(this)}}function wM(t,e){t.parts_.length>0&&(t.byteLength_+=1),t.parts_.push(e),t.byteLength_+=_h(e),vS(t)}function EM(t){const e=t.parts_.pop();t.byteLength_-=_h(e),t.parts_.length>0&&(t.byteLength_-=1)}function vS(t){if(t.byteLength_>F0)throw new Error(t.errorPrefix_+"has a key path longer than "+F0+" bytes ("+t.byteLength_+").");if(t.parts_.length>L0)throw new Error(t.errorPrefix_+"path specified exceeds the maximum depth that can be written ("+L0+") or object contains a cycle "+xi(t))}function xi(t){return t.parts_.length===0?"":"in property '"+t.parts_.join(".")+"'"}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ng extends pS{constructor(){super(["visible"]);let e,n;typeof document<"u"&&typeof document.addEventListener<"u"&&(typeof document.hidden<"u"?(n="visibilitychange",e="hidden"):typeof document.mozHidden<"u"?(n="mozvisibilitychange",e="mozHidden"):typeof document.msHidden<"u"?(n="msvisibilitychange",e="msHidden"):typeof document.webkitHidden<"u"&&(n="webkitvisibilitychange",e="webkitHidden")),this.visible_=!0,n&&document.addEventListener(n,()=>{const r=!document[e];r!==this.visible_&&(this.visible_=r,this.trigger("visible",r))},!1)}static getInstance(){return new Ng}getInitialEvent(e){return G(e==="visible","Unknown event type: "+e),[this.visible_]}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const na=1e3,TM=60*5*1e3,V0=30*1e3,IM=1.3,SM=3e4,kM="server_kill",U0=3;class pr extends fS{constructor(e,n,r,i,s,o,a,u){if(super(),this.repoInfo_=e,this.applicationId_=n,this.onDataUpdate_=r,this.onConnectStatus_=i,this.onServerInfoUpdate_=s,this.authTokenProvider_=o,this.appCheckTokenProvider_=a,this.authOverride_=u,this.id=pr.nextPersistentConnectionId_++,this.log_=bl("p:"+this.id+":"),this.interruptReasons_={},this.listens=new Map,this.outstandingPuts_=[],this.outstandingGets_=[],this.outstandingPutCount_=0,this.outstandingGetCount_=0,this.onDisconnectRequestQueue_=[],this.connected_=!1,this.reconnectDelay_=na,this.maxReconnectDelay_=TM,this.securityDebugCallback_=null,this.lastSessionId=null,this.establishConnectionTimer_=null,this.visible_=!1,this.requestCBHash_={},this.requestNumber_=0,this.realtime_=null,this.authToken_=null,this.appCheckToken_=null,this.forceTokenRefresh_=!1,this.invalidAuthTokenCount_=0,this.invalidAppCheckTokenCount_=0,this.firstConnection_=!0,this.lastConnectionAttemptTime_=null,this.lastConnectionEstablishedTime_=null,u)throw new Error("Auth override specified in options, but not supported on non Node.js platforms");Ng.getInstance().on("visible",this.onVisible_,this),e.host.indexOf("fblocal")===-1&&Vc.getInstance().on("online",this.onOnline_,this)}sendRequest(e,n,r){const i=++this.requestNumber_,s={r:i,a:e,b:n};this.log_(Et(s)),G(this.connected_,"sendRequest call when we're not connected not allowed."),this.realtime_.sendRequest(s),r&&(this.requestCBHash_[i]=r)}get(e){this.initConnection_();const n=new gh,i={action:"g",request:{p:e._path.toString(),q:e._queryObject},onComplete:o=>{const a=o.d;o.s==="ok"?n.resolve(a):n.reject(a)}};this.outstandingGets_.push(i),this.outstandingGetCount_++;const s=this.outstandingGets_.length-1;return this.connected_&&this.sendGet_(s),n.promise}listen(e,n,r,i){this.initConnection_();const s=e._queryIdentifier,o=e._path.toString();this.log_("Listen called for "+o+" "+s),this.listens.has(o)||this.listens.set(o,new Map),G(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"listen() called for non-default but complete query"),G(!this.listens.get(o).has(s),"listen() called twice for same path/queryId.");const a={onComplete:i,hashFn:n,query:e,tag:r};this.listens.get(o).set(s,a),this.connected_&&this.sendListen_(a)}sendGet_(e){const n=this.outstandingGets_[e];this.sendRequest("g",n.request,r=>{delete this.outstandingGets_[e],this.outstandingGetCount_--,this.outstandingGetCount_===0&&(this.outstandingGets_=[]),n.onComplete&&n.onComplete(r)})}sendListen_(e){const n=e.query,r=n._path.toString(),i=n._queryIdentifier;this.log_("Listen on "+r+" for "+i);const s={p:r},o="q";e.tag&&(s.q=n._queryObject,s.t=e.tag),s.h=e.hashFn(),this.sendRequest(o,s,a=>{const u=a.d,c=a.s;pr.warnOnListenWarnings_(u,n),(this.listens.get(r)&&this.listens.get(r).get(i))===e&&(this.log_("listen response",a),c!=="ok"&&this.removeListen_(r,i),e.onComplete&&e.onComplete(c,u))})}static warnOnListenWarnings_(e,n){if(e&&typeof e=="object"&&xr(e,"w")){const r=ro(e,"w");if(Array.isArray(r)&&~r.indexOf("no_index")){const i='".indexOn": "'+n._queryParams.getIndex().toString()+'"',s=n._path.toString();nn(`Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding ${i} at ${s} to your security rules for better performance.`)}}}refreshAuthToken(e){this.authToken_=e,this.log_("Auth token refreshed"),this.authToken_?this.tryAuth():this.connected_&&this.sendRequest("unauth",{},()=>{}),this.reduceReconnectDelayIfAdminCredential_(e)}reduceReconnectDelayIfAdminCredential_(e){(e&&e.length===40||jA(e))&&(this.log_("Admin auth credential detected.  Reducing max reconnect time."),this.maxReconnectDelay_=V0)}refreshAppCheckToken(e){this.appCheckToken_=e,this.log_("App check token refreshed"),this.appCheckToken_?this.tryAppCheck():this.connected_&&this.sendRequest("unappeck",{},()=>{})}tryAuth(){if(this.connected_&&this.authToken_){const e=this.authToken_,n=UA(e)?"auth":"gauth",r={cred:e};this.authOverride_===null?r.noauth=!0:typeof this.authOverride_=="object"&&(r.authvar=this.authOverride_),this.sendRequest(n,r,i=>{const s=i.s,o=i.d||"error";this.authToken_===e&&(s==="ok"?this.invalidAuthTokenCount_=0:this.onAuthRevoked_(s,o))})}}tryAppCheck(){this.connected_&&this.appCheckToken_&&this.sendRequest("appcheck",{token:this.appCheckToken_},e=>{const n=e.s,r=e.d||"error";n==="ok"?this.invalidAppCheckTokenCount_=0:this.onAppCheckRevoked_(n,r)})}unlisten(e,n){const r=e._path.toString(),i=e._queryIdentifier;this.log_("Unlisten called for "+r+" "+i),G(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"unlisten() called for non-default but complete query"),this.removeListen_(r,i)&&this.connected_&&this.sendUnlisten_(r,i,e._queryObject,n)}sendUnlisten_(e,n,r,i){this.log_("Unlisten on "+e+" for "+n);const s={p:e},o="n";i&&(s.q=r,s.t=i),this.sendRequest(o,s)}onDisconnectPut(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("o",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"o",data:n,onComplete:r})}onDisconnectMerge(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("om",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"om",data:n,onComplete:r})}onDisconnectCancel(e,n){this.initConnection_(),this.connected_?this.sendOnDisconnect_("oc",e,null,n):this.onDisconnectRequestQueue_.push({pathString:e,action:"oc",data:null,onComplete:n})}sendOnDisconnect_(e,n,r,i){const s={p:n,d:r};this.log_("onDisconnect "+e,s),this.sendRequest(e,s,o=>{i&&setTimeout(()=>{i(o.s,o.d)},Math.floor(0))})}put(e,n,r,i){this.putInternal("p",e,n,r,i)}merge(e,n,r,i){this.putInternal("m",e,n,r,i)}putInternal(e,n,r,i,s){this.initConnection_();const o={p:n,d:r};s!==void 0&&(o.h=s),this.outstandingPuts_.push({action:e,request:o,onComplete:i}),this.outstandingPutCount_++;const a=this.outstandingPuts_.length-1;this.connected_?this.sendPut_(a):this.log_("Buffering put: "+n)}sendPut_(e){const n=this.outstandingPuts_[e].action,r=this.outstandingPuts_[e].request,i=this.outstandingPuts_[e].onComplete;this.outstandingPuts_[e].queued=this.connected_,this.sendRequest(n,r,s=>{this.log_(n+" response",s),delete this.outstandingPuts_[e],this.outstandingPutCount_--,this.outstandingPutCount_===0&&(this.outstandingPuts_=[]),i&&i(s.s,s.d)})}reportStats(e){if(this.connected_){const n={c:e};this.log_("reportStats",n),this.sendRequest("s",n,r=>{if(r.s!=="ok"){const s=r.d;this.log_("reportStats","Error sending stats: "+s)}})}}onDataMessage_(e){if("r"in e){this.log_("from server: "+Et(e));const n=e.r,r=this.requestCBHash_[n];r&&(delete this.requestCBHash_[n],r(e.b))}else{if("error"in e)throw"A server-side error has occurred: "+e.error;"a"in e&&this.onDataPush_(e.a,e.b)}}onDataPush_(e,n){this.log_("handleServerMessage",e,n),e==="d"?this.onDataUpdate_(n.p,n.d,!1,n.t):e==="m"?this.onDataUpdate_(n.p,n.d,!0,n.t):e==="c"?this.onListenRevoked_(n.p,n.q):e==="ac"?this.onAuthRevoked_(n.s,n.d):e==="apc"?this.onAppCheckRevoked_(n.s,n.d):e==="sd"?this.onSecurityDebugPacket_(n):Tp("Unrecognized action received from server: "+Et(e)+`
Are you using the latest client?`)}onReady_(e,n){this.log_("connection ready"),this.connected_=!0,this.lastConnectionEstablishedTime_=new Date().getTime(),this.handleTimestamp_(e),this.lastSessionId=n,this.firstConnection_&&this.sendConnectStats_(),this.restoreState_(),this.firstConnection_=!1,this.onConnectStatus_(!0)}scheduleConnect_(e){G(!this.realtime_,"Scheduling a connect when we're already connected/ing?"),this.establishConnectionTimer_&&clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=setTimeout(()=>{this.establishConnectionTimer_=null,this.establishConnection_()},Math.floor(e))}initConnection_(){!this.realtime_&&this.firstConnection_&&this.scheduleConnect_(0)}onVisible_(e){e&&!this.visible_&&this.reconnectDelay_===this.maxReconnectDelay_&&(this.log_("Window became visible.  Reducing delay."),this.reconnectDelay_=na,this.realtime_||this.scheduleConnect_(0)),this.visible_=e}onOnline_(e){e?(this.log_("Browser went online."),this.reconnectDelay_=na,this.realtime_||this.scheduleConnect_(0)):(this.log_("Browser went offline.  Killing connection."),this.realtime_&&this.realtime_.close())}onRealtimeDisconnect_(){if(this.log_("data client disconnected"),this.connected_=!1,this.realtime_=null,this.cancelSentTransactions_(),this.requestCBHash_={},this.shouldReconnect_()){this.visible_?this.lastConnectionEstablishedTime_&&(new Date().getTime()-this.lastConnectionEstablishedTime_>SM&&(this.reconnectDelay_=na),this.lastConnectionEstablishedTime_=null):(this.log_("Window isn't visible.  Delaying reconnect."),this.reconnectDelay_=this.maxReconnectDelay_,this.lastConnectionAttemptTime_=new Date().getTime());const e=new Date().getTime()-this.lastConnectionAttemptTime_;let n=Math.max(0,this.reconnectDelay_-e);n=Math.random()*n,this.log_("Trying to reconnect in "+n+"ms"),this.scheduleConnect_(n),this.reconnectDelay_=Math.min(this.maxReconnectDelay_,this.reconnectDelay_*IM)}this.onConnectStatus_(!1)}async establishConnection_(){if(this.shouldReconnect_()){this.log_("Making a connection attempt"),this.lastConnectionAttemptTime_=new Date().getTime(),this.lastConnectionEstablishedTime_=null;const e=this.onDataMessage_.bind(this),n=this.onReady_.bind(this),r=this.onRealtimeDisconnect_.bind(this),i=this.id+":"+pr.nextConnectionId_++,s=this.lastSessionId;let o=!1,a=null;const u=function(){a?a.close():(o=!0,r())},c=function(f){G(a,"sendRequest call when we're not connected not allowed."),a.sendRequest(f)};this.realtime_={close:u,sendRequest:c};const h=this.forceTokenRefresh_;this.forceTokenRefresh_=!1;try{const[f,g]=await Promise.all([this.authTokenProvider_.getToken(h),this.appCheckTokenProvider_.getToken(h)]);o?Ft("getToken() completed but was canceled"):(Ft("getToken() completed. Creating connection."),this.authToken_=f&&f.accessToken,this.appCheckToken_=g&&g.token,a=new _M(i,this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,e,n,r,v=>{nn(v+" ("+this.repoInfo_.toString()+")"),this.interrupt(kM)},s))}catch(f){this.log_("Failed to get token: "+f),o||(this.repoInfo_.nodeAdmin&&nn(f),u())}}}interrupt(e){Ft("Interrupting connection for reason: "+e),this.interruptReasons_[e]=!0,this.realtime_?this.realtime_.close():(this.establishConnectionTimer_&&(clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=null),this.connected_&&this.onRealtimeDisconnect_())}resume(e){Ft("Resuming connection for reason: "+e),delete this.interruptReasons_[e],Zf(this.interruptReasons_)&&(this.reconnectDelay_=na,this.realtime_||this.scheduleConnect_(0))}handleTimestamp_(e){const n=e-new Date().getTime();this.onServerInfoUpdate_({serverTimeOffset:n})}cancelSentTransactions_(){for(let e=0;e<this.outstandingPuts_.length;e++){const n=this.outstandingPuts_[e];n&&"h"in n.request&&n.queued&&(n.onComplete&&n.onComplete("disconnect"),delete this.outstandingPuts_[e],this.outstandingPutCount_--)}this.outstandingPutCount_===0&&(this.outstandingPuts_=[])}onListenRevoked_(e,n){let r;n?r=n.map(s=>xg(s)).join("$"):r="default";const i=this.removeListen_(e,r);i&&i.onComplete&&i.onComplete("permission_denied")}removeListen_(e,n){const r=new $e(e).toString();let i;if(this.listens.has(r)){const s=this.listens.get(r);i=s.get(n),s.delete(n),s.size===0&&this.listens.delete(r)}else i=void 0;return i}onAuthRevoked_(e,n){Ft("Auth token revoked: "+e+"/"+n),this.authToken_=null,this.forceTokenRefresh_=!0,this.realtime_.close(),(e==="invalid_token"||e==="permission_denied")&&(this.invalidAuthTokenCount_++,this.invalidAuthTokenCount_>=U0&&(this.reconnectDelay_=V0,this.authTokenProvider_.notifyForInvalidToken()))}onAppCheckRevoked_(e,n){Ft("App check token revoked: "+e+"/"+n),this.appCheckToken_=null,this.forceTokenRefresh_=!0,(e==="invalid_token"||e==="permission_denied")&&(this.invalidAppCheckTokenCount_++,this.invalidAppCheckTokenCount_>=U0&&this.appCheckTokenProvider_.notifyForInvalidToken())}onSecurityDebugPacket_(e){this.securityDebugCallback_?this.securityDebugCallback_(e):"msg"in e&&console.log("FIREBASE: "+e.msg.replace(`
`,`
FIREBASE: `))}restoreState_(){this.tryAuth(),this.tryAppCheck();for(const e of this.listens.values())for(const n of e.values())this.sendListen_(n);for(let e=0;e<this.outstandingPuts_.length;e++)this.outstandingPuts_[e]&&this.sendPut_(e);for(;this.onDisconnectRequestQueue_.length;){const e=this.onDisconnectRequestQueue_.shift();this.sendOnDisconnect_(e.action,e.pathString,e.data,e.onComplete)}for(let e=0;e<this.outstandingGets_.length;e++)this.outstandingGets_[e]&&this.sendGet_(e)}sendConnectStats_(){const e={};let n="js";e["sdk."+n+"."+q1.replace(/\./g,"-")]=1,Vm()?e["framework.cordova"]=1:ZT()&&(e["framework.reactnative"]=1),this.reportStats(e)}shouldReconnect_(){const e=Vc.getInstance().currentlyOnline();return Zf(this.interruptReasons_)&&e}}pr.nextPersistentConnectionId_=0;pr.nextConnectionId_=0;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ye{constructor(e,n){this.name=e,this.node=n}static Wrap(e,n){return new ye(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Dh{getCompare(){return this.compare.bind(this)}indexedValueChanged(e,n){const r=new ye(ho,e),i=new ye(ho,n);return this.compare(r,i)!==0}minPost(){return ye.MIN}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let ku;class wS extends Dh{static get __EMPTY_NODE(){return ku}static set __EMPTY_NODE(e){ku=e}compare(e,n){return ko(e.name,n.name)}isDefinedOn(e){throw _o("KeyIndex.isDefinedOn not expected to be called.")}indexedValueChanged(e,n){return!1}minPost(){return ye.MIN}maxPost(){return new ye(Qi,ku)}makePost(e,n){return G(typeof e=="string","KeyIndex indexValue must always be a string."),new ye(e,ku)}toString(){return".key"}}const Ws=new wS;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Cu{constructor(e,n,r,i,s=null){this.isReverse_=i,this.resultGenerator_=s,this.nodeStack_=[];let o=1;for(;!e.isEmpty();)if(e=e,o=n?r(e.key,n):1,i&&(o*=-1),o<0)this.isReverse_?e=e.left:e=e.right;else if(o===0){this.nodeStack_.push(e);break}else this.nodeStack_.push(e),this.isReverse_?e=e.right:e=e.left}getNext(){if(this.nodeStack_.length===0)return null;let e=this.nodeStack_.pop(),n;if(this.resultGenerator_?n=this.resultGenerator_(e.key,e.value):n={key:e.key,value:e.value},this.isReverse_)for(e=e.left;!e.isEmpty();)this.nodeStack_.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack_.push(e),e=e.left;return n}hasNext(){return this.nodeStack_.length>0}peek(){if(this.nodeStack_.length===0)return null;const e=this.nodeStack_[this.nodeStack_.length-1];return this.resultGenerator_?this.resultGenerator_(e.key,e.value):{key:e.key,value:e.value}}}class mt{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??mt.RED,this.left=i??Jt.EMPTY_NODE,this.right=s??Jt.EMPTY_NODE}copy(e,n,r,i,s){return new mt(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}count(){return this.left.count()+1+this.right.count()}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||!!e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min_(){return this.left.isEmpty()?this:this.left.min_()}minKey(){return this.min_().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return s<0?i=i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i=i.copy(null,n,null,null,null):i=i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp_()}removeMin_(){if(this.left.isEmpty())return Jt.EMPTY_NODE;let e=this;return!e.left.isRed_()&&!e.left.left.isRed_()&&(e=e.moveRedLeft_()),e=e.copy(null,null,null,e.left.removeMin_(),null),e.fixUp_()}remove(e,n){let r,i;if(r=this,n(e,r.key)<0)!r.left.isEmpty()&&!r.left.isRed_()&&!r.left.left.isRed_()&&(r=r.moveRedLeft_()),r=r.copy(null,null,null,r.left.remove(e,n),null);else{if(r.left.isRed_()&&(r=r.rotateRight_()),!r.right.isEmpty()&&!r.right.isRed_()&&!r.right.left.isRed_()&&(r=r.moveRedRight_()),n(e,r.key)===0){if(r.right.isEmpty())return Jt.EMPTY_NODE;i=r.right.min_(),r=r.copy(i.key,i.value,null,null,r.right.removeMin_())}r=r.copy(null,null,null,null,r.right.remove(e,n))}return r.fixUp_()}isRed_(){return this.color}fixUp_(){let e=this;return e.right.isRed_()&&!e.left.isRed_()&&(e=e.rotateLeft_()),e.left.isRed_()&&e.left.left.isRed_()&&(e=e.rotateRight_()),e.left.isRed_()&&e.right.isRed_()&&(e=e.colorFlip_()),e}moveRedLeft_(){let e=this.colorFlip_();return e.right.left.isRed_()&&(e=e.copy(null,null,null,null,e.right.rotateRight_()),e=e.rotateLeft_(),e=e.colorFlip_()),e}moveRedRight_(){let e=this.colorFlip_();return e.left.left.isRed_()&&(e=e.rotateRight_(),e=e.colorFlip_()),e}rotateLeft_(){const e=this.copy(null,null,mt.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight_(){const e=this.copy(null,null,mt.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip_(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth_(){const e=this.check_();return Math.pow(2,e)<=this.count()+1}check_(){if(this.isRed_()&&this.left.isRed_())throw new Error("Red node has red child("+this.key+","+this.value+")");if(this.right.isRed_())throw new Error("Right child of ("+this.key+","+this.value+") is red");const e=this.left.check_();if(e!==this.right.check_())throw new Error("Black depths differ");return e+(this.isRed_()?0:1)}}mt.RED=!0;mt.BLACK=!1;class CM{copy(e,n,r,i,s){return this}insert(e,n,r){return new mt(e,n,null)}remove(e,n){return this}count(){return 0}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}check_(){return 0}isRed_(){return!1}}class Jt{constructor(e,n=Jt.EMPTY_NODE){this.comparator_=e,this.root_=n}insert(e,n){return new Jt(this.comparator_,this.root_.insert(e,n,this.comparator_).copy(null,null,mt.BLACK,null,null))}remove(e){return new Jt(this.comparator_,this.root_.remove(e,this.comparator_).copy(null,null,mt.BLACK,null,null))}get(e){let n,r=this.root_;for(;!r.isEmpty();){if(n=this.comparator_(e,r.key),n===0)return r.value;n<0?r=r.left:n>0&&(r=r.right)}return null}getPredecessorKey(e){let n,r=this.root_,i=null;for(;!r.isEmpty();)if(n=this.comparator_(e,r.key),n===0){if(r.left.isEmpty())return i?i.key:null;for(r=r.left;!r.right.isEmpty();)r=r.right;return r.key}else n<0?r=r.left:n>0&&(i=r,r=r.right);throw new Error("Attempted to find predecessor key for a nonexistent key.  What gives?")}isEmpty(){return this.root_.isEmpty()}count(){return this.root_.count()}minKey(){return this.root_.minKey()}maxKey(){return this.root_.maxKey()}inorderTraversal(e){return this.root_.inorderTraversal(e)}reverseTraversal(e){return this.root_.reverseTraversal(e)}getIterator(e){return new Cu(this.root_,null,this.comparator_,!1,e)}getIteratorFrom(e,n){return new Cu(this.root_,e,this.comparator_,!1,n)}getReverseIteratorFrom(e,n){return new Cu(this.root_,e,this.comparator_,!0,n)}getReverseIterator(e){return new Cu(this.root_,null,this.comparator_,!0,e)}}Jt.EMPTY_NODE=new CM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function RM(t,e){return ko(t.name,e.name)}function Dg(t,e){return ko(t,e)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Sp;function xM(t){Sp=t}const ES=function(t){return typeof t=="number"?"number:"+Y1(t):"string:"+t},TS=function(t){if(t.isLeafNode()){const e=t.val();G(typeof e=="string"||typeof e=="number"||typeof e=="object"&&xr(e,".sv"),"Priority must be a string or number.")}else G(t===Sp||t.isEmpty(),"priority of unexpected type.");G(t===Sp||t.getPriority().isEmpty(),"Priority nodes can't have a priority of their own.")};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let j0;class dt{constructor(e,n=dt.__childrenNodeConstructor.EMPTY_NODE){this.value_=e,this.priorityNode_=n,this.lazyHash_=null,G(this.value_!==void 0&&this.value_!==null,"LeafNode shouldn't be created with null/undefined value."),TS(this.priorityNode_)}static set __childrenNodeConstructor(e){j0=e}static get __childrenNodeConstructor(){return j0}isLeafNode(){return!0}getPriority(){return this.priorityNode_}updatePriority(e){return new dt(this.value_,e)}getImmediateChild(e){return e===".priority"?this.priorityNode_:dt.__childrenNodeConstructor.EMPTY_NODE}getChild(e){return me(e)?this:de(e)===".priority"?this.priorityNode_:dt.__childrenNodeConstructor.EMPTY_NODE}hasChild(){return!1}getPredecessorChildName(e,n){return null}updateImmediateChild(e,n){return e===".priority"?this.updatePriority(n):n.isEmpty()&&e!==".priority"?this:dt.__childrenNodeConstructor.EMPTY_NODE.updateImmediateChild(e,n).updatePriority(this.priorityNode_)}updateChild(e,n){const r=de(e);return r===null?n:n.isEmpty()&&r!==".priority"?this:(G(r!==".priority"||pi(e)===1,".priority must be the last token in a path"),this.updateImmediateChild(r,dt.__childrenNodeConstructor.EMPTY_NODE.updateChild(Ue(e),n)))}isEmpty(){return!1}numChildren(){return 0}forEachChild(e,n){return!1}val(e){return e&&!this.getPriority().isEmpty()?{".value":this.getValue(),".priority":this.getPriority().val()}:this.getValue()}hash(){if(this.lazyHash_===null){let e="";this.priorityNode_.isEmpty()||(e+="priority:"+ES(this.priorityNode_.val())+":");const n=typeof this.value_;e+=n+":",n==="number"?e+=Y1(this.value_):e+=this.value_,this.lazyHash_=G1(e)}return this.lazyHash_}getValue(){return this.value_}compareTo(e){return e===dt.__childrenNodeConstructor.EMPTY_NODE?1:e instanceof dt.__childrenNodeConstructor?-1:(G(e.isLeafNode(),"Unknown node type"),this.compareToLeafNode_(e))}compareToLeafNode_(e){const n=typeof e.value_,r=typeof this.value_,i=dt.VALUE_TYPE_ORDER.indexOf(n),s=dt.VALUE_TYPE_ORDER.indexOf(r);return G(i>=0,"Unknown leaf type: "+n),G(s>=0,"Unknown leaf type: "+r),i===s?r==="object"?0:this.value_<e.value_?-1:this.value_===e.value_?0:1:s-i}withIndex(){return this}isIndexed(){return!0}equals(e){if(e===this)return!0;if(e.isLeafNode()){const n=e;return this.value_===n.value_&&this.priorityNode_.equals(n.priorityNode_)}else return!1}}dt.VALUE_TYPE_ORDER=["object","boolean","number","string"];/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let IS,SS;function AM(t){IS=t}function bM(t){SS=t}class PM extends Dh{compare(e,n){const r=e.node.getPriority(),i=n.node.getPriority(),s=r.compareTo(i);return s===0?ko(e.name,n.name):s}isDefinedOn(e){return!e.getPriority().isEmpty()}indexedValueChanged(e,n){return!e.getPriority().equals(n.getPriority())}minPost(){return ye.MIN}maxPost(){return new ye(Qi,new dt("[PRIORITY-POST]",SS))}makePost(e,n){const r=IS(e);return new ye(n,new dt("[PRIORITY-POST]",r))}toString(){return".priority"}}const Vt=new PM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const NM=Math.log(2);class DM{constructor(e){const n=s=>parseInt(Math.log(s)/NM,10),r=s=>parseInt(Array(s+1).join("1"),2);this.count=n(e+1),this.current_=this.count-1;const i=r(this.count);this.bits_=e+1&i}nextBitIsOne(){const e=!(this.bits_&1<<this.current_);return this.current_--,e}}const Uc=function(t,e,n,r){t.sort(e);const i=function(u,c){const h=c-u;let f,g;if(h===0)return null;if(h===1)return f=t[u],g=n?n(f):f,new mt(g,f.node,mt.BLACK,null,null);{const v=parseInt(h/2,10)+u,I=i(u,v),N=i(v+1,c);return f=t[v],g=n?n(f):f,new mt(g,f.node,mt.BLACK,I,N)}},s=function(u){let c=null,h=null,f=t.length;const g=function(I,N){const D=f-I,C=f;f-=I;const w=i(D+1,C),R=t[D],M=n?n(R):R;v(new mt(M,R.node,N,null,w))},v=function(I){c?(c.left=I,c=I):(h=I,c=I)};for(let I=0;I<u.count;++I){const N=u.nextBitIsOne(),D=Math.pow(2,u.count-(I+1));N?g(D,mt.BLACK):(g(D,mt.BLACK),g(D,mt.RED))}return h},o=new DM(t.length),a=s(o);return new Jt(r||e,a)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Yd;const _s={};class lr{constructor(e,n){this.indexes_=e,this.indexSet_=n}static get Default(){return G(_s&&Vt,"ChildrenNode.ts has not been loaded"),Yd=Yd||new lr({".priority":_s},{".priority":Vt}),Yd}get(e){const n=ro(this.indexes_,e);if(!n)throw new Error("No index defined for "+e);return n instanceof Jt?n:null}hasIndex(e){return xr(this.indexSet_,e.toString())}addIndex(e,n){G(e!==Ws,"KeyIndex always exists and isn't meant to be added to the IndexMap.");const r=[];let i=!1;const s=n.getIterator(ye.Wrap);let o=s.getNext();for(;o;)i=i||e.isDefinedOn(o.node),r.push(o),o=s.getNext();let a;i?a=Uc(r,e.getCompare()):a=_s;const u=e.toString(),c=Object.assign({},this.indexSet_);c[u]=e;const h=Object.assign({},this.indexes_);return h[u]=a,new lr(h,c)}addToIndexes(e,n){const r=Cc(this.indexes_,(i,s)=>{const o=ro(this.indexSet_,s);if(G(o,"Missing index implementation for "+s),i===_s)if(o.isDefinedOn(e.node)){const a=[],u=n.getIterator(ye.Wrap);let c=u.getNext();for(;c;)c.name!==e.name&&a.push(c),c=u.getNext();return a.push(e),Uc(a,o.getCompare())}else return _s;else{const a=n.get(e.name);let u=i;return a&&(u=u.remove(new ye(e.name,a))),u.insert(e,e.node)}});return new lr(r,this.indexSet_)}removeFromIndexes(e,n){const r=Cc(this.indexes_,i=>{if(i===_s)return i;{const s=n.get(e.name);return s?i.remove(new ye(e.name,s)):i}});return new lr(r,this.indexSet_)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let ra;class Ce{constructor(e,n,r){this.children_=e,this.priorityNode_=n,this.indexMap_=r,this.lazyHash_=null,this.priorityNode_&&TS(this.priorityNode_),this.children_.isEmpty()&&G(!this.priorityNode_||this.priorityNode_.isEmpty(),"An empty node cannot have a priority")}static get EMPTY_NODE(){return ra||(ra=new Ce(new Jt(Dg),null,lr.Default))}isLeafNode(){return!1}getPriority(){return this.priorityNode_||ra}updatePriority(e){return this.children_.isEmpty()?this:new Ce(this.children_,e,this.indexMap_)}getImmediateChild(e){if(e===".priority")return this.getPriority();{const n=this.children_.get(e);return n===null?ra:n}}getChild(e){const n=de(e);return n===null?this:this.getImmediateChild(n).getChild(Ue(e))}hasChild(e){return this.children_.get(e)!==null}updateImmediateChild(e,n){if(G(n,"We should always be passing snapshot nodes"),e===".priority")return this.updatePriority(n);{const r=new ye(e,n);let i,s;n.isEmpty()?(i=this.children_.remove(e),s=this.indexMap_.removeFromIndexes(r,this.children_)):(i=this.children_.insert(e,n),s=this.indexMap_.addToIndexes(r,this.children_));const o=i.isEmpty()?ra:this.priorityNode_;return new Ce(i,o,s)}}updateChild(e,n){const r=de(e);if(r===null)return n;{G(de(e)!==".priority"||pi(e)===1,".priority must be the last token in a path");const i=this.getImmediateChild(r).updateChild(Ue(e),n);return this.updateImmediateChild(r,i)}}isEmpty(){return this.children_.isEmpty()}numChildren(){return this.children_.count()}val(e){if(this.isEmpty())return null;const n={};let r=0,i=0,s=!0;if(this.forEachChild(Vt,(o,a)=>{n[o]=a.val(e),r++,s&&Ce.INTEGER_REGEXP_.test(o)?i=Math.max(i,Number(o)):s=!1}),!e&&s&&i<2*r){const o=[];for(const a in n)o[a]=n[a];return o}else return e&&!this.getPriority().isEmpty()&&(n[".priority"]=this.getPriority().val()),n}hash(){if(this.lazyHash_===null){let e="";this.getPriority().isEmpty()||(e+="priority:"+ES(this.getPriority().val())+":"),this.forEachChild(Vt,(n,r)=>{const i=r.hash();i!==""&&(e+=":"+n+":"+i)}),this.lazyHash_=e===""?"":G1(e)}return this.lazyHash_}getPredecessorChildName(e,n,r){const i=this.resolveIndex_(r);if(i){const s=i.getPredecessorKey(new ye(e,n));return s?s.name:null}else return this.children_.getPredecessorKey(e)}getFirstChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.minKey();return r&&r.name}else return this.children_.minKey()}getFirstChild(e){const n=this.getFirstChildName(e);return n?new ye(n,this.children_.get(n)):null}getLastChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.maxKey();return r&&r.name}else return this.children_.maxKey()}getLastChild(e){const n=this.getLastChildName(e);return n?new ye(n,this.children_.get(n)):null}forEachChild(e,n){const r=this.resolveIndex_(e);return r?r.inorderTraversal(i=>n(i.name,i.node)):this.children_.inorderTraversal(n)}getIterator(e){return this.getIteratorFrom(e.minPost(),e)}getIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getIteratorFrom(e,i=>i);{const i=this.children_.getIteratorFrom(e.name,ye.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)<0;)i.getNext(),s=i.peek();return i}}getReverseIterator(e){return this.getReverseIteratorFrom(e.maxPost(),e)}getReverseIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getReverseIteratorFrom(e,i=>i);{const i=this.children_.getReverseIteratorFrom(e.name,ye.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)>0;)i.getNext(),s=i.peek();return i}}compareTo(e){return this.isEmpty()?e.isEmpty()?0:-1:e.isLeafNode()||e.isEmpty()?1:e===Pl?-1:0}withIndex(e){if(e===Ws||this.indexMap_.hasIndex(e))return this;{const n=this.indexMap_.addIndex(e,this.children_);return new Ce(this.children_,this.priorityNode_,n)}}isIndexed(e){return e===Ws||this.indexMap_.hasIndex(e)}equals(e){if(e===this)return!0;if(e.isLeafNode())return!1;{const n=e;if(this.getPriority().equals(n.getPriority()))if(this.children_.count()===n.children_.count()){const r=this.getIterator(Vt),i=n.getIterator(Vt);let s=r.getNext(),o=i.getNext();for(;s&&o;){if(s.name!==o.name||!s.node.equals(o.node))return!1;s=r.getNext(),o=i.getNext()}return s===null&&o===null}else return!1;else return!1}}resolveIndex_(e){return e===Ws?null:this.indexMap_.get(e.toString())}}Ce.INTEGER_REGEXP_=/^(0|[1-9]\d*)$/;class OM extends Ce{constructor(){super(new Jt(Dg),Ce.EMPTY_NODE,lr.Default)}compareTo(e){return e===this?0:1}equals(e){return e===this}getPriority(){return this}getImmediateChild(e){return Ce.EMPTY_NODE}isEmpty(){return!1}}const Pl=new OM;Object.defineProperties(ye,{MIN:{value:new ye(ho,Ce.EMPTY_NODE)},MAX:{value:new ye(Qi,Pl)}});wS.__EMPTY_NODE=Ce.EMPTY_NODE;dt.__childrenNodeConstructor=Ce;xM(Pl);bM(Pl);/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const MM=!0;function wt(t,e=null){if(t===null)return Ce.EMPTY_NODE;if(typeof t=="object"&&".priority"in t&&(e=t[".priority"]),G(e===null||typeof e=="string"||typeof e=="number"||typeof e=="object"&&".sv"in e,"Invalid priority type found: "+typeof e),typeof t=="object"&&".value"in t&&t[".value"]!==null&&(t=t[".value"]),typeof t!="object"||".sv"in t){const n=t;return new dt(n,wt(e))}if(!(t instanceof Array)&&MM){const n=[];let r=!1;if(Cn(t,(o,a)=>{if(o.substring(0,1)!=="."){const u=wt(a);u.isEmpty()||(r=r||!u.getPriority().isEmpty(),n.push(new ye(o,u)))}}),n.length===0)return Ce.EMPTY_NODE;const s=Uc(n,RM,o=>o.name,Dg);if(r){const o=Uc(n,Vt.getCompare());return new Ce(s,wt(e),new lr({".priority":o},{".priority":Vt}))}else return new Ce(s,wt(e),lr.Default)}else{let n=Ce.EMPTY_NODE;return Cn(t,(r,i)=>{if(xr(t,r)&&r.substring(0,1)!=="."){const s=wt(i);(s.isLeafNode()||!s.isEmpty())&&(n=n.updateImmediateChild(r,s))}}),n.updatePriority(wt(e))}}AM(wt);/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class LM extends Dh{constructor(e){super(),this.indexPath_=e,G(!me(e)&&de(e)!==".priority","Can't create PathIndex with empty path or .priority key")}extractChild(e){return e.getChild(this.indexPath_)}isDefinedOn(e){return!e.getChild(this.indexPath_).isEmpty()}compare(e,n){const r=this.extractChild(e.node),i=this.extractChild(n.node),s=r.compareTo(i);return s===0?ko(e.name,n.name):s}makePost(e,n){const r=wt(e),i=Ce.EMPTY_NODE.updateChild(this.indexPath_,r);return new ye(n,i)}maxPost(){const e=Ce.EMPTY_NODE.updateChild(this.indexPath_,Pl);return new ye(Qi,e)}toString(){return gS(this.indexPath_,0).join("/")}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class FM extends Dh{compare(e,n){const r=e.node.compareTo(n.node);return r===0?ko(e.name,n.name):r}isDefinedOn(e){return!0}indexedValueChanged(e,n){return!e.equals(n)}minPost(){return ye.MIN}maxPost(){return ye.MAX}makePost(e,n){const r=wt(e);return new ye(n,r)}toString(){return".value"}}const VM=new FM;/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function UM(t){return{type:"value",snapshotNode:t}}function jM(t,e){return{type:"child_added",snapshotNode:e,childName:t}}function zM(t,e){return{type:"child_removed",snapshotNode:e,childName:t}}function z0(t,e,n){return{type:"child_changed",snapshotNode:e,childName:t,oldSnap:n}}function BM(t,e){return{type:"child_moved",snapshotNode:e,childName:t}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Og{constructor(){this.limitSet_=!1,this.startSet_=!1,this.startNameSet_=!1,this.startAfterSet_=!1,this.endSet_=!1,this.endNameSet_=!1,this.endBeforeSet_=!1,this.limit_=0,this.viewFrom_="",this.indexStartValue_=null,this.indexStartName_="",this.indexEndValue_=null,this.indexEndName_="",this.index_=Vt}hasStart(){return this.startSet_}isViewFromLeft(){return this.viewFrom_===""?this.startSet_:this.viewFrom_==="l"}getIndexStartValue(){return G(this.startSet_,"Only valid if start has been set"),this.indexStartValue_}getIndexStartName(){return G(this.startSet_,"Only valid if start has been set"),this.startNameSet_?this.indexStartName_:ho}hasEnd(){return this.endSet_}getIndexEndValue(){return G(this.endSet_,"Only valid if end has been set"),this.indexEndValue_}getIndexEndName(){return G(this.endSet_,"Only valid if end has been set"),this.endNameSet_?this.indexEndName_:Qi}hasLimit(){return this.limitSet_}hasAnchoredLimit(){return this.limitSet_&&this.viewFrom_!==""}getLimit(){return G(this.limitSet_,"Only valid if limit has been set"),this.limit_}getIndex(){return this.index_}loadsAllData(){return!(this.startSet_||this.endSet_||this.limitSet_)}isDefault(){return this.loadsAllData()&&this.index_===Vt}copy(){const e=new Og;return e.limitSet_=this.limitSet_,e.limit_=this.limit_,e.startSet_=this.startSet_,e.startAfterSet_=this.startAfterSet_,e.indexStartValue_=this.indexStartValue_,e.startNameSet_=this.startNameSet_,e.indexStartName_=this.indexStartName_,e.endSet_=this.endSet_,e.endBeforeSet_=this.endBeforeSet_,e.indexEndValue_=this.indexEndValue_,e.endNameSet_=this.endNameSet_,e.indexEndName_=this.indexEndName_,e.index_=this.index_,e.viewFrom_=this.viewFrom_,e}}function B0(t){const e={};if(t.isDefault())return e;let n;if(t.index_===Vt?n="$priority":t.index_===VM?n="$value":t.index_===Ws?n="$key":(G(t.index_ instanceof LM,"Unrecognized index type!"),n=t.index_.toString()),e.orderBy=Et(n),t.startSet_){const r=t.startAfterSet_?"startAfter":"startAt";e[r]=Et(t.indexStartValue_),t.startNameSet_&&(e[r]+=","+Et(t.indexStartName_))}if(t.endSet_){const r=t.endBeforeSet_?"endBefore":"endAt";e[r]=Et(t.indexEndValue_),t.endNameSet_&&(e[r]+=","+Et(t.indexEndName_))}return t.limitSet_&&(t.isViewFromLeft()?e.limitToFirst=t.limit_:e.limitToLast=t.limit_),e}function $0(t){const e={};if(t.startSet_&&(e.sp=t.indexStartValue_,t.startNameSet_&&(e.sn=t.indexStartName_),e.sin=!t.startAfterSet_),t.endSet_&&(e.ep=t.indexEndValue_,t.endNameSet_&&(e.en=t.indexEndName_),e.ein=!t.endBeforeSet_),t.limitSet_){e.l=t.limit_;let n=t.viewFrom_;n===""&&(t.isViewFromLeft()?n="l":n="r"),e.vf=n}return t.index_!==Vt&&(e.i=t.index_.toString()),e}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jc extends fS{constructor(e,n,r,i){super(),this.repoInfo_=e,this.onDataUpdate_=n,this.authTokenProvider_=r,this.appCheckTokenProvider_=i,this.log_=bl("p:rest:"),this.listens_={}}reportStats(e){throw new Error("Method not implemented.")}static getListenId_(e,n){return n!==void 0?"tag$"+n:(G(e._queryParams.isDefault(),"should have a tag if it's not a default query."),e._path.toString())}listen(e,n,r,i){const s=e._path.toString();this.log_("Listen called for "+s+" "+e._queryIdentifier);const o=jc.getListenId_(e,r),a={};this.listens_[o]=a;const u=B0(e._queryParams);this.restRequest_(s+".json",u,(c,h)=>{let f=h;if(c===404&&(f=null,c=null),c===null&&this.onDataUpdate_(s,f,!1,r),ro(this.listens_,o)===a){let g;c?c===401?g="permission_denied":g="rest_error:"+c:g="ok",i(g,null)}})}unlisten(e,n){const r=jc.getListenId_(e,n);delete this.listens_[r]}get(e){const n=B0(e._queryParams),r=e._path.toString(),i=new gh;return this.restRequest_(r+".json",n,(s,o)=>{let a=o;s===404&&(a=null,s=null),s===null?(this.onDataUpdate_(r,a,!1,null),i.resolve(a)):i.reject(new Error(a))}),i.promise}refreshAuthToken(e){}restRequest_(e,n={},r){return n.format="export",Promise.all([this.authTokenProvider_.getToken(!1),this.appCheckTokenProvider_.getToken(!1)]).then(([i,s])=>{i&&i.accessToken&&(n.auth=i.accessToken),s&&s.token&&(n.ac=s.token);const o=(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host+e+"?ns="+this.repoInfo_.namespace+yo(n);this.log_("Sending REST request for "+o);const a=new XMLHttpRequest;a.onreadystatechange=()=>{if(r&&a.readyState===4){this.log_("REST Response for "+o+" received. status:",a.status,"response:",a.responseText);let u=null;if(a.status>=200&&a.status<300){try{u=tl(a.responseText)}catch{nn("Failed to parse JSON response for "+o+": "+a.responseText)}r(null,u)}else a.status!==401&&a.status!==404&&nn("Got unsuccessful REST response for "+o+" Status: "+a.status),r(a.status);r=null}},a.open("GET",o,!0),a.send()})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $M{constructor(){this.rootNode_=Ce.EMPTY_NODE}getNode(e){return this.rootNode_.getChild(e)}updateSnapshot(e,n){this.rootNode_=this.rootNode_.updateChild(e,n)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function zc(){return{value:null,children:new Map}}function kS(t,e,n){if(me(e))t.value=n,t.children.clear();else if(t.value!==null)t.value=t.value.updateChild(e,n);else{const r=de(e);t.children.has(r)||t.children.set(r,zc());const i=t.children.get(r);e=Ue(e),kS(i,e,n)}}function kp(t,e,n){t.value!==null?n(e,t.value):WM(t,(r,i)=>{const s=new $e(e.toString()+"/"+r);kp(i,s,n)})}function WM(t,e){t.children.forEach((n,r)=>{e(r,n)})}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class qM{constructor(e){this.collection_=e,this.last_=null}get(){const e=this.collection_.get(),n=Object.assign({},e);return this.last_&&Cn(this.last_,(r,i)=>{n[r]=n[r]-i}),this.last_=e,n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const W0=10*1e3,HM=30*1e3,GM=5*60*1e3;class KM{constructor(e,n){this.server_=n,this.statsToReport_={},this.statsListener_=new qM(e);const r=W0+(HM-W0)*Math.random();ba(this.reportStats_.bind(this),Math.floor(r))}reportStats_(){const e=this.statsListener_.get(),n={};let r=!1;Cn(e,(i,s)=>{s>0&&xr(this.statsToReport_,i)&&(n[i]=s,r=!0)}),r&&this.server_.reportStats(n),ba(this.reportStats_.bind(this),Math.floor(Math.random()*2*GM))}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */var Wn;(function(t){t[t.OVERWRITE=0]="OVERWRITE",t[t.MERGE=1]="MERGE",t[t.ACK_USER_WRITE=2]="ACK_USER_WRITE",t[t.LISTEN_COMPLETE=3]="LISTEN_COMPLETE"})(Wn||(Wn={}));function CS(){return{fromUser:!0,fromServer:!1,queryId:null,tagged:!1}}function RS(){return{fromUser:!1,fromServer:!0,queryId:null,tagged:!1}}function xS(t){return{fromUser:!1,fromServer:!0,queryId:t,tagged:!0}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Bc{constructor(e,n,r){this.path=e,this.affectedTree=n,this.revert=r,this.type=Wn.ACK_USER_WRITE,this.source=CS()}operationForChild(e){if(me(this.path)){if(this.affectedTree.value!=null)return G(this.affectedTree.children.isEmpty(),"affectedTree should not have overlapping affected paths."),this;{const n=this.affectedTree.subtree(new $e(e));return new Bc(Pe(),n,this.revert)}}else return G(de(this.path)===e,"operationForChild called for unrelated child."),new Bc(Ue(this.path),this.affectedTree,this.revert)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Yi{constructor(e,n,r){this.source=e,this.path=n,this.snap=r,this.type=Wn.OVERWRITE}operationForChild(e){return me(this.path)?new Yi(this.source,Pe(),this.snap.getImmediateChild(e)):new Yi(this.source,Ue(this.path),this.snap)}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fl{constructor(e,n,r){this.source=e,this.path=n,this.children=r,this.type=Wn.MERGE}operationForChild(e){if(me(this.path)){const n=this.children.subtree(new $e(e));return n.isEmpty()?null:n.value?new Yi(this.source,Pe(),n.value):new fl(this.source,Pe(),n)}else return G(de(this.path)===e,"Can't get a merge for a child not on the path of the operation"),new fl(this.source,Ue(this.path),this.children)}toString(){return"Operation("+this.path+": "+this.source.toString()+" merge: "+this.children.toString()+")"}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Mg{constructor(e,n,r){this.node_=e,this.fullyInitialized_=n,this.filtered_=r}isFullyInitialized(){return this.fullyInitialized_}isFiltered(){return this.filtered_}isCompleteForPath(e){if(me(e))return this.isFullyInitialized()&&!this.filtered_;const n=de(e);return this.isCompleteForChild(n)}isCompleteForChild(e){return this.isFullyInitialized()&&!this.filtered_||this.node_.hasChild(e)}getNode(){return this.node_}}function QM(t,e,n,r){const i=[],s=[];return e.forEach(o=>{o.type==="child_changed"&&t.index_.indexedValueChanged(o.oldSnap,o.snapshotNode)&&s.push(BM(o.childName,o.snapshotNode))}),ia(t,i,"child_removed",e,r,n),ia(t,i,"child_added",e,r,n),ia(t,i,"child_moved",s,r,n),ia(t,i,"child_changed",e,r,n),ia(t,i,"value",e,r,n),i}function ia(t,e,n,r,i,s){const o=r.filter(a=>a.type===n);o.sort((a,u)=>XM(t,a,u)),o.forEach(a=>{const u=YM(t,a,s);i.forEach(c=>{c.respondsTo(a.type)&&e.push(c.createEvent(u,t.query_))})})}function YM(t,e,n){return e.type==="value"||e.type==="child_removed"||(e.prevName=n.getPredecessorChildName(e.childName,e.snapshotNode,t.index_)),e}function XM(t,e,n){if(e.childName==null||n.childName==null)throw _o("Should only compare child_ events.");const r=new ye(e.childName,e.snapshotNode),i=new ye(n.childName,n.snapshotNode);return t.index_.compare(r,i)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function AS(t,e){return{eventCache:t,serverCache:e}}function Pa(t,e,n,r){return AS(new Mg(e,n,r),t.serverCache)}function bS(t,e,n,r){return AS(t.eventCache,new Mg(e,n,r))}function Cp(t){return t.eventCache.isFullyInitialized()?t.eventCache.getNode():null}function Xi(t){return t.serverCache.isFullyInitialized()?t.serverCache.getNode():null}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Xd;const JM=()=>(Xd||(Xd=new Jt(VO)),Xd);class Ve{constructor(e,n=JM()){this.value=e,this.children=n}static fromObject(e){let n=new Ve(null);return Cn(e,(r,i)=>{n=n.set(new $e(r),i)}),n}isEmpty(){return this.value===null&&this.children.isEmpty()}findRootMostMatchingPathAndValue(e,n){if(this.value!=null&&n(this.value))return{path:Pe(),value:this.value};if(me(e))return null;{const r=de(e),i=this.children.get(r);if(i!==null){const s=i.findRootMostMatchingPathAndValue(Ue(e),n);return s!=null?{path:ut(new $e(r),s.path),value:s.value}:null}else return null}}findRootMostValueAndPath(e){return this.findRootMostMatchingPathAndValue(e,()=>!0)}subtree(e){if(me(e))return this;{const n=de(e),r=this.children.get(n);return r!==null?r.subtree(Ue(e)):new Ve(null)}}set(e,n){if(me(e))return new Ve(n,this.children);{const r=de(e),s=(this.children.get(r)||new Ve(null)).set(Ue(e),n),o=this.children.insert(r,s);return new Ve(this.value,o)}}remove(e){if(me(e))return this.children.isEmpty()?new Ve(null):new Ve(null,this.children);{const n=de(e),r=this.children.get(n);if(r){const i=r.remove(Ue(e));let s;return i.isEmpty()?s=this.children.remove(n):s=this.children.insert(n,i),this.value===null&&s.isEmpty()?new Ve(null):new Ve(this.value,s)}else return this}}get(e){if(me(e))return this.value;{const n=de(e),r=this.children.get(n);return r?r.get(Ue(e)):null}}setTree(e,n){if(me(e))return n;{const r=de(e),s=(this.children.get(r)||new Ve(null)).setTree(Ue(e),n);let o;return s.isEmpty()?o=this.children.remove(r):o=this.children.insert(r,s),new Ve(this.value,o)}}fold(e){return this.fold_(Pe(),e)}fold_(e,n){const r={};return this.children.inorderTraversal((i,s)=>{r[i]=s.fold_(ut(e,i),n)}),n(e,this.value,r)}findOnPath(e,n){return this.findOnPath_(e,Pe(),n)}findOnPath_(e,n,r){const i=this.value?r(n,this.value):!1;if(i)return i;if(me(e))return null;{const s=de(e),o=this.children.get(s);return o?o.findOnPath_(Ue(e),ut(n,s),r):null}}foreachOnPath(e,n){return this.foreachOnPath_(e,Pe(),n)}foreachOnPath_(e,n,r){if(me(e))return this;{this.value&&r(n,this.value);const i=de(e),s=this.children.get(i);return s?s.foreachOnPath_(Ue(e),ut(n,i),r):new Ve(null)}}foreach(e){this.foreach_(Pe(),e)}foreach_(e,n){this.children.inorderTraversal((r,i)=>{i.foreach_(ut(e,r),n)}),this.value&&n(e,this.value)}foreachChild(e){this.children.inorderTraversal((n,r)=>{r.value&&e(n,r.value)})}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Fn{constructor(e){this.writeTree_=e}static empty(){return new Fn(new Ve(null))}}function Na(t,e,n){if(me(e))return new Fn(new Ve(n));{const r=t.writeTree_.findRootMostValueAndPath(e);if(r!=null){const i=r.path;let s=r.value;const o=yn(i,e);return s=s.updateChild(o,n),new Fn(t.writeTree_.set(i,s))}else{const i=new Ve(n),s=t.writeTree_.setTree(e,i);return new Fn(s)}}}function q0(t,e,n){let r=t;return Cn(n,(i,s)=>{r=Na(r,ut(e,i),s)}),r}function H0(t,e){if(me(e))return Fn.empty();{const n=t.writeTree_.setTree(e,new Ve(null));return new Fn(n)}}function Rp(t,e){return os(t,e)!=null}function os(t,e){const n=t.writeTree_.findRootMostValueAndPath(e);return n!=null?t.writeTree_.get(n.path).getChild(yn(n.path,e)):null}function G0(t){const e=[],n=t.writeTree_.value;return n!=null?n.isLeafNode()||n.forEachChild(Vt,(r,i)=>{e.push(new ye(r,i))}):t.writeTree_.children.inorderTraversal((r,i)=>{i.value!=null&&e.push(new ye(r,i.value))}),e}function oi(t,e){if(me(e))return t;{const n=os(t,e);return n!=null?new Fn(new Ve(n)):new Fn(t.writeTree_.subtree(e))}}function xp(t){return t.writeTree_.isEmpty()}function fo(t,e){return PS(Pe(),t.writeTree_,e)}function PS(t,e,n){if(e.value!=null)return n.updateChild(t,e.value);{let r=null;return e.children.inorderTraversal((i,s)=>{i===".priority"?(G(s.value!==null,"Priority writes must always be leaf nodes"),r=s.value):n=PS(ut(t,i),s,n)}),!n.getChild(t).isEmpty()&&r!==null&&(n=n.updateChild(ut(t,".priority"),r)),n}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function NS(t,e){return FS(e,t)}function ZM(t,e,n,r,i){G(r>t.lastWriteId,"Stacking an older write on top of newer ones"),i===void 0&&(i=!0),t.allWrites.push({path:e,snap:n,writeId:r,visible:i}),i&&(t.visibleWrites=Na(t.visibleWrites,e,n)),t.lastWriteId=r}function eL(t,e){for(let n=0;n<t.allWrites.length;n++){const r=t.allWrites[n];if(r.writeId===e)return r}return null}function tL(t,e){const n=t.allWrites.findIndex(a=>a.writeId===e);G(n>=0,"removeWrite called with nonexistent writeId.");const r=t.allWrites[n];t.allWrites.splice(n,1);let i=r.visible,s=!1,o=t.allWrites.length-1;for(;i&&o>=0;){const a=t.allWrites[o];a.visible&&(o>=n&&nL(a,r.path)?i=!1:On(r.path,a.path)&&(s=!0)),o--}if(i){if(s)return rL(t),!0;if(r.snap)t.visibleWrites=H0(t.visibleWrites,r.path);else{const a=r.children;Cn(a,u=>{t.visibleWrites=H0(t.visibleWrites,ut(r.path,u))})}return!0}else return!1}function nL(t,e){if(t.snap)return On(t.path,e);for(const n in t.children)if(t.children.hasOwnProperty(n)&&On(ut(t.path,n),e))return!0;return!1}function rL(t){t.visibleWrites=DS(t.allWrites,iL,Pe()),t.allWrites.length>0?t.lastWriteId=t.allWrites[t.allWrites.length-1].writeId:t.lastWriteId=-1}function iL(t){return t.visible}function DS(t,e,n){let r=Fn.empty();for(let i=0;i<t.length;++i){const s=t[i];if(e(s)){const o=s.path;let a;if(s.snap)On(n,o)?(a=yn(n,o),r=Na(r,a,s.snap)):On(o,n)&&(a=yn(o,n),r=Na(r,Pe(),s.snap.getChild(a)));else if(s.children){if(On(n,o))a=yn(n,o),r=q0(r,a,s.children);else if(On(o,n))if(a=yn(o,n),me(a))r=q0(r,Pe(),s.children);else{const u=ro(s.children,de(a));if(u){const c=u.getChild(Ue(a));r=Na(r,Pe(),c)}}}else throw _o("WriteRecord should have .snap or .children")}}return r}function OS(t,e,n,r,i){if(!r&&!i){const s=os(t.visibleWrites,e);if(s!=null)return s;{const o=oi(t.visibleWrites,e);if(xp(o))return n;if(n==null&&!Rp(o,Pe()))return null;{const a=n||Ce.EMPTY_NODE;return fo(o,a)}}}else{const s=oi(t.visibleWrites,e);if(!i&&xp(s))return n;if(!i&&n==null&&!Rp(s,Pe()))return null;{const o=function(c){return(c.visible||i)&&(!r||!~r.indexOf(c.writeId))&&(On(c.path,e)||On(e,c.path))},a=DS(t.allWrites,o,e),u=n||Ce.EMPTY_NODE;return fo(a,u)}}}function sL(t,e,n){let r=Ce.EMPTY_NODE;const i=os(t.visibleWrites,e);if(i)return i.isLeafNode()||i.forEachChild(Vt,(s,o)=>{r=r.updateImmediateChild(s,o)}),r;if(n){const s=oi(t.visibleWrites,e);return n.forEachChild(Vt,(o,a)=>{const u=fo(oi(s,new $e(o)),a);r=r.updateImmediateChild(o,u)}),G0(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}else{const s=oi(t.visibleWrites,e);return G0(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}}function oL(t,e,n,r,i){G(r||i,"Either existingEventSnap or existingServerSnap must exist");const s=ut(e,n);if(Rp(t.visibleWrites,s))return null;{const o=oi(t.visibleWrites,s);return xp(o)?i.getChild(n):fo(o,i.getChild(n))}}function aL(t,e,n,r){const i=ut(e,n),s=os(t.visibleWrites,i);if(s!=null)return s;if(r.isCompleteForChild(n)){const o=oi(t.visibleWrites,i);return fo(o,r.getNode().getImmediateChild(n))}else return null}function lL(t,e){return os(t.visibleWrites,e)}function uL(t,e,n,r,i,s,o){let a;const u=oi(t.visibleWrites,e),c=os(u,Pe());if(c!=null)a=c;else if(n!=null)a=fo(u,n);else return[];if(a=a.withIndex(o),!a.isEmpty()&&!a.isLeafNode()){const h=[],f=o.getCompare(),g=s?a.getReverseIteratorFrom(r,o):a.getIteratorFrom(r,o);let v=g.getNext();for(;v&&h.length<i;)f(v,r)!==0&&h.push(v),v=g.getNext();return h}else return[]}function cL(){return{visibleWrites:Fn.empty(),allWrites:[],lastWriteId:-1}}function Ap(t,e,n,r){return OS(t.writeTree,t.treePath,e,n,r)}function MS(t,e){return sL(t.writeTree,t.treePath,e)}function K0(t,e,n,r){return oL(t.writeTree,t.treePath,e,n,r)}function $c(t,e){return lL(t.writeTree,ut(t.treePath,e))}function hL(t,e,n,r,i,s){return uL(t.writeTree,t.treePath,e,n,r,i,s)}function Lg(t,e,n){return aL(t.writeTree,t.treePath,e,n)}function LS(t,e){return FS(ut(t.treePath,e),t.writeTree)}function FS(t,e){return{treePath:t,writeTree:e}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class dL{constructor(){this.changeMap=new Map}trackChildChange(e){const n=e.type,r=e.childName;G(n==="child_added"||n==="child_changed"||n==="child_removed","Only child changes supported for tracking"),G(r!==".priority","Only non-priority child changes can be tracked.");const i=this.changeMap.get(r);if(i){const s=i.type;if(n==="child_added"&&s==="child_removed")this.changeMap.set(r,z0(r,e.snapshotNode,i.snapshotNode));else if(n==="child_removed"&&s==="child_added")this.changeMap.delete(r);else if(n==="child_removed"&&s==="child_changed")this.changeMap.set(r,zM(r,i.oldSnap));else if(n==="child_changed"&&s==="child_added")this.changeMap.set(r,jM(r,e.snapshotNode));else if(n==="child_changed"&&s==="child_changed")this.changeMap.set(r,z0(r,e.snapshotNode,i.oldSnap));else throw _o("Illegal combination of changes: "+e+" occurred after "+i)}else this.changeMap.set(r,e)}getChanges(){return Array.from(this.changeMap.values())}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class fL{getCompleteChild(e){return null}getChildAfterChild(e,n,r){return null}}const VS=new fL;class Fg{constructor(e,n,r=null){this.writes_=e,this.viewCache_=n,this.optCompleteServerCache_=r}getCompleteChild(e){const n=this.viewCache_.eventCache;if(n.isCompleteForChild(e))return n.getNode().getImmediateChild(e);{const r=this.optCompleteServerCache_!=null?new Mg(this.optCompleteServerCache_,!0,!1):this.viewCache_.serverCache;return Lg(this.writes_,e,r)}}getChildAfterChild(e,n,r){const i=this.optCompleteServerCache_!=null?this.optCompleteServerCache_:Xi(this.viewCache_),s=hL(this.writes_,i,n,1,r,e);return s.length===0?null:s[0]}}function pL(t,e){G(e.eventCache.getNode().isIndexed(t.filter.getIndex()),"Event snap not indexed"),G(e.serverCache.getNode().isIndexed(t.filter.getIndex()),"Server snap not indexed")}function mL(t,e,n,r,i){const s=new dL;let o,a;if(n.type===Wn.OVERWRITE){const c=n;c.source.fromUser?o=bp(t,e,c.path,c.snap,r,i,s):(G(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered()&&!me(c.path),o=Wc(t,e,c.path,c.snap,r,i,a,s))}else if(n.type===Wn.MERGE){const c=n;c.source.fromUser?o=_L(t,e,c.path,c.children,r,i,s):(G(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered(),o=Pp(t,e,c.path,c.children,r,i,a,s))}else if(n.type===Wn.ACK_USER_WRITE){const c=n;c.revert?o=wL(t,e,c.path,r,i,s):o=yL(t,e,c.path,c.affectedTree,r,i,s)}else if(n.type===Wn.LISTEN_COMPLETE)o=vL(t,e,n.path,r,s);else throw _o("Unknown operation type: "+n.type);const u=s.getChanges();return gL(e,o,u),{viewCache:o,changes:u}}function gL(t,e,n){const r=e.eventCache;if(r.isFullyInitialized()){const i=r.getNode().isLeafNode()||r.getNode().isEmpty(),s=Cp(t);(n.length>0||!t.eventCache.isFullyInitialized()||i&&!r.getNode().equals(s)||!r.getNode().getPriority().equals(s.getPriority()))&&n.push(UM(Cp(e)))}}function US(t,e,n,r,i,s){const o=e.eventCache;if($c(r,n)!=null)return e;{let a,u;if(me(n))if(G(e.serverCache.isFullyInitialized(),"If change path is empty, we must have complete server data"),e.serverCache.isFiltered()){const c=Xi(e),h=c instanceof Ce?c:Ce.EMPTY_NODE,f=MS(r,h);a=t.filter.updateFullNode(e.eventCache.getNode(),f,s)}else{const c=Ap(r,Xi(e));a=t.filter.updateFullNode(e.eventCache.getNode(),c,s)}else{const c=de(n);if(c===".priority"){G(pi(n)===1,"Can't have a priority with additional path components");const h=o.getNode();u=e.serverCache.getNode();const f=K0(r,n,h,u);f!=null?a=t.filter.updatePriority(h,f):a=o.getNode()}else{const h=Ue(n);let f;if(o.isCompleteForChild(c)){u=e.serverCache.getNode();const g=K0(r,n,o.getNode(),u);g!=null?f=o.getNode().getImmediateChild(c).updateChild(h,g):f=o.getNode().getImmediateChild(c)}else f=Lg(r,c,e.serverCache);f!=null?a=t.filter.updateChild(o.getNode(),c,f,h,i,s):a=o.getNode()}}return Pa(e,a,o.isFullyInitialized()||me(n),t.filter.filtersNodes())}}function Wc(t,e,n,r,i,s,o,a){const u=e.serverCache;let c;const h=o?t.filter:t.filter.getIndexedFilter();if(me(n))c=h.updateFullNode(u.getNode(),r,null);else if(h.filtersNodes()&&!u.isFiltered()){const v=u.getNode().updateChild(n,r);c=h.updateFullNode(u.getNode(),v,null)}else{const v=de(n);if(!u.isCompleteForPath(n)&&pi(n)>1)return e;const I=Ue(n),D=u.getNode().getImmediateChild(v).updateChild(I,r);v===".priority"?c=h.updatePriority(u.getNode(),D):c=h.updateChild(u.getNode(),v,D,I,VS,null)}const f=bS(e,c,u.isFullyInitialized()||me(n),h.filtersNodes()),g=new Fg(i,f,s);return US(t,f,n,i,g,a)}function bp(t,e,n,r,i,s,o){const a=e.eventCache;let u,c;const h=new Fg(i,e,s);if(me(n))c=t.filter.updateFullNode(e.eventCache.getNode(),r,o),u=Pa(e,c,!0,t.filter.filtersNodes());else{const f=de(n);if(f===".priority")c=t.filter.updatePriority(e.eventCache.getNode(),r),u=Pa(e,c,a.isFullyInitialized(),a.isFiltered());else{const g=Ue(n),v=a.getNode().getImmediateChild(f);let I;if(me(g))I=r;else{const N=h.getCompleteChild(f);N!=null?mS(g)===".priority"&&N.getChild(_S(g)).isEmpty()?I=N:I=N.updateChild(g,r):I=Ce.EMPTY_NODE}if(v.equals(I))u=e;else{const N=t.filter.updateChild(a.getNode(),f,I,g,h,o);u=Pa(e,N,a.isFullyInitialized(),t.filter.filtersNodes())}}}return u}function Q0(t,e){return t.eventCache.isCompleteForChild(e)}function _L(t,e,n,r,i,s,o){let a=e;return r.foreach((u,c)=>{const h=ut(n,u);Q0(e,de(h))&&(a=bp(t,a,h,c,i,s,o))}),r.foreach((u,c)=>{const h=ut(n,u);Q0(e,de(h))||(a=bp(t,a,h,c,i,s,o))}),a}function Y0(t,e,n){return n.foreach((r,i)=>{e=e.updateChild(r,i)}),e}function Pp(t,e,n,r,i,s,o,a){if(e.serverCache.getNode().isEmpty()&&!e.serverCache.isFullyInitialized())return e;let u=e,c;me(n)?c=r:c=new Ve(null).setTree(n,r);const h=e.serverCache.getNode();return c.children.inorderTraversal((f,g)=>{if(h.hasChild(f)){const v=e.serverCache.getNode().getImmediateChild(f),I=Y0(t,v,g);u=Wc(t,u,new $e(f),I,i,s,o,a)}}),c.children.inorderTraversal((f,g)=>{const v=!e.serverCache.isCompleteForChild(f)&&g.value===null;if(!h.hasChild(f)&&!v){const I=e.serverCache.getNode().getImmediateChild(f),N=Y0(t,I,g);u=Wc(t,u,new $e(f),N,i,s,o,a)}}),u}function yL(t,e,n,r,i,s,o){if($c(i,n)!=null)return e;const a=e.serverCache.isFiltered(),u=e.serverCache;if(r.value!=null){if(me(n)&&u.isFullyInitialized()||u.isCompleteForPath(n))return Wc(t,e,n,u.getNode().getChild(n),i,s,a,o);if(me(n)){let c=new Ve(null);return u.getNode().forEachChild(Ws,(h,f)=>{c=c.set(new $e(h),f)}),Pp(t,e,n,c,i,s,a,o)}else return e}else{let c=new Ve(null);return r.foreach((h,f)=>{const g=ut(n,h);u.isCompleteForPath(g)&&(c=c.set(h,u.getNode().getChild(g)))}),Pp(t,e,n,c,i,s,a,o)}}function vL(t,e,n,r,i){const s=e.serverCache,o=bS(e,s.getNode(),s.isFullyInitialized()||me(n),s.isFiltered());return US(t,o,n,r,VS,i)}function wL(t,e,n,r,i,s){let o;if($c(r,n)!=null)return e;{const a=new Fg(r,e,i),u=e.eventCache.getNode();let c;if(me(n)||de(n)===".priority"){let h;if(e.serverCache.isFullyInitialized())h=Ap(r,Xi(e));else{const f=e.serverCache.getNode();G(f instanceof Ce,"serverChildren would be complete if leaf node"),h=MS(r,f)}h=h,c=t.filter.updateFullNode(u,h,s)}else{const h=de(n);let f=Lg(r,h,e.serverCache);f==null&&e.serverCache.isCompleteForChild(h)&&(f=u.getImmediateChild(h)),f!=null?c=t.filter.updateChild(u,h,f,Ue(n),a,s):e.eventCache.getNode().hasChild(h)?c=t.filter.updateChild(u,h,Ce.EMPTY_NODE,Ue(n),a,s):c=u,c.isEmpty()&&e.serverCache.isFullyInitialized()&&(o=Ap(r,Xi(e)),o.isLeafNode()&&(c=t.filter.updateFullNode(c,o,s)))}return o=e.serverCache.isFullyInitialized()||$c(r,Pe())!=null,Pa(e,c,o,t.filter.filtersNodes())}}function EL(t,e){const n=Xi(t.viewCache_);return n&&(t.query._queryParams.loadsAllData()||!me(e)&&!n.getImmediateChild(de(e)).isEmpty())?n.getChild(e):null}function X0(t,e,n,r){e.type===Wn.MERGE&&e.source.queryId!==null&&(G(Xi(t.viewCache_),"We should always have a full cache before handling merges"),G(Cp(t.viewCache_),"Missing event cache, even though we have a server cache"));const i=t.viewCache_,s=mL(t.processor_,i,e,n,r);return pL(t.processor_,s.viewCache),G(s.viewCache.serverCache.isFullyInitialized()||!i.serverCache.isFullyInitialized(),"Once a server snap is complete, it should never go back"),t.viewCache_=s.viewCache,TL(t,s.changes,s.viewCache.eventCache.getNode())}function TL(t,e,n,r){const i=t.eventRegistrations_;return QM(t.eventGenerator_,e,n,i)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let J0;function IL(t){G(!J0,"__referenceConstructor has already been defined"),J0=t}function Vg(t,e,n,r){const i=e.source.queryId;if(i!==null){const s=t.views.get(i);return G(s!=null,"SyncTree gave us an op for an invalid query."),X0(s,e,n,r)}else{let s=[];for(const o of t.views.values())s=s.concat(X0(o,e,n,r));return s}}function Ug(t,e){let n=null;for(const r of t.views.values())n=n||EL(r,e);return n}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let Z0;function SL(t){G(!Z0,"__referenceConstructor has already been defined"),Z0=t}class ew{constructor(e){this.listenProvider_=e,this.syncPointTree_=new Ve(null),this.pendingWriteTree_=cL(),this.tagToQueryMap=new Map,this.queryToTagMap=new Map}}function jS(t,e,n,r,i){return ZM(t.pendingWriteTree_,e,n,r,i),i?Mh(t,new Yi(CS(),e,n)):[]}function Mi(t,e,n=!1){const r=eL(t.pendingWriteTree_,e);if(tL(t.pendingWriteTree_,e)){let s=new Ve(null);return r.snap!=null?s=s.set(Pe(),!0):Cn(r.children,o=>{s=s.set(new $e(o),!0)}),Mh(t,new Bc(r.path,s,n))}else return[]}function Oh(t,e,n){return Mh(t,new Yi(RS(),e,n))}function kL(t,e,n){const r=Ve.fromObject(n);return Mh(t,new fl(RS(),e,r))}function CL(t,e,n,r){const i=$S(t,r);if(i!=null){const s=WS(i),o=s.path,a=s.queryId,u=yn(o,e),c=new Yi(xS(a),u,n);return qS(t,o,c)}else return[]}function RL(t,e,n,r){const i=$S(t,r);if(i){const s=WS(i),o=s.path,a=s.queryId,u=yn(o,e),c=Ve.fromObject(n),h=new fl(xS(a),u,c);return qS(t,o,h)}else return[]}function jg(t,e,n){const i=t.pendingWriteTree_,s=t.syncPointTree_.findOnPath(e,(o,a)=>{const u=yn(o,e),c=Ug(a,u);if(c)return c});return OS(i,e,s,n,!0)}function Mh(t,e){return zS(e,t.syncPointTree_,null,NS(t.pendingWriteTree_,Pe()))}function zS(t,e,n,r){if(me(t.path))return BS(t,e,n,r);{const i=e.get(Pe());n==null&&i!=null&&(n=Ug(i,Pe()));let s=[];const o=de(t.path),a=t.operationForChild(o),u=e.children.get(o);if(u&&a){const c=n?n.getImmediateChild(o):null,h=LS(r,o);s=s.concat(zS(a,u,c,h))}return i&&(s=s.concat(Vg(i,t,r,n))),s}}function BS(t,e,n,r){const i=e.get(Pe());n==null&&i!=null&&(n=Ug(i,Pe()));let s=[];return e.children.inorderTraversal((o,a)=>{const u=n?n.getImmediateChild(o):null,c=LS(r,o),h=t.operationForChild(o);h&&(s=s.concat(BS(h,a,u,c)))}),i&&(s=s.concat(Vg(i,t,r,n))),s}function $S(t,e){return t.tagToQueryMap.get(e)}function WS(t){const e=t.indexOf("$");return G(e!==-1&&e<t.length-1,"Bad queryKey."),{queryId:t.substr(e+1),path:new $e(t.substr(0,e))}}function qS(t,e,n){const r=t.syncPointTree_.get(e);G(r,"Missing sync point for query tag that we're tracking");const i=NS(t.pendingWriteTree_,e);return Vg(r,n,i,null)}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zg{constructor(e){this.node_=e}getImmediateChild(e){const n=this.node_.getImmediateChild(e);return new zg(n)}node(){return this.node_}}class Bg{constructor(e,n){this.syncTree_=e,this.path_=n}getImmediateChild(e){const n=ut(this.path_,e);return new Bg(this.syncTree_,n)}node(){return jg(this.syncTree_,this.path_)}}const xL=function(t){return t=t||{},t.timestamp=t.timestamp||new Date().getTime(),t},tw=function(t,e,n){if(!t||typeof t!="object")return t;if(G(".sv"in t,"Unexpected leaf node or priority contents"),typeof t[".sv"]=="string")return AL(t[".sv"],e,n);if(typeof t[".sv"]=="object")return bL(t[".sv"],e);G(!1,"Unexpected server value: "+JSON.stringify(t,null,2))},AL=function(t,e,n){switch(t){case"timestamp":return n.timestamp;default:G(!1,"Unexpected server value: "+t)}},bL=function(t,e,n){t.hasOwnProperty("increment")||G(!1,"Unexpected server value: "+JSON.stringify(t,null,2));const r=t.increment;typeof r!="number"&&G(!1,"Unexpected increment value: "+r);const i=e.node();if(G(i!==null&&typeof i<"u","Expected ChildrenNode.EMPTY_NODE for nulls"),!i.isLeafNode())return r;const o=i.getValue();return typeof o!="number"?r:o+r},PL=function(t,e,n,r){return $g(e,new Bg(n,t),r)},HS=function(t,e,n){return $g(t,new zg(e),n)};function $g(t,e,n){const r=t.getPriority().val(),i=tw(r,e.getImmediateChild(".priority"),n);let s;if(t.isLeafNode()){const o=t,a=tw(o.getValue(),e,n);return a!==o.getValue()||i!==o.getPriority().val()?new dt(a,wt(i)):t}else{const o=t;return s=o,i!==o.getPriority().val()&&(s=s.updatePriority(new dt(i))),o.forEachChild(Vt,(a,u)=>{const c=$g(u,e.getImmediateChild(a),n);c!==u&&(s=s.updateImmediateChild(a,c))}),s}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Wg{constructor(e="",n=null,r={children:{},childCount:0}){this.name=e,this.parent=n,this.node=r}}function qg(t,e){let n=e instanceof $e?e:new $e(e),r=t,i=de(n);for(;i!==null;){const s=ro(r.node.children,i)||{children:{},childCount:0};r=new Wg(i,r,s),n=Ue(n),i=de(n)}return r}function Ro(t){return t.node.value}function GS(t,e){t.node.value=e,Np(t)}function KS(t){return t.node.childCount>0}function NL(t){return Ro(t)===void 0&&!KS(t)}function Lh(t,e){Cn(t.node.children,(n,r)=>{e(new Wg(n,t,r))})}function QS(t,e,n,r){n&&e(t),Lh(t,i=>{QS(i,e,!0)})}function DL(t,e,n){let r=t.parent;for(;r!==null;){if(e(r))return!0;r=r.parent}return!1}function Nl(t){return new $e(t.parent===null?t.name:Nl(t.parent)+"/"+t.name)}function Np(t){t.parent!==null&&OL(t.parent,t.name,t)}function OL(t,e,n){const r=NL(n),i=xr(t.node.children,e);r&&i?(delete t.node.children[e],t.node.childCount--,Np(t)):!r&&!i&&(t.node.children[e]=n.node,t.node.childCount++,Np(t))}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const ML=/[\[\].#$\/\u0000-\u001F\u007F]/,LL=/[\[\].#$\u0000-\u001F\u007F]/,Jd=10*1024*1024,YS=function(t){return typeof t=="string"&&t.length!==0&&!ML.test(t)},XS=function(t){return typeof t=="string"&&t.length!==0&&!LL.test(t)},FL=function(t){return t&&(t=t.replace(/^\/*\.info(\/|$)/,"/")),XS(t)},VL=function(t,e,n,r){Hg(Um(t,"value"),e,n)},Hg=function(t,e,n){const r=n instanceof $e?new vM(n,t):n;if(e===void 0)throw new Error(t+"contains undefined "+xi(r));if(typeof e=="function")throw new Error(t+"contains a function "+xi(r)+" with contents = "+e.toString());if(K1(e))throw new Error(t+"contains "+e.toString()+" "+xi(r));if(typeof e=="string"&&e.length>Jd/3&&_h(e)>Jd)throw new Error(t+"contains a string greater than "+Jd+" utf8 bytes "+xi(r)+" ('"+e.substring(0,50)+"...')");if(e&&typeof e=="object"){let i=!1,s=!1;if(Cn(e,(o,a)=>{if(o===".value")i=!0;else if(o!==".priority"&&o!==".sv"&&(s=!0,!YS(o)))throw new Error(t+" contains an invalid key ("+o+") "+xi(r)+`.  Keys must be non-empty strings and can't contain ".", "#", "$", "/", "[", or "]"`);wM(r,o),Hg(t,a,r),EM(r)}),i&&s)throw new Error(t+' contains ".value" child '+xi(r)+" in addition to actual children.")}},JS=function(t,e,n,r){if(!XS(n))throw new Error(Um(t,e)+'was an invalid path = "'+n+`". Paths must be non-empty strings and can't contain ".", "#", "$", "[", or "]"`)},UL=function(t,e,n,r){n&&(n=n.replace(/^\/*\.info(\/|$)/,"/")),JS(t,e,n)},ZS=function(t,e){if(de(e)===".info")throw new Error(t+" failed = Can't modify data under /.info/")},jL=function(t,e){const n=e.path.toString();if(typeof e.repoInfo.host!="string"||e.repoInfo.host.length===0||!YS(e.repoInfo.namespace)&&e.repoInfo.host.split(":")[0]!=="localhost"||n.length!==0&&!FL(n))throw new Error(Um(t,"url")+`must be a valid firebase URL and the path can't contain ".", "#", "$", "[", or "]".`)};/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zL{constructor(){this.eventLists_=[],this.recursionDepth_=0}}function ek(t,e){let n=null;for(let r=0;r<e.length;r++){const i=e[r],s=i.getPath();n!==null&&!yS(s,n.path)&&(t.eventLists_.push(n),n=null),n===null&&(n={events:[],path:s}),n.events.push(i)}n&&t.eventLists_.push(n)}function Sr(t,e,n){ek(t,n),BL(t,r=>On(r,e)||On(e,r))}function BL(t,e){t.recursionDepth_++;let n=!0;for(let r=0;r<t.eventLists_.length;r++){const i=t.eventLists_[r];if(i){const s=i.path;e(s)?($L(t.eventLists_[r]),t.eventLists_[r]=null):n=!1}}n&&(t.eventLists_=[]),t.recursionDepth_--}function $L(t){for(let e=0;e<t.events.length;e++){const n=t.events[e];if(n!==null){t.events[e]=null;const r=n.getEventRunner();Aa&&Ft("event: "+n.toString()),Co(r)}}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const WL="repo_interrupt",qL=25;class HL{constructor(e,n,r,i){this.repoInfo_=e,this.forceRestClient_=n,this.authTokenProvider_=r,this.appCheckProvider_=i,this.dataUpdateCount=0,this.statsListener_=null,this.eventQueue_=new zL,this.nextWriteId_=1,this.interceptServerDataCallback_=null,this.onDisconnect_=zc(),this.transactionQueueTree_=new Wg,this.persistentConnection_=null,this.key=this.repoInfo_.toURLString()}toString(){return(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host}}function GL(t,e,n){if(t.stats_=bg(t.repoInfo_),t.forceRestClient_||WO())t.server_=new jc(t.repoInfo_,(r,i,s,o)=>{nw(t,r,i,s,o)},t.authTokenProvider_,t.appCheckProvider_),setTimeout(()=>rw(t,!0),0);else{if(typeof n<"u"&&n!==null){if(typeof n!="object")throw new Error("Only objects are supported for option databaseAuthVariableOverride");try{Et(n)}catch(r){throw new Error("Invalid authOverride provided: "+r)}}t.persistentConnection_=new pr(t.repoInfo_,e,(r,i,s,o)=>{nw(t,r,i,s,o)},r=>{rw(t,r)},r=>{QL(t,r)},t.authTokenProvider_,t.appCheckProvider_,n),t.server_=t.persistentConnection_}t.authTokenProvider_.addTokenChangeListener(r=>{t.server_.refreshAuthToken(r)}),t.appCheckProvider_.addTokenChangeListener(r=>{t.server_.refreshAppCheckToken(r.token)}),t.statsReporter_=QO(t.repoInfo_,()=>new KM(t.stats_,t.server_)),t.infoData_=new $M,t.infoSyncTree_=new ew({startListening:(r,i,s,o)=>{let a=[];const u=t.infoData_.getNode(r._path);return u.isEmpty()||(a=Oh(t.infoSyncTree_,r._path,u),setTimeout(()=>{o("ok")},0)),a},stopListening:()=>{}}),Kg(t,"connected",!1),t.serverSyncTree_=new ew({startListening:(r,i,s,o)=>(t.server_.listen(r,s,i,(a,u)=>{const c=o(a,u);Sr(t.eventQueue_,r._path,c)}),[]),stopListening:(r,i)=>{t.server_.unlisten(r,i)}})}function KL(t){const n=t.infoData_.getNode(new $e(".info/serverTimeOffset")).val()||0;return new Date().getTime()+n}function Gg(t){return xL({timestamp:KL(t)})}function nw(t,e,n,r,i){t.dataUpdateCount++;const s=new $e(e);n=t.interceptServerDataCallback_?t.interceptServerDataCallback_(e,n):n;let o=[];if(i)if(r){const u=Cc(n,c=>wt(c));o=RL(t.serverSyncTree_,s,u,i)}else{const u=wt(n);o=CL(t.serverSyncTree_,s,u,i)}else if(r){const u=Cc(n,c=>wt(c));o=kL(t.serverSyncTree_,s,u)}else{const u=wt(n);o=Oh(t.serverSyncTree_,s,u)}let a=s;o.length>0&&(a=Fh(t,s)),Sr(t.eventQueue_,a,o)}function rw(t,e){Kg(t,"connected",e),e===!1&&XL(t)}function QL(t,e){Cn(e,(n,r)=>{Kg(t,n,r)})}function Kg(t,e,n){const r=new $e("/.info/"+e),i=wt(n);t.infoData_.updateSnapshot(r,i);const s=Oh(t.infoSyncTree_,r,i);Sr(t.eventQueue_,r,s)}function tk(t){return t.nextWriteId_++}function YL(t,e,n,r,i){Qg(t,"set",{path:e.toString(),value:n,priority:r});const s=Gg(t),o=wt(n,r),a=jg(t.serverSyncTree_,e),u=HS(o,a,s),c=tk(t),h=jS(t.serverSyncTree_,e,u,c,!0);ek(t.eventQueue_,h),t.server_.put(e.toString(),o.val(!0),(g,v)=>{const I=g==="ok";I||nn("set at "+e+" failed: "+g);const N=Mi(t.serverSyncTree_,c,!I);Sr(t.eventQueue_,e,N),ZL(t,i,g,v)});const f=ok(t,e);Fh(t,f),Sr(t.eventQueue_,f,[])}function XL(t){Qg(t,"onDisconnectEvents");const e=Gg(t),n=zc();kp(t.onDisconnect_,Pe(),(i,s)=>{const o=PL(i,s,t.serverSyncTree_,e);kS(n,i,o)});let r=[];kp(n,Pe(),(i,s)=>{r=r.concat(Oh(t.serverSyncTree_,i,s));const o=ok(t,i);Fh(t,o)}),t.onDisconnect_=zc(),Sr(t.eventQueue_,Pe(),r)}function JL(t){t.persistentConnection_&&t.persistentConnection_.interrupt(WL)}function Qg(t,...e){let n="";t.persistentConnection_&&(n=t.persistentConnection_.id+":"),Ft(n,...e)}function ZL(t,e,n,r){e&&Co(()=>{if(n==="ok")e(null);else{const i=(n||"error").toUpperCase();let s=i;r&&(s+=": "+r);const o=new Error(s);o.code=i,e(o)}})}function nk(t,e,n){return jg(t.serverSyncTree_,e,n)||Ce.EMPTY_NODE}function Yg(t,e=t.transactionQueueTree_){if(e||Vh(t,e),Ro(e)){const n=ik(t,e);G(n.length>0,"Sending zero length transaction queue"),n.every(i=>i.status===0)&&e4(t,Nl(e),n)}else KS(e)&&Lh(e,n=>{Yg(t,n)})}function e4(t,e,n){const r=n.map(c=>c.currentWriteId),i=nk(t,e,r);let s=i;const o=i.hash();for(let c=0;c<n.length;c++){const h=n[c];G(h.status===0,"tryToSendTransactionQueue_: items in queue should all be run."),h.status=1,h.retryCount++;const f=yn(e,h.path);s=s.updateChild(f,h.currentOutputSnapshotRaw)}const a=s.val(!0),u=e;t.server_.put(u.toString(),a,c=>{Qg(t,"transaction put response",{path:u.toString(),status:c});let h=[];if(c==="ok"){const f=[];for(let g=0;g<n.length;g++)n[g].status=2,h=h.concat(Mi(t.serverSyncTree_,n[g].currentWriteId)),n[g].onComplete&&f.push(()=>n[g].onComplete(null,!0,n[g].currentOutputSnapshotResolved)),n[g].unwatcher();Vh(t,qg(t.transactionQueueTree_,e)),Yg(t,t.transactionQueueTree_),Sr(t.eventQueue_,e,h);for(let g=0;g<f.length;g++)Co(f[g])}else{if(c==="datastale")for(let f=0;f<n.length;f++)n[f].status===3?n[f].status=4:n[f].status=0;else{nn("transaction at "+u.toString()+" failed: "+c);for(let f=0;f<n.length;f++)n[f].status=4,n[f].abortReason=c}Fh(t,e)}},o)}function Fh(t,e){const n=rk(t,e),r=Nl(n),i=ik(t,n);return t4(t,i,r),r}function t4(t,e,n){if(e.length===0)return;const r=[];let i=[];const o=e.filter(a=>a.status===0).map(a=>a.currentWriteId);for(let a=0;a<e.length;a++){const u=e[a],c=yn(n,u.path);let h=!1,f;if(G(c!==null,"rerunTransactionsUnderNode_: relativePath should not be null."),u.status===4)h=!0,f=u.abortReason,i=i.concat(Mi(t.serverSyncTree_,u.currentWriteId,!0));else if(u.status===0)if(u.retryCount>=qL)h=!0,f="maxretry",i=i.concat(Mi(t.serverSyncTree_,u.currentWriteId,!0));else{const g=nk(t,u.path,o);u.currentInputSnapshot=g;const v=e[a].update(g.val());if(v!==void 0){Hg("transaction failed: Data returned ",v,u.path);let I=wt(v);typeof v=="object"&&v!=null&&xr(v,".priority")||(I=I.updatePriority(g.getPriority()));const D=u.currentWriteId,C=Gg(t),w=HS(I,g,C);u.currentOutputSnapshotRaw=I,u.currentOutputSnapshotResolved=w,u.currentWriteId=tk(t),o.splice(o.indexOf(D),1),i=i.concat(jS(t.serverSyncTree_,u.path,w,u.currentWriteId,u.applyLocally)),i=i.concat(Mi(t.serverSyncTree_,D,!0))}else h=!0,f="nodata",i=i.concat(Mi(t.serverSyncTree_,u.currentWriteId,!0))}Sr(t.eventQueue_,n,i),i=[],h&&(e[a].status=2,function(g){setTimeout(g,Math.floor(0))}(e[a].unwatcher),e[a].onComplete&&(f==="nodata"?r.push(()=>e[a].onComplete(null,!1,e[a].currentInputSnapshot)):r.push(()=>e[a].onComplete(new Error(f),!1,null))))}Vh(t,t.transactionQueueTree_);for(let a=0;a<r.length;a++)Co(r[a]);Yg(t,t.transactionQueueTree_)}function rk(t,e){let n,r=t.transactionQueueTree_;for(n=de(e);n!==null&&Ro(r)===void 0;)r=qg(r,n),e=Ue(e),n=de(e);return r}function ik(t,e){const n=[];return sk(t,e,n),n.sort((r,i)=>r.order-i.order),n}function sk(t,e,n){const r=Ro(e);if(r)for(let i=0;i<r.length;i++)n.push(r[i]);Lh(e,i=>{sk(t,i,n)})}function Vh(t,e){const n=Ro(e);if(n){let r=0;for(let i=0;i<n.length;i++)n[i].status!==2&&(n[r]=n[i],r++);n.length=r,GS(e,n.length>0?n:void 0)}Lh(e,r=>{Vh(t,r)})}function ok(t,e){const n=Nl(rk(t,e)),r=qg(t.transactionQueueTree_,e);return DL(r,i=>{Zd(t,i)}),Zd(t,r),QS(r,i=>{Zd(t,i)}),n}function Zd(t,e){const n=Ro(e);if(n){const r=[];let i=[],s=-1;for(let o=0;o<n.length;o++)n[o].status===3||(n[o].status===1?(G(s===o-1,"All SENT items should be at beginning of queue."),s=o,n[o].status=3,n[o].abortReason="set"):(G(n[o].status===0,"Unexpected transaction status in abort"),n[o].unwatcher(),i=i.concat(Mi(t.serverSyncTree_,n[o].currentWriteId,!0)),n[o].onComplete&&r.push(n[o].onComplete.bind(null,new Error("set"),!1,null))));s===-1?GS(e,void 0):n.length=s+1,Sr(t.eventQueue_,Nl(e),i);for(let o=0;o<r.length;o++)Co(r[o])}}/**
 * @license
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function n4(t){let e="";const n=t.split("/");for(let r=0;r<n.length;r++)if(n[r].length>0){let i=n[r];try{i=decodeURIComponent(i.replace(/\+/g," "))}catch{}e+="/"+i}return e}function r4(t){const e={};t.charAt(0)==="?"&&(t=t.substring(1));for(const n of t.split("&")){if(n.length===0)continue;const r=n.split("=");r.length===2?e[decodeURIComponent(r[0])]=decodeURIComponent(r[1]):nn(`Invalid query segment '${n}' in query '${t}'`)}return e}const iw=function(t,e){const n=i4(t),r=n.namespace;n.domain==="firebase.com"&&Ir(n.host+" is no longer supported. Please use <YOUR FIREBASE>.firebaseio.com instead"),(!r||r==="undefined")&&n.domain!=="localhost"&&Ir("Cannot parse Firebase url. Please use https://<YOUR FIREBASE>.firebaseio.com"),n.secure||LO();const i=n.scheme==="ws"||n.scheme==="wss";return{repoInfo:new oS(n.host,n.secure,r,i,e,"",r!==n.subdomain),path:new $e(n.pathString)}},i4=function(t){let e="",n="",r="",i="",s="",o=!0,a="https",u=443;if(typeof t=="string"){let c=t.indexOf("//");c>=0&&(a=t.substring(0,c-1),t=t.substring(c+2));let h=t.indexOf("/");h===-1&&(h=t.length);let f=t.indexOf("?");f===-1&&(f=t.length),e=t.substring(0,Math.min(h,f)),h<f&&(i=n4(t.substring(h,f)));const g=r4(t.substring(Math.min(t.length,f)));c=e.indexOf(":"),c>=0?(o=a==="https"||a==="wss",u=parseInt(e.substring(c+1),10)):c=e.length;const v=e.slice(0,c);if(v.toLowerCase()==="localhost")n="localhost";else if(v.split(".").length<=2)n=v;else{const I=e.indexOf(".");r=e.substring(0,I).toLowerCase(),n=e.substring(I+1),s=r}"ns"in g&&(s=g.ns)}return{host:e,port:u,domain:n,subdomain:r,secure:o,scheme:a,pathString:i,namespace:s}};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Xg{constructor(e,n,r,i){this._repo=e,this._path=n,this._queryParams=r,this._orderByCalled=i}get key(){return me(this._path)?null:mS(this._path)}get ref(){return new as(this._repo,this._path)}get _queryIdentifier(){const e=$0(this._queryParams),n=xg(e);return n==="{}"?"default":n}get _queryObject(){return $0(this._queryParams)}isEqual(e){if(e=Xe(e),!(e instanceof Xg))return!1;const n=this._repo===e._repo,r=yS(this._path,e._path),i=this._queryIdentifier===e._queryIdentifier;return n&&r&&i}toJSON(){return this.toString()}toString(){return this._repo.toString()+yM(this._path)}}class as extends Xg{constructor(e,n){super(e,n,new Og,!1)}get parent(){const e=_S(this._path);return e===null?null:new as(this._repo,e)}get root(){let e=this;for(;e.parent!==null;)e=e.parent;return e}}function ef(t,e){return t=Xe(t),t._checkNotDeleted("ref"),e!==void 0?s4(t._root,e):t._root}function s4(t,e){return t=Xe(t),de(t._path)===null?UL("child","path",e):JS("child","path",e),new as(t._repo,ut(t._path,e))}function o4(t){return ZS("remove",t._path),Dp(t,null)}function Dp(t,e){t=Xe(t),ZS("set",t._path),VL("set",e,t._path);const n=new gh;return YL(t._repo,t._path,e,null,n.wrapCallback(()=>{})),n.promise}IL(as);SL(as);/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const a4="FIREBASE_DATABASE_EMULATOR_HOST",Op={};let l4=!1;function u4(t,e,n,r){t.repoInfo_=new oS(`${e}:${n}`,!1,t.repoInfo_.namespace,t.repoInfo_.webSocketOnly,t.repoInfo_.nodeAdmin,t.repoInfo_.persistenceKey,t.repoInfo_.includeNamespaceInQueryParams,!0),r&&(t.authTokenProvider_=r)}function c4(t,e,n,r,i){let s=r||t.options.databaseURL;s===void 0&&(t.options.projectId||Ir("Can't determine Firebase Database URL. Be sure to include  a Project ID when calling firebase.initializeApp()."),Ft("Using default host for project ",t.options.projectId),s=`${t.options.projectId}-default-rtdb.firebaseio.com`);let o=iw(s,i),a=o.repoInfo,u;typeof process<"u"&&S0&&(u=S0[a4]),u?(s=`http://${u}?ns=${a.namespace}`,o=iw(s,i),a=o.repoInfo):o.repoInfo.secure;const c=new HO(t.name,t.options,e);jL("Invalid Firebase Database URL",o),me(o.path)||Ir("Database URL must point to the root of a Firebase Database (not including a child path).");const h=d4(a,t,c,new qO(t.name,n));return new f4(h,t)}function h4(t,e){const n=Op[e];(!n||n[t.key]!==t)&&Ir(`Database ${e}(${t.repoInfo_}) has already been deleted.`),JL(t),delete n[t.key]}function d4(t,e,n,r){let i=Op[e.name];i||(i={},Op[e.name]=i);let s=i[t.toURLString()];return s&&Ir("Database initialized multiple times. Please make sure the format of the database URL matches with each database() call."),s=new HL(t,l4,n,r),i[t.toURLString()]=s,s}class f4{constructor(e,n){this._repoInternal=e,this.app=n,this.type="database",this._instanceStarted=!1}get _repo(){return this._instanceStarted||(GL(this._repoInternal,this.app.options.appId,this.app.options.databaseAuthVariableOverride),this._instanceStarted=!0),this._repoInternal}get _root(){return this._rootInternal||(this._rootInternal=new as(this._repo,Pe())),this._rootInternal}_delete(){return this._rootInternal!==null&&(h4(this._repo,this.app.name),this._repoInternal=null,this._rootInternal=null),Promise.resolve()}_checkNotDeleted(e){this._rootInternal===null&&Ir("Cannot call "+e+" on a deleted database.")}}function p4(t=vh(),e){const n=El(t,"database").getImmediate({identifier:e});if(!n._instanceStarted){const r=Lm("database");r&&m4(n,...r)}return n}function m4(t,e,n,r={}){t=Xe(t),t._checkNotDeleted("useEmulator"),t._instanceStarted&&Ir("Cannot call useEmulator() after instance has already been initialized.");const i=t._repoInternal;let s;if(i.repoInfo_.nodeAdmin)r.mockUserToken&&Ir('mockUserToken is not supported by the Admin SDK. For client access with mock users, please use the "firebase" package instead of "firebase-admin".'),s=new Ku(Ku.OWNER);else if(r.mockUserToken){const o=typeof r.mockUserToken=="string"?r.mockUserToken:Fm(r.mockUserToken,t.app.options.projectId);s=new Ku(o)}u4(i,e,n,s)}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function g4(t){bO(vi),ci(new vr("database",(e,{instanceIdentifier:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("auth-internal"),s=e.getProvider("app-check-internal");return c4(r,i,s,n)},"PUBLIC").setMultipleInstances(!0)),Tn(k0,C0,t),Tn(k0,C0,"esm2017")}pr.prototype.simpleListen=function(t,e){this.sendRequest("q",{p:t},e)};pr.prototype.echo=function(t,e){this.sendRequest("echo",{d:t},e)};g4();function Jg(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(t!=null&&typeof Object.getOwnPropertySymbols=="function")for(var i=0,r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]]);return n}function ak(){return{"dependent-sdk-initialized-before-auth":"Another Firebase SDK was initialized and is trying to use Auth before Auth is initialized. Please be sure to call `initializeAuth` or `getAuth` before starting any other Firebase SDK."}}const _4=ak,lk=new wl("auth","Firebase",ak());/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const qc=new yh("@firebase/auth");function y4(t,...e){qc.logLevel<=he.WARN&&qc.warn(`Auth (${vi}): ${t}`,...e)}function Qu(t,...e){qc.logLevel<=he.ERROR&&qc.error(`Auth (${vi}): ${t}`,...e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function kr(t,...e){throw Zg(t,...e)}function Yn(t,...e){return Zg(t,...e)}function uk(t,e,n){const r=Object.assign(Object.assign({},_4()),{[e]:n});return new wl("auth","Firebase",r).create(e,{appName:t.name})}function ai(t){return uk(t,"operation-not-supported-in-this-environment","Operations that alter the current user are not supported in conjunction with FirebaseServerApp")}function Zg(t,...e){if(typeof t!="string"){const n=e[0],r=[...e.slice(1)];return r[0]&&(r[0].appName=t.name),t._errorFactory.create(n,...r)}return lk.create(t,...e)}function ie(t,e,...n){if(!t)throw Zg(e,...n)}function ur(t){const e="INTERNAL ASSERTION FAILED: "+t;throw Qu(e),new Error(e)}function Cr(t,e){t||ur(e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Mp(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.href)||""}function v4(){return sw()==="http:"||sw()==="https:"}function sw(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.protocol)||null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function w4(){return typeof navigator<"u"&&navigator&&"onLine"in navigator&&typeof navigator.onLine=="boolean"&&(v4()||bA()||"connection"in navigator)?navigator.onLine:!0}function E4(){if(typeof navigator>"u")return null;const t=navigator;return t.languages&&t.languages[0]||t.language||null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Dl{constructor(e,n){this.shortDelay=e,this.longDelay=n,Cr(n>e,"Short delay should be less than long delay!"),this.isMobile=Vm()||ZT()}get(){return w4()?this.isMobile?this.longDelay:this.shortDelay:Math.min(5e3,this.shortDelay)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function e_(t,e){Cr(t.emulator,"Emulator should always be set here");const{url:n}=t.emulator;return e?`${n}${e.startsWith("/")?e.slice(1):e}`:n}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class ck{static initialize(e,n,r){this.fetchImpl=e,n&&(this.headersImpl=n),r&&(this.responseImpl=r)}static fetch(){if(this.fetchImpl)return this.fetchImpl;if(typeof self<"u"&&"fetch"in self)return self.fetch;if(typeof globalThis<"u"&&globalThis.fetch)return globalThis.fetch;if(typeof fetch<"u")return fetch;ur("Could not find fetch implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static headers(){if(this.headersImpl)return this.headersImpl;if(typeof self<"u"&&"Headers"in self)return self.Headers;if(typeof globalThis<"u"&&globalThis.Headers)return globalThis.Headers;if(typeof Headers<"u")return Headers;ur("Could not find Headers implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static response(){if(this.responseImpl)return this.responseImpl;if(typeof self<"u"&&"Response"in self)return self.Response;if(typeof globalThis<"u"&&globalThis.Response)return globalThis.Response;if(typeof Response<"u")return Response;ur("Could not find Response implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const T4={CREDENTIAL_MISMATCH:"custom-token-mismatch",MISSING_CUSTOM_TOKEN:"internal-error",INVALID_IDENTIFIER:"invalid-email",MISSING_CONTINUE_URI:"internal-error",INVALID_PASSWORD:"wrong-password",MISSING_PASSWORD:"missing-password",INVALID_LOGIN_CREDENTIALS:"invalid-credential",EMAIL_EXISTS:"email-already-in-use",PASSWORD_LOGIN_DISABLED:"operation-not-allowed",INVALID_IDP_RESPONSE:"invalid-credential",INVALID_PENDING_TOKEN:"invalid-credential",FEDERATED_USER_ID_ALREADY_LINKED:"credential-already-in-use",MISSING_REQ_TYPE:"internal-error",EMAIL_NOT_FOUND:"user-not-found",RESET_PASSWORD_EXCEED_LIMIT:"too-many-requests",EXPIRED_OOB_CODE:"expired-action-code",INVALID_OOB_CODE:"invalid-action-code",MISSING_OOB_CODE:"internal-error",CREDENTIAL_TOO_OLD_LOGIN_AGAIN:"requires-recent-login",INVALID_ID_TOKEN:"invalid-user-token",TOKEN_EXPIRED:"user-token-expired",USER_NOT_FOUND:"user-token-expired",TOO_MANY_ATTEMPTS_TRY_LATER:"too-many-requests",PASSWORD_DOES_NOT_MEET_REQUIREMENTS:"password-does-not-meet-requirements",INVALID_CODE:"invalid-verification-code",INVALID_SESSION_INFO:"invalid-verification-id",INVALID_TEMPORARY_PROOF:"invalid-credential",MISSING_SESSION_INFO:"missing-verification-id",SESSION_EXPIRED:"code-expired",MISSING_ANDROID_PACKAGE_NAME:"missing-android-pkg-name",UNAUTHORIZED_DOMAIN:"unauthorized-continue-uri",INVALID_OAUTH_CLIENT_ID:"invalid-oauth-client-id",ADMIN_ONLY_OPERATION:"admin-restricted-operation",INVALID_MFA_PENDING_CREDENTIAL:"invalid-multi-factor-session",MFA_ENROLLMENT_NOT_FOUND:"multi-factor-info-not-found",MISSING_MFA_ENROLLMENT_ID:"missing-multi-factor-info",MISSING_MFA_PENDING_CREDENTIAL:"missing-multi-factor-session",SECOND_FACTOR_EXISTS:"second-factor-already-in-use",SECOND_FACTOR_LIMIT_EXCEEDED:"maximum-second-factor-count-exceeded",BLOCKING_FUNCTION_ERROR_RESPONSE:"internal-error",RECAPTCHA_NOT_ENABLED:"recaptcha-not-enabled",MISSING_RECAPTCHA_TOKEN:"missing-recaptcha-token",INVALID_RECAPTCHA_TOKEN:"invalid-recaptcha-token",INVALID_RECAPTCHA_ACTION:"invalid-recaptcha-action",MISSING_CLIENT_TYPE:"missing-client-type",MISSING_RECAPTCHA_VERSION:"missing-recaptcha-version",INVALID_RECAPTCHA_VERSION:"invalid-recaptcha-version",INVALID_REQ_TYPE:"invalid-req-type"};/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const I4=new Dl(3e4,6e4);function Uh(t,e){return t.tenantId&&!e.tenantId?Object.assign(Object.assign({},e),{tenantId:t.tenantId}):e}async function xo(t,e,n,r,i={}){return hk(t,i,async()=>{let s={},o={};r&&(e==="GET"?o=r:s={body:JSON.stringify(r)});const a=yo(Object.assign({key:t.config.apiKey},o)).slice(1),u=await t._getAdditionalHeaders();u["Content-Type"]="application/json",t.languageCode&&(u["X-Firebase-Locale"]=t.languageCode);const c=Object.assign({method:e,headers:u},s);return AA()||(c.referrerPolicy="no-referrer"),ck.fetch()(fk(t,t.config.apiHost,n,a),c)})}async function hk(t,e,n){t._canInitEmulator=!1;const r=Object.assign(Object.assign({},T4),e);try{const i=new S4(t),s=await Promise.race([n(),i.promise]);i.clearNetworkTimeout();const o=await s.json();if("needConfirmation"in o)throw Ru(t,"account-exists-with-different-credential",o);if(s.ok&&!("errorMessage"in o))return o;{const a=s.ok?o.errorMessage:o.error.message,[u,c]=a.split(" : ");if(u==="FEDERATED_USER_ID_ALREADY_LINKED")throw Ru(t,"credential-already-in-use",o);if(u==="EMAIL_EXISTS")throw Ru(t,"email-already-in-use",o);if(u==="USER_DISABLED")throw Ru(t,"user-disabled",o);const h=r[u]||u.toLowerCase().replace(/[_\s]+/g,"-");if(c)throw uk(t,h,c);kr(t,h)}}catch(i){if(i instanceof Zn)throw i;kr(t,"network-request-failed",{message:String(i)})}}async function dk(t,e,n,r,i={}){const s=await xo(t,e,n,r,i);return"mfaPendingCredential"in s&&kr(t,"multi-factor-auth-required",{_serverResponse:s}),s}function fk(t,e,n,r){const i=`${e}${n}?${r}`;return t.config.emulator?e_(t.config,i):`${t.config.apiScheme}://${i}`}class S4{constructor(e){this.auth=e,this.timer=null,this.promise=new Promise((n,r)=>{this.timer=setTimeout(()=>r(Yn(this.auth,"network-request-failed")),I4.get())})}clearNetworkTimeout(){clearTimeout(this.timer)}}function Ru(t,e,n){const r={appName:t.name};n.email&&(r.email=n.email),n.phoneNumber&&(r.phoneNumber=n.phoneNumber);const i=Yn(t,e,r);return i.customData._tokenResponse=n,i}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function k4(t,e){return xo(t,"POST","/v1/accounts:delete",e)}async function pk(t,e){return xo(t,"POST","/v1/accounts:lookup",e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Da(t){if(t)try{const e=new Date(Number(t));if(!isNaN(e.getTime()))return e.toUTCString()}catch{}}async function C4(t,e=!1){const n=Xe(t),r=await n.getIdToken(e),i=t_(r);ie(i&&i.exp&&i.auth_time&&i.iat,n.auth,"internal-error");const s=typeof i.firebase=="object"?i.firebase:void 0,o=s==null?void 0:s.sign_in_provider;return{claims:i,token:r,authTime:Da(tf(i.auth_time)),issuedAtTime:Da(tf(i.iat)),expirationTime:Da(tf(i.exp)),signInProvider:o||null,signInSecondFactor:(s==null?void 0:s.sign_in_second_factor)||null}}function tf(t){return Number(t)*1e3}function t_(t){const[e,n,r]=t.split(".");if(e===void 0||n===void 0||r===void 0)return Qu("JWT malformed, contained fewer than 3 sections"),null;try{const i=kc(n);return i?JSON.parse(i):(Qu("Failed to decode base64 JWT payload"),null)}catch(i){return Qu("Caught error parsing JWT payload as JSON",i==null?void 0:i.toString()),null}}function ow(t){const e=t_(t);return ie(e,"internal-error"),ie(typeof e.exp<"u","internal-error"),ie(typeof e.iat<"u","internal-error"),Number(e.exp)-Number(e.iat)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function pl(t,e,n=!1){if(n)return e;try{return await e}catch(r){throw r instanceof Zn&&R4(r)&&t.auth.currentUser===t&&await t.auth.signOut(),r}}function R4({code:t}){return t==="auth/user-disabled"||t==="auth/user-token-expired"}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class x4{constructor(e){this.user=e,this.isRunning=!1,this.timerId=null,this.errorBackoff=3e4}_start(){this.isRunning||(this.isRunning=!0,this.schedule())}_stop(){this.isRunning&&(this.isRunning=!1,this.timerId!==null&&clearTimeout(this.timerId))}getInterval(e){var n;if(e){const r=this.errorBackoff;return this.errorBackoff=Math.min(this.errorBackoff*2,96e4),r}else{this.errorBackoff=3e4;const i=((n=this.user.stsTokenManager.expirationTime)!==null&&n!==void 0?n:0)-Date.now()-3e5;return Math.max(0,i)}}schedule(e=!1){if(!this.isRunning)return;const n=this.getInterval(e);this.timerId=setTimeout(async()=>{await this.iteration()},n)}async iteration(){try{await this.user.getIdToken(!0)}catch(e){(e==null?void 0:e.code)==="auth/network-request-failed"&&this.schedule(!0);return}this.schedule()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Lp{constructor(e,n){this.createdAt=e,this.lastLoginAt=n,this._initializeTime()}_initializeTime(){this.lastSignInTime=Da(this.lastLoginAt),this.creationTime=Da(this.createdAt)}_copy(e){this.createdAt=e.createdAt,this.lastLoginAt=e.lastLoginAt,this._initializeTime()}toJSON(){return{createdAt:this.createdAt,lastLoginAt:this.lastLoginAt}}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Hc(t){var e;const n=t.auth,r=await t.getIdToken(),i=await pl(t,pk(n,{idToken:r}));ie(i==null?void 0:i.users.length,n,"internal-error");const s=i.users[0];t._notifyReloadListener(s);const o=!((e=s.providerUserInfo)===null||e===void 0)&&e.length?mk(s.providerUserInfo):[],a=b4(t.providerData,o),u=t.isAnonymous,c=!(t.email&&s.passwordHash)&&!(a!=null&&a.length),h=u?c:!1,f={uid:s.localId,displayName:s.displayName||null,photoURL:s.photoUrl||null,email:s.email||null,emailVerified:s.emailVerified||!1,phoneNumber:s.phoneNumber||null,tenantId:s.tenantId||null,providerData:a,metadata:new Lp(s.createdAt,s.lastLoginAt),isAnonymous:h};Object.assign(t,f)}async function A4(t){const e=Xe(t);await Hc(e),await e.auth._persistUserIfCurrent(e),e.auth._notifyListenersIfCurrent(e)}function b4(t,e){return[...t.filter(r=>!e.some(i=>i.providerId===r.providerId)),...e]}function mk(t){return t.map(e=>{var{providerId:n}=e,r=Jg(e,["providerId"]);return{providerId:n,uid:r.rawId||"",displayName:r.displayName||null,email:r.email||null,phoneNumber:r.phoneNumber||null,photoURL:r.photoUrl||null}})}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function P4(t,e){const n=await hk(t,{},async()=>{const r=yo({grant_type:"refresh_token",refresh_token:e}).slice(1),{tokenApiHost:i,apiKey:s}=t.config,o=fk(t,i,"/v1/token",`key=${s}`),a=await t._getAdditionalHeaders();return a["Content-Type"]="application/x-www-form-urlencoded",ck.fetch()(o,{method:"POST",headers:a,body:r})});return{accessToken:n.access_token,expiresIn:n.expires_in,refreshToken:n.refresh_token}}async function N4(t,e){return xo(t,"POST","/v2/accounts:revokeToken",Uh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class qs{constructor(){this.refreshToken=null,this.accessToken=null,this.expirationTime=null}get isExpired(){return!this.expirationTime||Date.now()>this.expirationTime-3e4}updateFromServerResponse(e){ie(e.idToken,"internal-error"),ie(typeof e.idToken<"u","internal-error"),ie(typeof e.refreshToken<"u","internal-error");const n="expiresIn"in e&&typeof e.expiresIn<"u"?Number(e.expiresIn):ow(e.idToken);this.updateTokensAndExpiration(e.idToken,e.refreshToken,n)}updateFromIdToken(e){ie(e.length!==0,"internal-error");const n=ow(e);this.updateTokensAndExpiration(e,null,n)}async getToken(e,n=!1){return!n&&this.accessToken&&!this.isExpired?this.accessToken:(ie(this.refreshToken,e,"user-token-expired"),this.refreshToken?(await this.refresh(e,this.refreshToken),this.accessToken):null)}clearRefreshToken(){this.refreshToken=null}async refresh(e,n){const{accessToken:r,refreshToken:i,expiresIn:s}=await P4(e,n);this.updateTokensAndExpiration(r,i,Number(s))}updateTokensAndExpiration(e,n,r){this.refreshToken=n||null,this.accessToken=e||null,this.expirationTime=Date.now()+r*1e3}static fromJSON(e,n){const{refreshToken:r,accessToken:i,expirationTime:s}=n,o=new qs;return r&&(ie(typeof r=="string","internal-error",{appName:e}),o.refreshToken=r),i&&(ie(typeof i=="string","internal-error",{appName:e}),o.accessToken=i),s&&(ie(typeof s=="number","internal-error",{appName:e}),o.expirationTime=s),o}toJSON(){return{refreshToken:this.refreshToken,accessToken:this.accessToken,expirationTime:this.expirationTime}}_assign(e){this.accessToken=e.accessToken,this.refreshToken=e.refreshToken,this.expirationTime=e.expirationTime}_clone(){return Object.assign(new qs,this.toJSON())}_performRefresh(){return ur("not implemented")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Or(t,e){ie(typeof t=="string"||typeof t>"u","internal-error",{appName:e})}class cr{constructor(e){var{uid:n,auth:r,stsTokenManager:i}=e,s=Jg(e,["uid","auth","stsTokenManager"]);this.providerId="firebase",this.proactiveRefresh=new x4(this),this.reloadUserInfo=null,this.reloadListener=null,this.uid=n,this.auth=r,this.stsTokenManager=i,this.accessToken=i.accessToken,this.displayName=s.displayName||null,this.email=s.email||null,this.emailVerified=s.emailVerified||!1,this.phoneNumber=s.phoneNumber||null,this.photoURL=s.photoURL||null,this.isAnonymous=s.isAnonymous||!1,this.tenantId=s.tenantId||null,this.providerData=s.providerData?[...s.providerData]:[],this.metadata=new Lp(s.createdAt||void 0,s.lastLoginAt||void 0)}async getIdToken(e){const n=await pl(this,this.stsTokenManager.getToken(this.auth,e));return ie(n,this.auth,"internal-error"),this.accessToken!==n&&(this.accessToken=n,await this.auth._persistUserIfCurrent(this),this.auth._notifyListenersIfCurrent(this)),n}getIdTokenResult(e){return C4(this,e)}reload(){return A4(this)}_assign(e){this!==e&&(ie(this.uid===e.uid,this.auth,"internal-error"),this.displayName=e.displayName,this.photoURL=e.photoURL,this.email=e.email,this.emailVerified=e.emailVerified,this.phoneNumber=e.phoneNumber,this.isAnonymous=e.isAnonymous,this.tenantId=e.tenantId,this.providerData=e.providerData.map(n=>Object.assign({},n)),this.metadata._copy(e.metadata),this.stsTokenManager._assign(e.stsTokenManager))}_clone(e){const n=new cr(Object.assign(Object.assign({},this),{auth:e,stsTokenManager:this.stsTokenManager._clone()}));return n.metadata._copy(this.metadata),n}_onReload(e){ie(!this.reloadListener,this.auth,"internal-error"),this.reloadListener=e,this.reloadUserInfo&&(this._notifyReloadListener(this.reloadUserInfo),this.reloadUserInfo=null)}_notifyReloadListener(e){this.reloadListener?this.reloadListener(e):this.reloadUserInfo=e}_startProactiveRefresh(){this.proactiveRefresh._start()}_stopProactiveRefresh(){this.proactiveRefresh._stop()}async _updateTokensIfNecessary(e,n=!1){let r=!1;e.idToken&&e.idToken!==this.stsTokenManager.accessToken&&(this.stsTokenManager.updateFromServerResponse(e),r=!0),n&&await Hc(this),await this.auth._persistUserIfCurrent(this),r&&this.auth._notifyListenersIfCurrent(this)}async delete(){if(ar(this.auth.app))return Promise.reject(ai(this.auth));const e=await this.getIdToken();return await pl(this,k4(this.auth,{idToken:e})),this.stsTokenManager.clearRefreshToken(),this.auth.signOut()}toJSON(){return Object.assign(Object.assign({uid:this.uid,email:this.email||void 0,emailVerified:this.emailVerified,displayName:this.displayName||void 0,isAnonymous:this.isAnonymous,photoURL:this.photoURL||void 0,phoneNumber:this.phoneNumber||void 0,tenantId:this.tenantId||void 0,providerData:this.providerData.map(e=>Object.assign({},e)),stsTokenManager:this.stsTokenManager.toJSON(),_redirectEventId:this._redirectEventId},this.metadata.toJSON()),{apiKey:this.auth.config.apiKey,appName:this.auth.name})}get refreshToken(){return this.stsTokenManager.refreshToken||""}static _fromJSON(e,n){var r,i,s,o,a,u,c,h;const f=(r=n.displayName)!==null&&r!==void 0?r:void 0,g=(i=n.email)!==null&&i!==void 0?i:void 0,v=(s=n.phoneNumber)!==null&&s!==void 0?s:void 0,I=(o=n.photoURL)!==null&&o!==void 0?o:void 0,N=(a=n.tenantId)!==null&&a!==void 0?a:void 0,D=(u=n._redirectEventId)!==null&&u!==void 0?u:void 0,C=(c=n.createdAt)!==null&&c!==void 0?c:void 0,w=(h=n.lastLoginAt)!==null&&h!==void 0?h:void 0,{uid:R,emailVerified:M,isAnonymous:z,providerData:U,stsTokenManager:E}=n;ie(R&&E,e,"internal-error");const y=qs.fromJSON(this.name,E);ie(typeof R=="string",e,"internal-error"),Or(f,e.name),Or(g,e.name),ie(typeof M=="boolean",e,"internal-error"),ie(typeof z=="boolean",e,"internal-error"),Or(v,e.name),Or(I,e.name),Or(N,e.name),Or(D,e.name),Or(C,e.name),Or(w,e.name);const T=new cr({uid:R,auth:e,email:g,emailVerified:M,displayName:f,isAnonymous:z,photoURL:I,phoneNumber:v,tenantId:N,stsTokenManager:y,createdAt:C,lastLoginAt:w});return U&&Array.isArray(U)&&(T.providerData=U.map(x=>Object.assign({},x))),D&&(T._redirectEventId=D),T}static async _fromIdTokenResponse(e,n,r=!1){const i=new qs;i.updateFromServerResponse(n);const s=new cr({uid:n.localId,auth:e,stsTokenManager:i,isAnonymous:r});return await Hc(s),s}static async _fromGetAccountInfoResponse(e,n,r){const i=n.users[0];ie(i.localId!==void 0,"internal-error");const s=i.providerUserInfo!==void 0?mk(i.providerUserInfo):[],o=!(i.email&&i.passwordHash)&&!(s!=null&&s.length),a=new qs;a.updateFromIdToken(r);const u=new cr({uid:i.localId,auth:e,stsTokenManager:a,isAnonymous:o}),c={uid:i.localId,displayName:i.displayName||null,photoURL:i.photoUrl||null,email:i.email||null,emailVerified:i.emailVerified||!1,phoneNumber:i.phoneNumber||null,tenantId:i.tenantId||null,providerData:s,metadata:new Lp(i.createdAt,i.lastLoginAt),isAnonymous:!(i.email&&i.passwordHash)&&!(s!=null&&s.length)};return Object.assign(u,c),u}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const aw=new Map;function hr(t){Cr(t instanceof Function,"Expected a class definition");let e=aw.get(t);return e?(Cr(e instanceof t,"Instance stored in cache mismatched with class"),e):(e=new t,aw.set(t,e),e)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class gk{constructor(){this.type="NONE",this.storage={}}async _isAvailable(){return!0}async _set(e,n){this.storage[e]=n}async _get(e){const n=this.storage[e];return n===void 0?null:n}async _remove(e){delete this.storage[e]}_addListener(e,n){}_removeListener(e,n){}}gk.type="NONE";const lw=gk;/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Yu(t,e,n){return`firebase:${t}:${e}:${n}`}class Hs{constructor(e,n,r){this.persistence=e,this.auth=n,this.userKey=r;const{config:i,name:s}=this.auth;this.fullUserKey=Yu(this.userKey,i.apiKey,s),this.fullPersistenceKey=Yu("persistence",i.apiKey,s),this.boundEventHandler=n._onStorageEvent.bind(n),this.persistence._addListener(this.fullUserKey,this.boundEventHandler)}setCurrentUser(e){return this.persistence._set(this.fullUserKey,e.toJSON())}async getCurrentUser(){const e=await this.persistence._get(this.fullUserKey);return e?cr._fromJSON(this.auth,e):null}removeCurrentUser(){return this.persistence._remove(this.fullUserKey)}savePersistenceForRedirect(){return this.persistence._set(this.fullPersistenceKey,this.persistence.type)}async setPersistence(e){if(this.persistence===e)return;const n=await this.getCurrentUser();if(await this.removeCurrentUser(),this.persistence=e,n)return this.setCurrentUser(n)}delete(){this.persistence._removeListener(this.fullUserKey,this.boundEventHandler)}static async create(e,n,r="authUser"){if(!n.length)return new Hs(hr(lw),e,r);const i=(await Promise.all(n.map(async c=>{if(await c._isAvailable())return c}))).filter(c=>c);let s=i[0]||hr(lw);const o=Yu(r,e.config.apiKey,e.name);let a=null;for(const c of n)try{const h=await c._get(o);if(h){const f=cr._fromJSON(e,h);c!==s&&(a=f),s=c;break}}catch{}const u=i.filter(c=>c._shouldAllowMigration);return!s._shouldAllowMigration||!u.length?new Hs(s,e,r):(s=u[0],a&&await s._set(o,a.toJSON()),await Promise.all(n.map(async c=>{if(c!==s)try{await c._remove(o)}catch{}})),new Hs(s,e,r))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function uw(t){const e=t.toLowerCase();if(e.includes("opera/")||e.includes("opr/")||e.includes("opios/"))return"Opera";if(wk(e))return"IEMobile";if(e.includes("msie")||e.includes("trident/"))return"IE";if(e.includes("edge/"))return"Edge";if(_k(e))return"Firefox";if(e.includes("silk/"))return"Silk";if(Tk(e))return"Blackberry";if(Ik(e))return"Webos";if(yk(e))return"Safari";if((e.includes("chrome/")||vk(e))&&!e.includes("edge/"))return"Chrome";if(Ek(e))return"Android";{const n=/([a-zA-Z\d\.]+)\/[a-zA-Z\d\.]*$/,r=t.match(n);if((r==null?void 0:r.length)===2)return r[1]}return"Other"}function _k(t=jt()){return/firefox\//i.test(t)}function yk(t=jt()){const e=t.toLowerCase();return e.includes("safari/")&&!e.includes("chrome/")&&!e.includes("crios/")&&!e.includes("android")}function vk(t=jt()){return/crios\//i.test(t)}function wk(t=jt()){return/iemobile/i.test(t)}function Ek(t=jt()){return/android/i.test(t)}function Tk(t=jt()){return/blackberry/i.test(t)}function Ik(t=jt()){return/webos/i.test(t)}function n_(t=jt()){return/iphone|ipad|ipod/i.test(t)||/macintosh/i.test(t)&&/mobile/i.test(t)}function D4(t=jt()){var e;return n_(t)&&!!(!((e=window.navigator)===null||e===void 0)&&e.standalone)}function O4(){return PA()&&document.documentMode===10}function Sk(t=jt()){return n_(t)||Ek(t)||Ik(t)||Tk(t)||/windows phone/i.test(t)||wk(t)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function kk(t,e=[]){let n;switch(t){case"Browser":n=uw(jt());break;case"Worker":n=`${uw(jt())}-${t}`;break;default:n=t}const r=e.length?e.join(","):"FirebaseCore-web";return`${n}/JsCore/${vi}/${r}`}/**
 * @license
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class M4{constructor(e){this.auth=e,this.queue=[]}pushCallback(e,n){const r=s=>new Promise((o,a)=>{try{const u=e(s);o(u)}catch(u){a(u)}});r.onAbort=n,this.queue.push(r);const i=this.queue.length-1;return()=>{this.queue[i]=()=>Promise.resolve()}}async runMiddleware(e){if(this.auth.currentUser===e)return;const n=[];try{for(const r of this.queue)await r(e),r.onAbort&&n.push(r.onAbort)}catch(r){n.reverse();for(const i of n)try{i()}catch{}throw this.auth._errorFactory.create("login-blocked",{originalMessage:r==null?void 0:r.message})}}}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function L4(t,e={}){return xo(t,"GET","/v2/passwordPolicy",Uh(t,e))}/**
 * @license
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const F4=6;class V4{constructor(e){var n,r,i,s;const o=e.customStrengthOptions;this.customStrengthOptions={},this.customStrengthOptions.minPasswordLength=(n=o.minPasswordLength)!==null&&n!==void 0?n:F4,o.maxPasswordLength&&(this.customStrengthOptions.maxPasswordLength=o.maxPasswordLength),o.containsLowercaseCharacter!==void 0&&(this.customStrengthOptions.containsLowercaseLetter=o.containsLowercaseCharacter),o.containsUppercaseCharacter!==void 0&&(this.customStrengthOptions.containsUppercaseLetter=o.containsUppercaseCharacter),o.containsNumericCharacter!==void 0&&(this.customStrengthOptions.containsNumericCharacter=o.containsNumericCharacter),o.containsNonAlphanumericCharacter!==void 0&&(this.customStrengthOptions.containsNonAlphanumericCharacter=o.containsNonAlphanumericCharacter),this.enforcementState=e.enforcementState,this.enforcementState==="ENFORCEMENT_STATE_UNSPECIFIED"&&(this.enforcementState="OFF"),this.allowedNonAlphanumericCharacters=(i=(r=e.allowedNonAlphanumericCharacters)===null||r===void 0?void 0:r.join(""))!==null&&i!==void 0?i:"",this.forceUpgradeOnSignin=(s=e.forceUpgradeOnSignin)!==null&&s!==void 0?s:!1,this.schemaVersion=e.schemaVersion}validatePassword(e){var n,r,i,s,o,a;const u={isValid:!0,passwordPolicy:this};return this.validatePasswordLengthOptions(e,u),this.validatePasswordCharacterOptions(e,u),u.isValid&&(u.isValid=(n=u.meetsMinPasswordLength)!==null&&n!==void 0?n:!0),u.isValid&&(u.isValid=(r=u.meetsMaxPasswordLength)!==null&&r!==void 0?r:!0),u.isValid&&(u.isValid=(i=u.containsLowercaseLetter)!==null&&i!==void 0?i:!0),u.isValid&&(u.isValid=(s=u.containsUppercaseLetter)!==null&&s!==void 0?s:!0),u.isValid&&(u.isValid=(o=u.containsNumericCharacter)!==null&&o!==void 0?o:!0),u.isValid&&(u.isValid=(a=u.containsNonAlphanumericCharacter)!==null&&a!==void 0?a:!0),u}validatePasswordLengthOptions(e,n){const r=this.customStrengthOptions.minPasswordLength,i=this.customStrengthOptions.maxPasswordLength;r&&(n.meetsMinPasswordLength=e.length>=r),i&&(n.meetsMaxPasswordLength=e.length<=i)}validatePasswordCharacterOptions(e,n){this.updatePasswordCharacterOptionsStatuses(n,!1,!1,!1,!1);let r;for(let i=0;i<e.length;i++)r=e.charAt(i),this.updatePasswordCharacterOptionsStatuses(n,r>="a"&&r<="z",r>="A"&&r<="Z",r>="0"&&r<="9",this.allowedNonAlphanumericCharacters.includes(r))}updatePasswordCharacterOptionsStatuses(e,n,r,i,s){this.customStrengthOptions.containsLowercaseLetter&&(e.containsLowercaseLetter||(e.containsLowercaseLetter=n)),this.customStrengthOptions.containsUppercaseLetter&&(e.containsUppercaseLetter||(e.containsUppercaseLetter=r)),this.customStrengthOptions.containsNumericCharacter&&(e.containsNumericCharacter||(e.containsNumericCharacter=i)),this.customStrengthOptions.containsNonAlphanumericCharacter&&(e.containsNonAlphanumericCharacter||(e.containsNonAlphanumericCharacter=s))}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class U4{constructor(e,n,r,i){this.app=e,this.heartbeatServiceProvider=n,this.appCheckServiceProvider=r,this.config=i,this.currentUser=null,this.emulatorConfig=null,this.operations=Promise.resolve(),this.authStateSubscription=new cw(this),this.idTokenSubscription=new cw(this),this.beforeStateQueue=new M4(this),this.redirectUser=null,this.isProactiveRefreshEnabled=!1,this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION=1,this._canInitEmulator=!0,this._isInitialized=!1,this._deleted=!1,this._initializationPromise=null,this._popupRedirectResolver=null,this._errorFactory=lk,this._agentRecaptchaConfig=null,this._tenantRecaptchaConfigs={},this._projectPasswordPolicy=null,this._tenantPasswordPolicies={},this.lastNotifiedUid=void 0,this.languageCode=null,this.tenantId=null,this.settings={appVerificationDisabledForTesting:!1},this.frameworks=[],this.name=e.name,this.clientVersion=i.sdkClientVersion}_initializeWithPersistence(e,n){return n&&(this._popupRedirectResolver=hr(n)),this._initializationPromise=this.queue(async()=>{var r,i;if(!this._deleted&&(this.persistenceManager=await Hs.create(this,e),!this._deleted)){if(!((r=this._popupRedirectResolver)===null||r===void 0)&&r._shouldInitProactively)try{await this._popupRedirectResolver._initialize(this)}catch{}await this.initializeCurrentUser(n),this.lastNotifiedUid=((i=this.currentUser)===null||i===void 0?void 0:i.uid)||null,!this._deleted&&(this._isInitialized=!0)}}),this._initializationPromise}async _onStorageEvent(){if(this._deleted)return;const e=await this.assertedPersistence.getCurrentUser();if(!(!this.currentUser&&!e)){if(this.currentUser&&e&&this.currentUser.uid===e.uid){this._currentUser._assign(e),await this.currentUser.getIdToken();return}await this._updateCurrentUser(e,!0)}}async initializeCurrentUserFromIdToken(e){try{const n=await pk(this,{idToken:e}),r=await cr._fromGetAccountInfoResponse(this,n,e);await this.directlySetCurrentUser(r)}catch(n){console.warn("FirebaseServerApp could not login user with provided authIdToken: ",n),await this.directlySetCurrentUser(null)}}async initializeCurrentUser(e){var n;if(ar(this.app)){const o=this.app.settings.authIdToken;return o?new Promise(a=>{setTimeout(()=>this.initializeCurrentUserFromIdToken(o).then(a,a))}):this.directlySetCurrentUser(null)}const r=await this.assertedPersistence.getCurrentUser();let i=r,s=!1;if(e&&this.config.authDomain){await this.getOrInitRedirectPersistenceManager();const o=(n=this.redirectUser)===null||n===void 0?void 0:n._redirectEventId,a=i==null?void 0:i._redirectEventId,u=await this.tryRedirectSignIn(e);(!o||o===a)&&(u!=null&&u.user)&&(i=u.user,s=!0)}if(!i)return this.directlySetCurrentUser(null);if(!i._redirectEventId){if(s)try{await this.beforeStateQueue.runMiddleware(i)}catch(o){i=r,this._popupRedirectResolver._overrideRedirectResult(this,()=>Promise.reject(o))}return i?this.reloadAndSetCurrentUserOrClear(i):this.directlySetCurrentUser(null)}return ie(this._popupRedirectResolver,this,"argument-error"),await this.getOrInitRedirectPersistenceManager(),this.redirectUser&&this.redirectUser._redirectEventId===i._redirectEventId?this.directlySetCurrentUser(i):this.reloadAndSetCurrentUserOrClear(i)}async tryRedirectSignIn(e){let n=null;try{n=await this._popupRedirectResolver._completeRedirectFn(this,e,!0)}catch{await this._setRedirectUser(null)}return n}async reloadAndSetCurrentUserOrClear(e){try{await Hc(e)}catch(n){if((n==null?void 0:n.code)!=="auth/network-request-failed")return this.directlySetCurrentUser(null)}return this.directlySetCurrentUser(e)}useDeviceLanguage(){this.languageCode=E4()}async _delete(){this._deleted=!0}async updateCurrentUser(e){if(ar(this.app))return Promise.reject(ai(this));const n=e?Xe(e):null;return n&&ie(n.auth.config.apiKey===this.config.apiKey,this,"invalid-user-token"),this._updateCurrentUser(n&&n._clone(this))}async _updateCurrentUser(e,n=!1){if(!this._deleted)return e&&ie(this.tenantId===e.tenantId,this,"tenant-id-mismatch"),n||await this.beforeStateQueue.runMiddleware(e),this.queue(async()=>{await this.directlySetCurrentUser(e),this.notifyAuthListeners()})}async signOut(){return ar(this.app)?Promise.reject(ai(this)):(await this.beforeStateQueue.runMiddleware(null),(this.redirectPersistenceManager||this._popupRedirectResolver)&&await this._setRedirectUser(null),this._updateCurrentUser(null,!0))}setPersistence(e){return ar(this.app)?Promise.reject(ai(this)):this.queue(async()=>{await this.assertedPersistence.setPersistence(hr(e))})}_getRecaptchaConfig(){return this.tenantId==null?this._agentRecaptchaConfig:this._tenantRecaptchaConfigs[this.tenantId]}async validatePassword(e){this._getPasswordPolicyInternal()||await this._updatePasswordPolicy();const n=this._getPasswordPolicyInternal();return n.schemaVersion!==this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION?Promise.reject(this._errorFactory.create("unsupported-password-policy-schema-version",{})):n.validatePassword(e)}_getPasswordPolicyInternal(){return this.tenantId===null?this._projectPasswordPolicy:this._tenantPasswordPolicies[this.tenantId]}async _updatePasswordPolicy(){const e=await L4(this),n=new V4(e);this.tenantId===null?this._projectPasswordPolicy=n:this._tenantPasswordPolicies[this.tenantId]=n}_getPersistence(){return this.assertedPersistence.persistence.type}_updateErrorMap(e){this._errorFactory=new wl("auth","Firebase",e())}onAuthStateChanged(e,n,r){return this.registerStateListener(this.authStateSubscription,e,n,r)}beforeAuthStateChanged(e,n){return this.beforeStateQueue.pushCallback(e,n)}onIdTokenChanged(e,n,r){return this.registerStateListener(this.idTokenSubscription,e,n,r)}authStateReady(){return new Promise((e,n)=>{if(this.currentUser)e();else{const r=this.onAuthStateChanged(()=>{r(),e()},n)}})}async revokeAccessToken(e){if(this.currentUser){const n=await this.currentUser.getIdToken(),r={providerId:"apple.com",tokenType:"ACCESS_TOKEN",token:e,idToken:n};this.tenantId!=null&&(r.tenantId=this.tenantId),await N4(this,r)}}toJSON(){var e;return{apiKey:this.config.apiKey,authDomain:this.config.authDomain,appName:this.name,currentUser:(e=this._currentUser)===null||e===void 0?void 0:e.toJSON()}}async _setRedirectUser(e,n){const r=await this.getOrInitRedirectPersistenceManager(n);return e===null?r.removeCurrentUser():r.setCurrentUser(e)}async getOrInitRedirectPersistenceManager(e){if(!this.redirectPersistenceManager){const n=e&&hr(e)||this._popupRedirectResolver;ie(n,this,"argument-error"),this.redirectPersistenceManager=await Hs.create(this,[hr(n._redirectPersistence)],"redirectUser"),this.redirectUser=await this.redirectPersistenceManager.getCurrentUser()}return this.redirectPersistenceManager}async _redirectUserForId(e){var n,r;return this._isInitialized&&await this.queue(async()=>{}),((n=this._currentUser)===null||n===void 0?void 0:n._redirectEventId)===e?this._currentUser:((r=this.redirectUser)===null||r===void 0?void 0:r._redirectEventId)===e?this.redirectUser:null}async _persistUserIfCurrent(e){if(e===this.currentUser)return this.queue(async()=>this.directlySetCurrentUser(e))}_notifyListenersIfCurrent(e){e===this.currentUser&&this.notifyAuthListeners()}_key(){return`${this.config.authDomain}:${this.config.apiKey}:${this.name}`}_startProactiveRefresh(){this.isProactiveRefreshEnabled=!0,this.currentUser&&this._currentUser._startProactiveRefresh()}_stopProactiveRefresh(){this.isProactiveRefreshEnabled=!1,this.currentUser&&this._currentUser._stopProactiveRefresh()}get _currentUser(){return this.currentUser}notifyAuthListeners(){var e,n;if(!this._isInitialized)return;this.idTokenSubscription.next(this.currentUser);const r=(n=(e=this.currentUser)===null||e===void 0?void 0:e.uid)!==null&&n!==void 0?n:null;this.lastNotifiedUid!==r&&(this.lastNotifiedUid=r,this.authStateSubscription.next(this.currentUser))}registerStateListener(e,n,r,i){if(this._deleted)return()=>{};const s=typeof n=="function"?n:n.next.bind(n);let o=!1;const a=this._isInitialized?Promise.resolve():this._initializationPromise;if(ie(a,this,"internal-error"),a.then(()=>{o||s(this.currentUser)}),typeof n=="function"){const u=e.addObserver(n,r,i);return()=>{o=!0,u()}}else{const u=e.addObserver(n);return()=>{o=!0,u()}}}async directlySetCurrentUser(e){this.currentUser&&this.currentUser!==e&&this._currentUser._stopProactiveRefresh(),e&&this.isProactiveRefreshEnabled&&e._startProactiveRefresh(),this.currentUser=e,e?await this.assertedPersistence.setCurrentUser(e):await this.assertedPersistence.removeCurrentUser()}queue(e){return this.operations=this.operations.then(e,e),this.operations}get assertedPersistence(){return ie(this.persistenceManager,this,"internal-error"),this.persistenceManager}_logFramework(e){!e||this.frameworks.includes(e)||(this.frameworks.push(e),this.frameworks.sort(),this.clientVersion=kk(this.config.clientPlatform,this._getFrameworks()))}_getFrameworks(){return this.frameworks}async _getAdditionalHeaders(){var e;const n={"X-Client-Version":this.clientVersion};this.app.options.appId&&(n["X-Firebase-gmpid"]=this.app.options.appId);const r=await((e=this.heartbeatServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getHeartbeatsHeader());r&&(n["X-Firebase-Client"]=r);const i=await this._getAppCheckToken();return i&&(n["X-Firebase-AppCheck"]=i),n}async _getAppCheckToken(){var e;const n=await((e=this.appCheckServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getToken());return n!=null&&n.error&&y4(`Error while retrieving App Check token: ${n.error}`),n==null?void 0:n.token}}function jh(t){return Xe(t)}class cw{constructor(e){this.auth=e,this.observer=null,this.addObserver=BA(n=>this.observer=n)}get next(){return ie(this.observer,this.auth,"internal-error"),this.observer.next.bind(this.observer)}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */let r_={async loadJS(){throw new Error("Unable to load external scripts")},recaptchaV2Script:"",recaptchaEnterpriseScript:"",gapiScript:""};function j4(t){r_=t}function z4(t){return r_.loadJS(t)}function B4(){return r_.gapiScript}function $4(t){return`__${t}${Math.floor(Math.random()*1e6)}`}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function W4(t,e){const n=El(t,"auth");if(n.isInitialized()){const i=n.getImmediate(),s=n.getOptions();if(Rc(s,e??{}))return i;kr(i,"already-initialized")}return n.initialize({options:e})}function q4(t,e){const n=(e==null?void 0:e.persistence)||[],r=(Array.isArray(n)?n:[n]).map(hr);e!=null&&e.errorMap&&t._updateErrorMap(e.errorMap),t._initializeWithPersistence(r,e==null?void 0:e.popupRedirectResolver)}function H4(t,e,n){const r=jh(t);ie(r._canInitEmulator,r,"emulator-config-failed"),ie(/^https?:\/\//.test(e),r,"invalid-emulator-scheme");const i=!1,s=Ck(e),{host:o,port:a}=G4(e),u=a===null?"":`:${a}`;r.config.emulator={url:`${s}//${o}${u}/`},r.settings.appVerificationDisabledForTesting=!0,r.emulatorConfig=Object.freeze({host:o,port:a,protocol:s.replace(":",""),options:Object.freeze({disableWarnings:i})}),K4()}function Ck(t){const e=t.indexOf(":");return e<0?"":t.substr(0,e+1)}function G4(t){const e=Ck(t),n=/(\/\/)?([^?#/]+)/.exec(t.substr(e.length));if(!n)return{host:"",port:null};const r=n[2].split("@").pop()||"",i=/^(\[[^\]]+\])(:|$)/.exec(r);if(i){const s=i[1];return{host:s,port:hw(r.substr(s.length+1))}}else{const[s,o]=r.split(":");return{host:s,port:hw(o)}}}function hw(t){if(!t)return null;const e=Number(t);return isNaN(e)?null:e}function K4(){function t(){const e=document.createElement("p"),n=e.style;e.innerText="Running in emulator mode. Do not use with production credentials.",n.position="fixed",n.width="100%",n.backgroundColor="#ffffff",n.border=".1em solid #000000",n.color="#b50000",n.bottom="0px",n.left="0px",n.margin="0px",n.zIndex="10000",n.textAlign="center",e.classList.add("firebase-emulator-warning"),document.body.appendChild(e)}typeof console<"u"&&typeof console.info=="function"&&console.info("WARNING: You are using the Auth Emulator, which is intended for local testing only.  Do not use with production credentials."),typeof window<"u"&&typeof document<"u"&&(document.readyState==="loading"?window.addEventListener("DOMContentLoaded",t):t())}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Rk{constructor(e,n){this.providerId=e,this.signInMethod=n}toJSON(){return ur("not implemented")}_getIdTokenResponse(e){return ur("not implemented")}_linkToIdToken(e,n){return ur("not implemented")}_getReauthenticationResolver(e){return ur("not implemented")}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Gs(t,e){return dk(t,"POST","/v1/accounts:signInWithIdp",Uh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Q4="http://localhost";class Ji extends Rk{constructor(){super(...arguments),this.pendingToken=null}static _fromParams(e){const n=new Ji(e.providerId,e.signInMethod);return e.idToken||e.accessToken?(e.idToken&&(n.idToken=e.idToken),e.accessToken&&(n.accessToken=e.accessToken),e.nonce&&!e.pendingToken&&(n.nonce=e.nonce),e.pendingToken&&(n.pendingToken=e.pendingToken)):e.oauthToken&&e.oauthTokenSecret?(n.accessToken=e.oauthToken,n.secret=e.oauthTokenSecret):kr("argument-error"),n}toJSON(){return{idToken:this.idToken,accessToken:this.accessToken,secret:this.secret,nonce:this.nonce,pendingToken:this.pendingToken,providerId:this.providerId,signInMethod:this.signInMethod}}static fromJSON(e){const n=typeof e=="string"?JSON.parse(e):e,{providerId:r,signInMethod:i}=n,s=Jg(n,["providerId","signInMethod"]);if(!r||!i)return null;const o=new Ji(r,i);return o.idToken=s.idToken||void 0,o.accessToken=s.accessToken||void 0,o.secret=s.secret,o.nonce=s.nonce,o.pendingToken=s.pendingToken||null,o}_getIdTokenResponse(e){const n=this.buildRequest();return Gs(e,n)}_linkToIdToken(e,n){const r=this.buildRequest();return r.idToken=n,Gs(e,r)}_getReauthenticationResolver(e){const n=this.buildRequest();return n.autoCreate=!1,Gs(e,n)}buildRequest(){const e={requestUri:Q4,returnSecureToken:!0};if(this.pendingToken)e.pendingToken=this.pendingToken;else{const n={};this.idToken&&(n.id_token=this.idToken),this.accessToken&&(n.access_token=this.accessToken),this.secret&&(n.oauth_token_secret=this.secret),n.providerId=this.providerId,this.nonce&&!this.pendingToken&&(n.nonce=this.nonce),e.postBody=yo(n)}return e}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class xk{constructor(e){this.providerId=e,this.defaultLanguageCode=null,this.customParameters={}}setDefaultLanguage(e){this.defaultLanguageCode=e}setCustomParameters(e){return this.customParameters=e,this}getCustomParameters(){return this.customParameters}}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Ol extends xk{constructor(){super(...arguments),this.scopes=[]}addScope(e){return this.scopes.includes(e)||this.scopes.push(e),this}getScopes(){return[...this.scopes]}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class jr extends Ol{constructor(){super("facebook.com")}static credential(e){return Ji._fromParams({providerId:jr.PROVIDER_ID,signInMethod:jr.FACEBOOK_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return jr.credentialFromTaggedObject(e)}static credentialFromError(e){return jr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return jr.credential(e.oauthAccessToken)}catch{return null}}}jr.FACEBOOK_SIGN_IN_METHOD="facebook.com";jr.PROVIDER_ID="facebook.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zr extends Ol{constructor(){super("google.com"),this.addScope("profile")}static credential(e,n){return Ji._fromParams({providerId:zr.PROVIDER_ID,signInMethod:zr.GOOGLE_SIGN_IN_METHOD,idToken:e,accessToken:n})}static credentialFromResult(e){return zr.credentialFromTaggedObject(e)}static credentialFromError(e){return zr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthIdToken:n,oauthAccessToken:r}=e;if(!n&&!r)return null;try{return zr.credential(n,r)}catch{return null}}}zr.GOOGLE_SIGN_IN_METHOD="google.com";zr.PROVIDER_ID="google.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Br extends Ol{constructor(){super("github.com")}static credential(e){return Ji._fromParams({providerId:Br.PROVIDER_ID,signInMethod:Br.GITHUB_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return Br.credentialFromTaggedObject(e)}static credentialFromError(e){return Br.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return Br.credential(e.oauthAccessToken)}catch{return null}}}Br.GITHUB_SIGN_IN_METHOD="github.com";Br.PROVIDER_ID="github.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class $r extends Ol{constructor(){super("twitter.com")}static credential(e,n){return Ji._fromParams({providerId:$r.PROVIDER_ID,signInMethod:$r.TWITTER_SIGN_IN_METHOD,oauthToken:e,oauthTokenSecret:n})}static credentialFromResult(e){return $r.credentialFromTaggedObject(e)}static credentialFromError(e){return $r.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthAccessToken:n,oauthTokenSecret:r}=e;if(!n||!r)return null;try{return $r.credential(n,r)}catch{return null}}}$r.TWITTER_SIGN_IN_METHOD="twitter.com";$r.PROVIDER_ID="twitter.com";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Y4(t,e){return dk(t,"POST","/v1/accounts:signUp",Uh(t,e))}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class mi{constructor(e){this.user=e.user,this.providerId=e.providerId,this._tokenResponse=e._tokenResponse,this.operationType=e.operationType}static async _fromIdTokenResponse(e,n,r,i=!1){const s=await cr._fromIdTokenResponse(e,r,i),o=dw(r);return new mi({user:s,providerId:o,_tokenResponse:r,operationType:n})}static async _forOperation(e,n,r){await e._updateTokensIfNecessary(r,!0);const i=dw(r);return new mi({user:e,providerId:i,_tokenResponse:r,operationType:n})}}function dw(t){return t.providerId?t.providerId:"phoneNumber"in t?"phone":null}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function X4(t){var e;if(ar(t.app))return Promise.reject(ai(t));const n=jh(t);if(await n._initializationPromise,!((e=n.currentUser)===null||e===void 0)&&e.isAnonymous)return new mi({user:n.currentUser,providerId:null,operationType:"signIn"});const r=await Y4(n,{returnSecureToken:!0}),i=await mi._fromIdTokenResponse(n,"signIn",r,!0);return await n._updateCurrentUser(i.user),i}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Gc extends Zn{constructor(e,n,r,i){var s;super(n.code,n.message),this.operationType=r,this.user=i,Object.setPrototypeOf(this,Gc.prototype),this.customData={appName:e.name,tenantId:(s=e.tenantId)!==null&&s!==void 0?s:void 0,_serverResponse:n.customData._serverResponse,operationType:r}}static _fromErrorAndOperation(e,n,r,i){return new Gc(e,n,r,i)}}function Ak(t,e,n,r){return(e==="reauthenticate"?n._getReauthenticationResolver(t):n._getIdTokenResponse(t)).catch(s=>{throw s.code==="auth/multi-factor-auth-required"?Gc._fromErrorAndOperation(t,s,e,r):s})}async function J4(t,e,n=!1){const r=await pl(t,e._linkToIdToken(t.auth,await t.getIdToken()),n);return mi._forOperation(t,"link",r)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function Z4(t,e,n=!1){const{auth:r}=t;if(ar(r.app))return Promise.reject(ai(r));const i="reauthenticate";try{const s=await pl(t,Ak(r,i,e,t),n);ie(s.idToken,r,"internal-error");const o=t_(s.idToken);ie(o,r,"internal-error");const{sub:a}=o;return ie(t.uid===a,r,"user-mismatch"),mi._forOperation(t,i,s)}catch(s){throw(s==null?void 0:s.code)==="auth/user-not-found"&&kr(r,"user-mismatch"),s}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function eF(t,e,n=!1){if(ar(t.app))return Promise.reject(ai(t));const r="signIn",i=await Ak(t,r,e),s=await mi._fromIdTokenResponse(t,r,i);return n||await t._updateCurrentUser(s.user),s}function tF(t,e,n,r){return Xe(t).onIdTokenChanged(e,n,r)}function nF(t,e,n){return Xe(t).beforeAuthStateChanged(e,n)}const Kc="__sak";/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class bk{constructor(e,n){this.storageRetriever=e,this.type=n}_isAvailable(){try{return this.storage?(this.storage.setItem(Kc,"1"),this.storage.removeItem(Kc),Promise.resolve(!0)):Promise.resolve(!1)}catch{return Promise.resolve(!1)}}_set(e,n){return this.storage.setItem(e,JSON.stringify(n)),Promise.resolve()}_get(e){const n=this.storage.getItem(e);return Promise.resolve(n?JSON.parse(n):null)}_remove(e){return this.storage.removeItem(e),Promise.resolve()}get storage(){return this.storageRetriever()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const rF=1e3,iF=10;class Pk extends bk{constructor(){super(()=>window.localStorage,"LOCAL"),this.boundEventHandler=(e,n)=>this.onStorageEvent(e,n),this.listeners={},this.localCache={},this.pollTimer=null,this.fallbackToPolling=Sk(),this._shouldAllowMigration=!0}forAllChangedKeys(e){for(const n of Object.keys(this.listeners)){const r=this.storage.getItem(n),i=this.localCache[n];r!==i&&e(n,i,r)}}onStorageEvent(e,n=!1){if(!e.key){this.forAllChangedKeys((o,a,u)=>{this.notifyListeners(o,u)});return}const r=e.key;n?this.detachListener():this.stopPolling();const i=()=>{const o=this.storage.getItem(r);!n&&this.localCache[r]===o||this.notifyListeners(r,o)},s=this.storage.getItem(r);O4()&&s!==e.newValue&&e.newValue!==e.oldValue?setTimeout(i,iF):i()}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n&&JSON.parse(n))}startPolling(){this.stopPolling(),this.pollTimer=setInterval(()=>{this.forAllChangedKeys((e,n,r)=>{this.onStorageEvent(new StorageEvent("storage",{key:e,oldValue:n,newValue:r}),!0)})},rF)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}attachListener(){window.addEventListener("storage",this.boundEventHandler)}detachListener(){window.removeEventListener("storage",this.boundEventHandler)}_addListener(e,n){Object.keys(this.listeners).length===0&&(this.fallbackToPolling?this.startPolling():this.attachListener()),this.listeners[e]||(this.listeners[e]=new Set,this.localCache[e]=this.storage.getItem(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&(this.detachListener(),this.stopPolling())}async _set(e,n){await super._set(e,n),this.localCache[e]=JSON.stringify(n)}async _get(e){const n=await super._get(e);return this.localCache[e]=JSON.stringify(n),n}async _remove(e){await super._remove(e),delete this.localCache[e]}}Pk.type="LOCAL";const sF=Pk;/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Nk extends bk{constructor(){super(()=>window.sessionStorage,"SESSION")}_addListener(e,n){}_removeListener(e,n){}}Nk.type="SESSION";const Dk=Nk;/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function oF(t){return Promise.all(t.map(async e=>{try{return{fulfilled:!0,value:await e}}catch(n){return{fulfilled:!1,reason:n}}}))}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class zh{constructor(e){this.eventTarget=e,this.handlersMap={},this.boundEventHandler=this.handleEvent.bind(this)}static _getInstance(e){const n=this.receivers.find(i=>i.isListeningto(e));if(n)return n;const r=new zh(e);return this.receivers.push(r),r}isListeningto(e){return this.eventTarget===e}async handleEvent(e){const n=e,{eventId:r,eventType:i,data:s}=n.data,o=this.handlersMap[i];if(!(o!=null&&o.size))return;n.ports[0].postMessage({status:"ack",eventId:r,eventType:i});const a=Array.from(o).map(async c=>c(n.origin,s)),u=await oF(a);n.ports[0].postMessage({status:"done",eventId:r,eventType:i,response:u})}_subscribe(e,n){Object.keys(this.handlersMap).length===0&&this.eventTarget.addEventListener("message",this.boundEventHandler),this.handlersMap[e]||(this.handlersMap[e]=new Set),this.handlersMap[e].add(n)}_unsubscribe(e,n){this.handlersMap[e]&&n&&this.handlersMap[e].delete(n),(!n||this.handlersMap[e].size===0)&&delete this.handlersMap[e],Object.keys(this.handlersMap).length===0&&this.eventTarget.removeEventListener("message",this.boundEventHandler)}}zh.receivers=[];/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function i_(t="",e=10){let n="";for(let r=0;r<e;r++)n+=Math.floor(Math.random()*10);return t+n}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class aF{constructor(e){this.target=e,this.handlers=new Set}removeMessageHandler(e){e.messageChannel&&(e.messageChannel.port1.removeEventListener("message",e.onMessage),e.messageChannel.port1.close()),this.handlers.delete(e)}async _send(e,n,r=50){const i=typeof MessageChannel<"u"?new MessageChannel:null;if(!i)throw new Error("connection_unavailable");let s,o;return new Promise((a,u)=>{const c=i_("",20);i.port1.start();const h=setTimeout(()=>{u(new Error("unsupported_event"))},r);o={messageChannel:i,onMessage(f){const g=f;if(g.data.eventId===c)switch(g.data.status){case"ack":clearTimeout(h),s=setTimeout(()=>{u(new Error("timeout"))},3e3);break;case"done":clearTimeout(s),a(g.data.response);break;default:clearTimeout(h),clearTimeout(s),u(new Error("invalid_response"));break}}},this.handlers.add(o),i.port1.addEventListener("message",o.onMessage),this.target.postMessage({eventType:e,eventId:c,data:n},[i.port2])}).finally(()=>{o&&this.removeMessageHandler(o)})}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Xn(){return window}function lF(t){Xn().location.href=t}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function Ok(){return typeof Xn().WorkerGlobalScope<"u"&&typeof Xn().importScripts=="function"}async function uF(){if(!(navigator!=null&&navigator.serviceWorker))return null;try{return(await navigator.serviceWorker.ready).active}catch{return null}}function cF(){var t;return((t=navigator==null?void 0:navigator.serviceWorker)===null||t===void 0?void 0:t.controller)||null}function hF(){return Ok()?self:null}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const Mk="firebaseLocalStorageDb",dF=1,Qc="firebaseLocalStorage",Lk="fbase_key";class Ml{constructor(e){this.request=e}toPromise(){return new Promise((e,n)=>{this.request.addEventListener("success",()=>{e(this.request.result)}),this.request.addEventListener("error",()=>{n(this.request.error)})})}}function Bh(t,e){return t.transaction([Qc],e?"readwrite":"readonly").objectStore(Qc)}function fF(){const t=indexedDB.deleteDatabase(Mk);return new Ml(t).toPromise()}function Fp(){const t=indexedDB.open(Mk,dF);return new Promise((e,n)=>{t.addEventListener("error",()=>{n(t.error)}),t.addEventListener("upgradeneeded",()=>{const r=t.result;try{r.createObjectStore(Qc,{keyPath:Lk})}catch(i){n(i)}}),t.addEventListener("success",async()=>{const r=t.result;r.objectStoreNames.contains(Qc)?e(r):(r.close(),await fF(),e(await Fp()))})})}async function fw(t,e,n){const r=Bh(t,!0).put({[Lk]:e,value:n});return new Ml(r).toPromise()}async function pF(t,e){const n=Bh(t,!1).get(e),r=await new Ml(n).toPromise();return r===void 0?null:r.value}function pw(t,e){const n=Bh(t,!0).delete(e);return new Ml(n).toPromise()}const mF=800,gF=3;class Fk{constructor(){this.type="LOCAL",this._shouldAllowMigration=!0,this.listeners={},this.localCache={},this.pollTimer=null,this.pendingWrites=0,this.receiver=null,this.sender=null,this.serviceWorkerReceiverAvailable=!1,this.activeServiceWorker=null,this._workerInitializationPromise=this.initializeServiceWorkerMessaging().then(()=>{},()=>{})}async _openDb(){return this.db?this.db:(this.db=await Fp(),this.db)}async _withRetries(e){let n=0;for(;;)try{const r=await this._openDb();return await e(r)}catch(r){if(n++>gF)throw r;this.db&&(this.db.close(),this.db=void 0)}}async initializeServiceWorkerMessaging(){return Ok()?this.initializeReceiver():this.initializeSender()}async initializeReceiver(){this.receiver=zh._getInstance(hF()),this.receiver._subscribe("keyChanged",async(e,n)=>({keyProcessed:(await this._poll()).includes(n.key)})),this.receiver._subscribe("ping",async(e,n)=>["keyChanged"])}async initializeSender(){var e,n;if(this.activeServiceWorker=await uF(),!this.activeServiceWorker)return;this.sender=new aF(this.activeServiceWorker);const r=await this.sender._send("ping",{},800);r&&!((e=r[0])===null||e===void 0)&&e.fulfilled&&!((n=r[0])===null||n===void 0)&&n.value.includes("keyChanged")&&(this.serviceWorkerReceiverAvailable=!0)}async notifyServiceWorker(e){if(!(!this.sender||!this.activeServiceWorker||cF()!==this.activeServiceWorker))try{await this.sender._send("keyChanged",{key:e},this.serviceWorkerReceiverAvailable?800:50)}catch{}}async _isAvailable(){try{if(!indexedDB)return!1;const e=await Fp();return await fw(e,Kc,"1"),await pw(e,Kc),!0}catch{}return!1}async _withPendingWrite(e){this.pendingWrites++;try{await e()}finally{this.pendingWrites--}}async _set(e,n){return this._withPendingWrite(async()=>(await this._withRetries(r=>fw(r,e,n)),this.localCache[e]=n,this.notifyServiceWorker(e)))}async _get(e){const n=await this._withRetries(r=>pF(r,e));return this.localCache[e]=n,n}async _remove(e){return this._withPendingWrite(async()=>(await this._withRetries(n=>pw(n,e)),delete this.localCache[e],this.notifyServiceWorker(e)))}async _poll(){const e=await this._withRetries(i=>{const s=Bh(i,!1).getAll();return new Ml(s).toPromise()});if(!e)return[];if(this.pendingWrites!==0)return[];const n=[],r=new Set;if(e.length!==0)for(const{fbase_key:i,value:s}of e)r.add(i),JSON.stringify(this.localCache[i])!==JSON.stringify(s)&&(this.notifyListeners(i,s),n.push(i));for(const i of Object.keys(this.localCache))this.localCache[i]&&!r.has(i)&&(this.notifyListeners(i,null),n.push(i));return n}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n)}startPolling(){this.stopPolling(),this.pollTimer=setInterval(async()=>this._poll(),mF)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}_addListener(e,n){Object.keys(this.listeners).length===0&&this.startPolling(),this.listeners[e]||(this.listeners[e]=new Set,this._get(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&this.stopPolling()}}Fk.type="LOCAL";const _F=Fk;new Dl(3e4,6e4);/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function yF(t,e){return e?hr(e):(ie(t._popupRedirectResolver,t,"argument-error"),t._popupRedirectResolver)}/**
 * @license
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class s_ extends Rk{constructor(e){super("custom","custom"),this.params=e}_getIdTokenResponse(e){return Gs(e,this._buildIdpRequest())}_linkToIdToken(e,n){return Gs(e,this._buildIdpRequest(n))}_getReauthenticationResolver(e){return Gs(e,this._buildIdpRequest())}_buildIdpRequest(e){const n={requestUri:this.params.requestUri,sessionId:this.params.sessionId,postBody:this.params.postBody,tenantId:this.params.tenantId,pendingToken:this.params.pendingToken,returnSecureToken:!0,returnIdpCredential:!0};return e&&(n.idToken=e),n}}function vF(t){return eF(t.auth,new s_(t),t.bypassAuthState)}function wF(t){const{auth:e,user:n}=t;return ie(n,e,"internal-error"),Z4(n,new s_(t),t.bypassAuthState)}async function EF(t){const{auth:e,user:n}=t;return ie(n,e,"internal-error"),J4(n,new s_(t),t.bypassAuthState)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class Vk{constructor(e,n,r,i,s=!1){this.auth=e,this.resolver=r,this.user=i,this.bypassAuthState=s,this.pendingPromise=null,this.eventManager=null,this.filter=Array.isArray(n)?n:[n]}execute(){return new Promise(async(e,n)=>{this.pendingPromise={resolve:e,reject:n};try{this.eventManager=await this.resolver._initialize(this.auth),await this.onExecution(),this.eventManager.registerConsumer(this)}catch(r){this.reject(r)}})}async onAuthEvent(e){const{urlResponse:n,sessionId:r,postBody:i,tenantId:s,error:o,type:a}=e;if(o){this.reject(o);return}const u={auth:this.auth,requestUri:n,sessionId:r,tenantId:s||void 0,postBody:i||void 0,user:this.user,bypassAuthState:this.bypassAuthState};try{this.resolve(await this.getIdpTask(a)(u))}catch(c){this.reject(c)}}onError(e){this.reject(e)}getIdpTask(e){switch(e){case"signInViaPopup":case"signInViaRedirect":return vF;case"linkViaPopup":case"linkViaRedirect":return EF;case"reauthViaPopup":case"reauthViaRedirect":return wF;default:kr(this.auth,"internal-error")}}resolve(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.resolve(e),this.unregisterAndCleanUp()}reject(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.reject(e),this.unregisterAndCleanUp()}unregisterAndCleanUp(){this.eventManager&&this.eventManager.unregisterConsumer(this),this.pendingPromise=null,this.cleanUp()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const TF=new Dl(2e3,1e4);class Ms extends Vk{constructor(e,n,r,i,s){super(e,n,i,s),this.provider=r,this.authWindow=null,this.pollId=null,Ms.currentPopupAction&&Ms.currentPopupAction.cancel(),Ms.currentPopupAction=this}async executeNotNull(){const e=await this.execute();return ie(e,this.auth,"internal-error"),e}async onExecution(){Cr(this.filter.length===1,"Popup operations only handle one event");const e=i_();this.authWindow=await this.resolver._openPopup(this.auth,this.provider,this.filter[0],e),this.authWindow.associatedEvent=e,this.resolver._originValidation(this.auth).catch(n=>{this.reject(n)}),this.resolver._isIframeWebStorageSupported(this.auth,n=>{n||this.reject(Yn(this.auth,"web-storage-unsupported"))}),this.pollUserCancellation()}get eventId(){var e;return((e=this.authWindow)===null||e===void 0?void 0:e.associatedEvent)||null}cancel(){this.reject(Yn(this.auth,"cancelled-popup-request"))}cleanUp(){this.authWindow&&this.authWindow.close(),this.pollId&&window.clearTimeout(this.pollId),this.authWindow=null,this.pollId=null,Ms.currentPopupAction=null}pollUserCancellation(){const e=()=>{var n,r;if(!((r=(n=this.authWindow)===null||n===void 0?void 0:n.window)===null||r===void 0)&&r.closed){this.pollId=window.setTimeout(()=>{this.pollId=null,this.reject(Yn(this.auth,"popup-closed-by-user"))},8e3);return}this.pollId=window.setTimeout(e,TF.get())};e()}}Ms.currentPopupAction=null;/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const IF="pendingRedirect",Xu=new Map;class SF extends Vk{constructor(e,n,r=!1){super(e,["signInViaRedirect","linkViaRedirect","reauthViaRedirect","unknown"],n,void 0,r),this.eventId=null}async execute(){let e=Xu.get(this.auth._key());if(!e){try{const r=await kF(this.resolver,this.auth)?await super.execute():null;e=()=>Promise.resolve(r)}catch(n){e=()=>Promise.reject(n)}Xu.set(this.auth._key(),e)}return this.bypassAuthState||Xu.set(this.auth._key(),()=>Promise.resolve(null)),e()}async onAuthEvent(e){if(e.type==="signInViaRedirect")return super.onAuthEvent(e);if(e.type==="unknown"){this.resolve(null);return}if(e.eventId){const n=await this.auth._redirectUserForId(e.eventId);if(n)return this.user=n,super.onAuthEvent(e);this.resolve(null)}}async onExecution(){}cleanUp(){}}async function kF(t,e){const n=xF(e),r=RF(t);if(!await r._isAvailable())return!1;const i=await r._get(n)==="true";return await r._remove(n),i}function CF(t,e){Xu.set(t._key(),e)}function RF(t){return hr(t._redirectPersistence)}function xF(t){return Yu(IF,t.config.apiKey,t.name)}async function AF(t,e,n=!1){if(ar(t.app))return Promise.reject(ai(t));const r=jh(t),i=yF(r,e),o=await new SF(r,i,n).execute();return o&&!n&&(delete o.user._redirectEventId,await r._persistUserIfCurrent(o.user),await r._setRedirectUser(null,e)),o}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const bF=10*60*1e3;class PF{constructor(e){this.auth=e,this.cachedEventUids=new Set,this.consumers=new Set,this.queuedRedirectEvent=null,this.hasHandledPotentialRedirect=!1,this.lastProcessedEventTime=Date.now()}registerConsumer(e){this.consumers.add(e),this.queuedRedirectEvent&&this.isEventForConsumer(this.queuedRedirectEvent,e)&&(this.sendToConsumer(this.queuedRedirectEvent,e),this.saveEventToCache(this.queuedRedirectEvent),this.queuedRedirectEvent=null)}unregisterConsumer(e){this.consumers.delete(e)}onEvent(e){if(this.hasEventBeenHandled(e))return!1;let n=!1;return this.consumers.forEach(r=>{this.isEventForConsumer(e,r)&&(n=!0,this.sendToConsumer(e,r),this.saveEventToCache(e))}),this.hasHandledPotentialRedirect||!NF(e)||(this.hasHandledPotentialRedirect=!0,n||(this.queuedRedirectEvent=e,n=!0)),n}sendToConsumer(e,n){var r;if(e.error&&!Uk(e)){const i=((r=e.error.code)===null||r===void 0?void 0:r.split("auth/")[1])||"internal-error";n.onError(Yn(this.auth,i))}else n.onAuthEvent(e)}isEventForConsumer(e,n){const r=n.eventId===null||!!e.eventId&&e.eventId===n.eventId;return n.filter.includes(e.type)&&r}hasEventBeenHandled(e){return Date.now()-this.lastProcessedEventTime>=bF&&this.cachedEventUids.clear(),this.cachedEventUids.has(mw(e))}saveEventToCache(e){this.cachedEventUids.add(mw(e)),this.lastProcessedEventTime=Date.now()}}function mw(t){return[t.type,t.eventId,t.sessionId,t.tenantId].filter(e=>e).join("-")}function Uk({type:t,error:e}){return t==="unknown"&&(e==null?void 0:e.code)==="auth/no-auth-event"}function NF(t){switch(t.type){case"signInViaRedirect":case"linkViaRedirect":case"reauthViaRedirect":return!0;case"unknown":return Uk(t);default:return!1}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */async function DF(t,e={}){return xo(t,"GET","/v1/projects",e)}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const OF=/^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/,MF=/^https?/;async function LF(t){if(t.config.emulator)return;const{authorizedDomains:e}=await DF(t);for(const n of e)try{if(FF(n))return}catch{}kr(t,"unauthorized-domain")}function FF(t){const e=Mp(),{protocol:n,hostname:r}=new URL(e);if(t.startsWith("chrome-extension://")){const o=new URL(t);return o.hostname===""&&r===""?n==="chrome-extension:"&&t.replace("chrome-extension://","")===e.replace("chrome-extension://",""):n==="chrome-extension:"&&o.hostname===r}if(!MF.test(n))return!1;if(OF.test(t))return r===t;const i=t.replace(/\./g,"\\.");return new RegExp("^(.+\\."+i+"|"+i+")$","i").test(r)}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const VF=new Dl(3e4,6e4);function gw(){const t=Xn().___jsl;if(t!=null&&t.H){for(const e of Object.keys(t.H))if(t.H[e].r=t.H[e].r||[],t.H[e].L=t.H[e].L||[],t.H[e].r=[...t.H[e].L],t.CP)for(let n=0;n<t.CP.length;n++)t.CP[n]=null}}function UF(t){return new Promise((e,n)=>{var r,i,s;function o(){gw(),gapi.load("gapi.iframes",{callback:()=>{e(gapi.iframes.getContext())},ontimeout:()=>{gw(),n(Yn(t,"network-request-failed"))},timeout:VF.get()})}if(!((i=(r=Xn().gapi)===null||r===void 0?void 0:r.iframes)===null||i===void 0)&&i.Iframe)e(gapi.iframes.getContext());else if(!((s=Xn().gapi)===null||s===void 0)&&s.load)o();else{const a=$4("iframefcb");return Xn()[a]=()=>{gapi.load?o():n(Yn(t,"network-request-failed"))},z4(`${B4()}?onload=${a}`).catch(u=>n(u))}}).catch(e=>{throw Ju=null,e})}let Ju=null;function jF(t){return Ju=Ju||UF(t),Ju}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const zF=new Dl(5e3,15e3),BF="__/auth/iframe",$F="emulator/auth/iframe",WF={style:{position:"absolute",top:"-100px",width:"1px",height:"1px"},"aria-hidden":"true",tabindex:"-1"},qF=new Map([["identitytoolkit.googleapis.com","p"],["staging-identitytoolkit.sandbox.googleapis.com","s"],["test-identitytoolkit.sandbox.googleapis.com","t"]]);function HF(t){const e=t.config;ie(e.authDomain,t,"auth-domain-config-required");const n=e.emulator?e_(e,$F):`https://${t.config.authDomain}/${BF}`,r={apiKey:e.apiKey,appName:t.name,v:vi},i=qF.get(t.config.apiHost);i&&(r.eid=i);const s=t._getFrameworks();return s.length&&(r.fw=s.join(",")),`${n}?${yo(r).slice(1)}`}async function GF(t){const e=await jF(t),n=Xn().gapi;return ie(n,t,"internal-error"),e.open({where:document.body,url:HF(t),messageHandlersFilter:n.iframes.CROSS_ORIGIN_IFRAMES_FILTER,attributes:WF,dontclear:!0},r=>new Promise(async(i,s)=>{await r.restyle({setHideOnLeave:!1});const o=Yn(t,"network-request-failed"),a=Xn().setTimeout(()=>{s(o)},zF.get());function u(){Xn().clearTimeout(a),i(r)}r.ping(u).then(u,()=>{s(o)})}))}/**
 * @license
 * Copyright 2020 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const KF={location:"yes",resizable:"yes",statusbar:"yes",toolbar:"no"},QF=500,YF=600,XF="_blank",JF="http://localhost";class _w{constructor(e){this.window=e,this.associatedEvent=null}close(){if(this.window)try{this.window.close()}catch{}}}function ZF(t,e,n,r=QF,i=YF){const s=Math.max((window.screen.availHeight-i)/2,0).toString(),o=Math.max((window.screen.availWidth-r)/2,0).toString();let a="";const u=Object.assign(Object.assign({},KF),{width:r.toString(),height:i.toString(),top:s,left:o}),c=jt().toLowerCase();n&&(a=vk(c)?XF:n),_k(c)&&(e=e||JF,u.scrollbars="yes");const h=Object.entries(u).reduce((g,[v,I])=>`${g}${v}=${I},`,"");if(D4(c)&&a!=="_self")return eV(e||"",a),new _w(null);const f=window.open(e||"",a,h);ie(f,t,"popup-blocked");try{f.focus()}catch{}return new _w(f)}function eV(t,e){const n=document.createElement("a");n.href=t,n.target=e;const r=document.createEvent("MouseEvent");r.initMouseEvent("click",!0,!0,window,1,0,0,0,0,!1,!1,!1,!1,1,null),n.dispatchEvent(r)}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const tV="__/auth/handler",nV="emulator/auth/handler",rV=encodeURIComponent("fac");async function yw(t,e,n,r,i,s){ie(t.config.authDomain,t,"auth-domain-config-required"),ie(t.config.apiKey,t,"invalid-api-key");const o={apiKey:t.config.apiKey,appName:t.name,authType:n,redirectUrl:r,v:vi,eventId:i};if(e instanceof xk){e.setDefaultLanguage(t.languageCode),o.providerId=e.providerId||"",Zf(e.getCustomParameters())||(o.customParameters=JSON.stringify(e.getCustomParameters()));for(const[h,f]of Object.entries({}))o[h]=f}if(e instanceof Ol){const h=e.getScopes().filter(f=>f!=="");h.length>0&&(o.scopes=h.join(","))}t.tenantId&&(o.tid=t.tenantId);const a=o;for(const h of Object.keys(a))a[h]===void 0&&delete a[h];const u=await t._getAppCheckToken(),c=u?`#${rV}=${encodeURIComponent(u)}`:"";return`${iV(t)}?${yo(a).slice(1)}${c}`}function iV({config:t}){return t.emulator?e_(t,nV):`https://${t.authDomain}/${tV}`}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const nf="webStorageSupport";class sV{constructor(){this.eventManagers={},this.iframes={},this.originValidationPromises={},this._redirectPersistence=Dk,this._completeRedirectFn=AF,this._overrideRedirectResult=CF}async _openPopup(e,n,r,i){var s;Cr((s=this.eventManagers[e._key()])===null||s===void 0?void 0:s.manager,"_initialize() not called before _openPopup()");const o=await yw(e,n,r,Mp(),i);return ZF(e,o,i_())}async _openRedirect(e,n,r,i){await this._originValidation(e);const s=await yw(e,n,r,Mp(),i);return lF(s),new Promise(()=>{})}_initialize(e){const n=e._key();if(this.eventManagers[n]){const{manager:i,promise:s}=this.eventManagers[n];return i?Promise.resolve(i):(Cr(s,"If manager is not set, promise should be"),s)}const r=this.initAndGetManager(e);return this.eventManagers[n]={promise:r},r.catch(()=>{delete this.eventManagers[n]}),r}async initAndGetManager(e){const n=await GF(e),r=new PF(e);return n.register("authEvent",i=>(ie(i==null?void 0:i.authEvent,e,"invalid-auth-event"),{status:r.onEvent(i.authEvent)?"ACK":"ERROR"}),gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER),this.eventManagers[e._key()]={manager:r},this.iframes[e._key()]=n,r}_isIframeWebStorageSupported(e,n){this.iframes[e._key()].send(nf,{type:nf},i=>{var s;const o=(s=i==null?void 0:i[0])===null||s===void 0?void 0:s[nf];o!==void 0&&n(!!o),kr(e,"internal-error")},gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER)}_originValidation(e){const n=e._key();return this.originValidationPromises[n]||(this.originValidationPromises[n]=LF(e)),this.originValidationPromises[n]}get _shouldInitProactively(){return Sk()||yk()||n_()}}const oV=sV;var vw="@firebase/auth",ww="1.7.9";/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */class aV{constructor(e){this.auth=e,this.internalListeners=new Map}getUid(){var e;return this.assertAuthConfigured(),((e=this.auth.currentUser)===null||e===void 0?void 0:e.uid)||null}async getToken(e){return this.assertAuthConfigured(),await this.auth._initializationPromise,this.auth.currentUser?{accessToken:await this.auth.currentUser.getIdToken(e)}:null}addAuthTokenListener(e){if(this.assertAuthConfigured(),this.internalListeners.has(e))return;const n=this.auth.onIdTokenChanged(r=>{e((r==null?void 0:r.stsTokenManager.accessToken)||null)});this.internalListeners.set(e,n),this.updateProactiveRefresh()}removeAuthTokenListener(e){this.assertAuthConfigured();const n=this.internalListeners.get(e);n&&(this.internalListeners.delete(e),n(),this.updateProactiveRefresh())}assertAuthConfigured(){ie(this.auth._initializationPromise,"dependent-sdk-initialized-before-auth")}updateProactiveRefresh(){this.internalListeners.size>0?this.auth._startProactiveRefresh():this.auth._stopProactiveRefresh()}}/**
 * @license
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */function lV(t){switch(t){case"Node":return"node";case"ReactNative":return"rn";case"Worker":return"webworker";case"Cordova":return"cordova";case"WebExtension":return"web-extension";default:return}}function uV(t){ci(new vr("auth",(e,{options:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("heartbeat"),s=e.getProvider("app-check-internal"),{apiKey:o,authDomain:a}=r.options;ie(o&&!o.includes(":"),"invalid-api-key",{appName:r.name});const u={apiKey:o,authDomain:a,clientPlatform:t,apiHost:"identitytoolkit.googleapis.com",tokenApiHost:"securetoken.googleapis.com",apiScheme:"https",sdkClientVersion:kk(t)},c=new U4(r,i,s,u);return q4(c,n),c},"PUBLIC").setInstantiationMode("EXPLICIT").setInstanceCreatedCallback((e,n,r)=>{e.getProvider("auth-internal").initialize()})),ci(new vr("auth-internal",e=>{const n=jh(e.getProvider("auth").getImmediate());return(r=>new aV(r))(n)},"PRIVATE").setInstantiationMode("EXPLICIT")),Tn(vw,ww,lV(t)),Tn(vw,ww,"esm2017")}/**
 * @license
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */const cV=5*60,hV=JT("authIdTokenMaxAge")||cV;let Ew=null;const dV=t=>async e=>{const n=e&&await e.getIdTokenResult(),r=n&&(new Date().getTime()-Date.parse(n.issuedAtTime))/1e3;if(r&&r>hV)return;const i=n==null?void 0:n.token;Ew!==i&&(Ew=i,await fetch(t,{method:i?"POST":"DELETE",headers:i?{Authorization:`Bearer ${i}`}:{}}))};function fV(t=vh()){const e=El(t,"auth");if(e.isInitialized())return e.getImmediate();const n=W4(t,{popupRedirectResolver:oV,persistence:[_F,sF,Dk]}),r=JT("authTokenSyncURL");if(r&&typeof isSecureContext=="boolean"&&isSecureContext){const s=new URL(r,location.origin);if(location.origin===s.origin){const o=dV(s.toString());nF(n,o,()=>o(n.currentUser)),tF(n,a=>o(a))}}const i=YT("auth");return i&&H4(n,`http://${i}`),n}function pV(){var t,e;return(e=(t=document.getElementsByTagName("head"))===null||t===void 0?void 0:t[0])!==null&&e!==void 0?e:document}j4({loadJS(t){return new Promise((e,n)=>{const r=document.createElement("script");r.setAttribute("src",t),r.onload=e,r.onerror=i=>{const s=Yn("internal-error");s.customData=i,n(s)},r.type="text/javascript",r.charset="UTF-8",pV().appendChild(r)})},gapiScript:"https://apis.google.com/js/api.js",recaptchaV2Script:"https://www.google.com/recaptcha/api.js",recaptchaEnterpriseScript:"https://www.google.com/recaptcha/enterprise.js?render="});uV("Browser");const Oa={apiKey:"AIzaSyC0sUtQ-SsE-IazJNg9AwP-JmQ_xJMR1iY",authDomain:"book-store-bec15.firebaseapp.com",databaseURL:"https://book-store-bec15-default-rtdb.firebaseio.com",projectId:"book-store-bec15",storageBucket:"book-store-bec15.firebasestorage.app",messagingSenderId:"1096744232990",appId:"1:1096744232990:web:186080c3ec42ad7a33660f",measurementId:"G-8YSJN6PWZT"},$h=rI(Oa),mV=fV($h),xu=WN($h),Tw=CO($h),rf=p4($h);function gV({activeTab:t,setActiveTab:e,bookCount:n,courseCount:r,onOpenRules:i}){return m.jsx("header",{style:{position:"sticky",top:0,zIndex:50,backdropFilter:"blur(20px)",WebkitBackdropFilter:"blur(20px)",background:"rgba(9, 13, 22, 0.85)",borderBottom:"1px solid rgba(255, 255, 255, 0.08)",padding:"0.85rem 2rem"},children:m.jsxs("div",{style:{maxWidth:1280,margin:"0 auto",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx("div",{style:{width:42,height:42,borderRadius:12,background:"linear-gradient(135deg, #6366f1, #a855f7)",display:"flex",alignItems:"center",justifyContent:"center",boxShadow:"0 0 20px rgba(99, 102, 241, 0.4)"},children:m.jsx(no,{size:22,color:"#ffffff"})}),m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"1.25rem",fontWeight:800,letterSpacing:"-0.02em",background:"linear-gradient(to right, #ffffff, #c7d2fe)",WebkitBackgroundClip:"text",WebkitTextFillColor:"transparent"},children:"AudioBook Studio"}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#64748b"},children:"Firebase Markdown Publishing Portal"})]})]}),m.jsxs("div",{style:{display:"flex",background:"rgba(255, 255, 255, 0.04)",padding:"4px",borderRadius:"12px",border:"1px solid rgba(255, 255, 255, 0.06)"},children:[m.jsxs("button",{onClick:()=>e("upload"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="upload"?"var(--accent-primary)":"transparent",color:t==="upload"?"#ffffff":"var(--text-muted)"},children:[m.jsx(Dm,{size:16}),"Upload & Parse"]}),m.jsxs("button",{onClick:()=>e("library"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="library"?"var(--accent-primary)":"transparent",color:t==="library"?"#ffffff":"var(--text-muted)"},children:[m.jsx(dA,{size:16}),"Library",typeof n=="number"&&m.jsx("span",{style:{background:t==="library"?"rgba(255,255,255,0.25)":"rgba(255,255,255,0.1)",padding:"1px 7px",borderRadius:"9999px",fontSize:"0.75rem",marginLeft:4},children:n})]}),m.jsxs("button",{onClick:()=>e("courses"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="courses"?"linear-gradient(135deg, #10b981, #059669)":"transparent",color:t==="courses"?"#ffffff":"var(--text-muted)"},children:[m.jsx(Jf,{size:16}),"Language & Skill Courses",typeof r=="number"&&r>0&&m.jsx("span",{style:{background:t==="courses"?"rgba(255,255,255,0.25)":"rgba(255,255,255,0.1)",padding:"1px 7px",borderRadius:"9999px",fontSize:"0.75rem",marginLeft:4},children:r})]})]}),m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx("button",{onClick:i,className:"btn-secondary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",color:"#f87171",borderColor:"rgba(239, 68, 68, 0.3)"},title:"Setup Firebase Storage & Firestore Rules",children:"Fix Rules / Permissions"}),m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.6rem",background:"rgba(16, 185, 129, 0.1)",border:"1px solid rgba(16, 185, 129, 0.25)",padding:"0.4rem 0.85rem",borderRadius:"9999px",fontSize:"0.78rem",color:"#6ee7b7"},children:[m.jsx("span",{style:{width:8,height:8,borderRadius:"50%",background:"#10b981",boxShadow:"0 0 10px #10b981"}}),m.jsxs("span",{children:["Firebase: ",m.jsx("strong",{children:Oa.projectId})]})]})]})]})})}function _V(t,e=""){if(!t)return{title:e.replace(/\.(md|markdown|txt|pdf)$/i,"").replace(/_/g," "),subtitle:"",author:"",translator:"",tagline:"",totalWords:0,estimatedMinutes:1};const n=t.split(/\r?\n/);let r="",i="",s="",o="",a="";const u=e.replace(/\.(md|markdown|txt|pdf)$/i,"").replace(/_/g," "),c=n.find(D=>/^#\s+(.+)/.test(D));c?r=c.replace(/^#\s+/,"").trim():r=u;const h=n.find(D=>/^\s*[\*_]\((.+)\)[\*_]\s*$/.test(D)||/^\s*[\*_]([^\*_]+)[\*_]\s*$/.test(D));if(h){const D=h.match(/[\*_]\(?([^\*\_\(\)]+)\)?[\*_]/);D&&(i=D[1].trim())}const f=t.match(/\*\*(?:মূল\s*লেখক|লেখক|Author|Written By)\s*:\*\*\s*([^\n\r]+)/i);f&&(s=f[1].trim());const g=t.match(/\*\*(?:অনুবাদক\s*ও\s*সংকলক|অনুবাদক|সংকলক|Translator|Compiled By)\s*:\*\*\s*([^\n\r]+)/i);g&&(o=g[1].trim());const v=t.match(/\n\*\*([^\*:\n]{8,80})\*\*\s*\n/);v&&(!f||!f[0].includes(v[1]))&&(a=v[1].trim());const I=yV(t),N=Math.max(1,Math.ceil(I/140));return{title:r||u,subtitle:i,author:s,translator:o,tagline:a,totalWords:I,estimatedMinutes:N}}function yV(t){return t?t.trim().split(/\s+/).filter(n=>n.length>0).length:0}function vV(t){if(!t)return`book-${Date.now()}`;const e=t.toLowerCase().replace(/[^\w\s-]/g,"").trim().replace(/\s+/g,"-");return e.length>2?`${e}-${Date.now().toString().slice(-4)}`:`book-${Date.now()}`}function Ks(t){if(!t||t===0)return"0 B";const e=1024,n=["B","KB","MB","GB"],r=Math.floor(Math.log(t)/Math.log(e));return parseFloat((t/Math.pow(e,r)).toFixed(1))+" "+n[r]}function Iw(t){if(!t||typeof t!="string")return"";const e=t.trim(),n=e.match(/\/file\/d\/([a-zA-Z0-9_-]+)/);if(n&&n[1])return`https://drive.google.com/uc?export=download&id=${n[1]}`;const r=e.match(/[?&]id=([a-zA-Z0-9_-]+)/);return e.includes("drive.google.com")&&r&&r[1]?`https://drive.google.com/uc?export=download&id=${r[1]}`:e}const Sw=["আত্ম উন্নয়নমূলক বাংলা বই","ধনসম্পদ ও আর্থিক স্বাধীনতা","অভ্যাস গঠন ও প্রোডাক্টিভিটি","মাইন্ডসেট ও মানব মনস্তত্ত্ব","যোগাযোগ ও ব্যক্তিত্ব বিকাশ","ক্যারিয়ার, ব্যবসা ও নেতৃত্ব","জীবনদর্শন ও আত্মিক শান্তি","পারিবারিক সম্পর্ক ও প্যারেন্টিং","অনুপ্রেরণামূলক জীবনী ও সাহিত্য"],o_="আত্ম উন্নয়নমূলক বাংলা বই";function jk({value:t,onChange:e,label:n="Category (ক্যাটাগরি)"}){const r=t&&Sw.includes(t)?t:o_;return m.jsxs("div",{children:[m.jsxs("label",{className:"input-label",style:{display:"flex",alignItems:"center",gap:"0.35rem"},children:[m.jsx(_A,{size:13,color:"#818cf8"}),m.jsx("span",{children:n})]}),m.jsx("select",{className:"input-field",value:r,onChange:i=>e(i.target.value),style:{cursor:"pointer"},children:Sw.map(i=>m.jsx("option",{value:i,children:i},i))})]})}function wV({onProceedToReview:t,onParsedBook:e,onShowToast:n}){const[r,i]=ne.useState(null),[s,o]=ne.useState(""),[a,u]=ne.useState(null),[c,h]=ne.useState(""),[f,g]=ne.useState(null),[v,I]=ne.useState(""),[N,D]=ne.useState(null),[C,w]=ne.useState(null),[R,M]=ne.useState(o_),[z,U]=ne.useState("Bangla"),[E,y]=ne.useState(""),[T,x]=ne.useState(!1),b=ne.useRef(null),k=ne.useRef(null),S=ne.useRef(null),ue=ne.useRef(null),Se=F=>{!F||F.length===0||(Array.from(F).forEach(W=>{const K=W.name.toLowerCase();if(K.endsWith(".pdf"))g(W);else if(K.match(/\.(jpg|jpeg|png|webp)$/))D(W),w(URL.createObjectURL(W));else if(K.endsWith(".md")||K.endsWith(".markdown")||K.endsWith(".txt")){const Z=new FileReader;Z.onload=Y=>{const oe=Y.target.result;K.includes("summary")||!r?(i(W),o(oe)):(u(W),h(oe))},Z.readAsText(W)}}),n({type:"info",title:"Files Processed",message:`Attached ${F.length} file(s). Review slots below.`}))},Je=F=>{if(!F)return;i(F);const W=new FileReader;W.onload=K=>o(K.target.result),W.readAsText(F)},Rt=F=>{if(!F)return;u(F);const W=new FileReader;W.onload=K=>h(K.target.result),W.readAsText(F)},H=F=>{if(F){if(!F.name.toLowerCase().endsWith(".pdf")){n({type:"error",title:"Invalid File",message:"Please choose a .pdf document."});return}g(F)}},re=F=>{F&&(D(F),w(URL.createObjectURL(F)))},P=()=>{const F=`# ধনী বাবা গরীব বাবা
*(বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ)*

**মূল লেখক:** রবার্ট টি. কিওসাকি  
**অনুবাদক ও সংকলক:** মোঃ আবির আহমেদ  

**আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা**

---

## ভূমিকা ও সারসংক্ষেপ
রবার্ট কিওসাকির এই বিখ্যাত বইটি দুই বাবার আর্থিক দৃষ্টিভঙ্গির মাধ্যমে ধনী ও দরিদ্র মানসিকতার মৌলিক পার্থক্য তুলে ধরে।
- ধনী বাবা শিখিয়েছেন: অর্থকে নিজের জন্য কাজে লাগাও।
- গরীব বাবা শিখিয়েছেন: একটি নিরাপদ চাকরির জন্য কঠোর পরিশ্রম করো।

পুঁজি বিনিযোগ, সম্পদ বৃদ্ধি ও অর্থনৈতিক সচেতনতার জন্য এটি একটি আন্তর্জাতিক কালজয়ী ক্লাসিক।`,W=`# ধনী বাবা গরীব বাবা (সম্পূর্ণ বই)
**লেখক:** রবার্ট টি. কিওসাকি

[এখানে সম্পূর্ণ বইয়ের বিস্তারিত বাংলা অনুবাদ সংকলিত হয়েছে...]`,K=new Blob([F],{type:"text/markdown"}),Z=new Blob([W],{type:"text/markdown"}),Y=new Blob(["%PDF-1.4 sample pdf placeholder"],{type:"application/pdf"});i(new File([K],"Rich_Dad_Poor_Dad_Summary.md",{type:"text/markdown"})),o(F),u(new File([Z],"Rich_Dad_Poor_Dad_Full_Book.md",{type:"text/markdown"})),h(W),g(new File([Y],"Rich_Dad_Poor_Dad_Bangla_Full.pdf",{type:"application/pdf"})),n({type:"info",title:"Sample Files Loaded",message:"Attached sample Summary.md, Full Book.md, and PDF."})},A=()=>{if(!r&&!a&&!f&&!v.trim()){n({type:"error",title:"Missing Files or Link",message:"Please upload at least a Summary .md, Full Book .md, or provide a PDF file/Drive link."});return}const F=s||c||"",W=(r==null?void 0:r.name)||(a==null?void 0:a.name)||(f==null?void 0:f.name)||(v?"Book_From_Drive.pdf":""),K=_V(F,W),Z=t||e;Z&&Z({...K,summaryFile:r,summaryText:s,fullBookFile:a,fullBookText:c,pdfFile:f,pdfDriveUrl:v.trim(),coverFile:N,coverPreview:C,category:R,language:z,audioUrl:E})},$=r||a||f||v.trim();return m.jsxs("div",{style:{maxWidth:960,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.75rem"},children:[m.jsx("div",{className:"glass-panel",style:{padding:"2rem",position:"relative",overflow:"hidden"},children:m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"flex-start",flexWrap:"wrap",gap:"1rem"},children:[m.jsxs("div",{children:[m.jsxs("span",{className:"badge badge-indigo",style:{marginBottom:"0.75rem"},children:[m.jsx(vv,{size:12})," Direct Firebase Storage & Firestore Link"]}),m.jsx("h1",{style:{fontSize:"1.85rem",marginBottom:"0.5rem"},children:"Upload Book Files (Summary .md, Full .md, PDF)"}),m.jsxs("p",{style:{color:"var(--text-muted)",fontSize:"0.92rem",maxWidth:620,lineHeight:1.6},children:["Upload your ",m.jsx("strong",{children:"Summary Markdown"}),", ",m.jsx("strong",{children:"Full Book Markdown"}),", and ",m.jsx("strong",{children:"PDF"})," files directly into Firebase Storage. Book metadata and secure download links will be stored in Cloud Firestore (no chapter text in the database)."]})]}),m.jsxs("button",{type:"button",onClick:P,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[m.jsx(vv,{size:16,color:"#a855f7"})," Load Sample Files"]})]})}),m.jsxs("div",{className:`dropzone ${T?"active":""}`,onDragOver:F=>{F.preventDefault(),x(!0)},onDragLeave:()=>x(!1),onDrop:F=>{F.preventDefault(),x(!1),Se(F.dataTransfer.files)},children:[m.jsx("div",{style:{width:60,height:60,borderRadius:16,background:"rgba(99, 102, 241, 0.12)",display:"flex",alignItems:"center",justifyContent:"center",margin:"0 auto 1rem",border:"1px solid rgba(99, 102, 241, 0.3)"},children:m.jsx(Dm,{size:30,color:"#6366f1"})}),m.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.4rem"},children:"Drag & Drop all book files together here"}),m.jsxs("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem",marginBottom:"1.25rem"},children:["Drop your ",m.jsx("strong",{children:".md summary"}),", ",m.jsx("strong",{children:".md full book"}),", ",m.jsx("strong",{children:".pdf"}),", and ",m.jsx("strong",{children:"cover image"}),". The uploader will automatically place each in its dedicated slot."]}),m.jsxs("div",{style:{display:"flex",justifyContent:"center",gap:"0.75rem",flexWrap:"wrap"},children:[m.jsx("span",{style:{fontSize:"0.8rem",color:"#a5b4fc",background:"rgba(99, 102, 241, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(99,102,241,0.2)"},children:"📝 Summary .md"}),m.jsx("span",{style:{fontSize:"0.8rem",color:"#c084fc",background:"rgba(168, 85, 247, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(168,85,247,0.2)"},children:"📖 Full Book .md"}),m.jsx("span",{style:{fontSize:"0.8rem",color:"#f87171",background:"rgba(239, 68, 68, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(239,68,68,0.2)"},children:"📕 PDF Document"}),m.jsx("span",{style:{fontSize:"0.8rem",color:"#34d399",background:"rgba(16, 185, 129, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(16,185,129,0.2)"},children:"🖼️ Cover Image"})]})]}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(280px, 1fr))",gap:"1.25rem"},children:[m.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:r?"1px solid rgba(99, 102, 241, 0.5)":"1px solid var(--border-subtle)"},children:[m.jsxs("div",{children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#a5b4fc"},children:[m.jsx(el,{size:18})," 1. Summary Markdown (.md)"]}),r&&m.jsx(Ds,{size:18,color:"#10b981"})]}),m.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Short summary or chapter notes script in markdown format."}),r?m.jsxs("div",{style:{background:"rgba(99, 102, 241, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(99, 102, 241, 0.2)"},children:[m.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:r.name}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:Ks(r.size)})]}):m.jsx("div",{style:{padding:"1rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem"},children:"No summary file selected"})]}),m.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[m.jsx("input",{type:"file",ref:b,accept:".md,.markdown,.txt",style:{display:"none"},onChange:F=>{var W;return Je((W=F.target.files)==null?void 0:W[0])}}),m.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=b.current)==null?void 0:F.click()},children:r?"Change Summary":"Select Summary .md"}),r&&m.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>{i(null),o("")},children:m.jsx(ha,{size:14})})]})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:a?"1px solid rgba(168, 85, 247, 0.5)":"1px solid var(--border-subtle)"},children:[m.jsxs("div",{children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#c084fc"},children:[m.jsx(no,{size:18})," 2. Full Book Markdown (.md)"]}),a&&m.jsx(Ds,{size:18,color:"#10b981"})]}),m.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Optional complete book manuscript or full translation in markdown."}),a?m.jsxs("div",{style:{background:"rgba(168, 85, 247, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(168, 85, 247, 0.2)"},children:[m.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:a.name}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:Ks(a.size)})]}):m.jsx("div",{style:{padding:"1rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem"},children:"No full book file selected"})]}),m.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[m.jsx("input",{type:"file",ref:k,accept:".md,.markdown,.txt",style:{display:"none"},onChange:F=>{var W;return Rt((W=F.target.files)==null?void 0:W[0])}}),m.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=k.current)==null?void 0:F.click()},children:a?"Change Full Book":"Select Full .md"}),a&&m.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>{u(null),h("")},children:m.jsx(ha,{size:14})})]})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:f||v?"1px solid rgba(239, 68, 68, 0.5)":"1px solid var(--border-subtle)"},children:[m.jsxs("div",{children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#f87171"},children:[m.jsx(Om,{size:18})," 3. PDF Book Document (.pdf or Drive Link)"]}),(f||v)&&m.jsx(Ds,{size:18,color:"#10b981"})]}),m.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Upload local PDF or paste a Google Drive / Web PDF link."}),f?m.jsxs("div",{style:{background:"rgba(239, 68, 68, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(239, 68, 68, 0.2)",marginBottom:"0.75rem"},children:[m.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:f.name}),m.jsxs("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:[Ks(f.size)," (Local file ready to upload)"]})]}):v?m.jsxs("div",{style:{background:"rgba(16, 185, 129, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(16, 185, 129, 0.25)",marginBottom:"0.75rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.4rem",fontWeight:600,fontSize:"0.82rem",color:"#34d399"},children:[m.jsx(Bu,{size:14})," PDF Drive Link Added"]}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:3,wordBreak:"break-all"},children:v})]}):m.jsx("div",{style:{padding:"0.75rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem",marginBottom:"0.75rem"},children:"No PDF file or Drive link provided"}),m.jsxs("div",{style:{marginTop:"0.5rem"},children:[m.jsxs("label",{style:{display:"flex",alignItems:"center",gap:"0.35rem",fontSize:"0.75rem",fontWeight:600,color:"var(--text-muted)",marginBottom:"0.35rem"},children:[m.jsx(Bu,{size:13,color:"#f87171"})," Google Drive or PDF Link:"]}),m.jsxs("div",{style:{display:"flex",gap:"0.35rem"},children:[m.jsx("input",{type:"url",className:"input-field",style:{fontSize:"0.8rem",padding:"0.45rem 0.65rem"},placeholder:"https://drive.google.com/file/d/...",value:v,onChange:F=>I(F.target.value)}),v&&m.jsx("button",{type:"button",className:"btn-secondary",style:{padding:"0.45rem 0.65rem",color:"#ef4444"},onClick:()=>I(""),title:"Clear link",children:m.jsx(ha,{size:13})})]})]})]}),m.jsxs("div",{style:{display:"flex",gap:"0.5rem",marginTop:"0.5rem"},children:[m.jsx("input",{type:"file",ref:S,accept:".pdf",style:{display:"none"},onChange:F=>{var W;return H((W=F.target.files)==null?void 0:W[0])}}),m.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=S.current)==null?void 0:F.click()},children:f?"Change File":"Or Pick File (.pdf)"}),f&&m.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>g(null),children:m.jsx(ha,{size:14})})]})]})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1.75rem"},children:[m.jsxs("h4",{style:{fontSize:"1.05rem",marginBottom:"1.25rem",display:"flex",alignItems:"center",gap:"0.5rem"},children:[m.jsx($T,{size:18,color:"#818cf8"})," Book Settings, Cover & Audio Stream"]}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(240px, 1fr))",gap:"1.25rem"},children:[m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Language"}),m.jsxs("select",{className:"input-field",value:z,onChange:F=>U(F.target.value),children:[m.jsx("option",{value:"Bangla",children:"বাংলা (Bangla)"}),m.jsx("option",{value:"English",children:"English"}),m.jsx("option",{value:"Hindi",children:"Hindi"}),m.jsx("option",{value:"Other",children:"Other"})]})]}),m.jsx(jk,{value:R,onChange:M}),m.jsxs("div",{style:{gridColumn:"1 / -1"},children:[m.jsx("label",{className:"input-label",children:"Audio Stream / MP3 URL (Optional)"}),m.jsx("input",{type:"url",className:"input-field",placeholder:"https://domain.com/audiobook.mp3",value:E,onChange:F=>y(F.target.value)})]}),m.jsxs("div",{children:[m.jsxs("label",{className:"input-label",style:{display:"flex",alignItems:"center",gap:"0.4rem"},children:[m.jsx(Bu,{size:14,color:"#f87171"})," Google Drive / PDF Download URL"]}),m.jsx("input",{type:"url",className:"input-field",placeholder:"https://drive.google.com/file/d/...",value:v,onChange:F=>I(F.target.value)})]}),m.jsxs("div",{style:{gridColumn:"1 / -1"},children:[m.jsx("label",{className:"input-label",children:"Book Cover Image (Optional)"}),m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1.25rem",flexWrap:"wrap"},children:[m.jsx("input",{type:"file",ref:ue,accept:"image/*",style:{display:"none"},onChange:F=>{var W;return re((W=F.target.files)==null?void 0:W[0])}}),m.jsxs("button",{type:"button",className:"btn-secondary",onClick:()=>{var F;return(F=ue.current)==null?void 0:F.click()},children:[m.jsx(hA,{size:16})," Choose Cover Image"]}),C&&m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx("img",{src:C,alt:"Cover Preview",style:{width:44,height:58,objectFit:"cover",borderRadius:6,border:"1px solid var(--border-accent)"}}),m.jsxs("span",{style:{fontSize:"0.85rem",color:"#10b981"},children:[m.jsx(Ds,{size:14,style:{display:"inline",verticalAlign:"middle",marginRight:4}}),N==null?void 0:N.name]})]})]})]})]})]}),m.jsx("div",{style:{display:"flex",justifyContent:"flex-end"},children:m.jsxs("button",{type:"button",onClick:A,disabled:!$,className:"btn-primary",style:{padding:"0.85rem 2rem",fontSize:"1rem"},children:[m.jsx("span",{children:"Continue to Review & Upload"}),m.jsx(nA,{size:18})]})})]})}function a_(){return{async:!1,breaks:!1,extensions:null,gfm:!0,hooks:null,pedantic:!1,renderer:null,silent:!1,tokenizer:null,walkTokens:null}}let ls=a_();function zk(t){ls=t}const Bk=/[&<>"']/,EV=new RegExp(Bk.source,"g"),$k=/[<>"']|&(?!(#\d{1,7}|#[Xx][a-fA-F0-9]{1,6}|\w+);)/,TV=new RegExp($k.source,"g"),IV={"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"},kw=t=>IV[t];function on(t,e){if(e){if(Bk.test(t))return t.replace(EV,kw)}else if($k.test(t))return t.replace(TV,kw);return t}const SV=/(^|[^\[])\^/g;function Ne(t,e){let n=typeof t=="string"?t:t.source;e=e||"";const r={replace:(i,s)=>{let o=typeof s=="string"?s:s.source;return o=o.replace(SV,"$1"),n=n.replace(i,o),r},getRegex:()=>new RegExp(n,e)};return r}function Cw(t){try{t=encodeURI(t).replace(/%25/g,"%")}catch{return null}return t}const Ma={exec:()=>null};function Rw(t,e){const n=t.replace(/\|/g,(s,o,a)=>{let u=!1,c=o;for(;--c>=0&&a[c]==="\\";)u=!u;return u?"|":" |"}),r=n.split(/ \|/);let i=0;if(r[0].trim()||r.shift(),r.length>0&&!r[r.length-1].trim()&&r.pop(),e)if(r.length>e)r.splice(e);else for(;r.length<e;)r.push("");for(;i<r.length;i++)r[i]=r[i].trim().replace(/\\\|/g,"|");return r}function sa(t,e,n){const r=t.length;if(r===0)return"";let i=0;for(;i<r&&t.charAt(r-i-1)===e;)i++;return t.slice(0,r-i)}function kV(t,e){if(t.indexOf(e[1])===-1)return-1;let n=0;for(let r=0;r<t.length;r++)if(t[r]==="\\")r++;else if(t[r]===e[0])n++;else if(t[r]===e[1]&&(n--,n<0))return r;return-1}function xw(t,e,n,r){const i=e.href,s=e.title?on(e.title):null,o=t[1].replace(/\\([\[\]])/g,"$1");if(t[0].charAt(0)!=="!"){r.state.inLink=!0;const a={type:"link",raw:n,href:i,title:s,text:o,tokens:r.inlineTokens(o)};return r.state.inLink=!1,a}return{type:"image",raw:n,href:i,title:s,text:on(o)}}function CV(t,e){const n=t.match(/^(\s+)(?:```)/);if(n===null)return e;const r=n[1];return e.split(`
`).map(i=>{const s=i.match(/^\s+/);if(s===null)return i;const[o]=s;return o.length>=r.length?i.slice(r.length):i}).join(`
`)}class Yc{constructor(e){Oe(this,"options");Oe(this,"rules");Oe(this,"lexer");this.options=e||ls}space(e){const n=this.rules.block.newline.exec(e);if(n&&n[0].length>0)return{type:"space",raw:n[0]}}code(e){const n=this.rules.block.code.exec(e);if(n){const r=n[0].replace(/^(?: {1,4}| {0,3}\t)/gm,"");return{type:"code",raw:n[0],codeBlockStyle:"indented",text:this.options.pedantic?r:sa(r,`
`)}}}fences(e){const n=this.rules.block.fences.exec(e);if(n){const r=n[0],i=CV(r,n[3]||"");return{type:"code",raw:r,lang:n[2]?n[2].trim().replace(this.rules.inline.anyPunctuation,"$1"):n[2],text:i}}}heading(e){const n=this.rules.block.heading.exec(e);if(n){let r=n[2].trim();if(/#$/.test(r)){const i=sa(r,"#");(this.options.pedantic||!i||/ $/.test(i))&&(r=i.trim())}return{type:"heading",raw:n[0],depth:n[1].length,text:r,tokens:this.lexer.inline(r)}}}hr(e){const n=this.rules.block.hr.exec(e);if(n)return{type:"hr",raw:sa(n[0],`
`)}}blockquote(e){const n=this.rules.block.blockquote.exec(e);if(n){let r=sa(n[0],`
`).split(`
`),i="",s="";const o=[];for(;r.length>0;){let a=!1;const u=[];let c;for(c=0;c<r.length;c++)if(/^ {0,3}>/.test(r[c]))u.push(r[c]),a=!0;else if(!a)u.push(r[c]);else break;r=r.slice(c);const h=u.join(`
`),f=h.replace(/\n {0,3}((?:=+|-+) *)(?=\n|$)/g,`
    $1`).replace(/^ {0,3}>[ \t]?/gm,"");i=i?`${i}
${h}`:h,s=s?`${s}
${f}`:f;const g=this.lexer.state.top;if(this.lexer.state.top=!0,this.lexer.blockTokens(f,o,!0),this.lexer.state.top=g,r.length===0)break;const v=o[o.length-1];if((v==null?void 0:v.type)==="code")break;if((v==null?void 0:v.type)==="blockquote"){const I=v,N=I.raw+`
`+r.join(`
`),D=this.blockquote(N);o[o.length-1]=D,i=i.substring(0,i.length-I.raw.length)+D.raw,s=s.substring(0,s.length-I.text.length)+D.text;break}else if((v==null?void 0:v.type)==="list"){const I=v,N=I.raw+`
`+r.join(`
`),D=this.list(N);o[o.length-1]=D,i=i.substring(0,i.length-v.raw.length)+D.raw,s=s.substring(0,s.length-I.raw.length)+D.raw,r=N.substring(o[o.length-1].raw.length).split(`
`);continue}}return{type:"blockquote",raw:i,tokens:o,text:s}}}list(e){let n=this.rules.block.list.exec(e);if(n){let r=n[1].trim();const i=r.length>1,s={type:"list",raw:"",ordered:i,start:i?+r.slice(0,-1):"",loose:!1,items:[]};r=i?`\\d{1,9}\\${r.slice(-1)}`:`\\${r}`,this.options.pedantic&&(r=i?r:"[*+-]");const o=new RegExp(`^( {0,3}${r})((?:[	 ][^\\n]*)?(?:\\n|$))`);let a=!1;for(;e;){let u=!1,c="",h="";if(!(n=o.exec(e))||this.rules.block.hr.test(e))break;c=n[0],e=e.substring(c.length);let f=n[2].split(`
`,1)[0].replace(/^\t+/,C=>" ".repeat(3*C.length)),g=e.split(`
`,1)[0],v=!f.trim(),I=0;if(this.options.pedantic?(I=2,h=f.trimStart()):v?I=n[1].length+1:(I=n[2].search(/[^ ]/),I=I>4?1:I,h=f.slice(I),I+=n[1].length),v&&/^[ \t]*$/.test(g)&&(c+=g+`
`,e=e.substring(g.length+1),u=!0),!u){const C=new RegExp(`^ {0,${Math.min(3,I-1)}}(?:[*+-]|\\d{1,9}[.)])((?:[ 	][^\\n]*)?(?:\\n|$))`),w=new RegExp(`^ {0,${Math.min(3,I-1)}}((?:- *){3,}|(?:_ *){3,}|(?:\\* *){3,})(?:\\n+|$)`),R=new RegExp(`^ {0,${Math.min(3,I-1)}}(?:\`\`\`|~~~)`),M=new RegExp(`^ {0,${Math.min(3,I-1)}}#`),z=new RegExp(`^ {0,${Math.min(3,I-1)}}<(?:[a-z].*>|!--)`,"i");for(;e;){const U=e.split(`
`,1)[0];let E;if(g=U,this.options.pedantic?(g=g.replace(/^ {1,4}(?=( {4})*[^ ])/g,"  "),E=g):E=g.replace(/\t/g,"    "),R.test(g)||M.test(g)||z.test(g)||C.test(g)||w.test(g))break;if(E.search(/[^ ]/)>=I||!g.trim())h+=`
`+E.slice(I);else{if(v||f.replace(/\t/g,"    ").search(/[^ ]/)>=4||R.test(f)||M.test(f)||w.test(f))break;h+=`
`+g}!v&&!g.trim()&&(v=!0),c+=U+`
`,e=e.substring(U.length+1),f=E.slice(I)}}s.loose||(a?s.loose=!0:/\n[ \t]*\n[ \t]*$/.test(c)&&(a=!0));let N=null,D;this.options.gfm&&(N=/^\[[ xX]\] /.exec(h),N&&(D=N[0]!=="[ ] ",h=h.replace(/^\[[ xX]\] +/,""))),s.items.push({type:"list_item",raw:c,task:!!N,checked:D,loose:!1,text:h,tokens:[]}),s.raw+=c}s.items[s.items.length-1].raw=s.items[s.items.length-1].raw.trimEnd(),s.items[s.items.length-1].text=s.items[s.items.length-1].text.trimEnd(),s.raw=s.raw.trimEnd();for(let u=0;u<s.items.length;u++)if(this.lexer.state.top=!1,s.items[u].tokens=this.lexer.blockTokens(s.items[u].text,[]),!s.loose){const c=s.items[u].tokens.filter(f=>f.type==="space"),h=c.length>0&&c.some(f=>/\n.*\n/.test(f.raw));s.loose=h}if(s.loose)for(let u=0;u<s.items.length;u++)s.items[u].loose=!0;return s}}html(e){const n=this.rules.block.html.exec(e);if(n)return{type:"html",block:!0,raw:n[0],pre:n[1]==="pre"||n[1]==="script"||n[1]==="style",text:n[0]}}def(e){const n=this.rules.block.def.exec(e);if(n){const r=n[1].toLowerCase().replace(/\s+/g," "),i=n[2]?n[2].replace(/^<(.*)>$/,"$1").replace(this.rules.inline.anyPunctuation,"$1"):"",s=n[3]?n[3].substring(1,n[3].length-1).replace(this.rules.inline.anyPunctuation,"$1"):n[3];return{type:"def",tag:r,raw:n[0],href:i,title:s}}}table(e){const n=this.rules.block.table.exec(e);if(!n||!/[:|]/.test(n[2]))return;const r=Rw(n[1]),i=n[2].replace(/^\||\| *$/g,"").split("|"),s=n[3]&&n[3].trim()?n[3].replace(/\n[ \t]*$/,"").split(`
`):[],o={type:"table",raw:n[0],header:[],align:[],rows:[]};if(r.length===i.length){for(const a of i)/^ *-+: *$/.test(a)?o.align.push("right"):/^ *:-+: *$/.test(a)?o.align.push("center"):/^ *:-+ *$/.test(a)?o.align.push("left"):o.align.push(null);for(let a=0;a<r.length;a++)o.header.push({text:r[a],tokens:this.lexer.inline(r[a]),header:!0,align:o.align[a]});for(const a of s)o.rows.push(Rw(a,o.header.length).map((u,c)=>({text:u,tokens:this.lexer.inline(u),header:!1,align:o.align[c]})));return o}}lheading(e){const n=this.rules.block.lheading.exec(e);if(n)return{type:"heading",raw:n[0],depth:n[2].charAt(0)==="="?1:2,text:n[1],tokens:this.lexer.inline(n[1])}}paragraph(e){const n=this.rules.block.paragraph.exec(e);if(n){const r=n[1].charAt(n[1].length-1)===`
`?n[1].slice(0,-1):n[1];return{type:"paragraph",raw:n[0],text:r,tokens:this.lexer.inline(r)}}}text(e){const n=this.rules.block.text.exec(e);if(n)return{type:"text",raw:n[0],text:n[0],tokens:this.lexer.inline(n[0])}}escape(e){const n=this.rules.inline.escape.exec(e);if(n)return{type:"escape",raw:n[0],text:on(n[1])}}tag(e){const n=this.rules.inline.tag.exec(e);if(n)return!this.lexer.state.inLink&&/^<a /i.test(n[0])?this.lexer.state.inLink=!0:this.lexer.state.inLink&&/^<\/a>/i.test(n[0])&&(this.lexer.state.inLink=!1),!this.lexer.state.inRawBlock&&/^<(pre|code|kbd|script)(\s|>)/i.test(n[0])?this.lexer.state.inRawBlock=!0:this.lexer.state.inRawBlock&&/^<\/(pre|code|kbd|script)(\s|>)/i.test(n[0])&&(this.lexer.state.inRawBlock=!1),{type:"html",raw:n[0],inLink:this.lexer.state.inLink,inRawBlock:this.lexer.state.inRawBlock,block:!1,text:n[0]}}link(e){const n=this.rules.inline.link.exec(e);if(n){const r=n[2].trim();if(!this.options.pedantic&&/^</.test(r)){if(!/>$/.test(r))return;const o=sa(r.slice(0,-1),"\\");if((r.length-o.length)%2===0)return}else{const o=kV(n[2],"()");if(o>-1){const u=(n[0].indexOf("!")===0?5:4)+n[1].length+o;n[2]=n[2].substring(0,o),n[0]=n[0].substring(0,u).trim(),n[3]=""}}let i=n[2],s="";if(this.options.pedantic){const o=/^([^'"]*[^\s])\s+(['"])(.*)\2/.exec(i);o&&(i=o[1],s=o[3])}else s=n[3]?n[3].slice(1,-1):"";return i=i.trim(),/^</.test(i)&&(this.options.pedantic&&!/>$/.test(r)?i=i.slice(1):i=i.slice(1,-1)),xw(n,{href:i&&i.replace(this.rules.inline.anyPunctuation,"$1"),title:s&&s.replace(this.rules.inline.anyPunctuation,"$1")},n[0],this.lexer)}}reflink(e,n){let r;if((r=this.rules.inline.reflink.exec(e))||(r=this.rules.inline.nolink.exec(e))){const i=(r[2]||r[1]).replace(/\s+/g," "),s=n[i.toLowerCase()];if(!s){const o=r[0].charAt(0);return{type:"text",raw:o,text:o}}return xw(r,s,r[0],this.lexer)}}emStrong(e,n,r=""){let i=this.rules.inline.emStrongLDelim.exec(e);if(!i||i[3]&&r.match(/[\p{L}\p{N}]/u))return;if(!(i[1]||i[2]||"")||!r||this.rules.inline.punctuation.exec(r)){const o=[...i[0]].length-1;let a,u,c=o,h=0;const f=i[0][0]==="*"?this.rules.inline.emStrongRDelimAst:this.rules.inline.emStrongRDelimUnd;for(f.lastIndex=0,n=n.slice(-1*e.length+o);(i=f.exec(n))!=null;){if(a=i[1]||i[2]||i[3]||i[4]||i[5]||i[6],!a)continue;if(u=[...a].length,i[3]||i[4]){c+=u;continue}else if((i[5]||i[6])&&o%3&&!((o+u)%3)){h+=u;continue}if(c-=u,c>0)continue;u=Math.min(u,u+c+h);const g=[...i[0]][0].length,v=e.slice(0,o+i.index+g+u);if(Math.min(o,u)%2){const N=v.slice(1,-1);return{type:"em",raw:v,text:N,tokens:this.lexer.inlineTokens(N)}}const I=v.slice(2,-2);return{type:"strong",raw:v,text:I,tokens:this.lexer.inlineTokens(I)}}}}codespan(e){const n=this.rules.inline.code.exec(e);if(n){let r=n[2].replace(/\n/g," ");const i=/[^ ]/.test(r),s=/^ /.test(r)&&/ $/.test(r);return i&&s&&(r=r.substring(1,r.length-1)),r=on(r,!0),{type:"codespan",raw:n[0],text:r}}}br(e){const n=this.rules.inline.br.exec(e);if(n)return{type:"br",raw:n[0]}}del(e){const n=this.rules.inline.del.exec(e);if(n)return{type:"del",raw:n[0],text:n[2],tokens:this.lexer.inlineTokens(n[2])}}autolink(e){const n=this.rules.inline.autolink.exec(e);if(n){let r,i;return n[2]==="@"?(r=on(n[1]),i="mailto:"+r):(r=on(n[1]),i=r),{type:"link",raw:n[0],text:r,href:i,tokens:[{type:"text",raw:r,text:r}]}}}url(e){var r;let n;if(n=this.rules.inline.url.exec(e)){let i,s;if(n[2]==="@")i=on(n[0]),s="mailto:"+i;else{let o;do o=n[0],n[0]=((r=this.rules.inline._backpedal.exec(n[0]))==null?void 0:r[0])??"";while(o!==n[0]);i=on(n[0]),n[1]==="www."?s="http://"+n[0]:s=n[0]}return{type:"link",raw:n[0],text:i,href:s,tokens:[{type:"text",raw:i,text:i}]}}}inlineText(e){const n=this.rules.inline.text.exec(e);if(n){let r;return this.lexer.state.inRawBlock?r=n[0]:r=on(n[0]),{type:"text",raw:n[0],text:r}}}}const RV=/^(?:[ \t]*(?:\n|$))+/,xV=/^((?: {4}| {0,3}\t)[^\n]+(?:\n(?:[ \t]*(?:\n|$))*)?)+/,AV=/^ {0,3}(`{3,}(?=[^`\n]*(?:\n|$))|~{3,})([^\n]*)(?:\n|$)(?:|([\s\S]*?)(?:\n|$))(?: {0,3}\1[~`]* *(?=\n|$)|$)/,Ll=/^ {0,3}((?:-[\t ]*){3,}|(?:_[ \t]*){3,}|(?:\*[ \t]*){3,})(?:\n+|$)/,bV=/^ {0,3}(#{1,6})(?=\s|$)(.*)(?:\n+|$)/,Wk=/(?:[*+-]|\d{1,9}[.)])/,qk=Ne(/^(?!bull |blockCode|fences|blockquote|heading|html)((?:.|\n(?!\s*?\n|bull |blockCode|fences|blockquote|heading|html))+?)\n {0,3}(=+|-+) *(?:\n+|$)/).replace(/bull/g,Wk).replace(/blockCode/g,/(?: {4}| {0,3}\t)/).replace(/fences/g,/ {0,3}(?:`{3,}|~{3,})/).replace(/blockquote/g,/ {0,3}>/).replace(/heading/g,/ {0,3}#{1,6}/).replace(/html/g,/ {0,3}<[^\n>]+>\n/).getRegex(),l_=/^([^\n]+(?:\n(?!hr|heading|lheading|blockquote|fences|list|html|table| +\n)[^\n]+)*)/,PV=/^[^\n]+/,u_=/(?!\s*\])(?:\\.|[^\[\]\\])+/,NV=Ne(/^ {0,3}\[(label)\]: *(?:\n[ \t]*)?([^<\s][^\s]*|<.*?>)(?:(?: +(?:\n[ \t]*)?| *\n[ \t]*)(title))? *(?:\n+|$)/).replace("label",u_).replace("title",/(?:"(?:\\"?|[^"\\])*"|'[^'\n]*(?:\n[^'\n]+)*\n?'|\([^()]*\))/).getRegex(),DV=Ne(/^( {0,3}bull)([ \t][^\n]+?)?(?:\n|$)/).replace(/bull/g,Wk).getRegex(),Wh="address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h[1-6]|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|search|section|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul",c_=/<!--(?:-?>|[\s\S]*?(?:-->|$))/,OV=Ne("^ {0,3}(?:<(script|pre|style|textarea)[\\s>][\\s\\S]*?(?:</\\1>[^\\n]*\\n+|$)|comment[^\\n]*(\\n+|$)|<\\?[\\s\\S]*?(?:\\?>\\n*|$)|<![A-Z][\\s\\S]*?(?:>\\n*|$)|<!\\[CDATA\\[[\\s\\S]*?(?:\\]\\]>\\n*|$)|</?(tag)(?: +|\\n|/?>)[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|<(?!script|pre|style|textarea)([a-z][\\w-]*)(?:attribute)*? */?>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|</(?!script|pre|style|textarea)[a-z][\\w-]*\\s*>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$))","i").replace("comment",c_).replace("tag",Wh).replace("attribute",/ +[a-zA-Z:_][\w.:-]*(?: *= *"[^"\n]*"| *= *'[^'\n]*'| *= *[^\s"'=<>`]+)?/).getRegex(),Hk=Ne(l_).replace("hr",Ll).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("|table","").replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Wh).getRegex(),MV=Ne(/^( {0,3}> ?(paragraph|[^\n]*)(?:\n|$))+/).replace("paragraph",Hk).getRegex(),h_={blockquote:MV,code:xV,def:NV,fences:AV,heading:bV,hr:Ll,html:OV,lheading:qk,list:DV,newline:RV,paragraph:Hk,table:Ma,text:PV},Aw=Ne("^ *([^\\n ].*)\\n {0,3}((?:\\| *)?:?-+:? *(?:\\| *:?-+:? *)*(?:\\| *)?)(?:\\n((?:(?! *\\n|hr|heading|blockquote|code|fences|list|html).*(?:\\n|$))*)\\n*|$)").replace("hr",Ll).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("blockquote"," {0,3}>").replace("code","(?: {4}| {0,3}	)[^\\n]").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Wh).getRegex(),LV={...h_,table:Aw,paragraph:Ne(l_).replace("hr",Ll).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("table",Aw).replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Wh).getRegex()},FV={...h_,html:Ne(`^ *(?:comment *(?:\\n|\\s*$)|<(tag)[\\s\\S]+?</\\1> *(?:\\n{2,}|\\s*$)|<tag(?:"[^"]*"|'[^']*'|\\s[^'"/>\\s]*)*?/?> *(?:\\n{2,}|\\s*$))`).replace("comment",c_).replace(/tag/g,"(?!(?:a|em|strong|small|s|cite|q|dfn|abbr|data|time|code|var|samp|kbd|sub|sup|i|b|u|mark|ruby|rt|rp|bdi|bdo|span|br|wbr|ins|del|img)\\b)\\w+(?!:|[^\\w\\s@]*@)\\b").getRegex(),def:/^ *\[([^\]]+)\]: *<?([^\s>]+)>?(?: +(["(][^\n]+[")]))? *(?:\n+|$)/,heading:/^(#{1,6})(.*)(?:\n+|$)/,fences:Ma,lheading:/^(.+?)\n {0,3}(=+|-+) *(?:\n+|$)/,paragraph:Ne(l_).replace("hr",Ll).replace("heading",` *#{1,6} *[^
]`).replace("lheading",qk).replace("|table","").replace("blockquote"," {0,3}>").replace("|fences","").replace("|list","").replace("|html","").replace("|tag","").getRegex()},Gk=/^\\([!"#$%&'()*+,\-./:;<=>?@\[\]\\^_`{|}~])/,VV=/^(`+)([^`]|[^`][\s\S]*?[^`])\1(?!`)/,Kk=/^( {2,}|\\)\n(?!\s*$)/,UV=/^(`+|[^`])(?:(?= {2,}\n)|[\s\S]*?(?:(?=[\\<!\[`*_]|\b_|$)|[^ ](?= {2,}\n)))/,Fl="\\p{P}\\p{S}",jV=Ne(/^((?![*_])[\spunctuation])/,"u").replace(/punctuation/g,Fl).getRegex(),zV=/\[[^[\]]*?\]\((?:\\.|[^\\\(\)]|\((?:\\.|[^\\\(\)])*\))*\)|`[^`]*?`|<[^<>]*?>/g,BV=Ne(/^(?:\*+(?:((?!\*)[punct])|[^\s*]))|^_+(?:((?!_)[punct])|([^\s_]))/,"u").replace(/punct/g,Fl).getRegex(),$V=Ne("^[^_*]*?__[^_*]*?\\*[^_*]*?(?=__)|[^*]+(?=[^*])|(?!\\*)[punct](\\*+)(?=[\\s]|$)|[^punct\\s](\\*+)(?!\\*)(?=[punct\\s]|$)|(?!\\*)[punct\\s](\\*+)(?=[^punct\\s])|[\\s](\\*+)(?!\\*)(?=[punct])|(?!\\*)[punct](\\*+)(?!\\*)(?=[punct])|[^punct\\s](\\*+)(?=[^punct\\s])","gu").replace(/punct/g,Fl).getRegex(),WV=Ne("^[^_*]*?\\*\\*[^_*]*?_[^_*]*?(?=\\*\\*)|[^_]+(?=[^_])|(?!_)[punct](_+)(?=[\\s]|$)|[^punct\\s](_+)(?!_)(?=[punct\\s]|$)|(?!_)[punct\\s](_+)(?=[^punct\\s])|[\\s](_+)(?!_)(?=[punct])|(?!_)[punct](_+)(?!_)(?=[punct])","gu").replace(/punct/g,Fl).getRegex(),qV=Ne(/\\([punct])/,"gu").replace(/punct/g,Fl).getRegex(),HV=Ne(/^<(scheme:[^\s\x00-\x1f<>]*|email)>/).replace("scheme",/[a-zA-Z][a-zA-Z0-9+.-]{1,31}/).replace("email",/[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(@)[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+(?![-_])/).getRegex(),GV=Ne(c_).replace("(?:-->|$)","-->").getRegex(),KV=Ne("^comment|^</[a-zA-Z][\\w:-]*\\s*>|^<[a-zA-Z][\\w-]*(?:attribute)*?\\s*/?>|^<\\?[\\s\\S]*?\\?>|^<![a-zA-Z]+\\s[\\s\\S]*?>|^<!\\[CDATA\\[[\\s\\S]*?\\]\\]>").replace("comment",GV).replace("attribute",/\s+[a-zA-Z:_][\w.:-]*(?:\s*=\s*"[^"]*"|\s*=\s*'[^']*'|\s*=\s*[^\s"'=<>`]+)?/).getRegex(),Xc=/(?:\[(?:\\.|[^\[\]\\])*\]|\\.|`[^`]*`|[^\[\]\\`])*?/,QV=Ne(/^!?\[(label)\]\(\s*(href)(?:\s+(title))?\s*\)/).replace("label",Xc).replace("href",/<(?:\\.|[^\n<>\\])+>|[^\s\x00-\x1f]*/).replace("title",/"(?:\\"?|[^"\\])*"|'(?:\\'?|[^'\\])*'|\((?:\\\)?|[^)\\])*\)/).getRegex(),Qk=Ne(/^!?\[(label)\]\[(ref)\]/).replace("label",Xc).replace("ref",u_).getRegex(),Yk=Ne(/^!?\[(ref)\](?:\[\])?/).replace("ref",u_).getRegex(),YV=Ne("reflink|nolink(?!\\()","g").replace("reflink",Qk).replace("nolink",Yk).getRegex(),d_={_backpedal:Ma,anyPunctuation:qV,autolink:HV,blockSkip:zV,br:Kk,code:VV,del:Ma,emStrongLDelim:BV,emStrongRDelimAst:$V,emStrongRDelimUnd:WV,escape:Gk,link:QV,nolink:Yk,punctuation:jV,reflink:Qk,reflinkSearch:YV,tag:KV,text:UV,url:Ma},XV={...d_,link:Ne(/^!?\[(label)\]\((.*?)\)/).replace("label",Xc).getRegex(),reflink:Ne(/^!?\[(label)\]\s*\[([^\]]*)\]/).replace("label",Xc).getRegex()},Vp={...d_,escape:Ne(Gk).replace("])","~|])").getRegex(),url:Ne(/^((?:ftp|https?):\/\/|www\.)(?:[a-zA-Z0-9\-]+\.?)+[^\s<]*|^email/,"i").replace("email",/[A-Za-z0-9._+-]+(@)[a-zA-Z0-9-_]+(?:\.[a-zA-Z0-9-_]*[a-zA-Z0-9])+(?![-_])/).getRegex(),_backpedal:/(?:[^?!.,:;*_'"~()&]+|\([^)]*\)|&(?![a-zA-Z0-9]+;$)|[?!.,:;*_'"~)]+(?!$))+/,del:/^(~~?)(?=[^\s~])((?:\\.|[^\\])*?(?:\\.|[^\s~\\]))\1(?=[^~]|$)/,text:/^([`~]+|[^`~])(?:(?= {2,}\n)|(?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)|[\s\S]*?(?:(?=[\\<!\[`*~_]|\b_|https?:\/\/|ftp:\/\/|www\.|$)|[^ ](?= {2,}\n)|[^a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-](?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)))/},JV={...Vp,br:Ne(Kk).replace("{2,}","*").getRegex(),text:Ne(Vp.text).replace("\\b_","\\b_| {2,}\\n").replace(/\{2,\}/g,"*").getRegex()},Au={normal:h_,gfm:LV,pedantic:FV},oa={normal:d_,gfm:Vp,breaks:JV,pedantic:XV};class vn{constructor(e){Oe(this,"tokens");Oe(this,"options");Oe(this,"state");Oe(this,"tokenizer");Oe(this,"inlineQueue");this.tokens=[],this.tokens.links=Object.create(null),this.options=e||ls,this.options.tokenizer=this.options.tokenizer||new Yc,this.tokenizer=this.options.tokenizer,this.tokenizer.options=this.options,this.tokenizer.lexer=this,this.inlineQueue=[],this.state={inLink:!1,inRawBlock:!1,top:!0};const n={block:Au.normal,inline:oa.normal};this.options.pedantic?(n.block=Au.pedantic,n.inline=oa.pedantic):this.options.gfm&&(n.block=Au.gfm,this.options.breaks?n.inline=oa.breaks:n.inline=oa.gfm),this.tokenizer.rules=n}static get rules(){return{block:Au,inline:oa}}static lex(e,n){return new vn(n).lex(e)}static lexInline(e,n){return new vn(n).inlineTokens(e)}lex(e){e=e.replace(/\r\n|\r/g,`
`),this.blockTokens(e,this.tokens);for(let n=0;n<this.inlineQueue.length;n++){const r=this.inlineQueue[n];this.inlineTokens(r.src,r.tokens)}return this.inlineQueue=[],this.tokens}blockTokens(e,n=[],r=!1){this.options.pedantic&&(e=e.replace(/\t/g,"    ").replace(/^ +$/gm,""));let i,s,o;for(;e;)if(!(this.options.extensions&&this.options.extensions.block&&this.options.extensions.block.some(a=>(i=a.call({lexer:this},e,n))?(e=e.substring(i.raw.length),n.push(i),!0):!1))){if(i=this.tokenizer.space(e)){e=e.substring(i.raw.length),i.raw.length===1&&n.length>0?n[n.length-1].raw+=`
`:n.push(i);continue}if(i=this.tokenizer.code(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(i=this.tokenizer.fences(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.heading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.hr(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.blockquote(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.list(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.html(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.def(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.raw,this.inlineQueue[this.inlineQueue.length-1].src=s.text):this.tokens.links[i.tag]||(this.tokens.links[i.tag]={href:i.href,title:i.title});continue}if(i=this.tokenizer.table(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.lheading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(o=e,this.options.extensions&&this.options.extensions.startBlock){let a=1/0;const u=e.slice(1);let c;this.options.extensions.startBlock.forEach(h=>{c=h.call({lexer:this},u),typeof c=="number"&&c>=0&&(a=Math.min(a,c))}),a<1/0&&a>=0&&(o=e.substring(0,a+1))}if(this.state.top&&(i=this.tokenizer.paragraph(o))){s=n[n.length-1],r&&(s==null?void 0:s.type)==="paragraph"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i),r=o.length!==e.length,e=e.substring(i.raw.length);continue}if(i=this.tokenizer.text(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&s.type==="text"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(e){const a="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(a);break}else throw new Error(a)}}return this.state.top=!0,n}inline(e,n=[]){return this.inlineQueue.push({src:e,tokens:n}),n}inlineTokens(e,n=[]){let r,i,s,o=e,a,u,c;if(this.tokens.links){const h=Object.keys(this.tokens.links);if(h.length>0)for(;(a=this.tokenizer.rules.inline.reflinkSearch.exec(o))!=null;)h.includes(a[0].slice(a[0].lastIndexOf("[")+1,-1))&&(o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.reflinkSearch.lastIndex))}for(;(a=this.tokenizer.rules.inline.blockSkip.exec(o))!=null;)o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.blockSkip.lastIndex);for(;(a=this.tokenizer.rules.inline.anyPunctuation.exec(o))!=null;)o=o.slice(0,a.index)+"++"+o.slice(this.tokenizer.rules.inline.anyPunctuation.lastIndex);for(;e;)if(u||(c=""),u=!1,!(this.options.extensions&&this.options.extensions.inline&&this.options.extensions.inline.some(h=>(r=h.call({lexer:this},e,n))?(e=e.substring(r.raw.length),n.push(r),!0):!1))){if(r=this.tokenizer.escape(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.tag(e)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.link(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.reflink(e,this.tokens.links)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.emStrong(e,o,c)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.codespan(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.br(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.del(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.autolink(e)){e=e.substring(r.raw.length),n.push(r);continue}if(!this.state.inLink&&(r=this.tokenizer.url(e))){e=e.substring(r.raw.length),n.push(r);continue}if(s=e,this.options.extensions&&this.options.extensions.startInline){let h=1/0;const f=e.slice(1);let g;this.options.extensions.startInline.forEach(v=>{g=v.call({lexer:this},f),typeof g=="number"&&g>=0&&(h=Math.min(h,g))}),h<1/0&&h>=0&&(s=e.substring(0,h+1))}if(r=this.tokenizer.inlineText(s)){e=e.substring(r.raw.length),r.raw.slice(-1)!=="_"&&(c=r.raw.slice(-1)),u=!0,i=n[n.length-1],i&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(e){const h="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(h);break}else throw new Error(h)}}return n}}class Jc{constructor(e){Oe(this,"options");Oe(this,"parser");this.options=e||ls}space(e){return""}code({text:e,lang:n,escaped:r}){var o;const i=(o=(n||"").match(/^\S*/))==null?void 0:o[0],s=e.replace(/\n$/,"")+`
`;return i?'<pre><code class="language-'+on(i)+'">'+(r?s:on(s,!0))+`</code></pre>
`:"<pre><code>"+(r?s:on(s,!0))+`</code></pre>
`}blockquote({tokens:e}){return`<blockquote>
${this.parser.parse(e)}</blockquote>
`}html({text:e}){return e}heading({tokens:e,depth:n}){return`<h${n}>${this.parser.parseInline(e)}</h${n}>
`}hr(e){return`<hr>
`}list(e){const n=e.ordered,r=e.start;let i="";for(let a=0;a<e.items.length;a++){const u=e.items[a];i+=this.listitem(u)}const s=n?"ol":"ul",o=n&&r!==1?' start="'+r+'"':"";return"<"+s+o+`>
`+i+"</"+s+`>
`}listitem(e){let n="";if(e.task){const r=this.checkbox({checked:!!e.checked});e.loose?e.tokens.length>0&&e.tokens[0].type==="paragraph"?(e.tokens[0].text=r+" "+e.tokens[0].text,e.tokens[0].tokens&&e.tokens[0].tokens.length>0&&e.tokens[0].tokens[0].type==="text"&&(e.tokens[0].tokens[0].text=r+" "+e.tokens[0].tokens[0].text)):e.tokens.unshift({type:"text",raw:r+" ",text:r+" "}):n+=r+" "}return n+=this.parser.parse(e.tokens,!!e.loose),`<li>${n}</li>
`}checkbox({checked:e}){return"<input "+(e?'checked="" ':"")+'disabled="" type="checkbox">'}paragraph({tokens:e}){return`<p>${this.parser.parseInline(e)}</p>
`}table(e){let n="",r="";for(let s=0;s<e.header.length;s++)r+=this.tablecell(e.header[s]);n+=this.tablerow({text:r});let i="";for(let s=0;s<e.rows.length;s++){const o=e.rows[s];r="";for(let a=0;a<o.length;a++)r+=this.tablecell(o[a]);i+=this.tablerow({text:r})}return i&&(i=`<tbody>${i}</tbody>`),`<table>
<thead>
`+n+`</thead>
`+i+`</table>
`}tablerow({text:e}){return`<tr>
${e}</tr>
`}tablecell(e){const n=this.parser.parseInline(e.tokens),r=e.header?"th":"td";return(e.align?`<${r} align="${e.align}">`:`<${r}>`)+n+`</${r}>
`}strong({tokens:e}){return`<strong>${this.parser.parseInline(e)}</strong>`}em({tokens:e}){return`<em>${this.parser.parseInline(e)}</em>`}codespan({text:e}){return`<code>${e}</code>`}br(e){return"<br>"}del({tokens:e}){return`<del>${this.parser.parseInline(e)}</del>`}link({href:e,title:n,tokens:r}){const i=this.parser.parseInline(r),s=Cw(e);if(s===null)return i;e=s;let o='<a href="'+e+'"';return n&&(o+=' title="'+n+'"'),o+=">"+i+"</a>",o}image({href:e,title:n,text:r}){const i=Cw(e);if(i===null)return r;e=i;let s=`<img src="${e}" alt="${r}"`;return n&&(s+=` title="${n}"`),s+=">",s}text(e){return"tokens"in e&&e.tokens?this.parser.parseInline(e.tokens):e.text}}class f_{strong({text:e}){return e}em({text:e}){return e}codespan({text:e}){return e}del({text:e}){return e}html({text:e}){return e}text({text:e}){return e}link({text:e}){return""+e}image({text:e}){return""+e}br(){return""}}class wn{constructor(e){Oe(this,"options");Oe(this,"renderer");Oe(this,"textRenderer");this.options=e||ls,this.options.renderer=this.options.renderer||new Jc,this.renderer=this.options.renderer,this.renderer.options=this.options,this.renderer.parser=this,this.textRenderer=new f_}static parse(e,n){return new wn(n).parse(e)}static parseInline(e,n){return new wn(n).parseInline(e)}parse(e,n=!0){let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=s,u=this.options.extensions.renderers[a.type].call({parser:this},a);if(u!==!1||!["space","hr","heading","code","table","blockquote","list","html","paragraph","text"].includes(a.type)){r+=u||"";continue}}const o=s;switch(o.type){case"space":{r+=this.renderer.space(o);continue}case"hr":{r+=this.renderer.hr(o);continue}case"heading":{r+=this.renderer.heading(o);continue}case"code":{r+=this.renderer.code(o);continue}case"table":{r+=this.renderer.table(o);continue}case"blockquote":{r+=this.renderer.blockquote(o);continue}case"list":{r+=this.renderer.list(o);continue}case"html":{r+=this.renderer.html(o);continue}case"paragraph":{r+=this.renderer.paragraph(o);continue}case"text":{let a=o,u=this.renderer.text(a);for(;i+1<e.length&&e[i+1].type==="text";)a=e[++i],u+=`
`+this.renderer.text(a);n?r+=this.renderer.paragraph({type:"paragraph",raw:u,text:u,tokens:[{type:"text",raw:u,text:u}]}):r+=u;continue}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}parseInline(e,n){n=n||this.renderer;let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=this.options.extensions.renderers[s.type].call({parser:this},s);if(a!==!1||!["escape","html","link","image","strong","em","codespan","br","del","text"].includes(s.type)){r+=a||"";continue}}const o=s;switch(o.type){case"escape":{r+=n.text(o);break}case"html":{r+=n.html(o);break}case"link":{r+=n.link(o);break}case"image":{r+=n.image(o);break}case"strong":{r+=n.strong(o);break}case"em":{r+=n.em(o);break}case"codespan":{r+=n.codespan(o);break}case"br":{r+=n.br(o);break}case"del":{r+=n.del(o);break}case"text":{r+=n.text(o);break}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}}class La{constructor(e){Oe(this,"options");Oe(this,"block");this.options=e||ls}preprocess(e){return e}postprocess(e){return e}processAllTokens(e){return e}provideLexer(){return this.block?vn.lex:vn.lexInline}provideParser(){return this.block?wn.parse:wn.parseInline}}Oe(La,"passThroughHooks",new Set(["preprocess","postprocess","processAllTokens"]));class ZV{constructor(...e){Oe(this,"defaults",a_());Oe(this,"options",this.setOptions);Oe(this,"parse",this.parseMarkdown(!0));Oe(this,"parseInline",this.parseMarkdown(!1));Oe(this,"Parser",wn);Oe(this,"Renderer",Jc);Oe(this,"TextRenderer",f_);Oe(this,"Lexer",vn);Oe(this,"Tokenizer",Yc);Oe(this,"Hooks",La);this.use(...e)}walkTokens(e,n){var i,s;let r=[];for(const o of e)switch(r=r.concat(n.call(this,o)),o.type){case"table":{const a=o;for(const u of a.header)r=r.concat(this.walkTokens(u.tokens,n));for(const u of a.rows)for(const c of u)r=r.concat(this.walkTokens(c.tokens,n));break}case"list":{const a=o;r=r.concat(this.walkTokens(a.items,n));break}default:{const a=o;(s=(i=this.defaults.extensions)==null?void 0:i.childTokens)!=null&&s[a.type]?this.defaults.extensions.childTokens[a.type].forEach(u=>{const c=a[u].flat(1/0);r=r.concat(this.walkTokens(c,n))}):a.tokens&&(r=r.concat(this.walkTokens(a.tokens,n)))}}return r}use(...e){const n=this.defaults.extensions||{renderers:{},childTokens:{}};return e.forEach(r=>{const i={...r};if(i.async=this.defaults.async||i.async||!1,r.extensions&&(r.extensions.forEach(s=>{if(!s.name)throw new Error("extension name required");if("renderer"in s){const o=n.renderers[s.name];o?n.renderers[s.name]=function(...a){let u=s.renderer.apply(this,a);return u===!1&&(u=o.apply(this,a)),u}:n.renderers[s.name]=s.renderer}if("tokenizer"in s){if(!s.level||s.level!=="block"&&s.level!=="inline")throw new Error("extension level must be 'block' or 'inline'");const o=n[s.level];o?o.unshift(s.tokenizer):n[s.level]=[s.tokenizer],s.start&&(s.level==="block"?n.startBlock?n.startBlock.push(s.start):n.startBlock=[s.start]:s.level==="inline"&&(n.startInline?n.startInline.push(s.start):n.startInline=[s.start]))}"childTokens"in s&&s.childTokens&&(n.childTokens[s.name]=s.childTokens)}),i.extensions=n),r.renderer){const s=this.defaults.renderer||new Jc(this.defaults);for(const o in r.renderer){if(!(o in s))throw new Error(`renderer '${o}' does not exist`);if(["options","parser"].includes(o))continue;const a=o,u=r.renderer[a],c=s[a];s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f||""}}i.renderer=s}if(r.tokenizer){const s=this.defaults.tokenizer||new Yc(this.defaults);for(const o in r.tokenizer){if(!(o in s))throw new Error(`tokenizer '${o}' does not exist`);if(["options","rules","lexer"].includes(o))continue;const a=o,u=r.tokenizer[a],c=s[a];s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f}}i.tokenizer=s}if(r.hooks){const s=this.defaults.hooks||new La;for(const o in r.hooks){if(!(o in s))throw new Error(`hook '${o}' does not exist`);if(["options","block"].includes(o))continue;const a=o,u=r.hooks[a],c=s[a];La.passThroughHooks.has(o)?s[a]=h=>{if(this.defaults.async)return Promise.resolve(u.call(s,h)).then(g=>c.call(s,g));const f=u.call(s,h);return c.call(s,f)}:s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f}}i.hooks=s}if(r.walkTokens){const s=this.defaults.walkTokens,o=r.walkTokens;i.walkTokens=function(a){let u=[];return u.push(o.call(this,a)),s&&(u=u.concat(s.call(this,a))),u}}this.defaults={...this.defaults,...i}}),this}setOptions(e){return this.defaults={...this.defaults,...e},this}lexer(e,n){return vn.lex(e,n??this.defaults)}parser(e,n){return wn.parse(e,n??this.defaults)}parseMarkdown(e){return(r,i)=>{const s={...i},o={...this.defaults,...s},a=this.onError(!!o.silent,!!o.async);if(this.defaults.async===!0&&s.async===!1)return a(new Error("marked(): The async option was set to true by an extension. Remove async: false from the parse options object to return a Promise."));if(typeof r>"u"||r===null)return a(new Error("marked(): input parameter is undefined or null"));if(typeof r!="string")return a(new Error("marked(): input parameter is of type "+Object.prototype.toString.call(r)+", string expected"));o.hooks&&(o.hooks.options=o,o.hooks.block=e);const u=o.hooks?o.hooks.provideLexer():e?vn.lex:vn.lexInline,c=o.hooks?o.hooks.provideParser():e?wn.parse:wn.parseInline;if(o.async)return Promise.resolve(o.hooks?o.hooks.preprocess(r):r).then(h=>u(h,o)).then(h=>o.hooks?o.hooks.processAllTokens(h):h).then(h=>o.walkTokens?Promise.all(this.walkTokens(h,o.walkTokens)).then(()=>h):h).then(h=>c(h,o)).then(h=>o.hooks?o.hooks.postprocess(h):h).catch(a);try{o.hooks&&(r=o.hooks.preprocess(r));let h=u(r,o);o.hooks&&(h=o.hooks.processAllTokens(h)),o.walkTokens&&this.walkTokens(h,o.walkTokens);let f=c(h,o);return o.hooks&&(f=o.hooks.postprocess(f)),f}catch(h){return a(h)}}}onError(e,n){return r=>{if(r.message+=`
Please report this to https://github.com/markedjs/marked.`,e){const i="<p>An error occurred:</p><pre>"+on(r.message+"",!0)+"</pre>";return n?Promise.resolve(i):i}if(n)return Promise.reject(r);throw r}}}const Zi=new ZV;function Re(t,e){return Zi.parse(t,e)}Re.options=Re.setOptions=function(t){return Zi.setOptions(t),Re.defaults=Zi.defaults,zk(Re.defaults),Re};Re.getDefaults=a_;Re.defaults=ls;Re.use=function(...t){return Zi.use(...t),Re.defaults=Zi.defaults,zk(Re.defaults),Re};Re.walkTokens=function(t,e){return Zi.walkTokens(t,e)};Re.parseInline=Zi.parseInline;Re.Parser=wn;Re.parser=wn.parse;Re.Renderer=Jc;Re.TextRenderer=f_;Re.Lexer=vn;Re.lexer=vn.lex;Re.Tokenizer=Yc;Re.Hooks=La;Re.parse=Re;Re.options;Re.setOptions;Re.use;Re.walkTokens;Re.parseInline;wn.parse;vn.lex;Re.setOptions({gfm:!0,breaks:!0});function e5({bookData:t,onCancel:e,onUpload:n,isUploading:r,uploadProgress:i,uploadStage:s}){var b;const[o,a]=ne.useState("summary"),[u,c]=ne.useState(t.title||""),[h,f]=ne.useState(t.subtitle||""),[g,v]=ne.useState(t.author||""),[I,N]=ne.useState(t.translator||""),[D,C]=ne.useState(t.tagline||""),[w,R]=ne.useState(t.category||o_),[M,z]=ne.useState(t.language||"Bangla"),[U,E]=ne.useState(t.audioUrl||""),[y,T]=ne.useState(t.pdfDriveUrl||""),x=()=>{n({...t,title:u,subtitle:h,author:g,translator:I,tagline:D,category:w,language:M,audioUrl:U,pdfDriveUrl:y})};return m.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[m.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1rem"},children:[m.jsxs("button",{onClick:e,disabled:r,className:"btn-secondary",style:{padding:"0.5rem 0.85rem"},children:[m.jsx(tA,{size:16})," Back"]}),m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"0.8rem",color:"var(--text-muted)"},children:"Ready to Upload to Firebase"}),m.jsx("h2",{style:{fontSize:"1.4rem"},children:"Review Metadata & Attached Files"})]})]}),m.jsx("button",{onClick:x,disabled:r,className:"btn-primary",style:{minWidth:230,justifyContent:"center"},children:r?m.jsxs(m.Fragment,{children:[m.jsx(fA,{size:18,className:"animate-spin",style:{animation:"spin 1s linear infinite"}}),m.jsxs("span",{children:[i,"% Uploading..."]})]}):m.jsxs(m.Fragment,{children:[m.jsx(Dm,{size:18}),m.jsx("span",{children:"Publish to Firebase"})]})})]}),r&&m.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",border:"1px solid var(--accent-primary)"},children:[m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",marginBottom:"0.5rem",fontSize:"0.85rem"},children:[m.jsx("span",{style:{color:"#a5b4fc",fontWeight:600},children:s||"Uploading files..."}),m.jsxs("span",{style:{color:"#f8fafc",fontWeight:700},children:[i,"%"]})]}),m.jsx("div",{style:{width:"100%",height:8,background:"rgba(255,255,255,0.1)",borderRadius:9999,overflow:"hidden"},children:m.jsx("div",{style:{width:`${i}%`,height:"100%",background:"var(--accent-gradient)",transition:"width 0.3s ease"}})})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem 1.75rem"},children:[m.jsx("h4",{style:{fontSize:"0.92rem",textTransform:"uppercase",letterSpacing:"0.05em",color:"var(--text-muted)",marginBottom:"0.85rem"},children:"Files Ready for Firebase Storage"}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(220px, 1fr))",gap:"0.85rem"},children:[m.jsxs("div",{style:{background:t.summaryFile?"rgba(99, 102, 241, 0.1)":"rgba(255,255,255,0.03)",border:t.summaryFile?"1px solid rgba(99, 102, 241, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx(el,{size:20,color:t.summaryFile?"#a5b4fc":"#64748b"}),m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.summaryFile?"#f8fafc":"#64748b"},children:"Summary Markdown"}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:t.summaryFile?`${t.summaryFile.name} (${Ks(t.summaryFile.size)})`:"Not provided"})]})]}),m.jsxs("div",{style:{background:t.fullBookFile?"rgba(168, 85, 247, 0.1)":"rgba(255,255,255,0.03)",border:t.fullBookFile?"1px solid rgba(168, 85, 247, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx(no,{size:20,color:t.fullBookFile?"#c084fc":"#64748b"}),m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.fullBookFile?"#f8fafc":"#64748b"},children:"Full Book Markdown"}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:t.fullBookFile?`${t.fullBookFile.name} (${Ks(t.fullBookFile.size)})`:"Not provided"})]})]}),m.jsxs("div",{style:{background:t.pdfFile||t.pdfDriveUrl?"rgba(239, 68, 68, 0.1)":"rgba(255,255,255,0.03)",border:t.pdfFile||t.pdfDriveUrl?"1px solid rgba(239, 68, 68, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx(Om,{size:20,color:t.pdfFile||t.pdfDriveUrl?"#f87171":"#64748b"}),m.jsxs("div",{style:{overflow:"hidden"},children:[m.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.pdfFile||t.pdfDriveUrl?"#f8fafc":"#64748b"},children:"PDF Document"}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",textOverflow:"ellipsis",overflow:"hidden",whiteSpace:"nowrap"},children:t.pdfFile?`${t.pdfFile.name} (${Ks(t.pdfFile.size)})`:t.pdfDriveUrl?"Google Drive / PDF Link Provided":"Not provided"})]})]}),t.coverPreview&&m.jsxs("div",{style:{background:"rgba(16, 185, 129, 0.1)",border:"1px solid rgba(16, 185, 129, 0.3)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx("img",{src:t.coverPreview,alt:"Cover",style:{width:28,height:38,objectFit:"cover",borderRadius:4}}),m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:"#f8fafc"},children:"Cover Image"}),m.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:(b=t.coverFile)==null?void 0:b.name})]})]})]})]}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(320px, 1fr))",gap:"1.5rem",alignItems:"start"},children:[m.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:[m.jsx(pA,{size:18,color:"#818cf8"}),m.jsx("h3",{style:{fontSize:"1.1rem"},children:"Firestore Metadata Fields"})]}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Book Title"}),m.jsx("input",{type:"text",className:"input-field",value:u,onChange:k=>c(k.target.value),placeholder:"e.g. ধনী বাবা গরীব বাবা"})]}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Subtitle / Description"}),m.jsx("input",{type:"text",className:"input-field",value:h,onChange:k=>f(k.target.value),placeholder:"e.g. বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ"})]}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.75rem"},children:[m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Original Author"}),m.jsx("input",{type:"text",className:"input-field",value:g,onChange:k=>v(k.target.value),placeholder:"e.g. রবার্ট টি. কিওসাকি"})]}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Translator / Compiler"}),m.jsx("input",{type:"text",className:"input-field",value:I,onChange:k=>N(k.target.value),placeholder:"e.g. মোঃ আবির আহমেদ"})]})]}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Tagline / Key Takeaway"}),m.jsx("input",{type:"text",className:"input-field",value:D,onChange:k=>C(k.target.value),placeholder:"e.g. আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা"})]}),m.jsx("div",{children:m.jsx(jk,{value:w,onChange:R})}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Language"}),m.jsx("input",{type:"text",className:"input-field",value:M,onChange:k=>z(k.target.value)})]}),m.jsxs("div",{children:[m.jsx("label",{className:"input-label",children:"Audio Stream Link (MP3)"}),m.jsx("input",{type:"url",className:"input-field",value:U,onChange:k=>E(k.target.value),placeholder:"https://domain.com/audio.mp3"})]}),m.jsxs("div",{children:[m.jsxs("label",{className:"input-label",style:{display:"flex",alignItems:"center",gap:"0.35rem"},children:[m.jsx(Bu,{size:13,color:"#f87171"}),m.jsx("span",{children:"Google Drive / Web PDF Link"})]}),m.jsx("input",{type:"url",className:"input-field",value:y,onChange:k=>T(k.target.value),placeholder:"https://drive.google.com/file/d/.../view or direct PDF URL"}),m.jsx("span",{style:{fontSize:"0.73rem",color:"var(--text-muted)",marginTop:"0.2rem",display:"block"},children:"Used for reading / downloading PDF if no local .pdf file was uploaded."})]})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:[m.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[t.summaryText&&m.jsxs("button",{onClick:()=>a("summary"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="summary"?"var(--accent-primary)":"transparent",color:o==="summary"?"#fff":"var(--text-muted)"},children:[m.jsx(el,{size:14})," Summary Preview"]}),t.fullBookText&&m.jsxs("button",{onClick:()=>a("full"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="full"?"var(--accent-primary)":"transparent",color:o==="full"?"#fff":"var(--text-muted)"},children:[m.jsx(no,{size:14})," Full Book Preview"]})]}),m.jsx("span",{style:{fontSize:"0.78rem",color:"#94a3b8"},children:o==="summary"?`${t.totalWords||0} words`:"Full Content"})]}),m.jsx("div",{className:"markdown-preview",style:{background:"rgba(15, 23, 42, 0.6)",borderRadius:"12px",padding:"1.5rem",border:"1px solid var(--border-subtle)",maxHeight:520,overflowY:"auto"},dangerouslySetInnerHTML:{__html:Re.parse(o==="summary"?t.summaryText||"":t.fullBookText||"")}})]})]})]})}function t5({books:t,loading:e,onRefresh:n,onDeleteBook:r}){const[i,s]=ne.useState(""),[o,a]=ne.useState("All"),u=t.filter(h=>{const f=(h.title||"").toLowerCase().includes(i.toLowerCase())||(h.author||"").toLowerCase().includes(i.toLowerCase())||(h.translator||"").toLowerCase().includes(i.toLowerCase()),g=o==="All"||h.category===o;return f&&g}),c=["All",...new Set(t.map(h=>h.category).filter(Boolean))];return m.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[m.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem"},children:[m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem",marginBottom:"1.25rem"},children:[m.jsxs("div",{children:[m.jsx("h2",{style:{fontSize:"1.5rem",marginBottom:"0.25rem"},children:"Firebase Book Repository"}),m.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem"},children:"Files securely stored in Firebase Storage with clean links and metadata in Cloud Firestore"})]}),m.jsxs("button",{onClick:n,disabled:e,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[m.jsx(Ic,{size:15,className:e?"animate-spin":"",style:{animation:e?"spin 1s linear infinite":"none"}}),"Refresh"]})]}),m.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(220px, 1fr))",gap:"1rem"},children:[m.jsxs("div",{style:{position:"relative"},children:[m.jsx(WT,{size:16,color:"#94a3b8",style:{position:"absolute",left:14,top:"50%",transform:"translateY(-50%)"}}),m.jsx("input",{type:"text",className:"input-field",placeholder:"Search by title, author, translator...",value:i,onChange:h=>s(h.target.value),style:{paddingLeft:"2.5rem"}})]}),m.jsx("select",{className:"input-field",value:o,onChange:h=>a(h.target.value),children:c.map(h=>m.jsxs("option",{value:h,children:[h," (",h==="All"?t.length:t.filter(f=>f.category===h).length,")"]},h))})]})]}),e?m.jsxs("div",{className:"glass-panel",style:{padding:"3rem",textAlign:"center",color:"var(--text-muted)"},children:[m.jsx(Ic,{size:32,className:"animate-spin",style:{animation:"spin 1s linear infinite",margin:"0 auto 1rem",color:"var(--accent-primary)"}}),m.jsx("div",{children:"Retrieving book catalog from Firebase..."})]}):u.length===0?m.jsxs("div",{className:"glass-panel",style:{padding:"3.5rem 2rem",textAlign:"center"},children:[m.jsx(no,{size:48,color:"#6366f1",style:{opacity:.5,margin:"0 auto 1rem"}}),m.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.5rem"},children:"No Books Found"}),m.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.9rem",maxWidth:460,margin:"0 auto 1.5rem"},children:i||o!=="All"?"No books matched your search query. Try clearing filters.":"Your Firebase collection is empty. Upload your first Summary .md, Full .md, or PDF file!"})]}):m.jsx("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fill, minmax(330px, 1fr))",gap:"1.25rem"},children:u.map(h=>m.jsxs("div",{className:"glass-panel glass-panel-hover",style:{padding:"1.5rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",position:"relative"},children:[m.jsxs("div",{children:[m.jsxs("div",{style:{display:"flex",gap:"1rem",alignItems:"flex-start",marginBottom:"0.85rem"},children:[h.coverUrl&&m.jsx("img",{src:h.coverUrl,alt:"Cover",style:{width:50,height:70,objectFit:"cover",borderRadius:6,border:"1px solid var(--border-subtle)",flexShrink:0}}),m.jsxs("div",{style:{flex:1},children:[m.jsxs("div",{style:{display:"flex",gap:"0.4rem",flexWrap:"wrap",marginBottom:"0.4rem"},children:[m.jsx("span",{className:"badge badge-indigo",children:h.category||"General"}),h.language&&m.jsx("span",{className:"badge badge-emerald",children:h.language})]}),m.jsx("h3",{style:{fontSize:"1.2rem",color:"#f8fafc",lineHeight:1.3},children:h.title})]})]}),h.subtitle&&m.jsx("p",{style:{fontSize:"0.83rem",color:"#a5b4fc",marginBottom:"0.5rem",fontStyle:"italic"},children:h.subtitle}),m.jsxs("div",{style:{fontSize:"0.82rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:[h.author&&m.jsxs("div",{children:[m.jsx("strong",{children:"Author:"})," ",h.author]}),h.translator&&m.jsxs("div",{children:[m.jsx("strong",{children:"Translator:"})," ",h.translator]})]}),h.summarySnippet&&m.jsxs("div",{style:{fontSize:"0.8rem",color:"#94a3b8",lineHeight:1.5,marginBottom:"0.85rem",background:"rgba(255,255,255,0.02)",padding:"0.6rem 0.75rem",borderRadius:8,border:"1px solid var(--border-subtle)"},children:[h.summarySnippet,"..."]}),m.jsxs("div",{style:{display:"flex",gap:"1rem",padding:"0.65rem 0",borderTop:"1px solid var(--border-subtle)",borderBottom:"1px solid var(--border-subtle)",fontSize:"0.78rem",color:"var(--text-muted)"},children:[h.totalWords>0&&m.jsxs("span",{children:[h.totalWords.toLocaleString()," words"]}),m.jsxs("span",{children:["~",h.estimatedMinutes||1," min read"]})]})]}),m.jsxs("div",{style:{display:"flex",flexDirection:"column",gap:"0.65rem",marginTop:"0.5rem"},children:[m.jsxs("div",{style:{display:"flex",gap:"0.5rem",flexWrap:"wrap"},children:[h.summaryMdUrl&&m.jsxs("a",{href:h.summaryMdUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Download Summary Markdown from Firebase Storage",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#a5b4fc"},children:[m.jsx(el,{size:13})," Summary .md"]}),h.fullBookMdUrl&&m.jsxs("a",{href:h.fullBookMdUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Download Full Book Markdown from Firebase Storage",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#c084fc"},children:[m.jsx(no,{size:13})," Full .md"]}),(h.pdfUrl||h.pdfDriveUrl)&&m.jsxs("a",{href:h.pdfUrl||h.pdfDriveUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:h.pdfDriveUrl?"Open PDF via Google Drive / Web link":"Open or Download PDF",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#f87171"},children:[m.jsx(Om,{size:13})," PDF"]}),h.audioUrl&&m.jsxs("a",{href:h.audioUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Open Audio Stream",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#6ee7b7"},children:[m.jsx(cA,{size:13})," Audio"]})]}),m.jsx("div",{style:{display:"flex",justifyContent:"flex-end",paddingTop:"0.25rem"},children:m.jsxs("button",{onClick:()=>r(h),className:"btn-secondary",title:"Delete Book from Firebase",style:{padding:"0.35rem 0.65rem",color:"#ef4444",fontSize:"0.78rem",borderColor:"rgba(239, 68, 68, 0.2)"},children:[m.jsx(ha,{size:13})," Delete"]})})]})]},h.id))})]})}function n5({courses:t,loading:e,onRefresh:n}){const[r,i]=ne.useState("All"),[s,o]=ne.useState(""),[a,u]=ne.useState(null),c=t.filter(f=>{var I,N,D,C,w;const g=r==="All"||r==="English"&&((I=f.language)==null?void 0:I.toLowerCase())==="english"||r==="Japanese"&&((N=f.language)==null?void 0:N.toLowerCase())==="japanese",v=!s.trim()||((D=f.title)==null?void 0:D.toLowerCase().includes(s.toLowerCase()))||((C=f.subtitle)==null?void 0:C.toLowerCase().includes(s.toLowerCase()))||((w=f.instructor)==null?void 0:w.toLowerCase().includes(s.toLowerCase()))||f.tags&&f.tags.some(R=>R.toLowerCase().includes(s.toLowerCase()));return g&&v}),h=f=>{u(g=>g===f?null:f)};return m.jsxs("div",{style:{maxWidth:1200,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[m.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[m.jsxs("div",{children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",marginBottom:"0.25rem"},children:[m.jsx("div",{style:{width:32,height:32,borderRadius:8,background:"linear-gradient(135deg, #10b981, #059669)",display:"flex",alignItems:"center",justifyContent:"center",boxShadow:"0 0 14px rgba(16, 185, 129, 0.4)"},children:m.jsx(Jf,{size:18,color:"#ffffff"})}),m.jsx("h2",{style:{fontSize:"1.4rem"},children:"ল্যাঙ্গুয়েজ ও স্কিল কোর্স"})]}),m.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.85rem"},children:"Android অ্যাপ ও ফায়ারবেস কোর্সেস ডেটাবেজের সাথে সিঙ্ক করা ল্যাঙ্গুয়েজ অডিও লেসন"})]}),m.jsx("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem",flexWrap:"wrap"},children:m.jsxs("button",{onClick:n,className:"btn-secondary",disabled:e,style:{padding:"0.5rem 0.85rem",fontSize:"0.85rem"},children:[m.jsx(Ic,{size:14,className:e?"animate-spin":"",style:e?{animation:"spin 1s linear infinite"}:{}}),m.jsx("span",{children:"Refresh Courses"})]})})]}),m.jsxs("div",{className:"glass-panel",style:{padding:"1rem 1.5rem",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[m.jsx("div",{style:{display:"flex",gap:"0.5rem"},children:["All","English","Japanese"].map(f=>m.jsx("button",{onClick:()=>i(f),style:{padding:"0.45rem 1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.82rem",background:r===f?"var(--accent-primary)":"rgba(255,255,255,0.05)",color:r===f?"#ffffff":"var(--text-muted)",transition:"all 0.2s ease"},children:f==="All"?"সব কোর্স":f==="English"?"🇬🇧 English Courses":"🇯🇵 Japanese Courses"},f))}),m.jsxs("div",{style:{position:"relative",width:280},children:[m.jsx(WT,{size:15,color:"#94a3b8",style:{position:"absolute",left:10,top:"50%",transform:"translateY(-50%)"}}),m.jsx("input",{type:"text",className:"input-field",style:{paddingLeft:"2rem",fontSize:"0.85rem"},placeholder:"কোর্স বা শিক্ষকের নাম দিয়ে খুঁজুন...",value:s,onChange:f=>o(f.target.value)})]})]}),e?m.jsxs("div",{className:"glass-panel",style:{padding:"3.5rem",textAlign:"center",color:"var(--text-muted)"},children:[m.jsx(Ic,{size:36,className:"animate-spin",style:{animation:"spin 1s linear infinite",margin:"0 auto 1rem",color:"#10b981"}}),m.jsx("div",{children:"Firestore থেকে ল্যাঙ্গুয়েজ কোর্স তালিকা লোড হচ্ছে..."})]}):c.length===0?m.jsxs("div",{className:"glass-panel",style:{padding:"3.5rem 2rem",textAlign:"center"},children:[m.jsx(Jf,{size:48,color:"#10b981",style:{opacity:.5,margin:"0 auto 1rem"}}),m.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.5rem"},children:"কোনো কোর্স পাওয়া যায়নি"}),m.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem",maxWidth:440,margin:"0 auto"},children:s?"সার্চের সাথে মিলে এমন কোনো কোর্স পাওয়া যায়নি। সার্চ কিওয়ার্ড পরিবর্তন করুন।":"ফায়ারবেসের `courses` কালেকশন লোড করুন অথবা seed_firestore.js দিয়ে কোর্স যোগ করুন।"})]}):m.jsx("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fill, minmax(360px, 1fr))",gap:"1.5rem"},children:c.map(f=>{var I;const g=a===f.id,v=((I=f.language)==null?void 0:I.toLowerCase())==="japanese";return m.jsx("div",{className:"glass-panel glass-panel-hover",style:{padding:"1.5rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:v?"1px solid rgba(239, 68, 68, 0.25)":"1px solid rgba(59, 130, 246, 0.25)"},children:m.jsxs("div",{children:[f.thumbnailUrl&&m.jsxs("div",{style:{width:"100%",height:160,borderRadius:8,overflow:"hidden",marginBottom:"1rem",position:"relative"},children:[m.jsx("img",{src:f.thumbnailUrl,alt:f.title,style:{width:"100%",height:"100%",objectFit:"cover"}}),m.jsx("span",{style:{position:"absolute",top:10,right:10,padding:"3px 10px",borderRadius:9999,fontSize:"0.75rem",fontWeight:700,background:v?"rgba(220, 38, 38, 0.85)":"rgba(37, 99, 235, 0.85)",color:"#ffffff",backdropFilter:"blur(8px)"},children:v?"🇯🇵 Japanese":"🇬🇧 English"})]}),m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.4rem"},children:[m.jsx("span",{className:"badge badge-indigo",style:{fontSize:"0.72rem"},children:f.level||"Beginner to Advanced"}),f.instructor&&m.jsxs("span",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:["শিক্ষক: ",m.jsx("strong",{children:f.instructor})]})]}),m.jsx("h3",{style:{fontSize:"1.2rem",color:"#f8fafc",lineHeight:1.3,marginBottom:"0.35rem"},children:f.title}),f.subtitle&&m.jsx("p",{style:{fontSize:"0.82rem",color:"#a5b4fc",marginBottom:"0.65rem",fontStyle:"italic"},children:f.subtitle}),f.description&&m.jsxs("p",{style:{fontSize:"0.78rem",color:"#94a3b8",lineHeight:1.5,marginBottom:"0.75rem"},children:[f.description.slice(0,160),"..."]}),m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",padding:"0.6rem 0",borderTop:"1px solid var(--border-subtle)",borderBottom:"1px solid var(--border-subtle)",fontSize:"0.75rem",color:"var(--text-muted)"},children:[m.jsxs("span",{style:{display:"flex",alignItems:"center",gap:"0.25rem"},children:[m.jsx(aA,{size:13,color:"#818cf8"}),f.totalHours?`${f.totalHours} hrs`:`${f.lessonCount||0} Lessons`]}),m.jsxs("span",{style:{display:"flex",alignItems:"center",gap:"0.25rem"},children:[m.jsx(gA,{size:13,color:"#fbbf24",fill:"#fbbf24"}),f.rating||"4.9"]}),m.jsxs("span",{style:{display:"flex",alignItems:"center",gap:"0.25rem"},children:[m.jsx(vA,{size:13,color:"#34d399"}),f.enrolledCount?`${f.enrolledCount.toLocaleString()} enrolled`:"Active"]})]}),f.tags&&f.tags.length>0&&m.jsx("div",{style:{display:"flex",flexWrap:"wrap",gap:"0.35rem",marginTop:"0.75rem"},children:f.tags.map((N,D)=>m.jsxs("span",{style:{fontSize:"0.7rem",padding:"2px 8px",borderRadius:6,background:"rgba(255, 255, 255, 0.04)",color:"#94a3b8",border:"1px solid rgba(255, 255, 255, 0.06)"},children:["#",N]},D))}),f.modules&&f.modules.length>0&&m.jsxs("div",{style:{marginTop:"0.85rem"},children:[m.jsxs("button",{onClick:()=>h(f.id),className:"btn-secondary",style:{width:"100%",justifyContent:"space-between",padding:"0.45rem 0.75rem",fontSize:"0.78rem"},children:[m.jsxs("span",{children:["পাঠ্যক্রম দেখুন (",f.modules.length," টি মডিউল)"]}),g?m.jsx(iA,{size:14}):m.jsx(rA,{size:14})]}),g&&m.jsx("div",{style:{marginTop:"0.65rem",display:"flex",flexDirection:"column",gap:"0.5rem",background:"rgba(0, 0, 0, 0.2)",padding:"0.75rem",borderRadius:8,border:"1px solid var(--border-subtle)",maxHeight:280,overflowY:"auto"},children:f.modules.map((N,D)=>{var C;return m.jsxs("div",{children:[m.jsx("div",{style:{fontSize:"0.78rem",fontWeight:700,color:"#f8fafc",marginBottom:"0.35rem"},children:N.moduleTitle}),m.jsx("div",{style:{display:"flex",flexDirection:"column",gap:"0.3rem",paddingLeft:"0.5rem"},children:(C=N.lessons)==null?void 0:C.map((w,R)=>m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",fontSize:"0.74rem",color:"#cbd5e1",padding:"0.25rem 0",borderBottom:"1px dashed rgba(255,255,255,0.06)"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.4rem",flex:1,minWidth:0},children:[m.jsx(gv,{size:12,color:"#10b981"}),m.jsx("span",{style:{textOverflow:"ellipsis",overflow:"hidden",whiteSpace:"nowrap"},children:w.title})]}),m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.4rem",flexShrink:0},children:[w.duration&&m.jsx("span",{style:{color:"#64748b",fontSize:"0.7rem"},children:w.duration}),w.audioUrl&&m.jsx("a",{href:w.audioUrl,target:"_blank",rel:"noopener noreferrer",style:{color:"#38bdf8"},title:"Play Audio Lesson",children:m.jsx(gv,{size:13})}),w.pdfUrl&&m.jsx("a",{href:w.pdfUrl,target:"_blank",rel:"noopener noreferrer",style:{color:"#f87171"},title:"Open PDF Lesson Notes",children:m.jsx(el,{size:13})})]})]},R))})]},D)})})]})]})},f.id)})})]})}function r5({isOpen:t,onClose:e}){const[n,r]=ne.useState(!1),[i,s]=ne.useState(!1);if(!t)return null;const o=`rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}`,a=`rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if true;
    }
  }
}`,u=(f,g)=>{navigator.clipboard.writeText(f),g==="storage"?(r(!0),setTimeout(()=>r(!1),2e3)):(s(!0),setTimeout(()=>s(!1),2e3))},c=`https://console.firebase.google.com/project/${Oa.projectId}/firestore/rules`,h=`https://console.firebase.google.com/project/${Oa.projectId}/storage/rules`;return m.jsx("div",{style:{position:"fixed",top:0,left:0,right:0,bottom:0,background:"rgba(0, 0, 0, 0.75)",backdropFilter:"blur(8px)",display:"flex",alignItems:"center",justifyContent:"center",zIndex:9999,padding:"1.5rem"},children:m.jsxs("div",{className:"glass-panel",style:{maxWidth:720,width:"100%",maxHeight:"90vh",overflowY:"auto",padding:"2rem",border:"1px solid rgba(239, 68, 68, 0.4)",boxShadow:"0 20px 50px rgba(0, 0, 0, 0.8)"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"1.25rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[m.jsx("div",{style:{width:42,height:42,borderRadius:10,background:"rgba(239, 68, 68, 0.2)",display:"flex",alignItems:"center",justifyContent:"center"},children:m.jsx(mA,{size:24,color:"#ef4444"})}),m.jsxs("div",{children:[m.jsx("h3",{style:{fontSize:"1.3rem",color:"#f8fafc"},children:"Fix Firebase Permissions"}),m.jsxs("p",{style:{fontSize:"0.82rem",color:"var(--text-muted)"},children:["Resolve ",m.jsx("strong",{children:'"Missing or insufficient permissions"'})," in project ",m.jsx("strong",{children:Oa.projectId})]})]})]}),m.jsx("button",{onClick:e,style:{background:"transparent",border:"none",color:"#94a3b8",cursor:"pointer",padding:4},children:m.jsx(qT,{size:20})})]}),m.jsxs("div",{style:{background:"rgba(239, 68, 68, 0.12)",border:"1px solid rgba(239, 68, 68, 0.3)",borderRadius:10,padding:"0.85rem 1rem",fontSize:"0.85rem",color:"#fca5a5",marginBottom:"1.25rem",display:"flex",gap:"0.6rem"},children:[m.jsx(yA,{size:18,style:{flexShrink:0,marginTop:2}}),m.jsxs("div",{children:[m.jsx("strong",{children:"Why this happens:"}),' Newly initialized Cloud Firestore and Storage buckets start in "Production/Locked mode" (',m.jsx("code",{children:"allow read, write: if false;"}),"). You need to publish the rules below to allow uploads."]})]}),m.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(16, 185, 129, 0.3)",marginBottom:"1.25rem"},children:[m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#6ee7b7"},children:[m.jsx(lA,{size:17}),' 1. Cloud Firestore Rules (Fixes "Missing or insufficient permissions")']}),m.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[m.jsxs("button",{onClick:()=>u(o,"firestore"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[i?m.jsx(Ds,{size:14,color:"#10b981"}):m.jsx(_v,{size:14}),i?"Copied":"Copy Firestore Rule"]}),m.jsxs("a",{href:c,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Firestore Rules ",m.jsx(yv,{size:13})]})]})]}),m.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:m.jsx("code",{children:o})}),m.jsxs("div",{style:{fontSize:"0.78rem",color:"#94a3b8",marginTop:"0.5rem"},children:["Click ",m.jsx("strong",{children:"Open Firestore Rules"})," > Paste above > Click ",m.jsx("strong",{children:"Publish"}),"."]})]}),m.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(99, 102, 241, 0.3)",marginBottom:"1.5rem"},children:[m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[m.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#a5b4fc"},children:[m.jsx(uA,{size:17})," 2. Firebase Storage Rules (Fixes storage/unauthorized)"]}),m.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[m.jsxs("button",{onClick:()=>u(a,"storage"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[n?m.jsx(Ds,{size:14,color:"#10b981"}):m.jsx(_v,{size:14}),n?"Copied":"Copy Storage Rule"]}),m.jsxs("a",{href:h,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Storage Rules ",m.jsx(yv,{size:13})]})]})]}),m.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:m.jsx("code",{children:a})})]}),m.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem"},children:[m.jsx("div",{style:{fontSize:"0.8rem",color:"#94a3b8"},children:"Once published in Firebase Console, uploads will succeed immediately."}),m.jsx("button",{onClick:e,className:"btn-primary",style:{padding:"0.65rem 1.25rem"},children:"I've Published Rules / Done"})]})]})})}function i5({toasts:t,onDismiss:e}){return!t||t.length===0?null:m.jsx("div",{className:"toast-container",children:t.map(n=>{let r=oA,i="rgba(16, 185, 129, 0.4)",s="#10b981";return n.type==="error"?(r=sA,i="rgba(239, 68, 68, 0.4)",s="#ef4444"):n.type==="info"&&(r=$T,i="rgba(99, 102, 241, 0.4)",s="#6366f1"),m.jsxs("div",{className:"toast",style:{borderColor:i},children:[m.jsx(r,{size:20,color:s,style:{flexShrink:0}}),m.jsxs("div",{style:{flex:1,fontSize:"0.9rem"},children:[n.title&&m.jsx("div",{style:{fontWeight:600,marginBottom:2},children:n.title}),m.jsx("div",{style:{color:"#cbd5e1"},children:n.message})]}),m.jsx("button",{onClick:()=>e(n.id),style:{background:"transparent",border:"none",color:"#64748b",cursor:"pointer",display:"flex",alignItems:"center",padding:4},children:m.jsx(qT,{size:16})})]},n.id)})})}var p_={};(function t(e,n,r,i){var s=!!(e.Worker&&e.Blob&&e.Promise&&e.OffscreenCanvas&&e.OffscreenCanvasRenderingContext2D&&e.HTMLCanvasElement&&e.HTMLCanvasElement.prototype.transferControlToOffscreen&&e.URL&&e.URL.createObjectURL),o=typeof Path2D=="function"&&typeof DOMMatrix=="function",a=function(){if(!e.OffscreenCanvas)return!1;try{var P=new OffscreenCanvas(1,1),A=P.getContext("2d");A.fillRect(0,0,1,1);var $=P.transferToImageBitmap();A.createPattern($,"no-repeat")}catch{return!1}return!0}();function u(){}function c(P){var A=n.exports.Promise,$=A!==void 0?A:e.Promise;return typeof $=="function"?new $(P):(P(u,u),null)}var h=function(P,A){return{transform:function($){if(P)return $;if(A.has($))return A.get($);var F=new OffscreenCanvas($.width,$.height),W=F.getContext("2d");return W.drawImage($,0,0),A.set($,F),F},clear:function(){A.clear()}}}(a,new Map),f=function(){var P=Math.floor(16.666666666666668),A,$,F={},W=0;return typeof requestAnimationFrame=="function"&&typeof cancelAnimationFrame=="function"?(A=function(K){var Z=Math.random();return F[Z]=requestAnimationFrame(function Y(oe){W===oe||W+P-1<oe?(W=oe,delete F[Z],K()):F[Z]=requestAnimationFrame(Y)}),Z},$=function(K){F[K]&&cancelAnimationFrame(F[K])}):(A=function(K){return setTimeout(K,P)},$=function(K){return clearTimeout(K)}),{frame:A,cancel:$}}(),g=function(){var P,A,$={};function F(W){function K(Z,Y){W.postMessage({options:Z||{},callback:Y})}W.init=function(Y){var oe=Y.transferControlToOffscreen();W.postMessage({canvas:oe},[oe])},W.fire=function(Y,oe,we){if(A)return K(Y,null),A;var Ee=Math.random().toString(36).slice(2);return A=c(function(pe){function ke(be){be.data.callback===Ee&&(delete $[Ee],W.removeEventListener("message",ke),A=null,h.clear(),we(),pe())}W.addEventListener("message",ke),K(Y,Ee),$[Ee]=ke.bind(null,{data:{callback:Ee}})}),A},W.reset=function(){W.postMessage({reset:!0});for(var Y in $)$[Y](),delete $[Y]}}return function(){if(P)return P;if(!r&&s){var W=["var CONFETTI, SIZE = {}, module = {};","("+t.toString()+")(this, module, true, SIZE);","onmessage = function(msg) {","  if (msg.data.options) {","    CONFETTI(msg.data.options).then(function () {","      if (msg.data.callback) {","        postMessage({ callback: msg.data.callback });","      }","    });","  } else if (msg.data.reset) {","    CONFETTI && CONFETTI.reset();","  } else if (msg.data.resize) {","    SIZE.width = msg.data.resize.width;","    SIZE.height = msg.data.resize.height;","  } else if (msg.data.canvas) {","    SIZE.width = msg.data.canvas.width;","    SIZE.height = msg.data.canvas.height;","    CONFETTI = module.exports.create(msg.data.canvas);","  }","}"].join(`
`);try{P=new Worker(URL.createObjectURL(new Blob([W])))}catch(K){return typeof console<"u"&&typeof console.warn=="function"&&console.warn("🎊 Could not load worker",K),null}F(P)}return P}}(),v={particleCount:50,angle:90,spread:45,startVelocity:45,decay:.9,gravity:1,drift:0,ticks:200,x:.5,y:.5,shapes:["square","circle"],zIndex:100,colors:["#26ccff","#a25afd","#ff5e7e","#88ff5a","#fcff42","#ffa62d","#ff36ff"],disableForReducedMotion:!1,scalar:1};function I(P,A){return A?A(P):P}function N(P){return P!=null}function D(P,A,$){return I(P&&N(P[A])?P[A]:v[A],$)}function C(P){return P<0?0:Math.floor(P)}function w(P,A){return Math.floor(Math.random()*(A-P))+P}function R(P){return parseInt(P,16)}function M(P){return P.map(z)}function z(P){var A=String(P).replace(/[^0-9a-f]/gi,"");return A.length<6&&(A=A[0]+A[0]+A[1]+A[1]+A[2]+A[2]),{r:R(A.substring(0,2)),g:R(A.substring(2,4)),b:R(A.substring(4,6))}}function U(P){var A=D(P,"origin",Object);return A.x=D(A,"x",Number),A.y=D(A,"y",Number),A}function E(P){P.width=document.documentElement.clientWidth,P.height=document.documentElement.clientHeight}function y(P){var A=P.getBoundingClientRect();P.width=A.width,P.height=A.height}function T(P){var A=document.createElement("canvas");return A.style.position="fixed",A.style.top="0px",A.style.left="0px",A.style.pointerEvents="none",A.style.zIndex=P,A}function x(P,A,$,F,W,K,Z,Y,oe){P.save(),P.translate(A,$),P.rotate(K),P.scale(F,W),P.arc(0,0,1,Z,Y,oe),P.restore()}function b(P){var A=P.angle*(Math.PI/180),$=P.spread*(Math.PI/180);return{x:P.x,y:P.y,wobble:Math.random()*10,wobbleSpeed:Math.min(.11,Math.random()*.1+.05),velocity:P.startVelocity*.5+Math.random()*P.startVelocity,angle2D:-A+(.5*$-Math.random()*$),tiltAngle:(Math.random()*(.75-.25)+.25)*Math.PI,color:P.color,shape:P.shape,tick:0,totalTicks:P.ticks,decay:P.decay,drift:P.drift,random:Math.random()+2,tiltSin:0,tiltCos:0,wobbleX:0,wobbleY:0,gravity:P.gravity*3,ovalScalar:.6,scalar:P.scalar,flat:P.flat}}function k(P,A){A.x+=Math.cos(A.angle2D)*A.velocity+A.drift,A.y+=Math.sin(A.angle2D)*A.velocity+A.gravity,A.velocity*=A.decay,A.flat?(A.wobble=0,A.wobbleX=A.x+10*A.scalar,A.wobbleY=A.y+10*A.scalar,A.tiltSin=0,A.tiltCos=0,A.random=1):(A.wobble+=A.wobbleSpeed,A.wobbleX=A.x+10*A.scalar*Math.cos(A.wobble),A.wobbleY=A.y+10*A.scalar*Math.sin(A.wobble),A.tiltAngle+=.1,A.tiltSin=Math.sin(A.tiltAngle),A.tiltCos=Math.cos(A.tiltAngle),A.random=Math.random()+2);var $=A.tick++/A.totalTicks,F=A.x+A.random*A.tiltCos,W=A.y+A.random*A.tiltSin,K=A.wobbleX+A.random*A.tiltCos,Z=A.wobbleY+A.random*A.tiltSin;if(P.fillStyle="rgba("+A.color.r+", "+A.color.g+", "+A.color.b+", "+(1-$)+")",P.beginPath(),o&&A.shape.type==="path"&&typeof A.shape.path=="string"&&Array.isArray(A.shape.matrix))P.fill(Rt(A.shape.path,A.shape.matrix,A.x,A.y,Math.abs(K-F)*.1,Math.abs(Z-W)*.1,Math.PI/10*A.wobble));else if(A.shape.type==="bitmap"){var Y=Math.PI/10*A.wobble,oe=Math.abs(K-F)*.1,we=Math.abs(Z-W)*.1,Ee=A.shape.bitmap.width*A.scalar,pe=A.shape.bitmap.height*A.scalar,ke=new DOMMatrix([Math.cos(Y)*oe,Math.sin(Y)*oe,-Math.sin(Y)*we,Math.cos(Y)*we,A.x,A.y]);ke.multiplySelf(new DOMMatrix(A.shape.matrix));var be=P.createPattern(h.transform(A.shape.bitmap),"no-repeat");be.setTransform(ke),P.globalAlpha=1-$,P.fillStyle=be,P.fillRect(A.x-Ee/2,A.y-pe/2,Ee,pe),P.globalAlpha=1}else if(A.shape==="circle")P.ellipse?P.ellipse(A.x,A.y,Math.abs(K-F)*A.ovalScalar,Math.abs(Z-W)*A.ovalScalar,Math.PI/10*A.wobble,0,2*Math.PI):x(P,A.x,A.y,Math.abs(K-F)*A.ovalScalar,Math.abs(Z-W)*A.ovalScalar,Math.PI/10*A.wobble,0,2*Math.PI);else if(A.shape==="star")for(var ee=Math.PI/2*3,Ze=4*A.scalar,nt=8*A.scalar,zt=A.x,Kt=A.y,fn=5,xt=Math.PI/fn;fn--;)zt=A.x+Math.cos(ee)*nt,Kt=A.y+Math.sin(ee)*nt,P.lineTo(zt,Kt),ee+=xt,zt=A.x+Math.cos(ee)*Ze,Kt=A.y+Math.sin(ee)*Ze,P.lineTo(zt,Kt),ee+=xt;else P.moveTo(Math.floor(A.x),Math.floor(A.y)),P.lineTo(Math.floor(A.wobbleX),Math.floor(W)),P.lineTo(Math.floor(K),Math.floor(Z)),P.lineTo(Math.floor(F),Math.floor(A.wobbleY));return P.closePath(),P.fill(),A.tick<A.totalTicks}function S(P,A,$,F,W){var K=A.slice(),Z=P.getContext("2d"),Y,oe,we=c(function(Ee){function pe(){Y=oe=null,Z.clearRect(0,0,F.width,F.height),h.clear(),W(),Ee()}function ke(){r&&!(F.width===i.width&&F.height===i.height)&&(F.width=P.width=i.width,F.height=P.height=i.height),!F.width&&!F.height&&($(P),F.width=P.width,F.height=P.height),Z.clearRect(0,0,F.width,F.height),K=K.filter(function(be){return k(Z,be)}),K.length?Y=f.frame(ke):pe()}Y=f.frame(ke),oe=pe});return{addFettis:function(Ee){return K=K.concat(Ee),we},canvas:P,promise:we,reset:function(){Y&&f.cancel(Y),oe&&oe()}}}function ue(P,A){var $=!P,F=!!D(A||{},"resize"),W=!1,K=D(A,"disableForReducedMotion",Boolean),Z=s&&!!D(A||{},"useWorker"),Y=Z?g():null,oe=$?E:y,we=P&&Y?!!P.__confetti_initialized:!1,Ee=typeof matchMedia=="function"&&matchMedia("(prefers-reduced-motion)").matches,pe;function ke(ee,Ze,nt){for(var zt=D(ee,"particleCount",C),Kt=D(ee,"angle",Number),fn=D(ee,"spread",Number),xt=D(ee,"startVelocity",Number),Ar=D(ee,"decay",Number),qh=D(ee,"gravity",Number),Ao=D(ee,"drift",Number),us=D(ee,"colors",M),Vl=D(ee,"ticks",Number),at=D(ee,"shapes"),_t=D(ee,"scalar"),cs=!!D(ee,"flat"),bo=U(ee),Po=zt,No=[],wi=P.width*bo.x,Ul=P.height*bo.y;Po--;)No.push(b({x:wi,y:Ul,angle:Kt,spread:fn,startVelocity:xt,color:us[Po%us.length],shape:at[w(0,at.length)],ticks:Vl,decay:Ar,gravity:qh,drift:Ao,scalar:_t,flat:cs}));return pe?pe.addFettis(No):(pe=S(P,No,oe,Ze,nt),pe.promise)}function be(ee){var Ze=K||D(ee,"disableForReducedMotion",Boolean),nt=D(ee,"zIndex",Number);if(Ze&&Ee)return c(function(xt){xt()});$&&pe?P=pe.canvas:$&&!P&&(P=T(nt),document.body.appendChild(P)),F&&!we&&oe(P);var zt={width:P.width,height:P.height};Y&&!we&&Y.init(P),we=!0,Y&&(P.__confetti_initialized=!0);function Kt(){if(Y){var xt={getBoundingClientRect:function(){if(!$)return P.getBoundingClientRect()}};oe(xt),Y.postMessage({resize:{width:xt.width,height:xt.height}});return}zt.width=zt.height=null}function fn(){pe=null,F&&(W=!1,e.removeEventListener("resize",Kt)),$&&P&&(document.body.contains(P)&&document.body.removeChild(P),P=null,we=!1)}return F&&!W&&(W=!0,e.addEventListener("resize",Kt,!1)),Y?Y.fire(ee,zt,fn):ke(ee,zt,fn)}return be.reset=function(){Y&&Y.reset(),pe&&pe.reset()},be}var Se;function Je(){return Se||(Se=ue(null,{useWorker:!0,resize:!0})),Se}function Rt(P,A,$,F,W,K,Z){var Y=new Path2D(P),oe=new Path2D;oe.addPath(Y,new DOMMatrix(A));var we=new Path2D;return we.addPath(oe,new DOMMatrix([Math.cos(Z)*W,Math.sin(Z)*W,-Math.sin(Z)*K,Math.cos(Z)*K,$,F])),we}function H(P){if(!o)throw new Error("path confetti are not supported in this browser");var A,$;typeof P=="string"?A=P:(A=P.path,$=P.matrix);var F=new Path2D(A),W=document.createElement("canvas"),K=W.getContext("2d");if(!$){for(var Z=1e3,Y=Z,oe=Z,we=0,Ee=0,pe,ke,be=0;be<Z;be+=2)for(var ee=0;ee<Z;ee+=2)K.isPointInPath(F,be,ee,"nonzero")&&(Y=Math.min(Y,be),oe=Math.min(oe,ee),we=Math.max(we,be),Ee=Math.max(Ee,ee));pe=we-Y,ke=Ee-oe;var Ze=10,nt=Math.min(Ze/pe,Ze/ke);$=[nt,0,0,nt,-Math.round(pe/2+Y)*nt,-Math.round(ke/2+oe)*nt]}return{type:"path",path:A,matrix:$}}function re(P){var A,$=1,F="#000000",W='"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji", "EmojiOne Color", "Android Emoji", "Twemoji Mozilla", "system emoji", sans-serif';typeof P=="string"?A=P:(A=P.text,$="scalar"in P?P.scalar:$,W="fontFamily"in P?P.fontFamily:W,F="color"in P?P.color:F);var K=10*$,Z=""+K+"px "+W,Y=new OffscreenCanvas(K,K),oe=Y.getContext("2d");oe.font=Z;var we=oe.measureText(A),Ee=Math.ceil(we.actualBoundingBoxRight+we.actualBoundingBoxLeft),pe=Math.ceil(we.actualBoundingBoxAscent+we.actualBoundingBoxDescent),ke=2,be=we.actualBoundingBoxLeft+ke,ee=we.actualBoundingBoxAscent+ke;Ee+=ke+ke,pe+=ke+ke,Y=new OffscreenCanvas(Ee,pe),oe=Y.getContext("2d"),oe.font=Z,oe.fillStyle=F,oe.fillText(A,be,ee);var Ze=1/$;return{type:"bitmap",bitmap:Y.transferToImageBitmap(),matrix:[Ze,0,0,Ze,-Ee*Ze/2,-pe*Ze/2]}}n.exports=function(){return Je().apply(this,arguments)},n.exports.reset=function(){Je().reset()},n.exports.create=ue,n.exports.shapeFromPath=H,n.exports.shapeFromText=re})(function(){return typeof window<"u"?window:typeof self<"u"?self:this||{}}(),p_,!1);const s5=p_.exports;p_.exports.create;function o5(){const[t,e]=ne.useState("upload"),[n,r]=ne.useState(null),[i,s]=ne.useState([]),[o,a]=ne.useState(!1),[u,c]=ne.useState([]),[h,f]=ne.useState(!1),[g,v]=ne.useState(!1),[I,N]=ne.useState(!1),[D,C]=ne.useState(0),[w,R]=ne.useState(""),[M,z]=ne.useState([]),U=({type:k="info",title:S="",message:ue=""})=>{const Se=Date.now().toString();z(Je=>[...Je,{id:Se,type:k,title:S,message:ue}]),setTimeout(()=>{E(Se)},5e3)},E=k=>{z(S=>S.filter(ue=>ue.id!==k))},y=async()=>{a(!0);let k=[];try{const S=nD($d(xu,"books"),rD("createdAt","desc"));(await g0(S)).forEach(Se=>{k.push({id:Se.id,...Se.data()})})}catch(S){console.warn("Firestore fetch error or restricted rules:",S)}try{const S=JSON.parse(localStorage.getItem("audio_books_cache")||"[]"),ue=new Set(k.map(Je=>Je.id)),Se=S.filter(Je=>!ue.has(Je.id));k=[...k,...Se]}catch{}s(k),a(!1)},T=async()=>{f(!0);try{const S=(await g0($d(xu,"courses"))).docs.map(ue=>({id:ue.id,...ue.data()}));c(S)}catch(k){console.warn("Error fetching courses from Firestore:",k)}finally{f(!1)}};ne.useEffect(()=>{X4(mV).catch(k=>{console.log("Anonymous sign-in note:",k.message)}),y(),T()},[]);const x=async k=>{var S,ue,Se,Je,Rt,H,re;N(!0),C(5),R("Preparing files for Firebase Storage...");try{const P=vV(k.title),A=new Date().toISOString();let $="",F="",W="",K="",Z="",Y="",oe="",we="";const Ee=async(ee,Ze,nt)=>{const zt=I0(Tw,Ze),Kt=IO(zt,ee,nt?{contentType:nt}:void 0);return new Promise((fn,xt)=>{Kt.on("state_changed",null,Ar=>xt(Ar),async()=>{const Ar=await SO(Kt.snapshot.ref);fn(Ar)})})};if(k.summaryFile){R("Uploading Summary Markdown to Firebase Storage..."),C(20),F=`books/${P}/${k.summaryFile.name}`;try{$=await Ee(k.summaryFile,F,"text/markdown")}catch(ee){throw console.warn("Summary storage upload error:",ee),(ee.code==="storage/unauthorized"||(S=ee.message)!=null&&S.toLowerCase().includes("unauthorized"))&&v(!0),ee}}if(k.fullBookFile){R("Uploading Full Book Markdown to Firebase Storage..."),C(45),K=`books/${P}/${k.fullBookFile.name}`;try{W=await Ee(k.fullBookFile,K,"text/markdown")}catch(ee){throw console.warn("Full book storage upload error:",ee),ee}}if(k.pdfFile){R("Uploading PDF Document to Firebase Storage..."),C(70),Y=`books/${P}/${k.pdfFile.name}`;try{Z=await Ee(k.pdfFile,Y,"application/pdf")}catch(ee){throw console.warn("PDF storage upload error:",ee),ee}}else k.pdfDriveUrl&&(Z=Iw(k.pdfDriveUrl));if(k.coverFile){R("Uploading Cover Image..."),we=`covers/${P}/${k.coverFile.name}`;try{oe=await Ee(k.coverFile,we)}catch(ee){console.warn("Cover upload skipped:",ee)}}C(85),R("Saving book metadata & storage links in Firestore...");const pe={title:k.title||"Untitled Book",subtitle:k.subtitle||"",author:k.author||"Unknown",translator:k.translator||"",tagline:k.tagline||"",category:k.category||"General",language:k.language||"Bangla",audioUrl:k.audioUrl||"",summaryMdUrl:$||"",summaryMdPath:F||"",summaryFilename:((ue=k.summaryFile)==null?void 0:ue.name)||"",fullBookMdUrl:W||"",fullBookMdPath:K||"",fullBookFilename:((Se=k.fullBookFile)==null?void 0:Se.name)||"",pdfUrl:Z||(k.pdfDriveUrl?Iw(k.pdfDriveUrl):""),pdfPath:Y||"",pdfFilename:((Je=k.pdfFile)==null?void 0:Je.name)||(k.pdfDriveUrl?"Google Drive PDF":""),pdfDriveUrl:k.pdfDriveUrl||"",coverUrl:oe||"",coverPath:we||"",summarySnippet:(k.summaryText||"").slice(0,280),totalWords:k.totalWords||0,estimatedMinutes:k.estimatedMinutes||1,hasSummary:!!$,hasFullBook:!!W,hasPdf:!!Z||!!k.pdfDriveUrl,slug:P,createdAt:dD(),publishedAtIso:A};let ke="Firestore",be=`book_${Date.now()}`;try{be=(await hD($d(xu,"books"),pe)).id}catch(ee){if(console.warn("Firestore write error:",ee),ee.code==="permission-denied"||(Rt=ee.message)!=null&&Rt.toLowerCase().includes("permissions")){v(!0);try{await Dp(ef(rf,`books/${be}`),{...pe,id:be,createdAt:A}),ke="Realtime Database"}catch{const nt=JSON.parse(localStorage.getItem("audio_books_cache")||"[]");nt.unshift({...pe,id:be,createdAt:A,isOfflineSaved:!0}),localStorage.setItem("audio_books_cache",JSON.stringify(nt)),ke="Local Storage (Pending Rules)"}}else throw ee}if(ke==="Firestore")try{await Dp(ef(rf,`books/${be}`),{...pe,id:be,createdAt:A})}catch{}C(100),R("Upload Complete!"),s5({particleCount:80,spread:70,origin:{y:.6}}),U({type:"info",title:"Book Published to Firebase!",message:`"${k.title}" files uploaded to Storage and linked in Firestore.`}),r(null),await y(),e("library")}catch(P){console.error("Failed to upload book:",P),(P.code==="storage/unauthorized"||P.code==="permission-denied"||(H=P.message)!=null&&H.toLowerCase().includes("permissions")||(re=P.message)!=null&&re.toLowerCase().includes("unauthorized"))&&v(!0),U({type:"error",title:"Upload Failed",message:P.message||"Firebase error. Please ensure rules allow access."})}finally{N(!1)}},b=async k=>{if(window.confirm(`Are you sure you want to delete "${k.title}" from Firebase?`))try{await cD(p1(xu,"books",k.id));try{await o4(ef(rf,`books/${k.id}`))}catch{}const S=[k.summaryMdPath,k.fullBookMdPath,k.pdfPath,k.coverPath].filter(Boolean);for(const ue of S)try{await kO(I0(Tw,ue))}catch(Se){console.warn("Could not delete storage file:",ue,Se)}try{const Se=JSON.parse(localStorage.getItem("audio_books_cache")||"[]").filter(Je=>Je.id!==k.id);localStorage.setItem("audio_books_cache",JSON.stringify(Se))}catch{}s(ue=>ue.filter(Se=>Se.id!==k.id)),U({type:"info",title:"Book Deleted",message:"The book record and associated files were removed from Firebase."})}catch(S){console.error("Delete error:",S),U({type:"error",title:"Delete Failed",message:S.message})}};return m.jsxs("div",{style:{minHeight:"100vh",display:"flex",flexDirection:"column"},children:[m.jsx(i5,{toasts:M,onDismiss:E}),m.jsx(r5,{isOpen:g,onClose:()=>v(!1)}),m.jsx(gV,{activeTab:t,setActiveTab:e,bookCount:i.length,courseCount:u.length,onOpenRules:()=>v(!0)}),m.jsx("main",{style:{flex:1,padding:"2rem 1.5rem"},children:t==="upload"?n?m.jsx(e5,{bookData:n,onCancel:()=>r(null),onUpload:x,isUploading:I,uploadProgress:D,uploadStage:w}):m.jsx(wV,{onParsedBook:r,onShowToast:U}):t==="library"?m.jsx(t5,{books:i,loading:o,onRefresh:y,onDeleteBook:b}):m.jsx(n5,{courses:u,loading:h,onRefresh:T})}),m.jsx("footer",{style:{padding:"1.5rem",textAlign:"center",borderTop:"1px solid rgba(255, 255, 255, 0.06)",color:"#64748b",fontSize:"0.82rem"},children:m.jsxs("div",{children:["AudioBook Studio • Firebase Markdown Uploader • Connected to project ",m.jsx("strong",{children:"book-store-bec15"})]})})]})}sf.createRoot(document.getElementById("root")).render(m.jsx(jC.StrictMode,{children:m.jsx(o5,{})}));
