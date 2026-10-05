var mC=Object.defineProperty;var gC=(t,e,n)=>e in t?mC(t,e,{enumerable:!0,configurable:!0,writable:!0,value:n}):t[e]=n;var Pe=(t,e,n)=>gC(t,typeof e!="symbol"?e+"":e,n);(function(){const e=document.createElement("link").relList;if(e&&e.supports&&e.supports("modulepreload"))return;for(const i of document.querySelectorAll('link[rel="modulepreload"]'))r(i);new MutationObserver(i=>{for(const s of i)if(s.type==="childList")for(const o of s.addedNodes)o.tagName==="LINK"&&o.rel==="modulepreload"&&r(o)}).observe(document,{childList:!0,subtree:!0});function n(i){const s={};return i.integrity&&(s.integrity=i.integrity),i.referrerPolicy&&(s.referrerPolicy=i.referrerPolicy),i.crossOrigin==="use-credentials"?s.credentials="include":i.crossOrigin==="anonymous"?s.credentials="omit":s.credentials="same-origin",s}function r(i){if(i.ep)return;i.ep=!0;const s=n(i);fetch(i.href,s)}})();function _C(t){return t&&t.__esModule&&Object.prototype.hasOwnProperty.call(t,"default")?t.default:t}var kw={exports:{}},Xc={},Cw={exports:{}},ce={};/**
 * @license React
 * react.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var fl=Symbol.for("react.element"),yC=Symbol.for("react.portal"),vC=Symbol.for("react.fragment"),wC=Symbol.for("react.strict_mode"),EC=Symbol.for("react.profiler"),TC=Symbol.for("react.provider"),IC=Symbol.for("react.context"),SC=Symbol.for("react.forward_ref"),kC=Symbol.for("react.suspense"),CC=Symbol.for("react.memo"),RC=Symbol.for("react.lazy"),ry=Symbol.iterator;function xC(t){return t===null||typeof t!="object"?null:(t=ry&&t[ry]||t["@@iterator"],typeof t=="function"?t:null)}var Rw={isMounted:function(){return!1},enqueueForceUpdate:function(){},enqueueReplaceState:function(){},enqueueSetState:function(){}},xw=Object.assign,Aw={};function fo(t,e,n){this.props=t,this.context=e,this.refs=Aw,this.updater=n||Rw}fo.prototype.isReactComponent={};fo.prototype.setState=function(t,e){if(typeof t!="object"&&typeof t!="function"&&t!=null)throw Error("setState(...): takes an object of state variables to update or a function which returns an object of state variables.");this.updater.enqueueSetState(this,t,e,"setState")};fo.prototype.forceUpdate=function(t){this.updater.enqueueForceUpdate(this,t,"forceUpdate")};function Pw(){}Pw.prototype=fo.prototype;function Lp(t,e,n){this.props=t,this.context=e,this.refs=Aw,this.updater=n||Rw}var Fp=Lp.prototype=new Pw;Fp.constructor=Lp;xw(Fp,fo.prototype);Fp.isPureReactComponent=!0;var iy=Array.isArray,bw=Object.prototype.hasOwnProperty,Vp={current:null},Nw={key:!0,ref:!0,__self:!0,__source:!0};function Dw(t,e,n){var r,i={},s=null,o=null;if(e!=null)for(r in e.ref!==void 0&&(o=e.ref),e.key!==void 0&&(s=""+e.key),e)bw.call(e,r)&&!Nw.hasOwnProperty(r)&&(i[r]=e[r]);var a=arguments.length-2;if(a===1)i.children=n;else if(1<a){for(var u=Array(a),c=0;c<a;c++)u[c]=arguments[c+2];i.children=u}if(t&&t.defaultProps)for(r in a=t.defaultProps,a)i[r]===void 0&&(i[r]=a[r]);return{$$typeof:fl,type:t,key:s,ref:o,props:i,_owner:Vp.current}}function AC(t,e){return{$$typeof:fl,type:t.type,key:e,ref:t.ref,props:t.props,_owner:t._owner}}function Up(t){return typeof t=="object"&&t!==null&&t.$$typeof===fl}function PC(t){var e={"=":"=0",":":"=2"};return"$"+t.replace(/[=:]/g,function(n){return e[n]})}var sy=/\/+/g;function od(t,e){return typeof t=="object"&&t!==null&&t.key!=null?PC(""+t.key):e.toString(36)}function xu(t,e,n,r,i){var s=typeof t;(s==="undefined"||s==="boolean")&&(t=null);var o=!1;if(t===null)o=!0;else switch(s){case"string":case"number":o=!0;break;case"object":switch(t.$$typeof){case fl:case yC:o=!0}}if(o)return o=t,i=i(o),t=r===""?"."+od(o,0):r,iy(i)?(n="",t!=null&&(n=t.replace(sy,"$&/")+"/"),xu(i,e,n,"",function(c){return c})):i!=null&&(Up(i)&&(i=AC(i,n+(!i.key||o&&o.key===i.key?"":(""+i.key).replace(sy,"$&/")+"/")+t)),e.push(i)),1;if(o=0,r=r===""?".":r+":",iy(t))for(var a=0;a<t.length;a++){s=t[a];var u=r+od(s,a);o+=xu(s,e,n,u,i)}else if(u=xC(t),typeof u=="function")for(t=u.call(t),a=0;!(s=t.next()).done;)s=s.value,u=r+od(s,a++),o+=xu(s,e,n,u,i);else if(s==="object")throw e=String(t),Error("Objects are not valid as a React child (found: "+(e==="[object Object]"?"object with keys {"+Object.keys(t).join(", ")+"}":e)+"). If you meant to render a collection of children, use an array instead.");return o}function eu(t,e,n){if(t==null)return t;var r=[],i=0;return xu(t,r,"","",function(s){return e.call(n,s,i++)}),r}function bC(t){if(t._status===-1){var e=t._result;e=e(),e.then(function(n){(t._status===0||t._status===-1)&&(t._status=1,t._result=n)},function(n){(t._status===0||t._status===-1)&&(t._status=2,t._result=n)}),t._status===-1&&(t._status=0,t._result=e)}if(t._status===1)return t._result.default;throw t._result}var Wt={current:null},Au={transition:null},NC={ReactCurrentDispatcher:Wt,ReactCurrentBatchConfig:Au,ReactCurrentOwner:Vp};function Ow(){throw Error("act(...) is not supported in production builds of React.")}ce.Children={map:eu,forEach:function(t,e,n){eu(t,function(){e.apply(this,arguments)},n)},count:function(t){var e=0;return eu(t,function(){e++}),e},toArray:function(t){return eu(t,function(e){return e})||[]},only:function(t){if(!Up(t))throw Error("React.Children.only expected to receive a single React element child.");return t}};ce.Component=fo;ce.Fragment=vC;ce.Profiler=EC;ce.PureComponent=Lp;ce.StrictMode=wC;ce.Suspense=kC;ce.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=NC;ce.act=Ow;ce.cloneElement=function(t,e,n){if(t==null)throw Error("React.cloneElement(...): The argument must be a React element, but you passed "+t+".");var r=xw({},t.props),i=t.key,s=t.ref,o=t._owner;if(e!=null){if(e.ref!==void 0&&(s=e.ref,o=Vp.current),e.key!==void 0&&(i=""+e.key),t.type&&t.type.defaultProps)var a=t.type.defaultProps;for(u in e)bw.call(e,u)&&!Nw.hasOwnProperty(u)&&(r[u]=e[u]===void 0&&a!==void 0?a[u]:e[u])}var u=arguments.length-2;if(u===1)r.children=n;else if(1<u){a=Array(u);for(var c=0;c<u;c++)a[c]=arguments[c+2];r.children=a}return{$$typeof:fl,type:t.type,key:i,ref:s,props:r,_owner:o}};ce.createContext=function(t){return t={$$typeof:IC,_currentValue:t,_currentValue2:t,_threadCount:0,Provider:null,Consumer:null,_defaultValue:null,_globalName:null},t.Provider={$$typeof:TC,_context:t},t.Consumer=t};ce.createElement=Dw;ce.createFactory=function(t){var e=Dw.bind(null,t);return e.type=t,e};ce.createRef=function(){return{current:null}};ce.forwardRef=function(t){return{$$typeof:SC,render:t}};ce.isValidElement=Up;ce.lazy=function(t){return{$$typeof:RC,_payload:{_status:-1,_result:t},_init:bC}};ce.memo=function(t,e){return{$$typeof:CC,type:t,compare:e===void 0?null:e}};ce.startTransition=function(t){var e=Au.transition;Au.transition={};try{t()}finally{Au.transition=e}};ce.unstable_act=Ow;ce.useCallback=function(t,e){return Wt.current.useCallback(t,e)};ce.useContext=function(t){return Wt.current.useContext(t)};ce.useDebugValue=function(){};ce.useDeferredValue=function(t){return Wt.current.useDeferredValue(t)};ce.useEffect=function(t,e){return Wt.current.useEffect(t,e)};ce.useId=function(){return Wt.current.useId()};ce.useImperativeHandle=function(t,e,n){return Wt.current.useImperativeHandle(t,e,n)};ce.useInsertionEffect=function(t,e){return Wt.current.useInsertionEffect(t,e)};ce.useLayoutEffect=function(t,e){return Wt.current.useLayoutEffect(t,e)};ce.useMemo=function(t,e){return Wt.current.useMemo(t,e)};ce.useReducer=function(t,e,n){return Wt.current.useReducer(t,e,n)};ce.useRef=function(t){return Wt.current.useRef(t)};ce.useState=function(t){return Wt.current.useState(t)};ce.useSyncExternalStore=function(t,e,n){return Wt.current.useSyncExternalStore(t,e,n)};ce.useTransition=function(){return Wt.current.useTransition()};ce.version="18.3.1";Cw.exports=ce;var ie=Cw.exports;const DC=_C(ie);/**
 * @license React
 * react-jsx-runtime.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var OC=ie,MC=Symbol.for("react.element"),LC=Symbol.for("react.fragment"),FC=Object.prototype.hasOwnProperty,VC=OC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED.ReactCurrentOwner,UC={key:!0,ref:!0,__self:!0,__source:!0};function Mw(t,e,n){var r,i={},s=null,o=null;n!==void 0&&(s=""+n),e.key!==void 0&&(s=""+e.key),e.ref!==void 0&&(o=e.ref);for(r in e)FC.call(e,r)&&!UC.hasOwnProperty(r)&&(i[r]=e[r]);if(t&&t.defaultProps)for(r in e=t.defaultProps,e)i[r]===void 0&&(i[r]=e[r]);return{$$typeof:MC,type:t,key:s,ref:o,props:i,_owner:VC.current}}Xc.Fragment=LC;Xc.jsx=Mw;Xc.jsxs=Mw;kw.exports=Xc;var g=kw.exports,nf={},Lw={exports:{}},cn={},Fw={exports:{}},Vw={};/**
 * @license React
 * scheduler.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */(function(t){function e(H,te){var N=H.length;H.push(te);e:for(;0<N;){var x=N-1>>>1,$=H[x];if(0<i($,te))H[x]=te,H[N]=$,N=x;else break e}}function n(H){return H.length===0?null:H[0]}function r(H){if(H.length===0)return null;var te=H[0],N=H.pop();if(N!==te){H[0]=N;e:for(var x=0,$=H.length,F=$>>>1;x<F;){var W=2*(x+1)-1,K=H[W],Z=W+1,Y=H[Z];if(0>i(K,N))Z<$&&0>i(Y,K)?(H[x]=Y,H[Z]=N,x=Z):(H[x]=K,H[W]=N,x=W);else if(Z<$&&0>i(Y,N))H[x]=Y,H[Z]=N,x=Z;else break e}}return te}function i(H,te){var N=H.sortIndex-te.sortIndex;return N!==0?N:H.id-te.id}if(typeof performance=="object"&&typeof performance.now=="function"){var s=performance;t.unstable_now=function(){return s.now()}}else{var o=Date,a=o.now();t.unstable_now=function(){return o.now()-a}}var u=[],c=[],h=1,f=null,m=3,w=!1,S=!1,P=!1,D=typeof setTimeout=="function"?setTimeout:null,k=typeof clearTimeout=="function"?clearTimeout:null,T=typeof setImmediate<"u"?setImmediate:null;typeof navigator<"u"&&navigator.scheduling!==void 0&&navigator.scheduling.isInputPending!==void 0&&navigator.scheduling.isInputPending.bind(navigator.scheduling);function R(H){for(var te=n(c);te!==null;){if(te.callback===null)r(c);else if(te.startTime<=H)r(c),te.sortIndex=te.expirationTime,e(u,te);else break;te=n(c)}}function M(H){if(P=!1,R(H),!S)if(n(u)!==null)S=!0,Ut(z);else{var te=n(c);te!==null&&gt(M,te.startTime-H)}}function z(H,te){S=!1,P&&(P=!1,k(_),_=-1),w=!0;var N=m;try{for(R(te),f=n(u);f!==null&&(!(f.expirationTime>te)||H&&!A());){var x=f.callback;if(typeof x=="function"){f.callback=null,m=f.priorityLevel;var $=x(f.expirationTime<=te);te=t.unstable_now(),typeof $=="function"?f.callback=$:f===n(u)&&r(u),R(te)}else r(u);f=n(u)}if(f!==null)var F=!0;else{var W=n(c);W!==null&&gt(M,W.startTime-te),F=!1}return F}finally{f=null,m=N,w=!1}}var U=!1,v=null,_=-1,E=5,I=-1;function A(){return!(t.unstable_now()-I<E)}function b(){if(v!==null){var H=t.unstable_now();I=H;var te=!0;try{te=v(!0,H)}finally{te?C():(U=!1,v=null)}}else U=!1}var C;if(typeof T=="function")C=function(){T(b)};else if(typeof MessageChannel<"u"){var Xe=new MessageChannel,Ne=Xe.port2;Xe.port1.onmessage=b,C=function(){Ne.postMessage(null)}}else C=function(){D(b,0)};function Ut(H){v=H,U||(U=!0,C())}function gt(H,te){_=D(function(){H(t.unstable_now())},te)}t.unstable_IdlePriority=5,t.unstable_ImmediatePriority=1,t.unstable_LowPriority=4,t.unstable_NormalPriority=3,t.unstable_Profiling=null,t.unstable_UserBlockingPriority=2,t.unstable_cancelCallback=function(H){H.callback=null},t.unstable_continueExecution=function(){S||w||(S=!0,Ut(z))},t.unstable_forceFrameRate=function(H){0>H||125<H?console.error("forceFrameRate takes a positive int between 0 and 125, forcing frame rates higher than 125 fps is not supported"):E=0<H?Math.floor(1e3/H):5},t.unstable_getCurrentPriorityLevel=function(){return m},t.unstable_getFirstCallbackNode=function(){return n(u)},t.unstable_next=function(H){switch(m){case 1:case 2:case 3:var te=3;break;default:te=m}var N=m;m=te;try{return H()}finally{m=N}},t.unstable_pauseExecution=function(){},t.unstable_requestPaint=function(){},t.unstable_runWithPriority=function(H,te){switch(H){case 1:case 2:case 3:case 4:case 5:break;default:H=3}var N=m;m=H;try{return te()}finally{m=N}},t.unstable_scheduleCallback=function(H,te,N){var x=t.unstable_now();switch(typeof N=="object"&&N!==null?(N=N.delay,N=typeof N=="number"&&0<N?x+N:x):N=x,H){case 1:var $=-1;break;case 2:$=250;break;case 5:$=1073741823;break;case 4:$=1e4;break;default:$=5e3}return $=N+$,H={id:h++,callback:te,priorityLevel:H,startTime:N,expirationTime:$,sortIndex:-1},N>x?(H.sortIndex=N,e(c,H),n(u)===null&&H===n(c)&&(P?(k(_),_=-1):P=!0,gt(M,N-x))):(H.sortIndex=$,e(u,H),S||w||(S=!0,Ut(z))),H},t.unstable_shouldYield=A,t.unstable_wrapCallback=function(H){var te=m;return function(){var N=m;m=te;try{return H.apply(this,arguments)}finally{m=N}}}})(Vw);Fw.exports=Vw;var jC=Fw.exports;/**
 * @license React
 * react-dom.production.min.js
 *
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */var zC=ie,un=jC;function B(t){for(var e="https://reactjs.org/docs/error-decoder.html?invariant="+t,n=1;n<arguments.length;n++)e+="&args[]="+encodeURIComponent(arguments[n]);return"Minified React error #"+t+"; visit "+e+" for the full message or use the non-minified dev environment for full errors and additional helpful warnings."}var Uw=new Set,La={};function Zi(t,e){Ks(t,e),Ks(t+"Capture",e)}function Ks(t,e){for(La[t]=e,t=0;t<e.length;t++)Uw.add(e[t])}var mr=!(typeof window>"u"||typeof window.document>"u"||typeof window.document.createElement>"u"),rf=Object.prototype.hasOwnProperty,BC=/^[:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD][:A-Z_a-z\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD\-.0-9\u00B7\u0300-\u036F\u203F-\u2040]*$/,oy={},ay={};function $C(t){return rf.call(ay,t)?!0:rf.call(oy,t)?!1:BC.test(t)?ay[t]=!0:(oy[t]=!0,!1)}function WC(t,e,n,r){if(n!==null&&n.type===0)return!1;switch(typeof e){case"function":case"symbol":return!0;case"boolean":return r?!1:n!==null?!n.acceptsBooleans:(t=t.toLowerCase().slice(0,5),t!=="data-"&&t!=="aria-");default:return!1}}function qC(t,e,n,r){if(e===null||typeof e>"u"||WC(t,e,n,r))return!0;if(r)return!1;if(n!==null)switch(n.type){case 3:return!e;case 4:return e===!1;case 5:return isNaN(e);case 6:return isNaN(e)||1>e}return!1}function qt(t,e,n,r,i,s,o){this.acceptsBooleans=e===2||e===3||e===4,this.attributeName=r,this.attributeNamespace=i,this.mustUseProperty=n,this.propertyName=t,this.type=e,this.sanitizeURL=s,this.removeEmptyString=o}var kt={};"children dangerouslySetInnerHTML defaultValue defaultChecked innerHTML suppressContentEditableWarning suppressHydrationWarning style".split(" ").forEach(function(t){kt[t]=new qt(t,0,!1,t,null,!1,!1)});[["acceptCharset","accept-charset"],["className","class"],["htmlFor","for"],["httpEquiv","http-equiv"]].forEach(function(t){var e=t[0];kt[e]=new qt(e,1,!1,t[1],null,!1,!1)});["contentEditable","draggable","spellCheck","value"].forEach(function(t){kt[t]=new qt(t,2,!1,t.toLowerCase(),null,!1,!1)});["autoReverse","externalResourcesRequired","focusable","preserveAlpha"].forEach(function(t){kt[t]=new qt(t,2,!1,t,null,!1,!1)});"allowFullScreen async autoFocus autoPlay controls default defer disabled disablePictureInPicture disableRemotePlayback formNoValidate hidden loop noModule noValidate open playsInline readOnly required reversed scoped seamless itemScope".split(" ").forEach(function(t){kt[t]=new qt(t,3,!1,t.toLowerCase(),null,!1,!1)});["checked","multiple","muted","selected"].forEach(function(t){kt[t]=new qt(t,3,!0,t,null,!1,!1)});["capture","download"].forEach(function(t){kt[t]=new qt(t,4,!1,t,null,!1,!1)});["cols","rows","size","span"].forEach(function(t){kt[t]=new qt(t,6,!1,t,null,!1,!1)});["rowSpan","start"].forEach(function(t){kt[t]=new qt(t,5,!1,t.toLowerCase(),null,!1,!1)});var jp=/[\-:]([a-z])/g;function zp(t){return t[1].toUpperCase()}"accent-height alignment-baseline arabic-form baseline-shift cap-height clip-path clip-rule color-interpolation color-interpolation-filters color-profile color-rendering dominant-baseline enable-background fill-opacity fill-rule flood-color flood-opacity font-family font-size font-size-adjust font-stretch font-style font-variant font-weight glyph-name glyph-orientation-horizontal glyph-orientation-vertical horiz-adv-x horiz-origin-x image-rendering letter-spacing lighting-color marker-end marker-mid marker-start overline-position overline-thickness paint-order panose-1 pointer-events rendering-intent shape-rendering stop-color stop-opacity strikethrough-position strikethrough-thickness stroke-dasharray stroke-dashoffset stroke-linecap stroke-linejoin stroke-miterlimit stroke-opacity stroke-width text-anchor text-decoration text-rendering underline-position underline-thickness unicode-bidi unicode-range units-per-em v-alphabetic v-hanging v-ideographic v-mathematical vector-effect vert-adv-y vert-origin-x vert-origin-y word-spacing writing-mode xmlns:xlink x-height".split(" ").forEach(function(t){var e=t.replace(jp,zp);kt[e]=new qt(e,1,!1,t,null,!1,!1)});"xlink:actuate xlink:arcrole xlink:role xlink:show xlink:title xlink:type".split(" ").forEach(function(t){var e=t.replace(jp,zp);kt[e]=new qt(e,1,!1,t,"http://www.w3.org/1999/xlink",!1,!1)});["xml:base","xml:lang","xml:space"].forEach(function(t){var e=t.replace(jp,zp);kt[e]=new qt(e,1,!1,t,"http://www.w3.org/XML/1998/namespace",!1,!1)});["tabIndex","crossOrigin"].forEach(function(t){kt[t]=new qt(t,1,!1,t.toLowerCase(),null,!1,!1)});kt.xlinkHref=new qt("xlinkHref",1,!1,"xlink:href","http://www.w3.org/1999/xlink",!0,!1);["src","href","action","formAction"].forEach(function(t){kt[t]=new qt(t,1,!1,t.toLowerCase(),null,!0,!0)});function Bp(t,e,n,r){var i=kt.hasOwnProperty(e)?kt[e]:null;(i!==null?i.type!==0:r||!(2<e.length)||e[0]!=="o"&&e[0]!=="O"||e[1]!=="n"&&e[1]!=="N")&&(qC(e,n,i,r)&&(n=null),r||i===null?$C(e)&&(n===null?t.removeAttribute(e):t.setAttribute(e,""+n)):i.mustUseProperty?t[i.propertyName]=n===null?i.type===3?!1:"":n:(e=i.attributeName,r=i.attributeNamespace,n===null?t.removeAttribute(e):(i=i.type,n=i===3||i===4&&n===!0?"":""+n,r?t.setAttributeNS(r,e,n):t.setAttribute(e,n))))}var Rr=zC.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED,tu=Symbol.for("react.element"),ws=Symbol.for("react.portal"),Es=Symbol.for("react.fragment"),$p=Symbol.for("react.strict_mode"),sf=Symbol.for("react.profiler"),jw=Symbol.for("react.provider"),zw=Symbol.for("react.context"),Wp=Symbol.for("react.forward_ref"),of=Symbol.for("react.suspense"),af=Symbol.for("react.suspense_list"),qp=Symbol.for("react.memo"),Or=Symbol.for("react.lazy"),Bw=Symbol.for("react.offscreen"),ly=Symbol.iterator;function Wo(t){return t===null||typeof t!="object"?null:(t=ly&&t[ly]||t["@@iterator"],typeof t=="function"?t:null)}var He=Object.assign,ad;function oa(t){if(ad===void 0)try{throw Error()}catch(n){var e=n.stack.trim().match(/\n( *(at )?)/);ad=e&&e[1]||""}return`
`+ad+t}var ld=!1;function ud(t,e){if(!t||ld)return"";ld=!0;var n=Error.prepareStackTrace;Error.prepareStackTrace=void 0;try{if(e)if(e=function(){throw Error()},Object.defineProperty(e.prototype,"props",{set:function(){throw Error()}}),typeof Reflect=="object"&&Reflect.construct){try{Reflect.construct(e,[])}catch(c){var r=c}Reflect.construct(t,[],e)}else{try{e.call()}catch(c){r=c}t.call(e.prototype)}else{try{throw Error()}catch(c){r=c}t()}}catch(c){if(c&&r&&typeof c.stack=="string"){for(var i=c.stack.split(`
`),s=r.stack.split(`
`),o=i.length-1,a=s.length-1;1<=o&&0<=a&&i[o]!==s[a];)a--;for(;1<=o&&0<=a;o--,a--)if(i[o]!==s[a]){if(o!==1||a!==1)do if(o--,a--,0>a||i[o]!==s[a]){var u=`
`+i[o].replace(" at new "," at ");return t.displayName&&u.includes("<anonymous>")&&(u=u.replace("<anonymous>",t.displayName)),u}while(1<=o&&0<=a);break}}}finally{ld=!1,Error.prepareStackTrace=n}return(t=t?t.displayName||t.name:"")?oa(t):""}function HC(t){switch(t.tag){case 5:return oa(t.type);case 16:return oa("Lazy");case 13:return oa("Suspense");case 19:return oa("SuspenseList");case 0:case 2:case 15:return t=ud(t.type,!1),t;case 11:return t=ud(t.type.render,!1),t;case 1:return t=ud(t.type,!0),t;default:return""}}function lf(t){if(t==null)return null;if(typeof t=="function")return t.displayName||t.name||null;if(typeof t=="string")return t;switch(t){case Es:return"Fragment";case ws:return"Portal";case sf:return"Profiler";case $p:return"StrictMode";case of:return"Suspense";case af:return"SuspenseList"}if(typeof t=="object")switch(t.$$typeof){case zw:return(t.displayName||"Context")+".Consumer";case jw:return(t._context.displayName||"Context")+".Provider";case Wp:var e=t.render;return t=t.displayName,t||(t=e.displayName||e.name||"",t=t!==""?"ForwardRef("+t+")":"ForwardRef"),t;case qp:return e=t.displayName||null,e!==null?e:lf(t.type)||"Memo";case Or:e=t._payload,t=t._init;try{return lf(t(e))}catch{}}return null}function GC(t){var e=t.type;switch(t.tag){case 24:return"Cache";case 9:return(e.displayName||"Context")+".Consumer";case 10:return(e._context.displayName||"Context")+".Provider";case 18:return"DehydratedFragment";case 11:return t=e.render,t=t.displayName||t.name||"",e.displayName||(t!==""?"ForwardRef("+t+")":"ForwardRef");case 7:return"Fragment";case 5:return e;case 4:return"Portal";case 3:return"Root";case 6:return"Text";case 16:return lf(e);case 8:return e===$p?"StrictMode":"Mode";case 22:return"Offscreen";case 12:return"Profiler";case 21:return"Scope";case 13:return"Suspense";case 19:return"SuspenseList";case 25:return"TracingMarker";case 1:case 0:case 17:case 2:case 14:case 15:if(typeof e=="function")return e.displayName||e.name||null;if(typeof e=="string")return e}return null}function ai(t){switch(typeof t){case"boolean":case"number":case"string":case"undefined":return t;case"object":return t;default:return""}}function $w(t){var e=t.type;return(t=t.nodeName)&&t.toLowerCase()==="input"&&(e==="checkbox"||e==="radio")}function KC(t){var e=$w(t)?"checked":"value",n=Object.getOwnPropertyDescriptor(t.constructor.prototype,e),r=""+t[e];if(!t.hasOwnProperty(e)&&typeof n<"u"&&typeof n.get=="function"&&typeof n.set=="function"){var i=n.get,s=n.set;return Object.defineProperty(t,e,{configurable:!0,get:function(){return i.call(this)},set:function(o){r=""+o,s.call(this,o)}}),Object.defineProperty(t,e,{enumerable:n.enumerable}),{getValue:function(){return r},setValue:function(o){r=""+o},stopTracking:function(){t._valueTracker=null,delete t[e]}}}}function nu(t){t._valueTracker||(t._valueTracker=KC(t))}function Ww(t){if(!t)return!1;var e=t._valueTracker;if(!e)return!0;var n=e.getValue(),r="";return t&&(r=$w(t)?t.checked?"true":"false":t.value),t=r,t!==n?(e.setValue(t),!0):!1}function Xu(t){if(t=t||(typeof document<"u"?document:void 0),typeof t>"u")return null;try{return t.activeElement||t.body}catch{return t.body}}function uf(t,e){var n=e.checked;return He({},e,{defaultChecked:void 0,defaultValue:void 0,value:void 0,checked:n??t._wrapperState.initialChecked})}function uy(t,e){var n=e.defaultValue==null?"":e.defaultValue,r=e.checked!=null?e.checked:e.defaultChecked;n=ai(e.value!=null?e.value:n),t._wrapperState={initialChecked:r,initialValue:n,controlled:e.type==="checkbox"||e.type==="radio"?e.checked!=null:e.value!=null}}function qw(t,e){e=e.checked,e!=null&&Bp(t,"checked",e,!1)}function cf(t,e){qw(t,e);var n=ai(e.value),r=e.type;if(n!=null)r==="number"?(n===0&&t.value===""||t.value!=n)&&(t.value=""+n):t.value!==""+n&&(t.value=""+n);else if(r==="submit"||r==="reset"){t.removeAttribute("value");return}e.hasOwnProperty("value")?hf(t,e.type,n):e.hasOwnProperty("defaultValue")&&hf(t,e.type,ai(e.defaultValue)),e.checked==null&&e.defaultChecked!=null&&(t.defaultChecked=!!e.defaultChecked)}function cy(t,e,n){if(e.hasOwnProperty("value")||e.hasOwnProperty("defaultValue")){var r=e.type;if(!(r!=="submit"&&r!=="reset"||e.value!==void 0&&e.value!==null))return;e=""+t._wrapperState.initialValue,n||e===t.value||(t.value=e),t.defaultValue=e}n=t.name,n!==""&&(t.name=""),t.defaultChecked=!!t._wrapperState.initialChecked,n!==""&&(t.name=n)}function hf(t,e,n){(e!=="number"||Xu(t.ownerDocument)!==t)&&(n==null?t.defaultValue=""+t._wrapperState.initialValue:t.defaultValue!==""+n&&(t.defaultValue=""+n))}var aa=Array.isArray;function Ms(t,e,n,r){if(t=t.options,e){e={};for(var i=0;i<n.length;i++)e["$"+n[i]]=!0;for(n=0;n<t.length;n++)i=e.hasOwnProperty("$"+t[n].value),t[n].selected!==i&&(t[n].selected=i),i&&r&&(t[n].defaultSelected=!0)}else{for(n=""+ai(n),e=null,i=0;i<t.length;i++){if(t[i].value===n){t[i].selected=!0,r&&(t[i].defaultSelected=!0);return}e!==null||t[i].disabled||(e=t[i])}e!==null&&(e.selected=!0)}}function df(t,e){if(e.dangerouslySetInnerHTML!=null)throw Error(B(91));return He({},e,{value:void 0,defaultValue:void 0,children:""+t._wrapperState.initialValue})}function hy(t,e){var n=e.value;if(n==null){if(n=e.children,e=e.defaultValue,n!=null){if(e!=null)throw Error(B(92));if(aa(n)){if(1<n.length)throw Error(B(93));n=n[0]}e=n}e==null&&(e=""),n=e}t._wrapperState={initialValue:ai(n)}}function Hw(t,e){var n=ai(e.value),r=ai(e.defaultValue);n!=null&&(n=""+n,n!==t.value&&(t.value=n),e.defaultValue==null&&t.defaultValue!==n&&(t.defaultValue=n)),r!=null&&(t.defaultValue=""+r)}function dy(t){var e=t.textContent;e===t._wrapperState.initialValue&&e!==""&&e!==null&&(t.value=e)}function Gw(t){switch(t){case"svg":return"http://www.w3.org/2000/svg";case"math":return"http://www.w3.org/1998/Math/MathML";default:return"http://www.w3.org/1999/xhtml"}}function ff(t,e){return t==null||t==="http://www.w3.org/1999/xhtml"?Gw(e):t==="http://www.w3.org/2000/svg"&&e==="foreignObject"?"http://www.w3.org/1999/xhtml":t}var ru,Kw=function(t){return typeof MSApp<"u"&&MSApp.execUnsafeLocalFunction?function(e,n,r,i){MSApp.execUnsafeLocalFunction(function(){return t(e,n,r,i)})}:t}(function(t,e){if(t.namespaceURI!=="http://www.w3.org/2000/svg"||"innerHTML"in t)t.innerHTML=e;else{for(ru=ru||document.createElement("div"),ru.innerHTML="<svg>"+e.valueOf().toString()+"</svg>",e=ru.firstChild;t.firstChild;)t.removeChild(t.firstChild);for(;e.firstChild;)t.appendChild(e.firstChild)}});function Fa(t,e){if(e){var n=t.firstChild;if(n&&n===t.lastChild&&n.nodeType===3){n.nodeValue=e;return}}t.textContent=e}var pa={animationIterationCount:!0,aspectRatio:!0,borderImageOutset:!0,borderImageSlice:!0,borderImageWidth:!0,boxFlex:!0,boxFlexGroup:!0,boxOrdinalGroup:!0,columnCount:!0,columns:!0,flex:!0,flexGrow:!0,flexPositive:!0,flexShrink:!0,flexNegative:!0,flexOrder:!0,gridArea:!0,gridRow:!0,gridRowEnd:!0,gridRowSpan:!0,gridRowStart:!0,gridColumn:!0,gridColumnEnd:!0,gridColumnSpan:!0,gridColumnStart:!0,fontWeight:!0,lineClamp:!0,lineHeight:!0,opacity:!0,order:!0,orphans:!0,tabSize:!0,widows:!0,zIndex:!0,zoom:!0,fillOpacity:!0,floodOpacity:!0,stopOpacity:!0,strokeDasharray:!0,strokeDashoffset:!0,strokeMiterlimit:!0,strokeOpacity:!0,strokeWidth:!0},QC=["Webkit","ms","Moz","O"];Object.keys(pa).forEach(function(t){QC.forEach(function(e){e=e+t.charAt(0).toUpperCase()+t.substring(1),pa[e]=pa[t]})});function Qw(t,e,n){return e==null||typeof e=="boolean"||e===""?"":n||typeof e!="number"||e===0||pa.hasOwnProperty(t)&&pa[t]?(""+e).trim():e+"px"}function Yw(t,e){t=t.style;for(var n in e)if(e.hasOwnProperty(n)){var r=n.indexOf("--")===0,i=Qw(n,e[n],r);n==="float"&&(n="cssFloat"),r?t.setProperty(n,i):t[n]=i}}var YC=He({menuitem:!0},{area:!0,base:!0,br:!0,col:!0,embed:!0,hr:!0,img:!0,input:!0,keygen:!0,link:!0,meta:!0,param:!0,source:!0,track:!0,wbr:!0});function pf(t,e){if(e){if(YC[t]&&(e.children!=null||e.dangerouslySetInnerHTML!=null))throw Error(B(137,t));if(e.dangerouslySetInnerHTML!=null){if(e.children!=null)throw Error(B(60));if(typeof e.dangerouslySetInnerHTML!="object"||!("__html"in e.dangerouslySetInnerHTML))throw Error(B(61))}if(e.style!=null&&typeof e.style!="object")throw Error(B(62))}}function mf(t,e){if(t.indexOf("-")===-1)return typeof e.is=="string";switch(t){case"annotation-xml":case"color-profile":case"font-face":case"font-face-src":case"font-face-uri":case"font-face-format":case"font-face-name":case"missing-glyph":return!1;default:return!0}}var gf=null;function Hp(t){return t=t.target||t.srcElement||window,t.correspondingUseElement&&(t=t.correspondingUseElement),t.nodeType===3?t.parentNode:t}var _f=null,Ls=null,Fs=null;function fy(t){if(t=gl(t)){if(typeof _f!="function")throw Error(B(280));var e=t.stateNode;e&&(e=nh(e),_f(t.stateNode,t.type,e))}}function Xw(t){Ls?Fs?Fs.push(t):Fs=[t]:Ls=t}function Jw(){if(Ls){var t=Ls,e=Fs;if(Fs=Ls=null,fy(t),e)for(t=0;t<e.length;t++)fy(e[t])}}function Zw(t,e){return t(e)}function eE(){}var cd=!1;function tE(t,e,n){if(cd)return t(e,n);cd=!0;try{return Zw(t,e,n)}finally{cd=!1,(Ls!==null||Fs!==null)&&(eE(),Jw())}}function Va(t,e){var n=t.stateNode;if(n===null)return null;var r=nh(n);if(r===null)return null;n=r[e];e:switch(e){case"onClick":case"onClickCapture":case"onDoubleClick":case"onDoubleClickCapture":case"onMouseDown":case"onMouseDownCapture":case"onMouseMove":case"onMouseMoveCapture":case"onMouseUp":case"onMouseUpCapture":case"onMouseEnter":(r=!r.disabled)||(t=t.type,r=!(t==="button"||t==="input"||t==="select"||t==="textarea")),t=!r;break e;default:t=!1}if(t)return null;if(n&&typeof n!="function")throw Error(B(231,e,typeof n));return n}var yf=!1;if(mr)try{var qo={};Object.defineProperty(qo,"passive",{get:function(){yf=!0}}),window.addEventListener("test",qo,qo),window.removeEventListener("test",qo,qo)}catch{yf=!1}function XC(t,e,n,r,i,s,o,a,u){var c=Array.prototype.slice.call(arguments,3);try{e.apply(n,c)}catch(h){this.onError(h)}}var ma=!1,Ju=null,Zu=!1,vf=null,JC={onError:function(t){ma=!0,Ju=t}};function ZC(t,e,n,r,i,s,o,a,u){ma=!1,Ju=null,XC.apply(JC,arguments)}function eR(t,e,n,r,i,s,o,a,u){if(ZC.apply(this,arguments),ma){if(ma){var c=Ju;ma=!1,Ju=null}else throw Error(B(198));Zu||(Zu=!0,vf=c)}}function es(t){var e=t,n=t;if(t.alternate)for(;e.return;)e=e.return;else{t=e;do e=t,e.flags&4098&&(n=e.return),t=e.return;while(t)}return e.tag===3?n:null}function nE(t){if(t.tag===13){var e=t.memoizedState;if(e===null&&(t=t.alternate,t!==null&&(e=t.memoizedState)),e!==null)return e.dehydrated}return null}function py(t){if(es(t)!==t)throw Error(B(188))}function tR(t){var e=t.alternate;if(!e){if(e=es(t),e===null)throw Error(B(188));return e!==t?null:t}for(var n=t,r=e;;){var i=n.return;if(i===null)break;var s=i.alternate;if(s===null){if(r=i.return,r!==null){n=r;continue}break}if(i.child===s.child){for(s=i.child;s;){if(s===n)return py(i),t;if(s===r)return py(i),e;s=s.sibling}throw Error(B(188))}if(n.return!==r.return)n=i,r=s;else{for(var o=!1,a=i.child;a;){if(a===n){o=!0,n=i,r=s;break}if(a===r){o=!0,r=i,n=s;break}a=a.sibling}if(!o){for(a=s.child;a;){if(a===n){o=!0,n=s,r=i;break}if(a===r){o=!0,r=s,n=i;break}a=a.sibling}if(!o)throw Error(B(189))}}if(n.alternate!==r)throw Error(B(190))}if(n.tag!==3)throw Error(B(188));return n.stateNode.current===n?t:e}function rE(t){return t=tR(t),t!==null?iE(t):null}function iE(t){if(t.tag===5||t.tag===6)return t;for(t=t.child;t!==null;){var e=iE(t);if(e!==null)return e;t=t.sibling}return null}var sE=un.unstable_scheduleCallback,my=un.unstable_cancelCallback,nR=un.unstable_shouldYield,rR=un.unstable_requestPaint,Ze=un.unstable_now,iR=un.unstable_getCurrentPriorityLevel,Gp=un.unstable_ImmediatePriority,oE=un.unstable_UserBlockingPriority,ec=un.unstable_NormalPriority,sR=un.unstable_LowPriority,aE=un.unstable_IdlePriority,Jc=null,qn=null;function oR(t){if(qn&&typeof qn.onCommitFiberRoot=="function")try{qn.onCommitFiberRoot(Jc,t,void 0,(t.current.flags&128)===128)}catch{}}var On=Math.clz32?Math.clz32:uR,aR=Math.log,lR=Math.LN2;function uR(t){return t>>>=0,t===0?32:31-(aR(t)/lR|0)|0}var iu=64,su=4194304;function la(t){switch(t&-t){case 1:return 1;case 2:return 2;case 4:return 4;case 8:return 8;case 16:return 16;case 32:return 32;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return t&4194240;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return t&130023424;case 134217728:return 134217728;case 268435456:return 268435456;case 536870912:return 536870912;case 1073741824:return 1073741824;default:return t}}function tc(t,e){var n=t.pendingLanes;if(n===0)return 0;var r=0,i=t.suspendedLanes,s=t.pingedLanes,o=n&268435455;if(o!==0){var a=o&~i;a!==0?r=la(a):(s&=o,s!==0&&(r=la(s)))}else o=n&~i,o!==0?r=la(o):s!==0&&(r=la(s));if(r===0)return 0;if(e!==0&&e!==r&&!(e&i)&&(i=r&-r,s=e&-e,i>=s||i===16&&(s&4194240)!==0))return e;if(r&4&&(r|=n&16),e=t.entangledLanes,e!==0)for(t=t.entanglements,e&=r;0<e;)n=31-On(e),i=1<<n,r|=t[n],e&=~i;return r}function cR(t,e){switch(t){case 1:case 2:case 4:return e+250;case 8:case 16:case 32:case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:return e+5e3;case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:return-1;case 134217728:case 268435456:case 536870912:case 1073741824:return-1;default:return-1}}function hR(t,e){for(var n=t.suspendedLanes,r=t.pingedLanes,i=t.expirationTimes,s=t.pendingLanes;0<s;){var o=31-On(s),a=1<<o,u=i[o];u===-1?(!(a&n)||a&r)&&(i[o]=cR(a,e)):u<=e&&(t.expiredLanes|=a),s&=~a}}function wf(t){return t=t.pendingLanes&-1073741825,t!==0?t:t&1073741824?1073741824:0}function lE(){var t=iu;return iu<<=1,!(iu&4194240)&&(iu=64),t}function hd(t){for(var e=[],n=0;31>n;n++)e.push(t);return e}function pl(t,e,n){t.pendingLanes|=e,e!==536870912&&(t.suspendedLanes=0,t.pingedLanes=0),t=t.eventTimes,e=31-On(e),t[e]=n}function dR(t,e){var n=t.pendingLanes&~e;t.pendingLanes=e,t.suspendedLanes=0,t.pingedLanes=0,t.expiredLanes&=e,t.mutableReadLanes&=e,t.entangledLanes&=e,e=t.entanglements;var r=t.eventTimes;for(t=t.expirationTimes;0<n;){var i=31-On(n),s=1<<i;e[i]=0,r[i]=-1,t[i]=-1,n&=~s}}function Kp(t,e){var n=t.entangledLanes|=e;for(t=t.entanglements;n;){var r=31-On(n),i=1<<r;i&e|t[r]&e&&(t[r]|=e),n&=~i}}var Se=0;function uE(t){return t&=-t,1<t?4<t?t&268435455?16:536870912:4:1}var cE,Qp,hE,dE,fE,Ef=!1,ou=[],Hr=null,Gr=null,Kr=null,Ua=new Map,ja=new Map,Lr=[],fR="mousedown mouseup touchcancel touchend touchstart auxclick dblclick pointercancel pointerdown pointerup dragend dragstart drop compositionend compositionstart keydown keypress keyup input textInput copy cut paste click change contextmenu reset submit".split(" ");function gy(t,e){switch(t){case"focusin":case"focusout":Hr=null;break;case"dragenter":case"dragleave":Gr=null;break;case"mouseover":case"mouseout":Kr=null;break;case"pointerover":case"pointerout":Ua.delete(e.pointerId);break;case"gotpointercapture":case"lostpointercapture":ja.delete(e.pointerId)}}function Ho(t,e,n,r,i,s){return t===null||t.nativeEvent!==s?(t={blockedOn:e,domEventName:n,eventSystemFlags:r,nativeEvent:s,targetContainers:[i]},e!==null&&(e=gl(e),e!==null&&Qp(e)),t):(t.eventSystemFlags|=r,e=t.targetContainers,i!==null&&e.indexOf(i)===-1&&e.push(i),t)}function pR(t,e,n,r,i){switch(e){case"focusin":return Hr=Ho(Hr,t,e,n,r,i),!0;case"dragenter":return Gr=Ho(Gr,t,e,n,r,i),!0;case"mouseover":return Kr=Ho(Kr,t,e,n,r,i),!0;case"pointerover":var s=i.pointerId;return Ua.set(s,Ho(Ua.get(s)||null,t,e,n,r,i)),!0;case"gotpointercapture":return s=i.pointerId,ja.set(s,Ho(ja.get(s)||null,t,e,n,r,i)),!0}return!1}function pE(t){var e=Ai(t.target);if(e!==null){var n=es(e);if(n!==null){if(e=n.tag,e===13){if(e=nE(n),e!==null){t.blockedOn=e,fE(t.priority,function(){hE(n)});return}}else if(e===3&&n.stateNode.current.memoizedState.isDehydrated){t.blockedOn=n.tag===3?n.stateNode.containerInfo:null;return}}}t.blockedOn=null}function Pu(t){if(t.blockedOn!==null)return!1;for(var e=t.targetContainers;0<e.length;){var n=Tf(t.domEventName,t.eventSystemFlags,e[0],t.nativeEvent);if(n===null){n=t.nativeEvent;var r=new n.constructor(n.type,n);gf=r,n.target.dispatchEvent(r),gf=null}else return e=gl(n),e!==null&&Qp(e),t.blockedOn=n,!1;e.shift()}return!0}function _y(t,e,n){Pu(t)&&n.delete(e)}function mR(){Ef=!1,Hr!==null&&Pu(Hr)&&(Hr=null),Gr!==null&&Pu(Gr)&&(Gr=null),Kr!==null&&Pu(Kr)&&(Kr=null),Ua.forEach(_y),ja.forEach(_y)}function Go(t,e){t.blockedOn===e&&(t.blockedOn=null,Ef||(Ef=!0,un.unstable_scheduleCallback(un.unstable_NormalPriority,mR)))}function za(t){function e(i){return Go(i,t)}if(0<ou.length){Go(ou[0],t);for(var n=1;n<ou.length;n++){var r=ou[n];r.blockedOn===t&&(r.blockedOn=null)}}for(Hr!==null&&Go(Hr,t),Gr!==null&&Go(Gr,t),Kr!==null&&Go(Kr,t),Ua.forEach(e),ja.forEach(e),n=0;n<Lr.length;n++)r=Lr[n],r.blockedOn===t&&(r.blockedOn=null);for(;0<Lr.length&&(n=Lr[0],n.blockedOn===null);)pE(n),n.blockedOn===null&&Lr.shift()}var Vs=Rr.ReactCurrentBatchConfig,nc=!0;function gR(t,e,n,r){var i=Se,s=Vs.transition;Vs.transition=null;try{Se=1,Yp(t,e,n,r)}finally{Se=i,Vs.transition=s}}function _R(t,e,n,r){var i=Se,s=Vs.transition;Vs.transition=null;try{Se=4,Yp(t,e,n,r)}finally{Se=i,Vs.transition=s}}function Yp(t,e,n,r){if(nc){var i=Tf(t,e,n,r);if(i===null)Ed(t,e,r,rc,n),gy(t,r);else if(pR(i,t,e,n,r))r.stopPropagation();else if(gy(t,r),e&4&&-1<fR.indexOf(t)){for(;i!==null;){var s=gl(i);if(s!==null&&cE(s),s=Tf(t,e,n,r),s===null&&Ed(t,e,r,rc,n),s===i)break;i=s}i!==null&&r.stopPropagation()}else Ed(t,e,r,null,n)}}var rc=null;function Tf(t,e,n,r){if(rc=null,t=Hp(r),t=Ai(t),t!==null)if(e=es(t),e===null)t=null;else if(n=e.tag,n===13){if(t=nE(e),t!==null)return t;t=null}else if(n===3){if(e.stateNode.current.memoizedState.isDehydrated)return e.tag===3?e.stateNode.containerInfo:null;t=null}else e!==t&&(t=null);return rc=t,null}function mE(t){switch(t){case"cancel":case"click":case"close":case"contextmenu":case"copy":case"cut":case"auxclick":case"dblclick":case"dragend":case"dragstart":case"drop":case"focusin":case"focusout":case"input":case"invalid":case"keydown":case"keypress":case"keyup":case"mousedown":case"mouseup":case"paste":case"pause":case"play":case"pointercancel":case"pointerdown":case"pointerup":case"ratechange":case"reset":case"resize":case"seeked":case"submit":case"touchcancel":case"touchend":case"touchstart":case"volumechange":case"change":case"selectionchange":case"textInput":case"compositionstart":case"compositionend":case"compositionupdate":case"beforeblur":case"afterblur":case"beforeinput":case"blur":case"fullscreenchange":case"focus":case"hashchange":case"popstate":case"select":case"selectstart":return 1;case"drag":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"mousemove":case"mouseout":case"mouseover":case"pointermove":case"pointerout":case"pointerover":case"scroll":case"toggle":case"touchmove":case"wheel":case"mouseenter":case"mouseleave":case"pointerenter":case"pointerleave":return 4;case"message":switch(iR()){case Gp:return 1;case oE:return 4;case ec:case sR:return 16;case aE:return 536870912;default:return 16}default:return 16}}var $r=null,Xp=null,bu=null;function gE(){if(bu)return bu;var t,e=Xp,n=e.length,r,i="value"in $r?$r.value:$r.textContent,s=i.length;for(t=0;t<n&&e[t]===i[t];t++);var o=n-t;for(r=1;r<=o&&e[n-r]===i[s-r];r++);return bu=i.slice(t,1<r?1-r:void 0)}function Nu(t){var e=t.keyCode;return"charCode"in t?(t=t.charCode,t===0&&e===13&&(t=13)):t=e,t===10&&(t=13),32<=t||t===13?t:0}function au(){return!0}function yy(){return!1}function hn(t){function e(n,r,i,s,o){this._reactName=n,this._targetInst=i,this.type=r,this.nativeEvent=s,this.target=o,this.currentTarget=null;for(var a in t)t.hasOwnProperty(a)&&(n=t[a],this[a]=n?n(s):s[a]);return this.isDefaultPrevented=(s.defaultPrevented!=null?s.defaultPrevented:s.returnValue===!1)?au:yy,this.isPropagationStopped=yy,this}return He(e.prototype,{preventDefault:function(){this.defaultPrevented=!0;var n=this.nativeEvent;n&&(n.preventDefault?n.preventDefault():typeof n.returnValue!="unknown"&&(n.returnValue=!1),this.isDefaultPrevented=au)},stopPropagation:function(){var n=this.nativeEvent;n&&(n.stopPropagation?n.stopPropagation():typeof n.cancelBubble!="unknown"&&(n.cancelBubble=!0),this.isPropagationStopped=au)},persist:function(){},isPersistent:au}),e}var po={eventPhase:0,bubbles:0,cancelable:0,timeStamp:function(t){return t.timeStamp||Date.now()},defaultPrevented:0,isTrusted:0},Jp=hn(po),ml=He({},po,{view:0,detail:0}),yR=hn(ml),dd,fd,Ko,Zc=He({},ml,{screenX:0,screenY:0,clientX:0,clientY:0,pageX:0,pageY:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,getModifierState:Zp,button:0,buttons:0,relatedTarget:function(t){return t.relatedTarget===void 0?t.fromElement===t.srcElement?t.toElement:t.fromElement:t.relatedTarget},movementX:function(t){return"movementX"in t?t.movementX:(t!==Ko&&(Ko&&t.type==="mousemove"?(dd=t.screenX-Ko.screenX,fd=t.screenY-Ko.screenY):fd=dd=0,Ko=t),dd)},movementY:function(t){return"movementY"in t?t.movementY:fd}}),vy=hn(Zc),vR=He({},Zc,{dataTransfer:0}),wR=hn(vR),ER=He({},ml,{relatedTarget:0}),pd=hn(ER),TR=He({},po,{animationName:0,elapsedTime:0,pseudoElement:0}),IR=hn(TR),SR=He({},po,{clipboardData:function(t){return"clipboardData"in t?t.clipboardData:window.clipboardData}}),kR=hn(SR),CR=He({},po,{data:0}),wy=hn(CR),RR={Esc:"Escape",Spacebar:" ",Left:"ArrowLeft",Up:"ArrowUp",Right:"ArrowRight",Down:"ArrowDown",Del:"Delete",Win:"OS",Menu:"ContextMenu",Apps:"ContextMenu",Scroll:"ScrollLock",MozPrintableKey:"Unidentified"},xR={8:"Backspace",9:"Tab",12:"Clear",13:"Enter",16:"Shift",17:"Control",18:"Alt",19:"Pause",20:"CapsLock",27:"Escape",32:" ",33:"PageUp",34:"PageDown",35:"End",36:"Home",37:"ArrowLeft",38:"ArrowUp",39:"ArrowRight",40:"ArrowDown",45:"Insert",46:"Delete",112:"F1",113:"F2",114:"F3",115:"F4",116:"F5",117:"F6",118:"F7",119:"F8",120:"F9",121:"F10",122:"F11",123:"F12",144:"NumLock",145:"ScrollLock",224:"Meta"},AR={Alt:"altKey",Control:"ctrlKey",Meta:"metaKey",Shift:"shiftKey"};function PR(t){var e=this.nativeEvent;return e.getModifierState?e.getModifierState(t):(t=AR[t])?!!e[t]:!1}function Zp(){return PR}var bR=He({},ml,{key:function(t){if(t.key){var e=RR[t.key]||t.key;if(e!=="Unidentified")return e}return t.type==="keypress"?(t=Nu(t),t===13?"Enter":String.fromCharCode(t)):t.type==="keydown"||t.type==="keyup"?xR[t.keyCode]||"Unidentified":""},code:0,location:0,ctrlKey:0,shiftKey:0,altKey:0,metaKey:0,repeat:0,locale:0,getModifierState:Zp,charCode:function(t){return t.type==="keypress"?Nu(t):0},keyCode:function(t){return t.type==="keydown"||t.type==="keyup"?t.keyCode:0},which:function(t){return t.type==="keypress"?Nu(t):t.type==="keydown"||t.type==="keyup"?t.keyCode:0}}),NR=hn(bR),DR=He({},Zc,{pointerId:0,width:0,height:0,pressure:0,tangentialPressure:0,tiltX:0,tiltY:0,twist:0,pointerType:0,isPrimary:0}),Ey=hn(DR),OR=He({},ml,{touches:0,targetTouches:0,changedTouches:0,altKey:0,metaKey:0,ctrlKey:0,shiftKey:0,getModifierState:Zp}),MR=hn(OR),LR=He({},po,{propertyName:0,elapsedTime:0,pseudoElement:0}),FR=hn(LR),VR=He({},Zc,{deltaX:function(t){return"deltaX"in t?t.deltaX:"wheelDeltaX"in t?-t.wheelDeltaX:0},deltaY:function(t){return"deltaY"in t?t.deltaY:"wheelDeltaY"in t?-t.wheelDeltaY:"wheelDelta"in t?-t.wheelDelta:0},deltaZ:0,deltaMode:0}),UR=hn(VR),jR=[9,13,27,32],em=mr&&"CompositionEvent"in window,ga=null;mr&&"documentMode"in document&&(ga=document.documentMode);var zR=mr&&"TextEvent"in window&&!ga,_E=mr&&(!em||ga&&8<ga&&11>=ga),Ty=" ",Iy=!1;function yE(t,e){switch(t){case"keyup":return jR.indexOf(e.keyCode)!==-1;case"keydown":return e.keyCode!==229;case"keypress":case"mousedown":case"focusout":return!0;default:return!1}}function vE(t){return t=t.detail,typeof t=="object"&&"data"in t?t.data:null}var Ts=!1;function BR(t,e){switch(t){case"compositionend":return vE(e);case"keypress":return e.which!==32?null:(Iy=!0,Ty);case"textInput":return t=e.data,t===Ty&&Iy?null:t;default:return null}}function $R(t,e){if(Ts)return t==="compositionend"||!em&&yE(t,e)?(t=gE(),bu=Xp=$r=null,Ts=!1,t):null;switch(t){case"paste":return null;case"keypress":if(!(e.ctrlKey||e.altKey||e.metaKey)||e.ctrlKey&&e.altKey){if(e.char&&1<e.char.length)return e.char;if(e.which)return String.fromCharCode(e.which)}return null;case"compositionend":return _E&&e.locale!=="ko"?null:e.data;default:return null}}var WR={color:!0,date:!0,datetime:!0,"datetime-local":!0,email:!0,month:!0,number:!0,password:!0,range:!0,search:!0,tel:!0,text:!0,time:!0,url:!0,week:!0};function Sy(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e==="input"?!!WR[t.type]:e==="textarea"}function wE(t,e,n,r){Xw(r),e=ic(e,"onChange"),0<e.length&&(n=new Jp("onChange","change",null,n,r),t.push({event:n,listeners:e}))}var _a=null,Ba=null;function qR(t){bE(t,0)}function eh(t){var e=ks(t);if(Ww(e))return t}function HR(t,e){if(t==="change")return e}var EE=!1;if(mr){var md;if(mr){var gd="oninput"in document;if(!gd){var ky=document.createElement("div");ky.setAttribute("oninput","return;"),gd=typeof ky.oninput=="function"}md=gd}else md=!1;EE=md&&(!document.documentMode||9<document.documentMode)}function Cy(){_a&&(_a.detachEvent("onpropertychange",TE),Ba=_a=null)}function TE(t){if(t.propertyName==="value"&&eh(Ba)){var e=[];wE(e,Ba,t,Hp(t)),tE(qR,e)}}function GR(t,e,n){t==="focusin"?(Cy(),_a=e,Ba=n,_a.attachEvent("onpropertychange",TE)):t==="focusout"&&Cy()}function KR(t){if(t==="selectionchange"||t==="keyup"||t==="keydown")return eh(Ba)}function QR(t,e){if(t==="click")return eh(e)}function YR(t,e){if(t==="input"||t==="change")return eh(e)}function XR(t,e){return t===e&&(t!==0||1/t===1/e)||t!==t&&e!==e}var Fn=typeof Object.is=="function"?Object.is:XR;function $a(t,e){if(Fn(t,e))return!0;if(typeof t!="object"||t===null||typeof e!="object"||e===null)return!1;var n=Object.keys(t),r=Object.keys(e);if(n.length!==r.length)return!1;for(r=0;r<n.length;r++){var i=n[r];if(!rf.call(e,i)||!Fn(t[i],e[i]))return!1}return!0}function Ry(t){for(;t&&t.firstChild;)t=t.firstChild;return t}function xy(t,e){var n=Ry(t);t=0;for(var r;n;){if(n.nodeType===3){if(r=t+n.textContent.length,t<=e&&r>=e)return{node:n,offset:e-t};t=r}e:{for(;n;){if(n.nextSibling){n=n.nextSibling;break e}n=n.parentNode}n=void 0}n=Ry(n)}}function IE(t,e){return t&&e?t===e?!0:t&&t.nodeType===3?!1:e&&e.nodeType===3?IE(t,e.parentNode):"contains"in t?t.contains(e):t.compareDocumentPosition?!!(t.compareDocumentPosition(e)&16):!1:!1}function SE(){for(var t=window,e=Xu();e instanceof t.HTMLIFrameElement;){try{var n=typeof e.contentWindow.location.href=="string"}catch{n=!1}if(n)t=e.contentWindow;else break;e=Xu(t.document)}return e}function tm(t){var e=t&&t.nodeName&&t.nodeName.toLowerCase();return e&&(e==="input"&&(t.type==="text"||t.type==="search"||t.type==="tel"||t.type==="url"||t.type==="password")||e==="textarea"||t.contentEditable==="true")}function JR(t){var e=SE(),n=t.focusedElem,r=t.selectionRange;if(e!==n&&n&&n.ownerDocument&&IE(n.ownerDocument.documentElement,n)){if(r!==null&&tm(n)){if(e=r.start,t=r.end,t===void 0&&(t=e),"selectionStart"in n)n.selectionStart=e,n.selectionEnd=Math.min(t,n.value.length);else if(t=(e=n.ownerDocument||document)&&e.defaultView||window,t.getSelection){t=t.getSelection();var i=n.textContent.length,s=Math.min(r.start,i);r=r.end===void 0?s:Math.min(r.end,i),!t.extend&&s>r&&(i=r,r=s,s=i),i=xy(n,s);var o=xy(n,r);i&&o&&(t.rangeCount!==1||t.anchorNode!==i.node||t.anchorOffset!==i.offset||t.focusNode!==o.node||t.focusOffset!==o.offset)&&(e=e.createRange(),e.setStart(i.node,i.offset),t.removeAllRanges(),s>r?(t.addRange(e),t.extend(o.node,o.offset)):(e.setEnd(o.node,o.offset),t.addRange(e)))}}for(e=[],t=n;t=t.parentNode;)t.nodeType===1&&e.push({element:t,left:t.scrollLeft,top:t.scrollTop});for(typeof n.focus=="function"&&n.focus(),n=0;n<e.length;n++)t=e[n],t.element.scrollLeft=t.left,t.element.scrollTop=t.top}}var ZR=mr&&"documentMode"in document&&11>=document.documentMode,Is=null,If=null,ya=null,Sf=!1;function Ay(t,e,n){var r=n.window===n?n.document:n.nodeType===9?n:n.ownerDocument;Sf||Is==null||Is!==Xu(r)||(r=Is,"selectionStart"in r&&tm(r)?r={start:r.selectionStart,end:r.selectionEnd}:(r=(r.ownerDocument&&r.ownerDocument.defaultView||window).getSelection(),r={anchorNode:r.anchorNode,anchorOffset:r.anchorOffset,focusNode:r.focusNode,focusOffset:r.focusOffset}),ya&&$a(ya,r)||(ya=r,r=ic(If,"onSelect"),0<r.length&&(e=new Jp("onSelect","select",null,e,n),t.push({event:e,listeners:r}),e.target=Is)))}function lu(t,e){var n={};return n[t.toLowerCase()]=e.toLowerCase(),n["Webkit"+t]="webkit"+e,n["Moz"+t]="moz"+e,n}var Ss={animationend:lu("Animation","AnimationEnd"),animationiteration:lu("Animation","AnimationIteration"),animationstart:lu("Animation","AnimationStart"),transitionend:lu("Transition","TransitionEnd")},_d={},kE={};mr&&(kE=document.createElement("div").style,"AnimationEvent"in window||(delete Ss.animationend.animation,delete Ss.animationiteration.animation,delete Ss.animationstart.animation),"TransitionEvent"in window||delete Ss.transitionend.transition);function th(t){if(_d[t])return _d[t];if(!Ss[t])return t;var e=Ss[t],n;for(n in e)if(e.hasOwnProperty(n)&&n in kE)return _d[t]=e[n];return t}var CE=th("animationend"),RE=th("animationiteration"),xE=th("animationstart"),AE=th("transitionend"),PE=new Map,Py="abort auxClick cancel canPlay canPlayThrough click close contextMenu copy cut drag dragEnd dragEnter dragExit dragLeave dragOver dragStart drop durationChange emptied encrypted ended error gotPointerCapture input invalid keyDown keyPress keyUp load loadedData loadedMetadata loadStart lostPointerCapture mouseDown mouseMove mouseOut mouseOver mouseUp paste pause play playing pointerCancel pointerDown pointerMove pointerOut pointerOver pointerUp progress rateChange reset resize seeked seeking stalled submit suspend timeUpdate touchCancel touchEnd touchStart volumeChange scroll toggle touchMove waiting wheel".split(" ");function mi(t,e){PE.set(t,e),Zi(e,[t])}for(var yd=0;yd<Py.length;yd++){var vd=Py[yd],ex=vd.toLowerCase(),tx=vd[0].toUpperCase()+vd.slice(1);mi(ex,"on"+tx)}mi(CE,"onAnimationEnd");mi(RE,"onAnimationIteration");mi(xE,"onAnimationStart");mi("dblclick","onDoubleClick");mi("focusin","onFocus");mi("focusout","onBlur");mi(AE,"onTransitionEnd");Ks("onMouseEnter",["mouseout","mouseover"]);Ks("onMouseLeave",["mouseout","mouseover"]);Ks("onPointerEnter",["pointerout","pointerover"]);Ks("onPointerLeave",["pointerout","pointerover"]);Zi("onChange","change click focusin focusout input keydown keyup selectionchange".split(" "));Zi("onSelect","focusout contextmenu dragend focusin keydown keyup mousedown mouseup selectionchange".split(" "));Zi("onBeforeInput",["compositionend","keypress","textInput","paste"]);Zi("onCompositionEnd","compositionend focusout keydown keypress keyup mousedown".split(" "));Zi("onCompositionStart","compositionstart focusout keydown keypress keyup mousedown".split(" "));Zi("onCompositionUpdate","compositionupdate focusout keydown keypress keyup mousedown".split(" "));var ua="abort canplay canplaythrough durationchange emptied encrypted ended error loadeddata loadedmetadata loadstart pause play playing progress ratechange resize seeked seeking stalled suspend timeupdate volumechange waiting".split(" "),nx=new Set("cancel close invalid load scroll toggle".split(" ").concat(ua));function by(t,e,n){var r=t.type||"unknown-event";t.currentTarget=n,eR(r,e,void 0,t),t.currentTarget=null}function bE(t,e){e=(e&4)!==0;for(var n=0;n<t.length;n++){var r=t[n],i=r.event;r=r.listeners;e:{var s=void 0;if(e)for(var o=r.length-1;0<=o;o--){var a=r[o],u=a.instance,c=a.currentTarget;if(a=a.listener,u!==s&&i.isPropagationStopped())break e;by(i,a,c),s=u}else for(o=0;o<r.length;o++){if(a=r[o],u=a.instance,c=a.currentTarget,a=a.listener,u!==s&&i.isPropagationStopped())break e;by(i,a,c),s=u}}}if(Zu)throw t=vf,Zu=!1,vf=null,t}function Me(t,e){var n=e[Af];n===void 0&&(n=e[Af]=new Set);var r=t+"__bubble";n.has(r)||(NE(e,t,2,!1),n.add(r))}function wd(t,e,n){var r=0;e&&(r|=4),NE(n,t,r,e)}var uu="_reactListening"+Math.random().toString(36).slice(2);function Wa(t){if(!t[uu]){t[uu]=!0,Uw.forEach(function(n){n!=="selectionchange"&&(nx.has(n)||wd(n,!1,t),wd(n,!0,t))});var e=t.nodeType===9?t:t.ownerDocument;e===null||e[uu]||(e[uu]=!0,wd("selectionchange",!1,e))}}function NE(t,e,n,r){switch(mE(e)){case 1:var i=gR;break;case 4:i=_R;break;default:i=Yp}n=i.bind(null,e,n,t),i=void 0,!yf||e!=="touchstart"&&e!=="touchmove"&&e!=="wheel"||(i=!0),r?i!==void 0?t.addEventListener(e,n,{capture:!0,passive:i}):t.addEventListener(e,n,!0):i!==void 0?t.addEventListener(e,n,{passive:i}):t.addEventListener(e,n,!1)}function Ed(t,e,n,r,i){var s=r;if(!(e&1)&&!(e&2)&&r!==null)e:for(;;){if(r===null)return;var o=r.tag;if(o===3||o===4){var a=r.stateNode.containerInfo;if(a===i||a.nodeType===8&&a.parentNode===i)break;if(o===4)for(o=r.return;o!==null;){var u=o.tag;if((u===3||u===4)&&(u=o.stateNode.containerInfo,u===i||u.nodeType===8&&u.parentNode===i))return;o=o.return}for(;a!==null;){if(o=Ai(a),o===null)return;if(u=o.tag,u===5||u===6){r=s=o;continue e}a=a.parentNode}}r=r.return}tE(function(){var c=s,h=Hp(n),f=[];e:{var m=PE.get(t);if(m!==void 0){var w=Jp,S=t;switch(t){case"keypress":if(Nu(n)===0)break e;case"keydown":case"keyup":w=NR;break;case"focusin":S="focus",w=pd;break;case"focusout":S="blur",w=pd;break;case"beforeblur":case"afterblur":w=pd;break;case"click":if(n.button===2)break e;case"auxclick":case"dblclick":case"mousedown":case"mousemove":case"mouseup":case"mouseout":case"mouseover":case"contextmenu":w=vy;break;case"drag":case"dragend":case"dragenter":case"dragexit":case"dragleave":case"dragover":case"dragstart":case"drop":w=wR;break;case"touchcancel":case"touchend":case"touchmove":case"touchstart":w=MR;break;case CE:case RE:case xE:w=IR;break;case AE:w=FR;break;case"scroll":w=yR;break;case"wheel":w=UR;break;case"copy":case"cut":case"paste":w=kR;break;case"gotpointercapture":case"lostpointercapture":case"pointercancel":case"pointerdown":case"pointermove":case"pointerout":case"pointerover":case"pointerup":w=Ey}var P=(e&4)!==0,D=!P&&t==="scroll",k=P?m!==null?m+"Capture":null:m;P=[];for(var T=c,R;T!==null;){R=T;var M=R.stateNode;if(R.tag===5&&M!==null&&(R=M,k!==null&&(M=Va(T,k),M!=null&&P.push(qa(T,M,R)))),D)break;T=T.return}0<P.length&&(m=new w(m,S,null,n,h),f.push({event:m,listeners:P}))}}if(!(e&7)){e:{if(m=t==="mouseover"||t==="pointerover",w=t==="mouseout"||t==="pointerout",m&&n!==gf&&(S=n.relatedTarget||n.fromElement)&&(Ai(S)||S[gr]))break e;if((w||m)&&(m=h.window===h?h:(m=h.ownerDocument)?m.defaultView||m.parentWindow:window,w?(S=n.relatedTarget||n.toElement,w=c,S=S?Ai(S):null,S!==null&&(D=es(S),S!==D||S.tag!==5&&S.tag!==6)&&(S=null)):(w=null,S=c),w!==S)){if(P=vy,M="onMouseLeave",k="onMouseEnter",T="mouse",(t==="pointerout"||t==="pointerover")&&(P=Ey,M="onPointerLeave",k="onPointerEnter",T="pointer"),D=w==null?m:ks(w),R=S==null?m:ks(S),m=new P(M,T+"leave",w,n,h),m.target=D,m.relatedTarget=R,M=null,Ai(h)===c&&(P=new P(k,T+"enter",S,n,h),P.target=R,P.relatedTarget=D,M=P),D=M,w&&S)t:{for(P=w,k=S,T=0,R=P;R;R=ps(R))T++;for(R=0,M=k;M;M=ps(M))R++;for(;0<T-R;)P=ps(P),T--;for(;0<R-T;)k=ps(k),R--;for(;T--;){if(P===k||k!==null&&P===k.alternate)break t;P=ps(P),k=ps(k)}P=null}else P=null;w!==null&&Ny(f,m,w,P,!1),S!==null&&D!==null&&Ny(f,D,S,P,!0)}}e:{if(m=c?ks(c):window,w=m.nodeName&&m.nodeName.toLowerCase(),w==="select"||w==="input"&&m.type==="file")var z=HR;else if(Sy(m))if(EE)z=YR;else{z=KR;var U=GR}else(w=m.nodeName)&&w.toLowerCase()==="input"&&(m.type==="checkbox"||m.type==="radio")&&(z=QR);if(z&&(z=z(t,c))){wE(f,z,n,h);break e}U&&U(t,m,c),t==="focusout"&&(U=m._wrapperState)&&U.controlled&&m.type==="number"&&hf(m,"number",m.value)}switch(U=c?ks(c):window,t){case"focusin":(Sy(U)||U.contentEditable==="true")&&(Is=U,If=c,ya=null);break;case"focusout":ya=If=Is=null;break;case"mousedown":Sf=!0;break;case"contextmenu":case"mouseup":case"dragend":Sf=!1,Ay(f,n,h);break;case"selectionchange":if(ZR)break;case"keydown":case"keyup":Ay(f,n,h)}var v;if(em)e:{switch(t){case"compositionstart":var _="onCompositionStart";break e;case"compositionend":_="onCompositionEnd";break e;case"compositionupdate":_="onCompositionUpdate";break e}_=void 0}else Ts?yE(t,n)&&(_="onCompositionEnd"):t==="keydown"&&n.keyCode===229&&(_="onCompositionStart");_&&(_E&&n.locale!=="ko"&&(Ts||_!=="onCompositionStart"?_==="onCompositionEnd"&&Ts&&(v=gE()):($r=h,Xp="value"in $r?$r.value:$r.textContent,Ts=!0)),U=ic(c,_),0<U.length&&(_=new wy(_,t,null,n,h),f.push({event:_,listeners:U}),v?_.data=v:(v=vE(n),v!==null&&(_.data=v)))),(v=zR?BR(t,n):$R(t,n))&&(c=ic(c,"onBeforeInput"),0<c.length&&(h=new wy("onBeforeInput","beforeinput",null,n,h),f.push({event:h,listeners:c}),h.data=v))}bE(f,e)})}function qa(t,e,n){return{instance:t,listener:e,currentTarget:n}}function ic(t,e){for(var n=e+"Capture",r=[];t!==null;){var i=t,s=i.stateNode;i.tag===5&&s!==null&&(i=s,s=Va(t,n),s!=null&&r.unshift(qa(t,s,i)),s=Va(t,e),s!=null&&r.push(qa(t,s,i))),t=t.return}return r}function ps(t){if(t===null)return null;do t=t.return;while(t&&t.tag!==5);return t||null}function Ny(t,e,n,r,i){for(var s=e._reactName,o=[];n!==null&&n!==r;){var a=n,u=a.alternate,c=a.stateNode;if(u!==null&&u===r)break;a.tag===5&&c!==null&&(a=c,i?(u=Va(n,s),u!=null&&o.unshift(qa(n,u,a))):i||(u=Va(n,s),u!=null&&o.push(qa(n,u,a)))),n=n.return}o.length!==0&&t.push({event:e,listeners:o})}var rx=/\r\n?/g,ix=/\u0000|\uFFFD/g;function Dy(t){return(typeof t=="string"?t:""+t).replace(rx,`
`).replace(ix,"")}function cu(t,e,n){if(e=Dy(e),Dy(t)!==e&&n)throw Error(B(425))}function sc(){}var kf=null,Cf=null;function Rf(t,e){return t==="textarea"||t==="noscript"||typeof e.children=="string"||typeof e.children=="number"||typeof e.dangerouslySetInnerHTML=="object"&&e.dangerouslySetInnerHTML!==null&&e.dangerouslySetInnerHTML.__html!=null}var xf=typeof setTimeout=="function"?setTimeout:void 0,sx=typeof clearTimeout=="function"?clearTimeout:void 0,Oy=typeof Promise=="function"?Promise:void 0,ox=typeof queueMicrotask=="function"?queueMicrotask:typeof Oy<"u"?function(t){return Oy.resolve(null).then(t).catch(ax)}:xf;function ax(t){setTimeout(function(){throw t})}function Td(t,e){var n=e,r=0;do{var i=n.nextSibling;if(t.removeChild(n),i&&i.nodeType===8)if(n=i.data,n==="/$"){if(r===0){t.removeChild(i),za(e);return}r--}else n!=="$"&&n!=="$?"&&n!=="$!"||r++;n=i}while(n);za(e)}function Qr(t){for(;t!=null;t=t.nextSibling){var e=t.nodeType;if(e===1||e===3)break;if(e===8){if(e=t.data,e==="$"||e==="$!"||e==="$?")break;if(e==="/$")return null}}return t}function My(t){t=t.previousSibling;for(var e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="$"||n==="$!"||n==="$?"){if(e===0)return t;e--}else n==="/$"&&e++}t=t.previousSibling}return null}var mo=Math.random().toString(36).slice(2),Bn="__reactFiber$"+mo,Ha="__reactProps$"+mo,gr="__reactContainer$"+mo,Af="__reactEvents$"+mo,lx="__reactListeners$"+mo,ux="__reactHandles$"+mo;function Ai(t){var e=t[Bn];if(e)return e;for(var n=t.parentNode;n;){if(e=n[gr]||n[Bn]){if(n=e.alternate,e.child!==null||n!==null&&n.child!==null)for(t=My(t);t!==null;){if(n=t[Bn])return n;t=My(t)}return e}t=n,n=t.parentNode}return null}function gl(t){return t=t[Bn]||t[gr],!t||t.tag!==5&&t.tag!==6&&t.tag!==13&&t.tag!==3?null:t}function ks(t){if(t.tag===5||t.tag===6)return t.stateNode;throw Error(B(33))}function nh(t){return t[Ha]||null}var Pf=[],Cs=-1;function gi(t){return{current:t}}function Ue(t){0>Cs||(t.current=Pf[Cs],Pf[Cs]=null,Cs--)}function De(t,e){Cs++,Pf[Cs]=t.current,t.current=e}var li={},Ft=gi(li),Xt=gi(!1),Ui=li;function Qs(t,e){var n=t.type.contextTypes;if(!n)return li;var r=t.stateNode;if(r&&r.__reactInternalMemoizedUnmaskedChildContext===e)return r.__reactInternalMemoizedMaskedChildContext;var i={},s;for(s in n)i[s]=e[s];return r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=e,t.__reactInternalMemoizedMaskedChildContext=i),i}function Jt(t){return t=t.childContextTypes,t!=null}function oc(){Ue(Xt),Ue(Ft)}function Ly(t,e,n){if(Ft.current!==li)throw Error(B(168));De(Ft,e),De(Xt,n)}function DE(t,e,n){var r=t.stateNode;if(e=e.childContextTypes,typeof r.getChildContext!="function")return n;r=r.getChildContext();for(var i in r)if(!(i in e))throw Error(B(108,GC(t)||"Unknown",i));return He({},n,r)}function ac(t){return t=(t=t.stateNode)&&t.__reactInternalMemoizedMergedChildContext||li,Ui=Ft.current,De(Ft,t),De(Xt,Xt.current),!0}function Fy(t,e,n){var r=t.stateNode;if(!r)throw Error(B(169));n?(t=DE(t,e,Ui),r.__reactInternalMemoizedMergedChildContext=t,Ue(Xt),Ue(Ft),De(Ft,t)):Ue(Xt),De(Xt,n)}var ir=null,rh=!1,Id=!1;function OE(t){ir===null?ir=[t]:ir.push(t)}function cx(t){rh=!0,OE(t)}function _i(){if(!Id&&ir!==null){Id=!0;var t=0,e=Se;try{var n=ir;for(Se=1;t<n.length;t++){var r=n[t];do r=r(!0);while(r!==null)}ir=null,rh=!1}catch(i){throw ir!==null&&(ir=ir.slice(t+1)),sE(Gp,_i),i}finally{Se=e,Id=!1}}return null}var Rs=[],xs=0,lc=null,uc=0,dn=[],fn=0,ji=null,sr=1,or="";function Si(t,e){Rs[xs++]=uc,Rs[xs++]=lc,lc=t,uc=e}function ME(t,e,n){dn[fn++]=sr,dn[fn++]=or,dn[fn++]=ji,ji=t;var r=sr;t=or;var i=32-On(r)-1;r&=~(1<<i),n+=1;var s=32-On(e)+i;if(30<s){var o=i-i%5;s=(r&(1<<o)-1).toString(32),r>>=o,i-=o,sr=1<<32-On(e)+i|n<<i|r,or=s+t}else sr=1<<s|n<<i|r,or=t}function nm(t){t.return!==null&&(Si(t,1),ME(t,1,0))}function rm(t){for(;t===lc;)lc=Rs[--xs],Rs[xs]=null,uc=Rs[--xs],Rs[xs]=null;for(;t===ji;)ji=dn[--fn],dn[fn]=null,or=dn[--fn],dn[fn]=null,sr=dn[--fn],dn[fn]=null}var ln=null,on=null,$e=!1,Pn=null;function LE(t,e){var n=mn(5,null,null,0);n.elementType="DELETED",n.stateNode=e,n.return=t,e=t.deletions,e===null?(t.deletions=[n],t.flags|=16):e.push(n)}function Vy(t,e){switch(t.tag){case 5:var n=t.type;return e=e.nodeType!==1||n.toLowerCase()!==e.nodeName.toLowerCase()?null:e,e!==null?(t.stateNode=e,ln=t,on=Qr(e.firstChild),!0):!1;case 6:return e=t.pendingProps===""||e.nodeType!==3?null:e,e!==null?(t.stateNode=e,ln=t,on=null,!0):!1;case 13:return e=e.nodeType!==8?null:e,e!==null?(n=ji!==null?{id:sr,overflow:or}:null,t.memoizedState={dehydrated:e,treeContext:n,retryLane:1073741824},n=mn(18,null,null,0),n.stateNode=e,n.return=t,t.child=n,ln=t,on=null,!0):!1;default:return!1}}function bf(t){return(t.mode&1)!==0&&(t.flags&128)===0}function Nf(t){if($e){var e=on;if(e){var n=e;if(!Vy(t,e)){if(bf(t))throw Error(B(418));e=Qr(n.nextSibling);var r=ln;e&&Vy(t,e)?LE(r,n):(t.flags=t.flags&-4097|2,$e=!1,ln=t)}}else{if(bf(t))throw Error(B(418));t.flags=t.flags&-4097|2,$e=!1,ln=t}}}function Uy(t){for(t=t.return;t!==null&&t.tag!==5&&t.tag!==3&&t.tag!==13;)t=t.return;ln=t}function hu(t){if(t!==ln)return!1;if(!$e)return Uy(t),$e=!0,!1;var e;if((e=t.tag!==3)&&!(e=t.tag!==5)&&(e=t.type,e=e!=="head"&&e!=="body"&&!Rf(t.type,t.memoizedProps)),e&&(e=on)){if(bf(t))throw FE(),Error(B(418));for(;e;)LE(t,e),e=Qr(e.nextSibling)}if(Uy(t),t.tag===13){if(t=t.memoizedState,t=t!==null?t.dehydrated:null,!t)throw Error(B(317));e:{for(t=t.nextSibling,e=0;t;){if(t.nodeType===8){var n=t.data;if(n==="/$"){if(e===0){on=Qr(t.nextSibling);break e}e--}else n!=="$"&&n!=="$!"&&n!=="$?"||e++}t=t.nextSibling}on=null}}else on=ln?Qr(t.stateNode.nextSibling):null;return!0}function FE(){for(var t=on;t;)t=Qr(t.nextSibling)}function Ys(){on=ln=null,$e=!1}function im(t){Pn===null?Pn=[t]:Pn.push(t)}var hx=Rr.ReactCurrentBatchConfig;function Qo(t,e,n){if(t=n.ref,t!==null&&typeof t!="function"&&typeof t!="object"){if(n._owner){if(n=n._owner,n){if(n.tag!==1)throw Error(B(309));var r=n.stateNode}if(!r)throw Error(B(147,t));var i=r,s=""+t;return e!==null&&e.ref!==null&&typeof e.ref=="function"&&e.ref._stringRef===s?e.ref:(e=function(o){var a=i.refs;o===null?delete a[s]:a[s]=o},e._stringRef=s,e)}if(typeof t!="string")throw Error(B(284));if(!n._owner)throw Error(B(290,t))}return t}function du(t,e){throw t=Object.prototype.toString.call(e),Error(B(31,t==="[object Object]"?"object with keys {"+Object.keys(e).join(", ")+"}":t))}function jy(t){var e=t._init;return e(t._payload)}function VE(t){function e(k,T){if(t){var R=k.deletions;R===null?(k.deletions=[T],k.flags|=16):R.push(T)}}function n(k,T){if(!t)return null;for(;T!==null;)e(k,T),T=T.sibling;return null}function r(k,T){for(k=new Map;T!==null;)T.key!==null?k.set(T.key,T):k.set(T.index,T),T=T.sibling;return k}function i(k,T){return k=Zr(k,T),k.index=0,k.sibling=null,k}function s(k,T,R){return k.index=R,t?(R=k.alternate,R!==null?(R=R.index,R<T?(k.flags|=2,T):R):(k.flags|=2,T)):(k.flags|=1048576,T)}function o(k){return t&&k.alternate===null&&(k.flags|=2),k}function a(k,T,R,M){return T===null||T.tag!==6?(T=Pd(R,k.mode,M),T.return=k,T):(T=i(T,R),T.return=k,T)}function u(k,T,R,M){var z=R.type;return z===Es?h(k,T,R.props.children,M,R.key):T!==null&&(T.elementType===z||typeof z=="object"&&z!==null&&z.$$typeof===Or&&jy(z)===T.type)?(M=i(T,R.props),M.ref=Qo(k,T,R),M.return=k,M):(M=Uu(R.type,R.key,R.props,null,k.mode,M),M.ref=Qo(k,T,R),M.return=k,M)}function c(k,T,R,M){return T===null||T.tag!==4||T.stateNode.containerInfo!==R.containerInfo||T.stateNode.implementation!==R.implementation?(T=bd(R,k.mode,M),T.return=k,T):(T=i(T,R.children||[]),T.return=k,T)}function h(k,T,R,M,z){return T===null||T.tag!==7?(T=Li(R,k.mode,M,z),T.return=k,T):(T=i(T,R),T.return=k,T)}function f(k,T,R){if(typeof T=="string"&&T!==""||typeof T=="number")return T=Pd(""+T,k.mode,R),T.return=k,T;if(typeof T=="object"&&T!==null){switch(T.$$typeof){case tu:return R=Uu(T.type,T.key,T.props,null,k.mode,R),R.ref=Qo(k,null,T),R.return=k,R;case ws:return T=bd(T,k.mode,R),T.return=k,T;case Or:var M=T._init;return f(k,M(T._payload),R)}if(aa(T)||Wo(T))return T=Li(T,k.mode,R,null),T.return=k,T;du(k,T)}return null}function m(k,T,R,M){var z=T!==null?T.key:null;if(typeof R=="string"&&R!==""||typeof R=="number")return z!==null?null:a(k,T,""+R,M);if(typeof R=="object"&&R!==null){switch(R.$$typeof){case tu:return R.key===z?u(k,T,R,M):null;case ws:return R.key===z?c(k,T,R,M):null;case Or:return z=R._init,m(k,T,z(R._payload),M)}if(aa(R)||Wo(R))return z!==null?null:h(k,T,R,M,null);du(k,R)}return null}function w(k,T,R,M,z){if(typeof M=="string"&&M!==""||typeof M=="number")return k=k.get(R)||null,a(T,k,""+M,z);if(typeof M=="object"&&M!==null){switch(M.$$typeof){case tu:return k=k.get(M.key===null?R:M.key)||null,u(T,k,M,z);case ws:return k=k.get(M.key===null?R:M.key)||null,c(T,k,M,z);case Or:var U=M._init;return w(k,T,R,U(M._payload),z)}if(aa(M)||Wo(M))return k=k.get(R)||null,h(T,k,M,z,null);du(T,M)}return null}function S(k,T,R,M){for(var z=null,U=null,v=T,_=T=0,E=null;v!==null&&_<R.length;_++){v.index>_?(E=v,v=null):E=v.sibling;var I=m(k,v,R[_],M);if(I===null){v===null&&(v=E);break}t&&v&&I.alternate===null&&e(k,v),T=s(I,T,_),U===null?z=I:U.sibling=I,U=I,v=E}if(_===R.length)return n(k,v),$e&&Si(k,_),z;if(v===null){for(;_<R.length;_++)v=f(k,R[_],M),v!==null&&(T=s(v,T,_),U===null?z=v:U.sibling=v,U=v);return $e&&Si(k,_),z}for(v=r(k,v);_<R.length;_++)E=w(v,k,_,R[_],M),E!==null&&(t&&E.alternate!==null&&v.delete(E.key===null?_:E.key),T=s(E,T,_),U===null?z=E:U.sibling=E,U=E);return t&&v.forEach(function(A){return e(k,A)}),$e&&Si(k,_),z}function P(k,T,R,M){var z=Wo(R);if(typeof z!="function")throw Error(B(150));if(R=z.call(R),R==null)throw Error(B(151));for(var U=z=null,v=T,_=T=0,E=null,I=R.next();v!==null&&!I.done;_++,I=R.next()){v.index>_?(E=v,v=null):E=v.sibling;var A=m(k,v,I.value,M);if(A===null){v===null&&(v=E);break}t&&v&&A.alternate===null&&e(k,v),T=s(A,T,_),U===null?z=A:U.sibling=A,U=A,v=E}if(I.done)return n(k,v),$e&&Si(k,_),z;if(v===null){for(;!I.done;_++,I=R.next())I=f(k,I.value,M),I!==null&&(T=s(I,T,_),U===null?z=I:U.sibling=I,U=I);return $e&&Si(k,_),z}for(v=r(k,v);!I.done;_++,I=R.next())I=w(v,k,_,I.value,M),I!==null&&(t&&I.alternate!==null&&v.delete(I.key===null?_:I.key),T=s(I,T,_),U===null?z=I:U.sibling=I,U=I);return t&&v.forEach(function(b){return e(k,b)}),$e&&Si(k,_),z}function D(k,T,R,M){if(typeof R=="object"&&R!==null&&R.type===Es&&R.key===null&&(R=R.props.children),typeof R=="object"&&R!==null){switch(R.$$typeof){case tu:e:{for(var z=R.key,U=T;U!==null;){if(U.key===z){if(z=R.type,z===Es){if(U.tag===7){n(k,U.sibling),T=i(U,R.props.children),T.return=k,k=T;break e}}else if(U.elementType===z||typeof z=="object"&&z!==null&&z.$$typeof===Or&&jy(z)===U.type){n(k,U.sibling),T=i(U,R.props),T.ref=Qo(k,U,R),T.return=k,k=T;break e}n(k,U);break}else e(k,U);U=U.sibling}R.type===Es?(T=Li(R.props.children,k.mode,M,R.key),T.return=k,k=T):(M=Uu(R.type,R.key,R.props,null,k.mode,M),M.ref=Qo(k,T,R),M.return=k,k=M)}return o(k);case ws:e:{for(U=R.key;T!==null;){if(T.key===U)if(T.tag===4&&T.stateNode.containerInfo===R.containerInfo&&T.stateNode.implementation===R.implementation){n(k,T.sibling),T=i(T,R.children||[]),T.return=k,k=T;break e}else{n(k,T);break}else e(k,T);T=T.sibling}T=bd(R,k.mode,M),T.return=k,k=T}return o(k);case Or:return U=R._init,D(k,T,U(R._payload),M)}if(aa(R))return S(k,T,R,M);if(Wo(R))return P(k,T,R,M);du(k,R)}return typeof R=="string"&&R!==""||typeof R=="number"?(R=""+R,T!==null&&T.tag===6?(n(k,T.sibling),T=i(T,R),T.return=k,k=T):(n(k,T),T=Pd(R,k.mode,M),T.return=k,k=T),o(k)):n(k,T)}return D}var Xs=VE(!0),UE=VE(!1),cc=gi(null),hc=null,As=null,sm=null;function om(){sm=As=hc=null}function am(t){var e=cc.current;Ue(cc),t._currentValue=e}function Df(t,e,n){for(;t!==null;){var r=t.alternate;if((t.childLanes&e)!==e?(t.childLanes|=e,r!==null&&(r.childLanes|=e)):r!==null&&(r.childLanes&e)!==e&&(r.childLanes|=e),t===n)break;t=t.return}}function Us(t,e){hc=t,sm=As=null,t=t.dependencies,t!==null&&t.firstContext!==null&&(t.lanes&e&&(Qt=!0),t.firstContext=null)}function Tn(t){var e=t._currentValue;if(sm!==t)if(t={context:t,memoizedValue:e,next:null},As===null){if(hc===null)throw Error(B(308));As=t,hc.dependencies={lanes:0,firstContext:t}}else As=As.next=t;return e}var Pi=null;function lm(t){Pi===null?Pi=[t]:Pi.push(t)}function jE(t,e,n,r){var i=e.interleaved;return i===null?(n.next=n,lm(e)):(n.next=i.next,i.next=n),e.interleaved=n,_r(t,r)}function _r(t,e){t.lanes|=e;var n=t.alternate;for(n!==null&&(n.lanes|=e),n=t,t=t.return;t!==null;)t.childLanes|=e,n=t.alternate,n!==null&&(n.childLanes|=e),n=t,t=t.return;return n.tag===3?n.stateNode:null}var Mr=!1;function um(t){t.updateQueue={baseState:t.memoizedState,firstBaseUpdate:null,lastBaseUpdate:null,shared:{pending:null,interleaved:null,lanes:0},effects:null}}function zE(t,e){t=t.updateQueue,e.updateQueue===t&&(e.updateQueue={baseState:t.baseState,firstBaseUpdate:t.firstBaseUpdate,lastBaseUpdate:t.lastBaseUpdate,shared:t.shared,effects:t.effects})}function dr(t,e){return{eventTime:t,lane:e,tag:0,payload:null,callback:null,next:null}}function Yr(t,e,n){var r=t.updateQueue;if(r===null)return null;if(r=r.shared,ye&2){var i=r.pending;return i===null?e.next=e:(e.next=i.next,i.next=e),r.pending=e,_r(t,n)}return i=r.interleaved,i===null?(e.next=e,lm(r)):(e.next=i.next,i.next=e),r.interleaved=e,_r(t,n)}function Du(t,e,n){if(e=e.updateQueue,e!==null&&(e=e.shared,(n&4194240)!==0)){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Kp(t,n)}}function zy(t,e){var n=t.updateQueue,r=t.alternate;if(r!==null&&(r=r.updateQueue,n===r)){var i=null,s=null;if(n=n.firstBaseUpdate,n!==null){do{var o={eventTime:n.eventTime,lane:n.lane,tag:n.tag,payload:n.payload,callback:n.callback,next:null};s===null?i=s=o:s=s.next=o,n=n.next}while(n!==null);s===null?i=s=e:s=s.next=e}else i=s=e;n={baseState:r.baseState,firstBaseUpdate:i,lastBaseUpdate:s,shared:r.shared,effects:r.effects},t.updateQueue=n;return}t=n.lastBaseUpdate,t===null?n.firstBaseUpdate=e:t.next=e,n.lastBaseUpdate=e}function dc(t,e,n,r){var i=t.updateQueue;Mr=!1;var s=i.firstBaseUpdate,o=i.lastBaseUpdate,a=i.shared.pending;if(a!==null){i.shared.pending=null;var u=a,c=u.next;u.next=null,o===null?s=c:o.next=c,o=u;var h=t.alternate;h!==null&&(h=h.updateQueue,a=h.lastBaseUpdate,a!==o&&(a===null?h.firstBaseUpdate=c:a.next=c,h.lastBaseUpdate=u))}if(s!==null){var f=i.baseState;o=0,h=c=u=null,a=s;do{var m=a.lane,w=a.eventTime;if((r&m)===m){h!==null&&(h=h.next={eventTime:w,lane:0,tag:a.tag,payload:a.payload,callback:a.callback,next:null});e:{var S=t,P=a;switch(m=e,w=n,P.tag){case 1:if(S=P.payload,typeof S=="function"){f=S.call(w,f,m);break e}f=S;break e;case 3:S.flags=S.flags&-65537|128;case 0:if(S=P.payload,m=typeof S=="function"?S.call(w,f,m):S,m==null)break e;f=He({},f,m);break e;case 2:Mr=!0}}a.callback!==null&&a.lane!==0&&(t.flags|=64,m=i.effects,m===null?i.effects=[a]:m.push(a))}else w={eventTime:w,lane:m,tag:a.tag,payload:a.payload,callback:a.callback,next:null},h===null?(c=h=w,u=f):h=h.next=w,o|=m;if(a=a.next,a===null){if(a=i.shared.pending,a===null)break;m=a,a=m.next,m.next=null,i.lastBaseUpdate=m,i.shared.pending=null}}while(!0);if(h===null&&(u=f),i.baseState=u,i.firstBaseUpdate=c,i.lastBaseUpdate=h,e=i.shared.interleaved,e!==null){i=e;do o|=i.lane,i=i.next;while(i!==e)}else s===null&&(i.shared.lanes=0);Bi|=o,t.lanes=o,t.memoizedState=f}}function By(t,e,n){if(t=e.effects,e.effects=null,t!==null)for(e=0;e<t.length;e++){var r=t[e],i=r.callback;if(i!==null){if(r.callback=null,r=n,typeof i!="function")throw Error(B(191,i));i.call(r)}}}var _l={},Hn=gi(_l),Ga=gi(_l),Ka=gi(_l);function bi(t){if(t===_l)throw Error(B(174));return t}function cm(t,e){switch(De(Ka,e),De(Ga,t),De(Hn,_l),t=e.nodeType,t){case 9:case 11:e=(e=e.documentElement)?e.namespaceURI:ff(null,"");break;default:t=t===8?e.parentNode:e,e=t.namespaceURI||null,t=t.tagName,e=ff(e,t)}Ue(Hn),De(Hn,e)}function Js(){Ue(Hn),Ue(Ga),Ue(Ka)}function BE(t){bi(Ka.current);var e=bi(Hn.current),n=ff(e,t.type);e!==n&&(De(Ga,t),De(Hn,n))}function hm(t){Ga.current===t&&(Ue(Hn),Ue(Ga))}var We=gi(0);function fc(t){for(var e=t;e!==null;){if(e.tag===13){var n=e.memoizedState;if(n!==null&&(n=n.dehydrated,n===null||n.data==="$?"||n.data==="$!"))return e}else if(e.tag===19&&e.memoizedProps.revealOrder!==void 0){if(e.flags&128)return e}else if(e.child!==null){e.child.return=e,e=e.child;continue}if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return null;e=e.return}e.sibling.return=e.return,e=e.sibling}return null}var Sd=[];function dm(){for(var t=0;t<Sd.length;t++)Sd[t]._workInProgressVersionPrimary=null;Sd.length=0}var Ou=Rr.ReactCurrentDispatcher,kd=Rr.ReactCurrentBatchConfig,zi=0,qe=null,ot=null,ft=null,pc=!1,va=!1,Qa=0,dx=0;function At(){throw Error(B(321))}function fm(t,e){if(e===null)return!1;for(var n=0;n<e.length&&n<t.length;n++)if(!Fn(t[n],e[n]))return!1;return!0}function pm(t,e,n,r,i,s){if(zi=s,qe=e,e.memoizedState=null,e.updateQueue=null,e.lanes=0,Ou.current=t===null||t.memoizedState===null?gx:_x,t=n(r,i),va){s=0;do{if(va=!1,Qa=0,25<=s)throw Error(B(301));s+=1,ft=ot=null,e.updateQueue=null,Ou.current=yx,t=n(r,i)}while(va)}if(Ou.current=mc,e=ot!==null&&ot.next!==null,zi=0,ft=ot=qe=null,pc=!1,e)throw Error(B(300));return t}function mm(){var t=Qa!==0;return Qa=0,t}function zn(){var t={memoizedState:null,baseState:null,baseQueue:null,queue:null,next:null};return ft===null?qe.memoizedState=ft=t:ft=ft.next=t,ft}function In(){if(ot===null){var t=qe.alternate;t=t!==null?t.memoizedState:null}else t=ot.next;var e=ft===null?qe.memoizedState:ft.next;if(e!==null)ft=e,ot=t;else{if(t===null)throw Error(B(310));ot=t,t={memoizedState:ot.memoizedState,baseState:ot.baseState,baseQueue:ot.baseQueue,queue:ot.queue,next:null},ft===null?qe.memoizedState=ft=t:ft=ft.next=t}return ft}function Ya(t,e){return typeof e=="function"?e(t):e}function Cd(t){var e=In(),n=e.queue;if(n===null)throw Error(B(311));n.lastRenderedReducer=t;var r=ot,i=r.baseQueue,s=n.pending;if(s!==null){if(i!==null){var o=i.next;i.next=s.next,s.next=o}r.baseQueue=i=s,n.pending=null}if(i!==null){s=i.next,r=r.baseState;var a=o=null,u=null,c=s;do{var h=c.lane;if((zi&h)===h)u!==null&&(u=u.next={lane:0,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null}),r=c.hasEagerState?c.eagerState:t(r,c.action);else{var f={lane:h,action:c.action,hasEagerState:c.hasEagerState,eagerState:c.eagerState,next:null};u===null?(a=u=f,o=r):u=u.next=f,qe.lanes|=h,Bi|=h}c=c.next}while(c!==null&&c!==s);u===null?o=r:u.next=a,Fn(r,e.memoizedState)||(Qt=!0),e.memoizedState=r,e.baseState=o,e.baseQueue=u,n.lastRenderedState=r}if(t=n.interleaved,t!==null){i=t;do s=i.lane,qe.lanes|=s,Bi|=s,i=i.next;while(i!==t)}else i===null&&(n.lanes=0);return[e.memoizedState,n.dispatch]}function Rd(t){var e=In(),n=e.queue;if(n===null)throw Error(B(311));n.lastRenderedReducer=t;var r=n.dispatch,i=n.pending,s=e.memoizedState;if(i!==null){n.pending=null;var o=i=i.next;do s=t(s,o.action),o=o.next;while(o!==i);Fn(s,e.memoizedState)||(Qt=!0),e.memoizedState=s,e.baseQueue===null&&(e.baseState=s),n.lastRenderedState=s}return[s,r]}function $E(){}function WE(t,e){var n=qe,r=In(),i=e(),s=!Fn(r.memoizedState,i);if(s&&(r.memoizedState=i,Qt=!0),r=r.queue,gm(GE.bind(null,n,r,t),[t]),r.getSnapshot!==e||s||ft!==null&&ft.memoizedState.tag&1){if(n.flags|=2048,Xa(9,HE.bind(null,n,r,i,e),void 0,null),mt===null)throw Error(B(349));zi&30||qE(n,e,i)}return i}function qE(t,e,n){t.flags|=16384,t={getSnapshot:e,value:n},e=qe.updateQueue,e===null?(e={lastEffect:null,stores:null},qe.updateQueue=e,e.stores=[t]):(n=e.stores,n===null?e.stores=[t]:n.push(t))}function HE(t,e,n,r){e.value=n,e.getSnapshot=r,KE(e)&&QE(t)}function GE(t,e,n){return n(function(){KE(e)&&QE(t)})}function KE(t){var e=t.getSnapshot;t=t.value;try{var n=e();return!Fn(t,n)}catch{return!0}}function QE(t){var e=_r(t,1);e!==null&&Mn(e,t,1,-1)}function $y(t){var e=zn();return typeof t=="function"&&(t=t()),e.memoizedState=e.baseState=t,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:Ya,lastRenderedState:t},e.queue=t,t=t.dispatch=mx.bind(null,qe,t),[e.memoizedState,t]}function Xa(t,e,n,r){return t={tag:t,create:e,destroy:n,deps:r,next:null},e=qe.updateQueue,e===null?(e={lastEffect:null,stores:null},qe.updateQueue=e,e.lastEffect=t.next=t):(n=e.lastEffect,n===null?e.lastEffect=t.next=t:(r=n.next,n.next=t,t.next=r,e.lastEffect=t)),t}function YE(){return In().memoizedState}function Mu(t,e,n,r){var i=zn();qe.flags|=t,i.memoizedState=Xa(1|e,n,void 0,r===void 0?null:r)}function ih(t,e,n,r){var i=In();r=r===void 0?null:r;var s=void 0;if(ot!==null){var o=ot.memoizedState;if(s=o.destroy,r!==null&&fm(r,o.deps)){i.memoizedState=Xa(e,n,s,r);return}}qe.flags|=t,i.memoizedState=Xa(1|e,n,s,r)}function Wy(t,e){return Mu(8390656,8,t,e)}function gm(t,e){return ih(2048,8,t,e)}function XE(t,e){return ih(4,2,t,e)}function JE(t,e){return ih(4,4,t,e)}function ZE(t,e){if(typeof e=="function")return t=t(),e(t),function(){e(null)};if(e!=null)return t=t(),e.current=t,function(){e.current=null}}function eT(t,e,n){return n=n!=null?n.concat([t]):null,ih(4,4,ZE.bind(null,e,t),n)}function _m(){}function tT(t,e){var n=In();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&fm(e,r[1])?r[0]:(n.memoizedState=[t,e],t)}function nT(t,e){var n=In();e=e===void 0?null:e;var r=n.memoizedState;return r!==null&&e!==null&&fm(e,r[1])?r[0]:(t=t(),n.memoizedState=[t,e],t)}function rT(t,e,n){return zi&21?(Fn(n,e)||(n=lE(),qe.lanes|=n,Bi|=n,t.baseState=!0),e):(t.baseState&&(t.baseState=!1,Qt=!0),t.memoizedState=n)}function fx(t,e){var n=Se;Se=n!==0&&4>n?n:4,t(!0);var r=kd.transition;kd.transition={};try{t(!1),e()}finally{Se=n,kd.transition=r}}function iT(){return In().memoizedState}function px(t,e,n){var r=Jr(t);if(n={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null},sT(t))oT(e,n);else if(n=jE(t,e,n,r),n!==null){var i=$t();Mn(n,t,r,i),aT(n,e,r)}}function mx(t,e,n){var r=Jr(t),i={lane:r,action:n,hasEagerState:!1,eagerState:null,next:null};if(sT(t))oT(e,i);else{var s=t.alternate;if(t.lanes===0&&(s===null||s.lanes===0)&&(s=e.lastRenderedReducer,s!==null))try{var o=e.lastRenderedState,a=s(o,n);if(i.hasEagerState=!0,i.eagerState=a,Fn(a,o)){var u=e.interleaved;u===null?(i.next=i,lm(e)):(i.next=u.next,u.next=i),e.interleaved=i;return}}catch{}finally{}n=jE(t,e,i,r),n!==null&&(i=$t(),Mn(n,t,r,i),aT(n,e,r))}}function sT(t){var e=t.alternate;return t===qe||e!==null&&e===qe}function oT(t,e){va=pc=!0;var n=t.pending;n===null?e.next=e:(e.next=n.next,n.next=e),t.pending=e}function aT(t,e,n){if(n&4194240){var r=e.lanes;r&=t.pendingLanes,n|=r,e.lanes=n,Kp(t,n)}}var mc={readContext:Tn,useCallback:At,useContext:At,useEffect:At,useImperativeHandle:At,useInsertionEffect:At,useLayoutEffect:At,useMemo:At,useReducer:At,useRef:At,useState:At,useDebugValue:At,useDeferredValue:At,useTransition:At,useMutableSource:At,useSyncExternalStore:At,useId:At,unstable_isNewReconciler:!1},gx={readContext:Tn,useCallback:function(t,e){return zn().memoizedState=[t,e===void 0?null:e],t},useContext:Tn,useEffect:Wy,useImperativeHandle:function(t,e,n){return n=n!=null?n.concat([t]):null,Mu(4194308,4,ZE.bind(null,e,t),n)},useLayoutEffect:function(t,e){return Mu(4194308,4,t,e)},useInsertionEffect:function(t,e){return Mu(4,2,t,e)},useMemo:function(t,e){var n=zn();return e=e===void 0?null:e,t=t(),n.memoizedState=[t,e],t},useReducer:function(t,e,n){var r=zn();return e=n!==void 0?n(e):e,r.memoizedState=r.baseState=e,t={pending:null,interleaved:null,lanes:0,dispatch:null,lastRenderedReducer:t,lastRenderedState:e},r.queue=t,t=t.dispatch=px.bind(null,qe,t),[r.memoizedState,t]},useRef:function(t){var e=zn();return t={current:t},e.memoizedState=t},useState:$y,useDebugValue:_m,useDeferredValue:function(t){return zn().memoizedState=t},useTransition:function(){var t=$y(!1),e=t[0];return t=fx.bind(null,t[1]),zn().memoizedState=t,[e,t]},useMutableSource:function(){},useSyncExternalStore:function(t,e,n){var r=qe,i=zn();if($e){if(n===void 0)throw Error(B(407));n=n()}else{if(n=e(),mt===null)throw Error(B(349));zi&30||qE(r,e,n)}i.memoizedState=n;var s={value:n,getSnapshot:e};return i.queue=s,Wy(GE.bind(null,r,s,t),[t]),r.flags|=2048,Xa(9,HE.bind(null,r,s,n,e),void 0,null),n},useId:function(){var t=zn(),e=mt.identifierPrefix;if($e){var n=or,r=sr;n=(r&~(1<<32-On(r)-1)).toString(32)+n,e=":"+e+"R"+n,n=Qa++,0<n&&(e+="H"+n.toString(32)),e+=":"}else n=dx++,e=":"+e+"r"+n.toString(32)+":";return t.memoizedState=e},unstable_isNewReconciler:!1},_x={readContext:Tn,useCallback:tT,useContext:Tn,useEffect:gm,useImperativeHandle:eT,useInsertionEffect:XE,useLayoutEffect:JE,useMemo:nT,useReducer:Cd,useRef:YE,useState:function(){return Cd(Ya)},useDebugValue:_m,useDeferredValue:function(t){var e=In();return rT(e,ot.memoizedState,t)},useTransition:function(){var t=Cd(Ya)[0],e=In().memoizedState;return[t,e]},useMutableSource:$E,useSyncExternalStore:WE,useId:iT,unstable_isNewReconciler:!1},yx={readContext:Tn,useCallback:tT,useContext:Tn,useEffect:gm,useImperativeHandle:eT,useInsertionEffect:XE,useLayoutEffect:JE,useMemo:nT,useReducer:Rd,useRef:YE,useState:function(){return Rd(Ya)},useDebugValue:_m,useDeferredValue:function(t){var e=In();return ot===null?e.memoizedState=t:rT(e,ot.memoizedState,t)},useTransition:function(){var t=Rd(Ya)[0],e=In().memoizedState;return[t,e]},useMutableSource:$E,useSyncExternalStore:WE,useId:iT,unstable_isNewReconciler:!1};function xn(t,e){if(t&&t.defaultProps){e=He({},e),t=t.defaultProps;for(var n in t)e[n]===void 0&&(e[n]=t[n]);return e}return e}function Of(t,e,n,r){e=t.memoizedState,n=n(r,e),n=n==null?e:He({},e,n),t.memoizedState=n,t.lanes===0&&(t.updateQueue.baseState=n)}var sh={isMounted:function(t){return(t=t._reactInternals)?es(t)===t:!1},enqueueSetState:function(t,e,n){t=t._reactInternals;var r=$t(),i=Jr(t),s=dr(r,i);s.payload=e,n!=null&&(s.callback=n),e=Yr(t,s,i),e!==null&&(Mn(e,t,i,r),Du(e,t,i))},enqueueReplaceState:function(t,e,n){t=t._reactInternals;var r=$t(),i=Jr(t),s=dr(r,i);s.tag=1,s.payload=e,n!=null&&(s.callback=n),e=Yr(t,s,i),e!==null&&(Mn(e,t,i,r),Du(e,t,i))},enqueueForceUpdate:function(t,e){t=t._reactInternals;var n=$t(),r=Jr(t),i=dr(n,r);i.tag=2,e!=null&&(i.callback=e),e=Yr(t,i,r),e!==null&&(Mn(e,t,r,n),Du(e,t,r))}};function qy(t,e,n,r,i,s,o){return t=t.stateNode,typeof t.shouldComponentUpdate=="function"?t.shouldComponentUpdate(r,s,o):e.prototype&&e.prototype.isPureReactComponent?!$a(n,r)||!$a(i,s):!0}function lT(t,e,n){var r=!1,i=li,s=e.contextType;return typeof s=="object"&&s!==null?s=Tn(s):(i=Jt(e)?Ui:Ft.current,r=e.contextTypes,s=(r=r!=null)?Qs(t,i):li),e=new e(n,s),t.memoizedState=e.state!==null&&e.state!==void 0?e.state:null,e.updater=sh,t.stateNode=e,e._reactInternals=t,r&&(t=t.stateNode,t.__reactInternalMemoizedUnmaskedChildContext=i,t.__reactInternalMemoizedMaskedChildContext=s),e}function Hy(t,e,n,r){t=e.state,typeof e.componentWillReceiveProps=="function"&&e.componentWillReceiveProps(n,r),typeof e.UNSAFE_componentWillReceiveProps=="function"&&e.UNSAFE_componentWillReceiveProps(n,r),e.state!==t&&sh.enqueueReplaceState(e,e.state,null)}function Mf(t,e,n,r){var i=t.stateNode;i.props=n,i.state=t.memoizedState,i.refs={},um(t);var s=e.contextType;typeof s=="object"&&s!==null?i.context=Tn(s):(s=Jt(e)?Ui:Ft.current,i.context=Qs(t,s)),i.state=t.memoizedState,s=e.getDerivedStateFromProps,typeof s=="function"&&(Of(t,e,s,n),i.state=t.memoizedState),typeof e.getDerivedStateFromProps=="function"||typeof i.getSnapshotBeforeUpdate=="function"||typeof i.UNSAFE_componentWillMount!="function"&&typeof i.componentWillMount!="function"||(e=i.state,typeof i.componentWillMount=="function"&&i.componentWillMount(),typeof i.UNSAFE_componentWillMount=="function"&&i.UNSAFE_componentWillMount(),e!==i.state&&sh.enqueueReplaceState(i,i.state,null),dc(t,n,i,r),i.state=t.memoizedState),typeof i.componentDidMount=="function"&&(t.flags|=4194308)}function Zs(t,e){try{var n="",r=e;do n+=HC(r),r=r.return;while(r);var i=n}catch(s){i=`
Error generating stack: `+s.message+`
`+s.stack}return{value:t,source:e,stack:i,digest:null}}function xd(t,e,n){return{value:t,source:null,stack:n??null,digest:e??null}}function Lf(t,e){try{console.error(e.value)}catch(n){setTimeout(function(){throw n})}}var vx=typeof WeakMap=="function"?WeakMap:Map;function uT(t,e,n){n=dr(-1,n),n.tag=3,n.payload={element:null};var r=e.value;return n.callback=function(){_c||(_c=!0,Hf=r),Lf(t,e)},n}function cT(t,e,n){n=dr(-1,n),n.tag=3;var r=t.type.getDerivedStateFromError;if(typeof r=="function"){var i=e.value;n.payload=function(){return r(i)},n.callback=function(){Lf(t,e)}}var s=t.stateNode;return s!==null&&typeof s.componentDidCatch=="function"&&(n.callback=function(){Lf(t,e),typeof r!="function"&&(Xr===null?Xr=new Set([this]):Xr.add(this));var o=e.stack;this.componentDidCatch(e.value,{componentStack:o!==null?o:""})}),n}function Gy(t,e,n){var r=t.pingCache;if(r===null){r=t.pingCache=new vx;var i=new Set;r.set(e,i)}else i=r.get(e),i===void 0&&(i=new Set,r.set(e,i));i.has(n)||(i.add(n),t=Dx.bind(null,t,e,n),e.then(t,t))}function Ky(t){do{var e;if((e=t.tag===13)&&(e=t.memoizedState,e=e!==null?e.dehydrated!==null:!0),e)return t;t=t.return}while(t!==null);return null}function Qy(t,e,n,r,i){return t.mode&1?(t.flags|=65536,t.lanes=i,t):(t===e?t.flags|=65536:(t.flags|=128,n.flags|=131072,n.flags&=-52805,n.tag===1&&(n.alternate===null?n.tag=17:(e=dr(-1,1),e.tag=2,Yr(n,e,1))),n.lanes|=1),t)}var wx=Rr.ReactCurrentOwner,Qt=!1;function Bt(t,e,n,r){e.child=t===null?UE(e,null,n,r):Xs(e,t.child,n,r)}function Yy(t,e,n,r,i){n=n.render;var s=e.ref;return Us(e,i),r=pm(t,e,n,r,s,i),n=mm(),t!==null&&!Qt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):($e&&n&&nm(e),e.flags|=1,Bt(t,e,r,i),e.child)}function Xy(t,e,n,r,i){if(t===null){var s=n.type;return typeof s=="function"&&!km(s)&&s.defaultProps===void 0&&n.compare===null&&n.defaultProps===void 0?(e.tag=15,e.type=s,hT(t,e,s,r,i)):(t=Uu(n.type,null,r,e,e.mode,i),t.ref=e.ref,t.return=e,e.child=t)}if(s=t.child,!(t.lanes&i)){var o=s.memoizedProps;if(n=n.compare,n=n!==null?n:$a,n(o,r)&&t.ref===e.ref)return yr(t,e,i)}return e.flags|=1,t=Zr(s,r),t.ref=e.ref,t.return=e,e.child=t}function hT(t,e,n,r,i){if(t!==null){var s=t.memoizedProps;if($a(s,r)&&t.ref===e.ref)if(Qt=!1,e.pendingProps=r=s,(t.lanes&i)!==0)t.flags&131072&&(Qt=!0);else return e.lanes=t.lanes,yr(t,e,i)}return Ff(t,e,n,r,i)}function dT(t,e,n){var r=e.pendingProps,i=r.children,s=t!==null?t.memoizedState:null;if(r.mode==="hidden")if(!(e.mode&1))e.memoizedState={baseLanes:0,cachePool:null,transitions:null},De(bs,rn),rn|=n;else{if(!(n&1073741824))return t=s!==null?s.baseLanes|n:n,e.lanes=e.childLanes=1073741824,e.memoizedState={baseLanes:t,cachePool:null,transitions:null},e.updateQueue=null,De(bs,rn),rn|=t,null;e.memoizedState={baseLanes:0,cachePool:null,transitions:null},r=s!==null?s.baseLanes:n,De(bs,rn),rn|=r}else s!==null?(r=s.baseLanes|n,e.memoizedState=null):r=n,De(bs,rn),rn|=r;return Bt(t,e,i,n),e.child}function fT(t,e){var n=e.ref;(t===null&&n!==null||t!==null&&t.ref!==n)&&(e.flags|=512,e.flags|=2097152)}function Ff(t,e,n,r,i){var s=Jt(n)?Ui:Ft.current;return s=Qs(e,s),Us(e,i),n=pm(t,e,n,r,s,i),r=mm(),t!==null&&!Qt?(e.updateQueue=t.updateQueue,e.flags&=-2053,t.lanes&=~i,yr(t,e,i)):($e&&r&&nm(e),e.flags|=1,Bt(t,e,n,i),e.child)}function Jy(t,e,n,r,i){if(Jt(n)){var s=!0;ac(e)}else s=!1;if(Us(e,i),e.stateNode===null)Lu(t,e),lT(e,n,r),Mf(e,n,r,i),r=!0;else if(t===null){var o=e.stateNode,a=e.memoizedProps;o.props=a;var u=o.context,c=n.contextType;typeof c=="object"&&c!==null?c=Tn(c):(c=Jt(n)?Ui:Ft.current,c=Qs(e,c));var h=n.getDerivedStateFromProps,f=typeof h=="function"||typeof o.getSnapshotBeforeUpdate=="function";f||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==r||u!==c)&&Hy(e,o,r,c),Mr=!1;var m=e.memoizedState;o.state=m,dc(e,r,o,i),u=e.memoizedState,a!==r||m!==u||Xt.current||Mr?(typeof h=="function"&&(Of(e,n,h,r),u=e.memoizedState),(a=Mr||qy(e,n,a,r,m,u,c))?(f||typeof o.UNSAFE_componentWillMount!="function"&&typeof o.componentWillMount!="function"||(typeof o.componentWillMount=="function"&&o.componentWillMount(),typeof o.UNSAFE_componentWillMount=="function"&&o.UNSAFE_componentWillMount()),typeof o.componentDidMount=="function"&&(e.flags|=4194308)):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),e.memoizedProps=r,e.memoizedState=u),o.props=r,o.state=u,o.context=c,r=a):(typeof o.componentDidMount=="function"&&(e.flags|=4194308),r=!1)}else{o=e.stateNode,zE(t,e),a=e.memoizedProps,c=e.type===e.elementType?a:xn(e.type,a),o.props=c,f=e.pendingProps,m=o.context,u=n.contextType,typeof u=="object"&&u!==null?u=Tn(u):(u=Jt(n)?Ui:Ft.current,u=Qs(e,u));var w=n.getDerivedStateFromProps;(h=typeof w=="function"||typeof o.getSnapshotBeforeUpdate=="function")||typeof o.UNSAFE_componentWillReceiveProps!="function"&&typeof o.componentWillReceiveProps!="function"||(a!==f||m!==u)&&Hy(e,o,r,u),Mr=!1,m=e.memoizedState,o.state=m,dc(e,r,o,i);var S=e.memoizedState;a!==f||m!==S||Xt.current||Mr?(typeof w=="function"&&(Of(e,n,w,r),S=e.memoizedState),(c=Mr||qy(e,n,c,r,m,S,u)||!1)?(h||typeof o.UNSAFE_componentWillUpdate!="function"&&typeof o.componentWillUpdate!="function"||(typeof o.componentWillUpdate=="function"&&o.componentWillUpdate(r,S,u),typeof o.UNSAFE_componentWillUpdate=="function"&&o.UNSAFE_componentWillUpdate(r,S,u)),typeof o.componentDidUpdate=="function"&&(e.flags|=4),typeof o.getSnapshotBeforeUpdate=="function"&&(e.flags|=1024)):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=1024),e.memoizedProps=r,e.memoizedState=S),o.props=r,o.state=S,o.context=u,r=c):(typeof o.componentDidUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=4),typeof o.getSnapshotBeforeUpdate!="function"||a===t.memoizedProps&&m===t.memoizedState||(e.flags|=1024),r=!1)}return Vf(t,e,n,r,s,i)}function Vf(t,e,n,r,i,s){fT(t,e);var o=(e.flags&128)!==0;if(!r&&!o)return i&&Fy(e,n,!1),yr(t,e,s);r=e.stateNode,wx.current=e;var a=o&&typeof n.getDerivedStateFromError!="function"?null:r.render();return e.flags|=1,t!==null&&o?(e.child=Xs(e,t.child,null,s),e.child=Xs(e,null,a,s)):Bt(t,e,a,s),e.memoizedState=r.state,i&&Fy(e,n,!0),e.child}function pT(t){var e=t.stateNode;e.pendingContext?Ly(t,e.pendingContext,e.pendingContext!==e.context):e.context&&Ly(t,e.context,!1),cm(t,e.containerInfo)}function Zy(t,e,n,r,i){return Ys(),im(i),e.flags|=256,Bt(t,e,n,r),e.child}var Uf={dehydrated:null,treeContext:null,retryLane:0};function jf(t){return{baseLanes:t,cachePool:null,transitions:null}}function mT(t,e,n){var r=e.pendingProps,i=We.current,s=!1,o=(e.flags&128)!==0,a;if((a=o)||(a=t!==null&&t.memoizedState===null?!1:(i&2)!==0),a?(s=!0,e.flags&=-129):(t===null||t.memoizedState!==null)&&(i|=1),De(We,i&1),t===null)return Nf(e),t=e.memoizedState,t!==null&&(t=t.dehydrated,t!==null)?(e.mode&1?t.data==="$!"?e.lanes=8:e.lanes=1073741824:e.lanes=1,null):(o=r.children,t=r.fallback,s?(r=e.mode,s=e.child,o={mode:"hidden",children:o},!(r&1)&&s!==null?(s.childLanes=0,s.pendingProps=o):s=lh(o,r,0,null),t=Li(t,r,n,null),s.return=e,t.return=e,s.sibling=t,e.child=s,e.child.memoizedState=jf(n),e.memoizedState=Uf,t):ym(e,o));if(i=t.memoizedState,i!==null&&(a=i.dehydrated,a!==null))return Ex(t,e,o,r,a,i,n);if(s){s=r.fallback,o=e.mode,i=t.child,a=i.sibling;var u={mode:"hidden",children:r.children};return!(o&1)&&e.child!==i?(r=e.child,r.childLanes=0,r.pendingProps=u,e.deletions=null):(r=Zr(i,u),r.subtreeFlags=i.subtreeFlags&14680064),a!==null?s=Zr(a,s):(s=Li(s,o,n,null),s.flags|=2),s.return=e,r.return=e,r.sibling=s,e.child=r,r=s,s=e.child,o=t.child.memoizedState,o=o===null?jf(n):{baseLanes:o.baseLanes|n,cachePool:null,transitions:o.transitions},s.memoizedState=o,s.childLanes=t.childLanes&~n,e.memoizedState=Uf,r}return s=t.child,t=s.sibling,r=Zr(s,{mode:"visible",children:r.children}),!(e.mode&1)&&(r.lanes=n),r.return=e,r.sibling=null,t!==null&&(n=e.deletions,n===null?(e.deletions=[t],e.flags|=16):n.push(t)),e.child=r,e.memoizedState=null,r}function ym(t,e){return e=lh({mode:"visible",children:e},t.mode,0,null),e.return=t,t.child=e}function fu(t,e,n,r){return r!==null&&im(r),Xs(e,t.child,null,n),t=ym(e,e.pendingProps.children),t.flags|=2,e.memoizedState=null,t}function Ex(t,e,n,r,i,s,o){if(n)return e.flags&256?(e.flags&=-257,r=xd(Error(B(422))),fu(t,e,o,r)):e.memoizedState!==null?(e.child=t.child,e.flags|=128,null):(s=r.fallback,i=e.mode,r=lh({mode:"visible",children:r.children},i,0,null),s=Li(s,i,o,null),s.flags|=2,r.return=e,s.return=e,r.sibling=s,e.child=r,e.mode&1&&Xs(e,t.child,null,o),e.child.memoizedState=jf(o),e.memoizedState=Uf,s);if(!(e.mode&1))return fu(t,e,o,null);if(i.data==="$!"){if(r=i.nextSibling&&i.nextSibling.dataset,r)var a=r.dgst;return r=a,s=Error(B(419)),r=xd(s,r,void 0),fu(t,e,o,r)}if(a=(o&t.childLanes)!==0,Qt||a){if(r=mt,r!==null){switch(o&-o){case 4:i=2;break;case 16:i=8;break;case 64:case 128:case 256:case 512:case 1024:case 2048:case 4096:case 8192:case 16384:case 32768:case 65536:case 131072:case 262144:case 524288:case 1048576:case 2097152:case 4194304:case 8388608:case 16777216:case 33554432:case 67108864:i=32;break;case 536870912:i=268435456;break;default:i=0}i=i&(r.suspendedLanes|o)?0:i,i!==0&&i!==s.retryLane&&(s.retryLane=i,_r(t,i),Mn(r,t,i,-1))}return Sm(),r=xd(Error(B(421))),fu(t,e,o,r)}return i.data==="$?"?(e.flags|=128,e.child=t.child,e=Ox.bind(null,t),i._reactRetry=e,null):(t=s.treeContext,on=Qr(i.nextSibling),ln=e,$e=!0,Pn=null,t!==null&&(dn[fn++]=sr,dn[fn++]=or,dn[fn++]=ji,sr=t.id,or=t.overflow,ji=e),e=ym(e,r.children),e.flags|=4096,e)}function ev(t,e,n){t.lanes|=e;var r=t.alternate;r!==null&&(r.lanes|=e),Df(t.return,e,n)}function Ad(t,e,n,r,i){var s=t.memoizedState;s===null?t.memoizedState={isBackwards:e,rendering:null,renderingStartTime:0,last:r,tail:n,tailMode:i}:(s.isBackwards=e,s.rendering=null,s.renderingStartTime=0,s.last=r,s.tail=n,s.tailMode=i)}function gT(t,e,n){var r=e.pendingProps,i=r.revealOrder,s=r.tail;if(Bt(t,e,r.children,n),r=We.current,r&2)r=r&1|2,e.flags|=128;else{if(t!==null&&t.flags&128)e:for(t=e.child;t!==null;){if(t.tag===13)t.memoizedState!==null&&ev(t,n,e);else if(t.tag===19)ev(t,n,e);else if(t.child!==null){t.child.return=t,t=t.child;continue}if(t===e)break e;for(;t.sibling===null;){if(t.return===null||t.return===e)break e;t=t.return}t.sibling.return=t.return,t=t.sibling}r&=1}if(De(We,r),!(e.mode&1))e.memoizedState=null;else switch(i){case"forwards":for(n=e.child,i=null;n!==null;)t=n.alternate,t!==null&&fc(t)===null&&(i=n),n=n.sibling;n=i,n===null?(i=e.child,e.child=null):(i=n.sibling,n.sibling=null),Ad(e,!1,i,n,s);break;case"backwards":for(n=null,i=e.child,e.child=null;i!==null;){if(t=i.alternate,t!==null&&fc(t)===null){e.child=i;break}t=i.sibling,i.sibling=n,n=i,i=t}Ad(e,!0,n,null,s);break;case"together":Ad(e,!1,null,null,void 0);break;default:e.memoizedState=null}return e.child}function Lu(t,e){!(e.mode&1)&&t!==null&&(t.alternate=null,e.alternate=null,e.flags|=2)}function yr(t,e,n){if(t!==null&&(e.dependencies=t.dependencies),Bi|=e.lanes,!(n&e.childLanes))return null;if(t!==null&&e.child!==t.child)throw Error(B(153));if(e.child!==null){for(t=e.child,n=Zr(t,t.pendingProps),e.child=n,n.return=e;t.sibling!==null;)t=t.sibling,n=n.sibling=Zr(t,t.pendingProps),n.return=e;n.sibling=null}return e.child}function Tx(t,e,n){switch(e.tag){case 3:pT(e),Ys();break;case 5:BE(e);break;case 1:Jt(e.type)&&ac(e);break;case 4:cm(e,e.stateNode.containerInfo);break;case 10:var r=e.type._context,i=e.memoizedProps.value;De(cc,r._currentValue),r._currentValue=i;break;case 13:if(r=e.memoizedState,r!==null)return r.dehydrated!==null?(De(We,We.current&1),e.flags|=128,null):n&e.child.childLanes?mT(t,e,n):(De(We,We.current&1),t=yr(t,e,n),t!==null?t.sibling:null);De(We,We.current&1);break;case 19:if(r=(n&e.childLanes)!==0,t.flags&128){if(r)return gT(t,e,n);e.flags|=128}if(i=e.memoizedState,i!==null&&(i.rendering=null,i.tail=null,i.lastEffect=null),De(We,We.current),r)break;return null;case 22:case 23:return e.lanes=0,dT(t,e,n)}return yr(t,e,n)}var _T,zf,yT,vT;_T=function(t,e){for(var n=e.child;n!==null;){if(n.tag===5||n.tag===6)t.appendChild(n.stateNode);else if(n.tag!==4&&n.child!==null){n.child.return=n,n=n.child;continue}if(n===e)break;for(;n.sibling===null;){if(n.return===null||n.return===e)return;n=n.return}n.sibling.return=n.return,n=n.sibling}};zf=function(){};yT=function(t,e,n,r){var i=t.memoizedProps;if(i!==r){t=e.stateNode,bi(Hn.current);var s=null;switch(n){case"input":i=uf(t,i),r=uf(t,r),s=[];break;case"select":i=He({},i,{value:void 0}),r=He({},r,{value:void 0}),s=[];break;case"textarea":i=df(t,i),r=df(t,r),s=[];break;default:typeof i.onClick!="function"&&typeof r.onClick=="function"&&(t.onclick=sc)}pf(n,r);var o;n=null;for(c in i)if(!r.hasOwnProperty(c)&&i.hasOwnProperty(c)&&i[c]!=null)if(c==="style"){var a=i[c];for(o in a)a.hasOwnProperty(o)&&(n||(n={}),n[o]="")}else c!=="dangerouslySetInnerHTML"&&c!=="children"&&c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&c!=="autoFocus"&&(La.hasOwnProperty(c)?s||(s=[]):(s=s||[]).push(c,null));for(c in r){var u=r[c];if(a=i!=null?i[c]:void 0,r.hasOwnProperty(c)&&u!==a&&(u!=null||a!=null))if(c==="style")if(a){for(o in a)!a.hasOwnProperty(o)||u&&u.hasOwnProperty(o)||(n||(n={}),n[o]="");for(o in u)u.hasOwnProperty(o)&&a[o]!==u[o]&&(n||(n={}),n[o]=u[o])}else n||(s||(s=[]),s.push(c,n)),n=u;else c==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,a=a?a.__html:void 0,u!=null&&a!==u&&(s=s||[]).push(c,u)):c==="children"?typeof u!="string"&&typeof u!="number"||(s=s||[]).push(c,""+u):c!=="suppressContentEditableWarning"&&c!=="suppressHydrationWarning"&&(La.hasOwnProperty(c)?(u!=null&&c==="onScroll"&&Me("scroll",t),s||a===u||(s=[])):(s=s||[]).push(c,u))}n&&(s=s||[]).push("style",n);var c=s;(e.updateQueue=c)&&(e.flags|=4)}};vT=function(t,e,n,r){n!==r&&(e.flags|=4)};function Yo(t,e){if(!$e)switch(t.tailMode){case"hidden":e=t.tail;for(var n=null;e!==null;)e.alternate!==null&&(n=e),e=e.sibling;n===null?t.tail=null:n.sibling=null;break;case"collapsed":n=t.tail;for(var r=null;n!==null;)n.alternate!==null&&(r=n),n=n.sibling;r===null?e||t.tail===null?t.tail=null:t.tail.sibling=null:r.sibling=null}}function Pt(t){var e=t.alternate!==null&&t.alternate.child===t.child,n=0,r=0;if(e)for(var i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags&14680064,r|=i.flags&14680064,i.return=t,i=i.sibling;else for(i=t.child;i!==null;)n|=i.lanes|i.childLanes,r|=i.subtreeFlags,r|=i.flags,i.return=t,i=i.sibling;return t.subtreeFlags|=r,t.childLanes=n,e}function Ix(t,e,n){var r=e.pendingProps;switch(rm(e),e.tag){case 2:case 16:case 15:case 0:case 11:case 7:case 8:case 12:case 9:case 14:return Pt(e),null;case 1:return Jt(e.type)&&oc(),Pt(e),null;case 3:return r=e.stateNode,Js(),Ue(Xt),Ue(Ft),dm(),r.pendingContext&&(r.context=r.pendingContext,r.pendingContext=null),(t===null||t.child===null)&&(hu(e)?e.flags|=4:t===null||t.memoizedState.isDehydrated&&!(e.flags&256)||(e.flags|=1024,Pn!==null&&(Qf(Pn),Pn=null))),zf(t,e),Pt(e),null;case 5:hm(e);var i=bi(Ka.current);if(n=e.type,t!==null&&e.stateNode!=null)yT(t,e,n,r,i),t.ref!==e.ref&&(e.flags|=512,e.flags|=2097152);else{if(!r){if(e.stateNode===null)throw Error(B(166));return Pt(e),null}if(t=bi(Hn.current),hu(e)){r=e.stateNode,n=e.type;var s=e.memoizedProps;switch(r[Bn]=e,r[Ha]=s,t=(e.mode&1)!==0,n){case"dialog":Me("cancel",r),Me("close",r);break;case"iframe":case"object":case"embed":Me("load",r);break;case"video":case"audio":for(i=0;i<ua.length;i++)Me(ua[i],r);break;case"source":Me("error",r);break;case"img":case"image":case"link":Me("error",r),Me("load",r);break;case"details":Me("toggle",r);break;case"input":uy(r,s),Me("invalid",r);break;case"select":r._wrapperState={wasMultiple:!!s.multiple},Me("invalid",r);break;case"textarea":hy(r,s),Me("invalid",r)}pf(n,s),i=null;for(var o in s)if(s.hasOwnProperty(o)){var a=s[o];o==="children"?typeof a=="string"?r.textContent!==a&&(s.suppressHydrationWarning!==!0&&cu(r.textContent,a,t),i=["children",a]):typeof a=="number"&&r.textContent!==""+a&&(s.suppressHydrationWarning!==!0&&cu(r.textContent,a,t),i=["children",""+a]):La.hasOwnProperty(o)&&a!=null&&o==="onScroll"&&Me("scroll",r)}switch(n){case"input":nu(r),cy(r,s,!0);break;case"textarea":nu(r),dy(r);break;case"select":case"option":break;default:typeof s.onClick=="function"&&(r.onclick=sc)}r=i,e.updateQueue=r,r!==null&&(e.flags|=4)}else{o=i.nodeType===9?i:i.ownerDocument,t==="http://www.w3.org/1999/xhtml"&&(t=Gw(n)),t==="http://www.w3.org/1999/xhtml"?n==="script"?(t=o.createElement("div"),t.innerHTML="<script><\/script>",t=t.removeChild(t.firstChild)):typeof r.is=="string"?t=o.createElement(n,{is:r.is}):(t=o.createElement(n),n==="select"&&(o=t,r.multiple?o.multiple=!0:r.size&&(o.size=r.size))):t=o.createElementNS(t,n),t[Bn]=e,t[Ha]=r,_T(t,e,!1,!1),e.stateNode=t;e:{switch(o=mf(n,r),n){case"dialog":Me("cancel",t),Me("close",t),i=r;break;case"iframe":case"object":case"embed":Me("load",t),i=r;break;case"video":case"audio":for(i=0;i<ua.length;i++)Me(ua[i],t);i=r;break;case"source":Me("error",t),i=r;break;case"img":case"image":case"link":Me("error",t),Me("load",t),i=r;break;case"details":Me("toggle",t),i=r;break;case"input":uy(t,r),i=uf(t,r),Me("invalid",t);break;case"option":i=r;break;case"select":t._wrapperState={wasMultiple:!!r.multiple},i=He({},r,{value:void 0}),Me("invalid",t);break;case"textarea":hy(t,r),i=df(t,r),Me("invalid",t);break;default:i=r}pf(n,i),a=i;for(s in a)if(a.hasOwnProperty(s)){var u=a[s];s==="style"?Yw(t,u):s==="dangerouslySetInnerHTML"?(u=u?u.__html:void 0,u!=null&&Kw(t,u)):s==="children"?typeof u=="string"?(n!=="textarea"||u!=="")&&Fa(t,u):typeof u=="number"&&Fa(t,""+u):s!=="suppressContentEditableWarning"&&s!=="suppressHydrationWarning"&&s!=="autoFocus"&&(La.hasOwnProperty(s)?u!=null&&s==="onScroll"&&Me("scroll",t):u!=null&&Bp(t,s,u,o))}switch(n){case"input":nu(t),cy(t,r,!1);break;case"textarea":nu(t),dy(t);break;case"option":r.value!=null&&t.setAttribute("value",""+ai(r.value));break;case"select":t.multiple=!!r.multiple,s=r.value,s!=null?Ms(t,!!r.multiple,s,!1):r.defaultValue!=null&&Ms(t,!!r.multiple,r.defaultValue,!0);break;default:typeof i.onClick=="function"&&(t.onclick=sc)}switch(n){case"button":case"input":case"select":case"textarea":r=!!r.autoFocus;break e;case"img":r=!0;break e;default:r=!1}}r&&(e.flags|=4)}e.ref!==null&&(e.flags|=512,e.flags|=2097152)}return Pt(e),null;case 6:if(t&&e.stateNode!=null)vT(t,e,t.memoizedProps,r);else{if(typeof r!="string"&&e.stateNode===null)throw Error(B(166));if(n=bi(Ka.current),bi(Hn.current),hu(e)){if(r=e.stateNode,n=e.memoizedProps,r[Bn]=e,(s=r.nodeValue!==n)&&(t=ln,t!==null))switch(t.tag){case 3:cu(r.nodeValue,n,(t.mode&1)!==0);break;case 5:t.memoizedProps.suppressHydrationWarning!==!0&&cu(r.nodeValue,n,(t.mode&1)!==0)}s&&(e.flags|=4)}else r=(n.nodeType===9?n:n.ownerDocument).createTextNode(r),r[Bn]=e,e.stateNode=r}return Pt(e),null;case 13:if(Ue(We),r=e.memoizedState,t===null||t.memoizedState!==null&&t.memoizedState.dehydrated!==null){if($e&&on!==null&&e.mode&1&&!(e.flags&128))FE(),Ys(),e.flags|=98560,s=!1;else if(s=hu(e),r!==null&&r.dehydrated!==null){if(t===null){if(!s)throw Error(B(318));if(s=e.memoizedState,s=s!==null?s.dehydrated:null,!s)throw Error(B(317));s[Bn]=e}else Ys(),!(e.flags&128)&&(e.memoizedState=null),e.flags|=4;Pt(e),s=!1}else Pn!==null&&(Qf(Pn),Pn=null),s=!0;if(!s)return e.flags&65536?e:null}return e.flags&128?(e.lanes=n,e):(r=r!==null,r!==(t!==null&&t.memoizedState!==null)&&r&&(e.child.flags|=8192,e.mode&1&&(t===null||We.current&1?lt===0&&(lt=3):Sm())),e.updateQueue!==null&&(e.flags|=4),Pt(e),null);case 4:return Js(),zf(t,e),t===null&&Wa(e.stateNode.containerInfo),Pt(e),null;case 10:return am(e.type._context),Pt(e),null;case 17:return Jt(e.type)&&oc(),Pt(e),null;case 19:if(Ue(We),s=e.memoizedState,s===null)return Pt(e),null;if(r=(e.flags&128)!==0,o=s.rendering,o===null)if(r)Yo(s,!1);else{if(lt!==0||t!==null&&t.flags&128)for(t=e.child;t!==null;){if(o=fc(t),o!==null){for(e.flags|=128,Yo(s,!1),r=o.updateQueue,r!==null&&(e.updateQueue=r,e.flags|=4),e.subtreeFlags=0,r=n,n=e.child;n!==null;)s=n,t=r,s.flags&=14680066,o=s.alternate,o===null?(s.childLanes=0,s.lanes=t,s.child=null,s.subtreeFlags=0,s.memoizedProps=null,s.memoizedState=null,s.updateQueue=null,s.dependencies=null,s.stateNode=null):(s.childLanes=o.childLanes,s.lanes=o.lanes,s.child=o.child,s.subtreeFlags=0,s.deletions=null,s.memoizedProps=o.memoizedProps,s.memoizedState=o.memoizedState,s.updateQueue=o.updateQueue,s.type=o.type,t=o.dependencies,s.dependencies=t===null?null:{lanes:t.lanes,firstContext:t.firstContext}),n=n.sibling;return De(We,We.current&1|2),e.child}t=t.sibling}s.tail!==null&&Ze()>eo&&(e.flags|=128,r=!0,Yo(s,!1),e.lanes=4194304)}else{if(!r)if(t=fc(o),t!==null){if(e.flags|=128,r=!0,n=t.updateQueue,n!==null&&(e.updateQueue=n,e.flags|=4),Yo(s,!0),s.tail===null&&s.tailMode==="hidden"&&!o.alternate&&!$e)return Pt(e),null}else 2*Ze()-s.renderingStartTime>eo&&n!==1073741824&&(e.flags|=128,r=!0,Yo(s,!1),e.lanes=4194304);s.isBackwards?(o.sibling=e.child,e.child=o):(n=s.last,n!==null?n.sibling=o:e.child=o,s.last=o)}return s.tail!==null?(e=s.tail,s.rendering=e,s.tail=e.sibling,s.renderingStartTime=Ze(),e.sibling=null,n=We.current,De(We,r?n&1|2:n&1),e):(Pt(e),null);case 22:case 23:return Im(),r=e.memoizedState!==null,t!==null&&t.memoizedState!==null!==r&&(e.flags|=8192),r&&e.mode&1?rn&1073741824&&(Pt(e),e.subtreeFlags&6&&(e.flags|=8192)):Pt(e),null;case 24:return null;case 25:return null}throw Error(B(156,e.tag))}function Sx(t,e){switch(rm(e),e.tag){case 1:return Jt(e.type)&&oc(),t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 3:return Js(),Ue(Xt),Ue(Ft),dm(),t=e.flags,t&65536&&!(t&128)?(e.flags=t&-65537|128,e):null;case 5:return hm(e),null;case 13:if(Ue(We),t=e.memoizedState,t!==null&&t.dehydrated!==null){if(e.alternate===null)throw Error(B(340));Ys()}return t=e.flags,t&65536?(e.flags=t&-65537|128,e):null;case 19:return Ue(We),null;case 4:return Js(),null;case 10:return am(e.type._context),null;case 22:case 23:return Im(),null;case 24:return null;default:return null}}var pu=!1,Dt=!1,kx=typeof WeakSet=="function"?WeakSet:Set,Q=null;function Ps(t,e){var n=t.ref;if(n!==null)if(typeof n=="function")try{n(null)}catch(r){Qe(t,e,r)}else n.current=null}function Bf(t,e,n){try{n()}catch(r){Qe(t,e,r)}}var tv=!1;function Cx(t,e){if(kf=nc,t=SE(),tm(t)){if("selectionStart"in t)var n={start:t.selectionStart,end:t.selectionEnd};else e:{n=(n=t.ownerDocument)&&n.defaultView||window;var r=n.getSelection&&n.getSelection();if(r&&r.rangeCount!==0){n=r.anchorNode;var i=r.anchorOffset,s=r.focusNode;r=r.focusOffset;try{n.nodeType,s.nodeType}catch{n=null;break e}var o=0,a=-1,u=-1,c=0,h=0,f=t,m=null;t:for(;;){for(var w;f!==n||i!==0&&f.nodeType!==3||(a=o+i),f!==s||r!==0&&f.nodeType!==3||(u=o+r),f.nodeType===3&&(o+=f.nodeValue.length),(w=f.firstChild)!==null;)m=f,f=w;for(;;){if(f===t)break t;if(m===n&&++c===i&&(a=o),m===s&&++h===r&&(u=o),(w=f.nextSibling)!==null)break;f=m,m=f.parentNode}f=w}n=a===-1||u===-1?null:{start:a,end:u}}else n=null}n=n||{start:0,end:0}}else n=null;for(Cf={focusedElem:t,selectionRange:n},nc=!1,Q=e;Q!==null;)if(e=Q,t=e.child,(e.subtreeFlags&1028)!==0&&t!==null)t.return=e,Q=t;else for(;Q!==null;){e=Q;try{var S=e.alternate;if(e.flags&1024)switch(e.tag){case 0:case 11:case 15:break;case 1:if(S!==null){var P=S.memoizedProps,D=S.memoizedState,k=e.stateNode,T=k.getSnapshotBeforeUpdate(e.elementType===e.type?P:xn(e.type,P),D);k.__reactInternalSnapshotBeforeUpdate=T}break;case 3:var R=e.stateNode.containerInfo;R.nodeType===1?R.textContent="":R.nodeType===9&&R.documentElement&&R.removeChild(R.documentElement);break;case 5:case 6:case 4:case 17:break;default:throw Error(B(163))}}catch(M){Qe(e,e.return,M)}if(t=e.sibling,t!==null){t.return=e.return,Q=t;break}Q=e.return}return S=tv,tv=!1,S}function wa(t,e,n){var r=e.updateQueue;if(r=r!==null?r.lastEffect:null,r!==null){var i=r=r.next;do{if((i.tag&t)===t){var s=i.destroy;i.destroy=void 0,s!==void 0&&Bf(e,n,s)}i=i.next}while(i!==r)}}function oh(t,e){if(e=e.updateQueue,e=e!==null?e.lastEffect:null,e!==null){var n=e=e.next;do{if((n.tag&t)===t){var r=n.create;n.destroy=r()}n=n.next}while(n!==e)}}function $f(t){var e=t.ref;if(e!==null){var n=t.stateNode;switch(t.tag){case 5:t=n;break;default:t=n}typeof e=="function"?e(t):e.current=t}}function wT(t){var e=t.alternate;e!==null&&(t.alternate=null,wT(e)),t.child=null,t.deletions=null,t.sibling=null,t.tag===5&&(e=t.stateNode,e!==null&&(delete e[Bn],delete e[Ha],delete e[Af],delete e[lx],delete e[ux])),t.stateNode=null,t.return=null,t.dependencies=null,t.memoizedProps=null,t.memoizedState=null,t.pendingProps=null,t.stateNode=null,t.updateQueue=null}function ET(t){return t.tag===5||t.tag===3||t.tag===4}function nv(t){e:for(;;){for(;t.sibling===null;){if(t.return===null||ET(t.return))return null;t=t.return}for(t.sibling.return=t.return,t=t.sibling;t.tag!==5&&t.tag!==6&&t.tag!==18;){if(t.flags&2||t.child===null||t.tag===4)continue e;t.child.return=t,t=t.child}if(!(t.flags&2))return t.stateNode}}function Wf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.nodeType===8?n.parentNode.insertBefore(t,e):n.insertBefore(t,e):(n.nodeType===8?(e=n.parentNode,e.insertBefore(t,n)):(e=n,e.appendChild(t)),n=n._reactRootContainer,n!=null||e.onclick!==null||(e.onclick=sc));else if(r!==4&&(t=t.child,t!==null))for(Wf(t,e,n),t=t.sibling;t!==null;)Wf(t,e,n),t=t.sibling}function qf(t,e,n){var r=t.tag;if(r===5||r===6)t=t.stateNode,e?n.insertBefore(t,e):n.appendChild(t);else if(r!==4&&(t=t.child,t!==null))for(qf(t,e,n),t=t.sibling;t!==null;)qf(t,e,n),t=t.sibling}var vt=null,An=!1;function Nr(t,e,n){for(n=n.child;n!==null;)TT(t,e,n),n=n.sibling}function TT(t,e,n){if(qn&&typeof qn.onCommitFiberUnmount=="function")try{qn.onCommitFiberUnmount(Jc,n)}catch{}switch(n.tag){case 5:Dt||Ps(n,e);case 6:var r=vt,i=An;vt=null,Nr(t,e,n),vt=r,An=i,vt!==null&&(An?(t=vt,n=n.stateNode,t.nodeType===8?t.parentNode.removeChild(n):t.removeChild(n)):vt.removeChild(n.stateNode));break;case 18:vt!==null&&(An?(t=vt,n=n.stateNode,t.nodeType===8?Td(t.parentNode,n):t.nodeType===1&&Td(t,n),za(t)):Td(vt,n.stateNode));break;case 4:r=vt,i=An,vt=n.stateNode.containerInfo,An=!0,Nr(t,e,n),vt=r,An=i;break;case 0:case 11:case 14:case 15:if(!Dt&&(r=n.updateQueue,r!==null&&(r=r.lastEffect,r!==null))){i=r=r.next;do{var s=i,o=s.destroy;s=s.tag,o!==void 0&&(s&2||s&4)&&Bf(n,e,o),i=i.next}while(i!==r)}Nr(t,e,n);break;case 1:if(!Dt&&(Ps(n,e),r=n.stateNode,typeof r.componentWillUnmount=="function"))try{r.props=n.memoizedProps,r.state=n.memoizedState,r.componentWillUnmount()}catch(a){Qe(n,e,a)}Nr(t,e,n);break;case 21:Nr(t,e,n);break;case 22:n.mode&1?(Dt=(r=Dt)||n.memoizedState!==null,Nr(t,e,n),Dt=r):Nr(t,e,n);break;default:Nr(t,e,n)}}function rv(t){var e=t.updateQueue;if(e!==null){t.updateQueue=null;var n=t.stateNode;n===null&&(n=t.stateNode=new kx),e.forEach(function(r){var i=Mx.bind(null,t,r);n.has(r)||(n.add(r),r.then(i,i))})}}function Rn(t,e){var n=e.deletions;if(n!==null)for(var r=0;r<n.length;r++){var i=n[r];try{var s=t,o=e,a=o;e:for(;a!==null;){switch(a.tag){case 5:vt=a.stateNode,An=!1;break e;case 3:vt=a.stateNode.containerInfo,An=!0;break e;case 4:vt=a.stateNode.containerInfo,An=!0;break e}a=a.return}if(vt===null)throw Error(B(160));TT(s,o,i),vt=null,An=!1;var u=i.alternate;u!==null&&(u.return=null),i.return=null}catch(c){Qe(i,e,c)}}if(e.subtreeFlags&12854)for(e=e.child;e!==null;)IT(e,t),e=e.sibling}function IT(t,e){var n=t.alternate,r=t.flags;switch(t.tag){case 0:case 11:case 14:case 15:if(Rn(e,t),jn(t),r&4){try{wa(3,t,t.return),oh(3,t)}catch(P){Qe(t,t.return,P)}try{wa(5,t,t.return)}catch(P){Qe(t,t.return,P)}}break;case 1:Rn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return);break;case 5:if(Rn(e,t),jn(t),r&512&&n!==null&&Ps(n,n.return),t.flags&32){var i=t.stateNode;try{Fa(i,"")}catch(P){Qe(t,t.return,P)}}if(r&4&&(i=t.stateNode,i!=null)){var s=t.memoizedProps,o=n!==null?n.memoizedProps:s,a=t.type,u=t.updateQueue;if(t.updateQueue=null,u!==null)try{a==="input"&&s.type==="radio"&&s.name!=null&&qw(i,s),mf(a,o);var c=mf(a,s);for(o=0;o<u.length;o+=2){var h=u[o],f=u[o+1];h==="style"?Yw(i,f):h==="dangerouslySetInnerHTML"?Kw(i,f):h==="children"?Fa(i,f):Bp(i,h,f,c)}switch(a){case"input":cf(i,s);break;case"textarea":Hw(i,s);break;case"select":var m=i._wrapperState.wasMultiple;i._wrapperState.wasMultiple=!!s.multiple;var w=s.value;w!=null?Ms(i,!!s.multiple,w,!1):m!==!!s.multiple&&(s.defaultValue!=null?Ms(i,!!s.multiple,s.defaultValue,!0):Ms(i,!!s.multiple,s.multiple?[]:"",!1))}i[Ha]=s}catch(P){Qe(t,t.return,P)}}break;case 6:if(Rn(e,t),jn(t),r&4){if(t.stateNode===null)throw Error(B(162));i=t.stateNode,s=t.memoizedProps;try{i.nodeValue=s}catch(P){Qe(t,t.return,P)}}break;case 3:if(Rn(e,t),jn(t),r&4&&n!==null&&n.memoizedState.isDehydrated)try{za(e.containerInfo)}catch(P){Qe(t,t.return,P)}break;case 4:Rn(e,t),jn(t);break;case 13:Rn(e,t),jn(t),i=t.child,i.flags&8192&&(s=i.memoizedState!==null,i.stateNode.isHidden=s,!s||i.alternate!==null&&i.alternate.memoizedState!==null||(Em=Ze())),r&4&&rv(t);break;case 22:if(h=n!==null&&n.memoizedState!==null,t.mode&1?(Dt=(c=Dt)||h,Rn(e,t),Dt=c):Rn(e,t),jn(t),r&8192){if(c=t.memoizedState!==null,(t.stateNode.isHidden=c)&&!h&&t.mode&1)for(Q=t,h=t.child;h!==null;){for(f=Q=h;Q!==null;){switch(m=Q,w=m.child,m.tag){case 0:case 11:case 14:case 15:wa(4,m,m.return);break;case 1:Ps(m,m.return);var S=m.stateNode;if(typeof S.componentWillUnmount=="function"){r=m,n=m.return;try{e=r,S.props=e.memoizedProps,S.state=e.memoizedState,S.componentWillUnmount()}catch(P){Qe(r,n,P)}}break;case 5:Ps(m,m.return);break;case 22:if(m.memoizedState!==null){sv(f);continue}}w!==null?(w.return=m,Q=w):sv(f)}h=h.sibling}e:for(h=null,f=t;;){if(f.tag===5){if(h===null){h=f;try{i=f.stateNode,c?(s=i.style,typeof s.setProperty=="function"?s.setProperty("display","none","important"):s.display="none"):(a=f.stateNode,u=f.memoizedProps.style,o=u!=null&&u.hasOwnProperty("display")?u.display:null,a.style.display=Qw("display",o))}catch(P){Qe(t,t.return,P)}}}else if(f.tag===6){if(h===null)try{f.stateNode.nodeValue=c?"":f.memoizedProps}catch(P){Qe(t,t.return,P)}}else if((f.tag!==22&&f.tag!==23||f.memoizedState===null||f===t)&&f.child!==null){f.child.return=f,f=f.child;continue}if(f===t)break e;for(;f.sibling===null;){if(f.return===null||f.return===t)break e;h===f&&(h=null),f=f.return}h===f&&(h=null),f.sibling.return=f.return,f=f.sibling}}break;case 19:Rn(e,t),jn(t),r&4&&rv(t);break;case 21:break;default:Rn(e,t),jn(t)}}function jn(t){var e=t.flags;if(e&2){try{e:{for(var n=t.return;n!==null;){if(ET(n)){var r=n;break e}n=n.return}throw Error(B(160))}switch(r.tag){case 5:var i=r.stateNode;r.flags&32&&(Fa(i,""),r.flags&=-33);var s=nv(t);qf(t,s,i);break;case 3:case 4:var o=r.stateNode.containerInfo,a=nv(t);Wf(t,a,o);break;default:throw Error(B(161))}}catch(u){Qe(t,t.return,u)}t.flags&=-3}e&4096&&(t.flags&=-4097)}function Rx(t,e,n){Q=t,ST(t)}function ST(t,e,n){for(var r=(t.mode&1)!==0;Q!==null;){var i=Q,s=i.child;if(i.tag===22&&r){var o=i.memoizedState!==null||pu;if(!o){var a=i.alternate,u=a!==null&&a.memoizedState!==null||Dt;a=pu;var c=Dt;if(pu=o,(Dt=u)&&!c)for(Q=i;Q!==null;)o=Q,u=o.child,o.tag===22&&o.memoizedState!==null?ov(i):u!==null?(u.return=o,Q=u):ov(i);for(;s!==null;)Q=s,ST(s),s=s.sibling;Q=i,pu=a,Dt=c}iv(t)}else i.subtreeFlags&8772&&s!==null?(s.return=i,Q=s):iv(t)}}function iv(t){for(;Q!==null;){var e=Q;if(e.flags&8772){var n=e.alternate;try{if(e.flags&8772)switch(e.tag){case 0:case 11:case 15:Dt||oh(5,e);break;case 1:var r=e.stateNode;if(e.flags&4&&!Dt)if(n===null)r.componentDidMount();else{var i=e.elementType===e.type?n.memoizedProps:xn(e.type,n.memoizedProps);r.componentDidUpdate(i,n.memoizedState,r.__reactInternalSnapshotBeforeUpdate)}var s=e.updateQueue;s!==null&&By(e,s,r);break;case 3:var o=e.updateQueue;if(o!==null){if(n=null,e.child!==null)switch(e.child.tag){case 5:n=e.child.stateNode;break;case 1:n=e.child.stateNode}By(e,o,n)}break;case 5:var a=e.stateNode;if(n===null&&e.flags&4){n=a;var u=e.memoizedProps;switch(e.type){case"button":case"input":case"select":case"textarea":u.autoFocus&&n.focus();break;case"img":u.src&&(n.src=u.src)}}break;case 6:break;case 4:break;case 12:break;case 13:if(e.memoizedState===null){var c=e.alternate;if(c!==null){var h=c.memoizedState;if(h!==null){var f=h.dehydrated;f!==null&&za(f)}}}break;case 19:case 17:case 21:case 22:case 23:case 25:break;default:throw Error(B(163))}Dt||e.flags&512&&$f(e)}catch(m){Qe(e,e.return,m)}}if(e===t){Q=null;break}if(n=e.sibling,n!==null){n.return=e.return,Q=n;break}Q=e.return}}function sv(t){for(;Q!==null;){var e=Q;if(e===t){Q=null;break}var n=e.sibling;if(n!==null){n.return=e.return,Q=n;break}Q=e.return}}function ov(t){for(;Q!==null;){var e=Q;try{switch(e.tag){case 0:case 11:case 15:var n=e.return;try{oh(4,e)}catch(u){Qe(e,n,u)}break;case 1:var r=e.stateNode;if(typeof r.componentDidMount=="function"){var i=e.return;try{r.componentDidMount()}catch(u){Qe(e,i,u)}}var s=e.return;try{$f(e)}catch(u){Qe(e,s,u)}break;case 5:var o=e.return;try{$f(e)}catch(u){Qe(e,o,u)}}}catch(u){Qe(e,e.return,u)}if(e===t){Q=null;break}var a=e.sibling;if(a!==null){a.return=e.return,Q=a;break}Q=e.return}}var xx=Math.ceil,gc=Rr.ReactCurrentDispatcher,vm=Rr.ReactCurrentOwner,vn=Rr.ReactCurrentBatchConfig,ye=0,mt=null,nt=null,It=0,rn=0,bs=gi(0),lt=0,Ja=null,Bi=0,ah=0,wm=0,Ea=null,Kt=null,Em=0,eo=1/0,rr=null,_c=!1,Hf=null,Xr=null,mu=!1,Wr=null,yc=0,Ta=0,Gf=null,Fu=-1,Vu=0;function $t(){return ye&6?Ze():Fu!==-1?Fu:Fu=Ze()}function Jr(t){return t.mode&1?ye&2&&It!==0?It&-It:hx.transition!==null?(Vu===0&&(Vu=lE()),Vu):(t=Se,t!==0||(t=window.event,t=t===void 0?16:mE(t.type)),t):1}function Mn(t,e,n,r){if(50<Ta)throw Ta=0,Gf=null,Error(B(185));pl(t,n,r),(!(ye&2)||t!==mt)&&(t===mt&&(!(ye&2)&&(ah|=n),lt===4&&Fr(t,It)),Zt(t,r),n===1&&ye===0&&!(e.mode&1)&&(eo=Ze()+500,rh&&_i()))}function Zt(t,e){var n=t.callbackNode;hR(t,e);var r=tc(t,t===mt?It:0);if(r===0)n!==null&&my(n),t.callbackNode=null,t.callbackPriority=0;else if(e=r&-r,t.callbackPriority!==e){if(n!=null&&my(n),e===1)t.tag===0?cx(av.bind(null,t)):OE(av.bind(null,t)),ox(function(){!(ye&6)&&_i()}),n=null;else{switch(uE(r)){case 1:n=Gp;break;case 4:n=oE;break;case 16:n=ec;break;case 536870912:n=aE;break;default:n=ec}n=NT(n,kT.bind(null,t))}t.callbackPriority=e,t.callbackNode=n}}function kT(t,e){if(Fu=-1,Vu=0,ye&6)throw Error(B(327));var n=t.callbackNode;if(js()&&t.callbackNode!==n)return null;var r=tc(t,t===mt?It:0);if(r===0)return null;if(r&30||r&t.expiredLanes||e)e=vc(t,r);else{e=r;var i=ye;ye|=2;var s=RT();(mt!==t||It!==e)&&(rr=null,eo=Ze()+500,Mi(t,e));do try{bx();break}catch(a){CT(t,a)}while(!0);om(),gc.current=s,ye=i,nt!==null?e=0:(mt=null,It=0,e=lt)}if(e!==0){if(e===2&&(i=wf(t),i!==0&&(r=i,e=Kf(t,i))),e===1)throw n=Ja,Mi(t,0),Fr(t,r),Zt(t,Ze()),n;if(e===6)Fr(t,r);else{if(i=t.current.alternate,!(r&30)&&!Ax(i)&&(e=vc(t,r),e===2&&(s=wf(t),s!==0&&(r=s,e=Kf(t,s))),e===1))throw n=Ja,Mi(t,0),Fr(t,r),Zt(t,Ze()),n;switch(t.finishedWork=i,t.finishedLanes=r,e){case 0:case 1:throw Error(B(345));case 2:ki(t,Kt,rr);break;case 3:if(Fr(t,r),(r&130023424)===r&&(e=Em+500-Ze(),10<e)){if(tc(t,0)!==0)break;if(i=t.suspendedLanes,(i&r)!==r){$t(),t.pingedLanes|=t.suspendedLanes&i;break}t.timeoutHandle=xf(ki.bind(null,t,Kt,rr),e);break}ki(t,Kt,rr);break;case 4:if(Fr(t,r),(r&4194240)===r)break;for(e=t.eventTimes,i=-1;0<r;){var o=31-On(r);s=1<<o,o=e[o],o>i&&(i=o),r&=~s}if(r=i,r=Ze()-r,r=(120>r?120:480>r?480:1080>r?1080:1920>r?1920:3e3>r?3e3:4320>r?4320:1960*xx(r/1960))-r,10<r){t.timeoutHandle=xf(ki.bind(null,t,Kt,rr),r);break}ki(t,Kt,rr);break;case 5:ki(t,Kt,rr);break;default:throw Error(B(329))}}}return Zt(t,Ze()),t.callbackNode===n?kT.bind(null,t):null}function Kf(t,e){var n=Ea;return t.current.memoizedState.isDehydrated&&(Mi(t,e).flags|=256),t=vc(t,e),t!==2&&(e=Kt,Kt=n,e!==null&&Qf(e)),t}function Qf(t){Kt===null?Kt=t:Kt.push.apply(Kt,t)}function Ax(t){for(var e=t;;){if(e.flags&16384){var n=e.updateQueue;if(n!==null&&(n=n.stores,n!==null))for(var r=0;r<n.length;r++){var i=n[r],s=i.getSnapshot;i=i.value;try{if(!Fn(s(),i))return!1}catch{return!1}}}if(n=e.child,e.subtreeFlags&16384&&n!==null)n.return=e,e=n;else{if(e===t)break;for(;e.sibling===null;){if(e.return===null||e.return===t)return!0;e=e.return}e.sibling.return=e.return,e=e.sibling}}return!0}function Fr(t,e){for(e&=~wm,e&=~ah,t.suspendedLanes|=e,t.pingedLanes&=~e,t=t.expirationTimes;0<e;){var n=31-On(e),r=1<<n;t[n]=-1,e&=~r}}function av(t){if(ye&6)throw Error(B(327));js();var e=tc(t,0);if(!(e&1))return Zt(t,Ze()),null;var n=vc(t,e);if(t.tag!==0&&n===2){var r=wf(t);r!==0&&(e=r,n=Kf(t,r))}if(n===1)throw n=Ja,Mi(t,0),Fr(t,e),Zt(t,Ze()),n;if(n===6)throw Error(B(345));return t.finishedWork=t.current.alternate,t.finishedLanes=e,ki(t,Kt,rr),Zt(t,Ze()),null}function Tm(t,e){var n=ye;ye|=1;try{return t(e)}finally{ye=n,ye===0&&(eo=Ze()+500,rh&&_i())}}function $i(t){Wr!==null&&Wr.tag===0&&!(ye&6)&&js();var e=ye;ye|=1;var n=vn.transition,r=Se;try{if(vn.transition=null,Se=1,t)return t()}finally{Se=r,vn.transition=n,ye=e,!(ye&6)&&_i()}}function Im(){rn=bs.current,Ue(bs)}function Mi(t,e){t.finishedWork=null,t.finishedLanes=0;var n=t.timeoutHandle;if(n!==-1&&(t.timeoutHandle=-1,sx(n)),nt!==null)for(n=nt.return;n!==null;){var r=n;switch(rm(r),r.tag){case 1:r=r.type.childContextTypes,r!=null&&oc();break;case 3:Js(),Ue(Xt),Ue(Ft),dm();break;case 5:hm(r);break;case 4:Js();break;case 13:Ue(We);break;case 19:Ue(We);break;case 10:am(r.type._context);break;case 22:case 23:Im()}n=n.return}if(mt=t,nt=t=Zr(t.current,null),It=rn=e,lt=0,Ja=null,wm=ah=Bi=0,Kt=Ea=null,Pi!==null){for(e=0;e<Pi.length;e++)if(n=Pi[e],r=n.interleaved,r!==null){n.interleaved=null;var i=r.next,s=n.pending;if(s!==null){var o=s.next;s.next=i,r.next=o}n.pending=r}Pi=null}return t}function CT(t,e){do{var n=nt;try{if(om(),Ou.current=mc,pc){for(var r=qe.memoizedState;r!==null;){var i=r.queue;i!==null&&(i.pending=null),r=r.next}pc=!1}if(zi=0,ft=ot=qe=null,va=!1,Qa=0,vm.current=null,n===null||n.return===null){lt=1,Ja=e,nt=null;break}e:{var s=t,o=n.return,a=n,u=e;if(e=It,a.flags|=32768,u!==null&&typeof u=="object"&&typeof u.then=="function"){var c=u,h=a,f=h.tag;if(!(h.mode&1)&&(f===0||f===11||f===15)){var m=h.alternate;m?(h.updateQueue=m.updateQueue,h.memoizedState=m.memoizedState,h.lanes=m.lanes):(h.updateQueue=null,h.memoizedState=null)}var w=Ky(o);if(w!==null){w.flags&=-257,Qy(w,o,a,s,e),w.mode&1&&Gy(s,c,e),e=w,u=c;var S=e.updateQueue;if(S===null){var P=new Set;P.add(u),e.updateQueue=P}else S.add(u);break e}else{if(!(e&1)){Gy(s,c,e),Sm();break e}u=Error(B(426))}}else if($e&&a.mode&1){var D=Ky(o);if(D!==null){!(D.flags&65536)&&(D.flags|=256),Qy(D,o,a,s,e),im(Zs(u,a));break e}}s=u=Zs(u,a),lt!==4&&(lt=2),Ea===null?Ea=[s]:Ea.push(s),s=o;do{switch(s.tag){case 3:s.flags|=65536,e&=-e,s.lanes|=e;var k=uT(s,u,e);zy(s,k);break e;case 1:a=u;var T=s.type,R=s.stateNode;if(!(s.flags&128)&&(typeof T.getDerivedStateFromError=="function"||R!==null&&typeof R.componentDidCatch=="function"&&(Xr===null||!Xr.has(R)))){s.flags|=65536,e&=-e,s.lanes|=e;var M=cT(s,a,e);zy(s,M);break e}}s=s.return}while(s!==null)}AT(n)}catch(z){e=z,nt===n&&n!==null&&(nt=n=n.return);continue}break}while(!0)}function RT(){var t=gc.current;return gc.current=mc,t===null?mc:t}function Sm(){(lt===0||lt===3||lt===2)&&(lt=4),mt===null||!(Bi&268435455)&&!(ah&268435455)||Fr(mt,It)}function vc(t,e){var n=ye;ye|=2;var r=RT();(mt!==t||It!==e)&&(rr=null,Mi(t,e));do try{Px();break}catch(i){CT(t,i)}while(!0);if(om(),ye=n,gc.current=r,nt!==null)throw Error(B(261));return mt=null,It=0,lt}function Px(){for(;nt!==null;)xT(nt)}function bx(){for(;nt!==null&&!nR();)xT(nt)}function xT(t){var e=bT(t.alternate,t,rn);t.memoizedProps=t.pendingProps,e===null?AT(t):nt=e,vm.current=null}function AT(t){var e=t;do{var n=e.alternate;if(t=e.return,e.flags&32768){if(n=Sx(n,e),n!==null){n.flags&=32767,nt=n;return}if(t!==null)t.flags|=32768,t.subtreeFlags=0,t.deletions=null;else{lt=6,nt=null;return}}else if(n=Ix(n,e,rn),n!==null){nt=n;return}if(e=e.sibling,e!==null){nt=e;return}nt=e=t}while(e!==null);lt===0&&(lt=5)}function ki(t,e,n){var r=Se,i=vn.transition;try{vn.transition=null,Se=1,Nx(t,e,n,r)}finally{vn.transition=i,Se=r}return null}function Nx(t,e,n,r){do js();while(Wr!==null);if(ye&6)throw Error(B(327));n=t.finishedWork;var i=t.finishedLanes;if(n===null)return null;if(t.finishedWork=null,t.finishedLanes=0,n===t.current)throw Error(B(177));t.callbackNode=null,t.callbackPriority=0;var s=n.lanes|n.childLanes;if(dR(t,s),t===mt&&(nt=mt=null,It=0),!(n.subtreeFlags&2064)&&!(n.flags&2064)||mu||(mu=!0,NT(ec,function(){return js(),null})),s=(n.flags&15990)!==0,n.subtreeFlags&15990||s){s=vn.transition,vn.transition=null;var o=Se;Se=1;var a=ye;ye|=4,vm.current=null,Cx(t,n),IT(n,t),JR(Cf),nc=!!kf,Cf=kf=null,t.current=n,Rx(n),rR(),ye=a,Se=o,vn.transition=s}else t.current=n;if(mu&&(mu=!1,Wr=t,yc=i),s=t.pendingLanes,s===0&&(Xr=null),oR(n.stateNode),Zt(t,Ze()),e!==null)for(r=t.onRecoverableError,n=0;n<e.length;n++)i=e[n],r(i.value,{componentStack:i.stack,digest:i.digest});if(_c)throw _c=!1,t=Hf,Hf=null,t;return yc&1&&t.tag!==0&&js(),s=t.pendingLanes,s&1?t===Gf?Ta++:(Ta=0,Gf=t):Ta=0,_i(),null}function js(){if(Wr!==null){var t=uE(yc),e=vn.transition,n=Se;try{if(vn.transition=null,Se=16>t?16:t,Wr===null)var r=!1;else{if(t=Wr,Wr=null,yc=0,ye&6)throw Error(B(331));var i=ye;for(ye|=4,Q=t.current;Q!==null;){var s=Q,o=s.child;if(Q.flags&16){var a=s.deletions;if(a!==null){for(var u=0;u<a.length;u++){var c=a[u];for(Q=c;Q!==null;){var h=Q;switch(h.tag){case 0:case 11:case 15:wa(8,h,s)}var f=h.child;if(f!==null)f.return=h,Q=f;else for(;Q!==null;){h=Q;var m=h.sibling,w=h.return;if(wT(h),h===c){Q=null;break}if(m!==null){m.return=w,Q=m;break}Q=w}}}var S=s.alternate;if(S!==null){var P=S.child;if(P!==null){S.child=null;do{var D=P.sibling;P.sibling=null,P=D}while(P!==null)}}Q=s}}if(s.subtreeFlags&2064&&o!==null)o.return=s,Q=o;else e:for(;Q!==null;){if(s=Q,s.flags&2048)switch(s.tag){case 0:case 11:case 15:wa(9,s,s.return)}var k=s.sibling;if(k!==null){k.return=s.return,Q=k;break e}Q=s.return}}var T=t.current;for(Q=T;Q!==null;){o=Q;var R=o.child;if(o.subtreeFlags&2064&&R!==null)R.return=o,Q=R;else e:for(o=T;Q!==null;){if(a=Q,a.flags&2048)try{switch(a.tag){case 0:case 11:case 15:oh(9,a)}}catch(z){Qe(a,a.return,z)}if(a===o){Q=null;break e}var M=a.sibling;if(M!==null){M.return=a.return,Q=M;break e}Q=a.return}}if(ye=i,_i(),qn&&typeof qn.onPostCommitFiberRoot=="function")try{qn.onPostCommitFiberRoot(Jc,t)}catch{}r=!0}return r}finally{Se=n,vn.transition=e}}return!1}function lv(t,e,n){e=Zs(n,e),e=uT(t,e,1),t=Yr(t,e,1),e=$t(),t!==null&&(pl(t,1,e),Zt(t,e))}function Qe(t,e,n){if(t.tag===3)lv(t,t,n);else for(;e!==null;){if(e.tag===3){lv(e,t,n);break}else if(e.tag===1){var r=e.stateNode;if(typeof e.type.getDerivedStateFromError=="function"||typeof r.componentDidCatch=="function"&&(Xr===null||!Xr.has(r))){t=Zs(n,t),t=cT(e,t,1),e=Yr(e,t,1),t=$t(),e!==null&&(pl(e,1,t),Zt(e,t));break}}e=e.return}}function Dx(t,e,n){var r=t.pingCache;r!==null&&r.delete(e),e=$t(),t.pingedLanes|=t.suspendedLanes&n,mt===t&&(It&n)===n&&(lt===4||lt===3&&(It&130023424)===It&&500>Ze()-Em?Mi(t,0):wm|=n),Zt(t,e)}function PT(t,e){e===0&&(t.mode&1?(e=su,su<<=1,!(su&130023424)&&(su=4194304)):e=1);var n=$t();t=_r(t,e),t!==null&&(pl(t,e,n),Zt(t,n))}function Ox(t){var e=t.memoizedState,n=0;e!==null&&(n=e.retryLane),PT(t,n)}function Mx(t,e){var n=0;switch(t.tag){case 13:var r=t.stateNode,i=t.memoizedState;i!==null&&(n=i.retryLane);break;case 19:r=t.stateNode;break;default:throw Error(B(314))}r!==null&&r.delete(e),PT(t,n)}var bT;bT=function(t,e,n){if(t!==null)if(t.memoizedProps!==e.pendingProps||Xt.current)Qt=!0;else{if(!(t.lanes&n)&&!(e.flags&128))return Qt=!1,Tx(t,e,n);Qt=!!(t.flags&131072)}else Qt=!1,$e&&e.flags&1048576&&ME(e,uc,e.index);switch(e.lanes=0,e.tag){case 2:var r=e.type;Lu(t,e),t=e.pendingProps;var i=Qs(e,Ft.current);Us(e,n),i=pm(null,e,r,t,i,n);var s=mm();return e.flags|=1,typeof i=="object"&&i!==null&&typeof i.render=="function"&&i.$$typeof===void 0?(e.tag=1,e.memoizedState=null,e.updateQueue=null,Jt(r)?(s=!0,ac(e)):s=!1,e.memoizedState=i.state!==null&&i.state!==void 0?i.state:null,um(e),i.updater=sh,e.stateNode=i,i._reactInternals=e,Mf(e,r,t,n),e=Vf(null,e,r,!0,s,n)):(e.tag=0,$e&&s&&nm(e),Bt(null,e,i,n),e=e.child),e;case 16:r=e.elementType;e:{switch(Lu(t,e),t=e.pendingProps,i=r._init,r=i(r._payload),e.type=r,i=e.tag=Fx(r),t=xn(r,t),i){case 0:e=Ff(null,e,r,t,n);break e;case 1:e=Jy(null,e,r,t,n);break e;case 11:e=Yy(null,e,r,t,n);break e;case 14:e=Xy(null,e,r,xn(r.type,t),n);break e}throw Error(B(306,r,""))}return e;case 0:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:xn(r,i),Ff(t,e,r,i,n);case 1:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:xn(r,i),Jy(t,e,r,i,n);case 3:e:{if(pT(e),t===null)throw Error(B(387));r=e.pendingProps,s=e.memoizedState,i=s.element,zE(t,e),dc(e,r,null,n);var o=e.memoizedState;if(r=o.element,s.isDehydrated)if(s={element:r,isDehydrated:!1,cache:o.cache,pendingSuspenseBoundaries:o.pendingSuspenseBoundaries,transitions:o.transitions},e.updateQueue.baseState=s,e.memoizedState=s,e.flags&256){i=Zs(Error(B(423)),e),e=Zy(t,e,r,n,i);break e}else if(r!==i){i=Zs(Error(B(424)),e),e=Zy(t,e,r,n,i);break e}else for(on=Qr(e.stateNode.containerInfo.firstChild),ln=e,$e=!0,Pn=null,n=UE(e,null,r,n),e.child=n;n;)n.flags=n.flags&-3|4096,n=n.sibling;else{if(Ys(),r===i){e=yr(t,e,n);break e}Bt(t,e,r,n)}e=e.child}return e;case 5:return BE(e),t===null&&Nf(e),r=e.type,i=e.pendingProps,s=t!==null?t.memoizedProps:null,o=i.children,Rf(r,i)?o=null:s!==null&&Rf(r,s)&&(e.flags|=32),fT(t,e),Bt(t,e,o,n),e.child;case 6:return t===null&&Nf(e),null;case 13:return mT(t,e,n);case 4:return cm(e,e.stateNode.containerInfo),r=e.pendingProps,t===null?e.child=Xs(e,null,r,n):Bt(t,e,r,n),e.child;case 11:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:xn(r,i),Yy(t,e,r,i,n);case 7:return Bt(t,e,e.pendingProps,n),e.child;case 8:return Bt(t,e,e.pendingProps.children,n),e.child;case 12:return Bt(t,e,e.pendingProps.children,n),e.child;case 10:e:{if(r=e.type._context,i=e.pendingProps,s=e.memoizedProps,o=i.value,De(cc,r._currentValue),r._currentValue=o,s!==null)if(Fn(s.value,o)){if(s.children===i.children&&!Xt.current){e=yr(t,e,n);break e}}else for(s=e.child,s!==null&&(s.return=e);s!==null;){var a=s.dependencies;if(a!==null){o=s.child;for(var u=a.firstContext;u!==null;){if(u.context===r){if(s.tag===1){u=dr(-1,n&-n),u.tag=2;var c=s.updateQueue;if(c!==null){c=c.shared;var h=c.pending;h===null?u.next=u:(u.next=h.next,h.next=u),c.pending=u}}s.lanes|=n,u=s.alternate,u!==null&&(u.lanes|=n),Df(s.return,n,e),a.lanes|=n;break}u=u.next}}else if(s.tag===10)o=s.type===e.type?null:s.child;else if(s.tag===18){if(o=s.return,o===null)throw Error(B(341));o.lanes|=n,a=o.alternate,a!==null&&(a.lanes|=n),Df(o,n,e),o=s.sibling}else o=s.child;if(o!==null)o.return=s;else for(o=s;o!==null;){if(o===e){o=null;break}if(s=o.sibling,s!==null){s.return=o.return,o=s;break}o=o.return}s=o}Bt(t,e,i.children,n),e=e.child}return e;case 9:return i=e.type,r=e.pendingProps.children,Us(e,n),i=Tn(i),r=r(i),e.flags|=1,Bt(t,e,r,n),e.child;case 14:return r=e.type,i=xn(r,e.pendingProps),i=xn(r.type,i),Xy(t,e,r,i,n);case 15:return hT(t,e,e.type,e.pendingProps,n);case 17:return r=e.type,i=e.pendingProps,i=e.elementType===r?i:xn(r,i),Lu(t,e),e.tag=1,Jt(r)?(t=!0,ac(e)):t=!1,Us(e,n),lT(e,r,i),Mf(e,r,i,n),Vf(null,e,r,!0,t,n);case 19:return gT(t,e,n);case 22:return dT(t,e,n)}throw Error(B(156,e.tag))};function NT(t,e){return sE(t,e)}function Lx(t,e,n,r){this.tag=t,this.key=n,this.sibling=this.child=this.return=this.stateNode=this.type=this.elementType=null,this.index=0,this.ref=null,this.pendingProps=e,this.dependencies=this.memoizedState=this.updateQueue=this.memoizedProps=null,this.mode=r,this.subtreeFlags=this.flags=0,this.deletions=null,this.childLanes=this.lanes=0,this.alternate=null}function mn(t,e,n,r){return new Lx(t,e,n,r)}function km(t){return t=t.prototype,!(!t||!t.isReactComponent)}function Fx(t){if(typeof t=="function")return km(t)?1:0;if(t!=null){if(t=t.$$typeof,t===Wp)return 11;if(t===qp)return 14}return 2}function Zr(t,e){var n=t.alternate;return n===null?(n=mn(t.tag,e,t.key,t.mode),n.elementType=t.elementType,n.type=t.type,n.stateNode=t.stateNode,n.alternate=t,t.alternate=n):(n.pendingProps=e,n.type=t.type,n.flags=0,n.subtreeFlags=0,n.deletions=null),n.flags=t.flags&14680064,n.childLanes=t.childLanes,n.lanes=t.lanes,n.child=t.child,n.memoizedProps=t.memoizedProps,n.memoizedState=t.memoizedState,n.updateQueue=t.updateQueue,e=t.dependencies,n.dependencies=e===null?null:{lanes:e.lanes,firstContext:e.firstContext},n.sibling=t.sibling,n.index=t.index,n.ref=t.ref,n}function Uu(t,e,n,r,i,s){var o=2;if(r=t,typeof t=="function")km(t)&&(o=1);else if(typeof t=="string")o=5;else e:switch(t){case Es:return Li(n.children,i,s,e);case $p:o=8,i|=8;break;case sf:return t=mn(12,n,e,i|2),t.elementType=sf,t.lanes=s,t;case of:return t=mn(13,n,e,i),t.elementType=of,t.lanes=s,t;case af:return t=mn(19,n,e,i),t.elementType=af,t.lanes=s,t;case Bw:return lh(n,i,s,e);default:if(typeof t=="object"&&t!==null)switch(t.$$typeof){case jw:o=10;break e;case zw:o=9;break e;case Wp:o=11;break e;case qp:o=14;break e;case Or:o=16,r=null;break e}throw Error(B(130,t==null?t:typeof t,""))}return e=mn(o,n,e,i),e.elementType=t,e.type=r,e.lanes=s,e}function Li(t,e,n,r){return t=mn(7,t,r,e),t.lanes=n,t}function lh(t,e,n,r){return t=mn(22,t,r,e),t.elementType=Bw,t.lanes=n,t.stateNode={isHidden:!1},t}function Pd(t,e,n){return t=mn(6,t,null,e),t.lanes=n,t}function bd(t,e,n){return e=mn(4,t.children!==null?t.children:[],t.key,e),e.lanes=n,e.stateNode={containerInfo:t.containerInfo,pendingChildren:null,implementation:t.implementation},e}function Vx(t,e,n,r,i){this.tag=e,this.containerInfo=t,this.finishedWork=this.pingCache=this.current=this.pendingChildren=null,this.timeoutHandle=-1,this.callbackNode=this.pendingContext=this.context=null,this.callbackPriority=0,this.eventTimes=hd(0),this.expirationTimes=hd(-1),this.entangledLanes=this.finishedLanes=this.mutableReadLanes=this.expiredLanes=this.pingedLanes=this.suspendedLanes=this.pendingLanes=0,this.entanglements=hd(0),this.identifierPrefix=r,this.onRecoverableError=i,this.mutableSourceEagerHydrationData=null}function Cm(t,e,n,r,i,s,o,a,u){return t=new Vx(t,e,n,a,u),e===1?(e=1,s===!0&&(e|=8)):e=0,s=mn(3,null,null,e),t.current=s,s.stateNode=t,s.memoizedState={element:r,isDehydrated:n,cache:null,transitions:null,pendingSuspenseBoundaries:null},um(s),t}function Ux(t,e,n){var r=3<arguments.length&&arguments[3]!==void 0?arguments[3]:null;return{$$typeof:ws,key:r==null?null:""+r,children:t,containerInfo:e,implementation:n}}function DT(t){if(!t)return li;t=t._reactInternals;e:{if(es(t)!==t||t.tag!==1)throw Error(B(170));var e=t;do{switch(e.tag){case 3:e=e.stateNode.context;break e;case 1:if(Jt(e.type)){e=e.stateNode.__reactInternalMemoizedMergedChildContext;break e}}e=e.return}while(e!==null);throw Error(B(171))}if(t.tag===1){var n=t.type;if(Jt(n))return DE(t,n,e)}return e}function OT(t,e,n,r,i,s,o,a,u){return t=Cm(n,r,!0,t,i,s,o,a,u),t.context=DT(null),n=t.current,r=$t(),i=Jr(n),s=dr(r,i),s.callback=e??null,Yr(n,s,i),t.current.lanes=i,pl(t,i,r),Zt(t,r),t}function uh(t,e,n,r){var i=e.current,s=$t(),o=Jr(i);return n=DT(n),e.context===null?e.context=n:e.pendingContext=n,e=dr(s,o),e.payload={element:t},r=r===void 0?null:r,r!==null&&(e.callback=r),t=Yr(i,e,o),t!==null&&(Mn(t,i,o,s),Du(t,i,o)),o}function wc(t){if(t=t.current,!t.child)return null;switch(t.child.tag){case 5:return t.child.stateNode;default:return t.child.stateNode}}function uv(t,e){if(t=t.memoizedState,t!==null&&t.dehydrated!==null){var n=t.retryLane;t.retryLane=n!==0&&n<e?n:e}}function Rm(t,e){uv(t,e),(t=t.alternate)&&uv(t,e)}function jx(){return null}var MT=typeof reportError=="function"?reportError:function(t){console.error(t)};function xm(t){this._internalRoot=t}ch.prototype.render=xm.prototype.render=function(t){var e=this._internalRoot;if(e===null)throw Error(B(409));uh(t,e,null,null)};ch.prototype.unmount=xm.prototype.unmount=function(){var t=this._internalRoot;if(t!==null){this._internalRoot=null;var e=t.containerInfo;$i(function(){uh(null,t,null,null)}),e[gr]=null}};function ch(t){this._internalRoot=t}ch.prototype.unstable_scheduleHydration=function(t){if(t){var e=dE();t={blockedOn:null,target:t,priority:e};for(var n=0;n<Lr.length&&e!==0&&e<Lr[n].priority;n++);Lr.splice(n,0,t),n===0&&pE(t)}};function Am(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11)}function hh(t){return!(!t||t.nodeType!==1&&t.nodeType!==9&&t.nodeType!==11&&(t.nodeType!==8||t.nodeValue!==" react-mount-point-unstable "))}function cv(){}function zx(t,e,n,r,i){if(i){if(typeof r=="function"){var s=r;r=function(){var c=wc(o);s.call(c)}}var o=OT(e,r,t,0,null,!1,!1,"",cv);return t._reactRootContainer=o,t[gr]=o.current,Wa(t.nodeType===8?t.parentNode:t),$i(),o}for(;i=t.lastChild;)t.removeChild(i);if(typeof r=="function"){var a=r;r=function(){var c=wc(u);a.call(c)}}var u=Cm(t,0,!1,null,null,!1,!1,"",cv);return t._reactRootContainer=u,t[gr]=u.current,Wa(t.nodeType===8?t.parentNode:t),$i(function(){uh(e,u,n,r)}),u}function dh(t,e,n,r,i){var s=n._reactRootContainer;if(s){var o=s;if(typeof i=="function"){var a=i;i=function(){var u=wc(o);a.call(u)}}uh(e,o,t,i)}else o=zx(n,e,t,i,r);return wc(o)}cE=function(t){switch(t.tag){case 3:var e=t.stateNode;if(e.current.memoizedState.isDehydrated){var n=la(e.pendingLanes);n!==0&&(Kp(e,n|1),Zt(e,Ze()),!(ye&6)&&(eo=Ze()+500,_i()))}break;case 13:$i(function(){var r=_r(t,1);if(r!==null){var i=$t();Mn(r,t,1,i)}}),Rm(t,1)}};Qp=function(t){if(t.tag===13){var e=_r(t,134217728);if(e!==null){var n=$t();Mn(e,t,134217728,n)}Rm(t,134217728)}};hE=function(t){if(t.tag===13){var e=Jr(t),n=_r(t,e);if(n!==null){var r=$t();Mn(n,t,e,r)}Rm(t,e)}};dE=function(){return Se};fE=function(t,e){var n=Se;try{return Se=t,e()}finally{Se=n}};_f=function(t,e,n){switch(e){case"input":if(cf(t,n),e=n.name,n.type==="radio"&&e!=null){for(n=t;n.parentNode;)n=n.parentNode;for(n=n.querySelectorAll("input[name="+JSON.stringify(""+e)+'][type="radio"]'),e=0;e<n.length;e++){var r=n[e];if(r!==t&&r.form===t.form){var i=nh(r);if(!i)throw Error(B(90));Ww(r),cf(r,i)}}}break;case"textarea":Hw(t,n);break;case"select":e=n.value,e!=null&&Ms(t,!!n.multiple,e,!1)}};Zw=Tm;eE=$i;var Bx={usingClientEntryPoint:!1,Events:[gl,ks,nh,Xw,Jw,Tm]},Xo={findFiberByHostInstance:Ai,bundleType:0,version:"18.3.1",rendererPackageName:"react-dom"},$x={bundleType:Xo.bundleType,version:Xo.version,rendererPackageName:Xo.rendererPackageName,rendererConfig:Xo.rendererConfig,overrideHookState:null,overrideHookStateDeletePath:null,overrideHookStateRenamePath:null,overrideProps:null,overridePropsDeletePath:null,overridePropsRenamePath:null,setErrorHandler:null,setSuspenseHandler:null,scheduleUpdate:null,currentDispatcherRef:Rr.ReactCurrentDispatcher,findHostInstanceByFiber:function(t){return t=rE(t),t===null?null:t.stateNode},findFiberByHostInstance:Xo.findFiberByHostInstance||jx,findHostInstancesForRefresh:null,scheduleRefresh:null,scheduleRoot:null,setRefreshHandler:null,getCurrentFiber:null,reconcilerVersion:"18.3.1-next-f1338f8080-20240426"};if(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__<"u"){var gu=__REACT_DEVTOOLS_GLOBAL_HOOK__;if(!gu.isDisabled&&gu.supportsFiber)try{Jc=gu.inject($x),qn=gu}catch{}}cn.__SECRET_INTERNALS_DO_NOT_USE_OR_YOU_WILL_BE_FIRED=Bx;cn.createPortal=function(t,e){var n=2<arguments.length&&arguments[2]!==void 0?arguments[2]:null;if(!Am(e))throw Error(B(200));return Ux(t,e,null,n)};cn.createRoot=function(t,e){if(!Am(t))throw Error(B(299));var n=!1,r="",i=MT;return e!=null&&(e.unstable_strictMode===!0&&(n=!0),e.identifierPrefix!==void 0&&(r=e.identifierPrefix),e.onRecoverableError!==void 0&&(i=e.onRecoverableError)),e=Cm(t,1,!1,null,null,n,!1,r,i),t[gr]=e.current,Wa(t.nodeType===8?t.parentNode:t),new xm(e)};cn.findDOMNode=function(t){if(t==null)return null;if(t.nodeType===1)return t;var e=t._reactInternals;if(e===void 0)throw typeof t.render=="function"?Error(B(188)):(t=Object.keys(t).join(","),Error(B(268,t)));return t=rE(e),t=t===null?null:t.stateNode,t};cn.flushSync=function(t){return $i(t)};cn.hydrate=function(t,e,n){if(!hh(e))throw Error(B(200));return dh(null,t,e,!0,n)};cn.hydrateRoot=function(t,e,n){if(!Am(t))throw Error(B(405));var r=n!=null&&n.hydratedSources||null,i=!1,s="",o=MT;if(n!=null&&(n.unstable_strictMode===!0&&(i=!0),n.identifierPrefix!==void 0&&(s=n.identifierPrefix),n.onRecoverableError!==void 0&&(o=n.onRecoverableError)),e=OT(e,null,t,1,n??null,i,!1,s,o),t[gr]=e.current,Wa(t),r)for(t=0;t<r.length;t++)n=r[t],i=n._getVersion,i=i(n._source),e.mutableSourceEagerHydrationData==null?e.mutableSourceEagerHydrationData=[n,i]:e.mutableSourceEagerHydrationData.push(n,i);return new ch(e)};cn.render=function(t,e,n){if(!hh(e))throw Error(B(200));return dh(null,t,e,!1,n)};cn.unmountComponentAtNode=function(t){if(!hh(t))throw Error(B(40));return t._reactRootContainer?($i(function(){dh(null,null,t,!1,function(){t._reactRootContainer=null,t[gr]=null})}),!0):!1};cn.unstable_batchedUpdates=Tm;cn.unstable_renderSubtreeIntoContainer=function(t,e,n,r){if(!hh(n))throw Error(B(200));if(t==null||t._reactInternals===void 0)throw Error(B(38));return dh(t,e,n,!1,r)};cn.version="18.3.1-next-f1338f8080-20240426";function LT(){if(!(typeof __REACT_DEVTOOLS_GLOBAL_HOOK__>"u"||typeof __REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE!="function"))try{__REACT_DEVTOOLS_GLOBAL_HOOK__.checkDCE(LT)}catch(t){console.error(t)}}LT(),Lw.exports=cn;var Wx=Lw.exports,hv=Wx;nf.createRoot=hv.createRoot,nf.hydrateRoot=hv.hydrateRoot;/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const qx=t=>t.replace(/([a-z0-9])([A-Z])/g,"$1-$2").toLowerCase(),FT=(...t)=>t.filter((e,n,r)=>!!e&&r.indexOf(e)===n).join(" ");/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */var Hx={xmlns:"http://www.w3.org/2000/svg",width:24,height:24,viewBox:"0 0 24 24",fill:"none",stroke:"currentColor",strokeWidth:2,strokeLinecap:"round",strokeLinejoin:"round"};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Gx=ie.forwardRef(({color:t="currentColor",size:e=24,strokeWidth:n=2,absoluteStrokeWidth:r,className:i="",children:s,iconNode:o,...a},u)=>ie.createElement("svg",{ref:u,...Hx,width:e,height:e,stroke:t,strokeWidth:r?Number(n)*24/Number(e):n,className:FT("lucide",i),...a},[...o.map(([c,h])=>ie.createElement(c,h)),...Array.isArray(s)?s:[s]]));/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const be=(t,e)=>{const n=ie.forwardRef(({className:r,...i},s)=>ie.createElement(Gx,{ref:s,iconNode:e,className:FT(`lucide-${qx(t)}`,r),...i}));return n.displayName=`${t}`,n};/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Kx=be("ArrowLeft",[["path",{d:"m12 19-7-7 7-7",key:"1l729n"}],["path",{d:"M19 12H5",key:"x3x0zl"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Qx=be("ArrowRight",[["path",{d:"M5 12h14",key:"1ays0h"}],["path",{d:"m12 5 7 7-7 7",key:"xquz4c"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const to=be("BookOpen",[["path",{d:"M12 7v14",key:"1akyts"}],["path",{d:"M3 18a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h5a4 4 0 0 1 4 4 4 4 0 0 1 4-4h5a1 1 0 0 1 1 1v13a1 1 0 0 1-1 1h-6a3 3 0 0 0-3 3 3 3 0 0 0-3-3z",key:"ruj8y"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Ns=be("Check",[["path",{d:"M20 6 9 17l-5-5",key:"1gmf2c"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Yx=be("CircleAlert",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["line",{x1:"12",x2:"12",y1:"8",y2:"12",key:"1pkeuh"}],["line",{x1:"12",x2:"12.01",y1:"16",y2:"16",key:"4dfq90"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Xx=be("CircleCheck",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"m9 12 2 2 4-4",key:"dzmm74"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Pm=be("CloudUpload",[["path",{d:"M12 13v8",key:"1l5pq0"}],["path",{d:"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242",key:"1pljnt"}],["path",{d:"m8 17 4-4 4 4",key:"1quai1"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const dv=be("Copy",[["rect",{width:"14",height:"14",x:"8",y:"8",rx:"2",ry:"2",key:"17jyea"}],["path",{d:"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2",key:"zix9uf"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Jx=be("Database",[["ellipse",{cx:"12",cy:"5",rx:"9",ry:"3",key:"msslwz"}],["path",{d:"M3 5V19A9 3 0 0 0 21 19V5",key:"1wlel7"}],["path",{d:"M3 12A9 3 0 0 0 21 12",key:"mv7ke4"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const fv=be("ExternalLink",[["path",{d:"M15 3h6v6",key:"1q9fwt"}],["path",{d:"M10 14 21 3",key:"gplh6r"}],["path",{d:"M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6",key:"a6xqqp"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const bm=be("FileCode",[["path",{d:"M10 12.5 8 15l2 2.5",key:"1tg20x"}],["path",{d:"m14 12.5 2 2.5-2 2.5",key:"yinavb"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7z",key:"1mlx9k"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Ec=be("FileText",[["path",{d:"M15 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7Z",key:"1rqfz7"}],["path",{d:"M14 2v4a2 2 0 0 0 2 2h4",key:"tnqrlb"}],["path",{d:"M10 9H8",key:"b1mrlr"}],["path",{d:"M16 13H8",key:"t4e002"}],["path",{d:"M16 17H8",key:"z1uh3a"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const Zx=be("HardDrive",[["line",{x1:"22",x2:"2",y1:"12",y2:"12",key:"1y58io"}],["path",{d:"M5.45 5.11 2 12v6a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-6l-3.45-6.89A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z",key:"oot6mr"}],["line",{x1:"6",x2:"6.01",y1:"16",y2:"16",key:"sgf278"}],["line",{x1:"10",x2:"10.01",y1:"16",y2:"16",key:"1l4acy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const eA=be("Headphones",[["path",{d:"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3",key:"1xhozi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const tA=be("Image",[["rect",{width:"18",height:"18",x:"3",y:"3",rx:"2",ry:"2",key:"1m3agn"}],["circle",{cx:"9",cy:"9",r:"2",key:"af1f0g"}],["path",{d:"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21",key:"1xmnt7"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const VT=be("Info",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["path",{d:"M12 16v-4",key:"1dtifu"}],["path",{d:"M12 8h.01",key:"e9boi3"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const nA=be("Library",[["path",{d:"m16 6 4 14",key:"ji33uf"}],["path",{d:"M12 6v14",key:"1n7gus"}],["path",{d:"M8 8v12",key:"1gg7y9"}],["path",{d:"M4 4v16",key:"6qkkli"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ju=be("Link2",[["path",{d:"M9 17H7A5 5 0 0 1 7 7h2",key:"8i5ue5"}],["path",{d:"M15 7h2a5 5 0 1 1 0 10h-2",key:"1b9ql8"}],["line",{x1:"8",x2:"16",y1:"12",y2:"12",key:"1jonct"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const rA=be("LoaderCircle",[["path",{d:"M21 12a9 9 0 1 1-6.219-8.56",key:"13zald"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const iA=be("PenLine",[["path",{d:"M12 20h9",key:"t2du7b"}],["path",{d:"M16.376 3.622a1 1 0 0 1 3.002 3.002L7.368 18.635a2 2 0 0 1-.855.506l-2.872.838a.5.5 0 0 1-.62-.62l.838-2.872a2 2 0 0 1 .506-.854z",key:"1ykcvy"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const pv=be("RefreshCw",[["path",{d:"M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8",key:"v9h5vc"}],["path",{d:"M21 3v5h-5",key:"1q7to0"}],["path",{d:"M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16",key:"3uifl3"}],["path",{d:"M8 16H3v5",key:"1cv678"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const sA=be("Search",[["circle",{cx:"11",cy:"11",r:"8",key:"4ej97u"}],["path",{d:"m21 21-4.3-4.3",key:"1qie3q"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const oA=be("ShieldAlert",[["path",{d:"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z",key:"oel41y"}],["path",{d:"M12 8v4",key:"1got3b"}],["path",{d:"M12 16h.01",key:"1drbdi"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const mv=be("Sparkles",[["path",{d:"M9.937 15.5A2 2 0 0 0 8.5 14.063l-6.135-1.582a.5.5 0 0 1 0-.962L8.5 9.936A2 2 0 0 0 9.937 8.5l1.582-6.135a.5.5 0 0 1 .963 0L14.063 8.5A2 2 0 0 0 15.5 9.937l6.135 1.581a.5.5 0 0 1 0 .964L15.5 14.063a2 2 0 0 0-1.437 1.437l-1.582 6.135a.5.5 0 0 1-.963 0z",key:"4pj2yx"}],["path",{d:"M20 3v4",key:"1olli1"}],["path",{d:"M22 5h-4",key:"1gvqau"}],["path",{d:"M4 17v2",key:"vumght"}],["path",{d:"M5 18H3",key:"zchphs"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const ca=be("Trash2",[["path",{d:"M3 6h18",key:"d0wm0j"}],["path",{d:"M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6",key:"4alrt4"}],["path",{d:"M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2",key:"v07s0e"}],["line",{x1:"10",x2:"10",y1:"11",y2:"17",key:"1uufr5"}],["line",{x1:"14",x2:"14",y1:"11",y2:"17",key:"xtxkd"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const aA=be("TriangleAlert",[["path",{d:"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3",key:"wmoenq"}],["path",{d:"M12 9v4",key:"juzpu7"}],["path",{d:"M12 17h.01",key:"p32p05"}]]);/**
 * @license lucide-react v0.441.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const UT=be("X",[["path",{d:"M18 6 6 18",key:"1bl5f8"}],["path",{d:"m6 6 12 12",key:"d8bk6v"}]]);var gv={};/**
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
 */const jT={NODE_ADMIN:!1,SDK_VERSION:"${JSCORE_VERSION}"};/**
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
 */const G=function(t,e){if(!t)throw go(e)},go=function(t){return new Error("Firebase Database ("+jT.SDK_VERSION+") INTERNAL ASSERT FAILED: "+t)};/**
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
 */const zT=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):(i&64512)===55296&&r+1<t.length&&(t.charCodeAt(r+1)&64512)===56320?(i=65536+((i&1023)<<10)+(t.charCodeAt(++r)&1023),e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},lA=function(t){const e=[];let n=0,r=0;for(;n<t.length;){const i=t[n++];if(i<128)e[r++]=String.fromCharCode(i);else if(i>191&&i<224){const s=t[n++];e[r++]=String.fromCharCode((i&31)<<6|s&63)}else if(i>239&&i<365){const s=t[n++],o=t[n++],a=t[n++],u=((i&7)<<18|(s&63)<<12|(o&63)<<6|a&63)-65536;e[r++]=String.fromCharCode(55296+(u>>10)),e[r++]=String.fromCharCode(56320+(u&1023))}else{const s=t[n++],o=t[n++];e[r++]=String.fromCharCode((i&15)<<12|(s&63)<<6|o&63)}}return e.join("")},Nm={byteToCharMap_:null,charToByteMap_:null,byteToCharMapWebSafe_:null,charToByteMapWebSafe_:null,ENCODED_VALS_BASE:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",get ENCODED_VALS(){return this.ENCODED_VALS_BASE+"+/="},get ENCODED_VALS_WEBSAFE(){return this.ENCODED_VALS_BASE+"-_."},HAS_NATIVE_SUPPORT:typeof atob=="function",encodeByteArray(t,e){if(!Array.isArray(t))throw Error("encodeByteArray takes an array as a parameter");this.init_();const n=e?this.byteToCharMapWebSafe_:this.byteToCharMap_,r=[];for(let i=0;i<t.length;i+=3){const s=t[i],o=i+1<t.length,a=o?t[i+1]:0,u=i+2<t.length,c=u?t[i+2]:0,h=s>>2,f=(s&3)<<4|a>>4;let m=(a&15)<<2|c>>6,w=c&63;u||(w=64,o||(m=64)),r.push(n[h],n[f],n[m],n[w])}return r.join("")},encodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?btoa(t):this.encodeByteArray(zT(t),e)},decodeString(t,e){return this.HAS_NATIVE_SUPPORT&&!e?atob(t):lA(this.decodeStringToByteArray(t,e))},decodeStringToByteArray(t,e){this.init_();const n=e?this.charToByteMapWebSafe_:this.charToByteMap_,r=[];for(let i=0;i<t.length;){const s=n[t.charAt(i++)],a=i<t.length?n[t.charAt(i)]:0;++i;const c=i<t.length?n[t.charAt(i)]:64;++i;const f=i<t.length?n[t.charAt(i)]:64;if(++i,s==null||a==null||c==null||f==null)throw new uA;const m=s<<2|a>>4;if(r.push(m),c!==64){const w=a<<4&240|c>>2;if(r.push(w),f!==64){const S=c<<6&192|f;r.push(S)}}}return r},init_(){if(!this.byteToCharMap_){this.byteToCharMap_={},this.charToByteMap_={},this.byteToCharMapWebSafe_={},this.charToByteMapWebSafe_={};for(let t=0;t<this.ENCODED_VALS.length;t++)this.byteToCharMap_[t]=this.ENCODED_VALS.charAt(t),this.charToByteMap_[this.byteToCharMap_[t]]=t,this.byteToCharMapWebSafe_[t]=this.ENCODED_VALS_WEBSAFE.charAt(t),this.charToByteMapWebSafe_[this.byteToCharMapWebSafe_[t]]=t,t>=this.ENCODED_VALS_BASE.length&&(this.charToByteMap_[this.ENCODED_VALS_WEBSAFE.charAt(t)]=t,this.charToByteMapWebSafe_[this.ENCODED_VALS.charAt(t)]=t)}}};class uA extends Error{constructor(){super(...arguments),this.name="DecodeBase64StringError"}}const BT=function(t){const e=zT(t);return Nm.encodeByteArray(e,!0)},Tc=function(t){return BT(t).replace(/\./g,"")},Ic=function(t){try{return Nm.decodeString(t,!0)}catch(e){console.error("base64Decode failed: ",e)}return null};/**
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
 */function cA(t){return $T(void 0,t)}function $T(t,e){if(!(e instanceof Object))return e;switch(e.constructor){case Date:const n=e;return new Date(n.getTime());case Object:t===void 0&&(t={});break;case Array:t=[];break;default:return e}for(const n in e)!e.hasOwnProperty(n)||!hA(n)||(t[n]=$T(t[n],e[n]));return t}function hA(t){return t!=="__proto__"}/**
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
 */function dA(){if(typeof self<"u")return self;if(typeof window<"u")return window;if(typeof global<"u")return global;throw new Error("Unable to locate global object.")}/**
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
 */const fA=()=>dA().__FIREBASE_DEFAULTS__,pA=()=>{if(typeof process>"u"||typeof gv>"u")return;const t=gv.__FIREBASE_DEFAULTS__;if(t)return JSON.parse(t)},mA=()=>{if(typeof document>"u")return;let t;try{t=document.cookie.match(/__FIREBASE_DEFAULTS__=([^;]+)/)}catch{return}const e=t&&Ic(t[1]);return e&&JSON.parse(e)},fh=()=>{try{return fA()||pA()||mA()}catch(t){console.info(`Unable to get __FIREBASE_DEFAULTS__ due to: ${t}`);return}},WT=t=>{var e,n;return(n=(e=fh())===null||e===void 0?void 0:e.emulatorHosts)===null||n===void 0?void 0:n[t]},Dm=t=>{const e=WT(t);if(!e)return;const n=e.lastIndexOf(":");if(n<=0||n+1===e.length)throw new Error(`Invalid host ${e} with no separate hostname and port!`);const r=parseInt(e.substring(n+1),10);return e[0]==="["?[e.substring(1,n-1),r]:[e.substring(0,n),r]},qT=()=>{var t;return(t=fh())===null||t===void 0?void 0:t.config},HT=t=>{var e;return(e=fh())===null||e===void 0?void 0:e[`_${t}`]};/**
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
 */class ph{constructor(){this.reject=()=>{},this.resolve=()=>{},this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}wrapCallback(e){return(n,r)=>{n?this.reject(n):this.resolve(r),typeof e=="function"&&(this.promise.catch(()=>{}),e.length===1?e(n):e(n,r))}}}/**
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
 */function Om(t,e){if(t.uid)throw new Error('The "uid" field is no longer supported by mockUserToken. Please use "sub" instead for Firebase Auth User ID.');const n={alg:"none",type:"JWT"},r=e||"demo-project",i=t.iat||0,s=t.sub||t.user_id;if(!s)throw new Error("mockUserToken must contain 'sub' or 'user_id' field!");const o=Object.assign({iss:`https://securetoken.google.com/${r}`,aud:r,iat:i,exp:i+3600,auth_time:i,sub:s,user_id:s,firebase:{sign_in_provider:"custom",identities:{}}},t);return[Tc(JSON.stringify(n)),Tc(JSON.stringify(o)),""].join(".")}/**
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
 */function Vt(){return typeof navigator<"u"&&typeof navigator.userAgent=="string"?navigator.userAgent:""}function Mm(){return typeof window<"u"&&!!(window.cordova||window.phonegap||window.PhoneGap)&&/ios|iphone|ipod|ipad|android|blackberry|iemobile/i.test(Vt())}function gA(){var t;const e=(t=fh())===null||t===void 0?void 0:t.forceEnvironment;if(e==="node")return!0;if(e==="browser")return!1;try{return Object.prototype.toString.call(global.process)==="[object process]"}catch{return!1}}function _A(){return typeof navigator<"u"&&navigator.userAgent==="Cloudflare-Workers"}function yA(){const t=typeof chrome=="object"?chrome.runtime:typeof browser=="object"?browser.runtime:void 0;return typeof t=="object"&&t.id!==void 0}function GT(){return typeof navigator=="object"&&navigator.product==="ReactNative"}function vA(){const t=Vt();return t.indexOf("MSIE ")>=0||t.indexOf("Trident/")>=0}function wA(){return jT.NODE_ADMIN===!0}function EA(){return!gA()&&!!navigator.userAgent&&navigator.userAgent.includes("Safari")&&!navigator.userAgent.includes("Chrome")}function TA(){try{return typeof indexedDB=="object"}catch{return!1}}function IA(){return new Promise((t,e)=>{try{let n=!0;const r="validate-browser-context-for-indexeddb-analytics-module",i=self.indexedDB.open(r);i.onsuccess=()=>{i.result.close(),n||self.indexedDB.deleteDatabase(r),t(!0)},i.onupgradeneeded=()=>{n=!1},i.onerror=()=>{var s;e(((s=i.error)===null||s===void 0?void 0:s.message)||"")}}catch(n){e(n)}})}/**
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
 */const SA="FirebaseError";class Zn extends Error{constructor(e,n,r){super(n),this.code=e,this.customData=r,this.name=SA,Object.setPrototypeOf(this,Zn.prototype),Error.captureStackTrace&&Error.captureStackTrace(this,yl.prototype.create)}}class yl{constructor(e,n,r){this.service=e,this.serviceName=n,this.errors=r}create(e,...n){const r=n[0]||{},i=`${this.service}/${e}`,s=this.errors[e],o=s?kA(s,r):"Error",a=`${this.serviceName}: ${o} (${i}).`;return new Zn(i,a,r)}}function kA(t,e){return t.replace(CA,(n,r)=>{const i=e[r];return i!=null?String(i):`<${r}?>`})}const CA=/\{\$([^}]+)}/g;/**
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
 */function Za(t){return JSON.parse(t)}function Et(t){return JSON.stringify(t)}/**
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
 */const KT=function(t){let e={},n={},r={},i="";try{const s=t.split(".");e=Za(Ic(s[0])||""),n=Za(Ic(s[1])||""),i=s[2],r=n.d||{},delete n.d}catch{}return{header:e,claims:n,data:r,signature:i}},RA=function(t){const e=KT(t),n=e.claims;return!!n&&typeof n=="object"&&n.hasOwnProperty("iat")},xA=function(t){const e=KT(t).claims;return typeof e=="object"&&e.admin===!0};/**
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
 */function xr(t,e){return Object.prototype.hasOwnProperty.call(t,e)}function no(t,e){if(Object.prototype.hasOwnProperty.call(t,e))return t[e]}function Yf(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}function Sc(t,e,n){const r={};for(const i in t)Object.prototype.hasOwnProperty.call(t,i)&&(r[i]=e.call(n,t[i],i,t));return r}function kc(t,e){if(t===e)return!0;const n=Object.keys(t),r=Object.keys(e);for(const i of n){if(!r.includes(i))return!1;const s=t[i],o=e[i];if(_v(s)&&_v(o)){if(!kc(s,o))return!1}else if(s!==o)return!1}for(const i of r)if(!n.includes(i))return!1;return!0}function _v(t){return t!==null&&typeof t=="object"}/**
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
 */function _o(t){const e=[];for(const[n,r]of Object.entries(t))Array.isArray(r)?r.forEach(i=>{e.push(encodeURIComponent(n)+"="+encodeURIComponent(i))}):e.push(encodeURIComponent(n)+"="+encodeURIComponent(r));return e.length?"&"+e.join("&"):""}/**
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
 */class AA{constructor(){this.chain_=[],this.buf_=[],this.W_=[],this.pad_=[],this.inbuf_=0,this.total_=0,this.blockSize=512/8,this.pad_[0]=128;for(let e=1;e<this.blockSize;++e)this.pad_[e]=0;this.reset()}reset(){this.chain_[0]=1732584193,this.chain_[1]=4023233417,this.chain_[2]=2562383102,this.chain_[3]=271733878,this.chain_[4]=3285377520,this.inbuf_=0,this.total_=0}compress_(e,n){n||(n=0);const r=this.W_;if(typeof e=="string")for(let f=0;f<16;f++)r[f]=e.charCodeAt(n)<<24|e.charCodeAt(n+1)<<16|e.charCodeAt(n+2)<<8|e.charCodeAt(n+3),n+=4;else for(let f=0;f<16;f++)r[f]=e[n]<<24|e[n+1]<<16|e[n+2]<<8|e[n+3],n+=4;for(let f=16;f<80;f++){const m=r[f-3]^r[f-8]^r[f-14]^r[f-16];r[f]=(m<<1|m>>>31)&4294967295}let i=this.chain_[0],s=this.chain_[1],o=this.chain_[2],a=this.chain_[3],u=this.chain_[4],c,h;for(let f=0;f<80;f++){f<40?f<20?(c=a^s&(o^a),h=1518500249):(c=s^o^a,h=1859775393):f<60?(c=s&o|a&(s|o),h=2400959708):(c=s^o^a,h=3395469782);const m=(i<<5|i>>>27)+c+u+h+r[f]&4294967295;u=a,a=o,o=(s<<30|s>>>2)&4294967295,s=i,i=m}this.chain_[0]=this.chain_[0]+i&4294967295,this.chain_[1]=this.chain_[1]+s&4294967295,this.chain_[2]=this.chain_[2]+o&4294967295,this.chain_[3]=this.chain_[3]+a&4294967295,this.chain_[4]=this.chain_[4]+u&4294967295}update(e,n){if(e==null)return;n===void 0&&(n=e.length);const r=n-this.blockSize;let i=0;const s=this.buf_;let o=this.inbuf_;for(;i<n;){if(o===0)for(;i<=r;)this.compress_(e,i),i+=this.blockSize;if(typeof e=="string"){for(;i<n;)if(s[o]=e.charCodeAt(i),++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}else for(;i<n;)if(s[o]=e[i],++o,++i,o===this.blockSize){this.compress_(s),o=0;break}}this.inbuf_=o,this.total_+=n}digest(){const e=[];let n=this.total_*8;this.inbuf_<56?this.update(this.pad_,56-this.inbuf_):this.update(this.pad_,this.blockSize-(this.inbuf_-56));for(let i=this.blockSize-1;i>=56;i--)this.buf_[i]=n&255,n/=256;this.compress_(this.buf_);let r=0;for(let i=0;i<5;i++)for(let s=24;s>=0;s-=8)e[r]=this.chain_[i]>>s&255,++r;return e}}function PA(t,e){const n=new bA(t,e);return n.subscribe.bind(n)}class bA{constructor(e,n){this.observers=[],this.unsubscribes=[],this.observerCount=0,this.task=Promise.resolve(),this.finalized=!1,this.onNoObservers=n,this.task.then(()=>{e(this)}).catch(r=>{this.error(r)})}next(e){this.forEachObserver(n=>{n.next(e)})}error(e){this.forEachObserver(n=>{n.error(e)}),this.close(e)}complete(){this.forEachObserver(e=>{e.complete()}),this.close()}subscribe(e,n,r){let i;if(e===void 0&&n===void 0&&r===void 0)throw new Error("Missing Observer.");NA(e,["next","error","complete"])?i=e:i={next:e,error:n,complete:r},i.next===void 0&&(i.next=Nd),i.error===void 0&&(i.error=Nd),i.complete===void 0&&(i.complete=Nd);const s=this.unsubscribeOne.bind(this,this.observers.length);return this.finalized&&this.task.then(()=>{try{this.finalError?i.error(this.finalError):i.complete()}catch{}}),this.observers.push(i),s}unsubscribeOne(e){this.observers===void 0||this.observers[e]===void 0||(delete this.observers[e],this.observerCount-=1,this.observerCount===0&&this.onNoObservers!==void 0&&this.onNoObservers(this))}forEachObserver(e){if(!this.finalized)for(let n=0;n<this.observers.length;n++)this.sendOne(n,e)}sendOne(e,n){this.task.then(()=>{if(this.observers!==void 0&&this.observers[e]!==void 0)try{n(this.observers[e])}catch(r){typeof console<"u"&&console.error&&console.error(r)}})}close(e){this.finalized||(this.finalized=!0,e!==void 0&&(this.finalError=e),this.task.then(()=>{this.observers=void 0,this.onNoObservers=void 0}))}}function NA(t,e){if(typeof t!="object"||t===null)return!1;for(const n of e)if(n in t&&typeof t[n]=="function")return!0;return!1}function Nd(){}function Lm(t,e){return`${t} failed: ${e} argument `}/**
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
 */const DA=function(t){const e=[];let n=0;for(let r=0;r<t.length;r++){let i=t.charCodeAt(r);if(i>=55296&&i<=56319){const s=i-55296;r++,G(r<t.length,"Surrogate pair missing trail surrogate.");const o=t.charCodeAt(r)-56320;i=65536+(s<<10)+o}i<128?e[n++]=i:i<2048?(e[n++]=i>>6|192,e[n++]=i&63|128):i<65536?(e[n++]=i>>12|224,e[n++]=i>>6&63|128,e[n++]=i&63|128):(e[n++]=i>>18|240,e[n++]=i>>12&63|128,e[n++]=i>>6&63|128,e[n++]=i&63|128)}return e},mh=function(t){let e=0;for(let n=0;n<t.length;n++){const r=t.charCodeAt(n);r<128?e++:r<2048?e+=2:r>=55296&&r<=56319?(e+=4,n++):e+=3}return e};/**
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
 */function Ye(t){return t&&t._delegate?t._delegate:t}class vr{constructor(e,n,r){this.name=e,this.instanceFactory=n,this.type=r,this.multipleInstances=!1,this.serviceProps={},this.instantiationMode="LAZY",this.onInstanceCreated=null}setInstantiationMode(e){return this.instantiationMode=e,this}setMultipleInstances(e){return this.multipleInstances=e,this}setServiceProps(e){return this.serviceProps=e,this}setInstanceCreatedCallback(e){return this.onInstanceCreated=e,this}}/**
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
 */const Ci="[DEFAULT]";/**
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
 */class OA{constructor(e,n){this.name=e,this.container=n,this.component=null,this.instances=new Map,this.instancesDeferred=new Map,this.instancesOptions=new Map,this.onInitCallbacks=new Map}get(e){const n=this.normalizeInstanceIdentifier(e);if(!this.instancesDeferred.has(n)){const r=new ph;if(this.instancesDeferred.set(n,r),this.isInitialized(n)||this.shouldAutoInitialize())try{const i=this.getOrInitializeService({instanceIdentifier:n});i&&r.resolve(i)}catch{}}return this.instancesDeferred.get(n).promise}getImmediate(e){var n;const r=this.normalizeInstanceIdentifier(e==null?void 0:e.identifier),i=(n=e==null?void 0:e.optional)!==null&&n!==void 0?n:!1;if(this.isInitialized(r)||this.shouldAutoInitialize())try{return this.getOrInitializeService({instanceIdentifier:r})}catch(s){if(i)return null;throw s}else{if(i)return null;throw Error(`Service ${this.name} is not available`)}}getComponent(){return this.component}setComponent(e){if(e.name!==this.name)throw Error(`Mismatching Component ${e.name} for Provider ${this.name}.`);if(this.component)throw Error(`Component for ${this.name} has already been provided`);if(this.component=e,!!this.shouldAutoInitialize()){if(LA(e))try{this.getOrInitializeService({instanceIdentifier:Ci})}catch{}for(const[n,r]of this.instancesDeferred.entries()){const i=this.normalizeInstanceIdentifier(n);try{const s=this.getOrInitializeService({instanceIdentifier:i});r.resolve(s)}catch{}}}}clearInstance(e=Ci){this.instancesDeferred.delete(e),this.instancesOptions.delete(e),this.instances.delete(e)}async delete(){const e=Array.from(this.instances.values());await Promise.all([...e.filter(n=>"INTERNAL"in n).map(n=>n.INTERNAL.delete()),...e.filter(n=>"_delete"in n).map(n=>n._delete())])}isComponentSet(){return this.component!=null}isInitialized(e=Ci){return this.instances.has(e)}getOptions(e=Ci){return this.instancesOptions.get(e)||{}}initialize(e={}){const{options:n={}}=e,r=this.normalizeInstanceIdentifier(e.instanceIdentifier);if(this.isInitialized(r))throw Error(`${this.name}(${r}) has already been initialized`);if(!this.isComponentSet())throw Error(`Component ${this.name} has not been registered yet`);const i=this.getOrInitializeService({instanceIdentifier:r,options:n});for(const[s,o]of this.instancesDeferred.entries()){const a=this.normalizeInstanceIdentifier(s);r===a&&o.resolve(i)}return i}onInit(e,n){var r;const i=this.normalizeInstanceIdentifier(n),s=(r=this.onInitCallbacks.get(i))!==null&&r!==void 0?r:new Set;s.add(e),this.onInitCallbacks.set(i,s);const o=this.instances.get(i);return o&&e(o,i),()=>{s.delete(e)}}invokeOnInitCallbacks(e,n){const r=this.onInitCallbacks.get(n);if(r)for(const i of r)try{i(e,n)}catch{}}getOrInitializeService({instanceIdentifier:e,options:n={}}){let r=this.instances.get(e);if(!r&&this.component&&(r=this.component.instanceFactory(this.container,{instanceIdentifier:MA(e),options:n}),this.instances.set(e,r),this.instancesOptions.set(e,n),this.invokeOnInitCallbacks(r,e),this.component.onInstanceCreated))try{this.component.onInstanceCreated(this.container,e,r)}catch{}return r||null}normalizeInstanceIdentifier(e=Ci){return this.component?this.component.multipleInstances?e:Ci:e}shouldAutoInitialize(){return!!this.component&&this.component.instantiationMode!=="EXPLICIT"}}function MA(t){return t===Ci?void 0:t}function LA(t){return t.instantiationMode==="EAGER"}/**
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
 */class FA{constructor(e){this.name=e,this.providers=new Map}addComponent(e){const n=this.getProvider(e.name);if(n.isComponentSet())throw new Error(`Component ${e.name} has already been registered with ${this.name}`);n.setComponent(e)}addOrOverwriteComponent(e){this.getProvider(e.name).isComponentSet()&&this.providers.delete(e.name),this.addComponent(e)}getProvider(e){if(this.providers.has(e))return this.providers.get(e);const n=new OA(e,this);return this.providers.set(e,n),n}getProviders(){return Array.from(this.providers.values())}}/**
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
 */var de;(function(t){t[t.DEBUG=0]="DEBUG",t[t.VERBOSE=1]="VERBOSE",t[t.INFO=2]="INFO",t[t.WARN=3]="WARN",t[t.ERROR=4]="ERROR",t[t.SILENT=5]="SILENT"})(de||(de={}));const VA={debug:de.DEBUG,verbose:de.VERBOSE,info:de.INFO,warn:de.WARN,error:de.ERROR,silent:de.SILENT},UA=de.INFO,jA={[de.DEBUG]:"log",[de.VERBOSE]:"log",[de.INFO]:"info",[de.WARN]:"warn",[de.ERROR]:"error"},zA=(t,e,...n)=>{if(e<t.logLevel)return;const r=new Date().toISOString(),i=jA[e];if(i)console[i](`[${r}]  ${t.name}:`,...n);else throw new Error(`Attempted to log a message with an invalid logType (value: ${e})`)};class gh{constructor(e){this.name=e,this._logLevel=UA,this._logHandler=zA,this._userLogHandler=null}get logLevel(){return this._logLevel}set logLevel(e){if(!(e in de))throw new TypeError(`Invalid value "${e}" assigned to \`logLevel\``);this._logLevel=e}setLogLevel(e){this._logLevel=typeof e=="string"?VA[e]:e}get logHandler(){return this._logHandler}set logHandler(e){if(typeof e!="function")throw new TypeError("Value assigned to `logHandler` must be a function");this._logHandler=e}get userLogHandler(){return this._userLogHandler}set userLogHandler(e){this._userLogHandler=e}debug(...e){this._userLogHandler&&this._userLogHandler(this,de.DEBUG,...e),this._logHandler(this,de.DEBUG,...e)}log(...e){this._userLogHandler&&this._userLogHandler(this,de.VERBOSE,...e),this._logHandler(this,de.VERBOSE,...e)}info(...e){this._userLogHandler&&this._userLogHandler(this,de.INFO,...e),this._logHandler(this,de.INFO,...e)}warn(...e){this._userLogHandler&&this._userLogHandler(this,de.WARN,...e),this._logHandler(this,de.WARN,...e)}error(...e){this._userLogHandler&&this._userLogHandler(this,de.ERROR,...e),this._logHandler(this,de.ERROR,...e)}}const BA=(t,e)=>e.some(n=>t instanceof n);let yv,vv;function $A(){return yv||(yv=[IDBDatabase,IDBObjectStore,IDBIndex,IDBCursor,IDBTransaction])}function WA(){return vv||(vv=[IDBCursor.prototype.advance,IDBCursor.prototype.continue,IDBCursor.prototype.continuePrimaryKey])}const QT=new WeakMap,Xf=new WeakMap,YT=new WeakMap,Dd=new WeakMap,Fm=new WeakMap;function qA(t){const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("success",s),t.removeEventListener("error",o)},s=()=>{n(ei(t.result)),i()},o=()=>{r(t.error),i()};t.addEventListener("success",s),t.addEventListener("error",o)});return e.then(n=>{n instanceof IDBCursor&&QT.set(n,t)}).catch(()=>{}),Fm.set(e,t),e}function HA(t){if(Xf.has(t))return;const e=new Promise((n,r)=>{const i=()=>{t.removeEventListener("complete",s),t.removeEventListener("error",o),t.removeEventListener("abort",o)},s=()=>{n(),i()},o=()=>{r(t.error||new DOMException("AbortError","AbortError")),i()};t.addEventListener("complete",s),t.addEventListener("error",o),t.addEventListener("abort",o)});Xf.set(t,e)}let Jf={get(t,e,n){if(t instanceof IDBTransaction){if(e==="done")return Xf.get(t);if(e==="objectStoreNames")return t.objectStoreNames||YT.get(t);if(e==="store")return n.objectStoreNames[1]?void 0:n.objectStore(n.objectStoreNames[0])}return ei(t[e])},set(t,e,n){return t[e]=n,!0},has(t,e){return t instanceof IDBTransaction&&(e==="done"||e==="store")?!0:e in t}};function GA(t){Jf=t(Jf)}function KA(t){return t===IDBDatabase.prototype.transaction&&!("objectStoreNames"in IDBTransaction.prototype)?function(e,...n){const r=t.call(Od(this),e,...n);return YT.set(r,e.sort?e.sort():[e]),ei(r)}:WA().includes(t)?function(...e){return t.apply(Od(this),e),ei(QT.get(this))}:function(...e){return ei(t.apply(Od(this),e))}}function QA(t){return typeof t=="function"?KA(t):(t instanceof IDBTransaction&&HA(t),BA(t,$A())?new Proxy(t,Jf):t)}function ei(t){if(t instanceof IDBRequest)return qA(t);if(Dd.has(t))return Dd.get(t);const e=QA(t);return e!==t&&(Dd.set(t,e),Fm.set(e,t)),e}const Od=t=>Fm.get(t);function YA(t,e,{blocked:n,upgrade:r,blocking:i,terminated:s}={}){const o=indexedDB.open(t,e),a=ei(o);return r&&o.addEventListener("upgradeneeded",u=>{r(ei(o.result),u.oldVersion,u.newVersion,ei(o.transaction),u)}),n&&o.addEventListener("blocked",u=>n(u.oldVersion,u.newVersion,u)),a.then(u=>{s&&u.addEventListener("close",()=>s()),i&&u.addEventListener("versionchange",c=>i(c.oldVersion,c.newVersion,c))}).catch(()=>{}),a}const XA=["get","getKey","getAll","getAllKeys","count"],JA=["put","add","delete","clear"],Md=new Map;function wv(t,e){if(!(t instanceof IDBDatabase&&!(e in t)&&typeof e=="string"))return;if(Md.get(e))return Md.get(e);const n=e.replace(/FromIndex$/,""),r=e!==n,i=JA.includes(n);if(!(n in(r?IDBIndex:IDBObjectStore).prototype)||!(i||XA.includes(n)))return;const s=async function(o,...a){const u=this.transaction(o,i?"readwrite":"readonly");let c=u.store;return r&&(c=c.index(a.shift())),(await Promise.all([c[n](...a),i&&u.done]))[0]};return Md.set(e,s),s}GA(t=>({...t,get:(e,n,r)=>wv(e,n)||t.get(e,n,r),has:(e,n)=>!!wv(e,n)||t.has(e,n)}));/**
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
 */class ZA{constructor(e){this.container=e}getPlatformInfoString(){return this.container.getProviders().map(n=>{if(eP(n)){const r=n.getImmediate();return`${r.library}/${r.version}`}else return null}).filter(n=>n).join(" ")}}function eP(t){const e=t.getComponent();return(e==null?void 0:e.type)==="VERSION"}const Zf="@firebase/app",Ev="0.10.13";/**
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
 */const wr=new gh("@firebase/app"),tP="@firebase/app-compat",nP="@firebase/analytics-compat",rP="@firebase/analytics",iP="@firebase/app-check-compat",sP="@firebase/app-check",oP="@firebase/auth",aP="@firebase/auth-compat",lP="@firebase/database",uP="@firebase/data-connect",cP="@firebase/database-compat",hP="@firebase/functions",dP="@firebase/functions-compat",fP="@firebase/installations",pP="@firebase/installations-compat",mP="@firebase/messaging",gP="@firebase/messaging-compat",_P="@firebase/performance",yP="@firebase/performance-compat",vP="@firebase/remote-config",wP="@firebase/remote-config-compat",EP="@firebase/storage",TP="@firebase/storage-compat",IP="@firebase/firestore",SP="@firebase/vertexai-preview",kP="@firebase/firestore-compat",CP="firebase",RP="10.14.1";/**
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
 */const ep="[DEFAULT]",xP={[Zf]:"fire-core",[tP]:"fire-core-compat",[rP]:"fire-analytics",[nP]:"fire-analytics-compat",[sP]:"fire-app-check",[iP]:"fire-app-check-compat",[oP]:"fire-auth",[aP]:"fire-auth-compat",[lP]:"fire-rtdb",[uP]:"fire-data-connect",[cP]:"fire-rtdb-compat",[hP]:"fire-fn",[dP]:"fire-fn-compat",[fP]:"fire-iid",[pP]:"fire-iid-compat",[mP]:"fire-fcm",[gP]:"fire-fcm-compat",[_P]:"fire-perf",[yP]:"fire-perf-compat",[vP]:"fire-rc",[wP]:"fire-rc-compat",[EP]:"fire-gcs",[TP]:"fire-gcs-compat",[IP]:"fire-fst",[kP]:"fire-fst-compat",[SP]:"fire-vertex","fire-js":"fire-js",[CP]:"fire-js-all"};/**
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
 */const Cc=new Map,AP=new Map,tp=new Map;function Tv(t,e){try{t.container.addComponent(e)}catch(n){wr.debug(`Component ${e.name} failed to register with FirebaseApp ${t.name}`,n)}}function ui(t){const e=t.name;if(tp.has(e))return wr.debug(`There were multiple attempts to register component ${e}.`),!1;tp.set(e,t);for(const n of Cc.values())Tv(n,t);for(const n of AP.values())Tv(n,t);return!0}function vl(t,e){const n=t.container.getProvider("heartbeat").getImmediate({optional:!0});return n&&n.triggerHeartbeat(),t.container.getProvider(e)}function ar(t){return t.settings!==void 0}/**
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
 */const PP={"no-app":"No Firebase App '{$appName}' has been created - call initializeApp() first","bad-app-name":"Illegal App name: '{$appName}'","duplicate-app":"Firebase App named '{$appName}' already exists with different options or config","app-deleted":"Firebase App named '{$appName}' already deleted","server-app-deleted":"Firebase Server App has been deleted","no-options":"Need to provide options, when not being deployed to hosting via source.","invalid-app-argument":"firebase.{$appName}() takes either no argument or a Firebase App instance.","invalid-log-argument":"First argument to `onLog` must be null or a function.","idb-open":"Error thrown when opening IndexedDB. Original error: {$originalErrorMessage}.","idb-get":"Error thrown when reading from IndexedDB. Original error: {$originalErrorMessage}.","idb-set":"Error thrown when writing to IndexedDB. Original error: {$originalErrorMessage}.","idb-delete":"Error thrown when deleting from IndexedDB. Original error: {$originalErrorMessage}.","finalization-registry-not-supported":"FirebaseServerApp deleteOnDeref field defined but the JS runtime does not support FinalizationRegistry.","invalid-server-app-environment":"FirebaseServerApp is not for use in browser environments."},ti=new yl("app","Firebase",PP);/**
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
 */class bP{constructor(e,n,r){this._isDeleted=!1,this._options=Object.assign({},e),this._config=Object.assign({},n),this._name=n.name,this._automaticDataCollectionEnabled=n.automaticDataCollectionEnabled,this._container=r,this.container.addComponent(new vr("app",()=>this,"PUBLIC"))}get automaticDataCollectionEnabled(){return this.checkDestroyed(),this._automaticDataCollectionEnabled}set automaticDataCollectionEnabled(e){this.checkDestroyed(),this._automaticDataCollectionEnabled=e}get name(){return this.checkDestroyed(),this._name}get options(){return this.checkDestroyed(),this._options}get config(){return this.checkDestroyed(),this._config}get container(){return this._container}get isDeleted(){return this._isDeleted}set isDeleted(e){this._isDeleted=e}checkDestroyed(){if(this.isDeleted)throw ti.create("app-deleted",{appName:this._name})}}/**
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
 */const yi=RP;function XT(t,e={}){let n=t;typeof e!="object"&&(e={name:e});const r=Object.assign({name:ep,automaticDataCollectionEnabled:!1},e),i=r.name;if(typeof i!="string"||!i)throw ti.create("bad-app-name",{appName:String(i)});if(n||(n=qT()),!n)throw ti.create("no-options");const s=Cc.get(i);if(s){if(kc(n,s.options)&&kc(r,s.config))return s;throw ti.create("duplicate-app",{appName:i})}const o=new FA(i);for(const u of tp.values())o.addComponent(u);const a=new bP(n,r,o);return Cc.set(i,a),a}function _h(t=ep){const e=Cc.get(t);if(!e&&t===ep&&qT())return XT();if(!e)throw ti.create("no-app",{appName:t});return e}function wn(t,e,n){var r;let i=(r=xP[t])!==null&&r!==void 0?r:t;n&&(i+=`-${n}`);const s=i.match(/\s|\//),o=e.match(/\s|\//);if(s||o){const a=[`Unable to register library "${i}" with version "${e}":`];s&&a.push(`library name "${i}" contains illegal characters (whitespace or "/")`),s&&o&&a.push("and"),o&&a.push(`version name "${e}" contains illegal characters (whitespace or "/")`),wr.warn(a.join(" "));return}ui(new vr(`${i}-version`,()=>({library:i,version:e}),"VERSION"))}/**
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
 */const NP="firebase-heartbeat-database",DP=1,el="firebase-heartbeat-store";let Ld=null;function JT(){return Ld||(Ld=YA(NP,DP,{upgrade:(t,e)=>{switch(e){case 0:try{t.createObjectStore(el)}catch(n){console.warn(n)}}}}).catch(t=>{throw ti.create("idb-open",{originalErrorMessage:t.message})})),Ld}async function OP(t){try{const n=(await JT()).transaction(el),r=await n.objectStore(el).get(ZT(t));return await n.done,r}catch(e){if(e instanceof Zn)wr.warn(e.message);else{const n=ti.create("idb-get",{originalErrorMessage:e==null?void 0:e.message});wr.warn(n.message)}}}async function Iv(t,e){try{const r=(await JT()).transaction(el,"readwrite");await r.objectStore(el).put(e,ZT(t)),await r.done}catch(n){if(n instanceof Zn)wr.warn(n.message);else{const r=ti.create("idb-set",{originalErrorMessage:n==null?void 0:n.message});wr.warn(r.message)}}}function ZT(t){return`${t.name}!${t.options.appId}`}/**
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
 */const MP=1024,LP=30*24*60*60*1e3;class FP{constructor(e){this.container=e,this._heartbeatsCache=null;const n=this.container.getProvider("app").getImmediate();this._storage=new UP(n),this._heartbeatsCachePromise=this._storage.read().then(r=>(this._heartbeatsCache=r,r))}async triggerHeartbeat(){var e,n;try{const i=this.container.getProvider("platform-logger").getImmediate().getPlatformInfoString(),s=Sv();return((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null&&(this._heartbeatsCache=await this._heartbeatsCachePromise,((n=this._heartbeatsCache)===null||n===void 0?void 0:n.heartbeats)==null)||this._heartbeatsCache.lastSentHeartbeatDate===s||this._heartbeatsCache.heartbeats.some(o=>o.date===s)?void 0:(this._heartbeatsCache.heartbeats.push({date:s,agent:i}),this._heartbeatsCache.heartbeats=this._heartbeatsCache.heartbeats.filter(o=>{const a=new Date(o.date).valueOf();return Date.now()-a<=LP}),this._storage.overwrite(this._heartbeatsCache))}catch(r){wr.warn(r)}}async getHeartbeatsHeader(){var e;try{if(this._heartbeatsCache===null&&await this._heartbeatsCachePromise,((e=this._heartbeatsCache)===null||e===void 0?void 0:e.heartbeats)==null||this._heartbeatsCache.heartbeats.length===0)return"";const n=Sv(),{heartbeatsToSend:r,unsentEntries:i}=VP(this._heartbeatsCache.heartbeats),s=Tc(JSON.stringify({version:2,heartbeats:r}));return this._heartbeatsCache.lastSentHeartbeatDate=n,i.length>0?(this._heartbeatsCache.heartbeats=i,await this._storage.overwrite(this._heartbeatsCache)):(this._heartbeatsCache.heartbeats=[],this._storage.overwrite(this._heartbeatsCache)),s}catch(n){return wr.warn(n),""}}}function Sv(){return new Date().toISOString().substring(0,10)}function VP(t,e=MP){const n=[];let r=t.slice();for(const i of t){const s=n.find(o=>o.agent===i.agent);if(s){if(s.dates.push(i.date),kv(n)>e){s.dates.pop();break}}else if(n.push({agent:i.agent,dates:[i.date]}),kv(n)>e){n.pop();break}r=r.slice(1)}return{heartbeatsToSend:n,unsentEntries:r}}class UP{constructor(e){this.app=e,this._canUseIndexedDBPromise=this.runIndexedDBEnvironmentCheck()}async runIndexedDBEnvironmentCheck(){return TA()?IA().then(()=>!0).catch(()=>!1):!1}async read(){if(await this._canUseIndexedDBPromise){const n=await OP(this.app);return n!=null&&n.heartbeats?n:{heartbeats:[]}}else return{heartbeats:[]}}async overwrite(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Iv(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:e.heartbeats})}else return}async add(e){var n;if(await this._canUseIndexedDBPromise){const i=await this.read();return Iv(this.app,{lastSentHeartbeatDate:(n=e.lastSentHeartbeatDate)!==null&&n!==void 0?n:i.lastSentHeartbeatDate,heartbeats:[...i.heartbeats,...e.heartbeats]})}else return}}function kv(t){return Tc(JSON.stringify({version:2,heartbeats:t})).length}/**
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
 */function jP(t){ui(new vr("platform-logger",e=>new ZA(e),"PRIVATE")),ui(new vr("heartbeat",e=>new FP(e),"PRIVATE")),wn(Zf,Ev,t),wn(Zf,Ev,"esm2017"),wn("fire-js","")}jP("");var zP="firebase",BP="10.14.1";/**
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
 */wn(zP,BP,"app");var Cv=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var Fi,eI;(function(){var t;/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/function e(v,_){function E(){}E.prototype=_.prototype,v.D=_.prototype,v.prototype=new E,v.prototype.constructor=v,v.C=function(I,A,b){for(var C=Array(arguments.length-2),Xe=2;Xe<arguments.length;Xe++)C[Xe-2]=arguments[Xe];return _.prototype[A].apply(I,C)}}function n(){this.blockSize=-1}function r(){this.blockSize=-1,this.blockSize=64,this.g=Array(4),this.B=Array(this.blockSize),this.o=this.h=0,this.s()}e(r,n),r.prototype.s=function(){this.g[0]=1732584193,this.g[1]=4023233417,this.g[2]=2562383102,this.g[3]=271733878,this.o=this.h=0};function i(v,_,E){E||(E=0);var I=Array(16);if(typeof _=="string")for(var A=0;16>A;++A)I[A]=_.charCodeAt(E++)|_.charCodeAt(E++)<<8|_.charCodeAt(E++)<<16|_.charCodeAt(E++)<<24;else for(A=0;16>A;++A)I[A]=_[E++]|_[E++]<<8|_[E++]<<16|_[E++]<<24;_=v.g[0],E=v.g[1],A=v.g[2];var b=v.g[3],C=_+(b^E&(A^b))+I[0]+3614090360&4294967295;_=E+(C<<7&4294967295|C>>>25),C=b+(A^_&(E^A))+I[1]+3905402710&4294967295,b=_+(C<<12&4294967295|C>>>20),C=A+(E^b&(_^E))+I[2]+606105819&4294967295,A=b+(C<<17&4294967295|C>>>15),C=E+(_^A&(b^_))+I[3]+3250441966&4294967295,E=A+(C<<22&4294967295|C>>>10),C=_+(b^E&(A^b))+I[4]+4118548399&4294967295,_=E+(C<<7&4294967295|C>>>25),C=b+(A^_&(E^A))+I[5]+1200080426&4294967295,b=_+(C<<12&4294967295|C>>>20),C=A+(E^b&(_^E))+I[6]+2821735955&4294967295,A=b+(C<<17&4294967295|C>>>15),C=E+(_^A&(b^_))+I[7]+4249261313&4294967295,E=A+(C<<22&4294967295|C>>>10),C=_+(b^E&(A^b))+I[8]+1770035416&4294967295,_=E+(C<<7&4294967295|C>>>25),C=b+(A^_&(E^A))+I[9]+2336552879&4294967295,b=_+(C<<12&4294967295|C>>>20),C=A+(E^b&(_^E))+I[10]+4294925233&4294967295,A=b+(C<<17&4294967295|C>>>15),C=E+(_^A&(b^_))+I[11]+2304563134&4294967295,E=A+(C<<22&4294967295|C>>>10),C=_+(b^E&(A^b))+I[12]+1804603682&4294967295,_=E+(C<<7&4294967295|C>>>25),C=b+(A^_&(E^A))+I[13]+4254626195&4294967295,b=_+(C<<12&4294967295|C>>>20),C=A+(E^b&(_^E))+I[14]+2792965006&4294967295,A=b+(C<<17&4294967295|C>>>15),C=E+(_^A&(b^_))+I[15]+1236535329&4294967295,E=A+(C<<22&4294967295|C>>>10),C=_+(A^b&(E^A))+I[1]+4129170786&4294967295,_=E+(C<<5&4294967295|C>>>27),C=b+(E^A&(_^E))+I[6]+3225465664&4294967295,b=_+(C<<9&4294967295|C>>>23),C=A+(_^E&(b^_))+I[11]+643717713&4294967295,A=b+(C<<14&4294967295|C>>>18),C=E+(b^_&(A^b))+I[0]+3921069994&4294967295,E=A+(C<<20&4294967295|C>>>12),C=_+(A^b&(E^A))+I[5]+3593408605&4294967295,_=E+(C<<5&4294967295|C>>>27),C=b+(E^A&(_^E))+I[10]+38016083&4294967295,b=_+(C<<9&4294967295|C>>>23),C=A+(_^E&(b^_))+I[15]+3634488961&4294967295,A=b+(C<<14&4294967295|C>>>18),C=E+(b^_&(A^b))+I[4]+3889429448&4294967295,E=A+(C<<20&4294967295|C>>>12),C=_+(A^b&(E^A))+I[9]+568446438&4294967295,_=E+(C<<5&4294967295|C>>>27),C=b+(E^A&(_^E))+I[14]+3275163606&4294967295,b=_+(C<<9&4294967295|C>>>23),C=A+(_^E&(b^_))+I[3]+4107603335&4294967295,A=b+(C<<14&4294967295|C>>>18),C=E+(b^_&(A^b))+I[8]+1163531501&4294967295,E=A+(C<<20&4294967295|C>>>12),C=_+(A^b&(E^A))+I[13]+2850285829&4294967295,_=E+(C<<5&4294967295|C>>>27),C=b+(E^A&(_^E))+I[2]+4243563512&4294967295,b=_+(C<<9&4294967295|C>>>23),C=A+(_^E&(b^_))+I[7]+1735328473&4294967295,A=b+(C<<14&4294967295|C>>>18),C=E+(b^_&(A^b))+I[12]+2368359562&4294967295,E=A+(C<<20&4294967295|C>>>12),C=_+(E^A^b)+I[5]+4294588738&4294967295,_=E+(C<<4&4294967295|C>>>28),C=b+(_^E^A)+I[8]+2272392833&4294967295,b=_+(C<<11&4294967295|C>>>21),C=A+(b^_^E)+I[11]+1839030562&4294967295,A=b+(C<<16&4294967295|C>>>16),C=E+(A^b^_)+I[14]+4259657740&4294967295,E=A+(C<<23&4294967295|C>>>9),C=_+(E^A^b)+I[1]+2763975236&4294967295,_=E+(C<<4&4294967295|C>>>28),C=b+(_^E^A)+I[4]+1272893353&4294967295,b=_+(C<<11&4294967295|C>>>21),C=A+(b^_^E)+I[7]+4139469664&4294967295,A=b+(C<<16&4294967295|C>>>16),C=E+(A^b^_)+I[10]+3200236656&4294967295,E=A+(C<<23&4294967295|C>>>9),C=_+(E^A^b)+I[13]+681279174&4294967295,_=E+(C<<4&4294967295|C>>>28),C=b+(_^E^A)+I[0]+3936430074&4294967295,b=_+(C<<11&4294967295|C>>>21),C=A+(b^_^E)+I[3]+3572445317&4294967295,A=b+(C<<16&4294967295|C>>>16),C=E+(A^b^_)+I[6]+76029189&4294967295,E=A+(C<<23&4294967295|C>>>9),C=_+(E^A^b)+I[9]+3654602809&4294967295,_=E+(C<<4&4294967295|C>>>28),C=b+(_^E^A)+I[12]+3873151461&4294967295,b=_+(C<<11&4294967295|C>>>21),C=A+(b^_^E)+I[15]+530742520&4294967295,A=b+(C<<16&4294967295|C>>>16),C=E+(A^b^_)+I[2]+3299628645&4294967295,E=A+(C<<23&4294967295|C>>>9),C=_+(A^(E|~b))+I[0]+4096336452&4294967295,_=E+(C<<6&4294967295|C>>>26),C=b+(E^(_|~A))+I[7]+1126891415&4294967295,b=_+(C<<10&4294967295|C>>>22),C=A+(_^(b|~E))+I[14]+2878612391&4294967295,A=b+(C<<15&4294967295|C>>>17),C=E+(b^(A|~_))+I[5]+4237533241&4294967295,E=A+(C<<21&4294967295|C>>>11),C=_+(A^(E|~b))+I[12]+1700485571&4294967295,_=E+(C<<6&4294967295|C>>>26),C=b+(E^(_|~A))+I[3]+2399980690&4294967295,b=_+(C<<10&4294967295|C>>>22),C=A+(_^(b|~E))+I[10]+4293915773&4294967295,A=b+(C<<15&4294967295|C>>>17),C=E+(b^(A|~_))+I[1]+2240044497&4294967295,E=A+(C<<21&4294967295|C>>>11),C=_+(A^(E|~b))+I[8]+1873313359&4294967295,_=E+(C<<6&4294967295|C>>>26),C=b+(E^(_|~A))+I[15]+4264355552&4294967295,b=_+(C<<10&4294967295|C>>>22),C=A+(_^(b|~E))+I[6]+2734768916&4294967295,A=b+(C<<15&4294967295|C>>>17),C=E+(b^(A|~_))+I[13]+1309151649&4294967295,E=A+(C<<21&4294967295|C>>>11),C=_+(A^(E|~b))+I[4]+4149444226&4294967295,_=E+(C<<6&4294967295|C>>>26),C=b+(E^(_|~A))+I[11]+3174756917&4294967295,b=_+(C<<10&4294967295|C>>>22),C=A+(_^(b|~E))+I[2]+718787259&4294967295,A=b+(C<<15&4294967295|C>>>17),C=E+(b^(A|~_))+I[9]+3951481745&4294967295,v.g[0]=v.g[0]+_&4294967295,v.g[1]=v.g[1]+(A+(C<<21&4294967295|C>>>11))&4294967295,v.g[2]=v.g[2]+A&4294967295,v.g[3]=v.g[3]+b&4294967295}r.prototype.u=function(v,_){_===void 0&&(_=v.length);for(var E=_-this.blockSize,I=this.B,A=this.h,b=0;b<_;){if(A==0)for(;b<=E;)i(this,v,b),b+=this.blockSize;if(typeof v=="string"){for(;b<_;)if(I[A++]=v.charCodeAt(b++),A==this.blockSize){i(this,I),A=0;break}}else for(;b<_;)if(I[A++]=v[b++],A==this.blockSize){i(this,I),A=0;break}}this.h=A,this.o+=_},r.prototype.v=function(){var v=Array((56>this.h?this.blockSize:2*this.blockSize)-this.h);v[0]=128;for(var _=1;_<v.length-8;++_)v[_]=0;var E=8*this.o;for(_=v.length-8;_<v.length;++_)v[_]=E&255,E/=256;for(this.u(v),v=Array(16),_=E=0;4>_;++_)for(var I=0;32>I;I+=8)v[E++]=this.g[_]>>>I&255;return v};function s(v,_){var E=a;return Object.prototype.hasOwnProperty.call(E,v)?E[v]:E[v]=_(v)}function o(v,_){this.h=_;for(var E=[],I=!0,A=v.length-1;0<=A;A--){var b=v[A]|0;I&&b==_||(E[A]=b,I=!1)}this.g=E}var a={};function u(v){return-128<=v&&128>v?s(v,function(_){return new o([_|0],0>_?-1:0)}):new o([v|0],0>v?-1:0)}function c(v){if(isNaN(v)||!isFinite(v))return f;if(0>v)return D(c(-v));for(var _=[],E=1,I=0;v>=E;I++)_[I]=v/E|0,E*=4294967296;return new o(_,0)}function h(v,_){if(v.length==0)throw Error("number format error: empty string");if(_=_||10,2>_||36<_)throw Error("radix out of range: "+_);if(v.charAt(0)=="-")return D(h(v.substring(1),_));if(0<=v.indexOf("-"))throw Error('number format error: interior "-" character');for(var E=c(Math.pow(_,8)),I=f,A=0;A<v.length;A+=8){var b=Math.min(8,v.length-A),C=parseInt(v.substring(A,A+b),_);8>b?(b=c(Math.pow(_,b)),I=I.j(b).add(c(C))):(I=I.j(E),I=I.add(c(C)))}return I}var f=u(0),m=u(1),w=u(16777216);t=o.prototype,t.m=function(){if(P(this))return-D(this).m();for(var v=0,_=1,E=0;E<this.g.length;E++){var I=this.i(E);v+=(0<=I?I:4294967296+I)*_,_*=4294967296}return v},t.toString=function(v){if(v=v||10,2>v||36<v)throw Error("radix out of range: "+v);if(S(this))return"0";if(P(this))return"-"+D(this).toString(v);for(var _=c(Math.pow(v,6)),E=this,I="";;){var A=M(E,_).g;E=k(E,A.j(_));var b=((0<E.g.length?E.g[0]:E.h)>>>0).toString(v);if(E=A,S(E))return b+I;for(;6>b.length;)b="0"+b;I=b+I}},t.i=function(v){return 0>v?0:v<this.g.length?this.g[v]:this.h};function S(v){if(v.h!=0)return!1;for(var _=0;_<v.g.length;_++)if(v.g[_]!=0)return!1;return!0}function P(v){return v.h==-1}t.l=function(v){return v=k(this,v),P(v)?-1:S(v)?0:1};function D(v){for(var _=v.g.length,E=[],I=0;I<_;I++)E[I]=~v.g[I];return new o(E,~v.h).add(m)}t.abs=function(){return P(this)?D(this):this},t.add=function(v){for(var _=Math.max(this.g.length,v.g.length),E=[],I=0,A=0;A<=_;A++){var b=I+(this.i(A)&65535)+(v.i(A)&65535),C=(b>>>16)+(this.i(A)>>>16)+(v.i(A)>>>16);I=C>>>16,b&=65535,C&=65535,E[A]=C<<16|b}return new o(E,E[E.length-1]&-2147483648?-1:0)};function k(v,_){return v.add(D(_))}t.j=function(v){if(S(this)||S(v))return f;if(P(this))return P(v)?D(this).j(D(v)):D(D(this).j(v));if(P(v))return D(this.j(D(v)));if(0>this.l(w)&&0>v.l(w))return c(this.m()*v.m());for(var _=this.g.length+v.g.length,E=[],I=0;I<2*_;I++)E[I]=0;for(I=0;I<this.g.length;I++)for(var A=0;A<v.g.length;A++){var b=this.i(I)>>>16,C=this.i(I)&65535,Xe=v.i(A)>>>16,Ne=v.i(A)&65535;E[2*I+2*A]+=C*Ne,T(E,2*I+2*A),E[2*I+2*A+1]+=b*Ne,T(E,2*I+2*A+1),E[2*I+2*A+1]+=C*Xe,T(E,2*I+2*A+1),E[2*I+2*A+2]+=b*Xe,T(E,2*I+2*A+2)}for(I=0;I<_;I++)E[I]=E[2*I+1]<<16|E[2*I];for(I=_;I<2*_;I++)E[I]=0;return new o(E,0)};function T(v,_){for(;(v[_]&65535)!=v[_];)v[_+1]+=v[_]>>>16,v[_]&=65535,_++}function R(v,_){this.g=v,this.h=_}function M(v,_){if(S(_))throw Error("division by zero");if(S(v))return new R(f,f);if(P(v))return _=M(D(v),_),new R(D(_.g),D(_.h));if(P(_))return _=M(v,D(_)),new R(D(_.g),_.h);if(30<v.g.length){if(P(v)||P(_))throw Error("slowDivide_ only works with positive integers.");for(var E=m,I=_;0>=I.l(v);)E=z(E),I=z(I);var A=U(E,1),b=U(I,1);for(I=U(I,2),E=U(E,2);!S(I);){var C=b.add(I);0>=C.l(v)&&(A=A.add(E),b=C),I=U(I,1),E=U(E,1)}return _=k(v,A.j(_)),new R(A,_)}for(A=f;0<=v.l(_);){for(E=Math.max(1,Math.floor(v.m()/_.m())),I=Math.ceil(Math.log(E)/Math.LN2),I=48>=I?1:Math.pow(2,I-48),b=c(E),C=b.j(_);P(C)||0<C.l(v);)E-=I,b=c(E),C=b.j(_);S(b)&&(b=m),A=A.add(b),v=k(v,C)}return new R(A,v)}t.A=function(v){return M(this,v).h},t.and=function(v){for(var _=Math.max(this.g.length,v.g.length),E=[],I=0;I<_;I++)E[I]=this.i(I)&v.i(I);return new o(E,this.h&v.h)},t.or=function(v){for(var _=Math.max(this.g.length,v.g.length),E=[],I=0;I<_;I++)E[I]=this.i(I)|v.i(I);return new o(E,this.h|v.h)},t.xor=function(v){for(var _=Math.max(this.g.length,v.g.length),E=[],I=0;I<_;I++)E[I]=this.i(I)^v.i(I);return new o(E,this.h^v.h)};function z(v){for(var _=v.g.length+1,E=[],I=0;I<_;I++)E[I]=v.i(I)<<1|v.i(I-1)>>>31;return new o(E,v.h)}function U(v,_){var E=_>>5;_%=32;for(var I=v.g.length-E,A=[],b=0;b<I;b++)A[b]=0<_?v.i(b+E)>>>_|v.i(b+E+1)<<32-_:v.i(b+E);return new o(A,v.h)}r.prototype.digest=r.prototype.v,r.prototype.reset=r.prototype.s,r.prototype.update=r.prototype.u,eI=r,o.prototype.add=o.prototype.add,o.prototype.multiply=o.prototype.j,o.prototype.modulo=o.prototype.A,o.prototype.compare=o.prototype.l,o.prototype.toNumber=o.prototype.m,o.prototype.toString=o.prototype.toString,o.prototype.getBits=o.prototype.i,o.fromNumber=c,o.fromString=h,Fi=o}).apply(typeof Cv<"u"?Cv:typeof self<"u"?self:typeof window<"u"?window:{});var _u=typeof globalThis<"u"?globalThis:typeof window<"u"?window:typeof global<"u"?global:typeof self<"u"?self:{};/** @license
Copyright The Closure Library Authors.
SPDX-License-Identifier: Apache-2.0
*/var tI,ha,nI,zu,np,rI,iI,sI;(function(){var t,e=typeof Object.defineProperties=="function"?Object.defineProperty:function(l,d,p){return l==Array.prototype||l==Object.prototype||(l[d]=p.value),l};function n(l){l=[typeof globalThis=="object"&&globalThis,l,typeof window=="object"&&window,typeof self=="object"&&self,typeof _u=="object"&&_u];for(var d=0;d<l.length;++d){var p=l[d];if(p&&p.Math==Math)return p}throw Error("Cannot find global object")}var r=n(this);function i(l,d){if(d)e:{var p=r;l=l.split(".");for(var y=0;y<l.length-1;y++){var O=l[y];if(!(O in p))break e;p=p[O]}l=l[l.length-1],y=p[l],d=d(y),d!=y&&d!=null&&e(p,l,{configurable:!0,writable:!0,value:d})}}function s(l,d){l instanceof String&&(l+="");var p=0,y=!1,O={next:function(){if(!y&&p<l.length){var L=p++;return{value:d(L,l[L]),done:!1}}return y=!0,{done:!0,value:void 0}}};return O[Symbol.iterator]=function(){return O},O}i("Array.prototype.values",function(l){return l||function(){return s(this,function(d,p){return p})}});/** @license

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/var o=o||{},a=this||self;function u(l){var d=typeof l;return d=d!="object"?d:l?Array.isArray(l)?"array":d:"null",d=="array"||d=="object"&&typeof l.length=="number"}function c(l){var d=typeof l;return d=="object"&&l!=null||d=="function"}function h(l,d,p){return l.call.apply(l.bind,arguments)}function f(l,d,p){if(!l)throw Error();if(2<arguments.length){var y=Array.prototype.slice.call(arguments,2);return function(){var O=Array.prototype.slice.call(arguments);return Array.prototype.unshift.apply(O,y),l.apply(d,O)}}return function(){return l.apply(d,arguments)}}function m(l,d,p){return m=Function.prototype.bind&&Function.prototype.bind.toString().indexOf("native code")!=-1?h:f,m.apply(null,arguments)}function w(l,d){var p=Array.prototype.slice.call(arguments,1);return function(){var y=p.slice();return y.push.apply(y,arguments),l.apply(this,y)}}function S(l,d){function p(){}p.prototype=d.prototype,l.aa=d.prototype,l.prototype=new p,l.prototype.constructor=l,l.Qb=function(y,O,L){for(var q=Array(arguments.length-2),Ae=2;Ae<arguments.length;Ae++)q[Ae-2]=arguments[Ae];return d.prototype[O].apply(y,q)}}function P(l){const d=l.length;if(0<d){const p=Array(d);for(let y=0;y<d;y++)p[y]=l[y];return p}return[]}function D(l,d){for(let p=1;p<arguments.length;p++){const y=arguments[p];if(u(y)){const O=l.length||0,L=y.length||0;l.length=O+L;for(let q=0;q<L;q++)l[O+q]=y[q]}else l.push(y)}}class k{constructor(d,p){this.i=d,this.j=p,this.h=0,this.g=null}get(){let d;return 0<this.h?(this.h--,d=this.g,this.g=d.next,d.next=null):d=this.i(),d}}function T(l){return/^[\s\xa0]*$/.test(l)}function R(){var l=a.navigator;return l&&(l=l.userAgent)?l:""}function M(l){return M[" "](l),l}M[" "]=function(){};var z=R().indexOf("Gecko")!=-1&&!(R().toLowerCase().indexOf("webkit")!=-1&&R().indexOf("Edge")==-1)&&!(R().indexOf("Trident")!=-1||R().indexOf("MSIE")!=-1)&&R().indexOf("Edge")==-1;function U(l,d,p){for(const y in l)d.call(p,l[y],y,l)}function v(l,d){for(const p in l)d.call(void 0,l[p],p,l)}function _(l){const d={};for(const p in l)d[p]=l[p];return d}const E="constructor hasOwnProperty isPrototypeOf propertyIsEnumerable toLocaleString toString valueOf".split(" ");function I(l,d){let p,y;for(let O=1;O<arguments.length;O++){y=arguments[O];for(p in y)l[p]=y[p];for(let L=0;L<E.length;L++)p=E[L],Object.prototype.hasOwnProperty.call(y,p)&&(l[p]=y[p])}}function A(l){var d=1;l=l.split(":");const p=[];for(;0<d&&l.length;)p.push(l.shift()),d--;return l.length&&p.push(l.join(":")),p}function b(l){a.setTimeout(()=>{throw l},0)}function C(){var l=te;let d=null;return l.g&&(d=l.g,l.g=l.g.next,l.g||(l.h=null),d.next=null),d}class Xe{constructor(){this.h=this.g=null}add(d,p){const y=Ne.get();y.set(d,p),this.h?this.h.next=y:this.g=y,this.h=y}}var Ne=new k(()=>new Ut,l=>l.reset());class Ut{constructor(){this.next=this.g=this.h=null}set(d,p){this.h=d,this.g=p,this.next=null}reset(){this.next=this.g=this.h=null}}let gt,H=!1,te=new Xe,N=()=>{const l=a.Promise.resolve(void 0);gt=()=>{l.then(x)}};var x=()=>{for(var l;l=C();){try{l.h.call(l.g)}catch(p){b(p)}var d=Ne;d.j(l),100>d.h&&(d.h++,l.next=d.g,d.g=l)}H=!1};function $(){this.s=this.s,this.C=this.C}$.prototype.s=!1,$.prototype.ma=function(){this.s||(this.s=!0,this.N())},$.prototype.N=function(){if(this.C)for(;this.C.length;)this.C.shift()()};function F(l,d){this.type=l,this.g=this.target=d,this.defaultPrevented=!1}F.prototype.h=function(){this.defaultPrevented=!0};var W=function(){if(!a.addEventListener||!Object.defineProperty)return!1;var l=!1,d=Object.defineProperty({},"passive",{get:function(){l=!0}});try{const p=()=>{};a.addEventListener("test",p,d),a.removeEventListener("test",p,d)}catch{}return l}();function K(l,d){if(F.call(this,l?l.type:""),this.relatedTarget=this.g=this.target=null,this.button=this.screenY=this.screenX=this.clientY=this.clientX=0,this.key="",this.metaKey=this.shiftKey=this.altKey=this.ctrlKey=!1,this.state=null,this.pointerId=0,this.pointerType="",this.i=null,l){var p=this.type=l.type,y=l.changedTouches&&l.changedTouches.length?l.changedTouches[0]:null;if(this.target=l.target||l.srcElement,this.g=d,d=l.relatedTarget){if(z){e:{try{M(d.nodeName);var O=!0;break e}catch{}O=!1}O||(d=null)}}else p=="mouseover"?d=l.fromElement:p=="mouseout"&&(d=l.toElement);this.relatedTarget=d,y?(this.clientX=y.clientX!==void 0?y.clientX:y.pageX,this.clientY=y.clientY!==void 0?y.clientY:y.pageY,this.screenX=y.screenX||0,this.screenY=y.screenY||0):(this.clientX=l.clientX!==void 0?l.clientX:l.pageX,this.clientY=l.clientY!==void 0?l.clientY:l.pageY,this.screenX=l.screenX||0,this.screenY=l.screenY||0),this.button=l.button,this.key=l.key||"",this.ctrlKey=l.ctrlKey,this.altKey=l.altKey,this.shiftKey=l.shiftKey,this.metaKey=l.metaKey,this.pointerId=l.pointerId||0,this.pointerType=typeof l.pointerType=="string"?l.pointerType:Z[l.pointerType]||"",this.state=l.state,this.i=l,l.defaultPrevented&&K.aa.h.call(this)}}S(K,F);var Z={2:"touch",3:"pen",4:"mouse"};K.prototype.h=function(){K.aa.h.call(this);var l=this.i;l.preventDefault?l.preventDefault():l.returnValue=!1};var Y="closure_listenable_"+(1e6*Math.random()|0),re=0;function ne(l,d,p,y,O){this.listener=l,this.proxy=null,this.src=d,this.type=p,this.capture=!!y,this.ha=O,this.key=++re,this.da=this.fa=!1}function Ee(l){l.da=!0,l.listener=null,l.proxy=null,l.src=null,l.ha=null}function he(l){this.src=l,this.g={},this.h=0}he.prototype.add=function(l,d,p,y,O){var L=l.toString();l=this.g[L],l||(l=this.g[L]=[],this.h++);var q=Be(l,d,y,O);return-1<q?(d=l[q],p||(d.fa=!1)):(d=new ne(d,this.src,L,!!y,O),d.fa=p,l.push(d)),d};function Ce(l,d){var p=d.type;if(p in l.g){var y=l.g[p],O=Array.prototype.indexOf.call(y,d,void 0),L;(L=0<=O)&&Array.prototype.splice.call(y,O,1),L&&(Ee(d),l.g[p].length==0&&(delete l.g[p],l.h--))}}function Be(l,d,p,y){for(var O=0;O<l.length;++O){var L=l[O];if(!L.da&&L.listener==d&&L.capture==!!p&&L.ha==y)return O}return-1}var ue="closure_lm_"+(1e6*Math.random()|0),et={};function ct(l,d,p,y,O){if(Array.isArray(d)){for(var L=0;L<d.length;L++)ct(l,d[L],p,y,O);return null}return p=Fl(p),l&&l[Y]?l.K(d,p,c(y)?!!y.capture:!1,O):tn(l,d,p,!1,y,O)}function tn(l,d,p,y,O,L){if(!d)throw Error("Invalid event type");var q=c(O)?!!O.capture:!!O,Ae=xo(l);if(Ae||(l[ue]=Ae=new he(l)),p=Ae.add(d,p,y,q,L),p.proxy)return p;if(y=kn(),p.proxy=y,y.src=l,y.listener=p,l.addEventListener)W||(O=q),O===void 0&&(O=!1),l.addEventListener(d.toString(),y,O);else if(l.attachEvent)l.attachEvent(Ll(d.toString()),y);else if(l.addListener&&l.removeListener)l.addListener(y);else throw Error("addEventListener and attachEvent are unavailable.");return p}function kn(){function l(p){return d.call(l.src,l.listener,p)}const d=$h;return l}function Un(l,d,p,y,O){if(Array.isArray(d))for(var L=0;L<d.length;L++)Un(l,d[L],p,y,O);else y=c(y)?!!y.capture:!!y,p=Fl(p),l&&l[Y]?(l=l.i,d=String(d).toString(),d in l.g&&(L=l.g[d],p=Be(L,p,y,O),-1<p&&(Ee(L[p]),Array.prototype.splice.call(L,p,1),L.length==0&&(delete l.g[d],l.h--)))):l&&(l=xo(l))&&(d=l.g[d.toString()],l=-1,d&&(l=Be(d,p,y,O)),(p=-1<l?d[l]:null)&&Ht(p))}function Ht(l){if(typeof l!="number"&&l&&!l.da){var d=l.src;if(d&&d[Y])Ce(d.i,l);else{var p=l.type,y=l.proxy;d.removeEventListener?d.removeEventListener(p,y,l.capture):d.detachEvent?d.detachEvent(Ll(p),y):d.addListener&&d.removeListener&&d.removeListener(y),(p=xo(d))?(Ce(p,l),p.h==0&&(p.src=null,d[ue]=null)):Ee(l)}}}function Ll(l){return l in et?et[l]:et[l]="on"+l}function $h(l,d){if(l.da)l=!0;else{d=new K(d,this);var p=l.listener,y=l.ha||l.src;l.fa&&Ht(l),l=p.call(y,d)}return l}function xo(l){return l=l[ue],l instanceof he?l:null}var ls="__closure_events_fn_"+(1e9*Math.random()>>>0);function Fl(l){return typeof l=="function"?l:(l[ls]||(l[ls]=function(d){return l.handleEvent(d)}),l[ls])}function st(){$.call(this),this.i=new he(this),this.M=this,this.F=null}S(st,$),st.prototype[Y]=!0,st.prototype.removeEventListener=function(l,d,p,y){Un(this,l,d,p,y)};function _t(l,d){var p,y=l.F;if(y)for(p=[];y;y=y.F)p.push(y);if(l=l.M,y=d.type||d,typeof d=="string")d=new F(d,l);else if(d instanceof F)d.target=d.target||l;else{var O=d;d=new F(y,l),I(d,O)}if(O=!0,p)for(var L=p.length-1;0<=L;L--){var q=d.g=p[L];O=us(q,y,!0,d)&&O}if(q=d.g=l,O=us(q,y,!0,d)&&O,O=us(q,y,!1,d)&&O,p)for(L=0;L<p.length;L++)q=d.g=p[L],O=us(q,y,!1,d)&&O}st.prototype.N=function(){if(st.aa.N.call(this),this.i){var l=this.i,d;for(d in l.g){for(var p=l.g[d],y=0;y<p.length;y++)Ee(p[y]);delete l.g[d],l.h--}}this.F=null},st.prototype.K=function(l,d,p,y){return this.i.add(String(l),d,!1,p,y)},st.prototype.L=function(l,d,p,y){return this.i.add(String(l),d,!0,p,y)};function us(l,d,p,y){if(d=l.i.g[String(d)],!d)return!0;d=d.concat();for(var O=!0,L=0;L<d.length;++L){var q=d[L];if(q&&!q.da&&q.capture==p){var Ae=q.listener,yt=q.ha||q.src;q.fa&&Ce(l.i,q),O=Ae.call(yt,y)!==!1&&O}}return O&&!y.defaultPrevented}function Ao(l,d,p){if(typeof l=="function")p&&(l=m(l,p));else if(l&&typeof l.handleEvent=="function")l=m(l.handleEvent,l);else throw Error("Invalid listener argument");return 2147483647<Number(d)?-1:a.setTimeout(l,d||0)}function Po(l){l.g=Ao(()=>{l.g=null,l.i&&(l.i=!1,Po(l))},l.l);const d=l.h;l.h=null,l.m.apply(null,d)}class bo extends ${constructor(d,p){super(),this.m=d,this.l=p,this.h=null,this.i=!1,this.g=null}j(d){this.h=arguments,this.g?this.i=!0:Po(this)}N(){super.N(),this.g&&(a.clearTimeout(this.g),this.g=null,this.i=!1,this.h=null)}}function vi(l){$.call(this),this.h=l,this.g={}}S(vi,$);var Vl=[];function h_(l){U(l.g,function(d,p){this.g.hasOwnProperty(p)&&Ht(d)},l),l.g={}}vi.prototype.N=function(){vi.aa.N.call(this),h_(this)},vi.prototype.handleEvent=function(){throw Error("EventHandler.handleEvent not implemented")};var Wh=a.JSON.stringify,W1=a.JSON.parse,q1=class{stringify(l){return a.JSON.stringify(l,void 0)}parse(l){return a.JSON.parse(l,void 0)}};function qh(){}qh.prototype.h=null;function d_(l){return l.h||(l.h=l.i())}function f_(){}var No={OPEN:"a",kb:"b",Ja:"c",wb:"d"};function Hh(){F.call(this,"d")}S(Hh,F);function Gh(){F.call(this,"c")}S(Gh,F);var wi={},p_=null;function Ul(){return p_=p_||new st}wi.La="serverreachability";function m_(l){F.call(this,wi.La,l)}S(m_,F);function Do(l){const d=Ul();_t(d,new m_(d))}wi.STAT_EVENT="statevent";function g_(l,d){F.call(this,wi.STAT_EVENT,l),this.stat=d}S(g_,F);function jt(l){const d=Ul();_t(d,new g_(d,l))}wi.Ma="timingevent";function __(l,d){F.call(this,wi.Ma,l),this.size=d}S(__,F);function Oo(l,d){if(typeof l!="function")throw Error("Fn must not be null and must be a function");return a.setTimeout(function(){l()},d)}function Mo(){this.g=!0}Mo.prototype.xa=function(){this.g=!1};function H1(l,d,p,y,O,L){l.info(function(){if(l.g)if(L)for(var q="",Ae=L.split("&"),yt=0;yt<Ae.length;yt++){var ve=Ae[yt].split("=");if(1<ve.length){var Rt=ve[0];ve=ve[1];var xt=Rt.split("_");q=2<=xt.length&&xt[1]=="type"?q+(Rt+"="+ve+"&"):q+(Rt+"=redacted&")}}else q=null;else q=L;return"XMLHTTP REQ ("+y+") [attempt "+O+"]: "+d+`
`+p+`
`+q})}function G1(l,d,p,y,O,L,q){l.info(function(){return"XMLHTTP RESP ("+y+") [ attempt "+O+"]: "+d+`
`+p+`
`+L+" "+q})}function cs(l,d,p,y){l.info(function(){return"XMLHTTP TEXT ("+d+"): "+Q1(l,p)+(y?" "+y:"")})}function K1(l,d){l.info(function(){return"TIMEOUT: "+d})}Mo.prototype.info=function(){};function Q1(l,d){if(!l.g)return d;if(!d)return null;try{var p=JSON.parse(d);if(p){for(l=0;l<p.length;l++)if(Array.isArray(p[l])){var y=p[l];if(!(2>y.length)){var O=y[1];if(Array.isArray(O)&&!(1>O.length)){var L=O[0];if(L!="noop"&&L!="stop"&&L!="close")for(var q=1;q<O.length;q++)O[q]=""}}}}return Wh(p)}catch{return d}}var jl={NO_ERROR:0,gb:1,tb:2,sb:3,nb:4,rb:5,ub:6,Ia:7,TIMEOUT:8,xb:9},y_={lb:"complete",Hb:"success",Ja:"error",Ia:"abort",zb:"ready",Ab:"readystatechange",TIMEOUT:"timeout",vb:"incrementaldata",yb:"progress",ob:"downloadprogress",Pb:"uploadprogress"},Kh;function zl(){}S(zl,qh),zl.prototype.g=function(){return new XMLHttpRequest},zl.prototype.i=function(){return{}},Kh=new zl;function Ar(l,d,p,y){this.j=l,this.i=d,this.l=p,this.R=y||1,this.U=new vi(this),this.I=45e3,this.H=null,this.o=!1,this.m=this.A=this.v=this.L=this.F=this.S=this.B=null,this.D=[],this.g=null,this.C=0,this.s=this.u=null,this.X=-1,this.J=!1,this.O=0,this.M=null,this.W=this.K=this.T=this.P=!1,this.h=new v_}function v_(){this.i=null,this.g="",this.h=!1}var w_={},Qh={};function Yh(l,d,p){l.L=1,l.v=ql(er(d)),l.m=p,l.P=!0,E_(l,null)}function E_(l,d){l.F=Date.now(),Bl(l),l.A=er(l.v);var p=l.A,y=l.R;Array.isArray(y)||(y=[String(y)]),M_(p.i,"t",y),l.C=0,p=l.j.J,l.h=new v_,l.g=Z_(l.j,p?d:null,!l.m),0<l.O&&(l.M=new bo(m(l.Y,l,l.g),l.O)),d=l.U,p=l.g,y=l.ca;var O="readystatechange";Array.isArray(O)||(O&&(Vl[0]=O.toString()),O=Vl);for(var L=0;L<O.length;L++){var q=ct(p,O[L],y||d.handleEvent,!1,d.h||d);if(!q)break;d.g[q.key]=q}d=l.H?_(l.H):{},l.m?(l.u||(l.u="POST"),d["Content-Type"]="application/x-www-form-urlencoded",l.g.ea(l.A,l.u,l.m,d)):(l.u="GET",l.g.ea(l.A,l.u,null,d)),Do(),H1(l.i,l.u,l.A,l.l,l.R,l.m)}Ar.prototype.ca=function(l){l=l.target;const d=this.M;d&&tr(l)==3?d.j():this.Y(l)},Ar.prototype.Y=function(l){try{if(l==this.g)e:{const xt=tr(this.g);var d=this.g.Ba();const fs=this.g.Z();if(!(3>xt)&&(xt!=3||this.g&&(this.h.h||this.g.oa()||B_(this.g)))){this.J||xt!=4||d==7||(d==8||0>=fs?Do(3):Do(2)),Xh(this);var p=this.g.Z();this.X=p;t:if(T_(this)){var y=B_(this.g);l="";var O=y.length,L=tr(this.g)==4;if(!this.h.i){if(typeof TextDecoder>"u"){Ei(this),Lo(this);var q="";break t}this.h.i=new a.TextDecoder}for(d=0;d<O;d++)this.h.h=!0,l+=this.h.i.decode(y[d],{stream:!(L&&d==O-1)});y.length=0,this.h.g+=l,this.C=0,q=this.h.g}else q=this.g.oa();if(this.o=p==200,G1(this.i,this.u,this.A,this.l,this.R,xt,p),this.o){if(this.T&&!this.K){t:{if(this.g){var Ae,yt=this.g;if((Ae=yt.g?yt.g.getResponseHeader("X-HTTP-Initial-Response"):null)&&!T(Ae)){var ve=Ae;break t}}ve=null}if(p=ve)cs(this.i,this.l,p,"Initial handshake response via X-HTTP-Initial-Response"),this.K=!0,Jh(this,p);else{this.o=!1,this.s=3,jt(12),Ei(this),Lo(this);break e}}if(this.P){p=!0;let Cn;for(;!this.J&&this.C<q.length;)if(Cn=Y1(this,q),Cn==Qh){xt==4&&(this.s=4,jt(14),p=!1),cs(this.i,this.l,null,"[Incomplete Response]");break}else if(Cn==w_){this.s=4,jt(15),cs(this.i,this.l,q,"[Invalid Chunk]"),p=!1;break}else cs(this.i,this.l,Cn,null),Jh(this,Cn);if(T_(this)&&this.C!=0&&(this.h.g=this.h.g.slice(this.C),this.C=0),xt!=4||q.length!=0||this.h.h||(this.s=1,jt(16),p=!1),this.o=this.o&&p,!p)cs(this.i,this.l,q,"[Invalid Chunked Response]"),Ei(this),Lo(this);else if(0<q.length&&!this.W){this.W=!0;var Rt=this.j;Rt.g==this&&Rt.ba&&!Rt.M&&(Rt.j.info("Great, no buffering proxy detected. Bytes received: "+q.length),id(Rt),Rt.M=!0,jt(11))}}else cs(this.i,this.l,q,null),Jh(this,q);xt==4&&Ei(this),this.o&&!this.J&&(xt==4?Q_(this.j,this):(this.o=!1,Bl(this)))}else fC(this.g),p==400&&0<q.indexOf("Unknown SID")?(this.s=3,jt(12)):(this.s=0,jt(13)),Ei(this),Lo(this)}}}catch{}finally{}};function T_(l){return l.g?l.u=="GET"&&l.L!=2&&l.j.Ca:!1}function Y1(l,d){var p=l.C,y=d.indexOf(`
`,p);return y==-1?Qh:(p=Number(d.substring(p,y)),isNaN(p)?w_:(y+=1,y+p>d.length?Qh:(d=d.slice(y,y+p),l.C=y+p,d)))}Ar.prototype.cancel=function(){this.J=!0,Ei(this)};function Bl(l){l.S=Date.now()+l.I,I_(l,l.I)}function I_(l,d){if(l.B!=null)throw Error("WatchDog timer not null");l.B=Oo(m(l.ba,l),d)}function Xh(l){l.B&&(a.clearTimeout(l.B),l.B=null)}Ar.prototype.ba=function(){this.B=null;const l=Date.now();0<=l-this.S?(K1(this.i,this.A),this.L!=2&&(Do(),jt(17)),Ei(this),this.s=2,Lo(this)):I_(this,this.S-l)};function Lo(l){l.j.G==0||l.J||Q_(l.j,l)}function Ei(l){Xh(l);var d=l.M;d&&typeof d.ma=="function"&&d.ma(),l.M=null,h_(l.U),l.g&&(d=l.g,l.g=null,d.abort(),d.ma())}function Jh(l,d){try{var p=l.j;if(p.G!=0&&(p.g==l||Zh(p.h,l))){if(!l.K&&Zh(p.h,l)&&p.G==3){try{var y=p.Da.g.parse(d)}catch{y=null}if(Array.isArray(y)&&y.length==3){var O=y;if(O[0]==0){e:if(!p.u){if(p.g)if(p.g.F+3e3<l.F)Xl(p),Ql(p);else break e;rd(p),jt(18)}}else p.za=O[1],0<p.za-p.T&&37500>O[2]&&p.F&&p.v==0&&!p.C&&(p.C=Oo(m(p.Za,p),6e3));if(1>=C_(p.h)&&p.ca){try{p.ca()}catch{}p.ca=void 0}}else Ii(p,11)}else if((l.K||p.g==l)&&Xl(p),!T(d))for(O=p.Da.g.parse(d),d=0;d<O.length;d++){let ve=O[d];if(p.T=ve[0],ve=ve[1],p.G==2)if(ve[0]=="c"){p.K=ve[1],p.ia=ve[2];const Rt=ve[3];Rt!=null&&(p.la=Rt,p.j.info("VER="+p.la));const xt=ve[4];xt!=null&&(p.Aa=xt,p.j.info("SVER="+p.Aa));const fs=ve[5];fs!=null&&typeof fs=="number"&&0<fs&&(y=1.5*fs,p.L=y,p.j.info("backChannelRequestTimeoutMs_="+y)),y=p;const Cn=l.g;if(Cn){const Zl=Cn.g?Cn.g.getResponseHeader("X-Client-Wire-Protocol"):null;if(Zl){var L=y.h;L.g||Zl.indexOf("spdy")==-1&&Zl.indexOf("quic")==-1&&Zl.indexOf("h2")==-1||(L.j=L.l,L.g=new Set,L.h&&(ed(L,L.h),L.h=null))}if(y.D){const sd=Cn.g?Cn.g.getResponseHeader("X-HTTP-Session-Id"):null;sd&&(y.ya=sd,Oe(y.I,y.D,sd))}}p.G=3,p.l&&p.l.ua(),p.ba&&(p.R=Date.now()-l.F,p.j.info("Handshake RTT: "+p.R+"ms")),y=p;var q=l;if(y.qa=J_(y,y.J?y.ia:null,y.W),q.K){R_(y.h,q);var Ae=q,yt=y.L;yt&&(Ae.I=yt),Ae.B&&(Xh(Ae),Bl(Ae)),y.g=q}else G_(y);0<p.i.length&&Yl(p)}else ve[0]!="stop"&&ve[0]!="close"||Ii(p,7);else p.G==3&&(ve[0]=="stop"||ve[0]=="close"?ve[0]=="stop"?Ii(p,7):nd(p):ve[0]!="noop"&&p.l&&p.l.ta(ve),p.v=0)}}Do(4)}catch{}}var X1=class{constructor(l,d){this.g=l,this.map=d}};function S_(l){this.l=l||10,a.PerformanceNavigationTiming?(l=a.performance.getEntriesByType("navigation"),l=0<l.length&&(l[0].nextHopProtocol=="hq"||l[0].nextHopProtocol=="h2")):l=!!(a.chrome&&a.chrome.loadTimes&&a.chrome.loadTimes()&&a.chrome.loadTimes().wasFetchedViaSpdy),this.j=l?this.l:1,this.g=null,1<this.j&&(this.g=new Set),this.h=null,this.i=[]}function k_(l){return l.h?!0:l.g?l.g.size>=l.j:!1}function C_(l){return l.h?1:l.g?l.g.size:0}function Zh(l,d){return l.h?l.h==d:l.g?l.g.has(d):!1}function ed(l,d){l.g?l.g.add(d):l.h=d}function R_(l,d){l.h&&l.h==d?l.h=null:l.g&&l.g.has(d)&&l.g.delete(d)}S_.prototype.cancel=function(){if(this.i=x_(this),this.h)this.h.cancel(),this.h=null;else if(this.g&&this.g.size!==0){for(const l of this.g.values())l.cancel();this.g.clear()}};function x_(l){if(l.h!=null)return l.i.concat(l.h.D);if(l.g!=null&&l.g.size!==0){let d=l.i;for(const p of l.g.values())d=d.concat(p.D);return d}return P(l.i)}function J1(l){if(l.V&&typeof l.V=="function")return l.V();if(typeof Map<"u"&&l instanceof Map||typeof Set<"u"&&l instanceof Set)return Array.from(l.values());if(typeof l=="string")return l.split("");if(u(l)){for(var d=[],p=l.length,y=0;y<p;y++)d.push(l[y]);return d}d=[],p=0;for(y in l)d[p++]=l[y];return d}function Z1(l){if(l.na&&typeof l.na=="function")return l.na();if(!l.V||typeof l.V!="function"){if(typeof Map<"u"&&l instanceof Map)return Array.from(l.keys());if(!(typeof Set<"u"&&l instanceof Set)){if(u(l)||typeof l=="string"){var d=[];l=l.length;for(var p=0;p<l;p++)d.push(p);return d}d=[],p=0;for(const y in l)d[p++]=y;return d}}}function A_(l,d){if(l.forEach&&typeof l.forEach=="function")l.forEach(d,void 0);else if(u(l)||typeof l=="string")Array.prototype.forEach.call(l,d,void 0);else for(var p=Z1(l),y=J1(l),O=y.length,L=0;L<O;L++)d.call(void 0,y[L],p&&p[L],l)}var P_=RegExp("^(?:([^:/?#.]+):)?(?://(?:([^\\\\/?#]*)@)?([^\\\\/?#]*?)(?::([0-9]+))?(?=[\\\\/?#]|$))?([^?#]+)?(?:\\?([^#]*))?(?:#([\\s\\S]*))?$");function eC(l,d){if(l){l=l.split("&");for(var p=0;p<l.length;p++){var y=l[p].indexOf("="),O=null;if(0<=y){var L=l[p].substring(0,y);O=l[p].substring(y+1)}else L=l[p];d(L,O?decodeURIComponent(O.replace(/\+/g," ")):"")}}}function Ti(l){if(this.g=this.o=this.j="",this.s=null,this.m=this.l="",this.h=!1,l instanceof Ti){this.h=l.h,$l(this,l.j),this.o=l.o,this.g=l.g,Wl(this,l.s),this.l=l.l;var d=l.i,p=new Uo;p.i=d.i,d.g&&(p.g=new Map(d.g),p.h=d.h),b_(this,p),this.m=l.m}else l&&(d=String(l).match(P_))?(this.h=!1,$l(this,d[1]||"",!0),this.o=Fo(d[2]||""),this.g=Fo(d[3]||"",!0),Wl(this,d[4]),this.l=Fo(d[5]||"",!0),b_(this,d[6]||"",!0),this.m=Fo(d[7]||"")):(this.h=!1,this.i=new Uo(null,this.h))}Ti.prototype.toString=function(){var l=[],d=this.j;d&&l.push(Vo(d,N_,!0),":");var p=this.g;return(p||d=="file")&&(l.push("//"),(d=this.o)&&l.push(Vo(d,N_,!0),"@"),l.push(encodeURIComponent(String(p)).replace(/%25([0-9a-fA-F]{2})/g,"%$1")),p=this.s,p!=null&&l.push(":",String(p))),(p=this.l)&&(this.g&&p.charAt(0)!="/"&&l.push("/"),l.push(Vo(p,p.charAt(0)=="/"?rC:nC,!0))),(p=this.i.toString())&&l.push("?",p),(p=this.m)&&l.push("#",Vo(p,sC)),l.join("")};function er(l){return new Ti(l)}function $l(l,d,p){l.j=p?Fo(d,!0):d,l.j&&(l.j=l.j.replace(/:$/,""))}function Wl(l,d){if(d){if(d=Number(d),isNaN(d)||0>d)throw Error("Bad port number "+d);l.s=d}else l.s=null}function b_(l,d,p){d instanceof Uo?(l.i=d,oC(l.i,l.h)):(p||(d=Vo(d,iC)),l.i=new Uo(d,l.h))}function Oe(l,d,p){l.i.set(d,p)}function ql(l){return Oe(l,"zx",Math.floor(2147483648*Math.random()).toString(36)+Math.abs(Math.floor(2147483648*Math.random())^Date.now()).toString(36)),l}function Fo(l,d){return l?d?decodeURI(l.replace(/%25/g,"%2525")):decodeURIComponent(l):""}function Vo(l,d,p){return typeof l=="string"?(l=encodeURI(l).replace(d,tC),p&&(l=l.replace(/%25([0-9a-fA-F]{2})/g,"%$1")),l):null}function tC(l){return l=l.charCodeAt(0),"%"+(l>>4&15).toString(16)+(l&15).toString(16)}var N_=/[#\/\?@]/g,nC=/[#\?:]/g,rC=/[#\?]/g,iC=/[#\?@]/g,sC=/#/g;function Uo(l,d){this.h=this.g=null,this.i=l||null,this.j=!!d}function Pr(l){l.g||(l.g=new Map,l.h=0,l.i&&eC(l.i,function(d,p){l.add(decodeURIComponent(d.replace(/\+/g," ")),p)}))}t=Uo.prototype,t.add=function(l,d){Pr(this),this.i=null,l=hs(this,l);var p=this.g.get(l);return p||this.g.set(l,p=[]),p.push(d),this.h+=1,this};function D_(l,d){Pr(l),d=hs(l,d),l.g.has(d)&&(l.i=null,l.h-=l.g.get(d).length,l.g.delete(d))}function O_(l,d){return Pr(l),d=hs(l,d),l.g.has(d)}t.forEach=function(l,d){Pr(this),this.g.forEach(function(p,y){p.forEach(function(O){l.call(d,O,y,this)},this)},this)},t.na=function(){Pr(this);const l=Array.from(this.g.values()),d=Array.from(this.g.keys()),p=[];for(let y=0;y<d.length;y++){const O=l[y];for(let L=0;L<O.length;L++)p.push(d[y])}return p},t.V=function(l){Pr(this);let d=[];if(typeof l=="string")O_(this,l)&&(d=d.concat(this.g.get(hs(this,l))));else{l=Array.from(this.g.values());for(let p=0;p<l.length;p++)d=d.concat(l[p])}return d},t.set=function(l,d){return Pr(this),this.i=null,l=hs(this,l),O_(this,l)&&(this.h-=this.g.get(l).length),this.g.set(l,[d]),this.h+=1,this},t.get=function(l,d){return l?(l=this.V(l),0<l.length?String(l[0]):d):d};function M_(l,d,p){D_(l,d),0<p.length&&(l.i=null,l.g.set(hs(l,d),P(p)),l.h+=p.length)}t.toString=function(){if(this.i)return this.i;if(!this.g)return"";const l=[],d=Array.from(this.g.keys());for(var p=0;p<d.length;p++){var y=d[p];const L=encodeURIComponent(String(y)),q=this.V(y);for(y=0;y<q.length;y++){var O=L;q[y]!==""&&(O+="="+encodeURIComponent(String(q[y]))),l.push(O)}}return this.i=l.join("&")};function hs(l,d){return d=String(d),l.j&&(d=d.toLowerCase()),d}function oC(l,d){d&&!l.j&&(Pr(l),l.i=null,l.g.forEach(function(p,y){var O=y.toLowerCase();y!=O&&(D_(this,y),M_(this,O,p))},l)),l.j=d}function aC(l,d){const p=new Mo;if(a.Image){const y=new Image;y.onload=w(br,p,"TestLoadImage: loaded",!0,d,y),y.onerror=w(br,p,"TestLoadImage: error",!1,d,y),y.onabort=w(br,p,"TestLoadImage: abort",!1,d,y),y.ontimeout=w(br,p,"TestLoadImage: timeout",!1,d,y),a.setTimeout(function(){y.ontimeout&&y.ontimeout()},1e4),y.src=l}else d(!1)}function lC(l,d){const p=new Mo,y=new AbortController,O=setTimeout(()=>{y.abort(),br(p,"TestPingServer: timeout",!1,d)},1e4);fetch(l,{signal:y.signal}).then(L=>{clearTimeout(O),L.ok?br(p,"TestPingServer: ok",!0,d):br(p,"TestPingServer: server error",!1,d)}).catch(()=>{clearTimeout(O),br(p,"TestPingServer: error",!1,d)})}function br(l,d,p,y,O){try{O&&(O.onload=null,O.onerror=null,O.onabort=null,O.ontimeout=null),y(p)}catch{}}function uC(){this.g=new q1}function cC(l,d,p){const y=p||"";try{A_(l,function(O,L){let q=O;c(O)&&(q=Wh(O)),d.push(y+L+"="+encodeURIComponent(q))})}catch(O){throw d.push(y+"type="+encodeURIComponent("_badmap")),O}}function Hl(l){this.l=l.Ub||null,this.j=l.eb||!1}S(Hl,qh),Hl.prototype.g=function(){return new Gl(this.l,this.j)},Hl.prototype.i=function(l){return function(){return l}}({});function Gl(l,d){st.call(this),this.D=l,this.o=d,this.m=void 0,this.status=this.readyState=0,this.responseType=this.responseText=this.response=this.statusText="",this.onreadystatechange=null,this.u=new Headers,this.h=null,this.B="GET",this.A="",this.g=!1,this.v=this.j=this.l=null}S(Gl,st),t=Gl.prototype,t.open=function(l,d){if(this.readyState!=0)throw this.abort(),Error("Error reopening a connection");this.B=l,this.A=d,this.readyState=1,zo(this)},t.send=function(l){if(this.readyState!=1)throw this.abort(),Error("need to call open() first. ");this.g=!0;const d={headers:this.u,method:this.B,credentials:this.m,cache:void 0};l&&(d.body=l),(this.D||a).fetch(new Request(this.A,d)).then(this.Sa.bind(this),this.ga.bind(this))},t.abort=function(){this.response=this.responseText="",this.u=new Headers,this.status=0,this.j&&this.j.cancel("Request was aborted.").catch(()=>{}),1<=this.readyState&&this.g&&this.readyState!=4&&(this.g=!1,jo(this)),this.readyState=0},t.Sa=function(l){if(this.g&&(this.l=l,this.h||(this.status=this.l.status,this.statusText=this.l.statusText,this.h=l.headers,this.readyState=2,zo(this)),this.g&&(this.readyState=3,zo(this),this.g)))if(this.responseType==="arraybuffer")l.arrayBuffer().then(this.Qa.bind(this),this.ga.bind(this));else if(typeof a.ReadableStream<"u"&&"body"in l){if(this.j=l.body.getReader(),this.o){if(this.responseType)throw Error('responseType must be empty for "streamBinaryChunks" mode responses.');this.response=[]}else this.response=this.responseText="",this.v=new TextDecoder;L_(this)}else l.text().then(this.Ra.bind(this),this.ga.bind(this))};function L_(l){l.j.read().then(l.Pa.bind(l)).catch(l.ga.bind(l))}t.Pa=function(l){if(this.g){if(this.o&&l.value)this.response.push(l.value);else if(!this.o){var d=l.value?l.value:new Uint8Array(0);(d=this.v.decode(d,{stream:!l.done}))&&(this.response=this.responseText+=d)}l.done?jo(this):zo(this),this.readyState==3&&L_(this)}},t.Ra=function(l){this.g&&(this.response=this.responseText=l,jo(this))},t.Qa=function(l){this.g&&(this.response=l,jo(this))},t.ga=function(){this.g&&jo(this)};function jo(l){l.readyState=4,l.l=null,l.j=null,l.v=null,zo(l)}t.setRequestHeader=function(l,d){this.u.append(l,d)},t.getResponseHeader=function(l){return this.h&&this.h.get(l.toLowerCase())||""},t.getAllResponseHeaders=function(){if(!this.h)return"";const l=[],d=this.h.entries();for(var p=d.next();!p.done;)p=p.value,l.push(p[0]+": "+p[1]),p=d.next();return l.join(`\r
`)};function zo(l){l.onreadystatechange&&l.onreadystatechange.call(l)}Object.defineProperty(Gl.prototype,"withCredentials",{get:function(){return this.m==="include"},set:function(l){this.m=l?"include":"same-origin"}});function F_(l){let d="";return U(l,function(p,y){d+=y,d+=":",d+=p,d+=`\r
`}),d}function td(l,d,p){e:{for(y in p){var y=!1;break e}y=!0}y||(p=F_(p),typeof l=="string"?p!=null&&encodeURIComponent(String(p)):Oe(l,d,p))}function Ke(l){st.call(this),this.headers=new Map,this.o=l||null,this.h=!1,this.v=this.g=null,this.D="",this.m=0,this.l="",this.j=this.B=this.u=this.A=!1,this.I=null,this.H="",this.J=!1}S(Ke,st);var hC=/^https?$/i,dC=["POST","PUT"];t=Ke.prototype,t.Ha=function(l){this.J=l},t.ea=function(l,d,p,y){if(this.g)throw Error("[goog.net.XhrIo] Object is active with another request="+this.D+"; newUri="+l);d=d?d.toUpperCase():"GET",this.D=l,this.l="",this.m=0,this.A=!1,this.h=!0,this.g=this.o?this.o.g():Kh.g(),this.v=this.o?d_(this.o):d_(Kh),this.g.onreadystatechange=m(this.Ea,this);try{this.B=!0,this.g.open(d,String(l),!0),this.B=!1}catch(L){V_(this,L);return}if(l=p||"",p=new Map(this.headers),y)if(Object.getPrototypeOf(y)===Object.prototype)for(var O in y)p.set(O,y[O]);else if(typeof y.keys=="function"&&typeof y.get=="function")for(const L of y.keys())p.set(L,y.get(L));else throw Error("Unknown input type for opt_headers: "+String(y));y=Array.from(p.keys()).find(L=>L.toLowerCase()=="content-type"),O=a.FormData&&l instanceof a.FormData,!(0<=Array.prototype.indexOf.call(dC,d,void 0))||y||O||p.set("Content-Type","application/x-www-form-urlencoded;charset=utf-8");for(const[L,q]of p)this.g.setRequestHeader(L,q);this.H&&(this.g.responseType=this.H),"withCredentials"in this.g&&this.g.withCredentials!==this.J&&(this.g.withCredentials=this.J);try{z_(this),this.u=!0,this.g.send(l),this.u=!1}catch(L){V_(this,L)}};function V_(l,d){l.h=!1,l.g&&(l.j=!0,l.g.abort(),l.j=!1),l.l=d,l.m=5,U_(l),Kl(l)}function U_(l){l.A||(l.A=!0,_t(l,"complete"),_t(l,"error"))}t.abort=function(l){this.g&&this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1,this.m=l||7,_t(this,"complete"),_t(this,"abort"),Kl(this))},t.N=function(){this.g&&(this.h&&(this.h=!1,this.j=!0,this.g.abort(),this.j=!1),Kl(this,!0)),Ke.aa.N.call(this)},t.Ea=function(){this.s||(this.B||this.u||this.j?j_(this):this.bb())},t.bb=function(){j_(this)};function j_(l){if(l.h&&typeof o<"u"&&(!l.v[1]||tr(l)!=4||l.Z()!=2)){if(l.u&&tr(l)==4)Ao(l.Ea,0,l);else if(_t(l,"readystatechange"),tr(l)==4){l.h=!1;try{const q=l.Z();e:switch(q){case 200:case 201:case 202:case 204:case 206:case 304:case 1223:var d=!0;break e;default:d=!1}var p;if(!(p=d)){var y;if(y=q===0){var O=String(l.D).match(P_)[1]||null;!O&&a.self&&a.self.location&&(O=a.self.location.protocol.slice(0,-1)),y=!hC.test(O?O.toLowerCase():"")}p=y}if(p)_t(l,"complete"),_t(l,"success");else{l.m=6;try{var L=2<tr(l)?l.g.statusText:""}catch{L=""}l.l=L+" ["+l.Z()+"]",U_(l)}}finally{Kl(l)}}}}function Kl(l,d){if(l.g){z_(l);const p=l.g,y=l.v[0]?()=>{}:null;l.g=null,l.v=null,d||_t(l,"ready");try{p.onreadystatechange=y}catch{}}}function z_(l){l.I&&(a.clearTimeout(l.I),l.I=null)}t.isActive=function(){return!!this.g};function tr(l){return l.g?l.g.readyState:0}t.Z=function(){try{return 2<tr(this)?this.g.status:-1}catch{return-1}},t.oa=function(){try{return this.g?this.g.responseText:""}catch{return""}},t.Oa=function(l){if(this.g){var d=this.g.responseText;return l&&d.indexOf(l)==0&&(d=d.substring(l.length)),W1(d)}};function B_(l){try{if(!l.g)return null;if("response"in l.g)return l.g.response;switch(l.H){case"":case"text":return l.g.responseText;case"arraybuffer":if("mozResponseArrayBuffer"in l.g)return l.g.mozResponseArrayBuffer}return null}catch{return null}}function fC(l){const d={};l=(l.g&&2<=tr(l)&&l.g.getAllResponseHeaders()||"").split(`\r
`);for(let y=0;y<l.length;y++){if(T(l[y]))continue;var p=A(l[y]);const O=p[0];if(p=p[1],typeof p!="string")continue;p=p.trim();const L=d[O]||[];d[O]=L,L.push(p)}v(d,function(y){return y.join(", ")})}t.Ba=function(){return this.m},t.Ka=function(){return typeof this.l=="string"?this.l:String(this.l)};function Bo(l,d,p){return p&&p.internalChannelParams&&p.internalChannelParams[l]||d}function $_(l){this.Aa=0,this.i=[],this.j=new Mo,this.ia=this.qa=this.I=this.W=this.g=this.ya=this.D=this.H=this.m=this.S=this.o=null,this.Ya=this.U=0,this.Va=Bo("failFast",!1,l),this.F=this.C=this.u=this.s=this.l=null,this.X=!0,this.za=this.T=-1,this.Y=this.v=this.B=0,this.Ta=Bo("baseRetryDelayMs",5e3,l),this.cb=Bo("retryDelaySeedMs",1e4,l),this.Wa=Bo("forwardChannelMaxRetries",2,l),this.wa=Bo("forwardChannelRequestTimeoutMs",2e4,l),this.pa=l&&l.xmlHttpFactory||void 0,this.Xa=l&&l.Tb||void 0,this.Ca=l&&l.useFetchStreams||!1,this.L=void 0,this.J=l&&l.supportsCrossDomainXhr||!1,this.K="",this.h=new S_(l&&l.concurrentRequestLimit),this.Da=new uC,this.P=l&&l.fastHandshake||!1,this.O=l&&l.encodeInitMessageHeaders||!1,this.P&&this.O&&(this.O=!1),this.Ua=l&&l.Rb||!1,l&&l.xa&&this.j.xa(),l&&l.forceLongPolling&&(this.X=!1),this.ba=!this.P&&this.X&&l&&l.detectBufferingProxy||!1,this.ja=void 0,l&&l.longPollingTimeout&&0<l.longPollingTimeout&&(this.ja=l.longPollingTimeout),this.ca=void 0,this.R=0,this.M=!1,this.ka=this.A=null}t=$_.prototype,t.la=8,t.G=1,t.connect=function(l,d,p,y){jt(0),this.W=l,this.H=d||{},p&&y!==void 0&&(this.H.OSID=p,this.H.OAID=y),this.F=this.X,this.I=J_(this,null,this.W),Yl(this)};function nd(l){if(W_(l),l.G==3){var d=l.U++,p=er(l.I);if(Oe(p,"SID",l.K),Oe(p,"RID",d),Oe(p,"TYPE","terminate"),$o(l,p),d=new Ar(l,l.j,d),d.L=2,d.v=ql(er(p)),p=!1,a.navigator&&a.navigator.sendBeacon)try{p=a.navigator.sendBeacon(d.v.toString(),"")}catch{}!p&&a.Image&&(new Image().src=d.v,p=!0),p||(d.g=Z_(d.j,null),d.g.ea(d.v)),d.F=Date.now(),Bl(d)}X_(l)}function Ql(l){l.g&&(id(l),l.g.cancel(),l.g=null)}function W_(l){Ql(l),l.u&&(a.clearTimeout(l.u),l.u=null),Xl(l),l.h.cancel(),l.s&&(typeof l.s=="number"&&a.clearTimeout(l.s),l.s=null)}function Yl(l){if(!k_(l.h)&&!l.s){l.s=!0;var d=l.Ga;gt||N(),H||(gt(),H=!0),te.add(d,l),l.B=0}}function pC(l,d){return C_(l.h)>=l.h.j-(l.s?1:0)?!1:l.s?(l.i=d.D.concat(l.i),!0):l.G==1||l.G==2||l.B>=(l.Va?0:l.Wa)?!1:(l.s=Oo(m(l.Ga,l,d),Y_(l,l.B)),l.B++,!0)}t.Ga=function(l){if(this.s)if(this.s=null,this.G==1){if(!l){this.U=Math.floor(1e5*Math.random()),l=this.U++;const O=new Ar(this,this.j,l);let L=this.o;if(this.S&&(L?(L=_(L),I(L,this.S)):L=this.S),this.m!==null||this.O||(O.H=L,L=null),this.P)e:{for(var d=0,p=0;p<this.i.length;p++){t:{var y=this.i[p];if("__data__"in y.map&&(y=y.map.__data__,typeof y=="string")){y=y.length;break t}y=void 0}if(y===void 0)break;if(d+=y,4096<d){d=p;break e}if(d===4096||p===this.i.length-1){d=p+1;break e}}d=1e3}else d=1e3;d=H_(this,O,d),p=er(this.I),Oe(p,"RID",l),Oe(p,"CVER",22),this.D&&Oe(p,"X-HTTP-Session-Id",this.D),$o(this,p),L&&(this.O?d="headers="+encodeURIComponent(String(F_(L)))+"&"+d:this.m&&td(p,this.m,L)),ed(this.h,O),this.Ua&&Oe(p,"TYPE","init"),this.P?(Oe(p,"$req",d),Oe(p,"SID","null"),O.T=!0,Yh(O,p,null)):Yh(O,p,d),this.G=2}}else this.G==3&&(l?q_(this,l):this.i.length==0||k_(this.h)||q_(this))};function q_(l,d){var p;d?p=d.l:p=l.U++;const y=er(l.I);Oe(y,"SID",l.K),Oe(y,"RID",p),Oe(y,"AID",l.T),$o(l,y),l.m&&l.o&&td(y,l.m,l.o),p=new Ar(l,l.j,p,l.B+1),l.m===null&&(p.H=l.o),d&&(l.i=d.D.concat(l.i)),d=H_(l,p,1e3),p.I=Math.round(.5*l.wa)+Math.round(.5*l.wa*Math.random()),ed(l.h,p),Yh(p,y,d)}function $o(l,d){l.H&&U(l.H,function(p,y){Oe(d,y,p)}),l.l&&A_({},function(p,y){Oe(d,y,p)})}function H_(l,d,p){p=Math.min(l.i.length,p);var y=l.l?m(l.l.Na,l.l,l):null;e:{var O=l.i;let L=-1;for(;;){const q=["count="+p];L==-1?0<p?(L=O[0].g,q.push("ofs="+L)):L=0:q.push("ofs="+L);let Ae=!0;for(let yt=0;yt<p;yt++){let ve=O[yt].g;const Rt=O[yt].map;if(ve-=L,0>ve)L=Math.max(0,O[yt].g-100),Ae=!1;else try{cC(Rt,q,"req"+ve+"_")}catch{y&&y(Rt)}}if(Ae){y=q.join("&");break e}}}return l=l.i.splice(0,p),d.D=l,y}function G_(l){if(!l.g&&!l.u){l.Y=1;var d=l.Fa;gt||N(),H||(gt(),H=!0),te.add(d,l),l.v=0}}function rd(l){return l.g||l.u||3<=l.v?!1:(l.Y++,l.u=Oo(m(l.Fa,l),Y_(l,l.v)),l.v++,!0)}t.Fa=function(){if(this.u=null,K_(this),this.ba&&!(this.M||this.g==null||0>=this.R)){var l=2*this.R;this.j.info("BP detection timer enabled: "+l),this.A=Oo(m(this.ab,this),l)}},t.ab=function(){this.A&&(this.A=null,this.j.info("BP detection timeout reached."),this.j.info("Buffering proxy detected and switch to long-polling!"),this.F=!1,this.M=!0,jt(10),Ql(this),K_(this))};function id(l){l.A!=null&&(a.clearTimeout(l.A),l.A=null)}function K_(l){l.g=new Ar(l,l.j,"rpc",l.Y),l.m===null&&(l.g.H=l.o),l.g.O=0;var d=er(l.qa);Oe(d,"RID","rpc"),Oe(d,"SID",l.K),Oe(d,"AID",l.T),Oe(d,"CI",l.F?"0":"1"),!l.F&&l.ja&&Oe(d,"TO",l.ja),Oe(d,"TYPE","xmlhttp"),$o(l,d),l.m&&l.o&&td(d,l.m,l.o),l.L&&(l.g.I=l.L);var p=l.g;l=l.ia,p.L=1,p.v=ql(er(d)),p.m=null,p.P=!0,E_(p,l)}t.Za=function(){this.C!=null&&(this.C=null,Ql(this),rd(this),jt(19))};function Xl(l){l.C!=null&&(a.clearTimeout(l.C),l.C=null)}function Q_(l,d){var p=null;if(l.g==d){Xl(l),id(l),l.g=null;var y=2}else if(Zh(l.h,d))p=d.D,R_(l.h,d),y=1;else return;if(l.G!=0){if(d.o)if(y==1){p=d.m?d.m.length:0,d=Date.now()-d.F;var O=l.B;y=Ul(),_t(y,new __(y,p)),Yl(l)}else G_(l);else if(O=d.s,O==3||O==0&&0<d.X||!(y==1&&pC(l,d)||y==2&&rd(l)))switch(p&&0<p.length&&(d=l.h,d.i=d.i.concat(p)),O){case 1:Ii(l,5);break;case 4:Ii(l,10);break;case 3:Ii(l,6);break;default:Ii(l,2)}}}function Y_(l,d){let p=l.Ta+Math.floor(Math.random()*l.cb);return l.isActive()||(p*=2),p*d}function Ii(l,d){if(l.j.info("Error code "+d),d==2){var p=m(l.fb,l),y=l.Xa;const O=!y;y=new Ti(y||"//www.google.com/images/cleardot.gif"),a.location&&a.location.protocol=="http"||$l(y,"https"),ql(y),O?aC(y.toString(),p):lC(y.toString(),p)}else jt(2);l.G=0,l.l&&l.l.sa(d),X_(l),W_(l)}t.fb=function(l){l?(this.j.info("Successfully pinged google.com"),jt(2)):(this.j.info("Failed to ping google.com"),jt(1))};function X_(l){if(l.G=0,l.ka=[],l.l){const d=x_(l.h);(d.length!=0||l.i.length!=0)&&(D(l.ka,d),D(l.ka,l.i),l.h.i.length=0,P(l.i),l.i.length=0),l.l.ra()}}function J_(l,d,p){var y=p instanceof Ti?er(p):new Ti(p);if(y.g!="")d&&(y.g=d+"."+y.g),Wl(y,y.s);else{var O=a.location;y=O.protocol,d=d?d+"."+O.hostname:O.hostname,O=+O.port;var L=new Ti(null);y&&$l(L,y),d&&(L.g=d),O&&Wl(L,O),p&&(L.l=p),y=L}return p=l.D,d=l.ya,p&&d&&Oe(y,p,d),Oe(y,"VER",l.la),$o(l,y),y}function Z_(l,d,p){if(d&&!l.J)throw Error("Can't create secondary domain capable XhrIo object.");return d=l.Ca&&!l.pa?new Ke(new Hl({eb:p})):new Ke(l.pa),d.Ha(l.J),d}t.isActive=function(){return!!this.l&&this.l.isActive(this)};function ey(){}t=ey.prototype,t.ua=function(){},t.ta=function(){},t.sa=function(){},t.ra=function(){},t.isActive=function(){return!0},t.Na=function(){};function Jl(){}Jl.prototype.g=function(l,d){return new nn(l,d)};function nn(l,d){st.call(this),this.g=new $_(d),this.l=l,this.h=d&&d.messageUrlParams||null,l=d&&d.messageHeaders||null,d&&d.clientProtocolHeaderRequired&&(l?l["X-Client-Protocol"]="webchannel":l={"X-Client-Protocol":"webchannel"}),this.g.o=l,l=d&&d.initMessageHeaders||null,d&&d.messageContentType&&(l?l["X-WebChannel-Content-Type"]=d.messageContentType:l={"X-WebChannel-Content-Type":d.messageContentType}),d&&d.va&&(l?l["X-WebChannel-Client-Profile"]=d.va:l={"X-WebChannel-Client-Profile":d.va}),this.g.S=l,(l=d&&d.Sb)&&!T(l)&&(this.g.m=l),this.v=d&&d.supportsCrossDomainXhr||!1,this.u=d&&d.sendRawJson||!1,(d=d&&d.httpSessionIdParam)&&!T(d)&&(this.g.D=d,l=this.h,l!==null&&d in l&&(l=this.h,d in l&&delete l[d])),this.j=new ds(this)}S(nn,st),nn.prototype.m=function(){this.g.l=this.j,this.v&&(this.g.J=!0),this.g.connect(this.l,this.h||void 0)},nn.prototype.close=function(){nd(this.g)},nn.prototype.o=function(l){var d=this.g;if(typeof l=="string"){var p={};p.__data__=l,l=p}else this.u&&(p={},p.__data__=Wh(l),l=p);d.i.push(new X1(d.Ya++,l)),d.G==3&&Yl(d)},nn.prototype.N=function(){this.g.l=null,delete this.j,nd(this.g),delete this.g,nn.aa.N.call(this)};function ty(l){Hh.call(this),l.__headers__&&(this.headers=l.__headers__,this.statusCode=l.__status__,delete l.__headers__,delete l.__status__);var d=l.__sm__;if(d){e:{for(const p in d){l=p;break e}l=void 0}(this.i=l)&&(l=this.i,d=d!==null&&l in d?d[l]:void 0),this.data=d}else this.data=l}S(ty,Hh);function ny(){Gh.call(this),this.status=1}S(ny,Gh);function ds(l){this.g=l}S(ds,ey),ds.prototype.ua=function(){_t(this.g,"a")},ds.prototype.ta=function(l){_t(this.g,new ty(l))},ds.prototype.sa=function(l){_t(this.g,new ny)},ds.prototype.ra=function(){_t(this.g,"b")},Jl.prototype.createWebChannel=Jl.prototype.g,nn.prototype.send=nn.prototype.o,nn.prototype.open=nn.prototype.m,nn.prototype.close=nn.prototype.close,sI=function(){return new Jl},iI=function(){return Ul()},rI=wi,np={mb:0,pb:1,qb:2,Jb:3,Ob:4,Lb:5,Mb:6,Kb:7,Ib:8,Nb:9,PROXY:10,NOPROXY:11,Gb:12,Cb:13,Db:14,Bb:15,Eb:16,Fb:17,ib:18,hb:19,jb:20},jl.NO_ERROR=0,jl.TIMEOUT=8,jl.HTTP_ERROR=6,zu=jl,y_.COMPLETE="complete",nI=y_,f_.EventType=No,No.OPEN="a",No.CLOSE="b",No.ERROR="c",No.MESSAGE="d",st.prototype.listen=st.prototype.K,ha=f_,Ke.prototype.listenOnce=Ke.prototype.L,Ke.prototype.getLastError=Ke.prototype.Ka,Ke.prototype.getLastErrorCode=Ke.prototype.Ba,Ke.prototype.getStatus=Ke.prototype.Z,Ke.prototype.getResponseJson=Ke.prototype.Oa,Ke.prototype.getResponseText=Ke.prototype.oa,Ke.prototype.send=Ke.prototype.ea,Ke.prototype.setWithCredentials=Ke.prototype.Ha,tI=Ke}).apply(typeof _u<"u"?_u:typeof self<"u"?self:typeof window<"u"?window:{});const Rv="@firebase/firestore";/**
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
 */class Nt{constructor(e){this.uid=e}isAuthenticated(){return this.uid!=null}toKey(){return this.isAuthenticated()?"uid:"+this.uid:"anonymous-user"}isEqual(e){return e.uid===this.uid}}Nt.UNAUTHENTICATED=new Nt(null),Nt.GOOGLE_CREDENTIALS=new Nt("google-credentials-uid"),Nt.FIRST_PARTY=new Nt("first-party-uid"),Nt.MOCK_USER=new Nt("mock-user");/**
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
 */let yo="10.14.0";/**
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
 */const Wi=new gh("@firebase/firestore");function Jo(){return Wi.logLevel}function J(t,...e){if(Wi.logLevel<=de.DEBUG){const n=e.map(Vm);Wi.debug(`Firestore (${yo}): ${t}`,...n)}}function Er(t,...e){if(Wi.logLevel<=de.ERROR){const n=e.map(Vm);Wi.error(`Firestore (${yo}): ${t}`,...n)}}function ro(t,...e){if(Wi.logLevel<=de.WARN){const n=e.map(Vm);Wi.warn(`Firestore (${yo}): ${t}`,...n)}}function Vm(t){if(typeof t=="string")return t;try{/**
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
 */function oe(t="Unexpected state"){const e=`FIRESTORE (${yo}) INTERNAL ASSERTION FAILED: `+t;throw Er(e),new Error(e)}function ke(t,e){t||oe()}function le(t,e){return t}/**
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
 */class ni{constructor(){this.promise=new Promise((e,n)=>{this.resolve=e,this.reject=n})}}/**
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
 */class oI{constructor(e,n){this.user=n,this.type="OAuth",this.headers=new Map,this.headers.set("Authorization",`Bearer ${e}`)}}class $P{getToken(){return Promise.resolve(null)}invalidateToken(){}start(e,n){e.enqueueRetryable(()=>n(Nt.UNAUTHENTICATED))}shutdown(){}}class WP{constructor(e){this.token=e,this.changeListener=null}getToken(){return Promise.resolve(this.token)}invalidateToken(){}start(e,n){this.changeListener=n,e.enqueueRetryable(()=>n(this.token.user))}shutdown(){this.changeListener=null}}class qP{constructor(e){this.t=e,this.currentUser=Nt.UNAUTHENTICATED,this.i=0,this.forceRefresh=!1,this.auth=null}start(e,n){ke(this.o===void 0);let r=this.i;const i=u=>this.i!==r?(r=this.i,n(u)):Promise.resolve();let s=new ni;this.o=()=>{this.i++,this.currentUser=this.u(),s.resolve(),s=new ni,e.enqueueRetryable(()=>i(this.currentUser))};const o=()=>{const u=s;e.enqueueRetryable(async()=>{await u.promise,await i(this.currentUser)})},a=u=>{J("FirebaseAuthCredentialsProvider","Auth detected"),this.auth=u,this.o&&(this.auth.addAuthTokenListener(this.o),o())};this.t.onInit(u=>a(u)),setTimeout(()=>{if(!this.auth){const u=this.t.getImmediate({optional:!0});u?a(u):(J("FirebaseAuthCredentialsProvider","Auth not yet detected"),s.resolve(),s=new ni)}},0),o()}getToken(){const e=this.i,n=this.forceRefresh;return this.forceRefresh=!1,this.auth?this.auth.getToken(n).then(r=>this.i!==e?(J("FirebaseAuthCredentialsProvider","getToken aborted due to token change."),this.getToken()):r?(ke(typeof r.accessToken=="string"),new oI(r.accessToken,this.currentUser)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.auth&&this.o&&this.auth.removeAuthTokenListener(this.o),this.o=void 0}u(){const e=this.auth&&this.auth.getUid();return ke(e===null||typeof e=="string"),new Nt(e)}}class HP{constructor(e,n,r){this.l=e,this.h=n,this.P=r,this.type="FirstParty",this.user=Nt.FIRST_PARTY,this.I=new Map}T(){return this.P?this.P():null}get headers(){this.I.set("X-Goog-AuthUser",this.l);const e=this.T();return e&&this.I.set("Authorization",e),this.h&&this.I.set("X-Goog-Iam-Authorization-Token",this.h),this.I}}class GP{constructor(e,n,r){this.l=e,this.h=n,this.P=r}getToken(){return Promise.resolve(new HP(this.l,this.h,this.P))}start(e,n){e.enqueueRetryable(()=>n(Nt.FIRST_PARTY))}shutdown(){}invalidateToken(){}}class KP{constructor(e){this.value=e,this.type="AppCheck",this.headers=new Map,e&&e.length>0&&this.headers.set("x-firebase-appcheck",this.value)}}class QP{constructor(e){this.A=e,this.forceRefresh=!1,this.appCheck=null,this.R=null}start(e,n){ke(this.o===void 0);const r=s=>{s.error!=null&&J("FirebaseAppCheckTokenProvider",`Error getting App Check token; using placeholder token instead. Error: ${s.error.message}`);const o=s.token!==this.R;return this.R=s.token,J("FirebaseAppCheckTokenProvider",`Received ${o?"new":"existing"} token.`),o?n(s.token):Promise.resolve()};this.o=s=>{e.enqueueRetryable(()=>r(s))};const i=s=>{J("FirebaseAppCheckTokenProvider","AppCheck detected"),this.appCheck=s,this.o&&this.appCheck.addTokenListener(this.o)};this.A.onInit(s=>i(s)),setTimeout(()=>{if(!this.appCheck){const s=this.A.getImmediate({optional:!0});s?i(s):J("FirebaseAppCheckTokenProvider","AppCheck not yet detected")}},0)}getToken(){const e=this.forceRefresh;return this.forceRefresh=!1,this.appCheck?this.appCheck.getToken(e).then(n=>n?(ke(typeof n.token=="string"),this.R=n.token,new KP(n.token)):null):Promise.resolve(null)}invalidateToken(){this.forceRefresh=!0}shutdown(){this.appCheck&&this.o&&this.appCheck.removeTokenListener(this.o),this.o=void 0}}/**
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
 */function YP(t){const e=typeof self<"u"&&(self.crypto||self.msCrypto),n=new Uint8Array(t);if(e&&typeof e.getRandomValues=="function")e.getRandomValues(n);else for(let r=0;r<t;r++)n[r]=Math.floor(256*Math.random());return n}/**
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
 */class aI{static newId(){const e="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",n=Math.floor(256/e.length)*e.length;let r="";for(;r.length<20;){const i=YP(40);for(let s=0;s<i.length;++s)r.length<20&&i[s]<n&&(r+=e.charAt(i[s]%e.length))}return r}}function we(t,e){return t<e?-1:t>e?1:0}function io(t,e,n){return t.length===e.length&&t.every((r,i)=>n(r,e[i]))}/**
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
 */class ut{constructor(e,n){if(this.seconds=e,this.nanoseconds=n,n<0)throw new X(V.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(n>=1e9)throw new X(V.INVALID_ARGUMENT,"Timestamp nanoseconds out of range: "+n);if(e<-62135596800)throw new X(V.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e);if(e>=253402300800)throw new X(V.INVALID_ARGUMENT,"Timestamp seconds out of range: "+e)}static now(){return ut.fromMillis(Date.now())}static fromDate(e){return ut.fromMillis(e.getTime())}static fromMillis(e){const n=Math.floor(e/1e3),r=Math.floor(1e6*(e-1e3*n));return new ut(n,r)}toDate(){return new Date(this.toMillis())}toMillis(){return 1e3*this.seconds+this.nanoseconds/1e6}_compareTo(e){return this.seconds===e.seconds?we(this.nanoseconds,e.nanoseconds):we(this.seconds,e.seconds)}isEqual(e){return e.seconds===this.seconds&&e.nanoseconds===this.nanoseconds}toString(){return"Timestamp(seconds="+this.seconds+", nanoseconds="+this.nanoseconds+")"}toJSON(){return{seconds:this.seconds,nanoseconds:this.nanoseconds}}valueOf(){const e=this.seconds- -62135596800;return String(e).padStart(12,"0")+"."+String(this.nanoseconds).padStart(9,"0")}}/**
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
 */class ae{constructor(e){this.timestamp=e}static fromTimestamp(e){return new ae(e)}static min(){return new ae(new ut(0,0))}static max(){return new ae(new ut(253402300799,999999999))}compareTo(e){return this.timestamp._compareTo(e.timestamp)}isEqual(e){return this.timestamp.isEqual(e.timestamp)}toMicroseconds(){return 1e6*this.timestamp.seconds+this.timestamp.nanoseconds/1e3}toString(){return"SnapshotVersion("+this.timestamp.toString()+")"}toTimestamp(){return this.timestamp}}/**
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
 */class tl{constructor(e,n,r){n===void 0?n=0:n>e.length&&oe(),r===void 0?r=e.length-n:r>e.length-n&&oe(),this.segments=e,this.offset=n,this.len=r}get length(){return this.len}isEqual(e){return tl.comparator(this,e)===0}child(e){const n=this.segments.slice(this.offset,this.limit());return e instanceof tl?e.forEach(r=>{n.push(r)}):n.push(e),this.construct(n)}limit(){return this.offset+this.length}popFirst(e){return e=e===void 0?1:e,this.construct(this.segments,this.offset+e,this.length-e)}popLast(){return this.construct(this.segments,this.offset,this.length-1)}firstSegment(){return this.segments[this.offset]}lastSegment(){return this.get(this.length-1)}get(e){return this.segments[this.offset+e]}isEmpty(){return this.length===0}isPrefixOf(e){if(e.length<this.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}isImmediateParentOf(e){if(this.length+1!==e.length)return!1;for(let n=0;n<this.length;n++)if(this.get(n)!==e.get(n))return!1;return!0}forEach(e){for(let n=this.offset,r=this.limit();n<r;n++)e(this.segments[n])}toArray(){return this.segments.slice(this.offset,this.limit())}static comparator(e,n){const r=Math.min(e.length,n.length);for(let i=0;i<r;i++){const s=e.get(i),o=n.get(i);if(s<o)return-1;if(s>o)return 1}return e.length<n.length?-1:e.length>n.length?1:0}}class Ve extends tl{construct(e,n,r){return new Ve(e,n,r)}canonicalString(){return this.toArray().join("/")}toString(){return this.canonicalString()}toUriEncodedString(){return this.toArray().map(encodeURIComponent).join("/")}static fromString(...e){const n=[];for(const r of e){if(r.indexOf("//")>=0)throw new X(V.INVALID_ARGUMENT,`Invalid segment (${r}). Paths must not contain // in them.`);n.push(...r.split("/").filter(i=>i.length>0))}return new Ve(n)}static emptyPath(){return new Ve([])}}const XP=/^[_a-zA-Z][_a-zA-Z0-9]*$/;class Tt extends tl{construct(e,n,r){return new Tt(e,n,r)}static isValidIdentifier(e){return XP.test(e)}canonicalString(){return this.toArray().map(e=>(e=e.replace(/\\/g,"\\\\").replace(/`/g,"\\`"),Tt.isValidIdentifier(e)||(e="`"+e+"`"),e)).join(".")}toString(){return this.canonicalString()}isKeyField(){return this.length===1&&this.get(0)==="__name__"}static keyField(){return new Tt(["__name__"])}static fromServerFormat(e){const n=[];let r="",i=0;const s=()=>{if(r.length===0)throw new X(V.INVALID_ARGUMENT,`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`);n.push(r),r=""};let o=!1;for(;i<e.length;){const a=e[i];if(a==="\\"){if(i+1===e.length)throw new X(V.INVALID_ARGUMENT,"Path has trailing escape character: "+e);const u=e[i+1];if(u!=="\\"&&u!=="."&&u!=="`")throw new X(V.INVALID_ARGUMENT,"Path has invalid escape sequence: "+e);r+=u,i+=2}else a==="`"?(o=!o,i++):a!=="."||o?(r+=a,i++):(s(),i++)}if(s(),o)throw new X(V.INVALID_ARGUMENT,"Unterminated ` in path: "+e);return new Tt(n)}static emptyPath(){return new Tt([])}}/**
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
 */class ee{constructor(e){this.path=e}static fromPath(e){return new ee(Ve.fromString(e))}static fromName(e){return new ee(Ve.fromString(e).popFirst(5))}static empty(){return new ee(Ve.emptyPath())}get collectionGroup(){return this.path.popLast().lastSegment()}hasCollectionId(e){return this.path.length>=2&&this.path.get(this.path.length-2)===e}getCollectionGroup(){return this.path.get(this.path.length-2)}getCollectionPath(){return this.path.popLast()}isEqual(e){return e!==null&&Ve.comparator(this.path,e.path)===0}toString(){return this.path.toString()}static comparator(e,n){return Ve.comparator(e.path,n.path)}static isDocumentKey(e){return e.length%2==0}static fromSegments(e){return new ee(new Ve(e.slice()))}}function JP(t,e){const n=t.toTimestamp().seconds,r=t.toTimestamp().nanoseconds+1,i=ae.fromTimestamp(r===1e9?new ut(n+1,0):new ut(n,r));return new ci(i,ee.empty(),e)}function ZP(t){return new ci(t.readTime,t.key,-1)}class ci{constructor(e,n,r){this.readTime=e,this.documentKey=n,this.largestBatchId=r}static min(){return new ci(ae.min(),ee.empty(),-1)}static max(){return new ci(ae.max(),ee.empty(),-1)}}function eb(t,e){let n=t.readTime.compareTo(e.readTime);return n!==0?n:(n=ee.comparator(t.documentKey,e.documentKey),n!==0?n:we(t.largestBatchId,e.largestBatchId))}/**
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
 */const tb="The current tab is not in the required state to perform this operation. It might be necessary to refresh the browser tab.";class nb{constructor(){this.onCommittedListeners=[]}addOnCommittedListener(e){this.onCommittedListeners.push(e)}raiseOnCommittedEvent(){this.onCommittedListeners.forEach(e=>e())}}/**
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
 */async function wl(t){if(t.code!==V.FAILED_PRECONDITION||t.message!==tb)throw t;J("LocalStore","Unexpectedly lost primary lease")}/**
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
 */class j{constructor(e){this.nextCallback=null,this.catchCallback=null,this.result=void 0,this.error=void 0,this.isDone=!1,this.callbackAttached=!1,e(n=>{this.isDone=!0,this.result=n,this.nextCallback&&this.nextCallback(n)},n=>{this.isDone=!0,this.error=n,this.catchCallback&&this.catchCallback(n)})}catch(e){return this.next(void 0,e)}next(e,n){return this.callbackAttached&&oe(),this.callbackAttached=!0,this.isDone?this.error?this.wrapFailure(n,this.error):this.wrapSuccess(e,this.result):new j((r,i)=>{this.nextCallback=s=>{this.wrapSuccess(e,s).next(r,i)},this.catchCallback=s=>{this.wrapFailure(n,s).next(r,i)}})}toPromise(){return new Promise((e,n)=>{this.next(e,n)})}wrapUserFunction(e){try{const n=e();return n instanceof j?n:j.resolve(n)}catch(n){return j.reject(n)}}wrapSuccess(e,n){return e?this.wrapUserFunction(()=>e(n)):j.resolve(n)}wrapFailure(e,n){return e?this.wrapUserFunction(()=>e(n)):j.reject(n)}static resolve(e){return new j((n,r)=>{n(e)})}static reject(e){return new j((n,r)=>{r(e)})}static waitFor(e){return new j((n,r)=>{let i=0,s=0,o=!1;e.forEach(a=>{++i,a.next(()=>{++s,o&&s===i&&n()},u=>r(u))}),o=!0,s===i&&n()})}static or(e){let n=j.resolve(!1);for(const r of e)n=n.next(i=>i?j.resolve(i):r());return n}static forEach(e,n){const r=[];return e.forEach((i,s)=>{r.push(n.call(this,i,s))}),this.waitFor(r)}static mapArray(e,n){return new j((r,i)=>{const s=e.length,o=new Array(s);let a=0;for(let u=0;u<s;u++){const c=u;n(e[c]).next(h=>{o[c]=h,++a,a===s&&r(o)},h=>i(h))}})}static doWhile(e,n){return new j((r,i)=>{const s=()=>{e()===!0?n().next(()=>{s()},i):r()};s()})}}function rb(t){const e=t.match(/Android ([\d.]+)/i),n=e?e[1].split(".").slice(0,2).join("."):"-1";return Number(n)}function El(t){return t.name==="IndexedDbTransactionError"}/**
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
 */class Um{constructor(e,n){this.previousValue=e,n&&(n.sequenceNumberHandler=r=>this.ie(r),this.se=r=>n.writeSequenceNumber(r))}ie(e){return this.previousValue=Math.max(e,this.previousValue),this.previousValue}next(){const e=++this.previousValue;return this.se&&this.se(e),e}}Um.oe=-1;function yh(t){return t==null}function Rc(t){return t===0&&1/t==-1/0}function ib(t){return typeof t=="number"&&Number.isInteger(t)&&!Rc(t)&&t<=Number.MAX_SAFE_INTEGER&&t>=Number.MIN_SAFE_INTEGER}/**
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
 */function xv(t){let e=0;for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e++;return e}function vo(t,e){for(const n in t)Object.prototype.hasOwnProperty.call(t,n)&&e(n,t[n])}function lI(t){for(const e in t)if(Object.prototype.hasOwnProperty.call(t,e))return!1;return!0}/**
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
 */let it=class rp{constructor(e,n){this.comparator=e,this.root=n||ri.EMPTY}insert(e,n){return new rp(this.comparator,this.root.insert(e,n,this.comparator).copy(null,null,ri.BLACK,null,null))}remove(e){return new rp(this.comparator,this.root.remove(e,this.comparator).copy(null,null,ri.BLACK,null,null))}get(e){let n=this.root;for(;!n.isEmpty();){const r=this.comparator(e,n.key);if(r===0)return n.value;r<0?n=n.left:r>0&&(n=n.right)}return null}indexOf(e){let n=0,r=this.root;for(;!r.isEmpty();){const i=this.comparator(e,r.key);if(i===0)return n+r.left.size;i<0?r=r.left:(n+=r.left.size+1,r=r.right)}return-1}isEmpty(){return this.root.isEmpty()}get size(){return this.root.size}minKey(){return this.root.minKey()}maxKey(){return this.root.maxKey()}inorderTraversal(e){return this.root.inorderTraversal(e)}forEach(e){this.inorderTraversal((n,r)=>(e(n,r),!1))}toString(){const e=[];return this.inorderTraversal((n,r)=>(e.push(`${n}:${r}`),!1)),`{${e.join(", ")}}`}reverseTraversal(e){return this.root.reverseTraversal(e)}getIterator(){return new yu(this.root,null,this.comparator,!1)}getIteratorFrom(e){return new yu(this.root,e,this.comparator,!1)}getReverseIterator(){return new yu(this.root,null,this.comparator,!0)}getReverseIteratorFrom(e){return new yu(this.root,e,this.comparator,!0)}},yu=class{constructor(e,n,r,i){this.isReverse=i,this.nodeStack=[];let s=1;for(;!e.isEmpty();)if(s=n?r(e.key,n):1,n&&i&&(s*=-1),s<0)e=this.isReverse?e.left:e.right;else{if(s===0){this.nodeStack.push(e);break}this.nodeStack.push(e),e=this.isReverse?e.right:e.left}}getNext(){let e=this.nodeStack.pop();const n={key:e.key,value:e.value};if(this.isReverse)for(e=e.left;!e.isEmpty();)this.nodeStack.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack.push(e),e=e.left;return n}hasNext(){return this.nodeStack.length>0}peek(){if(this.nodeStack.length===0)return null;const e=this.nodeStack[this.nodeStack.length-1];return{key:e.key,value:e.value}}},ri=class nr{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??nr.RED,this.left=i??nr.EMPTY,this.right=s??nr.EMPTY,this.size=this.left.size+1+this.right.size}copy(e,n,r,i,s){return new nr(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min(){return this.left.isEmpty()?this:this.left.min()}minKey(){return this.min().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return i=s<0?i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i.copy(null,n,null,null,null):i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp()}removeMin(){if(this.left.isEmpty())return nr.EMPTY;let e=this;return e.left.isRed()||e.left.left.isRed()||(e=e.moveRedLeft()),e=e.copy(null,null,null,e.left.removeMin(),null),e.fixUp()}remove(e,n){let r,i=this;if(n(e,i.key)<0)i.left.isEmpty()||i.left.isRed()||i.left.left.isRed()||(i=i.moveRedLeft()),i=i.copy(null,null,null,i.left.remove(e,n),null);else{if(i.left.isRed()&&(i=i.rotateRight()),i.right.isEmpty()||i.right.isRed()||i.right.left.isRed()||(i=i.moveRedRight()),n(e,i.key)===0){if(i.right.isEmpty())return nr.EMPTY;r=i.right.min(),i=i.copy(r.key,r.value,null,null,i.right.removeMin())}i=i.copy(null,null,null,null,i.right.remove(e,n))}return i.fixUp()}isRed(){return this.color}fixUp(){let e=this;return e.right.isRed()&&!e.left.isRed()&&(e=e.rotateLeft()),e.left.isRed()&&e.left.left.isRed()&&(e=e.rotateRight()),e.left.isRed()&&e.right.isRed()&&(e=e.colorFlip()),e}moveRedLeft(){let e=this.colorFlip();return e.right.left.isRed()&&(e=e.copy(null,null,null,null,e.right.rotateRight()),e=e.rotateLeft(),e=e.colorFlip()),e}moveRedRight(){let e=this.colorFlip();return e.left.left.isRed()&&(e=e.rotateRight(),e=e.colorFlip()),e}rotateLeft(){const e=this.copy(null,null,nr.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight(){const e=this.copy(null,null,nr.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth(){const e=this.check();return Math.pow(2,e)<=this.size+1}check(){if(this.isRed()&&this.left.isRed()||this.right.isRed())throw oe();const e=this.left.check();if(e!==this.right.check())throw oe();return e+(this.isRed()?0:1)}};ri.EMPTY=null,ri.RED=!0,ri.BLACK=!1;ri.EMPTY=new class{constructor(){this.size=0}get key(){throw oe()}get value(){throw oe()}get color(){throw oe()}get left(){throw oe()}get right(){throw oe()}copy(e,n,r,i,s){return this}insert(e,n,r){return new ri(e,n)}remove(e,n){return this}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}isRed(){return!1}checkMaxDepth(){return!0}check(){return 0}};/**
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
 */class St{constructor(e){this.comparator=e,this.data=new it(this.comparator)}has(e){return this.data.get(e)!==null}first(){return this.data.minKey()}last(){return this.data.maxKey()}get size(){return this.data.size}indexOf(e){return this.data.indexOf(e)}forEach(e){this.data.inorderTraversal((n,r)=>(e(n),!1))}forEachInRange(e,n){const r=this.data.getIteratorFrom(e[0]);for(;r.hasNext();){const i=r.getNext();if(this.comparator(i.key,e[1])>=0)return;n(i.key)}}forEachWhile(e,n){let r;for(r=n!==void 0?this.data.getIteratorFrom(n):this.data.getIterator();r.hasNext();)if(!e(r.getNext().key))return}firstAfterOrEqual(e){const n=this.data.getIteratorFrom(e);return n.hasNext()?n.getNext().key:null}getIterator(){return new Av(this.data.getIterator())}getIteratorFrom(e){return new Av(this.data.getIteratorFrom(e))}add(e){return this.copy(this.data.remove(e).insert(e,!0))}delete(e){return this.has(e)?this.copy(this.data.remove(e)):this}isEmpty(){return this.data.isEmpty()}unionWith(e){let n=this;return n.size<e.size&&(n=e,e=this),e.forEach(r=>{n=n.add(r)}),n}isEqual(e){if(!(e instanceof St)||this.size!==e.size)return!1;const n=this.data.getIterator(),r=e.data.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(this.comparator(i,s)!==0)return!1}return!0}toArray(){const e=[];return this.forEach(n=>{e.push(n)}),e}toString(){const e=[];return this.forEach(n=>e.push(n)),"SortedSet("+e.toString()+")"}copy(e){const n=new St(this.comparator);return n.data=e,n}}class Av{constructor(e){this.iter=e}getNext(){return this.iter.getNext().key}hasNext(){return this.iter.hasNext()}}/**
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
 */class Nn{constructor(e){this.fields=e,e.sort(Tt.comparator)}static empty(){return new Nn([])}unionWith(e){let n=new St(Tt.comparator);for(const r of this.fields)n=n.add(r);for(const r of e)n=n.add(r);return new Nn(n.toArray())}covers(e){for(const n of this.fields)if(n.isPrefixOf(e))return!0;return!1}isEqual(e){return io(this.fields,e.fields,(n,r)=>n.isEqual(r))}}/**
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
 */class uI extends Error{constructor(){super(...arguments),this.name="Base64DecodeError"}}/**
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
 */class Ct{constructor(e){this.binaryString=e}static fromBase64String(e){const n=function(i){try{return atob(i)}catch(s){throw typeof DOMException<"u"&&s instanceof DOMException?new uI("Invalid base64 string: "+s):s}}(e);return new Ct(n)}static fromUint8Array(e){const n=function(i){let s="";for(let o=0;o<i.length;++o)s+=String.fromCharCode(i[o]);return s}(e);return new Ct(n)}[Symbol.iterator](){let e=0;return{next:()=>e<this.binaryString.length?{value:this.binaryString.charCodeAt(e++),done:!1}:{value:void 0,done:!0}}}toBase64(){return function(n){return btoa(n)}(this.binaryString)}toUint8Array(){return function(n){const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}(this.binaryString)}approximateByteSize(){return 2*this.binaryString.length}compareTo(e){return we(this.binaryString,e.binaryString)}isEqual(e){return this.binaryString===e.binaryString}}Ct.EMPTY_BYTE_STRING=new Ct("");const sb=new RegExp(/^\d{4}-\d\d-\d\dT\d\d:\d\d:\d\d(?:\.(\d+))?Z$/);function hi(t){if(ke(!!t),typeof t=="string"){let e=0;const n=sb.exec(t);if(ke(!!n),n[1]){let i=n[1];i=(i+"000000000").substr(0,9),e=Number(i)}const r=new Date(t);return{seconds:Math.floor(r.getTime()/1e3),nanos:e}}return{seconds:Je(t.seconds),nanos:Je(t.nanos)}}function Je(t){return typeof t=="number"?t:typeof t=="string"?Number(t):0}function qi(t){return typeof t=="string"?Ct.fromBase64String(t):Ct.fromUint8Array(t)}/**
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
 */function jm(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="server_timestamp"}function zm(t){const e=t.mapValue.fields.__previous_value__;return jm(e)?zm(e):e}function nl(t){const e=hi(t.mapValue.fields.__local_write_time__.timestampValue);return new ut(e.seconds,e.nanos)}/**
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
 */class ob{constructor(e,n,r,i,s,o,a,u,c){this.databaseId=e,this.appId=n,this.persistenceKey=r,this.host=i,this.ssl=s,this.forceLongPolling=o,this.autoDetectLongPolling=a,this.longPollingOptions=u,this.useFetchStreams=c}}class rl{constructor(e,n){this.projectId=e,this.database=n||"(default)"}static empty(){return new rl("","")}get isDefaultDatabase(){return this.database==="(default)"}isEqual(e){return e instanceof rl&&e.projectId===this.projectId&&e.database===this.database}}/**
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
 */const vu={mapValue:{}};function Hi(t){return"nullValue"in t?0:"booleanValue"in t?1:"integerValue"in t||"doubleValue"in t?2:"timestampValue"in t?3:"stringValue"in t?5:"bytesValue"in t?6:"referenceValue"in t?7:"geoPointValue"in t?8:"arrayValue"in t?9:"mapValue"in t?jm(t)?4:lb(t)?9007199254740991:ab(t)?10:11:oe()}function Jn(t,e){if(t===e)return!0;const n=Hi(t);if(n!==Hi(e))return!1;switch(n){case 0:case 9007199254740991:return!0;case 1:return t.booleanValue===e.booleanValue;case 4:return nl(t).isEqual(nl(e));case 3:return function(i,s){if(typeof i.timestampValue=="string"&&typeof s.timestampValue=="string"&&i.timestampValue.length===s.timestampValue.length)return i.timestampValue===s.timestampValue;const o=hi(i.timestampValue),a=hi(s.timestampValue);return o.seconds===a.seconds&&o.nanos===a.nanos}(t,e);case 5:return t.stringValue===e.stringValue;case 6:return function(i,s){return qi(i.bytesValue).isEqual(qi(s.bytesValue))}(t,e);case 7:return t.referenceValue===e.referenceValue;case 8:return function(i,s){return Je(i.geoPointValue.latitude)===Je(s.geoPointValue.latitude)&&Je(i.geoPointValue.longitude)===Je(s.geoPointValue.longitude)}(t,e);case 2:return function(i,s){if("integerValue"in i&&"integerValue"in s)return Je(i.integerValue)===Je(s.integerValue);if("doubleValue"in i&&"doubleValue"in s){const o=Je(i.doubleValue),a=Je(s.doubleValue);return o===a?Rc(o)===Rc(a):isNaN(o)&&isNaN(a)}return!1}(t,e);case 9:return io(t.arrayValue.values||[],e.arrayValue.values||[],Jn);case 10:case 11:return function(i,s){const o=i.mapValue.fields||{},a=s.mapValue.fields||{};if(xv(o)!==xv(a))return!1;for(const u in o)if(o.hasOwnProperty(u)&&(a[u]===void 0||!Jn(o[u],a[u])))return!1;return!0}(t,e);default:return oe()}}function il(t,e){return(t.values||[]).find(n=>Jn(n,e))!==void 0}function so(t,e){if(t===e)return 0;const n=Hi(t),r=Hi(e);if(n!==r)return we(n,r);switch(n){case 0:case 9007199254740991:return 0;case 1:return we(t.booleanValue,e.booleanValue);case 2:return function(s,o){const a=Je(s.integerValue||s.doubleValue),u=Je(o.integerValue||o.doubleValue);return a<u?-1:a>u?1:a===u?0:isNaN(a)?isNaN(u)?0:-1:1}(t,e);case 3:return Pv(t.timestampValue,e.timestampValue);case 4:return Pv(nl(t),nl(e));case 5:return we(t.stringValue,e.stringValue);case 6:return function(s,o){const a=qi(s),u=qi(o);return a.compareTo(u)}(t.bytesValue,e.bytesValue);case 7:return function(s,o){const a=s.split("/"),u=o.split("/");for(let c=0;c<a.length&&c<u.length;c++){const h=we(a[c],u[c]);if(h!==0)return h}return we(a.length,u.length)}(t.referenceValue,e.referenceValue);case 8:return function(s,o){const a=we(Je(s.latitude),Je(o.latitude));return a!==0?a:we(Je(s.longitude),Je(o.longitude))}(t.geoPointValue,e.geoPointValue);case 9:return bv(t.arrayValue,e.arrayValue);case 10:return function(s,o){var a,u,c,h;const f=s.fields||{},m=o.fields||{},w=(a=f.value)===null||a===void 0?void 0:a.arrayValue,S=(u=m.value)===null||u===void 0?void 0:u.arrayValue,P=we(((c=w==null?void 0:w.values)===null||c===void 0?void 0:c.length)||0,((h=S==null?void 0:S.values)===null||h===void 0?void 0:h.length)||0);return P!==0?P:bv(w,S)}(t.mapValue,e.mapValue);case 11:return function(s,o){if(s===vu.mapValue&&o===vu.mapValue)return 0;if(s===vu.mapValue)return 1;if(o===vu.mapValue)return-1;const a=s.fields||{},u=Object.keys(a),c=o.fields||{},h=Object.keys(c);u.sort(),h.sort();for(let f=0;f<u.length&&f<h.length;++f){const m=we(u[f],h[f]);if(m!==0)return m;const w=so(a[u[f]],c[h[f]]);if(w!==0)return w}return we(u.length,h.length)}(t.mapValue,e.mapValue);default:throw oe()}}function Pv(t,e){if(typeof t=="string"&&typeof e=="string"&&t.length===e.length)return we(t,e);const n=hi(t),r=hi(e),i=we(n.seconds,r.seconds);return i!==0?i:we(n.nanos,r.nanos)}function bv(t,e){const n=t.values||[],r=e.values||[];for(let i=0;i<n.length&&i<r.length;++i){const s=so(n[i],r[i]);if(s)return s}return we(n.length,r.length)}function oo(t){return ip(t)}function ip(t){return"nullValue"in t?"null":"booleanValue"in t?""+t.booleanValue:"integerValue"in t?""+t.integerValue:"doubleValue"in t?""+t.doubleValue:"timestampValue"in t?function(n){const r=hi(n);return`time(${r.seconds},${r.nanos})`}(t.timestampValue):"stringValue"in t?t.stringValue:"bytesValue"in t?function(n){return qi(n).toBase64()}(t.bytesValue):"referenceValue"in t?function(n){return ee.fromName(n).toString()}(t.referenceValue):"geoPointValue"in t?function(n){return`geo(${n.latitude},${n.longitude})`}(t.geoPointValue):"arrayValue"in t?function(n){let r="[",i=!0;for(const s of n.values||[])i?i=!1:r+=",",r+=ip(s);return r+"]"}(t.arrayValue):"mapValue"in t?function(n){const r=Object.keys(n.fields||{}).sort();let i="{",s=!0;for(const o of r)s?s=!1:i+=",",i+=`${o}:${ip(n.fields[o])}`;return i+"}"}(t.mapValue):oe()}function Nv(t,e){return{referenceValue:`projects/${t.projectId}/databases/${t.database}/documents/${e.path.canonicalString()}`}}function sp(t){return!!t&&"integerValue"in t}function Bm(t){return!!t&&"arrayValue"in t}function Dv(t){return!!t&&"nullValue"in t}function Ov(t){return!!t&&"doubleValue"in t&&isNaN(Number(t.doubleValue))}function Bu(t){return!!t&&"mapValue"in t}function ab(t){var e,n;return((n=(((e=t==null?void 0:t.mapValue)===null||e===void 0?void 0:e.fields)||{}).__type__)===null||n===void 0?void 0:n.stringValue)==="__vector__"}function Ia(t){if(t.geoPointValue)return{geoPointValue:Object.assign({},t.geoPointValue)};if(t.timestampValue&&typeof t.timestampValue=="object")return{timestampValue:Object.assign({},t.timestampValue)};if(t.mapValue){const e={mapValue:{fields:{}}};return vo(t.mapValue.fields,(n,r)=>e.mapValue.fields[n]=Ia(r)),e}if(t.arrayValue){const e={arrayValue:{values:[]}};for(let n=0;n<(t.arrayValue.values||[]).length;++n)e.arrayValue.values[n]=Ia(t.arrayValue.values[n]);return e}return Object.assign({},t)}function lb(t){return(((t.mapValue||{}).fields||{}).__type__||{}).stringValue==="__max__"}/**
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
 */class pn{constructor(e){this.value=e}static empty(){return new pn({mapValue:{}})}field(e){if(e.isEmpty())return this.value;{let n=this.value;for(let r=0;r<e.length-1;++r)if(n=(n.mapValue.fields||{})[e.get(r)],!Bu(n))return null;return n=(n.mapValue.fields||{})[e.lastSegment()],n||null}}set(e,n){this.getFieldsMap(e.popLast())[e.lastSegment()]=Ia(n)}setAll(e){let n=Tt.emptyPath(),r={},i=[];e.forEach((o,a)=>{if(!n.isImmediateParentOf(a)){const u=this.getFieldsMap(n);this.applyChanges(u,r,i),r={},i=[],n=a.popLast()}o?r[a.lastSegment()]=Ia(o):i.push(a.lastSegment())});const s=this.getFieldsMap(n);this.applyChanges(s,r,i)}delete(e){const n=this.field(e.popLast());Bu(n)&&n.mapValue.fields&&delete n.mapValue.fields[e.lastSegment()]}isEqual(e){return Jn(this.value,e.value)}getFieldsMap(e){let n=this.value;n.mapValue.fields||(n.mapValue={fields:{}});for(let r=0;r<e.length;++r){let i=n.mapValue.fields[e.get(r)];Bu(i)&&i.mapValue.fields||(i={mapValue:{fields:{}}},n.mapValue.fields[e.get(r)]=i),n=i}return n.mapValue.fields}applyChanges(e,n,r){vo(n,(i,s)=>e[i]=s);for(const i of r)delete e[i]}clone(){return new pn(Ia(this.value))}}function cI(t){const e=[];return vo(t.fields,(n,r)=>{const i=new Tt([n]);if(Bu(r)){const s=cI(r.mapValue).fields;if(s.length===0)e.push(i);else for(const o of s)e.push(i.child(o))}else e.push(i)}),new Nn(e)}/**
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
 */class Ot{constructor(e,n,r,i,s,o,a){this.key=e,this.documentType=n,this.version=r,this.readTime=i,this.createTime=s,this.data=o,this.documentState=a}static newInvalidDocument(e){return new Ot(e,0,ae.min(),ae.min(),ae.min(),pn.empty(),0)}static newFoundDocument(e,n,r,i){return new Ot(e,1,n,ae.min(),r,i,0)}static newNoDocument(e,n){return new Ot(e,2,n,ae.min(),ae.min(),pn.empty(),0)}static newUnknownDocument(e,n){return new Ot(e,3,n,ae.min(),ae.min(),pn.empty(),2)}convertToFoundDocument(e,n){return!this.createTime.isEqual(ae.min())||this.documentType!==2&&this.documentType!==0||(this.createTime=e),this.version=e,this.documentType=1,this.data=n,this.documentState=0,this}convertToNoDocument(e){return this.version=e,this.documentType=2,this.data=pn.empty(),this.documentState=0,this}convertToUnknownDocument(e){return this.version=e,this.documentType=3,this.data=pn.empty(),this.documentState=2,this}setHasCommittedMutations(){return this.documentState=2,this}setHasLocalMutations(){return this.documentState=1,this.version=ae.min(),this}setReadTime(e){return this.readTime=e,this}get hasLocalMutations(){return this.documentState===1}get hasCommittedMutations(){return this.documentState===2}get hasPendingWrites(){return this.hasLocalMutations||this.hasCommittedMutations}isValidDocument(){return this.documentType!==0}isFoundDocument(){return this.documentType===1}isNoDocument(){return this.documentType===2}isUnknownDocument(){return this.documentType===3}isEqual(e){return e instanceof Ot&&this.key.isEqual(e.key)&&this.version.isEqual(e.version)&&this.documentType===e.documentType&&this.documentState===e.documentState&&this.data.isEqual(e.data)}mutableCopy(){return new Ot(this.key,this.documentType,this.version,this.readTime,this.createTime,this.data.clone(),this.documentState)}toString(){return`Document(${this.key}, ${this.version}, ${JSON.stringify(this.data.value)}, {createTime: ${this.createTime}}), {documentType: ${this.documentType}}), {documentState: ${this.documentState}})`}}/**
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
 */class xc{constructor(e,n){this.position=e,this.inclusive=n}}function Mv(t,e,n){let r=0;for(let i=0;i<t.position.length;i++){const s=e[i],o=t.position[i];if(s.field.isKeyField()?r=ee.comparator(ee.fromName(o.referenceValue),n.key):r=so(o,n.data.field(s.field)),s.dir==="desc"&&(r*=-1),r!==0)break}return r}function Lv(t,e){if(t===null)return e===null;if(e===null||t.inclusive!==e.inclusive||t.position.length!==e.position.length)return!1;for(let n=0;n<t.position.length;n++)if(!Jn(t.position[n],e.position[n]))return!1;return!0}/**
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
 */class sl{constructor(e,n="asc"){this.field=e,this.dir=n}}function ub(t,e){return t.dir===e.dir&&t.field.isEqual(e.field)}/**
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
 */class hI{}class rt extends hI{constructor(e,n,r){super(),this.field=e,this.op=n,this.value=r}static create(e,n,r){return e.isKeyField()?n==="in"||n==="not-in"?this.createKeyFieldInFilter(e,n,r):new hb(e,n,r):n==="array-contains"?new pb(e,r):n==="in"?new mb(e,r):n==="not-in"?new gb(e,r):n==="array-contains-any"?new _b(e,r):new rt(e,n,r)}static createKeyFieldInFilter(e,n,r){return n==="in"?new db(e,r):new fb(e,r)}matches(e){const n=e.data.field(this.field);return this.op==="!="?n!==null&&this.matchesComparison(so(n,this.value)):n!==null&&Hi(this.value)===Hi(n)&&this.matchesComparison(so(n,this.value))}matchesComparison(e){switch(this.op){case"<":return e<0;case"<=":return e<=0;case"==":return e===0;case"!=":return e!==0;case">":return e>0;case">=":return e>=0;default:return oe()}}isInequality(){return["<","<=",">",">=","!=","not-in"].indexOf(this.op)>=0}getFlattenedFilters(){return[this]}getFilters(){return[this]}}class Vn extends hI{constructor(e,n){super(),this.filters=e,this.op=n,this.ae=null}static create(e,n){return new Vn(e,n)}matches(e){return dI(this)?this.filters.find(n=>!n.matches(e))===void 0:this.filters.find(n=>n.matches(e))!==void 0}getFlattenedFilters(){return this.ae!==null||(this.ae=this.filters.reduce((e,n)=>e.concat(n.getFlattenedFilters()),[])),this.ae}getFilters(){return Object.assign([],this.filters)}}function dI(t){return t.op==="and"}function fI(t){return cb(t)&&dI(t)}function cb(t){for(const e of t.filters)if(e instanceof Vn)return!1;return!0}function op(t){if(t instanceof rt)return t.field.canonicalString()+t.op.toString()+oo(t.value);if(fI(t))return t.filters.map(e=>op(e)).join(",");{const e=t.filters.map(n=>op(n)).join(",");return`${t.op}(${e})`}}function pI(t,e){return t instanceof rt?function(r,i){return i instanceof rt&&r.op===i.op&&r.field.isEqual(i.field)&&Jn(r.value,i.value)}(t,e):t instanceof Vn?function(r,i){return i instanceof Vn&&r.op===i.op&&r.filters.length===i.filters.length?r.filters.reduce((s,o,a)=>s&&pI(o,i.filters[a]),!0):!1}(t,e):void oe()}function mI(t){return t instanceof rt?function(n){return`${n.field.canonicalString()} ${n.op} ${oo(n.value)}`}(t):t instanceof Vn?function(n){return n.op.toString()+" {"+n.getFilters().map(mI).join(" ,")+"}"}(t):"Filter"}class hb extends rt{constructor(e,n,r){super(e,n,r),this.key=ee.fromName(r.referenceValue)}matches(e){const n=ee.comparator(e.key,this.key);return this.matchesComparison(n)}}class db extends rt{constructor(e,n){super(e,"in",n),this.keys=gI("in",n)}matches(e){return this.keys.some(n=>n.isEqual(e.key))}}class fb extends rt{constructor(e,n){super(e,"not-in",n),this.keys=gI("not-in",n)}matches(e){return!this.keys.some(n=>n.isEqual(e.key))}}function gI(t,e){var n;return(((n=e.arrayValue)===null||n===void 0?void 0:n.values)||[]).map(r=>ee.fromName(r.referenceValue))}class pb extends rt{constructor(e,n){super(e,"array-contains",n)}matches(e){const n=e.data.field(this.field);return Bm(n)&&il(n.arrayValue,this.value)}}class mb extends rt{constructor(e,n){super(e,"in",n)}matches(e){const n=e.data.field(this.field);return n!==null&&il(this.value.arrayValue,n)}}class gb extends rt{constructor(e,n){super(e,"not-in",n)}matches(e){if(il(this.value.arrayValue,{nullValue:"NULL_VALUE"}))return!1;const n=e.data.field(this.field);return n!==null&&!il(this.value.arrayValue,n)}}class _b extends rt{constructor(e,n){super(e,"array-contains-any",n)}matches(e){const n=e.data.field(this.field);return!(!Bm(n)||!n.arrayValue.values)&&n.arrayValue.values.some(r=>il(this.value.arrayValue,r))}}/**
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
 */class yb{constructor(e,n=null,r=[],i=[],s=null,o=null,a=null){this.path=e,this.collectionGroup=n,this.orderBy=r,this.filters=i,this.limit=s,this.startAt=o,this.endAt=a,this.ue=null}}function Fv(t,e=null,n=[],r=[],i=null,s=null,o=null){return new yb(t,e,n,r,i,s,o)}function $m(t){const e=le(t);if(e.ue===null){let n=e.path.canonicalString();e.collectionGroup!==null&&(n+="|cg:"+e.collectionGroup),n+="|f:",n+=e.filters.map(r=>op(r)).join(","),n+="|ob:",n+=e.orderBy.map(r=>function(s){return s.field.canonicalString()+s.dir}(r)).join(","),yh(e.limit)||(n+="|l:",n+=e.limit),e.startAt&&(n+="|lb:",n+=e.startAt.inclusive?"b:":"a:",n+=e.startAt.position.map(r=>oo(r)).join(",")),e.endAt&&(n+="|ub:",n+=e.endAt.inclusive?"a:":"b:",n+=e.endAt.position.map(r=>oo(r)).join(",")),e.ue=n}return e.ue}function Wm(t,e){if(t.limit!==e.limit||t.orderBy.length!==e.orderBy.length)return!1;for(let n=0;n<t.orderBy.length;n++)if(!ub(t.orderBy[n],e.orderBy[n]))return!1;if(t.filters.length!==e.filters.length)return!1;for(let n=0;n<t.filters.length;n++)if(!pI(t.filters[n],e.filters[n]))return!1;return t.collectionGroup===e.collectionGroup&&!!t.path.isEqual(e.path)&&!!Lv(t.startAt,e.startAt)&&Lv(t.endAt,e.endAt)}function ap(t){return ee.isDocumentKey(t.path)&&t.collectionGroup===null&&t.filters.length===0}/**
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
 */class wo{constructor(e,n=null,r=[],i=[],s=null,o="F",a=null,u=null){this.path=e,this.collectionGroup=n,this.explicitOrderBy=r,this.filters=i,this.limit=s,this.limitType=o,this.startAt=a,this.endAt=u,this.ce=null,this.le=null,this.he=null,this.startAt,this.endAt}}function vb(t,e,n,r,i,s,o,a){return new wo(t,e,n,r,i,s,o,a)}function _I(t){return new wo(t)}function Vv(t){return t.filters.length===0&&t.limit===null&&t.startAt==null&&t.endAt==null&&(t.explicitOrderBy.length===0||t.explicitOrderBy.length===1&&t.explicitOrderBy[0].field.isKeyField())}function yI(t){return t.collectionGroup!==null}function Sa(t){const e=le(t);if(e.ce===null){e.ce=[];const n=new Set;for(const s of e.explicitOrderBy)e.ce.push(s),n.add(s.field.canonicalString());const r=e.explicitOrderBy.length>0?e.explicitOrderBy[e.explicitOrderBy.length-1].dir:"asc";(function(o){let a=new St(Tt.comparator);return o.filters.forEach(u=>{u.getFlattenedFilters().forEach(c=>{c.isInequality()&&(a=a.add(c.field))})}),a})(e).forEach(s=>{n.has(s.canonicalString())||s.isKeyField()||e.ce.push(new sl(s,r))}),n.has(Tt.keyField().canonicalString())||e.ce.push(new sl(Tt.keyField(),r))}return e.ce}function Gn(t){const e=le(t);return e.le||(e.le=wb(e,Sa(t))),e.le}function wb(t,e){if(t.limitType==="F")return Fv(t.path,t.collectionGroup,e,t.filters,t.limit,t.startAt,t.endAt);{e=e.map(i=>{const s=i.dir==="desc"?"asc":"desc";return new sl(i.field,s)});const n=t.endAt?new xc(t.endAt.position,t.endAt.inclusive):null,r=t.startAt?new xc(t.startAt.position,t.startAt.inclusive):null;return Fv(t.path,t.collectionGroup,e,t.filters,t.limit,n,r)}}function lp(t,e){const n=t.filters.concat([e]);return new wo(t.path,t.collectionGroup,t.explicitOrderBy.slice(),n,t.limit,t.limitType,t.startAt,t.endAt)}function up(t,e,n){return new wo(t.path,t.collectionGroup,t.explicitOrderBy.slice(),t.filters.slice(),e,n,t.startAt,t.endAt)}function vh(t,e){return Wm(Gn(t),Gn(e))&&t.limitType===e.limitType}function vI(t){return`${$m(Gn(t))}|lt:${t.limitType}`}function _s(t){return`Query(target=${function(n){let r=n.path.canonicalString();return n.collectionGroup!==null&&(r+=" collectionGroup="+n.collectionGroup),n.filters.length>0&&(r+=`, filters: [${n.filters.map(i=>mI(i)).join(", ")}]`),yh(n.limit)||(r+=", limit: "+n.limit),n.orderBy.length>0&&(r+=`, orderBy: [${n.orderBy.map(i=>function(o){return`${o.field.canonicalString()} (${o.dir})`}(i)).join(", ")}]`),n.startAt&&(r+=", startAt: ",r+=n.startAt.inclusive?"b:":"a:",r+=n.startAt.position.map(i=>oo(i)).join(",")),n.endAt&&(r+=", endAt: ",r+=n.endAt.inclusive?"a:":"b:",r+=n.endAt.position.map(i=>oo(i)).join(",")),`Target(${r})`}(Gn(t))}; limitType=${t.limitType})`}function wh(t,e){return e.isFoundDocument()&&function(r,i){const s=i.key.path;return r.collectionGroup!==null?i.key.hasCollectionId(r.collectionGroup)&&r.path.isPrefixOf(s):ee.isDocumentKey(r.path)?r.path.isEqual(s):r.path.isImmediateParentOf(s)}(t,e)&&function(r,i){for(const s of Sa(r))if(!s.field.isKeyField()&&i.data.field(s.field)===null)return!1;return!0}(t,e)&&function(r,i){for(const s of r.filters)if(!s.matches(i))return!1;return!0}(t,e)&&function(r,i){return!(r.startAt&&!function(o,a,u){const c=Mv(o,a,u);return o.inclusive?c<=0:c<0}(r.startAt,Sa(r),i)||r.endAt&&!function(o,a,u){const c=Mv(o,a,u);return o.inclusive?c>=0:c>0}(r.endAt,Sa(r),i))}(t,e)}function Eb(t){return t.collectionGroup||(t.path.length%2==1?t.path.lastSegment():t.path.get(t.path.length-2))}function wI(t){return(e,n)=>{let r=!1;for(const i of Sa(t)){const s=Tb(i,e,n);if(s!==0)return s;r=r||i.field.isKeyField()}return 0}}function Tb(t,e,n){const r=t.field.isKeyField()?ee.comparator(e.key,n.key):function(s,o,a){const u=o.data.field(s),c=a.data.field(s);return u!==null&&c!==null?so(u,c):oe()}(t.field,e,n);switch(t.dir){case"asc":return r;case"desc":return-1*r;default:return oe()}}/**
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
 */class Eo{constructor(e,n){this.mapKeyFn=e,this.equalsFn=n,this.inner={},this.innerSize=0}get(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r!==void 0){for(const[i,s]of r)if(this.equalsFn(i,e))return s}}has(e){return this.get(e)!==void 0}set(e,n){const r=this.mapKeyFn(e),i=this.inner[r];if(i===void 0)return this.inner[r]=[[e,n]],void this.innerSize++;for(let s=0;s<i.length;s++)if(this.equalsFn(i[s][0],e))return void(i[s]=[e,n]);i.push([e,n]),this.innerSize++}delete(e){const n=this.mapKeyFn(e),r=this.inner[n];if(r===void 0)return!1;for(let i=0;i<r.length;i++)if(this.equalsFn(r[i][0],e))return r.length===1?delete this.inner[n]:r.splice(i,1),this.innerSize--,!0;return!1}forEach(e){vo(this.inner,(n,r)=>{for(const[i,s]of r)e(i,s)})}isEmpty(){return lI(this.inner)}size(){return this.innerSize}}/**
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
 */const Ib=new it(ee.comparator);function Tr(){return Ib}const EI=new it(ee.comparator);function da(...t){let e=EI;for(const n of t)e=e.insert(n.key,n);return e}function TI(t){let e=EI;return t.forEach((n,r)=>e=e.insert(n,r.overlayedDocument)),e}function Ni(){return ka()}function II(){return ka()}function ka(){return new Eo(t=>t.toString(),(t,e)=>t.isEqual(e))}const Sb=new it(ee.comparator),kb=new St(ee.comparator);function pe(...t){let e=kb;for(const n of t)e=e.add(n);return e}const Cb=new St(we);function Rb(){return Cb}/**
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
 */function qm(t,e){if(t.useProto3Json){if(isNaN(e))return{doubleValue:"NaN"};if(e===1/0)return{doubleValue:"Infinity"};if(e===-1/0)return{doubleValue:"-Infinity"}}return{doubleValue:Rc(e)?"-0":e}}function SI(t){return{integerValue:""+t}}function xb(t,e){return ib(e)?SI(e):qm(t,e)}/**
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
 */class Eh{constructor(){this._=void 0}}function Ab(t,e,n){return t instanceof ol?function(i,s){const o={fields:{__type__:{stringValue:"server_timestamp"},__local_write_time__:{timestampValue:{seconds:i.seconds,nanos:i.nanoseconds}}}};return s&&jm(s)&&(s=zm(s)),s&&(o.fields.__previous_value__=s),{mapValue:o}}(n,e):t instanceof al?CI(t,e):t instanceof ll?RI(t,e):function(i,s){const o=kI(i,s),a=Uv(o)+Uv(i.Pe);return sp(o)&&sp(i.Pe)?SI(a):qm(i.serializer,a)}(t,e)}function Pb(t,e,n){return t instanceof al?CI(t,e):t instanceof ll?RI(t,e):n}function kI(t,e){return t instanceof Ac?function(r){return sp(r)||function(s){return!!s&&"doubleValue"in s}(r)}(e)?e:{integerValue:0}:null}class ol extends Eh{}class al extends Eh{constructor(e){super(),this.elements=e}}function CI(t,e){const n=xI(e);for(const r of t.elements)n.some(i=>Jn(i,r))||n.push(r);return{arrayValue:{values:n}}}class ll extends Eh{constructor(e){super(),this.elements=e}}function RI(t,e){let n=xI(e);for(const r of t.elements)n=n.filter(i=>!Jn(i,r));return{arrayValue:{values:n}}}class Ac extends Eh{constructor(e,n){super(),this.serializer=e,this.Pe=n}}function Uv(t){return Je(t.integerValue||t.doubleValue)}function xI(t){return Bm(t)&&t.arrayValue.values?t.arrayValue.values.slice():[]}/**
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
 */class bb{constructor(e,n){this.field=e,this.transform=n}}function Nb(t,e){return t.field.isEqual(e.field)&&function(r,i){return r instanceof al&&i instanceof al||r instanceof ll&&i instanceof ll?io(r.elements,i.elements,Jn):r instanceof Ac&&i instanceof Ac?Jn(r.Pe,i.Pe):r instanceof ol&&i instanceof ol}(t.transform,e.transform)}class Db{constructor(e,n){this.version=e,this.transformResults=n}}class Kn{constructor(e,n){this.updateTime=e,this.exists=n}static none(){return new Kn}static exists(e){return new Kn(void 0,e)}static updateTime(e){return new Kn(e)}get isNone(){return this.updateTime===void 0&&this.exists===void 0}isEqual(e){return this.exists===e.exists&&(this.updateTime?!!e.updateTime&&this.updateTime.isEqual(e.updateTime):!e.updateTime)}}function $u(t,e){return t.updateTime!==void 0?e.isFoundDocument()&&e.version.isEqual(t.updateTime):t.exists===void 0||t.exists===e.isFoundDocument()}class Th{}function AI(t,e){if(!t.hasLocalMutations||e&&e.fields.length===0)return null;if(e===null)return t.isNoDocument()?new Hm(t.key,Kn.none()):new Tl(t.key,t.data,Kn.none());{const n=t.data,r=pn.empty();let i=new St(Tt.comparator);for(let s of e.fields)if(!i.has(s)){let o=n.field(s);o===null&&s.length>1&&(s=s.popLast(),o=n.field(s)),o===null?r.delete(s):r.set(s,o),i=i.add(s)}return new ts(t.key,r,new Nn(i.toArray()),Kn.none())}}function Ob(t,e,n){t instanceof Tl?function(i,s,o){const a=i.value.clone(),u=zv(i.fieldTransforms,s,o.transformResults);a.setAll(u),s.convertToFoundDocument(o.version,a).setHasCommittedMutations()}(t,e,n):t instanceof ts?function(i,s,o){if(!$u(i.precondition,s))return void s.convertToUnknownDocument(o.version);const a=zv(i.fieldTransforms,s,o.transformResults),u=s.data;u.setAll(PI(i)),u.setAll(a),s.convertToFoundDocument(o.version,u).setHasCommittedMutations()}(t,e,n):function(i,s,o){s.convertToNoDocument(o.version).setHasCommittedMutations()}(0,e,n)}function Ca(t,e,n,r){return t instanceof Tl?function(s,o,a,u){if(!$u(s.precondition,o))return a;const c=s.value.clone(),h=Bv(s.fieldTransforms,u,o);return c.setAll(h),o.convertToFoundDocument(o.version,c).setHasLocalMutations(),null}(t,e,n,r):t instanceof ts?function(s,o,a,u){if(!$u(s.precondition,o))return a;const c=Bv(s.fieldTransforms,u,o),h=o.data;return h.setAll(PI(s)),h.setAll(c),o.convertToFoundDocument(o.version,h).setHasLocalMutations(),a===null?null:a.unionWith(s.fieldMask.fields).unionWith(s.fieldTransforms.map(f=>f.field))}(t,e,n,r):function(s,o,a){return $u(s.precondition,o)?(o.convertToNoDocument(o.version).setHasLocalMutations(),null):a}(t,e,n)}function Mb(t,e){let n=null;for(const r of t.fieldTransforms){const i=e.data.field(r.field),s=kI(r.transform,i||null);s!=null&&(n===null&&(n=pn.empty()),n.set(r.field,s))}return n||null}function jv(t,e){return t.type===e.type&&!!t.key.isEqual(e.key)&&!!t.precondition.isEqual(e.precondition)&&!!function(r,i){return r===void 0&&i===void 0||!(!r||!i)&&io(r,i,(s,o)=>Nb(s,o))}(t.fieldTransforms,e.fieldTransforms)&&(t.type===0?t.value.isEqual(e.value):t.type!==1||t.data.isEqual(e.data)&&t.fieldMask.isEqual(e.fieldMask))}class Tl extends Th{constructor(e,n,r,i=[]){super(),this.key=e,this.value=n,this.precondition=r,this.fieldTransforms=i,this.type=0}getFieldMask(){return null}}class ts extends Th{constructor(e,n,r,i,s=[]){super(),this.key=e,this.data=n,this.fieldMask=r,this.precondition=i,this.fieldTransforms=s,this.type=1}getFieldMask(){return this.fieldMask}}function PI(t){const e=new Map;return t.fieldMask.fields.forEach(n=>{if(!n.isEmpty()){const r=t.data.field(n);e.set(n,r)}}),e}function zv(t,e,n){const r=new Map;ke(t.length===n.length);for(let i=0;i<n.length;i++){const s=t[i],o=s.transform,a=e.data.field(s.field);r.set(s.field,Pb(o,a,n[i]))}return r}function Bv(t,e,n){const r=new Map;for(const i of t){const s=i.transform,o=n.data.field(i.field);r.set(i.field,Ab(s,o,e))}return r}class Hm extends Th{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=2,this.fieldTransforms=[]}getFieldMask(){return null}}class Lb extends Th{constructor(e,n){super(),this.key=e,this.precondition=n,this.type=3,this.fieldTransforms=[]}getFieldMask(){return null}}/**
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
 */class Fb{constructor(e,n,r,i){this.batchId=e,this.localWriteTime=n,this.baseMutations=r,this.mutations=i}applyToRemoteDocument(e,n){const r=n.mutationResults;for(let i=0;i<this.mutations.length;i++){const s=this.mutations[i];s.key.isEqual(e.key)&&Ob(s,e,r[i])}}applyToLocalView(e,n){for(const r of this.baseMutations)r.key.isEqual(e.key)&&(n=Ca(r,e,n,this.localWriteTime));for(const r of this.mutations)r.key.isEqual(e.key)&&(n=Ca(r,e,n,this.localWriteTime));return n}applyToLocalDocumentSet(e,n){const r=II();return this.mutations.forEach(i=>{const s=e.get(i.key),o=s.overlayedDocument;let a=this.applyToLocalView(o,s.mutatedFields);a=n.has(i.key)?null:a;const u=AI(o,a);u!==null&&r.set(i.key,u),o.isValidDocument()||o.convertToNoDocument(ae.min())}),r}keys(){return this.mutations.reduce((e,n)=>e.add(n.key),pe())}isEqual(e){return this.batchId===e.batchId&&io(this.mutations,e.mutations,(n,r)=>jv(n,r))&&io(this.baseMutations,e.baseMutations,(n,r)=>jv(n,r))}}class Gm{constructor(e,n,r,i){this.batch=e,this.commitVersion=n,this.mutationResults=r,this.docVersions=i}static from(e,n,r){ke(e.mutations.length===r.length);let i=function(){return Sb}();const s=e.mutations;for(let o=0;o<s.length;o++)i=i.insert(s[o].key,r[o].version);return new Gm(e,n,r,i)}}/**
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
 */class Vb{constructor(e,n){this.largestBatchId=e,this.mutation=n}getKey(){return this.mutation.key}isEqual(e){return e!==null&&this.mutation===e.mutation}toString(){return`Overlay{
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
 */class Ub{constructor(e,n){this.count=e,this.unchangedNames=n}}/**
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
 */var tt,ge;function jb(t){switch(t){default:return oe();case V.CANCELLED:case V.UNKNOWN:case V.DEADLINE_EXCEEDED:case V.RESOURCE_EXHAUSTED:case V.INTERNAL:case V.UNAVAILABLE:case V.UNAUTHENTICATED:return!1;case V.INVALID_ARGUMENT:case V.NOT_FOUND:case V.ALREADY_EXISTS:case V.PERMISSION_DENIED:case V.FAILED_PRECONDITION:case V.ABORTED:case V.OUT_OF_RANGE:case V.UNIMPLEMENTED:case V.DATA_LOSS:return!0}}function bI(t){if(t===void 0)return Er("GRPC error has no .code"),V.UNKNOWN;switch(t){case tt.OK:return V.OK;case tt.CANCELLED:return V.CANCELLED;case tt.UNKNOWN:return V.UNKNOWN;case tt.DEADLINE_EXCEEDED:return V.DEADLINE_EXCEEDED;case tt.RESOURCE_EXHAUSTED:return V.RESOURCE_EXHAUSTED;case tt.INTERNAL:return V.INTERNAL;case tt.UNAVAILABLE:return V.UNAVAILABLE;case tt.UNAUTHENTICATED:return V.UNAUTHENTICATED;case tt.INVALID_ARGUMENT:return V.INVALID_ARGUMENT;case tt.NOT_FOUND:return V.NOT_FOUND;case tt.ALREADY_EXISTS:return V.ALREADY_EXISTS;case tt.PERMISSION_DENIED:return V.PERMISSION_DENIED;case tt.FAILED_PRECONDITION:return V.FAILED_PRECONDITION;case tt.ABORTED:return V.ABORTED;case tt.OUT_OF_RANGE:return V.OUT_OF_RANGE;case tt.UNIMPLEMENTED:return V.UNIMPLEMENTED;case tt.DATA_LOSS:return V.DATA_LOSS;default:return oe()}}(ge=tt||(tt={}))[ge.OK=0]="OK",ge[ge.CANCELLED=1]="CANCELLED",ge[ge.UNKNOWN=2]="UNKNOWN",ge[ge.INVALID_ARGUMENT=3]="INVALID_ARGUMENT",ge[ge.DEADLINE_EXCEEDED=4]="DEADLINE_EXCEEDED",ge[ge.NOT_FOUND=5]="NOT_FOUND",ge[ge.ALREADY_EXISTS=6]="ALREADY_EXISTS",ge[ge.PERMISSION_DENIED=7]="PERMISSION_DENIED",ge[ge.UNAUTHENTICATED=16]="UNAUTHENTICATED",ge[ge.RESOURCE_EXHAUSTED=8]="RESOURCE_EXHAUSTED",ge[ge.FAILED_PRECONDITION=9]="FAILED_PRECONDITION",ge[ge.ABORTED=10]="ABORTED",ge[ge.OUT_OF_RANGE=11]="OUT_OF_RANGE",ge[ge.UNIMPLEMENTED=12]="UNIMPLEMENTED",ge[ge.INTERNAL=13]="INTERNAL",ge[ge.UNAVAILABLE=14]="UNAVAILABLE",ge[ge.DATA_LOSS=15]="DATA_LOSS";/**
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
 */function zb(){return new TextEncoder}/**
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
 */const Bb=new Fi([4294967295,4294967295],0);function $v(t){const e=zb().encode(t),n=new eI;return n.update(e),new Uint8Array(n.digest())}function Wv(t){const e=new DataView(t.buffer),n=e.getUint32(0,!0),r=e.getUint32(4,!0),i=e.getUint32(8,!0),s=e.getUint32(12,!0);return[new Fi([n,r],0),new Fi([i,s],0)]}class Km{constructor(e,n,r){if(this.bitmap=e,this.padding=n,this.hashCount=r,n<0||n>=8)throw new fa(`Invalid padding: ${n}`);if(r<0)throw new fa(`Invalid hash count: ${r}`);if(e.length>0&&this.hashCount===0)throw new fa(`Invalid hash count: ${r}`);if(e.length===0&&n!==0)throw new fa(`Invalid padding when bitmap length is 0: ${n}`);this.Ie=8*e.length-n,this.Te=Fi.fromNumber(this.Ie)}Ee(e,n,r){let i=e.add(n.multiply(Fi.fromNumber(r)));return i.compare(Bb)===1&&(i=new Fi([i.getBits(0),i.getBits(1)],0)),i.modulo(this.Te).toNumber()}de(e){return(this.bitmap[Math.floor(e/8)]&1<<e%8)!=0}mightContain(e){if(this.Ie===0)return!1;const n=$v(e),[r,i]=Wv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);if(!this.de(o))return!1}return!0}static create(e,n,r){const i=e%8==0?0:8-e%8,s=new Uint8Array(Math.ceil(e/8)),o=new Km(s,i,n);return r.forEach(a=>o.insert(a)),o}insert(e){if(this.Ie===0)return;const n=$v(e),[r,i]=Wv(n);for(let s=0;s<this.hashCount;s++){const o=this.Ee(r,i,s);this.Ae(o)}}Ae(e){const n=Math.floor(e/8),r=e%8;this.bitmap[n]|=1<<r}}class fa extends Error{constructor(){super(...arguments),this.name="BloomFilterError"}}/**
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
 */class Ih{constructor(e,n,r,i,s){this.snapshotVersion=e,this.targetChanges=n,this.targetMismatches=r,this.documentUpdates=i,this.resolvedLimboDocuments=s}static createSynthesizedRemoteEventForCurrentChange(e,n,r){const i=new Map;return i.set(e,Il.createSynthesizedTargetChangeForCurrentChange(e,n,r)),new Ih(ae.min(),i,new it(we),Tr(),pe())}}class Il{constructor(e,n,r,i,s){this.resumeToken=e,this.current=n,this.addedDocuments=r,this.modifiedDocuments=i,this.removedDocuments=s}static createSynthesizedTargetChangeForCurrentChange(e,n,r){return new Il(r,n,pe(),pe(),pe())}}/**
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
 */class Wu{constructor(e,n,r,i){this.Re=e,this.removedTargetIds=n,this.key=r,this.Ve=i}}class NI{constructor(e,n){this.targetId=e,this.me=n}}class DI{constructor(e,n,r=Ct.EMPTY_BYTE_STRING,i=null){this.state=e,this.targetIds=n,this.resumeToken=r,this.cause=i}}class qv{constructor(){this.fe=0,this.ge=Gv(),this.pe=Ct.EMPTY_BYTE_STRING,this.ye=!1,this.we=!0}get current(){return this.ye}get resumeToken(){return this.pe}get Se(){return this.fe!==0}get be(){return this.we}De(e){e.approximateByteSize()>0&&(this.we=!0,this.pe=e)}ve(){let e=pe(),n=pe(),r=pe();return this.ge.forEach((i,s)=>{switch(s){case 0:e=e.add(i);break;case 2:n=n.add(i);break;case 1:r=r.add(i);break;default:oe()}}),new Il(this.pe,this.ye,e,n,r)}Ce(){this.we=!1,this.ge=Gv()}Fe(e,n){this.we=!0,this.ge=this.ge.insert(e,n)}Me(e){this.we=!0,this.ge=this.ge.remove(e)}xe(){this.fe+=1}Oe(){this.fe-=1,ke(this.fe>=0)}Ne(){this.we=!0,this.ye=!0}}class $b{constructor(e){this.Le=e,this.Be=new Map,this.ke=Tr(),this.qe=Hv(),this.Qe=new it(we)}Ke(e){for(const n of e.Re)e.Ve&&e.Ve.isFoundDocument()?this.$e(n,e.Ve):this.Ue(n,e.key,e.Ve);for(const n of e.removedTargetIds)this.Ue(n,e.key,e.Ve)}We(e){this.forEachTarget(e,n=>{const r=this.Ge(n);switch(e.state){case 0:this.ze(n)&&r.De(e.resumeToken);break;case 1:r.Oe(),r.Se||r.Ce(),r.De(e.resumeToken);break;case 2:r.Oe(),r.Se||this.removeTarget(n);break;case 3:this.ze(n)&&(r.Ne(),r.De(e.resumeToken));break;case 4:this.ze(n)&&(this.je(n),r.De(e.resumeToken));break;default:oe()}})}forEachTarget(e,n){e.targetIds.length>0?e.targetIds.forEach(n):this.Be.forEach((r,i)=>{this.ze(i)&&n(i)})}He(e){const n=e.targetId,r=e.me.count,i=this.Je(n);if(i){const s=i.target;if(ap(s))if(r===0){const o=new ee(s.path);this.Ue(n,o,Ot.newNoDocument(o,ae.min()))}else ke(r===1);else{const o=this.Ye(n);if(o!==r){const a=this.Ze(e),u=a?this.Xe(a,e,o):1;if(u!==0){this.je(n);const c=u===2?"TargetPurposeExistenceFilterMismatchBloom":"TargetPurposeExistenceFilterMismatch";this.Qe=this.Qe.insert(n,c)}}}}}Ze(e){const n=e.me.unchangedNames;if(!n||!n.bits)return null;const{bits:{bitmap:r="",padding:i=0},hashCount:s=0}=n;let o,a;try{o=qi(r).toUint8Array()}catch(u){if(u instanceof uI)return ro("Decoding the base64 bloom filter in existence filter failed ("+u.message+"); ignoring the bloom filter and falling back to full re-query."),null;throw u}try{a=new Km(o,i,s)}catch(u){return ro(u instanceof fa?"BloomFilter error: ":"Applying bloom filter failed: ",u),null}return a.Ie===0?null:a}Xe(e,n,r){return n.me.count===r-this.nt(e,n.targetId)?0:2}nt(e,n){const r=this.Le.getRemoteKeysForTarget(n);let i=0;return r.forEach(s=>{const o=this.Le.tt(),a=`projects/${o.projectId}/databases/${o.database}/documents/${s.path.canonicalString()}`;e.mightContain(a)||(this.Ue(n,s,null),i++)}),i}rt(e){const n=new Map;this.Be.forEach((s,o)=>{const a=this.Je(o);if(a){if(s.current&&ap(a.target)){const u=new ee(a.target.path);this.ke.get(u)!==null||this.it(o,u)||this.Ue(o,u,Ot.newNoDocument(u,e))}s.be&&(n.set(o,s.ve()),s.Ce())}});let r=pe();this.qe.forEach((s,o)=>{let a=!0;o.forEachWhile(u=>{const c=this.Je(u);return!c||c.purpose==="TargetPurposeLimboResolution"||(a=!1,!1)}),a&&(r=r.add(s))}),this.ke.forEach((s,o)=>o.setReadTime(e));const i=new Ih(e,n,this.Qe,this.ke,r);return this.ke=Tr(),this.qe=Hv(),this.Qe=new it(we),i}$e(e,n){if(!this.ze(e))return;const r=this.it(e,n.key)?2:0;this.Ge(e).Fe(n.key,r),this.ke=this.ke.insert(n.key,n),this.qe=this.qe.insert(n.key,this.st(n.key).add(e))}Ue(e,n,r){if(!this.ze(e))return;const i=this.Ge(e);this.it(e,n)?i.Fe(n,1):i.Me(n),this.qe=this.qe.insert(n,this.st(n).delete(e)),r&&(this.ke=this.ke.insert(n,r))}removeTarget(e){this.Be.delete(e)}Ye(e){const n=this.Ge(e).ve();return this.Le.getRemoteKeysForTarget(e).size+n.addedDocuments.size-n.removedDocuments.size}xe(e){this.Ge(e).xe()}Ge(e){let n=this.Be.get(e);return n||(n=new qv,this.Be.set(e,n)),n}st(e){let n=this.qe.get(e);return n||(n=new St(we),this.qe=this.qe.insert(e,n)),n}ze(e){const n=this.Je(e)!==null;return n||J("WatchChangeAggregator","Detected inactive target",e),n}Je(e){const n=this.Be.get(e);return n&&n.Se?null:this.Le.ot(e)}je(e){this.Be.set(e,new qv),this.Le.getRemoteKeysForTarget(e).forEach(n=>{this.Ue(e,n,null)})}it(e,n){return this.Le.getRemoteKeysForTarget(e).has(n)}}function Hv(){return new it(ee.comparator)}function Gv(){return new it(ee.comparator)}const Wb={asc:"ASCENDING",desc:"DESCENDING"},qb={"<":"LESS_THAN","<=":"LESS_THAN_OR_EQUAL",">":"GREATER_THAN",">=":"GREATER_THAN_OR_EQUAL","==":"EQUAL","!=":"NOT_EQUAL","array-contains":"ARRAY_CONTAINS",in:"IN","not-in":"NOT_IN","array-contains-any":"ARRAY_CONTAINS_ANY"},Hb={and:"AND",or:"OR"};class Gb{constructor(e,n){this.databaseId=e,this.useProto3Json=n}}function cp(t,e){return t.useProto3Json||yh(e)?e:{value:e}}function Pc(t,e){return t.useProto3Json?`${new Date(1e3*e.seconds).toISOString().replace(/\.\d*/,"").replace("Z","")}.${("000000000"+e.nanoseconds).slice(-9)}Z`:{seconds:""+e.seconds,nanos:e.nanoseconds}}function OI(t,e){return t.useProto3Json?e.toBase64():e.toUint8Array()}function Kb(t,e){return Pc(t,e.toTimestamp())}function Qn(t){return ke(!!t),ae.fromTimestamp(function(n){const r=hi(n);return new ut(r.seconds,r.nanos)}(t))}function Qm(t,e){return hp(t,e).canonicalString()}function hp(t,e){const n=function(i){return new Ve(["projects",i.projectId,"databases",i.database])}(t).child("documents");return e===void 0?n:n.child(e)}function MI(t){const e=Ve.fromString(t);return ke(jI(e)),e}function dp(t,e){return Qm(t.databaseId,e.path)}function Fd(t,e){const n=MI(e);if(n.get(1)!==t.databaseId.projectId)throw new X(V.INVALID_ARGUMENT,"Tried to deserialize key from different project: "+n.get(1)+" vs "+t.databaseId.projectId);if(n.get(3)!==t.databaseId.database)throw new X(V.INVALID_ARGUMENT,"Tried to deserialize key from different database: "+n.get(3)+" vs "+t.databaseId.database);return new ee(FI(n))}function LI(t,e){return Qm(t.databaseId,e)}function Qb(t){const e=MI(t);return e.length===4?Ve.emptyPath():FI(e)}function fp(t){return new Ve(["projects",t.databaseId.projectId,"databases",t.databaseId.database]).canonicalString()}function FI(t){return ke(t.length>4&&t.get(4)==="documents"),t.popFirst(5)}function Kv(t,e,n){return{name:dp(t,e),fields:n.value.mapValue.fields}}function Yb(t,e){let n;if("targetChange"in e){e.targetChange;const r=function(c){return c==="NO_CHANGE"?0:c==="ADD"?1:c==="REMOVE"?2:c==="CURRENT"?3:c==="RESET"?4:oe()}(e.targetChange.targetChangeType||"NO_CHANGE"),i=e.targetChange.targetIds||[],s=function(c,h){return c.useProto3Json?(ke(h===void 0||typeof h=="string"),Ct.fromBase64String(h||"")):(ke(h===void 0||h instanceof Buffer||h instanceof Uint8Array),Ct.fromUint8Array(h||new Uint8Array))}(t,e.targetChange.resumeToken),o=e.targetChange.cause,a=o&&function(c){const h=c.code===void 0?V.UNKNOWN:bI(c.code);return new X(h,c.message||"")}(o);n=new DI(r,i,s,a||null)}else if("documentChange"in e){e.documentChange;const r=e.documentChange;r.document,r.document.name,r.document.updateTime;const i=Fd(t,r.document.name),s=Qn(r.document.updateTime),o=r.document.createTime?Qn(r.document.createTime):ae.min(),a=new pn({mapValue:{fields:r.document.fields}}),u=Ot.newFoundDocument(i,s,o,a),c=r.targetIds||[],h=r.removedTargetIds||[];n=new Wu(c,h,u.key,u)}else if("documentDelete"in e){e.documentDelete;const r=e.documentDelete;r.document;const i=Fd(t,r.document),s=r.readTime?Qn(r.readTime):ae.min(),o=Ot.newNoDocument(i,s),a=r.removedTargetIds||[];n=new Wu([],a,o.key,o)}else if("documentRemove"in e){e.documentRemove;const r=e.documentRemove;r.document;const i=Fd(t,r.document),s=r.removedTargetIds||[];n=new Wu([],s,i,null)}else{if(!("filter"in e))return oe();{e.filter;const r=e.filter;r.targetId;const{count:i=0,unchangedNames:s}=r,o=new Ub(i,s),a=r.targetId;n=new NI(a,o)}}return n}function Xb(t,e){let n;if(e instanceof Tl)n={update:Kv(t,e.key,e.value)};else if(e instanceof Hm)n={delete:dp(t,e.key)};else if(e instanceof ts)n={update:Kv(t,e.key,e.data),updateMask:oN(e.fieldMask)};else{if(!(e instanceof Lb))return oe();n={verify:dp(t,e.key)}}return e.fieldTransforms.length>0&&(n.updateTransforms=e.fieldTransforms.map(r=>function(s,o){const a=o.transform;if(a instanceof ol)return{fieldPath:o.field.canonicalString(),setToServerValue:"REQUEST_TIME"};if(a instanceof al)return{fieldPath:o.field.canonicalString(),appendMissingElements:{values:a.elements}};if(a instanceof ll)return{fieldPath:o.field.canonicalString(),removeAllFromArray:{values:a.elements}};if(a instanceof Ac)return{fieldPath:o.field.canonicalString(),increment:a.Pe};throw oe()}(0,r))),e.precondition.isNone||(n.currentDocument=function(i,s){return s.updateTime!==void 0?{updateTime:Kb(i,s.updateTime)}:s.exists!==void 0?{exists:s.exists}:oe()}(t,e.precondition)),n}function Jb(t,e){return t&&t.length>0?(ke(e!==void 0),t.map(n=>function(i,s){let o=i.updateTime?Qn(i.updateTime):Qn(s);return o.isEqual(ae.min())&&(o=Qn(s)),new Db(o,i.transformResults||[])}(n,e))):[]}function Zb(t,e){return{documents:[LI(t,e.path)]}}function eN(t,e){const n={structuredQuery:{}},r=e.path;let i;e.collectionGroup!==null?(i=r,n.structuredQuery.from=[{collectionId:e.collectionGroup,allDescendants:!0}]):(i=r.popLast(),n.structuredQuery.from=[{collectionId:r.lastSegment()}]),n.parent=LI(t,i);const s=function(c){if(c.length!==0)return UI(Vn.create(c,"and"))}(e.filters);s&&(n.structuredQuery.where=s);const o=function(c){if(c.length!==0)return c.map(h=>function(m){return{field:ys(m.field),direction:rN(m.dir)}}(h))}(e.orderBy);o&&(n.structuredQuery.orderBy=o);const a=cp(t,e.limit);return a!==null&&(n.structuredQuery.limit=a),e.startAt&&(n.structuredQuery.startAt=function(c){return{before:c.inclusive,values:c.position}}(e.startAt)),e.endAt&&(n.structuredQuery.endAt=function(c){return{before:!c.inclusive,values:c.position}}(e.endAt)),{_t:n,parent:i}}function tN(t){let e=Qb(t.parent);const n=t.structuredQuery,r=n.from?n.from.length:0;let i=null;if(r>0){ke(r===1);const h=n.from[0];h.allDescendants?i=h.collectionId:e=e.child(h.collectionId)}let s=[];n.where&&(s=function(f){const m=VI(f);return m instanceof Vn&&fI(m)?m.getFilters():[m]}(n.where));let o=[];n.orderBy&&(o=function(f){return f.map(m=>function(S){return new sl(vs(S.field),function(D){switch(D){case"ASCENDING":return"asc";case"DESCENDING":return"desc";default:return}}(S.direction))}(m))}(n.orderBy));let a=null;n.limit&&(a=function(f){let m;return m=typeof f=="object"?f.value:f,yh(m)?null:m}(n.limit));let u=null;n.startAt&&(u=function(f){const m=!!f.before,w=f.values||[];return new xc(w,m)}(n.startAt));let c=null;return n.endAt&&(c=function(f){const m=!f.before,w=f.values||[];return new xc(w,m)}(n.endAt)),vb(e,i,o,s,a,"F",u,c)}function nN(t,e){const n=function(i){switch(i){case"TargetPurposeListen":return null;case"TargetPurposeExistenceFilterMismatch":return"existence-filter-mismatch";case"TargetPurposeExistenceFilterMismatchBloom":return"existence-filter-mismatch-bloom";case"TargetPurposeLimboResolution":return"limbo-document";default:return oe()}}(e.purpose);return n==null?null:{"goog-listen-tags":n}}function VI(t){return t.unaryFilter!==void 0?function(n){switch(n.unaryFilter.op){case"IS_NAN":const r=vs(n.unaryFilter.field);return rt.create(r,"==",{doubleValue:NaN});case"IS_NULL":const i=vs(n.unaryFilter.field);return rt.create(i,"==",{nullValue:"NULL_VALUE"});case"IS_NOT_NAN":const s=vs(n.unaryFilter.field);return rt.create(s,"!=",{doubleValue:NaN});case"IS_NOT_NULL":const o=vs(n.unaryFilter.field);return rt.create(o,"!=",{nullValue:"NULL_VALUE"});default:return oe()}}(t):t.fieldFilter!==void 0?function(n){return rt.create(vs(n.fieldFilter.field),function(i){switch(i){case"EQUAL":return"==";case"NOT_EQUAL":return"!=";case"GREATER_THAN":return">";case"GREATER_THAN_OR_EQUAL":return">=";case"LESS_THAN":return"<";case"LESS_THAN_OR_EQUAL":return"<=";case"ARRAY_CONTAINS":return"array-contains";case"IN":return"in";case"NOT_IN":return"not-in";case"ARRAY_CONTAINS_ANY":return"array-contains-any";default:return oe()}}(n.fieldFilter.op),n.fieldFilter.value)}(t):t.compositeFilter!==void 0?function(n){return Vn.create(n.compositeFilter.filters.map(r=>VI(r)),function(i){switch(i){case"AND":return"and";case"OR":return"or";default:return oe()}}(n.compositeFilter.op))}(t):oe()}function rN(t){return Wb[t]}function iN(t){return qb[t]}function sN(t){return Hb[t]}function ys(t){return{fieldPath:t.canonicalString()}}function vs(t){return Tt.fromServerFormat(t.fieldPath)}function UI(t){return t instanceof rt?function(n){if(n.op==="=="){if(Ov(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NAN"}};if(Dv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NULL"}}}else if(n.op==="!="){if(Ov(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NOT_NAN"}};if(Dv(n.value))return{unaryFilter:{field:ys(n.field),op:"IS_NOT_NULL"}}}return{fieldFilter:{field:ys(n.field),op:iN(n.op),value:n.value}}}(t):t instanceof Vn?function(n){const r=n.getFilters().map(i=>UI(i));return r.length===1?r[0]:{compositeFilter:{op:sN(n.op),filters:r}}}(t):oe()}function oN(t){const e=[];return t.fields.forEach(n=>e.push(n.canonicalString())),{fieldPaths:e}}function jI(t){return t.length>=4&&t.get(0)==="projects"&&t.get(2)==="databases"}/**
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
 */class qr{constructor(e,n,r,i,s=ae.min(),o=ae.min(),a=Ct.EMPTY_BYTE_STRING,u=null){this.target=e,this.targetId=n,this.purpose=r,this.sequenceNumber=i,this.snapshotVersion=s,this.lastLimboFreeSnapshotVersion=o,this.resumeToken=a,this.expectedCount=u}withSequenceNumber(e){return new qr(this.target,this.targetId,this.purpose,e,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,this.expectedCount)}withResumeToken(e,n){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,n,this.lastLimboFreeSnapshotVersion,e,null)}withExpectedCount(e){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,this.lastLimboFreeSnapshotVersion,this.resumeToken,e)}withLastLimboFreeSnapshotVersion(e){return new qr(this.target,this.targetId,this.purpose,this.sequenceNumber,this.snapshotVersion,e,this.resumeToken,this.expectedCount)}}/**
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
 */class aN{constructor(e){this.ct=e}}function lN(t){const e=tN({parent:t.parent,structuredQuery:t.structuredQuery});return t.limitType==="LAST"?up(e,e.limit,"L"):e}/**
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
 */class uN{constructor(){this.un=new cN}addToCollectionParentIndex(e,n){return this.un.add(n),j.resolve()}getCollectionParents(e,n){return j.resolve(this.un.getEntries(n))}addFieldIndex(e,n){return j.resolve()}deleteFieldIndex(e,n){return j.resolve()}deleteAllFieldIndexes(e){return j.resolve()}createTargetIndexes(e,n){return j.resolve()}getDocumentsMatchingTarget(e,n){return j.resolve(null)}getIndexType(e,n){return j.resolve(0)}getFieldIndexes(e,n){return j.resolve([])}getNextCollectionGroupToUpdate(e){return j.resolve(null)}getMinOffset(e,n){return j.resolve(ci.min())}getMinOffsetFromCollectionGroup(e,n){return j.resolve(ci.min())}updateCollectionGroup(e,n,r){return j.resolve()}updateIndexEntries(e,n){return j.resolve()}}class cN{constructor(){this.index={}}add(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n]||new St(Ve.comparator),s=!i.has(r);return this.index[n]=i.add(r),s}has(e){const n=e.lastSegment(),r=e.popLast(),i=this.index[n];return i&&i.has(r)}getEntries(e){return(this.index[e]||new St(Ve.comparator)).toArray()}}/**
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
 */class ao{constructor(e){this.Ln=e}next(){return this.Ln+=2,this.Ln}static Bn(){return new ao(0)}static kn(){return new ao(-1)}}/**
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
 */class hN{constructor(){this.changes=new Eo(e=>e.toString(),(e,n)=>e.isEqual(n)),this.changesApplied=!1}addEntry(e){this.assertNotApplied(),this.changes.set(e.key,e)}removeEntry(e,n){this.assertNotApplied(),this.changes.set(e,Ot.newInvalidDocument(e).setReadTime(n))}getEntry(e,n){this.assertNotApplied();const r=this.changes.get(n);return r!==void 0?j.resolve(r):this.getFromCache(e,n)}getEntries(e,n){return this.getAllFromCache(e,n)}apply(e){return this.assertNotApplied(),this.changesApplied=!0,this.applyChanges(e)}assertNotApplied(){}}/**
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
 */class dN{constructor(e,n){this.overlayedDocument=e,this.mutatedFields=n}}/**
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
 */class fN{constructor(e,n,r,i){this.remoteDocumentCache=e,this.mutationQueue=n,this.documentOverlayCache=r,this.indexManager=i}getDocument(e,n){let r=null;return this.documentOverlayCache.getOverlay(e,n).next(i=>(r=i,this.remoteDocumentCache.getEntry(e,n))).next(i=>(r!==null&&Ca(r.mutation,i,Nn.empty(),ut.now()),i))}getDocuments(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.getLocalViewOfDocuments(e,r,pe()).next(()=>r))}getLocalViewOfDocuments(e,n,r=pe()){const i=Ni();return this.populateOverlays(e,i,n).next(()=>this.computeViews(e,n,i,r).next(s=>{let o=da();return s.forEach((a,u)=>{o=o.insert(a,u.overlayedDocument)}),o}))}getOverlayedDocuments(e,n){const r=Ni();return this.populateOverlays(e,r,n).next(()=>this.computeViews(e,n,r,pe()))}populateOverlays(e,n,r){const i=[];return r.forEach(s=>{n.has(s)||i.push(s)}),this.documentOverlayCache.getOverlays(e,i).next(s=>{s.forEach((o,a)=>{n.set(o,a)})})}computeViews(e,n,r,i){let s=Tr();const o=ka(),a=function(){return ka()}();return n.forEach((u,c)=>{const h=r.get(c.key);i.has(c.key)&&(h===void 0||h.mutation instanceof ts)?s=s.insert(c.key,c):h!==void 0?(o.set(c.key,h.mutation.getFieldMask()),Ca(h.mutation,c,h.mutation.getFieldMask(),ut.now())):o.set(c.key,Nn.empty())}),this.recalculateAndSaveOverlays(e,s).next(u=>(u.forEach((c,h)=>o.set(c,h)),n.forEach((c,h)=>{var f;return a.set(c,new dN(h,(f=o.get(c))!==null&&f!==void 0?f:null))}),a))}recalculateAndSaveOverlays(e,n){const r=ka();let i=new it((o,a)=>o-a),s=pe();return this.mutationQueue.getAllMutationBatchesAffectingDocumentKeys(e,n).next(o=>{for(const a of o)a.keys().forEach(u=>{const c=n.get(u);if(c===null)return;let h=r.get(u)||Nn.empty();h=a.applyToLocalView(c,h),r.set(u,h);const f=(i.get(a.batchId)||pe()).add(u);i=i.insert(a.batchId,f)})}).next(()=>{const o=[],a=i.getReverseIterator();for(;a.hasNext();){const u=a.getNext(),c=u.key,h=u.value,f=II();h.forEach(m=>{if(!s.has(m)){const w=AI(n.get(m),r.get(m));w!==null&&f.set(m,w),s=s.add(m)}}),o.push(this.documentOverlayCache.saveOverlays(e,c,f))}return j.waitFor(o)}).next(()=>r)}recalculateAndSaveOverlaysForDocumentKeys(e,n){return this.remoteDocumentCache.getEntries(e,n).next(r=>this.recalculateAndSaveOverlays(e,r))}getDocumentsMatchingQuery(e,n,r,i){return function(o){return ee.isDocumentKey(o.path)&&o.collectionGroup===null&&o.filters.length===0}(n)?this.getDocumentsMatchingDocumentQuery(e,n.path):yI(n)?this.getDocumentsMatchingCollectionGroupQuery(e,n,r,i):this.getDocumentsMatchingCollectionQuery(e,n,r,i)}getNextDocuments(e,n,r,i){return this.remoteDocumentCache.getAllFromCollectionGroup(e,n,r,i).next(s=>{const o=i-s.size>0?this.documentOverlayCache.getOverlaysForCollectionGroup(e,n,r.largestBatchId,i-s.size):j.resolve(Ni());let a=-1,u=s;return o.next(c=>j.forEach(c,(h,f)=>(a<f.largestBatchId&&(a=f.largestBatchId),s.get(h)?j.resolve():this.remoteDocumentCache.getEntry(e,h).next(m=>{u=u.insert(h,m)}))).next(()=>this.populateOverlays(e,c,s)).next(()=>this.computeViews(e,u,c,pe())).next(h=>({batchId:a,changes:TI(h)})))})}getDocumentsMatchingDocumentQuery(e,n){return this.getDocument(e,new ee(n)).next(r=>{let i=da();return r.isFoundDocument()&&(i=i.insert(r.key,r)),i})}getDocumentsMatchingCollectionGroupQuery(e,n,r,i){const s=n.collectionGroup;let o=da();return this.indexManager.getCollectionParents(e,s).next(a=>j.forEach(a,u=>{const c=function(f,m){return new wo(m,null,f.explicitOrderBy.slice(),f.filters.slice(),f.limit,f.limitType,f.startAt,f.endAt)}(n,u.child(s));return this.getDocumentsMatchingCollectionQuery(e,c,r,i).next(h=>{h.forEach((f,m)=>{o=o.insert(f,m)})})}).next(()=>o))}getDocumentsMatchingCollectionQuery(e,n,r,i){let s;return this.documentOverlayCache.getOverlaysForCollection(e,n.path,r.largestBatchId).next(o=>(s=o,this.remoteDocumentCache.getDocumentsMatchingQuery(e,n,r,s,i))).next(o=>{s.forEach((u,c)=>{const h=c.getKey();o.get(h)===null&&(o=o.insert(h,Ot.newInvalidDocument(h)))});let a=da();return o.forEach((u,c)=>{const h=s.get(u);h!==void 0&&Ca(h.mutation,c,Nn.empty(),ut.now()),wh(n,c)&&(a=a.insert(u,c))}),a})}}/**
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
 */class pN{constructor(e){this.serializer=e,this.hr=new Map,this.Pr=new Map}getBundleMetadata(e,n){return j.resolve(this.hr.get(n))}saveBundleMetadata(e,n){return this.hr.set(n.id,function(i){return{id:i.id,version:i.version,createTime:Qn(i.createTime)}}(n)),j.resolve()}getNamedQuery(e,n){return j.resolve(this.Pr.get(n))}saveNamedQuery(e,n){return this.Pr.set(n.name,function(i){return{name:i.name,query:lN(i.bundledQuery),readTime:Qn(i.readTime)}}(n)),j.resolve()}}/**
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
 */class mN{constructor(){this.overlays=new it(ee.comparator),this.Ir=new Map}getOverlay(e,n){return j.resolve(this.overlays.get(n))}getOverlays(e,n){const r=Ni();return j.forEach(n,i=>this.getOverlay(e,i).next(s=>{s!==null&&r.set(i,s)})).next(()=>r)}saveOverlays(e,n,r){return r.forEach((i,s)=>{this.ht(e,n,s)}),j.resolve()}removeOverlaysForBatchId(e,n,r){const i=this.Ir.get(r);return i!==void 0&&(i.forEach(s=>this.overlays=this.overlays.remove(s)),this.Ir.delete(r)),j.resolve()}getOverlaysForCollection(e,n,r){const i=Ni(),s=n.length+1,o=new ee(n.child("")),a=this.overlays.getIteratorFrom(o);for(;a.hasNext();){const u=a.getNext().value,c=u.getKey();if(!n.isPrefixOf(c.path))break;c.path.length===s&&u.largestBatchId>r&&i.set(u.getKey(),u)}return j.resolve(i)}getOverlaysForCollectionGroup(e,n,r,i){let s=new it((c,h)=>c-h);const o=this.overlays.getIterator();for(;o.hasNext();){const c=o.getNext().value;if(c.getKey().getCollectionGroup()===n&&c.largestBatchId>r){let h=s.get(c.largestBatchId);h===null&&(h=Ni(),s=s.insert(c.largestBatchId,h)),h.set(c.getKey(),c)}}const a=Ni(),u=s.getIterator();for(;u.hasNext()&&(u.getNext().value.forEach((c,h)=>a.set(c,h)),!(a.size()>=i)););return j.resolve(a)}ht(e,n,r){const i=this.overlays.get(r.key);if(i!==null){const o=this.Ir.get(i.largestBatchId).delete(r.key);this.Ir.set(i.largestBatchId,o)}this.overlays=this.overlays.insert(r.key,new Vb(n,r));let s=this.Ir.get(n);s===void 0&&(s=pe(),this.Ir.set(n,s)),this.Ir.set(n,s.add(r.key))}}/**
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
 */class gN{constructor(){this.sessionToken=Ct.EMPTY_BYTE_STRING}getSessionToken(e){return j.resolve(this.sessionToken)}setSessionToken(e,n){return this.sessionToken=n,j.resolve()}}/**
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
 */class Ym{constructor(){this.Tr=new St(dt.Er),this.dr=new St(dt.Ar)}isEmpty(){return this.Tr.isEmpty()}addReference(e,n){const r=new dt(e,n);this.Tr=this.Tr.add(r),this.dr=this.dr.add(r)}Rr(e,n){e.forEach(r=>this.addReference(r,n))}removeReference(e,n){this.Vr(new dt(e,n))}mr(e,n){e.forEach(r=>this.removeReference(r,n))}gr(e){const n=new ee(new Ve([])),r=new dt(n,e),i=new dt(n,e+1),s=[];return this.dr.forEachInRange([r,i],o=>{this.Vr(o),s.push(o.key)}),s}pr(){this.Tr.forEach(e=>this.Vr(e))}Vr(e){this.Tr=this.Tr.delete(e),this.dr=this.dr.delete(e)}yr(e){const n=new ee(new Ve([])),r=new dt(n,e),i=new dt(n,e+1);let s=pe();return this.dr.forEachInRange([r,i],o=>{s=s.add(o.key)}),s}containsKey(e){const n=new dt(e,0),r=this.Tr.firstAfterOrEqual(n);return r!==null&&e.isEqual(r.key)}}class dt{constructor(e,n){this.key=e,this.wr=n}static Er(e,n){return ee.comparator(e.key,n.key)||we(e.wr,n.wr)}static Ar(e,n){return we(e.wr,n.wr)||ee.comparator(e.key,n.key)}}/**
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
 */class _N{constructor(e,n){this.indexManager=e,this.referenceDelegate=n,this.mutationQueue=[],this.Sr=1,this.br=new St(dt.Er)}checkEmpty(e){return j.resolve(this.mutationQueue.length===0)}addMutationBatch(e,n,r,i){const s=this.Sr;this.Sr++,this.mutationQueue.length>0&&this.mutationQueue[this.mutationQueue.length-1];const o=new Fb(s,n,r,i);this.mutationQueue.push(o);for(const a of i)this.br=this.br.add(new dt(a.key,s)),this.indexManager.addToCollectionParentIndex(e,a.key.path.popLast());return j.resolve(o)}lookupMutationBatch(e,n){return j.resolve(this.Dr(n))}getNextMutationBatchAfterBatchId(e,n){const r=n+1,i=this.vr(r),s=i<0?0:i;return j.resolve(this.mutationQueue.length>s?this.mutationQueue[s]:null)}getHighestUnacknowledgedBatchId(){return j.resolve(this.mutationQueue.length===0?-1:this.Sr-1)}getAllMutationBatches(e){return j.resolve(this.mutationQueue.slice())}getAllMutationBatchesAffectingDocumentKey(e,n){const r=new dt(n,0),i=new dt(n,Number.POSITIVE_INFINITY),s=[];return this.br.forEachInRange([r,i],o=>{const a=this.Dr(o.wr);s.push(a)}),j.resolve(s)}getAllMutationBatchesAffectingDocumentKeys(e,n){let r=new St(we);return n.forEach(i=>{const s=new dt(i,0),o=new dt(i,Number.POSITIVE_INFINITY);this.br.forEachInRange([s,o],a=>{r=r.add(a.wr)})}),j.resolve(this.Cr(r))}getAllMutationBatchesAffectingQuery(e,n){const r=n.path,i=r.length+1;let s=r;ee.isDocumentKey(s)||(s=s.child(""));const o=new dt(new ee(s),0);let a=new St(we);return this.br.forEachWhile(u=>{const c=u.key.path;return!!r.isPrefixOf(c)&&(c.length===i&&(a=a.add(u.wr)),!0)},o),j.resolve(this.Cr(a))}Cr(e){const n=[];return e.forEach(r=>{const i=this.Dr(r);i!==null&&n.push(i)}),n}removeMutationBatch(e,n){ke(this.Fr(n.batchId,"removed")===0),this.mutationQueue.shift();let r=this.br;return j.forEach(n.mutations,i=>{const s=new dt(i.key,n.batchId);return r=r.delete(s),this.referenceDelegate.markPotentiallyOrphaned(e,i.key)}).next(()=>{this.br=r})}On(e){}containsKey(e,n){const r=new dt(n,0),i=this.br.firstAfterOrEqual(r);return j.resolve(n.isEqual(i&&i.key))}performConsistencyCheck(e){return this.mutationQueue.length,j.resolve()}Fr(e,n){return this.vr(e)}vr(e){return this.mutationQueue.length===0?0:e-this.mutationQueue[0].batchId}Dr(e){const n=this.vr(e);return n<0||n>=this.mutationQueue.length?null:this.mutationQueue[n]}}/**
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
 */class yN{constructor(e){this.Mr=e,this.docs=function(){return new it(ee.comparator)}(),this.size=0}setIndexManager(e){this.indexManager=e}addEntry(e,n){const r=n.key,i=this.docs.get(r),s=i?i.size:0,o=this.Mr(n);return this.docs=this.docs.insert(r,{document:n.mutableCopy(),size:o}),this.size+=o-s,this.indexManager.addToCollectionParentIndex(e,r.path.popLast())}removeEntry(e){const n=this.docs.get(e);n&&(this.docs=this.docs.remove(e),this.size-=n.size)}getEntry(e,n){const r=this.docs.get(n);return j.resolve(r?r.document.mutableCopy():Ot.newInvalidDocument(n))}getEntries(e,n){let r=Tr();return n.forEach(i=>{const s=this.docs.get(i);r=r.insert(i,s?s.document.mutableCopy():Ot.newInvalidDocument(i))}),j.resolve(r)}getDocumentsMatchingQuery(e,n,r,i){let s=Tr();const o=n.path,a=new ee(o.child("")),u=this.docs.getIteratorFrom(a);for(;u.hasNext();){const{key:c,value:{document:h}}=u.getNext();if(!o.isPrefixOf(c.path))break;c.path.length>o.length+1||eb(ZP(h),r)<=0||(i.has(h.key)||wh(n,h))&&(s=s.insert(h.key,h.mutableCopy()))}return j.resolve(s)}getAllFromCollectionGroup(e,n,r,i){oe()}Or(e,n){return j.forEach(this.docs,r=>n(r))}newChangeBuffer(e){return new vN(this)}getSize(e){return j.resolve(this.size)}}class vN extends hN{constructor(e){super(),this.cr=e}applyChanges(e){const n=[];return this.changes.forEach((r,i)=>{i.isValidDocument()?n.push(this.cr.addEntry(e,i)):this.cr.removeEntry(r)}),j.waitFor(n)}getFromCache(e,n){return this.cr.getEntry(e,n)}getAllFromCache(e,n){return this.cr.getEntries(e,n)}}/**
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
 */class wN{constructor(e){this.persistence=e,this.Nr=new Eo(n=>$m(n),Wm),this.lastRemoteSnapshotVersion=ae.min(),this.highestTargetId=0,this.Lr=0,this.Br=new Ym,this.targetCount=0,this.kr=ao.Bn()}forEachTarget(e,n){return this.Nr.forEach((r,i)=>n(i)),j.resolve()}getLastRemoteSnapshotVersion(e){return j.resolve(this.lastRemoteSnapshotVersion)}getHighestSequenceNumber(e){return j.resolve(this.Lr)}allocateTargetId(e){return this.highestTargetId=this.kr.next(),j.resolve(this.highestTargetId)}setTargetsMetadata(e,n,r){return r&&(this.lastRemoteSnapshotVersion=r),n>this.Lr&&(this.Lr=n),j.resolve()}Kn(e){this.Nr.set(e.target,e);const n=e.targetId;n>this.highestTargetId&&(this.kr=new ao(n),this.highestTargetId=n),e.sequenceNumber>this.Lr&&(this.Lr=e.sequenceNumber)}addTargetData(e,n){return this.Kn(n),this.targetCount+=1,j.resolve()}updateTargetData(e,n){return this.Kn(n),j.resolve()}removeTargetData(e,n){return this.Nr.delete(n.target),this.Br.gr(n.targetId),this.targetCount-=1,j.resolve()}removeTargets(e,n,r){let i=0;const s=[];return this.Nr.forEach((o,a)=>{a.sequenceNumber<=n&&r.get(a.targetId)===null&&(this.Nr.delete(o),s.push(this.removeMatchingKeysForTargetId(e,a.targetId)),i++)}),j.waitFor(s).next(()=>i)}getTargetCount(e){return j.resolve(this.targetCount)}getTargetData(e,n){const r=this.Nr.get(n)||null;return j.resolve(r)}addMatchingKeys(e,n,r){return this.Br.Rr(n,r),j.resolve()}removeMatchingKeys(e,n,r){this.Br.mr(n,r);const i=this.persistence.referenceDelegate,s=[];return i&&n.forEach(o=>{s.push(i.markPotentiallyOrphaned(e,o))}),j.waitFor(s)}removeMatchingKeysForTargetId(e,n){return this.Br.gr(n),j.resolve()}getMatchingKeysForTargetId(e,n){const r=this.Br.yr(n);return j.resolve(r)}containsKey(e,n){return j.resolve(this.Br.containsKey(n))}}/**
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
 */class EN{constructor(e,n){this.qr={},this.overlays={},this.Qr=new Um(0),this.Kr=!1,this.Kr=!0,this.$r=new gN,this.referenceDelegate=e(this),this.Ur=new wN(this),this.indexManager=new uN,this.remoteDocumentCache=function(i){return new yN(i)}(r=>this.referenceDelegate.Wr(r)),this.serializer=new aN(n),this.Gr=new pN(this.serializer)}start(){return Promise.resolve()}shutdown(){return this.Kr=!1,Promise.resolve()}get started(){return this.Kr}setDatabaseDeletedListener(){}setNetworkEnabled(){}getIndexManager(e){return this.indexManager}getDocumentOverlayCache(e){let n=this.overlays[e.toKey()];return n||(n=new mN,this.overlays[e.toKey()]=n),n}getMutationQueue(e,n){let r=this.qr[e.toKey()];return r||(r=new _N(n,this.referenceDelegate),this.qr[e.toKey()]=r),r}getGlobalsCache(){return this.$r}getTargetCache(){return this.Ur}getRemoteDocumentCache(){return this.remoteDocumentCache}getBundleCache(){return this.Gr}runTransaction(e,n,r){J("MemoryPersistence","Starting transaction:",e);const i=new TN(this.Qr.next());return this.referenceDelegate.zr(),r(i).next(s=>this.referenceDelegate.jr(i).next(()=>s)).toPromise().then(s=>(i.raiseOnCommittedEvent(),s))}Hr(e,n){return j.or(Object.values(this.qr).map(r=>()=>r.containsKey(e,n)))}}class TN extends nb{constructor(e){super(),this.currentSequenceNumber=e}}class Xm{constructor(e){this.persistence=e,this.Jr=new Ym,this.Yr=null}static Zr(e){return new Xm(e)}get Xr(){if(this.Yr)return this.Yr;throw oe()}addReference(e,n,r){return this.Jr.addReference(r,n),this.Xr.delete(r.toString()),j.resolve()}removeReference(e,n,r){return this.Jr.removeReference(r,n),this.Xr.add(r.toString()),j.resolve()}markPotentiallyOrphaned(e,n){return this.Xr.add(n.toString()),j.resolve()}removeTarget(e,n){this.Jr.gr(n.targetId).forEach(i=>this.Xr.add(i.toString()));const r=this.persistence.getTargetCache();return r.getMatchingKeysForTargetId(e,n.targetId).next(i=>{i.forEach(s=>this.Xr.add(s.toString()))}).next(()=>r.removeTargetData(e,n))}zr(){this.Yr=new Set}jr(e){const n=this.persistence.getRemoteDocumentCache().newChangeBuffer();return j.forEach(this.Xr,r=>{const i=ee.fromPath(r);return this.ei(e,i).next(s=>{s||n.removeEntry(i,ae.min())})}).next(()=>(this.Yr=null,n.apply(e)))}updateLimboDocument(e,n){return this.ei(e,n).next(r=>{r?this.Xr.delete(n.toString()):this.Xr.add(n.toString())})}Wr(e){return 0}ei(e,n){return j.or([()=>j.resolve(this.Jr.containsKey(n)),()=>this.persistence.getTargetCache().containsKey(e,n),()=>this.persistence.Hr(e,n)])}}/**
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
 */class Jm{constructor(e,n,r,i){this.targetId=e,this.fromCache=n,this.$i=r,this.Ui=i}static Wi(e,n){let r=pe(),i=pe();for(const s of n.docChanges)switch(s.type){case 0:r=r.add(s.doc.key);break;case 1:i=i.add(s.doc.key)}return new Jm(e,n.fromCache,r,i)}}/**
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
 */class IN{constructor(){this._documentReadCount=0}get documentReadCount(){return this._documentReadCount}incrementDocumentReadCount(e){this._documentReadCount+=e}}/**
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
 */class SN{constructor(){this.Gi=!1,this.zi=!1,this.ji=100,this.Hi=function(){return EA()?8:rb(Vt())>0?6:4}()}initialize(e,n){this.Ji=e,this.indexManager=n,this.Gi=!0}getDocumentsMatchingQuery(e,n,r,i){const s={result:null};return this.Yi(e,n).next(o=>{s.result=o}).next(()=>{if(!s.result)return this.Zi(e,n,i,r).next(o=>{s.result=o})}).next(()=>{if(s.result)return;const o=new IN;return this.Xi(e,n,o).next(a=>{if(s.result=a,this.zi)return this.es(e,n,o,a.size)})}).next(()=>s.result)}es(e,n,r,i){return r.documentReadCount<this.ji?(Jo()<=de.DEBUG&&J("QueryEngine","SDK will not create cache indexes for query:",_s(n),"since it only creates cache indexes for collection contains","more than or equal to",this.ji,"documents"),j.resolve()):(Jo()<=de.DEBUG&&J("QueryEngine","Query:",_s(n),"scans",r.documentReadCount,"local documents and returns",i,"documents as results."),r.documentReadCount>this.Hi*i?(Jo()<=de.DEBUG&&J("QueryEngine","The SDK decides to create cache indexes for query:",_s(n),"as using cache indexes may help improve performance."),this.indexManager.createTargetIndexes(e,Gn(n))):j.resolve())}Yi(e,n){if(Vv(n))return j.resolve(null);let r=Gn(n);return this.indexManager.getIndexType(e,r).next(i=>i===0?null:(n.limit!==null&&i===1&&(n=up(n,null,"F"),r=Gn(n)),this.indexManager.getDocumentsMatchingTarget(e,r).next(s=>{const o=pe(...s);return this.Ji.getDocuments(e,o).next(a=>this.indexManager.getMinOffset(e,r).next(u=>{const c=this.ts(n,a);return this.ns(n,c,o,u.readTime)?this.Yi(e,up(n,null,"F")):this.rs(e,c,n,u)}))})))}Zi(e,n,r,i){return Vv(n)||i.isEqual(ae.min())?j.resolve(null):this.Ji.getDocuments(e,r).next(s=>{const o=this.ts(n,s);return this.ns(n,o,r,i)?j.resolve(null):(Jo()<=de.DEBUG&&J("QueryEngine","Re-using previous result from %s to execute query: %s",i.toString(),_s(n)),this.rs(e,o,n,JP(i,-1)).next(a=>a))})}ts(e,n){let r=new St(wI(e));return n.forEach((i,s)=>{wh(e,s)&&(r=r.add(s))}),r}ns(e,n,r,i){if(e.limit===null)return!1;if(r.size!==n.size)return!0;const s=e.limitType==="F"?n.last():n.first();return!!s&&(s.hasPendingWrites||s.version.compareTo(i)>0)}Xi(e,n,r){return Jo()<=de.DEBUG&&J("QueryEngine","Using full collection scan to execute query:",_s(n)),this.Ji.getDocumentsMatchingQuery(e,n,ci.min(),r)}rs(e,n,r,i){return this.Ji.getDocumentsMatchingQuery(e,r,i).next(s=>(n.forEach(o=>{s=s.insert(o.key,o)}),s))}}/**
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
 */class kN{constructor(e,n,r,i){this.persistence=e,this.ss=n,this.serializer=i,this.os=new it(we),this._s=new Eo(s=>$m(s),Wm),this.us=new Map,this.cs=e.getRemoteDocumentCache(),this.Ur=e.getTargetCache(),this.Gr=e.getBundleCache(),this.ls(r)}ls(e){this.documentOverlayCache=this.persistence.getDocumentOverlayCache(e),this.indexManager=this.persistence.getIndexManager(e),this.mutationQueue=this.persistence.getMutationQueue(e,this.indexManager),this.localDocuments=new fN(this.cs,this.mutationQueue,this.documentOverlayCache,this.indexManager),this.cs.setIndexManager(this.indexManager),this.ss.initialize(this.localDocuments,this.indexManager)}collectGarbage(e){return this.persistence.runTransaction("Collect garbage","readwrite-primary",n=>e.collect(n,this.os))}}function CN(t,e,n,r){return new kN(t,e,n,r)}async function zI(t,e){const n=le(t);return await n.persistence.runTransaction("Handle user change","readonly",r=>{let i;return n.mutationQueue.getAllMutationBatches(r).next(s=>(i=s,n.ls(e),n.mutationQueue.getAllMutationBatches(r))).next(s=>{const o=[],a=[];let u=pe();for(const c of i){o.push(c.batchId);for(const h of c.mutations)u=u.add(h.key)}for(const c of s){a.push(c.batchId);for(const h of c.mutations)u=u.add(h.key)}return n.localDocuments.getDocuments(r,u).next(c=>({hs:c,removedBatchIds:o,addedBatchIds:a}))})})}function RN(t,e){const n=le(t);return n.persistence.runTransaction("Acknowledge batch","readwrite-primary",r=>{const i=e.batch.keys(),s=n.cs.newChangeBuffer({trackRemovals:!0});return function(a,u,c,h){const f=c.batch,m=f.keys();let w=j.resolve();return m.forEach(S=>{w=w.next(()=>h.getEntry(u,S)).next(P=>{const D=c.docVersions.get(S);ke(D!==null),P.version.compareTo(D)<0&&(f.applyToRemoteDocument(P,c),P.isValidDocument()&&(P.setReadTime(c.commitVersion),h.addEntry(P)))})}),w.next(()=>a.mutationQueue.removeMutationBatch(u,f))}(n,r,e,s).next(()=>s.apply(r)).next(()=>n.mutationQueue.performConsistencyCheck(r)).next(()=>n.documentOverlayCache.removeOverlaysForBatchId(r,i,e.batch.batchId)).next(()=>n.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(r,function(a){let u=pe();for(let c=0;c<a.mutationResults.length;++c)a.mutationResults[c].transformResults.length>0&&(u=u.add(a.batch.mutations[c].key));return u}(e))).next(()=>n.localDocuments.getDocuments(r,i))})}function BI(t){const e=le(t);return e.persistence.runTransaction("Get last remote snapshot version","readonly",n=>e.Ur.getLastRemoteSnapshotVersion(n))}function xN(t,e){const n=le(t),r=e.snapshotVersion;let i=n.os;return n.persistence.runTransaction("Apply remote event","readwrite-primary",s=>{const o=n.cs.newChangeBuffer({trackRemovals:!0});i=n.os;const a=[];e.targetChanges.forEach((h,f)=>{const m=i.get(f);if(!m)return;a.push(n.Ur.removeMatchingKeys(s,h.removedDocuments,f).next(()=>n.Ur.addMatchingKeys(s,h.addedDocuments,f)));let w=m.withSequenceNumber(s.currentSequenceNumber);e.targetMismatches.get(f)!==null?w=w.withResumeToken(Ct.EMPTY_BYTE_STRING,ae.min()).withLastLimboFreeSnapshotVersion(ae.min()):h.resumeToken.approximateByteSize()>0&&(w=w.withResumeToken(h.resumeToken,r)),i=i.insert(f,w),function(P,D,k){return P.resumeToken.approximateByteSize()===0||D.snapshotVersion.toMicroseconds()-P.snapshotVersion.toMicroseconds()>=3e8?!0:k.addedDocuments.size+k.modifiedDocuments.size+k.removedDocuments.size>0}(m,w,h)&&a.push(n.Ur.updateTargetData(s,w))});let u=Tr(),c=pe();if(e.documentUpdates.forEach(h=>{e.resolvedLimboDocuments.has(h)&&a.push(n.persistence.referenceDelegate.updateLimboDocument(s,h))}),a.push(AN(s,o,e.documentUpdates).next(h=>{u=h.Ps,c=h.Is})),!r.isEqual(ae.min())){const h=n.Ur.getLastRemoteSnapshotVersion(s).next(f=>n.Ur.setTargetsMetadata(s,s.currentSequenceNumber,r));a.push(h)}return j.waitFor(a).next(()=>o.apply(s)).next(()=>n.localDocuments.getLocalViewOfDocuments(s,u,c)).next(()=>u)}).then(s=>(n.os=i,s))}function AN(t,e,n){let r=pe(),i=pe();return n.forEach(s=>r=r.add(s)),e.getEntries(t,r).next(s=>{let o=Tr();return n.forEach((a,u)=>{const c=s.get(a);u.isFoundDocument()!==c.isFoundDocument()&&(i=i.add(a)),u.isNoDocument()&&u.version.isEqual(ae.min())?(e.removeEntry(a,u.readTime),o=o.insert(a,u)):!c.isValidDocument()||u.version.compareTo(c.version)>0||u.version.compareTo(c.version)===0&&c.hasPendingWrites?(e.addEntry(u),o=o.insert(a,u)):J("LocalStore","Ignoring outdated watch update for ",a,". Current version:",c.version," Watch version:",u.version)}),{Ps:o,Is:i}})}function PN(t,e){const n=le(t);return n.persistence.runTransaction("Get next mutation batch","readonly",r=>(e===void 0&&(e=-1),n.mutationQueue.getNextMutationBatchAfterBatchId(r,e)))}function bN(t,e){const n=le(t);return n.persistence.runTransaction("Allocate target","readwrite",r=>{let i;return n.Ur.getTargetData(r,e).next(s=>s?(i=s,j.resolve(i)):n.Ur.allocateTargetId(r).next(o=>(i=new qr(e,o,"TargetPurposeListen",r.currentSequenceNumber),n.Ur.addTargetData(r,i).next(()=>i))))}).then(r=>{const i=n.os.get(r.targetId);return(i===null||r.snapshotVersion.compareTo(i.snapshotVersion)>0)&&(n.os=n.os.insert(r.targetId,r),n._s.set(e,r.targetId)),r})}async function pp(t,e,n){const r=le(t),i=r.os.get(e),s=n?"readwrite":"readwrite-primary";try{n||await r.persistence.runTransaction("Release target",s,o=>r.persistence.referenceDelegate.removeTarget(o,i))}catch(o){if(!El(o))throw o;J("LocalStore",`Failed to update sequence numbers for target ${e}: ${o}`)}r.os=r.os.remove(e),r._s.delete(i.target)}function Qv(t,e,n){const r=le(t);let i=ae.min(),s=pe();return r.persistence.runTransaction("Execute query","readwrite",o=>function(u,c,h){const f=le(u),m=f._s.get(h);return m!==void 0?j.resolve(f.os.get(m)):f.Ur.getTargetData(c,h)}(r,o,Gn(e)).next(a=>{if(a)return i=a.lastLimboFreeSnapshotVersion,r.Ur.getMatchingKeysForTargetId(o,a.targetId).next(u=>{s=u})}).next(()=>r.ss.getDocumentsMatchingQuery(o,e,n?i:ae.min(),n?s:pe())).next(a=>(NN(r,Eb(e),a),{documents:a,Ts:s})))}function NN(t,e,n){let r=t.us.get(e)||ae.min();n.forEach((i,s)=>{s.readTime.compareTo(r)>0&&(r=s.readTime)}),t.us.set(e,r)}class Yv{constructor(){this.activeTargetIds=Rb()}fs(e){this.activeTargetIds=this.activeTargetIds.add(e)}gs(e){this.activeTargetIds=this.activeTargetIds.delete(e)}Vs(){const e={activeTargetIds:this.activeTargetIds.toArray(),updateTimeMs:Date.now()};return JSON.stringify(e)}}class DN{constructor(){this.so=new Yv,this.oo={},this.onlineStateHandler=null,this.sequenceNumberHandler=null}addPendingMutation(e){}updateMutationState(e,n,r){}addLocalQueryTarget(e,n=!0){return n&&this.so.fs(e),this.oo[e]||"not-current"}updateQueryState(e,n,r){this.oo[e]=n}removeLocalQueryTarget(e){this.so.gs(e)}isLocalQueryTarget(e){return this.so.activeTargetIds.has(e)}clearQueryState(e){delete this.oo[e]}getAllActiveQueryTargets(){return this.so.activeTargetIds}isActiveQueryTarget(e){return this.so.activeTargetIds.has(e)}start(){return this.so=new Yv,Promise.resolve()}handleUserChange(e,n,r){}setOnlineState(e){}shutdown(){}writeSequenceNumber(e){}notifyBundleLoaded(e){}}/**
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
 */class ON{_o(e){}shutdown(){}}/**
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
 */class Xv{constructor(){this.ao=()=>this.uo(),this.co=()=>this.lo(),this.ho=[],this.Po()}_o(e){this.ho.push(e)}shutdown(){window.removeEventListener("online",this.ao),window.removeEventListener("offline",this.co)}Po(){window.addEventListener("online",this.ao),window.addEventListener("offline",this.co)}uo(){J("ConnectivityMonitor","Network connectivity changed: AVAILABLE");for(const e of this.ho)e(0)}lo(){J("ConnectivityMonitor","Network connectivity changed: UNAVAILABLE");for(const e of this.ho)e(1)}static D(){return typeof window<"u"&&window.addEventListener!==void 0&&window.removeEventListener!==void 0}}/**
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
 */let wu=null;function Vd(){return wu===null?wu=function(){return 268435456+Math.round(2147483648*Math.random())}():wu++,"0x"+wu.toString(16)}/**
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
 */const MN={BatchGetDocuments:"batchGet",Commit:"commit",RunQuery:"runQuery",RunAggregationQuery:"runAggregationQuery"};/**
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
 */class LN{constructor(e){this.Io=e.Io,this.To=e.To}Eo(e){this.Ao=e}Ro(e){this.Vo=e}mo(e){this.fo=e}onMessage(e){this.po=e}close(){this.To()}send(e){this.Io(e)}yo(){this.Ao()}wo(){this.Vo()}So(e){this.fo(e)}bo(e){this.po(e)}}/**
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
 */const bt="WebChannelConnection";class FN extends class{constructor(n){this.databaseInfo=n,this.databaseId=n.databaseId;const r=n.ssl?"https":"http",i=encodeURIComponent(this.databaseId.projectId),s=encodeURIComponent(this.databaseId.database);this.Do=r+"://"+n.host,this.vo=`projects/${i}/databases/${s}`,this.Co=this.databaseId.database==="(default)"?`project_id=${i}`:`project_id=${i}&database_id=${s}`}get Fo(){return!1}Mo(n,r,i,s,o){const a=Vd(),u=this.xo(n,r.toUriEncodedString());J("RestConnection",`Sending RPC '${n}' ${a}:`,u,i);const c={"google-cloud-resource-prefix":this.vo,"x-goog-request-params":this.Co};return this.Oo(c,s,o),this.No(n,u,c,i).then(h=>(J("RestConnection",`Received RPC '${n}' ${a}: `,h),h),h=>{throw ro("RestConnection",`RPC '${n}' ${a} failed with error: `,h,"url: ",u,"request:",i),h})}Lo(n,r,i,s,o,a){return this.Mo(n,r,i,s,o)}Oo(n,r,i){n["X-Goog-Api-Client"]=function(){return"gl-js/ fire/"+yo}(),n["Content-Type"]="text/plain",this.databaseInfo.appId&&(n["X-Firebase-GMPID"]=this.databaseInfo.appId),r&&r.headers.forEach((s,o)=>n[o]=s),i&&i.headers.forEach((s,o)=>n[o]=s)}xo(n,r){const i=MN[n];return`${this.Do}/v1/${r}:${i}`}terminate(){}}{constructor(e){super(e),this.forceLongPolling=e.forceLongPolling,this.autoDetectLongPolling=e.autoDetectLongPolling,this.useFetchStreams=e.useFetchStreams,this.longPollingOptions=e.longPollingOptions}No(e,n,r,i){const s=Vd();return new Promise((o,a)=>{const u=new tI;u.setWithCredentials(!0),u.listenOnce(nI.COMPLETE,()=>{try{switch(u.getLastErrorCode()){case zu.NO_ERROR:const h=u.getResponseJson();J(bt,`XHR for RPC '${e}' ${s} received:`,JSON.stringify(h)),o(h);break;case zu.TIMEOUT:J(bt,`RPC '${e}' ${s} timed out`),a(new X(V.DEADLINE_EXCEEDED,"Request time out"));break;case zu.HTTP_ERROR:const f=u.getStatus();if(J(bt,`RPC '${e}' ${s} failed with status:`,f,"response text:",u.getResponseText()),f>0){let m=u.getResponseJson();Array.isArray(m)&&(m=m[0]);const w=m==null?void 0:m.error;if(w&&w.status&&w.message){const S=function(D){const k=D.toLowerCase().replace(/_/g,"-");return Object.values(V).indexOf(k)>=0?k:V.UNKNOWN}(w.status);a(new X(S,w.message))}else a(new X(V.UNKNOWN,"Server responded with status "+u.getStatus()))}else a(new X(V.UNAVAILABLE,"Connection failed."));break;default:oe()}}finally{J(bt,`RPC '${e}' ${s} completed.`)}});const c=JSON.stringify(i);J(bt,`RPC '${e}' ${s} sending request:`,i),u.send(n,"POST",c,r,15)})}Bo(e,n,r){const i=Vd(),s=[this.Do,"/","google.firestore.v1.Firestore","/",e,"/channel"],o=sI(),a=iI(),u={httpSessionIdParam:"gsessionid",initMessageHeaders:{},messageUrlParams:{database:`projects/${this.databaseId.projectId}/databases/${this.databaseId.database}`},sendRawJson:!0,supportsCrossDomainXhr:!0,internalChannelParams:{forwardChannelRequestTimeoutMs:6e5},forceLongPolling:this.forceLongPolling,detectBufferingProxy:this.autoDetectLongPolling},c=this.longPollingOptions.timeoutSeconds;c!==void 0&&(u.longPollingTimeout=Math.round(1e3*c)),this.useFetchStreams&&(u.useFetchStreams=!0),this.Oo(u.initMessageHeaders,n,r),u.encodeInitMessageHeaders=!0;const h=s.join("");J(bt,`Creating RPC '${e}' stream ${i}: ${h}`,u);const f=o.createWebChannel(h,u);let m=!1,w=!1;const S=new LN({Io:D=>{w?J(bt,`Not sending because RPC '${e}' stream ${i} is closed:`,D):(m||(J(bt,`Opening RPC '${e}' stream ${i} transport.`),f.open(),m=!0),J(bt,`RPC '${e}' stream ${i} sending:`,D),f.send(D))},To:()=>f.close()}),P=(D,k,T)=>{D.listen(k,R=>{try{T(R)}catch(M){setTimeout(()=>{throw M},0)}})};return P(f,ha.EventType.OPEN,()=>{w||(J(bt,`RPC '${e}' stream ${i} transport opened.`),S.yo())}),P(f,ha.EventType.CLOSE,()=>{w||(w=!0,J(bt,`RPC '${e}' stream ${i} transport closed`),S.So())}),P(f,ha.EventType.ERROR,D=>{w||(w=!0,ro(bt,`RPC '${e}' stream ${i} transport errored:`,D),S.So(new X(V.UNAVAILABLE,"The operation could not be completed")))}),P(f,ha.EventType.MESSAGE,D=>{var k;if(!w){const T=D.data[0];ke(!!T);const R=T,M=R.error||((k=R[0])===null||k===void 0?void 0:k.error);if(M){J(bt,`RPC '${e}' stream ${i} received error:`,M);const z=M.status;let U=function(E){const I=tt[E];if(I!==void 0)return bI(I)}(z),v=M.message;U===void 0&&(U=V.INTERNAL,v="Unknown error status: "+z+" with message "+M.message),w=!0,S.So(new X(U,v)),f.close()}else J(bt,`RPC '${e}' stream ${i} received:`,T),S.bo(T)}}),P(a,rI.STAT_EVENT,D=>{D.stat===np.PROXY?J(bt,`RPC '${e}' stream ${i} detected buffering proxy`):D.stat===np.NOPROXY&&J(bt,`RPC '${e}' stream ${i} detected no buffering proxy`)}),setTimeout(()=>{S.wo()},0),S}}function Ud(){return typeof document<"u"?document:null}/**
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
 */function Sh(t){return new Gb(t,!0)}/**
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
 */class $I{constructor(e,n,r=1e3,i=1.5,s=6e4){this.ui=e,this.timerId=n,this.ko=r,this.qo=i,this.Qo=s,this.Ko=0,this.$o=null,this.Uo=Date.now(),this.reset()}reset(){this.Ko=0}Wo(){this.Ko=this.Qo}Go(e){this.cancel();const n=Math.floor(this.Ko+this.zo()),r=Math.max(0,Date.now()-this.Uo),i=Math.max(0,n-r);i>0&&J("ExponentialBackoff",`Backing off for ${i} ms (base delay: ${this.Ko} ms, delay with jitter: ${n} ms, last attempt: ${r} ms ago)`),this.$o=this.ui.enqueueAfterDelay(this.timerId,i,()=>(this.Uo=Date.now(),e())),this.Ko*=this.qo,this.Ko<this.ko&&(this.Ko=this.ko),this.Ko>this.Qo&&(this.Ko=this.Qo)}jo(){this.$o!==null&&(this.$o.skipDelay(),this.$o=null)}cancel(){this.$o!==null&&(this.$o.cancel(),this.$o=null)}zo(){return(Math.random()-.5)*this.Ko}}/**
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
 */class WI{constructor(e,n,r,i,s,o,a,u){this.ui=e,this.Ho=r,this.Jo=i,this.connection=s,this.authCredentialsProvider=o,this.appCheckCredentialsProvider=a,this.listener=u,this.state=0,this.Yo=0,this.Zo=null,this.Xo=null,this.stream=null,this.e_=0,this.t_=new $I(e,n)}n_(){return this.state===1||this.state===5||this.r_()}r_(){return this.state===2||this.state===3}start(){this.e_=0,this.state!==4?this.auth():this.i_()}async stop(){this.n_()&&await this.close(0)}s_(){this.state=0,this.t_.reset()}o_(){this.r_()&&this.Zo===null&&(this.Zo=this.ui.enqueueAfterDelay(this.Ho,6e4,()=>this.__()))}a_(e){this.u_(),this.stream.send(e)}async __(){if(this.r_())return this.close(0)}u_(){this.Zo&&(this.Zo.cancel(),this.Zo=null)}c_(){this.Xo&&(this.Xo.cancel(),this.Xo=null)}async close(e,n){this.u_(),this.c_(),this.t_.cancel(),this.Yo++,e!==4?this.t_.reset():n&&n.code===V.RESOURCE_EXHAUSTED?(Er(n.toString()),Er("Using maximum backoff delay to prevent overloading the backend."),this.t_.Wo()):n&&n.code===V.UNAUTHENTICATED&&this.state!==3&&(this.authCredentialsProvider.invalidateToken(),this.appCheckCredentialsProvider.invalidateToken()),this.stream!==null&&(this.l_(),this.stream.close(),this.stream=null),this.state=e,await this.listener.mo(n)}l_(){}auth(){this.state=1;const e=this.h_(this.Yo),n=this.Yo;Promise.all([this.authCredentialsProvider.getToken(),this.appCheckCredentialsProvider.getToken()]).then(([r,i])=>{this.Yo===n&&this.P_(r,i)},r=>{e(()=>{const i=new X(V.UNKNOWN,"Fetching auth token failed: "+r.message);return this.I_(i)})})}P_(e,n){const r=this.h_(this.Yo);this.stream=this.T_(e,n),this.stream.Eo(()=>{r(()=>this.listener.Eo())}),this.stream.Ro(()=>{r(()=>(this.state=2,this.Xo=this.ui.enqueueAfterDelay(this.Jo,1e4,()=>(this.r_()&&(this.state=3),Promise.resolve())),this.listener.Ro()))}),this.stream.mo(i=>{r(()=>this.I_(i))}),this.stream.onMessage(i=>{r(()=>++this.e_==1?this.E_(i):this.onNext(i))})}i_(){this.state=5,this.t_.Go(async()=>{this.state=0,this.start()})}I_(e){return J("PersistentStream",`close with error: ${e}`),this.stream=null,this.close(4,e)}h_(e){return n=>{this.ui.enqueueAndForget(()=>this.Yo===e?n():(J("PersistentStream","stream callback skipped by getCloseGuardedDispatcher."),Promise.resolve()))}}}class VN extends WI{constructor(e,n,r,i,s,o){super(e,"listen_stream_connection_backoff","listen_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}T_(e,n){return this.connection.Bo("Listen",e,n)}E_(e){return this.onNext(e)}onNext(e){this.t_.reset();const n=Yb(this.serializer,e),r=function(s){if(!("targetChange"in s))return ae.min();const o=s.targetChange;return o.targetIds&&o.targetIds.length?ae.min():o.readTime?Qn(o.readTime):ae.min()}(e);return this.listener.d_(n,r)}A_(e){const n={};n.database=fp(this.serializer),n.addTarget=function(s,o){let a;const u=o.target;if(a=ap(u)?{documents:Zb(s,u)}:{query:eN(s,u)._t},a.targetId=o.targetId,o.resumeToken.approximateByteSize()>0){a.resumeToken=OI(s,o.resumeToken);const c=cp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}else if(o.snapshotVersion.compareTo(ae.min())>0){a.readTime=Pc(s,o.snapshotVersion.toTimestamp());const c=cp(s,o.expectedCount);c!==null&&(a.expectedCount=c)}return a}(this.serializer,e);const r=nN(this.serializer,e);r&&(n.labels=r),this.a_(n)}R_(e){const n={};n.database=fp(this.serializer),n.removeTarget=e,this.a_(n)}}class UN extends WI{constructor(e,n,r,i,s,o){super(e,"write_stream_connection_backoff","write_stream_idle","health_check_timeout",n,r,i,o),this.serializer=s}get V_(){return this.e_>0}start(){this.lastStreamToken=void 0,super.start()}l_(){this.V_&&this.m_([])}T_(e,n){return this.connection.Bo("Write",e,n)}E_(e){return ke(!!e.streamToken),this.lastStreamToken=e.streamToken,ke(!e.writeResults||e.writeResults.length===0),this.listener.f_()}onNext(e){ke(!!e.streamToken),this.lastStreamToken=e.streamToken,this.t_.reset();const n=Jb(e.writeResults,e.commitTime),r=Qn(e.commitTime);return this.listener.g_(r,n)}p_(){const e={};e.database=fp(this.serializer),this.a_(e)}m_(e){const n={streamToken:this.lastStreamToken,writes:e.map(r=>Xb(this.serializer,r))};this.a_(n)}}/**
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
 */class jN extends class{}{constructor(e,n,r,i){super(),this.authCredentials=e,this.appCheckCredentials=n,this.connection=r,this.serializer=i,this.y_=!1}w_(){if(this.y_)throw new X(V.FAILED_PRECONDITION,"The client has already been terminated.")}Mo(e,n,r,i){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([s,o])=>this.connection.Mo(e,hp(n,r),i,s,o)).catch(s=>{throw s.name==="FirebaseError"?(s.code===V.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),s):new X(V.UNKNOWN,s.toString())})}Lo(e,n,r,i,s){return this.w_(),Promise.all([this.authCredentials.getToken(),this.appCheckCredentials.getToken()]).then(([o,a])=>this.connection.Lo(e,hp(n,r),i,o,a,s)).catch(o=>{throw o.name==="FirebaseError"?(o.code===V.UNAUTHENTICATED&&(this.authCredentials.invalidateToken(),this.appCheckCredentials.invalidateToken()),o):new X(V.UNKNOWN,o.toString())})}terminate(){this.y_=!0,this.connection.terminate()}}class zN{constructor(e,n){this.asyncQueue=e,this.onlineStateHandler=n,this.state="Unknown",this.S_=0,this.b_=null,this.D_=!0}v_(){this.S_===0&&(this.C_("Unknown"),this.b_=this.asyncQueue.enqueueAfterDelay("online_state_timeout",1e4,()=>(this.b_=null,this.F_("Backend didn't respond within 10 seconds."),this.C_("Offline"),Promise.resolve())))}M_(e){this.state==="Online"?this.C_("Unknown"):(this.S_++,this.S_>=1&&(this.x_(),this.F_(`Connection failed 1 times. Most recent error: ${e.toString()}`),this.C_("Offline")))}set(e){this.x_(),this.S_=0,e==="Online"&&(this.D_=!1),this.C_(e)}C_(e){e!==this.state&&(this.state=e,this.onlineStateHandler(e))}F_(e){const n=`Could not reach Cloud Firestore backend. ${e}
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
 */class BN{constructor(e,n,r,i,s){this.localStore=e,this.datastore=n,this.asyncQueue=r,this.remoteSyncer={},this.O_=[],this.N_=new Map,this.L_=new Set,this.B_=[],this.k_=s,this.k_._o(o=>{r.enqueueAndForget(async()=>{ns(this)&&(J("RemoteStore","Restarting streams for network reachability change."),await async function(u){const c=le(u);c.L_.add(4),await Sl(c),c.q_.set("Unknown"),c.L_.delete(4),await kh(c)}(this))})}),this.q_=new zN(r,i)}}async function kh(t){if(ns(t))for(const e of t.B_)await e(!0)}async function Sl(t){for(const e of t.B_)await e(!1)}function qI(t,e){const n=le(t);n.N_.has(e.targetId)||(n.N_.set(e.targetId,e),ng(n)?tg(n):To(n).r_()&&eg(n,e))}function Zm(t,e){const n=le(t),r=To(n);n.N_.delete(e),r.r_()&&HI(n,e),n.N_.size===0&&(r.r_()?r.o_():ns(n)&&n.q_.set("Unknown"))}function eg(t,e){if(t.Q_.xe(e.targetId),e.resumeToken.approximateByteSize()>0||e.snapshotVersion.compareTo(ae.min())>0){const n=t.remoteSyncer.getRemoteKeysForTarget(e.targetId).size;e=e.withExpectedCount(n)}To(t).A_(e)}function HI(t,e){t.Q_.xe(e),To(t).R_(e)}function tg(t){t.Q_=new $b({getRemoteKeysForTarget:e=>t.remoteSyncer.getRemoteKeysForTarget(e),ot:e=>t.N_.get(e)||null,tt:()=>t.datastore.serializer.databaseId}),To(t).start(),t.q_.v_()}function ng(t){return ns(t)&&!To(t).n_()&&t.N_.size>0}function ns(t){return le(t).L_.size===0}function GI(t){t.Q_=void 0}async function $N(t){t.q_.set("Online")}async function WN(t){t.N_.forEach((e,n)=>{eg(t,e)})}async function qN(t,e){GI(t),ng(t)?(t.q_.M_(e),tg(t)):t.q_.set("Unknown")}async function HN(t,e,n){if(t.q_.set("Online"),e instanceof DI&&e.state===2&&e.cause)try{await async function(i,s){const o=s.cause;for(const a of s.targetIds)i.N_.has(a)&&(await i.remoteSyncer.rejectListen(a,o),i.N_.delete(a),i.Q_.removeTarget(a))}(t,e)}catch(r){J("RemoteStore","Failed to remove targets %s: %s ",e.targetIds.join(","),r),await bc(t,r)}else if(e instanceof Wu?t.Q_.Ke(e):e instanceof NI?t.Q_.He(e):t.Q_.We(e),!n.isEqual(ae.min()))try{const r=await BI(t.localStore);n.compareTo(r)>=0&&await function(s,o){const a=s.Q_.rt(o);return a.targetChanges.forEach((u,c)=>{if(u.resumeToken.approximateByteSize()>0){const h=s.N_.get(c);h&&s.N_.set(c,h.withResumeToken(u.resumeToken,o))}}),a.targetMismatches.forEach((u,c)=>{const h=s.N_.get(u);if(!h)return;s.N_.set(u,h.withResumeToken(Ct.EMPTY_BYTE_STRING,h.snapshotVersion)),HI(s,u);const f=new qr(h.target,u,c,h.sequenceNumber);eg(s,f)}),s.remoteSyncer.applyRemoteEvent(a)}(t,n)}catch(r){J("RemoteStore","Failed to raise snapshot:",r),await bc(t,r)}}async function bc(t,e,n){if(!El(e))throw e;t.L_.add(1),await Sl(t),t.q_.set("Offline"),n||(n=()=>BI(t.localStore)),t.asyncQueue.enqueueRetryable(async()=>{J("RemoteStore","Retrying IndexedDB access"),await n(),t.L_.delete(1),await kh(t)})}function KI(t,e){return e().catch(n=>bc(t,n,e))}async function Ch(t){const e=le(t),n=di(e);let r=e.O_.length>0?e.O_[e.O_.length-1].batchId:-1;for(;GN(e);)try{const i=await PN(e.localStore,r);if(i===null){e.O_.length===0&&n.o_();break}r=i.batchId,KN(e,i)}catch(i){await bc(e,i)}QI(e)&&YI(e)}function GN(t){return ns(t)&&t.O_.length<10}function KN(t,e){t.O_.push(e);const n=di(t);n.r_()&&n.V_&&n.m_(e.mutations)}function QI(t){return ns(t)&&!di(t).n_()&&t.O_.length>0}function YI(t){di(t).start()}async function QN(t){di(t).p_()}async function YN(t){const e=di(t);for(const n of t.O_)e.m_(n.mutations)}async function XN(t,e,n){const r=t.O_.shift(),i=Gm.from(r,e,n);await KI(t,()=>t.remoteSyncer.applySuccessfulWrite(i)),await Ch(t)}async function JN(t,e){e&&di(t).V_&&await async function(r,i){if(function(o){return jb(o)&&o!==V.ABORTED}(i.code)){const s=r.O_.shift();di(r).s_(),await KI(r,()=>r.remoteSyncer.rejectFailedWrite(s.batchId,i)),await Ch(r)}}(t,e),QI(t)&&YI(t)}async function Jv(t,e){const n=le(t);n.asyncQueue.verifyOperationInProgress(),J("RemoteStore","RemoteStore received new credentials");const r=ns(n);n.L_.add(3),await Sl(n),r&&n.q_.set("Unknown"),await n.remoteSyncer.handleCredentialChange(e),n.L_.delete(3),await kh(n)}async function ZN(t,e){const n=le(t);e?(n.L_.delete(2),await kh(n)):e||(n.L_.add(2),await Sl(n),n.q_.set("Unknown"))}function To(t){return t.K_||(t.K_=function(n,r,i){const s=le(n);return s.w_(),new VN(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:$N.bind(null,t),Ro:WN.bind(null,t),mo:qN.bind(null,t),d_:HN.bind(null,t)}),t.B_.push(async e=>{e?(t.K_.s_(),ng(t)?tg(t):t.q_.set("Unknown")):(await t.K_.stop(),GI(t))})),t.K_}function di(t){return t.U_||(t.U_=function(n,r,i){const s=le(n);return s.w_(),new UN(r,s.connection,s.authCredentials,s.appCheckCredentials,s.serializer,i)}(t.datastore,t.asyncQueue,{Eo:()=>Promise.resolve(),Ro:QN.bind(null,t),mo:JN.bind(null,t),f_:YN.bind(null,t),g_:XN.bind(null,t)}),t.B_.push(async e=>{e?(t.U_.s_(),await Ch(t)):(await t.U_.stop(),t.O_.length>0&&(J("RemoteStore",`Stopping write stream with ${t.O_.length} pending writes`),t.O_=[]))})),t.U_}/**
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
 */class rg{constructor(e,n,r,i,s){this.asyncQueue=e,this.timerId=n,this.targetTimeMs=r,this.op=i,this.removalCallback=s,this.deferred=new ni,this.then=this.deferred.promise.then.bind(this.deferred.promise),this.deferred.promise.catch(o=>{})}get promise(){return this.deferred.promise}static createAndSchedule(e,n,r,i,s){const o=Date.now()+r,a=new rg(e,n,o,i,s);return a.start(r),a}start(e){this.timerHandle=setTimeout(()=>this.handleDelayElapsed(),e)}skipDelay(){return this.handleDelayElapsed()}cancel(e){this.timerHandle!==null&&(this.clearTimeout(),this.deferred.reject(new X(V.CANCELLED,"Operation cancelled"+(e?": "+e:""))))}handleDelayElapsed(){this.asyncQueue.enqueueAndForget(()=>this.timerHandle!==null?(this.clearTimeout(),this.op().then(e=>this.deferred.resolve(e))):Promise.resolve())}clearTimeout(){this.timerHandle!==null&&(this.removalCallback(this),clearTimeout(this.timerHandle),this.timerHandle=null)}}function ig(t,e){if(Er("AsyncQueue",`${e}: ${t}`),El(t))return new X(V.UNAVAILABLE,`${e}: ${t}`);throw t}/**
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
 */class zs{constructor(e){this.comparator=e?(n,r)=>e(n,r)||ee.comparator(n.key,r.key):(n,r)=>ee.comparator(n.key,r.key),this.keyedMap=da(),this.sortedSet=new it(this.comparator)}static emptySet(e){return new zs(e.comparator)}has(e){return this.keyedMap.get(e)!=null}get(e){return this.keyedMap.get(e)}first(){return this.sortedSet.minKey()}last(){return this.sortedSet.maxKey()}isEmpty(){return this.sortedSet.isEmpty()}indexOf(e){const n=this.keyedMap.get(e);return n?this.sortedSet.indexOf(n):-1}get size(){return this.sortedSet.size}forEach(e){this.sortedSet.inorderTraversal((n,r)=>(e(n),!1))}add(e){const n=this.delete(e.key);return n.copy(n.keyedMap.insert(e.key,e),n.sortedSet.insert(e,null))}delete(e){const n=this.get(e);return n?this.copy(this.keyedMap.remove(e),this.sortedSet.remove(n)):this}isEqual(e){if(!(e instanceof zs)||this.size!==e.size)return!1;const n=this.sortedSet.getIterator(),r=e.sortedSet.getIterator();for(;n.hasNext();){const i=n.getNext().key,s=r.getNext().key;if(!i.isEqual(s))return!1}return!0}toString(){const e=[];return this.forEach(n=>{e.push(n.toString())}),e.length===0?"DocumentSet ()":`DocumentSet (
  `+e.join(`  
`)+`
)`}copy(e,n){const r=new zs;return r.comparator=this.comparator,r.keyedMap=e,r.sortedSet=n,r}}/**
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
 */class Zv{constructor(){this.W_=new it(ee.comparator)}track(e){const n=e.doc.key,r=this.W_.get(n);r?e.type!==0&&r.type===3?this.W_=this.W_.insert(n,e):e.type===3&&r.type!==1?this.W_=this.W_.insert(n,{type:r.type,doc:e.doc}):e.type===2&&r.type===2?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):e.type===2&&r.type===0?this.W_=this.W_.insert(n,{type:0,doc:e.doc}):e.type===1&&r.type===0?this.W_=this.W_.remove(n):e.type===1&&r.type===2?this.W_=this.W_.insert(n,{type:1,doc:r.doc}):e.type===0&&r.type===1?this.W_=this.W_.insert(n,{type:2,doc:e.doc}):oe():this.W_=this.W_.insert(n,e)}G_(){const e=[];return this.W_.inorderTraversal((n,r)=>{e.push(r)}),e}}class lo{constructor(e,n,r,i,s,o,a,u,c){this.query=e,this.docs=n,this.oldDocs=r,this.docChanges=i,this.mutatedKeys=s,this.fromCache=o,this.syncStateChanged=a,this.excludesMetadataChanges=u,this.hasCachedResults=c}static fromInitialDocuments(e,n,r,i,s){const o=[];return n.forEach(a=>{o.push({type:0,doc:a})}),new lo(e,n,zs.emptySet(n),o,r,i,!0,!1,s)}get hasPendingWrites(){return!this.mutatedKeys.isEmpty()}isEqual(e){if(!(this.fromCache===e.fromCache&&this.hasCachedResults===e.hasCachedResults&&this.syncStateChanged===e.syncStateChanged&&this.mutatedKeys.isEqual(e.mutatedKeys)&&vh(this.query,e.query)&&this.docs.isEqual(e.docs)&&this.oldDocs.isEqual(e.oldDocs)))return!1;const n=this.docChanges,r=e.docChanges;if(n.length!==r.length)return!1;for(let i=0;i<n.length;i++)if(n[i].type!==r[i].type||!n[i].doc.isEqual(r[i].doc))return!1;return!0}}/**
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
 */class e2{constructor(){this.z_=void 0,this.j_=[]}H_(){return this.j_.some(e=>e.J_())}}class t2{constructor(){this.queries=e0(),this.onlineState="Unknown",this.Y_=new Set}terminate(){(function(n,r){const i=le(n),s=i.queries;i.queries=e0(),s.forEach((o,a)=>{for(const u of a.j_)u.onError(r)})})(this,new X(V.ABORTED,"Firestore shutting down"))}}function e0(){return new Eo(t=>vI(t),vh)}async function n2(t,e){const n=le(t);let r=3;const i=e.query;let s=n.queries.get(i);s?!s.H_()&&e.J_()&&(r=2):(s=new e2,r=e.J_()?0:1);try{switch(r){case 0:s.z_=await n.onListen(i,!0);break;case 1:s.z_=await n.onListen(i,!1);break;case 2:await n.onFirstRemoteStoreListen(i)}}catch(o){const a=ig(o,`Initialization of query '${_s(e.query)}' failed`);return void e.onError(a)}n.queries.set(i,s),s.j_.push(e),e.Z_(n.onlineState),s.z_&&e.X_(s.z_)&&sg(n)}async function r2(t,e){const n=le(t),r=e.query;let i=3;const s=n.queries.get(r);if(s){const o=s.j_.indexOf(e);o>=0&&(s.j_.splice(o,1),s.j_.length===0?i=e.J_()?0:1:!s.H_()&&e.J_()&&(i=2))}switch(i){case 0:return n.queries.delete(r),n.onUnlisten(r,!0);case 1:return n.queries.delete(r),n.onUnlisten(r,!1);case 2:return n.onLastRemoteStoreUnlisten(r);default:return}}function i2(t,e){const n=le(t);let r=!1;for(const i of e){const s=i.query,o=n.queries.get(s);if(o){for(const a of o.j_)a.X_(i)&&(r=!0);o.z_=i}}r&&sg(n)}function s2(t,e,n){const r=le(t),i=r.queries.get(e);if(i)for(const s of i.j_)s.onError(n);r.queries.delete(e)}function sg(t){t.Y_.forEach(e=>{e.next()})}var mp,t0;(t0=mp||(mp={})).ea="default",t0.Cache="cache";class o2{constructor(e,n,r){this.query=e,this.ta=n,this.na=!1,this.ra=null,this.onlineState="Unknown",this.options=r||{}}X_(e){if(!this.options.includeMetadataChanges){const r=[];for(const i of e.docChanges)i.type!==3&&r.push(i);e=new lo(e.query,e.docs,e.oldDocs,r,e.mutatedKeys,e.fromCache,e.syncStateChanged,!0,e.hasCachedResults)}let n=!1;return this.na?this.ia(e)&&(this.ta.next(e),n=!0):this.sa(e,this.onlineState)&&(this.oa(e),n=!0),this.ra=e,n}onError(e){this.ta.error(e)}Z_(e){this.onlineState=e;let n=!1;return this.ra&&!this.na&&this.sa(this.ra,e)&&(this.oa(this.ra),n=!0),n}sa(e,n){if(!e.fromCache||!this.J_())return!0;const r=n!=="Offline";return(!this.options._a||!r)&&(!e.docs.isEmpty()||e.hasCachedResults||n==="Offline")}ia(e){if(e.docChanges.length>0)return!0;const n=this.ra&&this.ra.hasPendingWrites!==e.hasPendingWrites;return!(!e.syncStateChanged&&!n)&&this.options.includeMetadataChanges===!0}oa(e){e=lo.fromInitialDocuments(e.query,e.docs,e.mutatedKeys,e.fromCache,e.hasCachedResults),this.na=!0,this.ta.next(e)}J_(){return this.options.source!==mp.Cache}}/**
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
 */class XI{constructor(e){this.key=e}}class JI{constructor(e){this.key=e}}class a2{constructor(e,n){this.query=e,this.Ta=n,this.Ea=null,this.hasCachedResults=!1,this.current=!1,this.da=pe(),this.mutatedKeys=pe(),this.Aa=wI(e),this.Ra=new zs(this.Aa)}get Va(){return this.Ta}ma(e,n){const r=n?n.fa:new Zv,i=n?n.Ra:this.Ra;let s=n?n.mutatedKeys:this.mutatedKeys,o=i,a=!1;const u=this.query.limitType==="F"&&i.size===this.query.limit?i.last():null,c=this.query.limitType==="L"&&i.size===this.query.limit?i.first():null;if(e.inorderTraversal((h,f)=>{const m=i.get(h),w=wh(this.query,f)?f:null,S=!!m&&this.mutatedKeys.has(m.key),P=!!w&&(w.hasLocalMutations||this.mutatedKeys.has(w.key)&&w.hasCommittedMutations);let D=!1;m&&w?m.data.isEqual(w.data)?S!==P&&(r.track({type:3,doc:w}),D=!0):this.ga(m,w)||(r.track({type:2,doc:w}),D=!0,(u&&this.Aa(w,u)>0||c&&this.Aa(w,c)<0)&&(a=!0)):!m&&w?(r.track({type:0,doc:w}),D=!0):m&&!w&&(r.track({type:1,doc:m}),D=!0,(u||c)&&(a=!0)),D&&(w?(o=o.add(w),s=P?s.add(h):s.delete(h)):(o=o.delete(h),s=s.delete(h)))}),this.query.limit!==null)for(;o.size>this.query.limit;){const h=this.query.limitType==="F"?o.last():o.first();o=o.delete(h.key),s=s.delete(h.key),r.track({type:1,doc:h})}return{Ra:o,fa:r,ns:a,mutatedKeys:s}}ga(e,n){return e.hasLocalMutations&&n.hasCommittedMutations&&!n.hasLocalMutations}applyChanges(e,n,r,i){const s=this.Ra;this.Ra=e.Ra,this.mutatedKeys=e.mutatedKeys;const o=e.fa.G_();o.sort((h,f)=>function(w,S){const P=D=>{switch(D){case 0:return 1;case 2:case 3:return 2;case 1:return 0;default:return oe()}};return P(w)-P(S)}(h.type,f.type)||this.Aa(h.doc,f.doc)),this.pa(r),i=i!=null&&i;const a=n&&!i?this.ya():[],u=this.da.size===0&&this.current&&!i?1:0,c=u!==this.Ea;return this.Ea=u,o.length!==0||c?{snapshot:new lo(this.query,e.Ra,s,o,e.mutatedKeys,u===0,c,!1,!!r&&r.resumeToken.approximateByteSize()>0),wa:a}:{wa:a}}Z_(e){return this.current&&e==="Offline"?(this.current=!1,this.applyChanges({Ra:this.Ra,fa:new Zv,mutatedKeys:this.mutatedKeys,ns:!1},!1)):{wa:[]}}Sa(e){return!this.Ta.has(e)&&!!this.Ra.has(e)&&!this.Ra.get(e).hasLocalMutations}pa(e){e&&(e.addedDocuments.forEach(n=>this.Ta=this.Ta.add(n)),e.modifiedDocuments.forEach(n=>{}),e.removedDocuments.forEach(n=>this.Ta=this.Ta.delete(n)),this.current=e.current)}ya(){if(!this.current)return[];const e=this.da;this.da=pe(),this.Ra.forEach(r=>{this.Sa(r.key)&&(this.da=this.da.add(r.key))});const n=[];return e.forEach(r=>{this.da.has(r)||n.push(new JI(r))}),this.da.forEach(r=>{e.has(r)||n.push(new XI(r))}),n}ba(e){this.Ta=e.Ts,this.da=pe();const n=this.ma(e.documents);return this.applyChanges(n,!0)}Da(){return lo.fromInitialDocuments(this.query,this.Ra,this.mutatedKeys,this.Ea===0,this.hasCachedResults)}}class l2{constructor(e,n,r){this.query=e,this.targetId=n,this.view=r}}class u2{constructor(e){this.key=e,this.va=!1}}class c2{constructor(e,n,r,i,s,o){this.localStore=e,this.remoteStore=n,this.eventManager=r,this.sharedClientState=i,this.currentUser=s,this.maxConcurrentLimboResolutions=o,this.Ca={},this.Fa=new Eo(a=>vI(a),vh),this.Ma=new Map,this.xa=new Set,this.Oa=new it(ee.comparator),this.Na=new Map,this.La=new Ym,this.Ba={},this.ka=new Map,this.qa=ao.kn(),this.onlineState="Unknown",this.Qa=void 0}get isPrimaryClient(){return this.Qa===!0}}async function h2(t,e,n=!0){const r=iS(t);let i;const s=r.Fa.get(e);return s?(r.sharedClientState.addLocalQueryTarget(s.targetId),i=s.view.Da()):i=await ZI(r,e,n,!0),i}async function d2(t,e){const n=iS(t);await ZI(n,e,!0,!1)}async function ZI(t,e,n,r){const i=await bN(t.localStore,Gn(e)),s=i.targetId,o=t.sharedClientState.addLocalQueryTarget(s,n);let a;return r&&(a=await f2(t,e,s,o==="current",i.resumeToken)),t.isPrimaryClient&&n&&qI(t.remoteStore,i),a}async function f2(t,e,n,r,i){t.Ka=(f,m,w)=>async function(P,D,k,T){let R=D.view.ma(k);R.ns&&(R=await Qv(P.localStore,D.query,!1).then(({documents:v})=>D.view.ma(v,R)));const M=T&&T.targetChanges.get(D.targetId),z=T&&T.targetMismatches.get(D.targetId)!=null,U=D.view.applyChanges(R,P.isPrimaryClient,M,z);return r0(P,D.targetId,U.wa),U.snapshot}(t,f,m,w);const s=await Qv(t.localStore,e,!0),o=new a2(e,s.Ts),a=o.ma(s.documents),u=Il.createSynthesizedTargetChangeForCurrentChange(n,r&&t.onlineState!=="Offline",i),c=o.applyChanges(a,t.isPrimaryClient,u);r0(t,n,c.wa);const h=new l2(e,n,o);return t.Fa.set(e,h),t.Ma.has(n)?t.Ma.get(n).push(e):t.Ma.set(n,[e]),c.snapshot}async function p2(t,e,n){const r=le(t),i=r.Fa.get(e),s=r.Ma.get(i.targetId);if(s.length>1)return r.Ma.set(i.targetId,s.filter(o=>!vh(o,e))),void r.Fa.delete(e);r.isPrimaryClient?(r.sharedClientState.removeLocalQueryTarget(i.targetId),r.sharedClientState.isActiveQueryTarget(i.targetId)||await pp(r.localStore,i.targetId,!1).then(()=>{r.sharedClientState.clearQueryState(i.targetId),n&&Zm(r.remoteStore,i.targetId),gp(r,i.targetId)}).catch(wl)):(gp(r,i.targetId),await pp(r.localStore,i.targetId,!0))}async function m2(t,e){const n=le(t),r=n.Fa.get(e),i=n.Ma.get(r.targetId);n.isPrimaryClient&&i.length===1&&(n.sharedClientState.removeLocalQueryTarget(r.targetId),Zm(n.remoteStore,r.targetId))}async function g2(t,e,n){const r=I2(t);try{const i=await function(o,a){const u=le(o),c=ut.now(),h=a.reduce((w,S)=>w.add(S.key),pe());let f,m;return u.persistence.runTransaction("Locally write mutations","readwrite",w=>{let S=Tr(),P=pe();return u.cs.getEntries(w,h).next(D=>{S=D,S.forEach((k,T)=>{T.isValidDocument()||(P=P.add(k))})}).next(()=>u.localDocuments.getOverlayedDocuments(w,S)).next(D=>{f=D;const k=[];for(const T of a){const R=Mb(T,f.get(T.key).overlayedDocument);R!=null&&k.push(new ts(T.key,R,cI(R.value.mapValue),Kn.exists(!0)))}return u.mutationQueue.addMutationBatch(w,c,k,a)}).next(D=>{m=D;const k=D.applyToLocalDocumentSet(f,P);return u.documentOverlayCache.saveOverlays(w,D.batchId,k)})}).then(()=>({batchId:m.batchId,changes:TI(f)}))}(r.localStore,e);r.sharedClientState.addPendingMutation(i.batchId),function(o,a,u){let c=o.Ba[o.currentUser.toKey()];c||(c=new it(we)),c=c.insert(a,u),o.Ba[o.currentUser.toKey()]=c}(r,i.batchId,n),await kl(r,i.changes),await Ch(r.remoteStore)}catch(i){const s=ig(i,"Failed to persist write");n.reject(s)}}async function eS(t,e){const n=le(t);try{const r=await xN(n.localStore,e);e.targetChanges.forEach((i,s)=>{const o=n.Na.get(s);o&&(ke(i.addedDocuments.size+i.modifiedDocuments.size+i.removedDocuments.size<=1),i.addedDocuments.size>0?o.va=!0:i.modifiedDocuments.size>0?ke(o.va):i.removedDocuments.size>0&&(ke(o.va),o.va=!1))}),await kl(n,r,e)}catch(r){await wl(r)}}function n0(t,e,n){const r=le(t);if(r.isPrimaryClient&&n===0||!r.isPrimaryClient&&n===1){const i=[];r.Fa.forEach((s,o)=>{const a=o.view.Z_(e);a.snapshot&&i.push(a.snapshot)}),function(o,a){const u=le(o);u.onlineState=a;let c=!1;u.queries.forEach((h,f)=>{for(const m of f.j_)m.Z_(a)&&(c=!0)}),c&&sg(u)}(r.eventManager,e),i.length&&r.Ca.d_(i),r.onlineState=e,r.isPrimaryClient&&r.sharedClientState.setOnlineState(e)}}async function _2(t,e,n){const r=le(t);r.sharedClientState.updateQueryState(e,"rejected",n);const i=r.Na.get(e),s=i&&i.key;if(s){let o=new it(ee.comparator);o=o.insert(s,Ot.newNoDocument(s,ae.min()));const a=pe().add(s),u=new Ih(ae.min(),new Map,new it(we),o,a);await eS(r,u),r.Oa=r.Oa.remove(s),r.Na.delete(e),og(r)}else await pp(r.localStore,e,!1).then(()=>gp(r,e,n)).catch(wl)}async function y2(t,e){const n=le(t),r=e.batch.batchId;try{const i=await RN(n.localStore,e);nS(n,r,null),tS(n,r),n.sharedClientState.updateMutationState(r,"acknowledged"),await kl(n,i)}catch(i){await wl(i)}}async function v2(t,e,n){const r=le(t);try{const i=await function(o,a){const u=le(o);return u.persistence.runTransaction("Reject batch","readwrite-primary",c=>{let h;return u.mutationQueue.lookupMutationBatch(c,a).next(f=>(ke(f!==null),h=f.keys(),u.mutationQueue.removeMutationBatch(c,f))).next(()=>u.mutationQueue.performConsistencyCheck(c)).next(()=>u.documentOverlayCache.removeOverlaysForBatchId(c,h,a)).next(()=>u.localDocuments.recalculateAndSaveOverlaysForDocumentKeys(c,h)).next(()=>u.localDocuments.getDocuments(c,h))})}(r.localStore,e);nS(r,e,n),tS(r,e),r.sharedClientState.updateMutationState(e,"rejected",n),await kl(r,i)}catch(i){await wl(i)}}function tS(t,e){(t.ka.get(e)||[]).forEach(n=>{n.resolve()}),t.ka.delete(e)}function nS(t,e,n){const r=le(t);let i=r.Ba[r.currentUser.toKey()];if(i){const s=i.get(e);s&&(n?s.reject(n):s.resolve(),i=i.remove(e)),r.Ba[r.currentUser.toKey()]=i}}function gp(t,e,n=null){t.sharedClientState.removeLocalQueryTarget(e);for(const r of t.Ma.get(e))t.Fa.delete(r),n&&t.Ca.$a(r,n);t.Ma.delete(e),t.isPrimaryClient&&t.La.gr(e).forEach(r=>{t.La.containsKey(r)||rS(t,r)})}function rS(t,e){t.xa.delete(e.path.canonicalString());const n=t.Oa.get(e);n!==null&&(Zm(t.remoteStore,n),t.Oa=t.Oa.remove(e),t.Na.delete(n),og(t))}function r0(t,e,n){for(const r of n)r instanceof XI?(t.La.addReference(r.key,e),w2(t,r)):r instanceof JI?(J("SyncEngine","Document no longer in limbo: "+r.key),t.La.removeReference(r.key,e),t.La.containsKey(r.key)||rS(t,r.key)):oe()}function w2(t,e){const n=e.key,r=n.path.canonicalString();t.Oa.get(n)||t.xa.has(r)||(J("SyncEngine","New document in limbo: "+n),t.xa.add(r),og(t))}function og(t){for(;t.xa.size>0&&t.Oa.size<t.maxConcurrentLimboResolutions;){const e=t.xa.values().next().value;t.xa.delete(e);const n=new ee(Ve.fromString(e)),r=t.qa.next();t.Na.set(r,new u2(n)),t.Oa=t.Oa.insert(n,r),qI(t.remoteStore,new qr(Gn(_I(n.path)),r,"TargetPurposeLimboResolution",Um.oe))}}async function kl(t,e,n){const r=le(t),i=[],s=[],o=[];r.Fa.isEmpty()||(r.Fa.forEach((a,u)=>{o.push(r.Ka(u,e,n).then(c=>{var h;if((c||n)&&r.isPrimaryClient){const f=c?!c.fromCache:(h=n==null?void 0:n.targetChanges.get(u.targetId))===null||h===void 0?void 0:h.current;r.sharedClientState.updateQueryState(u.targetId,f?"current":"not-current")}if(c){i.push(c);const f=Jm.Wi(u.targetId,c);s.push(f)}}))}),await Promise.all(o),r.Ca.d_(i),await async function(u,c){const h=le(u);try{await h.persistence.runTransaction("notifyLocalViewChanges","readwrite",f=>j.forEach(c,m=>j.forEach(m.$i,w=>h.persistence.referenceDelegate.addReference(f,m.targetId,w)).next(()=>j.forEach(m.Ui,w=>h.persistence.referenceDelegate.removeReference(f,m.targetId,w)))))}catch(f){if(!El(f))throw f;J("LocalStore","Failed to update sequence numbers: "+f)}for(const f of c){const m=f.targetId;if(!f.fromCache){const w=h.os.get(m),S=w.snapshotVersion,P=w.withLastLimboFreeSnapshotVersion(S);h.os=h.os.insert(m,P)}}}(r.localStore,s))}async function E2(t,e){const n=le(t);if(!n.currentUser.isEqual(e)){J("SyncEngine","User change. New user:",e.toKey());const r=await zI(n.localStore,e);n.currentUser=e,function(s,o){s.ka.forEach(a=>{a.forEach(u=>{u.reject(new X(V.CANCELLED,o))})}),s.ka.clear()}(n,"'waitForPendingWrites' promise is rejected due to a user change."),n.sharedClientState.handleUserChange(e,r.removedBatchIds,r.addedBatchIds),await kl(n,r.hs)}}function T2(t,e){const n=le(t),r=n.Na.get(e);if(r&&r.va)return pe().add(r.key);{let i=pe();const s=n.Ma.get(e);if(!s)return i;for(const o of s){const a=n.Fa.get(o);i=i.unionWith(a.view.Va)}return i}}function iS(t){const e=le(t);return e.remoteStore.remoteSyncer.applyRemoteEvent=eS.bind(null,e),e.remoteStore.remoteSyncer.getRemoteKeysForTarget=T2.bind(null,e),e.remoteStore.remoteSyncer.rejectListen=_2.bind(null,e),e.Ca.d_=i2.bind(null,e.eventManager),e.Ca.$a=s2.bind(null,e.eventManager),e}function I2(t){const e=le(t);return e.remoteStore.remoteSyncer.applySuccessfulWrite=y2.bind(null,e),e.remoteStore.remoteSyncer.rejectFailedWrite=v2.bind(null,e),e}class Nc{constructor(){this.kind="memory",this.synchronizeTabs=!1}async initialize(e){this.serializer=Sh(e.databaseInfo.databaseId),this.sharedClientState=this.Wa(e),this.persistence=this.Ga(e),await this.persistence.start(),this.localStore=this.za(e),this.gcScheduler=this.ja(e,this.localStore),this.indexBackfillerScheduler=this.Ha(e,this.localStore)}ja(e,n){return null}Ha(e,n){return null}za(e){return CN(this.persistence,new SN,e.initialUser,this.serializer)}Ga(e){return new EN(Xm.Zr,this.serializer)}Wa(e){return new DN}async terminate(){var e,n;(e=this.gcScheduler)===null||e===void 0||e.stop(),(n=this.indexBackfillerScheduler)===null||n===void 0||n.stop(),this.sharedClientState.shutdown(),await this.persistence.shutdown()}}Nc.provider={build:()=>new Nc};class _p{async initialize(e,n){this.localStore||(this.localStore=e.localStore,this.sharedClientState=e.sharedClientState,this.datastore=this.createDatastore(n),this.remoteStore=this.createRemoteStore(n),this.eventManager=this.createEventManager(n),this.syncEngine=this.createSyncEngine(n,!e.synchronizeTabs),this.sharedClientState.onlineStateHandler=r=>n0(this.syncEngine,r,1),this.remoteStore.remoteSyncer.handleCredentialChange=E2.bind(null,this.syncEngine),await ZN(this.remoteStore,this.syncEngine.isPrimaryClient))}createEventManager(e){return function(){return new t2}()}createDatastore(e){const n=Sh(e.databaseInfo.databaseId),r=function(s){return new FN(s)}(e.databaseInfo);return function(s,o,a,u){return new jN(s,o,a,u)}(e.authCredentials,e.appCheckCredentials,r,n)}createRemoteStore(e){return function(r,i,s,o,a){return new BN(r,i,s,o,a)}(this.localStore,this.datastore,e.asyncQueue,n=>n0(this.syncEngine,n,0),function(){return Xv.D()?new Xv:new ON}())}createSyncEngine(e,n){return function(i,s,o,a,u,c,h){const f=new c2(i,s,o,a,u,c);return h&&(f.Qa=!0),f}(this.localStore,this.remoteStore,this.eventManager,this.sharedClientState,e.initialUser,e.maxConcurrentLimboResolutions,n)}async terminate(){var e,n;await async function(i){const s=le(i);J("RemoteStore","RemoteStore shutting down."),s.L_.add(5),await Sl(s),s.k_.shutdown(),s.q_.set("Unknown")}(this.remoteStore),(e=this.datastore)===null||e===void 0||e.terminate(),(n=this.eventManager)===null||n===void 0||n.terminate()}}_p.provider={build:()=>new _p};/**
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
 */class S2{constructor(e){this.observer=e,this.muted=!1}next(e){this.muted||this.observer.next&&this.Ya(this.observer.next,e)}error(e){this.muted||(this.observer.error?this.Ya(this.observer.error,e):Er("Uncaught Error in snapshot listener:",e.toString()))}Za(){this.muted=!0}Ya(e,n){setTimeout(()=>{this.muted||e(n)},0)}}/**
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
 */class k2{constructor(e,n,r,i,s){this.authCredentials=e,this.appCheckCredentials=n,this.asyncQueue=r,this.databaseInfo=i,this.user=Nt.UNAUTHENTICATED,this.clientId=aI.newId(),this.authCredentialListener=()=>Promise.resolve(),this.appCheckCredentialListener=()=>Promise.resolve(),this._uninitializedComponentsProvider=s,this.authCredentials.start(r,async o=>{J("FirestoreClient","Received user=",o.uid),await this.authCredentialListener(o),this.user=o}),this.appCheckCredentials.start(r,o=>(J("FirestoreClient","Received new app check token=",o),this.appCheckCredentialListener(o,this.user)))}get configuration(){return{asyncQueue:this.asyncQueue,databaseInfo:this.databaseInfo,clientId:this.clientId,authCredentials:this.authCredentials,appCheckCredentials:this.appCheckCredentials,initialUser:this.user,maxConcurrentLimboResolutions:100}}setCredentialChangeListener(e){this.authCredentialListener=e}setAppCheckTokenChangeListener(e){this.appCheckCredentialListener=e}terminate(){this.asyncQueue.enterRestrictedMode();const e=new ni;return this.asyncQueue.enqueueAndForgetEvenWhileRestricted(async()=>{try{this._onlineComponents&&await this._onlineComponents.terminate(),this._offlineComponents&&await this._offlineComponents.terminate(),this.authCredentials.shutdown(),this.appCheckCredentials.shutdown(),e.resolve()}catch(n){const r=ig(n,"Failed to shutdown persistence");e.reject(r)}}),e.promise}}async function jd(t,e){t.asyncQueue.verifyOperationInProgress(),J("FirestoreClient","Initializing OfflineComponentProvider");const n=t.configuration;await e.initialize(n);let r=n.initialUser;t.setCredentialChangeListener(async i=>{r.isEqual(i)||(await zI(e.localStore,i),r=i)}),e.persistence.setDatabaseDeletedListener(()=>t.terminate()),t._offlineComponents=e}async function i0(t,e){t.asyncQueue.verifyOperationInProgress();const n=await C2(t);J("FirestoreClient","Initializing OnlineComponentProvider"),await e.initialize(n,t.configuration),t.setCredentialChangeListener(r=>Jv(e.remoteStore,r)),t.setAppCheckTokenChangeListener((r,i)=>Jv(e.remoteStore,i)),t._onlineComponents=e}async function C2(t){if(!t._offlineComponents)if(t._uninitializedComponentsProvider){J("FirestoreClient","Using user provided OfflineComponentProvider");try{await jd(t,t._uninitializedComponentsProvider._offline)}catch(e){const n=e;if(!function(i){return i.name==="FirebaseError"?i.code===V.FAILED_PRECONDITION||i.code===V.UNIMPLEMENTED:!(typeof DOMException<"u"&&i instanceof DOMException)||i.code===22||i.code===20||i.code===11}(n))throw n;ro("Error using user provided cache. Falling back to memory cache: "+n),await jd(t,new Nc)}}else J("FirestoreClient","Using default OfflineComponentProvider"),await jd(t,new Nc);return t._offlineComponents}async function sS(t){return t._onlineComponents||(t._uninitializedComponentsProvider?(J("FirestoreClient","Using user provided OnlineComponentProvider"),await i0(t,t._uninitializedComponentsProvider._online)):(J("FirestoreClient","Using default OnlineComponentProvider"),await i0(t,new _p))),t._onlineComponents}function R2(t){return sS(t).then(e=>e.syncEngine)}async function x2(t){const e=await sS(t),n=e.eventManager;return n.onListen=h2.bind(null,e.syncEngine),n.onUnlisten=p2.bind(null,e.syncEngine),n.onFirstRemoteStoreListen=d2.bind(null,e.syncEngine),n.onLastRemoteStoreUnlisten=m2.bind(null,e.syncEngine),n}function A2(t,e,n={}){const r=new ni;return t.asyncQueue.enqueueAndForget(async()=>function(s,o,a,u,c){const h=new S2({next:m=>{h.Za(),o.enqueueAndForget(()=>r2(s,f)),m.fromCache&&u.source==="server"?c.reject(new X(V.UNAVAILABLE,'Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to "server" to retrieve the cached documents.)')):c.resolve(m)},error:m=>c.reject(m)}),f=new o2(a,h,{includeMetadataChanges:!0,_a:!0});return n2(s,f)}(await x2(t),t.asyncQueue,e,n,r)),r.promise}/**
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
 */function oS(t){const e={};return t.timeoutSeconds!==void 0&&(e.timeoutSeconds=t.timeoutSeconds),e}/**
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
 */const s0=new Map;/**
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
 */function aS(t,e,n){if(!n)throw new X(V.INVALID_ARGUMENT,`Function ${t}() cannot be called with an empty ${e}.`)}function P2(t,e,n,r){if(e===!0&&r===!0)throw new X(V.INVALID_ARGUMENT,`${t} and ${n} cannot be used together.`)}function o0(t){if(!ee.isDocumentKey(t))throw new X(V.INVALID_ARGUMENT,`Invalid document reference. Document references must have an even number of segments, but ${t} has ${t.length}.`)}function a0(t){if(ee.isDocumentKey(t))throw new X(V.INVALID_ARGUMENT,`Invalid collection reference. Collection references must have an odd number of segments, but ${t} has ${t.length}.`)}function Rh(t){if(t===void 0)return"undefined";if(t===null)return"null";if(typeof t=="string")return t.length>20&&(t=`${t.substring(0,20)}...`),JSON.stringify(t);if(typeof t=="number"||typeof t=="boolean")return""+t;if(typeof t=="object"){if(t instanceof Array)return"an array";{const e=function(r){return r.constructor?r.constructor.name:null}(t);return e?`a custom ${e} object`:"an object"}}return typeof t=="function"?"a function":oe()}function ul(t,e){if("_delegate"in t&&(t=t._delegate),!(t instanceof e)){if(e.name===t.constructor.name)throw new X(V.INVALID_ARGUMENT,"Type does not match the expected instance. Did you pass a reference from a different Firestore SDK?");{const n=Rh(t);throw new X(V.INVALID_ARGUMENT,`Expected type '${e.name}', but it was: ${n}`)}}return t}/**
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
 */class l0{constructor(e){var n,r;if(e.host===void 0){if(e.ssl!==void 0)throw new X(V.INVALID_ARGUMENT,"Can't provide ssl option if host option is not set");this.host="firestore.googleapis.com",this.ssl=!0}else this.host=e.host,this.ssl=(n=e.ssl)===null||n===void 0||n;if(this.credentials=e.credentials,this.ignoreUndefinedProperties=!!e.ignoreUndefinedProperties,this.localCache=e.localCache,e.cacheSizeBytes===void 0)this.cacheSizeBytes=41943040;else{if(e.cacheSizeBytes!==-1&&e.cacheSizeBytes<1048576)throw new X(V.INVALID_ARGUMENT,"cacheSizeBytes must be at least 1048576");this.cacheSizeBytes=e.cacheSizeBytes}P2("experimentalForceLongPolling",e.experimentalForceLongPolling,"experimentalAutoDetectLongPolling",e.experimentalAutoDetectLongPolling),this.experimentalForceLongPolling=!!e.experimentalForceLongPolling,this.experimentalForceLongPolling?this.experimentalAutoDetectLongPolling=!1:e.experimentalAutoDetectLongPolling===void 0?this.experimentalAutoDetectLongPolling=!0:this.experimentalAutoDetectLongPolling=!!e.experimentalAutoDetectLongPolling,this.experimentalLongPollingOptions=oS((r=e.experimentalLongPollingOptions)!==null&&r!==void 0?r:{}),function(s){if(s.timeoutSeconds!==void 0){if(isNaN(s.timeoutSeconds))throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (must not be NaN)`);if(s.timeoutSeconds<5)throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (minimum allowed value is 5)`);if(s.timeoutSeconds>30)throw new X(V.INVALID_ARGUMENT,`invalid long polling timeout: ${s.timeoutSeconds} (maximum allowed value is 30)`)}}(this.experimentalLongPollingOptions),this.useFetchStreams=!!e.useFetchStreams}isEqual(e){return this.host===e.host&&this.ssl===e.ssl&&this.credentials===e.credentials&&this.cacheSizeBytes===e.cacheSizeBytes&&this.experimentalForceLongPolling===e.experimentalForceLongPolling&&this.experimentalAutoDetectLongPolling===e.experimentalAutoDetectLongPolling&&function(r,i){return r.timeoutSeconds===i.timeoutSeconds}(this.experimentalLongPollingOptions,e.experimentalLongPollingOptions)&&this.ignoreUndefinedProperties===e.ignoreUndefinedProperties&&this.useFetchStreams===e.useFetchStreams}}class xh{constructor(e,n,r,i){this._authCredentials=e,this._appCheckCredentials=n,this._databaseId=r,this._app=i,this.type="firestore-lite",this._persistenceKey="(lite)",this._settings=new l0({}),this._settingsFrozen=!1,this._terminateTask="notTerminated"}get app(){if(!this._app)throw new X(V.FAILED_PRECONDITION,"Firestore was not initialized using the Firebase SDK. 'app' is not available");return this._app}get _initialized(){return this._settingsFrozen}get _terminated(){return this._terminateTask!=="notTerminated"}_setSettings(e){if(this._settingsFrozen)throw new X(V.FAILED_PRECONDITION,"Firestore has already been started and its settings can no longer be changed. You can only modify settings before calling any other methods on a Firestore object.");this._settings=new l0(e),e.credentials!==void 0&&(this._authCredentials=function(r){if(!r)return new $P;switch(r.type){case"firstParty":return new GP(r.sessionIndex||"0",r.iamToken||null,r.authTokenFactory||null);case"provider":return r.client;default:throw new X(V.INVALID_ARGUMENT,"makeAuthCredentialsProvider failed due to invalid credential type")}}(e.credentials))}_getSettings(){return this._settings}_freezeSettings(){return this._settingsFrozen=!0,this._settings}_delete(){return this._terminateTask==="notTerminated"&&(this._terminateTask=this._terminate()),this._terminateTask}async _restart(){this._terminateTask==="notTerminated"?await this._terminate():this._terminateTask="notTerminated"}toJSON(){return{app:this._app,databaseId:this._databaseId,settings:this._settings}}_terminate(){return function(n){const r=s0.get(n);r&&(J("ComponentProvider","Removing Datastore"),s0.delete(n),r.terminate())}(this),Promise.resolve()}}function b2(t,e,n,r={}){var i;const s=(t=ul(t,xh))._getSettings(),o=`${e}:${n}`;if(s.host!=="firestore.googleapis.com"&&s.host!==o&&ro("Host has been set in both settings() and connectFirestoreEmulator(), emulator host will be used."),t._setSettings(Object.assign(Object.assign({},s),{host:o,ssl:!1})),r.mockUserToken){let a,u;if(typeof r.mockUserToken=="string")a=r.mockUserToken,u=Nt.MOCK_USER;else{a=Om(r.mockUserToken,(i=t._app)===null||i===void 0?void 0:i.options.projectId);const c=r.mockUserToken.sub||r.mockUserToken.user_id;if(!c)throw new X(V.INVALID_ARGUMENT,"mockUserToken must contain 'sub' or 'user_id' field!");u=new Nt(c)}t._authCredentials=new WP(new oI(a,u))}}/**
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
 */class rs{constructor(e,n,r){this.converter=n,this._query=r,this.type="query",this.firestore=e}withConverter(e){return new rs(this.firestore,e,this._query)}}class En{constructor(e,n,r){this.converter=n,this._key=r,this.type="document",this.firestore=e}get _path(){return this._key.path}get id(){return this._key.path.lastSegment()}get path(){return this._key.path.canonicalString()}get parent(){return new ii(this.firestore,this.converter,this._key.path.popLast())}withConverter(e){return new En(this.firestore,e,this._key)}}class ii extends rs{constructor(e,n,r){super(e,n,_I(r)),this._path=r,this.type="collection"}get id(){return this._query.path.lastSegment()}get path(){return this._query.path.canonicalString()}get parent(){const e=this._path.popLast();return e.isEmpty()?null:new En(this.firestore,null,new ee(e))}withConverter(e){return new ii(this.firestore,e,this._path)}}function u0(t,e,...n){if(t=Ye(t),aS("collection","path",e),t instanceof xh){const r=Ve.fromString(e,...n);return a0(r),new ii(t,null,r)}{if(!(t instanceof En||t instanceof ii))throw new X(V.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(Ve.fromString(e,...n));return a0(r),new ii(t.firestore,null,r)}}function lS(t,e,...n){if(t=Ye(t),arguments.length===1&&(e=aI.newId()),aS("doc","path",e),t instanceof xh){const r=Ve.fromString(e,...n);return o0(r),new En(t,null,new ee(r))}{if(!(t instanceof En||t instanceof ii))throw new X(V.INVALID_ARGUMENT,"Expected first argument to collection() to be a CollectionReference, a DocumentReference or FirebaseFirestore");const r=t._path.child(Ve.fromString(e,...n));return o0(r),new En(t.firestore,t instanceof ii?t.converter:null,new ee(r))}}/**
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
 */class c0{constructor(e=Promise.resolve()){this.Pu=[],this.Iu=!1,this.Tu=[],this.Eu=null,this.du=!1,this.Au=!1,this.Ru=[],this.t_=new $I(this,"async_queue_retry"),this.Vu=()=>{const r=Ud();r&&J("AsyncQueue","Visibility state changed to "+r.visibilityState),this.t_.jo()},this.mu=e;const n=Ud();n&&typeof n.addEventListener=="function"&&n.addEventListener("visibilitychange",this.Vu)}get isShuttingDown(){return this.Iu}enqueueAndForget(e){this.enqueue(e)}enqueueAndForgetEvenWhileRestricted(e){this.fu(),this.gu(e)}enterRestrictedMode(e){if(!this.Iu){this.Iu=!0,this.Au=e||!1;const n=Ud();n&&typeof n.removeEventListener=="function"&&n.removeEventListener("visibilitychange",this.Vu)}}enqueue(e){if(this.fu(),this.Iu)return new Promise(()=>{});const n=new ni;return this.gu(()=>this.Iu&&this.Au?Promise.resolve():(e().then(n.resolve,n.reject),n.promise)).then(()=>n.promise)}enqueueRetryable(e){this.enqueueAndForget(()=>(this.Pu.push(e),this.pu()))}async pu(){if(this.Pu.length!==0){try{await this.Pu[0](),this.Pu.shift(),this.t_.reset()}catch(e){if(!El(e))throw e;J("AsyncQueue","Operation failed with retryable error: "+e)}this.Pu.length>0&&this.t_.Go(()=>this.pu())}}gu(e){const n=this.mu.then(()=>(this.du=!0,e().catch(r=>{this.Eu=r,this.du=!1;const i=function(o){let a=o.message||"";return o.stack&&(a=o.stack.includes(o.message)?o.stack:o.message+`
`+o.stack),a}(r);throw Er("INTERNAL UNHANDLED ERROR: ",i),r}).then(r=>(this.du=!1,r))));return this.mu=n,n}enqueueAfterDelay(e,n,r){this.fu(),this.Ru.indexOf(e)>-1&&(n=0);const i=rg.createAndSchedule(this,e,n,r,s=>this.yu(s));return this.Tu.push(i),i}fu(){this.Eu&&oe()}verifyOperationInProgress(){}async wu(){let e;do e=this.mu,await e;while(e!==this.mu)}Su(e){for(const n of this.Tu)if(n.timerId===e)return!0;return!1}bu(e){return this.wu().then(()=>{this.Tu.sort((n,r)=>n.targetTimeMs-r.targetTimeMs);for(const n of this.Tu)if(n.skipDelay(),e!=="all"&&n.timerId===e)break;return this.wu()})}Du(e){this.Ru.push(e)}yu(e){const n=this.Tu.indexOf(e);this.Tu.splice(n,1)}}class Ah extends xh{constructor(e,n,r,i){super(e,n,r,i),this.type="firestore",this._queue=new c0,this._persistenceKey=(i==null?void 0:i.name)||"[DEFAULT]"}async _terminate(){if(this._firestoreClient){const e=this._firestoreClient.terminate();this._queue=new c0(e),this._firestoreClient=void 0,await e}}}function N2(t,e){const n=typeof t=="object"?t:_h(),r=typeof t=="string"?t:"(default)",i=vl(n,"firestore").getImmediate({identifier:r});if(!i._initialized){const s=Dm("firestore");s&&b2(i,...s)}return i}function uS(t){if(t._terminated)throw new X(V.FAILED_PRECONDITION,"The client has already been terminated.");return t._firestoreClient||D2(t),t._firestoreClient}function D2(t){var e,n,r;const i=t._freezeSettings(),s=function(a,u,c,h){return new ob(a,u,c,h.host,h.ssl,h.experimentalForceLongPolling,h.experimentalAutoDetectLongPolling,oS(h.experimentalLongPollingOptions),h.useFetchStreams)}(t._databaseId,((e=t._app)===null||e===void 0?void 0:e.options.appId)||"",t._persistenceKey,i);t._componentsProvider||!((n=i.localCache)===null||n===void 0)&&n._offlineComponentProvider&&(!((r=i.localCache)===null||r===void 0)&&r._onlineComponentProvider)&&(t._componentsProvider={_offline:i.localCache._offlineComponentProvider,_online:i.localCache._onlineComponentProvider}),t._firestoreClient=new k2(t._authCredentials,t._appCheckCredentials,t._queue,s,t._componentsProvider&&function(a){const u=a==null?void 0:a._online.build();return{_offline:a==null?void 0:a._offline.build(u),_online:u}}(t._componentsProvider))}/**
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
 */class uo{constructor(e){this._byteString=e}static fromBase64String(e){try{return new uo(Ct.fromBase64String(e))}catch(n){throw new X(V.INVALID_ARGUMENT,"Failed to construct data from Base64 string: "+n)}}static fromUint8Array(e){return new uo(Ct.fromUint8Array(e))}toBase64(){return this._byteString.toBase64()}toUint8Array(){return this._byteString.toUint8Array()}toString(){return"Bytes(base64: "+this.toBase64()+")"}isEqual(e){return this._byteString.isEqual(e._byteString)}}/**
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
 */class ag{constructor(...e){for(let n=0;n<e.length;++n)if(e[n].length===0)throw new X(V.INVALID_ARGUMENT,"Invalid field name at argument $(i + 1). Field names must not be empty.");this._internalPath=new Tt(e)}isEqual(e){return this._internalPath.isEqual(e._internalPath)}}/**
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
 */class lg{constructor(e){this._methodName=e}}/**
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
 */class ug{constructor(e,n){if(!isFinite(e)||e<-90||e>90)throw new X(V.INVALID_ARGUMENT,"Latitude must be a number between -90 and 90, but was: "+e);if(!isFinite(n)||n<-180||n>180)throw new X(V.INVALID_ARGUMENT,"Longitude must be a number between -180 and 180, but was: "+n);this._lat=e,this._long=n}get latitude(){return this._lat}get longitude(){return this._long}isEqual(e){return this._lat===e._lat&&this._long===e._long}toJSON(){return{latitude:this._lat,longitude:this._long}}_compareTo(e){return we(this._lat,e._lat)||we(this._long,e._long)}}/**
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
 */class cg{constructor(e){this._values=(e||[]).map(n=>n)}toArray(){return this._values.map(e=>e)}isEqual(e){return function(r,i){if(r.length!==i.length)return!1;for(let s=0;s<r.length;++s)if(r[s]!==i[s])return!1;return!0}(this._values,e._values)}}/**
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
 */const O2=/^__.*__$/;class M2{constructor(e,n,r){this.data=e,this.fieldMask=n,this.fieldTransforms=r}toMutation(e,n){return this.fieldMask!==null?new ts(e,this.data,this.fieldMask,n,this.fieldTransforms):new Tl(e,this.data,n,this.fieldTransforms)}}function cS(t){switch(t){case 0:case 2:case 1:return!0;case 3:case 4:return!1;default:throw oe()}}class hg{constructor(e,n,r,i,s,o){this.settings=e,this.databaseId=n,this.serializer=r,this.ignoreUndefinedProperties=i,s===void 0&&this.vu(),this.fieldTransforms=s||[],this.fieldMask=o||[]}get path(){return this.settings.path}get Cu(){return this.settings.Cu}Fu(e){return new hg(Object.assign(Object.assign({},this.settings),e),this.databaseId,this.serializer,this.ignoreUndefinedProperties,this.fieldTransforms,this.fieldMask)}Mu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.Ou(e),i}Nu(e){var n;const r=(n=this.path)===null||n===void 0?void 0:n.child(e),i=this.Fu({path:r,xu:!1});return i.vu(),i}Lu(e){return this.Fu({path:void 0,xu:!0})}Bu(e){return Dc(e,this.settings.methodName,this.settings.ku||!1,this.path,this.settings.qu)}contains(e){return this.fieldMask.find(n=>e.isPrefixOf(n))!==void 0||this.fieldTransforms.find(n=>e.isPrefixOf(n.field))!==void 0}vu(){if(this.path)for(let e=0;e<this.path.length;e++)this.Ou(this.path.get(e))}Ou(e){if(e.length===0)throw this.Bu("Document fields must not be empty");if(cS(this.Cu)&&O2.test(e))throw this.Bu('Document fields cannot begin and end with "__"')}}class L2{constructor(e,n,r){this.databaseId=e,this.ignoreUndefinedProperties=n,this.serializer=r||Sh(e)}Qu(e,n,r,i=!1){return new hg({Cu:e,methodName:n,qu:r,path:Tt.emptyPath(),xu:!1,ku:i},this.databaseId,this.serializer,this.ignoreUndefinedProperties)}}function hS(t){const e=t._freezeSettings(),n=Sh(t._databaseId);return new L2(t._databaseId,!!e.ignoreUndefinedProperties,n)}function F2(t,e,n,r,i,s={}){const o=t.Qu(s.merge||s.mergeFields?2:0,e,n,i);pS("Data must be an object, but it was:",o,r);const a=dS(r,o);let u,c;if(s.merge)u=new Nn(o.fieldMask),c=o.fieldTransforms;else if(s.mergeFields){const h=[];for(const f of s.mergeFields){const m=U2(e,f,n);if(!o.contains(m))throw new X(V.INVALID_ARGUMENT,`Field '${m}' is specified in your field mask but missing from your input data.`);z2(h,m)||h.push(m)}u=new Nn(h),c=o.fieldTransforms.filter(f=>u.covers(f.field))}else u=null,c=o.fieldTransforms;return new M2(new pn(a),u,c)}class dg extends lg{_toFieldTransform(e){return new bb(e.path,new ol)}isEqual(e){return e instanceof dg}}function V2(t,e,n,r=!1){return fg(n,t.Qu(r?4:3,e))}function fg(t,e){if(fS(t=Ye(t)))return pS("Unsupported field value:",e,t),dS(t,e);if(t instanceof lg)return function(r,i){if(!cS(i.Cu))throw i.Bu(`${r._methodName}() can only be used with update() and set()`);if(!i.path)throw i.Bu(`${r._methodName}() is not currently supported inside arrays`);const s=r._toFieldTransform(i);s&&i.fieldTransforms.push(s)}(t,e),null;if(t===void 0&&e.ignoreUndefinedProperties)return null;if(e.path&&e.fieldMask.push(e.path),t instanceof Array){if(e.settings.xu&&e.Cu!==4)throw e.Bu("Nested arrays are not supported");return function(r,i){const s=[];let o=0;for(const a of r){let u=fg(a,i.Lu(o));u==null&&(u={nullValue:"NULL_VALUE"}),s.push(u),o++}return{arrayValue:{values:s}}}(t,e)}return function(r,i){if((r=Ye(r))===null)return{nullValue:"NULL_VALUE"};if(typeof r=="number")return xb(i.serializer,r);if(typeof r=="boolean")return{booleanValue:r};if(typeof r=="string")return{stringValue:r};if(r instanceof Date){const s=ut.fromDate(r);return{timestampValue:Pc(i.serializer,s)}}if(r instanceof ut){const s=new ut(r.seconds,1e3*Math.floor(r.nanoseconds/1e3));return{timestampValue:Pc(i.serializer,s)}}if(r instanceof ug)return{geoPointValue:{latitude:r.latitude,longitude:r.longitude}};if(r instanceof uo)return{bytesValue:OI(i.serializer,r._byteString)};if(r instanceof En){const s=i.databaseId,o=r.firestore._databaseId;if(!o.isEqual(s))throw i.Bu(`Document reference is for database ${o.projectId}/${o.database} but should be for database ${s.projectId}/${s.database}`);return{referenceValue:Qm(r.firestore._databaseId||i.databaseId,r._key.path)}}if(r instanceof cg)return function(o,a){return{mapValue:{fields:{__type__:{stringValue:"__vector__"},value:{arrayValue:{values:o.toArray().map(u=>{if(typeof u!="number")throw a.Bu("VectorValues must only contain numeric values.");return qm(a.serializer,u)})}}}}}}(r,i);throw i.Bu(`Unsupported field value: ${Rh(r)}`)}(t,e)}function dS(t,e){const n={};return lI(t)?e.path&&e.path.length>0&&e.fieldMask.push(e.path):vo(t,(r,i)=>{const s=fg(i,e.Mu(r));s!=null&&(n[r]=s)}),{mapValue:{fields:n}}}function fS(t){return!(typeof t!="object"||t===null||t instanceof Array||t instanceof Date||t instanceof ut||t instanceof ug||t instanceof uo||t instanceof En||t instanceof lg||t instanceof cg)}function pS(t,e,n){if(!fS(n)||!function(i){return typeof i=="object"&&i!==null&&(Object.getPrototypeOf(i)===Object.prototype||Object.getPrototypeOf(i)===null)}(n)){const r=Rh(n);throw r==="an object"?e.Bu(t+" a custom object"):e.Bu(t+" "+r)}}function U2(t,e,n){if((e=Ye(e))instanceof ag)return e._internalPath;if(typeof e=="string")return mS(t,e);throw Dc("Field path arguments must be of type string or ",t,!1,void 0,n)}const j2=new RegExp("[~\\*/\\[\\]]");function mS(t,e,n){if(e.search(j2)>=0)throw Dc(`Invalid field path (${e}). Paths must not contain '~', '*', '/', '[', or ']'`,t,!1,void 0,n);try{return new ag(...e.split("."))._internalPath}catch{throw Dc(`Invalid field path (${e}). Paths must not be empty, begin with '.', end with '.', or contain '..'`,t,!1,void 0,n)}}function Dc(t,e,n,r,i){const s=r&&!r.isEmpty(),o=i!==void 0;let a=`Function ${e}() called with invalid data`;n&&(a+=" (via `toFirestore()`)"),a+=". ";let u="";return(s||o)&&(u+=" (found",s&&(u+=` in field ${r}`),o&&(u+=` in document ${i}`),u+=")"),new X(V.INVALID_ARGUMENT,a+t+u)}function z2(t,e){return t.some(n=>n.isEqual(e))}/**
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
 */class gS{constructor(e,n,r,i,s){this._firestore=e,this._userDataWriter=n,this._key=r,this._document=i,this._converter=s}get id(){return this._key.path.lastSegment()}get ref(){return new En(this._firestore,this._converter,this._key)}exists(){return this._document!==null}data(){if(this._document){if(this._converter){const e=new B2(this._firestore,this._userDataWriter,this._key,this._document,null);return this._converter.fromFirestore(e)}return this._userDataWriter.convertValue(this._document.data.value)}}get(e){if(this._document){const n=this._document.data.field(pg("DocumentSnapshot.get",e));if(n!==null)return this._userDataWriter.convertValue(n)}}}class B2 extends gS{data(){return super.data()}}function pg(t,e){return typeof e=="string"?mS(t,e):e instanceof ag?e._internalPath:e._delegate._internalPath}/**
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
 */function $2(t){if(t.limitType==="L"&&t.explicitOrderBy.length===0)throw new X(V.UNIMPLEMENTED,"limitToLast() queries require specifying at least one orderBy() clause")}class mg{}class _S extends mg{}function W2(t,e,...n){let r=[];e instanceof mg&&r.push(e),r=r.concat(n),function(s){const o=s.filter(u=>u instanceof _g).length,a=s.filter(u=>u instanceof gg).length;if(o>1||o>0&&a>0)throw new X(V.INVALID_ARGUMENT,"InvalidQuery. When using composite filters, you cannot use more than one filter at the top level. Consider nesting the multiple filters within an `and(...)` statement. For example: change `query(query, where(...), or(...))` to `query(query, and(where(...), or(...)))`.")}(r);for(const i of r)t=i._apply(t);return t}class gg extends _S{constructor(e,n,r){super(),this._field=e,this._op=n,this._value=r,this.type="where"}static _create(e,n,r){return new gg(e,n,r)}_apply(e){const n=this._parse(e);return yS(e._query,n),new rs(e.firestore,e.converter,lp(e._query,n))}_parse(e){const n=hS(e.firestore);return function(s,o,a,u,c,h,f){let m;if(c.isKeyField()){if(h==="array-contains"||h==="array-contains-any")throw new X(V.INVALID_ARGUMENT,`Invalid Query. You can't perform '${h}' queries on documentId().`);if(h==="in"||h==="not-in"){d0(f,h);const w=[];for(const S of f)w.push(h0(u,s,S));m={arrayValue:{values:w}}}else m=h0(u,s,f)}else h!=="in"&&h!=="not-in"&&h!=="array-contains-any"||d0(f,h),m=V2(a,o,f,h==="in"||h==="not-in");return rt.create(c,h,m)}(e._query,"where",n,e.firestore._databaseId,this._field,this._op,this._value)}}class _g extends mg{constructor(e,n){super(),this.type=e,this._queryConstraints=n}static _create(e,n){return new _g(e,n)}_parse(e){const n=this._queryConstraints.map(r=>r._parse(e)).filter(r=>r.getFilters().length>0);return n.length===1?n[0]:Vn.create(n,this._getOperator())}_apply(e){const n=this._parse(e);return n.getFilters().length===0?e:(function(i,s){let o=i;const a=s.getFlattenedFilters();for(const u of a)yS(o,u),o=lp(o,u)}(e._query,n),new rs(e.firestore,e.converter,lp(e._query,n)))}_getQueryConstraints(){return this._queryConstraints}_getOperator(){return this.type==="and"?"and":"or"}}class yg extends _S{constructor(e,n){super(),this._field=e,this._direction=n,this.type="orderBy"}static _create(e,n){return new yg(e,n)}_apply(e){const n=function(i,s,o){if(i.startAt!==null)throw new X(V.INVALID_ARGUMENT,"Invalid query. You must not call startAt() or startAfter() before calling orderBy().");if(i.endAt!==null)throw new X(V.INVALID_ARGUMENT,"Invalid query. You must not call endAt() or endBefore() before calling orderBy().");return new sl(s,o)}(e._query,this._field,this._direction);return new rs(e.firestore,e.converter,function(i,s){const o=i.explicitOrderBy.concat([s]);return new wo(i.path,i.collectionGroup,o,i.filters.slice(),i.limit,i.limitType,i.startAt,i.endAt)}(e._query,n))}}function q2(t,e="asc"){const n=e,r=pg("orderBy",t);return yg._create(r,n)}function h0(t,e,n){if(typeof(n=Ye(n))=="string"){if(n==="")throw new X(V.INVALID_ARGUMENT,"Invalid query. When querying with documentId(), you must provide a valid document ID, but it was an empty string.");if(!yI(e)&&n.indexOf("/")!==-1)throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying a collection by documentId(), you must provide a plain document ID, but '${n}' contains a '/' character.`);const r=e.path.child(Ve.fromString(n));if(!ee.isDocumentKey(r))throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying a collection group by documentId(), the value provided must result in a valid document path, but '${r}' is not because it has an odd number of segments (${r.length}).`);return Nv(t,new ee(r))}if(n instanceof En)return Nv(t,n._key);throw new X(V.INVALID_ARGUMENT,`Invalid query. When querying with documentId(), you must provide a valid string or a DocumentReference, but it was: ${Rh(n)}.`)}function d0(t,e){if(!Array.isArray(t)||t.length===0)throw new X(V.INVALID_ARGUMENT,`Invalid Query. A non-empty array is required for '${e.toString()}' filters.`)}function yS(t,e){const n=function(i,s){for(const o of i)for(const a of o.getFlattenedFilters())if(s.indexOf(a.op)>=0)return a.op;return null}(t.filters,function(i){switch(i){case"!=":return["!=","not-in"];case"array-contains-any":case"in":return["not-in"];case"not-in":return["array-contains-any","in","not-in","!="];default:return[]}}(e.op));if(n!==null)throw n===e.op?new X(V.INVALID_ARGUMENT,`Invalid query. You cannot use more than one '${e.op.toString()}' filter.`):new X(V.INVALID_ARGUMENT,`Invalid query. You cannot use '${e.op.toString()}' filters with '${n.toString()}' filters.`)}class H2{convertValue(e,n="none"){switch(Hi(e)){case 0:return null;case 1:return e.booleanValue;case 2:return Je(e.integerValue||e.doubleValue);case 3:return this.convertTimestamp(e.timestampValue);case 4:return this.convertServerTimestamp(e,n);case 5:return e.stringValue;case 6:return this.convertBytes(qi(e.bytesValue));case 7:return this.convertReference(e.referenceValue);case 8:return this.convertGeoPoint(e.geoPointValue);case 9:return this.convertArray(e.arrayValue,n);case 11:return this.convertObject(e.mapValue,n);case 10:return this.convertVectorValue(e.mapValue);default:throw oe()}}convertObject(e,n){return this.convertObjectMap(e.fields,n)}convertObjectMap(e,n="none"){const r={};return vo(e,(i,s)=>{r[i]=this.convertValue(s,n)}),r}convertVectorValue(e){var n,r,i;const s=(i=(r=(n=e.fields)===null||n===void 0?void 0:n.value.arrayValue)===null||r===void 0?void 0:r.values)===null||i===void 0?void 0:i.map(o=>Je(o.doubleValue));return new cg(s)}convertGeoPoint(e){return new ug(Je(e.latitude),Je(e.longitude))}convertArray(e,n){return(e.values||[]).map(r=>this.convertValue(r,n))}convertServerTimestamp(e,n){switch(n){case"previous":const r=zm(e);return r==null?null:this.convertValue(r,n);case"estimate":return this.convertTimestamp(nl(e));default:return null}}convertTimestamp(e){const n=hi(e);return new ut(n.seconds,n.nanos)}convertDocumentKey(e,n){const r=Ve.fromString(e);ke(jI(r));const i=new rl(r.get(1),r.get(3)),s=new ee(r.popFirst(5));return i.isEqual(n)||Er(`Document ${s} contains a document reference within a different database (${i.projectId}/${i.database}) which is not supported. It will be treated as a reference in the current database (${n.projectId}/${n.database}) instead.`),s}}/**
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
 */function G2(t,e,n){let r;return r=t?t.toFirestore(e):e,r}/**
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
 */class Eu{constructor(e,n){this.hasPendingWrites=e,this.fromCache=n}isEqual(e){return this.hasPendingWrites===e.hasPendingWrites&&this.fromCache===e.fromCache}}class K2 extends gS{constructor(e,n,r,i,s,o){super(e,n,r,i,o),this._firestore=e,this._firestoreImpl=e,this.metadata=s}exists(){return super.exists()}data(e={}){if(this._document){if(this._converter){const n=new qu(this._firestore,this._userDataWriter,this._key,this._document,this.metadata,null);return this._converter.fromFirestore(n,e)}return this._userDataWriter.convertValue(this._document.data.value,e.serverTimestamps)}}get(e,n={}){if(this._document){const r=this._document.data.field(pg("DocumentSnapshot.get",e));if(r!==null)return this._userDataWriter.convertValue(r,n.serverTimestamps)}}}class qu extends K2{data(e={}){return super.data(e)}}class Q2{constructor(e,n,r,i){this._firestore=e,this._userDataWriter=n,this._snapshot=i,this.metadata=new Eu(i.hasPendingWrites,i.fromCache),this.query=r}get docs(){const e=[];return this.forEach(n=>e.push(n)),e}get size(){return this._snapshot.docs.size}get empty(){return this.size===0}forEach(e,n){this._snapshot.docs.forEach(r=>{e.call(n,new qu(this._firestore,this._userDataWriter,r.key,r,new Eu(this._snapshot.mutatedKeys.has(r.key),this._snapshot.fromCache),this.query.converter))})}docChanges(e={}){const n=!!e.includeMetadataChanges;if(n&&this._snapshot.excludesMetadataChanges)throw new X(V.INVALID_ARGUMENT,"To include metadata changes with your document changes, you must also pass { includeMetadataChanges:true } to onSnapshot().");return this._cachedChanges&&this._cachedChangesIncludeMetadataChanges===n||(this._cachedChanges=function(i,s){if(i._snapshot.oldDocs.isEmpty()){let o=0;return i._snapshot.docChanges.map(a=>{const u=new qu(i._firestore,i._userDataWriter,a.doc.key,a.doc,new Eu(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);return a.doc,{type:"added",doc:u,oldIndex:-1,newIndex:o++}})}{let o=i._snapshot.oldDocs;return i._snapshot.docChanges.filter(a=>s||a.type!==3).map(a=>{const u=new qu(i._firestore,i._userDataWriter,a.doc.key,a.doc,new Eu(i._snapshot.mutatedKeys.has(a.doc.key),i._snapshot.fromCache),i.query.converter);let c=-1,h=-1;return a.type!==0&&(c=o.indexOf(a.doc.key),o=o.delete(a.doc.key)),a.type!==1&&(o=o.add(a.doc),h=o.indexOf(a.doc.key)),{type:Y2(a.type),doc:u,oldIndex:c,newIndex:h}})}}(this,n),this._cachedChangesIncludeMetadataChanges=n),this._cachedChanges}}function Y2(t){switch(t){case 0:return"added";case 2:case 3:return"modified";case 1:return"removed";default:return oe()}}class X2 extends H2{constructor(e){super(),this.firestore=e}convertBytes(e){return new uo(e)}convertReference(e){const n=this.convertDocumentKey(e,this.firestore._databaseId);return new En(this.firestore,null,n)}}function J2(t){t=ul(t,rs);const e=ul(t.firestore,Ah),n=uS(e),r=new X2(e);return $2(t._query),A2(n,t._query).then(i=>new Q2(e,r,t,i))}function Z2(t){return vS(ul(t.firestore,Ah),[new Hm(t._key,Kn.none())])}function eD(t,e){const n=ul(t.firestore,Ah),r=lS(t),i=G2(t.converter,e);return vS(n,[F2(hS(t.firestore),"addDoc",r._key,i,t.converter!==null,{}).toMutation(r._key,Kn.exists(!1))]).then(()=>r)}function vS(t,e){return function(r,i){const s=new ni;return r.asyncQueue.enqueueAndForget(async()=>g2(await R2(r),i,s)),s.promise}(uS(t),e)}function tD(){return new dg("serverTimestamp")}(function(e,n=!0){(function(i){yo=i})(yi),ui(new vr("firestore",(r,{instanceIdentifier:i,options:s})=>{const o=r.getProvider("app").getImmediate(),a=new Ah(new qP(r.getProvider("auth-internal")),new QP(r.getProvider("app-check-internal")),function(c,h){if(!Object.prototype.hasOwnProperty.apply(c.options,["projectId"]))throw new X(V.INVALID_ARGUMENT,'"projectId" not provided in firebase.initializeApp.');return new rl(c.options.projectId,h)}(o,i),o);return s=Object.assign({useFetchStreams:n},s),a._setSettings(s),a},"PUBLIC").setMultipleInstances(!0)),wn(Rv,"4.7.3",e),wn(Rv,"4.7.3","esm2017")})();/**
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
 */const wS="firebasestorage.googleapis.com",ES="storageBucket",nD=2*60*1e3,rD=10*60*1e3,iD=1e3;/**
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
 */class Ge extends Zn{constructor(e,n,r=0){super(zd(e),`Firebase Storage: ${n} (${zd(e)})`),this.status_=r,this.customData={serverResponse:null},this._baseMessage=this.message,Object.setPrototypeOf(this,Ge.prototype)}get status(){return this.status_}set status(e){this.status_=e}_codeEquals(e){return zd(e)===this.code}get serverResponse(){return this.customData.serverResponse}set serverResponse(e){this.customData.serverResponse=e,this.customData.serverResponse?this.message=`${this._baseMessage}
${this.customData.serverResponse}`:this.message=this._baseMessage}}var je;(function(t){t.UNKNOWN="unknown",t.OBJECT_NOT_FOUND="object-not-found",t.BUCKET_NOT_FOUND="bucket-not-found",t.PROJECT_NOT_FOUND="project-not-found",t.QUOTA_EXCEEDED="quota-exceeded",t.UNAUTHENTICATED="unauthenticated",t.UNAUTHORIZED="unauthorized",t.UNAUTHORIZED_APP="unauthorized-app",t.RETRY_LIMIT_EXCEEDED="retry-limit-exceeded",t.INVALID_CHECKSUM="invalid-checksum",t.CANCELED="canceled",t.INVALID_EVENT_NAME="invalid-event-name",t.INVALID_URL="invalid-url",t.INVALID_DEFAULT_BUCKET="invalid-default-bucket",t.NO_DEFAULT_BUCKET="no-default-bucket",t.CANNOT_SLICE_BLOB="cannot-slice-blob",t.SERVER_FILE_WRONG_SIZE="server-file-wrong-size",t.NO_DOWNLOAD_URL="no-download-url",t.INVALID_ARGUMENT="invalid-argument",t.INVALID_ARGUMENT_COUNT="invalid-argument-count",t.APP_DELETED="app-deleted",t.INVALID_ROOT_OPERATION="invalid-root-operation",t.INVALID_FORMAT="invalid-format",t.INTERNAL_ERROR="internal-error",t.UNSUPPORTED_ENVIRONMENT="unsupported-environment"})(je||(je={}));function zd(t){return"storage/"+t}function vg(){const t="An unknown error occurred, please check the error payload for server response.";return new Ge(je.UNKNOWN,t)}function sD(t){return new Ge(je.OBJECT_NOT_FOUND,"Object '"+t+"' does not exist.")}function oD(t){return new Ge(je.QUOTA_EXCEEDED,"Quota for bucket '"+t+"' exceeded, please view quota on https://firebase.google.com/pricing/.")}function aD(){const t="User is not authenticated, please authenticate using Firebase Authentication and try again.";return new Ge(je.UNAUTHENTICATED,t)}function lD(){return new Ge(je.UNAUTHORIZED_APP,"This app does not have permission to access Firebase Storage on this project.")}function uD(t){return new Ge(je.UNAUTHORIZED,"User does not have permission to access '"+t+"'.")}function TS(){return new Ge(je.RETRY_LIMIT_EXCEEDED,"Max retry time for operation exceeded, please try again.")}function IS(){return new Ge(je.CANCELED,"User canceled the upload/download.")}function cD(t){return new Ge(je.INVALID_URL,"Invalid URL '"+t+"'.")}function hD(t){return new Ge(je.INVALID_DEFAULT_BUCKET,"Invalid default bucket '"+t+"'.")}function dD(){return new Ge(je.NO_DEFAULT_BUCKET,"No default bucket found. Did you set the '"+ES+"' property when initializing the app?")}function SS(){return new Ge(je.CANNOT_SLICE_BLOB,"Cannot slice blob for upload. Please retry the upload.")}function fD(){return new Ge(je.SERVER_FILE_WRONG_SIZE,"Server recorded incorrect upload file size, please retry the upload.")}function pD(){return new Ge(je.NO_DOWNLOAD_URL,"The given file does not have any download URLs.")}function mD(t){return new Ge(je.UNSUPPORTED_ENVIRONMENT,`${t} is missing. Make sure to install the required polyfills. See https://firebase.google.com/docs/web/environments-js-sdk#polyfills for more information.`)}function yp(t){return new Ge(je.INVALID_ARGUMENT,t)}function kS(){return new Ge(je.APP_DELETED,"The Firebase app was deleted.")}function gD(t){return new Ge(je.INVALID_ROOT_OPERATION,"The operation '"+t+"' cannot be performed on a root reference, create a non-root reference using child, such as .child('file.png').")}function Ra(t,e){return new Ge(je.INVALID_FORMAT,"String does not match format '"+t+"': "+e)}function Zo(t){throw new Ge(je.INTERNAL_ERROR,"Internal error: "+t)}/**
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
 */class an{constructor(e,n){this.bucket=e,this.path_=n}get path(){return this.path_}get isRoot(){return this.path.length===0}fullServerUrl(){const e=encodeURIComponent;return"/b/"+e(this.bucket)+"/o/"+e(this.path)}bucketOnlyServerUrl(){return"/b/"+encodeURIComponent(this.bucket)+"/o"}static makeFromBucketSpec(e,n){let r;try{r=an.makeFromUrl(e,n)}catch{return new an(e,"")}if(r.path==="")return r;throw hD(e)}static makeFromUrl(e,n){let r=null;const i="([A-Za-z0-9.\\-_]+)";function s(M){M.path.charAt(M.path.length-1)==="/"&&(M.path_=M.path_.slice(0,-1))}const o="(/(.*))?$",a=new RegExp("^gs://"+i+o,"i"),u={bucket:1,path:3};function c(M){M.path_=decodeURIComponent(M.path)}const h="v[A-Za-z0-9_]+",f=n.replace(/[.]/g,"\\."),m="(/([^?#]*).*)?$",w=new RegExp(`^https?://${f}/${h}/b/${i}/o${m}`,"i"),S={bucket:1,path:3},P=n===wS?"(?:storage.googleapis.com|storage.cloud.google.com)":n,D="([^?#]*)",k=new RegExp(`^https?://${P}/${i}/${D}`,"i"),R=[{regex:a,indices:u,postModify:s},{regex:w,indices:S,postModify:c},{regex:k,indices:{bucket:1,path:2},postModify:c}];for(let M=0;M<R.length;M++){const z=R[M],U=z.regex.exec(e);if(U){const v=U[z.indices.bucket];let _=U[z.indices.path];_||(_=""),r=new an(v,_),z.postModify(r);break}}if(r==null)throw cD(e);return r}}class _D{constructor(e){this.promise_=Promise.reject(e)}getPromise(){return this.promise_}cancel(e=!1){}}/**
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
 */function yD(t,e,n){let r=1,i=null,s=null,o=!1,a=0;function u(){return a===2}let c=!1;function h(...D){c||(c=!0,e.apply(null,D))}function f(D){i=setTimeout(()=>{i=null,t(w,u())},D)}function m(){s&&clearTimeout(s)}function w(D,...k){if(c){m();return}if(D){m(),h.call(null,D,...k);return}if(u()||o){m(),h.call(null,D,...k);return}r<64&&(r*=2);let R;a===1?(a=2,R=0):R=(r+Math.random())*1e3,f(R)}let S=!1;function P(D){S||(S=!0,m(),!c&&(i!==null?(D||(a=2),clearTimeout(i),f(0)):D||(a=1)))}return f(0),s=setTimeout(()=>{o=!0,P(!0)},n),P}function vD(t){t(!1)}/**
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
 */function wD(t){return t!==void 0}function ED(t){return typeof t=="function"}function TD(t){return typeof t=="object"&&!Array.isArray(t)}function Ph(t){return typeof t=="string"||t instanceof String}function f0(t){return wg()&&t instanceof Blob}function wg(){return typeof Blob<"u"}function p0(t,e,n,r){if(r<e)throw yp(`Invalid value for '${t}'. Expected ${e} or greater.`);if(r>n)throw yp(`Invalid value for '${t}'. Expected ${n} or less.`)}/**
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
 */function Io(t,e,n){let r=e;return n==null&&(r=`https://${e}`),`${n}://${r}/v0${t}`}function CS(t){const e=encodeURIComponent;let n="?";for(const r in t)if(t.hasOwnProperty(r)){const i=e(r)+"="+e(t[r]);n=n+i+"&"}return n=n.slice(0,-1),n}var Vi;(function(t){t[t.NO_ERROR=0]="NO_ERROR",t[t.NETWORK_ERROR=1]="NETWORK_ERROR",t[t.ABORT=2]="ABORT"})(Vi||(Vi={}));/**
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
 */function RS(t,e){const n=t>=500&&t<600,i=[408,429].indexOf(t)!==-1,s=e.indexOf(t)!==-1;return n||i||s}/**
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
 */class ID{constructor(e,n,r,i,s,o,a,u,c,h,f,m=!0){this.url_=e,this.method_=n,this.headers_=r,this.body_=i,this.successCodes_=s,this.additionalRetryCodes_=o,this.callback_=a,this.errorCallback_=u,this.timeout_=c,this.progressCallback_=h,this.connectionFactory_=f,this.retry=m,this.pendingConnection_=null,this.backoffId_=null,this.canceled_=!1,this.appDelete_=!1,this.promise_=new Promise((w,S)=>{this.resolve_=w,this.reject_=S,this.start_()})}start_(){const e=(r,i)=>{if(i){r(!1,new Tu(!1,null,!0));return}const s=this.connectionFactory_();this.pendingConnection_=s;const o=a=>{const u=a.loaded,c=a.lengthComputable?a.total:-1;this.progressCallback_!==null&&this.progressCallback_(u,c)};this.progressCallback_!==null&&s.addUploadProgressListener(o),s.send(this.url_,this.method_,this.body_,this.headers_).then(()=>{this.progressCallback_!==null&&s.removeUploadProgressListener(o),this.pendingConnection_=null;const a=s.getErrorCode()===Vi.NO_ERROR,u=s.getStatus();if(!a||RS(u,this.additionalRetryCodes_)&&this.retry){const h=s.getErrorCode()===Vi.ABORT;r(!1,new Tu(!1,null,h));return}const c=this.successCodes_.indexOf(u)!==-1;r(!0,new Tu(c,s))})},n=(r,i)=>{const s=this.resolve_,o=this.reject_,a=i.connection;if(i.wasSuccessCode)try{const u=this.callback_(a,a.getResponse());wD(u)?s(u):s()}catch(u){o(u)}else if(a!==null){const u=vg();u.serverResponse=a.getErrorText(),this.errorCallback_?o(this.errorCallback_(a,u)):o(u)}else if(i.canceled){const u=this.appDelete_?kS():IS();o(u)}else{const u=TS();o(u)}};this.canceled_?n(!1,new Tu(!1,null,!0)):this.backoffId_=yD(e,n,this.timeout_)}getPromise(){return this.promise_}cancel(e){this.canceled_=!0,this.appDelete_=e||!1,this.backoffId_!==null&&vD(this.backoffId_),this.pendingConnection_!==null&&this.pendingConnection_.abort()}}class Tu{constructor(e,n,r){this.wasSuccessCode=e,this.connection=n,this.canceled=!!r}}function SD(t,e){e!==null&&e.length>0&&(t.Authorization="Firebase "+e)}function kD(t,e){t["X-Firebase-Storage-Version"]="webjs/"+(e??"AppManager")}function CD(t,e){e&&(t["X-Firebase-GMPID"]=e)}function RD(t,e){e!==null&&(t["X-Firebase-AppCheck"]=e)}function xD(t,e,n,r,i,s,o=!0){const a=CS(t.urlParams),u=t.url+a,c=Object.assign({},t.headers);return CD(c,e),SD(c,n),kD(c,s),RD(c,r),new ID(u,t.method,c,t.body,t.successCodes,t.additionalRetryCodes,t.handler,t.errorHandler,t.timeout,t.progressCallback,i,o)}/**
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
 */function AD(){return typeof BlobBuilder<"u"?BlobBuilder:typeof WebKitBlobBuilder<"u"?WebKitBlobBuilder:void 0}function PD(...t){const e=AD();if(e!==void 0){const n=new e;for(let r=0;r<t.length;r++)n.append(t[r]);return n.getBlob()}else{if(wg())return new Blob(t);throw new Ge(je.UNSUPPORTED_ENVIRONMENT,"This browser doesn't seem to support creating Blobs")}}function bD(t,e,n){return t.webkitSlice?t.webkitSlice(e,n):t.mozSlice?t.mozSlice(e,n):t.slice?t.slice(e,n):null}/**
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
 */function ND(t){if(typeof atob>"u")throw mD("base-64");return atob(t)}/**
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
 */const $n={RAW:"raw",BASE64:"base64",BASE64URL:"base64url",DATA_URL:"data_url"};class Bd{constructor(e,n){this.data=e,this.contentType=n||null}}function DD(t,e){switch(t){case $n.RAW:return new Bd(xS(e));case $n.BASE64:case $n.BASE64URL:return new Bd(AS(t,e));case $n.DATA_URL:return new Bd(MD(e),LD(e))}throw vg()}function xS(t){const e=[];for(let n=0;n<t.length;n++){let r=t.charCodeAt(n);if(r<=127)e.push(r);else if(r<=2047)e.push(192|r>>6,128|r&63);else if((r&64512)===55296)if(!(n<t.length-1&&(t.charCodeAt(n+1)&64512)===56320))e.push(239,191,189);else{const s=r,o=t.charCodeAt(++n);r=65536|(s&1023)<<10|o&1023,e.push(240|r>>18,128|r>>12&63,128|r>>6&63,128|r&63)}else(r&64512)===56320?e.push(239,191,189):e.push(224|r>>12,128|r>>6&63,128|r&63)}return new Uint8Array(e)}function OD(t){let e;try{e=decodeURIComponent(t)}catch{throw Ra($n.DATA_URL,"Malformed data URL.")}return xS(e)}function AS(t,e){switch(t){case $n.BASE64:{const i=e.indexOf("-")!==-1,s=e.indexOf("_")!==-1;if(i||s)throw Ra(t,"Invalid character '"+(i?"-":"_")+"' found: is it base64url encoded?");break}case $n.BASE64URL:{const i=e.indexOf("+")!==-1,s=e.indexOf("/")!==-1;if(i||s)throw Ra(t,"Invalid character '"+(i?"+":"/")+"' found: is it base64 encoded?");e=e.replace(/-/g,"+").replace(/_/g,"/");break}}let n;try{n=ND(e)}catch(i){throw i.message.includes("polyfill")?i:Ra(t,"Invalid character found")}const r=new Uint8Array(n.length);for(let i=0;i<n.length;i++)r[i]=n.charCodeAt(i);return r}class PS{constructor(e){this.base64=!1,this.contentType=null;const n=e.match(/^data:([^,]+)?,/);if(n===null)throw Ra($n.DATA_URL,"Must be formatted 'data:[<mediatype>][;base64],<data>");const r=n[1]||null;r!=null&&(this.base64=FD(r,";base64"),this.contentType=this.base64?r.substring(0,r.length-7):r),this.rest=e.substring(e.indexOf(",")+1)}}function MD(t){const e=new PS(t);return e.base64?AS($n.BASE64,e.rest):OD(e.rest)}function LD(t){return new PS(t).contentType}function FD(t,e){return t.length>=e.length?t.substring(t.length-e.length)===e:!1}/**
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
 */class Vr{constructor(e,n){let r=0,i="";f0(e)?(this.data_=e,r=e.size,i=e.type):e instanceof ArrayBuffer?(n?this.data_=new Uint8Array(e):(this.data_=new Uint8Array(e.byteLength),this.data_.set(new Uint8Array(e))),r=this.data_.length):e instanceof Uint8Array&&(n?this.data_=e:(this.data_=new Uint8Array(e.length),this.data_.set(e)),r=e.length),this.size_=r,this.type_=i}size(){return this.size_}type(){return this.type_}slice(e,n){if(f0(this.data_)){const r=this.data_,i=bD(r,e,n);return i===null?null:new Vr(i)}else{const r=new Uint8Array(this.data_.buffer,e,n-e);return new Vr(r,!0)}}static getBlob(...e){if(wg()){const n=e.map(r=>r instanceof Vr?r.data_:r);return new Vr(PD.apply(null,n))}else{const n=e.map(o=>Ph(o)?DD($n.RAW,o).data:o.data_);let r=0;n.forEach(o=>{r+=o.byteLength});const i=new Uint8Array(r);let s=0;return n.forEach(o=>{for(let a=0;a<o.length;a++)i[s++]=o[a]}),new Vr(i,!0)}}uploadData(){return this.data_}}/**
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
 */function bS(t){let e;try{e=JSON.parse(t)}catch{return null}return TD(e)?e:null}/**
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
 */function VD(t){if(t.length===0)return null;const e=t.lastIndexOf("/");return e===-1?"":t.slice(0,e)}function UD(t,e){const n=e.split("/").filter(r=>r.length>0).join("/");return t.length===0?n:t+"/"+n}function NS(t){const e=t.lastIndexOf("/",t.length-2);return e===-1?t:t.slice(e+1)}/**
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
 */function jD(t,e){return e}class zt{constructor(e,n,r,i){this.server=e,this.local=n||e,this.writable=!!r,this.xform=i||jD}}let Iu=null;function zD(t){return!Ph(t)||t.length<2?t:NS(t)}function DS(){if(Iu)return Iu;const t=[];t.push(new zt("bucket")),t.push(new zt("generation")),t.push(new zt("metageneration")),t.push(new zt("name","fullPath",!0));function e(s,o){return zD(o)}const n=new zt("name");n.xform=e,t.push(n);function r(s,o){return o!==void 0?Number(o):o}const i=new zt("size");return i.xform=r,t.push(i),t.push(new zt("timeCreated")),t.push(new zt("updated")),t.push(new zt("md5Hash",null,!0)),t.push(new zt("cacheControl",null,!0)),t.push(new zt("contentDisposition",null,!0)),t.push(new zt("contentEncoding",null,!0)),t.push(new zt("contentLanguage",null,!0)),t.push(new zt("contentType",null,!0)),t.push(new zt("metadata","customMetadata",!0)),Iu=t,Iu}function BD(t,e){function n(){const r=t.bucket,i=t.fullPath,s=new an(r,i);return e._makeStorageReference(s)}Object.defineProperty(t,"ref",{get:n})}function $D(t,e,n){const r={};r.type="file";const i=n.length;for(let s=0;s<i;s++){const o=n[s];r[o.local]=o.xform(r,e[o.server])}return BD(r,t),r}function OS(t,e,n){const r=bS(e);return r===null?null:$D(t,r,n)}function WD(t,e,n,r){const i=bS(e);if(i===null||!Ph(i.downloadTokens))return null;const s=i.downloadTokens;if(s.length===0)return null;const o=encodeURIComponent;return s.split(",").map(c=>{const h=t.bucket,f=t.fullPath,m="/b/"+o(h)+"/o/"+o(f),w=Io(m,n,r),S=CS({alt:"media",token:c});return w+S})[0]}function MS(t,e){const n={},r=e.length;for(let i=0;i<r;i++){const s=e[i];s.writable&&(n[s.server]=t[s.local])}return JSON.stringify(n)}class is{constructor(e,n,r,i){this.url=e,this.method=n,this.handler=r,this.timeout=i,this.urlParams={},this.headers={},this.body=null,this.errorHandler=null,this.progressCallback=null,this.successCodes=[200],this.additionalRetryCodes=[]}}/**
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
 */function fr(t){if(!t)throw vg()}function Eg(t,e){function n(r,i){const s=OS(t,i,e);return fr(s!==null),s}return n}function qD(t,e){function n(r,i){const s=OS(t,i,e);return fr(s!==null),WD(s,i,t.host,t._protocol)}return n}function Cl(t){function e(n,r){let i;return n.getStatus()===401?n.getErrorText().includes("Firebase App Check token is invalid")?i=lD():i=aD():n.getStatus()===402?i=oD(t.bucket):n.getStatus()===403?i=uD(t.path):i=r,i.status=n.getStatus(),i.serverResponse=r.serverResponse,i}return e}function Tg(t){const e=Cl(t);function n(r,i){let s=e(r,i);return r.getStatus()===404&&(s=sD(t.path)),s.serverResponse=i.serverResponse,s}return n}function HD(t,e,n){const r=e.fullServerUrl(),i=Io(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new is(i,s,Eg(t,n),o);return a.errorHandler=Tg(e),a}function GD(t,e,n){const r=e.fullServerUrl(),i=Io(r,t.host,t._protocol),s="GET",o=t.maxOperationRetryTime,a=new is(i,s,qD(t,n),o);return a.errorHandler=Tg(e),a}function KD(t,e){const n=e.fullServerUrl(),r=Io(n,t.host,t._protocol),i="DELETE",s=t.maxOperationRetryTime;function o(u,c){}const a=new is(r,i,o,s);return a.successCodes=[200,204],a.errorHandler=Tg(e),a}function QD(t,e){return t&&t.contentType||e&&e.type()||"application/octet-stream"}function LS(t,e,n){const r=Object.assign({},n);return r.fullPath=t.path,r.size=e.size(),r.contentType||(r.contentType=QD(null,e)),r}function YD(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o={"X-Goog-Upload-Protocol":"multipart"};function a(){let R="";for(let M=0;M<2;M++)R=R+Math.random().toString().slice(2);return R}const u=a();o["Content-Type"]="multipart/related; boundary="+u;const c=LS(e,r,i),h=MS(c,n),f="--"+u+`\r
Content-Type: application/json; charset=utf-8\r
\r
`+h+`\r
--`+u+`\r
Content-Type: `+c.contentType+`\r
\r
`,m=`\r
--`+u+"--",w=Vr.getBlob(f,r,m);if(w===null)throw SS();const S={name:c.fullPath},P=Io(s,t.host,t._protocol),D="POST",k=t.maxUploadRetryTime,T=new is(P,D,Eg(t,n),k);return T.urlParams=S,T.headers=o,T.body=w.uploadData(),T.errorHandler=Cl(e),T}class Oc{constructor(e,n,r,i){this.current=e,this.total=n,this.finalized=!!r,this.metadata=i||null}}function Ig(t,e){let n=null;try{n=t.getResponseHeader("X-Goog-Upload-Status")}catch{fr(!1)}return fr(!!n&&(e||["active"]).indexOf(n)!==-1),n}function XD(t,e,n,r,i){const s=e.bucketOnlyServerUrl(),o=LS(e,r,i),a={name:o.fullPath},u=Io(s,t.host,t._protocol),c="POST",h={"X-Goog-Upload-Protocol":"resumable","X-Goog-Upload-Command":"start","X-Goog-Upload-Header-Content-Length":`${r.size()}`,"X-Goog-Upload-Header-Content-Type":o.contentType,"Content-Type":"application/json; charset=utf-8"},f=MS(o,n),m=t.maxUploadRetryTime;function w(P){Ig(P);let D;try{D=P.getResponseHeader("X-Goog-Upload-URL")}catch{fr(!1)}return fr(Ph(D)),D}const S=new is(u,c,w,m);return S.urlParams=a,S.headers=h,S.body=f,S.errorHandler=Cl(e),S}function JD(t,e,n,r){const i={"X-Goog-Upload-Command":"query"};function s(c){const h=Ig(c,["active","final"]);let f=null;try{f=c.getResponseHeader("X-Goog-Upload-Size-Received")}catch{fr(!1)}f||fr(!1);const m=Number(f);return fr(!isNaN(m)),new Oc(m,r.size(),h==="final")}const o="POST",a=t.maxUploadRetryTime,u=new is(n,o,s,a);return u.headers=i,u.errorHandler=Cl(e),u}const m0=256*1024;function ZD(t,e,n,r,i,s,o,a){const u=new Oc(0,0);if(o?(u.current=o.current,u.total=o.total):(u.current=0,u.total=r.size()),r.size()!==u.total)throw fD();const c=u.total-u.current;let h=c;i>0&&(h=Math.min(h,i));const f=u.current,m=f+h;let w="";h===0?w="finalize":c===h?w="upload, finalize":w="upload";const S={"X-Goog-Upload-Command":w,"X-Goog-Upload-Offset":`${u.current}`},P=r.slice(f,m);if(P===null)throw SS();function D(M,z){const U=Ig(M,["active","final"]),v=u.current+h,_=r.size();let E;return U==="final"?E=Eg(e,s)(M,z):E=null,new Oc(v,_,U==="final",E)}const k="POST",T=e.maxUploadRetryTime,R=new is(n,k,D,T);return R.headers=S,R.body=P.uploadData(),R.progressCallback=a||null,R.errorHandler=Cl(t),R}const Gt={RUNNING:"running",PAUSED:"paused",SUCCESS:"success",CANCELED:"canceled",ERROR:"error"};function $d(t){switch(t){case"running":case"pausing":case"canceling":return Gt.RUNNING;case"paused":return Gt.PAUSED;case"success":return Gt.SUCCESS;case"canceled":return Gt.CANCELED;case"error":return Gt.ERROR;default:return Gt.ERROR}}/**
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
 */class eO{constructor(e,n,r){if(ED(e)||n!=null||r!=null)this.next=e,this.error=n??void 0,this.complete=r??void 0;else{const s=e;this.next=s.next,this.error=s.error,this.complete=s.complete}}}/**
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
 */function ms(t){return(...e)=>{Promise.resolve().then(()=>t(...e))}}class tO{constructor(){this.sent_=!1,this.xhr_=new XMLHttpRequest,this.initXhr(),this.errorCode_=Vi.NO_ERROR,this.sendPromise_=new Promise(e=>{this.xhr_.addEventListener("abort",()=>{this.errorCode_=Vi.ABORT,e()}),this.xhr_.addEventListener("error",()=>{this.errorCode_=Vi.NETWORK_ERROR,e()}),this.xhr_.addEventListener("load",()=>{e()})})}send(e,n,r,i){if(this.sent_)throw Zo("cannot .send() more than once");if(this.sent_=!0,this.xhr_.open(n,e,!0),i!==void 0)for(const s in i)i.hasOwnProperty(s)&&this.xhr_.setRequestHeader(s,i[s].toString());return r!==void 0?this.xhr_.send(r):this.xhr_.send(),this.sendPromise_}getErrorCode(){if(!this.sent_)throw Zo("cannot .getErrorCode() before sending");return this.errorCode_}getStatus(){if(!this.sent_)throw Zo("cannot .getStatus() before sending");try{return this.xhr_.status}catch{return-1}}getResponse(){if(!this.sent_)throw Zo("cannot .getResponse() before sending");return this.xhr_.response}getErrorText(){if(!this.sent_)throw Zo("cannot .getErrorText() before sending");return this.xhr_.statusText}abort(){this.xhr_.abort()}getResponseHeader(e){return this.xhr_.getResponseHeader(e)}addUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.addEventListener("progress",e)}removeUploadProgressListener(e){this.xhr_.upload!=null&&this.xhr_.upload.removeEventListener("progress",e)}}class nO extends tO{initXhr(){this.xhr_.responseType="text"}}function xi(){return new nO}/**
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
 */class rO{constructor(e,n,r=null){this._transferred=0,this._needToFetchStatus=!1,this._needToFetchMetadata=!1,this._observers=[],this._error=void 0,this._uploadUrl=void 0,this._request=void 0,this._chunkMultiplier=1,this._resolve=void 0,this._reject=void 0,this._ref=e,this._blob=n,this._metadata=r,this._mappings=DS(),this._resumable=this._shouldDoResumable(this._blob),this._state="running",this._errorHandler=i=>{if(this._request=void 0,this._chunkMultiplier=1,i._codeEquals(je.CANCELED))this._needToFetchStatus=!0,this.completeTransitions_();else{const s=this.isExponentialBackoffExpired();if(RS(i.status,[]))if(s)i=TS();else{this.sleepTime=Math.max(this.sleepTime*2,iD),this._needToFetchStatus=!0,this.completeTransitions_();return}this._error=i,this._transition("error")}},this._metadataErrorHandler=i=>{this._request=void 0,i._codeEquals(je.CANCELED)?this.completeTransitions_():(this._error=i,this._transition("error"))},this.sleepTime=0,this.maxSleepTime=this._ref.storage.maxUploadRetryTime,this._promise=new Promise((i,s)=>{this._resolve=i,this._reject=s,this._start()}),this._promise.then(null,()=>{})}isExponentialBackoffExpired(){return this.sleepTime>this.maxSleepTime}_makeProgressCallback(){const e=this._transferred;return n=>this._updateProgress(e+n)}_shouldDoResumable(e){return e.size()>256*1024}_start(){this._state==="running"&&this._request===void 0&&(this._resumable?this._uploadUrl===void 0?this._createResumable():this._needToFetchStatus?this._fetchStatus():this._needToFetchMetadata?this._fetchMetadata():this.pendingTimeout=setTimeout(()=>{this.pendingTimeout=void 0,this._continueUpload()},this.sleepTime):this._oneShotUpload())}_resolveToken(e){Promise.all([this._ref.storage._getAuthToken(),this._ref.storage._getAppCheckToken()]).then(([n,r])=>{switch(this._state){case"running":e(n,r);break;case"canceling":this._transition("canceled");break;case"pausing":this._transition("paused");break}})}_createResumable(){this._resolveToken((e,n)=>{const r=XD(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,xi,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._uploadUrl=s,this._needToFetchStatus=!1,this.completeTransitions_()},this._errorHandler)})}_fetchStatus(){const e=this._uploadUrl;this._resolveToken((n,r)=>{const i=JD(this._ref.storage,this._ref._location,e,this._blob),s=this._ref.storage._makeRequest(i,xi,n,r);this._request=s,s.getPromise().then(o=>{o=o,this._request=void 0,this._updateProgress(o.current),this._needToFetchStatus=!1,o.finalized&&(this._needToFetchMetadata=!0),this.completeTransitions_()},this._errorHandler)})}_continueUpload(){const e=m0*this._chunkMultiplier,n=new Oc(this._transferred,this._blob.size()),r=this._uploadUrl;this._resolveToken((i,s)=>{let o;try{o=ZD(this._ref._location,this._ref.storage,r,this._blob,e,this._mappings,n,this._makeProgressCallback())}catch(u){this._error=u,this._transition("error");return}const a=this._ref.storage._makeRequest(o,xi,i,s,!1);this._request=a,a.getPromise().then(u=>{this._increaseMultiplier(),this._request=void 0,this._updateProgress(u.current),u.finalized?(this._metadata=u.metadata,this._transition("success")):this.completeTransitions_()},this._errorHandler)})}_increaseMultiplier(){m0*this._chunkMultiplier*2<32*1024*1024&&(this._chunkMultiplier*=2)}_fetchMetadata(){this._resolveToken((e,n)=>{const r=HD(this._ref.storage,this._ref._location,this._mappings),i=this._ref.storage._makeRequest(r,xi,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._transition("success")},this._metadataErrorHandler)})}_oneShotUpload(){this._resolveToken((e,n)=>{const r=YD(this._ref.storage,this._ref._location,this._mappings,this._blob,this._metadata),i=this._ref.storage._makeRequest(r,xi,e,n);this._request=i,i.getPromise().then(s=>{this._request=void 0,this._metadata=s,this._updateProgress(this._blob.size()),this._transition("success")},this._errorHandler)})}_updateProgress(e){const n=this._transferred;this._transferred=e,this._transferred!==n&&this._notifyObservers()}_transition(e){if(this._state!==e)switch(e){case"canceling":case"pausing":this._state=e,this._request!==void 0?this._request.cancel():this.pendingTimeout&&(clearTimeout(this.pendingTimeout),this.pendingTimeout=void 0,this.completeTransitions_());break;case"running":const n=this._state==="paused";this._state=e,n&&(this._notifyObservers(),this._start());break;case"paused":this._state=e,this._notifyObservers();break;case"canceled":this._error=IS(),this._state=e,this._notifyObservers();break;case"error":this._state=e,this._notifyObservers();break;case"success":this._state=e,this._notifyObservers();break}}completeTransitions_(){switch(this._state){case"pausing":this._transition("paused");break;case"canceling":this._transition("canceled");break;case"running":this._start();break}}get snapshot(){const e=$d(this._state);return{bytesTransferred:this._transferred,totalBytes:this._blob.size(),state:e,metadata:this._metadata,task:this,ref:this._ref}}on(e,n,r,i){const s=new eO(n||void 0,r||void 0,i||void 0);return this._addObserver(s),()=>{this._removeObserver(s)}}then(e,n){return this._promise.then(e,n)}catch(e){return this.then(null,e)}_addObserver(e){this._observers.push(e),this._notifyObserver(e)}_removeObserver(e){const n=this._observers.indexOf(e);n!==-1&&this._observers.splice(n,1)}_notifyObservers(){this._finishPromise(),this._observers.slice().forEach(n=>{this._notifyObserver(n)})}_finishPromise(){if(this._resolve!==void 0){let e=!0;switch($d(this._state)){case Gt.SUCCESS:ms(this._resolve.bind(null,this.snapshot))();break;case Gt.CANCELED:case Gt.ERROR:const n=this._reject;ms(n.bind(null,this._error))();break;default:e=!1;break}e&&(this._resolve=void 0,this._reject=void 0)}}_notifyObserver(e){switch($d(this._state)){case Gt.RUNNING:case Gt.PAUSED:e.next&&ms(e.next.bind(e,this.snapshot))();break;case Gt.SUCCESS:e.complete&&ms(e.complete.bind(e))();break;case Gt.CANCELED:case Gt.ERROR:e.error&&ms(e.error.bind(e,this._error))();break;default:e.error&&ms(e.error.bind(e,this._error))()}}resume(){const e=this._state==="paused"||this._state==="pausing";return e&&this._transition("running"),e}pause(){const e=this._state==="running";return e&&this._transition("pausing"),e}cancel(){const e=this._state==="running"||this._state==="pausing";return e&&this._transition("canceling"),e}}/**
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
 */class Gi{constructor(e,n){this._service=e,n instanceof an?this._location=n:this._location=an.makeFromUrl(n,e.host)}toString(){return"gs://"+this._location.bucket+"/"+this._location.path}_newRef(e,n){return new Gi(e,n)}get root(){const e=new an(this._location.bucket,"");return this._newRef(this._service,e)}get bucket(){return this._location.bucket}get fullPath(){return this._location.path}get name(){return NS(this._location.path)}get storage(){return this._service}get parent(){const e=VD(this._location.path);if(e===null)return null;const n=new an(this._location.bucket,e);return new Gi(this._service,n)}_throwIfRoot(e){if(this._location.path==="")throw gD(e)}}function iO(t,e,n){return t._throwIfRoot("uploadBytesResumable"),new rO(t,new Vr(e),n)}function sO(t){t._throwIfRoot("getDownloadURL");const e=GD(t.storage,t._location,DS());return t.storage.makeRequestWithTokens(e,xi).then(n=>{if(n===null)throw pD();return n})}function oO(t){t._throwIfRoot("deleteObject");const e=KD(t.storage,t._location);return t.storage.makeRequestWithTokens(e,xi)}function aO(t,e){const n=UD(t._location.path,e),r=new an(t._location.bucket,n);return new Gi(t.storage,r)}/**
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
 */function lO(t){return/^[A-Za-z]+:\/\//.test(t)}function uO(t,e){return new Gi(t,e)}function FS(t,e){if(t instanceof Sg){const n=t;if(n._bucket==null)throw dD();const r=new Gi(n,n._bucket);return e!=null?FS(r,e):r}else return e!==void 0?aO(t,e):t}function cO(t,e){if(e&&lO(e)){if(t instanceof Sg)return uO(t,e);throw yp("To use ref(service, url), the first argument must be a Storage instance.")}else return FS(t,e)}function g0(t,e){const n=e==null?void 0:e[ES];return n==null?null:an.makeFromBucketSpec(n,t)}function hO(t,e,n,r={}){t.host=`${e}:${n}`,t._protocol="http";const{mockUserToken:i}=r;i&&(t._overrideAuthToken=typeof i=="string"?i:Om(i,t.app.options.projectId))}class Sg{constructor(e,n,r,i,s){this.app=e,this._authProvider=n,this._appCheckProvider=r,this._url=i,this._firebaseVersion=s,this._bucket=null,this._host=wS,this._protocol="https",this._appId=null,this._deleted=!1,this._maxOperationRetryTime=nD,this._maxUploadRetryTime=rD,this._requests=new Set,i!=null?this._bucket=an.makeFromBucketSpec(i,this._host):this._bucket=g0(this._host,this.app.options)}get host(){return this._host}set host(e){this._host=e,this._url!=null?this._bucket=an.makeFromBucketSpec(this._url,e):this._bucket=g0(e,this.app.options)}get maxUploadRetryTime(){return this._maxUploadRetryTime}set maxUploadRetryTime(e){p0("time",0,Number.POSITIVE_INFINITY,e),this._maxUploadRetryTime=e}get maxOperationRetryTime(){return this._maxOperationRetryTime}set maxOperationRetryTime(e){p0("time",0,Number.POSITIVE_INFINITY,e),this._maxOperationRetryTime=e}async _getAuthToken(){if(this._overrideAuthToken)return this._overrideAuthToken;const e=this._authProvider.getImmediate({optional:!0});if(e){const n=await e.getToken();if(n!==null)return n.accessToken}return null}async _getAppCheckToken(){const e=this._appCheckProvider.getImmediate({optional:!0});return e?(await e.getToken()).token:null}_delete(){return this._deleted||(this._deleted=!0,this._requests.forEach(e=>e.cancel()),this._requests.clear()),Promise.resolve()}_makeStorageReference(e){return new Gi(this,e)}_makeRequest(e,n,r,i,s=!0){if(this._deleted)return new _D(kS());{const o=xD(e,this._appId,r,i,n,this._firebaseVersion,s);return this._requests.add(o),o.getPromise().then(()=>this._requests.delete(o),()=>this._requests.delete(o)),o}}async makeRequestWithTokens(e,n){const[r,i]=await Promise.all([this._getAuthToken(),this._getAppCheckToken()]);return this._makeRequest(e,n,r,i).getPromise()}}const _0="@firebase/storage",y0="0.13.2";/**
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
 */const VS="storage";function dO(t,e,n){return t=Ye(t),iO(t,e,n)}function fO(t){return t=Ye(t),sO(t)}function pO(t){return t=Ye(t),oO(t)}function v0(t,e){return t=Ye(t),cO(t,e)}function mO(t=_h(),e){t=Ye(t);const r=vl(t,VS).getImmediate({identifier:e}),i=Dm("storage");return i&&gO(r,...i),r}function gO(t,e,n,r={}){hO(t,e,n,r)}function _O(t,{instanceIdentifier:e}){const n=t.getProvider("app").getImmediate(),r=t.getProvider("auth-internal"),i=t.getProvider("app-check-internal");return new Sg(n,r,i,e,yi)}function yO(){ui(new vr(VS,_O,"PUBLIC").setMultipleInstances(!0)),wn(_0,y0,""),wn(_0,y0,"esm2017")}yO();var w0={};const E0="@firebase/database",T0="1.0.8";/**
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
 */let US="";function vO(t){US=t}/**
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
 */class wO{constructor(e){this.domStorage_=e,this.prefix_="firebase:"}set(e,n){n==null?this.domStorage_.removeItem(this.prefixedName_(e)):this.domStorage_.setItem(this.prefixedName_(e),Et(n))}get(e){const n=this.domStorage_.getItem(this.prefixedName_(e));return n==null?null:Za(n)}remove(e){this.domStorage_.removeItem(this.prefixedName_(e))}prefixedName_(e){return this.prefix_+e}toString(){return this.domStorage_.toString()}}/**
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
 */class EO{constructor(){this.cache_={},this.isInMemoryStorage=!0}set(e,n){n==null?delete this.cache_[e]:this.cache_[e]=n}get(e){return xr(this.cache_,e)?this.cache_[e]:null}remove(e){delete this.cache_[e]}}/**
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
 */const jS=function(t){try{if(typeof window<"u"&&typeof window[t]<"u"){const e=window[t];return e.setItem("firebase:sentinel","cache"),e.removeItem("firebase:sentinel"),new wO(e)}}catch{}return new EO},Di=jS("localStorage"),TO=jS("sessionStorage");/**
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
 */const Bs=new gh("@firebase/database"),IO=function(){let t=1;return function(){return t++}}(),zS=function(t){const e=DA(t),n=new AA;n.update(e);const r=n.digest();return Nm.encodeByteArray(r)},Rl=function(...t){let e="";for(let n=0;n<t.length;n++){const r=t[n];Array.isArray(r)||r&&typeof r=="object"&&typeof r.length=="number"?e+=Rl.apply(null,r):typeof r=="object"?e+=Et(r):e+=r,e+=" "}return e};let xa=null,I0=!0;const SO=function(t,e){G(!0,"Can't turn on custom loggers persistently."),Bs.logLevel=de.VERBOSE,xa=Bs.log.bind(Bs)},Mt=function(...t){if(I0===!0&&(I0=!1,xa===null&&TO.get("logging_enabled")===!0&&SO()),xa){const e=Rl.apply(null,t);xa(e)}},xl=function(t){return function(...e){Mt(t,...e)}},vp=function(...t){const e="FIREBASE INTERNAL ERROR: "+Rl(...t);Bs.error(e)},Ir=function(...t){const e=`FIREBASE FATAL ERROR: ${Rl(...t)}`;throw Bs.error(e),new Error(e)},en=function(...t){const e="FIREBASE WARNING: "+Rl(...t);Bs.warn(e)},kO=function(){typeof window<"u"&&window.location&&window.location.protocol&&window.location.protocol.indexOf("https:")!==-1&&en("Insecure Firebase access from a secure page. Please use https in calls to new Firebase().")},BS=function(t){return typeof t=="number"&&(t!==t||t===Number.POSITIVE_INFINITY||t===Number.NEGATIVE_INFINITY)},CO=function(t){if(document.readyState==="complete")t();else{let e=!1;const n=function(){if(!document.body){setTimeout(n,Math.floor(10));return}e||(e=!0,t())};document.addEventListener?(document.addEventListener("DOMContentLoaded",n,!1),window.addEventListener("load",n,!1)):document.attachEvent&&(document.attachEvent("onreadystatechange",()=>{document.readyState==="complete"&&n()}),window.attachEvent("onload",n))}},co="[MIN_NAME]",Ki="[MAX_NAME]",So=function(t,e){if(t===e)return 0;if(t===co||e===Ki)return-1;if(e===co||t===Ki)return 1;{const n=S0(t),r=S0(e);return n!==null?r!==null?n-r===0?t.length-e.length:n-r:-1:r!==null?1:t<e?-1:1}},RO=function(t,e){return t===e?0:t<e?-1:1},ea=function(t,e){if(e&&t in e)return e[t];throw new Error("Missing required key ("+t+") in object: "+Et(e))},kg=function(t){if(typeof t!="object"||t===null)return Et(t);const e=[];for(const r in t)e.push(r);e.sort();let n="{";for(let r=0;r<e.length;r++)r!==0&&(n+=","),n+=Et(e[r]),n+=":",n+=kg(t[e[r]]);return n+="}",n},$S=function(t,e){const n=t.length;if(n<=e)return[t];const r=[];for(let i=0;i<n;i+=e)i+e>n?r.push(t.substring(i,n)):r.push(t.substring(i,i+e));return r};function Sn(t,e){for(const n in t)t.hasOwnProperty(n)&&e(n,t[n])}const WS=function(t){G(!BS(t),"Invalid JSON number");const e=11,n=52,r=(1<<e-1)-1;let i,s,o,a,u;t===0?(s=0,o=0,i=1/t===-1/0?1:0):(i=t<0,t=Math.abs(t),t>=Math.pow(2,1-r)?(a=Math.min(Math.floor(Math.log(t)/Math.LN2),r),s=a+r,o=Math.round(t*Math.pow(2,n-a)-Math.pow(2,n))):(s=0,o=Math.round(t/Math.pow(2,1-r-n))));const c=[];for(u=n;u;u-=1)c.push(o%2?1:0),o=Math.floor(o/2);for(u=e;u;u-=1)c.push(s%2?1:0),s=Math.floor(s/2);c.push(i?1:0),c.reverse();const h=c.join("");let f="";for(u=0;u<64;u+=8){let m=parseInt(h.substr(u,8),2).toString(16);m.length===1&&(m="0"+m),f=f+m}return f.toLowerCase()},xO=function(){return!!(typeof window=="object"&&window.chrome&&window.chrome.extension&&!/^chrome/.test(window.location.href))},AO=function(){return typeof Windows=="object"&&typeof Windows.UI=="object"},PO=new RegExp("^-?(0*)\\d{1,10}$"),bO=-2147483648,NO=2147483647,S0=function(t){if(PO.test(t)){const e=Number(t);if(e>=bO&&e<=NO)return e}return null},ko=function(t){try{t()}catch(e){setTimeout(()=>{const n=e.stack||"";throw en("Exception was thrown by user callback.",n),e},Math.floor(0))}},DO=function(){return(typeof window=="object"&&window.navigator&&window.navigator.userAgent||"").search(/googlebot|google webmaster tools|bingbot|yahoo! slurp|baiduspider|yandexbot|duckduckbot/i)>=0},Aa=function(t,e){const n=setTimeout(t,e);return typeof n=="number"&&typeof Deno<"u"&&Deno.unrefTimer?Deno.unrefTimer(n):typeof n=="object"&&n.unref&&n.unref(),n};/**
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
 */class OO{constructor(e,n){this.appName_=e,this.appCheckProvider=n,this.appCheck=n==null?void 0:n.getImmediate({optional:!0}),this.appCheck||n==null||n.get().then(r=>this.appCheck=r)}getToken(e){return this.appCheck?this.appCheck.getToken(e):new Promise((n,r)=>{setTimeout(()=>{this.appCheck?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){var n;(n=this.appCheckProvider)===null||n===void 0||n.get().then(r=>r.addTokenListener(e))}notifyForInvalidToken(){en(`Provided AppCheck credentials for the app named "${this.appName_}" are invalid. This usually indicates your app was not initialized correctly.`)}}/**
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
 */class MO{constructor(e,n,r){this.appName_=e,this.firebaseOptions_=n,this.authProvider_=r,this.auth_=null,this.auth_=r.getImmediate({optional:!0}),this.auth_||r.onInit(i=>this.auth_=i)}getToken(e){return this.auth_?this.auth_.getToken(e).catch(n=>n&&n.code==="auth/token-not-initialized"?(Mt("Got auth/token-not-initialized error.  Treating as null token."),null):Promise.reject(n)):new Promise((n,r)=>{setTimeout(()=>{this.auth_?this.getToken(e).then(n,r):n(null)},0)})}addTokenChangeListener(e){this.auth_?this.auth_.addAuthTokenListener(e):this.authProvider_.get().then(n=>n.addAuthTokenListener(e))}removeTokenChangeListener(e){this.authProvider_.get().then(n=>n.removeAuthTokenListener(e))}notifyForInvalidToken(){let e='Provided authentication credentials for the app named "'+this.appName_+'" are invalid. This usually indicates your app was not initialized correctly. ';"credential"in this.firebaseOptions_?e+='Make sure the "credential" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':"serviceAccount"in this.firebaseOptions_?e+='Make sure the "serviceAccount" property provided to initializeApp() is authorized to access the specified "databaseURL" and is from the correct project.':e+='Make sure the "apiKey" and "databaseURL" properties provided to initializeApp() match the values provided for your app at https://console.firebase.google.com/.',en(e)}}class Hu{constructor(e){this.accessToken=e}getToken(e){return Promise.resolve({accessToken:this.accessToken})}addTokenChangeListener(e){e(this.accessToken)}removeTokenChangeListener(e){}notifyForInvalidToken(){}}Hu.OWNER="owner";/**
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
 */const Cg="5",qS="v",HS="s",GS="r",KS="f",QS=/(console\.firebase|firebase-console-\w+\.corp|firebase\.corp)\.google\.com/,YS="ls",XS="p",wp="ac",JS="websocket",ZS="long_polling";/**
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
 */class ek{constructor(e,n,r,i,s=!1,o="",a=!1,u=!1){this.secure=n,this.namespace=r,this.webSocketOnly=i,this.nodeAdmin=s,this.persistenceKey=o,this.includeNamespaceInQueryParams=a,this.isUsingEmulator=u,this._host=e.toLowerCase(),this._domain=this._host.substr(this._host.indexOf(".")+1),this.internalHost=Di.get("host:"+e)||this._host}isCacheableHost(){return this.internalHost.substr(0,2)==="s-"}isCustomHost(){return this._domain!=="firebaseio.com"&&this._domain!=="firebaseio-demo.com"}get host(){return this._host}set host(e){e!==this.internalHost&&(this.internalHost=e,this.isCacheableHost()&&Di.set("host:"+this._host,this.internalHost))}toString(){let e=this.toURLString();return this.persistenceKey&&(e+="<"+this.persistenceKey+">"),e}toURLString(){const e=this.secure?"https://":"http://",n=this.includeNamespaceInQueryParams?`?ns=${this.namespace}`:"";return`${e}${this.host}/${n}`}}function LO(t){return t.host!==t.internalHost||t.isCustomHost()||t.includeNamespaceInQueryParams}function tk(t,e,n){G(typeof e=="string","typeof type must == string"),G(typeof n=="object","typeof params must == object");let r;if(e===JS)r=(t.secure?"wss://":"ws://")+t.internalHost+"/.ws?";else if(e===ZS)r=(t.secure?"https://":"http://")+t.internalHost+"/.lp?";else throw new Error("Unknown connection type: "+e);LO(t)&&(n.ns=t.namespace);const i=[];return Sn(n,(s,o)=>{i.push(s+"="+o)}),r+i.join("&")}/**
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
 */class FO{constructor(){this.counters_={}}incrementCounter(e,n=1){xr(this.counters_,e)||(this.counters_[e]=0),this.counters_[e]+=n}get(){return cA(this.counters_)}}/**
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
 */const Wd={},qd={};function Rg(t){const e=t.toString();return Wd[e]||(Wd[e]=new FO),Wd[e]}function VO(t,e){const n=t.toString();return qd[n]||(qd[n]=e()),qd[n]}/**
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
 */class UO{constructor(e){this.onMessage_=e,this.pendingResponses=[],this.currentResponseNum=0,this.closeAfterResponse=-1,this.onClose=null}closeAfter(e,n){this.closeAfterResponse=e,this.onClose=n,this.closeAfterResponse<this.currentResponseNum&&(this.onClose(),this.onClose=null)}handleResponse(e,n){for(this.pendingResponses[e]=n;this.pendingResponses[this.currentResponseNum];){const r=this.pendingResponses[this.currentResponseNum];delete this.pendingResponses[this.currentResponseNum];for(let i=0;i<r.length;++i)r[i]&&ko(()=>{this.onMessage_(r[i])});if(this.currentResponseNum===this.closeAfterResponse){this.onClose&&(this.onClose(),this.onClose=null);break}this.currentResponseNum++}}}/**
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
 */const k0="start",jO="close",zO="pLPCommand",BO="pRTLPCB",nk="id",rk="pw",ik="ser",$O="cb",WO="seg",qO="ts",HO="d",GO="dframe",sk=1870,ok=30,KO=sk-ok,QO=25e3,YO=3e4;class Ds{constructor(e,n,r,i,s,o,a){this.connId=e,this.repoInfo=n,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.transportSessionId=o,this.lastSessionId=a,this.bytesSent=0,this.bytesReceived=0,this.everConnected_=!1,this.log_=xl(e),this.stats_=Rg(n),this.urlFn=u=>(this.appCheckToken&&(u[wp]=this.appCheckToken),tk(n,ZS,u))}open(e,n){this.curSegmentNum=0,this.onDisconnect_=n,this.myPacketOrderer=new UO(e),this.isClosed_=!1,this.connectTimeoutTimer_=setTimeout(()=>{this.log_("Timed out trying to connect."),this.onClosed_(),this.connectTimeoutTimer_=null},Math.floor(YO)),CO(()=>{if(this.isClosed_)return;this.scriptTagHolder=new xg((...s)=>{const[o,a,u,c,h]=s;if(this.incrementIncomingBytes_(s),!!this.scriptTagHolder)if(this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null),this.everConnected_=!0,o===k0)this.id=a,this.password=u;else if(o===jO)a?(this.scriptTagHolder.sendNewPolls=!1,this.myPacketOrderer.closeAfter(a,()=>{this.onClosed_()})):this.onClosed_();else throw new Error("Unrecognized command received: "+o)},(...s)=>{const[o,a]=s;this.incrementIncomingBytes_(s),this.myPacketOrderer.handleResponse(o,a)},()=>{this.onClosed_()},this.urlFn);const r={};r[k0]="t",r[ik]=Math.floor(Math.random()*1e8),this.scriptTagHolder.uniqueCallbackIdentifier&&(r[$O]=this.scriptTagHolder.uniqueCallbackIdentifier),r[qS]=Cg,this.transportSessionId&&(r[HS]=this.transportSessionId),this.lastSessionId&&(r[YS]=this.lastSessionId),this.applicationId&&(r[XS]=this.applicationId),this.appCheckToken&&(r[wp]=this.appCheckToken),typeof location<"u"&&location.hostname&&QS.test(location.hostname)&&(r[GS]=KS);const i=this.urlFn(r);this.log_("Connecting via long-poll to "+i),this.scriptTagHolder.addTag(i,()=>{})})}start(){this.scriptTagHolder.startLongPoll(this.id,this.password),this.addDisconnectPingFrame(this.id,this.password)}static forceAllow(){Ds.forceAllow_=!0}static forceDisallow(){Ds.forceDisallow_=!0}static isAvailable(){return Ds.forceAllow_?!0:!Ds.forceDisallow_&&typeof document<"u"&&document.createElement!=null&&!xO()&&!AO()}markConnectionHealthy(){}shutdown_(){this.isClosed_=!0,this.scriptTagHolder&&(this.scriptTagHolder.close(),this.scriptTagHolder=null),this.myDisconnFrame&&(document.body.removeChild(this.myDisconnFrame),this.myDisconnFrame=null),this.connectTimeoutTimer_&&(clearTimeout(this.connectTimeoutTimer_),this.connectTimeoutTimer_=null)}onClosed_(){this.isClosed_||(this.log_("Longpoll is closing itself"),this.shutdown_(),this.onDisconnect_&&(this.onDisconnect_(this.everConnected_),this.onDisconnect_=null))}close(){this.isClosed_||(this.log_("Longpoll is being closed."),this.shutdown_())}send(e){const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=BT(n),i=$S(r,KO);for(let s=0;s<i.length;s++)this.scriptTagHolder.enqueueSegment(this.curSegmentNum,i.length,i[s]),this.curSegmentNum++}addDisconnectPingFrame(e,n){this.myDisconnFrame=document.createElement("iframe");const r={};r[GO]="t",r[nk]=e,r[rk]=n,this.myDisconnFrame.src=this.urlFn(r),this.myDisconnFrame.style.display="none",document.body.appendChild(this.myDisconnFrame)}incrementIncomingBytes_(e){const n=Et(e).length;this.bytesReceived+=n,this.stats_.incrementCounter("bytes_received",n)}}class xg{constructor(e,n,r,i){this.onDisconnect=r,this.urlFn=i,this.outstandingRequests=new Set,this.pendingSegs=[],this.currentSerial=Math.floor(Math.random()*1e8),this.sendNewPolls=!0;{this.uniqueCallbackIdentifier=IO(),window[zO+this.uniqueCallbackIdentifier]=e,window[BO+this.uniqueCallbackIdentifier]=n,this.myIFrame=xg.createIFrame_();let s="";this.myIFrame.src&&this.myIFrame.src.substr(0,11)==="javascript:"&&(s='<script>document.domain="'+document.domain+'";<\/script>');const o="<html><body>"+s+"</body></html>";try{this.myIFrame.doc.open(),this.myIFrame.doc.write(o),this.myIFrame.doc.close()}catch(a){Mt("frame writing exception"),a.stack&&Mt(a.stack),Mt(a)}}}static createIFrame_(){const e=document.createElement("iframe");if(e.style.display="none",document.body){document.body.appendChild(e);try{e.contentWindow.document||Mt("No IE domain setting required")}catch{const r=document.domain;e.src="javascript:void((function(){document.open();document.domain='"+r+"';document.close();})())"}}else throw"Document body has not initialized. Wait to initialize Firebase until after the document is ready.";return e.contentDocument?e.doc=e.contentDocument:e.contentWindow?e.doc=e.contentWindow.document:e.document&&(e.doc=e.document),e}close(){this.alive=!1,this.myIFrame&&(this.myIFrame.doc.body.textContent="",setTimeout(()=>{this.myIFrame!==null&&(document.body.removeChild(this.myIFrame),this.myIFrame=null)},Math.floor(0)));const e=this.onDisconnect;e&&(this.onDisconnect=null,e())}startLongPoll(e,n){for(this.myID=e,this.myPW=n,this.alive=!0;this.newRequest_(););}newRequest_(){if(this.alive&&this.sendNewPolls&&this.outstandingRequests.size<(this.pendingSegs.length>0?2:1)){this.currentSerial++;const e={};e[nk]=this.myID,e[rk]=this.myPW,e[ik]=this.currentSerial;let n=this.urlFn(e),r="",i=0;for(;this.pendingSegs.length>0&&this.pendingSegs[0].d.length+ok+r.length<=sk;){const o=this.pendingSegs.shift();r=r+"&"+WO+i+"="+o.seg+"&"+qO+i+"="+o.ts+"&"+HO+i+"="+o.d,i++}return n=n+r,this.addLongPollTag_(n,this.currentSerial),!0}else return!1}enqueueSegment(e,n,r){this.pendingSegs.push({seg:e,ts:n,d:r}),this.alive&&this.newRequest_()}addLongPollTag_(e,n){this.outstandingRequests.add(n);const r=()=>{this.outstandingRequests.delete(n),this.newRequest_()},i=setTimeout(r,Math.floor(QO)),s=()=>{clearTimeout(i),r()};this.addTag(e,s)}addTag(e,n){setTimeout(()=>{try{if(!this.sendNewPolls)return;const r=this.myIFrame.doc.createElement("script");r.type="text/javascript",r.async=!0,r.src=e,r.onload=r.onreadystatechange=function(){const i=r.readyState;(!i||i==="loaded"||i==="complete")&&(r.onload=r.onreadystatechange=null,r.parentNode&&r.parentNode.removeChild(r),n())},r.onerror=()=>{Mt("Long-poll script failed to load: "+e),this.sendNewPolls=!1,this.close()},this.myIFrame.doc.body.appendChild(r)}catch{}},Math.floor(1))}}/**
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
 */const XO=16384,JO=45e3;let Mc=null;typeof MozWebSocket<"u"?Mc=MozWebSocket:typeof WebSocket<"u"&&(Mc=WebSocket);class bn{constructor(e,n,r,i,s,o,a){this.connId=e,this.applicationId=r,this.appCheckToken=i,this.authToken=s,this.keepaliveTimer=null,this.frames=null,this.totalFrames=0,this.bytesSent=0,this.bytesReceived=0,this.log_=xl(this.connId),this.stats_=Rg(n),this.connURL=bn.connectionURL_(n,o,a,i,r),this.nodeAdmin=n.nodeAdmin}static connectionURL_(e,n,r,i,s){const o={};return o[qS]=Cg,typeof location<"u"&&location.hostname&&QS.test(location.hostname)&&(o[GS]=KS),n&&(o[HS]=n),r&&(o[YS]=r),i&&(o[wp]=i),s&&(o[XS]=s),tk(e,JS,o)}open(e,n){this.onDisconnect=n,this.onMessage=e,this.log_("Websocket connecting to "+this.connURL),this.everConnected_=!1,Di.set("previous_websocket_failure",!0);try{let r;wA(),this.mySock=new Mc(this.connURL,[],r)}catch(r){this.log_("Error instantiating WebSocket.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_();return}this.mySock.onopen=()=>{this.log_("Websocket connected."),this.everConnected_=!0},this.mySock.onclose=()=>{this.log_("Websocket connection was disconnected."),this.mySock=null,this.onClosed_()},this.mySock.onmessage=r=>{this.handleIncomingFrame(r)},this.mySock.onerror=r=>{this.log_("WebSocket error.  Closing connection.");const i=r.message||r.data;i&&this.log_(i),this.onClosed_()}}start(){}static forceDisallow(){bn.forceDisallow_=!0}static isAvailable(){let e=!1;if(typeof navigator<"u"&&navigator.userAgent){const n=/Android ([0-9]{0,}\.[0-9]{0,})/,r=navigator.userAgent.match(n);r&&r.length>1&&parseFloat(r[1])<4.4&&(e=!0)}return!e&&Mc!==null&&!bn.forceDisallow_}static previouslyFailed(){return Di.isInMemoryStorage||Di.get("previous_websocket_failure")===!0}markConnectionHealthy(){Di.remove("previous_websocket_failure")}appendFrame_(e){if(this.frames.push(e),this.frames.length===this.totalFrames){const n=this.frames.join("");this.frames=null;const r=Za(n);this.onMessage(r)}}handleNewFrameCount_(e){this.totalFrames=e,this.frames=[]}extractFrameCount_(e){if(G(this.frames===null,"We already have a frame buffer"),e.length<=6){const n=Number(e);if(!isNaN(n))return this.handleNewFrameCount_(n),null}return this.handleNewFrameCount_(1),e}handleIncomingFrame(e){if(this.mySock===null)return;const n=e.data;if(this.bytesReceived+=n.length,this.stats_.incrementCounter("bytes_received",n.length),this.resetKeepAlive(),this.frames!==null)this.appendFrame_(n);else{const r=this.extractFrameCount_(n);r!==null&&this.appendFrame_(r)}}send(e){this.resetKeepAlive();const n=Et(e);this.bytesSent+=n.length,this.stats_.incrementCounter("bytes_sent",n.length);const r=$S(n,XO);r.length>1&&this.sendString_(String(r.length));for(let i=0;i<r.length;i++)this.sendString_(r[i])}shutdown_(){this.isClosed_=!0,this.keepaliveTimer&&(clearInterval(this.keepaliveTimer),this.keepaliveTimer=null),this.mySock&&(this.mySock.close(),this.mySock=null)}onClosed_(){this.isClosed_||(this.log_("WebSocket is closing itself"),this.shutdown_(),this.onDisconnect&&(this.onDisconnect(this.everConnected_),this.onDisconnect=null))}close(){this.isClosed_||(this.log_("WebSocket is being closed"),this.shutdown_())}resetKeepAlive(){clearInterval(this.keepaliveTimer),this.keepaliveTimer=setInterval(()=>{this.mySock&&this.sendString_("0"),this.resetKeepAlive()},Math.floor(JO))}sendString_(e){try{this.mySock.send(e)}catch(n){this.log_("Exception thrown from WebSocket.send():",n.message||n.data,"Closing connection."),setTimeout(this.onClosed_.bind(this),0)}}}bn.responsesRequiredToBeHealthy=2;bn.healthyTimeout=3e4;/**
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
 */class cl{constructor(e){this.initTransports_(e)}static get ALL_TRANSPORTS(){return[Ds,bn]}static get IS_TRANSPORT_INITIALIZED(){return this.globalTransportInitialized_}initTransports_(e){const n=bn&&bn.isAvailable();let r=n&&!bn.previouslyFailed();if(e.webSocketOnly&&(n||en("wss:// URL used, but browser isn't known to support websockets.  Trying anyway."),r=!0),r)this.transports_=[bn];else{const i=this.transports_=[];for(const s of cl.ALL_TRANSPORTS)s&&s.isAvailable()&&i.push(s);cl.globalTransportInitialized_=!0}}initialTransport(){if(this.transports_.length>0)return this.transports_[0];throw new Error("No transports available")}upgradeTransport(){return this.transports_.length>1?this.transports_[1]:null}}cl.globalTransportInitialized_=!1;/**
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
 */const ZO=6e4,eM=5e3,tM=10*1024,nM=100*1024,Hd="t",C0="d",rM="s",R0="r",iM="e",x0="o",A0="a",P0="n",b0="p",sM="h";class oM{constructor(e,n,r,i,s,o,a,u,c,h){this.id=e,this.repoInfo_=n,this.applicationId_=r,this.appCheckToken_=i,this.authToken_=s,this.onMessage_=o,this.onReady_=a,this.onDisconnect_=u,this.onKill_=c,this.lastSessionId=h,this.connectionCount=0,this.pendingDataMessages=[],this.state_=0,this.log_=xl("c:"+this.id+":"),this.transportManager_=new cl(n),this.log_("Connection created"),this.start_()}start_(){const e=this.transportManager_.initialTransport();this.conn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,null,this.lastSessionId),this.primaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.conn_),r=this.disconnReceiver_(this.conn_);this.tx_=this.conn_,this.rx_=this.conn_,this.secondaryConn_=null,this.isHealthy_=!1,setTimeout(()=>{this.conn_&&this.conn_.open(n,r)},Math.floor(0));const i=e.healthyTimeout||0;i>0&&(this.healthyTimeout_=Aa(()=>{this.healthyTimeout_=null,this.isHealthy_||(this.conn_&&this.conn_.bytesReceived>nM?(this.log_("Connection exceeded healthy timeout but has received "+this.conn_.bytesReceived+" bytes.  Marking connection healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()):this.conn_&&this.conn_.bytesSent>tM?this.log_("Connection exceeded healthy timeout but has sent "+this.conn_.bytesSent+" bytes.  Leaving connection alive."):(this.log_("Closing unhealthy connection after timeout."),this.close()))},Math.floor(i)))}nextTransportId_(){return"c:"+this.id+":"+this.connectionCount++}disconnReceiver_(e){return n=>{e===this.conn_?this.onConnectionLost_(n):e===this.secondaryConn_?(this.log_("Secondary connection lost."),this.onSecondaryConnectionLost_()):this.log_("closing an old connection")}}connReceiver_(e){return n=>{this.state_!==2&&(e===this.rx_?this.onPrimaryMessageReceived_(n):e===this.secondaryConn_?this.onSecondaryMessageReceived_(n):this.log_("message on old connection"))}}sendRequest(e){const n={t:"d",d:e};this.sendData_(n)}tryCleanupConnection(){this.tx_===this.secondaryConn_&&this.rx_===this.secondaryConn_&&(this.log_("cleaning up and promoting a connection: "+this.secondaryConn_.connId),this.conn_=this.secondaryConn_,this.secondaryConn_=null)}onSecondaryControl_(e){if(Hd in e){const n=e[Hd];n===A0?this.upgradeIfSecondaryHealthy_():n===R0?(this.log_("Got a reset on secondary, closing it"),this.secondaryConn_.close(),(this.tx_===this.secondaryConn_||this.rx_===this.secondaryConn_)&&this.close()):n===x0&&(this.log_("got pong on secondary."),this.secondaryResponsesRequired_--,this.upgradeIfSecondaryHealthy_())}}onSecondaryMessageReceived_(e){const n=ea("t",e),r=ea("d",e);if(n==="c")this.onSecondaryControl_(r);else if(n==="d")this.pendingDataMessages.push(r);else throw new Error("Unknown protocol layer: "+n)}upgradeIfSecondaryHealthy_(){this.secondaryResponsesRequired_<=0?(this.log_("Secondary connection is healthy."),this.isHealthy_=!0,this.secondaryConn_.markConnectionHealthy(),this.proceedWithUpgrade_()):(this.log_("sending ping on secondary."),this.secondaryConn_.send({t:"c",d:{t:b0,d:{}}}))}proceedWithUpgrade_(){this.secondaryConn_.start(),this.log_("sending client ack on secondary"),this.secondaryConn_.send({t:"c",d:{t:A0,d:{}}}),this.log_("Ending transmission on primary"),this.conn_.send({t:"c",d:{t:P0,d:{}}}),this.tx_=this.secondaryConn_,this.tryCleanupConnection()}onPrimaryMessageReceived_(e){const n=ea("t",e),r=ea("d",e);n==="c"?this.onControl_(r):n==="d"&&this.onDataMessage_(r)}onDataMessage_(e){this.onPrimaryResponse_(),this.onMessage_(e)}onPrimaryResponse_(){this.isHealthy_||(this.primaryResponsesRequired_--,this.primaryResponsesRequired_<=0&&(this.log_("Primary connection is healthy."),this.isHealthy_=!0,this.conn_.markConnectionHealthy()))}onControl_(e){const n=ea(Hd,e);if(C0 in e){const r=e[C0];if(n===sM){const i=Object.assign({},r);this.repoInfo_.isUsingEmulator&&(i.h=this.repoInfo_.host),this.onHandshake_(i)}else if(n===P0){this.log_("recvd end transmission on primary"),this.rx_=this.secondaryConn_;for(let i=0;i<this.pendingDataMessages.length;++i)this.onDataMessage_(this.pendingDataMessages[i]);this.pendingDataMessages=[],this.tryCleanupConnection()}else n===rM?this.onConnectionShutdown_(r):n===R0?this.onReset_(r):n===iM?vp("Server Error: "+r):n===x0?(this.log_("got pong on primary."),this.onPrimaryResponse_(),this.sendPingOnPrimaryIfNecessary_()):vp("Unknown control packet command: "+n)}}onHandshake_(e){const n=e.ts,r=e.v,i=e.h;this.sessionId=e.s,this.repoInfo_.host=i,this.state_===0&&(this.conn_.start(),this.onConnectionEstablished_(this.conn_,n),Cg!==r&&en("Protocol version mismatch detected"),this.tryStartUpgrade_())}tryStartUpgrade_(){const e=this.transportManager_.upgradeTransport();e&&this.startUpgrade_(e)}startUpgrade_(e){this.secondaryConn_=new e(this.nextTransportId_(),this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,this.sessionId),this.secondaryResponsesRequired_=e.responsesRequiredToBeHealthy||0;const n=this.connReceiver_(this.secondaryConn_),r=this.disconnReceiver_(this.secondaryConn_);this.secondaryConn_.open(n,r),Aa(()=>{this.secondaryConn_&&(this.log_("Timed out trying to upgrade."),this.secondaryConn_.close())},Math.floor(ZO))}onReset_(e){this.log_("Reset packet received.  New host: "+e),this.repoInfo_.host=e,this.state_===1?this.close():(this.closeConnections_(),this.start_())}onConnectionEstablished_(e,n){this.log_("Realtime connection established."),this.conn_=e,this.state_=1,this.onReady_&&(this.onReady_(n,this.sessionId),this.onReady_=null),this.primaryResponsesRequired_===0?(this.log_("Primary connection is healthy."),this.isHealthy_=!0):Aa(()=>{this.sendPingOnPrimaryIfNecessary_()},Math.floor(eM))}sendPingOnPrimaryIfNecessary_(){!this.isHealthy_&&this.state_===1&&(this.log_("sending ping on primary."),this.sendData_({t:"c",d:{t:b0,d:{}}}))}onSecondaryConnectionLost_(){const e=this.secondaryConn_;this.secondaryConn_=null,(this.tx_===e||this.rx_===e)&&this.close()}onConnectionLost_(e){this.conn_=null,!e&&this.state_===0?(this.log_("Realtime connection failed."),this.repoInfo_.isCacheableHost()&&(Di.remove("host:"+this.repoInfo_.host),this.repoInfo_.internalHost=this.repoInfo_.host)):this.state_===1&&this.log_("Realtime connection lost."),this.close()}onConnectionShutdown_(e){this.log_("Connection shutdown command received. Shutting down..."),this.onKill_&&(this.onKill_(e),this.onKill_=null),this.onDisconnect_=null,this.close()}sendData_(e){if(this.state_!==1)throw"Connection is not connected";this.tx_.send(e)}close(){this.state_!==2&&(this.log_("Closing realtime connection."),this.state_=2,this.closeConnections_(),this.onDisconnect_&&(this.onDisconnect_(),this.onDisconnect_=null))}closeConnections_(){this.log_("Shutting down all connections"),this.conn_&&(this.conn_.close(),this.conn_=null),this.secondaryConn_&&(this.secondaryConn_.close(),this.secondaryConn_=null),this.healthyTimeout_&&(clearTimeout(this.healthyTimeout_),this.healthyTimeout_=null)}}/**
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
 */class ak{put(e,n,r,i){}merge(e,n,r,i){}refreshAuthToken(e){}refreshAppCheckToken(e){}onDisconnectPut(e,n,r){}onDisconnectMerge(e,n,r){}onDisconnectCancel(e,n){}reportStats(e){}}/**
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
 */class lk{constructor(e){this.allowedEvents_=e,this.listeners_={},G(Array.isArray(e)&&e.length>0,"Requires a non-empty array")}trigger(e,...n){if(Array.isArray(this.listeners_[e])){const r=[...this.listeners_[e]];for(let i=0;i<r.length;i++)r[i].callback.apply(r[i].context,n)}}on(e,n,r){this.validateEventType_(e),this.listeners_[e]=this.listeners_[e]||[],this.listeners_[e].push({callback:n,context:r});const i=this.getInitialEvent(e);i&&n.apply(r,i)}off(e,n,r){this.validateEventType_(e);const i=this.listeners_[e]||[];for(let s=0;s<i.length;s++)if(i[s].callback===n&&(!r||r===i[s].context)){i.splice(s,1);return}}validateEventType_(e){G(this.allowedEvents_.find(n=>n===e),"Unknown event: "+e)}}/**
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
 */class Lc extends lk{constructor(){super(["online"]),this.online_=!0,typeof window<"u"&&typeof window.addEventListener<"u"&&!Mm()&&(window.addEventListener("online",()=>{this.online_||(this.online_=!0,this.trigger("online",!0))},!1),window.addEventListener("offline",()=>{this.online_&&(this.online_=!1,this.trigger("online",!1))},!1))}static getInstance(){return new Lc}getInitialEvent(e){return G(e==="online","Unknown event type: "+e),[this.online_]}currentlyOnline(){return this.online_}}/**
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
 */const N0=32,D0=768;class ze{constructor(e,n){if(n===void 0){this.pieces_=e.split("/");let r=0;for(let i=0;i<this.pieces_.length;i++)this.pieces_[i].length>0&&(this.pieces_[r]=this.pieces_[i],r++);this.pieces_.length=r,this.pieceNum_=0}else this.pieces_=e,this.pieceNum_=n}toString(){let e="";for(let n=this.pieceNum_;n<this.pieces_.length;n++)this.pieces_[n]!==""&&(e+="/"+this.pieces_[n]);return e||"/"}}function Re(){return new ze("")}function fe(t){return t.pieceNum_>=t.pieces_.length?null:t.pieces_[t.pieceNum_]}function fi(t){return t.pieces_.length-t.pieceNum_}function Fe(t){let e=t.pieceNum_;return e<t.pieces_.length&&e++,new ze(t.pieces_,e)}function uk(t){return t.pieceNum_<t.pieces_.length?t.pieces_[t.pieces_.length-1]:null}function aM(t){let e="";for(let n=t.pieceNum_;n<t.pieces_.length;n++)t.pieces_[n]!==""&&(e+="/"+encodeURIComponent(String(t.pieces_[n])));return e||"/"}function ck(t,e=0){return t.pieces_.slice(t.pieceNum_+e)}function hk(t){if(t.pieceNum_>=t.pieces_.length)return null;const e=[];for(let n=t.pieceNum_;n<t.pieces_.length-1;n++)e.push(t.pieces_[n]);return new ze(e,0)}function at(t,e){const n=[];for(let r=t.pieceNum_;r<t.pieces_.length;r++)n.push(t.pieces_[r]);if(e instanceof ze)for(let r=e.pieceNum_;r<e.pieces_.length;r++)n.push(e.pieces_[r]);else{const r=e.split("/");for(let i=0;i<r.length;i++)r[i].length>0&&n.push(r[i])}return new ze(n,0)}function me(t){return t.pieceNum_>=t.pieces_.length}function gn(t,e){const n=fe(t),r=fe(e);if(n===null)return e;if(n===r)return gn(Fe(t),Fe(e));throw new Error("INTERNAL ERROR: innerPath ("+e+") is not within outerPath ("+t+")")}function dk(t,e){if(fi(t)!==fi(e))return!1;for(let n=t.pieceNum_,r=e.pieceNum_;n<=t.pieces_.length;n++,r++)if(t.pieces_[n]!==e.pieces_[r])return!1;return!0}function Dn(t,e){let n=t.pieceNum_,r=e.pieceNum_;if(fi(t)>fi(e))return!1;for(;n<t.pieces_.length;){if(t.pieces_[n]!==e.pieces_[r])return!1;++n,++r}return!0}class lM{constructor(e,n){this.errorPrefix_=n,this.parts_=ck(e,0),this.byteLength_=Math.max(1,this.parts_.length);for(let r=0;r<this.parts_.length;r++)this.byteLength_+=mh(this.parts_[r]);fk(this)}}function uM(t,e){t.parts_.length>0&&(t.byteLength_+=1),t.parts_.push(e),t.byteLength_+=mh(e),fk(t)}function cM(t){const e=t.parts_.pop();t.byteLength_-=mh(e),t.parts_.length>0&&(t.byteLength_-=1)}function fk(t){if(t.byteLength_>D0)throw new Error(t.errorPrefix_+"has a key path longer than "+D0+" bytes ("+t.byteLength_+").");if(t.parts_.length>N0)throw new Error(t.errorPrefix_+"path specified exceeds the maximum depth that can be written ("+N0+") or object contains a cycle "+Ri(t))}function Ri(t){return t.parts_.length===0?"":"in property '"+t.parts_.join(".")+"'"}/**
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
 */class Ag extends lk{constructor(){super(["visible"]);let e,n;typeof document<"u"&&typeof document.addEventListener<"u"&&(typeof document.hidden<"u"?(n="visibilitychange",e="hidden"):typeof document.mozHidden<"u"?(n="mozvisibilitychange",e="mozHidden"):typeof document.msHidden<"u"?(n="msvisibilitychange",e="msHidden"):typeof document.webkitHidden<"u"&&(n="webkitvisibilitychange",e="webkitHidden")),this.visible_=!0,n&&document.addEventListener(n,()=>{const r=!document[e];r!==this.visible_&&(this.visible_=r,this.trigger("visible",r))},!1)}static getInstance(){return new Ag}getInitialEvent(e){return G(e==="visible","Unknown event type: "+e),[this.visible_]}}/**
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
 */const ta=1e3,hM=60*5*1e3,O0=30*1e3,dM=1.3,fM=3e4,pM="server_kill",M0=3;class pr extends ak{constructor(e,n,r,i,s,o,a,u){if(super(),this.repoInfo_=e,this.applicationId_=n,this.onDataUpdate_=r,this.onConnectStatus_=i,this.onServerInfoUpdate_=s,this.authTokenProvider_=o,this.appCheckTokenProvider_=a,this.authOverride_=u,this.id=pr.nextPersistentConnectionId_++,this.log_=xl("p:"+this.id+":"),this.interruptReasons_={},this.listens=new Map,this.outstandingPuts_=[],this.outstandingGets_=[],this.outstandingPutCount_=0,this.outstandingGetCount_=0,this.onDisconnectRequestQueue_=[],this.connected_=!1,this.reconnectDelay_=ta,this.maxReconnectDelay_=hM,this.securityDebugCallback_=null,this.lastSessionId=null,this.establishConnectionTimer_=null,this.visible_=!1,this.requestCBHash_={},this.requestNumber_=0,this.realtime_=null,this.authToken_=null,this.appCheckToken_=null,this.forceTokenRefresh_=!1,this.invalidAuthTokenCount_=0,this.invalidAppCheckTokenCount_=0,this.firstConnection_=!0,this.lastConnectionAttemptTime_=null,this.lastConnectionEstablishedTime_=null,u)throw new Error("Auth override specified in options, but not supported on non Node.js platforms");Ag.getInstance().on("visible",this.onVisible_,this),e.host.indexOf("fblocal")===-1&&Lc.getInstance().on("online",this.onOnline_,this)}sendRequest(e,n,r){const i=++this.requestNumber_,s={r:i,a:e,b:n};this.log_(Et(s)),G(this.connected_,"sendRequest call when we're not connected not allowed."),this.realtime_.sendRequest(s),r&&(this.requestCBHash_[i]=r)}get(e){this.initConnection_();const n=new ph,i={action:"g",request:{p:e._path.toString(),q:e._queryObject},onComplete:o=>{const a=o.d;o.s==="ok"?n.resolve(a):n.reject(a)}};this.outstandingGets_.push(i),this.outstandingGetCount_++;const s=this.outstandingGets_.length-1;return this.connected_&&this.sendGet_(s),n.promise}listen(e,n,r,i){this.initConnection_();const s=e._queryIdentifier,o=e._path.toString();this.log_("Listen called for "+o+" "+s),this.listens.has(o)||this.listens.set(o,new Map),G(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"listen() called for non-default but complete query"),G(!this.listens.get(o).has(s),"listen() called twice for same path/queryId.");const a={onComplete:i,hashFn:n,query:e,tag:r};this.listens.get(o).set(s,a),this.connected_&&this.sendListen_(a)}sendGet_(e){const n=this.outstandingGets_[e];this.sendRequest("g",n.request,r=>{delete this.outstandingGets_[e],this.outstandingGetCount_--,this.outstandingGetCount_===0&&(this.outstandingGets_=[]),n.onComplete&&n.onComplete(r)})}sendListen_(e){const n=e.query,r=n._path.toString(),i=n._queryIdentifier;this.log_("Listen on "+r+" for "+i);const s={p:r},o="q";e.tag&&(s.q=n._queryObject,s.t=e.tag),s.h=e.hashFn(),this.sendRequest(o,s,a=>{const u=a.d,c=a.s;pr.warnOnListenWarnings_(u,n),(this.listens.get(r)&&this.listens.get(r).get(i))===e&&(this.log_("listen response",a),c!=="ok"&&this.removeListen_(r,i),e.onComplete&&e.onComplete(c,u))})}static warnOnListenWarnings_(e,n){if(e&&typeof e=="object"&&xr(e,"w")){const r=no(e,"w");if(Array.isArray(r)&&~r.indexOf("no_index")){const i='".indexOn": "'+n._queryParams.getIndex().toString()+'"',s=n._path.toString();en(`Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding ${i} at ${s} to your security rules for better performance.`)}}}refreshAuthToken(e){this.authToken_=e,this.log_("Auth token refreshed"),this.authToken_?this.tryAuth():this.connected_&&this.sendRequest("unauth",{},()=>{}),this.reduceReconnectDelayIfAdminCredential_(e)}reduceReconnectDelayIfAdminCredential_(e){(e&&e.length===40||xA(e))&&(this.log_("Admin auth credential detected.  Reducing max reconnect time."),this.maxReconnectDelay_=O0)}refreshAppCheckToken(e){this.appCheckToken_=e,this.log_("App check token refreshed"),this.appCheckToken_?this.tryAppCheck():this.connected_&&this.sendRequest("unappeck",{},()=>{})}tryAuth(){if(this.connected_&&this.authToken_){const e=this.authToken_,n=RA(e)?"auth":"gauth",r={cred:e};this.authOverride_===null?r.noauth=!0:typeof this.authOverride_=="object"&&(r.authvar=this.authOverride_),this.sendRequest(n,r,i=>{const s=i.s,o=i.d||"error";this.authToken_===e&&(s==="ok"?this.invalidAuthTokenCount_=0:this.onAuthRevoked_(s,o))})}}tryAppCheck(){this.connected_&&this.appCheckToken_&&this.sendRequest("appcheck",{token:this.appCheckToken_},e=>{const n=e.s,r=e.d||"error";n==="ok"?this.invalidAppCheckTokenCount_=0:this.onAppCheckRevoked_(n,r)})}unlisten(e,n){const r=e._path.toString(),i=e._queryIdentifier;this.log_("Unlisten called for "+r+" "+i),G(e._queryParams.isDefault()||!e._queryParams.loadsAllData(),"unlisten() called for non-default but complete query"),this.removeListen_(r,i)&&this.connected_&&this.sendUnlisten_(r,i,e._queryObject,n)}sendUnlisten_(e,n,r,i){this.log_("Unlisten on "+e+" for "+n);const s={p:e},o="n";i&&(s.q=r,s.t=i),this.sendRequest(o,s)}onDisconnectPut(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("o",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"o",data:n,onComplete:r})}onDisconnectMerge(e,n,r){this.initConnection_(),this.connected_?this.sendOnDisconnect_("om",e,n,r):this.onDisconnectRequestQueue_.push({pathString:e,action:"om",data:n,onComplete:r})}onDisconnectCancel(e,n){this.initConnection_(),this.connected_?this.sendOnDisconnect_("oc",e,null,n):this.onDisconnectRequestQueue_.push({pathString:e,action:"oc",data:null,onComplete:n})}sendOnDisconnect_(e,n,r,i){const s={p:n,d:r};this.log_("onDisconnect "+e,s),this.sendRequest(e,s,o=>{i&&setTimeout(()=>{i(o.s,o.d)},Math.floor(0))})}put(e,n,r,i){this.putInternal("p",e,n,r,i)}merge(e,n,r,i){this.putInternal("m",e,n,r,i)}putInternal(e,n,r,i,s){this.initConnection_();const o={p:n,d:r};s!==void 0&&(o.h=s),this.outstandingPuts_.push({action:e,request:o,onComplete:i}),this.outstandingPutCount_++;const a=this.outstandingPuts_.length-1;this.connected_?this.sendPut_(a):this.log_("Buffering put: "+n)}sendPut_(e){const n=this.outstandingPuts_[e].action,r=this.outstandingPuts_[e].request,i=this.outstandingPuts_[e].onComplete;this.outstandingPuts_[e].queued=this.connected_,this.sendRequest(n,r,s=>{this.log_(n+" response",s),delete this.outstandingPuts_[e],this.outstandingPutCount_--,this.outstandingPutCount_===0&&(this.outstandingPuts_=[]),i&&i(s.s,s.d)})}reportStats(e){if(this.connected_){const n={c:e};this.log_("reportStats",n),this.sendRequest("s",n,r=>{if(r.s!=="ok"){const s=r.d;this.log_("reportStats","Error sending stats: "+s)}})}}onDataMessage_(e){if("r"in e){this.log_("from server: "+Et(e));const n=e.r,r=this.requestCBHash_[n];r&&(delete this.requestCBHash_[n],r(e.b))}else{if("error"in e)throw"A server-side error has occurred: "+e.error;"a"in e&&this.onDataPush_(e.a,e.b)}}onDataPush_(e,n){this.log_("handleServerMessage",e,n),e==="d"?this.onDataUpdate_(n.p,n.d,!1,n.t):e==="m"?this.onDataUpdate_(n.p,n.d,!0,n.t):e==="c"?this.onListenRevoked_(n.p,n.q):e==="ac"?this.onAuthRevoked_(n.s,n.d):e==="apc"?this.onAppCheckRevoked_(n.s,n.d):e==="sd"?this.onSecurityDebugPacket_(n):vp("Unrecognized action received from server: "+Et(e)+`
Are you using the latest client?`)}onReady_(e,n){this.log_("connection ready"),this.connected_=!0,this.lastConnectionEstablishedTime_=new Date().getTime(),this.handleTimestamp_(e),this.lastSessionId=n,this.firstConnection_&&this.sendConnectStats_(),this.restoreState_(),this.firstConnection_=!1,this.onConnectStatus_(!0)}scheduleConnect_(e){G(!this.realtime_,"Scheduling a connect when we're already connected/ing?"),this.establishConnectionTimer_&&clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=setTimeout(()=>{this.establishConnectionTimer_=null,this.establishConnection_()},Math.floor(e))}initConnection_(){!this.realtime_&&this.firstConnection_&&this.scheduleConnect_(0)}onVisible_(e){e&&!this.visible_&&this.reconnectDelay_===this.maxReconnectDelay_&&(this.log_("Window became visible.  Reducing delay."),this.reconnectDelay_=ta,this.realtime_||this.scheduleConnect_(0)),this.visible_=e}onOnline_(e){e?(this.log_("Browser went online."),this.reconnectDelay_=ta,this.realtime_||this.scheduleConnect_(0)):(this.log_("Browser went offline.  Killing connection."),this.realtime_&&this.realtime_.close())}onRealtimeDisconnect_(){if(this.log_("data client disconnected"),this.connected_=!1,this.realtime_=null,this.cancelSentTransactions_(),this.requestCBHash_={},this.shouldReconnect_()){this.visible_?this.lastConnectionEstablishedTime_&&(new Date().getTime()-this.lastConnectionEstablishedTime_>fM&&(this.reconnectDelay_=ta),this.lastConnectionEstablishedTime_=null):(this.log_("Window isn't visible.  Delaying reconnect."),this.reconnectDelay_=this.maxReconnectDelay_,this.lastConnectionAttemptTime_=new Date().getTime());const e=new Date().getTime()-this.lastConnectionAttemptTime_;let n=Math.max(0,this.reconnectDelay_-e);n=Math.random()*n,this.log_("Trying to reconnect in "+n+"ms"),this.scheduleConnect_(n),this.reconnectDelay_=Math.min(this.maxReconnectDelay_,this.reconnectDelay_*dM)}this.onConnectStatus_(!1)}async establishConnection_(){if(this.shouldReconnect_()){this.log_("Making a connection attempt"),this.lastConnectionAttemptTime_=new Date().getTime(),this.lastConnectionEstablishedTime_=null;const e=this.onDataMessage_.bind(this),n=this.onReady_.bind(this),r=this.onRealtimeDisconnect_.bind(this),i=this.id+":"+pr.nextConnectionId_++,s=this.lastSessionId;let o=!1,a=null;const u=function(){a?a.close():(o=!0,r())},c=function(f){G(a,"sendRequest call when we're not connected not allowed."),a.sendRequest(f)};this.realtime_={close:u,sendRequest:c};const h=this.forceTokenRefresh_;this.forceTokenRefresh_=!1;try{const[f,m]=await Promise.all([this.authTokenProvider_.getToken(h),this.appCheckTokenProvider_.getToken(h)]);o?Mt("getToken() completed but was canceled"):(Mt("getToken() completed. Creating connection."),this.authToken_=f&&f.accessToken,this.appCheckToken_=m&&m.token,a=new oM(i,this.repoInfo_,this.applicationId_,this.appCheckToken_,this.authToken_,e,n,r,w=>{en(w+" ("+this.repoInfo_.toString()+")"),this.interrupt(pM)},s))}catch(f){this.log_("Failed to get token: "+f),o||(this.repoInfo_.nodeAdmin&&en(f),u())}}}interrupt(e){Mt("Interrupting connection for reason: "+e),this.interruptReasons_[e]=!0,this.realtime_?this.realtime_.close():(this.establishConnectionTimer_&&(clearTimeout(this.establishConnectionTimer_),this.establishConnectionTimer_=null),this.connected_&&this.onRealtimeDisconnect_())}resume(e){Mt("Resuming connection for reason: "+e),delete this.interruptReasons_[e],Yf(this.interruptReasons_)&&(this.reconnectDelay_=ta,this.realtime_||this.scheduleConnect_(0))}handleTimestamp_(e){const n=e-new Date().getTime();this.onServerInfoUpdate_({serverTimeOffset:n})}cancelSentTransactions_(){for(let e=0;e<this.outstandingPuts_.length;e++){const n=this.outstandingPuts_[e];n&&"h"in n.request&&n.queued&&(n.onComplete&&n.onComplete("disconnect"),delete this.outstandingPuts_[e],this.outstandingPutCount_--)}this.outstandingPutCount_===0&&(this.outstandingPuts_=[])}onListenRevoked_(e,n){let r;n?r=n.map(s=>kg(s)).join("$"):r="default";const i=this.removeListen_(e,r);i&&i.onComplete&&i.onComplete("permission_denied")}removeListen_(e,n){const r=new ze(e).toString();let i;if(this.listens.has(r)){const s=this.listens.get(r);i=s.get(n),s.delete(n),s.size===0&&this.listens.delete(r)}else i=void 0;return i}onAuthRevoked_(e,n){Mt("Auth token revoked: "+e+"/"+n),this.authToken_=null,this.forceTokenRefresh_=!0,this.realtime_.close(),(e==="invalid_token"||e==="permission_denied")&&(this.invalidAuthTokenCount_++,this.invalidAuthTokenCount_>=M0&&(this.reconnectDelay_=O0,this.authTokenProvider_.notifyForInvalidToken()))}onAppCheckRevoked_(e,n){Mt("App check token revoked: "+e+"/"+n),this.appCheckToken_=null,this.forceTokenRefresh_=!0,(e==="invalid_token"||e==="permission_denied")&&(this.invalidAppCheckTokenCount_++,this.invalidAppCheckTokenCount_>=M0&&this.appCheckTokenProvider_.notifyForInvalidToken())}onSecurityDebugPacket_(e){this.securityDebugCallback_?this.securityDebugCallback_(e):"msg"in e&&console.log("FIREBASE: "+e.msg.replace(`
`,`
FIREBASE: `))}restoreState_(){this.tryAuth(),this.tryAppCheck();for(const e of this.listens.values())for(const n of e.values())this.sendListen_(n);for(let e=0;e<this.outstandingPuts_.length;e++)this.outstandingPuts_[e]&&this.sendPut_(e);for(;this.onDisconnectRequestQueue_.length;){const e=this.onDisconnectRequestQueue_.shift();this.sendOnDisconnect_(e.action,e.pathString,e.data,e.onComplete)}for(let e=0;e<this.outstandingGets_.length;e++)this.outstandingGets_[e]&&this.sendGet_(e)}sendConnectStats_(){const e={};let n="js";e["sdk."+n+"."+US.replace(/\./g,"-")]=1,Mm()?e["framework.cordova"]=1:GT()&&(e["framework.reactnative"]=1),this.reportStats(e)}shouldReconnect_(){const e=Lc.getInstance().currentlyOnline();return Yf(this.interruptReasons_)&&e}}pr.nextPersistentConnectionId_=0;pr.nextConnectionId_=0;/**
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
 */class _e{constructor(e,n){this.name=e,this.node=n}static Wrap(e,n){return new _e(e,n)}}/**
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
 */class bh{getCompare(){return this.compare.bind(this)}indexedValueChanged(e,n){const r=new _e(co,e),i=new _e(co,n);return this.compare(r,i)!==0}minPost(){return _e.MIN}}/**
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
 */let Su;class pk extends bh{static get __EMPTY_NODE(){return Su}static set __EMPTY_NODE(e){Su=e}compare(e,n){return So(e.name,n.name)}isDefinedOn(e){throw go("KeyIndex.isDefinedOn not expected to be called.")}indexedValueChanged(e,n){return!1}minPost(){return _e.MIN}maxPost(){return new _e(Ki,Su)}makePost(e,n){return G(typeof e=="string","KeyIndex indexValue must always be a string."),new _e(e,Su)}toString(){return".key"}}const $s=new pk;/**
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
 */class ku{constructor(e,n,r,i,s=null){this.isReverse_=i,this.resultGenerator_=s,this.nodeStack_=[];let o=1;for(;!e.isEmpty();)if(e=e,o=n?r(e.key,n):1,i&&(o*=-1),o<0)this.isReverse_?e=e.left:e=e.right;else if(o===0){this.nodeStack_.push(e);break}else this.nodeStack_.push(e),this.isReverse_?e=e.right:e=e.left}getNext(){if(this.nodeStack_.length===0)return null;let e=this.nodeStack_.pop(),n;if(this.resultGenerator_?n=this.resultGenerator_(e.key,e.value):n={key:e.key,value:e.value},this.isReverse_)for(e=e.left;!e.isEmpty();)this.nodeStack_.push(e),e=e.right;else for(e=e.right;!e.isEmpty();)this.nodeStack_.push(e),e=e.left;return n}hasNext(){return this.nodeStack_.length>0}peek(){if(this.nodeStack_.length===0)return null;const e=this.nodeStack_[this.nodeStack_.length-1];return this.resultGenerator_?this.resultGenerator_(e.key,e.value):{key:e.key,value:e.value}}}class pt{constructor(e,n,r,i,s){this.key=e,this.value=n,this.color=r??pt.RED,this.left=i??Yt.EMPTY_NODE,this.right=s??Yt.EMPTY_NODE}copy(e,n,r,i,s){return new pt(e??this.key,n??this.value,r??this.color,i??this.left,s??this.right)}count(){return this.left.count()+1+this.right.count()}isEmpty(){return!1}inorderTraversal(e){return this.left.inorderTraversal(e)||!!e(this.key,this.value)||this.right.inorderTraversal(e)}reverseTraversal(e){return this.right.reverseTraversal(e)||e(this.key,this.value)||this.left.reverseTraversal(e)}min_(){return this.left.isEmpty()?this:this.left.min_()}minKey(){return this.min_().key}maxKey(){return this.right.isEmpty()?this.key:this.right.maxKey()}insert(e,n,r){let i=this;const s=r(e,i.key);return s<0?i=i.copy(null,null,null,i.left.insert(e,n,r),null):s===0?i=i.copy(null,n,null,null,null):i=i.copy(null,null,null,null,i.right.insert(e,n,r)),i.fixUp_()}removeMin_(){if(this.left.isEmpty())return Yt.EMPTY_NODE;let e=this;return!e.left.isRed_()&&!e.left.left.isRed_()&&(e=e.moveRedLeft_()),e=e.copy(null,null,null,e.left.removeMin_(),null),e.fixUp_()}remove(e,n){let r,i;if(r=this,n(e,r.key)<0)!r.left.isEmpty()&&!r.left.isRed_()&&!r.left.left.isRed_()&&(r=r.moveRedLeft_()),r=r.copy(null,null,null,r.left.remove(e,n),null);else{if(r.left.isRed_()&&(r=r.rotateRight_()),!r.right.isEmpty()&&!r.right.isRed_()&&!r.right.left.isRed_()&&(r=r.moveRedRight_()),n(e,r.key)===0){if(r.right.isEmpty())return Yt.EMPTY_NODE;i=r.right.min_(),r=r.copy(i.key,i.value,null,null,r.right.removeMin_())}r=r.copy(null,null,null,null,r.right.remove(e,n))}return r.fixUp_()}isRed_(){return this.color}fixUp_(){let e=this;return e.right.isRed_()&&!e.left.isRed_()&&(e=e.rotateLeft_()),e.left.isRed_()&&e.left.left.isRed_()&&(e=e.rotateRight_()),e.left.isRed_()&&e.right.isRed_()&&(e=e.colorFlip_()),e}moveRedLeft_(){let e=this.colorFlip_();return e.right.left.isRed_()&&(e=e.copy(null,null,null,null,e.right.rotateRight_()),e=e.rotateLeft_(),e=e.colorFlip_()),e}moveRedRight_(){let e=this.colorFlip_();return e.left.left.isRed_()&&(e=e.rotateRight_(),e=e.colorFlip_()),e}rotateLeft_(){const e=this.copy(null,null,pt.RED,null,this.right.left);return this.right.copy(null,null,this.color,e,null)}rotateRight_(){const e=this.copy(null,null,pt.RED,this.left.right,null);return this.left.copy(null,null,this.color,null,e)}colorFlip_(){const e=this.left.copy(null,null,!this.left.color,null,null),n=this.right.copy(null,null,!this.right.color,null,null);return this.copy(null,null,!this.color,e,n)}checkMaxDepth_(){const e=this.check_();return Math.pow(2,e)<=this.count()+1}check_(){if(this.isRed_()&&this.left.isRed_())throw new Error("Red node has red child("+this.key+","+this.value+")");if(this.right.isRed_())throw new Error("Right child of ("+this.key+","+this.value+") is red");const e=this.left.check_();if(e!==this.right.check_())throw new Error("Black depths differ");return e+(this.isRed_()?0:1)}}pt.RED=!0;pt.BLACK=!1;class mM{copy(e,n,r,i,s){return this}insert(e,n,r){return new pt(e,n,null)}remove(e,n){return this}count(){return 0}isEmpty(){return!0}inorderTraversal(e){return!1}reverseTraversal(e){return!1}minKey(){return null}maxKey(){return null}check_(){return 0}isRed_(){return!1}}class Yt{constructor(e,n=Yt.EMPTY_NODE){this.comparator_=e,this.root_=n}insert(e,n){return new Yt(this.comparator_,this.root_.insert(e,n,this.comparator_).copy(null,null,pt.BLACK,null,null))}remove(e){return new Yt(this.comparator_,this.root_.remove(e,this.comparator_).copy(null,null,pt.BLACK,null,null))}get(e){let n,r=this.root_;for(;!r.isEmpty();){if(n=this.comparator_(e,r.key),n===0)return r.value;n<0?r=r.left:n>0&&(r=r.right)}return null}getPredecessorKey(e){let n,r=this.root_,i=null;for(;!r.isEmpty();)if(n=this.comparator_(e,r.key),n===0){if(r.left.isEmpty())return i?i.key:null;for(r=r.left;!r.right.isEmpty();)r=r.right;return r.key}else n<0?r=r.left:n>0&&(i=r,r=r.right);throw new Error("Attempted to find predecessor key for a nonexistent key.  What gives?")}isEmpty(){return this.root_.isEmpty()}count(){return this.root_.count()}minKey(){return this.root_.minKey()}maxKey(){return this.root_.maxKey()}inorderTraversal(e){return this.root_.inorderTraversal(e)}reverseTraversal(e){return this.root_.reverseTraversal(e)}getIterator(e){return new ku(this.root_,null,this.comparator_,!1,e)}getIteratorFrom(e,n){return new ku(this.root_,e,this.comparator_,!1,n)}getReverseIteratorFrom(e,n){return new ku(this.root_,e,this.comparator_,!0,n)}getReverseIterator(e){return new ku(this.root_,null,this.comparator_,!0,e)}}Yt.EMPTY_NODE=new mM;/**
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
 */function gM(t,e){return So(t.name,e.name)}function Pg(t,e){return So(t,e)}/**
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
 */let Ep;function _M(t){Ep=t}const mk=function(t){return typeof t=="number"?"number:"+WS(t):"string:"+t},gk=function(t){if(t.isLeafNode()){const e=t.val();G(typeof e=="string"||typeof e=="number"||typeof e=="object"&&xr(e,".sv"),"Priority must be a string or number.")}else G(t===Ep||t.isEmpty(),"priority of unexpected type.");G(t===Ep||t.getPriority().isEmpty(),"Priority nodes can't have a priority of their own.")};/**
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
 */let L0;class ht{constructor(e,n=ht.__childrenNodeConstructor.EMPTY_NODE){this.value_=e,this.priorityNode_=n,this.lazyHash_=null,G(this.value_!==void 0&&this.value_!==null,"LeafNode shouldn't be created with null/undefined value."),gk(this.priorityNode_)}static set __childrenNodeConstructor(e){L0=e}static get __childrenNodeConstructor(){return L0}isLeafNode(){return!0}getPriority(){return this.priorityNode_}updatePriority(e){return new ht(this.value_,e)}getImmediateChild(e){return e===".priority"?this.priorityNode_:ht.__childrenNodeConstructor.EMPTY_NODE}getChild(e){return me(e)?this:fe(e)===".priority"?this.priorityNode_:ht.__childrenNodeConstructor.EMPTY_NODE}hasChild(){return!1}getPredecessorChildName(e,n){return null}updateImmediateChild(e,n){return e===".priority"?this.updatePriority(n):n.isEmpty()&&e!==".priority"?this:ht.__childrenNodeConstructor.EMPTY_NODE.updateImmediateChild(e,n).updatePriority(this.priorityNode_)}updateChild(e,n){const r=fe(e);return r===null?n:n.isEmpty()&&r!==".priority"?this:(G(r!==".priority"||fi(e)===1,".priority must be the last token in a path"),this.updateImmediateChild(r,ht.__childrenNodeConstructor.EMPTY_NODE.updateChild(Fe(e),n)))}isEmpty(){return!1}numChildren(){return 0}forEachChild(e,n){return!1}val(e){return e&&!this.getPriority().isEmpty()?{".value":this.getValue(),".priority":this.getPriority().val()}:this.getValue()}hash(){if(this.lazyHash_===null){let e="";this.priorityNode_.isEmpty()||(e+="priority:"+mk(this.priorityNode_.val())+":");const n=typeof this.value_;e+=n+":",n==="number"?e+=WS(this.value_):e+=this.value_,this.lazyHash_=zS(e)}return this.lazyHash_}getValue(){return this.value_}compareTo(e){return e===ht.__childrenNodeConstructor.EMPTY_NODE?1:e instanceof ht.__childrenNodeConstructor?-1:(G(e.isLeafNode(),"Unknown node type"),this.compareToLeafNode_(e))}compareToLeafNode_(e){const n=typeof e.value_,r=typeof this.value_,i=ht.VALUE_TYPE_ORDER.indexOf(n),s=ht.VALUE_TYPE_ORDER.indexOf(r);return G(i>=0,"Unknown leaf type: "+n),G(s>=0,"Unknown leaf type: "+r),i===s?r==="object"?0:this.value_<e.value_?-1:this.value_===e.value_?0:1:s-i}withIndex(){return this}isIndexed(){return!0}equals(e){if(e===this)return!0;if(e.isLeafNode()){const n=e;return this.value_===n.value_&&this.priorityNode_.equals(n.priorityNode_)}else return!1}}ht.VALUE_TYPE_ORDER=["object","boolean","number","string"];/**
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
 */let _k,yk;function yM(t){_k=t}function vM(t){yk=t}class wM extends bh{compare(e,n){const r=e.node.getPriority(),i=n.node.getPriority(),s=r.compareTo(i);return s===0?So(e.name,n.name):s}isDefinedOn(e){return!e.getPriority().isEmpty()}indexedValueChanged(e,n){return!e.getPriority().equals(n.getPriority())}minPost(){return _e.MIN}maxPost(){return new _e(Ki,new ht("[PRIORITY-POST]",yk))}makePost(e,n){const r=_k(e);return new _e(n,new ht("[PRIORITY-POST]",r))}toString(){return".priority"}}const Lt=new wM;/**
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
 */const EM=Math.log(2);class TM{constructor(e){const n=s=>parseInt(Math.log(s)/EM,10),r=s=>parseInt(Array(s+1).join("1"),2);this.count=n(e+1),this.current_=this.count-1;const i=r(this.count);this.bits_=e+1&i}nextBitIsOne(){const e=!(this.bits_&1<<this.current_);return this.current_--,e}}const Fc=function(t,e,n,r){t.sort(e);const i=function(u,c){const h=c-u;let f,m;if(h===0)return null;if(h===1)return f=t[u],m=n?n(f):f,new pt(m,f.node,pt.BLACK,null,null);{const w=parseInt(h/2,10)+u,S=i(u,w),P=i(w+1,c);return f=t[w],m=n?n(f):f,new pt(m,f.node,pt.BLACK,S,P)}},s=function(u){let c=null,h=null,f=t.length;const m=function(S,P){const D=f-S,k=f;f-=S;const T=i(D+1,k),R=t[D],M=n?n(R):R;w(new pt(M,R.node,P,null,T))},w=function(S){c?(c.left=S,c=S):(h=S,c=S)};for(let S=0;S<u.count;++S){const P=u.nextBitIsOne(),D=Math.pow(2,u.count-(S+1));P?m(D,pt.BLACK):(m(D,pt.BLACK),m(D,pt.RED))}return h},o=new TM(t.length),a=s(o);return new Yt(r||e,a)};/**
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
 */let Gd;const gs={};class lr{constructor(e,n){this.indexes_=e,this.indexSet_=n}static get Default(){return G(gs&&Lt,"ChildrenNode.ts has not been loaded"),Gd=Gd||new lr({".priority":gs},{".priority":Lt}),Gd}get(e){const n=no(this.indexes_,e);if(!n)throw new Error("No index defined for "+e);return n instanceof Yt?n:null}hasIndex(e){return xr(this.indexSet_,e.toString())}addIndex(e,n){G(e!==$s,"KeyIndex always exists and isn't meant to be added to the IndexMap.");const r=[];let i=!1;const s=n.getIterator(_e.Wrap);let o=s.getNext();for(;o;)i=i||e.isDefinedOn(o.node),r.push(o),o=s.getNext();let a;i?a=Fc(r,e.getCompare()):a=gs;const u=e.toString(),c=Object.assign({},this.indexSet_);c[u]=e;const h=Object.assign({},this.indexes_);return h[u]=a,new lr(h,c)}addToIndexes(e,n){const r=Sc(this.indexes_,(i,s)=>{const o=no(this.indexSet_,s);if(G(o,"Missing index implementation for "+s),i===gs)if(o.isDefinedOn(e.node)){const a=[],u=n.getIterator(_e.Wrap);let c=u.getNext();for(;c;)c.name!==e.name&&a.push(c),c=u.getNext();return a.push(e),Fc(a,o.getCompare())}else return gs;else{const a=n.get(e.name);let u=i;return a&&(u=u.remove(new _e(e.name,a))),u.insert(e,e.node)}});return new lr(r,this.indexSet_)}removeFromIndexes(e,n){const r=Sc(this.indexes_,i=>{if(i===gs)return i;{const s=n.get(e.name);return s?i.remove(new _e(e.name,s)):i}});return new lr(r,this.indexSet_)}}/**
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
 */let na;class Te{constructor(e,n,r){this.children_=e,this.priorityNode_=n,this.indexMap_=r,this.lazyHash_=null,this.priorityNode_&&gk(this.priorityNode_),this.children_.isEmpty()&&G(!this.priorityNode_||this.priorityNode_.isEmpty(),"An empty node cannot have a priority")}static get EMPTY_NODE(){return na||(na=new Te(new Yt(Pg),null,lr.Default))}isLeafNode(){return!1}getPriority(){return this.priorityNode_||na}updatePriority(e){return this.children_.isEmpty()?this:new Te(this.children_,e,this.indexMap_)}getImmediateChild(e){if(e===".priority")return this.getPriority();{const n=this.children_.get(e);return n===null?na:n}}getChild(e){const n=fe(e);return n===null?this:this.getImmediateChild(n).getChild(Fe(e))}hasChild(e){return this.children_.get(e)!==null}updateImmediateChild(e,n){if(G(n,"We should always be passing snapshot nodes"),e===".priority")return this.updatePriority(n);{const r=new _e(e,n);let i,s;n.isEmpty()?(i=this.children_.remove(e),s=this.indexMap_.removeFromIndexes(r,this.children_)):(i=this.children_.insert(e,n),s=this.indexMap_.addToIndexes(r,this.children_));const o=i.isEmpty()?na:this.priorityNode_;return new Te(i,o,s)}}updateChild(e,n){const r=fe(e);if(r===null)return n;{G(fe(e)!==".priority"||fi(e)===1,".priority must be the last token in a path");const i=this.getImmediateChild(r).updateChild(Fe(e),n);return this.updateImmediateChild(r,i)}}isEmpty(){return this.children_.isEmpty()}numChildren(){return this.children_.count()}val(e){if(this.isEmpty())return null;const n={};let r=0,i=0,s=!0;if(this.forEachChild(Lt,(o,a)=>{n[o]=a.val(e),r++,s&&Te.INTEGER_REGEXP_.test(o)?i=Math.max(i,Number(o)):s=!1}),!e&&s&&i<2*r){const o=[];for(const a in n)o[a]=n[a];return o}else return e&&!this.getPriority().isEmpty()&&(n[".priority"]=this.getPriority().val()),n}hash(){if(this.lazyHash_===null){let e="";this.getPriority().isEmpty()||(e+="priority:"+mk(this.getPriority().val())+":"),this.forEachChild(Lt,(n,r)=>{const i=r.hash();i!==""&&(e+=":"+n+":"+i)}),this.lazyHash_=e===""?"":zS(e)}return this.lazyHash_}getPredecessorChildName(e,n,r){const i=this.resolveIndex_(r);if(i){const s=i.getPredecessorKey(new _e(e,n));return s?s.name:null}else return this.children_.getPredecessorKey(e)}getFirstChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.minKey();return r&&r.name}else return this.children_.minKey()}getFirstChild(e){const n=this.getFirstChildName(e);return n?new _e(n,this.children_.get(n)):null}getLastChildName(e){const n=this.resolveIndex_(e);if(n){const r=n.maxKey();return r&&r.name}else return this.children_.maxKey()}getLastChild(e){const n=this.getLastChildName(e);return n?new _e(n,this.children_.get(n)):null}forEachChild(e,n){const r=this.resolveIndex_(e);return r?r.inorderTraversal(i=>n(i.name,i.node)):this.children_.inorderTraversal(n)}getIterator(e){return this.getIteratorFrom(e.minPost(),e)}getIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getIteratorFrom(e,i=>i);{const i=this.children_.getIteratorFrom(e.name,_e.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)<0;)i.getNext(),s=i.peek();return i}}getReverseIterator(e){return this.getReverseIteratorFrom(e.maxPost(),e)}getReverseIteratorFrom(e,n){const r=this.resolveIndex_(n);if(r)return r.getReverseIteratorFrom(e,i=>i);{const i=this.children_.getReverseIteratorFrom(e.name,_e.Wrap);let s=i.peek();for(;s!=null&&n.compare(s,e)>0;)i.getNext(),s=i.peek();return i}}compareTo(e){return this.isEmpty()?e.isEmpty()?0:-1:e.isLeafNode()||e.isEmpty()?1:e===Al?-1:0}withIndex(e){if(e===$s||this.indexMap_.hasIndex(e))return this;{const n=this.indexMap_.addIndex(e,this.children_);return new Te(this.children_,this.priorityNode_,n)}}isIndexed(e){return e===$s||this.indexMap_.hasIndex(e)}equals(e){if(e===this)return!0;if(e.isLeafNode())return!1;{const n=e;if(this.getPriority().equals(n.getPriority()))if(this.children_.count()===n.children_.count()){const r=this.getIterator(Lt),i=n.getIterator(Lt);let s=r.getNext(),o=i.getNext();for(;s&&o;){if(s.name!==o.name||!s.node.equals(o.node))return!1;s=r.getNext(),o=i.getNext()}return s===null&&o===null}else return!1;else return!1}}resolveIndex_(e){return e===$s?null:this.indexMap_.get(e.toString())}}Te.INTEGER_REGEXP_=/^(0|[1-9]\d*)$/;class IM extends Te{constructor(){super(new Yt(Pg),Te.EMPTY_NODE,lr.Default)}compareTo(e){return e===this?0:1}equals(e){return e===this}getPriority(){return this}getImmediateChild(e){return Te.EMPTY_NODE}isEmpty(){return!1}}const Al=new IM;Object.defineProperties(_e,{MIN:{value:new _e(co,Te.EMPTY_NODE)},MAX:{value:new _e(Ki,Al)}});pk.__EMPTY_NODE=Te.EMPTY_NODE;ht.__childrenNodeConstructor=Te;_M(Al);vM(Al);/**
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
 */const SM=!0;function wt(t,e=null){if(t===null)return Te.EMPTY_NODE;if(typeof t=="object"&&".priority"in t&&(e=t[".priority"]),G(e===null||typeof e=="string"||typeof e=="number"||typeof e=="object"&&".sv"in e,"Invalid priority type found: "+typeof e),typeof t=="object"&&".value"in t&&t[".value"]!==null&&(t=t[".value"]),typeof t!="object"||".sv"in t){const n=t;return new ht(n,wt(e))}if(!(t instanceof Array)&&SM){const n=[];let r=!1;if(Sn(t,(o,a)=>{if(o.substring(0,1)!=="."){const u=wt(a);u.isEmpty()||(r=r||!u.getPriority().isEmpty(),n.push(new _e(o,u)))}}),n.length===0)return Te.EMPTY_NODE;const s=Fc(n,gM,o=>o.name,Pg);if(r){const o=Fc(n,Lt.getCompare());return new Te(s,wt(e),new lr({".priority":o},{".priority":Lt}))}else return new Te(s,wt(e),lr.Default)}else{let n=Te.EMPTY_NODE;return Sn(t,(r,i)=>{if(xr(t,r)&&r.substring(0,1)!=="."){const s=wt(i);(s.isLeafNode()||!s.isEmpty())&&(n=n.updateImmediateChild(r,s))}}),n.updatePriority(wt(e))}}yM(wt);/**
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
 */class kM extends bh{constructor(e){super(),this.indexPath_=e,G(!me(e)&&fe(e)!==".priority","Can't create PathIndex with empty path or .priority key")}extractChild(e){return e.getChild(this.indexPath_)}isDefinedOn(e){return!e.getChild(this.indexPath_).isEmpty()}compare(e,n){const r=this.extractChild(e.node),i=this.extractChild(n.node),s=r.compareTo(i);return s===0?So(e.name,n.name):s}makePost(e,n){const r=wt(e),i=Te.EMPTY_NODE.updateChild(this.indexPath_,r);return new _e(n,i)}maxPost(){const e=Te.EMPTY_NODE.updateChild(this.indexPath_,Al);return new _e(Ki,e)}toString(){return ck(this.indexPath_,0).join("/")}}/**
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
 */class CM extends bh{compare(e,n){const r=e.node.compareTo(n.node);return r===0?So(e.name,n.name):r}isDefinedOn(e){return!0}indexedValueChanged(e,n){return!e.equals(n)}minPost(){return _e.MIN}maxPost(){return _e.MAX}makePost(e,n){const r=wt(e);return new _e(n,r)}toString(){return".value"}}const RM=new CM;/**
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
 */function xM(t){return{type:"value",snapshotNode:t}}function AM(t,e){return{type:"child_added",snapshotNode:e,childName:t}}function PM(t,e){return{type:"child_removed",snapshotNode:e,childName:t}}function F0(t,e,n){return{type:"child_changed",snapshotNode:e,childName:t,oldSnap:n}}function bM(t,e){return{type:"child_moved",snapshotNode:e,childName:t}}/**
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
 */class bg{constructor(){this.limitSet_=!1,this.startSet_=!1,this.startNameSet_=!1,this.startAfterSet_=!1,this.endSet_=!1,this.endNameSet_=!1,this.endBeforeSet_=!1,this.limit_=0,this.viewFrom_="",this.indexStartValue_=null,this.indexStartName_="",this.indexEndValue_=null,this.indexEndName_="",this.index_=Lt}hasStart(){return this.startSet_}isViewFromLeft(){return this.viewFrom_===""?this.startSet_:this.viewFrom_==="l"}getIndexStartValue(){return G(this.startSet_,"Only valid if start has been set"),this.indexStartValue_}getIndexStartName(){return G(this.startSet_,"Only valid if start has been set"),this.startNameSet_?this.indexStartName_:co}hasEnd(){return this.endSet_}getIndexEndValue(){return G(this.endSet_,"Only valid if end has been set"),this.indexEndValue_}getIndexEndName(){return G(this.endSet_,"Only valid if end has been set"),this.endNameSet_?this.indexEndName_:Ki}hasLimit(){return this.limitSet_}hasAnchoredLimit(){return this.limitSet_&&this.viewFrom_!==""}getLimit(){return G(this.limitSet_,"Only valid if limit has been set"),this.limit_}getIndex(){return this.index_}loadsAllData(){return!(this.startSet_||this.endSet_||this.limitSet_)}isDefault(){return this.loadsAllData()&&this.index_===Lt}copy(){const e=new bg;return e.limitSet_=this.limitSet_,e.limit_=this.limit_,e.startSet_=this.startSet_,e.startAfterSet_=this.startAfterSet_,e.indexStartValue_=this.indexStartValue_,e.startNameSet_=this.startNameSet_,e.indexStartName_=this.indexStartName_,e.endSet_=this.endSet_,e.endBeforeSet_=this.endBeforeSet_,e.indexEndValue_=this.indexEndValue_,e.endNameSet_=this.endNameSet_,e.indexEndName_=this.indexEndName_,e.index_=this.index_,e.viewFrom_=this.viewFrom_,e}}function V0(t){const e={};if(t.isDefault())return e;let n;if(t.index_===Lt?n="$priority":t.index_===RM?n="$value":t.index_===$s?n="$key":(G(t.index_ instanceof kM,"Unrecognized index type!"),n=t.index_.toString()),e.orderBy=Et(n),t.startSet_){const r=t.startAfterSet_?"startAfter":"startAt";e[r]=Et(t.indexStartValue_),t.startNameSet_&&(e[r]+=","+Et(t.indexStartName_))}if(t.endSet_){const r=t.endBeforeSet_?"endBefore":"endAt";e[r]=Et(t.indexEndValue_),t.endNameSet_&&(e[r]+=","+Et(t.indexEndName_))}return t.limitSet_&&(t.isViewFromLeft()?e.limitToFirst=t.limit_:e.limitToLast=t.limit_),e}function U0(t){const e={};if(t.startSet_&&(e.sp=t.indexStartValue_,t.startNameSet_&&(e.sn=t.indexStartName_),e.sin=!t.startAfterSet_),t.endSet_&&(e.ep=t.indexEndValue_,t.endNameSet_&&(e.en=t.indexEndName_),e.ein=!t.endBeforeSet_),t.limitSet_){e.l=t.limit_;let n=t.viewFrom_;n===""&&(t.isViewFromLeft()?n="l":n="r"),e.vf=n}return t.index_!==Lt&&(e.i=t.index_.toString()),e}/**
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
 */class Vc extends ak{constructor(e,n,r,i){super(),this.repoInfo_=e,this.onDataUpdate_=n,this.authTokenProvider_=r,this.appCheckTokenProvider_=i,this.log_=xl("p:rest:"),this.listens_={}}reportStats(e){throw new Error("Method not implemented.")}static getListenId_(e,n){return n!==void 0?"tag$"+n:(G(e._queryParams.isDefault(),"should have a tag if it's not a default query."),e._path.toString())}listen(e,n,r,i){const s=e._path.toString();this.log_("Listen called for "+s+" "+e._queryIdentifier);const o=Vc.getListenId_(e,r),a={};this.listens_[o]=a;const u=V0(e._queryParams);this.restRequest_(s+".json",u,(c,h)=>{let f=h;if(c===404&&(f=null,c=null),c===null&&this.onDataUpdate_(s,f,!1,r),no(this.listens_,o)===a){let m;c?c===401?m="permission_denied":m="rest_error:"+c:m="ok",i(m,null)}})}unlisten(e,n){const r=Vc.getListenId_(e,n);delete this.listens_[r]}get(e){const n=V0(e._queryParams),r=e._path.toString(),i=new ph;return this.restRequest_(r+".json",n,(s,o)=>{let a=o;s===404&&(a=null,s=null),s===null?(this.onDataUpdate_(r,a,!1,null),i.resolve(a)):i.reject(new Error(a))}),i.promise}refreshAuthToken(e){}restRequest_(e,n={},r){return n.format="export",Promise.all([this.authTokenProvider_.getToken(!1),this.appCheckTokenProvider_.getToken(!1)]).then(([i,s])=>{i&&i.accessToken&&(n.auth=i.accessToken),s&&s.token&&(n.ac=s.token);const o=(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host+e+"?ns="+this.repoInfo_.namespace+_o(n);this.log_("Sending REST request for "+o);const a=new XMLHttpRequest;a.onreadystatechange=()=>{if(r&&a.readyState===4){this.log_("REST Response for "+o+" received. status:",a.status,"response:",a.responseText);let u=null;if(a.status>=200&&a.status<300){try{u=Za(a.responseText)}catch{en("Failed to parse JSON response for "+o+": "+a.responseText)}r(null,u)}else a.status!==401&&a.status!==404&&en("Got unsuccessful REST response for "+o+" Status: "+a.status),r(a.status);r=null}},a.open("GET",o,!0),a.send()})}}/**
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
 */class NM{constructor(){this.rootNode_=Te.EMPTY_NODE}getNode(e){return this.rootNode_.getChild(e)}updateSnapshot(e,n){this.rootNode_=this.rootNode_.updateChild(e,n)}}/**
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
 */function Uc(){return{value:null,children:new Map}}function vk(t,e,n){if(me(e))t.value=n,t.children.clear();else if(t.value!==null)t.value=t.value.updateChild(e,n);else{const r=fe(e);t.children.has(r)||t.children.set(r,Uc());const i=t.children.get(r);e=Fe(e),vk(i,e,n)}}function Tp(t,e,n){t.value!==null?n(e,t.value):DM(t,(r,i)=>{const s=new ze(e.toString()+"/"+r);Tp(i,s,n)})}function DM(t,e){t.children.forEach((n,r)=>{e(r,n)})}/**
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
 */class OM{constructor(e){this.collection_=e,this.last_=null}get(){const e=this.collection_.get(),n=Object.assign({},e);return this.last_&&Sn(this.last_,(r,i)=>{n[r]=n[r]-i}),this.last_=e,n}}/**
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
 */const j0=10*1e3,MM=30*1e3,LM=5*60*1e3;class FM{constructor(e,n){this.server_=n,this.statsToReport_={},this.statsListener_=new OM(e);const r=j0+(MM-j0)*Math.random();Aa(this.reportStats_.bind(this),Math.floor(r))}reportStats_(){const e=this.statsListener_.get(),n={};let r=!1;Sn(e,(i,s)=>{s>0&&xr(this.statsToReport_,i)&&(n[i]=s,r=!0)}),r&&this.server_.reportStats(n),Aa(this.reportStats_.bind(this),Math.floor(Math.random()*2*LM))}}/**
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
 */var Wn;(function(t){t[t.OVERWRITE=0]="OVERWRITE",t[t.MERGE=1]="MERGE",t[t.ACK_USER_WRITE=2]="ACK_USER_WRITE",t[t.LISTEN_COMPLETE=3]="LISTEN_COMPLETE"})(Wn||(Wn={}));function wk(){return{fromUser:!0,fromServer:!1,queryId:null,tagged:!1}}function Ek(){return{fromUser:!1,fromServer:!0,queryId:null,tagged:!1}}function Tk(t){return{fromUser:!1,fromServer:!0,queryId:t,tagged:!0}}/**
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
 */class jc{constructor(e,n,r){this.path=e,this.affectedTree=n,this.revert=r,this.type=Wn.ACK_USER_WRITE,this.source=wk()}operationForChild(e){if(me(this.path)){if(this.affectedTree.value!=null)return G(this.affectedTree.children.isEmpty(),"affectedTree should not have overlapping affected paths."),this;{const n=this.affectedTree.subtree(new ze(e));return new jc(Re(),n,this.revert)}}else return G(fe(this.path)===e,"operationForChild called for unrelated child."),new jc(Fe(this.path),this.affectedTree,this.revert)}}/**
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
 */class Qi{constructor(e,n,r){this.source=e,this.path=n,this.snap=r,this.type=Wn.OVERWRITE}operationForChild(e){return me(this.path)?new Qi(this.source,Re(),this.snap.getImmediateChild(e)):new Qi(this.source,Fe(this.path),this.snap)}}/**
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
 */class hl{constructor(e,n,r){this.source=e,this.path=n,this.children=r,this.type=Wn.MERGE}operationForChild(e){if(me(this.path)){const n=this.children.subtree(new ze(e));return n.isEmpty()?null:n.value?new Qi(this.source,Re(),n.value):new hl(this.source,Re(),n)}else return G(fe(this.path)===e,"Can't get a merge for a child not on the path of the operation"),new hl(this.source,Fe(this.path),this.children)}toString(){return"Operation("+this.path+": "+this.source.toString()+" merge: "+this.children.toString()+")"}}/**
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
 */class Ng{constructor(e,n,r){this.node_=e,this.fullyInitialized_=n,this.filtered_=r}isFullyInitialized(){return this.fullyInitialized_}isFiltered(){return this.filtered_}isCompleteForPath(e){if(me(e))return this.isFullyInitialized()&&!this.filtered_;const n=fe(e);return this.isCompleteForChild(n)}isCompleteForChild(e){return this.isFullyInitialized()&&!this.filtered_||this.node_.hasChild(e)}getNode(){return this.node_}}function VM(t,e,n,r){const i=[],s=[];return e.forEach(o=>{o.type==="child_changed"&&t.index_.indexedValueChanged(o.oldSnap,o.snapshotNode)&&s.push(bM(o.childName,o.snapshotNode))}),ra(t,i,"child_removed",e,r,n),ra(t,i,"child_added",e,r,n),ra(t,i,"child_moved",s,r,n),ra(t,i,"child_changed",e,r,n),ra(t,i,"value",e,r,n),i}function ra(t,e,n,r,i,s){const o=r.filter(a=>a.type===n);o.sort((a,u)=>jM(t,a,u)),o.forEach(a=>{const u=UM(t,a,s);i.forEach(c=>{c.respondsTo(a.type)&&e.push(c.createEvent(u,t.query_))})})}function UM(t,e,n){return e.type==="value"||e.type==="child_removed"||(e.prevName=n.getPredecessorChildName(e.childName,e.snapshotNode,t.index_)),e}function jM(t,e,n){if(e.childName==null||n.childName==null)throw go("Should only compare child_ events.");const r=new _e(e.childName,e.snapshotNode),i=new _e(n.childName,n.snapshotNode);return t.index_.compare(r,i)}/**
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
 */function Ik(t,e){return{eventCache:t,serverCache:e}}function Pa(t,e,n,r){return Ik(new Ng(e,n,r),t.serverCache)}function Sk(t,e,n,r){return Ik(t.eventCache,new Ng(e,n,r))}function Ip(t){return t.eventCache.isFullyInitialized()?t.eventCache.getNode():null}function Yi(t){return t.serverCache.isFullyInitialized()?t.serverCache.getNode():null}/**
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
 */let Kd;const zM=()=>(Kd||(Kd=new Yt(RO)),Kd);class Le{constructor(e,n=zM()){this.value=e,this.children=n}static fromObject(e){let n=new Le(null);return Sn(e,(r,i)=>{n=n.set(new ze(r),i)}),n}isEmpty(){return this.value===null&&this.children.isEmpty()}findRootMostMatchingPathAndValue(e,n){if(this.value!=null&&n(this.value))return{path:Re(),value:this.value};if(me(e))return null;{const r=fe(e),i=this.children.get(r);if(i!==null){const s=i.findRootMostMatchingPathAndValue(Fe(e),n);return s!=null?{path:at(new ze(r),s.path),value:s.value}:null}else return null}}findRootMostValueAndPath(e){return this.findRootMostMatchingPathAndValue(e,()=>!0)}subtree(e){if(me(e))return this;{const n=fe(e),r=this.children.get(n);return r!==null?r.subtree(Fe(e)):new Le(null)}}set(e,n){if(me(e))return new Le(n,this.children);{const r=fe(e),s=(this.children.get(r)||new Le(null)).set(Fe(e),n),o=this.children.insert(r,s);return new Le(this.value,o)}}remove(e){if(me(e))return this.children.isEmpty()?new Le(null):new Le(null,this.children);{const n=fe(e),r=this.children.get(n);if(r){const i=r.remove(Fe(e));let s;return i.isEmpty()?s=this.children.remove(n):s=this.children.insert(n,i),this.value===null&&s.isEmpty()?new Le(null):new Le(this.value,s)}else return this}}get(e){if(me(e))return this.value;{const n=fe(e),r=this.children.get(n);return r?r.get(Fe(e)):null}}setTree(e,n){if(me(e))return n;{const r=fe(e),s=(this.children.get(r)||new Le(null)).setTree(Fe(e),n);let o;return s.isEmpty()?o=this.children.remove(r):o=this.children.insert(r,s),new Le(this.value,o)}}fold(e){return this.fold_(Re(),e)}fold_(e,n){const r={};return this.children.inorderTraversal((i,s)=>{r[i]=s.fold_(at(e,i),n)}),n(e,this.value,r)}findOnPath(e,n){return this.findOnPath_(e,Re(),n)}findOnPath_(e,n,r){const i=this.value?r(n,this.value):!1;if(i)return i;if(me(e))return null;{const s=fe(e),o=this.children.get(s);return o?o.findOnPath_(Fe(e),at(n,s),r):null}}foreachOnPath(e,n){return this.foreachOnPath_(e,Re(),n)}foreachOnPath_(e,n,r){if(me(e))return this;{this.value&&r(n,this.value);const i=fe(e),s=this.children.get(i);return s?s.foreachOnPath_(Fe(e),at(n,i),r):new Le(null)}}foreach(e){this.foreach_(Re(),e)}foreach_(e,n){this.children.inorderTraversal((r,i)=>{i.foreach_(at(e,r),n)}),this.value&&n(e,this.value)}foreachChild(e){this.children.inorderTraversal((n,r)=>{r.value&&e(n,r.value)})}}/**
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
 */class Ln{constructor(e){this.writeTree_=e}static empty(){return new Ln(new Le(null))}}function ba(t,e,n){if(me(e))return new Ln(new Le(n));{const r=t.writeTree_.findRootMostValueAndPath(e);if(r!=null){const i=r.path;let s=r.value;const o=gn(i,e);return s=s.updateChild(o,n),new Ln(t.writeTree_.set(i,s))}else{const i=new Le(n),s=t.writeTree_.setTree(e,i);return new Ln(s)}}}function z0(t,e,n){let r=t;return Sn(n,(i,s)=>{r=ba(r,at(e,i),s)}),r}function B0(t,e){if(me(e))return Ln.empty();{const n=t.writeTree_.setTree(e,new Le(null));return new Ln(n)}}function Sp(t,e){return ss(t,e)!=null}function ss(t,e){const n=t.writeTree_.findRootMostValueAndPath(e);return n!=null?t.writeTree_.get(n.path).getChild(gn(n.path,e)):null}function $0(t){const e=[],n=t.writeTree_.value;return n!=null?n.isLeafNode()||n.forEachChild(Lt,(r,i)=>{e.push(new _e(r,i))}):t.writeTree_.children.inorderTraversal((r,i)=>{i.value!=null&&e.push(new _e(r,i.value))}),e}function si(t,e){if(me(e))return t;{const n=ss(t,e);return n!=null?new Ln(new Le(n)):new Ln(t.writeTree_.subtree(e))}}function kp(t){return t.writeTree_.isEmpty()}function ho(t,e){return kk(Re(),t.writeTree_,e)}function kk(t,e,n){if(e.value!=null)return n.updateChild(t,e.value);{let r=null;return e.children.inorderTraversal((i,s)=>{i===".priority"?(G(s.value!==null,"Priority writes must always be leaf nodes"),r=s.value):n=kk(at(t,i),s,n)}),!n.getChild(t).isEmpty()&&r!==null&&(n=n.updateChild(at(t,".priority"),r)),n}}/**
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
 */function Ck(t,e){return bk(e,t)}function BM(t,e,n,r,i){G(r>t.lastWriteId,"Stacking an older write on top of newer ones"),i===void 0&&(i=!0),t.allWrites.push({path:e,snap:n,writeId:r,visible:i}),i&&(t.visibleWrites=ba(t.visibleWrites,e,n)),t.lastWriteId=r}function $M(t,e){for(let n=0;n<t.allWrites.length;n++){const r=t.allWrites[n];if(r.writeId===e)return r}return null}function WM(t,e){const n=t.allWrites.findIndex(a=>a.writeId===e);G(n>=0,"removeWrite called with nonexistent writeId.");const r=t.allWrites[n];t.allWrites.splice(n,1);let i=r.visible,s=!1,o=t.allWrites.length-1;for(;i&&o>=0;){const a=t.allWrites[o];a.visible&&(o>=n&&qM(a,r.path)?i=!1:Dn(r.path,a.path)&&(s=!0)),o--}if(i){if(s)return HM(t),!0;if(r.snap)t.visibleWrites=B0(t.visibleWrites,r.path);else{const a=r.children;Sn(a,u=>{t.visibleWrites=B0(t.visibleWrites,at(r.path,u))})}return!0}else return!1}function qM(t,e){if(t.snap)return Dn(t.path,e);for(const n in t.children)if(t.children.hasOwnProperty(n)&&Dn(at(t.path,n),e))return!0;return!1}function HM(t){t.visibleWrites=Rk(t.allWrites,GM,Re()),t.allWrites.length>0?t.lastWriteId=t.allWrites[t.allWrites.length-1].writeId:t.lastWriteId=-1}function GM(t){return t.visible}function Rk(t,e,n){let r=Ln.empty();for(let i=0;i<t.length;++i){const s=t[i];if(e(s)){const o=s.path;let a;if(s.snap)Dn(n,o)?(a=gn(n,o),r=ba(r,a,s.snap)):Dn(o,n)&&(a=gn(o,n),r=ba(r,Re(),s.snap.getChild(a)));else if(s.children){if(Dn(n,o))a=gn(n,o),r=z0(r,a,s.children);else if(Dn(o,n))if(a=gn(o,n),me(a))r=z0(r,Re(),s.children);else{const u=no(s.children,fe(a));if(u){const c=u.getChild(Fe(a));r=ba(r,Re(),c)}}}else throw go("WriteRecord should have .snap or .children")}}return r}function xk(t,e,n,r,i){if(!r&&!i){const s=ss(t.visibleWrites,e);if(s!=null)return s;{const o=si(t.visibleWrites,e);if(kp(o))return n;if(n==null&&!Sp(o,Re()))return null;{const a=n||Te.EMPTY_NODE;return ho(o,a)}}}else{const s=si(t.visibleWrites,e);if(!i&&kp(s))return n;if(!i&&n==null&&!Sp(s,Re()))return null;{const o=function(c){return(c.visible||i)&&(!r||!~r.indexOf(c.writeId))&&(Dn(c.path,e)||Dn(e,c.path))},a=Rk(t.allWrites,o,e),u=n||Te.EMPTY_NODE;return ho(a,u)}}}function KM(t,e,n){let r=Te.EMPTY_NODE;const i=ss(t.visibleWrites,e);if(i)return i.isLeafNode()||i.forEachChild(Lt,(s,o)=>{r=r.updateImmediateChild(s,o)}),r;if(n){const s=si(t.visibleWrites,e);return n.forEachChild(Lt,(o,a)=>{const u=ho(si(s,new ze(o)),a);r=r.updateImmediateChild(o,u)}),$0(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}else{const s=si(t.visibleWrites,e);return $0(s).forEach(o=>{r=r.updateImmediateChild(o.name,o.node)}),r}}function QM(t,e,n,r,i){G(r||i,"Either existingEventSnap or existingServerSnap must exist");const s=at(e,n);if(Sp(t.visibleWrites,s))return null;{const o=si(t.visibleWrites,s);return kp(o)?i.getChild(n):ho(o,i.getChild(n))}}function YM(t,e,n,r){const i=at(e,n),s=ss(t.visibleWrites,i);if(s!=null)return s;if(r.isCompleteForChild(n)){const o=si(t.visibleWrites,i);return ho(o,r.getNode().getImmediateChild(n))}else return null}function XM(t,e){return ss(t.visibleWrites,e)}function JM(t,e,n,r,i,s,o){let a;const u=si(t.visibleWrites,e),c=ss(u,Re());if(c!=null)a=c;else if(n!=null)a=ho(u,n);else return[];if(a=a.withIndex(o),!a.isEmpty()&&!a.isLeafNode()){const h=[],f=o.getCompare(),m=s?a.getReverseIteratorFrom(r,o):a.getIteratorFrom(r,o);let w=m.getNext();for(;w&&h.length<i;)f(w,r)!==0&&h.push(w),w=m.getNext();return h}else return[]}function ZM(){return{visibleWrites:Ln.empty(),allWrites:[],lastWriteId:-1}}function Cp(t,e,n,r){return xk(t.writeTree,t.treePath,e,n,r)}function Ak(t,e){return KM(t.writeTree,t.treePath,e)}function W0(t,e,n,r){return QM(t.writeTree,t.treePath,e,n,r)}function zc(t,e){return XM(t.writeTree,at(t.treePath,e))}function eL(t,e,n,r,i,s){return JM(t.writeTree,t.treePath,e,n,r,i,s)}function Dg(t,e,n){return YM(t.writeTree,t.treePath,e,n)}function Pk(t,e){return bk(at(t.treePath,e),t.writeTree)}function bk(t,e){return{treePath:t,writeTree:e}}/**
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
 */class tL{constructor(){this.changeMap=new Map}trackChildChange(e){const n=e.type,r=e.childName;G(n==="child_added"||n==="child_changed"||n==="child_removed","Only child changes supported for tracking"),G(r!==".priority","Only non-priority child changes can be tracked.");const i=this.changeMap.get(r);if(i){const s=i.type;if(n==="child_added"&&s==="child_removed")this.changeMap.set(r,F0(r,e.snapshotNode,i.snapshotNode));else if(n==="child_removed"&&s==="child_added")this.changeMap.delete(r);else if(n==="child_removed"&&s==="child_changed")this.changeMap.set(r,PM(r,i.oldSnap));else if(n==="child_changed"&&s==="child_added")this.changeMap.set(r,AM(r,e.snapshotNode));else if(n==="child_changed"&&s==="child_changed")this.changeMap.set(r,F0(r,e.snapshotNode,i.oldSnap));else throw go("Illegal combination of changes: "+e+" occurred after "+i)}else this.changeMap.set(r,e)}getChanges(){return Array.from(this.changeMap.values())}}/**
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
 */class nL{getCompleteChild(e){return null}getChildAfterChild(e,n,r){return null}}const Nk=new nL;class Og{constructor(e,n,r=null){this.writes_=e,this.viewCache_=n,this.optCompleteServerCache_=r}getCompleteChild(e){const n=this.viewCache_.eventCache;if(n.isCompleteForChild(e))return n.getNode().getImmediateChild(e);{const r=this.optCompleteServerCache_!=null?new Ng(this.optCompleteServerCache_,!0,!1):this.viewCache_.serverCache;return Dg(this.writes_,e,r)}}getChildAfterChild(e,n,r){const i=this.optCompleteServerCache_!=null?this.optCompleteServerCache_:Yi(this.viewCache_),s=eL(this.writes_,i,n,1,r,e);return s.length===0?null:s[0]}}function rL(t,e){G(e.eventCache.getNode().isIndexed(t.filter.getIndex()),"Event snap not indexed"),G(e.serverCache.getNode().isIndexed(t.filter.getIndex()),"Server snap not indexed")}function iL(t,e,n,r,i){const s=new tL;let o,a;if(n.type===Wn.OVERWRITE){const c=n;c.source.fromUser?o=Rp(t,e,c.path,c.snap,r,i,s):(G(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered()&&!me(c.path),o=Bc(t,e,c.path,c.snap,r,i,a,s))}else if(n.type===Wn.MERGE){const c=n;c.source.fromUser?o=oL(t,e,c.path,c.children,r,i,s):(G(c.source.fromServer,"Unknown source."),a=c.source.tagged||e.serverCache.isFiltered(),o=xp(t,e,c.path,c.children,r,i,a,s))}else if(n.type===Wn.ACK_USER_WRITE){const c=n;c.revert?o=uL(t,e,c.path,r,i,s):o=aL(t,e,c.path,c.affectedTree,r,i,s)}else if(n.type===Wn.LISTEN_COMPLETE)o=lL(t,e,n.path,r,s);else throw go("Unknown operation type: "+n.type);const u=s.getChanges();return sL(e,o,u),{viewCache:o,changes:u}}function sL(t,e,n){const r=e.eventCache;if(r.isFullyInitialized()){const i=r.getNode().isLeafNode()||r.getNode().isEmpty(),s=Ip(t);(n.length>0||!t.eventCache.isFullyInitialized()||i&&!r.getNode().equals(s)||!r.getNode().getPriority().equals(s.getPriority()))&&n.push(xM(Ip(e)))}}function Dk(t,e,n,r,i,s){const o=e.eventCache;if(zc(r,n)!=null)return e;{let a,u;if(me(n))if(G(e.serverCache.isFullyInitialized(),"If change path is empty, we must have complete server data"),e.serverCache.isFiltered()){const c=Yi(e),h=c instanceof Te?c:Te.EMPTY_NODE,f=Ak(r,h);a=t.filter.updateFullNode(e.eventCache.getNode(),f,s)}else{const c=Cp(r,Yi(e));a=t.filter.updateFullNode(e.eventCache.getNode(),c,s)}else{const c=fe(n);if(c===".priority"){G(fi(n)===1,"Can't have a priority with additional path components");const h=o.getNode();u=e.serverCache.getNode();const f=W0(r,n,h,u);f!=null?a=t.filter.updatePriority(h,f):a=o.getNode()}else{const h=Fe(n);let f;if(o.isCompleteForChild(c)){u=e.serverCache.getNode();const m=W0(r,n,o.getNode(),u);m!=null?f=o.getNode().getImmediateChild(c).updateChild(h,m):f=o.getNode().getImmediateChild(c)}else f=Dg(r,c,e.serverCache);f!=null?a=t.filter.updateChild(o.getNode(),c,f,h,i,s):a=o.getNode()}}return Pa(e,a,o.isFullyInitialized()||me(n),t.filter.filtersNodes())}}function Bc(t,e,n,r,i,s,o,a){const u=e.serverCache;let c;const h=o?t.filter:t.filter.getIndexedFilter();if(me(n))c=h.updateFullNode(u.getNode(),r,null);else if(h.filtersNodes()&&!u.isFiltered()){const w=u.getNode().updateChild(n,r);c=h.updateFullNode(u.getNode(),w,null)}else{const w=fe(n);if(!u.isCompleteForPath(n)&&fi(n)>1)return e;const S=Fe(n),D=u.getNode().getImmediateChild(w).updateChild(S,r);w===".priority"?c=h.updatePriority(u.getNode(),D):c=h.updateChild(u.getNode(),w,D,S,Nk,null)}const f=Sk(e,c,u.isFullyInitialized()||me(n),h.filtersNodes()),m=new Og(i,f,s);return Dk(t,f,n,i,m,a)}function Rp(t,e,n,r,i,s,o){const a=e.eventCache;let u,c;const h=new Og(i,e,s);if(me(n))c=t.filter.updateFullNode(e.eventCache.getNode(),r,o),u=Pa(e,c,!0,t.filter.filtersNodes());else{const f=fe(n);if(f===".priority")c=t.filter.updatePriority(e.eventCache.getNode(),r),u=Pa(e,c,a.isFullyInitialized(),a.isFiltered());else{const m=Fe(n),w=a.getNode().getImmediateChild(f);let S;if(me(m))S=r;else{const P=h.getCompleteChild(f);P!=null?uk(m)===".priority"&&P.getChild(hk(m)).isEmpty()?S=P:S=P.updateChild(m,r):S=Te.EMPTY_NODE}if(w.equals(S))u=e;else{const P=t.filter.updateChild(a.getNode(),f,S,m,h,o);u=Pa(e,P,a.isFullyInitialized(),t.filter.filtersNodes())}}}return u}function q0(t,e){return t.eventCache.isCompleteForChild(e)}function oL(t,e,n,r,i,s,o){let a=e;return r.foreach((u,c)=>{const h=at(n,u);q0(e,fe(h))&&(a=Rp(t,a,h,c,i,s,o))}),r.foreach((u,c)=>{const h=at(n,u);q0(e,fe(h))||(a=Rp(t,a,h,c,i,s,o))}),a}function H0(t,e,n){return n.foreach((r,i)=>{e=e.updateChild(r,i)}),e}function xp(t,e,n,r,i,s,o,a){if(e.serverCache.getNode().isEmpty()&&!e.serverCache.isFullyInitialized())return e;let u=e,c;me(n)?c=r:c=new Le(null).setTree(n,r);const h=e.serverCache.getNode();return c.children.inorderTraversal((f,m)=>{if(h.hasChild(f)){const w=e.serverCache.getNode().getImmediateChild(f),S=H0(t,w,m);u=Bc(t,u,new ze(f),S,i,s,o,a)}}),c.children.inorderTraversal((f,m)=>{const w=!e.serverCache.isCompleteForChild(f)&&m.value===null;if(!h.hasChild(f)&&!w){const S=e.serverCache.getNode().getImmediateChild(f),P=H0(t,S,m);u=Bc(t,u,new ze(f),P,i,s,o,a)}}),u}function aL(t,e,n,r,i,s,o){if(zc(i,n)!=null)return e;const a=e.serverCache.isFiltered(),u=e.serverCache;if(r.value!=null){if(me(n)&&u.isFullyInitialized()||u.isCompleteForPath(n))return Bc(t,e,n,u.getNode().getChild(n),i,s,a,o);if(me(n)){let c=new Le(null);return u.getNode().forEachChild($s,(h,f)=>{c=c.set(new ze(h),f)}),xp(t,e,n,c,i,s,a,o)}else return e}else{let c=new Le(null);return r.foreach((h,f)=>{const m=at(n,h);u.isCompleteForPath(m)&&(c=c.set(h,u.getNode().getChild(m)))}),xp(t,e,n,c,i,s,a,o)}}function lL(t,e,n,r,i){const s=e.serverCache,o=Sk(e,s.getNode(),s.isFullyInitialized()||me(n),s.isFiltered());return Dk(t,o,n,r,Nk,i)}function uL(t,e,n,r,i,s){let o;if(zc(r,n)!=null)return e;{const a=new Og(r,e,i),u=e.eventCache.getNode();let c;if(me(n)||fe(n)===".priority"){let h;if(e.serverCache.isFullyInitialized())h=Cp(r,Yi(e));else{const f=e.serverCache.getNode();G(f instanceof Te,"serverChildren would be complete if leaf node"),h=Ak(r,f)}h=h,c=t.filter.updateFullNode(u,h,s)}else{const h=fe(n);let f=Dg(r,h,e.serverCache);f==null&&e.serverCache.isCompleteForChild(h)&&(f=u.getImmediateChild(h)),f!=null?c=t.filter.updateChild(u,h,f,Fe(n),a,s):e.eventCache.getNode().hasChild(h)?c=t.filter.updateChild(u,h,Te.EMPTY_NODE,Fe(n),a,s):c=u,c.isEmpty()&&e.serverCache.isFullyInitialized()&&(o=Cp(r,Yi(e)),o.isLeafNode()&&(c=t.filter.updateFullNode(c,o,s)))}return o=e.serverCache.isFullyInitialized()||zc(r,Re())!=null,Pa(e,c,o,t.filter.filtersNodes())}}function cL(t,e){const n=Yi(t.viewCache_);return n&&(t.query._queryParams.loadsAllData()||!me(e)&&!n.getImmediateChild(fe(e)).isEmpty())?n.getChild(e):null}function G0(t,e,n,r){e.type===Wn.MERGE&&e.source.queryId!==null&&(G(Yi(t.viewCache_),"We should always have a full cache before handling merges"),G(Ip(t.viewCache_),"Missing event cache, even though we have a server cache"));const i=t.viewCache_,s=iL(t.processor_,i,e,n,r);return rL(t.processor_,s.viewCache),G(s.viewCache.serverCache.isFullyInitialized()||!i.serverCache.isFullyInitialized(),"Once a server snap is complete, it should never go back"),t.viewCache_=s.viewCache,hL(t,s.changes,s.viewCache.eventCache.getNode())}function hL(t,e,n,r){const i=t.eventRegistrations_;return VM(t.eventGenerator_,e,n,i)}/**
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
 */let K0;function dL(t){G(!K0,"__referenceConstructor has already been defined"),K0=t}function Mg(t,e,n,r){const i=e.source.queryId;if(i!==null){const s=t.views.get(i);return G(s!=null,"SyncTree gave us an op for an invalid query."),G0(s,e,n,r)}else{let s=[];for(const o of t.views.values())s=s.concat(G0(o,e,n,r));return s}}function Lg(t,e){let n=null;for(const r of t.views.values())n=n||cL(r,e);return n}/**
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
 */let Q0;function fL(t){G(!Q0,"__referenceConstructor has already been defined"),Q0=t}class Y0{constructor(e){this.listenProvider_=e,this.syncPointTree_=new Le(null),this.pendingWriteTree_=ZM(),this.tagToQueryMap=new Map,this.queryToTagMap=new Map}}function Ok(t,e,n,r,i){return BM(t.pendingWriteTree_,e,n,r,i),i?Dh(t,new Qi(wk(),e,n)):[]}function Oi(t,e,n=!1){const r=$M(t.pendingWriteTree_,e);if(WM(t.pendingWriteTree_,e)){let s=new Le(null);return r.snap!=null?s=s.set(Re(),!0):Sn(r.children,o=>{s=s.set(new ze(o),!0)}),Dh(t,new jc(r.path,s,n))}else return[]}function Nh(t,e,n){return Dh(t,new Qi(Ek(),e,n))}function pL(t,e,n){const r=Le.fromObject(n);return Dh(t,new hl(Ek(),e,r))}function mL(t,e,n,r){const i=Fk(t,r);if(i!=null){const s=Vk(i),o=s.path,a=s.queryId,u=gn(o,e),c=new Qi(Tk(a),u,n);return Uk(t,o,c)}else return[]}function gL(t,e,n,r){const i=Fk(t,r);if(i){const s=Vk(i),o=s.path,a=s.queryId,u=gn(o,e),c=Le.fromObject(n),h=new hl(Tk(a),u,c);return Uk(t,o,h)}else return[]}function Fg(t,e,n){const i=t.pendingWriteTree_,s=t.syncPointTree_.findOnPath(e,(o,a)=>{const u=gn(o,e),c=Lg(a,u);if(c)return c});return xk(i,e,s,n,!0)}function Dh(t,e){return Mk(e,t.syncPointTree_,null,Ck(t.pendingWriteTree_,Re()))}function Mk(t,e,n,r){if(me(t.path))return Lk(t,e,n,r);{const i=e.get(Re());n==null&&i!=null&&(n=Lg(i,Re()));let s=[];const o=fe(t.path),a=t.operationForChild(o),u=e.children.get(o);if(u&&a){const c=n?n.getImmediateChild(o):null,h=Pk(r,o);s=s.concat(Mk(a,u,c,h))}return i&&(s=s.concat(Mg(i,t,r,n))),s}}function Lk(t,e,n,r){const i=e.get(Re());n==null&&i!=null&&(n=Lg(i,Re()));let s=[];return e.children.inorderTraversal((o,a)=>{const u=n?n.getImmediateChild(o):null,c=Pk(r,o),h=t.operationForChild(o);h&&(s=s.concat(Lk(h,a,u,c)))}),i&&(s=s.concat(Mg(i,t,r,n))),s}function Fk(t,e){return t.tagToQueryMap.get(e)}function Vk(t){const e=t.indexOf("$");return G(e!==-1&&e<t.length-1,"Bad queryKey."),{queryId:t.substr(e+1),path:new ze(t.substr(0,e))}}function Uk(t,e,n){const r=t.syncPointTree_.get(e);G(r,"Missing sync point for query tag that we're tracking");const i=Ck(t.pendingWriteTree_,e);return Mg(r,n,i,null)}/**
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
 */class Vg{constructor(e){this.node_=e}getImmediateChild(e){const n=this.node_.getImmediateChild(e);return new Vg(n)}node(){return this.node_}}class Ug{constructor(e,n){this.syncTree_=e,this.path_=n}getImmediateChild(e){const n=at(this.path_,e);return new Ug(this.syncTree_,n)}node(){return Fg(this.syncTree_,this.path_)}}const _L=function(t){return t=t||{},t.timestamp=t.timestamp||new Date().getTime(),t},X0=function(t,e,n){if(!t||typeof t!="object")return t;if(G(".sv"in t,"Unexpected leaf node or priority contents"),typeof t[".sv"]=="string")return yL(t[".sv"],e,n);if(typeof t[".sv"]=="object")return vL(t[".sv"],e);G(!1,"Unexpected server value: "+JSON.stringify(t,null,2))},yL=function(t,e,n){switch(t){case"timestamp":return n.timestamp;default:G(!1,"Unexpected server value: "+t)}},vL=function(t,e,n){t.hasOwnProperty("increment")||G(!1,"Unexpected server value: "+JSON.stringify(t,null,2));const r=t.increment;typeof r!="number"&&G(!1,"Unexpected increment value: "+r);const i=e.node();if(G(i!==null&&typeof i<"u","Expected ChildrenNode.EMPTY_NODE for nulls"),!i.isLeafNode())return r;const o=i.getValue();return typeof o!="number"?r:o+r},wL=function(t,e,n,r){return jg(e,new Ug(n,t),r)},jk=function(t,e,n){return jg(t,new Vg(e),n)};function jg(t,e,n){const r=t.getPriority().val(),i=X0(r,e.getImmediateChild(".priority"),n);let s;if(t.isLeafNode()){const o=t,a=X0(o.getValue(),e,n);return a!==o.getValue()||i!==o.getPriority().val()?new ht(a,wt(i)):t}else{const o=t;return s=o,i!==o.getPriority().val()&&(s=s.updatePriority(new ht(i))),o.forEachChild(Lt,(a,u)=>{const c=jg(u,e.getImmediateChild(a),n);c!==u&&(s=s.updateImmediateChild(a,c))}),s}}/**
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
 */class zg{constructor(e="",n=null,r={children:{},childCount:0}){this.name=e,this.parent=n,this.node=r}}function Bg(t,e){let n=e instanceof ze?e:new ze(e),r=t,i=fe(n);for(;i!==null;){const s=no(r.node.children,i)||{children:{},childCount:0};r=new zg(i,r,s),n=Fe(n),i=fe(n)}return r}function Co(t){return t.node.value}function zk(t,e){t.node.value=e,Ap(t)}function Bk(t){return t.node.childCount>0}function EL(t){return Co(t)===void 0&&!Bk(t)}function Oh(t,e){Sn(t.node.children,(n,r)=>{e(new zg(n,t,r))})}function $k(t,e,n,r){n&&e(t),Oh(t,i=>{$k(i,e,!0)})}function TL(t,e,n){let r=t.parent;for(;r!==null;){if(e(r))return!0;r=r.parent}return!1}function Pl(t){return new ze(t.parent===null?t.name:Pl(t.parent)+"/"+t.name)}function Ap(t){t.parent!==null&&IL(t.parent,t.name,t)}function IL(t,e,n){const r=EL(n),i=xr(t.node.children,e);r&&i?(delete t.node.children[e],t.node.childCount--,Ap(t)):!r&&!i&&(t.node.children[e]=n.node,t.node.childCount++,Ap(t))}/**
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
 */const SL=/[\[\].#$\/\u0000-\u001F\u007F]/,kL=/[\[\].#$\u0000-\u001F\u007F]/,Qd=10*1024*1024,Wk=function(t){return typeof t=="string"&&t.length!==0&&!SL.test(t)},qk=function(t){return typeof t=="string"&&t.length!==0&&!kL.test(t)},CL=function(t){return t&&(t=t.replace(/^\/*\.info(\/|$)/,"/")),qk(t)},RL=function(t,e,n,r){$g(Lm(t,"value"),e,n)},$g=function(t,e,n){const r=n instanceof ze?new lM(n,t):n;if(e===void 0)throw new Error(t+"contains undefined "+Ri(r));if(typeof e=="function")throw new Error(t+"contains a function "+Ri(r)+" with contents = "+e.toString());if(BS(e))throw new Error(t+"contains "+e.toString()+" "+Ri(r));if(typeof e=="string"&&e.length>Qd/3&&mh(e)>Qd)throw new Error(t+"contains a string greater than "+Qd+" utf8 bytes "+Ri(r)+" ('"+e.substring(0,50)+"...')");if(e&&typeof e=="object"){let i=!1,s=!1;if(Sn(e,(o,a)=>{if(o===".value")i=!0;else if(o!==".priority"&&o!==".sv"&&(s=!0,!Wk(o)))throw new Error(t+" contains an invalid key ("+o+") "+Ri(r)+`.  Keys must be non-empty strings and can't contain ".", "#", "$", "/", "[", or "]"`);uM(r,o),$g(t,a,r),cM(r)}),i&&s)throw new Error(t+' contains ".value" child '+Ri(r)+" in addition to actual children.")}},Hk=function(t,e,n,r){if(!qk(n))throw new Error(Lm(t,e)+'was an invalid path = "'+n+`". Paths must be non-empty strings and can't contain ".", "#", "$", "[", or "]"`)},xL=function(t,e,n,r){n&&(n=n.replace(/^\/*\.info(\/|$)/,"/")),Hk(t,e,n)},Gk=function(t,e){if(fe(e)===".info")throw new Error(t+" failed = Can't modify data under /.info/")},AL=function(t,e){const n=e.path.toString();if(typeof e.repoInfo.host!="string"||e.repoInfo.host.length===0||!Wk(e.repoInfo.namespace)&&e.repoInfo.host.split(":")[0]!=="localhost"||n.length!==0&&!CL(n))throw new Error(Lm(t,"url")+`must be a valid firebase URL and the path can't contain ".", "#", "$", "[", or "]".`)};/**
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
 */class PL{constructor(){this.eventLists_=[],this.recursionDepth_=0}}function Kk(t,e){let n=null;for(let r=0;r<e.length;r++){const i=e[r],s=i.getPath();n!==null&&!dk(s,n.path)&&(t.eventLists_.push(n),n=null),n===null&&(n={events:[],path:s}),n.events.push(i)}n&&t.eventLists_.push(n)}function Sr(t,e,n){Kk(t,n),bL(t,r=>Dn(r,e)||Dn(e,r))}function bL(t,e){t.recursionDepth_++;let n=!0;for(let r=0;r<t.eventLists_.length;r++){const i=t.eventLists_[r];if(i){const s=i.path;e(s)?(NL(t.eventLists_[r]),t.eventLists_[r]=null):n=!1}}n&&(t.eventLists_=[]),t.recursionDepth_--}function NL(t){for(let e=0;e<t.events.length;e++){const n=t.events[e];if(n!==null){t.events[e]=null;const r=n.getEventRunner();xa&&Mt("event: "+n.toString()),ko(r)}}}/**
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
 */const DL="repo_interrupt",OL=25;class ML{constructor(e,n,r,i){this.repoInfo_=e,this.forceRestClient_=n,this.authTokenProvider_=r,this.appCheckProvider_=i,this.dataUpdateCount=0,this.statsListener_=null,this.eventQueue_=new PL,this.nextWriteId_=1,this.interceptServerDataCallback_=null,this.onDisconnect_=Uc(),this.transactionQueueTree_=new zg,this.persistentConnection_=null,this.key=this.repoInfo_.toURLString()}toString(){return(this.repoInfo_.secure?"https://":"http://")+this.repoInfo_.host}}function LL(t,e,n){if(t.stats_=Rg(t.repoInfo_),t.forceRestClient_||DO())t.server_=new Vc(t.repoInfo_,(r,i,s,o)=>{J0(t,r,i,s,o)},t.authTokenProvider_,t.appCheckProvider_),setTimeout(()=>Z0(t,!0),0);else{if(typeof n<"u"&&n!==null){if(typeof n!="object")throw new Error("Only objects are supported for option databaseAuthVariableOverride");try{Et(n)}catch(r){throw new Error("Invalid authOverride provided: "+r)}}t.persistentConnection_=new pr(t.repoInfo_,e,(r,i,s,o)=>{J0(t,r,i,s,o)},r=>{Z0(t,r)},r=>{VL(t,r)},t.authTokenProvider_,t.appCheckProvider_,n),t.server_=t.persistentConnection_}t.authTokenProvider_.addTokenChangeListener(r=>{t.server_.refreshAuthToken(r)}),t.appCheckProvider_.addTokenChangeListener(r=>{t.server_.refreshAppCheckToken(r.token)}),t.statsReporter_=VO(t.repoInfo_,()=>new FM(t.stats_,t.server_)),t.infoData_=new NM,t.infoSyncTree_=new Y0({startListening:(r,i,s,o)=>{let a=[];const u=t.infoData_.getNode(r._path);return u.isEmpty()||(a=Nh(t.infoSyncTree_,r._path,u),setTimeout(()=>{o("ok")},0)),a},stopListening:()=>{}}),qg(t,"connected",!1),t.serverSyncTree_=new Y0({startListening:(r,i,s,o)=>(t.server_.listen(r,s,i,(a,u)=>{const c=o(a,u);Sr(t.eventQueue_,r._path,c)}),[]),stopListening:(r,i)=>{t.server_.unlisten(r,i)}})}function FL(t){const n=t.infoData_.getNode(new ze(".info/serverTimeOffset")).val()||0;return new Date().getTime()+n}function Wg(t){return _L({timestamp:FL(t)})}function J0(t,e,n,r,i){t.dataUpdateCount++;const s=new ze(e);n=t.interceptServerDataCallback_?t.interceptServerDataCallback_(e,n):n;let o=[];if(i)if(r){const u=Sc(n,c=>wt(c));o=gL(t.serverSyncTree_,s,u,i)}else{const u=wt(n);o=mL(t.serverSyncTree_,s,u,i)}else if(r){const u=Sc(n,c=>wt(c));o=pL(t.serverSyncTree_,s,u)}else{const u=wt(n);o=Nh(t.serverSyncTree_,s,u)}let a=s;o.length>0&&(a=Mh(t,s)),Sr(t.eventQueue_,a,o)}function Z0(t,e){qg(t,"connected",e),e===!1&&jL(t)}function VL(t,e){Sn(e,(n,r)=>{qg(t,n,r)})}function qg(t,e,n){const r=new ze("/.info/"+e),i=wt(n);t.infoData_.updateSnapshot(r,i);const s=Nh(t.infoSyncTree_,r,i);Sr(t.eventQueue_,r,s)}function Qk(t){return t.nextWriteId_++}function UL(t,e,n,r,i){Hg(t,"set",{path:e.toString(),value:n,priority:r});const s=Wg(t),o=wt(n,r),a=Fg(t.serverSyncTree_,e),u=jk(o,a,s),c=Qk(t),h=Ok(t.serverSyncTree_,e,u,c,!0);Kk(t.eventQueue_,h),t.server_.put(e.toString(),o.val(!0),(m,w)=>{const S=m==="ok";S||en("set at "+e+" failed: "+m);const P=Oi(t.serverSyncTree_,c,!S);Sr(t.eventQueue_,e,P),BL(t,i,m,w)});const f=e1(t,e);Mh(t,f),Sr(t.eventQueue_,f,[])}function jL(t){Hg(t,"onDisconnectEvents");const e=Wg(t),n=Uc();Tp(t.onDisconnect_,Re(),(i,s)=>{const o=wL(i,s,t.serverSyncTree_,e);vk(n,i,o)});let r=[];Tp(n,Re(),(i,s)=>{r=r.concat(Nh(t.serverSyncTree_,i,s));const o=e1(t,i);Mh(t,o)}),t.onDisconnect_=Uc(),Sr(t.eventQueue_,Re(),r)}function zL(t){t.persistentConnection_&&t.persistentConnection_.interrupt(DL)}function Hg(t,...e){let n="";t.persistentConnection_&&(n=t.persistentConnection_.id+":"),Mt(n,...e)}function BL(t,e,n,r){e&&ko(()=>{if(n==="ok")e(null);else{const i=(n||"error").toUpperCase();let s=i;r&&(s+=": "+r);const o=new Error(s);o.code=i,e(o)}})}function Yk(t,e,n){return Fg(t.serverSyncTree_,e,n)||Te.EMPTY_NODE}function Gg(t,e=t.transactionQueueTree_){if(e||Lh(t,e),Co(e)){const n=Jk(t,e);G(n.length>0,"Sending zero length transaction queue"),n.every(i=>i.status===0)&&$L(t,Pl(e),n)}else Bk(e)&&Oh(e,n=>{Gg(t,n)})}function $L(t,e,n){const r=n.map(c=>c.currentWriteId),i=Yk(t,e,r);let s=i;const o=i.hash();for(let c=0;c<n.length;c++){const h=n[c];G(h.status===0,"tryToSendTransactionQueue_: items in queue should all be run."),h.status=1,h.retryCount++;const f=gn(e,h.path);s=s.updateChild(f,h.currentOutputSnapshotRaw)}const a=s.val(!0),u=e;t.server_.put(u.toString(),a,c=>{Hg(t,"transaction put response",{path:u.toString(),status:c});let h=[];if(c==="ok"){const f=[];for(let m=0;m<n.length;m++)n[m].status=2,h=h.concat(Oi(t.serverSyncTree_,n[m].currentWriteId)),n[m].onComplete&&f.push(()=>n[m].onComplete(null,!0,n[m].currentOutputSnapshotResolved)),n[m].unwatcher();Lh(t,Bg(t.transactionQueueTree_,e)),Gg(t,t.transactionQueueTree_),Sr(t.eventQueue_,e,h);for(let m=0;m<f.length;m++)ko(f[m])}else{if(c==="datastale")for(let f=0;f<n.length;f++)n[f].status===3?n[f].status=4:n[f].status=0;else{en("transaction at "+u.toString()+" failed: "+c);for(let f=0;f<n.length;f++)n[f].status=4,n[f].abortReason=c}Mh(t,e)}},o)}function Mh(t,e){const n=Xk(t,e),r=Pl(n),i=Jk(t,n);return WL(t,i,r),r}function WL(t,e,n){if(e.length===0)return;const r=[];let i=[];const o=e.filter(a=>a.status===0).map(a=>a.currentWriteId);for(let a=0;a<e.length;a++){const u=e[a],c=gn(n,u.path);let h=!1,f;if(G(c!==null,"rerunTransactionsUnderNode_: relativePath should not be null."),u.status===4)h=!0,f=u.abortReason,i=i.concat(Oi(t.serverSyncTree_,u.currentWriteId,!0));else if(u.status===0)if(u.retryCount>=OL)h=!0,f="maxretry",i=i.concat(Oi(t.serverSyncTree_,u.currentWriteId,!0));else{const m=Yk(t,u.path,o);u.currentInputSnapshot=m;const w=e[a].update(m.val());if(w!==void 0){$g("transaction failed: Data returned ",w,u.path);let S=wt(w);typeof w=="object"&&w!=null&&xr(w,".priority")||(S=S.updatePriority(m.getPriority()));const D=u.currentWriteId,k=Wg(t),T=jk(S,m,k);u.currentOutputSnapshotRaw=S,u.currentOutputSnapshotResolved=T,u.currentWriteId=Qk(t),o.splice(o.indexOf(D),1),i=i.concat(Ok(t.serverSyncTree_,u.path,T,u.currentWriteId,u.applyLocally)),i=i.concat(Oi(t.serverSyncTree_,D,!0))}else h=!0,f="nodata",i=i.concat(Oi(t.serverSyncTree_,u.currentWriteId,!0))}Sr(t.eventQueue_,n,i),i=[],h&&(e[a].status=2,function(m){setTimeout(m,Math.floor(0))}(e[a].unwatcher),e[a].onComplete&&(f==="nodata"?r.push(()=>e[a].onComplete(null,!1,e[a].currentInputSnapshot)):r.push(()=>e[a].onComplete(new Error(f),!1,null))))}Lh(t,t.transactionQueueTree_);for(let a=0;a<r.length;a++)ko(r[a]);Gg(t,t.transactionQueueTree_)}function Xk(t,e){let n,r=t.transactionQueueTree_;for(n=fe(e);n!==null&&Co(r)===void 0;)r=Bg(r,n),e=Fe(e),n=fe(e);return r}function Jk(t,e){const n=[];return Zk(t,e,n),n.sort((r,i)=>r.order-i.order),n}function Zk(t,e,n){const r=Co(e);if(r)for(let i=0;i<r.length;i++)n.push(r[i]);Oh(e,i=>{Zk(t,i,n)})}function Lh(t,e){const n=Co(e);if(n){let r=0;for(let i=0;i<n.length;i++)n[i].status!==2&&(n[r]=n[i],r++);n.length=r,zk(e,n.length>0?n:void 0)}Oh(e,r=>{Lh(t,r)})}function e1(t,e){const n=Pl(Xk(t,e)),r=Bg(t.transactionQueueTree_,e);return TL(r,i=>{Yd(t,i)}),Yd(t,r),$k(r,i=>{Yd(t,i)}),n}function Yd(t,e){const n=Co(e);if(n){const r=[];let i=[],s=-1;for(let o=0;o<n.length;o++)n[o].status===3||(n[o].status===1?(G(s===o-1,"All SENT items should be at beginning of queue."),s=o,n[o].status=3,n[o].abortReason="set"):(G(n[o].status===0,"Unexpected transaction status in abort"),n[o].unwatcher(),i=i.concat(Oi(t.serverSyncTree_,n[o].currentWriteId,!0)),n[o].onComplete&&r.push(n[o].onComplete.bind(null,new Error("set"),!1,null))));s===-1?zk(e,void 0):n.length=s+1,Sr(t.eventQueue_,Pl(e),i);for(let o=0;o<r.length;o++)ko(r[o])}}/**
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
 */function qL(t){let e="";const n=t.split("/");for(let r=0;r<n.length;r++)if(n[r].length>0){let i=n[r];try{i=decodeURIComponent(i.replace(/\+/g," "))}catch{}e+="/"+i}return e}function HL(t){const e={};t.charAt(0)==="?"&&(t=t.substring(1));for(const n of t.split("&")){if(n.length===0)continue;const r=n.split("=");r.length===2?e[decodeURIComponent(r[0])]=decodeURIComponent(r[1]):en(`Invalid query segment '${n}' in query '${t}'`)}return e}const ew=function(t,e){const n=GL(t),r=n.namespace;n.domain==="firebase.com"&&Ir(n.host+" is no longer supported. Please use <YOUR FIREBASE>.firebaseio.com instead"),(!r||r==="undefined")&&n.domain!=="localhost"&&Ir("Cannot parse Firebase url. Please use https://<YOUR FIREBASE>.firebaseio.com"),n.secure||kO();const i=n.scheme==="ws"||n.scheme==="wss";return{repoInfo:new ek(n.host,n.secure,r,i,e,"",r!==n.subdomain),path:new ze(n.pathString)}},GL=function(t){let e="",n="",r="",i="",s="",o=!0,a="https",u=443;if(typeof t=="string"){let c=t.indexOf("//");c>=0&&(a=t.substring(0,c-1),t=t.substring(c+2));let h=t.indexOf("/");h===-1&&(h=t.length);let f=t.indexOf("?");f===-1&&(f=t.length),e=t.substring(0,Math.min(h,f)),h<f&&(i=qL(t.substring(h,f)));const m=HL(t.substring(Math.min(t.length,f)));c=e.indexOf(":"),c>=0?(o=a==="https"||a==="wss",u=parseInt(e.substring(c+1),10)):c=e.length;const w=e.slice(0,c);if(w.toLowerCase()==="localhost")n="localhost";else if(w.split(".").length<=2)n=w;else{const S=e.indexOf(".");r=e.substring(0,S).toLowerCase(),n=e.substring(S+1),s=r}"ns"in m&&(s=m.ns)}return{host:e,port:u,domain:n,subdomain:r,secure:o,scheme:a,pathString:i,namespace:s}};/**
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
 */class Kg{constructor(e,n,r,i){this._repo=e,this._path=n,this._queryParams=r,this._orderByCalled=i}get key(){return me(this._path)?null:uk(this._path)}get ref(){return new os(this._repo,this._path)}get _queryIdentifier(){const e=U0(this._queryParams),n=kg(e);return n==="{}"?"default":n}get _queryObject(){return U0(this._queryParams)}isEqual(e){if(e=Ye(e),!(e instanceof Kg))return!1;const n=this._repo===e._repo,r=dk(this._path,e._path),i=this._queryIdentifier===e._queryIdentifier;return n&&r&&i}toJSON(){return this.toString()}toString(){return this._repo.toString()+aM(this._path)}}class os extends Kg{constructor(e,n){super(e,n,new bg,!1)}get parent(){const e=hk(this._path);return e===null?null:new os(this._repo,e)}get root(){let e=this;for(;e.parent!==null;)e=e.parent;return e}}function Xd(t,e){return t=Ye(t),t._checkNotDeleted("ref"),e!==void 0?KL(t._root,e):t._root}function KL(t,e){return t=Ye(t),fe(t._path)===null?xL("child","path",e):Hk("child","path",e),new os(t._repo,at(t._path,e))}function QL(t){return Gk("remove",t._path),Pp(t,null)}function Pp(t,e){t=Ye(t),Gk("set",t._path),RL("set",e,t._path);const n=new ph;return UL(t._repo,t._path,e,null,n.wrapCallback(()=>{})),n.promise}dL(os);fL(os);/**
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
 */const YL="FIREBASE_DATABASE_EMULATOR_HOST",bp={};let XL=!1;function JL(t,e,n,r){t.repoInfo_=new ek(`${e}:${n}`,!1,t.repoInfo_.namespace,t.repoInfo_.webSocketOnly,t.repoInfo_.nodeAdmin,t.repoInfo_.persistenceKey,t.repoInfo_.includeNamespaceInQueryParams,!0),r&&(t.authTokenProvider_=r)}function ZL(t,e,n,r,i){let s=r||t.options.databaseURL;s===void 0&&(t.options.projectId||Ir("Can't determine Firebase Database URL. Be sure to include  a Project ID when calling firebase.initializeApp()."),Mt("Using default host for project ",t.options.projectId),s=`${t.options.projectId}-default-rtdb.firebaseio.com`);let o=ew(s,i),a=o.repoInfo,u;typeof process<"u"&&w0&&(u=w0[YL]),u?(s=`http://${u}?ns=${a.namespace}`,o=ew(s,i),a=o.repoInfo):o.repoInfo.secure;const c=new MO(t.name,t.options,e);AL("Invalid Firebase Database URL",o),me(o.path)||Ir("Database URL must point to the root of a Firebase Database (not including a child path).");const h=tF(a,t,c,new OO(t.name,n));return new nF(h,t)}function eF(t,e){const n=bp[e];(!n||n[t.key]!==t)&&Ir(`Database ${e}(${t.repoInfo_}) has already been deleted.`),zL(t),delete n[t.key]}function tF(t,e,n,r){let i=bp[e.name];i||(i={},bp[e.name]=i);let s=i[t.toURLString()];return s&&Ir("Database initialized multiple times. Please make sure the format of the database URL matches with each database() call."),s=new ML(t,XL,n,r),i[t.toURLString()]=s,s}class nF{constructor(e,n){this._repoInternal=e,this.app=n,this.type="database",this._instanceStarted=!1}get _repo(){return this._instanceStarted||(LL(this._repoInternal,this.app.options.appId,this.app.options.databaseAuthVariableOverride),this._instanceStarted=!0),this._repoInternal}get _root(){return this._rootInternal||(this._rootInternal=new os(this._repo,Re())),this._rootInternal}_delete(){return this._rootInternal!==null&&(eF(this._repo,this.app.name),this._repoInternal=null,this._rootInternal=null),Promise.resolve()}_checkNotDeleted(e){this._rootInternal===null&&Ir("Cannot call "+e+" on a deleted database.")}}function rF(t=_h(),e){const n=vl(t,"database").getImmediate({identifier:e});if(!n._instanceStarted){const r=Dm("database");r&&iF(n,...r)}return n}function iF(t,e,n,r={}){t=Ye(t),t._checkNotDeleted("useEmulator"),t._instanceStarted&&Ir("Cannot call useEmulator() after instance has already been initialized.");const i=t._repoInternal;let s;if(i.repoInfo_.nodeAdmin)r.mockUserToken&&Ir('mockUserToken is not supported by the Admin SDK. For client access with mock users, please use the "firebase" package instead of "firebase-admin".'),s=new Hu(Hu.OWNER);else if(r.mockUserToken){const o=typeof r.mockUserToken=="string"?r.mockUserToken:Om(r.mockUserToken,t.app.options.projectId);s=new Hu(o)}JL(i,e,n,s)}/**
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
 */function sF(t){vO(yi),ui(new vr("database",(e,{instanceIdentifier:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("auth-internal"),s=e.getProvider("app-check-internal");return ZL(r,i,s,n)},"PUBLIC").setMultipleInstances(!0)),wn(E0,T0,t),wn(E0,T0,"esm2017")}pr.prototype.simpleListen=function(t,e){this.sendRequest("q",{p:t},e)};pr.prototype.echo=function(t,e){this.sendRequest("echo",{d:t},e)};sF();function Qg(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(t!=null&&typeof Object.getOwnPropertySymbols=="function")for(var i=0,r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]]);return n}function t1(){return{"dependent-sdk-initialized-before-auth":"Another Firebase SDK was initialized and is trying to use Auth before Auth is initialized. Please be sure to call `initializeAuth` or `getAuth` before starting any other Firebase SDK."}}const oF=t1,n1=new yl("auth","Firebase",t1());/**
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
 */const $c=new gh("@firebase/auth");function aF(t,...e){$c.logLevel<=de.WARN&&$c.warn(`Auth (${yi}): ${t}`,...e)}function Gu(t,...e){$c.logLevel<=de.ERROR&&$c.error(`Auth (${yi}): ${t}`,...e)}/**
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
 */function kr(t,...e){throw Yg(t,...e)}function Yn(t,...e){return Yg(t,...e)}function r1(t,e,n){const r=Object.assign(Object.assign({},oF()),{[e]:n});return new yl("auth","Firebase",r).create(e,{appName:t.name})}function oi(t){return r1(t,"operation-not-supported-in-this-environment","Operations that alter the current user are not supported in conjunction with FirebaseServerApp")}function Yg(t,...e){if(typeof t!="string"){const n=e[0],r=[...e.slice(1)];return r[0]&&(r[0].appName=t.name),t._errorFactory.create(n,...r)}return n1.create(t,...e)}function se(t,e,...n){if(!t)throw Yg(e,...n)}function ur(t){const e="INTERNAL ASSERTION FAILED: "+t;throw Gu(e),new Error(e)}function Cr(t,e){t||ur(e)}/**
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
 */function Np(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.href)||""}function lF(){return tw()==="http:"||tw()==="https:"}function tw(){var t;return typeof self<"u"&&((t=self.location)===null||t===void 0?void 0:t.protocol)||null}/**
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
 */function uF(){return typeof navigator<"u"&&navigator&&"onLine"in navigator&&typeof navigator.onLine=="boolean"&&(lF()||yA()||"connection"in navigator)?navigator.onLine:!0}function cF(){if(typeof navigator>"u")return null;const t=navigator;return t.languages&&t.languages[0]||t.language||null}/**
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
 */class bl{constructor(e,n){this.shortDelay=e,this.longDelay=n,Cr(n>e,"Short delay should be less than long delay!"),this.isMobile=Mm()||GT()}get(){return uF()?this.isMobile?this.longDelay:this.shortDelay:Math.min(5e3,this.shortDelay)}}/**
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
 */function Xg(t,e){Cr(t.emulator,"Emulator should always be set here");const{url:n}=t.emulator;return e?`${n}${e.startsWith("/")?e.slice(1):e}`:n}/**
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
 */class i1{static initialize(e,n,r){this.fetchImpl=e,n&&(this.headersImpl=n),r&&(this.responseImpl=r)}static fetch(){if(this.fetchImpl)return this.fetchImpl;if(typeof self<"u"&&"fetch"in self)return self.fetch;if(typeof globalThis<"u"&&globalThis.fetch)return globalThis.fetch;if(typeof fetch<"u")return fetch;ur("Could not find fetch implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static headers(){if(this.headersImpl)return this.headersImpl;if(typeof self<"u"&&"Headers"in self)return self.Headers;if(typeof globalThis<"u"&&globalThis.Headers)return globalThis.Headers;if(typeof Headers<"u")return Headers;ur("Could not find Headers implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}static response(){if(this.responseImpl)return this.responseImpl;if(typeof self<"u"&&"Response"in self)return self.Response;if(typeof globalThis<"u"&&globalThis.Response)return globalThis.Response;if(typeof Response<"u")return Response;ur("Could not find Response implementation, make sure you call FetchProvider.initialize() with an appropriate polyfill")}}/**
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
 */const hF={CREDENTIAL_MISMATCH:"custom-token-mismatch",MISSING_CUSTOM_TOKEN:"internal-error",INVALID_IDENTIFIER:"invalid-email",MISSING_CONTINUE_URI:"internal-error",INVALID_PASSWORD:"wrong-password",MISSING_PASSWORD:"missing-password",INVALID_LOGIN_CREDENTIALS:"invalid-credential",EMAIL_EXISTS:"email-already-in-use",PASSWORD_LOGIN_DISABLED:"operation-not-allowed",INVALID_IDP_RESPONSE:"invalid-credential",INVALID_PENDING_TOKEN:"invalid-credential",FEDERATED_USER_ID_ALREADY_LINKED:"credential-already-in-use",MISSING_REQ_TYPE:"internal-error",EMAIL_NOT_FOUND:"user-not-found",RESET_PASSWORD_EXCEED_LIMIT:"too-many-requests",EXPIRED_OOB_CODE:"expired-action-code",INVALID_OOB_CODE:"invalid-action-code",MISSING_OOB_CODE:"internal-error",CREDENTIAL_TOO_OLD_LOGIN_AGAIN:"requires-recent-login",INVALID_ID_TOKEN:"invalid-user-token",TOKEN_EXPIRED:"user-token-expired",USER_NOT_FOUND:"user-token-expired",TOO_MANY_ATTEMPTS_TRY_LATER:"too-many-requests",PASSWORD_DOES_NOT_MEET_REQUIREMENTS:"password-does-not-meet-requirements",INVALID_CODE:"invalid-verification-code",INVALID_SESSION_INFO:"invalid-verification-id",INVALID_TEMPORARY_PROOF:"invalid-credential",MISSING_SESSION_INFO:"missing-verification-id",SESSION_EXPIRED:"code-expired",MISSING_ANDROID_PACKAGE_NAME:"missing-android-pkg-name",UNAUTHORIZED_DOMAIN:"unauthorized-continue-uri",INVALID_OAUTH_CLIENT_ID:"invalid-oauth-client-id",ADMIN_ONLY_OPERATION:"admin-restricted-operation",INVALID_MFA_PENDING_CREDENTIAL:"invalid-multi-factor-session",MFA_ENROLLMENT_NOT_FOUND:"multi-factor-info-not-found",MISSING_MFA_ENROLLMENT_ID:"missing-multi-factor-info",MISSING_MFA_PENDING_CREDENTIAL:"missing-multi-factor-session",SECOND_FACTOR_EXISTS:"second-factor-already-in-use",SECOND_FACTOR_LIMIT_EXCEEDED:"maximum-second-factor-count-exceeded",BLOCKING_FUNCTION_ERROR_RESPONSE:"internal-error",RECAPTCHA_NOT_ENABLED:"recaptcha-not-enabled",MISSING_RECAPTCHA_TOKEN:"missing-recaptcha-token",INVALID_RECAPTCHA_TOKEN:"invalid-recaptcha-token",INVALID_RECAPTCHA_ACTION:"invalid-recaptcha-action",MISSING_CLIENT_TYPE:"missing-client-type",MISSING_RECAPTCHA_VERSION:"missing-recaptcha-version",INVALID_RECAPTCHA_VERSION:"invalid-recaptcha-version",INVALID_REQ_TYPE:"invalid-req-type"};/**
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
 */const dF=new bl(3e4,6e4);function Fh(t,e){return t.tenantId&&!e.tenantId?Object.assign(Object.assign({},e),{tenantId:t.tenantId}):e}async function Ro(t,e,n,r,i={}){return s1(t,i,async()=>{let s={},o={};r&&(e==="GET"?o=r:s={body:JSON.stringify(r)});const a=_o(Object.assign({key:t.config.apiKey},o)).slice(1),u=await t._getAdditionalHeaders();u["Content-Type"]="application/json",t.languageCode&&(u["X-Firebase-Locale"]=t.languageCode);const c=Object.assign({method:e,headers:u},s);return _A()||(c.referrerPolicy="no-referrer"),i1.fetch()(a1(t,t.config.apiHost,n,a),c)})}async function s1(t,e,n){t._canInitEmulator=!1;const r=Object.assign(Object.assign({},hF),e);try{const i=new fF(t),s=await Promise.race([n(),i.promise]);i.clearNetworkTimeout();const o=await s.json();if("needConfirmation"in o)throw Cu(t,"account-exists-with-different-credential",o);if(s.ok&&!("errorMessage"in o))return o;{const a=s.ok?o.errorMessage:o.error.message,[u,c]=a.split(" : ");if(u==="FEDERATED_USER_ID_ALREADY_LINKED")throw Cu(t,"credential-already-in-use",o);if(u==="EMAIL_EXISTS")throw Cu(t,"email-already-in-use",o);if(u==="USER_DISABLED")throw Cu(t,"user-disabled",o);const h=r[u]||u.toLowerCase().replace(/[_\s]+/g,"-");if(c)throw r1(t,h,c);kr(t,h)}}catch(i){if(i instanceof Zn)throw i;kr(t,"network-request-failed",{message:String(i)})}}async function o1(t,e,n,r,i={}){const s=await Ro(t,e,n,r,i);return"mfaPendingCredential"in s&&kr(t,"multi-factor-auth-required",{_serverResponse:s}),s}function a1(t,e,n,r){const i=`${e}${n}?${r}`;return t.config.emulator?Xg(t.config,i):`${t.config.apiScheme}://${i}`}class fF{constructor(e){this.auth=e,this.timer=null,this.promise=new Promise((n,r)=>{this.timer=setTimeout(()=>r(Yn(this.auth,"network-request-failed")),dF.get())})}clearNetworkTimeout(){clearTimeout(this.timer)}}function Cu(t,e,n){const r={appName:t.name};n.email&&(r.email=n.email),n.phoneNumber&&(r.phoneNumber=n.phoneNumber);const i=Yn(t,e,r);return i.customData._tokenResponse=n,i}/**
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
 */async function pF(t,e){return Ro(t,"POST","/v1/accounts:delete",e)}async function l1(t,e){return Ro(t,"POST","/v1/accounts:lookup",e)}/**
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
 */function Na(t){if(t)try{const e=new Date(Number(t));if(!isNaN(e.getTime()))return e.toUTCString()}catch{}}async function mF(t,e=!1){const n=Ye(t),r=await n.getIdToken(e),i=Jg(r);se(i&&i.exp&&i.auth_time&&i.iat,n.auth,"internal-error");const s=typeof i.firebase=="object"?i.firebase:void 0,o=s==null?void 0:s.sign_in_provider;return{claims:i,token:r,authTime:Na(Jd(i.auth_time)),issuedAtTime:Na(Jd(i.iat)),expirationTime:Na(Jd(i.exp)),signInProvider:o||null,signInSecondFactor:(s==null?void 0:s.sign_in_second_factor)||null}}function Jd(t){return Number(t)*1e3}function Jg(t){const[e,n,r]=t.split(".");if(e===void 0||n===void 0||r===void 0)return Gu("JWT malformed, contained fewer than 3 sections"),null;try{const i=Ic(n);return i?JSON.parse(i):(Gu("Failed to decode base64 JWT payload"),null)}catch(i){return Gu("Caught error parsing JWT payload as JSON",i==null?void 0:i.toString()),null}}function nw(t){const e=Jg(t);return se(e,"internal-error"),se(typeof e.exp<"u","internal-error"),se(typeof e.iat<"u","internal-error"),Number(e.exp)-Number(e.iat)}/**
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
 */async function dl(t,e,n=!1){if(n)return e;try{return await e}catch(r){throw r instanceof Zn&&gF(r)&&t.auth.currentUser===t&&await t.auth.signOut(),r}}function gF({code:t}){return t==="auth/user-disabled"||t==="auth/user-token-expired"}/**
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
 */class _F{constructor(e){this.user=e,this.isRunning=!1,this.timerId=null,this.errorBackoff=3e4}_start(){this.isRunning||(this.isRunning=!0,this.schedule())}_stop(){this.isRunning&&(this.isRunning=!1,this.timerId!==null&&clearTimeout(this.timerId))}getInterval(e){var n;if(e){const r=this.errorBackoff;return this.errorBackoff=Math.min(this.errorBackoff*2,96e4),r}else{this.errorBackoff=3e4;const i=((n=this.user.stsTokenManager.expirationTime)!==null&&n!==void 0?n:0)-Date.now()-3e5;return Math.max(0,i)}}schedule(e=!1){if(!this.isRunning)return;const n=this.getInterval(e);this.timerId=setTimeout(async()=>{await this.iteration()},n)}async iteration(){try{await this.user.getIdToken(!0)}catch(e){(e==null?void 0:e.code)==="auth/network-request-failed"&&this.schedule(!0);return}this.schedule()}}/**
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
 */class Dp{constructor(e,n){this.createdAt=e,this.lastLoginAt=n,this._initializeTime()}_initializeTime(){this.lastSignInTime=Na(this.lastLoginAt),this.creationTime=Na(this.createdAt)}_copy(e){this.createdAt=e.createdAt,this.lastLoginAt=e.lastLoginAt,this._initializeTime()}toJSON(){return{createdAt:this.createdAt,lastLoginAt:this.lastLoginAt}}}/**
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
 */async function Wc(t){var e;const n=t.auth,r=await t.getIdToken(),i=await dl(t,l1(n,{idToken:r}));se(i==null?void 0:i.users.length,n,"internal-error");const s=i.users[0];t._notifyReloadListener(s);const o=!((e=s.providerUserInfo)===null||e===void 0)&&e.length?u1(s.providerUserInfo):[],a=vF(t.providerData,o),u=t.isAnonymous,c=!(t.email&&s.passwordHash)&&!(a!=null&&a.length),h=u?c:!1,f={uid:s.localId,displayName:s.displayName||null,photoURL:s.photoUrl||null,email:s.email||null,emailVerified:s.emailVerified||!1,phoneNumber:s.phoneNumber||null,tenantId:s.tenantId||null,providerData:a,metadata:new Dp(s.createdAt,s.lastLoginAt),isAnonymous:h};Object.assign(t,f)}async function yF(t){const e=Ye(t);await Wc(e),await e.auth._persistUserIfCurrent(e),e.auth._notifyListenersIfCurrent(e)}function vF(t,e){return[...t.filter(r=>!e.some(i=>i.providerId===r.providerId)),...e]}function u1(t){return t.map(e=>{var{providerId:n}=e,r=Qg(e,["providerId"]);return{providerId:n,uid:r.rawId||"",displayName:r.displayName||null,email:r.email||null,phoneNumber:r.phoneNumber||null,photoURL:r.photoUrl||null}})}/**
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
 */async function wF(t,e){const n=await s1(t,{},async()=>{const r=_o({grant_type:"refresh_token",refresh_token:e}).slice(1),{tokenApiHost:i,apiKey:s}=t.config,o=a1(t,i,"/v1/token",`key=${s}`),a=await t._getAdditionalHeaders();return a["Content-Type"]="application/x-www-form-urlencoded",i1.fetch()(o,{method:"POST",headers:a,body:r})});return{accessToken:n.access_token,expiresIn:n.expires_in,refreshToken:n.refresh_token}}async function EF(t,e){return Ro(t,"POST","/v2/accounts:revokeToken",Fh(t,e))}/**
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
 */class Ws{constructor(){this.refreshToken=null,this.accessToken=null,this.expirationTime=null}get isExpired(){return!this.expirationTime||Date.now()>this.expirationTime-3e4}updateFromServerResponse(e){se(e.idToken,"internal-error"),se(typeof e.idToken<"u","internal-error"),se(typeof e.refreshToken<"u","internal-error");const n="expiresIn"in e&&typeof e.expiresIn<"u"?Number(e.expiresIn):nw(e.idToken);this.updateTokensAndExpiration(e.idToken,e.refreshToken,n)}updateFromIdToken(e){se(e.length!==0,"internal-error");const n=nw(e);this.updateTokensAndExpiration(e,null,n)}async getToken(e,n=!1){return!n&&this.accessToken&&!this.isExpired?this.accessToken:(se(this.refreshToken,e,"user-token-expired"),this.refreshToken?(await this.refresh(e,this.refreshToken),this.accessToken):null)}clearRefreshToken(){this.refreshToken=null}async refresh(e,n){const{accessToken:r,refreshToken:i,expiresIn:s}=await wF(e,n);this.updateTokensAndExpiration(r,i,Number(s))}updateTokensAndExpiration(e,n,r){this.refreshToken=n||null,this.accessToken=e||null,this.expirationTime=Date.now()+r*1e3}static fromJSON(e,n){const{refreshToken:r,accessToken:i,expirationTime:s}=n,o=new Ws;return r&&(se(typeof r=="string","internal-error",{appName:e}),o.refreshToken=r),i&&(se(typeof i=="string","internal-error",{appName:e}),o.accessToken=i),s&&(se(typeof s=="number","internal-error",{appName:e}),o.expirationTime=s),o}toJSON(){return{refreshToken:this.refreshToken,accessToken:this.accessToken,expirationTime:this.expirationTime}}_assign(e){this.accessToken=e.accessToken,this.refreshToken=e.refreshToken,this.expirationTime=e.expirationTime}_clone(){return Object.assign(new Ws,this.toJSON())}_performRefresh(){return ur("not implemented")}}/**
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
 */function Dr(t,e){se(typeof t=="string"||typeof t>"u","internal-error",{appName:e})}class cr{constructor(e){var{uid:n,auth:r,stsTokenManager:i}=e,s=Qg(e,["uid","auth","stsTokenManager"]);this.providerId="firebase",this.proactiveRefresh=new _F(this),this.reloadUserInfo=null,this.reloadListener=null,this.uid=n,this.auth=r,this.stsTokenManager=i,this.accessToken=i.accessToken,this.displayName=s.displayName||null,this.email=s.email||null,this.emailVerified=s.emailVerified||!1,this.phoneNumber=s.phoneNumber||null,this.photoURL=s.photoURL||null,this.isAnonymous=s.isAnonymous||!1,this.tenantId=s.tenantId||null,this.providerData=s.providerData?[...s.providerData]:[],this.metadata=new Dp(s.createdAt||void 0,s.lastLoginAt||void 0)}async getIdToken(e){const n=await dl(this,this.stsTokenManager.getToken(this.auth,e));return se(n,this.auth,"internal-error"),this.accessToken!==n&&(this.accessToken=n,await this.auth._persistUserIfCurrent(this),this.auth._notifyListenersIfCurrent(this)),n}getIdTokenResult(e){return mF(this,e)}reload(){return yF(this)}_assign(e){this!==e&&(se(this.uid===e.uid,this.auth,"internal-error"),this.displayName=e.displayName,this.photoURL=e.photoURL,this.email=e.email,this.emailVerified=e.emailVerified,this.phoneNumber=e.phoneNumber,this.isAnonymous=e.isAnonymous,this.tenantId=e.tenantId,this.providerData=e.providerData.map(n=>Object.assign({},n)),this.metadata._copy(e.metadata),this.stsTokenManager._assign(e.stsTokenManager))}_clone(e){const n=new cr(Object.assign(Object.assign({},this),{auth:e,stsTokenManager:this.stsTokenManager._clone()}));return n.metadata._copy(this.metadata),n}_onReload(e){se(!this.reloadListener,this.auth,"internal-error"),this.reloadListener=e,this.reloadUserInfo&&(this._notifyReloadListener(this.reloadUserInfo),this.reloadUserInfo=null)}_notifyReloadListener(e){this.reloadListener?this.reloadListener(e):this.reloadUserInfo=e}_startProactiveRefresh(){this.proactiveRefresh._start()}_stopProactiveRefresh(){this.proactiveRefresh._stop()}async _updateTokensIfNecessary(e,n=!1){let r=!1;e.idToken&&e.idToken!==this.stsTokenManager.accessToken&&(this.stsTokenManager.updateFromServerResponse(e),r=!0),n&&await Wc(this),await this.auth._persistUserIfCurrent(this),r&&this.auth._notifyListenersIfCurrent(this)}async delete(){if(ar(this.auth.app))return Promise.reject(oi(this.auth));const e=await this.getIdToken();return await dl(this,pF(this.auth,{idToken:e})),this.stsTokenManager.clearRefreshToken(),this.auth.signOut()}toJSON(){return Object.assign(Object.assign({uid:this.uid,email:this.email||void 0,emailVerified:this.emailVerified,displayName:this.displayName||void 0,isAnonymous:this.isAnonymous,photoURL:this.photoURL||void 0,phoneNumber:this.phoneNumber||void 0,tenantId:this.tenantId||void 0,providerData:this.providerData.map(e=>Object.assign({},e)),stsTokenManager:this.stsTokenManager.toJSON(),_redirectEventId:this._redirectEventId},this.metadata.toJSON()),{apiKey:this.auth.config.apiKey,appName:this.auth.name})}get refreshToken(){return this.stsTokenManager.refreshToken||""}static _fromJSON(e,n){var r,i,s,o,a,u,c,h;const f=(r=n.displayName)!==null&&r!==void 0?r:void 0,m=(i=n.email)!==null&&i!==void 0?i:void 0,w=(s=n.phoneNumber)!==null&&s!==void 0?s:void 0,S=(o=n.photoURL)!==null&&o!==void 0?o:void 0,P=(a=n.tenantId)!==null&&a!==void 0?a:void 0,D=(u=n._redirectEventId)!==null&&u!==void 0?u:void 0,k=(c=n.createdAt)!==null&&c!==void 0?c:void 0,T=(h=n.lastLoginAt)!==null&&h!==void 0?h:void 0,{uid:R,emailVerified:M,isAnonymous:z,providerData:U,stsTokenManager:v}=n;se(R&&v,e,"internal-error");const _=Ws.fromJSON(this.name,v);se(typeof R=="string",e,"internal-error"),Dr(f,e.name),Dr(m,e.name),se(typeof M=="boolean",e,"internal-error"),se(typeof z=="boolean",e,"internal-error"),Dr(w,e.name),Dr(S,e.name),Dr(P,e.name),Dr(D,e.name),Dr(k,e.name),Dr(T,e.name);const E=new cr({uid:R,auth:e,email:m,emailVerified:M,displayName:f,isAnonymous:z,photoURL:S,phoneNumber:w,tenantId:P,stsTokenManager:_,createdAt:k,lastLoginAt:T});return U&&Array.isArray(U)&&(E.providerData=U.map(I=>Object.assign({},I))),D&&(E._redirectEventId=D),E}static async _fromIdTokenResponse(e,n,r=!1){const i=new Ws;i.updateFromServerResponse(n);const s=new cr({uid:n.localId,auth:e,stsTokenManager:i,isAnonymous:r});return await Wc(s),s}static async _fromGetAccountInfoResponse(e,n,r){const i=n.users[0];se(i.localId!==void 0,"internal-error");const s=i.providerUserInfo!==void 0?u1(i.providerUserInfo):[],o=!(i.email&&i.passwordHash)&&!(s!=null&&s.length),a=new Ws;a.updateFromIdToken(r);const u=new cr({uid:i.localId,auth:e,stsTokenManager:a,isAnonymous:o}),c={uid:i.localId,displayName:i.displayName||null,photoURL:i.photoUrl||null,email:i.email||null,emailVerified:i.emailVerified||!1,phoneNumber:i.phoneNumber||null,tenantId:i.tenantId||null,providerData:s,metadata:new Dp(i.createdAt,i.lastLoginAt),isAnonymous:!(i.email&&i.passwordHash)&&!(s!=null&&s.length)};return Object.assign(u,c),u}}/**
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
 */const rw=new Map;function hr(t){Cr(t instanceof Function,"Expected a class definition");let e=rw.get(t);return e?(Cr(e instanceof t,"Instance stored in cache mismatched with class"),e):(e=new t,rw.set(t,e),e)}/**
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
 */class c1{constructor(){this.type="NONE",this.storage={}}async _isAvailable(){return!0}async _set(e,n){this.storage[e]=n}async _get(e){const n=this.storage[e];return n===void 0?null:n}async _remove(e){delete this.storage[e]}_addListener(e,n){}_removeListener(e,n){}}c1.type="NONE";const iw=c1;/**
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
 */function Ku(t,e,n){return`firebase:${t}:${e}:${n}`}class qs{constructor(e,n,r){this.persistence=e,this.auth=n,this.userKey=r;const{config:i,name:s}=this.auth;this.fullUserKey=Ku(this.userKey,i.apiKey,s),this.fullPersistenceKey=Ku("persistence",i.apiKey,s),this.boundEventHandler=n._onStorageEvent.bind(n),this.persistence._addListener(this.fullUserKey,this.boundEventHandler)}setCurrentUser(e){return this.persistence._set(this.fullUserKey,e.toJSON())}async getCurrentUser(){const e=await this.persistence._get(this.fullUserKey);return e?cr._fromJSON(this.auth,e):null}removeCurrentUser(){return this.persistence._remove(this.fullUserKey)}savePersistenceForRedirect(){return this.persistence._set(this.fullPersistenceKey,this.persistence.type)}async setPersistence(e){if(this.persistence===e)return;const n=await this.getCurrentUser();if(await this.removeCurrentUser(),this.persistence=e,n)return this.setCurrentUser(n)}delete(){this.persistence._removeListener(this.fullUserKey,this.boundEventHandler)}static async create(e,n,r="authUser"){if(!n.length)return new qs(hr(iw),e,r);const i=(await Promise.all(n.map(async c=>{if(await c._isAvailable())return c}))).filter(c=>c);let s=i[0]||hr(iw);const o=Ku(r,e.config.apiKey,e.name);let a=null;for(const c of n)try{const h=await c._get(o);if(h){const f=cr._fromJSON(e,h);c!==s&&(a=f),s=c;break}}catch{}const u=i.filter(c=>c._shouldAllowMigration);return!s._shouldAllowMigration||!u.length?new qs(s,e,r):(s=u[0],a&&await s._set(o,a.toJSON()),await Promise.all(n.map(async c=>{if(c!==s)try{await c._remove(o)}catch{}})),new qs(s,e,r))}}/**
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
 */function sw(t){const e=t.toLowerCase();if(e.includes("opera/")||e.includes("opr/")||e.includes("opios/"))return"Opera";if(p1(e))return"IEMobile";if(e.includes("msie")||e.includes("trident/"))return"IE";if(e.includes("edge/"))return"Edge";if(h1(e))return"Firefox";if(e.includes("silk/"))return"Silk";if(g1(e))return"Blackberry";if(_1(e))return"Webos";if(d1(e))return"Safari";if((e.includes("chrome/")||f1(e))&&!e.includes("edge/"))return"Chrome";if(m1(e))return"Android";{const n=/([a-zA-Z\d\.]+)\/[a-zA-Z\d\.]*$/,r=t.match(n);if((r==null?void 0:r.length)===2)return r[1]}return"Other"}function h1(t=Vt()){return/firefox\//i.test(t)}function d1(t=Vt()){const e=t.toLowerCase();return e.includes("safari/")&&!e.includes("chrome/")&&!e.includes("crios/")&&!e.includes("android")}function f1(t=Vt()){return/crios\//i.test(t)}function p1(t=Vt()){return/iemobile/i.test(t)}function m1(t=Vt()){return/android/i.test(t)}function g1(t=Vt()){return/blackberry/i.test(t)}function _1(t=Vt()){return/webos/i.test(t)}function Zg(t=Vt()){return/iphone|ipad|ipod/i.test(t)||/macintosh/i.test(t)&&/mobile/i.test(t)}function TF(t=Vt()){var e;return Zg(t)&&!!(!((e=window.navigator)===null||e===void 0)&&e.standalone)}function IF(){return vA()&&document.documentMode===10}function y1(t=Vt()){return Zg(t)||m1(t)||_1(t)||g1(t)||/windows phone/i.test(t)||p1(t)}/**
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
 */function v1(t,e=[]){let n;switch(t){case"Browser":n=sw(Vt());break;case"Worker":n=`${sw(Vt())}-${t}`;break;default:n=t}const r=e.length?e.join(","):"FirebaseCore-web";return`${n}/JsCore/${yi}/${r}`}/**
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
 */class SF{constructor(e){this.auth=e,this.queue=[]}pushCallback(e,n){const r=s=>new Promise((o,a)=>{try{const u=e(s);o(u)}catch(u){a(u)}});r.onAbort=n,this.queue.push(r);const i=this.queue.length-1;return()=>{this.queue[i]=()=>Promise.resolve()}}async runMiddleware(e){if(this.auth.currentUser===e)return;const n=[];try{for(const r of this.queue)await r(e),r.onAbort&&n.push(r.onAbort)}catch(r){n.reverse();for(const i of n)try{i()}catch{}throw this.auth._errorFactory.create("login-blocked",{originalMessage:r==null?void 0:r.message})}}}/**
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
 */async function kF(t,e={}){return Ro(t,"GET","/v2/passwordPolicy",Fh(t,e))}/**
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
 */const CF=6;class RF{constructor(e){var n,r,i,s;const o=e.customStrengthOptions;this.customStrengthOptions={},this.customStrengthOptions.minPasswordLength=(n=o.minPasswordLength)!==null&&n!==void 0?n:CF,o.maxPasswordLength&&(this.customStrengthOptions.maxPasswordLength=o.maxPasswordLength),o.containsLowercaseCharacter!==void 0&&(this.customStrengthOptions.containsLowercaseLetter=o.containsLowercaseCharacter),o.containsUppercaseCharacter!==void 0&&(this.customStrengthOptions.containsUppercaseLetter=o.containsUppercaseCharacter),o.containsNumericCharacter!==void 0&&(this.customStrengthOptions.containsNumericCharacter=o.containsNumericCharacter),o.containsNonAlphanumericCharacter!==void 0&&(this.customStrengthOptions.containsNonAlphanumericCharacter=o.containsNonAlphanumericCharacter),this.enforcementState=e.enforcementState,this.enforcementState==="ENFORCEMENT_STATE_UNSPECIFIED"&&(this.enforcementState="OFF"),this.allowedNonAlphanumericCharacters=(i=(r=e.allowedNonAlphanumericCharacters)===null||r===void 0?void 0:r.join(""))!==null&&i!==void 0?i:"",this.forceUpgradeOnSignin=(s=e.forceUpgradeOnSignin)!==null&&s!==void 0?s:!1,this.schemaVersion=e.schemaVersion}validatePassword(e){var n,r,i,s,o,a;const u={isValid:!0,passwordPolicy:this};return this.validatePasswordLengthOptions(e,u),this.validatePasswordCharacterOptions(e,u),u.isValid&&(u.isValid=(n=u.meetsMinPasswordLength)!==null&&n!==void 0?n:!0),u.isValid&&(u.isValid=(r=u.meetsMaxPasswordLength)!==null&&r!==void 0?r:!0),u.isValid&&(u.isValid=(i=u.containsLowercaseLetter)!==null&&i!==void 0?i:!0),u.isValid&&(u.isValid=(s=u.containsUppercaseLetter)!==null&&s!==void 0?s:!0),u.isValid&&(u.isValid=(o=u.containsNumericCharacter)!==null&&o!==void 0?o:!0),u.isValid&&(u.isValid=(a=u.containsNonAlphanumericCharacter)!==null&&a!==void 0?a:!0),u}validatePasswordLengthOptions(e,n){const r=this.customStrengthOptions.minPasswordLength,i=this.customStrengthOptions.maxPasswordLength;r&&(n.meetsMinPasswordLength=e.length>=r),i&&(n.meetsMaxPasswordLength=e.length<=i)}validatePasswordCharacterOptions(e,n){this.updatePasswordCharacterOptionsStatuses(n,!1,!1,!1,!1);let r;for(let i=0;i<e.length;i++)r=e.charAt(i),this.updatePasswordCharacterOptionsStatuses(n,r>="a"&&r<="z",r>="A"&&r<="Z",r>="0"&&r<="9",this.allowedNonAlphanumericCharacters.includes(r))}updatePasswordCharacterOptionsStatuses(e,n,r,i,s){this.customStrengthOptions.containsLowercaseLetter&&(e.containsLowercaseLetter||(e.containsLowercaseLetter=n)),this.customStrengthOptions.containsUppercaseLetter&&(e.containsUppercaseLetter||(e.containsUppercaseLetter=r)),this.customStrengthOptions.containsNumericCharacter&&(e.containsNumericCharacter||(e.containsNumericCharacter=i)),this.customStrengthOptions.containsNonAlphanumericCharacter&&(e.containsNonAlphanumericCharacter||(e.containsNonAlphanumericCharacter=s))}}/**
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
 */class xF{constructor(e,n,r,i){this.app=e,this.heartbeatServiceProvider=n,this.appCheckServiceProvider=r,this.config=i,this.currentUser=null,this.emulatorConfig=null,this.operations=Promise.resolve(),this.authStateSubscription=new ow(this),this.idTokenSubscription=new ow(this),this.beforeStateQueue=new SF(this),this.redirectUser=null,this.isProactiveRefreshEnabled=!1,this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION=1,this._canInitEmulator=!0,this._isInitialized=!1,this._deleted=!1,this._initializationPromise=null,this._popupRedirectResolver=null,this._errorFactory=n1,this._agentRecaptchaConfig=null,this._tenantRecaptchaConfigs={},this._projectPasswordPolicy=null,this._tenantPasswordPolicies={},this.lastNotifiedUid=void 0,this.languageCode=null,this.tenantId=null,this.settings={appVerificationDisabledForTesting:!1},this.frameworks=[],this.name=e.name,this.clientVersion=i.sdkClientVersion}_initializeWithPersistence(e,n){return n&&(this._popupRedirectResolver=hr(n)),this._initializationPromise=this.queue(async()=>{var r,i;if(!this._deleted&&(this.persistenceManager=await qs.create(this,e),!this._deleted)){if(!((r=this._popupRedirectResolver)===null||r===void 0)&&r._shouldInitProactively)try{await this._popupRedirectResolver._initialize(this)}catch{}await this.initializeCurrentUser(n),this.lastNotifiedUid=((i=this.currentUser)===null||i===void 0?void 0:i.uid)||null,!this._deleted&&(this._isInitialized=!0)}}),this._initializationPromise}async _onStorageEvent(){if(this._deleted)return;const e=await this.assertedPersistence.getCurrentUser();if(!(!this.currentUser&&!e)){if(this.currentUser&&e&&this.currentUser.uid===e.uid){this._currentUser._assign(e),await this.currentUser.getIdToken();return}await this._updateCurrentUser(e,!0)}}async initializeCurrentUserFromIdToken(e){try{const n=await l1(this,{idToken:e}),r=await cr._fromGetAccountInfoResponse(this,n,e);await this.directlySetCurrentUser(r)}catch(n){console.warn("FirebaseServerApp could not login user with provided authIdToken: ",n),await this.directlySetCurrentUser(null)}}async initializeCurrentUser(e){var n;if(ar(this.app)){const o=this.app.settings.authIdToken;return o?new Promise(a=>{setTimeout(()=>this.initializeCurrentUserFromIdToken(o).then(a,a))}):this.directlySetCurrentUser(null)}const r=await this.assertedPersistence.getCurrentUser();let i=r,s=!1;if(e&&this.config.authDomain){await this.getOrInitRedirectPersistenceManager();const o=(n=this.redirectUser)===null||n===void 0?void 0:n._redirectEventId,a=i==null?void 0:i._redirectEventId,u=await this.tryRedirectSignIn(e);(!o||o===a)&&(u!=null&&u.user)&&(i=u.user,s=!0)}if(!i)return this.directlySetCurrentUser(null);if(!i._redirectEventId){if(s)try{await this.beforeStateQueue.runMiddleware(i)}catch(o){i=r,this._popupRedirectResolver._overrideRedirectResult(this,()=>Promise.reject(o))}return i?this.reloadAndSetCurrentUserOrClear(i):this.directlySetCurrentUser(null)}return se(this._popupRedirectResolver,this,"argument-error"),await this.getOrInitRedirectPersistenceManager(),this.redirectUser&&this.redirectUser._redirectEventId===i._redirectEventId?this.directlySetCurrentUser(i):this.reloadAndSetCurrentUserOrClear(i)}async tryRedirectSignIn(e){let n=null;try{n=await this._popupRedirectResolver._completeRedirectFn(this,e,!0)}catch{await this._setRedirectUser(null)}return n}async reloadAndSetCurrentUserOrClear(e){try{await Wc(e)}catch(n){if((n==null?void 0:n.code)!=="auth/network-request-failed")return this.directlySetCurrentUser(null)}return this.directlySetCurrentUser(e)}useDeviceLanguage(){this.languageCode=cF()}async _delete(){this._deleted=!0}async updateCurrentUser(e){if(ar(this.app))return Promise.reject(oi(this));const n=e?Ye(e):null;return n&&se(n.auth.config.apiKey===this.config.apiKey,this,"invalid-user-token"),this._updateCurrentUser(n&&n._clone(this))}async _updateCurrentUser(e,n=!1){if(!this._deleted)return e&&se(this.tenantId===e.tenantId,this,"tenant-id-mismatch"),n||await this.beforeStateQueue.runMiddleware(e),this.queue(async()=>{await this.directlySetCurrentUser(e),this.notifyAuthListeners()})}async signOut(){return ar(this.app)?Promise.reject(oi(this)):(await this.beforeStateQueue.runMiddleware(null),(this.redirectPersistenceManager||this._popupRedirectResolver)&&await this._setRedirectUser(null),this._updateCurrentUser(null,!0))}setPersistence(e){return ar(this.app)?Promise.reject(oi(this)):this.queue(async()=>{await this.assertedPersistence.setPersistence(hr(e))})}_getRecaptchaConfig(){return this.tenantId==null?this._agentRecaptchaConfig:this._tenantRecaptchaConfigs[this.tenantId]}async validatePassword(e){this._getPasswordPolicyInternal()||await this._updatePasswordPolicy();const n=this._getPasswordPolicyInternal();return n.schemaVersion!==this.EXPECTED_PASSWORD_POLICY_SCHEMA_VERSION?Promise.reject(this._errorFactory.create("unsupported-password-policy-schema-version",{})):n.validatePassword(e)}_getPasswordPolicyInternal(){return this.tenantId===null?this._projectPasswordPolicy:this._tenantPasswordPolicies[this.tenantId]}async _updatePasswordPolicy(){const e=await kF(this),n=new RF(e);this.tenantId===null?this._projectPasswordPolicy=n:this._tenantPasswordPolicies[this.tenantId]=n}_getPersistence(){return this.assertedPersistence.persistence.type}_updateErrorMap(e){this._errorFactory=new yl("auth","Firebase",e())}onAuthStateChanged(e,n,r){return this.registerStateListener(this.authStateSubscription,e,n,r)}beforeAuthStateChanged(e,n){return this.beforeStateQueue.pushCallback(e,n)}onIdTokenChanged(e,n,r){return this.registerStateListener(this.idTokenSubscription,e,n,r)}authStateReady(){return new Promise((e,n)=>{if(this.currentUser)e();else{const r=this.onAuthStateChanged(()=>{r(),e()},n)}})}async revokeAccessToken(e){if(this.currentUser){const n=await this.currentUser.getIdToken(),r={providerId:"apple.com",tokenType:"ACCESS_TOKEN",token:e,idToken:n};this.tenantId!=null&&(r.tenantId=this.tenantId),await EF(this,r)}}toJSON(){var e;return{apiKey:this.config.apiKey,authDomain:this.config.authDomain,appName:this.name,currentUser:(e=this._currentUser)===null||e===void 0?void 0:e.toJSON()}}async _setRedirectUser(e,n){const r=await this.getOrInitRedirectPersistenceManager(n);return e===null?r.removeCurrentUser():r.setCurrentUser(e)}async getOrInitRedirectPersistenceManager(e){if(!this.redirectPersistenceManager){const n=e&&hr(e)||this._popupRedirectResolver;se(n,this,"argument-error"),this.redirectPersistenceManager=await qs.create(this,[hr(n._redirectPersistence)],"redirectUser"),this.redirectUser=await this.redirectPersistenceManager.getCurrentUser()}return this.redirectPersistenceManager}async _redirectUserForId(e){var n,r;return this._isInitialized&&await this.queue(async()=>{}),((n=this._currentUser)===null||n===void 0?void 0:n._redirectEventId)===e?this._currentUser:((r=this.redirectUser)===null||r===void 0?void 0:r._redirectEventId)===e?this.redirectUser:null}async _persistUserIfCurrent(e){if(e===this.currentUser)return this.queue(async()=>this.directlySetCurrentUser(e))}_notifyListenersIfCurrent(e){e===this.currentUser&&this.notifyAuthListeners()}_key(){return`${this.config.authDomain}:${this.config.apiKey}:${this.name}`}_startProactiveRefresh(){this.isProactiveRefreshEnabled=!0,this.currentUser&&this._currentUser._startProactiveRefresh()}_stopProactiveRefresh(){this.isProactiveRefreshEnabled=!1,this.currentUser&&this._currentUser._stopProactiveRefresh()}get _currentUser(){return this.currentUser}notifyAuthListeners(){var e,n;if(!this._isInitialized)return;this.idTokenSubscription.next(this.currentUser);const r=(n=(e=this.currentUser)===null||e===void 0?void 0:e.uid)!==null&&n!==void 0?n:null;this.lastNotifiedUid!==r&&(this.lastNotifiedUid=r,this.authStateSubscription.next(this.currentUser))}registerStateListener(e,n,r,i){if(this._deleted)return()=>{};const s=typeof n=="function"?n:n.next.bind(n);let o=!1;const a=this._isInitialized?Promise.resolve():this._initializationPromise;if(se(a,this,"internal-error"),a.then(()=>{o||s(this.currentUser)}),typeof n=="function"){const u=e.addObserver(n,r,i);return()=>{o=!0,u()}}else{const u=e.addObserver(n);return()=>{o=!0,u()}}}async directlySetCurrentUser(e){this.currentUser&&this.currentUser!==e&&this._currentUser._stopProactiveRefresh(),e&&this.isProactiveRefreshEnabled&&e._startProactiveRefresh(),this.currentUser=e,e?await this.assertedPersistence.setCurrentUser(e):await this.assertedPersistence.removeCurrentUser()}queue(e){return this.operations=this.operations.then(e,e),this.operations}get assertedPersistence(){return se(this.persistenceManager,this,"internal-error"),this.persistenceManager}_logFramework(e){!e||this.frameworks.includes(e)||(this.frameworks.push(e),this.frameworks.sort(),this.clientVersion=v1(this.config.clientPlatform,this._getFrameworks()))}_getFrameworks(){return this.frameworks}async _getAdditionalHeaders(){var e;const n={"X-Client-Version":this.clientVersion};this.app.options.appId&&(n["X-Firebase-gmpid"]=this.app.options.appId);const r=await((e=this.heartbeatServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getHeartbeatsHeader());r&&(n["X-Firebase-Client"]=r);const i=await this._getAppCheckToken();return i&&(n["X-Firebase-AppCheck"]=i),n}async _getAppCheckToken(){var e;const n=await((e=this.appCheckServiceProvider.getImmediate({optional:!0}))===null||e===void 0?void 0:e.getToken());return n!=null&&n.error&&aF(`Error while retrieving App Check token: ${n.error}`),n==null?void 0:n.token}}function Vh(t){return Ye(t)}class ow{constructor(e){this.auth=e,this.observer=null,this.addObserver=PA(n=>this.observer=n)}get next(){return se(this.observer,this.auth,"internal-error"),this.observer.next.bind(this.observer)}}/**
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
 */let e_={async loadJS(){throw new Error("Unable to load external scripts")},recaptchaV2Script:"",recaptchaEnterpriseScript:"",gapiScript:""};function AF(t){e_=t}function PF(t){return e_.loadJS(t)}function bF(){return e_.gapiScript}function NF(t){return`__${t}${Math.floor(Math.random()*1e6)}`}/**
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
 */function DF(t,e){const n=vl(t,"auth");if(n.isInitialized()){const i=n.getImmediate(),s=n.getOptions();if(kc(s,e??{}))return i;kr(i,"already-initialized")}return n.initialize({options:e})}function OF(t,e){const n=(e==null?void 0:e.persistence)||[],r=(Array.isArray(n)?n:[n]).map(hr);e!=null&&e.errorMap&&t._updateErrorMap(e.errorMap),t._initializeWithPersistence(r,e==null?void 0:e.popupRedirectResolver)}function MF(t,e,n){const r=Vh(t);se(r._canInitEmulator,r,"emulator-config-failed"),se(/^https?:\/\//.test(e),r,"invalid-emulator-scheme");const i=!1,s=w1(e),{host:o,port:a}=LF(e),u=a===null?"":`:${a}`;r.config.emulator={url:`${s}//${o}${u}/`},r.settings.appVerificationDisabledForTesting=!0,r.emulatorConfig=Object.freeze({host:o,port:a,protocol:s.replace(":",""),options:Object.freeze({disableWarnings:i})}),FF()}function w1(t){const e=t.indexOf(":");return e<0?"":t.substr(0,e+1)}function LF(t){const e=w1(t),n=/(\/\/)?([^?#/]+)/.exec(t.substr(e.length));if(!n)return{host:"",port:null};const r=n[2].split("@").pop()||"",i=/^(\[[^\]]+\])(:|$)/.exec(r);if(i){const s=i[1];return{host:s,port:aw(r.substr(s.length+1))}}else{const[s,o]=r.split(":");return{host:s,port:aw(o)}}}function aw(t){if(!t)return null;const e=Number(t);return isNaN(e)?null:e}function FF(){function t(){const e=document.createElement("p"),n=e.style;e.innerText="Running in emulator mode. Do not use with production credentials.",n.position="fixed",n.width="100%",n.backgroundColor="#ffffff",n.border=".1em solid #000000",n.color="#b50000",n.bottom="0px",n.left="0px",n.margin="0px",n.zIndex="10000",n.textAlign="center",e.classList.add("firebase-emulator-warning"),document.body.appendChild(e)}typeof console<"u"&&typeof console.info=="function"&&console.info("WARNING: You are using the Auth Emulator, which is intended for local testing only.  Do not use with production credentials."),typeof window<"u"&&typeof document<"u"&&(document.readyState==="loading"?window.addEventListener("DOMContentLoaded",t):t())}/**
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
 */class E1{constructor(e,n){this.providerId=e,this.signInMethod=n}toJSON(){return ur("not implemented")}_getIdTokenResponse(e){return ur("not implemented")}_linkToIdToken(e,n){return ur("not implemented")}_getReauthenticationResolver(e){return ur("not implemented")}}/**
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
 */async function Hs(t,e){return o1(t,"POST","/v1/accounts:signInWithIdp",Fh(t,e))}/**
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
 */const VF="http://localhost";class Xi extends E1{constructor(){super(...arguments),this.pendingToken=null}static _fromParams(e){const n=new Xi(e.providerId,e.signInMethod);return e.idToken||e.accessToken?(e.idToken&&(n.idToken=e.idToken),e.accessToken&&(n.accessToken=e.accessToken),e.nonce&&!e.pendingToken&&(n.nonce=e.nonce),e.pendingToken&&(n.pendingToken=e.pendingToken)):e.oauthToken&&e.oauthTokenSecret?(n.accessToken=e.oauthToken,n.secret=e.oauthTokenSecret):kr("argument-error"),n}toJSON(){return{idToken:this.idToken,accessToken:this.accessToken,secret:this.secret,nonce:this.nonce,pendingToken:this.pendingToken,providerId:this.providerId,signInMethod:this.signInMethod}}static fromJSON(e){const n=typeof e=="string"?JSON.parse(e):e,{providerId:r,signInMethod:i}=n,s=Qg(n,["providerId","signInMethod"]);if(!r||!i)return null;const o=new Xi(r,i);return o.idToken=s.idToken||void 0,o.accessToken=s.accessToken||void 0,o.secret=s.secret,o.nonce=s.nonce,o.pendingToken=s.pendingToken||null,o}_getIdTokenResponse(e){const n=this.buildRequest();return Hs(e,n)}_linkToIdToken(e,n){const r=this.buildRequest();return r.idToken=n,Hs(e,r)}_getReauthenticationResolver(e){const n=this.buildRequest();return n.autoCreate=!1,Hs(e,n)}buildRequest(){const e={requestUri:VF,returnSecureToken:!0};if(this.pendingToken)e.pendingToken=this.pendingToken;else{const n={};this.idToken&&(n.id_token=this.idToken),this.accessToken&&(n.access_token=this.accessToken),this.secret&&(n.oauth_token_secret=this.secret),n.providerId=this.providerId,this.nonce&&!this.pendingToken&&(n.nonce=this.nonce),e.postBody=_o(n)}return e}}/**
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
 */class T1{constructor(e){this.providerId=e,this.defaultLanguageCode=null,this.customParameters={}}setDefaultLanguage(e){this.defaultLanguageCode=e}setCustomParameters(e){return this.customParameters=e,this}getCustomParameters(){return this.customParameters}}/**
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
 */class Nl extends T1{constructor(){super(...arguments),this.scopes=[]}addScope(e){return this.scopes.includes(e)||this.scopes.push(e),this}getScopes(){return[...this.scopes]}}/**
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
 */class Ur extends Nl{constructor(){super("facebook.com")}static credential(e){return Xi._fromParams({providerId:Ur.PROVIDER_ID,signInMethod:Ur.FACEBOOK_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return Ur.credentialFromTaggedObject(e)}static credentialFromError(e){return Ur.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return Ur.credential(e.oauthAccessToken)}catch{return null}}}Ur.FACEBOOK_SIGN_IN_METHOD="facebook.com";Ur.PROVIDER_ID="facebook.com";/**
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
 */class jr extends Nl{constructor(){super("google.com"),this.addScope("profile")}static credential(e,n){return Xi._fromParams({providerId:jr.PROVIDER_ID,signInMethod:jr.GOOGLE_SIGN_IN_METHOD,idToken:e,accessToken:n})}static credentialFromResult(e){return jr.credentialFromTaggedObject(e)}static credentialFromError(e){return jr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthIdToken:n,oauthAccessToken:r}=e;if(!n&&!r)return null;try{return jr.credential(n,r)}catch{return null}}}jr.GOOGLE_SIGN_IN_METHOD="google.com";jr.PROVIDER_ID="google.com";/**
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
 */class zr extends Nl{constructor(){super("github.com")}static credential(e){return Xi._fromParams({providerId:zr.PROVIDER_ID,signInMethod:zr.GITHUB_SIGN_IN_METHOD,accessToken:e})}static credentialFromResult(e){return zr.credentialFromTaggedObject(e)}static credentialFromError(e){return zr.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e||!("oauthAccessToken"in e)||!e.oauthAccessToken)return null;try{return zr.credential(e.oauthAccessToken)}catch{return null}}}zr.GITHUB_SIGN_IN_METHOD="github.com";zr.PROVIDER_ID="github.com";/**
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
 */class Br extends Nl{constructor(){super("twitter.com")}static credential(e,n){return Xi._fromParams({providerId:Br.PROVIDER_ID,signInMethod:Br.TWITTER_SIGN_IN_METHOD,oauthToken:e,oauthTokenSecret:n})}static credentialFromResult(e){return Br.credentialFromTaggedObject(e)}static credentialFromError(e){return Br.credentialFromTaggedObject(e.customData||{})}static credentialFromTaggedObject({_tokenResponse:e}){if(!e)return null;const{oauthAccessToken:n,oauthTokenSecret:r}=e;if(!n||!r)return null;try{return Br.credential(n,r)}catch{return null}}}Br.TWITTER_SIGN_IN_METHOD="twitter.com";Br.PROVIDER_ID="twitter.com";/**
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
 */async function UF(t,e){return o1(t,"POST","/v1/accounts:signUp",Fh(t,e))}/**
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
 */class pi{constructor(e){this.user=e.user,this.providerId=e.providerId,this._tokenResponse=e._tokenResponse,this.operationType=e.operationType}static async _fromIdTokenResponse(e,n,r,i=!1){const s=await cr._fromIdTokenResponse(e,r,i),o=lw(r);return new pi({user:s,providerId:o,_tokenResponse:r,operationType:n})}static async _forOperation(e,n,r){await e._updateTokensIfNecessary(r,!0);const i=lw(r);return new pi({user:e,providerId:i,_tokenResponse:r,operationType:n})}}function lw(t){return t.providerId?t.providerId:"phoneNumber"in t?"phone":null}/**
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
 */async function jF(t){var e;if(ar(t.app))return Promise.reject(oi(t));const n=Vh(t);if(await n._initializationPromise,!((e=n.currentUser)===null||e===void 0)&&e.isAnonymous)return new pi({user:n.currentUser,providerId:null,operationType:"signIn"});const r=await UF(n,{returnSecureToken:!0}),i=await pi._fromIdTokenResponse(n,"signIn",r,!0);return await n._updateCurrentUser(i.user),i}/**
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
 */class qc extends Zn{constructor(e,n,r,i){var s;super(n.code,n.message),this.operationType=r,this.user=i,Object.setPrototypeOf(this,qc.prototype),this.customData={appName:e.name,tenantId:(s=e.tenantId)!==null&&s!==void 0?s:void 0,_serverResponse:n.customData._serverResponse,operationType:r}}static _fromErrorAndOperation(e,n,r,i){return new qc(e,n,r,i)}}function I1(t,e,n,r){return(e==="reauthenticate"?n._getReauthenticationResolver(t):n._getIdTokenResponse(t)).catch(s=>{throw s.code==="auth/multi-factor-auth-required"?qc._fromErrorAndOperation(t,s,e,r):s})}async function zF(t,e,n=!1){const r=await dl(t,e._linkToIdToken(t.auth,await t.getIdToken()),n);return pi._forOperation(t,"link",r)}/**
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
 */async function BF(t,e,n=!1){const{auth:r}=t;if(ar(r.app))return Promise.reject(oi(r));const i="reauthenticate";try{const s=await dl(t,I1(r,i,e,t),n);se(s.idToken,r,"internal-error");const o=Jg(s.idToken);se(o,r,"internal-error");const{sub:a}=o;return se(t.uid===a,r,"user-mismatch"),pi._forOperation(t,i,s)}catch(s){throw(s==null?void 0:s.code)==="auth/user-not-found"&&kr(r,"user-mismatch"),s}}/**
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
 */async function $F(t,e,n=!1){if(ar(t.app))return Promise.reject(oi(t));const r="signIn",i=await I1(t,r,e),s=await pi._fromIdTokenResponse(t,r,i);return n||await t._updateCurrentUser(s.user),s}function WF(t,e,n,r){return Ye(t).onIdTokenChanged(e,n,r)}function qF(t,e,n){return Ye(t).beforeAuthStateChanged(e,n)}const Hc="__sak";/**
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
 */class S1{constructor(e,n){this.storageRetriever=e,this.type=n}_isAvailable(){try{return this.storage?(this.storage.setItem(Hc,"1"),this.storage.removeItem(Hc),Promise.resolve(!0)):Promise.resolve(!1)}catch{return Promise.resolve(!1)}}_set(e,n){return this.storage.setItem(e,JSON.stringify(n)),Promise.resolve()}_get(e){const n=this.storage.getItem(e);return Promise.resolve(n?JSON.parse(n):null)}_remove(e){return this.storage.removeItem(e),Promise.resolve()}get storage(){return this.storageRetriever()}}/**
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
 */const HF=1e3,GF=10;class k1 extends S1{constructor(){super(()=>window.localStorage,"LOCAL"),this.boundEventHandler=(e,n)=>this.onStorageEvent(e,n),this.listeners={},this.localCache={},this.pollTimer=null,this.fallbackToPolling=y1(),this._shouldAllowMigration=!0}forAllChangedKeys(e){for(const n of Object.keys(this.listeners)){const r=this.storage.getItem(n),i=this.localCache[n];r!==i&&e(n,i,r)}}onStorageEvent(e,n=!1){if(!e.key){this.forAllChangedKeys((o,a,u)=>{this.notifyListeners(o,u)});return}const r=e.key;n?this.detachListener():this.stopPolling();const i=()=>{const o=this.storage.getItem(r);!n&&this.localCache[r]===o||this.notifyListeners(r,o)},s=this.storage.getItem(r);IF()&&s!==e.newValue&&e.newValue!==e.oldValue?setTimeout(i,GF):i()}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n&&JSON.parse(n))}startPolling(){this.stopPolling(),this.pollTimer=setInterval(()=>{this.forAllChangedKeys((e,n,r)=>{this.onStorageEvent(new StorageEvent("storage",{key:e,oldValue:n,newValue:r}),!0)})},HF)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}attachListener(){window.addEventListener("storage",this.boundEventHandler)}detachListener(){window.removeEventListener("storage",this.boundEventHandler)}_addListener(e,n){Object.keys(this.listeners).length===0&&(this.fallbackToPolling?this.startPolling():this.attachListener()),this.listeners[e]||(this.listeners[e]=new Set,this.localCache[e]=this.storage.getItem(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&(this.detachListener(),this.stopPolling())}async _set(e,n){await super._set(e,n),this.localCache[e]=JSON.stringify(n)}async _get(e){const n=await super._get(e);return this.localCache[e]=JSON.stringify(n),n}async _remove(e){await super._remove(e),delete this.localCache[e]}}k1.type="LOCAL";const KF=k1;/**
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
 */class C1 extends S1{constructor(){super(()=>window.sessionStorage,"SESSION")}_addListener(e,n){}_removeListener(e,n){}}C1.type="SESSION";const R1=C1;/**
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
 */function QF(t){return Promise.all(t.map(async e=>{try{return{fulfilled:!0,value:await e}}catch(n){return{fulfilled:!1,reason:n}}}))}/**
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
 */class Uh{constructor(e){this.eventTarget=e,this.handlersMap={},this.boundEventHandler=this.handleEvent.bind(this)}static _getInstance(e){const n=this.receivers.find(i=>i.isListeningto(e));if(n)return n;const r=new Uh(e);return this.receivers.push(r),r}isListeningto(e){return this.eventTarget===e}async handleEvent(e){const n=e,{eventId:r,eventType:i,data:s}=n.data,o=this.handlersMap[i];if(!(o!=null&&o.size))return;n.ports[0].postMessage({status:"ack",eventId:r,eventType:i});const a=Array.from(o).map(async c=>c(n.origin,s)),u=await QF(a);n.ports[0].postMessage({status:"done",eventId:r,eventType:i,response:u})}_subscribe(e,n){Object.keys(this.handlersMap).length===0&&this.eventTarget.addEventListener("message",this.boundEventHandler),this.handlersMap[e]||(this.handlersMap[e]=new Set),this.handlersMap[e].add(n)}_unsubscribe(e,n){this.handlersMap[e]&&n&&this.handlersMap[e].delete(n),(!n||this.handlersMap[e].size===0)&&delete this.handlersMap[e],Object.keys(this.handlersMap).length===0&&this.eventTarget.removeEventListener("message",this.boundEventHandler)}}Uh.receivers=[];/**
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
 */function t_(t="",e=10){let n="";for(let r=0;r<e;r++)n+=Math.floor(Math.random()*10);return t+n}/**
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
 */class YF{constructor(e){this.target=e,this.handlers=new Set}removeMessageHandler(e){e.messageChannel&&(e.messageChannel.port1.removeEventListener("message",e.onMessage),e.messageChannel.port1.close()),this.handlers.delete(e)}async _send(e,n,r=50){const i=typeof MessageChannel<"u"?new MessageChannel:null;if(!i)throw new Error("connection_unavailable");let s,o;return new Promise((a,u)=>{const c=t_("",20);i.port1.start();const h=setTimeout(()=>{u(new Error("unsupported_event"))},r);o={messageChannel:i,onMessage(f){const m=f;if(m.data.eventId===c)switch(m.data.status){case"ack":clearTimeout(h),s=setTimeout(()=>{u(new Error("timeout"))},3e3);break;case"done":clearTimeout(s),a(m.data.response);break;default:clearTimeout(h),clearTimeout(s),u(new Error("invalid_response"));break}}},this.handlers.add(o),i.port1.addEventListener("message",o.onMessage),this.target.postMessage({eventType:e,eventId:c,data:n},[i.port2])}).finally(()=>{o&&this.removeMessageHandler(o)})}}/**
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
 */function Xn(){return window}function XF(t){Xn().location.href=t}/**
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
 */function x1(){return typeof Xn().WorkerGlobalScope<"u"&&typeof Xn().importScripts=="function"}async function JF(){if(!(navigator!=null&&navigator.serviceWorker))return null;try{return(await navigator.serviceWorker.ready).active}catch{return null}}function ZF(){var t;return((t=navigator==null?void 0:navigator.serviceWorker)===null||t===void 0?void 0:t.controller)||null}function eV(){return x1()?self:null}/**
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
 */const A1="firebaseLocalStorageDb",tV=1,Gc="firebaseLocalStorage",P1="fbase_key";class Dl{constructor(e){this.request=e}toPromise(){return new Promise((e,n)=>{this.request.addEventListener("success",()=>{e(this.request.result)}),this.request.addEventListener("error",()=>{n(this.request.error)})})}}function jh(t,e){return t.transaction([Gc],e?"readwrite":"readonly").objectStore(Gc)}function nV(){const t=indexedDB.deleteDatabase(A1);return new Dl(t).toPromise()}function Op(){const t=indexedDB.open(A1,tV);return new Promise((e,n)=>{t.addEventListener("error",()=>{n(t.error)}),t.addEventListener("upgradeneeded",()=>{const r=t.result;try{r.createObjectStore(Gc,{keyPath:P1})}catch(i){n(i)}}),t.addEventListener("success",async()=>{const r=t.result;r.objectStoreNames.contains(Gc)?e(r):(r.close(),await nV(),e(await Op()))})})}async function uw(t,e,n){const r=jh(t,!0).put({[P1]:e,value:n});return new Dl(r).toPromise()}async function rV(t,e){const n=jh(t,!1).get(e),r=await new Dl(n).toPromise();return r===void 0?null:r.value}function cw(t,e){const n=jh(t,!0).delete(e);return new Dl(n).toPromise()}const iV=800,sV=3;class b1{constructor(){this.type="LOCAL",this._shouldAllowMigration=!0,this.listeners={},this.localCache={},this.pollTimer=null,this.pendingWrites=0,this.receiver=null,this.sender=null,this.serviceWorkerReceiverAvailable=!1,this.activeServiceWorker=null,this._workerInitializationPromise=this.initializeServiceWorkerMessaging().then(()=>{},()=>{})}async _openDb(){return this.db?this.db:(this.db=await Op(),this.db)}async _withRetries(e){let n=0;for(;;)try{const r=await this._openDb();return await e(r)}catch(r){if(n++>sV)throw r;this.db&&(this.db.close(),this.db=void 0)}}async initializeServiceWorkerMessaging(){return x1()?this.initializeReceiver():this.initializeSender()}async initializeReceiver(){this.receiver=Uh._getInstance(eV()),this.receiver._subscribe("keyChanged",async(e,n)=>({keyProcessed:(await this._poll()).includes(n.key)})),this.receiver._subscribe("ping",async(e,n)=>["keyChanged"])}async initializeSender(){var e,n;if(this.activeServiceWorker=await JF(),!this.activeServiceWorker)return;this.sender=new YF(this.activeServiceWorker);const r=await this.sender._send("ping",{},800);r&&!((e=r[0])===null||e===void 0)&&e.fulfilled&&!((n=r[0])===null||n===void 0)&&n.value.includes("keyChanged")&&(this.serviceWorkerReceiverAvailable=!0)}async notifyServiceWorker(e){if(!(!this.sender||!this.activeServiceWorker||ZF()!==this.activeServiceWorker))try{await this.sender._send("keyChanged",{key:e},this.serviceWorkerReceiverAvailable?800:50)}catch{}}async _isAvailable(){try{if(!indexedDB)return!1;const e=await Op();return await uw(e,Hc,"1"),await cw(e,Hc),!0}catch{}return!1}async _withPendingWrite(e){this.pendingWrites++;try{await e()}finally{this.pendingWrites--}}async _set(e,n){return this._withPendingWrite(async()=>(await this._withRetries(r=>uw(r,e,n)),this.localCache[e]=n,this.notifyServiceWorker(e)))}async _get(e){const n=await this._withRetries(r=>rV(r,e));return this.localCache[e]=n,n}async _remove(e){return this._withPendingWrite(async()=>(await this._withRetries(n=>cw(n,e)),delete this.localCache[e],this.notifyServiceWorker(e)))}async _poll(){const e=await this._withRetries(i=>{const s=jh(i,!1).getAll();return new Dl(s).toPromise()});if(!e)return[];if(this.pendingWrites!==0)return[];const n=[],r=new Set;if(e.length!==0)for(const{fbase_key:i,value:s}of e)r.add(i),JSON.stringify(this.localCache[i])!==JSON.stringify(s)&&(this.notifyListeners(i,s),n.push(i));for(const i of Object.keys(this.localCache))this.localCache[i]&&!r.has(i)&&(this.notifyListeners(i,null),n.push(i));return n}notifyListeners(e,n){this.localCache[e]=n;const r=this.listeners[e];if(r)for(const i of Array.from(r))i(n)}startPolling(){this.stopPolling(),this.pollTimer=setInterval(async()=>this._poll(),iV)}stopPolling(){this.pollTimer&&(clearInterval(this.pollTimer),this.pollTimer=null)}_addListener(e,n){Object.keys(this.listeners).length===0&&this.startPolling(),this.listeners[e]||(this.listeners[e]=new Set,this._get(e)),this.listeners[e].add(n)}_removeListener(e,n){this.listeners[e]&&(this.listeners[e].delete(n),this.listeners[e].size===0&&delete this.listeners[e]),Object.keys(this.listeners).length===0&&this.stopPolling()}}b1.type="LOCAL";const oV=b1;new bl(3e4,6e4);/**
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
 */function aV(t,e){return e?hr(e):(se(t._popupRedirectResolver,t,"argument-error"),t._popupRedirectResolver)}/**
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
 */class n_ extends E1{constructor(e){super("custom","custom"),this.params=e}_getIdTokenResponse(e){return Hs(e,this._buildIdpRequest())}_linkToIdToken(e,n){return Hs(e,this._buildIdpRequest(n))}_getReauthenticationResolver(e){return Hs(e,this._buildIdpRequest())}_buildIdpRequest(e){const n={requestUri:this.params.requestUri,sessionId:this.params.sessionId,postBody:this.params.postBody,tenantId:this.params.tenantId,pendingToken:this.params.pendingToken,returnSecureToken:!0,returnIdpCredential:!0};return e&&(n.idToken=e),n}}function lV(t){return $F(t.auth,new n_(t),t.bypassAuthState)}function uV(t){const{auth:e,user:n}=t;return se(n,e,"internal-error"),BF(n,new n_(t),t.bypassAuthState)}async function cV(t){const{auth:e,user:n}=t;return se(n,e,"internal-error"),zF(n,new n_(t),t.bypassAuthState)}/**
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
 */class N1{constructor(e,n,r,i,s=!1){this.auth=e,this.resolver=r,this.user=i,this.bypassAuthState=s,this.pendingPromise=null,this.eventManager=null,this.filter=Array.isArray(n)?n:[n]}execute(){return new Promise(async(e,n)=>{this.pendingPromise={resolve:e,reject:n};try{this.eventManager=await this.resolver._initialize(this.auth),await this.onExecution(),this.eventManager.registerConsumer(this)}catch(r){this.reject(r)}})}async onAuthEvent(e){const{urlResponse:n,sessionId:r,postBody:i,tenantId:s,error:o,type:a}=e;if(o){this.reject(o);return}const u={auth:this.auth,requestUri:n,sessionId:r,tenantId:s||void 0,postBody:i||void 0,user:this.user,bypassAuthState:this.bypassAuthState};try{this.resolve(await this.getIdpTask(a)(u))}catch(c){this.reject(c)}}onError(e){this.reject(e)}getIdpTask(e){switch(e){case"signInViaPopup":case"signInViaRedirect":return lV;case"linkViaPopup":case"linkViaRedirect":return cV;case"reauthViaPopup":case"reauthViaRedirect":return uV;default:kr(this.auth,"internal-error")}}resolve(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.resolve(e),this.unregisterAndCleanUp()}reject(e){Cr(this.pendingPromise,"Pending promise was never set"),this.pendingPromise.reject(e),this.unregisterAndCleanUp()}unregisterAndCleanUp(){this.eventManager&&this.eventManager.unregisterConsumer(this),this.pendingPromise=null,this.cleanUp()}}/**
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
 */const hV=new bl(2e3,1e4);class Os extends N1{constructor(e,n,r,i,s){super(e,n,i,s),this.provider=r,this.authWindow=null,this.pollId=null,Os.currentPopupAction&&Os.currentPopupAction.cancel(),Os.currentPopupAction=this}async executeNotNull(){const e=await this.execute();return se(e,this.auth,"internal-error"),e}async onExecution(){Cr(this.filter.length===1,"Popup operations only handle one event");const e=t_();this.authWindow=await this.resolver._openPopup(this.auth,this.provider,this.filter[0],e),this.authWindow.associatedEvent=e,this.resolver._originValidation(this.auth).catch(n=>{this.reject(n)}),this.resolver._isIframeWebStorageSupported(this.auth,n=>{n||this.reject(Yn(this.auth,"web-storage-unsupported"))}),this.pollUserCancellation()}get eventId(){var e;return((e=this.authWindow)===null||e===void 0?void 0:e.associatedEvent)||null}cancel(){this.reject(Yn(this.auth,"cancelled-popup-request"))}cleanUp(){this.authWindow&&this.authWindow.close(),this.pollId&&window.clearTimeout(this.pollId),this.authWindow=null,this.pollId=null,Os.currentPopupAction=null}pollUserCancellation(){const e=()=>{var n,r;if(!((r=(n=this.authWindow)===null||n===void 0?void 0:n.window)===null||r===void 0)&&r.closed){this.pollId=window.setTimeout(()=>{this.pollId=null,this.reject(Yn(this.auth,"popup-closed-by-user"))},8e3);return}this.pollId=window.setTimeout(e,hV.get())};e()}}Os.currentPopupAction=null;/**
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
 */const dV="pendingRedirect",Qu=new Map;class fV extends N1{constructor(e,n,r=!1){super(e,["signInViaRedirect","linkViaRedirect","reauthViaRedirect","unknown"],n,void 0,r),this.eventId=null}async execute(){let e=Qu.get(this.auth._key());if(!e){try{const r=await pV(this.resolver,this.auth)?await super.execute():null;e=()=>Promise.resolve(r)}catch(n){e=()=>Promise.reject(n)}Qu.set(this.auth._key(),e)}return this.bypassAuthState||Qu.set(this.auth._key(),()=>Promise.resolve(null)),e()}async onAuthEvent(e){if(e.type==="signInViaRedirect")return super.onAuthEvent(e);if(e.type==="unknown"){this.resolve(null);return}if(e.eventId){const n=await this.auth._redirectUserForId(e.eventId);if(n)return this.user=n,super.onAuthEvent(e);this.resolve(null)}}async onExecution(){}cleanUp(){}}async function pV(t,e){const n=_V(e),r=gV(t);if(!await r._isAvailable())return!1;const i=await r._get(n)==="true";return await r._remove(n),i}function mV(t,e){Qu.set(t._key(),e)}function gV(t){return hr(t._redirectPersistence)}function _V(t){return Ku(dV,t.config.apiKey,t.name)}async function yV(t,e,n=!1){if(ar(t.app))return Promise.reject(oi(t));const r=Vh(t),i=aV(r,e),o=await new fV(r,i,n).execute();return o&&!n&&(delete o.user._redirectEventId,await r._persistUserIfCurrent(o.user),await r._setRedirectUser(null,e)),o}/**
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
 */const vV=10*60*1e3;class wV{constructor(e){this.auth=e,this.cachedEventUids=new Set,this.consumers=new Set,this.queuedRedirectEvent=null,this.hasHandledPotentialRedirect=!1,this.lastProcessedEventTime=Date.now()}registerConsumer(e){this.consumers.add(e),this.queuedRedirectEvent&&this.isEventForConsumer(this.queuedRedirectEvent,e)&&(this.sendToConsumer(this.queuedRedirectEvent,e),this.saveEventToCache(this.queuedRedirectEvent),this.queuedRedirectEvent=null)}unregisterConsumer(e){this.consumers.delete(e)}onEvent(e){if(this.hasEventBeenHandled(e))return!1;let n=!1;return this.consumers.forEach(r=>{this.isEventForConsumer(e,r)&&(n=!0,this.sendToConsumer(e,r),this.saveEventToCache(e))}),this.hasHandledPotentialRedirect||!EV(e)||(this.hasHandledPotentialRedirect=!0,n||(this.queuedRedirectEvent=e,n=!0)),n}sendToConsumer(e,n){var r;if(e.error&&!D1(e)){const i=((r=e.error.code)===null||r===void 0?void 0:r.split("auth/")[1])||"internal-error";n.onError(Yn(this.auth,i))}else n.onAuthEvent(e)}isEventForConsumer(e,n){const r=n.eventId===null||!!e.eventId&&e.eventId===n.eventId;return n.filter.includes(e.type)&&r}hasEventBeenHandled(e){return Date.now()-this.lastProcessedEventTime>=vV&&this.cachedEventUids.clear(),this.cachedEventUids.has(hw(e))}saveEventToCache(e){this.cachedEventUids.add(hw(e)),this.lastProcessedEventTime=Date.now()}}function hw(t){return[t.type,t.eventId,t.sessionId,t.tenantId].filter(e=>e).join("-")}function D1({type:t,error:e}){return t==="unknown"&&(e==null?void 0:e.code)==="auth/no-auth-event"}function EV(t){switch(t.type){case"signInViaRedirect":case"linkViaRedirect":case"reauthViaRedirect":return!0;case"unknown":return D1(t);default:return!1}}/**
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
 */async function TV(t,e={}){return Ro(t,"GET","/v1/projects",e)}/**
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
 */const IV=/^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/,SV=/^https?/;async function kV(t){if(t.config.emulator)return;const{authorizedDomains:e}=await TV(t);for(const n of e)try{if(CV(n))return}catch{}kr(t,"unauthorized-domain")}function CV(t){const e=Np(),{protocol:n,hostname:r}=new URL(e);if(t.startsWith("chrome-extension://")){const o=new URL(t);return o.hostname===""&&r===""?n==="chrome-extension:"&&t.replace("chrome-extension://","")===e.replace("chrome-extension://",""):n==="chrome-extension:"&&o.hostname===r}if(!SV.test(n))return!1;if(IV.test(t))return r===t;const i=t.replace(/\./g,"\\.");return new RegExp("^(.+\\."+i+"|"+i+")$","i").test(r)}/**
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
 */const RV=new bl(3e4,6e4);function dw(){const t=Xn().___jsl;if(t!=null&&t.H){for(const e of Object.keys(t.H))if(t.H[e].r=t.H[e].r||[],t.H[e].L=t.H[e].L||[],t.H[e].r=[...t.H[e].L],t.CP)for(let n=0;n<t.CP.length;n++)t.CP[n]=null}}function xV(t){return new Promise((e,n)=>{var r,i,s;function o(){dw(),gapi.load("gapi.iframes",{callback:()=>{e(gapi.iframes.getContext())},ontimeout:()=>{dw(),n(Yn(t,"network-request-failed"))},timeout:RV.get()})}if(!((i=(r=Xn().gapi)===null||r===void 0?void 0:r.iframes)===null||i===void 0)&&i.Iframe)e(gapi.iframes.getContext());else if(!((s=Xn().gapi)===null||s===void 0)&&s.load)o();else{const a=NF("iframefcb");return Xn()[a]=()=>{gapi.load?o():n(Yn(t,"network-request-failed"))},PF(`${bF()}?onload=${a}`).catch(u=>n(u))}}).catch(e=>{throw Yu=null,e})}let Yu=null;function AV(t){return Yu=Yu||xV(t),Yu}/**
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
 */const PV=new bl(5e3,15e3),bV="__/auth/iframe",NV="emulator/auth/iframe",DV={style:{position:"absolute",top:"-100px",width:"1px",height:"1px"},"aria-hidden":"true",tabindex:"-1"},OV=new Map([["identitytoolkit.googleapis.com","p"],["staging-identitytoolkit.sandbox.googleapis.com","s"],["test-identitytoolkit.sandbox.googleapis.com","t"]]);function MV(t){const e=t.config;se(e.authDomain,t,"auth-domain-config-required");const n=e.emulator?Xg(e,NV):`https://${t.config.authDomain}/${bV}`,r={apiKey:e.apiKey,appName:t.name,v:yi},i=OV.get(t.config.apiHost);i&&(r.eid=i);const s=t._getFrameworks();return s.length&&(r.fw=s.join(",")),`${n}?${_o(r).slice(1)}`}async function LV(t){const e=await AV(t),n=Xn().gapi;return se(n,t,"internal-error"),e.open({where:document.body,url:MV(t),messageHandlersFilter:n.iframes.CROSS_ORIGIN_IFRAMES_FILTER,attributes:DV,dontclear:!0},r=>new Promise(async(i,s)=>{await r.restyle({setHideOnLeave:!1});const o=Yn(t,"network-request-failed"),a=Xn().setTimeout(()=>{s(o)},PV.get());function u(){Xn().clearTimeout(a),i(r)}r.ping(u).then(u,()=>{s(o)})}))}/**
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
 */const FV={location:"yes",resizable:"yes",statusbar:"yes",toolbar:"no"},VV=500,UV=600,jV="_blank",zV="http://localhost";class fw{constructor(e){this.window=e,this.associatedEvent=null}close(){if(this.window)try{this.window.close()}catch{}}}function BV(t,e,n,r=VV,i=UV){const s=Math.max((window.screen.availHeight-i)/2,0).toString(),o=Math.max((window.screen.availWidth-r)/2,0).toString();let a="";const u=Object.assign(Object.assign({},FV),{width:r.toString(),height:i.toString(),top:s,left:o}),c=Vt().toLowerCase();n&&(a=f1(c)?jV:n),h1(c)&&(e=e||zV,u.scrollbars="yes");const h=Object.entries(u).reduce((m,[w,S])=>`${m}${w}=${S},`,"");if(TF(c)&&a!=="_self")return $V(e||"",a),new fw(null);const f=window.open(e||"",a,h);se(f,t,"popup-blocked");try{f.focus()}catch{}return new fw(f)}function $V(t,e){const n=document.createElement("a");n.href=t,n.target=e;const r=document.createEvent("MouseEvent");r.initMouseEvent("click",!0,!0,window,1,0,0,0,0,!1,!1,!1,!1,1,null),n.dispatchEvent(r)}/**
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
 */const WV="__/auth/handler",qV="emulator/auth/handler",HV=encodeURIComponent("fac");async function pw(t,e,n,r,i,s){se(t.config.authDomain,t,"auth-domain-config-required"),se(t.config.apiKey,t,"invalid-api-key");const o={apiKey:t.config.apiKey,appName:t.name,authType:n,redirectUrl:r,v:yi,eventId:i};if(e instanceof T1){e.setDefaultLanguage(t.languageCode),o.providerId=e.providerId||"",Yf(e.getCustomParameters())||(o.customParameters=JSON.stringify(e.getCustomParameters()));for(const[h,f]of Object.entries({}))o[h]=f}if(e instanceof Nl){const h=e.getScopes().filter(f=>f!=="");h.length>0&&(o.scopes=h.join(","))}t.tenantId&&(o.tid=t.tenantId);const a=o;for(const h of Object.keys(a))a[h]===void 0&&delete a[h];const u=await t._getAppCheckToken(),c=u?`#${HV}=${encodeURIComponent(u)}`:"";return`${GV(t)}?${_o(a).slice(1)}${c}`}function GV({config:t}){return t.emulator?Xg(t,qV):`https://${t.authDomain}/${WV}`}/**
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
 */const Zd="webStorageSupport";class KV{constructor(){this.eventManagers={},this.iframes={},this.originValidationPromises={},this._redirectPersistence=R1,this._completeRedirectFn=yV,this._overrideRedirectResult=mV}async _openPopup(e,n,r,i){var s;Cr((s=this.eventManagers[e._key()])===null||s===void 0?void 0:s.manager,"_initialize() not called before _openPopup()");const o=await pw(e,n,r,Np(),i);return BV(e,o,t_())}async _openRedirect(e,n,r,i){await this._originValidation(e);const s=await pw(e,n,r,Np(),i);return XF(s),new Promise(()=>{})}_initialize(e){const n=e._key();if(this.eventManagers[n]){const{manager:i,promise:s}=this.eventManagers[n];return i?Promise.resolve(i):(Cr(s,"If manager is not set, promise should be"),s)}const r=this.initAndGetManager(e);return this.eventManagers[n]={promise:r},r.catch(()=>{delete this.eventManagers[n]}),r}async initAndGetManager(e){const n=await LV(e),r=new wV(e);return n.register("authEvent",i=>(se(i==null?void 0:i.authEvent,e,"invalid-auth-event"),{status:r.onEvent(i.authEvent)?"ACK":"ERROR"}),gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER),this.eventManagers[e._key()]={manager:r},this.iframes[e._key()]=n,r}_isIframeWebStorageSupported(e,n){this.iframes[e._key()].send(Zd,{type:Zd},i=>{var s;const o=(s=i==null?void 0:i[0])===null||s===void 0?void 0:s[Zd];o!==void 0&&n(!!o),kr(e,"internal-error")},gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER)}_originValidation(e){const n=e._key();return this.originValidationPromises[n]||(this.originValidationPromises[n]=kV(e)),this.originValidationPromises[n]}get _shouldInitProactively(){return y1()||d1()||Zg()}}const QV=KV;var mw="@firebase/auth",gw="1.7.9";/**
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
 */class YV{constructor(e){this.auth=e,this.internalListeners=new Map}getUid(){var e;return this.assertAuthConfigured(),((e=this.auth.currentUser)===null||e===void 0?void 0:e.uid)||null}async getToken(e){return this.assertAuthConfigured(),await this.auth._initializationPromise,this.auth.currentUser?{accessToken:await this.auth.currentUser.getIdToken(e)}:null}addAuthTokenListener(e){if(this.assertAuthConfigured(),this.internalListeners.has(e))return;const n=this.auth.onIdTokenChanged(r=>{e((r==null?void 0:r.stsTokenManager.accessToken)||null)});this.internalListeners.set(e,n),this.updateProactiveRefresh()}removeAuthTokenListener(e){this.assertAuthConfigured();const n=this.internalListeners.get(e);n&&(this.internalListeners.delete(e),n(),this.updateProactiveRefresh())}assertAuthConfigured(){se(this.auth._initializationPromise,"dependent-sdk-initialized-before-auth")}updateProactiveRefresh(){this.internalListeners.size>0?this.auth._startProactiveRefresh():this.auth._stopProactiveRefresh()}}/**
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
 */function XV(t){switch(t){case"Node":return"node";case"ReactNative":return"rn";case"Worker":return"webworker";case"Cordova":return"cordova";case"WebExtension":return"web-extension";default:return}}function JV(t){ui(new vr("auth",(e,{options:n})=>{const r=e.getProvider("app").getImmediate(),i=e.getProvider("heartbeat"),s=e.getProvider("app-check-internal"),{apiKey:o,authDomain:a}=r.options;se(o&&!o.includes(":"),"invalid-api-key",{appName:r.name});const u={apiKey:o,authDomain:a,clientPlatform:t,apiHost:"identitytoolkit.googleapis.com",tokenApiHost:"securetoken.googleapis.com",apiScheme:"https",sdkClientVersion:v1(t)},c=new xF(r,i,s,u);return OF(c,n),c},"PUBLIC").setInstantiationMode("EXPLICIT").setInstanceCreatedCallback((e,n,r)=>{e.getProvider("auth-internal").initialize()})),ui(new vr("auth-internal",e=>{const n=Vh(e.getProvider("auth").getImmediate());return(r=>new YV(r))(n)},"PRIVATE").setInstantiationMode("EXPLICIT")),wn(mw,gw,XV(t)),wn(mw,gw,"esm2017")}/**
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
 */const ZV=5*60,e4=HT("authIdTokenMaxAge")||ZV;let _w=null;const t4=t=>async e=>{const n=e&&await e.getIdTokenResult(),r=n&&(new Date().getTime()-Date.parse(n.issuedAtTime))/1e3;if(r&&r>e4)return;const i=n==null?void 0:n.token;_w!==i&&(_w=i,await fetch(t,{method:i?"POST":"DELETE",headers:i?{Authorization:`Bearer ${i}`}:{}}))};function n4(t=_h()){const e=vl(t,"auth");if(e.isInitialized())return e.getImmediate();const n=DF(t,{popupRedirectResolver:QV,persistence:[oV,KF,R1]}),r=HT("authTokenSyncURL");if(r&&typeof isSecureContext=="boolean"&&isSecureContext){const s=new URL(r,location.origin);if(location.origin===s.origin){const o=t4(s.toString());qF(n,o,()=>o(n.currentUser)),WF(n,a=>o(a))}}const i=WT("auth");return i&&MF(n,`http://${i}`),n}function r4(){var t,e;return(e=(t=document.getElementsByTagName("head"))===null||t===void 0?void 0:t[0])!==null&&e!==void 0?e:document}AF({loadJS(t){return new Promise((e,n)=>{const r=document.createElement("script");r.setAttribute("src",t),r.onload=e,r.onerror=i=>{const s=Yn("internal-error");s.customData=i,n(s)},r.type="text/javascript",r.charset="UTF-8",r4().appendChild(r)})},gapiScript:"https://apis.google.com/js/api.js",recaptchaV2Script:"https://www.google.com/recaptcha/api.js",recaptchaEnterpriseScript:"https://www.google.com/recaptcha/enterprise.js?render="});JV("Browser");const Da={apiKey:"AIzaSyC0sUtQ-SsE-IazJNg9AwP-JmQ_xJMR1iY",authDomain:"book-store-bec15.firebaseapp.com",databaseURL:"https://book-store-bec15-default-rtdb.firebaseio.com",projectId:"book-store-bec15",storageBucket:"book-store-bec15.firebasestorage.app",messagingSenderId:"1096744232990",appId:"1:1096744232990:web:186080c3ec42ad7a33660f",measurementId:"G-8YSJN6PWZT"},zh=XT(Da),i4=n4(zh),ef=N2(zh),yw=mO(zh),tf=rF(zh);function s4({activeTab:t,setActiveTab:e,bookCount:n,onOpenRules:r}){return g.jsx("header",{style:{position:"sticky",top:0,zIndex:50,backdropFilter:"blur(20px)",WebkitBackdropFilter:"blur(20px)",background:"rgba(9, 13, 22, 0.85)",borderBottom:"1px solid rgba(255, 255, 255, 0.08)",padding:"0.85rem 2rem"},children:g.jsxs("div",{style:{maxWidth:1280,margin:"0 auto",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx("div",{style:{width:42,height:42,borderRadius:12,background:"linear-gradient(135deg, #6366f1, #a855f7)",display:"flex",alignItems:"center",justifyContent:"center",boxShadow:"0 0 20px rgba(99, 102, 241, 0.4)"},children:g.jsx(to,{size:22,color:"#ffffff"})}),g.jsxs("div",{children:[g.jsx("div",{style:{fontSize:"1.25rem",fontWeight:800,letterSpacing:"-0.02em",background:"linear-gradient(to right, #ffffff, #c7d2fe)",WebkitBackgroundClip:"text",WebkitTextFillColor:"transparent"},children:"AudioBook Studio"}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#64748b"},children:"Firebase Markdown Publishing Portal"})]})]}),g.jsxs("div",{style:{display:"flex",background:"rgba(255, 255, 255, 0.04)",padding:"4px",borderRadius:"12px",border:"1px solid rgba(255, 255, 255, 0.06)"},children:[g.jsxs("button",{onClick:()=>e("upload"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="upload"?"var(--accent-primary)":"transparent",color:t==="upload"?"#ffffff":"var(--text-muted)"},children:[g.jsx(Pm,{size:16}),"Upload & Parse"]}),g.jsxs("button",{onClick:()=>e("library"),style:{display:"flex",alignItems:"center",gap:"0.5rem",padding:"0.5rem 1.1rem",borderRadius:"8px",border:"none",cursor:"pointer",fontWeight:600,fontSize:"0.88rem",transition:"all 0.2s",background:t==="library"?"var(--accent-primary)":"transparent",color:t==="library"?"#ffffff":"var(--text-muted)"},children:[g.jsx(nA,{size:16}),"Library",typeof n=="number"&&g.jsx("span",{style:{background:t==="library"?"rgba(255,255,255,0.25)":"rgba(255,255,255,0.1)",padding:"1px 7px",borderRadius:"9999px",fontSize:"0.75rem",marginLeft:4},children:n})]})]}),g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx("button",{onClick:r,className:"btn-secondary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",color:"#f87171",borderColor:"rgba(239, 68, 68, 0.3)"},title:"Setup Firebase Storage & Firestore Rules",children:"Fix Rules / Permissions"}),g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.6rem",background:"rgba(16, 185, 129, 0.1)",border:"1px solid rgba(16, 185, 129, 0.25)",padding:"0.4rem 0.85rem",borderRadius:"9999px",fontSize:"0.78rem",color:"#6ee7b7"},children:[g.jsx("span",{style:{width:8,height:8,borderRadius:"50%",background:"#10b981",boxShadow:"0 0 10px #10b981"}}),g.jsxs("span",{children:["Firebase: ",g.jsx("strong",{children:Da.projectId})]})]})]})]})})}function o4(t,e=""){if(!t)return{title:e.replace(/\.(md|markdown|txt|pdf)$/i,"").replace(/_/g," "),subtitle:"",author:"",translator:"",tagline:"",totalWords:0,estimatedMinutes:1};const n=t.split(/\r?\n/);let r="",i="",s="",o="",a="";const u=e.replace(/\.(md|markdown|txt|pdf)$/i,"").replace(/_/g," "),c=n.find(D=>/^#\s+(.+)/.test(D));c?r=c.replace(/^#\s+/,"").trim():r=u;const h=n.find(D=>/^\s*[\*_]\((.+)\)[\*_]\s*$/.test(D)||/^\s*[\*_]([^\*_]+)[\*_]\s*$/.test(D));if(h){const D=h.match(/[\*_]\(?([^\*\_\(\)]+)\)?[\*_]/);D&&(i=D[1].trim())}const f=t.match(/\*\*(?:মূল\s*লেখক|লেখক|Author|Written By)\s*:\*\*\s*([^\n\r]+)/i);f&&(s=f[1].trim());const m=t.match(/\*\*(?:অনুবাদক\s*ও\s*সংকলক|অনুবাদক|সংকলক|Translator|Compiled By)\s*:\*\*\s*([^\n\r]+)/i);m&&(o=m[1].trim());const w=t.match(/\n\*\*([^\*:\n]{8,80})\*\*\s*\n/);w&&(!f||!f[0].includes(w[1]))&&(a=w[1].trim());const S=a4(t),P=Math.max(1,Math.ceil(S/140));return{title:r||u,subtitle:i,author:s,translator:o,tagline:a,totalWords:S,estimatedMinutes:P}}function a4(t){return t?t.trim().split(/\s+/).filter(n=>n.length>0).length:0}function l4(t){if(!t)return`book-${Date.now()}`;const e=t.toLowerCase().replace(/[^\w\s-]/g,"").trim().replace(/\s+/g,"-");return e.length>2?`${e}-${Date.now().toString().slice(-4)}`:`book-${Date.now()}`}function Gs(t){if(!t||t===0)return"0 B";const e=1024,n=["B","KB","MB","GB"],r=Math.floor(Math.log(t)/Math.log(e));return parseFloat((t/Math.pow(e,r)).toFixed(1))+" "+n[r]}function vw(t){if(!t||typeof t!="string")return"";const e=t.trim(),n=e.match(/\/file\/d\/([a-zA-Z0-9_-]+)/);if(n&&n[1])return`https://drive.google.com/uc?export=download&id=${n[1]}`;const r=e.match(/[?&]id=([a-zA-Z0-9_-]+)/);return e.includes("drive.google.com")&&r&&r[1]?`https://drive.google.com/uc?export=download&id=${r[1]}`:e}function u4({onProceedToReview:t,onParsedBook:e,onShowToast:n}){const[r,i]=ie.useState(null),[s,o]=ie.useState(""),[a,u]=ie.useState(null),[c,h]=ie.useState(""),[f,m]=ie.useState(null),[w,S]=ie.useState(""),[P,D]=ie.useState(null),[k,T]=ie.useState(null),[R,M]=ie.useState("Personal Finance & Business"),[z,U]=ie.useState("Bangla"),[v,_]=ie.useState(""),[E,I]=ie.useState(!1),A=ie.useRef(null),b=ie.useRef(null),C=ie.useRef(null),Xe=ie.useRef(null),Ne=F=>{!F||F.length===0||(Array.from(F).forEach(W=>{const K=W.name.toLowerCase();if(K.endsWith(".pdf"))m(W);else if(K.match(/\.(jpg|jpeg|png|webp)$/))D(W),T(URL.createObjectURL(W));else if(K.endsWith(".md")||K.endsWith(".markdown")||K.endsWith(".txt")){const Z=new FileReader;Z.onload=Y=>{const re=Y.target.result;K.includes("summary")||!r?(i(W),o(re)):(u(W),h(re))},Z.readAsText(W)}}),n({type:"info",title:"Files Processed",message:`Attached ${F.length} file(s). Review slots below.`}))},Ut=F=>{if(!F)return;i(F);const W=new FileReader;W.onload=K=>o(K.target.result),W.readAsText(F)},gt=F=>{if(!F)return;u(F);const W=new FileReader;W.onload=K=>h(K.target.result),W.readAsText(F)},H=F=>{if(F){if(!F.name.toLowerCase().endsWith(".pdf")){n({type:"error",title:"Invalid File",message:"Please choose a .pdf document."});return}m(F)}},te=F=>{F&&(D(F),T(URL.createObjectURL(F)))},N=()=>{const F=`# ধনী বাবা গরীব বাবা
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

[এখানে সম্পূর্ণ বইয়ের বিস্তারিত বাংলা অনুবাদ সংকলিত হয়েছে...]`,K=new Blob([F],{type:"text/markdown"}),Z=new Blob([W],{type:"text/markdown"}),Y=new Blob(["%PDF-1.4 sample pdf placeholder"],{type:"application/pdf"});i(new File([K],"Rich_Dad_Poor_Dad_Summary.md",{type:"text/markdown"})),o(F),u(new File([Z],"Rich_Dad_Poor_Dad_Full_Book.md",{type:"text/markdown"})),h(W),m(new File([Y],"Rich_Dad_Poor_Dad_Bangla_Full.pdf",{type:"application/pdf"})),n({type:"info",title:"Sample Files Loaded",message:"Attached sample Summary.md, Full Book.md, and PDF."})},x=()=>{if(!r&&!a&&!f&&!w.trim()){n({type:"error",title:"Missing Files or Link",message:"Please upload at least a Summary .md, Full Book .md, or provide a PDF file/Drive link."});return}const F=s||c||"",W=(r==null?void 0:r.name)||(a==null?void 0:a.name)||(f==null?void 0:f.name)||(w?"Book_From_Drive.pdf":""),K=o4(F,W),Z=t||e;Z&&Z({...K,summaryFile:r,summaryText:s,fullBookFile:a,fullBookText:c,pdfFile:f,pdfDriveUrl:w.trim(),coverFile:P,coverPreview:k,category:R,language:z,audioUrl:v})},$=r||a||f||w.trim();return g.jsxs("div",{style:{maxWidth:960,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.75rem"},children:[g.jsx("div",{className:"glass-panel",style:{padding:"2rem",position:"relative",overflow:"hidden"},children:g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"flex-start",flexWrap:"wrap",gap:"1rem"},children:[g.jsxs("div",{children:[g.jsxs("span",{className:"badge badge-indigo",style:{marginBottom:"0.75rem"},children:[g.jsx(mv,{size:12})," Direct Firebase Storage & Firestore Link"]}),g.jsx("h1",{style:{fontSize:"1.85rem",marginBottom:"0.5rem"},children:"Upload Book Files (Summary .md, Full .md, PDF)"}),g.jsxs("p",{style:{color:"var(--text-muted)",fontSize:"0.92rem",maxWidth:620,lineHeight:1.6},children:["Upload your ",g.jsx("strong",{children:"Summary Markdown"}),", ",g.jsx("strong",{children:"Full Book Markdown"}),", and ",g.jsx("strong",{children:"PDF"})," files directly into Firebase Storage. Book metadata and secure download links will be stored in Cloud Firestore (no chapter text in the database)."]})]}),g.jsxs("button",{type:"button",onClick:N,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[g.jsx(mv,{size:16,color:"#a855f7"})," Load Sample Files"]})]})}),g.jsxs("div",{className:`dropzone ${E?"active":""}`,onDragOver:F=>{F.preventDefault(),I(!0)},onDragLeave:()=>I(!1),onDrop:F=>{F.preventDefault(),I(!1),Ne(F.dataTransfer.files)},children:[g.jsx("div",{style:{width:60,height:60,borderRadius:16,background:"rgba(99, 102, 241, 0.12)",display:"flex",alignItems:"center",justifyContent:"center",margin:"0 auto 1rem",border:"1px solid rgba(99, 102, 241, 0.3)"},children:g.jsx(Pm,{size:30,color:"#6366f1"})}),g.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.4rem"},children:"Drag & Drop all book files together here"}),g.jsxs("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem",marginBottom:"1.25rem"},children:["Drop your ",g.jsx("strong",{children:".md summary"}),", ",g.jsx("strong",{children:".md full book"}),", ",g.jsx("strong",{children:".pdf"}),", and ",g.jsx("strong",{children:"cover image"}),". The uploader will automatically place each in its dedicated slot."]}),g.jsxs("div",{style:{display:"flex",justifyContent:"center",gap:"0.75rem",flexWrap:"wrap"},children:[g.jsx("span",{style:{fontSize:"0.8rem",color:"#a5b4fc",background:"rgba(99, 102, 241, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(99,102,241,0.2)"},children:"📝 Summary .md"}),g.jsx("span",{style:{fontSize:"0.8rem",color:"#c084fc",background:"rgba(168, 85, 247, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(168,85,247,0.2)"},children:"📖 Full Book .md"}),g.jsx("span",{style:{fontSize:"0.8rem",color:"#f87171",background:"rgba(239, 68, 68, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(239,68,68,0.2)"},children:"📕 PDF Document"}),g.jsx("span",{style:{fontSize:"0.8rem",color:"#34d399",background:"rgba(16, 185, 129, 0.1)",padding:"4px 10px",borderRadius:6,border:"1px solid rgba(16,185,129,0.2)"},children:"🖼️ Cover Image"})]})]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(280px, 1fr))",gap:"1.25rem"},children:[g.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:r?"1px solid rgba(99, 102, 241, 0.5)":"1px solid var(--border-subtle)"},children:[g.jsxs("div",{children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#a5b4fc"},children:[g.jsx(Ec,{size:18})," 1. Summary Markdown (.md)"]}),r&&g.jsx(Ns,{size:18,color:"#10b981"})]}),g.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Short summary or chapter notes script in markdown format."}),r?g.jsxs("div",{style:{background:"rgba(99, 102, 241, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(99, 102, 241, 0.2)"},children:[g.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:r.name}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:Gs(r.size)})]}):g.jsx("div",{style:{padding:"1rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem"},children:"No summary file selected"})]}),g.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[g.jsx("input",{type:"file",ref:A,accept:".md,.markdown,.txt",style:{display:"none"},onChange:F=>{var W;return Ut((W=F.target.files)==null?void 0:W[0])}}),g.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=A.current)==null?void 0:F.click()},children:r?"Change Summary":"Select Summary .md"}),r&&g.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>{i(null),o("")},children:g.jsx(ca,{size:14})})]})]}),g.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:a?"1px solid rgba(168, 85, 247, 0.5)":"1px solid var(--border-subtle)"},children:[g.jsxs("div",{children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#c084fc"},children:[g.jsx(to,{size:18})," 2. Full Book Markdown (.md)"]}),a&&g.jsx(Ns,{size:18,color:"#10b981"})]}),g.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Optional complete book manuscript or full translation in markdown."}),a?g.jsxs("div",{style:{background:"rgba(168, 85, 247, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(168, 85, 247, 0.2)"},children:[g.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:a.name}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:Gs(a.size)})]}):g.jsx("div",{style:{padding:"1rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem"},children:"No full book file selected"})]}),g.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[g.jsx("input",{type:"file",ref:b,accept:".md,.markdown,.txt",style:{display:"none"},onChange:F=>{var W;return gt((W=F.target.files)==null?void 0:W[0])}}),g.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=b.current)==null?void 0:F.click()},children:a?"Change Full Book":"Select Full .md"}),a&&g.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>{u(null),h("")},children:g.jsx(ca,{size:14})})]})]}),g.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",border:f||w?"1px solid rgba(239, 68, 68, 0.5)":"1px solid var(--border-subtle)"},children:[g.jsxs("div",{children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"0.75rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#f87171"},children:[g.jsx(bm,{size:18})," 3. PDF Book Document (.pdf or Drive Link)"]}),(f||w)&&g.jsx(Ns,{size:18,color:"#10b981"})]}),g.jsx("p",{style:{fontSize:"0.8rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:"Upload local PDF or paste a Google Drive / Web PDF link."}),f?g.jsxs("div",{style:{background:"rgba(239, 68, 68, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(239, 68, 68, 0.2)",marginBottom:"0.75rem"},children:[g.jsx("div",{style:{fontWeight:600,fontSize:"0.85rem",color:"#f8fafc",wordBreak:"break-all"},children:f.name}),g.jsxs("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:2},children:[Gs(f.size)," (Local file ready to upload)"]})]}):w?g.jsxs("div",{style:{background:"rgba(16, 185, 129, 0.08)",padding:"0.75rem",borderRadius:8,border:"1px solid rgba(16, 185, 129, 0.25)",marginBottom:"0.75rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.4rem",fontWeight:600,fontSize:"0.82rem",color:"#34d399"},children:[g.jsx(ju,{size:14})," PDF Drive Link Added"]}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",marginTop:3,wordBreak:"break-all"},children:w})]}):g.jsx("div",{style:{padding:"0.75rem",textAlign:"center",border:"1px dashed var(--border-subtle)",borderRadius:8,color:"#64748b",fontSize:"0.82rem",marginBottom:"0.75rem"},children:"No PDF file or Drive link provided"}),g.jsxs("div",{style:{marginTop:"0.5rem"},children:[g.jsxs("label",{style:{display:"flex",alignItems:"center",gap:"0.35rem",fontSize:"0.75rem",fontWeight:600,color:"var(--text-muted)",marginBottom:"0.35rem"},children:[g.jsx(ju,{size:13,color:"#f87171"})," Google Drive or PDF Link:"]}),g.jsxs("div",{style:{display:"flex",gap:"0.35rem"},children:[g.jsx("input",{type:"url",className:"input-field",style:{fontSize:"0.8rem",padding:"0.45rem 0.65rem"},placeholder:"https://drive.google.com/file/d/...",value:w,onChange:F=>S(F.target.value)}),w&&g.jsx("button",{type:"button",className:"btn-secondary",style:{padding:"0.45rem 0.65rem",color:"#ef4444"},onClick:()=>S(""),title:"Clear link",children:g.jsx(ca,{size:13})})]})]})]}),g.jsxs("div",{style:{display:"flex",gap:"0.5rem",marginTop:"0.5rem"},children:[g.jsx("input",{type:"file",ref:C,accept:".pdf",style:{display:"none"},onChange:F=>{var W;return H((W=F.target.files)==null?void 0:W[0])}}),g.jsx("button",{type:"button",className:"btn-secondary",style:{flex:1,fontSize:"0.82rem",padding:"0.5rem"},onClick:()=>{var F;return(F=C.current)==null?void 0:F.click()},children:f?"Change File":"Or Pick File (.pdf)"}),f&&g.jsx("button",{type:"button",className:"btn-secondary",style:{color:"#ef4444",padding:"0.5rem 0.75rem"},onClick:()=>m(null),children:g.jsx(ca,{size:14})})]})]})]}),g.jsxs("div",{className:"glass-panel",style:{padding:"1.75rem"},children:[g.jsxs("h4",{style:{fontSize:"1.05rem",marginBottom:"1.25rem",display:"flex",alignItems:"center",gap:"0.5rem"},children:[g.jsx(VT,{size:18,color:"#818cf8"})," Book Settings, Cover & Audio Stream"]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(240px, 1fr))",gap:"1.25rem"},children:[g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Language"}),g.jsxs("select",{className:"input-field",value:z,onChange:F=>U(F.target.value),children:[g.jsx("option",{value:"Bangla",children:"বাংলা (Bangla)"}),g.jsx("option",{value:"English",children:"English"}),g.jsx("option",{value:"Hindi",children:"Hindi"}),g.jsx("option",{value:"Other",children:"Other"})]})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Category"}),g.jsxs("select",{className:"input-field",value:R,onChange:F=>M(F.target.value),children:[g.jsx("option",{value:"Personal Finance & Business",children:"Personal Finance & Business"}),g.jsx("option",{value:"Self Improvement",children:"Self Improvement"}),g.jsx("option",{value:"Psychology & Mindset",children:"Psychology & Mindset"}),g.jsx("option",{value:"Productivity & Habits",children:"Productivity & Habits"}),g.jsx("option",{value:"Biographies & History",children:"Biographies & History"}),g.jsx("option",{value:"Fiction & Literature",children:"Fiction & Literature"})]})]}),g.jsxs("div",{style:{gridColumn:"1 / -1"},children:[g.jsx("label",{className:"input-label",children:"Audio Stream / MP3 URL (Optional)"}),g.jsx("input",{type:"url",className:"input-field",placeholder:"https://domain.com/audiobook.mp3",value:v,onChange:F=>_(F.target.value)})]}),g.jsxs("div",{children:[g.jsxs("label",{className:"input-label",style:{display:"flex",alignItems:"center",gap:"0.4rem"},children:[g.jsx(ju,{size:14,color:"#f87171"})," Google Drive / PDF Download URL"]}),g.jsx("input",{type:"url",className:"input-field",placeholder:"https://drive.google.com/file/d/...",value:w,onChange:F=>S(F.target.value)})]}),g.jsxs("div",{style:{gridColumn:"1 / -1"},children:[g.jsx("label",{className:"input-label",children:"Book Cover Image (Optional)"}),g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1.25rem",flexWrap:"wrap"},children:[g.jsx("input",{type:"file",ref:Xe,accept:"image/*",style:{display:"none"},onChange:F=>{var W;return te((W=F.target.files)==null?void 0:W[0])}}),g.jsxs("button",{type:"button",className:"btn-secondary",onClick:()=>{var F;return(F=Xe.current)==null?void 0:F.click()},children:[g.jsx(tA,{size:16})," Choose Cover Image"]}),k&&g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx("img",{src:k,alt:"Cover Preview",style:{width:44,height:58,objectFit:"cover",borderRadius:6,border:"1px solid var(--border-accent)"}}),g.jsxs("span",{style:{fontSize:"0.85rem",color:"#10b981"},children:[g.jsx(Ns,{size:14,style:{display:"inline",verticalAlign:"middle",marginRight:4}}),P==null?void 0:P.name]})]})]})]})]})]}),g.jsx("div",{style:{display:"flex",justifyContent:"flex-end"},children:g.jsxs("button",{type:"button",onClick:x,disabled:!$,className:"btn-primary",style:{padding:"0.85rem 2rem",fontSize:"1rem"},children:[g.jsx("span",{children:"Continue to Review & Upload"}),g.jsx(Qx,{size:18})]})})]})}function r_(){return{async:!1,breaks:!1,extensions:null,gfm:!0,hooks:null,pedantic:!1,renderer:null,silent:!1,tokenizer:null,walkTokens:null}}let as=r_();function O1(t){as=t}const M1=/[&<>"']/,c4=new RegExp(M1.source,"g"),L1=/[<>"']|&(?!(#\d{1,7}|#[Xx][a-fA-F0-9]{1,6}|\w+);)/,h4=new RegExp(L1.source,"g"),d4={"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"},ww=t=>d4[t];function sn(t,e){if(e){if(M1.test(t))return t.replace(c4,ww)}else if(L1.test(t))return t.replace(h4,ww);return t}const f4=/(^|[^\[])\^/g;function xe(t,e){let n=typeof t=="string"?t:t.source;e=e||"";const r={replace:(i,s)=>{let o=typeof s=="string"?s:s.source;return o=o.replace(f4,"$1"),n=n.replace(i,o),r},getRegex:()=>new RegExp(n,e)};return r}function Ew(t){try{t=encodeURI(t).replace(/%25/g,"%")}catch{return null}return t}const Oa={exec:()=>null};function Tw(t,e){const n=t.replace(/\|/g,(s,o,a)=>{let u=!1,c=o;for(;--c>=0&&a[c]==="\\";)u=!u;return u?"|":" |"}),r=n.split(/ \|/);let i=0;if(r[0].trim()||r.shift(),r.length>0&&!r[r.length-1].trim()&&r.pop(),e)if(r.length>e)r.splice(e);else for(;r.length<e;)r.push("");for(;i<r.length;i++)r[i]=r[i].trim().replace(/\\\|/g,"|");return r}function ia(t,e,n){const r=t.length;if(r===0)return"";let i=0;for(;i<r&&t.charAt(r-i-1)===e;)i++;return t.slice(0,r-i)}function p4(t,e){if(t.indexOf(e[1])===-1)return-1;let n=0;for(let r=0;r<t.length;r++)if(t[r]==="\\")r++;else if(t[r]===e[0])n++;else if(t[r]===e[1]&&(n--,n<0))return r;return-1}function Iw(t,e,n,r){const i=e.href,s=e.title?sn(e.title):null,o=t[1].replace(/\\([\[\]])/g,"$1");if(t[0].charAt(0)!=="!"){r.state.inLink=!0;const a={type:"link",raw:n,href:i,title:s,text:o,tokens:r.inlineTokens(o)};return r.state.inLink=!1,a}return{type:"image",raw:n,href:i,title:s,text:sn(o)}}function m4(t,e){const n=t.match(/^(\s+)(?:```)/);if(n===null)return e;const r=n[1];return e.split(`
`).map(i=>{const s=i.match(/^\s+/);if(s===null)return i;const[o]=s;return o.length>=r.length?i.slice(r.length):i}).join(`
`)}class Kc{constructor(e){Pe(this,"options");Pe(this,"rules");Pe(this,"lexer");this.options=e||as}space(e){const n=this.rules.block.newline.exec(e);if(n&&n[0].length>0)return{type:"space",raw:n[0]}}code(e){const n=this.rules.block.code.exec(e);if(n){const r=n[0].replace(/^(?: {1,4}| {0,3}\t)/gm,"");return{type:"code",raw:n[0],codeBlockStyle:"indented",text:this.options.pedantic?r:ia(r,`
`)}}}fences(e){const n=this.rules.block.fences.exec(e);if(n){const r=n[0],i=m4(r,n[3]||"");return{type:"code",raw:r,lang:n[2]?n[2].trim().replace(this.rules.inline.anyPunctuation,"$1"):n[2],text:i}}}heading(e){const n=this.rules.block.heading.exec(e);if(n){let r=n[2].trim();if(/#$/.test(r)){const i=ia(r,"#");(this.options.pedantic||!i||/ $/.test(i))&&(r=i.trim())}return{type:"heading",raw:n[0],depth:n[1].length,text:r,tokens:this.lexer.inline(r)}}}hr(e){const n=this.rules.block.hr.exec(e);if(n)return{type:"hr",raw:ia(n[0],`
`)}}blockquote(e){const n=this.rules.block.blockquote.exec(e);if(n){let r=ia(n[0],`
`).split(`
`),i="",s="";const o=[];for(;r.length>0;){let a=!1;const u=[];let c;for(c=0;c<r.length;c++)if(/^ {0,3}>/.test(r[c]))u.push(r[c]),a=!0;else if(!a)u.push(r[c]);else break;r=r.slice(c);const h=u.join(`
`),f=h.replace(/\n {0,3}((?:=+|-+) *)(?=\n|$)/g,`
    $1`).replace(/^ {0,3}>[ \t]?/gm,"");i=i?`${i}
${h}`:h,s=s?`${s}
${f}`:f;const m=this.lexer.state.top;if(this.lexer.state.top=!0,this.lexer.blockTokens(f,o,!0),this.lexer.state.top=m,r.length===0)break;const w=o[o.length-1];if((w==null?void 0:w.type)==="code")break;if((w==null?void 0:w.type)==="blockquote"){const S=w,P=S.raw+`
`+r.join(`
`),D=this.blockquote(P);o[o.length-1]=D,i=i.substring(0,i.length-S.raw.length)+D.raw,s=s.substring(0,s.length-S.text.length)+D.text;break}else if((w==null?void 0:w.type)==="list"){const S=w,P=S.raw+`
`+r.join(`
`),D=this.list(P);o[o.length-1]=D,i=i.substring(0,i.length-w.raw.length)+D.raw,s=s.substring(0,s.length-S.raw.length)+D.raw,r=P.substring(o[o.length-1].raw.length).split(`
`);continue}}return{type:"blockquote",raw:i,tokens:o,text:s}}}list(e){let n=this.rules.block.list.exec(e);if(n){let r=n[1].trim();const i=r.length>1,s={type:"list",raw:"",ordered:i,start:i?+r.slice(0,-1):"",loose:!1,items:[]};r=i?`\\d{1,9}\\${r.slice(-1)}`:`\\${r}`,this.options.pedantic&&(r=i?r:"[*+-]");const o=new RegExp(`^( {0,3}${r})((?:[	 ][^\\n]*)?(?:\\n|$))`);let a=!1;for(;e;){let u=!1,c="",h="";if(!(n=o.exec(e))||this.rules.block.hr.test(e))break;c=n[0],e=e.substring(c.length);let f=n[2].split(`
`,1)[0].replace(/^\t+/,k=>" ".repeat(3*k.length)),m=e.split(`
`,1)[0],w=!f.trim(),S=0;if(this.options.pedantic?(S=2,h=f.trimStart()):w?S=n[1].length+1:(S=n[2].search(/[^ ]/),S=S>4?1:S,h=f.slice(S),S+=n[1].length),w&&/^[ \t]*$/.test(m)&&(c+=m+`
`,e=e.substring(m.length+1),u=!0),!u){const k=new RegExp(`^ {0,${Math.min(3,S-1)}}(?:[*+-]|\\d{1,9}[.)])((?:[ 	][^\\n]*)?(?:\\n|$))`),T=new RegExp(`^ {0,${Math.min(3,S-1)}}((?:- *){3,}|(?:_ *){3,}|(?:\\* *){3,})(?:\\n+|$)`),R=new RegExp(`^ {0,${Math.min(3,S-1)}}(?:\`\`\`|~~~)`),M=new RegExp(`^ {0,${Math.min(3,S-1)}}#`),z=new RegExp(`^ {0,${Math.min(3,S-1)}}<(?:[a-z].*>|!--)`,"i");for(;e;){const U=e.split(`
`,1)[0];let v;if(m=U,this.options.pedantic?(m=m.replace(/^ {1,4}(?=( {4})*[^ ])/g,"  "),v=m):v=m.replace(/\t/g,"    "),R.test(m)||M.test(m)||z.test(m)||k.test(m)||T.test(m))break;if(v.search(/[^ ]/)>=S||!m.trim())h+=`
`+v.slice(S);else{if(w||f.replace(/\t/g,"    ").search(/[^ ]/)>=4||R.test(f)||M.test(f)||T.test(f))break;h+=`
`+m}!w&&!m.trim()&&(w=!0),c+=U+`
`,e=e.substring(U.length+1),f=v.slice(S)}}s.loose||(a?s.loose=!0:/\n[ \t]*\n[ \t]*$/.test(c)&&(a=!0));let P=null,D;this.options.gfm&&(P=/^\[[ xX]\] /.exec(h),P&&(D=P[0]!=="[ ] ",h=h.replace(/^\[[ xX]\] +/,""))),s.items.push({type:"list_item",raw:c,task:!!P,checked:D,loose:!1,text:h,tokens:[]}),s.raw+=c}s.items[s.items.length-1].raw=s.items[s.items.length-1].raw.trimEnd(),s.items[s.items.length-1].text=s.items[s.items.length-1].text.trimEnd(),s.raw=s.raw.trimEnd();for(let u=0;u<s.items.length;u++)if(this.lexer.state.top=!1,s.items[u].tokens=this.lexer.blockTokens(s.items[u].text,[]),!s.loose){const c=s.items[u].tokens.filter(f=>f.type==="space"),h=c.length>0&&c.some(f=>/\n.*\n/.test(f.raw));s.loose=h}if(s.loose)for(let u=0;u<s.items.length;u++)s.items[u].loose=!0;return s}}html(e){const n=this.rules.block.html.exec(e);if(n)return{type:"html",block:!0,raw:n[0],pre:n[1]==="pre"||n[1]==="script"||n[1]==="style",text:n[0]}}def(e){const n=this.rules.block.def.exec(e);if(n){const r=n[1].toLowerCase().replace(/\s+/g," "),i=n[2]?n[2].replace(/^<(.*)>$/,"$1").replace(this.rules.inline.anyPunctuation,"$1"):"",s=n[3]?n[3].substring(1,n[3].length-1).replace(this.rules.inline.anyPunctuation,"$1"):n[3];return{type:"def",tag:r,raw:n[0],href:i,title:s}}}table(e){const n=this.rules.block.table.exec(e);if(!n||!/[:|]/.test(n[2]))return;const r=Tw(n[1]),i=n[2].replace(/^\||\| *$/g,"").split("|"),s=n[3]&&n[3].trim()?n[3].replace(/\n[ \t]*$/,"").split(`
`):[],o={type:"table",raw:n[0],header:[],align:[],rows:[]};if(r.length===i.length){for(const a of i)/^ *-+: *$/.test(a)?o.align.push("right"):/^ *:-+: *$/.test(a)?o.align.push("center"):/^ *:-+ *$/.test(a)?o.align.push("left"):o.align.push(null);for(let a=0;a<r.length;a++)o.header.push({text:r[a],tokens:this.lexer.inline(r[a]),header:!0,align:o.align[a]});for(const a of s)o.rows.push(Tw(a,o.header.length).map((u,c)=>({text:u,tokens:this.lexer.inline(u),header:!1,align:o.align[c]})));return o}}lheading(e){const n=this.rules.block.lheading.exec(e);if(n)return{type:"heading",raw:n[0],depth:n[2].charAt(0)==="="?1:2,text:n[1],tokens:this.lexer.inline(n[1])}}paragraph(e){const n=this.rules.block.paragraph.exec(e);if(n){const r=n[1].charAt(n[1].length-1)===`
`?n[1].slice(0,-1):n[1];return{type:"paragraph",raw:n[0],text:r,tokens:this.lexer.inline(r)}}}text(e){const n=this.rules.block.text.exec(e);if(n)return{type:"text",raw:n[0],text:n[0],tokens:this.lexer.inline(n[0])}}escape(e){const n=this.rules.inline.escape.exec(e);if(n)return{type:"escape",raw:n[0],text:sn(n[1])}}tag(e){const n=this.rules.inline.tag.exec(e);if(n)return!this.lexer.state.inLink&&/^<a /i.test(n[0])?this.lexer.state.inLink=!0:this.lexer.state.inLink&&/^<\/a>/i.test(n[0])&&(this.lexer.state.inLink=!1),!this.lexer.state.inRawBlock&&/^<(pre|code|kbd|script)(\s|>)/i.test(n[0])?this.lexer.state.inRawBlock=!0:this.lexer.state.inRawBlock&&/^<\/(pre|code|kbd|script)(\s|>)/i.test(n[0])&&(this.lexer.state.inRawBlock=!1),{type:"html",raw:n[0],inLink:this.lexer.state.inLink,inRawBlock:this.lexer.state.inRawBlock,block:!1,text:n[0]}}link(e){const n=this.rules.inline.link.exec(e);if(n){const r=n[2].trim();if(!this.options.pedantic&&/^</.test(r)){if(!/>$/.test(r))return;const o=ia(r.slice(0,-1),"\\");if((r.length-o.length)%2===0)return}else{const o=p4(n[2],"()");if(o>-1){const u=(n[0].indexOf("!")===0?5:4)+n[1].length+o;n[2]=n[2].substring(0,o),n[0]=n[0].substring(0,u).trim(),n[3]=""}}let i=n[2],s="";if(this.options.pedantic){const o=/^([^'"]*[^\s])\s+(['"])(.*)\2/.exec(i);o&&(i=o[1],s=o[3])}else s=n[3]?n[3].slice(1,-1):"";return i=i.trim(),/^</.test(i)&&(this.options.pedantic&&!/>$/.test(r)?i=i.slice(1):i=i.slice(1,-1)),Iw(n,{href:i&&i.replace(this.rules.inline.anyPunctuation,"$1"),title:s&&s.replace(this.rules.inline.anyPunctuation,"$1")},n[0],this.lexer)}}reflink(e,n){let r;if((r=this.rules.inline.reflink.exec(e))||(r=this.rules.inline.nolink.exec(e))){const i=(r[2]||r[1]).replace(/\s+/g," "),s=n[i.toLowerCase()];if(!s){const o=r[0].charAt(0);return{type:"text",raw:o,text:o}}return Iw(r,s,r[0],this.lexer)}}emStrong(e,n,r=""){let i=this.rules.inline.emStrongLDelim.exec(e);if(!i||i[3]&&r.match(/[\p{L}\p{N}]/u))return;if(!(i[1]||i[2]||"")||!r||this.rules.inline.punctuation.exec(r)){const o=[...i[0]].length-1;let a,u,c=o,h=0;const f=i[0][0]==="*"?this.rules.inline.emStrongRDelimAst:this.rules.inline.emStrongRDelimUnd;for(f.lastIndex=0,n=n.slice(-1*e.length+o);(i=f.exec(n))!=null;){if(a=i[1]||i[2]||i[3]||i[4]||i[5]||i[6],!a)continue;if(u=[...a].length,i[3]||i[4]){c+=u;continue}else if((i[5]||i[6])&&o%3&&!((o+u)%3)){h+=u;continue}if(c-=u,c>0)continue;u=Math.min(u,u+c+h);const m=[...i[0]][0].length,w=e.slice(0,o+i.index+m+u);if(Math.min(o,u)%2){const P=w.slice(1,-1);return{type:"em",raw:w,text:P,tokens:this.lexer.inlineTokens(P)}}const S=w.slice(2,-2);return{type:"strong",raw:w,text:S,tokens:this.lexer.inlineTokens(S)}}}}codespan(e){const n=this.rules.inline.code.exec(e);if(n){let r=n[2].replace(/\n/g," ");const i=/[^ ]/.test(r),s=/^ /.test(r)&&/ $/.test(r);return i&&s&&(r=r.substring(1,r.length-1)),r=sn(r,!0),{type:"codespan",raw:n[0],text:r}}}br(e){const n=this.rules.inline.br.exec(e);if(n)return{type:"br",raw:n[0]}}del(e){const n=this.rules.inline.del.exec(e);if(n)return{type:"del",raw:n[0],text:n[2],tokens:this.lexer.inlineTokens(n[2])}}autolink(e){const n=this.rules.inline.autolink.exec(e);if(n){let r,i;return n[2]==="@"?(r=sn(n[1]),i="mailto:"+r):(r=sn(n[1]),i=r),{type:"link",raw:n[0],text:r,href:i,tokens:[{type:"text",raw:r,text:r}]}}}url(e){var r;let n;if(n=this.rules.inline.url.exec(e)){let i,s;if(n[2]==="@")i=sn(n[0]),s="mailto:"+i;else{let o;do o=n[0],n[0]=((r=this.rules.inline._backpedal.exec(n[0]))==null?void 0:r[0])??"";while(o!==n[0]);i=sn(n[0]),n[1]==="www."?s="http://"+n[0]:s=n[0]}return{type:"link",raw:n[0],text:i,href:s,tokens:[{type:"text",raw:i,text:i}]}}}inlineText(e){const n=this.rules.inline.text.exec(e);if(n){let r;return this.lexer.state.inRawBlock?r=n[0]:r=sn(n[0]),{type:"text",raw:n[0],text:r}}}}const g4=/^(?:[ \t]*(?:\n|$))+/,_4=/^((?: {4}| {0,3}\t)[^\n]+(?:\n(?:[ \t]*(?:\n|$))*)?)+/,y4=/^ {0,3}(`{3,}(?=[^`\n]*(?:\n|$))|~{3,})([^\n]*)(?:\n|$)(?:|([\s\S]*?)(?:\n|$))(?: {0,3}\1[~`]* *(?=\n|$)|$)/,Ol=/^ {0,3}((?:-[\t ]*){3,}|(?:_[ \t]*){3,}|(?:\*[ \t]*){3,})(?:\n+|$)/,v4=/^ {0,3}(#{1,6})(?=\s|$)(.*)(?:\n+|$)/,F1=/(?:[*+-]|\d{1,9}[.)])/,V1=xe(/^(?!bull |blockCode|fences|blockquote|heading|html)((?:.|\n(?!\s*?\n|bull |blockCode|fences|blockquote|heading|html))+?)\n {0,3}(=+|-+) *(?:\n+|$)/).replace(/bull/g,F1).replace(/blockCode/g,/(?: {4}| {0,3}\t)/).replace(/fences/g,/ {0,3}(?:`{3,}|~{3,})/).replace(/blockquote/g,/ {0,3}>/).replace(/heading/g,/ {0,3}#{1,6}/).replace(/html/g,/ {0,3}<[^\n>]+>\n/).getRegex(),i_=/^([^\n]+(?:\n(?!hr|heading|lheading|blockquote|fences|list|html|table| +\n)[^\n]+)*)/,w4=/^[^\n]+/,s_=/(?!\s*\])(?:\\.|[^\[\]\\])+/,E4=xe(/^ {0,3}\[(label)\]: *(?:\n[ \t]*)?([^<\s][^\s]*|<.*?>)(?:(?: +(?:\n[ \t]*)?| *\n[ \t]*)(title))? *(?:\n+|$)/).replace("label",s_).replace("title",/(?:"(?:\\"?|[^"\\])*"|'[^'\n]*(?:\n[^'\n]+)*\n?'|\([^()]*\))/).getRegex(),T4=xe(/^( {0,3}bull)([ \t][^\n]+?)?(?:\n|$)/).replace(/bull/g,F1).getRegex(),Bh="address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h[1-6]|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|search|section|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul",o_=/<!--(?:-?>|[\s\S]*?(?:-->|$))/,I4=xe("^ {0,3}(?:<(script|pre|style|textarea)[\\s>][\\s\\S]*?(?:</\\1>[^\\n]*\\n+|$)|comment[^\\n]*(\\n+|$)|<\\?[\\s\\S]*?(?:\\?>\\n*|$)|<![A-Z][\\s\\S]*?(?:>\\n*|$)|<!\\[CDATA\\[[\\s\\S]*?(?:\\]\\]>\\n*|$)|</?(tag)(?: +|\\n|/?>)[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|<(?!script|pre|style|textarea)([a-z][\\w-]*)(?:attribute)*? */?>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$)|</(?!script|pre|style|textarea)[a-z][\\w-]*\\s*>(?=[ \\t]*(?:\\n|$))[\\s\\S]*?(?:(?:\\n[ 	]*)+\\n|$))","i").replace("comment",o_).replace("tag",Bh).replace("attribute",/ +[a-zA-Z:_][\w.:-]*(?: *= *"[^"\n]*"| *= *'[^'\n]*'| *= *[^\s"'=<>`]+)?/).getRegex(),U1=xe(i_).replace("hr",Ol).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("|table","").replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Bh).getRegex(),S4=xe(/^( {0,3}> ?(paragraph|[^\n]*)(?:\n|$))+/).replace("paragraph",U1).getRegex(),a_={blockquote:S4,code:_4,def:E4,fences:y4,heading:v4,hr:Ol,html:I4,lheading:V1,list:T4,newline:g4,paragraph:U1,table:Oa,text:w4},Sw=xe("^ *([^\\n ].*)\\n {0,3}((?:\\| *)?:?-+:? *(?:\\| *:?-+:? *)*(?:\\| *)?)(?:\\n((?:(?! *\\n|hr|heading|blockquote|code|fences|list|html).*(?:\\n|$))*)\\n*|$)").replace("hr",Ol).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("blockquote"," {0,3}>").replace("code","(?: {4}| {0,3}	)[^\\n]").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Bh).getRegex(),k4={...a_,table:Sw,paragraph:xe(i_).replace("hr",Ol).replace("heading"," {0,3}#{1,6}(?:\\s|$)").replace("|lheading","").replace("table",Sw).replace("blockquote"," {0,3}>").replace("fences"," {0,3}(?:`{3,}(?=[^`\\n]*\\n)|~{3,})[^\\n]*\\n").replace("list"," {0,3}(?:[*+-]|1[.)]) ").replace("html","</?(?:tag)(?: +|\\n|/?>)|<(?:script|pre|style|textarea|!--)").replace("tag",Bh).getRegex()},C4={...a_,html:xe(`^ *(?:comment *(?:\\n|\\s*$)|<(tag)[\\s\\S]+?</\\1> *(?:\\n{2,}|\\s*$)|<tag(?:"[^"]*"|'[^']*'|\\s[^'"/>\\s]*)*?/?> *(?:\\n{2,}|\\s*$))`).replace("comment",o_).replace(/tag/g,"(?!(?:a|em|strong|small|s|cite|q|dfn|abbr|data|time|code|var|samp|kbd|sub|sup|i|b|u|mark|ruby|rt|rp|bdi|bdo|span|br|wbr|ins|del|img)\\b)\\w+(?!:|[^\\w\\s@]*@)\\b").getRegex(),def:/^ *\[([^\]]+)\]: *<?([^\s>]+)>?(?: +(["(][^\n]+[")]))? *(?:\n+|$)/,heading:/^(#{1,6})(.*)(?:\n+|$)/,fences:Oa,lheading:/^(.+?)\n {0,3}(=+|-+) *(?:\n+|$)/,paragraph:xe(i_).replace("hr",Ol).replace("heading",` *#{1,6} *[^
]`).replace("lheading",V1).replace("|table","").replace("blockquote"," {0,3}>").replace("|fences","").replace("|list","").replace("|html","").replace("|tag","").getRegex()},j1=/^\\([!"#$%&'()*+,\-./:;<=>?@\[\]\\^_`{|}~])/,R4=/^(`+)([^`]|[^`][\s\S]*?[^`])\1(?!`)/,z1=/^( {2,}|\\)\n(?!\s*$)/,x4=/^(`+|[^`])(?:(?= {2,}\n)|[\s\S]*?(?:(?=[\\<!\[`*_]|\b_|$)|[^ ](?= {2,}\n)))/,Ml="\\p{P}\\p{S}",A4=xe(/^((?![*_])[\spunctuation])/,"u").replace(/punctuation/g,Ml).getRegex(),P4=/\[[^[\]]*?\]\((?:\\.|[^\\\(\)]|\((?:\\.|[^\\\(\)])*\))*\)|`[^`]*?`|<[^<>]*?>/g,b4=xe(/^(?:\*+(?:((?!\*)[punct])|[^\s*]))|^_+(?:((?!_)[punct])|([^\s_]))/,"u").replace(/punct/g,Ml).getRegex(),N4=xe("^[^_*]*?__[^_*]*?\\*[^_*]*?(?=__)|[^*]+(?=[^*])|(?!\\*)[punct](\\*+)(?=[\\s]|$)|[^punct\\s](\\*+)(?!\\*)(?=[punct\\s]|$)|(?!\\*)[punct\\s](\\*+)(?=[^punct\\s])|[\\s](\\*+)(?!\\*)(?=[punct])|(?!\\*)[punct](\\*+)(?!\\*)(?=[punct])|[^punct\\s](\\*+)(?=[^punct\\s])","gu").replace(/punct/g,Ml).getRegex(),D4=xe("^[^_*]*?\\*\\*[^_*]*?_[^_*]*?(?=\\*\\*)|[^_]+(?=[^_])|(?!_)[punct](_+)(?=[\\s]|$)|[^punct\\s](_+)(?!_)(?=[punct\\s]|$)|(?!_)[punct\\s](_+)(?=[^punct\\s])|[\\s](_+)(?!_)(?=[punct])|(?!_)[punct](_+)(?!_)(?=[punct])","gu").replace(/punct/g,Ml).getRegex(),O4=xe(/\\([punct])/,"gu").replace(/punct/g,Ml).getRegex(),M4=xe(/^<(scheme:[^\s\x00-\x1f<>]*|email)>/).replace("scheme",/[a-zA-Z][a-zA-Z0-9+.-]{1,31}/).replace("email",/[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(@)[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)+(?![-_])/).getRegex(),L4=xe(o_).replace("(?:-->|$)","-->").getRegex(),F4=xe("^comment|^</[a-zA-Z][\\w:-]*\\s*>|^<[a-zA-Z][\\w-]*(?:attribute)*?\\s*/?>|^<\\?[\\s\\S]*?\\?>|^<![a-zA-Z]+\\s[\\s\\S]*?>|^<!\\[CDATA\\[[\\s\\S]*?\\]\\]>").replace("comment",L4).replace("attribute",/\s+[a-zA-Z:_][\w.:-]*(?:\s*=\s*"[^"]*"|\s*=\s*'[^']*'|\s*=\s*[^\s"'=<>`]+)?/).getRegex(),Qc=/(?:\[(?:\\.|[^\[\]\\])*\]|\\.|`[^`]*`|[^\[\]\\`])*?/,V4=xe(/^!?\[(label)\]\(\s*(href)(?:\s+(title))?\s*\)/).replace("label",Qc).replace("href",/<(?:\\.|[^\n<>\\])+>|[^\s\x00-\x1f]*/).replace("title",/"(?:\\"?|[^"\\])*"|'(?:\\'?|[^'\\])*'|\((?:\\\)?|[^)\\])*\)/).getRegex(),B1=xe(/^!?\[(label)\]\[(ref)\]/).replace("label",Qc).replace("ref",s_).getRegex(),$1=xe(/^!?\[(ref)\](?:\[\])?/).replace("ref",s_).getRegex(),U4=xe("reflink|nolink(?!\\()","g").replace("reflink",B1).replace("nolink",$1).getRegex(),l_={_backpedal:Oa,anyPunctuation:O4,autolink:M4,blockSkip:P4,br:z1,code:R4,del:Oa,emStrongLDelim:b4,emStrongRDelimAst:N4,emStrongRDelimUnd:D4,escape:j1,link:V4,nolink:$1,punctuation:A4,reflink:B1,reflinkSearch:U4,tag:F4,text:x4,url:Oa},j4={...l_,link:xe(/^!?\[(label)\]\((.*?)\)/).replace("label",Qc).getRegex(),reflink:xe(/^!?\[(label)\]\s*\[([^\]]*)\]/).replace("label",Qc).getRegex()},Mp={...l_,escape:xe(j1).replace("])","~|])").getRegex(),url:xe(/^((?:ftp|https?):\/\/|www\.)(?:[a-zA-Z0-9\-]+\.?)+[^\s<]*|^email/,"i").replace("email",/[A-Za-z0-9._+-]+(@)[a-zA-Z0-9-_]+(?:\.[a-zA-Z0-9-_]*[a-zA-Z0-9])+(?![-_])/).getRegex(),_backpedal:/(?:[^?!.,:;*_'"~()&]+|\([^)]*\)|&(?![a-zA-Z0-9]+;$)|[?!.,:;*_'"~)]+(?!$))+/,del:/^(~~?)(?=[^\s~])((?:\\.|[^\\])*?(?:\\.|[^\s~\\]))\1(?=[^~]|$)/,text:/^([`~]+|[^`~])(?:(?= {2,}\n)|(?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)|[\s\S]*?(?:(?=[\\<!\[`*~_]|\b_|https?:\/\/|ftp:\/\/|www\.|$)|[^ ](?= {2,}\n)|[^a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-](?=[a-zA-Z0-9.!#$%&'*+\/=?_`{\|}~-]+@)))/},z4={...Mp,br:xe(z1).replace("{2,}","*").getRegex(),text:xe(Mp.text).replace("\\b_","\\b_| {2,}\\n").replace(/\{2,\}/g,"*").getRegex()},Ru={normal:a_,gfm:k4,pedantic:C4},sa={normal:l_,gfm:Mp,breaks:z4,pedantic:j4};class _n{constructor(e){Pe(this,"tokens");Pe(this,"options");Pe(this,"state");Pe(this,"tokenizer");Pe(this,"inlineQueue");this.tokens=[],this.tokens.links=Object.create(null),this.options=e||as,this.options.tokenizer=this.options.tokenizer||new Kc,this.tokenizer=this.options.tokenizer,this.tokenizer.options=this.options,this.tokenizer.lexer=this,this.inlineQueue=[],this.state={inLink:!1,inRawBlock:!1,top:!0};const n={block:Ru.normal,inline:sa.normal};this.options.pedantic?(n.block=Ru.pedantic,n.inline=sa.pedantic):this.options.gfm&&(n.block=Ru.gfm,this.options.breaks?n.inline=sa.breaks:n.inline=sa.gfm),this.tokenizer.rules=n}static get rules(){return{block:Ru,inline:sa}}static lex(e,n){return new _n(n).lex(e)}static lexInline(e,n){return new _n(n).inlineTokens(e)}lex(e){e=e.replace(/\r\n|\r/g,`
`),this.blockTokens(e,this.tokens);for(let n=0;n<this.inlineQueue.length;n++){const r=this.inlineQueue[n];this.inlineTokens(r.src,r.tokens)}return this.inlineQueue=[],this.tokens}blockTokens(e,n=[],r=!1){this.options.pedantic&&(e=e.replace(/\t/g,"    ").replace(/^ +$/gm,""));let i,s,o;for(;e;)if(!(this.options.extensions&&this.options.extensions.block&&this.options.extensions.block.some(a=>(i=a.call({lexer:this},e,n))?(e=e.substring(i.raw.length),n.push(i),!0):!1))){if(i=this.tokenizer.space(e)){e=e.substring(i.raw.length),i.raw.length===1&&n.length>0?n[n.length-1].raw+=`
`:n.push(i);continue}if(i=this.tokenizer.code(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(i=this.tokenizer.fences(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.heading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.hr(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.blockquote(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.list(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.html(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.def(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&(s.type==="paragraph"||s.type==="text")?(s.raw+=`
`+i.raw,s.text+=`
`+i.raw,this.inlineQueue[this.inlineQueue.length-1].src=s.text):this.tokens.links[i.tag]||(this.tokens.links[i.tag]={href:i.href,title:i.title});continue}if(i=this.tokenizer.table(e)){e=e.substring(i.raw.length),n.push(i);continue}if(i=this.tokenizer.lheading(e)){e=e.substring(i.raw.length),n.push(i);continue}if(o=e,this.options.extensions&&this.options.extensions.startBlock){let a=1/0;const u=e.slice(1);let c;this.options.extensions.startBlock.forEach(h=>{c=h.call({lexer:this},u),typeof c=="number"&&c>=0&&(a=Math.min(a,c))}),a<1/0&&a>=0&&(o=e.substring(0,a+1))}if(this.state.top&&(i=this.tokenizer.paragraph(o))){s=n[n.length-1],r&&(s==null?void 0:s.type)==="paragraph"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i),r=o.length!==e.length,e=e.substring(i.raw.length);continue}if(i=this.tokenizer.text(e)){e=e.substring(i.raw.length),s=n[n.length-1],s&&s.type==="text"?(s.raw+=`
`+i.raw,s.text+=`
`+i.text,this.inlineQueue.pop(),this.inlineQueue[this.inlineQueue.length-1].src=s.text):n.push(i);continue}if(e){const a="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(a);break}else throw new Error(a)}}return this.state.top=!0,n}inline(e,n=[]){return this.inlineQueue.push({src:e,tokens:n}),n}inlineTokens(e,n=[]){let r,i,s,o=e,a,u,c;if(this.tokens.links){const h=Object.keys(this.tokens.links);if(h.length>0)for(;(a=this.tokenizer.rules.inline.reflinkSearch.exec(o))!=null;)h.includes(a[0].slice(a[0].lastIndexOf("[")+1,-1))&&(o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.reflinkSearch.lastIndex))}for(;(a=this.tokenizer.rules.inline.blockSkip.exec(o))!=null;)o=o.slice(0,a.index)+"["+"a".repeat(a[0].length-2)+"]"+o.slice(this.tokenizer.rules.inline.blockSkip.lastIndex);for(;(a=this.tokenizer.rules.inline.anyPunctuation.exec(o))!=null;)o=o.slice(0,a.index)+"++"+o.slice(this.tokenizer.rules.inline.anyPunctuation.lastIndex);for(;e;)if(u||(c=""),u=!1,!(this.options.extensions&&this.options.extensions.inline&&this.options.extensions.inline.some(h=>(r=h.call({lexer:this},e,n))?(e=e.substring(r.raw.length),n.push(r),!0):!1))){if(r=this.tokenizer.escape(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.tag(e)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.link(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.reflink(e,this.tokens.links)){e=e.substring(r.raw.length),i=n[n.length-1],i&&r.type==="text"&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(r=this.tokenizer.emStrong(e,o,c)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.codespan(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.br(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.del(e)){e=e.substring(r.raw.length),n.push(r);continue}if(r=this.tokenizer.autolink(e)){e=e.substring(r.raw.length),n.push(r);continue}if(!this.state.inLink&&(r=this.tokenizer.url(e))){e=e.substring(r.raw.length),n.push(r);continue}if(s=e,this.options.extensions&&this.options.extensions.startInline){let h=1/0;const f=e.slice(1);let m;this.options.extensions.startInline.forEach(w=>{m=w.call({lexer:this},f),typeof m=="number"&&m>=0&&(h=Math.min(h,m))}),h<1/0&&h>=0&&(s=e.substring(0,h+1))}if(r=this.tokenizer.inlineText(s)){e=e.substring(r.raw.length),r.raw.slice(-1)!=="_"&&(c=r.raw.slice(-1)),u=!0,i=n[n.length-1],i&&i.type==="text"?(i.raw+=r.raw,i.text+=r.text):n.push(r);continue}if(e){const h="Infinite loop on byte: "+e.charCodeAt(0);if(this.options.silent){console.error(h);break}else throw new Error(h)}}return n}}class Yc{constructor(e){Pe(this,"options");Pe(this,"parser");this.options=e||as}space(e){return""}code({text:e,lang:n,escaped:r}){var o;const i=(o=(n||"").match(/^\S*/))==null?void 0:o[0],s=e.replace(/\n$/,"")+`
`;return i?'<pre><code class="language-'+sn(i)+'">'+(r?s:sn(s,!0))+`</code></pre>
`:"<pre><code>"+(r?s:sn(s,!0))+`</code></pre>
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
`}strong({tokens:e}){return`<strong>${this.parser.parseInline(e)}</strong>`}em({tokens:e}){return`<em>${this.parser.parseInline(e)}</em>`}codespan({text:e}){return`<code>${e}</code>`}br(e){return"<br>"}del({tokens:e}){return`<del>${this.parser.parseInline(e)}</del>`}link({href:e,title:n,tokens:r}){const i=this.parser.parseInline(r),s=Ew(e);if(s===null)return i;e=s;let o='<a href="'+e+'"';return n&&(o+=' title="'+n+'"'),o+=">"+i+"</a>",o}image({href:e,title:n,text:r}){const i=Ew(e);if(i===null)return r;e=i;let s=`<img src="${e}" alt="${r}"`;return n&&(s+=` title="${n}"`),s+=">",s}text(e){return"tokens"in e&&e.tokens?this.parser.parseInline(e.tokens):e.text}}class u_{strong({text:e}){return e}em({text:e}){return e}codespan({text:e}){return e}del({text:e}){return e}html({text:e}){return e}text({text:e}){return e}link({text:e}){return""+e}image({text:e}){return""+e}br(){return""}}class yn{constructor(e){Pe(this,"options");Pe(this,"renderer");Pe(this,"textRenderer");this.options=e||as,this.options.renderer=this.options.renderer||new Yc,this.renderer=this.options.renderer,this.renderer.options=this.options,this.renderer.parser=this,this.textRenderer=new u_}static parse(e,n){return new yn(n).parse(e)}static parseInline(e,n){return new yn(n).parseInline(e)}parse(e,n=!0){let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=s,u=this.options.extensions.renderers[a.type].call({parser:this},a);if(u!==!1||!["space","hr","heading","code","table","blockquote","list","html","paragraph","text"].includes(a.type)){r+=u||"";continue}}const o=s;switch(o.type){case"space":{r+=this.renderer.space(o);continue}case"hr":{r+=this.renderer.hr(o);continue}case"heading":{r+=this.renderer.heading(o);continue}case"code":{r+=this.renderer.code(o);continue}case"table":{r+=this.renderer.table(o);continue}case"blockquote":{r+=this.renderer.blockquote(o);continue}case"list":{r+=this.renderer.list(o);continue}case"html":{r+=this.renderer.html(o);continue}case"paragraph":{r+=this.renderer.paragraph(o);continue}case"text":{let a=o,u=this.renderer.text(a);for(;i+1<e.length&&e[i+1].type==="text";)a=e[++i],u+=`
`+this.renderer.text(a);n?r+=this.renderer.paragraph({type:"paragraph",raw:u,text:u,tokens:[{type:"text",raw:u,text:u}]}):r+=u;continue}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}parseInline(e,n){n=n||this.renderer;let r="";for(let i=0;i<e.length;i++){const s=e[i];if(this.options.extensions&&this.options.extensions.renderers&&this.options.extensions.renderers[s.type]){const a=this.options.extensions.renderers[s.type].call({parser:this},s);if(a!==!1||!["escape","html","link","image","strong","em","codespan","br","del","text"].includes(s.type)){r+=a||"";continue}}const o=s;switch(o.type){case"escape":{r+=n.text(o);break}case"html":{r+=n.html(o);break}case"link":{r+=n.link(o);break}case"image":{r+=n.image(o);break}case"strong":{r+=n.strong(o);break}case"em":{r+=n.em(o);break}case"codespan":{r+=n.codespan(o);break}case"br":{r+=n.br(o);break}case"del":{r+=n.del(o);break}case"text":{r+=n.text(o);break}default:{const a='Token with "'+o.type+'" type was not found.';if(this.options.silent)return console.error(a),"";throw new Error(a)}}}return r}}class Ma{constructor(e){Pe(this,"options");Pe(this,"block");this.options=e||as}preprocess(e){return e}postprocess(e){return e}processAllTokens(e){return e}provideLexer(){return this.block?_n.lex:_n.lexInline}provideParser(){return this.block?yn.parse:yn.parseInline}}Pe(Ma,"passThroughHooks",new Set(["preprocess","postprocess","processAllTokens"]));class B4{constructor(...e){Pe(this,"defaults",r_());Pe(this,"options",this.setOptions);Pe(this,"parse",this.parseMarkdown(!0));Pe(this,"parseInline",this.parseMarkdown(!1));Pe(this,"Parser",yn);Pe(this,"Renderer",Yc);Pe(this,"TextRenderer",u_);Pe(this,"Lexer",_n);Pe(this,"Tokenizer",Kc);Pe(this,"Hooks",Ma);this.use(...e)}walkTokens(e,n){var i,s;let r=[];for(const o of e)switch(r=r.concat(n.call(this,o)),o.type){case"table":{const a=o;for(const u of a.header)r=r.concat(this.walkTokens(u.tokens,n));for(const u of a.rows)for(const c of u)r=r.concat(this.walkTokens(c.tokens,n));break}case"list":{const a=o;r=r.concat(this.walkTokens(a.items,n));break}default:{const a=o;(s=(i=this.defaults.extensions)==null?void 0:i.childTokens)!=null&&s[a.type]?this.defaults.extensions.childTokens[a.type].forEach(u=>{const c=a[u].flat(1/0);r=r.concat(this.walkTokens(c,n))}):a.tokens&&(r=r.concat(this.walkTokens(a.tokens,n)))}}return r}use(...e){const n=this.defaults.extensions||{renderers:{},childTokens:{}};return e.forEach(r=>{const i={...r};if(i.async=this.defaults.async||i.async||!1,r.extensions&&(r.extensions.forEach(s=>{if(!s.name)throw new Error("extension name required");if("renderer"in s){const o=n.renderers[s.name];o?n.renderers[s.name]=function(...a){let u=s.renderer.apply(this,a);return u===!1&&(u=o.apply(this,a)),u}:n.renderers[s.name]=s.renderer}if("tokenizer"in s){if(!s.level||s.level!=="block"&&s.level!=="inline")throw new Error("extension level must be 'block' or 'inline'");const o=n[s.level];o?o.unshift(s.tokenizer):n[s.level]=[s.tokenizer],s.start&&(s.level==="block"?n.startBlock?n.startBlock.push(s.start):n.startBlock=[s.start]:s.level==="inline"&&(n.startInline?n.startInline.push(s.start):n.startInline=[s.start]))}"childTokens"in s&&s.childTokens&&(n.childTokens[s.name]=s.childTokens)}),i.extensions=n),r.renderer){const s=this.defaults.renderer||new Yc(this.defaults);for(const o in r.renderer){if(!(o in s))throw new Error(`renderer '${o}' does not exist`);if(["options","parser"].includes(o))continue;const a=o,u=r.renderer[a],c=s[a];s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f||""}}i.renderer=s}if(r.tokenizer){const s=this.defaults.tokenizer||new Kc(this.defaults);for(const o in r.tokenizer){if(!(o in s))throw new Error(`tokenizer '${o}' does not exist`);if(["options","rules","lexer"].includes(o))continue;const a=o,u=r.tokenizer[a],c=s[a];s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f}}i.tokenizer=s}if(r.hooks){const s=this.defaults.hooks||new Ma;for(const o in r.hooks){if(!(o in s))throw new Error(`hook '${o}' does not exist`);if(["options","block"].includes(o))continue;const a=o,u=r.hooks[a],c=s[a];Ma.passThroughHooks.has(o)?s[a]=h=>{if(this.defaults.async)return Promise.resolve(u.call(s,h)).then(m=>c.call(s,m));const f=u.call(s,h);return c.call(s,f)}:s[a]=(...h)=>{let f=u.apply(s,h);return f===!1&&(f=c.apply(s,h)),f}}i.hooks=s}if(r.walkTokens){const s=this.defaults.walkTokens,o=r.walkTokens;i.walkTokens=function(a){let u=[];return u.push(o.call(this,a)),s&&(u=u.concat(s.call(this,a))),u}}this.defaults={...this.defaults,...i}}),this}setOptions(e){return this.defaults={...this.defaults,...e},this}lexer(e,n){return _n.lex(e,n??this.defaults)}parser(e,n){return yn.parse(e,n??this.defaults)}parseMarkdown(e){return(r,i)=>{const s={...i},o={...this.defaults,...s},a=this.onError(!!o.silent,!!o.async);if(this.defaults.async===!0&&s.async===!1)return a(new Error("marked(): The async option was set to true by an extension. Remove async: false from the parse options object to return a Promise."));if(typeof r>"u"||r===null)return a(new Error("marked(): input parameter is undefined or null"));if(typeof r!="string")return a(new Error("marked(): input parameter is of type "+Object.prototype.toString.call(r)+", string expected"));o.hooks&&(o.hooks.options=o,o.hooks.block=e);const u=o.hooks?o.hooks.provideLexer():e?_n.lex:_n.lexInline,c=o.hooks?o.hooks.provideParser():e?yn.parse:yn.parseInline;if(o.async)return Promise.resolve(o.hooks?o.hooks.preprocess(r):r).then(h=>u(h,o)).then(h=>o.hooks?o.hooks.processAllTokens(h):h).then(h=>o.walkTokens?Promise.all(this.walkTokens(h,o.walkTokens)).then(()=>h):h).then(h=>c(h,o)).then(h=>o.hooks?o.hooks.postprocess(h):h).catch(a);try{o.hooks&&(r=o.hooks.preprocess(r));let h=u(r,o);o.hooks&&(h=o.hooks.processAllTokens(h)),o.walkTokens&&this.walkTokens(h,o.walkTokens);let f=c(h,o);return o.hooks&&(f=o.hooks.postprocess(f)),f}catch(h){return a(h)}}}onError(e,n){return r=>{if(r.message+=`
Please report this to https://github.com/markedjs/marked.`,e){const i="<p>An error occurred:</p><pre>"+sn(r.message+"",!0)+"</pre>";return n?Promise.resolve(i):i}if(n)return Promise.reject(r);throw r}}}const Ji=new B4;function Ie(t,e){return Ji.parse(t,e)}Ie.options=Ie.setOptions=function(t){return Ji.setOptions(t),Ie.defaults=Ji.defaults,O1(Ie.defaults),Ie};Ie.getDefaults=r_;Ie.defaults=as;Ie.use=function(...t){return Ji.use(...t),Ie.defaults=Ji.defaults,O1(Ie.defaults),Ie};Ie.walkTokens=function(t,e){return Ji.walkTokens(t,e)};Ie.parseInline=Ji.parseInline;Ie.Parser=yn;Ie.parser=yn.parse;Ie.Renderer=Yc;Ie.TextRenderer=u_;Ie.Lexer=_n;Ie.lexer=_n.lex;Ie.Tokenizer=Kc;Ie.Hooks=Ma;Ie.parse=Ie;Ie.options;Ie.setOptions;Ie.use;Ie.walkTokens;Ie.parseInline;yn.parse;_n.lex;Ie.setOptions({gfm:!0,breaks:!0});function $4({bookData:t,onCancel:e,onUpload:n,isUploading:r,uploadProgress:i,uploadStage:s}){var A;const[o,a]=ie.useState("summary"),[u,c]=ie.useState(t.title||""),[h,f]=ie.useState(t.subtitle||""),[m,w]=ie.useState(t.author||""),[S,P]=ie.useState(t.translator||""),[D,k]=ie.useState(t.tagline||""),[T,R]=ie.useState(t.category||"Personal Finance & Business"),[M,z]=ie.useState(t.language||"Bangla"),[U,v]=ie.useState(t.audioUrl||""),[_,E]=ie.useState(t.pdfDriveUrl||""),I=()=>{n({...t,title:u,subtitle:h,author:m,translator:S,tagline:D,category:T,language:M,audioUrl:U,pdfDriveUrl:_})};return g.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[g.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem",display:"flex",alignItems:"center",justifyContent:"space-between",flexWrap:"wrap",gap:"1rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"1rem"},children:[g.jsxs("button",{onClick:e,disabled:r,className:"btn-secondary",style:{padding:"0.5rem 0.85rem"},children:[g.jsx(Kx,{size:16})," Back"]}),g.jsxs("div",{children:[g.jsx("div",{style:{fontSize:"0.8rem",color:"var(--text-muted)"},children:"Ready to Upload to Firebase"}),g.jsx("h2",{style:{fontSize:"1.4rem"},children:"Review Metadata & Attached Files"})]})]}),g.jsx("button",{onClick:I,disabled:r,className:"btn-primary",style:{minWidth:230,justifyContent:"center"},children:r?g.jsxs(g.Fragment,{children:[g.jsx(rA,{size:18,className:"animate-spin",style:{animation:"spin 1s linear infinite"}}),g.jsxs("span",{children:[i,"% Uploading..."]})]}):g.jsxs(g.Fragment,{children:[g.jsx(Pm,{size:18}),g.jsx("span",{children:"Publish to Firebase"})]})})]}),r&&g.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem",border:"1px solid var(--accent-primary)"},children:[g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",marginBottom:"0.5rem",fontSize:"0.85rem"},children:[g.jsx("span",{style:{color:"#a5b4fc",fontWeight:600},children:s||"Uploading files..."}),g.jsxs("span",{style:{color:"#f8fafc",fontWeight:700},children:[i,"%"]})]}),g.jsx("div",{style:{width:"100%",height:8,background:"rgba(255,255,255,0.1)",borderRadius:9999,overflow:"hidden"},children:g.jsx("div",{style:{width:`${i}%`,height:"100%",background:"var(--accent-gradient)",transition:"width 0.3s ease"}})})]}),g.jsxs("div",{className:"glass-panel",style:{padding:"1.25rem 1.75rem"},children:[g.jsx("h4",{style:{fontSize:"0.92rem",textTransform:"uppercase",letterSpacing:"0.05em",color:"var(--text-muted)",marginBottom:"0.85rem"},children:"Files Ready for Firebase Storage"}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(220px, 1fr))",gap:"0.85rem"},children:[g.jsxs("div",{style:{background:t.summaryFile?"rgba(99, 102, 241, 0.1)":"rgba(255,255,255,0.03)",border:t.summaryFile?"1px solid rgba(99, 102, 241, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx(Ec,{size:20,color:t.summaryFile?"#a5b4fc":"#64748b"}),g.jsxs("div",{children:[g.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.summaryFile?"#f8fafc":"#64748b"},children:"Summary Markdown"}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:t.summaryFile?`${t.summaryFile.name} (${Gs(t.summaryFile.size)})`:"Not provided"})]})]}),g.jsxs("div",{style:{background:t.fullBookFile?"rgba(168, 85, 247, 0.1)":"rgba(255,255,255,0.03)",border:t.fullBookFile?"1px solid rgba(168, 85, 247, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx(to,{size:20,color:t.fullBookFile?"#c084fc":"#64748b"}),g.jsxs("div",{children:[g.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.fullBookFile?"#f8fafc":"#64748b"},children:"Full Book Markdown"}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:t.fullBookFile?`${t.fullBookFile.name} (${Gs(t.fullBookFile.size)})`:"Not provided"})]})]}),g.jsxs("div",{style:{background:t.pdfFile||t.pdfDriveUrl?"rgba(239, 68, 68, 0.1)":"rgba(255,255,255,0.03)",border:t.pdfFile||t.pdfDriveUrl?"1px solid rgba(239, 68, 68, 0.3)":"1px solid var(--border-subtle)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx(bm,{size:20,color:t.pdfFile||t.pdfDriveUrl?"#f87171":"#64748b"}),g.jsxs("div",{style:{overflow:"hidden"},children:[g.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:t.pdfFile||t.pdfDriveUrl?"#f8fafc":"#64748b"},children:"PDF Document"}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8",textOverflow:"ellipsis",overflow:"hidden",whiteSpace:"nowrap"},children:t.pdfFile?`${t.pdfFile.name} (${Gs(t.pdfFile.size)})`:t.pdfDriveUrl?"Google Drive / PDF Link Provided":"Not provided"})]})]}),t.coverPreview&&g.jsxs("div",{style:{background:"rgba(16, 185, 129, 0.1)",border:"1px solid rgba(16, 185, 129, 0.3)",borderRadius:10,padding:"0.75rem 1rem",display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx("img",{src:t.coverPreview,alt:"Cover",style:{width:28,height:38,objectFit:"cover",borderRadius:4}}),g.jsxs("div",{children:[g.jsx("div",{style:{fontSize:"0.82rem",fontWeight:600,color:"#f8fafc"},children:"Cover Image"}),g.jsx("div",{style:{fontSize:"0.75rem",color:"#94a3b8"},children:(A=t.coverFile)==null?void 0:A.name})]})]})]})]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(320px, 1fr))",gap:"1.5rem",alignItems:"start"},children:[g.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:[g.jsx(iA,{size:18,color:"#818cf8"}),g.jsx("h3",{style:{fontSize:"1.1rem"},children:"Firestore Metadata Fields"})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Book Title"}),g.jsx("input",{type:"text",className:"input-field",value:u,onChange:b=>c(b.target.value),placeholder:"e.g. ধনী বাবা গরীব বাবা"})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Subtitle / Description"}),g.jsx("input",{type:"text",className:"input-field",value:h,onChange:b=>f(b.target.value),placeholder:"e.g. বইয়ের পূর্ণাঙ্গ বাংলা সারসংক্ষেপ"})]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.75rem"},children:[g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Original Author"}),g.jsx("input",{type:"text",className:"input-field",value:m,onChange:b=>w(b.target.value),placeholder:"e.g. রবার্ট টি. কিওসাকি"})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Translator / Compiler"}),g.jsx("input",{type:"text",className:"input-field",value:S,onChange:b=>P(b.target.value),placeholder:"e.g. মোঃ আবির আহমেদ"})]})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Tagline / Key Takeaway"}),g.jsx("input",{type:"text",className:"input-field",value:D,onChange:b=>k(b.target.value),placeholder:"e.g. আর্থিক স্বাধীনতার এক অনবদ্য নির্দেশিকা"})]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.75rem"},children:[g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Category"}),g.jsx("input",{type:"text",className:"input-field",value:T,onChange:b=>R(b.target.value)})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Language"}),g.jsx("input",{type:"text",className:"input-field",value:M,onChange:b=>z(b.target.value)})]})]}),g.jsxs("div",{children:[g.jsx("label",{className:"input-label",children:"Audio Stream Link (MP3)"}),g.jsx("input",{type:"url",className:"input-field",value:U,onChange:b=>v(b.target.value),placeholder:"https://domain.com/audio.mp3"})]}),g.jsxs("div",{children:[g.jsxs("label",{className:"input-label",style:{display:"flex",alignItems:"center",gap:"0.35rem"},children:[g.jsx(ju,{size:13,color:"#f87171"}),g.jsx("span",{children:"Google Drive / Web PDF Link"})]}),g.jsx("input",{type:"url",className:"input-field",value:_,onChange:b=>E(b.target.value),placeholder:"https://drive.google.com/file/d/.../view or direct PDF URL"}),g.jsx("span",{style:{fontSize:"0.73rem",color:"var(--text-muted)",marginTop:"0.2rem",display:"block"},children:"Used for reading / downloading PDF if no local .pdf file was uploaded."})]})]}),g.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem",display:"flex",flexDirection:"column",gap:"1rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",borderBottom:"1px solid var(--border-subtle)",paddingBottom:"0.75rem"},children:[g.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[t.summaryText&&g.jsxs("button",{onClick:()=>a("summary"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="summary"?"var(--accent-primary)":"transparent",color:o==="summary"?"#fff":"var(--text-muted)"},children:[g.jsx(Ec,{size:14})," Summary Preview"]}),t.fullBookText&&g.jsxs("button",{onClick:()=>a("full"),className:"btn-secondary",style:{padding:"0.4rem 0.8rem",fontSize:"0.82rem",background:o==="full"?"var(--accent-primary)":"transparent",color:o==="full"?"#fff":"var(--text-muted)"},children:[g.jsx(to,{size:14})," Full Book Preview"]})]}),g.jsx("span",{style:{fontSize:"0.78rem",color:"#94a3b8"},children:o==="summary"?`${t.totalWords||0} words`:"Full Content"})]}),g.jsx("div",{className:"markdown-preview",style:{background:"rgba(15, 23, 42, 0.6)",borderRadius:"12px",padding:"1.5rem",border:"1px solid var(--border-subtle)",maxHeight:520,overflowY:"auto"},dangerouslySetInnerHTML:{__html:Ie.parse(o==="summary"?t.summaryText||"":t.fullBookText||"")}})]})]})]})}function W4({books:t,loading:e,onRefresh:n,onDeleteBook:r}){const[i,s]=ie.useState(""),[o,a]=ie.useState("All"),u=t.filter(h=>{const f=(h.title||"").toLowerCase().includes(i.toLowerCase())||(h.author||"").toLowerCase().includes(i.toLowerCase())||(h.translator||"").toLowerCase().includes(i.toLowerCase()),m=o==="All"||h.category===o;return f&&m}),c=["All",...new Set(t.map(h=>h.category).filter(Boolean))];return g.jsxs("div",{style:{maxWidth:1100,margin:"0 auto",display:"flex",flexDirection:"column",gap:"1.5rem"},children:[g.jsxs("div",{className:"glass-panel",style:{padding:"1.5rem 2rem"},children:[g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem",marginBottom:"1.25rem"},children:[g.jsxs("div",{children:[g.jsx("h2",{style:{fontSize:"1.5rem",marginBottom:"0.25rem"},children:"Firebase Book Repository"}),g.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.88rem"},children:"Files securely stored in Firebase Storage with clean links and metadata in Cloud Firestore"})]}),g.jsxs("button",{onClick:n,disabled:e,className:"btn-secondary",style:{fontSize:"0.85rem"},children:[g.jsx(pv,{size:15,className:e?"animate-spin":"",style:{animation:e?"spin 1s linear infinite":"none"}}),"Refresh"]})]}),g.jsxs("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fit, minmax(220px, 1fr))",gap:"1rem"},children:[g.jsxs("div",{style:{position:"relative"},children:[g.jsx(sA,{size:16,color:"#94a3b8",style:{position:"absolute",left:14,top:"50%",transform:"translateY(-50%)"}}),g.jsx("input",{type:"text",className:"input-field",placeholder:"Search by title, author, translator...",value:i,onChange:h=>s(h.target.value),style:{paddingLeft:"2.5rem"}})]}),g.jsx("select",{className:"input-field",value:o,onChange:h=>a(h.target.value),children:c.map(h=>g.jsxs("option",{value:h,children:[h," (",h==="All"?t.length:t.filter(f=>f.category===h).length,")"]},h))})]})]}),e?g.jsxs("div",{className:"glass-panel",style:{padding:"3rem",textAlign:"center",color:"var(--text-muted)"},children:[g.jsx(pv,{size:32,className:"animate-spin",style:{animation:"spin 1s linear infinite",margin:"0 auto 1rem",color:"var(--accent-primary)"}}),g.jsx("div",{children:"Retrieving book catalog from Firebase..."})]}):u.length===0?g.jsxs("div",{className:"glass-panel",style:{padding:"3.5rem 2rem",textAlign:"center"},children:[g.jsx(to,{size:48,color:"#6366f1",style:{opacity:.5,margin:"0 auto 1rem"}}),g.jsx("h3",{style:{fontSize:"1.25rem",marginBottom:"0.5rem"},children:"No Books Found"}),g.jsx("p",{style:{color:"var(--text-muted)",fontSize:"0.9rem",maxWidth:460,margin:"0 auto 1.5rem"},children:i||o!=="All"?"No books matched your search query. Try clearing filters.":"Your Firebase collection is empty. Upload your first Summary .md, Full .md, or PDF file!"})]}):g.jsx("div",{style:{display:"grid",gridTemplateColumns:"repeat(auto-fill, minmax(330px, 1fr))",gap:"1.25rem"},children:u.map(h=>g.jsxs("div",{className:"glass-panel glass-panel-hover",style:{padding:"1.5rem",display:"flex",flexDirection:"column",justifyContent:"space-between",gap:"1rem",position:"relative"},children:[g.jsxs("div",{children:[g.jsxs("div",{style:{display:"flex",gap:"1rem",alignItems:"flex-start",marginBottom:"0.85rem"},children:[h.coverUrl&&g.jsx("img",{src:h.coverUrl,alt:"Cover",style:{width:50,height:70,objectFit:"cover",borderRadius:6,border:"1px solid var(--border-subtle)",flexShrink:0}}),g.jsxs("div",{style:{flex:1},children:[g.jsxs("div",{style:{display:"flex",gap:"0.4rem",flexWrap:"wrap",marginBottom:"0.4rem"},children:[g.jsx("span",{className:"badge badge-indigo",children:h.category||"General"}),h.language&&g.jsx("span",{className:"badge badge-emerald",children:h.language})]}),g.jsx("h3",{style:{fontSize:"1.2rem",color:"#f8fafc",lineHeight:1.3},children:h.title})]})]}),h.subtitle&&g.jsx("p",{style:{fontSize:"0.83rem",color:"#a5b4fc",marginBottom:"0.5rem",fontStyle:"italic"},children:h.subtitle}),g.jsxs("div",{style:{fontSize:"0.82rem",color:"var(--text-muted)",marginBottom:"0.75rem"},children:[h.author&&g.jsxs("div",{children:[g.jsx("strong",{children:"Author:"})," ",h.author]}),h.translator&&g.jsxs("div",{children:[g.jsx("strong",{children:"Translator:"})," ",h.translator]})]}),h.summarySnippet&&g.jsxs("div",{style:{fontSize:"0.8rem",color:"#94a3b8",lineHeight:1.5,marginBottom:"0.85rem",background:"rgba(255,255,255,0.02)",padding:"0.6rem 0.75rem",borderRadius:8,border:"1px solid var(--border-subtle)"},children:[h.summarySnippet,"..."]}),g.jsxs("div",{style:{display:"flex",gap:"1rem",padding:"0.65rem 0",borderTop:"1px solid var(--border-subtle)",borderBottom:"1px solid var(--border-subtle)",fontSize:"0.78rem",color:"var(--text-muted)"},children:[h.totalWords>0&&g.jsxs("span",{children:[h.totalWords.toLocaleString()," words"]}),g.jsxs("span",{children:["~",h.estimatedMinutes||1," min read"]})]})]}),g.jsxs("div",{style:{display:"flex",flexDirection:"column",gap:"0.65rem",marginTop:"0.5rem"},children:[g.jsxs("div",{style:{display:"flex",gap:"0.5rem",flexWrap:"wrap"},children:[h.summaryMdUrl&&g.jsxs("a",{href:h.summaryMdUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Download Summary Markdown from Firebase Storage",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#a5b4fc"},children:[g.jsx(Ec,{size:13})," Summary .md"]}),h.fullBookMdUrl&&g.jsxs("a",{href:h.fullBookMdUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Download Full Book Markdown from Firebase Storage",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#c084fc"},children:[g.jsx(to,{size:13})," Full .md"]}),(h.pdfUrl||h.pdfDriveUrl)&&g.jsxs("a",{href:h.pdfUrl||h.pdfDriveUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:h.pdfDriveUrl?"Open PDF via Google Drive / Web link":"Open or Download PDF",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#f87171"},children:[g.jsx(bm,{size:13})," PDF"]}),h.audioUrl&&g.jsxs("a",{href:h.audioUrl,target:"_blank",rel:"noopener noreferrer",className:"btn-secondary",title:"Open Audio Stream",style:{padding:"0.4rem 0.65rem",fontSize:"0.78rem",color:"#6ee7b7"},children:[g.jsx(eA,{size:13})," Audio"]})]}),g.jsx("div",{style:{display:"flex",justifyContent:"flex-end",paddingTop:"0.25rem"},children:g.jsxs("button",{onClick:()=>r(h),className:"btn-secondary",title:"Delete Book from Firebase",style:{padding:"0.35rem 0.65rem",color:"#ef4444",fontSize:"0.78rem",borderColor:"rgba(239, 68, 68, 0.2)"},children:[g.jsx(ca,{size:13})," Delete"]})})]})]},h.id))})]})}function q4({isOpen:t,onClose:e}){const[n,r]=ie.useState(!1),[i,s]=ie.useState(!1);if(!t)return null;const o=`rules_version = '2';
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
}`,u=(f,m)=>{navigator.clipboard.writeText(f),m==="storage"?(r(!0),setTimeout(()=>r(!1),2e3)):(s(!0),setTimeout(()=>s(!1),2e3))},c=`https://console.firebase.google.com/project/${Da.projectId}/firestore/rules`,h=`https://console.firebase.google.com/project/${Da.projectId}/storage/rules`;return g.jsx("div",{style:{position:"fixed",top:0,left:0,right:0,bottom:0,background:"rgba(0, 0, 0, 0.75)",backdropFilter:"blur(8px)",display:"flex",alignItems:"center",justifyContent:"center",zIndex:9999,padding:"1.5rem"},children:g.jsxs("div",{className:"glass-panel",style:{maxWidth:720,width:"100%",maxHeight:"90vh",overflowY:"auto",padding:"2rem",border:"1px solid rgba(239, 68, 68, 0.4)",boxShadow:"0 20px 50px rgba(0, 0, 0, 0.8)"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",justifyContent:"space-between",marginBottom:"1.25rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.75rem"},children:[g.jsx("div",{style:{width:42,height:42,borderRadius:10,background:"rgba(239, 68, 68, 0.2)",display:"flex",alignItems:"center",justifyContent:"center"},children:g.jsx(oA,{size:24,color:"#ef4444"})}),g.jsxs("div",{children:[g.jsx("h3",{style:{fontSize:"1.3rem",color:"#f8fafc"},children:"Fix Firebase Permissions"}),g.jsxs("p",{style:{fontSize:"0.82rem",color:"var(--text-muted)"},children:["Resolve ",g.jsx("strong",{children:'"Missing or insufficient permissions"'})," in project ",g.jsx("strong",{children:Da.projectId})]})]})]}),g.jsx("button",{onClick:e,style:{background:"transparent",border:"none",color:"#94a3b8",cursor:"pointer",padding:4},children:g.jsx(UT,{size:20})})]}),g.jsxs("div",{style:{background:"rgba(239, 68, 68, 0.12)",border:"1px solid rgba(239, 68, 68, 0.3)",borderRadius:10,padding:"0.85rem 1rem",fontSize:"0.85rem",color:"#fca5a5",marginBottom:"1.25rem",display:"flex",gap:"0.6rem"},children:[g.jsx(aA,{size:18,style:{flexShrink:0,marginTop:2}}),g.jsxs("div",{children:[g.jsx("strong",{children:"Why this happens:"}),' Newly initialized Cloud Firestore and Storage buckets start in "Production/Locked mode" (',g.jsx("code",{children:"allow read, write: if false;"}),"). You need to publish the rules below to allow uploads."]})]}),g.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(16, 185, 129, 0.3)",marginBottom:"1.25rem"},children:[g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#6ee7b7"},children:[g.jsx(Jx,{size:17}),' 1. Cloud Firestore Rules (Fixes "Missing or insufficient permissions")']}),g.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[g.jsxs("button",{onClick:()=>u(o,"firestore"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[i?g.jsx(Ns,{size:14,color:"#10b981"}):g.jsx(dv,{size:14}),i?"Copied":"Copy Firestore Rule"]}),g.jsxs("a",{href:c,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Firestore Rules ",g.jsx(fv,{size:13})]})]})]}),g.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:g.jsx("code",{children:o})}),g.jsxs("div",{style:{fontSize:"0.78rem",color:"#94a3b8",marginTop:"0.5rem"},children:["Click ",g.jsx("strong",{children:"Open Firestore Rules"})," > Paste above > Click ",g.jsx("strong",{children:"Publish"}),"."]})]}),g.jsxs("div",{style:{background:"rgba(15, 23, 42, 0.8)",padding:"1.25rem",borderRadius:12,border:"1px solid rgba(99, 102, 241, 0.3)",marginBottom:"1.5rem"},children:[g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",marginBottom:"0.75rem",flexWrap:"wrap",gap:"0.5rem"},children:[g.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"0.5rem",fontWeight:700,color:"#a5b4fc"},children:[g.jsx(Zx,{size:17})," 2. Firebase Storage Rules (Fixes storage/unauthorized)"]}),g.jsxs("div",{style:{display:"flex",gap:"0.5rem"},children:[g.jsxs("button",{onClick:()=>u(a,"storage"),className:"btn-secondary",style:{padding:"0.35rem 0.65rem",fontSize:"0.78rem"},children:[n?g.jsx(Ns,{size:14,color:"#10b981"}):g.jsx(dv,{size:14}),n?"Copied":"Copy Storage Rule"]}),g.jsxs("a",{href:h,target:"_blank",rel:"noopener noreferrer",className:"btn-primary",style:{padding:"0.35rem 0.75rem",fontSize:"0.78rem",textDecoration:"none"},children:["Open Storage Rules ",g.jsx(fv,{size:13})]})]})]}),g.jsx("pre",{style:{background:"rgba(9, 13, 22, 0.95)",padding:"0.75rem 1rem",borderRadius:8,fontSize:"0.82rem",color:"#cbd5e1",overflowX:"auto",fontFamily:"Consolas, monospace",border:"1px solid rgba(255,255,255,0.06)"},children:g.jsx("code",{children:a})})]}),g.jsxs("div",{style:{display:"flex",justifyContent:"space-between",alignItems:"center",flexWrap:"wrap",gap:"1rem"},children:[g.jsx("div",{style:{fontSize:"0.8rem",color:"#94a3b8"},children:"Once published in Firebase Console, uploads will succeed immediately."}),g.jsx("button",{onClick:e,className:"btn-primary",style:{padding:"0.65rem 1.25rem"},children:"I've Published Rules / Done"})]})]})})}function H4({toasts:t,onDismiss:e}){return!t||t.length===0?null:g.jsx("div",{className:"toast-container",children:t.map(n=>{let r=Xx,i="rgba(16, 185, 129, 0.4)",s="#10b981";return n.type==="error"?(r=Yx,i="rgba(239, 68, 68, 0.4)",s="#ef4444"):n.type==="info"&&(r=VT,i="rgba(99, 102, 241, 0.4)",s="#6366f1"),g.jsxs("div",{className:"toast",style:{borderColor:i},children:[g.jsx(r,{size:20,color:s,style:{flexShrink:0}}),g.jsxs("div",{style:{flex:1,fontSize:"0.9rem"},children:[n.title&&g.jsx("div",{style:{fontWeight:600,marginBottom:2},children:n.title}),g.jsx("div",{style:{color:"#cbd5e1"},children:n.message})]}),g.jsx("button",{onClick:()=>e(n.id),style:{background:"transparent",border:"none",color:"#64748b",cursor:"pointer",display:"flex",alignItems:"center",padding:4},children:g.jsx(UT,{size:16})})]},n.id)})})}var c_={};(function t(e,n,r,i){var s=!!(e.Worker&&e.Blob&&e.Promise&&e.OffscreenCanvas&&e.OffscreenCanvasRenderingContext2D&&e.HTMLCanvasElement&&e.HTMLCanvasElement.prototype.transferControlToOffscreen&&e.URL&&e.URL.createObjectURL),o=typeof Path2D=="function"&&typeof DOMMatrix=="function",a=function(){if(!e.OffscreenCanvas)return!1;try{var N=new OffscreenCanvas(1,1),x=N.getContext("2d");x.fillRect(0,0,1,1);var $=N.transferToImageBitmap();x.createPattern($,"no-repeat")}catch{return!1}return!0}();function u(){}function c(N){var x=n.exports.Promise,$=x!==void 0?x:e.Promise;return typeof $=="function"?new $(N):(N(u,u),null)}var h=function(N,x){return{transform:function($){if(N)return $;if(x.has($))return x.get($);var F=new OffscreenCanvas($.width,$.height),W=F.getContext("2d");return W.drawImage($,0,0),x.set($,F),F},clear:function(){x.clear()}}}(a,new Map),f=function(){var N=Math.floor(16.666666666666668),x,$,F={},W=0;return typeof requestAnimationFrame=="function"&&typeof cancelAnimationFrame=="function"?(x=function(K){var Z=Math.random();return F[Z]=requestAnimationFrame(function Y(re){W===re||W+N-1<re?(W=re,delete F[Z],K()):F[Z]=requestAnimationFrame(Y)}),Z},$=function(K){F[K]&&cancelAnimationFrame(F[K])}):(x=function(K){return setTimeout(K,N)},$=function(K){return clearTimeout(K)}),{frame:x,cancel:$}}(),m=function(){var N,x,$={};function F(W){function K(Z,Y){W.postMessage({options:Z||{},callback:Y})}W.init=function(Y){var re=Y.transferControlToOffscreen();W.postMessage({canvas:re},[re])},W.fire=function(Y,re,ne){if(x)return K(Y,null),x;var Ee=Math.random().toString(36).slice(2);return x=c(function(he){function Ce(Be){Be.data.callback===Ee&&(delete $[Ee],W.removeEventListener("message",Ce),x=null,h.clear(),ne(),he())}W.addEventListener("message",Ce),K(Y,Ee),$[Ee]=Ce.bind(null,{data:{callback:Ee}})}),x},W.reset=function(){W.postMessage({reset:!0});for(var Y in $)$[Y](),delete $[Y]}}return function(){if(N)return N;if(!r&&s){var W=["var CONFETTI, SIZE = {}, module = {};","("+t.toString()+")(this, module, true, SIZE);","onmessage = function(msg) {","  if (msg.data.options) {","    CONFETTI(msg.data.options).then(function () {","      if (msg.data.callback) {","        postMessage({ callback: msg.data.callback });","      }","    });","  } else if (msg.data.reset) {","    CONFETTI && CONFETTI.reset();","  } else if (msg.data.resize) {","    SIZE.width = msg.data.resize.width;","    SIZE.height = msg.data.resize.height;","  } else if (msg.data.canvas) {","    SIZE.width = msg.data.canvas.width;","    SIZE.height = msg.data.canvas.height;","    CONFETTI = module.exports.create(msg.data.canvas);","  }","}"].join(`
`);try{N=new Worker(URL.createObjectURL(new Blob([W])))}catch(K){return typeof console<"u"&&typeof console.warn=="function"&&console.warn("🎊 Could not load worker",K),null}F(N)}return N}}(),w={particleCount:50,angle:90,spread:45,startVelocity:45,decay:.9,gravity:1,drift:0,ticks:200,x:.5,y:.5,shapes:["square","circle"],zIndex:100,colors:["#26ccff","#a25afd","#ff5e7e","#88ff5a","#fcff42","#ffa62d","#ff36ff"],disableForReducedMotion:!1,scalar:1};function S(N,x){return x?x(N):N}function P(N){return N!=null}function D(N,x,$){return S(N&&P(N[x])?N[x]:w[x],$)}function k(N){return N<0?0:Math.floor(N)}function T(N,x){return Math.floor(Math.random()*(x-N))+N}function R(N){return parseInt(N,16)}function M(N){return N.map(z)}function z(N){var x=String(N).replace(/[^0-9a-f]/gi,"");return x.length<6&&(x=x[0]+x[0]+x[1]+x[1]+x[2]+x[2]),{r:R(x.substring(0,2)),g:R(x.substring(2,4)),b:R(x.substring(4,6))}}function U(N){var x=D(N,"origin",Object);return x.x=D(x,"x",Number),x.y=D(x,"y",Number),x}function v(N){N.width=document.documentElement.clientWidth,N.height=document.documentElement.clientHeight}function _(N){var x=N.getBoundingClientRect();N.width=x.width,N.height=x.height}function E(N){var x=document.createElement("canvas");return x.style.position="fixed",x.style.top="0px",x.style.left="0px",x.style.pointerEvents="none",x.style.zIndex=N,x}function I(N,x,$,F,W,K,Z,Y,re){N.save(),N.translate(x,$),N.rotate(K),N.scale(F,W),N.arc(0,0,1,Z,Y,re),N.restore()}function A(N){var x=N.angle*(Math.PI/180),$=N.spread*(Math.PI/180);return{x:N.x,y:N.y,wobble:Math.random()*10,wobbleSpeed:Math.min(.11,Math.random()*.1+.05),velocity:N.startVelocity*.5+Math.random()*N.startVelocity,angle2D:-x+(.5*$-Math.random()*$),tiltAngle:(Math.random()*(.75-.25)+.25)*Math.PI,color:N.color,shape:N.shape,tick:0,totalTicks:N.ticks,decay:N.decay,drift:N.drift,random:Math.random()+2,tiltSin:0,tiltCos:0,wobbleX:0,wobbleY:0,gravity:N.gravity*3,ovalScalar:.6,scalar:N.scalar,flat:N.flat}}function b(N,x){x.x+=Math.cos(x.angle2D)*x.velocity+x.drift,x.y+=Math.sin(x.angle2D)*x.velocity+x.gravity,x.velocity*=x.decay,x.flat?(x.wobble=0,x.wobbleX=x.x+10*x.scalar,x.wobbleY=x.y+10*x.scalar,x.tiltSin=0,x.tiltCos=0,x.random=1):(x.wobble+=x.wobbleSpeed,x.wobbleX=x.x+10*x.scalar*Math.cos(x.wobble),x.wobbleY=x.y+10*x.scalar*Math.sin(x.wobble),x.tiltAngle+=.1,x.tiltSin=Math.sin(x.tiltAngle),x.tiltCos=Math.cos(x.tiltAngle),x.random=Math.random()+2);var $=x.tick++/x.totalTicks,F=x.x+x.random*x.tiltCos,W=x.y+x.random*x.tiltSin,K=x.wobbleX+x.random*x.tiltCos,Z=x.wobbleY+x.random*x.tiltSin;if(N.fillStyle="rgba("+x.color.r+", "+x.color.g+", "+x.color.b+", "+(1-$)+")",N.beginPath(),o&&x.shape.type==="path"&&typeof x.shape.path=="string"&&Array.isArray(x.shape.matrix))N.fill(gt(x.shape.path,x.shape.matrix,x.x,x.y,Math.abs(K-F)*.1,Math.abs(Z-W)*.1,Math.PI/10*x.wobble));else if(x.shape.type==="bitmap"){var Y=Math.PI/10*x.wobble,re=Math.abs(K-F)*.1,ne=Math.abs(Z-W)*.1,Ee=x.shape.bitmap.width*x.scalar,he=x.shape.bitmap.height*x.scalar,Ce=new DOMMatrix([Math.cos(Y)*re,Math.sin(Y)*re,-Math.sin(Y)*ne,Math.cos(Y)*ne,x.x,x.y]);Ce.multiplySelf(new DOMMatrix(x.shape.matrix));var Be=N.createPattern(h.transform(x.shape.bitmap),"no-repeat");Be.setTransform(Ce),N.globalAlpha=1-$,N.fillStyle=Be,N.fillRect(x.x-Ee/2,x.y-he/2,Ee,he),N.globalAlpha=1}else if(x.shape==="circle")N.ellipse?N.ellipse(x.x,x.y,Math.abs(K-F)*x.ovalScalar,Math.abs(Z-W)*x.ovalScalar,Math.PI/10*x.wobble,0,2*Math.PI):I(N,x.x,x.y,Math.abs(K-F)*x.ovalScalar,Math.abs(Z-W)*x.ovalScalar,Math.PI/10*x.wobble,0,2*Math.PI);else if(x.shape==="star")for(var ue=Math.PI/2*3,et=4*x.scalar,ct=8*x.scalar,tn=x.x,kn=x.y,Un=5,Ht=Math.PI/Un;Un--;)tn=x.x+Math.cos(ue)*ct,kn=x.y+Math.sin(ue)*ct,N.lineTo(tn,kn),ue+=Ht,tn=x.x+Math.cos(ue)*et,kn=x.y+Math.sin(ue)*et,N.lineTo(tn,kn),ue+=Ht;else N.moveTo(Math.floor(x.x),Math.floor(x.y)),N.lineTo(Math.floor(x.wobbleX),Math.floor(W)),N.lineTo(Math.floor(K),Math.floor(Z)),N.lineTo(Math.floor(F),Math.floor(x.wobbleY));return N.closePath(),N.fill(),x.tick<x.totalTicks}function C(N,x,$,F,W){var K=x.slice(),Z=N.getContext("2d"),Y,re,ne=c(function(Ee){function he(){Y=re=null,Z.clearRect(0,0,F.width,F.height),h.clear(),W(),Ee()}function Ce(){r&&!(F.width===i.width&&F.height===i.height)&&(F.width=N.width=i.width,F.height=N.height=i.height),!F.width&&!F.height&&($(N),F.width=N.width,F.height=N.height),Z.clearRect(0,0,F.width,F.height),K=K.filter(function(Be){return b(Z,Be)}),K.length?Y=f.frame(Ce):he()}Y=f.frame(Ce),re=he});return{addFettis:function(Ee){return K=K.concat(Ee),ne},canvas:N,promise:ne,reset:function(){Y&&f.cancel(Y),re&&re()}}}function Xe(N,x){var $=!N,F=!!D(x||{},"resize"),W=!1,K=D(x,"disableForReducedMotion",Boolean),Z=s&&!!D(x||{},"useWorker"),Y=Z?m():null,re=$?v:_,ne=N&&Y?!!N.__confetti_initialized:!1,Ee=typeof matchMedia=="function"&&matchMedia("(prefers-reduced-motion)").matches,he;function Ce(ue,et,ct){for(var tn=D(ue,"particleCount",k),kn=D(ue,"angle",Number),Un=D(ue,"spread",Number),Ht=D(ue,"startVelocity",Number),Ll=D(ue,"decay",Number),$h=D(ue,"gravity",Number),xo=D(ue,"drift",Number),ls=D(ue,"colors",M),Fl=D(ue,"ticks",Number),st=D(ue,"shapes"),_t=D(ue,"scalar"),us=!!D(ue,"flat"),Ao=U(ue),Po=tn,bo=[],vi=N.width*Ao.x,Vl=N.height*Ao.y;Po--;)bo.push(A({x:vi,y:Vl,angle:kn,spread:Un,startVelocity:Ht,color:ls[Po%ls.length],shape:st[T(0,st.length)],ticks:Fl,decay:Ll,gravity:$h,drift:xo,scalar:_t,flat:us}));return he?he.addFettis(bo):(he=C(N,bo,re,et,ct),he.promise)}function Be(ue){var et=K||D(ue,"disableForReducedMotion",Boolean),ct=D(ue,"zIndex",Number);if(et&&Ee)return c(function(Ht){Ht()});$&&he?N=he.canvas:$&&!N&&(N=E(ct),document.body.appendChild(N)),F&&!ne&&re(N);var tn={width:N.width,height:N.height};Y&&!ne&&Y.init(N),ne=!0,Y&&(N.__confetti_initialized=!0);function kn(){if(Y){var Ht={getBoundingClientRect:function(){if(!$)return N.getBoundingClientRect()}};re(Ht),Y.postMessage({resize:{width:Ht.width,height:Ht.height}});return}tn.width=tn.height=null}function Un(){he=null,F&&(W=!1,e.removeEventListener("resize",kn)),$&&N&&(document.body.contains(N)&&document.body.removeChild(N),N=null,ne=!1)}return F&&!W&&(W=!0,e.addEventListener("resize",kn,!1)),Y?Y.fire(ue,tn,Un):Ce(ue,tn,Un)}return Be.reset=function(){Y&&Y.reset(),he&&he.reset()},Be}var Ne;function Ut(){return Ne||(Ne=Xe(null,{useWorker:!0,resize:!0})),Ne}function gt(N,x,$,F,W,K,Z){var Y=new Path2D(N),re=new Path2D;re.addPath(Y,new DOMMatrix(x));var ne=new Path2D;return ne.addPath(re,new DOMMatrix([Math.cos(Z)*W,Math.sin(Z)*W,-Math.sin(Z)*K,Math.cos(Z)*K,$,F])),ne}function H(N){if(!o)throw new Error("path confetti are not supported in this browser");var x,$;typeof N=="string"?x=N:(x=N.path,$=N.matrix);var F=new Path2D(x),W=document.createElement("canvas"),K=W.getContext("2d");if(!$){for(var Z=1e3,Y=Z,re=Z,ne=0,Ee=0,he,Ce,Be=0;Be<Z;Be+=2)for(var ue=0;ue<Z;ue+=2)K.isPointInPath(F,Be,ue,"nonzero")&&(Y=Math.min(Y,Be),re=Math.min(re,ue),ne=Math.max(ne,Be),Ee=Math.max(Ee,ue));he=ne-Y,Ce=Ee-re;var et=10,ct=Math.min(et/he,et/Ce);$=[ct,0,0,ct,-Math.round(he/2+Y)*ct,-Math.round(Ce/2+re)*ct]}return{type:"path",path:x,matrix:$}}function te(N){var x,$=1,F="#000000",W='"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji", "EmojiOne Color", "Android Emoji", "Twemoji Mozilla", "system emoji", sans-serif';typeof N=="string"?x=N:(x=N.text,$="scalar"in N?N.scalar:$,W="fontFamily"in N?N.fontFamily:W,F="color"in N?N.color:F);var K=10*$,Z=""+K+"px "+W,Y=new OffscreenCanvas(K,K),re=Y.getContext("2d");re.font=Z;var ne=re.measureText(x),Ee=Math.ceil(ne.actualBoundingBoxRight+ne.actualBoundingBoxLeft),he=Math.ceil(ne.actualBoundingBoxAscent+ne.actualBoundingBoxDescent),Ce=2,Be=ne.actualBoundingBoxLeft+Ce,ue=ne.actualBoundingBoxAscent+Ce;Ee+=Ce+Ce,he+=Ce+Ce,Y=new OffscreenCanvas(Ee,he),re=Y.getContext("2d"),re.font=Z,re.fillStyle=F,re.fillText(x,Be,ue);var et=1/$;return{type:"bitmap",bitmap:Y.transferToImageBitmap(),matrix:[et,0,0,et,-Ee*et/2,-he*et/2]}}n.exports=function(){return Ut().apply(this,arguments)},n.exports.reset=function(){Ut().reset()},n.exports.create=Xe,n.exports.shapeFromPath=H,n.exports.shapeFromText=te})(function(){return typeof window<"u"?window:typeof self<"u"?self:this||{}}(),c_,!1);const G4=c_.exports;c_.exports.create;function K4(){const[t,e]=ie.useState("upload"),[n,r]=ie.useState(null),[i,s]=ie.useState([]),[o,a]=ie.useState(!1),[u,c]=ie.useState(!1),[h,f]=ie.useState(!1),[m,w]=ie.useState(0),[S,P]=ie.useState(""),[D,k]=ie.useState([]),T=({type:v="info",title:_="",message:E=""})=>{const I=Date.now().toString();k(A=>[...A,{id:I,type:v,title:_,message:E}]),setTimeout(()=>{R(I)},5e3)},R=v=>{k(_=>_.filter(E=>E.id!==v))},M=async()=>{a(!0);let v=[];try{const _=W2(u0(ef,"books"),q2("createdAt","desc"));(await J2(_)).forEach(I=>{v.push({id:I.id,...I.data()})})}catch(_){console.warn("Firestore fetch error or restricted rules:",_)}try{const _=JSON.parse(localStorage.getItem("audio_books_cache")||"[]"),E=new Set(v.map(A=>A.id)),I=_.filter(A=>!E.has(A.id));v=[...v,...I]}catch{}s(v),a(!1)};ie.useEffect(()=>{jF(i4).catch(v=>{console.log("Anonymous sign-in note:",v.message)}),M()},[]);const z=async v=>{var _,E,I,A,b,C,Xe;f(!0),w(5),P("Preparing files for Firebase Storage...");try{const Ne=l4(v.title),Ut=new Date().toISOString();let gt="",H="",te="",N="",x="",$="",F="",W="";const K=async(ne,Ee,he)=>{const Ce=v0(yw,Ee),Be=dO(Ce,ne,he?{contentType:he}:void 0);return new Promise((ue,et)=>{Be.on("state_changed",null,ct=>et(ct),async()=>{const ct=await fO(Be.snapshot.ref);ue(ct)})})};if(v.summaryFile){P("Uploading Summary Markdown to Firebase Storage..."),w(20),H=`books/${Ne}/${v.summaryFile.name}`;try{gt=await K(v.summaryFile,H,"text/markdown")}catch(ne){throw console.warn("Summary storage upload error:",ne),(ne.code==="storage/unauthorized"||(_=ne.message)!=null&&_.toLowerCase().includes("unauthorized"))&&c(!0),ne}}if(v.fullBookFile){P("Uploading Full Book Markdown to Firebase Storage..."),w(45),N=`books/${Ne}/${v.fullBookFile.name}`;try{te=await K(v.fullBookFile,N,"text/markdown")}catch(ne){throw console.warn("Full book storage upload error:",ne),ne}}if(v.pdfFile){P("Uploading PDF Document to Firebase Storage..."),w(70),$=`books/${Ne}/${v.pdfFile.name}`;try{x=await K(v.pdfFile,$,"application/pdf")}catch(ne){throw console.warn("PDF storage upload error:",ne),ne}}else v.pdfDriveUrl&&(x=vw(v.pdfDriveUrl));if(v.coverFile){P("Uploading Cover Image..."),W=`covers/${Ne}/${v.coverFile.name}`;try{F=await K(v.coverFile,W)}catch(ne){console.warn("Cover upload skipped:",ne)}}w(85),P("Saving book metadata & storage links in Firestore...");const Z={title:v.title||"Untitled Book",subtitle:v.subtitle||"",author:v.author||"Unknown",translator:v.translator||"",tagline:v.tagline||"",category:v.category||"General",language:v.language||"Bangla",audioUrl:v.audioUrl||"",summaryMdUrl:gt||"",summaryMdPath:H||"",summaryFilename:((E=v.summaryFile)==null?void 0:E.name)||"",fullBookMdUrl:te||"",fullBookMdPath:N||"",fullBookFilename:((I=v.fullBookFile)==null?void 0:I.name)||"",pdfUrl:x||(v.pdfDriveUrl?vw(v.pdfDriveUrl):""),pdfPath:$||"",pdfFilename:((A=v.pdfFile)==null?void 0:A.name)||(v.pdfDriveUrl?"Google Drive PDF":""),pdfDriveUrl:v.pdfDriveUrl||"",coverUrl:F||"",coverPath:W||"",summarySnippet:(v.summaryText||"").slice(0,280),totalWords:v.totalWords||0,estimatedMinutes:v.estimatedMinutes||1,hasSummary:!!gt,hasFullBook:!!te,hasPdf:!!x||!!v.pdfDriveUrl,slug:Ne,createdAt:tD(),publishedAtIso:Ut};let Y="Firestore",re=`book_${Date.now()}`;try{re=(await eD(u0(ef,"books"),Z)).id}catch(ne){if(console.warn("Firestore write error:",ne),ne.code==="permission-denied"||(b=ne.message)!=null&&b.toLowerCase().includes("permissions")){c(!0);try{await Pp(Xd(tf,`books/${re}`),{...Z,id:re,createdAt:Ut}),Y="Realtime Database"}catch{const he=JSON.parse(localStorage.getItem("audio_books_cache")||"[]");he.unshift({...Z,id:re,createdAt:Ut,isOfflineSaved:!0}),localStorage.setItem("audio_books_cache",JSON.stringify(he)),Y="Local Storage (Pending Rules)"}}else throw ne}if(Y==="Firestore")try{await Pp(Xd(tf,`books/${re}`),{...Z,id:re,createdAt:Ut})}catch{}w(100),P("Upload Complete!"),G4({particleCount:80,spread:70,origin:{y:.6}}),T({type:"info",title:"Book Published to Firebase!",message:`"${v.title}" files uploaded to Storage and linked in Firestore.`}),r(null),await M(),e("library")}catch(Ne){console.error("Failed to upload book:",Ne),(Ne.code==="storage/unauthorized"||Ne.code==="permission-denied"||(C=Ne.message)!=null&&C.toLowerCase().includes("permissions")||(Xe=Ne.message)!=null&&Xe.toLowerCase().includes("unauthorized"))&&c(!0),T({type:"error",title:"Upload Failed",message:Ne.message||"Firebase error. Please ensure rules allow access."})}finally{f(!1)}},U=async v=>{if(window.confirm(`Are you sure you want to delete "${v.title}" from Firebase?`))try{await Z2(lS(ef,"books",v.id));try{await QL(Xd(tf,`books/${v.id}`))}catch{}const _=[v.summaryMdPath,v.fullBookMdPath,v.pdfPath,v.coverPath].filter(Boolean);for(const E of _)try{await pO(v0(yw,E))}catch(I){console.warn("Could not delete storage file:",E,I)}try{const I=JSON.parse(localStorage.getItem("audio_books_cache")||"[]").filter(A=>A.id!==v.id);localStorage.setItem("audio_books_cache",JSON.stringify(I))}catch{}s(E=>E.filter(I=>I.id!==v.id)),T({type:"info",title:"Book Deleted",message:"The book record and associated files were removed from Firebase."})}catch(_){console.error("Delete error:",_),T({type:"error",title:"Delete Failed",message:_.message})}};return g.jsxs("div",{style:{minHeight:"100vh",display:"flex",flexDirection:"column"},children:[g.jsx(H4,{toasts:D,onDismiss:R}),g.jsx(q4,{isOpen:u,onClose:()=>c(!1)}),g.jsx(s4,{activeTab:t,setActiveTab:e,bookCount:i.length,onOpenRules:()=>c(!0)}),g.jsx("main",{style:{flex:1,padding:"2rem 1.5rem"},children:t==="upload"?n?g.jsx($4,{bookData:n,onCancel:()=>r(null),onUpload:z,isUploading:h,uploadProgress:m,uploadStage:S}):g.jsx(u4,{onParsedBook:r,onShowToast:T}):g.jsx(W4,{books:i,loading:o,onRefresh:M,onDeleteBook:U})}),g.jsx("footer",{style:{padding:"1.5rem",textAlign:"center",borderTop:"1px solid rgba(255, 255, 255, 0.06)",color:"#64748b",fontSize:"0.82rem"},children:g.jsxs("div",{children:["AudioBook Studio • Firebase Markdown Uploader • Connected to project ",g.jsx("strong",{children:"book-store-bec15"})]})})]})}nf.createRoot(document.getElementById("root")).render(g.jsx(DC.StrictMode,{children:g.jsx(K4,{})}));
