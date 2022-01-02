# Flyweight pattern
## What's the difference: Singleton v.s. Flyweight 
### Singleton pattern
- 「1クラス1インスタンス」の生成・管理に焦点を当てたパターン
- singletonなクラス自体にsingletonなインスタンスの生成・管理ロジックを記述する

### Flyweight pattern
- 「1クラス複数インスタンス」を取る場合のインスタンス生成・管理に焦点を当てたパターン
- singletonであるべきクラス自体には、singletonなインスタンスを生成するロジックを持たない
  factory等のインスタンスの管理クラスとの協働で、singletonな状態を維持する